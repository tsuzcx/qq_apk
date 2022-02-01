package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.dwm;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, dwm>
{
  private static Boolean a(String paramString1, String paramString2, dwm paramdwm)
  {
    AppMethodBeat.i(44401);
    Object localObject = paramdwm.EKx;
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    if (bt.gL(paramdwm.EzL))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(44401);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new bkx();
        ((bkx)localObject).parseFrom(arrayOfByte);
        if (((bkx)localObject).DIL.CWN.wA.length == 0)
        {
          ad.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(paramdwm.EKf.EKc, 105L);
          paramdwm = Boolean.FALSE;
          AppMethodBeat.o(44401);
          return paramdwm;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(paramdwm.EKf.EKc, 104L);
        LinkedList localLinkedList = paramdwm.EzL;
        long l1 = paramdwm.EKy & 0xFFFFFFFF;
        long l2 = paramdwm.EKz & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          ad.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)j.T(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
          int j = paramdwm.EKf.EKc;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(j, i);
          AppMethodBeat.o(44401);
          return Boolean.valueOf(bool);
        }
        if (bt.gL(localLinkedList))
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
      catch (Exception paramdwm)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramdwm, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
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
  
  final String aQI()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */