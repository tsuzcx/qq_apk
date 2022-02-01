package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "updatedAdExpose", "", "getUpdatedAdExpose", "()Z", "setUpdatedAdExpose", "(Z)V", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "pos", "", "convertView", "Landroid/view/View;", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "getView", "inflate", "isVideoCard", "registerCard", "cardTmpl", "resetUnReadIfNeed", "setVideoStatus", "status", "updateAdExposeStatus", "Companion", "plugin-brandservice_release"})
public final class s
  extends ae
{
  public static final a sEg;
  private final Context context;
  private final b sCg;
  private final f sEb;
  private final f sEc;
  private final f sEd;
  private final f sEe;
  private boolean sEf;
  
  static
  {
    AppMethodBeat.i(257132);
    sEg = new a((byte)0);
    AppMethodBeat.o(257132);
  }
  
  public s(Context paramContext, b paramb)
  {
    AppMethodBeat.i(257131);
    this.context = paramContext;
    this.sCg = paramb;
    this.sEb = g.ar((a)new g(this));
    this.sEc = g.ar((a)new b(this));
    this.sEd = g.ar((a)new e(this));
    this.sEe = g.ar((a)new c(this));
    AppMethodBeat.o(257131);
  }
  
  private final BizTLRecCardCanvasView cAB()
  {
    AppMethodBeat.i(257124);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = (BizTLRecCardCanvasView)this.sEc.getValue();
    AppMethodBeat.o(257124);
    return localBizTLRecCardCanvasView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(257125);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramView1, "convertView");
    kotlin.g.b.p.k(paramView2, "parent");
    paramView2 = "__ad_card_" + paramz.hwO();
    Log.i("MicroMsg.BizTLRecCanvas", "filling#" + paramView2 + " msgId=" + paramz.field_msgId + " pathType = " + paramz.getPathType());
    cAB().setBizTimeLineInfo(paramz);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = cAB();
    long l = paramz.field_msgId;
    paramView1 = (CharSequence)paramz.getPathType();
    int i;
    if ((paramView1 == null) || (n.ba(paramView1)))
    {
      i = 1;
      if (i == 0) {
        break label337;
      }
    }
    label337:
    for (paramView1 = "ad";; paramView1 = paramz.getPathType())
    {
      kotlin.g.b.p.j(paramView1, "if(info.pathType.isNullO…) \"ad\" else info.pathType");
      String str = paramz.ahl();
      kotlin.g.b.p.j(str, "info.adData");
      localBizTLRecCardCanvasView.a(l, paramView2, paramView1, str);
      this.sCg.a(paramInt, paramz, (View)this.sEd.getValue(), (View)this.sEe.getValue());
      paramView1 = af.bjB();
      kotlin.g.b.p.j(paramView1, "SubCoreBiz.getBizTimeLineInfoStorage()");
      l = paramView1.hxb();
      if ((paramz.hwv() != l) && ((paramz.field_status != 4) || (paramz.field_hasShow != 1)))
      {
        paramz.field_status = 4;
        paramz.field_hasShow = 1;
        h.ZvG.be((Runnable)new d(paramz));
      }
      a(paramz, (ae)this);
      if (!this.sEf)
      {
        this.sEf = true;
        h.ZvG.be((Runnable)new f(paramz));
      }
      AppMethodBeat.o(257125);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(z paramz, ae paramae)
  {
    AppMethodBeat.i(257126);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramae, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, paramae);
    AppMethodBeat.o(257126);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(257130);
    kotlin.g.b.p.k(paramz, "info");
    kotlin.g.b.p.k(paramString, "extra");
    paramString = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.a(paramz, "");
    AppMethodBeat.o(257130);
  }
  
  public final ViewGroup cAA()
  {
    AppMethodBeat.i(257122);
    ViewGroup localViewGroup = (ViewGroup)this.sEb.getValue();
    AppMethodBeat.o(257122);
    return localViewGroup;
  }
  
  public final boolean cAC()
  {
    boolean bool2 = true;
    AppMethodBeat.i(257127);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = cAB();
    boolean bool1 = bool2;
    if (localBizTLRecCardCanvasView.sEK.bic(localBizTLRecCardCanvasView.getCanvasId()) == null)
    {
      z localz = localBizTLRecCardCanvasView.sBt;
      if ((localz == null) || (localz.fYu() != true)) {
        break label96;
      }
    }
    label96:
    for (bool1 = bool2;; bool1 = false)
    {
      Log.i(localBizTLRecCardCanvasView.TAG, "isVideoCard = " + bool1 + ", " + localBizTLRecCardCanvasView.getCanvasId());
      AppMethodBeat.o(257127);
      return bool1;
    }
  }
  
  public final View getVideoView()
  {
    AppMethodBeat.i(257128);
    View localView = (View)cAB();
    AppMethodBeat.o(257128);
    return localView;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(257129);
    cAB().setVideoStatus(paramInt);
    AppMethodBeat.o(257129);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<BizTLRecCardCanvasView>
  {
    b(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<LinearLayout>
  {
    c(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(258803);
      af.bjB().d(this.sAV, false);
      AppMethodBeat.o(258803);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements a<LinearLayout>
  {
    e(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(263639);
      long l = System.currentTimeMillis();
      Object localObject = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
      if (!Util.isEqual(this.sAV.hwO(), ((MultiProcessMMKV)localObject).decodeString("BizLastExposeAdAId")))
      {
        ((MultiProcessMMKV)localObject).encode("BizLastExposeAdTime", l);
        ((MultiProcessMMKV)localObject).encode("BizLastExposeAdAId", this.sAV.hwO());
      }
      localObject = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.Tt(69L);
      localObject = new com.tencent.mm.storage.p();
      ((com.tencent.mm.storage.p)localObject).field_aId = this.sAV.hwO();
      ((com.tencent.mm.storage.p)localObject).field_msgId = this.sAV.field_msgId;
      ((com.tencent.mm.storage.p)localObject).field_exposeTime = l;
      af.bjC().a((com.tencent.mm.storage.p)localObject);
      AppMethodBeat.o(263639);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<ViewGroup>
  {
    g(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.s
 * JD-Core Version:    0.7.0.1
 */