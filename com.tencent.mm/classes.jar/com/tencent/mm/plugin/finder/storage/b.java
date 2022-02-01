package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import d.o;
import d.v;
import java.io.File;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AVATAR_COMPRESS_QUALITY", "", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "Comment_Max_Length", "getComment_Max_Length", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "()Ljava/lang/String;", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "setFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "", "getFOLDER_SIZE_LEVEL", "()F", "FRIEND_RECOMMEND_PLAN", "getFRIEND_RECOMMEND_PLAN", "setFRIEND_RECOMMEND_PLAN", "GRID_LAYOUT", "getGRID_LAYOUT", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "setMMFINDER_MORE_LOG", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_POST_ENTRANCE", "getTIMELINE_POST_ENTRANCE", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "debugAtMaxCount", "getDebugAtMaxCount", "setDebugAtMaxCount", "debugCommentExpand", "getDebugCommentExpand", "setDebugCommentExpand", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "(J)V", "debugLbsCgiStream", "getDebugLbsCgiStream", "setDebugLbsCgiStream", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugSwitchScene", "getDebugSwitchScene", "setDebugSwitchScene", "debugSwitchSceneTip", "getDebugSwitchSceneTip", "setDebugSwitchSceneTip", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "debugTopicMaxCount", "getDebugTopicMaxCount", "setDebugTopicMaxCount", "debugTopicMaxLength", "getDebugTopicMaxLength", "setDebugTopicMaxLength", "debugTopicSuggestSwitch", "getDebugTopicSuggestSwitch", "setDebugTopicSuggestSwitch", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnableHomeViewPagerScroll", "isGetGps", "isMoreTabEnable", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "lastCommentFullScreen", "getLastCommentFullScreen", "setLastCommentFullScreen", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "realNameDebugCache", "getRealNameDebugCache", "setRealNameDebugCache", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoRecordPara", "getVideoRecordPara", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "Lkotlin/Pair;", "plugin-finder_release"})
public final class b
{
  private static int KVX = 0;
  private static int KVY = 0;
  private static int KVZ = 0;
  private static boolean KWa = false;
  private static boolean KWb = false;
  private static int KWc = 0;
  private static int KWd = 0;
  private static int KWe = 0;
  private static final boolean KWf = false;
  private static int KWg = 0;
  private static final long KWh = 2000L;
  private static int KWi = 0;
  private static boolean KWj = false;
  private static final boolean KWk = false;
  private static final int KWl = 300000;
  private static final int KWm = 5000;
  private static int KWn = 0;
  private static boolean KWo = false;
  private static int KWp = 0;
  private static final int KWq;
  private static final String bLg;
  private static final int qIJ = 1024;
  private static final int qIK = 1048576;
  private static final int qIL = 10485760;
  private static final int qIM = 1048576;
  private static int qIN = 0;
  private static final int qIO = 300;
  private static int qIP = 0;
  private static int qIQ = 0;
  private static int qIR = 0;
  private static final int qIS = 143360;
  private static int qIT = 0;
  private static int qIU = 0;
  private static int qIV = 0;
  private static int qIW = 0;
  private static int qIX = 0;
  private static int qIY = 0;
  private static final int qIZ = 3;
  public static final b qJA;
  private static final int qJa = 800;
  private static int qJd = 0;
  private static final int qJe = 45;
  private static final int qJf = 45;
  private static final int qJg = 10;
  private static boolean qJh;
  private static boolean qJi;
  private static boolean qJj;
  private static long qJk;
  private static final long qJl;
  private static int qJm;
  private static final f qJn;
  private static final f qJo;
  private static final f qJp;
  private static int qJq;
  private static int qJr;
  private static int qJs;
  private static int qJt;
  private static boolean qJu;
  private static int qJv;
  private static boolean qJw;
  private static boolean qJy;
  private static int qJz;
  
