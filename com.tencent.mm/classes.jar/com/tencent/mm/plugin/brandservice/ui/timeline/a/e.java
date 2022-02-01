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
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.a.m;
import d.g.a.s;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class e
  extends g
{
  private View nBh;
  private LinearLayout nBi;
  private LinkedList<a> nBj;
  private final c<a> nBk;
  
  public e(final com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, final Context paramContext)
  {
    super(paramContext, paramc);
    AppMethodBeat.i(198847);
    this.nBj = new LinkedList();
    this.nBk = new c((d.g.a.a)new b(this, paramc, paramContext));
    AppMethodBeat.o(198847);
  }
  
  public final void a(t paramt, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(198844);
    d.g.b.k.h(paramt, "info");
    d.g.b.k.h(paramView1, "convertView");
    d.g.b.k.h(paramView2, "parent");
    super.a(paramt, paramInt, paramView1, paramView2);
    paramView2 = paramt.eZp();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.FPo; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(198844);
      return;
    }
    paramView1 = this.nBh;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.nBj).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.nBi;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).nBl);
      }
      this.nBk.nBe.add(localObject1);
    }
    this.nBj.clear();
    paramView1 = paramView2.FPq;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.fOc();
        }
        Object localObject3 = (dgc)paramView1;
        if ((localObject3 != null) && ((((dgc)localObject3).DPI & 0x1) == 0))
        {
          paramView1 = this.nBk;
          Object localObject6;
          int k;
          Object localObject4;
          Object localObject5;
          if (paramView1.nBe.size() > 0)
          {
            paramView1 = paramView1.nBe.remove(0);
            localObject2 = (a)paramView1;
            paramView1 = this.nBi;
            if (paramView1 != null) {
              paramView1.addView(((a)localObject2).nBl);
            }
            this.nBj.add(localObject2);
            d.g.b.k.h(paramt, "info");
            d.g.b.k.h(paramView2, "recCard");
            d.g.b.k.h(localObject3, "appMsg");
            localObject6 = ((dgc)localObject3).Title;
            paramView1 = ((dgc)localObject3).Ean;
            k = ((dgc)localObject3).hkQ;
            localObject4 = ((dgc)localObject3).Eap;
            localObject5 = ((dgc)localObject3).Eaq;
            ((a)localObject2).nCi.ar((CharSequence)localObject6);
            localObject6 = ((a)localObject2).nBl;
            if (paramInt != 0) {
              break label787;
            }
          }
          label787:
          for (int j = 2131231262;; j = 2131231256)
          {
            ((View)localObject6).setBackgroundResource(j);
            ((a)localObject2).nBl.setOnClickListener((View.OnClickListener)new e.a.a((a)localObject2, paramt, (dgc)localObject3, paramInt));
            if ((((b)com.tencent.mm.kernel.g.ab(b.class)).ys(1)) && (!bs.isNullOrNil(paramView1))) {
              ((b)com.tencent.mm.kernel.g.ab(b.class)).a(paramView1, k, 90, new Object[0]);
            }
            ((a)localObject2).nBm.type = k;
            ((a)localObject2).nBm.hld = ((String)localObject4);
            ((a)localObject2).nBm.hlu = ((String)localObject5);
            ((a)localObject2).nBm.url = paramView1;
            ((a)localObject2).a(((a)localObject2).nCp, ((a)localObject2).nCq, paramt, ((a)localObject2).nBm);
            paramView1 = ((a)localObject2).nCo;
            d.g.b.k.g(paramView1, "playIcon");
            paramView1.setVisibility(8);
            paramView1 = ((a)localObject2).nCm;
            d.g.b.k.g(paramView1, "voicePlayIconContainer");
            paramView1.setVisibility(8);
            if (((a)localObject2).nBm.type != 7) {
              break label973;
            }
            ((a)localObject2).nCl.setVisibility(8);
            d.g.b.k.h(paramt, "info");
            d.g.b.k.h(localObject3, "appMsg");
            paramView1 = ((a)localObject2).nCo;
            d.g.b.k.g(paramView1, "playIcon");
            paramView1.setVisibility(8);
            paramView1 = ((a)localObject2).nCm;
            d.g.b.k.g(paramView1, "voicePlayIconContainer");
            paramView1.setVisibility(0);
            paramView1 = ((a)localObject2).nCn;
            d.g.b.k.g(paramView1, "voicePlayIcon");
            paramView1 = paramView1.getDrawable();
            if (((paramView1 instanceof AnimationDrawable)) && (((AnimationDrawable)paramView1).isRunning())) {
              ((AnimationDrawable)paramView1).stop();
            }
            if (!d.g.b.k.g(String.valueOf(paramt.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
              break label870;
            }
            ((a)localObject2).nCn.setImageResource(2131231272);
            paramView1 = ((a)localObject2).nCn;
            d.g.b.k.g(paramView1, "voicePlayIcon");
            if (!(paramView1.getDrawable() instanceof AnimationDrawable)) {
              break label802;
            }
            paramView1 = ((a)localObject2).nCn;
            d.g.b.k.g(paramView1, "voicePlayIcon");
            paramView1 = paramView1.getDrawable();
            if (paramView1 != null) {
              break label795;
            }
            paramt = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(198844);
            throw paramt;
            paramView1 = paramView1.nBf.invoke();
            break;
          }
          label795:
          ((AnimationDrawable)paramView1).start();
          label802:
          paramView1 = ((dgc)localObject3).FPv;
          if (bs.isNullOrNil(paramView1))
          {
            ac.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label824:
            paramView1 = (m)e.a.c.nBt;
            localObject3 = (s)e.a.d.nBu;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label870:
            ((a)localObject2).nCn.setImageResource(2131231271);
            break label802;
            ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject2).nCn, String.valueOf(paramt.field_msgId) + "_" + paramInt, ((dgc)localObject3).Title, paramView1, "", ((dgc)localObject3).Eap);
            ((a)localObject2).nCn.setOnClickListener((View.OnClickListener)new e.a.e((a)localObject2));
            break label824;
            label973:
            if (!bs.isNullOrNil(((a)localObject2).nBm.hld))
            {
              ((a)localObject2).nCl.setVisibility(0);
              if (bs.isNullOrNil(((a)localObject2).nBm.hlu)) {}
              for (paramView1 = ((a)localObject2).nBm.hld;; paramView1 = ((a)localObject2).nBm.hlu)
              {
                localObject3 = ((a)localObject2).nCM.nzn;
                long l = paramt.field_msgId;
                localObject4 = ((a)localObject2).nBm;
                localObject5 = ((a)localObject2).nCl;
                j = com.tencent.mm.plugin.brandservice.ui.timeline.c.nza;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).a(l, paramInt, (com.tencent.mm.ah.v)localObject4, paramView1, (ImageView)localObject5, j, j, false, (m.a)new e.a.b((a)localObject2, paramt, paramInt), paramt.nCF + 1, 2.0F);
                break;
              }
            }
            if ((((a)localObject2).nBm.type == 5) || (((a)localObject2).nBm.type == 6))
            {
              ((a)localObject2).nCl.setVisibility(0);
              paramView1 = ((a)localObject2).nCM.nzn;
              localObject3 = ((a)localObject2).nCl;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.c.nza;
              paramView1.a("2131231674", (ImageView)localObject3, j, j, paramt.nCF + 1);
              break label824;
            }
            ((a)localObject2).nCk.setVisibility(8);
            break label824;
            localObject4 = ((a)localObject2).nCh;
            d.g.b.k.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.nze));
            localObject3 = ((a)localObject2).ijv;
            d.g.b.k.g(localObject3, "topLine");
            paramView1.n(localObject3, Integer.valueOf(com.tencent.mm.cc.a.g(((a)localObject2).context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = ((a)localObject2).nCh;
            d.g.b.k.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.nze), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.nzb));
            localObject2 = ((a)localObject2).ijv;
            d.g.b.k.g(localObject2, "topLine");
            paramView1.n(localObject2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.c.nzf));
          }
        }
        h.wUl.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.h(paramt);
    AppMethodBeat.o(198844);
  }
  
  public final void dA(View paramView)
  {
    AppMethodBeat.i(198845);
    d.g.b.k.h(paramView, "parent");
    if (this.nBh == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307256)).inflate();
      d.g.b.k.g(paramView, "this");
      dB(paramView);
      this.nBi = ((LinearLayout)paramView.findViewById(2131307153));
      this.nBh = paramView;
    }
    AppMethodBeat.o(198845);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(198846);
    View localView = this.nBh;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(198846);
      return;
    }
    AppMethodBeat.o(198846);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends k
  {
    final Context context;
    final View nBl;
    final com.tencent.mm.ah.v nBm;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(198842);
      this.context = localObject;
      this.nBl = View.inflate(this.context, 2131496139, null);
      this.nBm = new com.tencent.mm.ah.v();
      this.ijv = this.nBl.findViewById(2131306012);
      this.nCh = this.nBl.findViewById(2131298764);
      this$1 = this.nBl.findViewById(2131305938);
      if (e.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(198842);
        throw e.this;
      }
      this.nCi = ((MMNeat7extView)e.this);
      this.nCj = ((TextView)this.nBl.findViewById(2131305546));
      this.nCk = this.nBl.findViewById(2131298814);
      this.nCl = ((ImageView)this.nBl.findViewById(2131298824));
      this.nCm = this.nBl.findViewById(2131297330);
      this.nCn = ((ImageView)this.nBl.findViewById(2131297370));
      this.nCo = ((ImageView)this.nBl.findViewById(2131303284));
      this.nCp = this.nBl.findViewById(2131305184);
      this$1 = this.nBl.findViewById(2131300305);
      if (e.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(198842);
        throw e.this;
      }
      this.nCq = ((TextView)e.this);
      this.nCr = this.nBl.findViewById(2131303255);
      this.nCs = this.nBl.findViewById(2131303254);
      this.nCt = ((TextView)this.nBl.findViewById(2131303263));
      AppMethodBeat.o(198842);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e.a parama, t paramt, dgc paramdgc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(198835);
        this.nBo.nBn.a(this.nBp, this.nBq, paramView, this.nBr);
        AppMethodBeat.o(198835);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(t paramt, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(198836);
        this.nBo.a(this.nBo.nBm, true);
        this.nBo.nCM.nzn.p(this.nBp.field_msgId, this.nBs);
        AppMethodBeat.o(198836);
      }
      
      public final void onStart() {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(e.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(198841);
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dx((View)this.nBo.nCn);
        AppMethodBeat.o(198841);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.e
 * JD-Core Version:    0.7.0.1
 */