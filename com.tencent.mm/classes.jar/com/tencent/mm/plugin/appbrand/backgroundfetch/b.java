package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b
{
  private static void a(int paramInt, List<gn> paramList, m paramm)
  {
    AppMethodBeat.i(129762);
    if ((paramList.isEmpty()) || (paramm == null))
    {
      ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
      AppMethodBeat.o(129762);
      return;
    }
    ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    dae localdae = new dae();
    localdae.ygL.addAll(paramList);
    paramList = new b.a();
    paramList.funcId = 1733;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
    paramList.fsX = localdae;
    paramList.fsY = new daf();
    com.tencent.mm.ipcinvoker.wx_extension.b.a(paramList.ado(), new b.2(paramm, localdae, paramInt));
    AppMethodBeat.o(129762);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, m paramm)
  {
    AppMethodBeat.i(143063);
    if (bo.isNullOrNil(paramString2))
    {
      ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
      AppMethodBeat.o(143063);
      return;
    }
    Object localObject1 = q.Al(paramString2);
    if ((localObject1 != null) && (!((a)localObject1).hdS))
    {
      ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(143063);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (!bo.isNullOrNil(paramString3))
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
      localObject1 = com.tencent.mm.vending.j.a.C(localObject1, localObject2);
      paramString3 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      localObject2 = (String)((c)localObject1).get(1);
      ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", new Object[] { paramString2, paramString3, localObject2, Integer.valueOf(paramInt2) });
      localObject1 = new gn();
      ((gn)localObject1).cwc = paramString1;
      ((gn)localObject1).username = paramString2;
      ((gn)localObject1).wsT = 0;
      ((gn)localObject1).wsU = new bnh();
      ((gn)localObject1).wsU.scene = paramInt2;
      if (com.tencent.mm.kernel.g.E(l.class) != null)
      {
        paramString2 = ((l)com.tencent.mm.kernel.g.E(l.class)).zz(paramString2);
        if ((paramString2 == null) || (bo.isNullOrNil(paramString2.token))) {
          break label374;
        }
        ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) token:%s", new Object[] { ((gn)localObject1).username, paramString2.token });
        ((gn)localObject1).token = paramString2.token;
      }
      for (;;)
      {
        if (!bo.isNullOrNil(paramString3)) {
          ((gn)localObject1).wsU.path = paramString3;
        }
        if (!bo.isNullOrNil((String)localObject2)) {
          ((gn)localObject1).wsU.query = ((String)localObject2);
        }
        paramString1 = new LinkedList();
        paramString1.add(localObject1);
        a(0, paramString1, paramm);
        AppMethodBeat.o(143063);
        return;
        label374:
        ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, token is empty, appid:%s", new Object[] { paramString1 });
      }
      label392:
      localObject2 = localObject3;
      continue;
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  public static boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(129764);
    if ((paramAppBrandInitConfigWC != null) && (!bo.isNullOrNil(paramAppBrandInitConfigWC.appId)) && (!com.tencent.mm.plugin.appbrand.task.h.EZ(paramAppBrandInitConfigWC.appId)))
    {
      AppMethodBeat.o(129764);
      return true;
    }
    AppMethodBeat.o(129764);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b
 * JD-Core Version:    0.7.0.1
 */