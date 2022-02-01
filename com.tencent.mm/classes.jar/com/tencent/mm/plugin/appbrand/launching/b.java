package com.tencent.mm.plugin.appbrand.launching;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchBeforeLaunchLogic;", "", "()V", "CGI_COUNT_MAX", "", "CGI_ID", "CGI_TIME_OUT_MS", "", "CGI_URL", "", "TAG", "tasksStorage", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchTask;", "call", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "fetchType", "userName", "versionType", "reqData", "", "findAndRemoveTaskAtomic", "prefetchType", "instanceId", "findTask", "prefetch", "", "cgiPrefetchTypes", "releaseByInstanceId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b sVC;
  private static final CopyOnWriteArrayList<c> sVD;
  
  static
  {
    AppMethodBeat.i(320777);
    sVC = new b();
    sVD = new CopyOnWriteArrayList();
    AppMethodBeat.o(320777);
  }
  
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(320760);
    s.u(paramString1, "instanceId");
    s.u(paramString2, "userName");
    s.u(paramArrayOfByte, "cgiPrefetchTypes");
    Object localObject;
    if (paramArrayOfByte.length == 0)
    {
      i = 1;
      if (i != 0) {
        Log.i("MicroMsg.AppBrandCgiPrefetchBeforeLaunch", "prefetch: empty types");
      }
      localObject = (Collection)new ArrayList(paramArrayOfByte.length);
      int j = paramArrayOfByte.length;
      i = 0;
      label64:
      if (i >= j) {
        break label116;
      }
      if (paramArrayOfByte[i] != 1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      ((Collection)localObject).add(Boolean.valueOf(bool));
      i += 1;
      break label64;
      i = 0;
      break;
    }
    label116:
    paramArrayOfByte = ((Iterable)localObject).iterator();
    int i = 0;
    while (paramArrayOfByte.hasNext())
    {
      localObject = paramArrayOfByte.next();
      if (i < 0) {
        p.kkW();
      }
      if (((Boolean)localObject).booleanValue())
      {
        localObject = h.ahAA.g(new b..ExternalSyntheticLambda0(i, paramString2, paramInt));
        long l = SystemClock.elapsedRealtime();
        s.s(localObject, "future");
        localObject = new c(paramString1, paramString2, paramInt, i, l, (com.tencent.threadpool.i.d)localObject);
        sVD.add(localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(320760);
  }
  
  public static void acS(String paramString)
  {
    AppMethodBeat.i(320765);
    s.u(paramString, "instanceId");
    Object localObject2 = (Iterable)sVD;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (s.p(((c)localObject3).eup, paramString)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    paramString = (List)localObject1;
    localObject2 = (Iterable)paramString;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((c)((Iterator)localObject2).next()).sVE);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.threadpool.i.d)((Iterator)localObject1).next()).cancel(true);
    }
    sVD.removeAll((Collection)paramString);
    Log.i("MicroMsg.AppBrandCgiPrefetchBeforeLaunch", s.X("releaseByInstanceId: remaining size = ", Integer.valueOf(sVD.size())));
    AppMethodBeat.o(320765);
  }
  
  private static final AppBrandCgiPrefetchedResp l(int paramInt1, String paramString, int paramInt2)
  {
    int i = -1;
    AppMethodBeat.i(320773);
    s.u(paramString, "$userName");
    Object localObject1 = com.tencent.luggage.sdk.h.d.evM;
    long l = SystemClock.elapsedRealtime();
    Object localObject2;
    boolean bool;
    if ((paramInt1 < 0) || (paramInt1 >= 32))
    {
      paramString = new AppBrandCgiPrefetchedResp("", -1, "");
      localObject2 = paramString.toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label632;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "MicroMsg.AppBrandCgiPrefetchBeforeLaunch|call" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      AppMethodBeat.o(320773);
      return paramString;
      localObject1 = new c.a();
      ((c.a)localObject1).otE = ((a)new aea());
      ((c.a)localObject1).otF = ((a)new aeb());
      ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxabusiness/coldstartfetchdata";
      ((c.a)localObject1).funcId = 4024;
      ((c.a)localObject1).otG = 0;
      ((c.a)localObject1).respCmdId = 0;
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
      if (localObject2 == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ColdStartFetchDataRequest");
        AppMethodBeat.o(320773);
        throw paramString;
      }
      localObject2 = (aea)localObject2;
      ((aea)localObject2).username = paramString;
      ((aea)localObject2).Tqb = paramInt2;
      ((aea)localObject2).YKE = paramInt1;
      localObject1 = aa.a((com.tencent.mm.am.c)localObject1, 10000L);
      if ((localObject1 != null) && (((b.a)localObject1).errType == 0))
      {
        paramInt1 = 1;
        label332:
        if ((paramInt1 == 0) || (((b.a)localObject1).errCode != 0)) {
          break label499;
        }
        paramString = (aeb)((b.a)localObject1).ott;
        if (paramString == null) {
          break label436;
        }
        paramString = paramString.BaseResponse;
        if ((paramString == null) || (paramString.Idd != 0)) {
          break label436;
        }
        paramInt1 = 1;
        label375:
        if (paramInt1 == 0) {
          break label499;
        }
        paramString = (aeb)((b.a)localObject1).ott;
        if (paramString != null) {
          break label441;
        }
        paramString = null;
        label394:
        localObject2 = String.valueOf(paramString);
        paramString = (aeb)((b.a)localObject1).ott;
        if (paramString != null) {
          break label449;
        }
        paramString = "";
      }
      for (;;)
      {
        paramString = new AppBrandCgiPrefetchedResp((String)localObject2, 0, paramString);
        break;
        paramInt1 = 0;
        break label332;
        label436:
        paramInt1 = 0;
        break label375;
        label441:
        paramString = paramString.Zmi;
        break label394;
        label449:
        paramString = paramString.getBaseResponse();
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          paramString = paramString.akjO;
          if (paramString == null)
          {
            paramString = "";
          }
          else
          {
            localObject1 = paramString.abwM;
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
          }
        }
      }
      label499:
      if (localObject1 == null)
      {
        paramInt1 = i;
        label506:
        if (localObject1 != null) {
          break label563;
        }
        paramString = "";
      }
      for (;;)
      {
        paramString = new AppBrandCgiPrefetchedResp("", paramInt1, paramString);
        break;
        paramString = (aeb)((b.a)localObject1).ott;
        paramInt1 = i;
        if (paramString == null) {
          break label506;
        }
        paramString = paramString.getBaseResponse();
        paramInt1 = i;
        if (paramString == null) {
          break label506;
        }
        paramInt1 = paramString.Idd;
        break label506;
        label563:
        paramString = (aeb)((b.a)localObject1).ott;
        if (paramString == null)
        {
          paramString = "";
        }
        else
        {
          paramString = paramString.getBaseResponse();
          if (paramString == null)
          {
            paramString = "";
          }
          else
          {
            paramString = paramString.akjO;
            if (paramString == null)
            {
              paramString = "";
            }
            else
            {
              localObject1 = paramString.abwM;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                paramString = "";
              }
            }
          }
        }
      }
      label632:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "MicroMsg.AppBrandCgiPrefetchBeforeLaunch|call" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
    }
  }
  
  public final c aB(int paramInt, String paramString)
  {
    Collection localCollection;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(320783);
        s.u(paramString, "instanceId");
        s.u(paramString, "instanceId");
        Object localObject1 = (Iterable)sVD;
        localCollection = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        c localc = (c)localObject2;
        int i;
        if ((localc.sVB == paramInt) && (s.p(localc.eup, paramString)))
        {
          i = 1;
          if (i != 0) {
            localCollection.add(localObject2);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
    paramString = (List)localCollection;
    if (!((Collection)paramString).isEmpty())
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label187;
      }
    }
    label187:
    for (paramString = (c)paramString.get(0);; paramString = null)
    {
      if (paramString != null) {
        sVD.remove(paramString);
      }
      AppMethodBeat.o(320783);
      return paramString;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b
 * JD-Core Version:    0.7.0.1
 */