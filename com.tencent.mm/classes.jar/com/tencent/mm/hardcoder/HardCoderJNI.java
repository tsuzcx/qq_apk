package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class HardCoderJNI
{
  public static final int APP_SCENE_COMMUNICATE = 6;
  public static final int APP_SCENE_DATA_LOADING_AND_PROCESS = 4;
  public static final int APP_SCENE_MULTI_MEDIA_PROCESS = 5;
  public static final int APP_SCENE_STARTUP = 1;
  public static final int APP_SCENE_SYSTEM_DEVICE = 7;
  public static final int APP_SCENE_UNDEFINE = 0;
  public static final int APP_SCENE_WINDOW_SCROLL = 3;
  public static final int APP_SCENE_WINDOW_SWITCH = 2;
  public static final int CALLBACK_TYPE_BASE = 0;
  public static final int CALLBACK_TYPE_DATA = 2;
  public static final int CALLBACK_TYPE_STATUS = 1;
  public static final int CLIENT_CONNECT = -20000;
  public static final int CLIENT_DISCONNECT = -20001;
  public static final String CLIENT_SOCK = ".hardcoder.client.sock";
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
  public static final int ERR_CLIENT_ALREADY_INIT = -20002;
  public static final int ERR_UNAUTHORIZED = -10001;
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
  public static final int FUNC_LOCAL = 0;
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
  public static final int RET_CPU_HIGH_FREQ = 8;
  public static final int RET_CPU_HIGH_FREQ_LEVEL_1 = 9;
  public static final int RET_CPU_HIGH_FREQ_LEVEL_2 = 10;
  public static final int RET_CPU_HIGH_FREQ_LEVEL_3 = 11;
  public static final int RET_GPU_HIGH_FREQ = 32;
  public static final int RET_HIGH_IO_FREQ = 16;
  public static final int RET_HIGH_IO_FREQ_LEVEL_1 = 17;
  public static final int RET_HIGH_IO_FREQ_LEVEL_2 = 18;
  public static final int RET_HIGH_IO_FREQ_LEVEL_3 = 19;
  public static final int RET_LEVEL_1 = 1;
  public static final int RET_LEVEL_2 = 2;
  public static final int RET_LEVEL_3 = 3;
  public static final int RET_OK = 0;
  public static final String SERVER_PROP_KEY = "persist.sys.hardcoder.name";
  private static final String TAG = "Hardcoder.HardCoderJNI";
  private static AnrCallback anrCallback;
  private static boolean checkEnv;
  private static boolean connect;
  private static c.a connectStatusCallback;
  private static HashMap<Long, c.b> funcRetCallback;
  private static boolean hcDebug;
  private static boolean hcEnable;
  private static a hcPerfManager;
  private static byte[] lock;
  private static HashMap<Long, c.c> requestStatusCallback;
  private static Method sGetStringPropsMethod;
  private static volatile Class<?> sSystemPropertiesClazz;
  public static c.d sceneReportCallback;
  public static int tickRate;
  
  static
  {
    AppMethodBeat.i(62473);
    System.loadLibrary("hardcoder");
    tickRate = 100;
    connect = false;
    lock = new byte[0];
    checkEnv = false;
    hcDebug = false;
    hcEnable = true;
    sSystemPropertiesClazz = null;
    sGetStringPropsMethod = null;
    funcRetCallback = new HashMap();
    requestStatusCallback = new HashMap();
    AppMethodBeat.o(62473);
  }
  
  public static native long cancelCpuCoreForThread(int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native long cancelCpuHighFreq(int paramInt, long paramLong);
  
  public static native long cancelGpuHighFreq(int paramInt, long paramLong);
  
  public static native long cancelHighIOFreq(int paramInt, long paramLong);
  
  public static native long cancelUnifyCpuIOThreadCoreGpu(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int[] paramArrayOfInt, int paramInt, long paramLong);
  
  public static native long checkPermission(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static long checkPermission(String[] paramArrayOfString1, String[] paramArrayOfString2, c.b paramb)
  {
    AppMethodBeat.i(62463);
    if (!connect)
    {
      d.e("Hardcoder.HardCoderJNI", "startPerformance error disconnect");
      AppMethodBeat.o(62463);
      return -6L;
    }
    long l = checkPermission(paramArrayOfString1, paramArrayOfString2, Process.myPid(), Process.myUid(), Process.myTid(), SystemClock.elapsedRealtimeNanos());
    funcRetCallback.put(Long.valueOf(l), paramb);
    AppMethodBeat.o(62463);
    return l;
  }
  
  public static native long configure(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  public static native long getParameters(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  private static native int getTickRate();
  
  private static native int initHardCoder(String paramString1, int paramInt, String paramString2);
  
  public static int initHardCoder(String paramString1, int paramInt, String paramString2, HCPerfManagerThread paramHCPerfManagerThread, c.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(62462);
    if (!isHcEnable())
    {
      d.e("Hardcoder.HardCoderJNI", String.format("initHardCoder client not enable Hardcoder, hcEnable:%b, checkEnv:%b", new Object[] { Boolean.valueOf(isHcEnable()), Boolean.valueOf(isCheckEnv()) }));
      AppMethodBeat.o(62462);
      return -3;
    }
    if ((paramString1 == null) || (paramString1.equals(""))) {
      bool = false;
    }
    checkEnv = bool;
    synchronized (lock)
    {
      if (hcPerfManager == null)
      {
        Object localObject = paramHCPerfManagerThread;
        if (paramHCPerfManagerThread == null) {
          localObject = new HCPerfManagerThread()
          {
            public final Thread newThread(Runnable paramAnonymousRunnable, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(62459);
              paramAnonymousRunnable = new Thread(paramAnonymousRunnable, paramAnonymousString);
              AppMethodBeat.o(62459);
              return paramAnonymousRunnable;
            }
          };
        }
        hcPerfManager = new a((HCPerfManagerThread)localObject);
      }
      tickRate = getTickRate();
      connectStatusCallback = parama;
      paramInt = initHardCoder(paramString1, paramInt, paramString2);
      AppMethodBeat.o(62462);
      return paramInt;
    }
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
  
  public static void onData(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62467);
    d.i("Hardcoder.HardCoderJNI", "onData callbackType:" + paramInt1 + ", requestId:" + paramLong1 + ", timestamp:" + paramLong2 + ", retCode:" + paramInt2 + ", funcId:" + paramInt3 + ", dataType:" + paramInt4);
    switch (paramInt1)
    {
    default: 
      onRequestCallback(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
    }
    do
    {
      AppMethodBeat.o(62467);
      return;
      switch (paramInt3)
      {
      default: 
        onRequestCallback(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
        AppMethodBeat.o(62467);
        return;
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(62467);
        return;
        connect = true;
        if (connectStatusCallback != null)
        {
          connectStatusCallback.em(connect);
          AppMethodBeat.o(62467);
          return;
          connect = false;
          if (connectStatusCallback != null)
          {
            connectStatusCallback.em(connect);
            AppMethodBeat.o(62467);
            return;
            connect = true;
            d.i("Hardcoder.HardCoderJNI", "onData callback, already initHardcoder!");
          }
        }
      }
      switch (paramInt3)
      {
      default: 
        onRequestCallback(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
        AppMethodBeat.o(62467);
        return;
      }
    } while (anrCallback == null);
    anrCallback.onANR(paramArrayOfByte);
    AppMethodBeat.o(62467);
  }
  
  public static void onRequestCallback(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62471);
    c.b localb = null;
    if (requestStatusCallback != null) {}
    for (Object localObject = (c.c)requestStatusCallback.remove(Long.valueOf(paramLong));; localObject = null)
    {
      if (funcRetCallback != null)
      {
        localb = (c.b)funcRetCallback.remove(Long.valueOf(paramLong));
        if (localb != null) {
          localb.onFuncRet(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
        }
      }
      if ((localObject != null) || (localb != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("onRequestCallback, funcId:").append(paramInt3).append(", requestId:").append(paramLong).append(", retCode:").append(paramInt2).append(", requestStatus:");
        if (localObject != null) {
          break label182;
        }
        paramArrayOfByte = "null";
        localObject = localStringBuilder.append(paramArrayOfByte).append(", funcRetCallback:");
        if (localb != null) {
          break label192;
        }
      }
      label182:
      label192:
      for (paramArrayOfByte = "false";; paramArrayOfByte = "true")
      {
        d.i("Hardcoder.HardCoderJNI", paramArrayOfByte);
        AppMethodBeat.o(62471);
        return;
        paramArrayOfByte = ((c.c)localObject).toString();
        break;
      }
    }
  }
  
  public static void putFuncRetHashMap(long paramLong, c.b paramb)
  {
    AppMethodBeat.i(62470);
    if (funcRetCallback != null) {
      funcRetCallback.put(Long.valueOf(paramLong), paramb);
    }
    AppMethodBeat.o(62470);
  }
  
  public static void putRequestStatusHashMap(long paramLong, c.c paramc)
  {
    AppMethodBeat.i(62469);
    if (requestStatusCallback != null) {
      requestStatusCallback.put(Long.valueOf(paramLong), paramc);
    }
    AppMethodBeat.o(62469);
  }
  
  public static String readServerAddr()
  {
    AppMethodBeat.i(62468);
    try
    {
      synchronized (lock)
      {
        if (sSystemPropertiesClazz == null)
        {
          localObject1 = Class.forName("android.os.SystemProperties");
          sSystemPropertiesClazz = (Class)localObject1;
          localObject1 = ((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class, String.class });
          sGetStringPropsMethod = (Method)localObject1;
          ((Method)localObject1).setAccessible(true);
        }
        Object localObject1 = (String)sGetStringPropsMethod.invoke(null, new Object[] { "persist.sys.hardcoder.name", "" });
        d.i("Hardcoder.HardCoderJNI", String.format("readServerAddr, serverprop[%s] result[%s]", new Object[] { "persist.sys.hardcoder.name", localObject1 }));
        AppMethodBeat.o(62468);
        return localObject1;
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      d.printErrStackTrace("Hardcoder.HardCoderJNI", localThrowable, "readServerAddr", new Object[0]);
      AppMethodBeat.o(62468);
    }
  }
  
  public static native long registerANRCallback(int paramInt, long paramLong);
  
  public static long registerANRCallback(AnrCallback paramAnrCallback)
  {
    AppMethodBeat.i(62472);
    anrCallback = paramAnrCallback;
    long l = registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
    AppMethodBeat.o(62472);
    return l;
  }
  
  public static native long registerBootPreloadResource(String[] paramArrayOfString, int paramInt, long paramLong);
  
  public static native long registerSystemEventCallback(int paramInt, long paramLong);
  
  public static native long requestCpuCoreForThread(int paramInt1, long paramLong1, int[] paramArrayOfInt, int paramInt2, int paramInt3, long paramLong2);
  
  public static native long requestCpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native long requestGpuHighFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native long requestHighIOFreq(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public static native long requestScreenResolution(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public static native long requestUnifyCpuIOThreadCoreGpu(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong2);
  
  public static native long resetScreenResolution(int paramInt, long paramLong);
  
  public static void setCheckEnv(boolean paramBoolean)
  {
    checkEnv = paramBoolean;
  }
  
  private static native void setDebug(boolean paramBoolean);
  
  private static native void setHCEnable(boolean paramBoolean);
  
  public static void setHcDebug(boolean paramBoolean)
  {
    AppMethodBeat.i(62460);
    hcDebug = paramBoolean;
    if (checkEnv) {
      setDebug(paramBoolean);
    }
    AppMethodBeat.o(62460);
  }
  
  public static void setHcEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(62461);
    hcEnable = paramBoolean;
    if (checkEnv) {
      setHCEnable(paramBoolean);
    }
    AppMethodBeat.o(62461);
  }
  
  public static native void setRetryConnectInterval(int paramInt);
  
  public static void setSceneReportCallback(c.d paramd)
  {
    sceneReportCallback = paramd;
  }
  
  public static int startPerformance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(62464);
    paramInt1 = startPerformance(paramInt1, paramInt2, paramInt3, 0, new int[] { paramInt4 }, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    AppMethodBeat.o(62464);
    return paramInt1;
  }
  
  public static int startPerformance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    AppMethodBeat.i(62465);
    if (hcPerfManager == null)
    {
      d.e("Hardcoder.HardCoderJNI", "startPerformance error HCPerfManager is null, please initHardCoder first!");
      AppMethodBeat.o(62465);
      return -5;
    }
    if (!connect)
    {
      d.e("Hardcoder.HardCoderJNI", "startPerformance error disconnect");
      AppMethodBeat.o(62465);
      return -6;
    }
    paramInt1 = hcPerfManager.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    d.i("Hardcoder.HardCoderJNI", String.format("hcPerfManager startPerformance:%d, scene:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt6) }));
    AppMethodBeat.o(62465);
    return paramInt1;
  }
  
  public static native int startTraceCpuLoad(int paramInt1, int paramInt2);
  
  public static int stopPerformance(int paramInt)
  {
    AppMethodBeat.i(62466);
    if (hcPerfManager == null)
    {
      d.e("Hardcoder.HardCoderJNI", "stopPerformance error HCPerfManager is null, please initHardCoder first!");
      AppMethodBeat.o(62466);
      return -5;
    }
    if (!connect)
    {
      d.e("Hardcoder.HardCoderJNI", "stopPerformance error disconnect");
      AppMethodBeat.o(62466);
      return -6;
    }
    a locala = hcPerfManager;
    a.c localc = new a.c();
    localc.hla = System.currentTimeMillis();
    localc.aHK = paramInt;
    if (paramInt != 0) {}
    for (boolean bool = locala.hkY.offer(localc);; bool = false)
    {
      d.d("Hardcoder.HCPerfManager", String.format("stop ret:%b, hashcode:%x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      d.i("Hardcoder.HardCoderJNI", String.format("stopPerformance:%d, ret:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      if (!bool) {
        break;
      }
      AppMethodBeat.o(62466);
      return 0;
    }
    AppMethodBeat.o(62466);
    return -1;
  }
  
  public static native int stopTraceCpuLoad(int paramInt);
  
  public static native long terminateApp(int paramInt, long paramLong);
  
  public boolean isConnect()
  {
    return connect;
  }
  
  public static abstract interface AnrCallback
  {
    public abstract void onANR(byte[] paramArrayOfByte);
  }
  
  public static abstract interface HCPerfManagerThread
  {
    public abstract Thread newThread(Runnable paramRunnable, String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderJNI
 * JD-Core Version:    0.7.0.1
 */