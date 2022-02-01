package com.tencent.mm.plugin.finder.live.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.a.a.a.b.a.k.a;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.j;
import com.tencent.mm.live.core.core.e.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ay;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.trtc.TRTCCloud;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.r;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/FinderLiveUtil;", "", "()V", "ANCHOR_DIRECTOR_START_FROM_MINIWINDOW", "", "getANCHOR_DIRECTOR_START_FROM_MINIWINDOW", "()Z", "FINDER_LIVE_MMKV", "", "IS_ANCHOR_LIVE_VISITOR_ANONYMOUS_SHOWNED_KEY", "TAG", "TOUCH_DELEGATE_DEFAULT_VALUE", "", "liveListDebug", "getLiveListDebug", "setLiveListDebug", "(Z)V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "addSelfAppMsg", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveInteractiveMsg;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "addSysMsg", "", "content", "adjustHorizontalMarginWhenLandScape", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "ifLeft", "ifRight", "adjustMarginTopInSecondaryLiveRoom", "adjustMarginWhenLandScape", "audienceMicLinked", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "audienceMicWaitingAudio", "audienceMicWaitingVideo", "audioModeFuncEnableByExpt", "audioModeFuncEnableBySwitchFlag", "switchFlag", "", "autoPlayFinderLiveList", "canPlayDesktopSwitchShow", "canShowAnchorPrecheckEntrance", "canShowVisitorRoleEntrance", "checkIfAtMe", "commentData", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "checkIfAtWxMe", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "checkIfReplayBelongLive", "productInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "checkIfReplyMe", "checkIfTickleMe", "visitorRole", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "checkInsertLiveNewReddot", "containAlias", "dataList", "Ljava/util/LinkedList;", "containStock", "platformId", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "clickFeed", "commentScene", "forceFetchObject", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "convertToVisitorLiveData", "tabType", "createShoppingCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "scene", "idList", "enableAnchorMusic", "enableCastScreen", "enableMoclLiveList", "enableShowOlympicReserveGuide", "enterShopService", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "openItemCallback", "Lkotlin/Function0;", "csInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopCustomerServiceInfo;", "enterWxaShopService", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "path", "limitW", "limitH", "finderLivePrePlay", "followBiz", "callback", "Lkotlin/Function1;", "formatLiveNew", "num", "formatNumber", "number", "getAddProductPreloadBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "getAliasInfoList", "getAtName", "getBadgeLevel", "badgeInfos", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "getBadgeRankName", "getBatteryInfo", "", "getBatteryState", "()Ljava/lang/Integer;", "getBatteryTemperature", "getConfettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "generator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "source", "Lcom/tencent/mm/particles/ConfettiSource;", "root", "Landroid/view/ViewGroup;", "getConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentOrientation", "activity", "Landroid/app/Activity;", "getDebugFinderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getExtState", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "buContext", "actionValue", "strvalue", "getFinderCotactForSelfComment", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getFinderLiveAnchorSecondaryDeviceUIClass", "Ljava/lang/Class;", "getFinderLiveAnchorUIClass", "getFinderLiveAndienceFileIdList", "list", "", "", "getFinderLiveMiniProxyUIClass", "getFinderLiveVisitorUIClass", "getGameWeAppVersionType", "getHourList", "day", "formatStrRes", "isIgnoreMinute", "getLanscapePadding", "isScondaryDevice", "getLiveConfettInterval", "getLiveContentSize", "Lkotlin/Pair;", "getLiveContentTop", "getLiveCoverUrl", "liveCoverUrl", "anchorUserName", "getLiveDisplayName", "username", "nickname", "printLog", "getLiveTotalHeat", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)Ljava/lang/Long;", "getLotteryRemainTime", "beginTime", "endTime", "remainTime", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMiniprogramType", "getNoticePickerFirstList", "Lkotlin/Triple;", "getNoticePickerSecondList", "getNoticePickerThirdList", "hour", "getNoticeStartTime", "getPlayDesktopSwitch", "getPreHotBunder", "page", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "preloadType", "getPreHotBundle", "appid", "appUsername", "getPreloadMiniProgramBundleList", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadInfo;", "getRenderMode", "isLandscape", "isScreenShareMode", "getSubMsgString", "msg", "maxCharCount", "withEllapse", "getTickleContact", "getUxInfo", "adId", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Ljava/lang/Long;)Ljava/lang/String;", "getVisibilityString", "visibilityMode", "showDetail", "getVisitorModeString", "visitorMode", "giftFuncEnableByContactFlag", "contactFlag", "goProductReplayUI", "replayId", "session", "jumpId", "hasFollowFinderOrBiz", "hideSoftInput", "isAnchorLive", "isAnchorLiveVisitorAnonymousShowed", "isAnchorLiveWithoutSndDevice", "isAnchorOrAssistant", "isAnchorPluginLayout", "finderBaseLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "isAnchorWithExternalPost", "isAssistantOrAnchorRole", "contact", "isBuyProductMicUser", "userAttrFlag", "isCharging", "isCoupletsEvent", "eventId", "isEqual", "strA", "strB", "enableEmpty", "isFestivalEvent", "isFollowMicUser", "isFriend", "isGotRedPacket", "isInSecondaryDevice", "isLibPagEnabled", "isMyCurrentVisitorRole", "isMyself", "isPortrait", "isRewardMicUser", "isSelf", "isShowNewHeatValue", "liveCommonSlice", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "isThreePartyProduct", "jumpAdPage", "adPage", "Lcom/tencent/mm/protocal/protobuf/AdPage;", "uxInfo", "likeSwitchEnableBySwitchFlag", "flag", "linkMicFuncEnableBySwitchFlag", "value", "micSettingBuyProduct", "micSettingBuyProductSwitch", "micSettingFollow", "micSettingFollowSwitch", "micSettingReward", "micSettingRewardSwitch", "notifyToShowProductBubble", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "parseAliasInfoContent", "msgContent", "parseAliasInfoList", "container", "parseFinderLiveAudienceList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "parseTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "extInfo", "parseToPromoteData", "byteArray", "parseToPromottingData", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteMsgInfo;", "parseUxInfo", "adInfo", "playClickApplaudSound", "prepareAnchorMusicInfo", "Lcom/tencent/mm/ui/MMActivity;", "bgMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "printDebugMsg", "tag", "printVisitorRoleInfo", "prefix", "visitorRoleList", "curVisitorRoleType", "visitorRoleModifyTime", "readLiveListDebugInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "realNotifyToShowProductBubble", "removeFromParent", "child", "Landroid/view/View;", "rewardGainEnableBySwitchFlag", "saveAliasInfoList", "aliasInfoList", "saveLiveListDebugInfo", "info", "savePlayDesktopSwitch", "enable", "saveVisitorRoleInfo", "visitorRoleType", "modifyTime", "screenShareFuncEnableBySwitchFlag", "setAnchorLiveVisitorAnonymousShowed", "isShow", "setBigPitcureBlurBitmap", "view", "bitmap", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "blurBitmap", "setBlurBitmap", "url", "radius", "setBtnStatus", "btn", "Landroid/widget/TextView;", "forceDarkMode", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "maxInputLength", "maxInputSize", "enableEmoji", "configCallback", "setLiveAvatar", "avatarIv", "avatarUrl", "roleType", "setLiveGiftTypeFace", "tv", "setSeekBarTouchDelegate", "seekbarParent", "seekBar", "Landroid/widget/SeekBar;", "SEEK_SCOPE", "setTouchDelegate", "dx", "dy", "setTrtcEnvBeforeEnterRoom", "liveCore", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "showDebugToast", "showGiftHideTip", "showLoading", "show", "tryToDeletePromotingBubble", "updateRemoteLinkMicUserInfo", "sdkUserId", "sdkLiveId", "isAnchor", "sessionId", "vibrate", "visitorAnonymousEnableBySwitchFlag", "watchLiveVisitorCore", "closeLive", "outSideLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a DJT;
  private static final boolean DJU;
  private static final int DJV;
  private static com.tencent.mm.ui.base.w loadingDialog;
  
  static
  {
    AppMethodBeat.i(352471);
    DJT = new a();
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUu().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      DJU = bool;
      DJV = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
      AppMethodBeat.o(352471);
      return;
    }
  }
  
  public static int I(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(351260);
    kotlin.g.b.s.u(paramContext, "context");
    if (com.tencent.mm.ui.aw.bx(paramContext)) {}
    for (int i = bf.getStatusBarHeight(paramContext);; i = 0)
    {
      if (paramBoolean) {
        j = bf.bk(paramContext);
      }
      if (!paramBoolean) {
        break;
      }
      i = kotlin.k.k.qu(i, j);
      j = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_A);
      AppMethodBeat.o(351260);
      return i + j;
    }
    if (i > 0)
    {
      j = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_A);
      AppMethodBeat.o(351260);
      return j + i;
    }
    i = paramContext.getResources().getDimensionPixelOffset(p.c.Edge_3A);
    AppMethodBeat.o(351260);
    return i;
  }
  
  public static void J(final Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(351985);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(paramBoolean, paramContext));
    AppMethodBeat.o(351985);
  }
  
  public static String Pp(int paramInt)
  {
    AppMethodBeat.i(351496);
    if (paramInt == 524288)
    {
      str = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_post_charge_toast_tips);
      kotlin.g.b.s.s(str, "{\n                MMAppl…toast_tips)\n            }");
      AppMethodBeat.o(351496);
      return str;
    }
    if ((paramInt != 0) && (com.tencent.mm.ae.d.ee(paramInt, 7)))
    {
      str = MMApplicationContext.getContext().getResources().getString(p.h.Ctv);
      kotlin.g.b.s.s(str, "{\n                if (sh…          }\n            }");
      AppMethodBeat.o(351496);
      return str;
    }
    String str = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_visibility_public_tips);
    kotlin.g.b.s.s(str, "{\n                if (sh…          }\n            }");
    AppMethodBeat.o(351496);
    return str;
  }
  
  public static String Pq(int paramInt)
  {
    AppMethodBeat.i(351541);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(351541);
      return "";
    case 1: 
      str = MMApplicationContext.getContext().getResources().getString(p.h.CtP);
      kotlin.g.b.s.s(str, "{\n                MMAppl…ole_wechat)\n            }");
      AppMethodBeat.o(351541);
      return str;
    }
    String str = MMApplicationContext.getContext().getResources().getString(p.h.CtL);
    kotlin.g.b.s.s(str, "{\n                MMAppl…ole_finder)\n            }");
    AppMethodBeat.o(351541);
    return str;
  }
  
  public static boolean Pr(int paramInt)
  {
    return paramInt > 0;
  }
  
  public static boolean Ps(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 9999999) || (paramInt == 10000000);
  }
  
  private static ArrayList<List<String>> Pt(int paramInt)
  {
    AppMethodBeat.i(352046);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = kotlin.k.k.a((kotlin.k.e)kotlin.k.k.qt(0, 60), 5);
    int j = ((kotlin.k.e)localObject).fIj;
    int k = ((kotlin.k.e)localObject).aixs;
    int m = ((kotlin.k.e)localObject).rBp;
    int i;
    if (m > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      if ((m >= 0) || (k > j)) {
        break label125;
      }
      i = j;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      localObject = com.tencent.mm.plugin.finder.utils.aw.Uv(i);
      localArrayList2.add(MMApplicationContext.getContext().getResources().getString(p.h.CoY, new Object[] { localObject }));
      if (i == k)
      {
        label125:
        localObject = ((Iterable)localArrayList2).iterator();
        while (((Iterator)localObject).hasNext()) {
          Log.i("getNoticePicker", (String)((Iterator)localObject).next());
        }
        if (paramInt > 0)
        {
          i = 0;
          do
          {
            j = i + 1;
            localArrayList1.add(localArrayList2);
            i = j;
          } while (j < paramInt);
        }
        localArrayList2 = (ArrayList)localArrayList2.clone();
        localObject = new Date(bUu());
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime((Date)localObject);
        j = localCalendar.get(12) / 5 + 1;
        if (j > 0)
        {
          paramInt = 0;
          do
          {
            i = paramInt + 1;
            localArrayList2.remove(0);
            paramInt = i;
          } while (i < j);
        }
        localArrayList1.remove(0);
        if (!((Collection)localArrayList2).isEmpty()) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            localArrayList1.add(0, localArrayList2);
          }
          AppMethodBeat.o(352046);
          return localArrayList1;
        }
      }
      i += m;
    }
  }
  
  public static String Pu(int paramInt)
  {
    AppMethodBeat.i(352063);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(352063);
      return "0";
    }
    if (paramInt < 100)
    {
      AppMethodBeat.o(352063);
      return String.valueOf(paramInt);
    }
    AppMethodBeat.o(352063);
    return "...";
  }
  
  public static int a(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 5;
    AppMethodBeat.i(351341);
    kotlin.g.b.s.u(parama, "liveData");
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu();
    e.b localb = e.b.mKf;
    if (i == e.b.bct()) {
      if (paramBoolean2) {
        i = j;
      }
    }
    for (;;)
    {
      Log.i("FinderLiveUtil", "getRenderMode audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu() + ", renderMode:" + i);
      AppMethodBeat.o(351341);
      return i;
      i = j;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE())
        {
          i = 2;
        }
        else
        {
          i = j;
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX())
          {
            i = j;
            if (!paramBoolean1)
            {
              i = 2;
              continue;
              localb = e.b.mKf;
              if (i == e.b.bcu())
              {
                if (paramBoolean2) {
                  i = 1;
                } else if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet) {
                  i = 1;
                } else if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyE()) {
                  i = 0;
                } else if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX()) {
                  i = 1;
                } else if (paramBoolean1) {
                  i = 1;
                } else {
                  i = 0;
                }
              }
              else
              {
                Log.i("FinderLiveUtil", kotlin.g.b.s.X("unknown audienceMode:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyu())));
                i = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public static com.tencent.mm.particles.c a(Context paramContext, com.tencent.mm.particles.b paramb, com.tencent.mm.particles.d paramd, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(351784);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramb, "generator");
    kotlin.g.b.s.u(paramd, "source");
    kotlin.g.b.s.u(paramViewGroup, "root");
    paramContext = new com.tencent.mm.particles.c(paramContext, paramb, paramd, paramViewGroup).bv(1.0F).an(0.0F, 0.0F).ao(-360.0F, 50.0F);
    paramContext.pwJ = 1000L;
    paramContext.pwj = 1;
    kotlin.g.b.s.s(paramContext, "ConfettiManager(context,…   .setNumInitialCount(1)");
    AppMethodBeat.o(351784);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.appbrand.api.g a(aka paramaka)
  {
    AppMethodBeat.i(351838);
    kotlin.g.b.s.u(paramaka, "page");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramaka.appid;
    localg.qAF = paramaka.path;
    ay localay = new ay();
    localay.CIE = 1;
    localay.CIJ = 3;
    ah localah = ah.aiuX;
    localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localay);
    if (bUx()) {}
    for (int i = 1176;; i = 1177)
    {
      localg.scene = i;
      localg.qAT = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, false, null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16777212);
      localg.username = paramaka.username;
      localg.euz = bUq();
      AppMethodBeat.o(351838);
      return localg;
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.api.g a(bih parambih)
  {
    AppMethodBeat.i(351831);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    Object localObject1;
    label51:
    Object localObject2;
    if (parambih != null)
    {
      localObject1 = parambih.ZRp;
      if (localObject1 != null) {
        break label241;
      }
      localObject1 = "";
      localg.appId = ((String)localObject1);
      localObject1 = parambih.ZRp;
      if (localObject1 != null) {
        break label259;
      }
      localObject1 = "";
      localg.qAF = ((String)localObject1);
      localObject1 = new ay();
      ((ay)localObject1).CIE = 1;
      ((ay)localObject1).CIJ = 1;
      localObject2 = ah.aiuX;
      localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject1);
      if (!bUx()) {
        break label277;
      }
      i = 1176;
      label98:
      localg.scene = i;
      localg.qAT = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, false, null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16777212);
      parambih = parambih.ZRp;
      if (parambih != null) {
        break label284;
      }
      parambih = null;
      label155:
      localg.username = parambih;
      parambih = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if ((com.tencent.mm.plugin.finder.utils.aw.bgV()) && (!Util.isNullOrNil(localg.username)))
      {
        parambih = localg.username;
        if ((parambih == null) || (kotlin.n.n.rs(parambih, "@app"))) {
          break label292;
        }
      }
    }
    label259:
    label277:
    label284:
    label292:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localg.username = kotlin.g.b.s.X(localg.username, "@app");
      }
      localg.euz = bUq();
      AppMethodBeat.o(351831);
      return localg;
      label241:
      localObject2 = ((bzd)localObject1).appId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject2 = ((bzd)localObject1).aail;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label51;
      }
      localObject1 = "";
      break label51;
      i = 1177;
      break label98;
      parambih = parambih.YYZ;
      break label155;
    }
  }
  
  public static FinderLiveBundle a(ArrayList<cc> paramArrayList, cc paramcc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(351174);
    kotlin.g.b.s.u(paramArrayList, "data");
    kotlin.g.b.s.u(paramcc, "clickFeed");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((Iterable)paramArrayList).iterator();
    Object localObject2;
    label118:
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed))
      {
        paramArrayList = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (com.tencent.mm.plugin.finder.utils.aw.s((BaseFinderFeed)localObject2))
        {
          paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
          boolean bool;
          if (paramArrayList != null)
          {
            paramArrayList = paramArrayList.getLiveInfo();
            if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
            {
              i = 1;
              if (i == 0) {
                break label321;
              }
              paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(((cc)localObject2).bZA()).append(",is click feed:");
              if (((cc)localObject2).bZA() != paramcc.bZA()) {
                break label282;
              }
              bool = true;
              label170:
              localObject3 = paramArrayList.append(bool).append(",nickname:");
              paramArrayList = ((BaseFinderFeed)localObject2).contact;
              if (paramArrayList != null) {
                break label288;
              }
              paramArrayList = null;
              label199:
              localObject3 = ((StringBuilder)localObject3).append(paramArrayList).append(",live status:");
              paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
              if (paramArrayList != null) {
                break label296;
              }
              paramArrayList = null;
            }
          }
          for (;;)
          {
            Log.i("FinderLiveUtil", paramArrayList + '!');
            if (((cc)localObject2).bZA() != paramcc.bZA()) {
              break;
            }
            localArrayList.add(localObject2);
            break;
            i = 0;
            break label118;
            label282:
            bool = false;
            break label170;
            label288:
            paramArrayList = paramArrayList.getNickname();
            break label199;
            label296:
            paramArrayList = paramArrayList.getLiveInfo();
            if (paramArrayList == null) {
              paramArrayList = null;
            } else {
              paramArrayList = Integer.valueOf(paramArrayList.liveStatus);
            }
          }
          label321:
          localArrayList.add(localObject2);
        }
      }
    }
    int i = kotlin.a.p.a((List)localArrayList, paramcc);
    if (i >= 0) {}
    for (;;)
    {
      localObject1 = new FinderLiveBundle();
      ((FinderLiveBundle)localObject1).CEY = i;
      ((FinderLiveBundle)localObject1).hJx = paramInt1;
      ((FinderLiveBundle)localObject1).AJo = paramInt2;
      localObject2 = (Iterable)localArrayList;
      paramArrayList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (BaseFinderFeed)((Iterator)localObject2).next();
        com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        paramArrayList.add(com.tencent.mm.plugin.finder.utils.aw.a(((BaseFinderFeed)localObject3).feedObject.getFeedObject(), 0, false, 6));
      }
      i = 0;
    }
    ((FinderLiveBundle)localObject1).ag(new ArrayList((Collection)paramArrayList));
    if ((paramcc instanceof BaseFinderFeed))
    {
      paramArrayList = (BaseFinderFeed)paramcc;
      if (paramArrayList != null) {
        break label553;
      }
      paramArrayList = "";
      label507:
      ((FinderLiveBundle)localObject1).awv(paramArrayList);
      paramArrayList = (BaseFinderFeed)kotlin.a.p.ae((List)localArrayList, i);
      if (paramArrayList != null) {
        break label587;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((FinderLiveBundle)localObject1).extFlag = paramInt1;
      AppMethodBeat.o(351174);
      return localObject1;
      paramArrayList = null;
      break;
      label553:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label507;
      }
      paramcc = paramArrayList.getNickName();
      paramArrayList = paramcc;
      if (paramcc != null) {
        break label507;
      }
      paramArrayList = "";
      break label507;
      label587:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramInt1 = 0;
      }
      else
      {
        paramArrayList = paramArrayList.getFeedObject();
        if (paramArrayList == null)
        {
          paramInt1 = 0;
        }
        else
        {
          paramArrayList = paramArrayList.liveInfo;
          if (paramArrayList == null) {
            paramInt1 = 0;
          } else {
            paramInt1 = paramArrayList.ZRR;
          }
        }
      }
    }
  }
  
  public static FinderLiveBundle a(ArrayList<cc> paramArrayList, cc paramcc, int paramInt, boolean paramBoolean, bcl parambcl)
  {
    AppMethodBeat.i(351158);
    kotlin.g.b.s.u(paramArrayList, "data");
    kotlin.g.b.s.u(paramcc, "clickFeed");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((Iterable)paramArrayList).iterator();
    Object localObject2;
    label120:
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      boolean bool = localObject2 instanceof BaseFinderFeed;
      paramArrayList = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if ((com.tencent.mm.plugin.finder.utils.aw.s((BaseFinderFeed)localObject2) & bool))
      {
        paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getLiveInfo();
          if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
          {
            i = 1;
            if (i == 0) {
              break label323;
            }
            paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(((cc)localObject2).bZA()).append(",is click feed:");
            if (((cc)localObject2).bZA() != paramcc.bZA()) {
              break label284;
            }
            bool = true;
            label172:
            localObject3 = paramArrayList.append(bool).append(",nickname:");
            paramArrayList = ((BaseFinderFeed)localObject2).contact;
            if (paramArrayList != null) {
              break label290;
            }
            paramArrayList = null;
            label201:
            localObject3 = ((StringBuilder)localObject3).append(paramArrayList).append(",live status:");
            paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
            if (paramArrayList != null) {
              break label298;
            }
            paramArrayList = null;
          }
        }
        for (;;)
        {
          Log.i("FinderLiveUtil", paramArrayList + '!');
          if (((cc)localObject2).bZA() != paramcc.bZA()) {
            break;
          }
          localArrayList.add(localObject2);
          break;
          i = 0;
          break label120;
          label284:
          bool = false;
          break label172;
          label290:
          paramArrayList = paramArrayList.getNickname();
          break label201;
          label298:
          paramArrayList = paramArrayList.getLiveInfo();
          if (paramArrayList == null) {
            paramArrayList = null;
          } else {
            paramArrayList = Integer.valueOf(paramArrayList.liveStatus);
          }
        }
        label323:
        localArrayList.add(localObject2);
      }
    }
    int i = kotlin.a.p.a((List)localArrayList, paramcc);
    if (i >= 0) {}
    for (;;)
    {
      localObject1 = new FinderLiveBundle();
      ((FinderLiveBundle)localObject1).CEY = i;
      ((FinderLiveBundle)localObject1).AJo = paramInt;
      localObject2 = (Iterable)localArrayList;
      paramArrayList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (BaseFinderFeed)((Iterator)localObject2).next();
        com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        paramArrayList.add(com.tencent.mm.plugin.finder.utils.aw.a(((BaseFinderFeed)localObject3).feedObject.getFeedObject(), 0, paramBoolean, 2));
      }
      i = 0;
    }
    ((FinderLiveBundle)localObject1).ag(new ArrayList((Collection)paramArrayList));
    ((FinderLiveBundle)localObject1).CFf = 1;
    ((FinderLiveBundle)localObject1).ACt = parambcl;
    if ((paramcc instanceof BaseFinderFeed))
    {
      paramArrayList = (BaseFinderFeed)paramcc;
      if (paramArrayList != null) {
        break label585;
      }
      paramArrayList = "";
      label515:
      ((FinderLiveBundle)localObject1).awv(paramArrayList);
      paramArrayList = (BaseFinderFeed)kotlin.a.p.oL((List)localArrayList);
      if (paramArrayList != null) {
        break label619;
      }
      paramArrayList = null;
      label539:
      ((FinderLiveBundle)localObject1).CFj = paramArrayList;
      paramArrayList = (BaseFinderFeed)kotlin.a.p.ae((List)localArrayList, i);
      if (paramArrayList != null) {
        break label641;
      }
      paramInt = 0;
    }
    for (;;)
    {
      ((FinderLiveBundle)localObject1).extFlag = paramInt;
      AppMethodBeat.o(351158);
      return localObject1;
      paramArrayList = null;
      break;
      label585:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = "";
        break label515;
      }
      paramcc = paramArrayList.getNickName();
      paramArrayList = paramcc;
      if (paramcc != null) {
        break label515;
      }
      paramArrayList = "";
      break label515;
      label619:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramArrayList = null;
        break label539;
      }
      paramArrayList = paramArrayList.getFeedObject();
      break label539;
      label641:
      paramArrayList = paramArrayList.feedObject;
      if (paramArrayList == null)
      {
        paramInt = 0;
      }
      else
      {
        paramArrayList = paramArrayList.getFeedObject();
        if (paramArrayList == null)
        {
          paramInt = 0;
        }
        else
        {
          paramArrayList = paramArrayList.liveInfo;
          if (paramArrayList == null) {
            paramInt = 0;
          } else {
            paramInt = paramArrayList.ZRR;
          }
        }
      }
    }
  }
  
  public static com.tencent.mm.plugin.finder.live.model.t a(bdm parambdm, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351299);
    kotlin.g.b.s.u(parambdm, "appMsg");
    kotlin.g.b.s.u(parama, "liveData");
    com.tencent.mm.plugin.finder.live.model.t localt = new com.tencent.mm.plugin.finder.live.model.t(parambdm);
    bgh localbgh = new bgh();
    localbgh.contact = p(parama);
    localbgh.ZKa = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecm;
    ah localah = ah.aiuX;
    parambdm.ZOb = localbgh;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.add(localt);
    parambdm = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.bhf();
    AppMethodBeat.o(351299);
    return localt;
  }
  
  public static aps a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt, String paramString)
  {
    AppMethodBeat.i(351995);
    kotlin.g.b.s.u(parama, "buContext");
    kotlin.g.b.s.u(paramString, "strvalue");
    aps localaps = new aps();
    localaps.finderUsername = z.bAW();
    localaps.hKN = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    int i;
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label146;
      }
    }
    Object localObject;
    for (paramString = ak.l(kotlin.v.Y("feedActionType", Integer.valueOf(paramInt)));; paramString = (Map)localObject)
    {
      hQ("FinderLiveUtil", kotlin.g.b.s.X("getExtState :", paramString));
      localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      localaps.ZwW = com.tencent.mm.plugin.finder.utils.aw.aj(paramString);
      localaps.sessionBuffer = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer;
      AppMethodBeat.o(351995);
      return localaps;
      i = 0;
      break;
      label146:
      localObject = new HashMap();
      ((HashMap)localObject).put("feedActionType", Integer.valueOf(paramInt));
      ((HashMap)localObject).put("strValue", paramString);
    }
  }
  
  private static final CharSequence a(EditText paramEditText, CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(371311);
    if (paramEditText != null) {
      paramEditText.getText();
    }
    paramEditText = paramCharSequence.toString();
    paramCharSequence = (CharSequence)"\n";
    if (paramEditText == null)
    {
      paramEditText = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(371311);
      throw paramEditText;
    }
    if (paramEditText.contentEquals(paramCharSequence))
    {
      paramEditText = (CharSequence)"";
      AppMethodBeat.o(371311);
      return paramEditText;
    }
    AppMethodBeat.o(371311);
    return null;
  }
  
  private static final CharSequence a(Pattern paramPattern, CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(371312);
    if (!paramPattern.matcher(paramCharSequence).find())
    {
      AppMethodBeat.o(371312);
      return null;
    }
    paramPattern = (CharSequence)"";
    AppMethodBeat.o(371312);
    return paramPattern;
  }
  
  public static Long a(bip parambip)
  {
    AppMethodBeat.i(351703);
    aj localaj = aj.CGT;
    if (a((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)))
    {
      if (parambip == null)
      {
        AppMethodBeat.o(351703);
        return null;
      }
      l = parambip.ZKR;
      AppMethodBeat.o(351703);
      return Long.valueOf(l);
    }
    if (parambip == null)
    {
      AppMethodBeat.o(351703);
      return null;
    }
    long l = parambip.ZKy;
    AppMethodBeat.o(351703);
    return Long.valueOf(l);
  }
  
  public static String a(com.tencent.mm.plugin.finder.live.model.context.a parama, Long paramLong)
  {
    AppMethodBeat.i(352313);
    kotlin.g.b.s.u(parama, "buContext");
    String str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeF;
    String str1 = str2;
    if (str2 == null) {
      str1 = null;
    }
    if (str1 == null)
    {
      if (paramLong == null)
      {
        AppMethodBeat.o(352313);
        return null;
      }
      long l = ((Number)paramLong).longValue();
      parama = (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EeG.get(Long.valueOf(l));
      AppMethodBeat.o(352313);
      return parama;
    }
    AppMethodBeat.o(352313);
    return str1;
  }
  
  public static String a(String paramString, LinkedList<bcz> paramLinkedList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(351645);
    kotlin.g.b.s.u(paramString, "prefix");
    kotlin.g.b.s.u(paramLinkedList, "visitorRoleList");
    StringBuilder localStringBuilder1 = new StringBuilder("[printVisitorRoleInfo]" + paramString + ":curVisitorRoleType:" + paramInt + ";visitorRoleModifyTime:" + paramLong + ';');
    synchronized ((Iterable)paramLinkedList)
    {
      Iterator localIterator = ???.iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        paramString = localIterator.next();
        if (paramInt < 0) {
          kotlin.a.p.kkW();
        }
        paramLinkedList = (bcz)paramString;
        StringBuilder localStringBuilder2 = new StringBuilder("[").append(paramInt).append(':');
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        localStringBuilder1.append(com.tencent.mm.ae.f.dg(paramString) + ']');
        paramInt += 1;
      }
      paramString = ah.aiuX;
      paramString = localStringBuilder1.toString();
      kotlin.g.b.s.s(paramString, "msg.toString()");
      AppMethodBeat.o(351645);
      return paramString;
    }
  }
  
  public static LinkedList<bfh> a(List<byte[]> paramList, LinkedList<bfh> paramLinkedList)
  {
    AppMethodBeat.i(351511);
    kotlin.g.b.s.u(paramList, "list");
    if (paramLinkedList == null) {
      paramLinkedList = new LinkedList();
    }
    for (;;)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        bfh localbfh = new bfh();
        localbfh.parseFrom(arrayOfByte);
        paramLinkedList.add(localbfh);
      }
      paramLinkedList.clear();
    }
    AppMethodBeat.o(351511);
    return paramLinkedList;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.api.g> a(boh paramboh)
  {
    AppMethodBeat.i(351822);
    ArrayList localArrayList = new ArrayList();
    if (paramboh != null)
    {
      paramboh = paramboh.ZWF;
      if (paramboh != null)
      {
        paramboh = ((Iterable)paramboh).iterator();
        if (paramboh.hasNext())
        {
          bog localbog = (bog)paramboh.next();
          com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.appId = localbog.appid;
          localg.qAF = localbog.ZWB;
          Object localObject = new ay();
          if (localbog.ZWA)
          {
            ((ay)localObject).CIJ = 1;
            label105:
            ((ay)localObject).CIE = 1;
            ah localah = ah.aiuX;
            localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
            if (!bUx()) {
              break label240;
            }
          }
          label240:
          for (int i = 1176;; i = 1177)
          {
            localg.scene = i;
            localObject = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
            localg.qAT = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, com.tencent.mm.plugin.finder.live.view.convert.a.a(localbog), null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16776700);
            localg.euz = bUq();
            localArrayList.add(localg);
            break;
            if (localbog.ZWC)
            {
              ((ay)localObject).CIJ = 2;
              break label105;
            }
            if (!localbog.ZWD) {
              break label105;
            }
            ((ay)localObject).CIJ = 3;
            break label105;
          }
        }
      }
    }
    paramboh = (List)localArrayList;
    AppMethodBeat.o(351822);
    return paramboh;
  }
  
  public static void a(final Context paramContext, final com.tencent.mm.plugin.finder.live.model.context.a parama, final long paramLong, final bzc parambzc, final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(352337);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "liveData");
    kotlin.g.b.s.u(parambzc, "productInfo");
    kotlin.g.b.s.u(paramString1, "session");
    kotlin.g.b.s.u(paramString2, "jumpId");
    final ah.f localf = new ah.f();
    cb localcb = kotlinx.coroutines.j.a((kotlinx.coroutines.aq)bu.ajwo, (kotlin.d.f)bg.kCh(), null, (kotlin.g.a.m)new b(localf, paramContext, null), 2);
    Object localObject = aj.CGT;
    localObject = aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((ap)localObject).a((MMActivity)paramContext, paramLong, (kotlin.g.a.m)new a(localcb, localf, paramString1, parambzc, paramInt, parama, paramLong, paramString2, paramContext));
    }
    AppMethodBeat.o(352337);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(352219);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "data");
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ;
    int i;
    if (((CharSequence)str).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label156;
      }
    }
    for (;;)
    {
      if (str != null)
      {
        com.tencent.mm.pluginsdk.a locala = new com.tencent.mm.pluginsdk.a();
        locala.XNk = 215;
        locala.AcJ = 1;
        locala.XNl = false;
        locala.hzx = String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.class)).a(paramContext, str, new a..ExternalSyntheticLambda5(paramb), locala).show();
      }
      AppMethodBeat.o(352219);
      return;
      i = 0;
      break;
      label156:
      str = null;
    }
  }
  
  public static void a(Context paramContext, bms parambms, com.tencent.mm.plugin.finder.live.view.convert.k paramk)
  {
    AppMethodBeat.i(351952);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parambms, "csInfo");
    ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(parambms.username, new a..ExternalSyntheticLambda4(parambms, paramk, paramContext));
    AppMethodBeat.o(351952);
  }
  
  public static void a(Context paramContext, cr paramcr, String paramString)
  {
    AppMethodBeat.i(351671);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramcr, "adPage");
    kotlin.g.b.s.u(paramString, "uxInfo");
    switch (paramcr.YEX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(351671);
      return;
      Object localObject = paramcr.YEY;
      paramcr = (cr)localObject;
      if (localObject == null) {
        paramcr = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<ADInfo><uxInfo>").append(paramString).append("</uxInfo></ADInfo>");
      paramString = new Intent();
      paramString.putExtra("sns_landing_pages_pageid", Util.safeParseLong(paramcr));
      paramString.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      paramString.putExtra("sns_landig_pages_from_source", 24);
      paramString.putExtra("sns_landing_pages_ad_info", ((StringBuilder)localObject).toString());
      com.tencent.mm.br.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramString);
      Log.i("FinderLiveUtil", kotlin.g.b.s.X("adPage enter nativePage, ", paramcr));
      AppMethodBeat.o(351671);
      return;
      paramString = new com.tencent.mm.plugin.appbrand.api.g();
      paramString.appId = paramcr.app_id;
      paramString.qAF = paramcr.path;
      paramString.euz = 0;
      Log.i("FinderLiveUtil", "appId: " + paramString.appId + ", enterPath: " + paramString.qAF);
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(paramContext, paramString);
      Log.i("FinderLiveUtil", "adPage enter wxa, " + paramcr.app_id + ", " + paramcr.path);
      AppMethodBeat.o(351671);
      return;
      paramString = new Intent();
      paramString.putExtra("rawUrl", paramcr.path);
      paramString.putExtra("convertActivityFromTranslucent", true);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      Log.i("FinderLiveUtil", kotlin.g.b.s.X("adPage enter h5, ", paramcr.path));
    }
  }
  
  public static void a(View paramView, Bitmap paramBitmap, final kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(351138);
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramBitmap, "bitmap");
    com.tencent.mm.live.model.d.a.a locala = com.tencent.mm.live.model.d.a.nbX;
    com.tencent.mm.live.model.d.a.a.a(paramBitmap, MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_6), 8.0F, (kotlin.g.a.b)new d(paramView, paramb));
    AppMethodBeat.o(351138);
  }
  
  public static void a(EditText paramEditText, TextView paramTextView, int paramInt1, final int paramInt2, boolean paramBoolean, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(351477);
    paramTextView = new InputFilter[2];
    paramTextView[0] = new a..ExternalSyntheticLambda0(paramEditText);
    paramTextView[1] = ((InputFilter)new e(paramInt1, com.tencent.mm.ui.tools.g.a.afII));
    if (!paramBoolean)
    {
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jTv().bmg()).intValue() == 0) {
        paramTextView[0] = new a..ExternalSyntheticLambda1(Pattern.compile("[^a-zA-Z0-9一-龥_]"));
      }
    }
    if (paramEditText != null) {
      paramEditText.setFilters(paramTextView);
    }
    paramTextView = (TextWatcher)new f(null, paramInt2, parama);
    if (paramEditText != null) {
      paramEditText.addTextChangedListener(paramTextView);
    }
    AppMethodBeat.o(351477);
  }
  
  private static final void a(final ImageView paramImageView, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(371313);
    kotlin.g.b.s.u(paramImageView, "$avatarIv");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(paramBitmap, paramImageView));
    AppMethodBeat.o(371313);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(351130);
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramString, "url");
    Log.i("FinderLiveUtil", "setBlurBitmap imageView:" + paramImageView.getId() + ",url:" + paramString);
    Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCt();
    paramString = new com.tencent.mm.plugin.finder.loader.g(paramString, com.tencent.mm.plugin.finder.storage.v.FKZ);
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    AppMethodBeat.o(351130);
  }
  
  public static final void a(com.tencent.mm.ad.i parami, bno parambno)
  {
    AppMethodBeat.i(371316);
    if (parambno == null)
    {
      AppMethodBeat.o(371316);
      return;
    }
    int i = parami.optInt("tag_id");
    String str = parami.optString("tag_name");
    int j = parami.optInt("show_primary_tag");
    int k = parami.optInt("need_poi");
    parambno.ZWi = i;
    parambno.xms = str;
    parambno.ZWl = j;
    parambno.ZWm = k;
    AppMethodBeat.o(371316);
  }
  
  public static void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(352145);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if ((com.tencent.mm.plugin.finder.utils.aw.bgV()) && (paramb != null))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramb.setNetEnv(((Number)com.tencent.mm.plugin.finder.storage.d.eXE().bmg()).intValue());
    }
    AppMethodBeat.o(352145);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(352268);
    kotlin.g.b.s.u(parama, "buContext");
    kotlin.g.b.s.u(paramb, "statusMonitor");
    Object localObject = bj.GlQ;
    if (bj.y(parama))
    {
      localObject = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
      if ((com.tencent.mm.plugin.finder.live.olympic.util.a.eor()) && (!bUx()))
      {
        localObject = aj.CGT;
        localObject = aj.elk();
        if ((localObject != null) && (!((com.tencent.mm.plugin.finder.live.view.a)localObject).isLandscape())) {}
        for (int i = 1; i != 0; i = 0)
        {
          b.b.a(paramb, b.c.nfP);
          AppMethodBeat.o(352268);
          return;
        }
      }
    }
    b(parama, paramb);
    AppMethodBeat.o(352268);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, bzc parambzc)
  {
    AppMethodBeat.i(352323);
    kotlin.g.b.s.u(parama, "liveData");
    kotlin.g.b.s.u(parambzc, "productInfo");
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    parama = parambzc.aaij;
    if ((parama != null) && (l != parama.mMJ)) {
      parambzc.aaij = null;
    }
    AppMethodBeat.o(352323);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.b paramb)
  {
    AppMethodBeat.i(351243);
    kotlin.g.b.s.u(paramb, "plugin");
    if ((paramb.CTi.getLayoutParams() != null) && ((paramb.CTi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramb.isLandscape()))
    {
      int i = paramb.CTi.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
      paramb = paramb.CTi.getLayoutParams();
      if (paramb == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(351243);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)paramb).topMargin = i;
    }
    AppMethodBeat.o(351243);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(351249);
    kotlin.g.b.s.u(paramb, "plugin");
    paramb.CTi.post(new a..ExternalSyntheticLambda8(paramb, paramBoolean));
    AppMethodBeat.o(351249);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(352366);
    kotlin.g.b.s.u(paramb, "$plugin");
    if ((paramb.CTi.getLayoutParams() != null) && ((paramb.CTi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramb.isLandscape()))
    {
      int i = paramb.getCurrentOrientation();
      Object localObject = paramb.CTi.getContext();
      kotlin.g.b.s.s(localObject, "plugin.vg.context");
      if ((n(paramb.getBuContext())) || (o(paramb.getBuContext()))) {}
      int j;
      for (boolean bool = true;; bool = false)
      {
        j = I((Context)localObject, bool);
        if (!paramBoolean1) {
          break label150;
        }
        localObject = paramb.CTi.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(352366);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
      label150:
      if (paramBoolean2)
      {
        localObject = paramb.CTi.getLayoutParams();
        if (localObject == null)
        {
          paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(352366);
          throw paramb;
        }
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = j;
      }
      paramb.CTi.requestLayout();
      paramb.CTi.setTag(p.e.finder_live_plugin_orientation, Integer.valueOf(i));
    }
    AppMethodBeat.o(352366);
  }
  
  private static final void a(bms parambms, com.tencent.mm.plugin.finder.live.view.convert.k paramk, Context paramContext, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(371319);
    kotlin.g.b.s.u(parambms, "$csInfo");
    kotlin.g.b.s.u(paramContext, "$context");
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(parambms.username);
    Object localObject2;
    if ((localObject1 == null) || (((au)localObject1).maN == 0L))
    {
      Log.w("FinderLiveUtil", "weapp contact not found, mock and insert: " + parambms.username + ' ' + paramWxaAttributes.field_nickname);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
      localObject2 = new au();
      ((au)localObject2).setUsername(parambms.username);
      ((au)localObject2).setNickname(paramWxaAttributes.field_nickname);
    }
    try
    {
      ((au)localObject2).AY(com.tencent.mm.platformtools.f.Sa(((az)localObject2).field_nickname));
      ((au)localObject2).AZ(com.tencent.mm.platformtools.f.RZ(((az)localObject2).field_nickname));
      label167:
      paramWxaAttributes = ah.aiuX;
      ((bx)localObject1).az((au)localObject2);
      paramWxaAttributes = parambms.ZVw;
      Intent localIntent;
      if (paramWxaAttributes == null)
      {
        paramWxaAttributes = "";
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", parambms.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 4);
        localIntent.putExtra("key_temp_session_from", paramWxaAttributes);
        localIntent.putExtra("finish_direct", true);
        localObject1 = com.tencent.mm.plugin.appbrand.config.g.qWE;
        if (!com.tencent.mm.plugin.appbrand.config.g.ckz()) {
          localIntent.putExtra("key_need_send_video", false);
        }
        localIntent.putExtra("enableAnimation", true);
        localIntent.putExtra("app_brand_chatting_from_scene_new", 6);
        localObject1 = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject1).appId = paramWxaAttributes;
        ((WxaExposedParams.a)localObject1).username = parambms.username;
        ((WxaExposedParams.a)localObject1).qHO = 0;
        localIntent.putExtra("app_brand_chatting_expose_params", (Parcelable)((WxaExposedParams.a)localObject1).cll());
        if (paramk != null)
        {
          localIntent.putExtra("sendMessageTitle", paramk.title);
          localObject1 = parambms.ZVw;
          if (localObject1 != null) {
            break label528;
          }
          localObject1 = "";
          label368:
          localIntent.putExtra("sendMessagePath", (String)localObject1);
          localObject1 = paramk.DVl;
          if (localObject1 != null) {
            break label552;
          }
          localObject1 = "";
          label395:
          localIntent.putExtra("sendMessageImg", (String)localObject1);
          localIntent.putExtra("showMessageCard", true);
        }
        paramWxaAttributes = new StringBuilder("enter wxa shop service with: ").append(parambms.username).append(' ').append(paramWxaAttributes).append(' ');
        if (paramk != null) {
          break label579;
        }
        paramk = null;
        label454:
        paramWxaAttributes = paramWxaAttributes.append(paramk).append(' ');
        parambms = parambms.ZVw;
        if (parambms != null) {
          break label587;
        }
        parambms = "";
      }
      for (;;)
      {
        Log.i("FinderLiveUtil", parambms);
        com.tencent.mm.br.c.d(paramContext, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 0);
        AppMethodBeat.o(371319);
        return;
        paramWxaAttributes = paramWxaAttributes.appId;
        if (paramWxaAttributes == null)
        {
          paramWxaAttributes = "";
          break;
        }
        break;
        label528:
        localObject2 = ((bzd)localObject1).aail;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label368;
        }
        localObject1 = "";
        break label368;
        label552:
        localObject2 = (String)((LinkedList)localObject1).getFirst();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label395;
        }
        localObject1 = "";
        break label395;
        label579:
        paramk = paramk.title;
        break label454;
        label587:
        paramk = parambms.aail;
        parambms = paramk;
        if (paramk == null) {
          parambms = "";
        }
      }
    }
    catch (UnsatisfiedLinkError paramWxaAttributes)
    {
      break label167;
    }
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, bfk parambfk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351872);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(parama, "liveData");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
    int i;
    if (com.tencent.mm.live.core.core.a.b.a.bek())
    {
      if (parambfk != null) {
        break label269;
      }
      localObject1 = null;
      localObject1 = (Collection)localObject1;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label278;
      }
      i = 1;
      label65:
      if (i == 0)
      {
        localObject1 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDG;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label283;
        }
        i = 1;
        label107:
        if (i != 0)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee;
          if (parambfk != null) {
            break label288;
          }
        }
      }
    }
    label269:
    label278:
    label283:
    label288:
    for (parambfk = localObject2;; parambfk = parambfk.ZPo)
    {
      ((com.tencent.mm.plugin.finder.live.model.c)localObject1).h(parambfk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcT);
      parambfk = com.tencent.mm.plugin.finder.live.model.c.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee);
      Log.i("FinderLiveUtil", kotlin.g.b.s.X("prepareAnchorMusicInfo udpateMusicList:", parambfk));
      if (parambfk != null) {
        new com.tencent.mm.plugin.finder.live.model.cgi.t(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, 1, parambfk, (t.a)new a.c(parama)).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
      }
      AppMethodBeat.o(351872);
      return;
      localObject1 = parambfk.ZPo;
      break;
      i = 0;
      break label65;
      i = 0;
      break label107;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351311);
    kotlin.g.b.s.u(paramString, "content");
    kotlin.g.b.s.u(parama, "liveData");
    bke localbke = new bke();
    localbke.type = 10001;
    localbke.content = paramString;
    paramString = ah.aiuX;
    paramString = new com.tencent.mm.plugin.finder.live.model.am(localbke);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.add(paramString);
    paramString = com.tencent.mm.live.model.j.mXT;
    com.tencent.mm.live.model.j.bhf();
    AppMethodBeat.o(351311);
  }
  
  public static void a(LinkedList<bcz> paramLinkedList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(351576);
    u(paramLinkedList);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaO, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaS, Long.valueOf(paramLong));
    Object localObject = paramLinkedList;
    if (paramLinkedList == null) {
      localObject = new LinkedList();
    }
    Log.i("FinderLiveUtil", String.valueOf(a("saveVisitorRoleInfo", (LinkedList)localObject, paramInt, paramLong)));
    AppMethodBeat.o(351576);
  }
  
  private static final void a(kotlin.g.a.b paramb, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(371320);
    if (paramb != null) {
      if (paramInt != 1) {
        break label35;
      }
    }
    for (;;)
    {
      paramb.invoke(Boolean.valueOf(bool));
      AppMethodBeat.o(371320);
      return;
      label35:
      bool = false;
    }
  }
  
  public static boolean a(Context paramContext, com.tencent.mm.plugin.finder.live.view.convert.k paramk, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(351941);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramk, "item");
    kotlin.g.b.s.u(parama, "openItemCallback");
    bms localbms = paramk.DVj.aaie;
    if (localbms == null)
    {
      Log.i("FinderLiveUtil", "cs not support for: " + paramk.DVk + ' ' + "null");
      aa.dc(paramContext, com.tencent.mm.cd.a.bt(paramContext, p.h.CsO));
      AppMethodBeat.o(351941);
      return false;
    }
    Log.i("FinderLiveUtil", kotlin.g.b.s.X("enterShopService ", com.tencent.mm.ae.f.dg(localbms)));
    switch (localbms.xlL)
    {
    default: 
      boolean bool = a(paramContext, localbms);
      AppMethodBeat.o(351941);
      return bool;
    case 0: 
      new com.tencent.mm.ui.widget.a.g.a(paramContext).bDJ(com.tencent.mm.cd.a.bt(paramContext, p.h.app_cancel)).bDE(com.tencent.mm.cd.a.bt(paramContext, p.h.CsM)).NF(true).aEX(p.h.CsN).b(new a..ExternalSyntheticLambda6(parama)).show();
    }
    for (;;)
    {
      AppMethodBeat.o(351941);
      return true;
      a(paramContext, localbms, paramk);
    }
  }
  
  public static boolean a(Context paramContext, bms parambms)
  {
    AppMethodBeat.i(351964);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parambms, "csInfo");
    if ((parambms.xlL == 1) || (parambms.xlL == 0))
    {
      AppMethodBeat.o(351964);
      return false;
    }
    Object localObject;
    if (parambms.xlL == 2)
    {
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject, "service(IActivityRouter::class.java)");
      com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)localObject;
      localObject = parambms.ZVw;
      if (localObject == null)
      {
        localObject = "";
        parambms = parambms.ZVw;
        if (parambms != null) {
          break label134;
        }
        parambms = "";
        label97:
        f.a.a(localf, paramContext, (String)localObject, parambms);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(351964);
      return true;
      String str = ((bzd)localObject).appId;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label134:
      str = parambms.aail;
      parambms = str;
      if (str != null) {
        break label97;
      }
      parambms = "";
      break label97;
      localObject = (CharSequence)parambms.ttL;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("FinderLiveUtil", "invalid h5 url");
        AppMethodBeat.o(351964);
        return false;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambms.ttL);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
  }
  
  private static final boolean a(SeekBar paramSeekBar, int paramInt, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(371315);
    kotlin.g.b.s.u(paramSeekBar, "$seekBar");
    paramView = new Rect();
    paramSeekBar.getHitRect(paramView);
    if ((paramMotionEvent.getY() >= paramView.top - paramInt) && (paramMotionEvent.getY() <= paramView.bottom + paramInt) && (paramMotionEvent.getX() >= paramView.left) && (paramMotionEvent.getX() <= paramView.right))
    {
      long l1 = paramMotionEvent.getDownTime();
      long l2 = paramMotionEvent.getEventTime();
      paramInt = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getX();
      float f2 = paramView.left;
      float f3 = paramView.top;
      paramView = MotionEvent.obtain(l1, l2, paramInt, f1 - f2, paramView.height() / 2.0F + f3, paramMotionEvent.getMetaState());
      kotlin.g.b.s.s(paramView, "obtain(event.downTime,\n …         event.metaState)");
      boolean bool = paramSeekBar.onTouchEvent(paramView);
      AppMethodBeat.o(371315);
      return bool;
    }
    AppMethodBeat.o(371315);
    return false;
  }
  
  public static boolean a(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e parame)
  {
    AppMethodBeat.i(352012);
    if ((parame != null) && (parame.Edz == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        parame = com.tencent.d.a.a.a.a.a.ahiX;
        if (((Number)com.tencent.d.a.a.a.a.a.jRJ().bmg()).intValue() != 1) {
          break;
        }
      }
      AppMethodBeat.o(352012);
      return true;
    }
    AppMethodBeat.o(352012);
    return false;
  }
  
  public static boolean a(bgh parambgh)
  {
    AppMethodBeat.i(351381);
    if (parambgh == null) {}
    for (parambgh = null; parambgh != null; parambgh = parambgh.ZKa)
    {
      parambgh = ((Iterable)parambgh).iterator();
      do
      {
        if (!parambgh.hasNext()) {
          break;
        }
      } while (((bfl)parambgh.next()).ZPp != 5);
      AppMethodBeat.o(351381);
      return true;
    }
    AppMethodBeat.o(351381);
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(352156);
    kotlin.g.b.s.u(paramString1, "sdkUserId");
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().a(paramString2, paramString1, paramInt, paramBoolean);
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.a locala = com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FU(paramString1);
    if (locala != null)
    {
      Log.i("FinderLiveUtil", "updateRemoteLinkMicUserInfo: already add, need update, sdkUserId:" + paramString1 + ", sdkLiveId:" + paramInt + ", isAnchor:" + paramBoolean + ", sessionId:" + paramString2);
      locala.lyn = String.valueOf(paramInt);
      locala.mTy = paramBoolean;
      AppMethodBeat.o(352156);
      return true;
    }
    Log.i("FinderLiveUtil", "updateRemoteLinkMicUserInfo: user didn't online yet, sdkUserId:" + paramString1 + ", sdkLiveId:" + paramInt + ", isAnchor:" + paramBoolean + ", sessionId:" + paramString2);
    AppMethodBeat.o(352156);
    return false;
  }
  
  public static int aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(351268);
    int k = com.tencent.mm.model.cn.getSyncServerTimeSecond();
    int j = paramInt2 - k;
    int m = paramInt2 - paramInt1;
    if ((j > m) || (j > paramInt3)) {}
    for (int i = paramInt3;; i = j)
    {
      if (j <= 0) {
        i = 0;
      }
      Log.i("FinderLiveUtil", "getLotteryRemainTime serverTime:" + k + ",beginTime:" + paramInt1 + ",endTime:" + paramInt2 + ",remainTime:" + paramInt3 + ",calRemainTime:" + j + ",duration:" + m + ",result:" + i);
      AppMethodBeat.o(351268);
      return i;
    }
  }
  
  public static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(351491);
    com.tencent.mm.kernel.h.baC();
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(kotlin.g.b.s.X("_finder_live_mmkv", Integer.valueOf(com.tencent.mm.kernel.b.getUin())));
    kotlin.g.b.s.s(localMultiProcessMMKV, "getMMKV(FINDER_LIVE_MMKV + MMKernel.account().uin)");
    AppMethodBeat.o(351491);
    return localMultiProcessMMKV;
  }
  
  public static void aC(Activity paramActivity)
  {
    AppMethodBeat.i(351651);
    kotlin.g.b.s.u(paramActivity, "activity");
    View localView = paramActivity.getCurrentFocus();
    if (localView != null)
    {
      paramActivity = localView.getContext();
      if (paramActivity != null) {
        break label59;
      }
    }
    label59:
    for (paramActivity = null;; paramActivity = paramActivity.getSystemService("input_method"))
    {
      paramActivity = (InputMethodManager)paramActivity;
      if (paramActivity != null) {
        paramActivity.hideSoftInputFromWindow(localView.getWindowToken(), 2);
      }
      AppMethodBeat.o(351651);
      return;
    }
  }
  
  public static void aD(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(351218);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "msg");
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV()) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramContext, paramString));
    }
    AppMethodBeat.o(351218);
  }
  
  public static void ad(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(351893);
    Object localObject = com.tencent.mm.live.core.core.f.a.mUf;
    final int i = com.tencent.mm.live.core.core.f.a.bfB().size();
    if (paramBoolean1)
    {
      if ((i > 1) || ((paramBoolean2) && (i > 0)))
      {
        e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveVisitorCoreLeak", false, null, false, (kotlin.g.a.a)new j(paramBoolean2, i), 28);
        if ((paramBoolean2) && ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)))
        {
          aa.makeText(MMApplicationContext.getContext(), (CharSequence)kotlin.g.b.s.X("liveVisitorCoreLeak size=", Integer.valueOf(i)), 0).show();
          if (BuildInfo.DEBUG)
          {
            localObject = new RuntimeException(kotlin.g.b.s.X("liveVisitorCoreLeak size=", Integer.valueOf(i)));
            AppMethodBeat.o(351893);
            throw ((Throwable)localObject);
          }
        }
      }
    }
    else if (i > 2) {
      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveVisitorCoreOverSize", false, null, false, (kotlin.g.a.a)new k(i), 28);
    }
    AppMethodBeat.o(351893);
  }
  
  public static boolean as(LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(351728);
    kotlin.g.b.s.u(paramLinkedList, "dataList");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      if (((bcz)paramLinkedList.next()).ZNI == 2)
      {
        AppMethodBeat.o(351728);
        return true;
      }
    }
    AppMethodBeat.o(351728);
    return false;
  }
  
  public static int at(LinkedList<bfl> paramLinkedList)
  {
    AppMethodBeat.i(351916);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(351916);
      return -1;
    }
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    if (localIterator.hasNext())
    {
      paramLinkedList = localIterator.next();
      if (((bfl)paramLinkedList).ZPp == 1)
      {
        i = 1;
        label57:
        if (i == 0) {
          break label81;
        }
      }
    }
    for (;;)
    {
      paramLinkedList = (bfl)paramLinkedList;
      if (paramLinkedList != null) {
        break label88;
      }
      AppMethodBeat.o(351916);
      return -1;
      i = 0;
      break label57;
      label81:
      break;
      paramLinkedList = null;
    }
    label88:
    int i = paramLinkedList.ZPr;
    AppMethodBeat.o(351916);
    return i;
  }
  
  public static String au(LinkedList<bfl> paramLinkedList)
  {
    AppMethodBeat.i(351927);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(351927);
      return "";
    }
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramLinkedList = localIterator.next();
      if (((bfl)paramLinkedList).ZPp == 3)
      {
        i = 1;
        label59:
        if (i == 0) {
          break label85;
        }
      }
    }
    for (;;)
    {
      paramLinkedList = (bfl)paramLinkedList;
      if (paramLinkedList != null) {
        break label92;
      }
      AppMethodBeat.o(351927);
      return "";
      i = 0;
      break label59;
      label85:
      break;
      paramLinkedList = null;
    }
    label92:
    paramLinkedList = paramLinkedList.ZPs;
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(351927);
      return "";
    }
    AppMethodBeat.o(351927);
    return paramLinkedList;
  }
  
  public static boolean axR(String paramString)
  {
    AppMethodBeat.i(351622);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(351622);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.aBI(paramString))
    {
      AppMethodBeat.o(351622);
      return true;
    }
    localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.Iz(paramString))
    {
      AppMethodBeat.o(351622);
      return true;
    }
    AppMethodBeat.o(351622);
    return false;
  }
  
  public static boolean azc(int paramInt)
  {
    AppMethodBeat.i(371309);
    Object localObject = com.tencent.d.a.a.a.b.a.k.akmT;
    if (paramInt != a.k.a.kMF())
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.kMB().bmg()).intValue() != 1) {}
    }
    else
    {
      AppMethodBeat.o(371309);
      return true;
    }
    AppMethodBeat.o(371309);
    return false;
  }
  
  public static boolean azd(int paramInt)
  {
    AppMethodBeat.i(371310);
    a.k.a locala = com.tencent.d.a.a.a.b.a.k.akmT;
    if (paramInt == a.k.a.kMG())
    {
      AppMethodBeat.o(371310);
      return true;
    }
    AppMethodBeat.o(371310);
    return false;
  }
  
  public static auw b(int paramInt, LinkedList<Long> paramLinkedList)
  {
    AppMethodBeat.i(351797);
    kotlin.g.b.s.u(paramLinkedList, "idList");
    auw localauw = new auw();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramLinkedList = (LinkedList<Long>)localObject;
    case 101: 
    case 102: 
      for (;;)
      {
        if ((com.tencent.mm.bx.a)paramLinkedList != null)
        {
          localauw.cmdId = paramInt;
          localauw.ZFn = com.tencent.mm.bx.b.cX(((com.tencent.mm.bx.a)paramLinkedList).toByteArray());
        }
        AppMethodBeat.o(351797);
        return localauw;
        localObject = new bjy();
        ((bjy)localObject).ZTk = paramLinkedList;
        paramLinkedList = ah.aiuX;
        paramLinkedList = (LinkedList<Long>)localObject;
        continue;
        localObject = new bjx();
        ((bjx)localObject).ZTj = paramLinkedList;
        paramLinkedList = ah.aiuX;
        paramLinkedList = (LinkedList<Long>)localObject;
      }
    }
    localObject = new bjw();
    paramLinkedList = (Long)kotlin.a.p.oL((List)paramLinkedList);
    if (paramLinkedList == null) {}
    for (long l = 0L;; l = paramLinkedList.longValue())
    {
      ((bjw)localObject).DVk = l;
      paramLinkedList = ah.aiuX;
      paramLinkedList = (LinkedList<Long>)localObject;
      break;
    }
  }
  
  public static LinkedList<bcz> b(List<byte[]> paramList, LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(351533);
    kotlin.g.b.s.u(paramList, "list");
    if (paramLinkedList == null) {
      paramLinkedList = new LinkedList();
    }
    for (;;)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        bcz localbcz = new bcz();
        localbcz.parseFrom(arrayOfByte);
        paramLinkedList.add(localbcz);
      }
      paramLinkedList.clear();
    }
    AppMethodBeat.o(351533);
    return paramLinkedList;
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(352275);
    kotlin.g.b.s.u(parama, "buContext");
    kotlin.g.b.s.u(paramb, "statusMonitor");
    parama = ((q)parama.business(q.class)).Eie;
    b.c localc;
    Bundle localBundle;
    if (parama != null)
    {
      localc = b.c.ndP;
      localBundle = new Bundle();
      parama = c(parama);
      if (parama != null) {
        break label88;
      }
    }
    label88:
    for (parama = null;; parama = parama.toByteArray())
    {
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", parama);
      parama = ah.aiuX;
      paramb.statusChange(localc, localBundle);
      AppMethodBeat.o(352275);
      return;
    }
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.plugin.b paramb)
  {
    AppMethodBeat.i(351254);
    kotlin.g.b.s.u(paramb, "plugin");
    paramb.CTi.post(new a..ExternalSyntheticLambda9(paramb, true, true));
    AppMethodBeat.o(351254);
  }
  
  private static final void b(com.tencent.mm.plugin.finder.live.plugin.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(352353);
    kotlin.g.b.s.u(paramb, "$plugin");
    int i;
    Object localObject;
    int j;
    if ((paramb.CTi.getLayoutParams() != null) && ((paramb.CTi.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramb.isLandscape()))
    {
      i = paramb.getCurrentOrientation();
      localObject = paramb.CTi.getContext();
      kotlin.g.b.s.s(localObject, "plugin.vg.context");
      if ((n(paramb.getBuContext())) || (o(paramb.getBuContext()))) {}
      for (boolean bool = true;; bool = false)
      {
        j = I((Context)localObject, bool);
        if (!paramBoolean) {
          break label233;
        }
        localObject = paramb.CTi.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(352353);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(j);
    }
    for (;;)
    {
      paramb.CTi.requestLayout();
      localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (com.tencent.mm.plugin.finder.utils.aw.bgV()) {
        Log.i("FinderLiveUtil", "plugin:" + paramb.name() + ",Orientation:" + i + ",ifLeft:" + paramBoolean);
      }
      paramb.CTi.setTag(p.e.finder_live_plugin_orientation, Integer.valueOf(i));
      AppMethodBeat.o(352353);
      return;
      label233:
      localObject = paramb.CTi.getLayoutParams();
      if (localObject == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(352353);
        throw paramb;
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(j);
    }
  }
  
  private static final void b(kotlin.g.a.a parama, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(371317);
    kotlin.g.b.s.u(parama, "$openItemCallback");
    parama.invoke();
    AppMethodBeat.o(371317);
  }
  
  public static boolean b(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352054);
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inMutable = true;
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions);
    paramImageView.setImageBitmap(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(352054);
      return true;
    }
    AppMethodBeat.o(352054);
    return false;
  }
  
  public static boolean b(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    return ((parama instanceof com.tencent.mm.plugin.finder.live.view.b)) || ((parama instanceof com.tencent.mm.plugin.finder.live.view.c));
  }
  
  public static Object bU(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    AppMethodBeat.i(352244);
    kotlin.g.b.s.u(paramArrayOfByte, "byteArray");
    for (;;)
    {
      bla localbla;
      Object localObject2;
      try
      {
        localbla = new bla();
        localObject2 = (com.tencent.mm.bx.a)localbla;
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        Log.i("FinderLiveUtil", kotlin.g.b.s.X("e.msg = ", paramArrayOfByte.getMessage()));
        paramArrayOfByte = localObject1;
        continue;
        localObject2 = new bmt();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          localObject2 = new com.tencent.mm.plugin.finder.live.view.convert.i((bmt)localObject2);
          ((com.tencent.mm.plugin.finder.live.view.convert.i)localObject2).DUI = localbla.id;
          ((com.tencent.mm.plugin.finder.live.view.convert.i)localObject2).DUJ = localbla.ZUe;
          localObject3 = localbla.jump_id;
          paramArrayOfByte = (byte[])localObject3;
          if (localObject3 == null) {
            paramArrayOfByte = "";
          }
          kotlin.g.b.s.u(paramArrayOfByte, "<set-?>");
          ((com.tencent.mm.plugin.finder.live.view.convert.i)localObject2).DUN = paramArrayOfByte;
          ((com.tencent.mm.plugin.finder.live.view.convert.i)localObject2).hPp = localbla.ZUd;
          paramArrayOfByte = (byte[])localObject2;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bkk();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          paramArrayOfByte = new com.tencent.mm.plugin.finder.live.view.convert.f((bkk)localObject2);
          paramArrayOfByte.DUI = localbla.id;
          paramArrayOfByte.DUJ = localbla.ZUe;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bkx();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          paramArrayOfByte = new com.tencent.mm.plugin.finder.live.view.convert.e((bkx)localObject2);
          paramArrayOfByte.DUI = localbla.id;
          paramArrayOfByte.DUJ = localbla.ZUe;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bky();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          paramArrayOfByte = new com.tencent.mm.plugin.finder.live.view.convert.g((bky)localObject2);
          paramArrayOfByte.DUI = localbla.id;
          paramArrayOfByte.DUJ = localbla.ZUe;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bzc();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          localObject2 = new com.tencent.mm.plugin.finder.live.view.convert.k((bzc)localObject2);
          ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DUI = localbla.id;
          ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DUJ = localbla.ZUe;
          localObject3 = localbla.jump_id;
          paramArrayOfByte = (byte[])localObject3;
          if (localObject3 == null) {
            paramArrayOfByte = "";
          }
          ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).ayc(paramArrayOfByte);
          ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).hPp = localbla.ZUd;
          paramArrayOfByte = (byte[])localObject2;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bvo();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = null;
        try
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          paramArrayOfByte = new com.tencent.mm.plugin.finder.live.view.convert.j((bvo)localObject2);
          paramArrayOfByte.DUI = localbla.id;
          paramArrayOfByte.DUJ = localbla.ZUe;
          continue;
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          continue;
        }
        catch (Exception paramArrayOfByte)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          continue;
        }
        localObject2 = new bkz();
        localObject3 = (com.tencent.mm.bx.a)localObject2;
        paramArrayOfByte = localbla.ZTU;
        if (paramArrayOfByte != null) {
          break label899;
        }
      }
      try
      {
        ((com.tencent.mm.bx.a)localObject2).parseFrom(paramArrayOfByte);
        i = localbla.type;
        switch (i)
        {
        default: 
          paramArrayOfByte = localObject1;
          AppMethodBeat.o(352244);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
        continue;
      }
      Object localObject3;
      paramArrayOfByte = null;
      try
      {
        for (;;)
        {
          ((com.tencent.mm.bx.a)localObject3).parseFrom(paramArrayOfByte);
          paramArrayOfByte = ah.aiuX;
          localObject2 = new com.tencent.mm.plugin.finder.live.view.convert.h((bkz)localObject2);
          ((com.tencent.mm.plugin.finder.live.view.convert.h)localObject2).DUI = localbla.id;
          ((com.tencent.mm.plugin.finder.live.view.convert.h)localObject2).DUJ = localbla.ZUe;
          localObject3 = localbla.jump_id;
          paramArrayOfByte = (byte[])localObject3;
          if (localObject3 == null) {
            paramArrayOfByte = "";
          }
          kotlin.g.b.s.u(paramArrayOfByte, "<set-?>");
          ((com.tencent.mm.plugin.finder.live.view.convert.h)localObject2).DUN = paramArrayOfByte;
          ((com.tencent.mm.plugin.finder.live.view.convert.h)localObject2).hPp = localbla.ZUd;
          paramArrayOfByte = (byte[])localObject2;
          break;
          label899:
          paramArrayOfByte = paramArrayOfByte.toByteArray();
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
        }
      }
    }
  }
  
  public static boolean bUC()
  {
    AppMethodBeat.i(351371);
    com.tencent.mm.live.core.core.a.b.a locala = com.tencent.mm.live.core.core.a.b.mMo;
    boolean bool = com.tencent.mm.live.core.core.a.b.a.bek();
    AppMethodBeat.o(351371);
    return bool;
  }
  
  public static boolean bUb()
  {
    AppMethodBeat.i(351404);
    com.tencent.mm.plugin.expansions.b localb = com.tencent.mm.plugin.expansions.b.yFu;
    boolean bool = com.tencent.mm.plugin.expansions.b.isInstalled("xlab");
    AppMethodBeat.o(351404);
    return bool;
  }
  
  public static int bUq()
  {
    AppMethodBeat.i(351804);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV())
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      switch (((Number)com.tencent.d.a.a.a.a.a.jTw().bmg()).intValue())
      {
      default: 
        AppMethodBeat.o(351804);
        return 0;
      case 1: 
        AppMethodBeat.o(351804);
        return 1;
      }
      AppMethodBeat.o(351804);
      return 2;
    }
    AppMethodBeat.o(351804);
    return 0;
  }
  
  public static long bUu()
  {
    AppMethodBeat.i(352071);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSG().bmg()).intValue() == 1)
    {
      l = System.currentTimeMillis();
      AppMethodBeat.o(352071);
      return l;
    }
    long l = com.tencent.mm.model.cn.bDw();
    AppMethodBeat.o(352071);
    return l;
  }
  
  public static boolean bUv()
  {
    AppMethodBeat.i(351907);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTY().bmg()).intValue() == 0)
    {
      AppMethodBeat.o(351907);
      return true;
    }
    AppMethodBeat.o(351907);
    return false;
  }
  
  public static boolean bUx()
  {
    AppMethodBeat.i(351356);
    Object localObject = com.tencent.mm.live.core.core.a.b.mMo;
    if (!com.tencent.mm.live.core.core.a.b.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.e.a.mRf;
      if (!com.tencent.mm.live.core.core.e.a.a.bek()) {}
    }
    else
    {
      AppMethodBeat.o(351356);
      return true;
    }
    AppMethodBeat.o(351356);
    return false;
  }
  
  public static boolean bfK()
  {
    AppMethodBeat.i(351586);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaZ, Boolean.TRUE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(351586);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("FinderLiveUtil", kotlin.g.b.s.X("getPlayDesktopSwitch ", Boolean.valueOf(bool)));
    AppMethodBeat.o(351586);
    return bool;
  }
  
  public static boolean bj(Context paramContext)
  {
    AppMethodBeat.i(351880);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = paramContext.getResources();
    if (paramContext != null)
    {
      paramContext = paramContext.getConfiguration();
      if ((paramContext != null) && (paramContext.orientation == 1))
      {
        AppMethodBeat.o(351880);
        return true;
      }
    }
    AppMethodBeat.o(351880);
    return false;
  }
  
  public static bla c(cc paramcc)
  {
    AppMethodBeat.i(352262);
    kotlin.g.b.s.u(paramcc, "data");
    for (;;)
    {
      try
      {
        if (!(paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.i)) {
          continue;
        }
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.i)paramcc).DUI;
        localbla.type = 4;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.i)paramcc).DUO.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.i)paramcc).DUJ;
        localbla.jump_id = ((com.tencent.mm.plugin.finder.live.view.convert.i)paramcc).DUN;
        localbla.ZUd = ((com.tencent.mm.plugin.finder.live.view.convert.i)paramcc).hPp;
        paramcc = localbla;
      }
      catch (Exception paramcc)
      {
        bla localbla;
        Log.i("FinderLiveUtil", kotlin.g.b.s.X("e.msg = ", paramcc.getMessage()));
        paramcc = null;
        continue;
      }
      AppMethodBeat.o(352262);
      return paramcc;
      if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.f))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.f)paramcc).DUI;
        localbla.type = 1;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.f)paramcc).DUK.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.f)paramcc).DUJ;
        paramcc = localbla;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.e)paramcc).DUI;
        localbla.type = 2;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.e)paramcc).DUH.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.e)paramcc).DUJ;
        paramcc = localbla;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.g))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.g)paramcc).DUI;
        localbla.type = 3;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.g)paramcc).DUL.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.g)paramcc).DUJ;
        paramcc = localbla;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DUI;
        localbla.type = 5;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DVj.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DUJ;
        localbla.jump_id = ((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).DUN;
        localbla.ZUd = ((com.tencent.mm.plugin.finder.live.view.convert.k)paramcc).hPp;
        paramcc = localbla;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.j)paramcc).DUI;
        localbla.type = 6;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.j)paramcc).DUV.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.j)paramcc).DUJ;
        paramcc = localbla;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.h))
      {
        localbla = new bla();
        localbla.id = ((com.tencent.mm.plugin.finder.live.view.convert.h)paramcc).DUI;
        localbla.type = 7;
        localbla.ZTU = new com.tencent.mm.bx.b(((com.tencent.mm.plugin.finder.live.view.convert.h)paramcc).DUM.toByteArray());
        localbla.ZUe = ((com.tencent.mm.plugin.finder.live.view.convert.h)paramcc).DUJ;
        localbla.jump_id = ((com.tencent.mm.plugin.finder.live.view.convert.h)paramcc).DUN;
        localbla.ZUd = ((com.tencent.mm.plugin.finder.live.view.convert.h)paramcc).hPp;
        paramcc = localbla;
      }
      else
      {
        paramcc = null;
      }
    }
  }
  
  public static void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(351566);
    kotlin.g.b.s.u(paramImageView, "avatarIv");
    kotlin.g.b.s.u(paramString, "avatarUrl");
    switch (paramInt)
    {
    default: 
      localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCq();
      paramString = new com.tencent.mm.plugin.finder.loader.b(paramString);
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO)).a(new a..ExternalSyntheticLambda3(paramImageView)).Td();
      AppMethodBeat.o(351566);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCq();
    paramString = new com.tencent.mm.plugin.finder.loader.b(paramString);
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
    AppMethodBeat.o(351566);
  }
  
  public static void c(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(352179);
    kotlin.g.b.s.u(paramTextView, "btn");
    if (paramBoolean)
    {
      com.tencent.mm.ui.aw.isDarkMode();
      paramTextView.setTextColor(paramTextView.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
      AppMethodBeat.o(352179);
      return;
    }
    com.tencent.mm.ui.aw.isDarkMode();
    paramTextView.setTextColor(paramTextView.getContext().getResources().getColor(p.b.BW_100_Alpha_0_2));
    AppMethodBeat.o(352179);
  }
  
  public static void c(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(352287);
    kotlin.g.b.s.u(parama, "buContext");
    kotlin.g.b.s.u(paramb, "statusMonitor");
    parama = ((q)parama.business(q.class)).Eie;
    b.c localc;
    Bundle localBundle;
    if (parama != null)
    {
      localc = b.c.ndQ;
      localBundle = new Bundle();
      parama = c(parama);
      if (parama != null) {
        break label88;
      }
    }
    label88:
    for (parama = null;; parama = parama.toByteArray())
    {
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", parama);
      parama = ah.aiuX;
      paramb.statusChange(localc, localBundle);
      AppMethodBeat.o(352287);
      return;
    }
  }
  
  public static boolean c(com.tencent.mm.plugin.finder.live.model.aq paramaq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351272);
    kotlin.g.b.s.u(paramaq, "commentData");
    if (((paramaq instanceof com.tencent.mm.plugin.finder.live.model.t)) && (paramaq.getType() == 20002))
    {
      Object localObject1 = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZNW;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!kotlin.g.b.s.p(localObject1, z.bAM()))
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZNW;
          if (localObject1 != null) {
            break label145;
          }
          localObject1 = null;
          label78:
          if (!kotlin.g.b.s.p(localObject1, z.bAW()))
          {
            paramaq = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZNW;
            if (paramaq != null) {
              break label167;
            }
            paramaq = localObject2;
          }
        }
      }
      for (;;)
      {
        if (!kotlin.g.b.s.p(paramaq, z.bAX())) {
          break label186;
        }
        AppMethodBeat.o(351272);
        return true;
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break;
        label145:
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label78;
        }
        localObject1 = ((FinderContact)localObject1).username;
        break label78;
        label167:
        localObject1 = paramaq.contact;
        paramaq = localObject2;
        if (localObject1 != null) {
          paramaq = ((FinderContact)localObject1).username;
        }
      }
    }
    label186:
    AppMethodBeat.o(351272);
    return false;
  }
  
  public static void checkInsertLiveNewReddot()
  {
    int i = 0;
    AppMethodBeat.i(351124);
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaf, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(351124);
      return;
    }
    Object localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    if (!com.tencent.d.a.a.a.a.a.jTq())
    {
      AppMethodBeat.o(351124);
      return;
    }
    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager();
    localObject1 = new btw();
    ((btw)localObject1).ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
    ((btw)localObject1).priority = 50000;
    ((btw)localObject1).type = 1010;
    Object localObject2 = new bxq();
    ((bxq)localObject2).show_type = 1;
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).path = "FinderEntrance";
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = new bxq();
    ((bxq)localObject2).show_type = 1;
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).path = "TLPersonalCenter";
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = new bxq();
    ((bxq)localObject2).show_type = 1;
    ((bxq)localObject2).aagq = 1;
    ((bxq)localObject2).path = "FinderSelfLiveEntrance";
    ((btw)localObject1).aabA.add(localObject2);
    localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
    ((com.tencent.mm.plugin.h)localObject2).a((btw)localObject1, "checkInsertLiveNewReddot", new HashSet());
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaf, Integer.valueOf(1));
    AppMethodBeat.o(351124);
  }
  
  public static boolean d(com.tencent.mm.plugin.finder.live.model.aq paramaq)
  {
    AppMethodBeat.i(351283);
    kotlin.g.b.s.u(paramaq, "commentData");
    if ((!bUx()) && ((paramaq instanceof com.tencent.mm.plugin.finder.live.model.t)))
    {
      Object localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdI;
        if ((localObject1 != null) && (((bcz)localObject1).ZNI == 1))
        {
          i = 1;
          if (i == 0) {
            break label329;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZOb;
          if (localObject1 != null) {
            break label181;
          }
          localObject1 = "";
          label86:
          if ((!kotlin.g.b.s.p(localObject1, z.bAM())) && (paramaq.getType() == 20032))
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZOb;
            if (localObject1 != null) {
              break label215;
            }
            localObject1 = "";
          }
        }
      }
      for (;;)
      {
        if (!isFriend((String)localObject1))
        {
          if (paramaq.getType() != 20034) {
            break label329;
          }
          paramaq = paramaq.ekF();
          if (paramaq == null)
          {
            paramaq = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.FinderLiveContact>");
            AppMethodBeat.o(351283);
            throw paramaq;
            i = 0;
            break;
            label181:
            localObject1 = ((bgh)localObject1).contact;
            if (localObject1 == null)
            {
              localObject1 = "";
              break label86;
            }
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label86;
            }
            localObject1 = "";
            break label86;
            label215:
            localObject1 = ((bgh)localObject1).contact;
            if (localObject1 == null)
            {
              localObject1 = "";
              continue;
            }
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {
              continue;
            }
            localObject1 = "";
            continue;
          }
          Object localObject2 = ((Iterable)paramaq).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label324;
          }
          localObject1 = ((Iterator)localObject2).next();
          paramaq = ((bgh)localObject1).contact;
          if (paramaq != null) {
            break label316;
          }
          paramaq = null;
          label292:
          if (!kotlin.g.b.s.p(paramaq, z.bAM())) {
            break label322;
          }
        }
      }
      label316:
      label322:
      label324:
      for (paramaq = (com.tencent.mm.plugin.finder.live.model.aq)localObject1;; paramaq = null)
      {
        if (paramaq == null) {
          break label329;
        }
        AppMethodBeat.o(351283);
        return true;
        paramaq = paramaq.username;
        break label292;
        break;
      }
    }
    label329:
    AppMethodBeat.o(351283);
    return false;
  }
  
  public static boolean d(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    return (paramh != null) && (paramh.EbE == 2);
  }
  
  public static String e(com.tencent.mm.plugin.finder.live.model.aq paramaq)
  {
    AppMethodBeat.i(351290);
    kotlin.g.b.s.u(paramaq, "commentData");
    if (((paramaq instanceof com.tencent.mm.plugin.finder.live.model.t)) && (paramaq.getType() == 20002))
    {
      paramaq = ((com.tencent.mm.plugin.finder.live.model.t)paramaq).CER.ZNW;
      if (paramaq == null)
      {
        AppMethodBeat.o(351290);
        return null;
      }
      paramaq = paramaq.contact;
      if (paramaq == null)
      {
        AppMethodBeat.o(351290);
        return null;
      }
      paramaq = paramaq.nickname;
      AppMethodBeat.o(351290);
      return paramaq;
    }
    AppMethodBeat.o(351290);
    return "";
  }
  
  public static boolean e(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    AppMethodBeat.i(371122);
    kotlin.g.b.s.u(paramb, "commentData");
    if ((paramb.akfZ.msg_type == 20002) && (kotlin.g.b.s.p(paramb.aJP(), z.bAM())))
    {
      AppMethodBeat.o(371122);
      return true;
    }
    AppMethodBeat.o(371122);
    return false;
  }
  
  public static boolean e(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    return (paramh != null) && (paramh.EbE == 1);
  }
  
  public static boolean euB()
  {
    return DJU;
  }
  
  public static boolean euC()
  {
    AppMethodBeat.i(351109);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jUD().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(351109);
      return true;
    }
    AppMethodBeat.o(351109);
    return false;
  }
  
  public static boolean euD()
  {
    AppMethodBeat.i(351194);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    boolean bool = com.tencent.mm.plugin.finder.utils.aw.bgV();
    localObject = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSJ().bmg()).intValue();
    Log.i("FinderLiveUtil", "canShowVisitorRoleEntrance isTest:" + bool + ",configValue:" + i);
    switch (i)
    {
    default: 
      AppMethodBeat.o(351194);
      return false;
    case 0: 
      AppMethodBeat.o(351194);
      return true;
    }
    AppMethodBeat.o(351194);
    return bool;
  }
  
  public static boolean euE()
  {
    AppMethodBeat.i(351200);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    boolean bool = com.tencent.mm.plugin.finder.utils.aw.bgV();
    localObject = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSK().bmg()).intValue();
    Log.i("FinderLiveUtil", "canShowAnchorPrecheckEntrance isTest:" + bool + ",configValue:" + i);
    switch (i)
    {
    default: 
      AppMethodBeat.o(351200);
      return false;
    case 0: 
      AppMethodBeat.o(351200);
      return true;
    }
    AppMethodBeat.o(351200);
    return bool;
  }
  
  public static boolean euF()
  {
    AppMethodBeat.i(351205);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    int j = ((Number)com.tencent.d.a.a.a.a.a.jRQ().bmg()).intValue();
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(z.bAW());
    if (localObject == null) {}
    for (int i = 0;; i = (int)((com.tencent.mm.plugin.finder.api.m)localObject).field_liveSwitchFlag)
    {
      boolean bool = com.tencent.mm.ae.d.ee(i, 16);
      Log.i("FinderLiveUtil", "enableAnchorMusic configValue:" + j + ", enableAnchorMusic:" + bool + ", switchFlag:" + i);
      if ((j != 0) || (!bool)) {
        break;
      }
      AppMethodBeat.o(351205);
      return true;
    }
    AppMethodBeat.o(351205);
    return false;
  }
  
  public static TXLivePlayConfig euG()
  {
    AppMethodBeat.i(351331);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    int i = com.tencent.d.a.a.a.a.a.jTB();
    localObject = com.tencent.d.a.a.a.a.a.ahiX;
    int j = com.tencent.d.a.a.a.a.a.jTC();
    localObject = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject).setConnectRetryCount(i);
    ((TXLivePlayConfig)localObject).setConnectRetryInterval(j);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool = com.tencent.d.a.a.a.a.a.jTD();
    ((TXLivePlayConfig)localObject).setEnableMessage(bool);
    Log.i("FinderLiveUtil", "cdn config retry count:" + i + ",retry interval:" + j + ", sei:" + bool);
    AppMethodBeat.o(351331);
    return localObject;
  }
  
  public static boolean euH()
  {
    AppMethodBeat.i(351452);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRW().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(351452);
      return true;
    }
    AppMethodBeat.o(351452);
    return false;
  }
  
  public static boolean euI()
  {
    AppMethodBeat.i(351499);
    boolean bool = aBP().getBoolean("is_anchor_live_visitor_anonymous_showed_key", false);
    AppMethodBeat.o(351499);
    return bool;
  }
  
  public static void euJ()
  {
    AppMethodBeat.i(351502);
    aBP().putBoolean("is_anchor_live_visitor_anonymous_showed_key", true);
    AppMethodBeat.o(351502);
  }
  
  public static boolean euK()
  {
    AppMethodBeat.i(351604);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWm().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderLiveUtil", kotlin.g.b.s.X("canPlayDesktopSwitchShow ", Boolean.valueOf(bool)));
      AppMethodBeat.o(351604);
      return bool;
    }
  }
  
  public static boolean euL()
  {
    AppMethodBeat.i(351738);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRY().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(351738);
      return true;
    }
    AppMethodBeat.o(351738);
    return false;
  }
  
  public static int euM()
  {
    AppMethodBeat.i(351779);
    com.tencent.mm.ui.aw.jkS();
    int i = bd.fromDPToPix(MMApplicationContext.getContext(), 128);
    AppMethodBeat.o(351779);
    return i;
  }
  
  public static long euN()
  {
    return 500L;
  }
  
  public static int euO()
  {
    AppMethodBeat.i(351810);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV())
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      switch (((Number)com.tencent.d.a.a.a.a.a.jTx().bmg()).intValue())
      {
      default: 
        AppMethodBeat.o(351810);
        return 0;
      case 1: 
        AppMethodBeat.o(351810);
        return 1;
      }
      AppMethodBeat.o(351810);
      return 2;
    }
    AppMethodBeat.o(351810);
    return 0;
  }
  
  public static kotlin.u<ArrayList<String>, ArrayList<List<String>>, ArrayList<List<String>>> euP()
  {
    AppMethodBeat.i(352022);
    Object localObject2 = new Date(bUu());
    Object localObject3 = Calendar.getInstance();
    Object localObject1 = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((Calendar)localObject3).setTime((Date)localObject2);
      ((Calendar)localObject3).set(5, i + ((Calendar)localObject3).get(5));
      i = ((Calendar)localObject3).get(5);
      int k = ((Calendar)localObject3).get(2);
      ((ArrayList)localObject1).add(MMApplicationContext.getContext().getResources().getString(p.h.finder_live_notice_date_format, new Object[] { Integer.valueOf(k + 1), Integer.valueOf(i) }));
      if (j >= 60)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext()) {
          Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
        }
        if ((((Date)localObject2).getHours() >= 23) && (((Date)localObject2).getMinutes() >= 55)) {
          ((ArrayList)localObject1).remove(0);
        }
        localObject2 = z(((ArrayList)localObject1).size(), p.h.CoW, false);
        localObject1 = new kotlin.u(localObject1, localObject2, Pt(((ArrayList)localObject1).size() * ((ArrayList)localObject2).size()));
        AppMethodBeat.o(352022);
        return localObject1;
      }
    }
  }
  
  public static Integer euQ()
  {
    AppMethodBeat.i(352085);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if ((localObject instanceof BatteryManager)) {}
    for (localObject = (BatteryManager)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(352085);
      return Integer.valueOf(0);
    }
    int i = ((BatteryManager)localObject).getIntProperty(4);
    AppMethodBeat.o(352085);
    return Integer.valueOf(i);
  }
  
  public static int euR()
  {
    j = 0;
    AppMethodBeat.i(352093);
    for (;;)
    {
      try
      {
        localIntent = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localIntent != null) {
          continue;
        }
        i = 0;
        i /= 10;
      }
      finally
      {
        Intent localIntent;
        int i = j;
        continue;
      }
      AppMethodBeat.o(352093);
      return i;
      i = localIntent.getIntExtra("temperature", 0);
    }
  }
  
  public static boolean euS()
  {
    AppMethodBeat.i(352163);
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adeT, false))
    {
      AppMethodBeat.o(352163);
      return true;
    }
    AppMethodBeat.o(352163);
    return false;
  }
  
  public static boolean f(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(371124);
    kotlin.g.b.s.u(paramb, "commentData");
    if ((kotlin.g.b.s.p(paramb.aJO(), z.bAM())) || (paramb.akfZ.msg_type != 20032) || (!isFriend(paramb.aJO())))
    {
      if (paramb.akfZ.msg_type != 20034) {
        break label183;
      }
      if (!(paramb instanceof com.tencent.mm.plugin.finder.live.viewmodel.data.a.a)) {
        break label94;
      }
      paramb = (com.tencent.mm.plugin.finder.live.viewmodel.data.a.a)paramb;
      if (paramb != null) {
        break label99;
      }
      paramb = localObject1;
    }
    for (;;)
    {
      if (paramb != null)
      {
        AppMethodBeat.o(371124);
        return true;
        label94:
        paramb = null;
        break;
        label99:
        Object localObject2 = paramb.akfX;
        paramb = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label120:
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            paramb = ((bgh)localObject1).contact;
            if (paramb == null)
            {
              paramb = null;
              if (!kotlin.g.b.s.p(paramb, z.bAM())) {
                break label176;
              }
            }
          }
          label150:
          for (paramb = localObject1;; paramb = null)
          {
            paramb = (bgh)paramb;
            break;
            paramb = paramb.username;
            break label150;
            label176:
            break label120;
          }
        }
      }
    }
    label183:
    AppMethodBeat.o(371124);
    return false;
  }
  
  public static int[] gA(Context paramContext)
  {
    j = 0;
    AppMethodBeat.i(352081);
    kotlin.g.b.s.u(paramContext, "context");
    arrayOfInt = new int[2];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    for (;;)
    {
      try
      {
        paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (paramContext != null) {
          continue;
        }
        i = 0;
      }
      finally
      {
        Log.i("FinderLiveUtil", kotlin.g.b.s.X("getBatteryInfo ex:", paramContext.getMessage()));
        continue;
        arrayOfInt[0] = i;
        if (paramContext != null) {
          continue;
        }
        int i = j;
        continue;
      }
      arrayOfInt[1] = i;
      AppMethodBeat.o(352081);
      return arrayOfInt;
      i = paramContext.getIntExtra("temperature", 0);
      continue;
      i = paramContext.getIntExtra("status", 0);
    }
  }
  
  public static Class<?> gB(Context paramContext)
  {
    AppMethodBeat.i(352107);
    kotlin.g.b.s.u(paramContext, "context");
    if ((((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).ep(paramContext)) || (((paramContext instanceof Activity)) && (((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).D((Activity)paramContext))))
    {
      paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramContext = com.tencent.mm.plugin.findersdk.e.a.fst();
      AppMethodBeat.o(352107);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramContext = com.tencent.mm.plugin.findersdk.e.a.fss();
    AppMethodBeat.o(352107);
    return paramContext;
  }
  
  public static Class<?> gC(Context paramContext)
  {
    AppMethodBeat.i(352119);
    kotlin.g.b.s.u(paramContext, "context");
    if ((((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).ep(paramContext)) || (((paramContext instanceof Activity)) && (((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).D((Activity)paramContext))))
    {
      paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramContext = com.tencent.mm.plugin.findersdk.e.a.fsD();
      AppMethodBeat.o(352119);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramContext = com.tencent.mm.plugin.findersdk.e.a.fsC();
    AppMethodBeat.o(352119);
    return paramContext;
  }
  
  public static Class<?> gD(Context paramContext)
  {
    AppMethodBeat.i(352127);
    kotlin.g.b.s.u(paramContext, "context");
    if ((((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).ep(paramContext)) || (((paramContext instanceof Activity)) && (((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).D((Activity)paramContext))))
    {
      paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramContext = com.tencent.mm.plugin.findersdk.e.a.fsr();
      AppMethodBeat.o(352127);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramContext = com.tencent.mm.plugin.findersdk.e.a.fsq();
    AppMethodBeat.o(352127);
    return paramContext;
  }
  
  public static Class<?> gE(Context paramContext)
  {
    AppMethodBeat.i(352135);
    kotlin.g.b.s.u(paramContext, "context");
    if (((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).ep(paramContext))
    {
      paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramContext = com.tencent.mm.plugin.findersdk.e.a.fsB();
      AppMethodBeat.o(352135);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.findersdk.e.a.HdV;
    paramContext = com.tencent.mm.plugin.findersdk.e.a.fsA();
    AppMethodBeat.o(352135);
    return paramContext;
  }
  
  public static void gF(Context paramContext)
  {
    AppMethodBeat.i(352173);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject2 = new File(kotlin.g.b.s.X(MMApplicationContext.getContext().getApplicationContext().getFilesDir().getAbsolutePath(), "/finder_live_applaud_sound.mp3"));
    if (!((File)localObject2).exists()) {
      FilesCopy.copyAssets(paramContext, "finder_live_applaud_sound.mp3", ((File)localObject2).getPath());
    }
    paramContext = aj.CGT;
    com.tencent.mm.live.core.core.trtc.a locala = aj.getLiveCore();
    if (locala != null)
    {
      paramContext = Integer.valueOf(-10001);
      Log.i("MicroMsg.LiveCore", "stopLocalSoundEffect");
      if (paramContext != null) {
        break label284;
      }
      paramContext = null;
      localObject1 = paramContext;
      if (paramContext == null)
      {
        paramContext = ((com.tencent.mm.live.core.core.trtc.a)locala).mRJ;
        if (paramContext != null) {
          break label298;
        }
      }
    }
    label284:
    label298:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramContext.id))
    {
      if (localObject1 != null)
      {
        int i = ((Number)localObject1).intValue();
        locala.beO().getAudioEffectManager().stopPlayMusic(i);
        locala.beO().getAudioEffectManager().setMusicObserver(i, null);
        locala.mRJ = null;
      }
      paramContext = aj.CGT;
      paramContext = aj.getLiveCore();
      if (paramContext != null)
      {
        localObject1 = ((File)localObject2).getAbsolutePath();
        kotlin.g.b.s.s(localObject1, "soundFile.absolutePath");
        kotlin.g.b.s.u(localObject1, "path");
        Log.i("MicroMsg.LiveCore", kotlin.g.b.s.X("playLocalSoundEffect path:", localObject1));
        localObject1 = com.tencent.mm.live.core.core.trtc.a.H(-10001, (String)localObject1);
        ((TXAudioEffectManager.AudioMusicParam)localObject1).publish = false;
        localObject2 = ah.aiuX;
        paramContext.mRJ = ((TXAudioEffectManager.AudioMusicParam)localObject1);
        localObject1 = paramContext.mRJ;
        if (localObject1 != null)
        {
          paramContext.beO().getAudioEffectManager().setMusicObserver(((TXAudioEffectManager.AudioMusicParam)localObject1).id, (TXAudioEffectManager.TXMusicPlayObserver)new com.tencent.mm.live.core.core.trtc.a.d());
          paramContext.beO().getAudioEffectManager().startPlayMusic((TXAudioEffectManager.AudioMusicParam)localObject1);
        }
      }
      AppMethodBeat.o(352173);
      return;
      paramContext = Integer.valueOf(((Number)paramContext).intValue());
      break;
    }
  }
  
  public static LinkedList<String> gG(List<byte[]> paramList)
  {
    AppMethodBeat.i(351527);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      Log.i("FinderLiveUtil", "getFinderLiveAndienceFileIdList list is empty!");
      AppMethodBeat.o(351527);
      return localLinkedList;
    }
    StringBuilder localStringBuilder = new StringBuilder("AndienceFileIdList:");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      Object localObject2 = (byte[])localObject1;
      localObject1 = new bfh();
      ((bfh)localObject1).parseFrom((byte[])localObject2);
      localObject2 = ((bfh)localObject1).YPy;
      CharSequence localCharSequence = (CharSequence)localObject2;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label211;
        }
        localLinkedList.add(localObject2);
        localStringBuilder.append("[" + ((bfh)localObject1).title + ',' + ((bfh)localObject1).YPy + ']');
        i = j;
        break;
      }
      label211:
      Log.i("FinderLiveUtil", "getFinderLiveAndienceFileIdList index:" + i + " item:" + ((bfh)localObject1).title + " is empty!");
      i = j;
    }
    Log.i("FinderLiveUtil", kotlin.g.b.s.X("getFinderLiveAndienceFileIdList ", localStringBuilder));
    AppMethodBeat.o(351527);
    return localLinkedList;
  }
  
  public static r<Integer, Integer> gG(Context paramContext)
  {
    AppMethodBeat.i(352197);
    kotlin.g.b.s.u(paramContext, "context");
    int k = bf.bf(paramContext).x;
    int m = bf.bf(paramContext).y;
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      int j = m;
      int i = k;
      if (paramContext != null)
      {
        paramContext = paramContext.findViewById(p.e.BKe);
        j = m;
        i = k;
        if (paramContext != null)
        {
          j = m;
          i = k;
          if (paramContext.getWidth() > 0)
          {
            j = m;
            i = k;
            if (paramContext.getHeight() > 0)
            {
              i = paramContext.getWidth();
              j = paramContext.getHeight();
            }
          }
        }
      }
      paramContext = new r(Integer.valueOf(i), Integer.valueOf(j));
      AppMethodBeat.o(352197);
      return paramContext;
    }
  }
  
  public static void ge(View paramView)
  {
    AppMethodBeat.i(351323);
    kotlin.g.b.s.u(paramView, "view");
    paramView.performHapticFeedback(1, 3);
    AppMethodBeat.o(351323);
  }
  
  public static boolean gg(View paramView)
  {
    AppMethodBeat.i(351857);
    kotlin.g.b.s.u(paramView, "child");
    Object localObject = paramView.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(paramView);
      }
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(351857);
      return true;
    }
    AppMethodBeat.o(351857);
    return false;
  }
  
  public static void hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(351211);
    kotlin.g.b.s.u(paramString1, "tag");
    kotlin.g.b.s.u(paramString2, "msg");
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV()) {
      Log.i(kotlin.g.b.s.X(paramString1, "(Debug)"), paramString2);
    }
    AppMethodBeat.o(351211);
  }
  
  public static boolean isCharging()
  {
    bool = true;
    AppMethodBeat.i(352099);
    for (;;)
    {
      try
      {
        Intent localIntent = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localIntent == null) {
          continue;
        }
        i = localIntent.getIntExtra("plugged", -1);
        if (i != 0) {
          continue;
        }
        i = 1;
        if (i != 0) {
          continue;
        }
      }
      finally
      {
        int i;
        bool = false;
        continue;
      }
      AppMethodBeat.o(352099);
      return bool;
      i = 0;
      continue;
      bool = false;
    }
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(351181);
    kotlin.g.b.s.u(paramString, "username");
    boolean bool = com.tencent.mm.contact.d.rs(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString).field_type);
    AppMethodBeat.o(351181);
    return bool;
  }
  
  public static String jp(long paramLong)
  {
    AppMethodBeat.i(351980);
    if (LocaleUtil.isChineseAppLang())
    {
      if ((float)paramLong < 10000.0F) {}
      try
      {
        AppMethodBeat.o(351980);
        return String.valueOf(paramLong);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.i("FinderLiveUtil", kotlin.g.b.s.X("[formatNumber] errMsg:", localException.getMessage()));
          localObject2 = "";
        }
      }
      if (((float)paramLong >= 10000.0F) && ((float)paramLong < 1.0E+008F))
      {
        localObject1 = kotlin.g.b.am.aixg;
        localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_number_10000);
        kotlin.g.b.s.s(localObject1, "getContext().resources.g…ring.finder_number_10000)");
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 10000.0F) }, 1));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(351980);
      return localObject1;
      localObject1 = kotlin.g.b.am.aixg;
      localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_number_more_than_100000000_v2);
      kotlin.g.b.s.s(localObject1, "getContext().resources.g…r_more_than_100000000_v2)");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      continue;
      Object localObject2;
      if ((float)paramLong < 1000.0F)
      {
        AppMethodBeat.o(351980);
        return String.valueOf(paramLong);
      }
      if (((float)paramLong >= 1000.0F) && ((float)paramLong < 1000000.0F))
      {
        localObject2 = kotlin.g.b.am.aixg;
        localObject2 = MMApplicationContext.getContext().getResources().getString(p.h.finder_number_10000_en);
        kotlin.g.b.s.s(localObject2, "getContext().resources.g…g.finder_number_10000_en)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1000.0F) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      }
      else if (((float)paramLong >= 1000000.0F) && ((float)paramLong < 1.0E+009F))
      {
        localObject2 = kotlin.g.b.am.aixg;
        localObject2 = MMApplicationContext.getContext().getResources().getString(p.h.finder_number_more_than_100000000_en_v2);
        kotlin.g.b.s.s(localObject2, "getContext().resources.g…ore_than_100000000_en_v2)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1000000.0F) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      }
      else
      {
        localObject2 = kotlin.g.b.am.aixg;
        localObject2 = MMApplicationContext.getContext().getResources().getString(p.h.finder_number_more_than_billion_en);
        kotlin.g.b.s.s(localObject2, "getContext().resources.g…ber_more_than_billion_en)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1.0E+009F) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      }
    }
  }
  
  public static boolean jq(long paramLong)
  {
    AppMethodBeat.i(351456);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 1);
    AppMethodBeat.o(351456);
    return bool;
  }
  
  public static boolean n(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351227);
    kotlin.g.b.s.u(parama, "liveData");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).CFc == 2)
    {
      AppMethodBeat.o(351227);
      return true;
    }
    AppMethodBeat.o(351227);
    return false;
  }
  
  public static boolean o(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351235);
    kotlin.g.b.s.u(parama, "liveData");
    if ((bUx()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet))
    {
      AppMethodBeat.o(351235);
      return true;
    }
    AppMethodBeat.o(351235);
    return false;
  }
  
  public static boolean oG(long paramLong)
  {
    AppMethodBeat.i(351767);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdo());
    AppMethodBeat.o(351767);
    return bool;
  }
  
  public static boolean oH(long paramLong)
  {
    AppMethodBeat.i(351773);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdn());
    AppMethodBeat.o(351773);
    return bool;
  }
  
  public static boolean oI(long paramLong)
  {
    AppMethodBeat.i(351775);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdp());
    AppMethodBeat.o(351775);
    return bool;
  }
  
  public static boolean oM(long paramLong)
  {
    AppMethodBeat.i(351411);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 4);
    AppMethodBeat.o(351411);
    return bool;
  }
  
  public static boolean oN(long paramLong)
  {
    AppMethodBeat.i(351423);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 256);
    AppMethodBeat.o(351423);
    return bool;
  }
  
  public static boolean oO(long paramLong)
  {
    AppMethodBeat.i(351431);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 128);
    AppMethodBeat.o(351431);
    return bool;
  }
  
  public static boolean oP(long paramLong)
  {
    AppMethodBeat.i(351438);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 4096);
    AppMethodBeat.o(351438);
    return bool;
  }
  
  public static boolean oQ(long paramLong)
  {
    AppMethodBeat.i(351444);
    boolean bool = com.tencent.mm.ae.d.ee((int)paramLong, 8);
    AppMethodBeat.o(351444);
    return bool;
  }
  
  public static boolean oR(long paramLong)
  {
    AppMethodBeat.i(351744);
    int i = (int)paramLong;
    e.k localk = e.k.mLj;
    if (!com.tencent.mm.ae.d.ee(i, e.k.bdr()))
    {
      AppMethodBeat.o(351744);
      return true;
    }
    AppMethodBeat.o(351744);
    return false;
  }
  
  public static boolean oS(long paramLong)
  {
    AppMethodBeat.i(351751);
    int i = (int)paramLong;
    e.k localk = e.k.mLj;
    if (!com.tencent.mm.ae.d.ee(i, e.k.bdq()))
    {
      AppMethodBeat.o(351751);
      return true;
    }
    AppMethodBeat.o(351751);
    return false;
  }
  
  public static boolean oT(long paramLong)
  {
    AppMethodBeat.i(351759);
    int i = (int)paramLong;
    e.k localk = e.k.mLj;
    if (!com.tencent.mm.ae.d.ee(i, e.k.bds()))
    {
      AppMethodBeat.o(351759);
      return true;
    }
    AppMethodBeat.o(351759);
    return false;
  }
  
  public static FinderContact p(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351551);
    kotlin.g.b.s.u(parama, "liveData");
    FinderContact localFinderContact = new FinderContact();
    com.tencent.mm.plugin.finder.api.m localm;
    if (bUx())
    {
      localFinderContact.username = z.bAW();
      parama = com.tencent.mm.plugin.finder.api.d.AwY;
      localm = d.a.auT(localFinderContact.username);
      if (localm == null)
      {
        parama = "";
        localFinderContact.nickname = parama;
        if (localm != null) {
          break label98;
        }
        parama = "";
        label67:
        localFinderContact.headUrl = parama;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(351551);
      return localFinderContact;
      String str = localm.dUr();
      parama = str;
      if (str != null) {
        break;
      }
      parama = "";
      break;
      label98:
      str = localm.dUs();
      parama = str;
      if (str != null) {
        break label67;
      }
      parama = "";
      break label67;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe)
      {
        localFinderContact.username = z.bAM();
        localFinderContact.nickname = z.bAO();
        localFinderContact.headUrl = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.xkY;
      }
      else
      {
        parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI;
        switch (parama.ZNI)
        {
        default: 
          localFinderContact.username = z.bAM();
          localFinderContact.nickname = z.bAO();
          localFinderContact.headUrl = parama.xkY;
          break;
        case 2: 
          localFinderContact.username = z.bAX();
          localFinderContact.nickname = parama.nickname;
          localFinderContact.headUrl = parama.xkY;
          break;
        case 3: 
          localFinderContact.username = z.bAW();
          localFinderContact.nickname = parama.nickname;
          localFinderContact.headUrl = parama.xkY;
        }
      }
    }
  }
  
  public static boolean q(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(352208);
    kotlin.g.b.s.u(parama, "data");
    if (!((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC))
    {
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ);
      if ((parama == null) || (com.tencent.mm.contact.d.rs(parama.field_type) != true)) {
        break label105;
      }
    }
    label105:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(352208);
      return true;
    }
    AppMethodBeat.o(352208);
    return false;
  }
  
  public static boolean r(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    Object localObject1 = null;
    bld localbld = null;
    AppMethodBeat.i(352301);
    kotlin.g.b.s.u(parama, "buContext");
    parama = ((q)parama.business(q.class)).Eie;
    if ((parama instanceof com.tencent.mm.plugin.finder.live.view.convert.h))
    {
      parama = (com.tencent.mm.plugin.finder.live.view.convert.h)parama;
      if (parama != null) {
        break label68;
      }
      parama = localbld;
    }
    for (;;)
    {
      if (parama == null)
      {
        AppMethodBeat.o(352301);
        return false;
        parama = null;
        break;
        label68:
        parama = parama.DUM.ToF;
        kotlin.g.b.s.s(parama, "it.data.infos");
        Object localObject2 = (ehn)kotlin.a.p.oL((List)parama);
        parama = localbld;
        if (localObject2 != null)
        {
          localObject2 = ((ehn)localObject2).ZNU;
          parama = localbld;
          if (localObject2 != null)
          {
            parama = com.tencent.mm.plugin.finder.live.util.n.DJd;
            localbld = com.tencent.mm.plugin.finder.live.util.n.axM((String)localObject2);
            localObject2 = new StringBuilder("[isGotRedPacket], full:");
            label148:
            label169:
            int i;
            if (localbld == null)
            {
              parama = null;
              localObject2 = ((StringBuilder)localObject2).append(parama).append(", status:");
              if (localbld != null) {
                break label239;
              }
              parama = null;
              Log.i("FinderLiveUtil", parama);
              if ((localbld == null) || (localbld.ZUg != 0)) {
                break label251;
              }
              i = 1;
              label199:
              if (i == 0) {
                break label268;
              }
              if (localbld != null) {
                break label256;
              }
              parama = localObject1;
              label210:
              if (!parama.booleanValue()) {
                break label268;
              }
            }
            label256:
            label268:
            for (bool = true;; bool = false)
            {
              parama = Boolean.valueOf(bool);
              break;
              parama = Integer.valueOf(localbld.ZUg);
              break label148;
              label239:
              parama = Boolean.valueOf(localbld.ZUf);
              break label169;
              label251:
              i = 0;
              break label199;
              parama = Boolean.valueOf(localbld.ZUf);
              break label210;
            }
          }
        }
      }
    }
    boolean bool = parama.booleanValue();
    AppMethodBeat.o(352301);
    return bool;
  }
  
  public static void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(351596);
    Log.i("FinderLiveUtil", kotlin.g.b.s.X("savePlayDesktopSwitch ", Boolean.valueOf(paramBoolean)));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaZ, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(351596);
  }
  
  public static boolean s(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(352345);
    kotlin.g.b.s.u(parama, "liveData");
    if ((bUx()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe))
    {
      AppMethodBeat.o(352345);
      return true;
    }
    AppMethodBeat.o(352345);
    return false;
  }
  
  public static String u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(351465);
    kotlin.g.b.s.u(paramString, "msg");
    String str = com.tencent.mm.ui.tools.g.jd(paramString, paramInt);
    if ((paramBoolean) && (paramString.length() > str.length()))
    {
      paramString = kotlin.g.b.s.X(str, "...");
      AppMethodBeat.o(351465);
      return paramString;
    }
    kotlin.g.b.s.s(str, "{\n            subString\n        }");
    AppMethodBeat.o(351465);
    return str;
  }
  
  public static void u(LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(351612);
    try
    {
      bda localbda = new bda();
      localObject = paramLinkedList;
      if (paramLinkedList == null) {
        localObject = new LinkedList();
      }
      localbda.ZMv = ((LinkedList)localObject);
      paramLinkedList = localbda.toByteArray();
      kotlin.g.b.s.s(paramLinkedList, "saveList.toByteArray()");
      paramLinkedList = new String(paramLinkedList, kotlin.n.d.ISO_8859_1);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaP, paramLinkedList);
      Log.i("FinderLiveUtil", kotlin.g.b.s.X("saveAliasInfoList cacheListStr:", com.tencent.mm.ae.f.dg(localbda)));
      AppMethodBeat.o(351612);
      return;
    }
    catch (Exception paramLinkedList)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      com.tencent.mm.plugin.finder.utils.aw.a(paramLinkedList, kotlin.g.b.s.X("saveAliasInfoList:", paramLinkedList.getMessage()));
      AppMethodBeat.o(351612);
    }
  }
  
  private static final void v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(371314);
    kotlin.g.b.s.u(paramView, "$view");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt1, -paramInt2);
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(371314);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(371314);
  }
  
  public static void v(TextView paramTextView)
  {
    AppMethodBeat.i(351392);
    kotlin.g.b.s.u(paramTextView, "tv");
    try
    {
      paramTextView.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), "fonts/SF-Pro-Display-BoldItalic.otf"));
      AppMethodBeat.o(351392);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e("FinderLiveUtil", kotlin.g.b.s.X("setTypeface() Exception:", paramTextView.getMessage()));
      AppMethodBeat.o(351392);
    }
  }
  
  public static ArrayList<List<String>> z(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(352037);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      localObject = com.tencent.mm.plugin.finder.utils.aw.Uv(i);
      localArrayList2.add(MMApplicationContext.getContext().getResources().getString(paramInt2, new Object[] { localObject }));
      if (k >= 24)
      {
        localObject = ((Iterable)localArrayList2).iterator();
        while (((Iterator)localObject).hasNext()) {
          Log.i("getNoticePicker", (String)((Iterator)localObject).next());
        }
        if (paramInt1 > 0)
        {
          paramInt2 = 0;
          do
          {
            i = paramInt2 + 1;
            localArrayList1.add(localArrayList2);
            paramInt2 = i;
          } while (i < paramInt1);
        }
        localArrayList2 = (ArrayList)localArrayList2.clone();
        localObject = new Date(bUu());
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime((Date)localObject);
        i = localCalendar.get(11);
        if (paramBoolean) {
          if (i >= 0) {
            paramInt1 = 0;
          }
        }
        for (;;)
        {
          localArrayList2.remove(0);
          if (paramInt1 == i)
          {
            localArrayList1.remove(0);
            if (!((Collection)localArrayList2).isEmpty())
            {
              paramInt1 = j;
              if (paramInt1 != 0) {
                localArrayList1.add(0, localArrayList2);
              }
            }
            label337:
            for (;;)
            {
              AppMethodBeat.o(352037);
              return localArrayList1;
              paramInt1 = 0;
              break;
              if (i > 0)
              {
                paramInt1 = 0;
                do
                {
                  paramInt2 = paramInt1 + 1;
                  localArrayList2.remove(0);
                  paramInt1 = paramInt2;
                } while (paramInt2 < i);
              }
              localArrayList1.remove(0);
              if (((Date)localObject).getMinutes() >= 55) {
                localArrayList2.remove(0);
              }
              if (!((Collection)localArrayList2).isEmpty()) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  break label337;
                }
                localArrayList1.add(0, localArrayList2);
                break;
              }
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Boolean, bif, ah>
  {
    a(cb paramcb, ah.f<com.tencent.mm.ui.base.w> paramf, String paramString1, bzc parambzc, int paramInt, com.tencent.mm.plugin.finder.live.model.context.a parama, long paramLong, String paramString2, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(ah.f<com.tencent.mm.ui.base.w> paramf, Context paramContext, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(351036);
      paramObject = (kotlin.d.d)new b(this.AWR, paramContext, paramd);
      AppMethodBeat.o(351036);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(351034);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(351034);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (bb.e(1000L, paramObject) == locala)
        {
          AppMethodBeat.o(351034);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      this.AWR.aqH = com.tencent.mm.ui.base.w.a(paramContext, (CharSequence)paramContext.getString(p.h.loading_tips), false, 0, null);
      paramObject = ah.aiuX;
      AppMethodBeat.o(351034);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    d(View paramView, kotlin.g.a.b<? super Bitmap, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$setETInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.mm.ui.tools.g
  {
    e(int paramInt, com.tencent.mm.ui.tools.g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(351045);
      Object localObject;
      if (paramSpanned == null)
      {
        paramInt1 = 0;
        if (paramInt1 <= paramInt3) {
          break label159;
        }
        if (paramSpanned != null) {
          break label144;
        }
        localObject = null;
        label26:
        paramInt1 = com.tencent.mm.ui.tools.g.a(String.valueOf(localObject), com.tencent.mm.ui.tools.g.a.afII);
        label38:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label174;
        }
      }
      label144:
      label159:
      label174:
      for (paramInt2 = com.tencent.mm.ui.tools.g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), com.tencent.mm.ui.tools.g.a.afII);; paramInt2 = 0)
      {
        paramInt3 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramCharSequence), com.tencent.mm.ui.tools.g.a.afII);
        paramInt1 = this.DKa - paramInt1 - paramInt2;
        if (paramInt3 <= paramInt1) {
          break label179;
        }
        paramSpanned = a.DJT;
        paramCharSequence = (CharSequence)a.u(String.valueOf(paramCharSequence), paramInt1, false);
        AppMethodBeat.o(351045);
        return paramCharSequence;
        paramInt1 = paramSpanned.length();
        break;
        localObject = paramSpanned.subSequence(0, paramInt3);
        break label26;
        paramInt1 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramSpanned), com.tencent.mm.ui.tools.g.a.afII);
        break label38;
      }
      label179:
      if (paramCharSequence == null)
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(351045);
        return paramCharSequence;
      }
      AppMethodBeat.o(351045);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$setETInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TextWatcher
  {
    f(TextView paramTextView, int paramInt, kotlin.g.a.a<ah> parama) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(351043);
      int i = com.tencent.mm.ui.tools.g.bCx(String.valueOf(paramEditable)) / 2;
      TextView localTextView = this.DKb;
      if (localTextView != null) {
        if (i < 0) {
          break label85;
        }
      }
      label85:
      for (paramEditable = (CharSequence)(i + '/' + paramInt2);; paramEditable = (CharSequence)kotlin.g.b.s.X("0/", Integer.valueOf(paramInt2)))
      {
        localTextView.setText(paramEditable);
        paramEditable = parama;
        if (paramEditable != null) {
          paramEditable.invoke();
        }
        AppMethodBeat.o(351043);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(Bitmap paramBitmap, ImageView paramImageView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(boolean paramBoolean, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    j(boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    k(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.a
 * JD-Core Version:    0.7.0.1
 */