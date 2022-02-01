package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class e
  extends g
{
  private View mYI;
  private LinearLayout mYJ;
  private LinkedList<a> mYK;
  private final c<a> mYL;
  
  public e(final com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, final Context paramContext)
  {
    super(paramContext, paramc);
    AppMethodBeat.i(193053);
    this.mYK = new LinkedList();
    this.mYL = new c((d.g.a.a)new b(this, paramc, paramContext));
    AppMethodBeat.o(193053);
  }
  
  public final void a(com.tencent.mm.storage.s params, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(193050);
    d.g.b.k.h(params, "info");
    d.g.b.k.h(paramView1, "convertView");
    d.g.b.k.h(paramView2, "parent");
    super.a(params, paramInt, paramView1, paramView2);
    paramView2 = params.eJR();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.Esm; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(193050);
      return;
    }
    paramView1 = this.mYI;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.mYK).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.mYJ;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).mYM);
      }
      this.mYL.mYF.add(localObject1);
    }
    this.mYK.clear();
    paramView1 = paramView2.Eso;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.fvx();
        }
        localObject2 = (daq)paramView1;
        if ((localObject2 != null) && ((((daq)localObject2).Cxm & 0x1) == 0))
        {
          paramView1 = this.mYL;
          Object localObject6;
          int k;
          Object localObject4;
          Object localObject5;
          if (paramView1.mYF.size() > 0)
          {
            paramView1 = paramView1.mYF.remove(0);
            paramView1 = (a)paramView1;
            localObject3 = this.mYJ;
            if (localObject3 != null) {
              ((LinearLayout)localObject3).addView(paramView1.mYM);
            }
            this.mYK.add(paramView1);
            d.g.b.k.h(params, "info");
            d.g.b.k.h(paramView2, "recCard");
            d.g.b.k.h(localObject2, "appMsg");
            localObject6 = ((daq)localObject2).Title;
            localObject3 = ((daq)localObject2).CHL;
            k = ((daq)localObject2).gKq;
            localObject4 = ((daq)localObject2).CHN;
            localObject5 = ((daq)localObject2).CHO;
            paramView1.mZK.aq((CharSequence)localObject6);
            localObject6 = paramView1.mYM;
            if (paramInt != 0) {
              break label796;
            }
          }
          label796:
          for (int j = 2131231262;; j = 2131231256)
          {
            ((View)localObject6).setBackgroundResource(j);
            paramView1.mYM.setOnClickListener((View.OnClickListener)new e.a.a(paramView1, params, (daq)localObject2, paramInt));
            if ((((b)com.tencent.mm.kernel.g.ab(b.class)).xA(1)) && (!bt.isNullOrNil((String)localObject3))) {
              ((b)com.tencent.mm.kernel.g.ab(b.class)).a((String)localObject3, k, 90, new Object[0]);
            }
            paramView1.mYN.type = k;
            paramView1.mYN.gKD = ((String)localObject4);
            paramView1.mYN.gKU = ((String)localObject5);
            paramView1.mYN.url = ((String)localObject3);
            paramView1.a(paramView1.mZR, paramView1.mZS, params, paramView1.mYN);
            localObject3 = paramView1.mZQ;
            d.g.b.k.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = paramView1.mZO;
            d.g.b.k.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(8);
            if (paramView1.mYN.type != 7) {
              break label982;
            }
            paramView1.mZN.setVisibility(8);
            d.g.b.k.h(params, "info");
            d.g.b.k.h(localObject2, "appMsg");
            localObject3 = paramView1.mZQ;
            d.g.b.k.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = paramView1.mZO;
            d.g.b.k.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(0);
            localObject3 = paramView1.mZP;
            d.g.b.k.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (((localObject3 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject3).isRunning())) {
              ((AnimationDrawable)localObject3).stop();
            }
            if (!d.g.b.k.g(String.valueOf(params.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
              break label882;
            }
            paramView1.mZP.setImageResource(2131231272);
            localObject3 = paramView1.mZP;
            d.g.b.k.g(localObject3, "voicePlayIcon");
            if (!(((ImageView)localObject3).getDrawable() instanceof AnimationDrawable)) {
              break label812;
            }
            localObject3 = paramView1.mZP;
            d.g.b.k.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (localObject3 != null) {
              break label804;
            }
            params = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(193050);
            throw params;
            paramView1 = paramView1.mYG.invoke();
            break;
          }
          label804:
          ((AnimationDrawable)localObject3).start();
          label812:
          Object localObject3 = ((daq)localObject2).Est;
          if (bt.isNullOrNil((String)localObject3))
          {
            ad.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label836:
            localObject2 = (d.g.a.m)e.a.c.mYU;
            localObject3 = (d.g.a.s)e.a.d.mYV;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label882:
            paramView1.mZP.setImageResource(2131231271);
            break label812;
            ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)paramView1.mZP, String.valueOf(params.field_msgId) + "_" + paramInt, ((daq)localObject2).Title, (String)localObject3, "", ((daq)localObject2).CHN);
            paramView1.mZP.setOnClickListener((View.OnClickListener)new e.a.e(paramView1));
            break label836;
            label982:
            if (!bt.isNullOrNil(paramView1.mYN.gKD))
            {
              paramView1.mZN.setVisibility(0);
              localObject2 = paramView1.nao.mWO;
              long l = params.field_msgId;
              localObject3 = paramView1.mYN;
              localObject4 = com.tencent.mm.ai.m.a(paramView1.mYN);
              localObject5 = paramView1.mZN;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWB;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject2).a(l, paramInt, (com.tencent.mm.ai.v)localObject3, (String)localObject4, (ImageView)localObject5, j, j, false, (m.a)new e.a.b(paramView1, params, paramInt), params.nah + 1, 2.0F);
              break label836;
            }
            if ((paramView1.mYN.type == 5) || (paramView1.mYN.type == 6))
            {
              paramView1.mZN.setVisibility(0);
              localObject2 = paramView1.nao.mWO;
              localObject3 = paramView1.mZN;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.c.mWB;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject2).a("2131231674", (ImageView)localObject3, j, j, params.nah + 1);
              break label836;
            }
            paramView1.mZM.setVisibility(8);
            break label836;
            localObject4 = paramView1.mZJ;
            d.g.b.k.g(localObject4, "content");
            ((d.g.a.s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWF));
            localObject3 = paramView1.hIU;
            d.g.b.k.g(localObject3, "topLine");
            ((d.g.a.m)localObject2).n(localObject3, Integer.valueOf(com.tencent.mm.cd.a.g(paramView1.context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = paramView1.mZJ;
            d.g.b.k.g(localObject4, "content");
            ((d.g.a.s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWF), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWC));
            paramView1 = paramView1.hIU;
            d.g.b.k.g(paramView1, "topLine");
            ((d.g.a.m)localObject2).n(paramView1, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.mWG));
          }
        }
        h.vKh.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.h(params);
    AppMethodBeat.o(193050);
  }
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(193051);
    d.g.b.k.h(paramView, "parent");
    if (this.mYI == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307256)).inflate();
      d.g.b.k.g(paramView, "this");
      dz(paramView);
      this.mYJ = ((LinearLayout)paramView.findViewById(2131307153));
      this.mYI = paramView;
    }
    AppMethodBeat.o(193051);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(193052);
    View localView = this.mYI;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(193052);
      return;
    }
    AppMethodBeat.o(193052);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends k
  {
    final Context context;
    final View mYM;
    final com.tencent.mm.ai.v mYN;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(193048);
      this.context = localObject;
      this.mYM = View.inflate(this.context, 2131496139, null);
      this.mYN = new com.tencent.mm.ai.v();
      this.hIU = this.mYM.findViewById(2131306012);
      this.mZJ = this.mYM.findViewById(2131298764);
      this$1 = this.mYM.findViewById(2131305938);
      if (e.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(193048);
        throw e.this;
      }
      this.mZK = ((MMNeat7extView)e.this);
      this.mZL = ((TextView)this.mYM.findViewById(2131305546));
      this.mZM = this.mYM.findViewById(2131298814);
      this.mZN = ((ImageView)this.mYM.findViewById(2131298824));
      this.mZO = this.mYM.findViewById(2131297330);
      this.mZP = ((ImageView)this.mYM.findViewById(2131297370));
      this.mZQ = ((ImageView)this.mYM.findViewById(2131303284));
      this.mZR = this.mYM.findViewById(2131305184);
      this$1 = this.mYM.findViewById(2131300305);
      if (e.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(193048);
        throw e.this;
      }
      this.mZS = ((TextView)e.this);
      this.mZT = this.mYM.findViewById(2131303255);
      this.mZU = this.mYM.findViewById(2131303254);
      this.mZV = ((TextView)this.mYM.findViewById(2131303263));
      AppMethodBeat.o(193048);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.a parama, com.tencent.mm.storage.s params, daq paramdaq, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(193041);
        this.mYP.mYO.a(this.mYQ, this.mYR, paramView, this.mYS);
        AppMethodBeat.o(193041);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(com.tencent.mm.storage.s params, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(193042);
        this.mYP.a(this.mYP.mYN, true);
        this.mYP.nao.mWO.o(this.mYQ.field_msgId, this.mYT);
        AppMethodBeat.o(193042);
      }
      
      public final void onStart() {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(193047);
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dv((View)this.mYP.mZP);
        AppMethodBeat.o(193047);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<e.a>
  {
    b(e parame, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.e
 * JD-Core Version:    0.7.0.1
 */