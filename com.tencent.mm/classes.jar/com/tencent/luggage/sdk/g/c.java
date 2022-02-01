package com.tencent.luggage.sdk.g;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"})
public final class c
{
  public static final c cfw;
  
  static
  {
    AppMethodBeat.i(135555);
    cfw = new c();
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
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).DO();
      bool = ab.AI();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label174;
      }
      ac.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
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
      ac.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama, q<? super R, ? super Long, ? super Long, y> paramq)
  {
    AppMethodBeat.i(193263);
    k.h(paramString, "logName");
    k.h(parama, "block");
    k.h(paramq, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).DO();
      bool = ab.AI();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label177;
      }
      ac.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(193263);
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
      ac.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final String a(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(135554);
    Object localObject = (m)c.b.cfx;
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
    boolean bool = ab.AI();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32L) && (bool)) {
      ac.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135554);
      return "";
      ac.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile$ProfileReturnObject;", "", "runProfiledToString", "", "luggage-wxa-app_release"})
  public static abstract interface a
  {
    public abstract String DO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.c
 * JD-Core Version:    0.7.0.1
 */