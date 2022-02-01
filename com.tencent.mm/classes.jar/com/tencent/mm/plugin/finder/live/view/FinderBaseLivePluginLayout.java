package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.v;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.plugin.d.c;
import com.tencent.mm.plugin.finder.live.util.w;
import com.tencent.mm.plugin.finder.live.widget.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/IFinderLivePluginLayout;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "FADE_OUT_DURATION", "", "TAG", "", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "blurBgView", "Landroid/widget/ImageView;", "checkMiniWin", "", "getCheckMiniWin", "()Z", "setCheckMiniWin", "(Z)V", "curNetworkQuality", "", "getCurNetworkQuality", "()I", "setCurNetworkQuality", "(I)V", "curNetworkType", "getCurNetworkType", "setCurNetworkType", "currentAppId", "getCurrentAppId", "()Ljava/lang/String;", "setCurrentAppId", "(Ljava/lang/String;)V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "isCurLive", "setCurLive", "isManualClosed", "setManualClosed", "lastLiveState", "getLastLiveState", "setLastLiveState", "lastOrientation", "getLastOrientation", "setLastOrientation", "lastRotationFromSensor", "getLastRotationFromSensor", "setLastRotationFromSensor", "lastUIState", "getLastUIState", "setLastUIState", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "miniWinPermission", "getMiniWinPermission", "setMiniWinPermission", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "getOrientationEventListener", "()Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "setOrientationEventListener", "(Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;)V", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "progressView", "Landroid/view/View;", "statisticsWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "getStatisticsWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "setStatisticsWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;)V", "tipView", "Landroid/widget/TextView;", "activate", "", "config", "isFinished", "isFromFloat", "curIndex", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "disableRatation", "enableRotation", "fillBlurBg", "username", "finish", "forceScreenToLandscape", "forceScreenToPortrait", "getPlugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "hideLoadingLayer", "hideStatistics", "initLogic", "Lcom/tencent/mm/live/api/LiveConfig;", "isDestroyed", "isLiveFinished", "isLiveStarted", "isSwipeBack", "mount", "needMiniWindow", "needRemoveActivity", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAnchorConnectionChange", "anchorConnectionChange", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onFinderLiveAcceptLiveMic", "Lcom/tencent/mm/live/model/FinderLiveAcceptLiveMicInfo;", "onFinderLiveApplyLiveMic", "Lcom/tencent/mm/live/model/FinderLiveApplyLiveMicInfo;", "onFinderLiveCloseLiveMic", "Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "onLandscapeAction", "onLandscapeActionImpl", "onLiveEventCallback", "errorCode", "param", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onNewIntent", "intent", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onOrientationChange", "orientation", "onPortraitAction", "onPortraitActionImpl", "onScreenClear", "clear", "release", "reset", "resume", "showAlertDialog", "activity", "Landroid/app/Activity;", "title", "content", "buttonTitle", "showAlertInfo", "showBlurBg", "showCDNStatistics", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "showCenterCustomizeToast", "msg", "res", "showDebugToast", "showProgress", "showProgressWithBlurBg", "showStatistics", "showTipWithBlurBg", "tip", "showToast", "showTrtcStatistics", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "unMount", "plugin-finder_release"})
public abstract class FinderBaseLivePluginLayout
  extends BaseLivePluginLayout
  implements com.tencent.mm.plugin.mmsight.model.d.a
{
  private final long FADE_OUT_DURATION = 300L;
  private final String TAG = "Finder.FinderBaseLivePluginLayout";
  private HashMap _$_findViewCache;
  private byte _hellAccFlag_;
  private com.tencent.mm.ui.widget.a.d alertDialog;
  private final ImageView blurBgView;
  private boolean checkMiniWin;
  private int curNetworkQuality;
  private int curNetworkType;
  private String currentAppId = "";
  public com.tencent.mm.plugin.finder.live.viewmodel.c data;
  private boolean isCurLive;
  private boolean isManualClosed;
  private int lastLiveState;
  private int lastOrientation;
  private int lastRotationFromSensor;
  private int lastUIState;
  public com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
  private boolean miniWinPermission;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private final PhoneStateListener phoneStatelistener;
  private final View progressView;
  private m statisticsWidget;
  private final TextView tipView;
  
  public FinderBaseLivePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = e.h.hya;
    this.curNetworkQuality = e.h.aCT();
    this.curNetworkType = -1;
    this.lastRotationFromSensor = -1;
    this.lastOrientation = -1;
    this.lastLiveState = -1;
    this.lastUIState = -1;
    this.phoneStatelistener = ((PhoneStateListener)new d(this));
    paramContext = findViewById(2131303429);
    p.g(paramContext, "findViewById(R.id.live_loading_blur)");
    this.blurBgView = ((ImageView)paramContext);
    paramContext = findViewById(2131303428);
    p.g(paramContext, "findViewById(R.id.live_loading_bar)");
    this.progressView = paramContext;
    paramContext = findViewById(2131305271);
    p.g(paramContext, "findViewById(R.id.network_error_tip)");
    this.tipView = ((TextView)paramContext);
  }
  
  private final void showStatistics(com.tencent.mm.live.core.core.b.c paramc)
  {
    if (paramc != null)
    {
      int i = paramc.mode;
      e.a locala = e.a.hxc;
      if (i == e.a.aCf())
      {
        showCDNStatistics(paramc);
        return;
      }
    }
    showTrtcStatistics(paramc);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void activate(com.tencent.mm.plugin.finder.live.viewmodel.c paramc, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    p.h(paramc, "config");
    this.checkMiniWin = false;
  }
  
  public void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramBundle = ((Iterable)getPluginList()).iterator();
    while (paramBundle.hasNext()) {
      ((com.tencent.mm.live.c.a)paramBundle.next()).rf(paramInt2);
    }
  }
  
  public void bindData(com.tencent.mm.plugin.finder.live.viewmodel.c paramc, com.tencent.mm.plugin.finder.live.viewmodel.g paramg, boolean paramBoolean)
  {
    boolean bool2 = false;
    p.h(paramc, "data");
    p.h(paramg, "liveData");
    Log.i(this.TAG, "bind view:" + this + "  data:" + paramg);
    this.data = paramc;
    this.liveData = paramg;
    paramc = this.liveData;
    if (paramc == null) {
      p.btv("liveData");
    }
    paramg = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dwF().value()).intValue() == 1)
    {
      bool1 = true;
      paramc.uEV = bool1;
      paramg = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dwG().value()).intValue() != 1) {
        break label179;
      }
    }
    label179:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramc.uEW = bool1;
      paramg = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.dvm())
      {
        paramg = com.tencent.mm.plugin.finder.utils.y.vXH;
        bool1 = bool2;
        if (!com.tencent.mm.plugin.finder.utils.y.dCM()) {}
      }
      else
      {
        bool1 = true;
      }
      paramc.uEe = bool1;
      this.isCurLive = paramBoolean;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void disableRatation()
  {
    Log.i(this.TAG, "disableOritation");
    com.tencent.mm.plugin.mmsight.model.d locald = this.orientationEventListener;
    if (locald != null) {
      locald.disable();
    }
    locald = this.orientationEventListener;
    if (locald != null) {
      locald.a(null);
    }
    this.orientationEventListener = null;
  }
  
  public final void enableRotation()
  {
    Log.i(this.TAG, "enableOritation");
    Object localObject = this.liveData;
    if (localObject == null) {
      p.btv("liveData");
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).djm())
    {
      localObject = this.liveData;
      if (localObject == null) {
        p.btv("liveData");
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEv)
      {
        localObject = getFinderLiveAssistant();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.model.s)localObject).dfn();
        }
      }
      if (this.orientationEventListener == null) {
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
      }
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).a((com.tencent.mm.plugin.mmsight.model.d.a)this);
      }
      localObject = this.orientationEventListener;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mmsight.model.d)localObject).enable();
      }
    }
  }
  
  public final void fillBlurBg(final String paramString)
  {
    Object localObject = com.tencent.mm.plugin.finder.live.util.g.uwd;
    localObject = this.liveData;
    if (localObject == null) {
      p.btv("liveData");
    }
    com.tencent.mm.plugin.finder.live.util.g.a(paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEu, (View)this.blurBgView, (kotlin.g.a.b)new a(this, paramString));
  }
  
  public void finish()
  {
    if ((getContext() instanceof MMFinderUI))
    {
      this.isManualClosed = true;
      Context localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
      }
      ((MMFinderUI)localContext).finish();
    }
  }
  
  public final void forceScreenToLandscape()
  {
    disableRatation();
    Object localObject = getFinderLiveAssistant();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.model.s)localObject).dfp());; localObject = null)
    {
      if (p.j(localObject, Boolean.TRUE))
      {
        localObject = this.liveData;
        if (localObject == null) {
          p.btv("liveData");
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEv = true;
        localObject = this.liveData;
        if (localObject == null) {
          p.btv("liveData");
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDS = false;
      }
      return;
    }
  }
  
  public final void forceScreenToPortrait()
  {
    disableRatation();
    Object localObject = getFinderLiveAssistant();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.model.s)localObject).dfo());; localObject = null)
    {
      if (p.j(localObject, Boolean.TRUE))
      {
        localObject = this.liveData;
        if (localObject == null) {
          p.btv("liveData");
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uEv = true;
        localObject = this.liveData;
        if (localObject == null) {
          p.btv("liveData");
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDS = false;
      }
      return;
    }
  }
  
  protected final boolean getCheckMiniWin()
  {
    return this.checkMiniWin;
  }
  
  public final int getCurNetworkQuality()
  {
    return this.curNetworkQuality;
  }
  
  public final int getCurNetworkType()
  {
    return this.curNetworkType;
  }
  
  public final String getCurrentAppId()
  {
    return this.currentAppId;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.c getData()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.c localc = this.data;
    if (localc == null) {
      p.btv("data");
    }
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.s getFinderLiveAssistant()
  {
    o localo = o.ujN;
    return o.getFinderLiveAssistant();
  }
  
  protected final int getLastLiveState()
  {
    return this.lastLiveState;
  }
  
  public final int getLastOrientation()
  {
    return this.lastOrientation;
  }
  
  public final int getLastRotationFromSensor()
  {
    return this.lastRotationFromSensor;
  }
  
  protected final int getLastUIState()
  {
    return this.lastUIState;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    return localg;
  }
  
  protected final boolean getMiniWinPermission()
  {
    return this.miniWinPermission;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.d getOrientationEventListener()
  {
    return this.orientationEventListener;
  }
  
  public final ArrayList<com.tencent.mm.live.c.a> getPlugins()
  {
    return getPluginList();
  }
  
  public final m getStatisticsWidget()
  {
    return this.statisticsWidget;
  }
  
  public final void hideLoadingLayer()
  {
    Log.printInfoStack(this.TAG, "hideLoading", new Object[0]);
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new c(this));
    localValueAnimator.start();
  }
  
  public final void hideStatistics()
  {
    m localm = this.statisticsWidget;
    if (localm != null) {
      localm.uHs.setVisibility(8);
    }
  }
  
  public void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    p.h(paramLiveConfig, "config");
  }
  
  protected final boolean isCurLive()
  {
    return this.isCurLive;
  }
  
  public final boolean isDestroyed()
  {
    if ((getContext() != null) && ((getContext() instanceof Activity)))
    {
      Context localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type android.app.Activity");
      }
      return ((Activity)localContext).isDestroyed();
    }
    return false;
  }
  
  public final boolean isLiveFinished()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    return localg.djl();
  }
  
  public final boolean isLiveStarted()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    return localg.isLiveStarted();
  }
  
  protected final boolean isManualClosed()
  {
    return this.isManualClosed;
  }
  
  public boolean isSwipeBack()
  {
    Context localContext;
    if ((getContext() instanceof FinderLiveVisitor))
    {
      localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor");
      }
      return ((FinderLiveVisitor)localContext).ubn;
    }
    if ((getContext() instanceof FinderLiveAnchorUI))
    {
      localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI");
      }
      return ((FinderLiveAnchorUI)localContext).ubn;
    }
    if ((getContext() instanceof FinderLiveAnchorWithoutAffinityUI))
    {
      localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI");
      }
      return ((FinderLiveAnchorWithoutAffinityUI)localContext).ubn;
    }
    if ((getContext() instanceof FinderLiveVisitorWithoutAffinityUI))
    {
      localContext = getContext();
      if (localContext == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI");
      }
      return ((FinderLiveVisitorWithoutAffinityUI)localContext).ubn;
    }
    return false;
  }
  
  public void mount()
  {
    super.mount();
    Object localObject1 = getContext().getSystemService("phone");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }
    localObject1 = (TelephonyManager)localObject1;
    Object localObject2 = this.phoneStatelistener;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "mount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "mount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    localObject1 = com.tencent.mm.live.b.s.hIl;
    com.tencent.mm.live.b.s.a((j)this);
  }
  
  public final boolean needMiniWindow()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    return localg.uDS;
  }
  
  public final boolean needRemoveActivity()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    return localg.uDT;
  }
  
  public void onAcceptLiveMic(com.tencent.mm.live.b.a parama)
  {
    p.h(parama, "info");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(this.TAG, "onActivityResult,requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
  }
  
  public void onAnchorConnectionChange(boolean paramBoolean)
  {
    com.tencent.mm.plugin.finder.live.model.q localq = com.tencent.mm.plugin.finder.live.model.q.ukd;
    com.tencent.mm.plugin.finder.live.model.q.no(paramBoolean);
  }
  
  public void onApplyLiveMic(com.tencent.mm.live.b.b paramb)
  {
    p.h(paramb, "info");
  }
  
  public void onBanLiveComment(com.tencent.mm.live.b.c paramc)
  {
    p.h(paramc, "info");
  }
  
  public void onCloseApplyLiveMic(com.tencent.mm.live.b.d paramd)
  {
    p.h(paramd, "info");
  }
  
  public void onCloseLive(com.tencent.mm.live.b.e parame)
  {
    p.h(parame, "info");
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    if (localg.liveInfo.liveId == parame.liveId)
    {
      parame = com.tencent.mm.plugin.finder.live.model.q.ukd;
      com.tencent.mm.plugin.finder.live.model.q.dgA();
    }
  }
  
  public void onCloseLiveMic(f paramf)
  {
    p.h(paramf, "info");
  }
  
  public void onFinderLiveAcceptLiveMic(com.tencent.mm.live.b.g paramg)
  {
    p.h(paramg, "info");
    long l1 = paramg.liveId;
    long l2 = paramg.hFK;
    Object localObject2 = paramg.hFL;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramg.hFN;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramg.hFM;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject5 = paramg.hFO;
    localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    int i = paramg.scene;
    int j = paramg.businessType;
    localObject5 = paramg.hFP;
    paramg = (com.tencent.mm.live.b.g)localObject5;
    if (localObject5 == null) {
      paramg = "";
    }
    localObject5 = this.liveData;
    if (localObject5 == null) {
      p.btv("liveData");
    }
    localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject5).uDE;
    if (localObject5 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject5).liveId = l1;
    }
    localObject5 = this.liveData;
    if (localObject5 == null) {
      p.btv("liveData");
    }
    localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject5).uDE;
    if (localObject5 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject5).hFK = l2;
    }
    localObject5 = this.liveData;
    if (localObject5 == null) {
      p.btv("liveData");
    }
    localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject5).uDE;
    if (localObject5 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject5).uCo = ((String)localObject1);
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).finderUsername = ((String)localObject2);
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).uCn = ((String)localObject3);
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).hFO = ((String)localObject4);
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).scene = i;
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).businessType = j;
    }
    localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject1).uCp = paramg;
    }
    paramg = com.tencent.mm.plugin.finder.live.model.q.ukd;
    com.tencent.mm.plugin.finder.live.model.q.dgy();
  }
  
  public void onFinderLiveApplyLiveMic(com.tencent.mm.live.b.h paramh)
  {
    p.h(paramh, "info");
    long l1 = paramh.liveId;
    long l2 = paramh.hFK;
    Object localObject2 = paramh.hFQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = paramh.hFR;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = paramh.hFS;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    Object localObject5 = paramh.hFO;
    localObject4 = localObject5;
    if (localObject5 == null) {
      localObject4 = "";
    }
    int j = paramh.scene;
    int k = paramh.businessType;
    Object localObject6 = paramh.hFT;
    localObject5 = localObject6;
    if (localObject6 == null) {
      localObject5 = "";
    }
    localObject6 = paramh.hFU;
    paramh = (com.tencent.mm.live.b.h)localObject6;
    if (localObject6 == null) {
      paramh = "";
    }
    int i = 1;
    localObject6 = this.liveData;
    if (localObject6 == null) {
      p.btv("liveData");
    }
    localObject6 = ((Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject6).uDF).iterator();
    while (((Iterator)localObject6).hasNext()) {
      if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.b)((Iterator)localObject6).next()).finderUsername, (String)localObject3)) {
        i = 0;
      }
    }
    if (i != 0)
    {
      localObject6 = this.liveData;
      if (localObject6 == null) {
        p.btv("liveData");
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject6).uDG.add(localObject1);
      localObject6 = this.liveData;
      if (localObject6 == null) {
        p.btv("liveData");
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject6).uDF.add(new com.tencent.mm.plugin.finder.live.viewmodel.b(l1, l2, (String)localObject4, (String)localObject3, (String)localObject2, (String)localObject1, j, k, null, paramh, (String)localObject5, 256));
      paramh = com.tencent.mm.plugin.finder.live.model.q.ukd;
      com.tencent.mm.plugin.finder.live.model.q.dgx();
    }
  }
  
  public void onFinderLiveCloseLiveMic(com.tencent.mm.live.b.i parami)
  {
    p.h(parami, "info");
    Object localObject = this.liveData;
    if (localObject == null) {
      p.btv("liveData");
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDE = null;
    localObject = this.liveData;
    if (localObject == null) {
      p.btv("liveData");
    }
    Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDF).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.b)localObject).hFO, parami.hFO));
    for (parami = (com.tencent.mm.live.b.i)localObject;; parami = null)
    {
      parami = (com.tencent.mm.plugin.finder.live.viewmodel.b)parami;
      if (parami == null) {
        break label182;
      }
      localObject = this.liveData;
      if (localObject == null) {
        p.btv("liveData");
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDF.remove(parami);
      localObject = this.liveData;
      if (localObject == null) {
        p.btv("liveData");
      }
      localObject = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDG;
      parami = parami.uCo;
      if (localObject != null) {
        break;
      }
      throw new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
    af.eV(localObject).remove(parami);
    label182:
    parami = com.tencent.mm.plugin.finder.live.model.q.ukd;
    com.tencent.mm.plugin.finder.live.model.q.dgz();
  }
  
  public final void onLandscapeAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (!isLandscape())
    {
      forceScreenToLandscape();
      return;
    }
    onLandscapeActionImpl(paramInt1, paramInt2, paramBundle);
  }
  
  public final void onLandscapeActionImpl(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramInt1 = 0;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle.uEv = false;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle.uDS = true;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle = paramBundle.uEh;
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("POST_LANDSCAPE_ACTION_DELAY") != true) {
        break label313;
      }
      paramBundle = this.liveData;
      if (paramBundle == null) {
        p.btv("liveData");
      }
      paramBundle = paramBundle.uEh;
      if (paramBundle != null) {
        paramInt1 = paramBundle.getInt("POST_LANDSCAPE_ACTION_DELAY");
      }
    }
    for (;;)
    {
      String str = this.TAG;
      Object localObject = new StringBuilder("onLandscapeAction action:");
      paramBundle = this.liveData;
      if (paramBundle == null) {
        p.btv("liveData");
      }
      if (paramBundle != null)
      {
        paramBundle = paramBundle.uEh;
        label151:
        paramBundle = ((StringBuilder)localObject).append(paramBundle).append(", orientation:");
        localObject = getContext();
        p.g(localObject, "context");
        localObject = ((Context)localObject).getResources();
        p.g(localObject, "context.resources");
        Log.i(str, ((Resources)localObject).getConfiguration().orientation + ",delayMs:" + paramInt1);
        paramBundle = ((Iterable)getPluginList()).iterator();
      }
      for (;;)
      {
        if (!paramBundle.hasNext()) {
          break label305;
        }
        if (((com.tencent.mm.live.c.a)paramBundle.next() instanceof com.tencent.mm.plugin.finder.live.plugin.d))
        {
          if (paramInt1 > 0)
          {
            if (this.liveData != null) {
              continue;
            }
            p.btv("liveData");
            continue;
            paramInt1 = 0;
            break;
            paramBundle = null;
            break label151;
          }
          if (this.liveData == null) {
            p.btv("liveData");
          }
        }
      }
      label305:
      b.b.a(this, b.c.hNv);
      return;
      label313:
      paramInt1 = 0;
    }
  }
  
  public abstract void onLiveEventCallback(int paramInt, Bundle paramBundle);
  
  public void onLiveMicSucc(com.tencent.mm.live.b.q paramq)
  {
    p.h(paramq, "info");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.c.a locala = (com.tencent.mm.live.c.a)localIterator.next();
      Object localObject = locala;
      if (!(locala instanceof com.tencent.mm.plugin.finder.live.plugin.d)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.plugin.finder.live.plugin.d)localObject;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.plugin.d)localObject).onNewIntent(paramIntent);
      }
    }
  }
  
  public void onOnlineLiveList(v paramv)
  {
    p.h(paramv, "info");
  }
  
  public void onOrientationChange(int paramInt)
  {
    if ((this.lastRotationFromSensor == -1) || (this.lastRotationFromSensor != paramInt))
    {
      if (this.lastRotationFromSensor != -1)
      {
        com.tencent.mm.plugin.finder.live.model.s locals = getFinderLiveAssistant();
        if (locals != null) {
          locals.dfm();
        }
        if ((getCurrentOrientation() == 1) || (getCurrentOrientation() == 3)) {
          b.b.a(this, b.c.hMC);
        }
      }
      Log.i(this.TAG, "onOrientationChange lastRotationFromSensor:" + this.lastRotationFromSensor + ",cur orientation:" + paramInt);
      this.lastRotationFromSensor = paramInt;
    }
  }
  
  public final void onPortraitAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (isLandscape())
    {
      forceScreenToPortrait();
      return;
    }
    onPortraitActionImpl(paramInt1, paramInt2, paramBundle);
  }
  
  public final void onPortraitActionImpl(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramInt1 = 0;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle.uEv = false;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle.uDS = true;
    paramBundle = this.liveData;
    if (paramBundle == null) {
      p.btv("liveData");
    }
    paramBundle = paramBundle.uEh;
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("POST_PORTRAIT_ACTION_DELAY") != true) {
        break label361;
      }
      paramBundle = this.liveData;
      if (paramBundle == null) {
        p.btv("liveData");
      }
      paramBundle = paramBundle.uEh;
      if (paramBundle != null) {
        paramInt1 = paramBundle.getInt("POST_PORTRAIT_ACTION_DELAY");
      }
    }
    for (;;)
    {
      Object localObject1 = this.TAG;
      Object localObject2 = new StringBuilder("onPortraitAction action:");
      paramBundle = this.liveData;
      if (paramBundle == null) {
        p.btv("liveData");
      }
      if (paramBundle != null)
      {
        paramBundle = paramBundle.uEh;
        label151:
        paramBundle = ((StringBuilder)localObject2).append(paramBundle).append(", orientation:");
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources();
        p.g(localObject2, "context.resources");
        Log.i((String)localObject1, ((Resources)localObject2).getConfiguration().orientation + ",delayMs:" + paramInt1);
        paramBundle = ((Iterable)getPluginList()).iterator();
      }
      for (;;)
      {
        if (!paramBundle.hasNext()) {
          break label353;
        }
        localObject1 = (com.tencent.mm.live.c.a)paramBundle.next();
        if ((localObject1 instanceof com.tencent.mm.plugin.finder.live.plugin.d))
        {
          if (paramInt1 > 0)
          {
            localObject1 = (com.tencent.mm.plugin.finder.live.plugin.d)localObject1;
            localObject2 = this.liveData;
            if (localObject2 == null) {
              p.btv("liveData");
            }
            ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).a(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).uEh, paramInt1);
            continue;
            paramInt1 = 0;
            break;
            paramBundle = null;
            break label151;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.plugin.d)localObject1;
          localObject2 = this.liveData;
          if (localObject2 == null) {
            p.btv("liveData");
          }
          ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ai(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).uEh);
        }
      }
      label353:
      b.b.a(this, b.c.hNt);
      return;
      label361:
      paramInt1 = 0;
    }
  }
  
  public void onScreenClear(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.live.c.a)localIterator.next();
      if (((localObject1 instanceof com.tencent.mm.plugin.finder.live.plugin.d)) && (((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).dgK()))
      {
        Log.i(this.TAG, ((com.tencent.mm.live.c.a)localObject1).name() + " screen switch, visibility:" + ((com.tencent.mm.live.c.a)localObject1).hwr.getVisibility() + ", cacheVisibility:" + ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulV + ", clear:" + paramBoolean);
        Object localObject2 = (com.tencent.mm.plugin.finder.live.plugin.d)localObject1;
        if (paramBoolean) {}
        for (int i = 8;; i = 65535)
        {
          ((com.tencent.mm.plugin.finder.live.plugin.d)localObject2).ulW = i;
          if (!paramBoolean) {
            break label310;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.plugin.d)localObject1;
          if (((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX == null)
          {
            ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX = ObjectAnimator.ofFloat(((com.tencent.mm.live.c.a)localObject1).hwr, "alpha", new float[] { 1.0F, 0.0F });
            localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
            if (localObject2 != null) {
              ((ObjectAnimator)localObject2).setDuration(((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulZ);
            }
            localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
            if (localObject2 != null) {
              ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)new com.tencent.mm.plugin.finder.live.plugin.d.a((com.tencent.mm.plugin.finder.live.plugin.d)localObject1));
            }
            localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
            if (localObject2 != null) {
              ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
            }
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
          if (localObject2 != null) {
            ((ObjectAnimator)localObject2).cancel();
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
          if (localObject1 == null) {
            break;
          }
          ((ObjectAnimator)localObject1).start();
          break;
        }
        label310:
        localObject1 = (com.tencent.mm.plugin.finder.live.plugin.d)localObject1;
        if (((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY == null)
        {
          ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY = ObjectAnimator.ofFloat(((com.tencent.mm.live.c.a)localObject1).hwr, "alpha", new float[] { 0.0F, 1.0F });
          localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY;
          if (localObject2 != null) {
            ((ObjectAnimator)localObject2).setDuration(((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulZ);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY;
          if (localObject2 != null) {
            ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)new d.c((com.tencent.mm.plugin.finder.live.plugin.d)localObject1));
          }
          localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulX;
          if (localObject2 != null) {
            ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
          }
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY;
        if (localObject2 != null) {
          ((ObjectAnimator)localObject2).cancel();
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.d)localObject1).ulY;
        if (localObject1 != null) {
          ((ObjectAnimator)localObject1).start();
        }
      }
    }
  }
  
  public abstract void release();
  
  public void reset(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b.b.a(this, b.c.hNm);
    }
  }
  
  public void resume()
  {
    super.resume();
    this.checkMiniWin = false;
  }
  
  protected final void setCheckMiniWin(boolean paramBoolean)
  {
    this.checkMiniWin = paramBoolean;
  }
  
  protected final void setCurLive(boolean paramBoolean)
  {
    this.isCurLive = paramBoolean;
  }
  
  public final void setCurNetworkQuality(int paramInt)
  {
    this.curNetworkQuality = paramInt;
  }
  
  public final void setCurNetworkType(int paramInt)
  {
    this.curNetworkType = paramInt;
  }
  
  public final void setCurrentAppId(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.currentAppId = paramString;
  }
  
  public final void setData(com.tencent.mm.plugin.finder.live.viewmodel.c paramc)
  {
    p.h(paramc, "<set-?>");
    this.data = paramc;
  }
  
  protected final void setLastLiveState(int paramInt)
  {
    this.lastLiveState = paramInt;
  }
  
  public final void setLastOrientation(int paramInt)
  {
    this.lastOrientation = paramInt;
  }
  
  public final void setLastRotationFromSensor(int paramInt)
  {
    this.lastRotationFromSensor = paramInt;
  }
  
  protected final void setLastUIState(int paramInt)
  {
    this.lastUIState = paramInt;
  }
  
  public final void setLiveData(com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    p.h(paramg, "<set-?>");
    this.liveData = paramg;
  }
  
  protected final void setManualClosed(boolean paramBoolean)
  {
    this.isManualClosed = paramBoolean;
  }
  
  protected final void setMiniWinPermission(boolean paramBoolean)
  {
    this.miniWinPermission = paramBoolean;
  }
  
  public final void setOrientationEventListener(com.tencent.mm.plugin.mmsight.model.d paramd)
  {
    this.orientationEventListener = paramd;
  }
  
  public final void setStatisticsWidget(m paramm)
  {
    this.statisticsWidget = paramm;
  }
  
  public final boolean showAlertDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    p.h(paramActivity, "activity");
    Object localObject = this.alertDialog;
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.ui.widget.a.d)localObject).isShowing()); (p.j(localObject, Boolean.TRUE)) || (isDestroyed()); localObject = null) {
      return false;
    }
    localObject = this.liveData;
    if (localObject == null) {
      p.btv("liveData");
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).dje();
    int i;
    if (paramString2 != null)
    {
      localObject = new f.a((Context)paramActivity);
      CharSequence localCharSequence = (CharSequence)paramString1;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label231;
        }
        ((f.a)localObject).bow(paramString2);
        label132:
        ((f.a)localObject).hbu();
        paramActivity = paramActivity.getResources().getString(2131759865);
        p.g(paramActivity, "activity.resources.getSt…ive_alert_dialog_btn_txt)");
        paramString1 = (CharSequence)paramString3;
        if (paramString1 != null)
        {
          i = j;
          if (paramString1.length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          break label250;
        }
      }
    }
    for (;;)
    {
      ((f.a)localObject).boA(paramString3);
      ((f.a)localObject).b((f.c)new e(this)).show();
      this.alertDialog = ((f.a)localObject).hbv();
      return true;
      i = 0;
      break;
      label231:
      ((f.a)localObject).aC((CharSequence)paramString1).bow(paramString2);
      break label132;
      return false;
      label250:
      paramString3 = paramActivity;
    }
  }
  
  public final void showAlertInfo(Activity paramActivity)
  {
    String str1 = null;
    p.h(paramActivity, "activity");
    Object localObject1 = this.liveData;
    if (localObject1 == null) {
      p.btv("liveData");
    }
    awr localawr = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uDY;
    Object localObject2;
    label61:
    Object localObject3;
    label73:
    String str2;
    if (localawr != null)
    {
      localObject2 = Integer.valueOf(localawr.type);
      if (localawr == null) {
        break label114;
      }
      localObject1 = localawr.title;
      if (localawr == null) {
        break label120;
      }
      localObject3 = localawr.content;
      if (localawr == null) {
        break label126;
      }
      str2 = localawr.LHs;
      label85:
      if (localawr != null) {
        str1 = localawr.LHr;
      }
      if (localObject2 != null) {
        break label132;
      }
      label102:
      if (localObject2 != null) {
        break label212;
      }
    }
    label114:
    label120:
    label126:
    do
    {
      do
      {
        return;
        localObject2 = null;
        break;
        localObject1 = null;
        break label61;
        localObject3 = null;
        break label73;
        str2 = null;
        break label85;
        if (((Integer)localObject2).intValue() != 1) {
          break label102;
        }
        Log.i(this.TAG, "showAlertInfo type:" + localObject2 + ",title:" + (String)localObject1 + ",content:" + (String)localObject3 + ",buttonTitle:" + str2);
        showAlertDialog(paramActivity, (String)localObject1, (String)localObject3, str2);
        return;
      } while (((Integer)localObject2).intValue() != 0);
      Log.i(this.TAG, "showAlertInfo type:" + localObject2 + ",title:" + (String)localObject1 + ",content:" + (String)localObject3 + ",buttonTitle:" + str2 + ",iconName:" + str1);
    } while (localObject1 == null);
    label132:
    label462:
    for (;;)
    {
      try
      {
        label212:
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources();
        localObject3 = getContext();
        p.g(localObject3, "context");
        int i = ((Resources)localObject2).getIdentifier(str1, "drawable", ((Context)localObject3).getPackageName());
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources();
        localObject3 = getContext();
        p.g(localObject3, "context");
        int j = ((Resources)localObject2).getIdentifier(str1, "raw", ((Context)localObject3).getPackageName());
        if (j == 0) {
          break label462;
        }
        i = j;
        if (i != 0)
        {
          showCenterCustomizeToast((String)localObject1, i);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.i(this.TAG, "showAlertInfo exception:" + localException.getMessage());
        showToast((Context)paramActivity, (String)localObject1);
        return;
      }
      showToast((Context)paramActivity, (String)localObject1);
      return;
    }
  }
  
  public final void showBlurBg()
  {
    ImageView localImageView = this.blurBgView;
    Context localContext = getContext();
    p.g(localContext, "context");
    localImageView.setElevation(localContext.getResources().getDimensionPixelSize(2131166581));
    this.tipView.setVisibility(8);
  }
  
  public final void showCDNStatistics(com.tencent.mm.live.core.core.b.c paramc)
  {
    Object localObject3 = null;
    Object localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
    if ((!com.tencent.mm.plugin.finder.utils.y.dCM()) || (paramc == null)) {}
    label420:
    label684:
    label948:
    label1335:
    for (;;)
    {
      return;
      localObject1 = this.liveData;
      if (localObject1 == null) {
        p.btv("liveData");
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEN) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.util.q.uxj;
      com.tencent.mm.plugin.finder.live.util.q.b(paramc);
      localObject1 = com.tencent.mm.plugin.finder.live.util.q.uxj;
      Object localObject4 = com.tencent.mm.plugin.finder.live.util.q.dio();
      Object localObject2;
      if (localObject4 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwk.uxm.key + ':' + ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwk.uxm.value + '\n');
        ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwl.uxm.key + ':' + ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwl.uxm.value + '\n');
        StringBuilder localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwg.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwg.uxm.value).append('(');
        localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwg.uxn;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwj.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwj.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwj.uxn;
          if (localObject1 == null) {
            break label1287;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label332:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwh.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwh.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwh.uxn;
          if (localObject1 == null) {
            break label1292;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwi.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwi.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwi.uxn;
          if (localObject1 == null) {
            break label1297;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label508:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwm.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwm.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwm.uxn;
          if (localObject1 == null) {
            break label1302;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label596:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwn.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwn.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwn.uxn;
          if (localObject1 == null) {
            break label1307;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwo.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwo.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwo.uxn;
          if (localObject1 == null) {
            break label1312;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwp.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwp.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwp.uxn;
          if (localObject1 == null) {
            break label1317;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label860:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwq.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwq.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwq.uxn;
          if (localObject1 == null) {
            break label1322;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwr.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwr.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).uwr.uxn;
          if (localObject1 == null) {
            break label1327;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localObject1 = ((StringBuilder)localObject2).toString();
          p.g(localObject1, "sb.toString()");
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil((String)localObject1)) {
          break label1335;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject1).append("liveId:" + paramc.hyH + '\n');
        paramc = ((StringBuilder)localObject1).toString();
        if (this.statisticsWidget == null)
        {
          localObject1 = getContext();
          p.g(localObject1, "context");
          this.statisticsWidget = new m((Context)localObject1, (ViewGroup)this);
        }
        localObject2 = this.statisticsWidget;
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder("Mode CDN\n");
          localObject4 = this.liveData;
          if (localObject4 == null) {
            p.btv("liveData");
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).djj() + paramc;
          paramc = (com.tencent.mm.live.core.core.b.c)localObject1;
          if (localObject1 == null) {
            paramc = "";
          }
          ((m)localObject2).atZ(paramc);
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("showCDNStatistics:");
        paramc = com.tencent.mm.plugin.finder.live.util.q.uxj;
        localObject4 = com.tencent.mm.plugin.finder.live.util.q.dio();
        paramc = localObject3;
        if (localObject4 != null) {
          paramc = ((com.tencent.mm.plugin.finder.live.util.h)localObject4).dif();
        }
        Log.i((String)localObject1, paramc);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label332;
        localObject1 = null;
        break label420;
        localObject1 = null;
        break label508;
        localObject1 = null;
        break label596;
        localObject1 = null;
        break label684;
        localObject1 = null;
        break label772;
        localObject1 = null;
        break label860;
        localObject1 = null;
        break label948;
        localObject1 = null;
        break label1036;
        localObject1 = null;
      }
    }
    label772:
    label1036:
    label1297:
    label1302:
    label1307:
    label1312:
    label1317:
    label1322:
    label1327:
    hideStatistics();
    label1287:
    label1292:
    return;
  }
  
  public final void showCenterCustomizeToast(final String paramString, final int paramInt)
  {
    p.h(paramString, "msg");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this, paramString, paramInt));
  }
  
  public final void showDebugToast(String paramString)
  {
    p.h(paramString, "content");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      u.makeText(getContext(), (CharSequence)paramString, 0).show();
    }
  }
  
  public final void showProgress()
  {
    ImageView localImageView = this.blurBgView;
    Context localContext = getContext();
    p.g(localContext, "context");
    localImageView.setElevation(localContext.getResources().getDimensionPixelSize(2131166580));
    this.progressView.setVisibility(0);
    this.tipView.setVisibility(8);
    requestLayout();
  }
  
  public final void showProgressWithBlurBg(String paramString)
  {
    paramString = this.blurBgView;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramString.setElevation(localContext.getResources().getDimensionPixelSize(2131166581));
    this.progressView.setVisibility(0);
    this.tipView.setVisibility(8);
    requestLayout();
  }
  
  public final void showTipWithBlurBg(String paramString1, String paramString2)
  {
    p.h(paramString2, "tip");
    paramString1 = this.blurBgView;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramString1.setElevation(localContext.getResources().getDimensionPixelSize(2131166581));
    this.progressView.setVisibility(8);
    this.tipView.setVisibility(0);
    this.tipView.setText((CharSequence)paramString2);
    requestLayout();
  }
  
  public final void showToast(Context paramContext, String paramString)
  {
    p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    localg.dje();
    if (paramString != null) {
      u.makeText(paramContext, (CharSequence)paramString, 1).show();
    }
  }
  
  public final void showTrtcStatistics(com.tencent.mm.live.core.core.b.c paramc)
  {
    Object localObject3 = null;
    Object localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
    if ((!com.tencent.mm.plugin.finder.utils.y.dCM()) || (paramc == null)) {}
    label332:
    label596:
    label1242:
    for (;;)
    {
      return;
      localObject1 = this.liveData;
      if (localObject1 == null) {
        p.btv("liveData");
      }
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEN) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.util.q.uxj;
      com.tencent.mm.plugin.finder.live.util.q.a(paramc);
      localObject1 = com.tencent.mm.plugin.finder.live.util.q.uxj;
      Object localObject4 = com.tencent.mm.plugin.finder.live.util.q.din();
      Object localObject2;
      if (localObject4 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwk.uxm.key + ':' + ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwk.uxm.value + '\n');
        ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwl.uxm.key + ':' + ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwl.uxm.value + '\n');
        StringBuilder localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwj.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwj.uxm.value).append('(');
        localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwj.uxn;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwg.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwg.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwg.uxn;
          if (localObject1 == null) {
            break label1199;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxp.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxp.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxp.uxn;
          if (localObject1 == null) {
            break label1204;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxq.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxq.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxq.uxn;
          if (localObject1 == null) {
            break label1209;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label508:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxr.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxr.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxr.uxn;
          if (localObject1 == null) {
            break label1214;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxs.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxs.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxs.uxn;
          if (localObject1 == null) {
            break label1219;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxt.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxt.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uxt.uxn;
          if (localObject1 == null) {
            break label1224;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwh.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwh.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwh.uxn;
          if (localObject1 == null) {
            break label1229;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          label860:
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localStringBuilder = new StringBuilder().append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwi.uxm.key).append(':').append(((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwi.uxm.value).append('(');
          localObject1 = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).uwi.uxn;
          if (localObject1 == null) {
            break label1234;
          }
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.live.util.e)localObject1).uwa);
          ((StringBuilder)localObject2).append(localObject1 + ")\n");
          localObject1 = ((StringBuilder)localObject2).toString();
          p.g(localObject1, "sb.toString()");
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil((String)localObject1)) {
          break label1242;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject1).append("liveId:" + paramc.hyH + '\n');
        paramc = ((StringBuilder)localObject1).toString();
        if (this.statisticsWidget == null)
        {
          localObject1 = getContext();
          p.g(localObject1, "context");
          this.statisticsWidget = new m((Context)localObject1, (ViewGroup)this);
        }
        localObject2 = this.statisticsWidget;
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder("Mode Trtc\n");
          localObject4 = this.liveData;
          if (localObject4 == null) {
            p.btv("liveData");
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject4).djj() + paramc;
          paramc = (com.tencent.mm.live.core.core.b.c)localObject1;
          if (localObject1 == null) {
            paramc = "";
          }
          ((m)localObject2).atZ(paramc);
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("showTrtcStatistics:");
        paramc = com.tencent.mm.plugin.finder.live.util.q.uxj;
        localObject4 = com.tencent.mm.plugin.finder.live.util.q.din();
        paramc = localObject3;
        if (localObject4 != null) {
          paramc = ((com.tencent.mm.plugin.finder.live.util.y)localObject4).dif();
        }
        Log.i((String)localObject1, paramc);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label332;
        localObject1 = null;
        break label420;
        localObject1 = null;
        break label508;
        localObject1 = null;
        break label596;
        localObject1 = null;
        break label684;
        localObject1 = null;
        break label772;
        localObject1 = null;
        break label860;
        localObject1 = null;
        break label948;
        localObject1 = null;
      }
    }
    label420:
    label684:
    label948:
    label1209:
    label1214:
    label1219:
    label1224:
    label1229:
    label1234:
    hideStatistics();
    label772:
    label1199:
    label1204:
    return;
  }
  
  public void start()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    localg.uDS = true;
    localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    localg.uDT = false;
    localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    localg.uEv = false;
  }
  
  public void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    p.h(paramc, "status");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this, paramc, paramBundle));
  }
  
  public void stop()
  {
    super.stop();
  }
  
  public void unMount()
  {
    super.unMount();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("unMount ");
    com.tencent.mm.plugin.finder.live.viewmodel.g localg = this.liveData;
    if (localg == null) {
      p.btv("liveData");
    }
    Log.i((String)localObject1, localg);
    localObject1 = getContext().getSystemService("phone");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }
    localObject1 = (TelephonyManager)localObject1;
    localObject2 = this.phoneStatelistener;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "unMount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout", "unMount", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    localObject1 = this.alertDialog;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.d)localObject1).dismiss();
    }
    release();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$hideLoadingLayer$1$1"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(247312);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(247312);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      FinderBaseLivePluginLayout.access$getBlurBgView$p(this.uxy).setAlpha(f);
      FinderBaseLivePluginLayout.access$getProgressView$p(this.uxy).setAlpha(f);
      FinderBaseLivePluginLayout.access$getTipView$p(this.uxy).setAlpha(f);
      AppMethodBeat.o(247312);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$hideLoadingLayer$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(247314);
      FinderBaseLivePluginLayout.access$getBlurBgView$p(this.uxy).setAlpha(1.0F);
      FinderBaseLivePluginLayout.access$getProgressView$p(this.uxy).setAlpha(1.0F);
      FinderBaseLivePluginLayout.access$getTipView$p(this.uxy).setAlpha(1.0F);
      paramAnimator = FinderBaseLivePluginLayout.access$getBlurBgView$p(this.uxy);
      Context localContext = this.uxy.getContext();
      p.g(localContext, "context");
      paramAnimator.setElevation(localContext.getResources().getDimensionPixelSize(2131166580));
      FinderBaseLivePluginLayout.access$getProgressView$p(this.uxy).setVisibility(8);
      FinderBaseLivePluginLayout.access$getTipView$p(this.uxy).setVisibility(8);
      AppMethodBeat.o(247314);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247313);
      FinderBaseLivePluginLayout.access$getBlurBgView$p(this.uxy).setAlpha(1.0F);
      FinderBaseLivePluginLayout.access$getProgressView$p(this.uxy).setAlpha(1.0F);
      FinderBaseLivePluginLayout.access$getTipView$p(this.uxy).setAlpha(1.0F);
      paramAnimator = FinderBaseLivePluginLayout.access$getBlurBgView$p(this.uxy);
      Context localContext = this.uxy.getContext();
      p.g(localContext, "context");
      paramAnimator.setElevation(localContext.getResources().getDimensionPixelSize(2131166580));
      FinderBaseLivePluginLayout.access$getProgressView$p(this.uxy).setVisibility(8);
      FinderBaseLivePluginLayout.access$getTipView$p(this.uxy).setVisibility(8);
      AppMethodBeat.o(247313);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-finder_release"})
  public static final class d
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(247315);
      p.h(paramString, "incomingNumber");
      this.uxy.onCallStateChanged(paramInt, paramString);
      AppMethodBeat.o(247315);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class e
    implements f.c
  {
    e(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout) {}
    
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(247316);
      Log.i(FinderBaseLivePluginLayout.access$getTAG$p(this.uxy), "showAlertDialog click bOk:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(247316);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(FinderBaseLivePluginLayout paramFinderBaseLivePluginLayout, b.c paramc, Bundle paramBundle)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout
 * JD-Core Version:    0.7.0.1
 */