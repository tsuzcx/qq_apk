package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
{
  private static void a(gv paramgv)
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
      paramgv = paramgv.toByteArray();
      Object localObject = paramgv;
      if (paramgv == null) {}
      return;
    }
    catch (IOException paramgv)
    {
      try
      {
        localObject = new byte[0];
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_async_bizid_sid".concat(String.valueOf(i)), (byte[])localObject);
        AppMethodBeat.o(122126);
        return;
      }
      catch (Exception paramgv)
      {
        ad.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramgv, "AsyncBizDao._writeBizId crash: %s", new Object[] { paramgv.getMessage() });
        AppMethodBeat.o(122126);
      }
      paramgv = paramgv;
      ad.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramgv, "AsyncBizDao, putBizIdOfCloudConfig, crash: %s", new Object[] { paramgv.getMessage() });
      AppMethodBeat.o(122126);
      return;
    }
  }
  
  public static void aeY(String paramString)
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
      ad.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramString, "AsyncBizDao._write crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(122120);
    }
  }
  
  public static void cZ(List<String> paramList)
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
        Long localLong = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeQ(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() >= 43200000L))
        {
          ad.i("HABBYGE-MALI.AsyncBizDao", "AsyncBizDao, _clearHistory: %s", new Object[] { str });
          paramList.remove(i);
        }
      }
    }
    AppMethodBeat.o(122123);
  }
  
  public static String cpY()
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
  
  public static List<String> cpZ()
  {
    AppMethodBeat.i(122125);
    Object localObject = cqa();
    if (localObject == null)
    {
      AppMethodBeat.o(122125);
      return null;
    }
    localObject = ((gv)localObject).FyN;
    AppMethodBeat.o(122125);
    return localObject;
  }
  
  private static gv cqa()
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
    gv localgv = new gv();
    try
    {
      localgv.parseFrom(arrayOfByte);
      AppMethodBeat.o(122127);
      return localgv;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", localIOException, "AsyncBizDao, _readBizId, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122127);
    }
    return null;
  }
  
  public static void da(List<String> paramList)
  {
    AppMethodBeat.i(122124);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122124);
      return;
    }
    gv localgv = new gv();
    localgv.FyN.addAll(paramList);
    a(localgv);
    AppMethodBeat.o(122124);
  }
  
  public static void h(Set<String> paramSet)
  {
    AppMethodBeat.i(122122);
    if (paramSet.isEmpty())
    {
      AppMethodBeat.o(122122);
      return;
    }
    Object localObject = cpZ();
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (!paramSet.isEmpty())
      {
        localObject = new gv();
        ((gv)localObject).FyN.addAll(paramSet);
        a((gv)localObject);
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
      da((List)localObject);
    }
    AppMethodBeat.o(122122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.a
 * JD-Core Version:    0.7.0.1
 */