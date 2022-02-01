package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "pos", "", "convertView", "Landroid/view/View;", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "getView", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "resetUnReadIfNeed", "setVideoStatus", "status", "Companion", "plugin-brandservice_release"})
public final class r
  extends ad
{
  private static final f puK;
  public static final a puL;
  private final Context context;
  private final b psQ;
  private final f puG;
  private final f puH;
  private final f puI;
  private final f puJ;
  
  static
  {
    AppMethodBeat.i(195336);
    puL = new a((byte)0);
    puK = g.ah((a)b.puM);
    AppMethodBeat.o(195336);
  }
  
  public r(Context paramContext, b paramb)
  {
    AppMethodBeat.i(195335);
    this.context = paramContext;
    this.psQ = paramb;
    this.puG = g.ah((a)new g(this));
    this.puH = g.ah((a)new c(this));
    this.puI = g.ah((a)new f(this));
    this.puJ = g.ah((a)new d(this));
    AppMethodBeat.o(195335);
  }
  
  private final BizTLRecCardCanvasView cmR()
  {
    AppMethodBeat.i(195328);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = (BizTLRecCardCanvasView)this.puH.getValue();
    AppMethodBeat.o(195328);
    return localBizTLRecCardCanvasView;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(z paramz, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(195329);
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    String str = "__ad_card_" + paramz.gAG();
    Log.i("MicroMsg.BizTLRecCanvas", "filling#" + str + " msgId=" + paramz.field_msgId);
    cmR().setBizTimeLineInfo(paramz);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = cmR();
    long l = paramz.field_msgId;
    paramView2 = paramz.getPathType();
    paramView1 = paramView2;
    if (paramView2 == null) {
      paramView1 = "ad";
    }
    paramView2 = paramz.acx();
    p.g(paramView2, "info.adData");
    localBizTLRecCardCanvasView.a(l, str, paramView1, paramView2);
    this.psQ.a(paramInt, paramz, (View)this.puI.getValue(), (View)this.puJ.getValue());
    paramView1 = ag.ban();
    p.g(paramView1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    l = paramView1.gAS();
    if ((paramz.gAo() != l) && ((paramz.field_status != 4) || (paramz.field_hasShow != 1)))
    {
      paramz.field_status = 4;
      paramz.field_hasShow = 1;
      h.RTc.aX((Runnable)new e(paramz));
    }
    a(paramz, (ad)this);
    AppMethodBeat.o(195329);
  }
  
  public final void a(z paramz, ad paramad)
  {
    AppMethodBeat.i(195330);
    p.h(paramz, "info");
    p.h(paramad, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, paramad);
    AppMethodBeat.o(195330);
  }
  
  public final void a(z paramz, String paramString)
  {
    AppMethodBeat.i(195334);
    p.h(paramz, "info");
    p.h(paramString, "extra");
    paramString = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.a(paramz, "");
    AppMethodBeat.o(195334);
  }
  
  public final ViewGroup cmQ()
  {
    AppMethodBeat.i(195327);
    ViewGroup localViewGroup = (ViewGroup)this.puG.getValue();
    AppMethodBeat.o(195327);
    return localViewGroup;
  }
  
  public final boolean cmS()
  {
    boolean bool2 = true;
    AppMethodBeat.i(195331);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = cmR();
    boolean bool1 = bool2;
    if (localBizTLRecCardCanvasView.pvt.aWv(localBizTLRecCardCanvasView.getCanvasId()) == null)
    {
      z localz = localBizTLRecCardCanvasView.psm;
      if ((localz == null) || (localz.gAH() != true)) {
        break label96;
      }
    }
    label96:
    for (bool1 = bool2;; bool1 = false)
    {
      Log.i(localBizTLRecCardCanvasView.TAG, "isVideoCard = " + bool1 + ", " + localBizTLRecCardCanvasView.getCanvasId());
      AppMethodBeat.o(195331);
      return bool1;
    }
  }
  
  public final View getVideoView()
  {
    AppMethodBeat.i(195332);
    View localView = (View)cmR();
    AppMethodBeat.o(195332);
    return localView;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(195333);
    cmR().setVideoStatus(paramInt);
    AppMethodBeat.o(195333);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas$Companion;", "", "()V", "JS_ENGINE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "getJS_ENGINE", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "JS_ENGINE$delegate", "Lkotlin/Lazy;", "TAG", "", "plugin-brandservice_release"})
  public static final class a
  {
    public static x cmU()
    {
      AppMethodBeat.i(195321);
      Object localObject = r.cmT();
      a locala = r.puL;
      localObject = (x)((f)localObject).getValue();
      AppMethodBeat.o(195321);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    public static final b puM;
    
    static
    {
      AppMethodBeat.i(195320);
      puM = new b();
      AppMethodBeat.o(195320);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<BizTLRecCardCanvasView>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class d
    extends q
    implements a<LinearLayout>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(195324);
      ag.ban().c(this.prL, false);
      AppMethodBeat.o(195324);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class f
    extends q
    implements a<LinearLayout>
  {
    f(r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class g
    extends q
    implements a<ViewGroup>
  {
    g(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.r
 * JD-Core Version:    0.7.0.1
 */