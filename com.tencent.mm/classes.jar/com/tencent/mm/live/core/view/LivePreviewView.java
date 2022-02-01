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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.debug.LiveDebugView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "cameraOrientationChanged", "orientation", "", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "streamType", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshVideoView", "release", "remoteViewFullScreen", "value", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView gqE;
  public TRTCVideoLayoutManager gso;
  private m<? super Float, ? super Float, y> gsp;
  private long gsq;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209380);
    this.TAG = "MicroMsg.LiveCore";
    this.gsq = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496355, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307928);
    k.g(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.gso = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307620);
    k.g(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.gqE = ((LiveDebugView)paramContext);
    paramContext = g.agR();
    k.g(paramContext, "MMKernel.storage()");
    if (paramContext.agA().getInt(ah.a.GWc, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gqE.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.c(this.gqE);
      AppMethodBeat.o(209380);
      return;
    }
    this.gqE.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(209380);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(209376);
    SurfaceView localSurfaceView = this.gso.ajY();
    k.g(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(209376);
    return localSurfaceView;
  }
  
  public final TXCloudVideoView R(String paramString, int paramInt)
  {
    AppMethodBeat.i(209373);
    paramString = this.gso.S(paramString, paramInt);
    AppMethodBeat.o(209373);
    return paramString;
  }
  
  public final void a(q<? super j, ? super Integer, ? super Integer, y> paramq)
  {
    AppMethodBeat.i(209377);
    k.h(paramq, "callback");
    paramq.d(new j(getCameraView().getHolder()), Integer.valueOf(this.gso.getCameraViewWidth()), Integer.valueOf(this.gso.getCameraViewHeight()));
    AppMethodBeat.o(209377);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(209375);
    k.h(paramString, "userId");
    this.gso.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(209375);
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(209374);
    RelativeLayout localRelativeLayout = this.gso.getCameraContentView();
    AppMethodBeat.o(209374);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.gso;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209379);
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label43;
      }
      label21:
      if (localObject != null) {
        break label60;
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(209379);
      return bool;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label21;
      }
      this.gsq = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gsq > 0L) && (System.currentTimeMillis() - this.gsq <= ViewConfiguration.getTapTimeout()))
        {
          ac.d(this.TAG, "preview action up");
          localObject = this.gsp;
          if (localObject != null) {
            ((m)localObject).n(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gsq = -1L;
      }
    }
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, y> paramm)
  {
    AppMethodBeat.i(209378);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.gso;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(209378);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, y> paramm)
  {
    this.gsp = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(209372);
    k.h(paramTRTCVideoLayoutManager, "<set-?>");
    this.gso = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(209372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */