package com.tencent.mm.plugin.finder.live.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.i;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.plugin.bi;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.rtmp.TXLivePlayConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/FinderLiveUtil;", "", "()V", "CONFIG_HIDE_LIVE_LOADING", "", "getCONFIG_HIDE_LIVE_LOADING", "()Z", "ENABLE_ADJUST_GIFT_NAME", "getENABLE_ADJUST_GIFT_NAME", "ENABLE_PRELOAD_OTHERS_WEAPP", "getENABLE_PRELOAD_OTHERS_WEAPP", "FINDER_LIVE_MMKV", "", "TAG", "TOUCH_DELEGATE_DEFAULT_VALUE", "", "liveListDebug", "getLiveListDebug", "setLiveListDebug", "(Z)V", "addSelfAppMsg", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "addSysMsg", "content", "adjustHorizontalMarginWhenLandScape", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "ifLeft", "ifRight", "adjustMarginTopInSecondaryLiveRoom", "adjustMarginWhenLandScape", "audienceMicLinked", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "audienceMicWaitingAudio", "audienceMicWaitingVideo", "audioModeFuncEnableByExpt", "audioModeFuncEnableBySwitchFlag", "switchFlag", "", "autoPlayFinderLiveList", "canShowAnchorPrecheckEntrance", "canShowVisitorRoleEntrance", "checkIfAtMe", "commentData", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "checkIfTickleMe", "visitorRole", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "checkInsertLiveNewReddot", "containAlias", "dataList", "Ljava/util/LinkedList;", "containStock", "platformId", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toWhere", "forceFetchObject", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "clickFeed", "commentScene", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "convertToVisitorLiveData", "tabType", "createShoppingCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "scene", "idList", "enableAnchorMusic", "enableCastScreen", "enableMoclLiveList", "formatNumber", "number", "getAddProductPreloadBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "getAliasInfoList", "getAtName", "getBadgeLevel", "badgeInfos", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "getConfettiManager", "Lcom/tencent/mm/particles/ConfettiManager;", "context", "Landroid/content/Context;", "generator", "Lcom/tencent/mm/particles/ConfettiGenerator;", "source", "Lcom/tencent/mm/particles/ConfettiSource;", "root", "Landroid/view/ViewGroup;", "getConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentOrientation", "activity", "Landroid/app/Activity;", "getDebugFinderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFinderCotactForSelfComment", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getFinderLiveAndienceFileIdList", "list", "", "", "getLanscapePadding", "isScondaryDevice", "getLiveConfettInterval", "getLiveContentTop", "getLiveCoverUrl", "liveCoverUrl", "anchorUserName", "getLiveDisplayName", "username", "nickname", "printLog", "getLiveTotalHeat", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)Ljava/lang/Long;", "getLotteryRemainTime", "beginTime", "endTime", "remainTime", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMiniprogramType", "getPreHotBunder", "page", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "preloadType", "getPreHotBundle", "appid", "path", "appUsername", "getPreloadMiniProgramBundleList", "getRenderMode", "isLandscape", "isScreenShareMode", "getSubMsgString", "msg", "maxCharCount", "withEllapse", "getTickleContact", "getVisibilityString", "visibilityMode", "showDetail", "getVisitorModeString", "visitorMode", "giftFuncEnableByContactFlag", "contactFlag", "handleJoinLiveLikeConfettiResponse", "response", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "hideSoftInput", "isAnchorLive", "isAnchorLiveWithoutSndDevice", "isAnchorPluginLayout", "finderBaseLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "isAnchorWithExternalPost", "isBuyProductMicUser", "userAttrFlag", "isEqual", "strA", "strB", "enableEmpty", "isFollowMicUser", "isFriend", "isInSecondaryDevice", "isLibPagEnabled", "isMyCurrentVisitorRole", "isMyself", "isPortrait", "isRewardMicUser", "isSelf", "isThreePartyProduct", "jumpAdPage", "pageId", "uxInfo", "likeSwitchEnableBySwitchFlag", "flag", "linkMicFuncEnableBySwitchFlag", "value", "micSettingBuyProduct", "micSettingBuyProductSwitch", "micSettingFollow", "micSettingFollowSwitch", "micSettingReward", "micSettingRewardSwitch", "parseAliasInfoContent", "msgContent", "parseAliasInfoList", "container", "parseFinderLiveAudienceList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "parseTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "extInfo", "prepareAnchorMusicInfo", "Lcom/tencent/mm/ui/MMActivity;", "bgMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBackgroundMusicInfo;", "printDebugMsg", "tag", "printVisitorRoleInfo", "prefix", "visitorRoleList", "curVisitorRoleType", "visitorRoleModifyTime", "readLiveListDebugInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "removeFromParent", "child", "Landroid/view/View;", "rewardGainEnableBySwitchFlag", "saveAliasInfoList", "aliasInfoList", "saveLiveListDebugInfo", "info", "saveVisitorRoleInfo", "visitorRoleType", "modifyTime", "screenShareFuncEnableBySwitchFlag", "setBigPitcureBlurBitmap", "view", "bitmap", "Landroid/graphics/Bitmap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "blurBitmap", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "Lkotlin/Function0;", "setLiveAvatar", "avatarIv", "avatarUrl", "roleType", "setLiveGiftTypeFace", "tv", "setSeekBarTouchDelegate", "seekbarParent", "seekBar", "Landroid/widget/SeekBar;", "SEEK_SCOPE", "setTouchDelegate", "dx", "dy", "showDebugToast", "vibrate", "watchLiveVisitorCore", "closeLive", "outSideLive", "plugin-finder_release"})
public final class a
{
  private static final boolean yRh;
  private static final boolean yRi;
  private static final boolean yRj;
  private static boolean yRk;
  private static final int yRl;
  public static final a yRm;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(257453);
    yRm = new a();
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ink().aSr()).intValue() == 0)
    {
      bool1 = true;
      yRh = bool1;
      localObject = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.inr().aSr()).intValue() != 0) {
        break label129;
      }
      bool1 = true;
      label64:
      yRi = bool1;
      localObject = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.ins().aSr()).intValue() != 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      yRj = bool1;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      yRl = ((Context)localObject).getResources().getDimensionPixelOffset(b.d.Edge_A);
      AppMethodBeat.o(257453);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label64;
    }
  }
  
  public static void B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(257425);
    p.k(paramContext, "context");
    p.k(paramString1, "pageId");
    p.k(paramString2, "uxInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ADInfo><uxInfo>").append(paramString2).append("</uxInfo></ADInfo>");
    paramString2 = new Intent();
    paramString2.putExtra("sns_landing_pages_pageid", Util.safeParseLong(paramString1));
    paramString2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
    paramString2.putExtra("sns_landig_pages_from_source", 24);
    paramString2.putExtra("sns_landing_pages_ad_info", localStringBuilder.toString());
    com.tencent.mm.by.c.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramString2);
    AppMethodBeat.o(257425);
  }
  
  public static int E(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(257381);
    p.k(paramContext, "context");
    if (ar.aN(paramContext)) {}
    for (int i = ax.getStatusBarHeight(paramContext);; i = 0)
    {
      if (paramBoolean) {
        j = ax.aB(paramContext);
      }
      if (!paramBoolean) {
        break;
      }
      i = kotlin.k.i.ov(i, j);
      j = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
      AppMethodBeat.o(257381);
      return i + j;
    }
    if (i > 0)
    {
      j = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
      AppMethodBeat.o(257381);
      return j + i;
    }
    i = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_3A);
    AppMethodBeat.o(257381);
    return i;
  }
  
  public static boolean LA(long paramLong)
  {
    AppMethodBeat.i(257436);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKw());
    AppMethodBeat.o(257436);
    return bool;
  }
  
  public static boolean LE(long paramLong)
  {
    AppMethodBeat.i(257397);
    boolean bool = com.tencent.mm.ae.d.dr((int)paramLong, 4);
    AppMethodBeat.o(257397);
    return bool;
  }
  
  public static boolean LF(long paramLong)
  {
    AppMethodBeat.i(257398);
    boolean bool = com.tencent.mm.ae.d.dr((int)paramLong, 256);
    AppMethodBeat.o(257398);
    return bool;
  }
  
  public static boolean LG(long paramLong)
  {
    AppMethodBeat.i(257399);
    boolean bool = com.tencent.mm.ae.d.dr((int)paramLong, 128);
    AppMethodBeat.o(257399);
    return bool;
  }
  
  public static boolean LH(long paramLong)
  {
    AppMethodBeat.i(257400);
    boolean bool = com.tencent.mm.ae.d.dr((int)paramLong, 8);
    AppMethodBeat.o(257400);
    return bool;
  }
  
  public static boolean LI(long paramLong)
  {
    AppMethodBeat.i(257402);
    boolean bool = com.tencent.mm.ae.d.dr((int)paramLong, 1);
    AppMethodBeat.o(257402);
    return bool;
  }
  
  public static boolean LJ(long paramLong)
  {
    AppMethodBeat.i(257431);
    int i = (int)paramLong;
    e.i locali = e.i.kku;
    if (!com.tencent.mm.ae.d.dr(i, e.i.aKy()))
    {
      AppMethodBeat.o(257431);
      return true;
    }
    AppMethodBeat.o(257431);
    return false;
  }
  
  public static boolean LK(long paramLong)
  {
    AppMethodBeat.i(257432);
    int i = (int)paramLong;
    e.i locali = e.i.kku;
    if (!com.tencent.mm.ae.d.dr(i, e.i.aKx()))
    {
      AppMethodBeat.o(257432);
      return true;
    }
    AppMethodBeat.o(257432);
    return false;
  }
  
  public static boolean LL(long paramLong)
  {
    AppMethodBeat.i(257433);
    int i = (int)paramLong;
    e.i locali = e.i.kku;
    if (!com.tencent.mm.ae.d.dr(i, e.i.aKz()))
    {
      AppMethodBeat.o(257433);
      return true;
    }
    AppMethodBeat.o(257433);
    return false;
  }
  
  public static boolean Ly(long paramLong)
  {
    AppMethodBeat.i(257434);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKv());
    AppMethodBeat.o(257434);
    return bool;
  }
  
  public static boolean Lz(long paramLong)
  {
    AppMethodBeat.i(257435);
    int i = (int)paramLong;
    e.h localh = e.h.kkq;
    boolean bool = com.tencent.mm.ae.d.dr(i, e.h.aKu());
    AppMethodBeat.o(257435);
    return bool;
  }
  
  public static String NH(int paramInt)
  {
    AppMethodBeat.i(257408);
    if ((paramInt != 0) && (com.tencent.mm.ae.d.dr(paramInt, 7)))
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_visibility_white_list_group_toast_tips);
      p.j(localObject, "if (showDetail) {\n      …e_list)\n                }");
      AppMethodBeat.o(257408);
      return localObject;
    }
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(b.j.finder_live_visibility_public_tips);
    p.j(localObject, "if (showDetail) {\n      …1/19/21\n                }");
    AppMethodBeat.o(257408);
    return localObject;
  }
  
  public static String NI(int paramInt)
  {
    AppMethodBeat.i(257412);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(257412);
      return "";
    case 1: 
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(b.j.finder_live_visitor_role_wechat);
      p.j(localObject, "MMApplicationContext.get…live_visitor_role_wechat)");
      AppMethodBeat.o(257412);
      return localObject;
    }
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(b.j.finder_live_visitor_role_finder);
    p.j(localObject, "MMApplicationContext.get…live_visitor_role_finder)");
    AppMethodBeat.o(257412);
    return localObject;
  }
  
  public static boolean NJ(int paramInt)
  {
    return paramInt > 0;
  }
  
  public static boolean NK(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 9999999) || (paramInt == 10000000);
  }
  
  public static void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(257447);
    Object localObject = com.tencent.mm.live.core.core.c.a.kqk;
    final int i = com.tencent.mm.live.core.core.c.a.aMe().size();
    if (paramBoolean1)
    {
      if ((i > 1) || ((paramBoolean2) && (i > 0)))
      {
        f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveVisitorCoreLeak", false, false, (kotlin.g.a.a)new o(paramBoolean2, i), 12);
        if ((paramBoolean2) && ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG)))
        {
          com.tencent.mm.ui.base.w.makeText(MMApplicationContext.getContext(), (CharSequence)"liveVisitorCoreLeak size=".concat(String.valueOf(i)), 0).show();
          if (BuildInfo.DEBUG)
          {
            localObject = (Throwable)new RuntimeException("liveVisitorCoreLeak size=".concat(String.valueOf(i)));
            AppMethodBeat.o(257447);
            throw ((Throwable)localObject);
          }
        }
      }
    }
    else if (i > 2) {
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveVisitorCoreOverSize", false, false, (kotlin.g.a.a)new p(i), 12);
    }
    AppMethodBeat.o(257447);
  }
  
  public static String XU(long paramLong)
  {
    AppMethodBeat.i(293231);
    if (LocaleUtil.isChineseAppLang())
    {
      if ((float)paramLong < 10000.0F) {}
      try
      {
        AppMethodBeat.o(293231);
        return String.valueOf(paramLong);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.i("FinderLiveUtil", "[formatNumber] errMsg:" + localException.getMessage());
          localObject2 = "";
        }
      }
      if (((float)paramLong >= 10000.0F) && ((float)paramLong < 1.0E+008F))
      {
        localObject1 = af.aaBG;
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_number_10000);
        p.j(localObject1, "MMApplicationContext.get…ring.finder_number_10000)");
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 10000.0F) }, 1));
        p.j(localObject1, "java.lang.String.format(format, *args)");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(293231);
      return localObject1;
      localObject1 = af.aaBG;
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_number_more_than_100000000_v2);
      p.j(localObject1, "MMApplicationContext.get…r_more_than_100000000_v2)");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      continue;
      Object localObject2;
      if ((float)paramLong < 1000.0F)
      {
        AppMethodBeat.o(293231);
        return String.valueOf(paramLong);
      }
      if (((float)paramLong >= 1000.0F) && ((float)paramLong < 1000000.0F))
      {
        localObject2 = af.aaBG;
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_number_10000_en);
        p.j(localObject2, "MMApplicationContext.get…g.finder_number_10000_en)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1000.0F) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
      }
      else if (((float)paramLong >= 1000000.0F) && ((float)paramLong < 1.0E+009F))
      {
        localObject2 = af.aaBG;
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_number_more_than_100000000_en_v2);
        p.j(localObject2, "MMApplicationContext.get…ore_than_100000000_en_v2)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1000000.0F) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
      }
      else
      {
        localObject2 = af.aaBG;
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_number_more_than_billion_en);
        p.j(localObject2, "MMApplicationContext.get…ber_more_than_billion_en)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Float.valueOf((float)paramLong / 1.0E+009F) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
      }
    }
  }
  
  public static int a(com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 5;
    AppMethodBeat.i(257390);
    p.k(parama, "liveData");
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ();
    e.b localb = e.b.kjz;
    if (i == e.b.aJJ()) {
      if (paramBoolean2) {
        i = j;
      }
    }
    for (;;)
    {
      Log.i("FinderLiveUtil", "getRenderMode audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ() + ", renderMode:" + i);
      AppMethodBeat.o(257390);
      return i;
      i = j;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy) {
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGT())
        {
          i = j;
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGQ())
          {
            i = j;
            if (paramBoolean1) {}
          }
        }
        else
        {
          i = 2;
          continue;
          localb = e.b.kjz;
          if (i == e.b.aJK())
          {
            if (paramBoolean2)
            {
              i = 1;
            }
            else if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy)
            {
              i = 1;
            }
            else
            {
              if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGT())
              {
                if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGQ())
                {
                  i = 1;
                  continue;
                }
                if (paramBoolean1)
                {
                  i = 1;
                  continue;
                }
              }
              i = 0;
            }
          }
          else
          {
            Log.i("FinderLiveUtil", "unknown audienceMode:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGJ());
            i = 0;
          }
        }
      }
    }
  }
  
  public static com.tencent.mm.particles.c a(Context paramContext, com.tencent.mm.particles.b paramb, com.tencent.mm.particles.d paramd, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(257438);
    p.k(paramContext, "context");
    p.k(paramb, "generator");
    p.k(paramd, "source");
    p.k(paramViewGroup, "root");
    paramContext = new com.tencent.mm.particles.c(paramContext, paramb, paramd, paramViewGroup).ax(1.0F).but().I(-360.0F, 50.0F).GZ(1000L).bur();
    p.j(paramContext, "ConfettiManager(context,…   .setNumInitialCount(1)");
    AppMethodBeat.o(257438);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.appbrand.api.g a(ahj paramahj)
  {
    AppMethodBeat.i(257443);
    p.k(paramahj, "page");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramahj.appid;
    localg.nBq = paramahj.path;
    at localat = new at();
    localat.yiA = 1;
    localat.yiF = 3;
    localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localat);
    if (dEy()) {}
    for (int i = 1176;; i = 1177)
    {
      localg.scene = i;
      localg.nBE = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, false, null, null, false, 8188);
      localg.username = paramahj.username;
      localg.cBU = dEO();
      AppMethodBeat.o(257443);
      return localg;
    }
  }
  
  public static FinderLiveBundle a(ArrayList<bu> paramArrayList, bu parambu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257368);
    p.k(paramArrayList, "data");
    p.k(parambu, "clickFeed");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((Iterable)paramArrayList).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bu)((Iterator)localObject1).next();
      boolean bool = localObject2 instanceof BaseFinderFeed;
      paramArrayList = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (localObject2 == null)
      {
        paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(257368);
        throw paramArrayList;
      }
      if ((com.tencent.mm.plugin.finder.utils.aj.w((BaseFinderFeed)localObject2) & bool))
      {
        paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getLiveInfo();
          if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
          {
            paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(((bu)localObject2).mf()).append(",is click feed:");
            long l = ((bu)localObject2).mf();
            label196:
            StringBuilder localStringBuilder;
            if ((parambu != null) && (l == parambu.mf()))
            {
              bool = true;
              localStringBuilder = paramArrayList.append(bool).append(",nickname:");
              paramArrayList = ((BaseFinderFeed)localObject2).contact;
              if (paramArrayList == null) {
                break label326;
              }
              paramArrayList = paramArrayList.getNickname();
              label228:
              localStringBuilder = localStringBuilder.append(paramArrayList).append(",live status:");
              paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
              if (paramArrayList == null) {
                break label331;
              }
              paramArrayList = paramArrayList.getLiveInfo();
              if (paramArrayList == null) {
                break label331;
              }
            }
            label326:
            label331:
            for (paramArrayList = Integer.valueOf(paramArrayList.liveStatus);; paramArrayList = null)
            {
              Log.i("FinderLiveUtil", paramArrayList + '!');
              if (((bu)localObject2).mf() != parambu.mf()) {
                break;
              }
              localArrayList.add(localObject2);
              break;
              bool = false;
              break label196;
              paramArrayList = null;
              break label228;
            }
          }
        }
        localArrayList.add(localObject2);
      }
    }
    int i = kotlin.a.j.a((List)localArrayList, parambu);
    if (i >= 0) {}
    for (;;)
    {
      localObject1 = new FinderLiveBundle();
      ((FinderLiveBundle)localObject1).yeA = i;
      ((FinderLiveBundle)localObject1).fEH = paramInt1;
      ((FinderLiveBundle)localObject1).xkX = paramInt2;
      localObject2 = (Iterable)localArrayList;
      paramArrayList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramArrayList.add(a(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject(), 0, false, 6));
      }
      i = 0;
    }
    ((FinderLiveBundle)localObject1).ae(new ArrayList((Collection)paramArrayList));
    if (!(parambu instanceof BaseFinderFeed)) {}
    for (paramArrayList = null;; paramArrayList = parambu)
    {
      paramArrayList = (BaseFinderFeed)paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.feedObject;
        if (paramArrayList != null)
        {
          parambu = paramArrayList.getNickName();
          paramArrayList = parambu;
          if (parambu != null) {
            break label535;
          }
        }
      }
      paramArrayList = "";
      label535:
      ((FinderLiveBundle)localObject1).aCa(paramArrayList);
      paramArrayList = (BaseFinderFeed)kotlin.a.j.M((List)localArrayList, i);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getFeedObject();
          if (paramArrayList != null)
          {
            paramArrayList = paramArrayList.liveInfo;
            if (paramArrayList == null) {}
          }
        }
      }
      for (paramInt1 = paramArrayList.SLO;; paramInt1 = 0)
      {
        ((FinderLiveBundle)localObject1).extFlag = paramInt1;
        AppMethodBeat.o(257368);
        return localObject1;
      }
    }
  }
  
  public static FinderLiveBundle a(ArrayList<bu> paramArrayList, bu parambu, int paramInt, boolean paramBoolean, awq paramawq)
  {
    AppMethodBeat.i(257366);
    p.k(paramArrayList, "data");
    p.k(parambu, "clickFeed");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((Iterable)paramArrayList).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bu)((Iterator)localObject1).next();
      boolean bool = localObject2 instanceof BaseFinderFeed;
      paramArrayList = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (localObject2 == null)
      {
        paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(257366);
        throw paramArrayList;
      }
      if ((com.tencent.mm.plugin.finder.utils.aj.w((BaseFinderFeed)localObject2) & bool))
      {
        paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getLiveInfo();
          if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
          {
            paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(((bu)localObject2).mf()).append(",is click feed:");
            long l = ((bu)localObject2).mf();
            label196:
            StringBuilder localStringBuilder;
            if ((parambu != null) && (l == parambu.mf()))
            {
              bool = true;
              localStringBuilder = paramArrayList.append(bool).append(",nickname:");
              paramArrayList = ((BaseFinderFeed)localObject2).contact;
              if (paramArrayList == null) {
                break label326;
              }
              paramArrayList = paramArrayList.getNickname();
              label228:
              localStringBuilder = localStringBuilder.append(paramArrayList).append(",live status:");
              paramArrayList = ((BaseFinderFeed)localObject2).feedObject;
              if (paramArrayList == null) {
                break label331;
              }
              paramArrayList = paramArrayList.getLiveInfo();
              if (paramArrayList == null) {
                break label331;
              }
            }
            label326:
            label331:
            for (paramArrayList = Integer.valueOf(paramArrayList.liveStatus);; paramArrayList = null)
            {
              Log.i("FinderLiveUtil", paramArrayList + '!');
              if (((bu)localObject2).mf() != parambu.mf()) {
                break;
              }
              localArrayList.add(localObject2);
              break;
              bool = false;
              break label196;
              paramArrayList = null;
              break label228;
            }
          }
        }
        localArrayList.add(localObject2);
      }
    }
    int i = kotlin.a.j.a((List)localArrayList, parambu);
    if (i >= 0) {}
    for (;;)
    {
      localObject1 = new FinderLiveBundle();
      ((FinderLiveBundle)localObject1).yeA = i;
      ((FinderLiveBundle)localObject1).xkX = paramInt;
      localObject2 = (Iterable)localArrayList;
      paramArrayList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramArrayList.add(a(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject(), 0, paramBoolean, 2));
      }
      i = 0;
    }
    ((FinderLiveBundle)localObject1).ae(new ArrayList((Collection)paramArrayList));
    ((FinderLiveBundle)localObject1).yeH = 1;
    ((FinderLiveBundle)localObject1).xdb = paramawq;
    if (!(parambu instanceof BaseFinderFeed)) {}
    for (paramArrayList = null;; paramArrayList = parambu)
    {
      paramArrayList = (BaseFinderFeed)paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.feedObject;
        if (paramArrayList != null)
        {
          parambu = paramArrayList.getNickName();
          paramArrayList = parambu;
          if (parambu != null) {
            break label541;
          }
        }
      }
      paramArrayList = "";
      label541:
      ((FinderLiveBundle)localObject1).aCa(paramArrayList);
      paramArrayList = (BaseFinderFeed)kotlin.a.j.lp((List)localArrayList);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getFeedObject();
          ((FinderLiveBundle)localObject1).yeL = paramArrayList;
          paramArrayList = (BaseFinderFeed)kotlin.a.j.M((List)localArrayList, i);
          if (paramArrayList == null) {
            break label653;
          }
          paramArrayList = paramArrayList.feedObject;
          if (paramArrayList == null) {
            break label653;
          }
          paramArrayList = paramArrayList.getFeedObject();
          if (paramArrayList == null) {
            break label653;
          }
          paramArrayList = paramArrayList.liveInfo;
          if (paramArrayList == null) {
            break label653;
          }
        }
      }
      label653:
      for (paramInt = paramArrayList.SLO;; paramInt = 0)
      {
        ((FinderLiveBundle)localObject1).extFlag = paramInt;
        AppMethodBeat.o(257366);
        return localObject1;
        paramArrayList = null;
        break;
      }
    }
  }
  
  public static aza a(Context paramContext, com.tencent.mm.plugin.finder.live.model.ao paramao)
  {
    AppMethodBeat.i(257387);
    p.k(paramContext, "context");
    p.k(paramao, "commentData");
    if (((paramao instanceof com.tencent.mm.plugin.finder.live.model.q)) && (paramao.getType() == 20001))
    {
      paramContext = ((com.tencent.mm.plugin.finder.live.model.q)paramao).yet.SJC;
      AppMethodBeat.o(257387);
      return paramContext;
    }
    AppMethodBeat.o(257387);
    return null;
  }
  
  public static q.f a(final int paramInt, final Context paramContext, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(257359);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "feed");
    paramContext = (q.f)new d(paramBaseFinderFeed, paramInt, paramContext);
    AppMethodBeat.o(257359);
    return paramContext;
  }
  
  public static q.f a(final Context paramContext, BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(257357);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "feed");
    p.k(parame, "sheet");
    paramContext = (q.f)new c(paramBaseFinderFeed, paramContext, parame);
    AppMethodBeat.o(257357);
    return paramContext;
  }
  
  public static Long a(bac parambac)
  {
    AppMethodBeat.i(257426);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    long l;
    if (((Number)com.tencent.c.a.a.a.a.a.ilj().aSr()).intValue() == 1)
    {
      if (parambac != null)
      {
        l = parambac.SHu;
        AppMethodBeat.o(257426);
        return Long.valueOf(l);
      }
      AppMethodBeat.o(257426);
      return null;
    }
    if (parambac != null)
    {
      l = parambac.SHj;
      AppMethodBeat.o(257426);
      return Long.valueOf(l);
    }
    AppMethodBeat.o(257426);
    return null;
  }
  
  public static String a(String paramString, LinkedList<axc> paramLinkedList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(257423);
    p.k(paramString, "prefix");
    p.k(paramLinkedList, "visitorRoleList");
    StringBuilder localStringBuilder1 = new StringBuilder("[printVisitorRoleInfo]" + paramString + ":curVisitorRoleType:" + paramInt + ";visitorRoleModifyTime:" + paramLong + ';');
    synchronized ((Iterable)paramLinkedList)
    {
      Iterator localIterator = ???.iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        paramString = localIterator.next();
        if (paramInt < 0) {
          kotlin.a.j.iBO();
        }
        paramLinkedList = (axc)paramString;
        StringBuilder localStringBuilder2 = new StringBuilder("[").append(paramInt).append(':');
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        localStringBuilder1.append(com.tencent.mm.ae.g.bN(paramString) + ']');
        paramInt += 1;
      }
      paramString = x.aazN;
      paramString = localStringBuilder1.toString();
      p.j(paramString, "msg.toString()");
      AppMethodBeat.o(257423);
      return paramString;
    }
  }
  
  public static LinkedList<ayj> a(List<byte[]> paramList, LinkedList<ayj> paramLinkedList)
  {
    AppMethodBeat.i(257409);
    p.k(paramList, "list");
    if (paramLinkedList == null) {
      paramLinkedList = new LinkedList();
    }
    for (;;)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        ayj localayj = new ayj();
        localayj.parseFrom(arrayOfByte);
        paramLinkedList.add(localayj);
      }
      paramLinkedList.clear();
    }
    AppMethodBeat.o(257409);
    return paramLinkedList;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.api.g> a(azy paramazy)
  {
    AppMethodBeat.i(257441);
    ArrayList localArrayList = new ArrayList();
    aa.f localf = new aa.f();
    if (paramazy != null)
    {
      paramazy = paramazy.SLy;
      if (paramazy != null)
      {
        paramazy = paramazy.SOy;
        if (paramazy != null)
        {
          paramazy = ((Iterable)paramazy).iterator();
          if (paramazy.hasNext())
          {
            bdk localbdk = (bdk)paramazy.next();
            localf.aaBC = new com.tencent.mm.plugin.appbrand.api.g();
            ((com.tencent.mm.plugin.appbrand.api.g)localf.aaBC).appId = localbdk.appid;
            ((com.tencent.mm.plugin.appbrand.api.g)localf.aaBC).nBq = localbdk.SOu;
            com.tencent.mm.plugin.appbrand.api.g localg = (com.tencent.mm.plugin.appbrand.api.g)localf.aaBC;
            Object localObject = new at();
            if (localbdk.SOt)
            {
              ((at)localObject).yiF = 1;
              label147:
              ((at)localObject).yiA = 1;
              localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
              localg = (com.tencent.mm.plugin.appbrand.api.g)localf.aaBC;
              if (!dEy()) {
                break label297;
              }
            }
            label297:
            for (int i = 1176;; i = 1177)
            {
              localg.scene = i;
              localg = (com.tencent.mm.plugin.appbrand.api.g)localf.aaBC;
              localObject = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
              localg.nBE = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, com.tencent.mm.plugin.finder.live.view.convert.a.a(localbdk), null, null, false, 7676);
              ((com.tencent.mm.plugin.appbrand.api.g)localf.aaBC).cBU = dEO();
              localArrayList.add((com.tencent.mm.plugin.appbrand.api.g)localf.aaBC);
              break;
              if (localbdk.SOv)
              {
                ((at)localObject).yiF = 2;
                break label147;
              }
              if (!localbdk.SOw) {
                break label147;
              }
              ((at)localObject).yiF = 3;
              break label147;
            }
          }
        }
      }
    }
    paramazy = (List)localArrayList;
    AppMethodBeat.o(257441);
    return paramazy;
  }
  
  public static void a(View paramView, Bitmap paramBitmap, final kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(257362);
    p.k(paramView, "view");
    p.k(paramBitmap, "bitmap");
    Object localObject = com.tencent.mm.live.b.d.a.kyA;
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    com.tencent.mm.live.b.d.a.a.a(paramBitmap, ((Context)localObject).getResources().getColor(b.c.UN_BW_0_Alpha_0_3), (kotlin.g.a.b)new g(paramView, paramb));
    AppMethodBeat.o(257362);
  }
  
  public static void a(EditText paramEditText, TextView paramTextView, int paramInt1, final int paramInt2, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(257406);
    InputFilter localInputFilter1 = (InputFilter)new h(paramEditText);
    InputFilter localInputFilter2 = (InputFilter)new i(paramInt1, paramInt1, g.a.XSu);
    if (paramEditText != null) {
      paramEditText.setFilters(new InputFilter[] { localInputFilter1, localInputFilter2 });
    }
    paramTextView = (TextWatcher)new j(paramTextView, paramInt2, parama);
    if (paramEditText != null)
    {
      paramEditText.addTextChangedListener(paramTextView);
      AppMethodBeat.o(257406);
      return;
    }
    AppMethodBeat.o(257406);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(257378);
    p.k(paramd, "plugin");
    if ((paramd.ylc.getLayoutParams() != null) && ((paramd.ylc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramd.isLandscape()))
    {
      Context localContext = paramd.ylc.getContext();
      p.j(localContext, "plugin.vg.context");
      int i = localContext.getResources().getDimensionPixelOffset(b.d.Edge_2A);
      paramd = paramd.ylc.getLayoutParams();
      if (paramd == null)
      {
        paramd = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(257378);
        throw paramd;
      }
      ((ViewGroup.MarginLayoutParams)paramd).topMargin = i;
    }
    AppMethodBeat.o(257378);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(257379);
    p.k(paramd, "plugin");
    paramd.ylc.post((Runnable)new b(paramd, paramBoolean));
    AppMethodBeat.o(257379);
  }
  
  public static void a(awj paramawj, bi parambi, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(257363);
    p.k(paramawj, "response");
    p.k(parama, "liveData");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfL.clear();
    paramawj = paramawj.SIX;
    if (paramawj != null)
    {
      paramawj = paramawj.SJx;
      StringBuilder localStringBuilder = new StringBuilder("handleJoinLiveLikeConfettiResponse, size:");
      if (paramawj != null) {
        localObject = Integer.valueOf(paramawj.size());
      }
      localObject = localStringBuilder.append(localObject).append(", confettiPlugin init ok?:");
      if (parambi == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderLiveUtil", bool);
      localObject = (Collection)paramawj;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {
        i = 1;
      }
      if (i != 0) {
        break label205;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfL.addAll((Collection)paramawj);
      if (parambi == null) {
        break label205;
      }
      parambi.ao(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfL);
      AppMethodBeat.o(257363);
      return;
      paramawj = null;
      break;
    }
    label205:
    AppMethodBeat.o(257363);
  }
  
  public static void a(axe paramaxe, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(257385);
    p.k(paramaxe, "appMsg");
    p.k(parama, "liveData");
    com.tencent.mm.plugin.finder.live.model.q localq = new com.tencent.mm.plugin.finder.live.model.q(paramaxe);
    aza localaza = new aza();
    localaza.contact = m(parama);
    localaza.SHe = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeX;
    paramaxe.SJH = localaza;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(localq);
    paramaxe = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.aNv();
    AppMethodBeat.o(257385);
  }
  
  public static void a(final MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, ayk paramayk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(257445);
    p.k(paramMMActivity, "activity");
    p.k(parama, "liveData");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.klq;
    if (b.b.aLi())
    {
      if (paramayk != null)
      {
        localObject1 = paramayk.SKz;
        localObject1 = (Collection)localObject1;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label290;
        }
        i = 1;
        label68:
        if (i != 0) {
          break label300;
        }
        localObject1 = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydh;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label295;
        }
      }
      label290:
      label295:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label300;
        }
        com.tencent.mm.plugin.finder.live.model.b localb = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj;
        localObject1 = localObject2;
        if (paramayk != null) {
          localObject1 = paramayk.SKz;
        }
        localb.f((LinkedList)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv);
        paramayk = com.tencent.mm.plugin.finder.live.model.b.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj);
        Log.i("FinderLiveUtil", "prepareAnchorMusicInfo udpateMusicList:".concat(String.valueOf(paramayk)));
        if (paramayk == null) {
          break label300;
        }
        new com.tencent.mm.plugin.finder.live.model.cgi.r(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, z.bdh(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, 1, paramayk, (r.a)new f(parama, paramMMActivity)).bhW().a((com.tencent.mm.vending.e.b)paramMMActivity);
        AppMethodBeat.o(257445);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label68;
      }
    }
    label300:
    AppMethodBeat.o(257445);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(257386);
    p.k(paramString, "content");
    p.k(parama, "liveData");
    bbd localbbd = new bbd();
    localbbd.type = 10001;
    localbbd.content = paramString;
    paramString = new ak(localbbd);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).ziq.add(paramString);
    paramString = com.tencent.mm.live.b.j.kue;
    com.tencent.mm.live.b.j.aNv();
    AppMethodBeat.o(257386);
  }
  
  public static void a(LinkedList<axc> paramLinkedList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(257416);
    aq(paramLinkedList);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyS, Integer.valueOf(paramInt));
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyW, Long.valueOf(paramLong));
    localObject = paramLinkedList;
    if (paramLinkedList == null) {
      localObject = new LinkedList();
    }
    Log.i("FinderLiveUtil", String.valueOf(a("saveVisitorRoleInfo", (LinkedList)localObject, paramInt, paramLong)));
    AppMethodBeat.o(257416);
  }
  
  public static boolean a(com.tencent.mm.plugin.finder.live.model.ao paramao)
  {
    Object localObject2 = null;
    AppMethodBeat.i(257383);
    p.k(paramao, "commentData");
    if (((paramao instanceof com.tencent.mm.plugin.finder.live.model.q)) && (paramao.getType() == 20002))
    {
      Object localObject1 = ((com.tencent.mm.plugin.finder.live.model.q)paramao).yet.SJC;
      if (localObject1 != null)
      {
        localObject1 = ((aza)localObject1).contact;
        if (localObject1 != null)
        {
          localObject1 = ((FinderContact)localObject1).username;
          if (!p.h(localObject1, z.bcZ()))
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.model.q)paramao).yet.SJC;
            if (localObject1 == null) {
              break label168;
            }
            localObject1 = ((aza)localObject1).contact;
            if (localObject1 == null) {
              break label168;
            }
          }
        }
      }
      label168:
      for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
      {
        if (!p.h(localObject1, z.bdh()))
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.q)paramao).yet.SJC;
          paramao = localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((aza)localObject1).contact;
            paramao = localObject2;
            if (localObject1 != null) {
              paramao = ((FinderContact)localObject1).username;
            }
          }
          if (!p.h(paramao, z.bdi())) {
            break label173;
          }
        }
        AppMethodBeat.o(257383);
        return true;
        localObject1 = null;
        break;
      }
    }
    label173:
    AppMethodBeat.o(257383);
    return false;
  }
  
  public static boolean aA(Context paramContext)
  {
    AppMethodBeat.i(257446);
    p.k(paramContext, "context");
    paramContext = paramContext.getResources();
    if (paramContext != null)
    {
      paramContext = paramContext.getConfiguration();
      if ((paramContext != null) && (paramContext.orientation == 1))
      {
        AppMethodBeat.o(257446);
        return true;
      }
    }
    AppMethodBeat.o(257446);
    return false;
  }
  
  public static void aC(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(257374);
    p.k(paramContext, "context");
    p.k(paramString, "msg");
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eej()) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(paramContext, paramString));
    }
    AppMethodBeat.o(257374);
  }
  
  public static boolean aCQ(String paramString)
  {
    AppMethodBeat.i(257421);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(257421);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.aFJ(paramString))
    {
      AppMethodBeat.o(257421);
      return true;
    }
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.PE(paramString))
    {
      AppMethodBeat.o(257421);
      return true;
    }
    AppMethodBeat.o(257421);
    return false;
  }
  
  public static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(257407);
    Object localObject = new StringBuilder("_finder_live_mmkv");
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject = MultiProcessMMKV.getMMKV(com.tencent.mm.kernel.b.getUin());
    p.j(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(257407);
    return localObject;
  }
  
  public static int ah(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(257382);
    int k = cm.bfF();
    int j = paramInt2 - k;
    int m = paramInt2 - paramInt1;
    if ((j > m) || (j > paramInt3)) {}
    for (int i = paramInt3;; i = j)
    {
      if (j <= 0) {
        i = 0;
      }
      Log.i("FinderLiveUtil", "getLotteryRemainTime serverTime:" + k + ",beginTime:" + paramInt1 + ",endTime:" + paramInt2 + ",remainTime:" + paramInt3 + ",calRemainTime:" + j + ",duration:" + m + ",result:" + i);
      AppMethodBeat.o(257382);
      return i;
    }
  }
  
  public static void aq(Activity paramActivity)
  {
    AppMethodBeat.i(257424);
    p.k(paramActivity, "activity");
    View localView = paramActivity.getCurrentFocus();
    if (localView != null)
    {
      paramActivity = localView.getContext();
      if (paramActivity != null) {}
      for (paramActivity = paramActivity.getSystemService("input_method");; paramActivity = null)
      {
        paramActivity = (InputMethodManager)paramActivity;
        if (paramActivity == null) {
          break;
        }
        paramActivity.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        AppMethodBeat.o(257424);
        return;
      }
    }
    AppMethodBeat.o(257424);
  }
  
  public static void aq(LinkedList<axc> paramLinkedList)
  {
    AppMethodBeat.i(257417);
    try
    {
      axd localaxd = new axd();
      localObject = paramLinkedList;
      if (paramLinkedList == null) {
        localObject = new LinkedList();
      }
      localaxd.SID = ((LinkedList)localObject);
      paramLinkedList = localaxd.toByteArray();
      p.j(paramLinkedList, "saveList.toByteArray()");
      paramLinkedList = new String(paramLinkedList, kotlin.n.d.ISO_8859_1);
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyT, paramLinkedList);
      Log.i("FinderLiveUtil", "saveAliasInfoList cacheListStr:" + com.tencent.mm.ae.g.bN(localaxd));
      AppMethodBeat.o(257417);
      return;
    }
    catch (Exception paramLinkedList)
    {
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.a(paramLinkedList, "saveAliasInfoList:" + paramLinkedList.getMessage());
      AppMethodBeat.o(257417);
    }
  }
  
  public static boolean ar(LinkedList<axc> paramLinkedList)
  {
    AppMethodBeat.i(257429);
    p.k(paramLinkedList, "dataList");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      if (((axc)paramLinkedList.next()).SJy == 2)
      {
        AppMethodBeat.o(257429);
        return true;
      }
    }
    AppMethodBeat.o(257429);
    return false;
  }
  
  public static int as(LinkedList<ayl> paramLinkedList)
  {
    AppMethodBeat.i(257450);
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      int i;
      if (localIterator.hasNext())
      {
        paramLinkedList = localIterator.next();
        if (((ayl)paramLinkedList).SKA == 1)
        {
          i = 1;
          label49:
          if (i == 0) {
            break label78;
          }
        }
      }
      for (;;)
      {
        paramLinkedList = (ayl)paramLinkedList;
        if (paramLinkedList == null) {
          break label85;
        }
        i = paramLinkedList.SKC;
        AppMethodBeat.o(257450);
        return i;
        i = 0;
        break label49;
        label78:
        break;
        paramLinkedList = null;
      }
    }
    label85:
    AppMethodBeat.o(257450);
    return -1;
  }
  
  public static com.tencent.mm.plugin.appbrand.api.g b(azy paramazy)
  {
    AppMethodBeat.i(257442);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    int i;
    if (paramazy != null)
    {
      Object localObject = paramazy.SLw;
      String str;
      if (localObject != null)
      {
        str = ((bln)localObject).appId;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localg.appId = ((String)localObject);
      localObject = paramazy.SLw;
      if (localObject != null)
      {
        str = ((bln)localObject).SWz;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localg.nBq = ((String)localObject);
      localObject = new at();
      ((at)localObject).yiA = 1;
      ((at)localObject).yiF = 1;
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
      if (!dEy()) {
        break label260;
      }
      i = 1176;
      localg.scene = i;
      localg.nBE = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, false, null, null, false, 8188);
      paramazy = paramazy.SLw;
      if (paramazy == null) {
        break label267;
      }
    }
    label260:
    label267:
    for (paramazy = paramazy.Sba;; paramazy = null)
    {
      localg.username = paramazy;
      paramazy = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if ((com.tencent.mm.plugin.finder.utils.aj.eej()) && (!Util.isNullOrNil(localg.username)))
      {
        paramazy = localg.username;
        if ((paramazy != null) && (!kotlin.n.n.pu(paramazy, "@app")))
        {
          paramazy = localg.username;
          localg.username = (paramazy + "@app");
        }
      }
      localg.cBU = dEO();
      AppMethodBeat.o(257442);
      return localg;
      i = 1177;
      break;
    }
  }
  
  public static aqt b(int paramInt, LinkedList<Long> paramLinkedList)
  {
    AppMethodBeat.i(257439);
    p.k(paramLinkedList, "idList");
    aqt localaqt = new aqt();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramLinkedList = (LinkedList<Long>)localObject;
    case 101: 
    case 102: 
      for (;;)
      {
        if (paramLinkedList != null)
        {
          localaqt.cmdId = paramInt;
          localaqt.SDX = com.tencent.mm.cd.b.cU(paramLinkedList.toByteArray());
        }
        AppMethodBeat.o(257439);
        return localaqt;
        localObject = new bba();
        ((bba)localObject).SMK = paramLinkedList;
        paramLinkedList = (com.tencent.mm.cd.a)localObject;
        continue;
        localObject = new baz();
        ((baz)localObject).SMJ = paramLinkedList;
        paramLinkedList = (com.tencent.mm.cd.a)localObject;
      }
    }
    localObject = new bay();
    paramLinkedList = (Long)kotlin.a.j.lp((List)paramLinkedList);
    if (paramLinkedList != null) {}
    for (long l = paramLinkedList.longValue();; l = 0L)
    {
      ((bay)localObject).zaO = l;
      paramLinkedList = (com.tencent.mm.cd.a)localObject;
      break;
    }
  }
  
  public static String b(com.tencent.mm.plugin.finder.live.model.ao paramao)
  {
    AppMethodBeat.i(257384);
    p.k(paramao, "commentData");
    if (((paramao instanceof com.tencent.mm.plugin.finder.live.model.q)) && (paramao.getType() == 20002))
    {
      paramao = ((com.tencent.mm.plugin.finder.live.model.q)paramao).yet.SJC;
      if (paramao != null)
      {
        paramao = paramao.contact;
        if (paramao != null)
        {
          paramao = paramao.nickname;
          AppMethodBeat.o(257384);
          return paramao;
        }
      }
      AppMethodBeat.o(257384);
      return null;
    }
    AppMethodBeat.o(257384);
    return "";
  }
  
  public static LinkedList<axc> b(List<byte[]> paramList, LinkedList<axc> paramLinkedList)
  {
    AppMethodBeat.i(257411);
    p.k(paramList, "list");
    if (paramLinkedList == null) {
      paramLinkedList = new LinkedList();
    }
    for (;;)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        axc localaxc = new axc();
        localaxc.parseFrom(arrayOfByte);
        paramLinkedList.add(localaxc);
      }
      paramLinkedList.clear();
    }
    AppMethodBeat.o(257411);
    return paramLinkedList;
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(257380);
    p.k(paramd, "plugin");
    paramd.ylc.post((Runnable)new a(paramd));
    AppMethodBeat.o(257380);
  }
  
  public static boolean b(com.tencent.mm.plugin.finder.live.view.a parama)
  {
    return ((parama instanceof com.tencent.mm.plugin.finder.live.view.b)) || ((parama instanceof com.tencent.mm.plugin.finder.live.view.c));
  }
  
  public static void bU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(257418);
    p.k(paramArrayOfByte, "info");
    Util.writeToFile(com.tencent.mm.loader.j.b.aSL() + "liveListTest", paramArrayOfByte);
    AppMethodBeat.o(257418);
  }
  
  public static boolean bvO()
  {
    AppMethodBeat.i(257396);
    com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.vtq;
    boolean bool = com.tencent.mm.plugin.expansions.d.awa("xlab");
    AppMethodBeat.o(257396);
    return bool;
  }
  
  public static void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(257415);
    p.k(paramImageView, "avatarIv");
    p.k(paramString, "avatarUrl");
    switch (paramInt)
    {
    default: 
      localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject = com.tencent.mm.plugin.finder.loader.t.dJi();
      paramString = new com.tencent.mm.plugin.finder.loader.e(paramString);
      localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ)).a((com.tencent.mm.loader.f.e)new k(paramImageView)).tA();
      AppMethodBeat.o(257415);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJi();
    paramString = new com.tencent.mm.plugin.finder.loader.e(paramString);
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
    AppMethodBeat.o(257415);
  }
  
  public static void checkInsertLiveNewReddot()
  {
    int i = 0;
    AppMethodBeat.i(257356);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.Vyk, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(257356);
      return;
    }
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (!com.tencent.c.a.a.a.a.a.imJ())
    {
      AppMethodBeat.o(257356);
      return;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager();
    bhw localbhw = new bhw();
    localbhw.SQm = String.valueOf(cm.bfE());
    localbhw.priority = 50000;
    localbhw.type = 1010;
    bkn localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "FinderEntrance";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "TLPersonalCenter";
    localbhw.MFx.add(localbkn);
    localbkn = new bkn();
    localbkn.CKC = 1;
    localbkn.SVs = 1;
    localbkn.path = "FinderSelfLiveEntrance";
    localbhw.MFx.add(localbkn);
    com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject, localbhw, "checkInsertLiveNewReddot", null, true, null, null, 52);
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyk, Integer.valueOf(1));
    AppMethodBeat.o(257356);
  }
  
  public static boolean d(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    return (paramh != null) && (paramh.zeG == 2);
  }
  
  public static boolean dEA()
  {
    AppMethodBeat.i(257394);
    b.b localb = com.tencent.mm.live.core.core.a.b.klq;
    boolean bool = b.b.aLi();
    AppMethodBeat.o(257394);
    return bool;
  }
  
  public static boolean dEB()
  {
    return yRh;
  }
  
  public static boolean dEC()
  {
    return yRi;
  }
  
  public static boolean dED()
  {
    return yRj;
  }
  
  public static boolean dEE()
  {
    AppMethodBeat.i(257370);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.eej();
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.img().aSr()).intValue();
    Log.i("FinderLiveUtil", "canShowVisitorRoleEntrance isTest:" + bool + ",configValue:" + i);
    switch (i)
    {
    default: 
      AppMethodBeat.o(257370);
      return false;
    case 0: 
      AppMethodBeat.o(257370);
      return true;
    }
    AppMethodBeat.o(257370);
    return bool;
  }
  
  public static boolean dEF()
  {
    AppMethodBeat.i(257371);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.eej();
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.imh().aSr()).intValue();
    Log.i("FinderLiveUtil", "canShowAnchorPrecheckEntrance isTest:" + bool + ",configValue:" + i);
    switch (i)
    {
    default: 
      AppMethodBeat.o(257371);
      return false;
    case 0: 
      AppMethodBeat.o(257371);
      return true;
    }
    AppMethodBeat.o(257371);
    return bool;
  }
  
  public static boolean dEG()
  {
    AppMethodBeat.i(257372);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int j = ((Number)com.tencent.c.a.a.a.a.a.ilp().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = d.a.aAK(z.bdh());
    if (localObject != null) {}
    for (int i = (int)((com.tencent.mm.plugin.finder.api.i)localObject).field_liveSwitchFlag;; i = 0)
    {
      boolean bool = com.tencent.mm.ae.d.dr(i, 16);
      Log.i("FinderLiveUtil", "enableAnchorMusic configValue:" + j + ", enableAnchorMusic:" + bool + ", switchFlag:" + i);
      if ((j != 0) || (!bool)) {
        break;
      }
      AppMethodBeat.o(257372);
      return true;
    }
    AppMethodBeat.o(257372);
    return false;
  }
  
  public static TXLivePlayConfig dEH()
  {
    AppMethodBeat.i(257389);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int i = com.tencent.c.a.a.a.a.a.imU();
    localObject = com.tencent.c.a.a.a.a.a.Zlt;
    int j = com.tencent.c.a.a.a.a.a.imV();
    localObject = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject).setConnectRetryCount(i);
    ((TXLivePlayConfig)localObject).setConnectRetryInterval(j);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool = com.tencent.c.a.a.a.a.a.imW();
    ((TXLivePlayConfig)localObject).setEnableMessage(bool);
    Log.i("FinderLiveUtil", "cdn config retry count:" + i + ",retry interval:" + j + ", sei:" + bool);
    AppMethodBeat.o(257389);
    return localObject;
  }
  
  public static boolean dEI()
  {
    AppMethodBeat.i(257401);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilv().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(257401);
      return true;
    }
    AppMethodBeat.o(257401);
    return false;
  }
  
  public static boolean dEJ()
  {
    return yRk;
  }
  
  public static bjp dEK()
  {
    AppMethodBeat.i(257419);
    byte[] arrayOfByte = Util.readFromFile(com.tencent.mm.loader.j.b.aSL() + "liveListTest");
    if (arrayOfByte != null)
    {
      bjp localbjp = new bjp();
      localbjp.parseFrom(arrayOfByte);
      AppMethodBeat.o(257419);
      return localbjp;
    }
    AppMethodBeat.o(257419);
    return null;
  }
  
  public static boolean dEL()
  {
    AppMethodBeat.i(257420);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eej())
    {
      localObject = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Boolean)com.tencent.c.a.a.a.a.a.inm().aSr()).booleanValue())
      {
        AppMethodBeat.o(257420);
        return true;
      }
    }
    AppMethodBeat.o(257420);
    return false;
  }
  
  public static boolean dEM()
  {
    AppMethodBeat.i(257430);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilx().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(257430);
      return true;
    }
    AppMethodBeat.o(257430);
    return false;
  }
  
  public static int dEN()
  {
    AppMethodBeat.i(257437);
    ar.hIH();
    int i = aw.fromDPToPix(MMApplicationContext.getContext(), 120);
    AppMethodBeat.o(257437);
    return i;
  }
  
  public static int dEO()
  {
    AppMethodBeat.i(257440);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eej())
    {
      localObject = com.tencent.c.a.a.a.a.a.Zlt;
      switch (((Number)com.tencent.c.a.a.a.a.a.imQ().aSr()).intValue())
      {
      default: 
        AppMethodBeat.o(257440);
        return 0;
      case 1: 
        AppMethodBeat.o(257440);
        return 1;
      }
      AppMethodBeat.o(257440);
      return 2;
    }
    AppMethodBeat.o(257440);
    return 0;
  }
  
  public static boolean dEP()
  {
    AppMethodBeat.i(257449);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.inp().aSr()).intValue() == 0)
    {
      AppMethodBeat.o(257449);
      return true;
    }
    AppMethodBeat.o(257449);
    return false;
  }
  
  public static boolean dEy()
  {
    AppMethodBeat.i(257393);
    Object localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (!b.b.aLi())
    {
      localObject = com.tencent.mm.live.core.core.b.a.knj;
      if (!com.tencent.mm.live.core.core.b.a.a.aLi()) {}
    }
    else
    {
      AppMethodBeat.o(257393);
      return true;
    }
    AppMethodBeat.o(257393);
    return false;
  }
  
  public static boolean e(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    return (paramh != null) && (paramh.zeG == 1);
  }
  
  public static void eA(View paramView)
  {
    AppMethodBeat.i(257388);
    p.k(paramView, "view");
    paramView.performHapticFeedback(1, 3);
    AppMethodBeat.o(257388);
  }
  
  public static boolean eC(View paramView)
  {
    AppMethodBeat.i(257444);
    p.k(paramView, "child");
    ViewParent localViewParent = paramView.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(paramView);
    }
    if (localObject != null)
    {
      AppMethodBeat.o(257444);
      return true;
    }
    AppMethodBeat.o(257444);
    return false;
  }
  
  public static LinkedList<String> eu(List<byte[]> paramList)
  {
    AppMethodBeat.i(257410);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      Log.i("FinderLiveUtil", "getFinderLiveAndienceFileIdList list is empty!");
      AppMethodBeat.o(257410);
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
        kotlin.a.j.iBO();
      }
      Object localObject2 = (byte[])localObject1;
      localObject1 = new ayj();
      ((ayj)localObject1).parseFrom((byte[])localObject2);
      localObject2 = ((ayj)localObject1).RRY;
      CharSequence localCharSequence = (CharSequence)localObject2;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label216;
        }
        localLinkedList.add(localObject2);
        p.j(localStringBuilder.append("[" + ((ayj)localObject1).title + ',' + ((ayj)localObject1).RRY + ']'), "printMsg.append(\"[${item.title},${item.file_id}]\")");
        i = j;
        break;
      }
      label216:
      Log.i("FinderLiveUtil", "getFinderLiveAndienceFileIdList index:" + i + " item:" + ((ayj)localObject1).title + " is empty!");
      i = j;
    }
    Log.i("FinderLiveUtil", "getFinderLiveAndienceFileIdList ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(257410);
    return localLinkedList;
  }
  
  public static void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(257360);
    p.k(paramImageView, "imageView");
    p.k(paramString, "url");
    Log.i("FinderLiveUtil", "setBlurBitmap imageView:" + paramImageView.getId() + ",url:" + paramString);
    Object localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJl();
    paramString = new k(paramString, u.Alz);
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
    AppMethodBeat.o(257360);
  }
  
  public static void ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257373);
    p.k(paramString1, "tag");
    p.k(paramString2, "msg");
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eej()) {
      Log.i(paramString1 + "(Debug)", paramString2);
    }
    AppMethodBeat.o(257373);
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(257369);
    p.k(paramString, "username");
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)locala).bbL().RG(paramString);
    p.j(paramString, "contact");
    boolean bool = paramString.axZ();
    AppMethodBeat.o(257369);
    return bool;
  }
  
  public static boolean k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(257375);
    p.k(parama, "liveData");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).yeE == 2)
    {
      AppMethodBeat.o(257375);
      return true;
    }
    AppMethodBeat.o(257375);
    return false;
  }
  
  public static boolean l(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(257377);
    p.k(parama, "liveData");
    if ((dEy()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy))
    {
      AppMethodBeat.o(257377);
      return true;
    }
    AppMethodBeat.o(257377);
    return false;
  }
  
  public static FinderContact m(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(257413);
    p.k(parama, "liveData");
    FinderContact localFinderContact = new FinderContact();
    parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS;
    switch (parama.SJy)
    {
    default: 
      localFinderContact.username = z.bcZ();
      localFinderContact.nickname = z.bdb();
      localFinderContact.headUrl = parama.ueX;
    }
    for (;;)
    {
      AppMethodBeat.o(257413);
      return localFinderContact;
      localFinderContact.username = z.bdi();
      localFinderContact.nickname = parama.nickname;
      localFinderContact.headUrl = parama.ueX;
      continue;
      localFinderContact.username = z.bdh();
      localFinderContact.nickname = parama.nickname;
      localFinderContact.headUrl = parama.ueX;
    }
  }
  
  public static void q(TextView paramTextView)
  {
    AppMethodBeat.i(257395);
    p.k(paramTextView, "tv");
    try
    {
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      paramTextView.setTypeface(Typeface.createFromAsset(localContext.getAssets(), "fonts/SF-Pro-Display-BoldItalic.otf"));
      AppMethodBeat.o(257395);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e("FinderLiveUtil", "setTypeface() Exception:" + paramTextView.getMessage());
      AppMethodBeat.o(257395);
    }
  }
  
  public static String s(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(257404);
    p.k(paramString, "msg");
    String str = com.tencent.mm.ui.tools.g.hV(paramString, paramInt);
    if ((paramBoolean) && (paramString.length() > str.length()))
    {
      paramString = str + "...";
      AppMethodBeat.o(257404);
      return paramString;
    }
    p.j(str, "subString");
    AppMethodBeat.o(257404);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.plugin.finder.live.plugin.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(288004);
      if ((this.yRn.ylc.getLayoutParams() != null) && ((this.yRn.ylc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (this.yRn.isLandscape()))
      {
        int i = this.yRn.getCurrentOrientation();
        Object localObject = a.yRm;
        localObject = this.yRn.ylc.getContext();
        p.j(localObject, "plugin.vg.context");
        a locala = a.yRm;
        if (!a.k(this.yRn.getBuContext()))
        {
          locala = a.yRm;
          if (!a.l(this.yRn.getBuContext())) {
            break label164;
          }
        }
        int j;
        label164:
        for (boolean bool = true;; bool = false)
        {
          j = a.E((Context)localObject, bool);
          if (!this.yRo) {
            break label178;
          }
          localObject = this.yRn.ylc.getLayoutParams();
          if (localObject != null) {
            break;
          }
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(288004);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
        label178:
        if (this.yRp)
        {
          localObject = this.yRn.ylc.getLayoutParams();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(288004);
            throw ((Throwable)localObject);
          }
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = j;
        }
        this.yRn.ylc.requestLayout();
        this.yRn.ylc.setTag(b.f.finder_live_plugin_orientation, Integer.valueOf(i));
      }
      AppMethodBeat.o(288004);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.plugin.finder.live.plugin.d paramd, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(272507);
      int i;
      Object localObject;
      int j;
      if ((this.yRn.ylc.getLayoutParams() != null) && ((this.yRn.ylc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (this.yRn.isLandscape()))
      {
        i = this.yRn.getCurrentOrientation();
        localObject = a.yRm;
        localObject = this.yRn.ylc.getContext();
        p.j(localObject, "plugin.vg.context");
        a locala = a.yRm;
        if (!a.k(this.yRn.getBuContext()))
        {
          locala = a.yRm;
          if (!a.l(this.yRn.getBuContext())) {
            break label164;
          }
        }
        label164:
        for (boolean bool = true;; bool = false)
        {
          j = a.E((Context)localObject, bool);
          if (!paramBoolean) {
            break label270;
          }
          localObject = this.yRn.ylc.getLayoutParams();
          if (localObject != null) {
            break;
          }
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(272507);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(j);
      }
      for (;;)
      {
        this.yRn.ylc.requestLayout();
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.eej()) {
          Log.i("FinderLiveUtil", "plugin:" + this.yRn.name() + ",Orientation:" + i + ",ifLeft:" + paramBoolean);
        }
        this.yRn.ylc.setTag(b.f.finder_live_plugin_orientation, Integer.valueOf(i));
        AppMethodBeat.o(272507);
        return;
        label270:
        localObject = this.yRn.ylc.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(272507);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(j);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements q.f
  {
    c(BaseFinderFeed paramBaseFinderFeed, Context paramContext, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final o paramo)
    {
      AppMethodBeat.i(285149);
      Object localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      Object localObject2 = ((Context)localObject1).getResources().getString(b.j.app_share_to_weixin);
      p.j(localObject2, "MMApplicationContext.get…ring.app_share_to_weixin)");
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_share_timeline);
      p.j(localObject1, "MMApplicationContext.get…ng.finder_share_timeline)");
      Object localObject3 = new StringBuilder("lxl object Status: ").append(this.xno.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(this.xno.feedObject.isOnlySelfSee()).append(" isSelf=");
      com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
      Log.i("FinderLiveUtil", com.tencent.mm.plugin.finder.utils.aj.j(this.xno) + " isNotShare=" + this.xno.feedObject.isNotShare());
      boolean bool2;
      boolean bool1;
      if (this.xno.feedObject.isOnlySelfSee())
      {
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.j(this.xno))
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.t.ADN;
          localObject1 = com.tencent.mm.plugin.finder.utils.t.a(paramContext, this.xno, 2, (kotlin.g.a.b)new a(this, paramo));
          localObject2 = (String)((kotlin.r)localObject1).Mx;
          localObject1 = (String)((kotlin.r)localObject1).My;
          bool2 = true;
          bool1 = true;
        }
      }
      for (;;)
      {
        localObject3 = az.xDj;
        int i = az.dmA();
        localObject2 = (CharSequence)localObject2;
        int j = b.i.finder_icons_filled_share;
        localObject3 = MMApplicationContext.getContext();
        p.j(localObject3, "MMApplicationContext.getContext()");
        paramo.a(i, (CharSequence)localObject2, j, ((Context)localObject3).getResources().getColor(b.c.Brand), bool1);
        localObject2 = az.xDj;
        paramo.a(az.dmB(), (CharSequence)localObject1, b.i.bottomsheet_icon_moment, 0, bool2);
        paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramo = aj.a.fZ(paramContext);
        if (paramo != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
          com.tencent.mm.plugin.finder.report.n.O(this.xno.mf(), paramo.xkX);
        }
        paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramo = aj.a.fZ(paramContext);
        if (paramo != null)
        {
          paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.b(paramo);
          if (paramo != null)
          {
            paramo.dpO().KL(this.xno.mf());
            AppMethodBeat.o(285149);
            return;
            if ((!this.xno.feedObject.isOnlySelfSee()) && (!this.xno.feedObject.isNotShare())) {
              break label480;
            }
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
            bool2 = true;
            bool1 = true;
            continue;
          }
        }
        AppMethodBeat.o(285149);
        return;
        label480:
        bool2 = false;
        bool1 = false;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, x>
    {
      a(a.c paramc, o paramo)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(BaseFinderFeed paramBaseFinderFeed, int paramInt, Context paramContext) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(287193);
      Object localObject = a.yRm;
      if (!a.p(this.xno))
      {
        if ((paramInt != 3) && (paramInt != 1))
        {
          localObject = az.xDj;
          paramo.b(az.dtF(), (CharSequence)paramContext.getString(b.j.more_menu_unlike), b.i.finder_feed_dislike);
        }
        localObject = az.xDj;
        paramo.b(az.dtH(), (CharSequence)paramContext.getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
      }
      AppMethodBeat.o(287193);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"parse", "", "tag", "Lcom/tencent/mm/json/JSONObject;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "invoke"})
  public static final class e
    extends kotlin.g.b.q
    implements m<com.tencent.mm.ad.i, bda, x>
  {
    public static final e yRr;
    
    static
    {
      AppMethodBeat.i(232987);
      yRr = new e();
      AppMethodBeat.o(232987);
    }
    
    e()
    {
      super();
    }
    
    public static void a(com.tencent.mm.ad.i parami, bda parambda)
    {
      AppMethodBeat.i(232985);
      p.k(parami, "tag");
      p.k(parambda, "tagInfo");
      int i = parami.optInt("tag_id");
      String str = parami.optString("tag_name");
      int j = parami.optInt("show_primary_tag");
      int k = parami.optInt("need_poi");
      parambda.SOi = i;
      parambda.ugl = str;
      parambda.SOl = j;
      parambda.SOm = k;
      AppMethodBeat.o(232985);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$prepareAnchorMusicInfo$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder_release"})
  public static final class f
    implements r.a
  {
    f(com.tencent.mm.plugin.finder.live.model.context.a parama, MMActivity paramMMActivity) {}
    
    public final void a(int paramInt1, int paramInt2, ayq paramayq)
    {
      AppMethodBeat.i(292268);
      p.k(paramayq, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yRs.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.a(paramayq);
      }
      AppMethodBeat.o(292268);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "round1Result", "Landroid/graphics/Bitmap;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Bitmap, x>
  {
    g(View paramView, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class h
    implements InputFilter
  {
    h(EditText paramEditText) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(269117);
      paramSpanned = this.yRv;
      if (paramSpanned != null) {
        paramSpanned.getText();
      }
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(269117);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(269117);
        return paramCharSequence;
      }
      AppMethodBeat.o(269117);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$setETInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.ui.tools.g
  {
    i(int paramInt1, int paramInt2, g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(292229);
      CharSequence localCharSequence;
      if (paramSpanned != null)
      {
        paramInt1 = paramSpanned.length();
        if (paramInt1 <= paramInt3) {
          break label159;
        }
        if (paramSpanned == null) {
          break label153;
        }
        localCharSequence = paramSpanned.subSequence(0, paramInt3);
        label41:
        paramInt1 = com.tencent.mm.ui.tools.g.a(String.valueOf(localCharSequence), g.a.XSu);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label174;
        }
      }
      label153:
      label159:
      label174:
      for (paramInt2 = com.tencent.mm.ui.tools.g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.XSu);; paramInt2 = 0)
      {
        paramInt3 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramCharSequence), g.a.XSu);
        paramInt1 = this.yRw - paramInt1 - paramInt2;
        if (paramInt3 <= paramInt1) {
          break label179;
        }
        paramSpanned = a.yRm;
        paramCharSequence = (CharSequence)a.s(String.valueOf(paramCharSequence), paramInt1, false);
        AppMethodBeat.o(292229);
        return paramCharSequence;
        paramInt1 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt1 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramSpanned), g.a.XSu);
        break label53;
      }
      label179:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(292229);
        return paramCharSequence;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$setETInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class j
    implements TextWatcher
  {
    j(TextView paramTextView, int paramInt, kotlin.g.a.a parama) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(277760);
      int i = com.tencent.mm.ui.tools.g.bAB(String.valueOf(paramEditable)) / 2;
      TextView localTextView = this.yRx;
      if (localTextView != null) {
        if (i < 0) {
          break label85;
        }
      }
      label85:
      for (paramEditable = (CharSequence)(i + '/' + paramInt2);; paramEditable = (CharSequence)("0/" + paramInt2))
      {
        localTextView.setText(paramEditable);
        paramEditable = parama;
        if (paramEditable == null) {
          break;
        }
        paramEditable.invoke();
        AppMethodBeat.o(277760);
        return;
      }
      AppMethodBeat.o(277760);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class k<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.w, Bitmap>
  {
    k(ImageView paramImageView) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class l
    implements View.OnTouchListener
  {
    l(SeekBar paramSeekBar, int paramInt) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(224355);
      paramView = new Rect();
      this.yRB.getHitRect(paramView);
      p.j(paramMotionEvent, "event");
      if ((paramMotionEvent.getY() >= paramView.top - this.yRC) && (paramMotionEvent.getY() <= paramView.bottom + this.yRC) && (paramMotionEvent.getX() >= paramView.left) && (paramMotionEvent.getX() <= paramView.right))
      {
        long l1 = paramMotionEvent.getDownTime();
        long l2 = paramMotionEvent.getEventTime();
        int i = paramMotionEvent.getAction();
        float f1 = paramMotionEvent.getX();
        float f2 = paramView.left;
        float f3 = paramView.top;
        paramView = MotionEvent.obtain(l1, l2, i, f1 - f2, paramView.height() / 2.0F + f3, paramMotionEvent.getMetaState());
        p.j(paramView, "MotionEvent.obtain(event…         event.metaState)");
        boolean bool = this.yRB.onTouchEvent(paramView);
        AppMethodBeat.o(224355);
        return bool;
      }
      AppMethodBeat.o(224355);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(View paramView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(225284);
      Object localObject = new Rect();
      this.kqJ.getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-this.yRD, -this.yRE);
      ViewParent localViewParent = this.kqJ.getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(225284);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, this.kqJ));
      AppMethodBeat.o(225284);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    n(Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    o(boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    p(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.a
 * JD-Core Version:    0.7.0.1
 */