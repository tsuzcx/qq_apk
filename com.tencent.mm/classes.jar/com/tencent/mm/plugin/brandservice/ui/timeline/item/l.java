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
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.widget.MMNeat7extView;
import d.a.j;
import d.g.a.m;
import d.g.a.s;
import d.g.b.q;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", "hide", "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class l
  extends p
{
  private View oiV;
  private LinearLayout oiW;
  private LinkedList<a> oiX;
  private final g<a> oiY;
  
  public l(final com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, final Context paramContext)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(208711);
    this.oiX = new LinkedList();
    this.oiY = new g((d.g.a.a)new b(this, paramb, paramContext));
    AppMethodBeat.o(208711);
  }
  
  public final void a(w paramw, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(208708);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    super.a(paramw, paramInt, paramView1, paramView2);
    paramView2 = paramw.ftj();
    if (paramView2 != null) {}
    for (paramView1 = paramView2.HTL; paramView1 == null; paramView1 = null)
    {
      AppMethodBeat.o(208708);
      return;
    }
    paramView1 = this.oiV;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    paramView1 = ((Iterable)this.oiX).iterator();
    Object localObject1;
    Object localObject2;
    while (paramView1.hasNext())
    {
      localObject1 = (a)paramView1.next();
      localObject2 = this.oiW;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).removeView(((a)localObject1).oiZ);
      }
      this.oiY.cT(localObject1);
    }
    this.oiX.clear();
    paramView1 = paramView2.Gcu;
    if (paramView1 != null)
    {
      localObject1 = ((Iterable)paramView1).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramView1 = ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          j.gkd();
        }
        paramView1 = (dmm)paramView1;
        if ((paramView1 != null) && ((paramView1.FNv & 0x1) == 0))
        {
          localObject2 = (a)this.oiY.get();
          Object localObject3 = this.oiW;
          if (localObject3 != null) {
            ((LinearLayout)localObject3).addView(((a)localObject2).oiZ);
          }
          this.oiX.add(localObject2);
          d.g.b.p.h(paramw, "info");
          d.g.b.p.h(paramView2, "recCard");
          d.g.b.p.h(paramView1, "appMsg");
          Object localObject6 = paramView1.Title;
          localObject3 = paramView1.FYs;
          int k = paramView1.hFR;
          Object localObject4 = paramView1.FYu;
          Object localObject5 = paramView1.FYv;
          ((a)localObject2).okR.aq((CharSequence)localObject6);
          localObject6 = ((a)localObject2).oiZ;
          if (paramInt == 0) {}
          for (int j = 2131231262;; j = 2131231256)
          {
            ((View)localObject6).setBackgroundResource(j);
            ((a)localObject2).oiZ.setOnClickListener((View.OnClickListener)new l.a.a((a)localObject2, paramw, paramView1, paramInt));
            if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil((String)localObject3))) {
              ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((String)localObject3, k, 90, new Object[0]);
            }
            ((a)localObject2).oif.type = k;
            ((a)localObject2).oif.hGe = ((String)localObject4);
            ((a)localObject2).oif.hGv = ((String)localObject5);
            ((a)localObject2).oif.url = ((String)localObject3);
            ((a)localObject2).a(((a)localObject2).oiv, ((a)localObject2).oiw, paramw, ((a)localObject2).oif);
            localObject3 = ((a)localObject2).okW;
            d.g.b.p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).okU;
            d.g.b.p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(8);
            if (((a)localObject2).oif.type != 7) {
              break label960;
            }
            ((a)localObject2).oic.setVisibility(8);
            d.g.b.p.h(paramw, "info");
            d.g.b.p.h(paramView1, "appMsg");
            localObject3 = ((a)localObject2).okW;
            d.g.b.p.g(localObject3, "playIcon");
            ((ImageView)localObject3).setVisibility(8);
            localObject3 = ((a)localObject2).okU;
            d.g.b.p.g(localObject3, "voicePlayIconContainer");
            ((View)localObject3).setVisibility(0);
            localObject3 = ((a)localObject2).okV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (((localObject3 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject3).isRunning())) {
              ((AnimationDrawable)localObject3).stop();
            }
            if (!d.g.b.p.i(String.valueOf(paramw.field_msgId) + "_" + paramInt, com.tencent.mm.plugin.brandservice.ui.b.c.bTw())) {
              break label858;
            }
            ((a)localObject2).okV.setImageResource(2131231272);
            localObject3 = ((a)localObject2).okV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            if (!(((ImageView)localObject3).getDrawable() instanceof AnimationDrawable)) {
              break label792;
            }
            localObject3 = ((a)localObject2).okV;
            d.g.b.p.g(localObject3, "voicePlayIcon");
            localObject3 = ((ImageView)localObject3).getDrawable();
            if (localObject3 != null) {
              break;
            }
            paramw = new d.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AppMethodBeat.o(208708);
            throw paramw;
          }
          ((AnimationDrawable)localObject3).start();
          label792:
          localObject3 = paramView1.Gco;
          if (bu.isNullOrNil((String)localObject3))
          {
            ae.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
            label815:
            paramView1 = (m)l.a.c.ojf;
            localObject3 = (s)l.a.d.ojg;
            switch (paramInt)
            {
            }
          }
          for (;;)
          {
            paramInt = i;
            break;
            label858:
            ((a)localObject2).okV.setImageResource(2131231271);
            break label792;
            ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a((View)((a)localObject2).okV, String.valueOf(paramw.field_msgId) + "_" + paramInt, paramView1.Title, (String)localObject3, "", paramView1.FYu);
            ((a)localObject2).okV.setOnClickListener((View.OnClickListener)new l.a.e((a)localObject2));
            break label815;
            label960:
            if (!bu.isNullOrNil(((a)localObject2).oif.hGe))
            {
              ((a)localObject2).oic.setVisibility(0);
              if (bu.isNullOrNil(((a)localObject2).oif.hGv)) {}
              for (paramView1 = ((a)localObject2).oif.hGe;; paramView1 = ((a)localObject2).oif.hGv)
              {
                localObject3 = ((a)localObject2).oll.ogi;
                long l = paramw.field_msgId;
                localObject4 = ((a)localObject2).oif;
                localObject5 = ((a)localObject2).oic;
                j = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject3).a(l, paramInt, (com.tencent.mm.ah.v)localObject4, paramView1, (ImageView)localObject5, j, j, false, (m.a)new l.a.b((a)localObject2, paramw, paramInt), paramw.ole + 1, 2.0F);
                break;
              }
            }
            if ((((a)localObject2).oif.type == 5) || (((a)localObject2).oif.type == 6))
            {
              ((a)localObject2).oic.setVisibility(0);
              paramView1 = ((a)localObject2).oll.ogi;
              localObject3 = ((a)localObject2).oic;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.ofV;
              paramView1.a("2131231674", (ImageView)localObject3, j, j, paramw.ole + 1);
              break label815;
            }
            ((a)localObject2).okT.setVisibility(8);
            break label815;
            localObject4 = ((a)localObject2).okQ;
            d.g.b.p.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ));
            localObject3 = ((a)localObject2).iFF;
            d.g.b.p.g(localObject3, "topLine");
            paramView1.p(localObject3, Integer.valueOf(com.tencent.mm.cb.a.h(((a)localObject2).context, 16.0F)));
            paramInt = i;
            break;
            localObject4 = ((a)localObject2).okQ;
            d.g.b.p.g(localObject4, "content");
            ((s)localObject3).a(localObject4, Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofZ), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.ofW));
            localObject2 = ((a)localObject2).iFF;
            d.g.b.p.g(localObject2, "topLine");
            paramView1.p(localObject2, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.oga));
          }
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 6L, 1L, false);
        paramInt = i;
      }
    }
    com.tencent.mm.plugin.brandservice.ui.b.c.m(paramw);
    AppMethodBeat.o(208708);
  }
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(208709);
    d.g.b.p.h(paramView, "parent");
    if (this.oiV == null)
    {
      paramView = ((ViewStub)paramView.findViewById(2131307256)).inflate();
      d.g.b.p.g(paramView, "this");
      dE(paramView);
      this.oiW = ((LinearLayout)paramView.findViewById(2131307153));
      this.oiV = paramView;
    }
    AppMethodBeat.o(208709);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208710);
    View localView = this.oiV;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(208710);
      return;
    }
    AppMethodBeat.o(208710);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "index", "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
  public final class a
    extends x
  {
    final Context context;
    final View oiZ;
    final com.tencent.mm.ah.v oif;
    
    public a(Context paramContext)
    {
      super(localObject);
      AppMethodBeat.i(208706);
      this.context = localObject;
      this.oiZ = View.inflate(this.context, 2131496139, null);
      this.oif = new com.tencent.mm.ah.v();
      this.iFF = this.oiZ.findViewById(2131306012);
      this.okQ = this.oiZ.findViewById(2131298764);
      this$1 = this.oiZ.findViewById(2131305938);
      if (l.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(208706);
        throw l.this;
      }
      this.okR = ((MMNeat7extView)l.this);
      this.okS = ((TextView)this.oiZ.findViewById(2131305546));
      this.okT = this.oiZ.findViewById(2131298814);
      this.oic = ((ImageView)this.oiZ.findViewById(2131298824));
      this.okU = this.oiZ.findViewById(2131297330);
      this.okV = ((ImageView)this.oiZ.findViewById(2131297370));
      this.okW = ((ImageView)this.oiZ.findViewById(2131303284));
      this.oiv = this.oiZ.findViewById(2131305184);
      this$1 = this.oiZ.findViewById(2131300305);
      if (l.this == null)
      {
        this$1 = new d.v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(208706);
        throw l.this;
      }
      this.oiw = ((TextView)l.this);
      this.okX = this.oiZ.findViewById(2131303255);
      this.okY = this.oiZ.findViewById(2131303254);
      this.okZ = ((TextView)this.oiZ.findViewById(2131303263));
      AppMethodBeat.o(208706);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(l.a parama, w paramw, dmm paramdmm, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208699);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.ojb.oja.a(this.oiy, this.ojc, paramView, this.ojd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208699);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class b
      implements m.a
    {
      b(w paramw, int paramInt) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(208700);
        this.ojb.a(this.ojb.oif, true);
        this.ojb.oll.ogi.p(this.oiy.field_msgId, this.oje);
        AppMethodBeat.o(208700);
      }
      
      public final void onStart() {}
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(l.a parama) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208705);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz((View)this.ojb.okV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208705);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
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