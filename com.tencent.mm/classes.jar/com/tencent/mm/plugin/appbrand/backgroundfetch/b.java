package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.protocal.c.cmn;
import com.tencent.mm.protocal.c.cmo;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  public static void a(int paramInt, List<fe> paramList, i parami)
  {
    if ((paramList.isEmpty()) || (parami == null))
    {
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "batchFetchDataInternal, requestList or callback is null");
      return;
    }
    y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "batchFetchDataInternal, size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    cmn localcmn = new cmn();
    localcmn.tZp.addAll(paramList);
    paramList = new b.a();
    paramList.ecG = 1733;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
    paramList.ecH = localcmn;
    paramList.ecI = new cmo();
    com.tencent.mm.ipcinvoker.wx_extension.b.a(paramList.Kt(), new b.2(parami, localcmn, paramInt));
  }
  
  public static boolean ay(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return ((af)g.r(af.class)).ap(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b
 * JD-Core Version:    0.7.0.1
 */