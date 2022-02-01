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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.g.a.q;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "cameraOrientationChanged", "orientation", "", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "streamType", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshVideoView", "release", "remoteViewFullScreen", "value", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView gKo;
  public TRTCVideoLayoutManager gLW;
  private m<? super Float, ? super Float, z> gLX;
  private long gLY;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(217039);
    this.TAG = "MicroMsg.LiveCore";
    this.gLY = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496355, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307928);
    p.g(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.gLW = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307620);
    p.g(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.gKo = ((LiveDebugView)paramContext);
    paramContext = g.ajC();
    p.g(paramContext, "MMKernel.storage()");
    if (paramContext.ajl().getInt(al.a.IIZ, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gKo.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.c(this.gKo);
      AppMethodBeat.o(217039);
      return;
    }
    this.gKo.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(217039);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(217035);
    SurfaceView localSurfaceView = this.gLW.amK();
    p.g(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(217035);
    return localSurfaceView;
  }
  
  public final TXCloudVideoView U(String paramString, int paramInt)
  {
    AppMethodBeat.i(217032);
    paramString = this.gLW.V(paramString, paramInt);
    AppMethodBeat.o(217032);
    return paramString;
  }
  
  public final void a(q<? super j, ? super Integer, ? super Integer, z> paramq)
  {
    AppMethodBeat.i(217036);
    p.h(paramq, "callback");
    paramq.d(new j(getCameraView().getHolder()), Integer.valueOf(this.gLW.getCameraViewWidth()), Integer.valueOf(this.gLW.getCameraViewHeight()));
    AppMethodBeat.o(217036);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(217034);
    p.h(paramString, "userId");
    this.gLW.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(217034);
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(217033);
    RelativeLayout localRelativeLayout = this.gLW.getCameraContentView();
    AppMethodBeat.o(217033);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.gLW;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217038);
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
      AppMethodBeat.o(217038);
      return bool;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label21;
      }
      this.gLY = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gLY > 0L) && (System.currentTimeMillis() - this.gLY <= ViewConfiguration.getTapTimeout()))
        {
          ad.d(this.TAG, "preview action up");
          localObject = this.gLX;
          if (localObject != null) {
            ((m)localObject).p(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gLY = -1L;
      }
    }
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, z> paramm)
  {
    AppMethodBeat.i(217037);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.gLW;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(217037);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, z> paramm)
  {
    this.gLX = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(217031);
    p.h(paramTRTCVideoLayoutManager, "<set-?>");
    this.gLW = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(217031);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(LivePreviewView paramLivePreviewView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(217029);
      int i = this.gLZ.getRenderLayout().W(this.gMa, this.gMb);
      this.gLZ.getRenderLayout().nr(i);
      AppMethodBeat.o(217029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */