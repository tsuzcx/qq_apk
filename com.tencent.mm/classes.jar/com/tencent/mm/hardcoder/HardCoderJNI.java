package com.tencent.mm.hardcoder;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class HardCoderJNI
{
  public static final int CALLBACK_TYPE_BASE = 0;
  public static final int CALLBACK_TYPE_DATA = 2;
  public static final int CALLBACK_TYPE_STATUS = 1;
  public static final int CONFIGURE_TYPE_BASE = 0;
  public static final int CONFIGURE_TYPE_QP_MEDIACODEC = 1;
  public static final int CPU_LEVEL_0 = 0;
  public static final int CPU_LEVEL_1 = 1;
  public static final int CPU_LEVEL_2 = 2;
  public static final int CPU_LEVEL_3 = 3;
  public static final int ERROR_CODE_CHECKENV_FAIL = -2;
  public static final int ERROR_CODE_DISCONNECT = -6;
  public static final int ERROR_CODE_FAILED = -1;
  public static final int ERROR_CODE_HCPERFMANAGER_NULL = -5;
  public static final int ERROR_CODE_NOT_ENABLE = -3;
  public static final int ERROR_CODE_NOT_FOREGROUND = -4;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int ERR_CLIENT_CONNECT = -20000;
  public static final int ERR_CLIENT_DISCONNECT = -20001;
  public static final int ERR_CLIENT_RESPONSE = -20002;
  public static final int FUNC_BASE = 1000;
  public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
  public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
  public static final int FUNC_CANCEL_GPU_HIGH_FREQ = 1017;
  public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
  public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
  public static final int FUNC_CHECK_PERMISSION = 1001;
  public static final int FUNC_CONFIGURE = 1018;
  public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
  public static final int FUNC_CPU_HIGH_FREQ = 1002;
  public static final int FUNC_GPU_HIGH_FREQ = 1016;
  public static final int FUNC_HIGH_IO_FREQ = 1006;
  public static final int FUNC_REG_ANR_CALLBACK = 1010;
  public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
  public static final int FUNC_REG_SYSTEM_EVENT_CALLBACK = 1015;
  public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
  public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
  public static final int FUNC_TERMINATE_APP = 1012;
  public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
  public static final int GPU_LEVEL_0 = 0;
  public static final int GPU_LEVEL_1 = 1;
  public static final int IO_LEVEL_0 = 0;
  public static final int IO_LEVEL_1 = 1;
  public static final int IO_LEVEL_2 = 2;
  public static final int IO_LEVEL_3 = 3;
  public static final int SYSTEM_EVENT_BASE = 0;
  public static final int SYSTEM_EVENT_BLUETOOTH_ACCEPTCALL = 3;
  public static final int SYSTEM_EVENT_BLUETOOTH_HANGUPCALL = 4;
  public static final String SYSTEM_EVENT_CODE = "system_event_code";
  public static final int SYSTEM_EVENT_SLIDE_CLOSE = 2;
  public static final int SYSTEM_EVENT_SLIDE_OPEN = 1;
  private static final String TAG = "HardCoder.HardCoderJNI";
  private static AnrCallback anrCallback;
  private static boolean checkEnv = false;
  public static final String clientSock = ".hardcoder.client.sock";
  private static boolean connect = false;
  private static boolean hcDebug = false;
  private static boolean hcEnable = false;
  private static a hcPerfManager;
  private static Method sGetStringPropsMethod;
  public static final boolean sHCDEBUG = false;
  public static final boolean sHCENABLE = true;
  private static volatile Class<?> sSystemPropertiesClazz;
  public static SceneReportCallback sceneReportCallback;
  public static final String serverPropKey = "persist.sys.hardcoder.name";
  private static SystemEventCallback systemEventCallback;
  public static int tickRate;
  
  static
  {
    AppMethodBeat.i(93918);
    System.loadLibrary("hardcoder");
    tickRate = 100;
    checkEnv = false;
    hcDebug = false;
    hcEnable = true;
    connect = false;
    sSystemPropertiesClazz = null;
    sGetStringPropsMethod = null;
    AppMethodBeat.o(93918);
  }
  
  public static native int cancelCpuCoreForThread(int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int cancelCpuHighFreq(int paramInt, long paramLong);
  
  public static native int cancelGpuHighFreq(int paramInt, long paramLong);
  
  public static native int cancelHighIOFreq(int paramInt, long paramLong);
  
  public static native int cancelUnifyCpuIOThreadCoreGpu(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native int checkPermission(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static native int configure(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  private static native int getTickRate();
  
  private static native int initHardCoder(String paramString1, int paramInt, String paramString2);
  
  public static int initHardCoder(String paramString1, int paramInt, String paramString2, HCPerfManagerThread paramHCPerfManagerThread, Context paramContext)
  {
    AppMethodBeat.i(93909);
    if (!isHcEnable())
    {
      c.i("HardCoder.HardCoderJNI", String.format("initHardCoder isHcEnable false, hcEnable:%b, checkEnv:%b, ret:-2", new Object[] { Boolean.valueOf(isHcEnable()), Boolean.valueOf(isCheckEnv()) }));
      AppMethodBeat.o(93909);
      return -3;
    }
    if (hcPerfManager == null)
    {
      Object localObject = paramHCPerfManagerThread;
      if (paramHCPerfManagerThread == null) {
        localObject = new HCPerfManagerThread()
        {
          public final Thread newThread(Runnable paramAnonymousRunnable, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(93906);
            paramAnonymousRunnable = new Thread(paramAnonymousRunnable, paramAnonymousString);
            AppMethodBeat.o(93906);
            return paramAnonymousRunnable;
          }
        };
      }
      if (paramContext != null)
      {
        paramHCPerfManagerThread = paramContext;
        if (!(paramContext instanceof Activity)) {}
      }
      else
      {
        paramHCPerfManagerThread = paramContext.getApplicationContext();
      }
      hcPerfManager = new a((HCPerfManagerThread)localObject, paramHCPerfManagerThread);
    }
    tickRate = getTickRate();
    paramInt = initHardCoder(paramString1, paramInt, paramString2);
    AppMethodBeat.o(93909);
    return paramInt;
  }
  
  public static boolean isCheckEnv()
  {
    return checkEnv;
  }
  
  public static boolean isHcDebug()
  {
    return hcDebug;
  }
  
  public static boolean isHcEnable()
  {
    return hcEnable;
  }
  
  public static native int isRunning();
  
  public static void onData(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93916);
    c.i("HardCoder.HardCoderJNI", "onData callbackType:" + paramInt1 + " timestamp:" + paramLong + " errCode:" + paramInt2 + " funcid:" + paramInt3 + " dataType:" + paramInt4);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(93916);
        return;
        if (paramInt2 == -20000)
        {
          connect = true;
          AppMethodBeat.o(93916);
          return;
        }
        if (paramInt2 == -20001)
        {
          connect = false;
          AppMethodBeat.o(93916);
          return;
          switch (paramInt3)
          {
          default: 
            break;
          case 1010: 
            if (anrCallback != null) {
              anrCallback.onANR(new String(paramArrayOfByte));
            }
            break;
          }
        }
      }
    } while (systemEventCallback == null);
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      paramInt1 = paramArrayOfByte.optInt("system_event_code", 0);
      c.i("HardCoder.HardCoderJNI", "onData SYSTEM_EVENT_CODE: ".concat(String.valueOf(paramInt1)));
      systemEventCallback.onEvent(paramInt1);
      AppMethodBeat.o(93916);
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        c.i("HardCoder.HardCoderJNI", "onData parse system event e:" + paramArrayOfByte.getMessage());
        paramArrayOfByte = null;
      }
    }
  }
  
  public static String readServerAddr()
  {
    AppMethodBeat.i(93917);
    try
    {
      if (sSystemPropertiesClazz == null)
      {
        localObject = Class.forName("android.os.SystemProperties");
        sSystemPropertiesClazz = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredMethod("get", new Class[] { String.class, String.class });
        sGetStringPropsMethod = (Method)localObject;
        ((Method)localObject).setAccessible(true);
      }
      Object localObject = (String)sGetStringPropsMethod.invoke(null, new Object[] { "persist.sys.hardcoder.name", "" });
      c.i("HardCoder.HardCoderJNI", String.format("readServerAddr, serverprop[%s] result[%s]", new Object[] { "persist.sys.hardcoder.name", localObject }));
      AppMethodBeat.o(93917);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      c.printErrStackTrace("HardCoder.HardCoderJNI", localThrowable, "readServerAddr", new Object[0]);
      AppMethodBeat.o(93917);
    }
    return "";
  }
  
  public static native int registerANRCallback(int paramInt, long paramLong);
  
  public static int registerANRCallback(AnrCallback paramAnrCallback)
  {
    AppMethodBeat.i(93914);
    anrCallback = paramAnrCallback;
    int i = registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
    AppMethodBeat.o(93914);
    return i;
  }
  
  public static native int registerBootPreloadResource(String[] paramArrayOfString, int paramInt, long paramLong);
  
  public static native int registerSystemEventCallback(int paramInt, long paramLong);
  
  public static int registerSystemEventCallback(SystemEventCallback paramSystemEventCallback)
  {
    AppMethodBeat.i(93915);
    systemEventCallback = paramSystemEventCallback;
    int i = registerSystemEventCallback(Process.myTid(), SystemClock.elapsedRealtime());
    AppMethodBeat.o(93915);
    return i;
  }
  
  public static native int requestCpuCoreForThread(int paramInt1, long paramLong1, int[] paramArrayOfInt, int paramInt2, int paramInt3, long paramLong2);
  
  public static native int requestCpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestGpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestHighIOFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native int requestScreenResolution(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public static native int requestUnifyCpuIOThreadCoreGpu(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong2);
  
  public static native int resetScreenResolution(int paramInt, long paramLong);
  
  public static void setCheckEnv(boolean paramBoolean)
  {
    checkEnv = paramBoolean;
  }
  
  private static native void setDebug(boolean paramBoolean);
  
  private static native void setHCEnable(boolean paramBoolean);
  
  public static void setHcDebug(boolean paramBoolean)
  {
    AppMethodBeat.i(93907);
    hcDebug = paramBoolean;
    if (checkEnv) {
      setDebug(paramBoolean);
    }
    AppMethodBeat.o(93907);
  }
  
  public static void setHcEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(93908);
    hcEnable = paramBoolean;
    if (checkEnv) {
      setHCEnable(paramBoolean);
    }
    AppMethodBeat.o(93908);
  }
  
  public static native void setRetryConnectInterval(int paramInt);
  
  public static void setSceneReportCallback(SceneReportCallback paramSceneReportCallback)
  {
    sceneReportCallback = paramSceneReportCallback;
  }
  
  public static int startPerformance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(93910);
    paramInt1 = startPerformance(paramInt1, paramInt2, paramInt3, 0, new int[] { paramInt4 }, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    AppMethodBeat.o(93910);
    return paramInt1;
  }
  
  public static int startPerformance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(93911);
    if (hcPerfManager == null)
    {
      c.e("HardCoder.HardCoderJNI", "startPerformance error HCPerfManager is null, please initHardCoder first!");
      AppMethodBeat.o(93911);
      return -5;
    }
    if (!connect)
    {
      c.e("HardCoder.HardCoderJNI", "startPerformance error disconnect");
      AppMethodBeat.o(93911);
      return -6;
    }
    paramInt1 = hcPerfManager.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    c.i("HardCoder.HardCoderJNI", String.format("hcPerfManager startPerformance:%d, scene:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt6) }));
    AppMethodBeat.o(93911);
    return paramInt1;
  }
  
  public static int startTraceCpuLoad(int paramInt)
  {
    AppMethodBeat.i(93913);
    paramInt = startTraceCpuLoad(paramInt, 20);
    AppMethodBeat.o(93913);
    return paramInt;
  }
  
  public static native int startTraceCpuLoad(int paramInt1, int paramInt2);
  
  public static int stopPerformance(int paramInt)
  {
    AppMethodBeat.i(93912);
    if (hcPerfManager == null)
    {
      c.e("HardCoder.HardCoderJNI", "stopPerformance error HCPerfManager is null, please initHardCoder first!");
      AppMethodBeat.o(93912);
      return -5;
    }
    if (!connect)
    {
      c.e("HardCoder.HardCoderJNI", "stopPerformance error disconnect");
      AppMethodBeat.o(93912);
      return -6;
    }
    a locala = hcPerfManager;
    a.c localc = new a.c();
    localc.eBL = System.currentTimeMillis();
    localc.axc = paramInt;
    if (paramInt != 0) {}
    for (boolean bool = locala.eBJ.offer(localc);; bool = false)
    {
      c.d("HardCoder.HCPerfManager", String.format("stop ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      c.i("HardCoder.HardCoderJNI", String.format("hcPerfManager stopPerformance:%d, ret:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      if (!bool) {
        break;
      }
      AppMethodBeat.o(93912);
      return 0;
    }
    AppMethodBeat.o(93912);
    return -1;
  }
  
  public static native int stopTraceCpuLoad(int paramInt);
  
  public static native int terminateApp(int paramInt, long paramLong);
  
  public static abstract interface AnrCallback
  {
    public abstract void onANR(String paramString);
  }
  
  public static abstract interface HCPerfManagerThread
  {
    public abstract Thread newThread(Runnable paramRunnable, String paramString, int paramInt);
  }
  
  public static abstract interface SceneReportCallback
  {
    public abstract void sceneReport(int paramInt, long paramLong);
  }
  
  public static abstract interface SystemEventCallback
  {
    public abstract void onEvent(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderJNI
 * JD-Core Version:    0.7.0.1
 */