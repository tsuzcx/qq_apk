package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class s
  extends w
{
  private View puO;
  private LinearLayout puP;
  private LinkedList<a> puQ;
  private final i<a> puR;
  
  public s(final com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, final Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(195350);
    this.puQ = new LinkedList();
    this.puR = new i((kotlin.g.a.a)new b(this, paramb, paramContext));
    AppMethodBeat.o(195350);
  }
  
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195347);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    super.a(paramz, paramInt, paramView1, paramView2);
    paramView2 = paramz.gAC();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.NfT; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(195347);
      return;
    }
    paramView1 = this.puO;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.puQ).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.puP;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).puS);
      }
      this.puR.da(localObject1);
    }
    this.puQ.clear();
    paramView1 = paramView2.KWy;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.hxH();
        }
        paramView1 = (ega)paramView1;
        if ((paramView1 != null) && ((paramView1.KHa & 0x1) == 0))
        {
          localObject2 = (a)this.puR.get();
          Object localObject3 = this.puP;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).addView(((a)localObject2).puS);
          }
          this.puQ.add(localObject2);
          p.h(paramz, "info");
          p.h(paramView2, "recCard");
          p.h(paramView1, "appMsg");
          Object localObject6 = paramView1.Title;
          localObject3 = paramView1.KSj;
          int k = paramView1.iAb;
          Object localObject4 = paramView1.KSl;
          Object localObject5 = paramView1.KSm;
          ((a)localObject2).pxp.aw((CharSequence)localObject6);
          localObject6 = ((a)localObject2).puS;
          if (paramInt == 0) {}
          for (int j = 2131231322;; j = 2131231316)
          {
            ((View)localObject6).setBackgroundResource(j);
            ((a)localObject2).puS.setOnClickListener((View.OnClickListener)new s.a.a((a)localObject2, paramz, paramView1, paramInt));
            if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil((String)localObject3))) {
              ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, k, 90, new Object[0]);
            }
            ((a)localObject2).ptH.type = k;
            ((a)localObject2).ptH.iAo = ((String)localObject4);
            ((a)localObject2).ptH.iAD = ((String)localObject5);
            ((a)localObject2).ptH.url = ((String)localObject3);
            ((a)localObject2).a(((a)localObject2).ptX, ((a)localObject2).ptY, paramz, ((a)localObject2).ptH);
            localObject3 = ((a)localObject2).pxu;
            p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).pxs;
            p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(8);
            if (((a)localObject2).ptH.type != 7) {
              break label960;
            }
            ((a)localObject2).ptE.setVisibility(8);
            p.h(paramz, "info");
            p.h(paramView1, "appMsg");
            localObject3 = ((a)localObject2).pxu;
            p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).pxs;
            p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(0);
            localObject3 = ((a)localObject2).pxt;
            p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (((localObject3 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject3).isRunning())) {
              ((AnimationDrawable)localObject3).stop();
            }
            if (!p.j(String.valueOf(paramz.field_msgId) + "_" + paramInt, c.crh())) {
              break label858;
            }
            ((a)localObject2).pxt.setImageResource(2131231332);
            localObject3 = ((a)localObject2).pxt;
            p.g(localObject3, "voicePlayIcon");
            if (!(((ImageView)localObject3).getDrawable() instanceof AnimationDrawable)) {
              break label792;
            }
            localObject3 = ((a)localObject2).pxt;
            p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (localObject3 != null) {
              break;
            }
            paramz = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(195347);
            throw paramz;
          }
          ((AnimationDrawable)localObject3).start();
          label792:
          localObject3 = paramView1.KWt;
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label815:
            paramView1 = (m)s.a.c.puY;
            localObject3 = (kotlin.g.a.s)s.a.d.puZ;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label858:
            ((a)localObject2).pxt.setImageResource(2131231331);
            break label792;
            ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject2).pxt, String.valueOf(paramz.field_msgId) + "_" + paramInt, paramView1.Title, (String)localObject3, "", paramView1.KSl);
            ((a)localObject2).pxt.setOnClickListener((View.OnClickListener)new s.a.e((a)localObject2));
            break label815;
            label960:
            if (!Util.isNullOrNil(((a)localObject2).ptH.iAo))
            {
              ((a)localObject2).ptE.setVisibility(0);
              if (Util.isNullOrNil(((a)localObject2).ptH.iAD)) {}
              for (paramView1 = ((a)localObject2).ptH.iAo;; paramView1 = ((a)localObject2).ptH.iAD)
              {
                localObject3 = ((a)localObject2).pxE.prc;
                long l = paramz.field_msgId;
                localObject4 = ((a)localObject2).ptH;
                localObject5 = ((a)localObject2).ptE;
                j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                ((d)localObject3).a(l, paramInt, (v)localObject4, paramView1, (ImageView)localObject5, j, j, false, (m.a)new s.a.b((a)localObject2, paramz, paramInt), paramz.pxD + 1, 2.0F);
                break;
              }
            }
            if ((((a)localObject2).ptH.type == 5) || (((a)localObject2).ptH.type == 6))
            {
              ((a)localObject2).ptE.setVisibility(0);
              paramView1 = ((a)localObject2).pxE.prc;
              localObject3 = ((a)localObject2).ptE;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
              paramView1.a("2131231740", (ImageView)localObject3, j, j, paramz.pxD + 1);
              break label815;
            }
            ((a)localObject2).pxr.setVisibility(8);
            break label815;
            localObject4 = ((a)localObject2).pxo;
            p.g(localObject4, "content");
            ((kotlin.g.a.s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
            localObject3 = ((a)localObject2).jBI;
            p.g(localObject3, "topLine");
            paramView1.invoke(localObject3, Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(((a)localObject2).context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = ((a)localObject2).pxo;
            p.g(localObject4, "content");
            ((kotlin.g.a.s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
            localObject2 = ((a)localObject2).jBI;
            p.g(localObject2, "topLine");
            paramView1.invoke(localObject2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
          }
        }
        h.CyF.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    c.x(paramz);
    AppMethodBeat.o(195347);
  }
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(195348);
    p.h(paramView, "parent");
    if (this.puO == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131309869)).inflate();
      p.g(paramView, "this");
      dv(paramView);
      this.puP = ((LinearLayout)paramView.findViewById(2131297485));
      this.puO = paramView;
    }
    AppMethodBeat.o(195348);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(195349);
    View localView = this.puO;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(195349);
      return;
    }
    AppMethodBeat.o(195349);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends ah
  {
    final Context context;
    final v ptH;
    final View puS;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(195345);
      this.context = localObject;
      this.puS = View.inflate(this.context, 2131493269, null);
      this.ptH = new v();
      this.jBI = this.puS.findViewById(2131309322);
      this.pxo = this.puS.findViewById(2131299208);
      this$1 = this.puS.findViewById(2131309237);
      if (s.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(195345);
        throw s.this;
      }
      this.pxp = ((MMNeat7extView)s.this);
      this.pxq = ((TextView)this.puS.findViewById(2131308767));
      this.pxr = this.puS.findViewById(2131299279);
      this.ptE = ((ImageView)this.puS.findViewById(2131299289));
      this.pxs = this.puS.findViewById(2131297533);
      this.pxt = ((ImageView)this.puS.findViewById(2131297588));
      this.pxu = ((ImageView)this.puS.findViewById(2131305957));
      this.ptX = this.puS.findViewById(2131308374);
      this$1 = this.puS.findViewById(2131301796);
      if (s.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195345);
        throw s.this;
      }
      this.ptY = ((TextView)s.this);
      this.pxv = this.puS.findViewById(2131305926);
      this.pxw = this.puS.findViewById(2131305925);
      this.puD = ((TextView)this.puS.findViewById(2131305934));
      AppMethodBeat.o(195345);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(s.a parama, z paramz, ega paramega, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195338);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.puU.puT.a(this.prL, this.puV, paramView, this.puW);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195338);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(z paramz, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(195339);
        this.puU.a(this.puU.ptH, true);
        this.puU.pxE.prc.m(this.prL.field_msgId, this.puX);
        AppMethodBeat.o(195339);
      }
      
      public final void onStart() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(s.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(195344);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq((View)this.puU.pxt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195344);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<s.a>
  {
    b(s params, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.s
 * JD-Core Version:    0.7.0.1
 */