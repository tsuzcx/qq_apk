package com.tencent.luggage.sdk.g;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"})
public final class c
{
  public static final c cCI;
  
  static
  {
    AppMethodBeat.i(135555);
    cCI = new c();
    AppMethodBeat.o(135555);
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama)
  {
    AppMethodBeat.i(135553);
    p.h(paramString, "logName");
    p.h(parama, "block");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).Pb();
      bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label174;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135553);
      return localObject;
      if (localObject != null)
      {
        String str = localObject.toString();
        parama = str;
        if (str != null) {
          break;
        }
      }
      parama = "";
      break;
      label174:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama, q<? super R, ? super Long, ? super Long, x> paramq)
  {
    AppMethodBeat.i(219641);
    p.h(paramString, "logName");
    p.h(parama, "block");
    p.h(paramq, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).Pb();
      bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label177;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(219641);
      return localObject;
      if (localObject != null)
      {
        paramq = localObject.toString();
        parama = paramq;
        if (paramq != null) {
          break;
        }
      }
      parama = "";
      break;
      label177:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final String a(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(135554);
    Object localObject = (m)c.b.cCJ;
    p.h(paramString, "logName");
    p.h(paramRunnable, "run");
    p.h(localObject, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    paramRunnable.run();
    localObject = "".toString();
    paramRunnable = (Runnable)localObject;
    if (localObject == null) {
      paramRunnable = "";
    }
    boolean bool = ag.LB();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32L) && (bool)) {
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135554);
      return "";
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile$ProfileReturnObject;", "", "runProfiledToString", "", "luggage-wxa-app_release"})
  public static abstract interface a
  {
    public abstract String Pb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.c
 * JD-Core Version:    0.7.0.1
 */