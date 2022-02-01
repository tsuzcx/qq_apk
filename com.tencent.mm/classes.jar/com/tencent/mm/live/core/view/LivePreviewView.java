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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.g.a.q;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "cameraOrientationChanged", "orientation", "", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "streamType", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshVideoView", "release", "remoteViewFullScreen", "value", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView gMX;
  public TRTCVideoLayoutManager gOF;
  private m<? super Float, ? super Float, z> gOG;
  private long gOH;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197051);
    this.TAG = "MicroMsg.LiveCore";
    this.gOH = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496355, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307928);
    p.g(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.gOF = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307620);
    p.g(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.gMX = ((LiveDebugView)paramContext);
    paramContext = g.ajR();
    p.g(paramContext, "MMKernel.storage()");
    if (paramContext.ajA().getInt(am.a.JdF, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gMX.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.c(this.gMX);
      AppMethodBeat.o(197051);
      return;
    }
    this.gMX.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(197051);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(197047);
    SurfaceView localSurfaceView = this.gOF.amZ();
    p.g(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(197047);
    return localSurfaceView;
  }
  
  public final TXCloudVideoView V(String paramString, int paramInt)
  {
    AppMethodBeat.i(197044);
    paramString = this.gOF.W(paramString, paramInt);
    AppMethodBeat.o(197044);
    return paramString;
  }
  
  public final void a(q<? super j, ? super Integer, ? super Integer, z> paramq)
  {
    AppMethodBeat.i(197048);
    p.h(paramq, "callback");
    paramq.d(new j(getCameraView().getHolder()), Integer.valueOf(this.gOF.getCameraViewWidth()), Integer.valueOf(this.gOF.getCameraViewHeight()));
    AppMethodBeat.o(197048);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(197046);
    p.h(paramString, "userId");
    this.gOF.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(197046);
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(197045);
    RelativeLayout localRelativeLayout = this.gOF.getCameraContentView();
    AppMethodBeat.o(197045);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.gOF;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(197050);
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
      AppMethodBeat.o(197050);
      return bool;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label21;
      }
      this.gOH = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gOH > 0L) && (System.currentTimeMillis() - this.gOH <= ViewConfiguration.getTapTimeout()))
        {
          ae.d(this.TAG, "preview action up");
          localObject = this.gOG;
          if (localObject != null) {
            ((m)localObject).p(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gOH = -1L;
      }
    }
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, z> paramm)
  {
    AppMethodBeat.i(197049);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.gOF;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(197049);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, z> paramm)
  {
    this.gOG = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(197043);
    p.h(paramTRTCVideoLayoutManager, "<set-?>");
    this.gOF = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(197043);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(LivePreviewView paramLivePreviewView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(197041);
      int i = this.gOI.getRenderLayout().X(this.gOJ, this.gOK);
      this.gOI.getRenderLayout().nu(i);
      AppMethodBeat.o(197041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */