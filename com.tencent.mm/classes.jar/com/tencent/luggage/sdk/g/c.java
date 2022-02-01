package com.tencent.luggage.sdk.g;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"})
public final class c
{
  public static final c ciA;
  
  static
  {
    AppMethodBeat.i(135555);
    ciA = new c();
    AppMethodBeat.o(135555);
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama)
  {
    AppMethodBeat.i(135553);
    k.h(paramString, "logName");
    k.h(parama, "block");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof c.a))
    {
      parama = ((c.a)localObject).El();
      bool = aa.Be();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label174;
      }
      ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
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
      ad.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama, q<? super R, ? super Long, ? super Long, y> paramq)
  {
    AppMethodBeat.i(194353);
    k.h(paramString, "logName");
    k.h(parama, "block");
    k.h(paramq, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof c.a))
    {
      parama = ((c.a)localObject).El();
      bool = aa.Be();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label177;
      }
      ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(194353);
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
      ad.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final String a(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(135554);
    Object localObject = (m)c.b.ciB;
    k.h(paramString, "logName");
    k.h(paramRunnable, "run");
    k.h(localObject, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    paramRunnable.run();
    localObject = "".toString();
    paramRunnable = (Runnable)localObject;
    if (localObject == null) {
      paramRunnable = "";
    }
    boolean bool = aa.Be();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32L) && (bool)) {
      ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135554);
      return "";
      ad.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.c
 * JD-Core Version:    0.7.0.1
 */