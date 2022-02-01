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
import com.tencent.mm.live.core.debug.LiveDebugView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "bringToFront", "userId", "streamType", "", "cameraOrientationChanged", "orientation", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "halfCameraAndRemote", "halfRemoteAndCamera", "halfRemoteAndRemote", "anchorUserId", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshCameraView", "refreshVideoView", "release", "remoteViewFullScreen", "value", "remoteViewPkScreen", "restoreFromHalfMode", "setPkUserId", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "setSelfUserId", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView hCz;
  public TRTCVideoLayoutManager hER;
  private m<? super Float, ? super Float, x> hES;
  private long hET;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196765);
    this.TAG = "MicroMsg.LiveCore";
    this.hET = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495295, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131306943);
    p.g(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.hER = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(2131303382);
    p.g(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.hCz = ((LiveDebugView)paramContext);
    paramContext = g.aAh();
    p.g(paramContext, "MMKernel.storage()");
    if (paramContext.azQ().getInt(ar.a.Onl, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.hCz.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.c(this.hCz);
      AppMethodBeat.o(196765);
      return;
    }
    this.hCz.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(196765);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(196761);
    SurfaceView localSurfaceView = this.hER.aEX();
    p.g(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(196761);
    return localSurfaceView;
  }
  
  public final void GE(final String paramString)
  {
    AppMethodBeat.i(196754);
    post((Runnable)new a(this, paramString));
    AppMethodBeat.o(196754);
  }
  
  public final TXCloudVideoView X(String paramString, int paramInt)
  {
    AppMethodBeat.i(196755);
    paramString = this.hER.Y(paramString, paramInt);
    AppMethodBeat.o(196755);
    return paramString;
  }
  
  public final void a(q<? super com.tencent.mm.live.core.b.l, ? super Integer, ? super Integer, x> paramq)
  {
    AppMethodBeat.i(196762);
    p.h(paramq, "callback");
    paramq.d(new com.tencent.mm.live.core.b.l(getCameraView().getHolder()), Integer.valueOf(this.hER.getCameraViewWidth()), Integer.valueOf(this.hER.getCameraViewHeight()));
    AppMethodBeat.o(196762);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(196758);
    p.h(paramString, "userId");
    this.hER.c(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(196758);
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(196756);
    RelativeLayout localRelativeLayout = this.hER.getCameraContentView();
    AppMethodBeat.o(196756);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.hER;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196764);
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
      AppMethodBeat.o(196764);
      return bool;
      localObject = null;
      break;
      label45:
      if (((Integer)localObject).intValue() != 0) {
        break label22;
      }
      this.hET = System.currentTimeMillis();
      continue;
      label62:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.hET > 0L) && (System.currentTimeMillis() - this.hET <= ViewConfiguration.getTapTimeout()))
        {
          Log.d(this.TAG, "preview action up");
          localObject = this.hES;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.hET = -1L;
      }
    }
  }
  
  public final void qO(int paramInt)
  {
    AppMethodBeat.i(196757);
    this.hER.qQ(paramInt);
    AppMethodBeat.o(196757);
  }
  
  public final void setPkUserId(String paramString)
  {
    AppMethodBeat.i(196759);
    p.h(paramString, "userId");
    this.hER.setPkUserId(paramString);
    AppMethodBeat.o(196759);
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, x> paramm)
  {
    AppMethodBeat.i(196763);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.hER;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(196763);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, x> paramm)
  {
    this.hES = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(196753);
    p.h(paramTRTCVideoLayoutManager, "<set-?>");
    this.hER = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(196753);
  }
  
  public final void setSelfUserId(String paramString)
  {
    AppMethodBeat.i(196760);
    p.h(paramString, "userId");
    this.hER.setMySelfUserId(paramString);
    AppMethodBeat.o(196760);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(LivePreviewView paramLivePreviewView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(196751);
      int i = this.hEU.getRenderLayout().Z(paramString, this.hEW);
      this.hEU.getRenderLayout().qP(i);
      AppMethodBeat.o(196751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */