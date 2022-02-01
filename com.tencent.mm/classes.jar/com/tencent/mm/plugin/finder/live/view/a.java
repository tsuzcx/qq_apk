package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.finder.live.model.ai;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.al;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.widget.ak;
import com.tencent.mm.plugin.finder.live.widget.bb;
import com.tencent.mm.plugin.finder.live.widget.bm;
import com.tencent.mm.plugin.finder.report.u.a;
import com.tencent.mm.plugin.finder.report.u.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/model/context/IFinderLiveStore;", "Lcom/tencent/mm/plugin/finder/live/view/IFinderLivePluginLayout;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "CLEAR_RECOVERY_SCREEN_DURATION", "", "alertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "audienPreloadCDNLiveConfig", "", "getAudienPreloadCDNLiveConfig", "()Z", "setAudienPreloadCDNLiveConfig", "(Z)V", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "checkMiniWin", "getCheckMiniWin", "setCheckMiniWin", "confettiBitmapManager", "Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;", "getConfettiBitmapManager", "()Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;", "setConfettiBitmapManager", "(Lcom/tencent/mm/plugin/finder/live/widget/manager/ConfettiBitmapManager;)V", "curNetworkQuality", "", "getCurNetworkQuality", "()I", "setCurNetworkQuality", "(I)V", "curNetworkType", "getCurNetworkType", "setCurNetworkType", "currentAppId", "", "getCurrentAppId", "()Ljava/lang/String;", "setCurrentAppId", "(Ljava/lang/String;)V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "externalCallback", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$ExternalCallback;", "getExternalCallback", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$ExternalCallback;", "setExternalCallback", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$ExternalCallback;)V", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "finishActivityNotReleaseLive", "getFinishActivityNotReleaseLive", "setFinishActivityNotReleaseLive", "isManualClosed", "setManualClosed", "lastLiveState", "getLastLiveState", "setLastLiveState", "lastMicData", "Lorg/json/JSONObject;", "getLastMicData", "()Lorg/json/JSONObject;", "setLastMicData", "(Lorg/json/JSONObject;)V", "lastMicUserList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "getLastMicUserList", "()Ljava/util/ArrayList;", "lastOrientation", "getLastOrientation", "setLastOrientation", "lastPkMicUser", "getLastPkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "setLastPkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "lastRoomPkMicUserList", "Lorg/json/JSONArray;", "getLastRoomPkMicUserList", "()Lorg/json/JSONArray;", "setLastRoomPkMicUserList", "(Lorg/json/JSONArray;)V", "lastRotationFromSensor", "getLastRotationFromSensor", "setLastRotationFromSensor", "lastUIState", "getLastUIState", "setLastUIState", "loadingTipWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget;", "getLoadingTipWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget;", "miniWinPermission", "getMiniWinPermission", "setMiniWinPermission", "onNetworkChange", "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$onNetworkChange$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$onNetworkChange$1;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "getOrientationEventListener", "()Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "setOrientationEventListener", "(Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;)V", "previewRoot", "Landroid/widget/RelativeLayout;", "getPreviewRoot", "()Landroid/widget/RelativeLayout;", "rotationHelper", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "screenClearAnim", "Landroid/animation/ValueAnimator;", "screenRecoveryAnim", "statisticsWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "getStatisticsWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "setStatisticsWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;)V", "getUicFragment", "()Landroidx/fragment/app/Fragment;", "warnningCountWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveWarnningCountWidget;", "getWarnningCountWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveWarnningCountWidget;", "warnningCountWidget$delegate", "Lkotlin/Lazy;", "activate", "", "config", "isFromFloat", "restart", "applyLiveScene", "liveScene", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "bindData", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "changeScreenOrientation", "changeScreenToLandscape", "changeScreenToPortrait", "checkFinishWhenDiffTask", "activity", "Landroid/app/Activity;", "checkPauseStateWhenLiveStart", "diffMicUsers", "diffPkMicUsers", "diffRoomPkMicUsers", "list", "disableRatation", "dispatchValueAnimator", "value", "", "doScreenClearAnimation", "doScreenRecoveryAnimation", "enableAutoRotation", "enableRotation", "fillBlurBg", "username", "withoutBlur", "finish", "forceScreenToLandscape", "forceScreenToPortrait", "genAudienceMicMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "topMargin", "ratio", "screenX", "screenY", "genPkMicMap", "genRoomPKMicMap", "micData", "totalWidth", "totalHeight", "genRootViewByStub", "Landroid/view/View;", "stubId", "root", "getPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "modelClass", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getPlugins", "", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "getScreenSize", "Lkotlin/Pair;", "goGetLuckMoney", "redPacketId", "handleRecvLuckyMoneyErr", "errCode", "hideLoadingLayer", "withAnimation", "hideProgress", "hideStatistics", "hideTimeCount", "initLogic", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "isDestroyed", "isLiveFinished", "isLiveStarted", "isSwipeBack", "keyboardChange", "show", "height", "lockScreenRotation", "mount", "needMiniWindow", "needRemoveActivity", "networkChange", "status", "notifyAudienceMicUserChange", "checkDiff", "screenSize", "notifyPKMicUserChange", "notifyRoomPKMicUserChange", "forceUpdate", "onAcceptBattleTimeout", "onAcceptLiveMic", "info", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "onAcceptMicPkTimeout", "onAcceptMicTimeout", "micId", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAnchorCallInterruption", "callInterruption", "onAnchorConnectionChange", "anchorConnectionChange", "onApplyBattleTimeout", "onApplyLiveMic", "Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "onApplyMicPkTimeout", "onApplyMicTimeout", "onBanLiveComment", "Lcom/tencent/mm/live/model/BanLiveCommentInfo;", "onCloseApplyLiveMic", "Lcom/tencent/mm/live/model/CloseApplyLiveMicInfo;", "onCloseLive", "Lcom/tencent/mm/live/model/CloseLiveInfo;", "onCloseLiveMic", "Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLandscapeAction", "extraData", "", "onLandscapeActionImpl", "onLiveEventCallback", "errorCode", "param", "onLiveMicSucc", "Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "onNewIntent", "intent", "onOnlineLiveList", "Lcom/tencent/mm/live/model/OnlineLiveListInfo;", "onOrientationChange", "orientation", "onPortraitAction", "onPortraitActionImpl", "onRandomMatchTimeout", "onRandomMicAccept", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgApplyPkInfo;", "onRandomMicApply", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgNotifyApplyRandomMicInfo;", "onScreenClear", "clear", "onScreenClearEnd", "onScreenClearStart", "onScreenRecoveryEnd", "onScreenRecoveryStart", "processFinderLiveLayerShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "release", "reset", "resume", "showAlertDialog", "title", "content", "buttonTitle", "serverAlert", "showAlertInfo", "showBlurBg", "showBlurBgWithTimeCount", "tip", "showCenterCustomizeToast", "msg", "res", "showDebugToast", "showProgress", "showProgressWithBlurBg", "showProgressWithTips", "tips", "showStatistics", "showTipWithBlurBg", "showTipWithBlurBgAction", "actionTxt", "action", "Lkotlin/Function0;", "showToast", "showVerificationLayerInfo", "desc", "interceptTouchEvent", "showBg", "callback", "Lkotlin/Function1;", "start", "startPauseTime", "statusChange", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "unMount", "unregisterPlugin", "updateLayerShowInfo", "layerShowInfo", "fromJoin", "updateVerificationButtonState", "buttonWording", "", "enable", "updateVerificationCountDownTip", "countDownTip", "Companion", "ExternalCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends BaseLivePluginLayout
  implements com.tencent.mm.plugin.finder.live.model.mic.a, d.a
{
  public static final a Companion = new a((byte)0);
  private static final String TAG = kotlin.g.b.s.X("Finder.FinderBaseLivePluginLayout@", Integer.valueOf(Companion.hashCode()));
  private final long CLEAR_RECOVERY_SCREEN_DURATION;
  private com.tencent.mm.ui.widget.a.e alertDialog;
  private boolean audienPreloadCDNLiveConfig;
  public com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private boolean checkMiniWin;
  private com.tencent.mm.plugin.finder.live.widget.manager.a confettiBitmapManager;
  private int curNetworkQuality;
  private int curNetworkType;
  private String currentAppId;
  public com.tencent.mm.plugin.finder.live.viewmodel.data.f data;
  private b externalCallback;
  private boolean finishActivityNotReleaseLive;
  private boolean isManualClosed;
  private int lastLiveState;
  private JSONObject lastMicData;
  private final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.h> lastMicUserList;
  private int lastOrientation;
  private com.tencent.mm.plugin.finder.live.viewmodel.data.h lastPkMicUser;
  private JSONArray lastRoomPkMicUserList;
  private int lastRotationFromSensor;
  private int lastUIState;
  private final ak loadingTipWidget;
  private boolean miniWinPermission;
  private final i onNetworkChange;
  private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private final RelativeLayout previewRoot;
  private ai rotationHelper;
  private ValueAnimator screenClearAnim;
  private ValueAnimator screenRecoveryAnim;
  private bb statisticsWidget;
  private final Fragment uicFragment;
  private final kotlin.j warnningCountWidget$delegate;
  
  public a(Context paramContext, Fragment paramFragment, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uicFragment = paramFragment;
    this.currentAppId = "";
    paramFragment = e.o.mLz;
    this.curNetworkQuality = e.o.bdD();
    this.curNetworkType = -1;
    this.lastRotationFromSensor = -1;
    this.lastOrientation = -1;
    this.loadingTipWidget = new ak((ViewGroup)this);
    paramFragment = findViewById(p.e.BQY);
    kotlin.g.b.s.s(paramFragment, "findViewById(R.id.finder_live_preview_root)");
    this.previewRoot = ((RelativeLayout)paramFragment);
    this.warnningCountWidget$delegate = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.lastMicUserList = new ArrayList();
    paramFragment = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSY().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.audienPreloadCDNLiveConfig = bool;
      this.lastLiveState = -1;
      this.lastUIState = -1;
      this.rotationHelper = new ai(new WeakReference((MMFinderUI)paramContext));
      this.CLEAR_RECOVERY_SCREEN_DURATION = 300L;
      this.onNetworkChange = new i(this);
      return;
    }
  }
  
  private static final boolean activate$isPayForChargeLive(a parama)
  {
    boolean bool = true;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).Ecj == 1) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).PX(0);
      if (bool) {
        Log.i(TAG, "activate isChargeLive:true but change normal mode now!");
      }
      return bool;
      bool = false;
    }
  }
  
  private final boolean diffMicUsers()
  {
    boolean bool = false;
    int k;
    int i;
    int j;
    if (this.lastMicUserList.size() == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.size())
    {
      k = this.lastMicUserList.size();
      if (k > 0)
      {
        i = 0;
        bool = false;
        j = i + 1;
      }
    }
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      synchronized ((List)this.lastMicUserList)
      {
        localObject3 = kotlin.a.p.ae((List)???, i);
        ??? = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject3;
        if (??? == null)
        {
          ??? = null;
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(localObject3, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        }
      }
      ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).sessionId;
      continue;
      String str;
      continue;
      return true;
      i = j;
      break;
    }
  }
  
  private final boolean diffPkMicUsers()
  {
    String str = null;
    Object localObject = this.lastPkMicUser;
    com.tencent.mm.plugin.finder.live.viewmodel.data.h localh;
    if (localObject == null)
    {
      localObject = null;
      localh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localh != null) {
        break label49;
      }
    }
    for (;;)
    {
      if (Util.isEqual((String)localObject, str)) {
        break label57;
      }
      return true;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).sessionId;
      break;
      label49:
      str = localh.sessionId;
    }
    label57:
    return false;
  }
  
  private final boolean diffRoomPkMicUsers(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) && (this.lastRoomPkMicUserList == null)) {}
    JSONArray localJSONArray;
    int k;
    do
    {
      return false;
      if (paramJSONArray == null) {
        return true;
      }
      localJSONArray = this.lastRoomPkMicUserList;
      if (localJSONArray == null) {
        break label148;
      }
      if (localJSONArray.length() != paramJSONArray.length()) {
        break;
      }
      k = localJSONArray.length();
    } while (k <= 0);
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject1 = localJSONArray.optJSONObject(i);
      Object localObject2 = paramJSONArray.optJSONObject(i);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label122;
        }
      }
      label122:
      for (localObject2 = null;; localObject2 = ((JSONObject)localObject2).optString("uId"))
      {
        if (TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {
          break label135;
        }
        return true;
        localObject1 = ((JSONObject)localObject1).optString("uId");
        break;
      }
      label135:
      if (j >= k) {
        break;
      }
    }
    return true;
    label148:
    return true;
  }
  
  private final void dispatchValueAnimator(float paramFloat)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.live.b.a)localIterator.next();
      if (((localObject instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)localObject).eoI()))
      {
        localObject = (com.tencent.mm.plugin.finder.live.plugin.b)localObject;
        if ((((com.tencent.mm.plugin.finder.live.plugin.b)localObject).CTn == 1) && (Build.VERSION.SDK_INT >= 24)) {
          ((com.tencent.mm.live.b.a)localObject).mJe.setAlpha(paramFloat);
        }
      }
    }
  }
  
  private final void doScreenClearAnimation()
  {
    if (this.screenClearAnim == null)
    {
      localValueAnimator = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F }).setDuration(this.CLEAR_RECOVERY_SCREEN_DURATION);
      localValueAnimator.addListener((Animator.AnimatorListener)new c(this));
      localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda1(this));
      localValueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ah localah = ah.aiuX;
      this.screenClearAnim = localValueAnimator;
    }
    ValueAnimator localValueAnimator = this.screenClearAnim;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.screenClearAnim;
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
  }
  
  private static final void doScreenClearAnimation$lambda-9$lambda-8(a parama, ValueAnimator paramValueAnimator)
  {
    kotlin.g.b.s.u(parama, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    parama.dispatchValueAnimator(((Float)paramValueAnimator).floatValue());
  }
  
  private final void doScreenRecoveryAnimation()
  {
    if (this.screenRecoveryAnim == null)
    {
      localValueAnimator = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.CLEAR_RECOVERY_SCREEN_DURATION);
      localValueAnimator.addListener((Animator.AnimatorListener)new d(this));
      localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda0(this));
      Object localObject = this.screenRecoveryAnim;
      if (localObject != null) {
        ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
      }
      localObject = ah.aiuX;
      this.screenRecoveryAnim = localValueAnimator;
    }
    ValueAnimator localValueAnimator = this.screenRecoveryAnim;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.screenRecoveryAnim;
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
  }
  
  private static final void doScreenRecoveryAnimation$lambda-11$lambda-10(a parama, ValueAnimator paramValueAnimator)
  {
    kotlin.g.b.s.u(parama, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    parama.dispatchValueAnimator(((Float)paramValueAnimator).floatValue());
  }
  
  private final LinkedHashMap<String, Rect> genAudienceMicMap(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = (int)(paramInt2 / 2 * paramFloat);
    switch (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.size())
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      for (;;)
      {
        label68:
        Log.i(TAG, kotlin.g.b.s.X("genAudienceMicMap result:", localLinkedHashMap));
        return localLinkedHashMap;
        localObject7 = (Map)localLinkedHashMap;
        localObject8 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
        kotlin.g.b.s.s(localObject8, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
        ((Map)localObject7).put(localObject8, new Rect(0, 0, paramInt2, paramInt3));
        continue;
        localObject7 = (Map)localLinkedHashMap;
        localObject8 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
        kotlin.g.b.s.s(localObject8, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
        ((Map)localObject7).put(localObject8, new Rect(0, paramInt1, paramInt2 / 2, paramInt1 + i));
        localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        try
        {
          localObject8 = kotlin.a.p.ae((List)localObject7, 0);
          localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
          if (localObject7 != null)
          {
            localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
            if (localObject7 != null) {
              ((Map)localLinkedHashMap).put(localObject7, new Rect(paramInt2 / 2, paramInt1, paramInt2, i + paramInt1));
            }
          }
        }
        finally {}
      }
      localObject8 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
      kotlin.g.b.s.s(localObject8, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
      ((Map)localObject7).put(localObject8, new Rect(0, paramInt1, paramInt2 / 2, paramInt1 + i));
      localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      try
      {
        localObject8 = kotlin.a.p.ae((List)localObject7, 0);
        localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
        if (localObject7 != null)
        {
          localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
          if (localObject7 != null) {
            ((Map)localObject1).put(localObject7, new Rect(paramInt2 / 2, paramInt1, paramInt2, i / 2 + paramInt1));
          }
        }
        localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      }
      finally
      {
        try
        {
          localObject8 = kotlin.a.p.ae((List)localObject7, 1);
          localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
          if (localObject7 == null) {
            break label68;
          }
          localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
          if (localObject7 == null) {
            break label68;
          }
          ((Map)localObject1).put(localObject7, new Rect(paramInt2 / 2, i / 2 + paramInt1, paramInt2, i + paramInt1));
          break label68;
        }
        finally {}
        localObject2 = finally;
        throw localObject2;
      }
    }
    localObject7 = (Map)localObject3;
    Object localObject8 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
    kotlin.g.b.s.s(localObject8, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
    ((Map)localObject7).put(localObject8, new Rect(0, paramInt1, paramInt2 / 2, i / 2 + paramInt1));
    localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    try
    {
      localObject8 = kotlin.a.p.ae((List)localObject7, 0);
      localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
      if (localObject7 != null)
      {
        localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
        if (localObject7 != null) {
          ((Map)localObject3).put(localObject7, new Rect(paramInt2 / 2, paramInt1, paramInt2, i / 2 + paramInt1));
        }
      }
      localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    }
    finally
    {
      for (;;)
      {
        try
        {
          localObject8 = kotlin.a.p.ae((List)localObject7, 1);
          localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
          if (localObject7 != null)
          {
            localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
            if (localObject7 != null) {
              ((Map)localObject3).put(localObject7, new Rect(0, i / 2 + paramInt1, paramInt2 / 2, paramInt1 + i));
            }
          }
          localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(localObject7, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        }
        finally {}
        try
        {
          localObject8 = kotlin.a.p.ae((List)localObject7, 2);
          localObject7 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject8;
          if (localObject7 == null) {
            break;
          }
          localObject7 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject7).mXL;
          if (localObject7 == null) {
            break;
          }
          ((Map)localObject3).put(localObject7, new Rect(paramInt2 / 2, i / 2 + paramInt1, paramInt2, i + paramInt1));
          break;
        }
        finally {}
      }
      localObject4 = finally;
      throw localObject4;
    }
  }
  
  private final LinkedHashMap<String, Rect> genPkMicMap(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = (int)(paramInt2 / 2 * paramFloat);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).EbD == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = (Map)localLinkedHashMap;
      str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
      kotlin.g.b.s.s(str, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
      ((Map)localObject).put(str, new Rect(0, paramInt1, paramInt2 / 2, paramInt1 + j));
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXL;
        if (localObject != null) {
          ((Map)localLinkedHashMap).put(localObject, new Rect(paramInt2 / 2, paramInt1, paramInt2, j + paramInt1));
        }
      }
      return localLinkedHashMap;
    }
    localObject = (Map)localLinkedHashMap;
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
    kotlin.g.b.s.s(str, "business(LiveCoreSlice::…dkInfo.sdk_create_user_id");
    ((Map)localObject).put(str, new Rect(0, 0, paramInt2, paramInt3));
    return localLinkedHashMap;
  }
  
  private final LinkedHashMap<String, Rect> genRoomPKMicMap(int paramInt1, float paramFloat, JSONObject paramJSONObject, int paramInt2, int paramInt3)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int k = (int)(paramInt2 / 2 * paramFloat);
    Object localObject2 = paramJSONObject.optJSONArray("list");
    if (localObject2 == null) {}
    for (int i = 0; i == 0; i = ((JSONArray)localObject2).length())
    {
      localObject2 = (Map)localLinkedHashMap;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = "";
      }
      ((Map)localObject2).put(paramJSONObject, new Rect(0, 0, paramInt2, paramInt3));
      Log.i(TAG, kotlin.g.b.s.X("genRoomPKMicMap: result:", localLinkedHashMap));
      return localLinkedHashMap;
    }
    Object localObject1 = paramJSONObject.optString("x");
    kotlin.g.b.s.s(localObject1, "micData.optString(\"x\")");
    localObject1 = kotlin.n.n.bJE((String)localObject1);
    label158:
    float f1;
    label190:
    float f2;
    label222:
    float f3;
    label249:
    Map localMap;
    int j;
    if (localObject1 == null)
    {
      paramFloat = 0.0F;
      localObject1 = paramJSONObject.optString("y");
      kotlin.g.b.s.s(localObject1, "micData.optString(\"y\")");
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 != null) {
        break label527;
      }
      f1 = 0.0F;
      localObject1 = paramJSONObject.optString("w");
      kotlin.g.b.s.s(localObject1, "micData.optString(\"w\")");
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 != null) {
        break label537;
      }
      f2 = 0.0F;
      paramJSONObject = paramJSONObject.optString("h");
      kotlin.g.b.s.s(paramJSONObject, "micData.optString(\"h\")");
      paramJSONObject = kotlin.n.n.bJE(paramJSONObject);
      if (paramJSONObject != null) {
        break label547;
      }
      f3 = 0.0F;
      localMap = (Map)localLinkedHashMap;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw;
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = "";
      }
      paramInt3 = (int)(paramInt2 * paramFloat);
      i = (int)(paramInt1 + k * f1);
      j = (int)((paramFloat + f2) * paramInt2);
      paramFloat = paramInt1;
      localMap.put(paramJSONObject, new Rect(paramInt3, i, j, (int)((f1 + f3) * k + paramFloat)));
      i = 0;
      if (localObject2 != null) {
        break label556;
      }
      paramInt3 = 0;
      label365:
      if (paramInt3 <= 0) {
        break label564;
      }
      label370:
      j = i + 1;
      if (localObject2 != null) {
        break label566;
      }
      paramJSONObject = null;
      label383:
      if (paramJSONObject != null) {
        break label577;
      }
      paramFloat = 0.0F;
      label389:
      if (paramJSONObject != null) {
        break label622;
      }
      f1 = 0.0F;
      label396:
      if (paramJSONObject != null) {
        break label670;
      }
      f2 = 0.0F;
      label403:
      if (paramJSONObject != null) {
        break label718;
      }
      f3 = 0.0F;
      label410:
      if (paramJSONObject != null) {
        break label766;
      }
    }
    label527:
    label537:
    label547:
    label556:
    label564:
    label566:
    label577:
    label622:
    label766:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optString("uId"))
    {
      localMap = (Map)localLinkedHashMap;
      localObject1 = paramJSONObject;
      if (paramJSONObject == null) {
        localObject1 = "";
      }
      i = (int)(paramInt2 * paramFloat);
      int m = (int)(paramInt1 + k * f1);
      int n = (int)((f2 + paramFloat) * paramInt2);
      paramFloat = paramInt1;
      localMap.put(localObject1, new Rect(i, m, n, (int)((f3 + f1) * k + paramFloat)));
      if (j >= paramInt3) {
        break;
      }
      i = j;
      break label370;
      paramFloat = ((Float)localObject1).floatValue();
      break label158;
      f1 = ((Float)localObject1).floatValue();
      break label190;
      f2 = ((Float)localObject1).floatValue();
      break label222;
      f3 = paramJSONObject.floatValue();
      break label249;
      paramInt3 = ((JSONArray)localObject2).length();
      break label365;
      break;
      paramJSONObject = ((JSONArray)localObject2).optJSONObject(i);
      break label383;
      localObject1 = paramJSONObject.optString("x");
      if (localObject1 == null)
      {
        paramFloat = 0.0F;
        break label389;
      }
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 == null)
      {
        paramFloat = 0.0F;
        break label389;
      }
      paramFloat = ((Float)localObject1).floatValue();
      break label389;
      localObject1 = paramJSONObject.optString("y");
      if (localObject1 == null)
      {
        f1 = 0.0F;
        break label396;
      }
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 == null)
      {
        f1 = 0.0F;
        break label396;
      }
      f1 = ((Float)localObject1).floatValue();
      break label396;
      localObject1 = paramJSONObject.optString("w");
      if (localObject1 == null)
      {
        f2 = 0.0F;
        break label403;
      }
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 == null)
      {
        f2 = 0.0F;
        break label403;
      }
      f2 = ((Float)localObject1).floatValue();
      break label403;
      localObject1 = paramJSONObject.optString("h");
      if (localObject1 == null)
      {
        f3 = 0.0F;
        break label410;
      }
      localObject1 = kotlin.n.n.bJE((String)localObject1);
      if (localObject1 == null)
      {
        f3 = 0.0F;
        break label410;
      }
      f3 = ((Float)localObject1).floatValue();
      break label410;
    }
  }
  
  private final void networkChange(int paramInt)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.b.a)localIterator.next()).onNetworkChange(paramInt);
    }
  }
  
  private final void onLandscapeActionImpl(int paramInt1, int paramInt2, Bundle paramBundle, Object paramObject)
  {
    paramInt2 = 0;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = true;
    if ((paramBundle != null) && (paramBundle.containsKey("ACTION_POST_LANDSCAPE_DELAY") == true))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        if (paramBundle != null) {
          break label184;
        }
      }
    }
    label184:
    for (paramObject = null;; paramObject = Integer.valueOf(paramBundle.getInt("ACTION_POST_LANDSCAPE_DELAY")))
    {
      paramInt2 = paramObject.intValue();
      Log.i(TAG, "onLandscapeAction action:" + paramBundle + ", orientation:" + getContext().getResources().getConfiguration().orientation + ",delayMs:" + paramInt2);
      paramObject = ((Iterable)getPluginList()).iterator();
      while (paramObject.hasNext())
      {
        com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)paramObject.next();
        if (((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (paramInt2 <= 0)) {
          ((com.tencent.mm.plugin.finder.live.plugin.b)locala).aq(paramBundle);
        }
      }
      paramInt1 = 0;
      break;
    }
  }
  
  private final void onPortraitActionImpl(int paramInt1, int paramInt2, Bundle paramBundle, Object paramObject)
  {
    paramInt2 = 0;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = true;
    Object localObject;
    if ((paramBundle != null) && (paramBundle.containsKey("ACTION_POST_PORTRAIT_DELAY") == true))
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramBundle != null) {
          break label188;
        }
        localObject = null;
        label58:
        paramInt2 = ((Integer)localObject).intValue();
      }
      Log.i(TAG, "onPortraitAction action:" + paramBundle + ", orientation:" + getContext().getResources().getConfiguration().orientation + ",delayMs:" + paramInt2);
      localObject = ((Iterable)getPluginList()).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)((Iterator)localObject).next();
      if ((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b))
      {
        if (paramInt2 > 0)
        {
          ((com.tencent.mm.plugin.finder.live.plugin.b)locala).a(paramBundle, paramObject, paramInt2);
          continue;
          paramInt1 = 0;
          break;
          label188:
          localObject = Integer.valueOf(paramBundle.getInt("ACTION_POST_PORTRAIT_DELAY"));
          break label58;
        }
        ((com.tencent.mm.plugin.finder.live.plugin.b)locala).c(paramBundle, paramObject);
      }
    }
  }
  
  private final void onScreenClearEnd()
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if (((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)locala).eoI())) {
        ((com.tencent.mm.plugin.finder.live.plugin.b)locala).qW(true);
      }
    }
  }
  
  private final void onScreenClearStart()
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if (((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)locala).eoI())) {
        ((com.tencent.mm.plugin.finder.live.plugin.b)locala).qV(true);
      }
    }
  }
  
  private final void onScreenRecoveryEnd()
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if (((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)locala).eoI())) {
        ((com.tencent.mm.plugin.finder.live.plugin.b)locala).qW(false);
      }
    }
  }
  
  private final void onScreenRecoveryStart()
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if (((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)locala).eoI())) {
        ((com.tencent.mm.plugin.finder.live.plugin.b)locala).qV(false);
      }
    }
  }
  
  private static final void showAlertDialog$lambda-21(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrD, "2");
    }
    Log.i(TAG, kotlin.g.b.s.X("showAlertDialog click bOk:", Boolean.valueOf(paramBoolean2)));
  }
  
  private final void showStatistics()
  {
    final com.tencent.mm.live.core.core.model.e locale = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).Efc;
    Object localObject = aw.Gjk;
    if ((!aw.bgV()) || (locale == null)) {
      return;
    }
    business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class);
    if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.eyO())
    {
      localObject = com.tencent.mm.plugin.finder.report.u.FrJ;
      com.tencent.mm.plugin.finder.report.u.a((u.b)new k(this, locale));
      return;
    }
    hideStatistics();
  }
  
  private final void startPauseTime()
  {
    this.loadingTipWidget.startPauseTime();
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void activate(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    kotlin.g.b.s.u(paramf, "config");
    this.checkMiniWin = false;
    if (paramBoolean2)
    {
      paramf = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!activate$isPayForChargeLive(this)))
      {
        paramf = MMApplicationContext.getContext().getResources().getString(p.h.CtH);
        kotlin.g.b.s.s(paramf, "getContext().resources.g…sitor_role_changing_tips)");
        showProgressWithTips(paramf);
      }
    }
  }
  
  public final void applyLiveScene(int paramInt)
  {
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).PZ(paramInt);
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if ((locala instanceof com.tencent.mm.plugin.finder.live.plugin.b)) {
        locala.tO(((com.tencent.mm.plugin.finder.live.plugin.b)locala).CTl);
      }
    }
  }
  
  public void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.live.b.a)localIterator.next()).applyState(paramInt1, paramInt2, paramBundle);
    }
  }
  
  public void bindData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    boolean bool2 = false;
    kotlin.g.b.s.u(paramf, "data");
    Log.i(TAG, "bind view:" + hashCode() + "  liveId:" + paramf.Ebr.liveId);
    setData(paramf);
    setBuContext(paramf.BxG);
    paramf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSl().bmg()).intValue() == 1)
    {
      bool1 = true;
      paramf.EdF = bool1;
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSm().bmg()).intValue() != 1) {
        break label204;
      }
    }
    label204:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramf.EdG = bool1;
      paramf = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramf.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (!com.tencent.d.a.a.a.a.a.jSR())
      {
        localObject = aw.Gjk;
        bool1 = bool2;
        if (!aw.bgV()) {}
      }
      else
      {
        bool1 = true;
      }
      paramf.Egt = bool1;
      paramf = this.loadingTipWidget;
      localObject = getBuContext();
      kotlin.g.b.s.u(localObject, "liveData");
      paramf.CvU = ((com.tencent.mm.plugin.finder.live.model.context.a)localObject);
      return;
      bool1 = false;
      break;
    }
  }
  
  public <T extends androidx.lifecycle.af> T business(Class<T> paramClass)
  {
    kotlin.g.b.s.u(paramClass, "bu");
    return getBuContext().business(paramClass);
  }
  
  public final boolean changeScreenOrientation()
  {
    boolean bool = true;
    ai localai;
    Object localObject1;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      localai = this.rotationHelper;
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label183;
        }
        label46:
        if (localObject1 != null) {
          break label224;
        }
        bool = false;
      }
    }
    for (;;)
    {
      label52:
      Object localObject2 = localai.TAG;
      StringBuilder localStringBuilder = new StringBuilder("changeScreenOrientation curOrientation:").append(localObject1).append(",requestOrientation:");
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation()))
      {
        Log.i((String)localObject2, localObject1);
        localObject1 = (MMFinderUI)localai.CGS.get();
        if (localObject1 != null)
        {
          int i = ((MMFinderUI)localObject1).getRequestedOrientation();
          com.tencent.mm.plugin.finder.live.report.k.Doi.N(false, i);
        }
        return bool;
        localObject1 = ((MMFinderUI)localObject1).getResources();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((Resources)localObject1).getConfiguration();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
        break;
        label183:
        if (((Integer)localObject1).intValue() != 2) {
          break label46;
        }
        localObject2 = (MMFinderUI)localai.CGS.get();
        if (localObject2 == null) {
          break label278;
        }
        ((MMFinderUI)localObject2).FVH = true;
        ((MMFinderUI)localObject2).setRequestedOrientation(1);
        break label52;
        label224:
        if (((Integer)localObject1).intValue() != 1) {
          break label278;
        }
        localObject2 = (MMFinderUI)localai.CGS.get();
        if (localObject2 == null) {
          break label278;
        }
        ((MMFinderUI)localObject2).FVH = true;
        ((MMFinderUI)localObject2).setRequestedOrientation(0);
        break label52;
      }
      return false;
      label278:
      bool = false;
    }
  }
  
  public final boolean changeScreenToLandscape()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ai localai;
    label50:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      localai = this.rotationHelper;
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label123;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label162;
      }
      bool1 = bool2;
      localObject2 = localai.TAG;
      localStringBuilder = new StringBuilder("changeScreenToLandscape curOrientation:").append(localObject1).append(",requestOrientation:");
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label209;
      }
    }
    label162:
    label209:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation()))
    {
      Log.i((String)localObject2, localObject1 + ",change:" + bool1);
      return bool1;
      label123:
      localObject1 = ((MMFinderUI)localObject1).getResources();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Resources)localObject1).getConfiguration();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
      break;
      bool1 = bool2;
      if (((Integer)localObject1).intValue() != 1) {
        break label50;
      }
      localObject2 = (MMFinderUI)localai.CGS.get();
      bool1 = bool2;
      if (localObject2 == null) {
        break label50;
      }
      ((MMFinderUI)localObject2).FVH = true;
      ((MMFinderUI)localObject2).setRequestedOrientation(0);
      bool1 = true;
      break label50;
    }
  }
  
  public final boolean changeScreenToPortrait()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    ai localai;
    label50:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      localai = this.rotationHelper;
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label123;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label162;
      }
      bool1 = bool2;
      localObject2 = localai.TAG;
      localStringBuilder = new StringBuilder("changeScreenToPortrait curOrientation:").append(localObject1).append(",requestOrientation:");
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label209;
      }
    }
    label162:
    label209:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation()))
    {
      Log.i((String)localObject2, localObject1 + ",change:" + bool1);
      return bool1;
      label123:
      localObject1 = ((MMFinderUI)localObject1).getResources();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Resources)localObject1).getConfiguration();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
      break;
      bool1 = bool2;
      if (((Integer)localObject1).intValue() != 2) {
        break label50;
      }
      localObject2 = (MMFinderUI)localai.CGS.get();
      bool1 = bool2;
      if (localObject2 == null) {
        break label50;
      }
      ((MMFinderUI)localObject2).FVH = true;
      ((MMFinderUI)localObject2).setRequestedOrientation(1);
      bool1 = true;
      break label50;
    }
  }
  
  public boolean checkFinishWhenDiffTask(Activity paramActivity)
  {
    kotlin.g.b.s.u(paramActivity, "activity");
    if (((getContext() instanceof MMFinderUI)) && (!kotlin.g.b.s.p(getContext().getClass(), paramActivity.getClass())))
    {
      paramActivity = getContext();
      if (paramActivity == null) {
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
      }
      paramActivity = (MMFinderUI)paramActivity;
      if (paramActivity.getLifecycle().getCurrentState() != j.b.bHg)
      {
        this.finishActivityNotReleaseLive = true;
        paramActivity.finish();
      }
      return true;
    }
    return false;
  }
  
  public final void checkPauseStateWhenLiveStart()
  {
    bix localbix = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeq;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkPauseStateWhenLiveStart FinderLiveLayerShowInfo:");
    if (localbix == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(", ");
      if (localbix != null) {
        break label110;
      }
    }
    label110:
    for (Object localObject = null;; localObject = Integer.valueOf(localbix.ZSF))
    {
      Log.e(str, localObject + '!');
      if (localbix != null)
      {
        updateLayerShowInfo(localbix, true);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeq = null;
      }
      return;
      localObject = Integer.valueOf(localbix.show_type);
      break;
    }
  }
  
  public final void disableRatation()
  {
    Log.i(TAG, "disableOritation");
    com.tencent.mm.plugin.mmsight.model.d locald = this.orientationEventListener;
    if (locald != null) {
      locald.disable();
    }
    locald = this.orientationEventListener;
    if (locald != null) {
      locald.KUU = null;
    }
    this.orientationEventListener = null;
  }
  
  public final void enableAutoRotation()
  {
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      ai localai = this.rotationHelper;
      try
      {
        if (Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation") == 1)
        {
          MMFinderUI localMMFinderUI = (MMFinderUI)localai.CGS.get();
          if ((localMMFinderUI != null) && (localMMFinderUI.getRequestedOrientation() != -1))
          {
            localMMFinderUI.FVH = true;
            localMMFinderUI.setRequestedOrientation(-1);
          }
        }
        else
        {
          Log.i(localai.TAG, "enableAutoRotation ACCELEROMETER_ROTATION failed!");
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e(localai.TAG, kotlin.g.b.s.X("enableAutoRotation ", localException.getMessage()));
      }
    }
  }
  
  public final void enableRotation()
  {
    Log.i(TAG, "enableOritation");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda) {
        lockScreenRotation();
      }
      if (this.orientationEventListener == null) {
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(getContext(), (byte)0);
      }
      com.tencent.mm.plugin.mmsight.model.d locald = this.orientationEventListener;
      if (locald != null) {
        locald.KUU = ((d.a)this);
      }
      locald = this.orientationEventListener;
      if (locald != null) {
        locald.enable();
      }
    }
  }
  
  public final boolean fillBlurBg(String paramString, boolean paramBoolean)
  {
    return this.loadingTipWidget.fillBlurBg(paramString, paramBoolean);
  }
  
  public void finish()
  {
    if ((getContext() instanceof MMFinderUI))
    {
      this.isManualClosed = true;
      Context localContext = getContext();
      if (localContext == null) {
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
      }
      ((MMFinderUI)localContext).finish();
    }
  }
  
  public final void forceScreenToLandscape()
  {
    disableRatation();
    if (changeScreenToLandscape())
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = true;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = false;
    }
  }
  
  public final void forceScreenToPortrait()
  {
    disableRatation();
    if (changeScreenToPortrait() == true)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = true;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = false;
    }
  }
  
  public View genRootViewByStub(int paramInt, View paramView)
  {
    kotlin.g.b.s.u(paramView, "root");
    paramView = ((ViewStub)paramView.findViewById(paramInt)).inflate();
    kotlin.g.b.s.s(paramView, "stub.inflate()");
    return paramView;
  }
  
  public final boolean getAudienPreloadCDNLiveConfig()
  {
    return this.audienPreloadCDNLiveConfig;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a getBuContext()
  {
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.buContext;
    if (locala != null) {
      return locala;
    }
    kotlin.g.b.s.bIx("buContext");
    return null;
  }
  
  public final boolean getCheckMiniWin()
  {
    return this.checkMiniWin;
  }
  
  public final com.tencent.mm.plugin.finder.live.widget.manager.a getConfettiBitmapManager()
  {
    return this.confettiBitmapManager;
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
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.f getData()
  {
    com.tencent.mm.plugin.finder.live.viewmodel.data.f localf = this.data;
    if (localf != null) {
      return localf;
    }
    kotlin.g.b.s.bIx("data");
    return null;
  }
  
  public final b getExternalCallback()
  {
    return this.externalCallback;
  }
  
  public ap getFinderLiveAssistant()
  {
    aj localaj = aj.CGT;
    return aj.getFinderLiveAssistant();
  }
  
  public final boolean getFinishActivityNotReleaseLive()
  {
    return this.finishActivityNotReleaseLive;
  }
  
  protected final int getLastLiveState()
  {
    return this.lastLiveState;
  }
  
  public final JSONObject getLastMicData()
  {
    return this.lastMicData;
  }
  
  public final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.h> getLastMicUserList()
  {
    return this.lastMicUserList;
  }
  
  public final int getLastOrientation()
  {
    return this.lastOrientation;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.data.h getLastPkMicUser()
  {
    return this.lastPkMicUser;
  }
  
  public final JSONArray getLastRoomPkMicUserList()
  {
    return this.lastRoomPkMicUserList;
  }
  
  public final int getLastRotationFromSensor()
  {
    return this.lastRotationFromSensor;
  }
  
  protected final int getLastUIState()
  {
    return this.lastUIState;
  }
  
  protected final ak getLoadingTipWidget()
  {
    return this.loadingTipWidget;
  }
  
  public final boolean getMiniWinPermission()
  {
    return this.miniWinPermission;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.d getOrientationEventListener()
  {
    return this.orientationEventListener;
  }
  
  public <T extends com.tencent.mm.plugin.finder.live.plugin.b> T getPlugin(Class<T> paramClass)
  {
    kotlin.g.b.s.u(paramClass, "modelClass");
    synchronized ((Iterable)getPluginList())
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
        if (paramClass.isInstance(locala))
        {
          paramClass = (com.tencent.mm.plugin.finder.live.plugin.b)locala;
          return paramClass;
        }
      }
      paramClass = ah.aiuX;
      return null;
    }
  }
  
  public final List<com.tencent.mm.live.b.a> getPlugins()
  {
    return (List)getPluginList();
  }
  
  public final RelativeLayout getPreviewRoot()
  {
    return this.previewRoot;
  }
  
  public final r<Integer, Integer> getScreenSize()
  {
    int j = bf.bf(getContext()).x;
    int i = bf.bf(getContext()).y;
    Object localObject = getContext();
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      if (localObject == null) {
        break label100;
      }
      localObject = ((Activity)localObject).findViewById(p.e.BKe);
      if ((localObject == null) || (((View)localObject).getWidth() <= 0) || (((View)localObject).getHeight() <= 0)) {
        break label100;
      }
      j = ((View)localObject).getWidth();
      i = ((View)localObject).getHeight();
    }
    label100:
    for (;;)
    {
      return new r(Integer.valueOf(j), Integer.valueOf(i));
      localObject = null;
      break;
    }
  }
  
  public final bb getStatisticsWidget()
  {
    return this.statisticsWidget;
  }
  
  public final Fragment getUicFragment()
  {
    return this.uicFragment;
  }
  
  public final bm getWarnningCountWidget()
  {
    return (bm)this.warnningCountWidget$delegate.getValue();
  }
  
  public final void goGetLuckMoney(Activity paramActivity, String paramString)
  {
    kotlin.g.b.s.u(paramActivity, "activity");
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) {
      Log.w(TAG, "goGetLuckMoney redPacketId:" + paramString + " return for isTeenMode");
    }
    do
    {
      return;
      Log.i(TAG, kotlin.g.b.s.X("goGetLuckMoney redPacketId:", paramString));
    } while (paramString == null);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
      localObject = l.k.mYO;
    }
    for (int i = l.k.bhG();; i = l.k.bhH())
    {
      localObject = getFinderLiveAssistant();
      if (localObject == null) {
        break;
      }
      ((ap)localObject).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, i, kotlin.a.p.listOf(paramString), (ae.a)new h(new WeakReference(this), new WeakReference(paramActivity)));
      return;
      localObject = l.k.mYO;
    }
  }
  
  public final void handleRecvLuckyMoneyErr(int paramInt)
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramInt, this));
  }
  
  public void hideLoadingLayer(boolean paramBoolean)
  {
    this.loadingTipWidget.hideLoadingLayer(paramBoolean);
  }
  
  public final void hideProgress()
  {
    this.loadingTipWidget.hideProgress();
  }
  
  public final void hideStatistics()
  {
    bb localbb = this.statisticsWidget;
    if (localbb != null) {
      localbb.hideStatistics();
    }
  }
  
  public void hideTimeCount()
  {
    ak.a(this.loadingTipWidget);
  }
  
  public void initLogic(LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramLiveConfig, "config");
  }
  
  public final boolean isDestroyed()
  {
    if ((getContext() != null) && ((getContext() instanceof Activity)))
    {
      Context localContext = getContext();
      if (localContext == null) {
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      }
      return ((Activity)localContext).isDestroyed();
    }
    return false;
  }
  
  public final boolean isLiveFinished()
  {
    return ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyA();
  }
  
  public final boolean isLiveStarted()
  {
    return ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted();
  }
  
  public final boolean isManualClosed()
  {
    return this.isManualClosed;
  }
  
  public boolean isSwipeBack()
  {
    Object localObject = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    kotlin.g.b.s.u(localObject, "context");
    return com.tencent.mm.plugin.findersdk.e.a.fsp().gs((Context)localObject);
  }
  
  public void keyboardChange(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)localIterator.next();
      if (locala.mJe.getVisibility() == 0) {
        locala.keyboardChange(paramBoolean, paramInt);
      }
    }
  }
  
  public final void lockScreenRotation()
  {
    ai localai;
    label42:
    label46:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC())
    {
      localai = this.rotationHelper;
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label104;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label143;
      }
      if (localObject1 != null) {
        break label232;
      }
      localObject2 = localai.TAG;
      localStringBuilder = new StringBuilder("lockScreenRotation curOrientation:").append(localObject1).append(",requestOrientation:");
      localObject1 = (MMFinderUI)localai.CGS.get();
      if (localObject1 != null) {
        break label268;
      }
    }
    label268:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(((MMFinderUI)localObject1).getRequestedOrientation()))
    {
      Log.i((String)localObject2, localObject1);
      return;
      label104:
      localObject1 = ((MMFinderUI)localObject1).getResources();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((Resources)localObject1).getConfiguration();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((Configuration)localObject1).orientation);
      break;
      label143:
      if (((Integer)localObject1).intValue() != 2) {
        break label42;
      }
      localObject2 = (MMFinderUI)localai.CGS.get();
      if (localObject2 == null) {
        break label46;
      }
      ((MMFinderUI)localObject2).FVH = true;
      if (((MMFinderUI)localObject2).getContext().getWindow().getWindowManager().getDefaultDisplay().getRotation() == 1)
      {
        ((MMFinderUI)localObject2).setRequestedOrientation(0);
        break label46;
      }
      if (((MMFinderUI)localObject2).getContext().getWindow().getWindowManager().getDefaultDisplay().getRotation() != 3) {
        break label46;
      }
      ((MMFinderUI)localObject2).setRequestedOrientation(8);
      break label46;
      label232:
      if (((Integer)localObject1).intValue() != 1) {
        break label46;
      }
      localObject2 = (MMFinderUI)localai.CGS.get();
      if (localObject2 == null) {
        break label46;
      }
      ((MMFinderUI)localObject2).FVH = true;
      ((MMFinderUI)localObject2).setRequestedOrientation(1);
      break label46;
    }
  }
  
  public void mount()
  {
    super.mount();
    com.tencent.mm.kernel.h.baD().a((com.tencent.mm.network.p)this.onNetworkChange);
    Object localObject = com.tencent.mm.live.model.p.mZf;
    com.tencent.mm.live.model.p.a((com.tencent.mm.live.model.g)this);
    localObject = com.tencent.mm.plugin.finder.live.model.mic.b.CMY;
    com.tencent.mm.plugin.finder.live.model.mic.b.a((com.tencent.mm.plugin.finder.live.model.mic.a)this);
  }
  
  public final boolean needMiniWindow()
  {
    return ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI;
  }
  
  public final boolean needRemoveActivity()
  {
    return ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcJ;
  }
  
  public void notifyAudienceMicUserChange(boolean paramBoolean)
  {
    notifyAudienceMicUserChange(paramBoolean, null);
  }
  
  public final void notifyAudienceMicUserChange(final boolean paramBoolean, final r<Integer, Integer> paramr)
  {
    boolean bool = diffMicUsers();
    Log.i(TAG, "notifyAudienceMicUserChange: diffMicUsers:" + bool + ", checkDiff:" + paramBoolean + ", audienceLinkMicUserList size:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw.size());
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(bool, paramBoolean, this, paramr));
  }
  
  public void notifyPKMicUserChange(boolean paramBoolean)
  {
    notifyPKMicUserChange(paramBoolean, null);
  }
  
  public final void notifyPKMicUserChange(final boolean paramBoolean, final r<Integer, Integer> paramr)
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramBoolean, paramr));
  }
  
  public boolean notifyRoomPKMicUserChange(final JSONObject paramJSONObject, boolean paramBoolean, final r<Integer, Integer> paramr)
  {
    if (paramJSONObject == null)
    {
      Log.i(TAG, "notifyRoomPKMicUserChange: micData is null!");
      return false;
    }
    final JSONArray localJSONArray = paramJSONObject.optJSONArray("list");
    boolean bool = diffRoomPkMicUsers(localJSONArray);
    Log.i(TAG, "notifyRoomPKMicUserChange:diffRoomPkMicUsers:" + bool + ", forceUpdate:" + paramBoolean + ",list:" + localJSONArray);
    if (((bool) || (paramBoolean)) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaOw != null))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, localJSONArray, paramJSONObject, paramr));
      return true;
    }
    return false;
  }
  
  public void onAcceptBattleTimeout() {}
  
  public void onAcceptLiveMic(com.tencent.mm.live.model.a parama)
  {
    kotlin.g.b.s.u(parama, "info");
  }
  
  public void onAcceptMicPkTimeout() {}
  
  public void onAcceptMicTimeout(String paramString) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(TAG, "onActivityResult,requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
  }
  
  public void onAnchorCallInterruption(boolean paramBoolean)
  {
    al localal = al.CHU;
    al.qI(paramBoolean);
  }
  
  public void onAnchorConnectionChange(boolean paramBoolean)
  {
    al localal = al.CHU;
    al.qH(paramBoolean);
  }
  
  public void onApplyBattleTimeout() {}
  
  public void onApplyLiveMic(com.tencent.mm.live.model.b paramb)
  {
    kotlin.g.b.s.u(paramb, "info");
  }
  
  public void onApplyMicPkTimeout() {}
  
  public void onApplyMicTimeout() {}
  
  public void onBanLiveComment(com.tencent.mm.live.model.c paramc)
  {
    kotlin.g.b.s.u(paramc, "info");
  }
  
  public void onCloseApplyLiveMic(com.tencent.mm.live.model.d paramd)
  {
    kotlin.g.b.s.u(paramd, "info");
  }
  
  public void onCloseLive(com.tencent.mm.live.model.e parame)
  {
    kotlin.g.b.s.u(parame, "info");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId == parame.liveId)
    {
      parame = al.CHU;
      al.emc();
    }
  }
  
  public void onCloseLiveMic(com.tencent.mm.live.model.f paramf)
  {
    kotlin.g.b.s.u(paramf, "info");
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    label66:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.live.b.a)localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.finder.live.plugin.b)) {}
      for (localObject = (com.tencent.mm.plugin.finder.live.plugin.b)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label66;
        }
        ((com.tencent.mm.plugin.finder.live.plugin.b)localObject).onConfigurationChanged(paramConfiguration);
        break;
      }
    }
  }
  
  public final void onLandscapeAction(int paramInt1, int paramInt2, Bundle paramBundle, Object paramObject)
  {
    if (!isLandscape())
    {
      forceScreenToLandscape();
      return;
    }
    onLandscapeActionImpl(paramInt1, paramInt2, paramBundle, paramObject);
  }
  
  public abstract void onLiveEventCallback(int paramInt, Bundle paramBundle);
  
  public void onLiveMicSucc(com.tencent.mm.live.model.n paramn)
  {
    kotlin.g.b.s.u(paramn, "info");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    label59:
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.live.b.a)localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.finder.live.plugin.b)) {}
      for (localObject = (com.tencent.mm.plugin.finder.live.plugin.b)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label59;
        }
        ((com.tencent.mm.plugin.finder.live.plugin.b)localObject).onNewIntent(paramIntent);
        break;
      }
    }
  }
  
  public void onOnlineLiveList(com.tencent.mm.live.model.s params)
  {
    kotlin.g.b.s.u(params, "info");
  }
  
  public void onOrientationChange(int paramInt)
  {
    if ((this.lastRotationFromSensor == -1) || (this.lastRotationFromSensor != paramInt))
    {
      if (this.lastRotationFromSensor != -1)
      {
        enableAutoRotation();
        if ((getCurrentOrientation() == 1) || (getCurrentOrientation() == 3)) {
          b.b.a((com.tencent.mm.live.b.b)this, b.c.ndm);
        }
      }
      Log.i(TAG, "onOrientationChange lastRotationFromSensor:" + this.lastRotationFromSensor + ",cur orientation:" + paramInt);
      this.lastRotationFromSensor = paramInt;
    }
  }
  
  public final void onPortraitAction(int paramInt1, int paramInt2, Bundle paramBundle, Object paramObject)
  {
    if (isLandscape())
    {
      forceScreenToPortrait();
      return;
    }
    onPortraitActionImpl(paramInt1, paramInt2, paramBundle, paramObject);
  }
  
  public void onRandomMatchTimeout() {}
  
  public void onRandomMicAccept(bdm parambdm, bdt parambdt)
  {
    kotlin.g.b.s.u(parambdm, "appMsg");
    kotlin.g.b.s.u(parambdt, "info");
  }
  
  public void onRandomMicApply(bem parambem)
  {
    kotlin.g.b.s.u(parambem, "info");
  }
  
  public void onScreenClear(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)getPluginList()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (com.tencent.mm.live.b.a)localIterator.next();
      if (((localObject instanceof com.tencent.mm.plugin.finder.live.plugin.b)) && (((com.tencent.mm.plugin.finder.live.plugin.b)localObject).eoI()))
      {
        Log.i(TAG, ((com.tencent.mm.live.b.a)localObject).name() + " screen switch, visibility:" + ((com.tencent.mm.live.b.a)localObject).mJe.getVisibility() + ", cacheVisibility:" + ((com.tencent.mm.plugin.finder.live.plugin.b)localObject).CTl + ", clear:" + paramBoolean);
        localObject = (com.tencent.mm.plugin.finder.live.plugin.b)localObject;
        if (paramBoolean) {}
        for (int i = 8;; i = 65535)
        {
          ((com.tencent.mm.plugin.finder.live.plugin.b)localObject).CTm = i;
          break;
        }
      }
    }
    if (paramBoolean)
    {
      doScreenClearAnimation();
      return;
    }
    doScreenRecoveryAnimation();
  }
  
  public final void processFinderLiveLayerShowInfo(bix parambix)
  {
    Object localObject2 = null;
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("processFinderLiveLayerShowInfo FinderLiveLayerShowInfo:");
    if (parambix == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", ");
      if (parambix != null) {
        break label111;
      }
    }
    label111:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(parambix.ZSF))
    {
      Log.i(str, localObject1 + ", liveStart:" + bool);
      if (parambix != null)
      {
        if (!bool) {
          break label122;
        }
        updateLayerShowInfo(parambix, true);
      }
      return;
      localObject1 = Integer.valueOf(parambix.show_type);
      break;
    }
    label122:
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeq = parambix;
  }
  
  public abstract void release();
  
  public void reset(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b.b.a((com.tencent.mm.live.b.b)this, b.c.nea);
    }
  }
  
  public void resume()
  {
    super.resume();
    this.checkMiniWin = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = true;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcJ = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eez = false;
  }
  
  public final void setAudienPreloadCDNLiveConfig(boolean paramBoolean)
  {
    this.audienPreloadCDNLiveConfig = paramBoolean;
  }
  
  public final void setBuContext(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    kotlin.g.b.s.u(parama, "<set-?>");
    this.buContext = parama;
  }
  
  public final void setCheckMiniWin(boolean paramBoolean)
  {
    this.checkMiniWin = paramBoolean;
  }
  
  public final void setConfettiBitmapManager(com.tencent.mm.plugin.finder.live.widget.manager.a parama)
  {
    this.confettiBitmapManager = parama;
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
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.currentAppId = paramString;
  }
  
  public final void setData(com.tencent.mm.plugin.finder.live.viewmodel.data.f paramf)
  {
    kotlin.g.b.s.u(paramf, "<set-?>");
    this.data = paramf;
  }
  
  public final void setExternalCallback(b paramb)
  {
    this.externalCallback = paramb;
  }
  
  public final void setFinishActivityNotReleaseLive(boolean paramBoolean)
  {
    this.finishActivityNotReleaseLive = paramBoolean;
  }
  
  protected final void setLastLiveState(int paramInt)
  {
    this.lastLiveState = paramInt;
  }
  
  public final void setLastMicData(JSONObject paramJSONObject)
  {
    this.lastMicData = paramJSONObject;
  }
  
  public final void setLastOrientation(int paramInt)
  {
    this.lastOrientation = paramInt;
  }
  
  public final void setLastPkMicUser(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    this.lastPkMicUser = paramh;
  }
  
  public final void setLastRoomPkMicUserList(JSONArray paramJSONArray)
  {
    this.lastRoomPkMicUserList = paramJSONArray;
  }
  
  public final void setLastRotationFromSensor(int paramInt)
  {
    this.lastRotationFromSensor = paramInt;
  }
  
  protected final void setLastUIState(int paramInt)
  {
    this.lastUIState = paramInt;
  }
  
  public final void setManualClosed(boolean paramBoolean)
  {
    this.isManualClosed = paramBoolean;
  }
  
  public final void setMiniWinPermission(boolean paramBoolean)
  {
    this.miniWinPermission = paramBoolean;
  }
  
  public final void setOrientationEventListener(com.tencent.mm.plugin.mmsight.model.d paramd)
  {
    this.orientationEventListener = paramd;
  }
  
  public final void setStatisticsWidget(bb parambb)
  {
    this.statisticsWidget = parambb;
  }
  
  public final boolean showAlertDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int j = 0;
    kotlin.g.b.s.u(paramActivity, "activity");
    Object localObject = this.alertDialog;
    if (localObject == null) {}
    for (localObject = null; (kotlin.g.b.s.p(localObject, Boolean.TRUE)) || (isDestroyed()); localObject = Boolean.valueOf(((com.tencent.mm.ui.widget.a.e)localObject).isShowing())) {
      return false;
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyx();
    int i;
    if (paramString2 != null)
    {
      localObject = new g.a((Context)paramActivity);
      CharSequence localCharSequence = (CharSequence)paramString1;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label237;
        }
        ((g.a)localObject).bDE(paramString2);
        label123:
        ((g.a)localObject).Xdm = true;
        paramActivity = paramActivity.getResources().getString(p.h.ChT);
        kotlin.g.b.s.s(paramActivity, "activity.resources.getSt…ive_alert_dialog_btn_txt)");
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
          break label256;
        }
      }
    }
    for (;;)
    {
      ((g.a)localObject).bDI(paramString3);
      ((g.a)localObject).b(new a..ExternalSyntheticLambda2(paramBoolean)).show();
      if (paramBoolean) {
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrD, "1");
      }
      this.alertDialog = ((g.a)localObject).pRv;
      return true;
      i = 0;
      break;
      label237:
      ((g.a)localObject).bf((CharSequence)paramString1).bDE(paramString2);
      break label123;
      return false;
      label256:
      paramString3 = paramActivity;
    }
  }
  
  public final void showAlertInfo(Activity paramActivity)
  {
    kotlin.g.b.s.u(paramActivity, "activity");
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcO;
    Integer localInteger;
    String str1;
    label38:
    String str2;
    label46:
    String str3;
    if (localObject == null)
    {
      localInteger = null;
      if (localObject != null) {
        break label86;
      }
      str1 = null;
      if (localObject != null) {
        break label96;
      }
      str2 = null;
      if (localObject != null) {
        break label106;
      }
      str3 = null;
      label54:
      if (localObject != null) {
        break label116;
      }
      localObject = null;
      label62:
      if (localInteger != null) {
        break label126;
      }
      label67:
      if (localInteger != null) {
        break label206;
      }
    }
    label86:
    label96:
    label106:
    label116:
    label126:
    do
    {
      do
      {
        return;
        localInteger = Integer.valueOf(((bkf)localObject).type);
        break;
        str1 = ((bkf)localObject).title;
        break label38;
        str2 = ((bkf)localObject).content;
        break label46;
        str3 = ((bkf)localObject).ZTs;
        break label54;
        localObject = ((bkf)localObject).ZTr;
        break label62;
        if (localInteger.intValue() != 1) {
          break label67;
        }
        Log.i(TAG, "showAlertInfo type:" + localInteger + ",title:" + str1 + ",content:" + str2 + ",buttonTitle:" + str3);
        showAlertDialog(paramActivity, str1, str2, str3, true);
        return;
      } while (localInteger.intValue() != 0);
      Log.i(TAG, "showAlertInfo type:" + localInteger + ",title:" + str1 + ",content:" + str2 + ",buttonTitle:" + str3 + ",iconName:" + localObject);
    } while (str1 == null);
    label419:
    for (;;)
    {
      try
      {
        label206:
        int i = getContext().getResources().getIdentifier((String)localObject, "drawable", getContext().getPackageName());
        int j = getContext().getResources().getIdentifier((String)localObject, "raw", getContext().getPackageName());
        if (j == 0) {
          break label419;
        }
        i = j;
        if (i != 0)
        {
          showCenterCustomizeToast(str1, i);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyx();
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrD, "1");
          return;
        }
      }
      catch (Exception localException)
      {
        Log.i(TAG, kotlin.g.b.s.X("showAlertInfo exception:", localException.getMessage()));
        showToast((Context)paramActivity, str1);
        return;
      }
      showToast((Context)paramActivity, str1);
    }
  }
  
  public final void showBlurBg()
  {
    int i = 1;
    ak localak = this.loadingTipWidget;
    Object localObject = localak.Ern;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject = localak.Ern;
        if (localObject != null) {
          ((ValueAnimator)localObject).end();
        }
      }
      localak.Ero.setElevation(localak.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
      localak.titleTv.setVisibility(8);
      localak.descTv.setVisibility(8);
      localak.njJ.setVisibility(8);
      localObject = localak.nmm;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      ak.a(localak);
      return;
      i = 0;
    }
  }
  
  public void showBlurBgWithTimeCount(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramString2, "tip");
    ak localak = this.loadingTipWidget;
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramString2, "tip");
    ValueAnimator localValueAnimator = localak.Ern;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localValueAnimator = localak.Ern;
        if (localValueAnimator != null) {
          localValueAnimator.end();
        }
      }
      localak.CAj.setVisibility(0);
      localak.fillBlurBg(paramString1, true);
      localak.Ero.setElevation(localak.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
      if (Build.VERSION.SDK_INT >= 23) {
        localak.Ero.setForeground(localak.mJe.getContext().getResources().getDrawable(p.b.UN_BW_0_Alpha_0_3));
      }
      localak.Erp.setVisibility(8);
      localak.AkE.setVisibility(8);
      localak.titleTv.setVisibility(0);
      localak.descTv.setVisibility(8);
      localak.njJ.setVisibility(8);
      paramString1 = localak.nmm;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      localak.titleTv.setText((CharSequence)paramString2);
      localak.startPauseTime();
      localak.mJe.requestLayout();
      paramString1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        localak.eBa();
      }
      return;
    }
  }
  
  public final void showCenterCustomizeToast(final String paramString, final int paramInt)
  {
    kotlin.g.b.s.u(paramString, "msg");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(this, paramString, paramInt));
  }
  
  public final void showDebugToast(String paramString)
  {
    kotlin.g.b.s.u(paramString, "content");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      aa.makeText(getContext(), (CharSequence)paramString, 0).show();
    }
  }
  
  public final void showProgress()
  {
    ak localak = this.loadingTipWidget;
    localak.CAj.setVisibility(0);
    localak.Ero.setElevation(localak.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
    localak.Erp.setVisibility(0);
    localak.AkE.setVisibility(8);
    localak.titleTv.setVisibility(8);
    localak.descTv.setVisibility(8);
    localak.njJ.setVisibility(8);
    TextView localTextView = localak.nmm;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    ak.a(localak);
    localak.mJe.requestLayout();
  }
  
  public final void showProgressWithBlurBg(String paramString)
  {
    paramString = this.loadingTipWidget;
    paramString.CAj.setVisibility(0);
    paramString.Ero.setElevation(paramString.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
    paramString.Erp.setVisibility(0);
    paramString.AkE.setVisibility(8);
    paramString.titleTv.setVisibility(8);
    paramString.descTv.setVisibility(8);
    paramString.njJ.setVisibility(8);
    TextView localTextView = paramString.nmm;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    ak.a(paramString);
    paramString.mJe.requestLayout();
  }
  
  public final void showProgressWithTips(String paramString)
  {
    kotlin.g.b.s.u(paramString, "tips");
    ak localak = this.loadingTipWidget;
    kotlin.g.b.s.u(paramString, "tips");
    localak.CAj.setVisibility(0);
    localak.Ero.setElevation(localak.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
    localak.Erp.setVisibility(0);
    localak.AkE.setVisibility(0);
    localak.AkE.setText((CharSequence)paramString);
    localak.titleTv.setVisibility(8);
    localak.descTv.setVisibility(8);
    localak.njJ.setVisibility(8);
    paramString = localak.nmm;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    ak.a(localak);
    localak.mJe.requestLayout();
  }
  
  public final void showTipWithBlurBg(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString2, "tip");
    ak localak = this.loadingTipWidget;
    kotlin.g.b.s.u(paramString2, "tip");
    localak.CAj.setVisibility(0);
    localak.fillBlurBg(paramString1, true);
    localak.Ero.setElevation(localak.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
    localak.Erp.setVisibility(8);
    localak.AkE.setVisibility(8);
    localak.njJ.setVisibility(8);
    paramString1 = localak.nmm;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    localak.titleTv.setVisibility(0);
    localak.titleTv.setText((CharSequence)paramString2);
    localak.descTv.setVisibility(8);
    ak.a(localak);
    localak.mJe.requestLayout();
  }
  
  public void showTipWithBlurBgAction(String paramString1, String paramString2, String paramString3, kotlin.g.a.a<ah> parama)
  {
    kotlin.g.b.s.u(paramString1, "username");
    kotlin.g.b.s.u(paramString2, "tip");
    kotlin.g.b.s.u(paramString3, "actionTxt");
    this.loadingTipWidget.showTipWithBlurBgAction(paramString1, paramString2, paramString3, parama);
  }
  
  public final void showToast(Context paramContext, String paramString)
  {
    kotlin.g.b.s.u(paramContext, "context");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyx();
    if (paramString != null) {
      aa.makeText(paramContext, (CharSequence)paramString, 1).show();
    }
  }
  
  public final void showVerificationLayerInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    kotlin.g.b.s.u(paramString1, "title");
    this.loadingTipWidget.showVerificationLayerInfo(paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramb);
  }
  
  public void start()
  {
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcI = true;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcJ = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eda = false;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eez = false;
  }
  
  public void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    kotlin.g.b.s.u(paramc, "status");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this, paramc, paramBundle));
  }
  
  public void stop()
  {
    super.stop();
    com.tencent.mm.ae.d.B((kotlin.g.a.a)m.DKP);
  }
  
  public void unMount()
  {
    super.unMount();
    Object localObject = com.tencent.mm.live.model.p.mZf;
    com.tencent.mm.live.model.p.release();
    localObject = aj.CGT;
    aj.elm().elc();
    com.tencent.mm.kernel.h.baD().b((com.tencent.mm.network.p)this.onNetworkChange);
    Log.i(TAG, kotlin.g.b.s.X("unMount ", getBuContext()));
    localObject = this.alertDialog;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.e)localObject).dismiss();
    }
    localObject = this.loadingTipWidget;
    MTimerHandler localMTimerHandler = ((ak)localObject).Ers;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    ((ak)localObject).CAj.setVisibility(8);
    release();
  }
  
  public <T extends com.tencent.mm.plugin.finder.live.plugin.b> void unregisterPlugin(Class<T> paramClass)
  {
    kotlin.g.b.s.u(paramClass, "modelClass");
    for (;;)
    {
      int i;
      synchronized (getPluginList())
      {
        Object localObject = getPluginList();
        if (!((Collection)localObject).isEmpty())
        {
          i = 1;
          break label121;
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              com.tencent.mm.live.b.a locala = (com.tencent.mm.live.b.a)((Iterator)localObject).next();
              if (!paramClass.isInstance(locala)) {
                continue;
              }
              paramClass = (com.tencent.mm.plugin.finder.live.plugin.b)locala;
              getPluginList().remove(paramClass);
            }
          }
        }
        else
        {
          i = 0;
          break label121;
          localObject = null;
        }
      }
      paramClass = null;
      continue;
      label121:
      if (i == 0) {}
    }
  }
  
  public final void updateLayerShowInfo(bix parambix, boolean paramBoolean)
  {
    kotlin.g.b.s.u(parambix, "layerShowInfo");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).a(parambix, paramBoolean, (m)new n(this));
  }
  
  public final void updateVerificationButtonState(CharSequence paramCharSequence, boolean paramBoolean)
  {
    ak localak = this.loadingTipWidget;
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label47;
      }
      paramCharSequence = localak.nmm;
      if (paramCharSequence != null) {
        paramCharSequence.setVisibility(8);
      }
    }
    label47:
    do
    {
      return;
      i = 0;
      break;
      TextView localTextView = localak.nmm;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = localak.nmm;
      if (localTextView != null) {
        localTextView.setText(paramCharSequence);
      }
      paramCharSequence = localak.nmm;
    } while (paramCharSequence == null);
    paramCharSequence.setEnabled(paramBoolean);
  }
  
  public final void updateVerificationCountDownTip(CharSequence paramCharSequence)
  {
    ak localak = this.loadingTipWidget;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localak.njJ.setVisibility(8);
      return;
    }
    localak.njJ.setVisibility(0);
    localak.njJ.setText(paramCharSequence);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String getTAG()
    {
      AppMethodBeat.i(358313);
      String str = a.access$getTAG$cp();
      AppMethodBeat.o(358313);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$ExternalCallback;", "", "callback", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "params", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void b(b.c paramc);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$doScreenClearAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358320);
      a.access$onScreenClearEnd(this.DKH);
      AppMethodBeat.o(358320);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(358314);
      a.access$onScreenClearStart(this.DKH);
      AppMethodBeat.o(358314);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$doScreenRecoveryAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358310);
      a.access$onScreenRecoveryEnd(this.DKH);
      AppMethodBeat.o(358310);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(358306);
      a.access$onScreenRecoveryStart(this.DKH);
      AppMethodBeat.o(358306);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(int paramInt, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(boolean paramBoolean1, boolean paramBoolean2, a parama, r<Integer, Integer> paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(a parama, boolean paramBoolean, r<Integer, Integer> paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(a parama, JSONArray paramJSONArray, JSONObject paramJSONObject, r<Integer, Integer> paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends p.a
  {
    i(a parama) {}
    
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(358512);
      a.access$networkChange(this.DKH, paramInt);
      AppMethodBeat.o(358512);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(a parama, String paramString, int paramInt)
    {
      super();
    }
    
    private static final void j(int paramInt, View paramView)
    {
      AppMethodBeat.i(358506);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(paramInt);
        }
      }
      AppMethodBeat.o(358506);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$showStatistics$1", "Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfoCallback;", "callback", "", "memoryInfo", "Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements u.b
  {
    k(a parama, com.tencent.mm.live.core.core.model.e parame) {}
    
    public final void a(u.a parama)
    {
      AppMethodBeat.i(358502);
      kotlin.g.b.s.u(parama, "memoryInfo");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(parama, this.DKH, locale));
      AppMethodBeat.o(358502);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(u.a parama, a parama1, com.tencent.mm.live.core.core.model.e parame)
      {
        super();
      }
      
      private static final void a(a parama, bb parambb, View paramView)
      {
        AppMethodBeat.i(357735);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(parama);
        localb.cH(parambb);
        localb.cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$showStatistics$1$callback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        kotlin.g.b.s.u(parama, "this$0");
        kotlin.g.b.s.u(parambb, "$widget");
        parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class);
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.sm(false);
        parambb.hideStatistics();
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$showStatistics$1$callback$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(357735);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    l(a parama, b.c paramc, Bundle paramBundle)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final m DKP;
    
    static
    {
      AppMethodBeat.i(358475);
      DKP = new m();
      AppMethodBeat.o(358475);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pause", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements m<Boolean, Integer, ah>
  {
    n(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveWarnningCountWidget;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<bm>
  {
    o(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.a
 * JD-Core Version:    0.7.0.1
 */