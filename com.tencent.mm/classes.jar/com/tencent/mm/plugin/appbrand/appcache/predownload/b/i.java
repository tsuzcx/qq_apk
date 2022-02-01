package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.e;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.gmn;
import com.tencent.mm.protocal.protobuf.gmw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class i
  extends a<Boolean, gmw>
{
  private static Boolean a(String paramString1, String paramString2, gmw paramgmw)
  {
    AppMethodBeat.i(44401);
    Object localObject = paramgmw.acif;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (Util.isNullOrNil(paramgmw.abUC))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new dgu();
        ((dgu)localObject).parseFrom(arrayOfByte);
        if (((dgu)localObject).aaMa.Zjj.Op.length == 0)
        {
          Log.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramgmw.achK.achH, 105L);
          paramgmw = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return paramgmw;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramgmw.achK.achH, 104L);
        LinkedList localLinkedList = paramgmw.abUC;
        long l1 = paramgmw.acig & 0xFFFFFFFF;
        long l2 = paramgmw.acih & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          Log.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)n.ag(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
          int j = paramgmw.achK.achH;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (Util.isNullOrNil(localLinkedList))
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
      catch (Exception paramgmw)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramgmw, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(44401);
        return paramString1;
      }
      localObject = ((StringBuilder)localObject).toString();
      continue;
      label456:
      int i = 108;
    }
  }
  
  final String cht()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.i
 * JD-Core Version:    0.7.0.1
 */