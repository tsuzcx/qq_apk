package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
{
  private static aft L(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129866);
    aft localaft = new aft();
    localaft.fKw = paramString;
    localaft.jKs = paramInt1;
    localaft.wpF = paramInt2;
    AppMethodBeat.o(129866);
    return localaft;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(129867);
    if (g.wg() == null)
    {
      AppMethodBeat.o(129867);
      return "";
    }
    int i = a.aV(paramString, paramInt1);
    int j = a.aW(paramString, paramInt1);
    String str = a.aX(paramString, paramInt1);
    boolean bool;
    if ((j != 0) && ((bo.isNullOrNil(str)) || (j > i)))
    {
      bool = true;
      ab.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      ab.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
      if (!bool) {
        break label155;
      }
      if (paramBoolean) {
        a(paramString, paramInt1, j, paramInt2, new m.2(paramc, paramString));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(129867);
      return str;
      bool = false;
      break;
      label155:
      paramc.yA(str);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, b paramb)
  {
    AppMethodBeat.i(129868);
    LinkedList localLinkedList = new LinkedList();
    aft localaft = new aft();
    localaft.fKw = paramString;
    localaft.jKs = paramInt1;
    localaft.wpF = paramInt2;
    localaft.wYU = paramInt3;
    localLinkedList.add(localaft);
    a(localLinkedList, paramb);
    AppMethodBeat.o(129868);
  }
  
  public static void a(String paramString, LinkedList<cqs> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(129865);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
      AppMethodBeat.o(129865);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ab.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
      AppMethodBeat.o(129865);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      cqs localcqs = (cqs)localIterator.next();
      ab.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localcqs.version), Integer.valueOf(localcqs.type) });
      int i = a.aV(paramString, localcqs.type);
      int j = localcqs.version;
      a.N(paramString, localcqs.type, j);
      if (j != 0) {
        if (j > i)
        {
          localLinkedList.add(L(paramString, localcqs.type, localcqs.version));
        }
        else if (j == i)
        {
          if (bo.isNullOrNil(a.aX(paramString, localcqs.type))) {
            localLinkedList.add(L(paramString, localcqs.type, localcqs.version));
          }
        }
        else
        {
          ab.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (bo.isNullOrNil(a.aX(paramString, localcqs.type))) {
            localLinkedList.add(L(paramString, localcqs.type, localcqs.version));
          }
        }
      }
    }
    ab.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    if (paramBoolean)
    {
      if (localLinkedList.size() == 0)
      {
        AppMethodBeat.o(129865);
        return;
      }
      ab.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
      a(localLinkedList, new m.1(paramString));
    }
    AppMethodBeat.o(129865);
  }
  
  private static void a(LinkedList<aft> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(129869);
    b.a locala = new b.a();
    locala.funcId = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.fsY = new afv();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    afu localafu = new afu();
    localafu.wYV = paramLinkedList;
    locala.fsX = localafu;
    w.a(locala.ado(), new m.3(paramb), true);
    AppMethodBeat.o(129869);
  }
  
  public static void b(String paramString, LinkedList<cqs> paramLinkedList)
  {
    AppMethodBeat.i(129864);
    a(paramString, paramLinkedList, true);
    AppMethodBeat.o(129864);
  }
  
  public static final class a
  {
    public static void M(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129858);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129858);
        return;
      }
      g.wg().bG(aS(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(129858);
    }
    
    public static void N(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129859);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129859);
        return;
      }
      g.wg().bG(aT(paramString, paramInt1), String.valueOf(paramInt2));
      AppMethodBeat.o(129859);
    }
    
    private static String aS(String paramString, int paramInt)
    {
      AppMethodBeat.i(129855);
      paramString = String.format("%s_%s_local_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(129855);
      return paramString;
    }
    
    private static String aT(String paramString, int paramInt)
    {
      AppMethodBeat.i(129856);
      paramString = String.format("%s_%s_server_version", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(129856);
      return paramString;
    }
    
    private static String aU(String paramString, int paramInt)
    {
      AppMethodBeat.i(129857);
      paramString = String.format("%s_%s_config", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(129857);
      return paramString;
    }
    
    public static int aV(String paramString, int paramInt)
    {
      AppMethodBeat.i(129861);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129861);
        return 0;
      }
      paramInt = bo.getInt(g.wg().get(aS(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(129861);
      return paramInt;
    }
    
    public static int aW(String paramString, int paramInt)
    {
      AppMethodBeat.i(129862);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129862);
        return 0;
      }
      paramInt = bo.getInt(g.wg().get(aT(paramString, paramInt), "0"), 0);
      AppMethodBeat.o(129862);
      return paramInt;
    }
    
    public static String aX(String paramString, int paramInt)
    {
      AppMethodBeat.i(129863);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129863);
        return "";
      }
      paramString = g.wg().get(aU(paramString, paramInt), "");
      AppMethodBeat.o(129863);
      return paramString;
    }
    
    public static void i(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(129860);
      if (g.wg() == null)
      {
        AppMethodBeat.o(129860);
        return;
      }
      g.wg().bG(aU(paramString1, paramInt), paramString2);
      AppMethodBeat.o(129860);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, b paramb);
  }
  
  public static abstract interface c
  {
    public abstract void yA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */