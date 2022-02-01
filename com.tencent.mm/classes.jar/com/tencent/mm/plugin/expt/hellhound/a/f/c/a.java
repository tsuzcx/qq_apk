package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
{
  public static void WO(String paramString)
  {
    AppMethodBeat.i(122120);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122120);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_async_biz_dao".concat(String.valueOf(i)), str);
      AppMethodBeat.o(122120);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("AsyncBizDao", paramString, "habbyge-mali, AsyncBizDao._write crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(122120);
    }
  }
  
  private static void a(gk paramgk)
  {
    AppMethodBeat.i(122126);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122126);
      return;
    }
    try
    {
      paramgk = paramgk.toByteArray();
      Object localObject = paramgk;
      if (paramgk == null) {}
      return;
    }
    catch (IOException paramgk)
    {
      try
      {
        localObject = new byte[0];
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_async_bizid_sid".concat(String.valueOf(i)), (byte[])localObject);
        AppMethodBeat.o(122126);
        return;
      }
      catch (Exception paramgk)
      {
        ad.printErrStackTrace("AsyncBizDao", paramgk, "habbyge-mali, AsyncBizDao._writeBizId crash: %s", new Object[] { paramgk.getMessage() });
        AppMethodBeat.o(122126);
      }
      paramgk = paramgk;
      ad.printErrStackTrace("AsyncBizDao", paramgk, "AsyncBizDao, putBizIdOfCloudConfig, crash: %s", new Object[] { paramgk.getMessage() });
      AppMethodBeat.o(122126);
      return;
    }
  }
  
  public static void c(Set<String> paramSet)
  {
    AppMethodBeat.i(122122);
    if (paramSet.isEmpty())
    {
      AppMethodBeat.o(122122);
      return;
    }
    Object localObject = cdc();
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (!paramSet.isEmpty())
      {
        localObject = new gk();
        ((gk)localObject).CAW.addAll(paramSet);
        a((gk)localObject);
        AppMethodBeat.o(122122);
      }
    }
    else
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if ((str != null) && (!((List)localObject).contains(str))) {
          ((List)localObject).add(str);
        }
      }
      cW((List)localObject);
    }
    AppMethodBeat.o(122122);
  }
  
  public static void cV(List<String> paramList)
  {
    AppMethodBeat.i(122123);
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      String str = (String)paramList.get(i);
      if ((str == null) || (str.isEmpty())) {
        paramList.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        Long localLong = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WG(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() >= 43200000L))
        {
          ad.i("AsyncBizDao", "HABBYGE-MALI, AsyncBizDao, _clearHistory: %s", new Object[] { str });
          paramList.remove(i);
        }
      }
    }
    AppMethodBeat.o(122123);
  }
  
  public static void cW(List<String> paramList)
  {
    AppMethodBeat.i(122124);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122124);
      return;
    }
    gk localgk = new gk();
    localgk.CAW.addAll(paramList);
    a(localgk);
    AppMethodBeat.o(122124);
  }
  
  public static String cdb()
  {
    AppMethodBeat.i(122121);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122121);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_async_biz_dao".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(122121);
      return null;
    }
    AppMethodBeat.o(122121);
    return str;
  }
  
  public static List<String> cdc()
  {
    AppMethodBeat.i(122125);
    Object localObject = cdd();
    if (localObject == null)
    {
      AppMethodBeat.o(122125);
      return null;
    }
    localObject = ((gk)localObject).CAW;
    AppMethodBeat.o(122125);
    return localObject;
  }
  
  private static gk cdd()
  {
    AppMethodBeat.i(122127);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122127);
      return null;
    }
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_async_bizid_sid".concat(String.valueOf(i)));
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122127);
      return null;
    }
    gk localgk = new gk();
    try
    {
      localgk.parseFrom(arrayOfByte);
      AppMethodBeat.o(122127);
      return localgk;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("AsyncBizDao", localIOException, "AsyncBizDao, _readBizId, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122127);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.a
 * JD-Core Version:    0.7.0.1
 */