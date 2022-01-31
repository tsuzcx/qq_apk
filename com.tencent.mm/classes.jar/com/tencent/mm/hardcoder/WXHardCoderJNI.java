package com.tencent.mm.hardcoder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WXHardCoderJNI
  extends i
{
  public static final Map<Integer, Integer> APP_SCENE_ID_MAP;
  public static final boolean HC_ENABLE_FOR_TEST = false;
  public static final String KEY_HC_BEGIN_TIME_HOUR = "KEY_HC_BEGIN_TIME_HOUR";
  public static final String KEY_HC_BEGIN_TIME_MIN = "KEY_HC_BEGIN_TIME_MIN";
  public static final String KEY_HC_BG_ENABLE = "KEY_HC_BG_ENABLE";
  public static final String KEY_HC_DEBUG = "KEY_HC_DEBUG";
  public static final String KEY_HC_ENABLE = "KEY_HC_ENABLE";
  public static final String KEY_HC_END_TIME_HOUR = "KEY_HC_END_TIME_HOUR";
  public static final String KEY_HC_END_TIME_MIN = "KEY_HC_END_TIME_MIN";
  public static final String KEY_HC_KV_FT = "KEY_HC_KV_FT";
  public static final String KEY_HC_KV_PER = "KEY_HC_KV_PER";
  public static final String KEY_HC_RETRY_INTERVAL = "KEY_HC_RETRY_INTERVAL";
  public static final String KEY_HC_TIMEOUT_MARGIN = "KEY_HC_TIMEOUT_MARGIN";
  public static final String KEY_HC_TIME_LIMIT = "KEY_HC_TIME_LIMIT";
  public static final String KEY_HC_UIN_HASH = "KEY_HC_UIN_HASH";
  public static final Map<Integer, Integer> SCENE_ID_MAP;
  public static final String SETTING_SP_FILE = "hardcoder_setting";
  public static final String SETTING_UI_ACTION = "com.tencent.mm.action.HARDCODER_SETTING";
  public static final boolean SETTING_UI_ENABLE = false;
  private static final String TAG = "MicroMsg.WXHardCoderJNI";
  public static HashMap<Long, String> flagKeyMap;
  public static boolean foreground = false;
  private static j.a hardCoderReporterInfo;
  public static int hcBeginTimeHour = 0;
  public static int hcBeginTimeMin = 0;
  public static boolean hcBgEnable = false;
  public static int hcEndTimeHour = 0;
  public static int hcEndTimeMin = 0;
  public static boolean hcKVFtReport = false;
  public static boolean hcKVPerReport = false;
  public static int hcRetryInterval = 0;
  public static boolean hcTimeLimit = false;
  public static int hcTimeoutMargin = 0;
  public static int hcUinHash = 0;
  private static boolean needMapAPPScene = false;
  private static Method sGetStringPropsMethod;
  public static final int sHCBEGINHOUR = 8;
  public static final int sHCBEGINMIN = 0;
  public static final boolean sHCBGENABLE = true;
  public static final boolean sHCENABLE = true;
  public static final int sHCENDHOUR = 23;
  public static final int sHCENDMIN = 0;
  public static boolean sHCREPORT = false;
  public static final boolean sHCTIMELIMIT = false;
  public static final int sHCUINHASH = 0;
  public static final int sRETRYINTERVAL = 30;
  private static volatile Class<?> sSystemPropertiesClazz;
  public static final int sTIMEOUTMARGIN = 0;
  private static HardCoderJNI.SceneReportCallback sceneReportCallback;
  private static c.a wxHardCoderLog;
  
  static
  {
    AppMethodBeat.i(93146);
    hardCoderReporterInfo = null;
    needMapAPPScene = false;
    SCENE_ID_MAP = new HashMap();
    APP_SCENE_ID_MAP = new HashMap();
    flagKeyMap = new HashMap();
    initSceneAndFlagMap();
    reloadSPConfig(RELOAD_SCENE_INIT);
    foreground = false;
    hcBgEnable = true;
    hcRetryInterval = 30;
    hcUinHash = 0;
    hcTimeoutMargin = 0;
    sHCREPORT = false;
    hcKVPerReport = false;
    hcKVFtReport = sHCREPORT;
    hcTimeLimit = false;
    hcBeginTimeHour = 8;
    hcBeginTimeMin = 0;
    hcEndTimeHour = 23;
    hcEndTimeMin = 0;
    sSystemPropertiesClazz = null;
    sGetStringPropsMethod = null;
    wxHardCoderLog = new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(93119);
        ab.d(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(93119);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(93120);
        ab.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(93120);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(93118);
        ab.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(93118);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(93121);
        ab.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(93121);
      }
    };
    sceneReportCallback = new HardCoderJNI.SceneReportCallback()
    {
      public final void sceneReport(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(93123);
        if (WXHardCoderJNI.needMapAPPScene)
        {
          AppMethodBeat.o(93123);
          return;
        }
        Integer localInteger = (Integer)WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(paramAnonymousInt));
        if (localInteger == null)
        {
          AppMethodBeat.o(93123);
          return;
        }
        WXHardCoderJNI.access$100(new l(localInteger.intValue()));
        AppMethodBeat.o(93123);
      }
    };
    AppMethodBeat.o(93146);
  }
  
  private static boolean checkHardCoderEnv()
  {
    AppMethodBeat.i(93138);
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    String str3 = readServerAddr(false);
    ab.i("MicroMsg.WXHardCoderJNI", "checkHardCoderEnv manufacture[%s], model[%s], remote[%s]", new Object[] { str1, str2, str3 });
    if (!bo.isNullOrNil(str3))
    {
      AppMethodBeat.o(93138);
      return true;
    }
    AppMethodBeat.o(93138);
    return false;
  }
  
  public static boolean getDebug()
  {
    AppMethodBeat.i(93125);
    boolean bool = HardCoderJNI.isHcDebug();
    AppMethodBeat.o(93125);
    return bool;
  }
  
  public static boolean getEnable()
  {
    AppMethodBeat.i(93126);
    boolean bool = HardCoderJNI.isHcEnable();
    AppMethodBeat.o(93126);
    return bool;
  }
  
  public static int initHardCoder(e.a parama, j.a parama1)
  {
    AppMethodBeat.i(93137);
    HardCoderJNI.setHcEnable(isHCEnable());
    String str = readServerAddr(false);
    if ((str == null) || (str.isEmpty()))
    {
      parama = str;
      if (str == null) {
        parama = "null";
      }
      ab.w("MicroMsg.WXHardCoderJNI", "initHardCoder serverSock is null or empty, skip init and reguard as disabled, serverSock:%s.", new Object[] { parama });
      HardCoderJNI.setCheckEnv(false);
      AppMethodBeat.o(93137);
      return -3;
    }
    if ((str != null) && (str.contains("|"))) {
      needMapAPPScene = true;
    }
    e.a(parama);
    hardCoderReporterInfo = parama1;
    c.a(wxHardCoderLog);
    HardCoderJNI.setSceneReportCallback(sceneReportCallback);
    ab.i("MicroMsg.WXHardCoderJNI", "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", new Object[] { Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Boolean.valueOf(HardCoderJNI.isCheckEnv()), Integer.valueOf(HardCoderJNI.tickRate) });
    int i = HardCoderJNI.initHardCoder(str, 0, ah.getPackageName() + ".hardcoder.client.sock", new HardCoderJNI.HCPerfManagerThread()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(93122);
        paramAnonymousRunnable = d.a(paramAnonymousRunnable, paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(93122);
        return paramAnonymousRunnable;
      }
    }, ah.getContext());
    AppMethodBeat.o(93137);
    return i;
  }
  
  private static void initSceneAndFlagMap()
  {
    AppMethodBeat.i(93144);
    SCENE_ID_MAP.clear();
    APP_SCENE_ID_MAP.clear();
    SCENE_ID_MAP.put(Integer.valueOf(101), Integer.valueOf(1));
    SCENE_ID_MAP.put(Integer.valueOf(201), Integer.valueOf(2));
    SCENE_ID_MAP.put(Integer.valueOf(202), Integer.valueOf(3));
    SCENE_ID_MAP.put(Integer.valueOf(203), Integer.valueOf(4));
    SCENE_ID_MAP.put(Integer.valueOf(301), Integer.valueOf(5));
    SCENE_ID_MAP.put(Integer.valueOf(302), Integer.valueOf(6));
    SCENE_ID_MAP.put(Integer.valueOf(401), Integer.valueOf(7));
    SCENE_ID_MAP.put(Integer.valueOf(501), Integer.valueOf(8));
    SCENE_ID_MAP.put(Integer.valueOf(601), Integer.valueOf(9));
    SCENE_ID_MAP.put(Integer.valueOf(602), Integer.valueOf(10));
    SCENE_ID_MAP.put(Integer.valueOf(603), Integer.valueOf(11));
    SCENE_ID_MAP.put(Integer.valueOf(701), Integer.valueOf(12));
    SCENE_ID_MAP.put(Integer.valueOf(702), Integer.valueOf(13));
    SCENE_ID_MAP.put(Integer.valueOf(703), Integer.valueOf(14));
    SCENE_ID_MAP.put(Integer.valueOf(704), Integer.valueOf(15));
    SCENE_ID_MAP.put(Integer.valueOf(705), Integer.valueOf(16));
    SCENE_ID_MAP.put(Integer.valueOf(801), Integer.valueOf(17));
    SCENE_ID_MAP.put(Integer.valueOf(901), Integer.valueOf(18));
    SCENE_ID_MAP.put(Integer.valueOf(902), Integer.valueOf(19));
    SCENE_ID_MAP.put(Integer.valueOf(903), Integer.valueOf(20));
    SCENE_ID_MAP.put(Integer.valueOf(706), Integer.valueOf(21));
    SCENE_ID_MAP.put(Integer.valueOf(707), Integer.valueOf(22));
    APP_SCENE_ID_MAP.put(Integer.valueOf(101), Integer.valueOf(1));
    APP_SCENE_ID_MAP.put(Integer.valueOf(201), Integer.valueOf(6));
    APP_SCENE_ID_MAP.put(Integer.valueOf(202), Integer.valueOf(6));
    APP_SCENE_ID_MAP.put(Integer.valueOf(203), Integer.valueOf(5));
    APP_SCENE_ID_MAP.put(Integer.valueOf(301), Integer.valueOf(2));
    APP_SCENE_ID_MAP.put(Integer.valueOf(302), Integer.valueOf(2));
    APP_SCENE_ID_MAP.put(Integer.valueOf(401), Integer.valueOf(6));
    APP_SCENE_ID_MAP.put(Integer.valueOf(501), Integer.valueOf(4));
    APP_SCENE_ID_MAP.put(Integer.valueOf(601), Integer.valueOf(5));
    APP_SCENE_ID_MAP.put(Integer.valueOf(602), Integer.valueOf(5));
    APP_SCENE_ID_MAP.put(Integer.valueOf(603), Integer.valueOf(5));
    APP_SCENE_ID_MAP.put(Integer.valueOf(701), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(702), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(703), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(704), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(705), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(801), Integer.valueOf(1));
    APP_SCENE_ID_MAP.put(Integer.valueOf(901), Integer.valueOf(2));
    APP_SCENE_ID_MAP.put(Integer.valueOf(902), Integer.valueOf(2));
    APP_SCENE_ID_MAP.put(Integer.valueOf(903), Integer.valueOf(3));
    APP_SCENE_ID_MAP.put(Integer.valueOf(706), Integer.valueOf(2));
    APP_SCENE_ID_MAP.put(Integer.valueOf(707), Integer.valueOf(7));
    flagKeyMap.put(Long.valueOf(2L), "KEY_HC_BOOT_ENABLE");
    flagKeyMap.put(Long.valueOf(4L), "KEY_HC_RECEIVE_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(8L), "KEY_HC_SEND_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(16L), "KEY_HC_SEND_PIC_MSG_ENABLE");
    flagKeyMap.put(Long.valueOf(32L), "KEY_HC_ENTER_CHATTING_ENABLE");
    flagKeyMap.put(Long.valueOf(64L), "KEY_HC_QUIT_CHATTING_ENABLE");
    flagKeyMap.put(Long.valueOf(128L), "KEY_HC_UPDATE_CHATROOM_ENABLE");
    flagKeyMap.put(Long.valueOf(256L), "KEY_HC_DB_ENABLE");
    flagKeyMap.put(Long.valueOf(512L), "KEY_HC_DECODE_PIC_ENABLE");
    flagKeyMap.put(Long.valueOf(1024L), "KEY_HC_GIF_ENABLE");
    flagKeyMap.put(Long.valueOf(2048L), "KEY_HC_GIF_FRAME_ENABLE");
    flagKeyMap.put(Long.valueOf(4096L), "KEY_HC_ENCODE_VIDEO_ENABLE");
    flagKeyMap.put(Long.valueOf(8192L), "KEY_HC_SNS_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(16384L), "KEY_HCALBUM_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(32768L), "KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(65536L), "KEY_HC_SNS_USER_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(131072L), "KEY_HC_SNS_MSG_SCROLL_ENABLE");
    flagKeyMap.put(Long.valueOf(262144L), "KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE");
    AppMethodBeat.o(93144);
  }
  
  public static boolean isCheckEnv()
  {
    AppMethodBeat.i(93124);
    boolean bool = HardCoderJNI.isCheckEnv();
    AppMethodBeat.o(93124);
    return bool;
  }
  
  public static boolean isHCEnable()
  {
    AppMethodBeat.i(93136);
    boolean bool1 = isCheckEnv();
    boolean bool2 = getEnable();
    AppMethodBeat.o(93136);
    return bool1 & bool2;
  }
  
  public static int isRunning()
  {
    AppMethodBeat.i(93131);
    int i = HardCoderJNI.isRunning();
    AppMethodBeat.o(93131);
    return i;
  }
  
  public static String readServerAddr(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93135);
        try
        {
          if (sSystemPropertiesClazz == null)
          {
            localObject1 = Class.forName("android.os.SystemProperties");
            sSystemPropertiesClazz = (Class)localObject1;
            localObject1 = ((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class, String.class });
            sGetStringPropsMethod = (Method)localObject1;
            ((Method)localObject1).setAccessible(true);
          }
          localObject1 = (String)sGetStringPropsMethod.invoke(null, new Object[] { "persist.sys.hardcoder.name", "" });
          ab.i("MicroMsg.WXHardCoderJNI", "readServerAddr, serverprop[%s], result[%s], stack[%s]", new Object[] { "persist.sys.hardcoder.name", localObject1, bo.dtY() });
          if (paramBoolean)
          {
            if (!bo.isNullOrNil((String)localObject1)) {
              continue;
            }
            reportInfo(new l(true, 1, 1, false));
          }
          AppMethodBeat.o(93135);
        }
        catch (Throwable localThrowable)
        {
          Object localObject1;
          ab.printErrStackTrace("MicroMsg.WXHardCoderJNI", localThrowable, "readServerAddr", new Object[0]);
          if (!paramBoolean) {
            continue;
          }
          reportInfo(new l(true, 3, 1, false));
          String str = "";
          AppMethodBeat.o(93135);
          continue;
        }
        return localObject1;
      }
      finally {}
      reportInfo(new l(true, 2, 1, false));
      reportInfo(new m());
    }
  }
  
  public static int registerANRCallback(HardCoderJNI.AnrCallback paramAnrCallback)
  {
    AppMethodBeat.i(93139);
    if (!HardCoderJNI.isCheckEnv())
    {
      AppMethodBeat.o(93139);
      return -2;
    }
    int i = HardCoderJNI.registerANRCallback(paramAnrCallback);
    AppMethodBeat.o(93139);
    return i;
  }
  
  public static int registerSystemEventCallback(HardCoderJNI.SystemEventCallback paramSystemEventCallback)
  {
    AppMethodBeat.i(93140);
    if (!HardCoderJNI.isCheckEnv())
    {
      AppMethodBeat.o(93140);
      return -2;
    }
    ab.i("MicroMsg.WXHardCoderJNI", "registerSystemEventCallback, stack[%s]", new Object[] { bo.dtY() });
    int i = HardCoderJNI.registerSystemEventCallback(paramSystemEventCallback);
    AppMethodBeat.o(93140);
    return i;
  }
  
  public static void reloadSPConfig(int paramInt)
  {
    AppMethodBeat.i(93134);
    boolean bool = checkHardCoderEnv();
    HardCoderJNI.setCheckEnv(bool);
    if (!bool)
    {
      ab.e("MicroMsg.WXHardCoderJNI", "reloadSPConfig hcEnv is false.");
      AppMethodBeat.o(93134);
      return;
    }
    setDebug(false);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("hardcoder_setting", 0);
    HardCoderJNI.setHcEnable(localSharedPreferences.getBoolean("KEY_HC_ENABLE", true));
    hcBgEnable = localSharedPreferences.getBoolean("KEY_HC_BG_ENABLE", true);
    hcUinHash = localSharedPreferences.getInt("KEY_HC_UIN_HASH", 0);
    HardCoderJNI.setHcDebug(localSharedPreferences.getBoolean("KEY_HC_DEBUG", false));
    ab.i("MicroMsg.WXHardCoderJNI", "reloadSPConfig scene:%d, hcDebug:%b, hcEnable:%b, hcUinHash:%d, checkEnv:%b, stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Integer.valueOf(hcUinHash), Boolean.valueOf(HardCoderJNI.isCheckEnv()), bo.dtY() });
    hcRetryInterval = localSharedPreferences.getInt("KEY_HC_RETRY_INTERVAL", 30);
    if (localSharedPreferences.getInt("KEY_HC_KV_PER", 0) < hcUinHash)
    {
      bool = true;
      hcKVPerReport = bool;
      if (localSharedPreferences.getInt("KEY_HC_KV_FT", 0) >= hcUinHash) {
        break label2261;
      }
    }
    label2261:
    for (bool = true;; bool = false)
    {
      hcKVFtReport = bool;
      hcTimeoutMargin = localSharedPreferences.getInt("KEY_HC_TIMEOUT_MARGIN", 0);
      hcTimeLimit = localSharedPreferences.getBoolean("KEY_HC_TIME_LIMIT", false);
      hcBeginTimeHour = localSharedPreferences.getInt("KEY_HC_BEGIN_TIME_HOUR", 8);
      hcBeginTimeMin = localSharedPreferences.getInt("KEY_HC_BEGIN_TIME_MIN", 0);
      hcEndTimeHour = localSharedPreferences.getInt("KEY_HC_END_TIME_HOUR", 23);
      hcEndTimeMin = localSharedPreferences.getInt("KEY_HC_END_TIME_MIN", 0);
      hcBootEnable = localSharedPreferences.getBoolean("KEY_HC_BOOT_ENABLE", true);
      hcBootDelay = localSharedPreferences.getInt("KEY_HC_BOOT_DELEY", 0);
      hcBootCPU = localSharedPreferences.getInt("KEY_HC_BOOT_CPU", 1);
      hcBootIO = localSharedPreferences.getInt("KEY_HC_BOOT_IO", 0);
      hcBootThr = localSharedPreferences.getBoolean("KEY_HC_BOOT_THR", false);
      hcBootTimeout = localSharedPreferences.getInt("KEY_HC_BOOT_TIMEOUT", 5000);
      hcBootAction = localSharedPreferences.getLong("KEY_HC_BOOT_ACTION", 4L);
      hcEnterChattingEnable = localSharedPreferences.getBoolean("KEY_HC_ENTER_CHATTING_ENABLE", true);
      hcEnterChattingDelay = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_DELEY", 0);
      hcEnterChattingCPU = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_CPU", 1);
      hcEnterChattingIO = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_IO", 1);
      hcEnterChattingThr = localSharedPreferences.getBoolean("KEY_HC_ENTER_CHATTING_THR", false);
      hcEnterChattingTimeout = localSharedPreferences.getInt("KEY_HC_ENTER_CHATTING_TIMEOUT", 1000);
      hcEnterChattingAction = localSharedPreferences.getLong("KEY_HC_ENTER_CHATTING_ACTION", 12294L);
      hcQuitChattingEnable = localSharedPreferences.getBoolean("KEY_HC_QUIT_CHATTING_ENABLE", true);
      hcQuitChattingDelay = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_DELEY", 0);
      hcQuitChattingCPU = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_CPU", 2);
      hcQuitChattingIO = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_IO", 2);
      hcQuitChattingThr = localSharedPreferences.getBoolean("KEY_HC_QUIT_CHATTING_THR", false);
      hcQuitChattingTimeout = localSharedPreferences.getInt("KEY_HC_QUIT_CHATTING_TIMEOUT", 800);
      hcQuitChattingAction = localSharedPreferences.getLong("KEY_HC_QUIT_CHATTING_ACTION", 8194L);
      hcSendMsgEnable = localSharedPreferences.getBoolean("KEY_HC_SEND_MSG_ENABLE", true);
      hcSendMsgDelay = localSharedPreferences.getInt("KEY_HC_SEND_MSG_DELEY", 0);
      hcSendMsgCPU = localSharedPreferences.getInt("KEY_HC_SEND_MSG_CPU", 3);
      hcSendMsgIO = localSharedPreferences.getInt("KEY_HC_SEND_MSG_IO", 0);
      hcSendMsgThr = localSharedPreferences.getBoolean("KEY_HC_SEND_MSG_THR", true);
      hcSendMsgTimeout = localSharedPreferences.getInt("KEY_HC_SEND_MSG_TIMEOUT", 1000);
      hcSendMsgAction = localSharedPreferences.getLong("KEY_HC_SEND_MSG_ACTION", 12288L);
      hcSendPicMsgEnable = localSharedPreferences.getBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", true);
      hcSendPicMsgDelay = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_DELEY", 0);
      hcSendPicMsgCPU = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_CPU", 1);
      hcSendPicMsgIO = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_IO", 2);
      hcSendPicMsgThr = localSharedPreferences.getBoolean("KEY_HC_SEND_PIC_MSG_THR", true);
      hcSendPicMsgTimeout = localSharedPreferences.getInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", 500);
      hcSendPicMsgAction = localSharedPreferences.getLong("KEY_HC_SEND_PIC_MSG_ACTION", 123072L);
      hcReceiveMsgEnable = localSharedPreferences.getBoolean("KEY_HC_RECEIVE_MSG_ENABLE", true);
      hcReceiveMsgDelay = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_DELEY", 500);
      hcReceiveMsgCPU = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_CPU", 2);
      hcReceiveMsgIO = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_IO", 2);
      hcReceiveMsgThr = localSharedPreferences.getBoolean("KEY_HC_RECEIVE_MSG_THR", true);
      hcReceiveMsgTimeout = localSharedPreferences.getInt("KEY_HC_RECEIVE_MSG_TIMEOUT", 1000);
      hcReceiveMsgAction = localSharedPreferences.getLong("KEY_HC_RECEIVE_MSG_ACTION", 127040L);
      hcUpdateChatroomEnable = localSharedPreferences.getBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", true);
      hcUpdateChatroomDelay = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_DELEY", 0);
      hcUpdateChatroomCPU = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_CPU", 2);
      hcUpdateChatroomIO = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_IO", 2);
      hcUpdateChatroomThr = localSharedPreferences.getBoolean("KEY_HC_UPDATE_CHATROOM_THR", true);
      hcUpdateChatroomTimeout = localSharedPreferences.getInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", 1000);
      hcUpdateChatroomAction = localSharedPreferences.getLong("KEY_HC_UPDATE_CHATROOM_ACTION", 127040L);
      hcUpdateChatroomMemberCount = localSharedPreferences.getLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", 50L);
      hcDBEnable = localSharedPreferences.getBoolean("KEY_HC_DB_ENABLE", false);
      hcDBDelayQuery = localSharedPreferences.getInt("KEY_HC_DB_DELEY_QUERY", 100);
      hcDBDelayWrite = localSharedPreferences.getInt("KEY_HC_DB_DELEY_WRITE", 200);
      hcDBCPU = localSharedPreferences.getInt("KEY_HC_DB_CPU", 2);
      hcDBIO = localSharedPreferences.getInt("KEY_HC_DB_IO", 2);
      hcDBThr = localSharedPreferences.getBoolean("KEY_HC_DB_THR", false);
      hcDBTimeout = localSharedPreferences.getInt("KEY_HC_DB_TIMEOUT", 500);
      hcDBTimeoutBusy = localSharedPreferences.getInt("KEY_HC_DB_TIMEOUT_BUSY", 5000);
      hcDBActionQuery = localSharedPreferences.getLong("KEY_HC_DB_ACTION_QUERY", 4096L);
      hcDBActionWrite = localSharedPreferences.getLong("KEY_HC_DB_ACTION_WRITE", 12288L);
      hcEncodeVideoEnable = localSharedPreferences.getBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", true);
      hcEncodeVideoDelay = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_DELEY", 0);
      hcEncodeVideoCPU = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_CPU", 1);
      hcEncodeVideoIO = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_IO", 1);
      hcEncodeVideoThr = localSharedPreferences.getBoolean("KEY_HC_ENCODE_VIDEO_THR", false);
      hcEncodeVideoTimeout = localSharedPreferences.getInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", 20000);
      hcEncodeVideoAction = localSharedPreferences.getLong("KEY_HC_ENCODE_VIDEO_ACTION", 81984L);
      hcDecodePicEnable = localSharedPreferences.getBoolean("KEY_HC_DECODE_PIC_ENABLE", false);
      hcDecodePicDelay = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_DELEY", 100);
      hcDecodePicCPU = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_CPU", 2);
      hcDecodePicIO = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_IO", 2);
      hcDecodePicThr = localSharedPreferences.getBoolean("KEY_HC_DECODE_PIC_THR", false);
      hcDecodePicTimeout = localSharedPreferences.getInt("KEY_HC_DECODE_PIC_TIMEOUT", 500);
      hcDecodePicAction = localSharedPreferences.getLong("KEY_HC_DECODE_PIC_ACTION", 16448L);
      hcGifEnable = localSharedPreferences.getBoolean("KEY_HC_GIF_ENABLE", true);
      hcGifDelay = localSharedPreferences.getInt("KEY_HC_GIF_DELEY", 0);
      hcGifCPU = localSharedPreferences.getInt("KEY_HC_GIF_CPU", 3);
      hcGifIO = localSharedPreferences.getInt("KEY_HC_GIF_IO", 2);
      hcGifThr = localSharedPreferences.getBoolean("KEY_HC_GIF_THR", false);
      hcGifTimeout = localSharedPreferences.getInt("KEY_HC_GIF_TIMEOUT", 500);
      hcGifAction = localSharedPreferences.getLong("KEY_HC_GIF_ACTION", 81984L);
      hcGifFrameEnable = localSharedPreferences.getBoolean("KEY_HC_GIF_FRAME_ENABLE", true);
      hcGifFrameDelay = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_DELEY", 0);
      hcGifFrameCPU = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_CPU", 2);
      hcGifFrameIO = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_IO", 0);
      hcGifFrameThr = localSharedPreferences.getBoolean("KEY_HC_GIF_FRAME_THR", false);
      hcGifFrameTimeout = localSharedPreferences.getInt("KEY_HC_GIF_FRAME_TIMEOUT", 1000);
      hcGifFrameAction = localSharedPreferences.getLong("KEY_HC_GIF_FRAME_ACTION", 65600L);
      hcSNSScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_SCROLL_ENABLE", true);
      hcSNSScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_DELEY", 0);
      hcSNSScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_CPU", 2);
      hcSNSScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_IO", 2);
      hcSNSScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_SCROLL_THR", false);
      hcSNSScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_SCROLL_TIMEOUT", 1500);
      hcSNSScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_SCROLL_ACTION", 96L);
      hcSNSUserScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", true);
      hcSNSUserScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_DELEY", 0);
      hcSNSUserScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_CPU", 3);
      hcSNSUserScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_IO", 2);
      hcSNSUserScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_USER_SCROLL_THR", false);
      hcSNSUserScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", 1500);
      hcSNSUserScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_USER_SCROLL_ACTION", 96L);
      hcSNSMsgScrollEnable = localSharedPreferences.getBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", true);
      hcSNSMsgScrollDelay = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_DELEY", 0);
      hcSNSMsgScrollCPU = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_CPU", 3);
      hcSNSMsgScrollIO = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_IO", 2);
      hcSNSMsgScrollThr = localSharedPreferences.getBoolean("KEY_HC_SNS_MSG_SCROLL_THR", false);
      hcSNSMsgScrollTimeout = localSharedPreferences.getInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", 1500);
      hcSNSMsgScrollAction = localSharedPreferences.getLong("KEY_HC_SNS_MSG_SCROLL_ACTION", 96L);
      hcMediaGalleryScrollEnable = localSharedPreferences.getBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", true);
      hcMediaGalleryScrollDelay = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", 0);
      hcMediaGalleryScrollCPU = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", 3);
      hcMediaGalleryScrollIO = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", 2);
      hcMediaGalleryScrollThr = localSharedPreferences.getBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", false);
      hcMediaGalleryScrollTimeout = localSharedPreferences.getInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", 1500);
      hcMediaGalleryScrollAction = localSharedPreferences.getLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", 96L);
      hcAlbumScrollEnable = localSharedPreferences.getBoolean("KEY_HCALBUM_SCROLL_ENABLE", true);
      hcAlbumScrollDelay = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_DELEY", 0);
      hcAlbumScrollCPU = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_CPU", 3);
      hcAlbumScrollIO = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_IO", 2);
      hcAlbumScrollThr = localSharedPreferences.getBoolean("KEY_HC_ALBUM_SCROLL_THR", false);
      hcAlbumScrollTimeout = localSharedPreferences.getInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", 1500);
      hcAlbumScrollAction = localSharedPreferences.getLong("KEY_HC_ALBUM_SCROLL_ACTION", 96L);
      hcMiniProgramLaunchEnable = localSharedPreferences.getBoolean("KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE", true);
      hcMiniProgramLaunchDelay = localSharedPreferences.getInt("KEY_HC_MINI_PROGRAM_LAUNCH_DELEY", 500);
      hcMiniProgramLaunchCPU = localSharedPreferences.getInt("KEY_HC_MINI_PROGRAM_LAUNCH_CPU", 1);
      hcMiniProgramLaunchIO = localSharedPreferences.getInt("KEY_HC_MINI_PROGRAM_LAUNCH_IO", 1);
      hcMiniProgramLaunchThr = localSharedPreferences.getBoolean("KEY_HC_MINI_PROGRAM_LAUNCH_THR", false);
      hcMiniProgramLaunchTimeout = localSharedPreferences.getInt("KEY_HC_MINI_PROGRAM_LAUNCH_TIMEOUT", 5000);
      hcMiniProgramLaunchAction = localSharedPreferences.getLong("KEY_HC_MINI_PROGRAM_LAUNCH_ACTION", 114688L);
      ab.i("MicroMsg.WXHardCoderJNI", "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b] SNSUser[%b] SNSMsg[%b] MiniProgramLaunch[%b]", new Object[] { Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable), Boolean.valueOf(hcSNSUserScrollEnable), Boolean.valueOf(hcSNSMsgScrollEnable), Boolean.valueOf(hcMiniProgramLaunchEnable) });
      AppMethodBeat.o(93134);
      return;
      bool = false;
      break;
    }
  }
  
  public static void reportFPS(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93142);
    reportInfo(new k(paramInt1, paramLong1, paramInt2, paramLong2, paramLong3));
    AppMethodBeat.o(93142);
  }
  
  public static void reportIDKey(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(93141);
    reportInfo(new l(paramBoolean1, paramInt1, paramInt2, paramBoolean2));
    AppMethodBeat.o(93141);
  }
  
  private static void reportInfo(j paramj)
  {
    AppMethodBeat.i(93143);
    if (hardCoderReporterInfo != null) {
      hardCoderReporterInfo.reportInfo(paramj);
    }
    AppMethodBeat.o(93143);
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    AppMethodBeat.i(93128);
    HardCoderJNI.setHcDebug(paramBoolean);
    AppMethodBeat.o(93128);
  }
  
  public static void setHcEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(93127);
    HardCoderJNI.setHcEnable(paramBoolean);
    AppMethodBeat.o(93127);
  }
  
  public static void setRetryConnectInterval(int paramInt)
  {
    AppMethodBeat.i(93130);
    HardCoderJNI.setRetryConnectInterval(paramInt);
    AppMethodBeat.o(93130);
  }
  
  public static int startPerformance(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, String paramString)
  {
    AppMethodBeat.i(93132);
    if (!paramBoolean)
    {
      AppMethodBeat.o(93132);
      return -3;
    }
    if ((!hcBgEnable) && (!foreground))
    {
      AppMethodBeat.o(93132);
      return -4;
    }
    if (needMapAPPScene)
    {
      Integer localInteger = (Integer)APP_SCENE_ID_MAP.get(Integer.valueOf(paramInt6));
      if (localInteger != null) {
        paramInt6 = localInteger.intValue();
      }
    }
    for (;;)
    {
      paramInt1 = HardCoderJNI.startPerformance(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 + hcTimeoutMargin, paramInt6, paramLong, Process.myTid(), paramString);
      AppMethodBeat.o(93132);
      return paramInt1;
    }
  }
  
  public static int stopPerformance(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(93133);
    if (!paramBoolean)
    {
      AppMethodBeat.o(93133);
      return -3;
    }
    paramInt = HardCoderJNI.stopPerformance(paramInt);
    AppMethodBeat.o(93133);
    return paramInt;
  }
  
  public static int terminateApp(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93129);
    paramInt = HardCoderJNI.terminateApp(paramInt, paramLong);
    AppMethodBeat.o(93129);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI
 * JD-Core Version:    0.7.0.1
 */