package com.tencent.mm.plugin.crashfix.jni;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

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
  private byte _hellAccFlag_;
  
  public static native void calculateOffset();
  
  public static Object execTransactBegin(Class paramClass, int paramInt)
  {
    AppMethodBeat.i(261555);
    paramClass = new a(paramClass, paramInt);
    mH.postDelayed(paramClass, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(261555);
    return paramClass;
  }
  
  public static void execTransactEnd(Object paramObject)
  {
    AppMethodBeat.i(261558);
    paramObject = (a)paramObject;
    mH.removeCallbacks(paramObject);
    long l = System.currentTimeMillis() - paramObject.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      h.OAn.p(1435L, 2L, 1L);
      String str = paramObject.clazz.getName() + "#" + paramObject.clazz.getGenericSuperclass() + "#" + paramObject.code;
      Log.e("MicroMsg.BadBinder", paramObject.hashCode() + "#exec_cost#" + l + "#" + str);
      h.OAn.b(20494, new Object[] { str, Long.valueOf(l) });
    }
    AppMethodBeat.o(261558);
  }
  
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(261521);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG("systemcrashprotect");
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/crashfix/jni/BinderProxyTransactNativeHook", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/crashfix/jni/BinderProxyTransactNativeHook", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    localObject1 = new HandlerThread("BadBinder");
    mBadBinderCheckHandlerThread = (HandlerThread)localObject1;
    ((HandlerThread)localObject1).start();
    mH = new Handler(mBadBinderCheckHandlerThread.getLooper());
    AppMethodBeat.o(261521);
  }
  
  public static Object onTransactNativeBegin()
  {
    AppMethodBeat.i(261540);
    b localb = new b();
    mH.postDelayed(localb, BAD_BINDER_TIME_OUT);
    AppMethodBeat.o(261540);
    return localb;
  }
  
  public static void onTransactNativeEnd(Object paramObject)
  {
    AppMethodBeat.i(261549);
    b localb = (b)paramObject;
    mH.removeCallbacks(localb);
    long l = System.currentTimeMillis() - localb.startTime;
    if (l > BAD_BINDER_TIME_OUT)
    {
      h.OAn.p(1435L, 1L, 1L);
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
    AppMethodBeat.o(261549);
  }
  
  static final class a
    implements Runnable
  {
    Class clazz;
    int code;
    long startTime;
    
    a(Class paramClass, int paramInt)
    {
      AppMethodBeat.i(261522);
      this.startTime = 0L;
      this.code = 0;
      this.clazz = paramClass;
      this.code = paramInt;
      this.startTime = System.currentTimeMillis();
      AppMethodBeat.o(261522);
    }
    
    public final void run()
    {
      AppMethodBeat.i(261529);
      Log.e("MicroMsg.BadBinder", hashCode() + "#exec_bad#" + this.clazz.getName() + "#" + this.clazz.getGenericSuperclass() + "#" + this.code);
      AppMethodBeat.o(261529);
    }
  }
  
  static final class b
    implements Runnable
  {
    long startTime;
    
    b()
    {
      AppMethodBeat.i(261507);
      this.startTime = 0L;
      this.startTime = System.currentTimeMillis();
      AppMethodBeat.o(261507);
    }
    
    public final void run()
    {
      AppMethodBeat.i(261515);
      Log.e("MicroMsg.BadBinder", hashCode() + "#send_bad#");
      AppMethodBeat.o(261515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.BinderProxyTransactNativeHook
 * JD-Core Version:    0.7.0.1
 */