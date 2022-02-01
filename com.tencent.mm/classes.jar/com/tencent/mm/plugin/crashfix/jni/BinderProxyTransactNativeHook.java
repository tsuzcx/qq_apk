package com.tencent.mm.plugin.crashfix.jni;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(187000);
    paramClass = new a(paramClass, paramInt);
    mH.postDelayed(paramClass, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(187000);
    return paramClass;
  }
  
  @Keep
  public static void execTransactEnd(Object paramObject)
  {
    AppMethodBeat.i(187001);
    paramObject = (a)paramObject;
    mH.removeCallbacks(paramObject);
    long l = System.currentTimeMillis() - paramObject.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      g.yhR.n(1435L, 2L, 1L);
      String str = paramObject.aWK.getName() + "#" + paramObject.aWK.getGenericSuperclass() + "#" + paramObject.code;
      ad.e("MicroMsg.BadBinder", paramObject.hashCode() + "#exec_cost#" + l + "#" + str);
      g.yhR.f(20494, new Object[] { str, Long.valueOf(l) });
    }
    AppMethodBeat.o(187001);
  }
  
  @Keep
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(186997);
    System.loadLibrary("systemcrashprotect");
    HandlerThread localHandlerThread = new HandlerThread("BadBinder");
    mBadBinderCheckHandlerThread = localHandlerThread;
    localHandlerThread.start();
    mH = new Handler(mBadBinderCheckHandlerThread.getLooper());
    AppMethodBeat.o(186997);
  }
  
  @Keep
  public static Object onTransactNativeBegin()
  {
    AppMethodBeat.i(186998);
    BinderProxyTransactNativeHook.b localb = new BinderProxyTransactNativeHook.b();
    mH.postDelayed(localb, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(186998);
    return localb;
  }
  
  @Keep
  public static void onTransactNativeEnd(Object paramObject)
  {
    AppMethodBeat.i(186999);
    BinderProxyTransactNativeHook.b localb = (BinderProxyTransactNativeHook.b)paramObject;
    mH.removeCallbacks(localb);
    long l = System.currentTimeMillis() - localb.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      g.yhR.n(1435L, 1L, 1L);
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
      ad.e("MicroMsg.BadBinder", localb.hashCode() + "#send_cost#" + l + "#" + localObject);
    }
    AppMethodBeat.o(186999);
  }
  
  static final class a
    implements Runnable
  {
    Class aWK;
    int code;
    long startTime;
    
    a(Class paramClass, int paramInt)
    {
      AppMethodBeat.i(186993);
      this.startTime = 0L;
      this.code = 0;
      this.aWK = paramClass;
      this.code = paramInt;
      this.startTime = System.currentTimeMillis();
      AppMethodBeat.o(186993);
    }
    
    public final void run()
    {
      AppMethodBeat.i(186994);
      ad.e("MicroMsg.BadBinder", hashCode() + "#exec_bad#" + this.aWK.getName() + "#" + this.aWK.getGenericSuperclass() + "#" + this.code);
      AppMethodBeat.o(186994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook
 * JD-Core Version:    0.7.0.1
 */