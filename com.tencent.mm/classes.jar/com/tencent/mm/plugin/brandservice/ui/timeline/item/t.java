package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class t
  extends x
{
  private View sEi;
  private LinearLayout sEj;
  private LinkedList<a> sEk;
  private final i<a> sEl;
  
  public t(final com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, final Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(265371);
    this.sEk = new LinkedList();
    this.sEl = new i((kotlin.g.a.a)new b(this, paramb, paramContext));
    AppMethodBeat.o(265371);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(265366);
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = paramz.hwK();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.Usy; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(265366);
      return;
    }
    paramView1 = this.sEi;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.sEk).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.sEj;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).sEm);
      }
      this.sEl.cX(localObject1);
    }
    this.sEk.clear();
    paramView1 = paramView2.RXM;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.iBO();
        }
        paramView1 = (eqc)paramView1;
        if ((paramView1 != null) && ((paramView1.RIs & 0x1) == 0))
        {
          localObject2 = (a)this.sEl.get();
          Object localObject3 = this.sEj;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).addView(((a)localObject2).sEm);
          }
          this.sEk.add(localObject2);
          p.k(paramz, "info");
          p.k(paramView2, "recCard");
          p.k(paramView1, "appMsg");
          Object localObject6 = paramView1.fwr;
          localObject3 = paramView1.RTk;
          int k = paramView1.lpx;
          Object localObject4 = paramView1.RTm;
          Object localObject5 = paramView1.RTn;
          ((a)localObject2).sGQ.aL((CharSequence)localObject6);
          localObject6 = ((a)localObject2).sEm;
          if (paramInt == 0) {}
          for (int j = d.d.spF;; j = d.d.spE)
          {
            ((View)localObject6).setBackgroundResource(j);
            ((a)localObject2).sEm.setOnClickListener((View.OnClickListener)new t.a.a((a)localObject2, paramz, paramView1, paramInt));
            if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil((String)localObject3))) {
              ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a((String)localObject3, k, 90, new Object[0]);
            }
            ((a)localObject2).sCU.type = k;
            ((a)localObject2).sCU.lpK = ((String)localObject4);
            ((a)localObject2).sCU.lqb = ((String)localObject5);
            ((a)localObject2).sCU.url = ((String)localObject3);
            ((a)localObject2).a(((a)localObject2).sDk, ((a)localObject2).sDl, paramz, ((a)localObject2).sCU);
            localObject3 = ((a)localObject2).sGV;
            p.j(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).sGT;
            p.j(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(8);
            d.apR(paramz.getId());
            if (((a)localObject2).sCU.type != 7) {
              break label968;
            }
            ((a)localObject2).sCR.setVisibility(8);
            p.k(paramz, "info");
            p.k(paramView1, "appMsg");
            localObject3 = ((a)localObject2).sGV;
            p.j(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).sGT;
            p.j(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(0);
            localObject3 = ((a)localObject2).sGU;
            p.j(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (((localObject3 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject3).isRunning())) {
              ((AnimationDrawable)localObject3).stop();
            }
            if (!p.h(String.valueOf(paramz.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.cEq())) {
              break label866;
            }
            ((a)localObject2).sGU.setImageResource(d.d.dmz);
            localObject3 = ((a)localObject2).sGU;
            p.j(localObject3, "voicePlayIcon");
            if (!(((ImageView)localObject3).getDrawable() instanceof AnimationDrawable)) {
              break label800;
            }
            localObject3 = ((a)localObject2).sGU;
            p.j(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (localObject3 != null) {
              break;
            }
            paramz = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(265366);
            throw paramz;
          }
          ((AnimationDrawable)localObject3).start();
          label800:
          localObject3 = paramView1.RXH;
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label823:
            paramView1 = (m)t.a.c.sEr;
            localObject3 = (s)t.a.d.sEs;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label866:
            ((a)localObject2).sGU.setImageResource(d.d.dmy);
            break label800;
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a((View)((a)localObject2).sGU, String.valueOf(paramz.field_msgId) + "_" + paramInt, paramView1.fwr, (String)localObject3, "", paramView1.RTm);
            ((a)localObject2).sGU.setOnClickListener((View.OnClickListener)new t.a.e((a)localObject2));
            break label823;
            label968:
            if (!Util.isNullOrNil(((a)localObject2).sCU.lpK))
            {
              ((a)localObject2).sCR.setVisibility(0);
              if (Util.isNullOrNil(((a)localObject2).sCU.lqb)) {}
              for (paramView1 = ((a)localObject2).sCU.lpK;; paramView1 = ((a)localObject2).sCU.lqb)
              {
                localObject3 = ((a)localObject2).sHf.sAc;
                long l = paramz.field_orderFlag;
                localObject4 = ((a)localObject2).sCU;
                localObject5 = ((a)localObject2).sCR;
                j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
                ((d)localObject3).a(l, paramInt, (v)localObject4, paramView1, (ImageView)localObject5, j, j, false, (m.a)new t.a.b((a)localObject2, paramz, paramInt), paramz.sHe + 1, 2.0F);
                break;
              }
            }
            if ((((a)localObject2).sCU.type == 5) || (((a)localObject2).sCU.type == 6))
            {
              ((a)localObject2).sCR.setVisibility(0);
              paramView1 = ((a)localObject2).sHf.sAc;
              localObject3 = String.valueOf(d.d.chatting_item_biz_play_icon_bg);
              localObject4 = ((a)localObject2).sCR;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
              paramView1.a((String)localObject3, (ImageView)localObject4, j, j, paramz.sHe + 1);
              break label823;
            }
            ((a)localObject2).sGS.setVisibility(8);
            break label823;
            localObject4 = ((a)localObject2).rgA;
            p.j(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw));
            localObject3 = ((a)localObject2).mrE;
            p.j(localObject3, "topLine");
            paramView1.invoke(localObject3, Integer.valueOf(com.tencent.mm.ci.a.fromDPToPix(((a)localObject2).context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = ((a)localObject2).rgA;
            p.j(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt));
            localObject2 = ((a)localObject2).mrE;
            p.j(localObject2, "topLine");
            paramView1.invoke(localObject2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx));
          }
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
    AppMethodBeat.o(265366);
  }
  
  public final void dS(View paramView)
  {
    AppMethodBeat.i(265368);
    p.k(paramView, "parent");
    if (this.sEi == null)
    {
      paramView = ((ViewStub)paramView.findViewById(d.e.sto)).inflate();
      p.j(paramView, "this");
      dT(paramView);
      this.sEj = ((LinearLayout)paramView.findViewById(d.e.spU));
      this.sEi = paramView;
    }
    AppMethodBeat.o(265368);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(265370);
    View localView = this.sEi;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(265370);
      return;
    }
    AppMethodBeat.o(265370);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends aj
  {
    final Context context;
    final v sCU;
    final View sEm;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(266096);
      this.context = localObject;
      this.sEm = View.inflate(this.context, d.f.stS, null);
      this.sCU = new v();
      this.mrE = this.sEm.findViewById(d.e.top_line);
      this.rgA = ((ViewGroup)this.sEm.findViewById(d.e.content_ll));
      this$1 = this.sEm.findViewById(d.e.stf);
      if (t.this == null)
      {
        this$1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(266096);
        throw t.this;
      }
      this.sGQ = ((MMNeat7extView)t.this);
      this.sGR = ((TextView)this.sEm.findViewById(d.e.summary));
      this.sGS = this.sEm.findViewById(d.e.cover_area);
      this.sCR = ((ImageView)this.sEm.findViewById(d.e.cover_iv));
      this.sGT = this.sEm.findViewById(d.e.dum);
      this.sGU = ((ImageView)this.sEm.findViewById(d.e.srt));
      this.sGV = ((ImageView)this.sEm.findViewById(d.e.play_icon));
      this.sDk = this.sEm.findViewById(d.e.sta);
      this$1 = this.sEm.findViewById(d.e.srT);
      if (t.this == null)
      {
        this$1 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(266096);
        throw t.this;
      }
      this.sDl = ((TextView)t.this);
      this.sGW = this.sEm.findViewById(d.e.ssl);
      this.sGX = this.sEm.findViewById(d.e.ssk);
      this.sDY = ((TextView)this.sEm.findViewById(d.e.dRg));
      AppMethodBeat.o(266096);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(t.a parama, z paramz, eqc parameqc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(260867);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.sEo.sEn.a(this.sAV, this.sEp, this.nmX);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260867);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(257528);
        this.sEo.a(this.sEo.sCU, true);
        this.sEo.sHf.sAc.p(this.sAV.field_msgId, this.sEq);
        AppMethodBeat.o(257528);
      }
      
      public final void onStart() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(t.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(266932);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).dN((View)this.sEo.sGU);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266932);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<t.a>
  {
    b(t paramt, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.t
 * JD-Core Version:    0.7.0.1
 */