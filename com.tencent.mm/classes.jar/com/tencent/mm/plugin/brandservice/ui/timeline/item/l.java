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
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.a.m;
import d.g.a.s;
import d.g.b.q;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class l
  extends p
{
  private View odh;
  private LinearLayout odi;
  private LinkedList<a> odj;
  private final g<a> odk;
  
  public l(final com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, final Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(209737);
    this.odj = new LinkedList();
    this.odk = new g((d.g.a.a)new b(this, paramb, paramContext));
    AppMethodBeat.o(209737);
  }
  
  public final void a(com.tencent.mm.storage.w paramw, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(209734);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    super.a(paramw, paramInt, paramView1, paramView2);
    paramView2 = paramw.fpl();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.HzY; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(209734);
      return;
    }
    paramView1 = this.odh;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.odj).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.odi;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).odl);
      }
      this.odk.cS(localObject1);
    }
    this.odj.clear();
    paramView1 = paramView2.FJV;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.gfB();
        }
        paramView1 = (dlp)paramView1;
        if ((paramView1 != null) && ((paramView1.FuX & 0x1) == 0))
        {
          localObject2 = (a)this.odk.get();
          Object localObject3 = this.odi;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).addView(((a)localObject2).odl);
          }
          this.odj.add(localObject2);
          d.g.b.p.h(paramw, "info");
          d.g.b.p.h(paramView2, "recCard");
          d.g.b.p.h(paramView1, "appMsg");
          Object localObject6 = paramView1.Title;
          localObject3 = paramView1.FFW;
          int k = paramView1.hCZ;
          Object localObject4 = paramView1.FFY;
          Object localObject5 = paramView1.FFZ;
          ((a)localObject2).oeR.ar((CharSequence)localObject6);
          localObject6 = ((a)localObject2).odl;
          if (paramInt == 0) {}
          for (int j = 2131231262;; j = 2131231256)
          {
            ((View)localObject6).setBackgroundResource(j);
            ((a)localObject2).odl.setOnClickListener((View.OnClickListener)new l.a.a((a)localObject2, paramw, paramView1, paramInt));
            if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!bt.isNullOrNil((String)localObject3))) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, k, 90, new Object[0]);
            }
            ((a)localObject2).ocq.type = k;
            ((a)localObject2).ocq.hDm = ((String)localObject4);
            ((a)localObject2).ocq.hDD = ((String)localObject5);
            ((a)localObject2).ocq.url = ((String)localObject3);
            ((a)localObject2).a(((a)localObject2).ocG, ((a)localObject2).ocH, paramw, ((a)localObject2).ocq);
            localObject3 = ((a)localObject2).oeW;
            d.g.b.p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).oeU;
            d.g.b.p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(8);
            if (((a)localObject2).ocq.type != 7) {
              break label960;
            }
            ((a)localObject2).ocn.setVisibility(8);
            d.g.b.p.h(paramw, "info");
            d.g.b.p.h(paramView1, "appMsg");
            localObject3 = ((a)localObject2).oeW;
            d.g.b.p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).oeU;
            d.g.b.p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(0);
            localObject3 = ((a)localObject2).oeV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (((localObject3 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject3).isRunning())) {
              ((AnimationDrawable)localObject3).stop();
            }
            if (!d.g.b.p.i(String.valueOf(paramw.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.bSj())) {
              break label858;
            }
            ((a)localObject2).oeV.setImageResource(2131231272);
            localObject3 = ((a)localObject2).oeV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            if (!(((ImageView)localObject3).getDrawable() instanceof AnimationDrawable)) {
              break label792;
            }
            localObject3 = ((a)localObject2).oeV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (localObject3 != null) {
              break;
            }
            paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(209734);
            throw paramw;
          }
          ((AnimationDrawable)localObject3).start();
          label792:
          localObject3 = paramView1.FJP;
          if (bt.isNullOrNil((String)localObject3))
          {
            ad.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label815:
            paramView1 = (m)l.a.c.odr;
            localObject3 = (s)l.a.d.ods;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label858:
            ((a)localObject2).oeV.setImageResource(2131231271);
            break label792;
            ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject2).oeV, String.valueOf(paramw.field_msgId) + "_" + paramInt, paramView1.Title, (String)localObject3, "", paramView1.FFY);
            ((a)localObject2).oeV.setOnClickListener((View.OnClickListener)new l.a.e((a)localObject2));
            break label815;
            label960:
            if (!bt.isNullOrNil(((a)localObject2).ocq.hDm))
            {
              ((a)localObject2).ocn.setVisibility(0);
              if (bt.isNullOrNil(((a)localObject2).ocq.hDD)) {}
              for (paramView1 = ((a)localObject2).ocq.hDm;; paramView1 = ((a)localObject2).ocq.hDD)
              {
                localObject3 = ((a)localObject2).ofm.oas;
                long l = paramw.field_msgId;
                localObject4 = ((a)localObject2).ocq;
                localObject5 = ((a)localObject2).ocn;
                j = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).a(l, paramInt, (com.tencent.mm.ai.v)localObject4, paramView1, (ImageView)localObject5, j, j, false, (m.a)new l.a.b((a)localObject2, paramw, paramInt), paramw.ofe + 1, 2.0F);
                break;
              }
            }
            if ((((a)localObject2).ocq.type == 5) || (((a)localObject2).ocq.type == 6))
            {
              ((a)localObject2).ocn.setVisibility(0);
              paramView1 = ((a)localObject2).ofm.oas;
              localObject3 = ((a)localObject2).ocn;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.oaf;
              paramView1.a("2131231674", (ImageView)localObject3, j, j, paramw.ofe + 1);
              break label815;
            }
            ((a)localObject2).oeT.setVisibility(8);
            break label815;
            localObject4 = ((a)localObject2).oeQ;
            d.g.b.p.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oag), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oaj));
            localObject3 = ((a)localObject2).iCM;
            d.g.b.p.g(localObject3, "topLine");
            paramView1.p(localObject3, Integer.valueOf(com.tencent.mm.cc.a.g(((a)localObject2).context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = ((a)localObject2).oeQ;
            d.g.b.p.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oaj), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oag));
            localObject2 = ((a)localObject2).iCM;
            d.g.b.p.g(localObject2, "topLine");
            paramView1.p(localObject2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oak));
          }
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.l(paramw);
    AppMethodBeat.o(209734);
  }
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(209735);
    d.g.b.p.h(paramView, "parent");
    if (this.odh == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307256)).inflate();
      d.g.b.p.g(paramView, "this");
      dE(paramView);
      this.odi = ((LinearLayout)paramView.findViewById(2131307153));
      this.odh = paramView;
    }
    AppMethodBeat.o(209735);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209736);
    View localView = this.odh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(209736);
      return;
    }
    AppMethodBeat.o(209736);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends w
  {
    final Context context;
    final com.tencent.mm.ai.v ocq;
    final View odl;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(209732);
      this.context = localObject;
      this.odl = View.inflate(this.context, 2131496139, null);
      this.ocq = new com.tencent.mm.ai.v();
      this.iCM = this.odl.findViewById(2131306012);
      this.oeQ = this.odl.findViewById(2131298764);
      this$1 = this.odl.findViewById(2131305938);
      if (l.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(209732);
        throw l.this;
      }
      this.oeR = ((MMNeat7extView)l.this);
      this.oeS = ((TextView)this.odl.findViewById(2131305546));
      this.oeT = this.odl.findViewById(2131298814);
      this.ocn = ((ImageView)this.odl.findViewById(2131298824));
      this.oeU = this.odl.findViewById(2131297330);
      this.oeV = ((ImageView)this.odl.findViewById(2131297370));
      this.oeW = ((ImageView)this.odl.findViewById(2131303284));
      this.ocG = this.odl.findViewById(2131305184);
      this$1 = this.odl.findViewById(2131300305);
      if (l.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(209732);
        throw l.this;
      }
      this.ocH = ((TextView)l.this);
      this.oeX = this.odl.findViewById(2131303255);
      this.oeY = this.odl.findViewById(2131303254);
      this.oeZ = ((TextView)this.odl.findViewById(2131303263));
      AppMethodBeat.o(209732);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(l.a parama, com.tencent.mm.storage.w paramw, dlp paramdlp, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209725);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.odn.odm.a(this.ocJ, this.odo, paramView, this.odp);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209725);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(com.tencent.mm.storage.w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(209726);
        this.odn.a(this.odn.ocq, true);
        this.odn.ofm.oas.p(this.ocJ.field_msgId, this.odq);
        AppMethodBeat.o(209726);
      }
      
      public final void onStart() {}
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(l.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(209731);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.odn.oeV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209731);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<l.a>
  {
    b(l paraml, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.l
 * JD-Core Version:    0.7.0.1
 */