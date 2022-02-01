package com.tencent.mm.live.core.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.a.d;
import com.tencent.mm.live.core.a.e;
import com.tencent.mm.live.core.debug.LiveDebugView;
import com.tencent.mm.live.core.debug.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "onViewCreated", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "", "onViewSizeChanged", "Lkotlin/Function2;", "", "w", "h", "previewTouchListener", "", "x", "y", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "surfaceHolderCallback", "com/tencent/mm/live/core/view/LivePreviewView$surfaceHolderCallback$1", "Lcom/tencent/mm/live/core/view/LivePreviewView$surfaceHolderCallback$1;", "bringToFront", "userId", "streamType", "cameraOrientationChanged", "orientation", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/TextureView;", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "halfRemoteAndCamera", "isRenderLayoutMakeLayoutReady", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshCameraView", "refreshVideoView", "relayoutAnchorPreview", "userIdList", "", "relayoutAnchorPreviewRoomPk", "anchorUserId", "micUserMap", "Ljava/util/HashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/HashMap;", "parentTopMargin", "relayoutVisitorPreview", "selfUserId", "relayoutVisitorPreviewRoomPk", "release", "remoteViewFullScreen", "value", "remoteViewPkScreen", "restoreFromHalfMode", "setPkUserId", "setPreviewMoveListener", "callback", "xOffset", "yOffset", "setPreviewTouchListener", "setSelfUserId", "setupSurface", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LivePreviewView
  extends RelativeLayout
{
  private final String TAG;
  private LiveDebugView mUz;
  private m<? super Integer, ? super Integer, ah> mWA;
  public TRTCVideoLayoutManager mWP;
  private m<? super Float, ? super Float, ah> mWQ;
  private long mWR;
  private kotlin.g.a.b<? super SurfaceTexture, ah> mWS;
  private LivePreviewView.a mWT;
  
  public LivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247597);
    this.TAG = "MicroMsg.LiveCore";
    this.mWR = -1L;
    this.mWT = new LivePreviewView.a(this);
    paramContext = LayoutInflater.from(paramContext).inflate(a.e.live_visitor_preview_view, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(a.d.render_view);
    s.s(paramAttributeSet, "parent.findViewById(R.id.render_view)");
    this.mWP = ((TRTCVideoLayoutManager)paramAttributeSet);
    paramContext = paramContext.findViewById(a.d.live_debug_view);
    s.s(paramContext, "parent.findViewById(R.id.live_debug_view)");
    this.mUz = ((LiveDebugView)paramContext);
    if (h.baE().ban().getInt(at.a.adfq, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.mUz.setVisibility(0);
      paramContext = a.mUy;
      a.a(this.mUz);
      AppMethodBeat.o(247597);
      return;
    }
    this.mUz.setVisibility(8);
    paramContext = a.mUy;
    a.release();
    AppMethodBeat.o(247597);
  }
  
  private static final void a(LivePreviewView paramLivePreviewView, String paramString, int paramInt)
  {
    AppMethodBeat.i(247616);
    s.u(paramLivePreviewView, "this$0");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = paramLivePreviewView.getRenderLayout();
    int i = 0;
    if (i < localTRTCVideoLayoutManager.mXo.size())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localTRTCVideoLayoutManager.mXo.get(i);
      if ((localb.mXw.mVideoView == null) || (!Util.isEqual(paramString, localb.userId)) || (localb.streamType != paramInt)) {}
    }
    for (;;)
    {
      paramLivePreviewView.getRenderLayout().tz(i);
      AppMethodBeat.o(247616);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static final void a(m paramm, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(247622);
    paramm.invoke(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    AppMethodBeat.o(247622);
  }
  
  private final TextureView getCameraView()
  {
    AppMethodBeat.i(247605);
    Object localObject = this.mWP;
    Iterator localIterator = ((TRTCVideoLayoutManager)localObject).mXo.iterator();
    TRTCVideoLayoutManager.b localb;
    while (localIterator.hasNext())
    {
      localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.mXw.mWV != null)
      {
        localb.userId = "";
        localb.streamType = 0;
        localb.mXw.setVisibility(0);
        ((TRTCVideoLayoutManager)localObject).mCount += 1;
        if ((((TRTCVideoLayoutManager)localObject).mMode == 2) && (((TRTCVideoLayoutManager)localObject).mCount == 5)) {
          ((TRTCVideoLayoutManager)localObject).bhc();
        }
        localb.mXw.Gh("");
      }
    }
    for (localObject = localb.mXw.mWV;; localObject = null)
    {
      s.s(localObject, "renderLayout.allocCameraView()");
      AppMethodBeat.o(247605);
      return localObject;
    }
  }
  
  public final void Gf(String paramString)
  {
    AppMethodBeat.i(247675);
    post(new LivePreviewView..ExternalSyntheticLambda1(this, paramString, 0));
    AppMethodBeat.o(247675);
  }
  
  public final void Gg(String paramString)
  {
    AppMethodBeat.i(247790);
    this.mWP.Gg(paramString);
    AppMethodBeat.o(247790);
  }
  
  public final void a(String paramString1, String paramString2, HashMap<String, Rect> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(247778);
    s.u(paramString1, "anchorUserId");
    s.u(paramString2, "selfUserId");
    s.u(paramHashMap, "micUserMap");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0) || (paramHashMap == null) || (paramHashMap.isEmpty()))
    {
      Log.w(TRTCVideoLayoutManager.TAG, "relayoutVisitorPreviewRoomPk return by invalid value!");
      AppMethodBeat.o(247778);
      return;
    }
    paramString1 = new ArrayList();
    Object localObject = paramHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString1.add((String)((Iterator)localObject).next());
    }
    localTRTCVideoLayoutManager.d(paramString2, paramString1);
    paramString1 = paramHashMap.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramHashMap = (Map.Entry)paramString1.next();
      localObject = (String)paramHashMap.getKey();
      paramHashMap = (Rect)paramHashMap.getValue();
      RelativeLayout.LayoutParams localLayoutParams;
      if (Util.isEqual((String)localObject, paramString2))
      {
        localObject = (b)localTRTCVideoLayoutManager.getCameraContentView();
        if ((localObject != null) && (((b)localObject).getLayoutParams() != null))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject).getLayoutParams();
          localLayoutParams.width = paramHashMap.width();
          localLayoutParams.height = paramHashMap.height();
          localLayoutParams.setMarginStart(paramHashMap.left);
          localLayoutParams.topMargin = (paramHashMap.top - paramInt);
          ((b)localObject).setLayoutParams(localLayoutParams);
          ((b)localObject).mXh = false;
          ((b)localObject).setOnClickListener(null);
          ((b)localObject).bringToFront();
        }
      }
      else
      {
        localObject = localTRTCVideoLayoutManager.Gi((String)localObject);
        if ((localObject != null) && (((TRTCVideoLayoutManager.b)localObject).mXw != null) && (((TRTCVideoLayoutManager.b)localObject).mXw.getLayoutParams() != null))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject).mXw.getLayoutParams();
          localLayoutParams.width = paramHashMap.width();
          localLayoutParams.height = paramHashMap.height();
          localLayoutParams.setMarginStart(paramHashMap.left);
          localLayoutParams.topMargin = (paramHashMap.top - paramInt);
          ((TRTCVideoLayoutManager.b)localObject).mXw.setLayoutParams(localLayoutParams);
          ((TRTCVideoLayoutManager.b)localObject).mXw.bringToFront();
        }
      }
    }
    localTRTCVideoLayoutManager.requestLayout();
    AppMethodBeat.o(247778);
  }
  
  public final void a(String paramString, HashMap<String, Rect> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(247725);
    s.u(paramString, "anchorUserId");
    s.u(paramHashMap, "micUserMap");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    if ((paramHashMap == null) || (paramHashMap.size() == 0))
    {
      Log.w(TRTCVideoLayoutManager.TAG, "relayoutAnchorPreviewRoomPk return by invalid value!");
      AppMethodBeat.o(247725);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add((String)((Iterator)localObject2).next());
    }
    localTRTCVideoLayoutManager.bE((List)localObject1);
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      localObject1 = (Map.Entry)paramHashMap.next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (Rect)((Map.Entry)localObject1).getValue();
      RelativeLayout.LayoutParams localLayoutParams;
      if (Util.isEqual((String)localObject2, paramString))
      {
        localObject2 = (b)localTRTCVideoLayoutManager.getCameraContentView();
        if ((localObject2 != null) && (((b)localObject2).getLayoutParams() != null))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).getLayoutParams();
          localLayoutParams.width = ((Rect)localObject1).width();
          localLayoutParams.height = ((Rect)localObject1).height();
          localLayoutParams.setMarginStart(((Rect)localObject1).left);
          localLayoutParams.topMargin = (((Rect)localObject1).top - paramInt);
          ((b)localObject2).setLayoutParams(localLayoutParams);
          ((b)localObject2).mXh = false;
          ((b)localObject2).setOnClickListener(null);
          ((b)localObject2).bringToFront();
        }
      }
      else
      {
        localObject2 = localTRTCVideoLayoutManager.Gi((String)localObject2);
        if ((localObject2 != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams() != null))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams();
          localLayoutParams.width = ((Rect)localObject1).width();
          localLayoutParams.height = ((Rect)localObject1).height();
          localLayoutParams.setMarginStart(((Rect)localObject1).left);
          localLayoutParams.topMargin = (((Rect)localObject1).top - paramInt);
          ((TRTCVideoLayoutManager.b)localObject2).mXw.setLayoutParams(localLayoutParams);
          ((TRTCVideoLayoutManager.b)localObject2).mXw.bringToFront();
        }
      }
    }
    localTRTCVideoLayoutManager.requestLayout();
    AppMethodBeat.o(247725);
  }
  
  public final void a(kotlin.g.a.b<? super SurfaceTexture, ah> paramb, m<? super Integer, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(247857);
    this.mWS = paramb;
    this.mWA = paramm;
    getCameraView().setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.mWT);
    Log.i(this.TAG, s.X("setupSurface ", this.mWT));
    AppMethodBeat.o(247857);
  }
  
  public final TXCloudVideoView az(String paramString, int paramInt)
  {
    AppMethodBeat.i(247787);
    paramString = this.mWP.aA(paramString, paramInt);
    AppMethodBeat.o(247787);
    return paramString;
  }
  
  public final void bD(List<String> paramList)
  {
    AppMethodBeat.i(247708);
    s.u(paramList, "userIdList");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    if (paramList.size() == 0)
    {
      Log.w(TRTCVideoLayoutManager.TAG, "relayoutAnchorPreview return by invalid value!");
      AppMethodBeat.o(247708);
      return;
    }
    localTRTCVideoLayoutManager.bE(paramList);
    switch (paramList.size())
    {
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.requestLayout();
      AppMethodBeat.o(247708);
      return;
      paramList = (b)localTRTCVideoLayoutManager.getCameraContentView();
      if ((paramList != null) && (paramList.getLayoutParams() != null))
      {
        Object localObject1 = (RelativeLayout.LayoutParams)paramList.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -1;
        ((RelativeLayout.LayoutParams)localObject1).height = -1;
        ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
        paramList.bringToFront();
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramList.mXh = false;
        paramList.setOnClickListener(null);
        int i = 0;
        while (i < localTRTCVideoLayoutManager.mXo.size())
        {
          paramList = (TRTCVideoLayoutManager.b)localTRTCVideoLayoutManager.mXo.get(i);
          if (paramList != null)
          {
            localObject1 = (RelativeLayout.LayoutParams)paramList.mXw.getLayoutParams();
            if (localObject1 != null)
            {
              ((RelativeLayout.LayoutParams)localObject1).width = -1;
              ((RelativeLayout.LayoutParams)localObject1).height = -1;
              ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
              ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
              paramList.mXw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
          i += 1;
        }
        paramList = (String)paramList.get(1);
        float f = c.bhe();
        Log.i(TRTCVideoLayoutManager.TAG, "cameraAndRemote userId:" + paramList + " ratio:" + f);
        if ((paramList == null) || (paramList.length() == 0))
        {
          Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by invalid value!");
        }
        else
        {
          localObject1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
          Object localObject2;
          if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
          {
            localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
            ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
            ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((b)localObject1).mXh = false;
            ((b)localObject1).setOnClickListener(null);
            ((b)localObject1).bringToFront();
          }
          paramList = localTRTCVideoLayoutManager.Gi(paramList);
          if ((paramList != null) && (paramList.mXw != null) && (paramList.mXw.getLayoutParams() != null))
          {
            localObject1 = (RelativeLayout.LayoutParams)paramList.mXw.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
            paramList.mXw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramList.mXw.mXh = false;
            paramList.mXw.setOnClickListener(null);
            paramList.mXw.bringToFront();
            continue;
            localObject1 = (String)paramList.get(1);
            f = c.bhe();
            Log.i(TRTCVideoLayoutManager.TAG, "cameraAnd2Remote userId1:" + (String)localObject1 + " ratio:" + f);
            if ((localObject1 == null) || (((String)localObject1).length() == 0))
            {
              Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
            }
            else
            {
              localObject2 = (b)localTRTCVideoLayoutManager.getCameraContentView();
              RelativeLayout.LayoutParams localLayoutParams;
              if ((localObject2 != null) && (((b)localObject2).getLayoutParams() != null))
              {
                localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).getLayoutParams();
                localLayoutParams.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                localLayoutParams.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f));
                localLayoutParams.setMarginStart(0);
                localLayoutParams.setMarginEnd(0);
                ((b)localObject2).setLayoutParams(localLayoutParams);
                ((b)localObject2).mXh = false;
                ((b)localObject2).setOnClickListener(null);
                ((b)localObject2).bringToFront();
              }
              localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
              if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
              {
                localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                ((RelativeLayout.LayoutParams)localObject2).setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
              }
              paramList = (String)paramList.get(2);
              Log.i(TRTCVideoLayoutManager.TAG, "cameraAnd2Remote userId2:".concat(String.valueOf(paramList)));
              if ((paramList == null) || (paramList.length() == 0))
              {
                Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
              }
              else
              {
                paramList = localTRTCVideoLayoutManager.Gi(paramList);
                if ((paramList != null) && (paramList.mXw != null) && (paramList.mXw.getLayoutParams() != null))
                {
                  localObject1 = (RelativeLayout.LayoutParams)paramList.mXw.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject1).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                  ((RelativeLayout.LayoutParams)localObject1).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                  ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                  ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
                  ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                  ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                  paramList.mXw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  paramList.mXw.mXh = false;
                  paramList.mXw.setOnClickListener(null);
                  paramList.mXw.bringToFront();
                  continue;
                  localObject1 = (String)paramList.get(1);
                  f = c.bhe();
                  Log.i(TRTCVideoLayoutManager.TAG, "cameraAnd3Remote userId1:" + (String)localObject1 + " ratio:" + f);
                  if ((localObject1 == null) || (((String)localObject1).length() == 0))
                  {
                    Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
                  }
                  else
                  {
                    localObject2 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                    if ((localObject2 != null) && (((b)localObject2).getLayoutParams() != null))
                    {
                      localLayoutParams = (RelativeLayout.LayoutParams)((b)localObject2).getLayoutParams();
                      localLayoutParams.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      localLayoutParams.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      localLayoutParams.setMarginStart(0);
                      localLayoutParams.setMarginEnd(0);
                      ((b)localObject2).setLayoutParams(localLayoutParams);
                      ((b)localObject2).mXh = false;
                      ((b)localObject2).setOnClickListener(null);
                      ((b)localObject2).bringToFront();
                    }
                    localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
                    if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
                    {
                      localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
                    }
                    for (;;)
                    {
                      localObject1 = (String)paramList.get(2);
                      Log.i(TRTCVideoLayoutManager.TAG, "cameraAnd3Remote userId2:".concat(String.valueOf(localObject1)));
                      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                        break label1604;
                      }
                      Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case3 return by userId2 invalid value!");
                      break;
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        aa.makeText(MMApplicationContext.getContext(), "pkEntity1 is nul", 0).show();
                      }
                      Log.e(TRTCVideoLayoutManager.TAG, "pkEntity1 is null");
                    }
                    label1604:
                    localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
                    if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
                    {
                      localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                      ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                      ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
                    }
                    for (;;)
                    {
                      paramList = (String)paramList.get(3);
                      Log.i(TRTCVideoLayoutManager.TAG, "cameraAnd3Remote userId3:".concat(String.valueOf(paramList)));
                      if ((paramList != null) && (paramList.length() != 0)) {
                        break label1863;
                      }
                      Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case4 return by userId3 invalid value!");
                      break;
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        aa.makeText(MMApplicationContext.getContext(), "pkEntity2 is nul", 0).show();
                      }
                      Log.e(TRTCVideoLayoutManager.TAG, "pkEntity2 is null");
                    }
                    label1863:
                    paramList = localTRTCVideoLayoutManager.Gi(paramList);
                    if ((paramList != null) && (paramList.mXw != null) && (paramList.mXw.getLayoutParams() != null))
                    {
                      localObject1 = (RelativeLayout.LayoutParams)paramList.mXw.getLayoutParams();
                      ((RelativeLayout.LayoutParams)localObject1).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                      ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
                      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
                      paramList.mXw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                      paramList.mXw.mXh = false;
                      paramList.mXw.setOnClickListener(null);
                      paramList.mXw.bringToFront();
                    }
                    else
                    {
                      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
                        aa.makeText(MMApplicationContext.getContext(), "pkEntity3 is nul", 0).show();
                      }
                      Log.e(TRTCVideoLayoutManager.TAG, "pkEntity3 is null");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void bgZ()
  {
    AppMethodBeat.i(247798);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    Iterator localIterator = localTRTCVideoLayoutManager.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if (localb.mXw.mWV != null)
      {
        if (localb.index == 0) {
          localTRTCVideoLayoutManager.tz(1);
        }
        localTRTCVideoLayoutManager.mCount -= 1;
        if ((localTRTCVideoLayoutManager.mMode == 2) && (localTRTCVideoLayoutManager.mCount == 4)) {
          localTRTCVideoLayoutManager.bhc();
        }
        b localb1 = localb.mXw;
        Context localContext = localTRTCVideoLayoutManager.getContext();
        int i = localTRTCVideoLayoutManager.getWidth();
        localTRTCVideoLayoutManager.getHeight();
        localb1.setLayoutParams(c.O(localContext, i));
        localb.mXw.setVisibility(8);
        localb.userId = "";
        localb.streamType = -1;
      }
    }
    AppMethodBeat.o(247798);
  }
  
  public final void bha()
  {
    AppMethodBeat.i(247808);
    Iterator localIterator = this.mWP.mXo.iterator();
    while (localIterator.hasNext())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localIterator.next();
      if ((localb.mXw.mWV != null) && (localb.mXw.getParent() != null) && ((localb.mXw.getParent() instanceof ViewGroup)))
      {
        ViewGroup localViewGroup = (ViewGroup)localb.mXw.getParent();
        localViewGroup.removeView(localb.mXw);
        localViewGroup.addView(localb.mXw);
      }
    }
    AppMethodBeat.o(247808);
  }
  
  public final void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(247831);
    s.u(paramString, "userId");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    int i = 1;
    if (i < localTRTCVideoLayoutManager.mXo.size())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localTRTCVideoLayoutManager.mXo.get(i);
      if ((localb.mXw != null) && (Util.isEqual(localb.userId, paramString)) && (localb.streamType == paramInt2))
      {
        if (paramInt1 != 1) {
          break label118;
        }
        localb.mXw.setLayoutParams(c.N(localTRTCVideoLayoutManager.getContext(), localTRTCVideoLayoutManager.getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label118:
        if (paramInt1 == 2) {
          localb.mXw.setLayoutParams(c.M(localTRTCVideoLayoutManager.getContext(), localTRTCVideoLayoutManager.getWidth()));
        }
      }
    }
    AppMethodBeat.o(247831);
  }
  
  public final void c(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(247768);
    s.u(paramString1, "anchorUserId");
    s.u(paramString2, "selfUserId");
    s.u(paramList, "userIdList");
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0) || (paramList.isEmpty()))
    {
      Log.w(TRTCVideoLayoutManager.TAG, "relayoutVisitorPreview return by invalid value!");
      AppMethodBeat.o(247768);
      return;
    }
    localTRTCVideoLayoutManager.d(paramString2, paramList);
    switch (paramList.size())
    {
    }
    for (;;)
    {
      localTRTCVideoLayoutManager.requestLayout();
      AppMethodBeat.o(247768);
      return;
      Log.i(TRTCVideoLayoutManager.TAG, "relayoutVisitorPreview only anchor view");
      paramString1 = localTRTCVideoLayoutManager.Gi(paramString1);
      if ((paramString1 != null) && (paramString1.mXw != null) && (paramString1.mXw.getLayoutParams() != null))
      {
        paramString2 = (RelativeLayout.LayoutParams)paramString1.mXw.getLayoutParams();
        paramString2.width = bf.bf(localTRTCVideoLayoutManager.getContext()).x;
        paramString2.height = bf.bf(localTRTCVideoLayoutManager.getContext()).y;
        paramString2.setMarginStart(0);
        paramString2.setMarginEnd(0);
        paramString1.mXw.setLayoutParams(paramString2);
        paramString1.mXw.bringToFront();
        continue;
        paramList = (String)paramList.get(1);
        float f = c.bhe();
        Log.i(TRTCVideoLayoutManager.TAG, "remoteAndCamera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId:" + paramList + " ratio:" + f);
        if ((paramList == null) || (paramList.length() == 0))
        {
          Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by invalid value!");
        }
        else
        {
          paramString1 = localTRTCVideoLayoutManager.Gi(paramString1);
          Object localObject1;
          if ((paramString1 != null) && (paramString1.mXw != null) && (paramString1.mXw.getLayoutParams() != null))
          {
            localObject1 = (RelativeLayout.LayoutParams)paramString1.mXw.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
            ((RelativeLayout.LayoutParams)localObject1).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f));
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
            ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
            paramString1.mXw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramString1.mXw.bringToFront();
          }
          if (Util.isEqual(paramString2, paramList))
          {
            paramString1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
            if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
            {
              paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
              paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
              paramString2.height = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)));
              paramString2.topMargin = 0;
              paramString2.bottomMargin = 0;
              paramString2.setMarginStart(paramString2.width);
              paramString2.setMarginEnd(0);
              paramString1.setLayoutParams(paramString2);
              paramString1.mXh = false;
              paramString1.setOnClickListener(null);
              paramString1.bringToFront();
            }
          }
          else
          {
            paramString1 = localTRTCVideoLayoutManager.Gi(paramList);
            if ((paramString1 != null) && (paramString1.mXw != null) && (paramString1.mXw.getLayoutParams() != null))
            {
              paramString2 = (RelativeLayout.LayoutParams)paramString1.mXw.getLayoutParams();
              paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
              paramString2.height = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)));
              paramString2.topMargin = 0;
              paramString2.bottomMargin = 0;
              paramString2.setMarginStart(paramString2.width);
              paramString2.setMarginEnd(0);
              paramString1.mXw.setLayoutParams(paramString2);
              paramString1.mXw.mXh = false;
              paramString1.mXw.setOnClickListener(null);
              paramString1.mXw.bringToFront();
              continue;
              localObject1 = (String)paramList.get(1);
              f = c.bhe();
              Log.i(TRTCVideoLayoutManager.TAG, "remoteAnd2Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId1:" + (String)localObject1 + " ratio:" + f);
              if ((localObject1 == null) || (((String)localObject1).length() == 0))
              {
                Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
              }
              else
              {
                Object localObject2 = localTRTCVideoLayoutManager.Gi(paramString1);
                RelativeLayout.LayoutParams localLayoutParams;
                if ((localObject2 != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams() != null))
                {
                  localLayoutParams = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams();
                  localLayoutParams.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                  localLayoutParams.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f));
                  localLayoutParams.setMarginStart(0);
                  localLayoutParams.setMarginEnd(0);
                  localLayoutParams.topMargin = 0;
                  localLayoutParams.bottomMargin = 0;
                  ((TRTCVideoLayoutManager.b)localObject2).mXw.setLayoutParams(localLayoutParams);
                  ((TRTCVideoLayoutManager.b)localObject2).mXw.bringToFront();
                }
                if (Util.isEqual(paramString2, (String)localObject1))
                {
                  localObject1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                  if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                  {
                    localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                    ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                    ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                    ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                    ((b)localObject1).mXh = false;
                    ((b)localObject1).setOnClickListener(null);
                    ((b)localObject1).bringToFront();
                  }
                }
                for (;;)
                {
                  paramList = (String)paramList.get(2);
                  Log.i(TRTCVideoLayoutManager.TAG, "remoteAnd2Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId2:" + paramList);
                  if ((paramList != null) && (paramList.length() != 0)) {
                    break label1306;
                  }
                  Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                  break;
                  localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
                  if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
                  {
                    localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                    ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                    ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                    ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                    ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                    ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                    ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                    ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
                  }
                }
                label1306:
                if (Util.isEqual(paramString2, paramList))
                {
                  paramString1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                  if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
                  {
                    paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
                    paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                    paramString2.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                    paramString2.topMargin = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)) / 2);
                    paramString2.bottomMargin = 0;
                    paramString2.setMarginStart(paramString2.width);
                    paramString2.setMarginEnd(0);
                    paramString1.setLayoutParams(paramString2);
                    paramString1.mXh = false;
                    paramString1.setOnClickListener(null);
                    paramString1.bringToFront();
                  }
                }
                else
                {
                  paramString1 = localTRTCVideoLayoutManager.Gi(paramList);
                  if ((paramString1 != null) && (paramString1.mXw != null) && (paramString1.mXw.getLayoutParams() != null))
                  {
                    paramString2 = (RelativeLayout.LayoutParams)paramString1.mXw.getLayoutParams();
                    paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                    paramString2.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                    paramString2.topMargin = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)) / 2);
                    paramString2.bottomMargin = 0;
                    paramString2.setMarginStart(paramString2.width);
                    paramString2.setMarginEnd(0);
                    paramString1.mXw.setLayoutParams(paramString2);
                    paramString1.mXw.mXh = false;
                    paramString1.mXw.setOnClickListener(null);
                    paramString1.mXw.bringToFront();
                    continue;
                    localObject1 = (String)paramList.get(1);
                    f = c.bhe();
                    Log.i(TRTCVideoLayoutManager.TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId1:" + (String)localObject1 + " ratio:" + f);
                    if ((localObject1 == null) || (((String)localObject1).length() == 0))
                    {
                      Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
                    }
                    else
                    {
                      localObject2 = localTRTCVideoLayoutManager.Gi(paramString1);
                      if ((localObject2 != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw != null) && (((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams() != null))
                      {
                        localLayoutParams = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject2).mXw.getLayoutParams();
                        localLayoutParams.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                        localLayoutParams.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                        localLayoutParams.setMarginStart(0);
                        localLayoutParams.setMarginEnd(0);
                        localLayoutParams.topMargin = 0;
                        localLayoutParams.bottomMargin = 0;
                        ((TRTCVideoLayoutManager.b)localObject2).mXw.setLayoutParams(localLayoutParams);
                        ((TRTCVideoLayoutManager.b)localObject2).mXw.bringToFront();
                      }
                      if (Util.isEqual(paramString2, (String)localObject1))
                      {
                        localObject1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                        if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).mXh = false;
                          ((b)localObject1).setOnClickListener(null);
                          ((b)localObject1).bringToFront();
                        }
                      }
                      for (;;)
                      {
                        localObject1 = (String)paramList.get(2);
                        Log.i(TRTCVideoLayoutManager.TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId2:" + (String)localObject1);
                        if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                          break label2204;
                        }
                        Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                        localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
                        if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(((RelativeLayout.LayoutParams)localObject2).width);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
                        }
                      }
                      label2204:
                      if (Util.isEqual(paramString2, (String)localObject1))
                      {
                        localObject1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                        if ((localObject1 != null) && (((b)localObject1).getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((b)localObject1).getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((b)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((b)localObject1).mXh = false;
                          ((b)localObject1).setOnClickListener(null);
                          ((b)localObject1).bringToFront();
                        }
                      }
                      for (;;)
                      {
                        paramList = (String)paramList.get(3);
                        Log.i(TRTCVideoLayoutManager.TAG, "remoteAnd3Camera anchorUserId:" + paramString1 + " selfId:" + paramString2 + " userId3:" + paramList);
                        if ((paramList != null) && (paramList.length() != 0)) {
                          break label2604;
                        }
                        Log.w(TRTCVideoLayoutManager.TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                        localObject1 = localTRTCVideoLayoutManager.Gi((String)localObject1);
                        if ((localObject1 != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw != null) && (((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams() != null))
                        {
                          localObject2 = (RelativeLayout.LayoutParams)((TRTCVideoLayoutManager.b)localObject1).mXw.getLayoutParams();
                          ((RelativeLayout.LayoutParams)localObject2).width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          ((RelativeLayout.LayoutParams)localObject2).height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
                          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(0);
                          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(0);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.mXh = false;
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.setOnClickListener(null);
                          ((TRTCVideoLayoutManager.b)localObject1).mXw.bringToFront();
                        }
                      }
                      label2604:
                      if (Util.isEqual(paramString2, paramList))
                      {
                        paramString1 = (b)localTRTCVideoLayoutManager.getCameraContentView();
                        if ((paramString1 != null) && (paramString1.getLayoutParams() != null))
                        {
                          paramString2 = (RelativeLayout.LayoutParams)paramString1.getLayoutParams();
                          paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          paramString2.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          paramString2.topMargin = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)) / 2);
                          paramString2.bottomMargin = 0;
                          paramString2.setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          paramString2.setMarginEnd(0);
                          paramString1.setLayoutParams(paramString2);
                          paramString1.mXh = false;
                          paramString1.setOnClickListener(null);
                          paramString1.bringToFront();
                        }
                      }
                      else
                      {
                        paramString1 = localTRTCVideoLayoutManager.Gi(paramList);
                        if ((paramString1 != null) && (paramString1.mXw != null) && (paramString1.mXw.getLayoutParams() != null))
                        {
                          paramString2 = (RelativeLayout.LayoutParams)paramString1.mXw.getLayoutParams();
                          paramString2.width = (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          paramString2.height = ((int)(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2 * f) / 2);
                          paramString2.topMargin = ((int)(f * (bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2)) / 2);
                          paramString2.bottomMargin = 0;
                          paramString2.setMarginStart(bf.bf(localTRTCVideoLayoutManager.getContext()).x / 2);
                          paramString2.setMarginEnd(0);
                          paramString1.mXw.setLayoutParams(paramString2);
                          paramString1.mXw.mXh = false;
                          paramString1.mXw.setOnClickListener(null);
                          paramString1.mXw.bringToFront();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final RelativeLayout getCameraRootView()
  {
    AppMethodBeat.i(247814);
    RelativeLayout localRelativeLayout = this.mWP.getCameraContentView();
    AppMethodBeat.o(247814);
    return localRelativeLayout;
  }
  
  public final TRTCVideoLayoutManager getRenderLayout()
  {
    return this.mWP;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247878);
    Object localObject;
    if (paramMotionEvent == null)
    {
      localObject = null;
      if (localObject != null) {
        break label45;
      }
      label16:
      if (localObject != null) {
        break label62;
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(247878);
      return bool;
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      break;
      label45:
      if (((Integer)localObject).intValue() != 0) {
        break label16;
      }
      this.mWR = System.currentTimeMillis();
      continue;
      label62:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.mWR > 0L) && (System.currentTimeMillis() - this.mWR <= ViewConfiguration.getTapTimeout()))
        {
          Log.d(this.TAG, "preview action up");
          localObject = this.mWQ;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.mWR = -1L;
      }
    }
  }
  
  public final void setPkUserId(String paramString)
  {
    AppMethodBeat.i(247840);
    s.u(paramString, "userId");
    this.mWP.setPkUserId(paramString);
    AppMethodBeat.o(247840);
  }
  
  public final void setPreviewMoveListener(m<? super Float, ? super Float, ah> paramm)
  {
    AppMethodBeat.i(247870);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    if (paramm == null) {}
    for (paramm = null;; paramm = new LivePreviewView..ExternalSyntheticLambda0(paramm))
    {
      localTRTCVideoLayoutManager.setGestureListener(paramm);
      AppMethodBeat.o(247870);
      return;
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, ah> paramm)
  {
    this.mWQ = paramm;
  }
  
  public final void setRenderLayout(TRTCVideoLayoutManager paramTRTCVideoLayoutManager)
  {
    AppMethodBeat.i(247665);
    s.u(paramTRTCVideoLayoutManager, "<set-?>");
    this.mWP = paramTRTCVideoLayoutManager;
    AppMethodBeat.o(247665);
  }
  
  public final void setSelfUserId(String paramString)
  {
    AppMethodBeat.i(247849);
    s.u(paramString, "userId");
    this.mWP.setMySelfUserId(paramString);
    AppMethodBeat.o(247849);
  }
  
  public final void ty(int paramInt)
  {
    AppMethodBeat.i(247823);
    TRTCVideoLayoutManager localTRTCVideoLayoutManager = this.mWP;
    int i = 1;
    if (i < localTRTCVideoLayoutManager.mXo.size())
    {
      TRTCVideoLayoutManager.b localb = (TRTCVideoLayoutManager.b)localTRTCVideoLayoutManager.mXo.get(i);
      if ((localb.mXw != null) && (localb.mXw.mWV != null))
      {
        if (paramInt != 1) {
          break label91;
        }
        localb.mXw.setLayoutParams(c.N(localTRTCVideoLayoutManager.getContext(), localTRTCVideoLayoutManager.getWidth()));
      }
      for (;;)
      {
        i += 1;
        break;
        label91:
        if (paramInt == 2) {
          localb.mXw.setLayoutParams(c.M(localTRTCVideoLayoutManager.getContext(), localTRTCVideoLayoutManager.getWidth()));
        }
      }
    }
    AppMethodBeat.o(247823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LivePreviewView
 * JD-Core Version:    0.7.0.1
 */