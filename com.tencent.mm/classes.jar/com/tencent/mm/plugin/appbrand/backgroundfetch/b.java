package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.j.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static long jxC = 0L;
  
  private static void a(final int paramInt, List<ho> paramList, m paramm)
  {
    AppMethodBeat.i(44696);
    if ((paramList.isEmpty()) || (paramm == null))
    {
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
      AppMethodBeat.o(44696);
      return;
    }
    ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    final eal localeal = new eal();
    localeal.Ggn.addAll(paramList);
    paramList = new b.a();
    paramList.funcId = 1733;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
    paramList.hvt = localeal;
    paramList.hvu = new eam();
    IPCRunCgi.a(paramList.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(44692);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof eam)))
        {
          paramAnonymousString = (eam)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousString.Ggo != null) && (!paramAnonymousString.Ggo.isEmpty()))
          {
            ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
            this.jxD.f(paramAnonymousString.Ggo, localeal.Ggn);
            AppMethodBeat.o(44692);
            return;
          }
          ac.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
          this.jxD.onFail(paramInt);
          AppMethodBeat.o(44692);
          return;
        }
        ac.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
        this.jxD.onFail(paramInt);
        AppMethodBeat.o(44692);
      }
    });
    AppMethodBeat.o(44696);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, m paramm)
  {
    AppMethodBeat.i(44695);
    if (bs.isNullOrNil(paramString2))
    {
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject1 = u.Kg(paramString2);
    if ((localObject1 != null) && (!((a)localObject1).jxy))
    {
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (!bs.isNullOrNil(paramString3))
    {
      paramInt1 = paramString3.lastIndexOf('?');
      localObject2 = localObject3;
      localObject1 = paramString3;
      if (paramInt1 > 0)
      {
        localObject1 = paramString3.substring(0, paramInt1);
        if (paramInt1 >= paramString3.length() - 1) {
          break label392;
        }
        localObject2 = paramString3.substring(paramInt1 + 1);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.vending.j.a.L(localObject1, localObject2);
      paramString3 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      localObject2 = (String)((c)localObject1).get(1);
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", new Object[] { paramString2, paramString3, localObject2, Integer.valueOf(paramInt2) });
      localObject1 = new ho();
      ((ho)localObject1).djj = paramString1;
      ((ho)localObject1).username = paramString2;
      ((ho)localObject1).DUV = 0;
      ((ho)localObject1).DUW = new cgr();
      ((ho)localObject1).DUW.scene = paramInt2;
      if (g.ab(l.class) != null)
      {
        paramString2 = ((l)g.ab(l.class)).Jq(paramString2);
        if ((paramString2 == null) || (bs.isNullOrNil(paramString2.token))) {
          break label374;
        }
        ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) token:%s", new Object[] { ((ho)localObject1).username, paramString2.token });
        ((ho)localObject1).token = paramString2.token;
      }
      for (;;)
      {
        if (!bs.isNullOrNil(paramString3)) {
          ((ho)localObject1).DUW.path = paramString3;
        }
        if (!bs.isNullOrNil((String)localObject2)) {
          ((ho)localObject1).DUW.query = ((String)localObject2);
        }
        paramString1 = new LinkedList();
        paramString1.add(localObject1);
        a(0, paramString1, paramm);
        AppMethodBeat.o(44695);
        return;
        label374:
        ac.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, token is empty, appid:%s", new Object[] { paramString1 });
      }
      label392:
      localObject2 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  public static void aZt()
  {
    AppMethodBeat.i(44693);
    if (!ax.isWifi(ai.getContext()))
    {
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, not wifi network");
      AppMethodBeat.o(44693);
      return;
    }
    long l = ce.azH();
    if (l - jxC < 900000L)
    {
      ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, too frequent");
      AppMethodBeat.o(44693);
      return;
    }
    jxC = l;
    com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44690);
        Object localObject = com.tencent.mm.plugin.appbrand.app.j.aVA().rB(200);
        if (((List)localObject).isEmpty())
        {
          ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, no recent apps");
          AppMethodBeat.o(44690);
          return;
        }
        ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, recent list size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        HashMap localHashMap = new HashMap();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
          if ((!localHashMap.containsKey(localLocalUsageInfo.username)) && (b.bi(localLocalUsageInfo.username, localLocalUsageInfo.hxM)))
          {
            localHashMap.put(localLocalUsageInfo.username, localLocalUsageInfo.appId);
            if (localHashMap.size() >= 20) {
              ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, batch list full");
            }
          }
        }
        if (!localHashMap.isEmpty())
        {
          b.a(localHashMap, new j());
          AppMethodBeat.o(44690);
          return;
        }
        ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, currently no app needs to update period data");
        AppMethodBeat.o(44690);
      }
    });
    AppMethodBeat.o(44693);
  }
  
  public static String cu(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44694);
    ac.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, userName:%s, appId:%s", new Object[] { paramString1, paramString2 });
    if (!ax.isWifi(ai.getContext()))
    {
      ac.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, not wifi network");
      AppMethodBeat.o(44694);
      return "fail:not wifi network";
    }
    if (g.ab(l.class) != null)
    {
      AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = ((l)g.ab(l.class)).Jq(paramString1);
      if ((localAppBrandBackgroundFetchDataTokenParcel == null) || (bs.isNullOrNil(localAppBrandBackgroundFetchDataTokenParcel.token)))
      {
        ac.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, app(%s) token is empty", new Object[] { paramString1 });
        AppMethodBeat.o(44694);
        return "fail:token not set";
      }
    }
    com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44691);
        HashMap localHashMap = new HashMap();
        localHashMap.put(this.hyc, paramString2);
        b.a(localHashMap, new j());
        AppMethodBeat.o(44691);
      }
    });
    AppMethodBeat.o(44694);
    return "ok";
  }
  
  public static boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(44697);
    if ((paramAppBrandInitConfigWC != null) && (!bs.isNullOrNil(paramAppBrandInitConfigWC.appId)) && (!f.QZ(paramAppBrandInitConfigWC.appId)))
    {
      AppMethodBeat.o(44697);
      return true;
    }
    AppMethodBeat.o(44697);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b
 * JD-Core Version:    0.7.0.1
 */