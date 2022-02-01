package com.tencent.luggage.sdk.g;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.a.m;
import d.g.a.q;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"})
public final class c
{
  public static final c cqp;
  
  static
  {
    AppMethodBeat.i(135555);
    cqp = new c();
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
    if ((localObject instanceof c.a))
    {
      parama = ((c.a)localObject).Fs();
      bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label174;
      }
      ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
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
      ae.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama, q<? super R, ? super Long, ? super Long, z> paramq)
  {
    AppMethodBeat.i(208034);
    p.h(paramString, "logName");
    p.h(parama, "block");
    p.h(paramq, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof c.a))
    {
      parama = ((c.a)localObject).Fs();
      bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label177;
      }
      ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(208034);
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
      ae.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final String a(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(135554);
    Object localObject = (m)c.b.cqq;
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
    boolean bool = ag.Ck();
    l = SystemClock.elapsedRealtime() - l;
    if ((l > 32L) && (bool)) {
      ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135554);
      return "";
      ae.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + paramRunnable + " isMainThread: " + bool + ' ');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.c
 * JD-Core Version:    0.7.0.1
 */