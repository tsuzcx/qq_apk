package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.debug.LiveDebugView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "bringToFront", "userId", "streamType", "", "cameraOrientationChanged", "orientation", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "halfRemoteAndCamera", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshCameraView", "refreshVideoView", "relayoutAnchorPreview", "userIdList", "", "relayoutVisitorPreview", "anchorUserId", "selfUserId", "release", "remoteViewFullScreen", "value", "remoteViewPkScreen", "restoreFromHalfMode", "setPkUserId", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "setSelfUserId", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView kqA;
  public TRTCVideoLayoutManager ksW;
  private m<? super Float, ? super Float, x> ksX;
  private long ksY;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201314);
    this.TAG = "MicroMsg.LiveCore";
    this.ksY = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(a.e.live_visitor_preview_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(a.d.render_view);
    p.j(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.ksW = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(a.d.live_debug_view);
    p.j(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.kqA = ((LiveDebugView)paramContext);
    paramContext = h.aHG();
    p.j(paramContext, "MMKernel.storage()");
    if (paramContext.aHp().getInt(ar.a.VCx, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.kqA.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.c(this.kqA);
      AppMethodBeat.o(201314);
      return;
    }
    this.kqA.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(201314);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(201293);
    SurfaceView localSurfaceView = this.ksW.aNp();
    p.j(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(201293);
    return localSurfaceView;
  }
  
  public final void NR(final String paramString)
  {
    AppMethodBeat.i(201271);
    post((Runnable)new a(this, paramString));
    AppMethodBeat.o(201271);
  }
  
  public final void NS(String paramString)
  {
    AppMethodBeat.i(201282);
    this.ksW.NS(paramString);
    AppMethodBeat.o(201282);
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(201279);
    p.k(paramString1, "anchorUserId");
    p.k(paramString2, "selfUserId");
    p.k(paramList, "userIdList");
    this.ksW.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(201279);
  }
  
  public final void a(q<? super n, ? super Integer, ? super Integer, x> paramq)
  {
    AppMethodBeat.i(201295);
    p.k(paramq, "callback");
    paramq.c(new n(getCameraView().getHolder()), Integer.valueOf(this.ksW.getCameraViewWidth()), Integer.valueOf(this.ksW.getCameraViewHeight()));
    AppMethodBeat.o(201295);
  }
  
  public final void ad(List<String> paramList)
  {
    AppMethodBeat.i(201274);
    p.k(paramList, "userIdList");
    this.ksW.ad(paramList);
    AppMethodBeat.o(201274);
  }
  
  public final TXCloudVideoView ap(String paramString, int paramInt)
  {
    AppMethodBeat.i(201280);
    paramString = this.ksW.aq(paramString, paramInt);
    AppMethodBeat.o(201280);
    return paramString;
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(201288);
    p.k(paramString, "userId");
    this.ksW.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(201288);
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(201283);
    RelativeLayout localRelativeLayout = this.ksW.getCameraContentView();
    AppMethodBeat.o(201283);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.ksW;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201306);
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label45;
      }
      label22:
      if (localObject != null) {
        break label62;
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(201306);
      return bool;
      localObject = null;
      break;
      label45:
      if (((Integer)localObject).intValue() != 0) {
        break label22;
      }
      this.ksY = System.currentTimeMillis();
      continue;
      label62:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.ksY > 0L) && (System.currentTimeMillis() - this.ksY <= ViewConfiguration.getTapTimeout()))
        {
          Log.d(this.TAG, "preview action up");
          localObject = this.ksX;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.ksY = -1L;
      }
    }
  }
  
  public final void setPkUserId(String paramString)
  {
    AppMethodBeat.i(201289);
    p.k(paramString, "userId");
    this.ksW.setPkUserId(paramString);
    AppMethodBeat.o(201289);
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, x> paramm)
  {
    AppMethodBeat.i(201299);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.ksW;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(201299);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, x> paramm)
  {
    this.ksX = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(201268);
    p.k(paramTRTCVideoLayoutManager, "<set-?>");
    this.ksW = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(201268);
  }
  
  public final void setSelfUserId(String paramString)
  {
    AppMethodBeat.i(201291);
    p.k(paramString, "userId");
    this.ksW.setMySelfUserId(paramString);
    AppMethodBeat.o(201291);
  }
  
  public final void tD(int paramInt)
  {
    AppMethodBeat.i(201285);
    this.ksW.tF(paramInt);
    AppMethodBeat.o(201285);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(LivePreviewView paramLivePreviewView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(199691);
      int i = this.ksZ.getRenderLayout().ar(paramString, this.ktb);
      this.ksZ.getRenderLayout().tE(i);
      AppMethodBeat.o(199691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */