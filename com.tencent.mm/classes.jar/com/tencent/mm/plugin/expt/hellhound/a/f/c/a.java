package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
{
  private static void a(go paramgo)
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
      paramgo = paramgo.toByteArray();
      Object localObject = paramgo;
      if (paramgo == null) {}
      return;
    }
    catch (IOException paramgo)
    {
      try
      {
        localObject = new byte[0];
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_async_bizid_sid".concat(String.valueOf(i)), (byte[])localObject);
        AppMethodBeat.o(122126);
        return;
      }
      catch (Exception paramgo)
      {
        ac.printErrStackTrace("AsyncBizDao", paramgo, "habbyge-mali, AsyncBizDao._writeBizId crash: %s", new Object[] { paramgo.getMessage() });
        AppMethodBeat.o(122126);
      }
      paramgo = paramgo;
      ac.printErrStackTrace("AsyncBizDao", paramgo, "AsyncBizDao, putBizIdOfCloudConfig, crash: %s", new Object[] { paramgo.getMessage() });
      AppMethodBeat.o(122126);
      return;
    }
  }
  
  public static void abl(String paramString)
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
      ac.printErrStackTrace("AsyncBizDao", paramString, "habbyge-mali, AsyncBizDao._write crash: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(122120);
    }
  }
  
  public static void cX(List<String> paramList)
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
        Long localLong = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abd(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() >= 43200000L))
        {
          ac.i("AsyncBizDao", "HABBYGE-MALI, AsyncBizDao, _clearHistory: %s", new Object[] { str });
          paramList.remove(i);
        }
      }
    }
    AppMethodBeat.o(122123);
  }
  
  public static void cY(List<String> paramList)
  {
    AppMethodBeat.i(122124);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(122124);
      return;
    }
    go localgo = new go();
    localgo.DTu.addAll(paramList);
    a(localgo);
    AppMethodBeat.o(122124);
  }
  
  public static String ckJ()
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
  
  public static List<String> ckK()
  {
    AppMethodBeat.i(122125);
    Object localObject = ckL();
    if (localObject == null)
    {
      AppMethodBeat.o(122125);
      return null;
    }
    localObject = ((go)localObject).DTu;
    AppMethodBeat.o(122125);
    return localObject;
  }
  
  private static go ckL()
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
    go localgo = new go();
    try
    {
      localgo.parseFrom(arrayOfByte);
      AppMethodBeat.o(122127);
      return localgo;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("AsyncBizDao", localIOException, "AsyncBizDao, _readBizId, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122127);
    }
    return null;
  }
  
  public static void d(Set<String> paramSet)
  {
    AppMethodBeat.i(122122);
    if (paramSet.isEmpty())
    {
      AppMethodBeat.o(122122);
      return;
    }
    Object localObject = ckK();
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (!paramSet.isEmpty())
      {
        localObject = new go();
        ((go)localObject).DTu.addAll(paramSet);
        a((go)localObject);
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
      cY((List)localObject);
    }
    AppMethodBeat.o(122122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.a
 * JD-Core Version:    0.7.0.1
 */