package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.j.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static long jRy = 0L;
  
  private static void a(final int paramInt, List<hv> paramList, m paramm)
  {
    AppMethodBeat.i(44696);
    if ((paramList.isEmpty()) || (paramm == null))
    {
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
      AppMethodBeat.o(44696);
      return;
    }
    ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    final egp localegp = new egp();
    localegp.HRA.addAll(paramList);
    paramList = new b.a();
    paramList.funcId = 1733;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
    paramList.hNM = localegp;
    paramList.hNN = new egq();
    IPCRunCgi.a(paramList.aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(44692);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof egq)))
        {
          paramAnonymousString = (egq)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousString.HRB != null) && (!paramAnonymousString.HRB.isEmpty()))
          {
            ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
            this.jRz.f(paramAnonymousString.HRB, localegp.HRA);
            AppMethodBeat.o(44692);
            return;
          }
          ad.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
          this.jRz.onFail(paramInt);
          AppMethodBeat.o(44692);
          return;
        }
        ad.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
        this.jRz.onFail(paramInt);
        AppMethodBeat.o(44692);
      }
    });
    AppMethodBeat.o(44696);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, m paramm)
  {
    AppMethodBeat.i(44695);
    if (bt.isNullOrNil(paramString2))
    {
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject1 = v.Nz(paramString2);
    if ((localObject1 != null) && (!((a)localObject1).jRu))
    {
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (!bt.isNullOrNil(paramString3))
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
      localObject1 = com.tencent.mm.vending.j.a.N(localObject1, localObject2);
      paramString3 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      localObject2 = (String)((c)localObject1).get(1);
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", new Object[] { paramString2, paramString3, localObject2, Integer.valueOf(paramInt2) });
      localObject1 = new hv();
      ((hv)localObject1).duW = paramString1;
      ((hv)localObject1).username = paramString2;
      ((hv)localObject1).FAq = 0;
      ((hv)localObject1).FAr = new clq();
      ((hv)localObject1).FAr.scene = paramInt2;
      if (g.ab(l.class) != null)
      {
        paramString2 = ((l)g.ab(l.class)).MJ(paramString2);
        if ((paramString2 == null) || (bt.isNullOrNil(paramString2.token))) {
          break label374;
        }
        ad.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) token:%s", new Object[] { ((hv)localObject1).username, paramString2.token });
        ((hv)localObject1).token = paramString2.token;
      }
      for (;;)
      {
        if (!bt.isNullOrNil(paramString3)) {
          ((hv)localObject1).FAr.path = paramString3;
        }
        if (!bt.isNullOrNil((String)localObject2)) {
          ((hv)localObject1).FAr.query = ((String)localObject2);
        }
        paramString1 = new LinkedList();
        paramString1.add(localObject1);
        a(0, paramString1, paramm);
        AppMethodBeat.o(44695);
        return;
        label374:
        ad.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, token is empty, appid:%s", new Object[] { paramString1 });
      }
      label392:
      localObject2 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  public static void bcR()
  {
    AppMethodBeat.i(44693);
    if (!ay.isWifi(aj.getContext()))
    {
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, not wifi network");
      AppMethodBeat.o(44693);
      return;
    }
    long l = cf.aCK();
    if (l - jRy < 900000L)
    {
      ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, too frequent");
      AppMethodBeat.o(44693);
      return;
    }
    jRy = l;
    com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44690);
        Object localObject = com.tencent.mm.plugin.appbrand.app.j.aYV().sb(200);
        if (((List)localObject).isEmpty())
        {
          ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, no recent apps");
          AppMethodBeat.o(44690);
          return;
        }
        ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, recent list size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        HashMap localHashMap = new HashMap();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
          if ((!localHashMap.containsKey(localLocalUsageInfo.username)) && (b.bk(localLocalUsageInfo.username, localLocalUsageInfo.hQh)))
          {
            localHashMap.put(localLocalUsageInfo.username, localLocalUsageInfo.appId);
            if (localHashMap.size() >= 20) {
              ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, batch list full");
            }
          }
        }
        if (!localHashMap.isEmpty())
        {
          b.a(localHashMap, new j());
          AppMethodBeat.o(44690);
          return;
        }
        ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, currently no app needs to update period data");
        AppMethodBeat.o(44690);
      }
    });
    AppMethodBeat.o(44693);
  }
  
  public static String cw(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44694);
    ad.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, userName:%s, appId:%s", new Object[] { paramString1, paramString2 });
    if (!ay.isWifi(aj.getContext()))
    {
      ad.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, not wifi network");
      AppMethodBeat.o(44694);
      return "fail:not wifi network";
    }
    if (g.ab(l.class) != null)
    {
      AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = ((l)g.ab(l.class)).MJ(paramString1);
      if ((localAppBrandBackgroundFetchDataTokenParcel == null) || (bt.isNullOrNil(localAppBrandBackgroundFetchDataTokenParcel.token)))
      {
        ad.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, app(%s) token is empty", new Object[] { paramString1 });
        AppMethodBeat.o(44694);
        return "fail:token not set";
      }
    }
    com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44691);
        HashMap localHashMap = new HashMap();
        localHashMap.put(this.fNT, paramString2);
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
    if ((paramAppBrandInitConfigWC != null) && (!bt.isNullOrNil(paramAppBrandInitConfigWC.appId)) && (!f.UF(paramAppBrandInitConfigWC.appId)))
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