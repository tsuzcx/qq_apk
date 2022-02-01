package com.tencent.luggage.sdk.h;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d evM;
  
  static
  {
    AppMethodBeat.i(135555);
    evM = new d();
    AppMethodBeat.o(135555);
  }
  
  public static final <R> R a(String paramString, a<? extends R> parama, q<? super R, ? super Long, ? super Long, ah> paramq)
  {
    AppMethodBeat.i(220576);
    s.u(paramString, "logName");
    s.u(parama, "block");
    s.u(paramq, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).asQ();
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label183;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(220576);
      return localObject;
      if (localObject == null)
      {
        parama = "";
        break;
      }
      paramq = localObject.toString();
      parama = paramq;
      if (paramq != null) {
        break;
      }
      parama = "";
      break;
      label183:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  public static final String a(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(135554);
    s.u(paramString, "logName");
    s.u(paramRunnable, "run");
    Object localObject = (m)b.evN;
    s.u(paramString, "logName");
    s.u(paramRunnable, "run");
    s.u(localObject, "profileFunc");
    long l = SystemClock.elapsedRealtime();
    paramRunnable.run();
    localObject = "".toString();
    paramRunnable = (Runnable)localObject;
    if (localObject == null) {
      paramRunnable = "";
    }
    boolean bool = ao.aoz();
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
  
  public static final <R> R b(String paramString, a<? extends R> parama)
  {
    AppMethodBeat.i(135553);
    s.u(paramString, "logName");
    s.u(parama, "block");
    long l = SystemClock.elapsedRealtime();
    Object localObject = parama.invoke();
    boolean bool;
    if ((localObject instanceof a))
    {
      parama = ((a)localObject).asQ();
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label180;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(135553);
      return localObject;
      if (localObject == null)
      {
        parama = "";
        break;
      }
      String str = localObject.toString();
      parama = str;
      if (str != null) {
        break;
      }
      parama = "";
      break;
      label180:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + paramString + " cost " + l + " ms result:" + parama + " isMainThread: " + bool + ' ');
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/Profile$ProfileReturnObject;", "", "runProfiledToString", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract String asQ();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Long, Long, ah>
  {
    public static final b evN;
    
    static
    {
      AppMethodBeat.i(220558);
      evN = new b();
      AppMethodBeat.o(220558);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.h.d
 * JD-Core Version:    0.7.0.1
 */