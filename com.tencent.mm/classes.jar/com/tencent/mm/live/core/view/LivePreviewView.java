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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function0;", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "cameraOrientationChanged", "orientation", "", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "Lkotlin/ParameterName;", "name", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "userId", "streamType", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshVideoView", "release", "remoteViewFullScreen", "value", "setPreviewMoveListener", "Lkotlin/Function2;", "", "xOffset", "yOffset", "setPreviewTouchListener", "plugin-core_release"})
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private long jPo;
  private LiveDebugView qOK;
  public TRTCVideoLayoutManager qUv;
  private d.g.a.a<y> qUw;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205842);
    this.TAG = "MicroMsg.LiveCore";
    this.jPo = -1L;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496346, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307834);
    k.g(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.qUv = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307539);
    k.g(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.qOK = ((LiveDebugView)paramContext);
    paramContext = g.afB();
    k.g(paramContext, "MMKernel.storage()");
    if (paramContext.afk().getInt(ae.a.LBD, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.qOK.setVisibility(0);
      paramContext = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.c(this.qOK);
      AppMethodBeat.o(205842);
      return;
    }
    this.qOK.setVisibility(8);
    paramContext = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.release();
    AppMethodBeat.o(205842);
  }
  
  private final SurfaceView getCameraView()
  {
    AppMethodBeat.i(205838);
    SurfaceView localSurfaceView = this.qUv.dRd();
    k.g(localSurfaceView, "renderLayout.allocCameraView()");
    AppMethodBeat.o(205838);
    return localSurfaceView;
  }
  
  public final void c(q<? super j, ? super Integer, ? super Integer, y> paramq)
  {
    AppMethodBeat.i(205839);
    k.h(paramq, "callback");
    paramq.d(new j(getCameraView().getHolder()), Integer.valueOf(this.qUv.getCameraViewWidth()), Integer.valueOf(this.qUv.getCameraViewHeight()));
    AppMethodBeat.o(205839);
  }
  
  public final TXCloudVideoView gO(String paramString, int paramInt)
  {
    AppMethodBeat.i(205835);
    paramString = this.qUv.gP(paramString, paramInt);
    AppMethodBeat.o(205835);
    return paramString;
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(205836);
    RelativeLayout localRelativeLayout = this.qUv.getCameraContentView();
    AppMethodBeat.o(205836);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.qUv;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205841);
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
      AppMethodBeat.o(205841);
      return bool;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label21;
      }
      this.jPo = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.jPo > 0L) && (System.currentTimeMillis() - this.jPo <= ViewConfiguration.getTapTimeout()))
        {
          ad.d(this.TAG, "preview action up");
          localObject = this.qUw;
          if (localObject != null) {
            ((d.g.a.a)localObject).invoke();
          }
        }
        this.jPo = -1L;
      }
    }
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, y> paramm)
  {
    AppMethodBeat.i(205840);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.qUv;
    if (paramm != null) {
      paramm = new a(paramm);
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.setGestureListener((b.a)paramm);
      AppMethodBeat.o(205840);
      return;
    }
  }
  
  public final void setPreviewTouchListener(d.g.a.a<y> parama)
  {
    this.qUw = parama;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(205834);
    k.h(paramTRTCVideoLayoutManager, "<set-?>");
    this.qUv = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(205834);
  }
  
  public final void w(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(205837);
    k.h(paramString, "userId");
    this.qUv.w(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(205837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */