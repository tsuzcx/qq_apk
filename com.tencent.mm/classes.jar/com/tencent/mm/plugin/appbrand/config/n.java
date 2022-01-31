package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
{
  public static String a(String paramString, int paramInt1, int paramInt2, c paramc, boolean paramBoolean)
  {
    if (e.aaY() == null) {
      return "";
    }
    int j = n.a.aF(paramString, paramInt1);
    int i;
    String str;
    boolean bool;
    if (e.aaY() == null)
    {
      i = 0;
      str = n.a.aG(paramString, paramInt1);
      if ((i == 0) || ((!bk.bl(str)) && (i <= j))) {
        break label208;
      }
      bool = true;
      label55:
      y.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      y.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[] { str, Boolean.valueOf(bool) });
      if (!bool) {
        break label214;
      }
      if (paramBoolean)
      {
        paramc = new n.2(paramc, paramString);
        LinkedList localLinkedList = new LinkedList();
        abb localabb = new abb();
        localabb.euK = paramString;
        localabb.hQR = paramInt1;
        localabb.swt = i;
        localabb.taE = paramInt2;
        localLinkedList.add(localabb);
        a(localLinkedList, paramc);
      }
    }
    for (;;)
    {
      return str;
      i = bk.getInt(e.aaY().get(n.a.aD(paramString, paramInt1), "0"), 0);
      break;
      label208:
      bool = false;
      break label55;
      label214:
      paramc.rf(str);
    }
  }
  
  public static void a(String paramString, LinkedList<cdl> paramLinkedList, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
    }
    LinkedList localLinkedList;
    do
    {
      return;
      if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
      {
        y.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        return;
      }
      localLinkedList = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cdl localcdl = (cdl)localIterator.next();
        y.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[] { Integer.valueOf(localcdl.version), Integer.valueOf(localcdl.type) });
        int i = n.a.aF(paramString, localcdl.type);
        int j = localcdl.version;
        n.a.B(paramString, localcdl.type, j);
        if (j != 0) {
          if (j > i)
          {
            localLinkedList.add(z(paramString, localcdl.type, localcdl.version));
          }
          else if (j == i)
          {
            if (bk.bl(n.a.aG(paramString, localcdl.type))) {
              localLinkedList.add(z(paramString, localcdl.type, localcdl.version));
            }
          }
          else
          {
            y.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            if (bk.bl(n.a.aG(paramString, localcdl.type))) {
              localLinkedList.add(z(paramString, localcdl.type, localcdl.version));
            }
          }
        }
      }
      y.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(localLinkedList.size()) });
    } while ((!paramBoolean) || (localLinkedList.size() == 0));
    y.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[] { paramString });
    a(localLinkedList, new n.1(paramString));
  }
  
  private static void a(LinkedList<abb> paramLinkedList, n.b paramb)
  {
    b.a locala = new b.a();
    locala.ecG = 1138;
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
    locala.ecI = new abd();
    locala.ecJ = 0;
    locala.ecK = 0;
    abc localabc = new abc();
    localabc.taF = paramLinkedList;
    locala.ecH = localabc;
    w.a(locala.Kt(), new n.3(paramb), true);
  }
  
  public static void b(String paramString, LinkedList<cdl> paramLinkedList)
  {
    a(paramString, paramLinkedList, true);
  }
  
  private static abb z(String paramString, int paramInt1, int paramInt2)
  {
    abb localabb = new abb();
    localabb.euK = paramString;
    localabb.hQR = paramInt1;
    localabb.swt = paramInt2;
    return localabb;
  }
  
  public static abstract interface c
  {
    public abstract void rf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */