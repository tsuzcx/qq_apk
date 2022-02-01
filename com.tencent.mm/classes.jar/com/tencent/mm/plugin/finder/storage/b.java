package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.o;
import d.v;
import java.io.File;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AVATAR_COMPRESS_QUALITY", "", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "Comment_Max_Length", "getComment_Max_Length", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "()Ljava/lang/String;", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "setFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "", "getFOLDER_SIZE_LEVEL", "()F", "FRIEND_RECOMMEND_PLAN", "getFRIEND_RECOMMEND_PLAN", "setFRIEND_RECOMMEND_PLAN", "GRID_LAYOUT", "getGRID_LAYOUT", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "setMMFINDER_MORE_LOG", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_POST_ENTRANCE", "getTIMELINE_POST_ENTRANCE", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "checkPreloadStreamRefreshTime", "getCheckPreloadStreamRefreshTime", "debugAtMaxCount", "getDebugAtMaxCount", "setDebugAtMaxCount", "debugCommentExpand", "getDebugCommentExpand", "setDebugCommentExpand", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "(J)V", "debugLbsCgiStream", "getDebugLbsCgiStream", "setDebugLbsCgiStream", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugSwitchScene", "getDebugSwitchScene", "setDebugSwitchScene", "debugSwitchSceneTip", "getDebugSwitchSceneTip", "setDebugSwitchSceneTip", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "debugTopicMaxCount", "getDebugTopicMaxCount", "setDebugTopicMaxCount", "debugTopicMaxLength", "getDebugTopicMaxLength", "setDebugTopicMaxLength", "debugTopicSuggestSwitch", "getDebugTopicSuggestSwitch", "setDebugTopicSuggestSwitch", "fakeWaitForRefresh", "getFakeWaitForRefresh", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnableHomeViewPagerScroll", "isEnablePreloadStreamRefresh", "isEnablePreloadVideoForPreloadStream", "isEnableShowNew", "isEnableStoreLastTabType", "isGetGps", "isMoreTabEnable", "value", "isNeverEnterMultiTab", "setNeverEnterMultiTab", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "lastCommentFullScreen", "getLastCommentFullScreen", "setLastCommentFullScreen", "localEnableShowNew", "getLocalEnableShowNew", "setLocalEnableShowNew", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "realNameDebugCache", "getRealNameDebugCache", "setRealNameDebugCache", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoRecordPara", "getVideoRecordPara", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "Lkotlin/Pair;", "plugin-finder_release"})
public final class b
{
  private static final String bIO;
  private static final int rBK = 1024;
  private static final int rBL = 1048576;
  private static final int rBM = 10485760;
  private static final int rBN = 1048576;
  private static int rBO = 0;
  private static int rBP = 0;
  private static final int rBQ = 300;
  private static int rBR = 0;
  private static int rBS = 0;
  private static int rBT = 0;
  private static final int rBU = 143360;
  private static int rBV = 0;
  private static int rBW = 0;
  private static int rBX = 0;
  private static int rBY = 0;
  private static int rBZ = 0;
  private static boolean rCA = false;
  private static int rCB = 0;
  private static boolean rCC = false;
  private static int rCD = 0;
  private static int rCE = 0;
  private static int rCF = 0;
  private static final boolean rCG = false;
  private static int rCH = 0;
  private static final long rCI = 2000L;
  private static int rCJ = 0;
  private static boolean rCK = false;
  private static final boolean rCL = false;
  private static final int rCM = 300000;
  private static final int rCN = 5000;
  private static int rCO = 0;
  private static boolean rCP = false;
  private static int rCQ = 0;
  private static final int rCR;
  private static int rCS = 0;
  private static boolean rCT = false;
  public static final b rCU;
  private static int rCa = 0;
  private static int rCb = 0;
  private static final int rCc = 3;
  private static final int rCd = 800;
  private static int rCe = 0;
  private static final int rCf = 45;
  private static final int rCg = 45;
  private static final int rCh = 10;
  private static boolean rCi;
  private static boolean rCj;
  private static boolean rCk;
  private static long rCl;
  private static final long rCm;
  private static int rCn;
  private static final f rCo;
  private static final f rCp;
  private static final f rCq;
  private static int rCr;
  private static int rCs;
  private static int rCt;
  private static int rCu;
  private static int rCv;
  private static boolean rCw;
  private static int rCx;
  private static boolean rCy;
  private static boolean rCz;
  
  static
  {
    AppMethodBeat.i(166903);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "isEnableGesturePreviewImage", "isEnableGesturePreviewImage()Z")), (d.l.k)w.a(new u(w.bn(b.class), "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo()Z")), (d.l.k)w.a(new u(w.bn(b.class), "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION()I")) };
    rCU = new b();
    rBK = 1024;
    rBL = 1048576;
    rBM = rBL * 10;
    rBN = rBL * 1;
    rBO = rBL * 28;
    rBP = rBL * 28;
    rBQ = 300;
    rBR = 1280;
    rBS = 1080;
    rBT = 90;
    rBU = rBK * 140;
    rBV = 1080;
    rBW = 1080;
    rBX = 70;
    rBY = 1080;
    rBZ = 1080;
    rCa = 70;
    rCb = 50;
    rCc = 3;
    rCd = 800;
    rCe = 300000;
    rCf = 45;
    rCg = 45;
    rCh = 10;
    rCl = -1L;
    rCm = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    bIO = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + cyS() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + cyO() + " 后台处理\n    3、可配置（接x）：timeline顶部相机入口是否展示（默认展示）" + cyP() + "\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + cyQ() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + com.tencent.mm.plugin.expt.a.b.a.pVd + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    rCo = d.g.K((d.g.a.a)b.b.rCW);
    rCp = d.g.K((d.g.a.a)b.c.rCX);
    rCq = d.g.K((d.g.a.a)b.a.rCV);
    rCr = 1;
    rCs = 15;
    rCt = 1;
    rCv = 1;
    rCx = 5;
    com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.cDh()) {}
    for (int i = 1;; i = 2)
    {
      rCB = i;
      rCC = true;
      rCE = -1;
      rCF = -1;
      rCI = 2000L;
      rCJ = 2;
      rCK = true;
      rCM = 300000;
      rCN = 5000;
      rCO = 20;
      rCQ = -1;
      rCR = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaM, 0);
      rCT = true;
      AppMethodBeat.o(166903);
      return;
    }
  }
  
  public static void DZ(int paramInt)
  {
    rCe = paramInt;
  }
  
  public static void Ea(int paramInt)
  {
    rCu = paramInt;
  }
  
  public static void Eb(int paramInt)
  {
    rCE = paramInt;
  }
  
  public static void Ec(int paramInt)
  {
    rCH = paramInt;
  }
  
  public static void Ed(int paramInt)
  {
    rCJ = paramInt;
  }
  
  public static void Ee(int paramInt)
  {
    rCO = paramInt;
  }
  
  public static void Ef(int paramInt)
  {
    rCQ = paramInt;
  }
  
  public static String aX(int paramInt, String paramString)
  {
    AppMethodBeat.i(202925);
    d.g.b.k.h(paramString, "defaultStr");
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(202925);
      return "";
    case 1: 
      locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      paramString = locale.agA().get(ah.a.GUD, paramString);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(202925);
        throw paramString;
      }
      paramString = (String)paramString;
      AppMethodBeat.o(202925);
      return paramString;
    case 3: 
      locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      paramString = locale.agA().get(ah.a.GUF, paramString);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(202925);
        throw paramString;
      }
      paramString = (String)paramString;
      AppMethodBeat.o(202925);
      return paramString;
    }
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramString = locale.agA().get(ah.a.GUE, paramString);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202925);
      throw paramString;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(202925);
    return paramString;
  }
  
  public static int cAa()
  {
    return rCM;
  }
  
  public static int cAb()
  {
    return rCN;
  }
  
  public static int cAc()
  {
    return rCO;
  }
  
  public static int cAd()
  {
    AppMethodBeat.i(202920);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderFakeLoadingPageCount", 5);
    AppMethodBeat.o(202920);
    return i;
  }
  
  public static long cAe()
  {
    AppMethodBeat.i(202921);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getInt("FinderFakeLoadingDurationMS", 300);
    localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GUy, i);
    if (j == 0) {}
    for (;;)
    {
      ac.i("FinderConfig", "[TIMELINE_LOADING_EXPIRED_TIME] duration=".concat(String.valueOf(i)));
      long l = i;
      AppMethodBeat.o(202921);
      return l;
      i = j;
    }
  }
  
  public static boolean cAf()
  {
    AppMethodBeat.i(202922);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service(IConfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderFakeLoadingPageCount", 5) > 0)
    {
      AppMethodBeat.o(202922);
      return true;
    }
    AppMethodBeat.o(202922);
    return false;
  }
  
  public static boolean cAg()
  {
    return rCP;
  }
  
  public static void cAh()
  {
    rCP = true;
  }
  
  public static int cAi()
  {
    int i = 0;
    AppMethodBeat.i(202923);
    if (rCQ == -1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      if (locale.agA().getBoolean(ah.a.GVX, false)) {
        i = 1;
      }
      rCQ = i;
    }
    i = rCQ;
    AppMethodBeat.o(202923);
    return i;
  }
  
  public static boolean cAj()
  {
    AppMethodBeat.i(202924);
    if (h.IS_FLAVOR_PURPLE)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      if (locale.agA().getBoolean(ah.a.GUC, false)) {}
    }
    else
    {
      AppMethodBeat.o(202924);
      return false;
    }
    AppMethodBeat.o(202924);
    return true;
  }
  
  public static boolean cAk()
  {
    AppMethodBeat.i(202926);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVq, 1) == 1)
    {
      AppMethodBeat.o(202926);
      return true;
    }
    AppMethodBeat.o(202926);
    return false;
  }
  
  public static int cAl()
  {
    return rCR;
  }
  
  public static boolean cAm()
  {
    AppMethodBeat.i(202927);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOH, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(bool)));
      AppMethodBeat.o(202927);
      return bool;
    }
  }
  
  public static void cAn()
  {
    rCS = 1;
  }
  
  public static void cAo()
  {
    AppMethodBeat.i(202928);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GUI, Integer.valueOf(1));
    rCT = false;
    AppMethodBeat.o(202928);
  }
  
  public static boolean cAp()
  {
    AppMethodBeat.i(202929);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOI, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(bool)));
      AppMethodBeat.o(202929);
      return bool;
    }
  }
  
  public static boolean cAq()
  {
    AppMethodBeat.i(202930);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOJ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(bool)));
      AppMethodBeat.o(202930);
      return bool;
    }
  }
  
  public static long cAr()
  {
    AppMethodBeat.i(202931);
    long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOK, 1200000L);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    long l3 = locale.agA().getInt(ah.a.GUB, 0);
    long l1 = l3;
    if (l3 == 0L) {
      l1 = l2;
    }
    ac.i("FinderConfig", "[get] checkPreloadStreamRefreshTime=" + l1 + "ms, server=" + l2 + "ms");
    AppMethodBeat.o(202931);
    return l1;
  }
  
  public static long cAs()
  {
    AppMethodBeat.i(202932);
    long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOL, 500L);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    long l3 = locale.agA().getInt(ah.a.GUz, 0);
    long l1 = l3;
    if (l3 == 0L) {
      l1 = l2;
    }
    ac.i("FinderConfig", "[get] fakeWaitForRefresh=" + l1 + "ms, server=" + l2 + "ms");
    AppMethodBeat.o(202932);
    return l1;
  }
  
  public static VideoTransPara cxY()
  {
    AppMethodBeat.i(166904);
    Object localObject = d.aDL();
    d.g.b.k.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((d)localObject).aDQ();
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara cxZ()
  {
    AppMethodBeat.i(166905);
    Object localObject = d.aDL();
    d.g.b.k.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((d)localObject).aDR();
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static void cyA()
  {
    rCl = 60000L;
  }
  
  private static float cyB()
  {
    AppMethodBeat.i(166918);
    ac.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + rCm);
    if (rCm < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (rCm < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long cyC()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVs, 1024L) * rBL) * cyB());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long cyD()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVt, 100L) * rBL) * cyB());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static long cyE()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVu, 500L) * rBL) * cyB());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static long cyF()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVv, 1024L) * rBL) * cyB());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long cyG()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVw, 500L) * rBL) * cyB());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long cyH()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVx, 500L) * rBL) * cyB());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long cyI()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVy, 500L) * rBL) * cyB());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static int cyJ()
  {
    AppMethodBeat.i(166926);
    if ((rCn > 0) && (ac.getLogLevel() <= 1))
    {
      i = rCn;
      AppMethodBeat.o(166926);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderCommentTextLimit", 800);
    AppMethodBeat.o(166926);
    return i;
  }
  
  public static int cyK()
  {
    AppMethodBeat.i(166927);
    if ((rCn > 0) && (ac.getLogLevel() <= 1))
    {
      i = rCn;
      AppMethodBeat.o(166927);
      return i + 5;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderMediaPublishTextLimit", 1000);
    AppMethodBeat.o(166927);
    return i;
  }
  
  public static int cyL()
  {
    AppMethodBeat.i(166928);
    if ((rCn > 0) && (ac.getLogLevel() <= 1))
    {
      i = rCn;
      AppMethodBeat.o(166928);
      return i + 10;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderPureTextPublishTextLimit", 800);
    AppMethodBeat.o(166928);
    return i;
  }
  
  public static void cyM()
  {
    rCn = 10;
  }
  
  public static int cyN()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean cyO()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVb, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean cyP()
  {
    AppMethodBeat.i(166931);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVa, 1) == 1)
    {
      AppMethodBeat.o(166931);
      return true;
    }
    AppMethodBeat.o(166931);
    return false;
  }
  
  public static boolean cyQ()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVc, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean cyR()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVi, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean cyS()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVj, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean cyT()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean cyU()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean cyV()
  {
    AppMethodBeat.i(202901);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(202901);
      return true;
    }
    AppMethodBeat.o(202901);
    return false;
  }
  
  public static String cyW()
  {
    AppMethodBeat.i(202902);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GUg, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202902);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = ai.getContext().getString(2131759289);
      d.g.b.k.g(localObject, "MMApplicationContext.get…finder_no_post_edu_title)");
      AppMethodBeat.o(202902);
      return localObject;
    }
    AppMethodBeat.o(202902);
    return localObject;
  }
  
  public static String cyX()
  {
    AppMethodBeat.i(202903);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GUh, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(202903);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = ai.getContext().getString(2131759288);
      d.g.b.k.g(localObject, "MMApplicationContext.get….finder_no_post_edu_desc)");
      AppMethodBeat.o(202903);
      return localObject;
    }
    AppMethodBeat.o(202903);
    return localObject;
  }
  
  public static boolean cyY()
  {
    AppMethodBeat.i(166937);
    boolean bool = ((Boolean)rCo.getValue()).booleanValue();
    AppMethodBeat.o(166937);
    return bool;
  }
  
  public static boolean cyZ()
  {
    AppMethodBeat.i(166938);
    boolean bool = ((Boolean)rCp.getValue()).booleanValue();
    AppMethodBeat.o(166938);
    return bool;
  }
  
  public static int cya()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVh, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  public static boolean cyb()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVN, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int cyc()
  {
    AppMethodBeat.i(202898);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWc, rBL * 28);
    AppMethodBeat.o(202898);
    return i;
  }
  
  public static int cyd()
  {
    AppMethodBeat.i(202899);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWd, rBL * 28);
    AppMethodBeat.o(202899);
    return i;
  }
  
  public static int cye()
  {
    return rBQ;
  }
  
  public static int cyf()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166908);
      return 1280;
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166908);
      throw ((Throwable)localObject);
    }
    i = bs.aLy((String)d.n.n.a((CharSequence)d.n.n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int cyg()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166909);
      return 1080;
    }
    ac.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166909);
      throw ((Throwable)localObject);
    }
    i = bs.aLy((String)d.n.n.a((CharSequence)d.n.n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int cyh()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166910);
      return 90;
    }
    ac.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166910);
      throw ((Throwable)localObject);
    }
    i = bs.aLy(d.n.n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static int cyi()
  {
    return rBU;
  }
  
  public static int cyj()
  {
    AppMethodBeat.i(166911);
    int i = rBV;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int cyk()
  {
    AppMethodBeat.i(166912);
    int i = rBW;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int cyl()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderHeadCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166913);
      return 90;
    }
    ac.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166913);
      throw ((Throwable)localObject);
    }
    i = bs.aLy(d.n.n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int cym()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166914);
      return 1080;
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166914);
      throw ((Throwable)localObject);
    }
    i = bs.aLy((String)d.n.n.a((CharSequence)d.n.n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int cyn()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166915);
      return 1080;
    }
    ac.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166915);
      throw ((Throwable)localObject);
    }
    i = bs.aLy((String)d.n.n.a((CharSequence)d.n.n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int cyo()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).ZY().getValue("FinderProfileBgImgCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166916);
      return 70;
    }
    ac.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166916);
      throw ((Throwable)localObject);
    }
    i = bs.aLy(d.n.n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int cyp()
  {
    AppMethodBeat.i(202900);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(202900);
    return i;
  }
  
  public static int cyq()
  {
    return rCc;
  }
  
  public static int cyr()
  {
    return rCe;
  }
  
  public static int cys()
  {
    return rCf;
  }
  
  public static int cyt()
  {
    return rCg;
  }
  
  public static boolean cyu()
  {
    return rCi;
  }
  
  public static boolean cyv()
  {
    return rCj;
  }
  
  public static void cyw()
  {
    rCj = true;
  }
  
  public static boolean cyx()
  {
    return rCk;
  }
  
  public static void cyy()
  {
    rCk = true;
  }
  
  public static long cyz()
  {
    AppMethodBeat.i(166917);
    if ((rCl > 0L) && (ac.getLogLevel() <= 1))
    {
      l = rCl;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVr, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  public static boolean czA()
  {
    return rCA;
  }
  
  public static boolean czB()
  {
    AppMethodBeat.i(178411);
    com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.cDh())
    {
      if (rCA)
      {
        AppMethodBeat.o(178411);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVT, 0) == 1)
      {
        AppMethodBeat.o(178411);
        return true;
      }
      AppMethodBeat.o(178411);
      return false;
    }
    AppMethodBeat.o(178411);
    return false;
  }
  
  public static int czC()
  {
    AppMethodBeat.i(202911);
    Object localObject = new StringBuilder("DEFAULT_REPLY_SCENE hasFinderAccount:");
    com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    ac.i("FinderConfig", com.tencent.mm.plugin.finder.utils.n.cDh());
    localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.cDh())
    {
      AppMethodBeat.o(202911);
      return 1;
    }
    AppMethodBeat.o(202911);
    return 2;
  }
  
  public static boolean czD()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static int czE()
  {
    AppMethodBeat.i(178414);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWg, 0);
    AppMethodBeat.o(178414);
    return i;
  }
  
  public static boolean czF()
  {
    AppMethodBeat.i(178415);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.agA().a(ah.a.GVC, 0L) == 0L)
    {
      AppMethodBeat.o(178415);
      return true;
    }
    AppMethodBeat.o(178415);
    return false;
  }
  
  public static void czG()
  {
    rCD = 1;
  }
  
  public static boolean czH()
  {
    AppMethodBeat.i(178416);
    if ((rCD == 1) && (ac.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWe, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int czI()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWf, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int czJ()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static long czK()
  {
    AppMethodBeat.i(202912);
    long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVk, 300000L);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    long l3 = locale.agA().getInt(ah.a.GUA, 0);
    long l1 = l3;
    if (l3 == 0L) {
      l1 = l2;
    }
    ac.i("FinderConfig", "[get] FINDER_TIMELINE_REFRESH_EXPIRED=" + l1 + "ms, server=" + l2 + "ms");
    AppMethodBeat.o(202912);
    return l1;
  }
  
  public static int czL()
  {
    return rCE;
  }
  
  public static boolean czM()
  {
    AppMethodBeat.i(202913);
    if (rCE < 0) {
      rCE = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVo, 0);
    }
    if (rCE == 1)
    {
      AppMethodBeat.o(202913);
      return true;
    }
    AppMethodBeat.o(202913);
    return false;
  }
  
  public static void czN()
  {
    rCF = -1;
  }
  
  public static boolean czO()
  {
    AppMethodBeat.i(202914);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVp, 1);
    if (rCF == -1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(locale, "MMKernel.storage()");
      rCF = locale.agA().getInt(ah.a.GVe, 0);
      ac.i("FinderConfig", "real name like config serverConfig:" + i + " realNameDebugCache:" + rCF);
    }
    if (rCF == 1)
    {
      AppMethodBeat.o(202914);
      return true;
    }
    if (rCF == 2)
    {
      AppMethodBeat.o(202914);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(202914);
      return true;
    }
    AppMethodBeat.o(202914);
    return false;
  }
  
  public static boolean czP()
  {
    return rCG;
  }
  
  public static int czQ()
  {
    return rCH;
  }
  
  public static boolean czR()
  {
    AppMethodBeat.i(202915);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.agA().getInt(ah.a.GVc, 0) == 1)
    {
      AppMethodBeat.o(202915);
      return true;
    }
    AppMethodBeat.o(202915);
    return false;
  }
  
  public static long czS()
  {
    return rCI;
  }
  
  public static boolean czT()
  {
    AppMethodBeat.i(202916);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    int j = locale.agA().getInt(ah.a.GVd, 0);
    int i = j;
    if (j == 0) {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVm, 1);
    }
    if (i == 1)
    {
      AppMethodBeat.o(202916);
      return true;
    }
    AppMethodBeat.o(202916);
    return false;
  }
  
  public static boolean czU()
  {
    AppMethodBeat.i(202917);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVl, 1) == 1)
    {
      AppMethodBeat.o(202917);
      return true;
    }
    AppMethodBeat.o(202917);
    return false;
  }
  
  public static int czV()
  {
    return rCJ;
  }
  
  public static boolean czW()
  {
    AppMethodBeat.i(202918);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GVW, -1);
    if (i == 1)
    {
      AppMethodBeat.o(202918);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(202918);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVn, 1) == 1)
    {
      AppMethodBeat.o(202918);
      return true;
    }
    AppMethodBeat.o(202918);
    return false;
  }
  
  public static boolean czX()
  {
    return rCK;
  }
  
  public static boolean czY()
  {
    AppMethodBeat.i(202919);
    if ((!rCK) && (ac.getLogLevel() <= 1))
    {
      AppMethodBeat.o(202919);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderCommentAutoExpandSubcommentList", 1) == 1)
    {
      AppMethodBeat.o(202919);
      return true;
    }
    AppMethodBeat.o(202919);
    return false;
  }
  
  public static boolean czZ()
  {
    return rCL;
  }
  
  private static boolean[] cza()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVJ, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        ac.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(localObject1)));
        localObject1 = new JSONObject((String)localObject1);
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("hard-close");
        int j = localJSONArray.length();
        i = 0;
        if (i < j)
        {
          Object localObject3 = localJSONArray.getJSONObject(i);
          Object localObject2 = ((JSONObject)localObject3).getString("device-brand");
          String str = ((JSONObject)localObject3).getString("device-model");
          int k = ((JSONObject)localObject3).getInt("below-sdk-version");
          bool1 = ((JSONObject)localObject3).getBoolean("isEnableImage");
          bool2 = ((JSONObject)localObject3).getBoolean("isEnableVideo");
          localObject3 = Build.BRAND + " " + Build.MODEL;
          ac.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + (String)localObject2 + " model=" + str + " version=" + k + " isEnableImage=" + bool1 + " isEnableVideo=" + bool2 + " | this device=" + (String)localObject3 + " version=" + Build.VERSION.SDK_INT);
          if (k < Build.VERSION.SDK_INT) {
            break label471;
          }
          CharSequence localCharSequence = (CharSequence)localObject3;
          d.g.b.k.g(localObject2, "name");
          if (!d.n.n.a(localCharSequence, (CharSequence)localObject2, true)) {
            break label471;
          }
          localObject2 = (CharSequence)localObject3;
          d.g.b.k.g(str, "model");
          if (!d.n.n.a((CharSequence)localObject2, (CharSequence)str, true)) {
            break label471;
          }
          AppMethodBeat.o(166939);
          return new boolean[] { bool1, bool2 };
        }
        boolean bool1 = ((JSONObject)localObject1).getBoolean("isEnableImage");
        boolean bool2 = ((JSONObject)localObject1).getBoolean("isEnableVideo");
        ac.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + bool1 + " isEnableVideo=" + bool2);
        AppMethodBeat.o(166939);
        return new boolean[] { bool1, bool2 };
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("FinderConfig", (Throwable)localException, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(166939);
        return new boolean[] { true, true };
        ac.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
      }
      label471:
      i += 1;
    }
  }
  
  public static boolean czb()
  {
    AppMethodBeat.i(202904);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVF, 1) == 1)
    {
      AppMethodBeat.o(202904);
      return true;
    }
    AppMethodBeat.o(202904);
    return false;
  }
  
  public static boolean czc()
  {
    AppMethodBeat.i(202905);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVG, 1) == 1)
    {
      AppMethodBeat.o(202905);
      return true;
    }
    AppMethodBeat.o(202905);
    return false;
  }
  
  public static o<Integer, Boolean> czd()
  {
    AppMethodBeat.i(202906);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVA, 3);
    try
    {
      Object localObject1 = Build.MODEL;
      d.g.b.k.g(localObject1, "Build.MODEL");
      localObject3 = Locale.getDefault();
      d.g.b.k.g(localObject3, "Locale.getDefault()");
      if (localObject1 != null) {
        break label111;
      }
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(202906);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    ac.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(202906);
    return localObject2;
    label111:
    localObject2 = ((String)localObject2).toLowerCase((Locale)localObject3);
    d.g.b.k.g(localObject2, "(this as java.lang.String).toLowerCase(locale)");
    Object localObject3 = Build.BRAND;
    d.g.b.k.g(localObject3, "Build.BRAND");
    Object localObject4 = Locale.getDefault();
    d.g.b.k.g(localObject4, "Locale.getDefault()");
    if (localObject3 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(202906);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    d.g.b.k.g(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVC, "");
    if (!bs.isNullOrNil(str))
    {
      d.g.b.k.g(str, "waitForRelease");
      if ((d.n.n.e((CharSequence)str, (CharSequence)localObject2)) || (d.n.n.e((CharSequence)str, (CharSequence)localObject3)) || (d.n.n.e((CharSequence)str, (CharSequence)localObject4))) {
        ac.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVB, "");
          if (bs.isNullOrNil(str)) {
            break label520;
          }
          d.g.b.k.g(str, "videoSingleCount");
          if ((!d.n.n.e((CharSequence)str, (CharSequence)localObject2)) && (!d.n.n.e((CharSequence)str, (CharSequence)localObject3)) && (!d.n.n.e((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          ac.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(202906);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static int cze()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)rCq.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static boolean czf()
  {
    AppMethodBeat.i(202907);
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbu, 1) == 1) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
    {
      AppMethodBeat.o(202907);
      return true;
    }
    AppMethodBeat.o(202907);
    return false;
  }
  
  public static boolean czg()
  {
    AppMethodBeat.i(202908);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbv, 1) == 1)
    {
      AppMethodBeat.o(202908);
      return true;
    }
    AppMethodBeat.o(202908);
    return false;
  }
  
  public static String czh()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVL, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean czi()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean czj()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVM, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static void czk()
  {
    rCr = 3;
  }
  
  public static int czl()
  {
    AppMethodBeat.i(166946);
    if ((rCr > 1) && (ac.getLogLevel() <= 1))
    {
      i = rCr;
      AppMethodBeat.o(166946);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderMaxTopicCount", rCr);
    AppMethodBeat.o(166946);
    return i;
  }
  
  public static void czm()
  {
    rCs = 10;
  }
  
  public static int czn()
  {
    AppMethodBeat.i(166947);
    if ((rCs != 15) && (ac.getLogLevel() <= 1))
    {
      i = rCs;
      AppMethodBeat.o(166947);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderTopicTextLimit", rCs);
    AppMethodBeat.o(166947);
    return i;
  }
  
  public static boolean czo()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVO, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean czp()
  {
    AppMethodBeat.i(202909);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(202909);
      return true;
    }
    AppMethodBeat.o(202909);
    return false;
  }
  
  public static void czq()
  {
    rCt = 3;
  }
  
  public static int czr()
  {
    AppMethodBeat.i(202910);
    if ((rCt > 1) && (ac.getLogLevel() <= 1))
    {
      i = rCt;
      AppMethodBeat.o(202910);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderMaxMentionSbCount", 1000);
    AppMethodBeat.o(202910);
    return i;
  }
  
  public static int czs()
  {
    return rCu;
  }
  
  public static boolean czt()
  {
    AppMethodBeat.i(166949);
    if ((rCu > 0) && (ac.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166949);
      return true;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderSuggestTagViewShow", 0) == 1)
    {
      AppMethodBeat.o(166949);
      return true;
    }
    AppMethodBeat.o(166949);
    return false;
  }
  
  public static boolean czu()
  {
    AppMethodBeat.i(166950);
    if ((rCv == 0) && (ac.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean czv()
  {
    AppMethodBeat.i(166952);
    if ((rCw) && (ac.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVQ, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int czw()
  {
    AppMethodBeat.i(178407);
    if ((rCx != 5) && (ac.getLogLevel() <= 1))
    {
      i = rCx;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pVS, rCx);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static boolean czx()
  {
    AppMethodBeat.i(178408);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    boolean bool = locale.agA().getBoolean(ah.a.GVg, false);
    ac.i("FinderConfig", "[GET] ENABLE_SHOW_OTHER_PROFILE_FANS = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(178408);
    return bool;
  }
  
  public static boolean czy()
  {
    return rCy;
  }
  
  public static boolean czz()
  {
    AppMethodBeat.i(178409);
    boolean bool = rCz;
    AppMethodBeat.o(178409);
    return bool;
  }
  
  public static void lH(boolean paramBoolean)
  {
    rCi = paramBoolean;
  }
  
  public static void lI(boolean paramBoolean)
  {
    rCy = paramBoolean;
  }
  
  public static void lJ(boolean paramBoolean)
  {
    AppMethodBeat.i(178410);
    rCz = paramBoolean;
    AppMethodBeat.o(178410);
  }
  
  public static void lK(boolean paramBoolean)
  {
    rCA = paramBoolean;
  }
  
  public static void lL(boolean paramBoolean)
  {
    rCK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */