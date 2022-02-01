package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.finder.live.plugin.as;
import com.tencent.mm.plugin.surface.b.d;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGameInfoView;", "Lcom/tencent/mm/plugin/surface/view/SurfaceAppContainer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastFrameGameData", "", "root", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "setuped", "", "surfaceMgr", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "getSurfaceMgr", "()Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "setSurfaceMgr", "(Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;)V", "dispatchGameData", "", "gameDataJson", "notifyGameData", "gameData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameData;", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "pause", "requestLayout", "resume", "setup", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGameInfoView
  extends SurfaceAppContainer
{
  public static final FinderLiveGameInfoView.a DNn;
  private static long xQE;
  private com.tencent.mm.plugin.finder.live.model.frameset.c CZh;
  private String CZi;
  private boolean DNo;
  public com.tencent.mm.plugin.surface.c.f vFn;
  
  static
  {
    AppMethodBeat.i(358078);
    DNn = new FinderLiveGameInfoView.a((byte)0);
    xQE = MMSlotKt.now();
    com.tencent.mm.plugin.surface.b localb = com.tencent.mm.plugin.surface.b.SJM;
    com.tencent.mm.plugin.surface.b.a("wx9e221f7828fa7482", new com.tencent.mm.plugin.surface.core.g((Collection)kotlin.a.p.listOf(new com.tencent.mm.plugin.appbrand.jsapi.p[] { (com.tencent.mm.plugin.appbrand.jsapi.p)new d(), (com.tencent.mm.plugin.appbrand.jsapi.p)new co(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.b(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.a(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.c(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.appbrand.jsapi.aa.f(), (com.tencent.mm.plugin.appbrand.jsapi.p)new com.tencent.mm.plugin.surface.b.e(), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(764), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(865), ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).zk(968) }), (com.tencent.mm.plugin.surface.d.a)new b()));
    AppMethodBeat.o(358078);
  }
  
  public FinderLiveGameInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(358067);
    AppMethodBeat.o(358067);
  }
  
  public FinderLiveGameInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358041);
    AppMethodBeat.o(358041);
  }
  
  private final void awT(String paramString)
  {
    AppMethodBeat.i(358058);
    Log.i("MicroMsg.FinderLiveGameInfoView", s.X("notifyGameData:", paramString));
    com.tencent.mm.plugin.surface.c.f localf = this.vFn;
    if (localf != null) {
      localf.bdb(paramString);
    }
    AppMethodBeat.o(358058);
  }
  
  public final void a(bgz parambgz)
  {
    AppMethodBeat.i(358107);
    s.u(parambgz, "gameData");
    parambgz = parambgz.ZQv;
    if (parambgz == null) {}
    for (parambgz = null; (!s.p(this.CZi, parambgz)) && (parambgz != null); parambgz = parambgz.toString("UTF-8"))
    {
      this.CZi = parambgz;
      awT(parambgz);
      AppMethodBeat.o(358107);
      return;
    }
    if (parambgz == null)
    {
      Log.v("MicroMsg.FinderLiveGameInfoView", "game data invalid");
      AppMethodBeat.o(358107);
      return;
    }
    Log.v("MicroMsg.FinderLiveGameInfoView", "skip same game data");
    AppMethodBeat.o(358107);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.frameset.c getSurfaceMgr()
  {
    return this.CZh;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(358113);
    Log.i("MicroMsg.FinderLiveGameInfoView", "onAttachedToWindow");
    super.onAttachedToWindow();
    AppMethodBeat.o(358113);
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(358117);
    Log.i("MicroMsg.FinderLiveGameInfoView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.DNo = false;
    AppMethodBeat.o(358117);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358149);
    Log.d("MicroMsg.FinderLiveGameInfoView", "onInterceptTouchEvent");
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 1))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(as.REPORT_ID, as.CZy);
      Log.v(as.REPORT_TAG, "info card on click");
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(358149);
    return bool;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(358124);
    Log.d("MicroMsg.FinderLiveGameInfoView", "onLayout changed:" + paramBoolean + ", left:" + paramInt1 + ", top:" + paramInt2 + ", right:" + paramInt3 + ", bottom:" + paramInt4);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(358124);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358132);
    super.onMeasure(paramInt1, paramInt2);
    Log.d("MicroMsg.FinderLiveGameInfoView", "onMeasure:" + getMeasuredHeight() + ", " + getMeasuredWidth());
    AppMethodBeat.o(358132);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358139);
    Log.d("MicroMsg.FinderLiveGameInfoView", "onTouchEvent");
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(358139);
    return bool;
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(358153);
    Log.d("MicroMsg.FinderLiveGameInfoView", "requestLayout");
    super.requestLayout();
    AppMethodBeat.o(358153);
  }
  
  public final void setSurfaceMgr(com.tencent.mm.plugin.finder.live.model.frameset.c paramc)
  {
    this.CZh = paramc;
  }
  
  public final void setup(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e parame)
  {
    Context localContext = null;
    AppMethodBeat.i(358097);
    s.u(parame, "data");
    if (this.DNo)
    {
      AppMethodBeat.o(358097);
      return;
    }
    this.DNo = true;
    xQE = MMSlotKt.now();
    com.tencent.mm.plugin.report.service.h.OAn.b(as.CZz, new Object[] { as.CZA, Integer.valueOf(as.CZB), Long.valueOf(MMSlotKt.now()), Long.valueOf(xQE) });
    bde("portrait_game_outfits");
    Object localObject = this.CZh;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label245;
      }
      localObject = this.CZh;
      if (localObject != null)
      {
        localContext = getContext();
        s.s(localContext, "this.context");
        ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject).a(this, localContext, parame.mIC, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
      }
      parame = this.CZh;
      if (parame != null) {
        break label237;
      }
    }
    label237:
    for (parame = null;; parame = parame.CMX)
    {
      this.vFn = parame;
      parame = (SurfaceAppContainer)this;
      localObject = this.vFn;
      s.checkNotNull(localObject);
      SurfaceAppContainer.a(parame, (com.tencent.mm.plugin.surface.c.f)localObject);
      parame = this.CZi;
      if (parame != null) {
        awT(parame);
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(as.REPORT_ID, as.CZt);
      Log.v(as.REPORT_TAG, "info card setup");
      AppMethodBeat.o(358097);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.model.frameset.c)localObject).CMX;
      break;
    }
    label245:
    parame = this.CZh;
    if (parame == null) {}
    for (parame = localContext;; parame = parame.CMX)
    {
      this.vFn = parame;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveGameInfoView$Companion$1", "Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "reportFirstFrameRender", "", "reportJsException", "appId", "", "source", "message", "stackTrace", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.surface.d.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGameInfoView
 * JD-Core Version:    0.7.0.1
 */