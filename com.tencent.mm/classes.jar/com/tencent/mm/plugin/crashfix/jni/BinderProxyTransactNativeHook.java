package com.tencent.mm.plugin.crashfix.jni;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
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
    AppMethodBeat.i(256617);
    paramClass = new a(paramClass, paramInt);
    mH.postDelayed(paramClass, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(256617);
    return paramClass;
  }
  
  @Keep
  public static void execTransactEnd(Object paramObject)
  {
    AppMethodBeat.i(256620);
    paramObject = (a)paramObject;
    mH.removeCallbacks(paramObject);
    long l = System.currentTimeMillis() - paramObject.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      h.IzE.p(1435L, 2L, 1L);
      String str = paramObject.aFS.getName() + "#" + paramObject.aFS.getGenericSuperclass() + "#" + paramObject.code;
      Log.e("MicroMsg.BadBinder", paramObject.hashCode() + "#exec_cost#" + l + "#" + str);
      h.IzE.a(20494, new Object[] { str, Long.valueOf(l) });
    }
    AppMethodBeat.o(256620);
  }
  
  @Keep
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(256611);
    System.loadLibrary("systemcrashprotect");
    HandlerThread localHandlerThread = new HandlerThread("BadBinder");
    mBadBinderCheckHandlerThread = localHandlerThread;
    localHandlerThread.start();
    mH = new Handler(mBadBinderCheckHandlerThread.getLooper());
    AppMethodBeat.o(256611);
  }
  
  @Keep
  public static Object onTransactNativeBegin()
  {
    AppMethodBeat.i(256615);
    BinderProxyTransactNativeHook.b localb = new BinderProxyTransactNativeHook.b();
    mH.postDelayed(localb, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(256615);
    return localb;
  }
  
  @Keep
  public static void onTransactNativeEnd(Object paramObject)
  {
    AppMethodBeat.i(256616);
    BinderProxyTransactNativeHook.b localb = (BinderProxyTransactNativeHook.b)paramObject;
    mH.removeCallbacks(localb);
    long l = System.currentTimeMillis() - localb.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      h.IzE.p(1435L, 1L, 1L);
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
      Log.e("MicroMsg.BadBinder", localb.hashCode() + "#send_cost#" + l + "#" + localObject);
    }
    AppMethodBeat.o(256616);
  }
  
  static final class a
    implements Runnable
  {
    Class aFS;
    int code;
    long startTime;
    
    a(Class paramClass, int paramInt)
    {
      AppMethodBeat.i(256682);
      this.startTime = 0L;
      this.code = 0;
      this.aFS = paramClass;
      this.code = paramInt;
      this.startTime = System.currentTimeMillis();
      AppMethodBeat.o(256682);
    }
    
    public final void run()
    {
      AppMethodBeat.i(256684);
      Log.e("MicroMsg.BadBinder", hashCode() + "#exec_bad#" + this.aFS.getName() + "#" + this.aFS.getGenericSuperclass() + "#" + this.code);
      AppMethodBeat.o(256684);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook
 * JD-Core Version:    0.7.0.1
 */