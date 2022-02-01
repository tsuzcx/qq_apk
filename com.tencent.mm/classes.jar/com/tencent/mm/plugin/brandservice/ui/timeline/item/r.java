package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.q;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "updatedAdExpose", "", "getUpdatedAdExpose", "()Z", "setUpdatedAdExpose", "(Z)V", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "pos", "", "convertView", "Landroid/view/View;", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "getView", "inflate", "isVideoCard", "registerCard", "cardTmpl", "resetUnReadIfNeed", "setVideoStatus", "status", "updateAdExposeStatus", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends ab
{
  public static final r.a vJN;
  private final Context context;
  private final b vHY;
  private final j vJO;
  private final j vJP;
  private final j vJQ;
  private final j vJR;
  private boolean vJS;
  
  static
  {
    AppMethodBeat.i(302686);
    vJN = new r.a((byte)0);
    AppMethodBeat.o(302686);
  }
  
  public r(Context paramContext, b paramb)
  {
    AppMethodBeat.i(302652);
    this.context = paramContext;
    this.vHY = paramb;
    this.vJO = k.cm((a)new e(this));
    this.vJP = k.cm((a)new b(this));
    this.vJQ = k.cm((a)new d(this));
    this.vJR = k.cm((a)new c(this));
    AppMethodBeat.o(302652);
  }
  
  private final BizTLRecCardCanvasView ddB()
  {
    AppMethodBeat.i(302660);
    Object localObject = this.vJP.getValue();
    s.s(localObject, "<get-canvasView>(...)");
    localObject = (BizTLRecCardCanvasView)localObject;
    AppMethodBeat.o(302660);
    return localObject;
  }
  
  private static final void l(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(302667);
    s.u(paramab, "$info");
    af.bHl().d(paramab, false);
    AppMethodBeat.o(302667);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(302705);
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    paramView1 = com.tencent.mm.storage.r.acDM;
    paramView1 = paramab.getTraceId();
    s.s(paramView1, "info.traceId");
    paramView2 = com.tencent.mm.storage.r.bvg(paramView1);
    Log.i("MicroMsg.BizTLRecCanvas", "filling#" + paramView2 + " aId = " + paramab.iYs() + " msgId=" + paramab.field_msgId + " pathType = " + paramab.iYt());
    ddB().setBizTimeLineInfo(paramab);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = ddB();
    long l = paramab.field_msgId;
    paramView1 = (CharSequence)paramab.iYt();
    int i;
    if ((paramView1 == null) || (n.bp(paramView1)))
    {
      i = 1;
      if (i == 0) {
        break label325;
      }
    }
    label325:
    for (paramView1 = "ad";; paramView1 = paramab.iYt())
    {
      s.s(paramView1, "if(info.pathType.isNullO…) \"ad\" else info.pathType");
      String str = paramab.iYq();
      s.s(str, "info.adData");
      localBizTLRecCardCanvasView.a(l, paramView2, paramView1, str);
      this.vHY.a(paramInt, paramab, (View)this.vJQ.getValue(), (View)this.vJR.getValue());
      l = af.bHl().iYD();
      if ((paramab.iYa() != l) && ((paramab.field_status != 4) || (paramab.field_hasShow != 1)))
      {
        paramab.field_status = 4;
        paramab.field_hasShow = 1;
        h.ahAA.bm(new r..ExternalSyntheticLambda0(paramab));
      }
      a(paramab, (ab)this);
      paramView1 = com.tencent.mm.storage.r.acDM;
      if ((!com.tencent.mm.storage.r.iXr()) && (!this.vJS)) {
        break label333;
      }
      AppMethodBeat.o(302705);
      return;
      i = 0;
      break;
    }
    label333:
    this.vJS = true;
    af.bHm().A(paramab);
    AppMethodBeat.o(302705);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, ab paramab1)
  {
    AppMethodBeat.i(302710);
    s.u(paramab, "info");
    s.u(paramab1, "cardTmpl");
    MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, paramab1);
    AppMethodBeat.o(302710);
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, String paramString)
  {
    AppMethodBeat.i(302732);
    s.u(paramab, "info");
    s.u(paramString, "extra");
    paramString = MPVideoPreviewMgr.vXs;
    MPVideoPreviewMgr.a(paramab, "");
    AppMethodBeat.o(302732);
  }
  
  public final ViewGroup ddA()
  {
    AppMethodBeat.i(302693);
    ViewGroup localViewGroup = (ViewGroup)this.vJO.getValue();
    AppMethodBeat.o(302693);
    return localViewGroup;
  }
  
  public final boolean ddC()
  {
    boolean bool = false;
    AppMethodBeat.i(302716);
    BizTLRecCardCanvasView localBizTLRecCardCanvasView = ddB();
    if (localBizTLRecCardCanvasView.getLogicEngine().bhN(localBizTLRecCardCanvasView.getCanvasId()) == null)
    {
      com.tencent.mm.storage.ab localab = localBizTLRecCardCanvasView.vGS;
      if (localab == null) {
        break label139;
      }
      if ((Util.isNullOrNil(localab.iYs())) || (localab.acFG == null) || (Util.isNullOrNil(localab.acFG.optString("video_info")))) {
        break label134;
      }
      i = 1;
      if (i != 1) {
        break label139;
      }
    }
    label134:
    label139:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      Log.i(localBizTLRecCardCanvasView.TAG, "isVideoCard = " + bool + ", " + localBizTLRecCardCanvasView.getCanvasId());
      AppMethodBeat.o(302716);
      return bool;
      i = 0;
      break;
    }
  }
  
  public final View getVideoView()
  {
    AppMethodBeat.i(302718);
    View localView = (View)ddB();
    AppMethodBeat.o(302718);
    return localView;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(302724);
    ddB().setVideoStatus(paramInt);
    AppMethodBeat.o(302724);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<BizTLRecCardCanvasView>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<LinearLayout>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<LinearLayout>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ViewGroup>
  {
    e(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.r
 * JD-Core Version:    0.7.0.1
 */