package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.cmy;
import com.tencent.mm.protocal.c.cnf;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, cnf>
{
  private static Boolean a(String paramString1, String paramString2, cnf paramcnf)
  {
    Object localObject = paramcnf.tZW;
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      return Boolean.FALSE;
    }
    if (bk.dk(paramcnf.tSb))
    {
      y.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      return Boolean.FALSE;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new ati();
        ((ati)localObject).aH(arrayOfByte);
        if (((ati)localObject).toW.sMN.oY.length == 0)
        {
          y.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramcnf.tZH.tZF, 105L);
          return Boolean.FALSE;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramcnf.tZH.tZF, 104L);
        LinkedList localLinkedList = paramcnf.tSb;
        l1 = paramcnf.tZX & 0xFFFFFFFF;
        long l2 = paramcnf.tZY & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          y.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((com.tencent.mm.plugin.appbrand.appcache.b.d.e)com.tencent.mm.plugin.appbrand.app.e.G(com.tencent.mm.plugin.appbrand.appcache.b.d.e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
          l2 = paramcnf.tZH.tZF;
          if (!bool) {
            break label415;
          }
          l1 = 107L;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(l2, l1);
          return Boolean.valueOf(bool);
        }
        if (bk.dk(localLinkedList))
        {
          localObject = "{}";
          continue;
        }
        localObject = new StringBuilder("{");
        Iterator localIterator = localLinkedList.iterator();
        if (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append(localIterator.next().toString()).append(',');
          continue;
        }
        ((StringBuilder)localObject).append("}");
      }
      catch (Exception paramcnf)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramcnf, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        return Boolean.FALSE;
      }
      localObject = ((StringBuilder)localObject).toString();
      continue;
      label415:
      long l1 = 108L;
    }
  }
  
  final String act()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */