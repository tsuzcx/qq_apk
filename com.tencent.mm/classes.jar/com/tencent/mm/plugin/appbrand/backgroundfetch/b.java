package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.gky;
import com.tencent.mm.protocal.protobuf.gkz;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static long qRI = 0L;
  
  private static void a(final int paramInt, List<it> paramList, m paramm)
  {
    AppMethodBeat.i(44696);
    if ((paramList.isEmpty()) || (paramm == null))
    {
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
      AppMethodBeat.o(44696);
      return;
    }
    Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    final gky localgky = new gky();
    localgky.acgI.addAll(paramList);
    paramList = new c.a();
    paramList.funcId = 1733;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
    paramList.otE = localgky;
    paramList.otF = new gkz();
    IPCRunCgi.a(paramList.bEF(), new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(44692);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousc != null) && (c.c.b(paramAnonymousc.otC) != null) && ((c.c.b(paramAnonymousc.otC) instanceof gkz)))
        {
          paramAnonymousString = (gkz)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousString.acgJ != null) && (!paramAnonymousString.acgJ.isEmpty()))
          {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
            b.this.m(paramAnonymousString.acgJ, localgky.acgI);
            AppMethodBeat.o(44692);
            return;
          }
          Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
          b.this.onFail(paramInt);
          AppMethodBeat.o(44692);
          return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
        b.this.onFail(paramInt);
        AppMethodBeat.o(44692);
      }
    });
    AppMethodBeat.o(44696);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, m paramm)
  {
    AppMethodBeat.i(44695);
    if (Util.isNullOrNil(paramString2))
    {
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject1 = ad.XF(paramString2);
    if ((localObject1 != null) && (!((a)localObject1).qRE))
    {
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(44695);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (!Util.isNullOrNil(paramString3))
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
      localObject1 = com.tencent.mm.vending.j.a.U(localObject1, localObject2);
      paramString3 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      localObject2 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", new Object[] { paramString2, paramString3, localObject2, Integer.valueOf(paramInt2) });
      localObject1 = new it();
      ((it)localObject1).appid = paramString1;
      ((it)localObject1).username = paramString2;
      ((it)localObject1).YKE = 0;
      ((it)localObject1).YKF = new egc();
      ((it)localObject1).YKF.scene = paramInt2;
      if (h.ax(l.class) != null)
      {
        paramString2 = ((l)h.ax(l.class)).WN(paramString2);
        if ((paramString2 == null) || (Util.isNullOrNil(paramString2.token))) {
          break label374;
        }
        Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) token:%s", new Object[] { ((it)localObject1).username, paramString2.token });
        ((it)localObject1).token = paramString2.token;
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramString3)) {
          ((it)localObject1).YKF.path = paramString3;
        }
        if (!Util.isNullOrNil((String)localObject2)) {
          ((it)localObject1).YKF.query = ((String)localObject2);
        }
        paramString1 = new LinkedList();
        paramString1.add(localObject1);
        a(0, paramString1, paramm);
        AppMethodBeat.o(44695);
        return;
        label374:
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, token is empty, appid:%s", new Object[] { paramString1 });
      }
      label392:
      localObject2 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  public static void cjD()
  {
    AppMethodBeat.i(44693);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, not wifi network");
      AppMethodBeat.o(44693);
      return;
    }
    long l = cn.bDu();
    if (l - qRI < 900000L)
    {
      Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, too frequent");
      AppMethodBeat.o(44693);
      return;
    }
    qRI = l;
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44690);
        try
        {
          localObject = n.cfk().zx(200);
          if (((List)localObject).isEmpty())
          {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, no recent apps");
            AppMethodBeat.o(44690);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", localException, "periodFetchDataWhenAppEnterForeground, getHistories error.", new Object[0]);
          AppMethodBeat.o(44690);
          return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, recent list size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        HashMap localHashMap = new HashMap();
        Object localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
          if ((!localHashMap.containsKey(localLocalUsageInfo.username)) && (b.cd(localLocalUsageInfo.username, localLocalUsageInfo.euz)))
          {
            localHashMap.put(localLocalUsageInfo.username, localLocalUsageInfo.appId);
            if (localHashMap.size() >= 20) {
              Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, batch list full");
            }
          }
        }
        if (!localHashMap.isEmpty())
        {
          b.a(localHashMap, new j());
          AppMethodBeat.o(44690);
          return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, currently no app needs to update period data");
        AppMethodBeat.o(44690);
      }
    });
    AppMethodBeat.o(44693);
  }
  
  public static String dm(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(44694);
    Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, userName:%s, appId:%s", new Object[] { paramString1, paramString2 });
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, not wifi network");
      AppMethodBeat.o(44694);
      return "fail:not wifi network";
    }
    if (h.ax(l.class) != null)
    {
      AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = ((l)h.ax(l.class)).WN(paramString1);
      if ((localAppBrandBackgroundFetchDataTokenParcel == null) || (Util.isNullOrNil(localAppBrandBackgroundFetchDataTokenParcel.token)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, app(%s) token is empty", new Object[] { paramString1 });
        AppMethodBeat.o(44694);
        return "fail:token not set";
      }
    }
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44691);
        HashMap localHashMap = new HashMap();
        localHashMap.put(b.this, paramString2);
        b.a(localHashMap, new j());
        AppMethodBeat.o(44691);
      }
    });
    AppMethodBeat.o(44694);
    return "ok";
  }
  
  public static boolean f(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(44697);
    if ((paramAppBrandInitConfigWC != null) && (!Util.isNullOrNil(paramAppBrandInitConfigWC.appId)) && (!i.cJV().fA(paramAppBrandInitConfigWC.appId)))
    {
      AppMethodBeat.o(44697);
      return true;
    }
    AppMethodBeat.o(44697);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b
 * JD-Core Version:    0.7.0.1
 */