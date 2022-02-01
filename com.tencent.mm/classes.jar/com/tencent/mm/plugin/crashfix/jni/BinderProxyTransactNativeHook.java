package com.tencent.mm.plugin.crashfix.jni;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Method;

@Keep
public class BinderProxyTransactNativeHook
{
  private static long BAD_BINDER_TIME_OUT = 1000L;
  private static final int IDKEY_BAD_BINDER_MONITOR = 1435;
  private static final int ID_CLIENT_1S_KEY = 1;
  private static final int ID_KV_BAD_BINDER_MONITOR = 20494;
  private static final int ID_SERVER_1S_KEY = 2;
  private static final String TAG = "MicroMsg.BadBinder";
  private static HandlerThread mBadBinderCheckHandlerThread;
  private static Handler mH;
  
  @Keep
  public static native void calculateOffset();
  
  @Keep
  public static Object execTransactBegin(Class paramClass, int paramInt)
  {
    AppMethodBeat.i(190273);
    paramClass = new a(paramClass, paramInt);
    mH.postDelayed(paramClass, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(190273);
    return paramClass;
  }
  
  @Keep
  public static void execTransactEnd(Object paramObject)
  {
    AppMethodBeat.i(190274);
    paramObject = (a)paramObject;
    mH.removeCallbacks(paramObject);
    long l = System.currentTimeMillis() - paramObject.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      g.yxI.n(1435L, 2L, 1L);
      String str = paramObject.aWK.getName() + "#" + paramObject.aWK.getGenericSuperclass() + "#" + paramObject.code;
      ae.e("MicroMsg.BadBinder", paramObject.hashCode() + "#exec_cost#" + l + "#" + str);
      g.yxI.f(20494, new Object[] { str, Long.valueOf(l) });
    }
    AppMethodBeat.o(190274);
  }
  
  @Keep
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(190270);
    System.loadLibrary("systemcrashprotect");
    HandlerThread localHandlerThread = new HandlerThread("BadBinder");
    mBadBinderCheckHandlerThread = localHandlerThread;
    localHandlerThread.start();
    mH = new Handler(mBadBinderCheckHandlerThread.getLooper());
    AppMethodBeat.o(190270);
  }
  
  @Keep
  public static Object onTransactNativeBegin()
  {
    AppMethodBeat.i(190271);
    BinderProxyTransactNativeHook.b localb = new BinderProxyTransactNativeHook.b();
    mH.postDelayed(localb, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(190271);
    return localb;
  }
  
  @Keep
  public static void onTransactNativeEnd(Object paramObject)
  {
    AppMethodBeat.i(190272);
    BinderProxyTransactNativeHook.b localb = (BinderProxyTransactNativeHook.b)paramObject;
    mH.removeCallbacks(localb);
    long l = System.currentTimeMillis() - localb.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      g.yxI.n(1435L, 1L, 1L);
      paramObject = "";
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      Object localObject = paramObject;
      if (arrayOfStackTraceElement != null)
      {
        int i = 0;
        localObject = paramObject;
        if (i < arrayOfStackTraceElement.length)
        {
          if (TextUtils.isEmpty(paramObject)) {}
          for (paramObject = arrayOfStackTraceElement[i].toString();; paramObject = paramObject + "\n" + arrayOfStackTraceElement[i].toString())
          {
            i += 1;
            break;
          }
        }
      }
      ae.e("MicroMsg.BadBinder", localb.hashCode() + "#send_cost#" + l + "#" + localObject);
    }
    AppMethodBeat.o(190272);
  }
  
  static final class a
    implements Runnable
  {
    Class aWK;
    int code;
    long startTime;
    
    a(Class paramClass, int paramInt)
    {
      AppMethodBeat.i(190266);
      this.startTime = 0L;
      this.code = 0;
      this.aWK = paramClass;
      this.code = paramInt;
      this.startTime = System.currentTimeMillis();
      AppMethodBeat.o(190266);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190267);
      ae.e("MicroMsg.BadBinder", hashCode() + "#exec_bad#" + this.aWK.getName() + "#" + this.aWK.getGenericSuperclass() + "#" + this.code);
      AppMethodBeat.o(190267);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook
 * JD-Core Version:    0.7.0.1
 */