  static
  {
    AppMethodBeat.i(166903);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "isEnableGesturePreviewImage", "isEnableGesturePreviewImage()Z")), (d.l.k)w.a(new u(w.bk(b.class), "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo()Z")), (d.l.k)w.a(new u(w.bk(b.class), "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION()I")) };
    qJA = new b();
    qIJ = 1024;
    qIK = 1048576;
    qIL = qIK * 10;
    qIM = qIK * 1;
    qIN = qIK * 28;
    KVX = qIK * 28;
    qIO = 300;
    qIP = 1280;
    qIQ = 1080;
    qIR = 90;
    qIS = qIJ * 140;
    qIT = 1080;
    qIU = 1080;
    qIV = 70;
    qIW = 1080;
    qIX = 1080;
    qIY = 70;
    KVY = 50;
    qIZ = 3;
    qJa = 800;
    qJd = 300000;
    qJe = 45;
    qJf = 45;
    qJg = 10;
    qJk = -1L;
    qJl = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    bLg = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + cpv() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + cpr() + " 后台处理\n    3、可配置（接x）：timeline顶部相机入口是否展示（默认展示）" + cps() + "\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量） \n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + cpt() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + com.tencent.mm.plugin.expt.a.b.a.prq + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    qJn = d.g.E((d.g.a.a)b.qJC);
    qJo = d.g.E((d.g.a.a)b.c.qJD);
    qJp = d.g.E((d.g.a.a)b.a.qJB);
    qJq = 1;
    qJr = 15;
    KVZ = 1;
    qJt = 1;
    qJv = 5;
    i locali = i.qTa;
    if (i.crT()) {}
    for (int i = 1;; i = 2)
    {
      KWc = i;
      qJy = true;
      KWd = -1;
      KWe = -1;
      KWh = 2000L;
      KWi = 2;
      KWj = true;
      KWl = 300000;
      KWm = 5000;
      KWn = 20;
      KWp = -1;
      KWq = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEA, 0);
      AppMethodBeat.o(166903);
      return;
    }
  }
  
  public static void CO(int paramInt)
  {
    qJd = paramInt;
  }
  
  public static void ahs(int paramInt)
  {
    qJs = paramInt;
  }
  
  public static void aht(int paramInt)
  {
    KWd = paramInt;
  }
  
  public static void ahu(int paramInt)
  {
    KWg = paramInt;
  }
  
  public static void ahv(int paramInt)
  {
    KWi = paramInt;
  }
  
  public static void ahw(int paramInt)
  {
    KWn = paramInt;
  }
  
  public static void ahx(int paramInt)
  {
    KWp = paramInt;
  }
  
  public static String cU(int paramInt, String paramString)
  {
    AppMethodBeat.i(198968);
    d.g.b.k.h(paramString, "defaultStr");
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(198968);
      return "";
    case 1: 
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      paramString = locale.afk().get(ae.a.LAU, paramString);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(198968);
        throw paramString;
      }
      paramString = (String)paramString;
      AppMethodBeat.o(198968);
      return paramString;
    case 3: 
      locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      paramString = locale.afk().get(ae.a.LAW, paramString);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(198968);
        throw paramString;
      }
      paramString = (String)paramString;
      AppMethodBeat.o(198968);
      return paramString;
    }
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    paramString = locale.afk().get(ae.a.LAV, paramString);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(198968);
      throw paramString;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(198968);
    return paramString;
  }
  
  public static VideoTransPara coB()
  {
    AppMethodBeat.i(166904);
    Object localObject = d.awT();
    d.g.b.k.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((d)localObject).awY();
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara coC()
  {
    AppMethodBeat.i(166905);
    Object localObject = d.awT();
    d.g.b.k.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((d)localObject).awZ();
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static int coD()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pru, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  public static boolean coE()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prP, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int coF()
  {
    AppMethodBeat.i(198945);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEx, qIK * 28);
    AppMethodBeat.o(198945);
    return i;
  }
  
  public static int coG()
  {
    return qIO;
  }
  
  public static int coH()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderFeedCompressResolution");
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
    i = bt.aGh((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int coI()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166909);
      return 1080;
    }
    ad.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166909);
      throw ((Throwable)localObject);
    }
    i = bt.aGh((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int coJ()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166910);
      return 90;
    }
    ad.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166910);
      throw ((Throwable)localObject);
    }
    i = bt.aGh(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static int coK()
  {
    return qIS;
  }
  
  public static int coL()
  {
    AppMethodBeat.i(166911);
    int i = qIT;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int coM()
  {
    AppMethodBeat.i(166912);
    int i = qIU;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int coN()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderHeadCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166913);
      return 90;
    }
    ad.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166913);
      throw ((Throwable)localObject);
    }
    i = bt.aGh(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int coO()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderProfileBgImgCompressResolution");
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
    i = bt.aGh((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int coP()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166915);
      return 1080;
    }
    ad.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166915);
      throw ((Throwable)localObject);
    }
    i = bt.aGh((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int coQ()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getValue("FinderProfileBgImgCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166916);
      return 70;
    }
    ad.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166916);
      throw ((Throwable)localObject);
    }
    i = bt.aGh(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int coR()
  {
    return qIZ;
  }
  
  public static int coU()
  {
    return qJd;
  }
  
  public static int coV()
  {
    return qJe;
  }
  
  public static int coW()
  {
    return qJf;
  }
  
  public static boolean coX()
  {
    return qJh;
  }
  
  public static boolean coY()
  {
    return qJi;
  }
  
  public static void coZ()
  {
    qJi = true;
  }
  
  public static String cpA()
  {
    AppMethodBeat.i(190877);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwm, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(190877);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = aj.getContext().getString(2131759288);
      d.g.b.k.g(localObject, "MMApplicationContext.get….finder_no_post_edu_desc)");
      AppMethodBeat.o(190877);
      return localObject;
    }
    AppMethodBeat.o(190877);
    return localObject;
  }
  
  public static boolean cpB()
  {
    AppMethodBeat.i(166937);
    boolean bool = ((Boolean)qJn.getValue()).booleanValue();
    AppMethodBeat.o(166937);
    return bool;
  }
  
  public static boolean cpC()
  {
    AppMethodBeat.i(166938);
    boolean bool = ((Boolean)qJo.getValue()).booleanValue();
    AppMethodBeat.o(166938);
    return bool;
  }
  
  private static boolean[] cpD()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prL, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(localObject1)));
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
          ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + (String)localObject2 + " model=" + str + " version=" + k + " isEnableImage=" + bool1 + " isEnableVideo=" + bool2 + " | this device=" + (String)localObject3 + " version=" + Build.VERSION.SDK_INT);
          if (k < Build.VERSION.SDK_INT) {
            break label471;
          }
          CharSequence localCharSequence = (CharSequence)localObject3;
          d.g.b.k.g(localObject2, "name");
          if (!n.a(localCharSequence, (CharSequence)localObject2, true)) {
            break label471;
          }
          localObject2 = (CharSequence)localObject3;
          d.g.b.k.g(str, "model");
          if (!n.a((CharSequence)localObject2, (CharSequence)str, true)) {
            break label471;
          }
          AppMethodBeat.o(166939);
          return new boolean[] { bool1, bool2 };
        }
        boolean bool1 = ((JSONObject)localObject1).getBoolean("isEnableImage");
        boolean bool2 = ((JSONObject)localObject1).getBoolean("isEnableVideo");
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + bool1 + " isEnableVideo=" + bool2);
        AppMethodBeat.o(166939);
        return new boolean[] { bool1, bool2 };
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("FinderConfig", (Throwable)localException, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(166939);
        return new boolean[] { true, true };
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
      }
      label471:
      i += 1;
    }
  }
  
  public static int cpG()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)qJp.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static String cpH()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prN, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean cpI()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean cpJ()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prO, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static void cpK()
  {
    qJq = 3;
  }
  
  public static int cpL()
  {
    AppMethodBeat.i(166946);
    if ((qJq > 1) && (ad.getLogLevel() <= 1))
    {
      i = qJq;
      AppMethodBeat.o(166946);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderMaxTopicCount", qJq);
    AppMethodBeat.o(166946);
    return i;
  }
  
  public static void cpM()
  {
    qJr = 10;
  }
  
  public static int cpN()
  {
    AppMethodBeat.i(166947);
    if ((qJr != 15) && (ad.getLogLevel() <= 1))
    {
      i = qJr;
      AppMethodBeat.o(166947);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderTopicTextLimit", qJr);
    AppMethodBeat.o(166947);
    return i;
  }
  
  public static boolean cpO()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prQ, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean cpQ()
  {
    AppMethodBeat.i(166949);
    if ((qJs > 0) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166949);
      return true;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderSuggestTagViewShow", 0) == 1)
    {
      AppMethodBeat.o(166949);
      return true;
    }
    AppMethodBeat.o(166949);
    return false;
  }
  
  public static boolean cpR()
  {
    AppMethodBeat.i(166950);
    if ((qJt == 0) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean cpT()
  {
    AppMethodBeat.i(166952);
    if ((qJu) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prT, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int cpU()
  {
    AppMethodBeat.i(178407);
    if ((qJv != 5) && (ad.getLogLevel() <= 1))
    {
      i = qJv;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prV, qJv);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static boolean cpX()
  {
    AppMethodBeat.i(178408);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    boolean bool = locale.afk().getBoolean(ae.a.FwQ, false);
    ad.i("FinderConfig", "[GET] ENABLE_SHOW_OTHER_PROFILE_FANS = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(178408);
    return bool;
  }
  
  public static boolean cpZ()
  {
    AppMethodBeat.i(178409);
    boolean bool = KWa;
    AppMethodBeat.o(178409);
    return bool;
  }
  
  public static boolean cpa()
  {
    return qJj;
  }
  
  public static void cpb()
  {
    qJj = true;
  }
  
  public static long cpc()
  {
    AppMethodBeat.i(166917);
    if ((qJk > 0L) && (ad.getLogLevel() <= 1))
    {
      l = qJk;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pry, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  public static void cpd()
  {
    qJk = 60000L;
  }
  
  private static float cpe()
  {
    AppMethodBeat.i(166918);
    ad.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + qJl);
    if (qJl < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (qJl < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long cpf()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prz, 1024L) * qIK) * cpe());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long cpg()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prA, 100L) * qIK) * cpe());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static long cph()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prB, 500L) * qIK) * cpe());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static long cpi()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prC, 1024L) * qIK) * cpe());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long cpj()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prD, 500L) * qIK) * cpe());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long cpk()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prE, 500L) * qIK) * cpe());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long cpl()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prF, 500L) * qIK) * cpe());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static int cpm()
  {
    AppMethodBeat.i(166926);
    if ((qJm > 0) && (ad.getLogLevel() <= 1))
    {
      i = qJm;
      AppMethodBeat.o(166926);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderCommentTextLimit", 800);
    AppMethodBeat.o(166926);
    return i;
  }
  
  public static int cpn()
  {
    AppMethodBeat.i(166927);
    if ((qJm > 0) && (ad.getLogLevel() <= 1))
    {
      i = qJm;
      AppMethodBeat.o(166927);
      return i + 5;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderMediaPublishTextLimit", 1000);
    AppMethodBeat.o(166927);
    return i;
  }
  
  public static int cpo()
  {
    AppMethodBeat.i(166928);
    if ((qJm > 0) && (ad.getLogLevel() <= 1))
    {
      i = qJm;
      AppMethodBeat.o(166928);
      return i + 10;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderPureTextPublishTextLimit", 800);
    AppMethodBeat.o(166928);
    return i;
  }
  
  public static void cpp()
  {
    qJm = 10;
  }
  
  public static int cpq()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean cpr()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pro, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean cps()
  {
    AppMethodBeat.i(166931);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prn, 1) == 1)
    {
      AppMethodBeat.o(166931);
      return true;
    }
    AppMethodBeat.o(166931);
    return false;
  }
  
  public static boolean cpt()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prp, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean cpu()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prv, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean cpv()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prw, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean cpw()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean cpx()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean cpy()
  {
    AppMethodBeat.i(190875);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(190875);
      return true;
    }
    AppMethodBeat.o(190875);
    return false;
  }
  
  public static String cpz()
  {
    AppMethodBeat.i(190876);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwl, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(190876);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = aj.getContext().getString(2131759289);
      d.g.b.k.g(localObject, "MMApplicationContext.get…finder_no_post_edu_title)");
      AppMethodBeat.o(190876);
      return localObject;
    }
    AppMethodBeat.o(190876);
    return localObject;
  }
  
  public static boolean cqa()
  {
    AppMethodBeat.i(178411);
    i locali = i.qTa;
    if (i.crT())
    {
      if (KWb)
      {
        AppMethodBeat.o(178411);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prW, 0) == 1)
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
  
  public static boolean cqc()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static int cqd()
  {
    AppMethodBeat.i(178414);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psd, 0);
    AppMethodBeat.o(178414);
    return i;
  }
  
  public static boolean cqe()
  {
    AppMethodBeat.i(178415);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.afk().a(ae.a.Fxm, 0L) == 0L)
    {
      AppMethodBeat.o(178415);
      return true;
    }
    AppMethodBeat.o(178415);
    return false;
  }
  
  public static void cqf()
  {
    qJz = 1;
  }
  
  public static boolean cqg()
  {
    AppMethodBeat.i(178416);
    if ((qJz == 1) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psb, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int cqh()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psc, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int cqi()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static int cqj()
  {
    AppMethodBeat.i(190878);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prx, 300000);
    AppMethodBeat.o(190878);
    return i;
  }
  
  public static boolean fUA()
  {
    return KWj;
  }
  
  public static boolean fUB()
  {
    AppMethodBeat.i(198962);
    if ((!KWj) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(198962);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderCommentAutoExpandSubcommentList", 1) == 1)
    {
      AppMethodBeat.o(198962);
      return true;
    }
    AppMethodBeat.o(198962);
    return false;
  }
  
  public static boolean fUC()
  {
    return KWk;
  }
  
  public static int fUD()
  {
    return KWl;
  }
  
  public static int fUE()
  {
    return KWm;
  }
  
  public static int fUF()
  {
    return KWn;
  }
  
  public static int fUG()
  {
    AppMethodBeat.i(198963);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderFakeLoadingPageCount", 5);
    AppMethodBeat.o(198963);
    return i;
  }
  
  public static long fUH()
  {
    AppMethodBeat.i(198964);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)localObject).Zd().getInt("FinderFakeLoadingDurationMS", 300);
    localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.LAS, i);
    if (j == 0) {}
    for (;;)
    {
      ad.i("FinderConfig", "[TIMELINE_LOADING_EXPIRED_TIME] duration=".concat(String.valueOf(i)));
      long l = i;
      AppMethodBeat.o(198964);
      return l;
      i = j;
    }
  }
  
  public static boolean fUI()
  {
    AppMethodBeat.i(198965);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service(IConfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderFakeLoadingPageCount", 5) > 0)
    {
      AppMethodBeat.o(198965);
      return true;
    }
    AppMethodBeat.o(198965);
    return false;
  }
  
  public static boolean fUJ()
  {
    return KWo;
  }
  
  public static void fUK()
  {
    KWo = true;
  }
  
  public static int fUL()
  {
    int i = 0;
    AppMethodBeat.i(198966);
    if (KWp == -1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      if (locale.afk().getBoolean(ae.a.LBz, false)) {
        i = 1;
      }
      KWp = i;
    }
    i = KWp;
    AppMethodBeat.o(198966);
    return i;
  }
  
  public static boolean fUM()
  {
    AppMethodBeat.i(198967);
    if (h.IS_FLAVOR_PURPLE)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      if (locale.afk().getBoolean(ae.a.LAT, false)) {}
    }
    else
    {
      AppMethodBeat.o(198967);
      return false;
    }
    AppMethodBeat.o(198967);
    return true;
  }
  
  public static boolean fUN()
  {
    AppMethodBeat.i(198969);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEm, 1) == 1)
    {
      AppMethodBeat.o(198969);
      return true;
    }
    AppMethodBeat.o(198969);
    return false;
  }
  
  public static int fUO()
  {
    return KWq;
  }
  
  public static int fUa()
  {
    AppMethodBeat.i(198946);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEy, qIK * 28);
    AppMethodBeat.o(198946);
    return i;
  }
  
  public static int fUb()
  {
    AppMethodBeat.i(198947);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(198947);
    return i;
  }
  
  public static boolean fUc()
  {
    AppMethodBeat.i(198948);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEr, 1) == 1)
    {
      AppMethodBeat.o(198948);
      return true;
    }
    AppMethodBeat.o(198948);
    return false;
  }
  
  public static boolean fUd()
  {
    AppMethodBeat.i(198949);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEs, 1) == 1)
    {
      AppMethodBeat.o(198949);
      return true;
    }
    AppMethodBeat.o(198949);
    return false;
  }
  
  public static o<Integer, Boolean> fUe()
  {
    AppMethodBeat.i(198950);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEn, 3);
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
      AppMethodBeat.o(198950);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    ad.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(198950);
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
      AppMethodBeat.o(198950);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    d.g.b.k.g(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEp, "");
    if (!bt.isNullOrNil(str))
    {
      d.g.b.k.g(str, "waitForRelease");
      if ((n.f((CharSequence)str, (CharSequence)localObject2)) || (n.f((CharSequence)str, (CharSequence)localObject3)) || (n.f((CharSequence)str, (CharSequence)localObject4))) {
        ad.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEo, "");
          if (bt.isNullOrNil(str)) {
            break label520;
          }
          d.g.b.k.g(str, "videoSingleCount");
          if ((!n.f((CharSequence)str, (CharSequence)localObject2)) && (!n.f((CharSequence)str, (CharSequence)localObject3)) && (!n.f((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          ad.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(198950);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static boolean fUf()
  {
    AppMethodBeat.i(198951);
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEB, 1) == 1) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
    {
      AppMethodBeat.o(198951);
      return true;
    }
    AppMethodBeat.o(198951);
    return false;
  }
  
  public static boolean fUg()
  {
    AppMethodBeat.i(198952);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEC, 1) == 1)
    {
      AppMethodBeat.o(198952);
      return true;
    }
    AppMethodBeat.o(198952);
    return false;
  }
  
  public static boolean fUh()
  {
    AppMethodBeat.i(198953);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(198953);
      return true;
    }
    AppMethodBeat.o(198953);
    return false;
  }
  
  public static void fUi()
  {
    KVZ = 3;
  }
  
  public static int fUj()
  {
    AppMethodBeat.i(198954);
    if ((KVZ > 1) && (ad.getLogLevel() <= 1))
    {
      i = KVZ;
      AppMethodBeat.o(198954);
      return i;
    }
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("FinderMaxMentionSbCount", 1000);
    AppMethodBeat.o(198954);
    return i;
  }
  
  public static int fUk()
  {
    return qJs;
  }
  
  public static boolean fUl()
  {
    return qJw;
  }
  
  public static boolean fUm()
  {
    return KWb;
  }
  
  public static int fUn()
  {
    AppMethodBeat.i(198955);
    Object localObject = new StringBuilder("DEFAULT_REPLY_SCENE hasFinderAccount:");
    i locali = i.qTa;
    ad.i("FinderConfig", i.crT());
    localObject = i.qTa;
    if (i.crT())
    {
      AppMethodBeat.o(198955);
      return 1;
    }
    AppMethodBeat.o(198955);
    return 2;
  }
  
  public static int fUo()
  {
    return KWd;
  }
  
  public static boolean fUp()
  {
    AppMethodBeat.i(198956);
    if (KWd < 0) {
      KWd = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEk, 0);
    }
    if (KWd == 1)
    {
      AppMethodBeat.o(198956);
      return true;
    }
    AppMethodBeat.o(198956);
    return false;
  }
  
  public static void fUq()
  {
    KWe = -1;
  }
  
  public static boolean fUr()
  {
    AppMethodBeat.i(198957);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEl, 1);
    if (KWe == -1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      KWe = locale.afk().getInt(ae.a.LBi, 0);
      ad.i("FinderConfig", "real name like config serverConfig:" + i + " realNameDebugCache:" + KWe);
    }
    if (KWe == 1)
    {
      AppMethodBeat.o(198957);
      return true;
    }
    if (KWe == 2)
    {
      AppMethodBeat.o(198957);
      return false;
    }
    if (i == 1)
    {
      AppMethodBeat.o(198957);
      return true;
    }
    AppMethodBeat.o(198957);
    return false;
  }
  
  public static boolean fUs()
  {
    return KWf;
  }
  
  public static int fUt()
  {
    return KWg;
  }
  
  public static boolean fUu()
  {
    AppMethodBeat.i(198958);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if (locale.afk().getInt(ae.a.LBg, 0) == 1)
    {
      AppMethodBeat.o(198958);
      return true;
    }
    AppMethodBeat.o(198958);
    return false;
  }
  
  public static long fUv()
  {
    return KWh;
  }
  
  public static boolean fUw()
  {
    AppMethodBeat.i(198959);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    int j = locale.afk().getInt(ae.a.LBh, 0);
    int i = j;
    if (j == 0) {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEi, 1);
    }
    if (i == 1)
    {
      AppMethodBeat.o(198959);
      return true;
    }
    AppMethodBeat.o(198959);
    return false;
  }
  
  public static boolean fUx()
  {
    AppMethodBeat.i(198960);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEh, 1) == 1)
    {
      AppMethodBeat.o(198960);
      return true;
    }
    AppMethodBeat.o(198960);
    return false;
  }
  
  public static int fUy()
  {
    return KWi;
  }
  
  public static boolean fUz()
  {
    AppMethodBeat.i(198961);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.LBy, -1);
    if (i == 1)
    {
      AppMethodBeat.o(198961);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(198961);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.KEj, 1) == 1)
    {
      AppMethodBeat.o(198961);
      return true;
    }
    AppMethodBeat.o(198961);
    return false;
  }
  
  public static void ld(boolean paramBoolean)
  {
    qJh = paramBoolean;
  }
  
  public static void le(boolean paramBoolean)
  {
    AppMethodBeat.i(178410);
    KWa = paramBoolean;
    AppMethodBeat.o(178410);
  }
  
  public static void yG(boolean paramBoolean)
  {
    qJw = paramBoolean;
  }
  
  public static void yH(boolean paramBoolean)
  {
    KWb = paramBoolean;
  }
  
  public static void yI(boolean paramBoolean)
  {
    KWj = paramBoolean;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final b qJC;
    
    static
    {
      AppMethodBeat.i(166900);
      qJC = new b();
      AppMethodBeat.o(166900);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */