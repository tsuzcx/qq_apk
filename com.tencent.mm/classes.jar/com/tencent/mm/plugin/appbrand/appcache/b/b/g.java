package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g
  extends a<Boolean, dbn>
{
  private static Boolean a(String paramString1, String paramString2, dbn paramdbn)
  {
    AppMethodBeat.i(129474);
    Object localObject = paramdbn.yhP;
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(129474);
      return paramString1;
    }
    if (bo.es(paramdbn.xYZ))
    {
      ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[] { paramString1, paramString2 });
      paramString1 = Boolean.FALSE;
      AppMethodBeat.o(129474);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = Base64.decode((String)localObject, 0);
        localObject = new azn();
        ((azn)localObject).parseFrom(arrayOfByte);
        if (((azn)localObject).xoU.wKA.pW.length == 0)
        {
          ab.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[] { paramString1, paramString2 });
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramdbn.yhA.yhy, 105L);
          paramdbn = Boolean.FALSE;
          AppMethodBeat.o(129474);
          return paramdbn;
        }
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramdbn.yhA.yhy, 104L);
        LinkedList localLinkedList = paramdbn.xYZ;
        long l1 = paramdbn.yhQ & 0xFFFFFFFF;
        long l2 = paramdbn.yhR & 0xFFFFFFFF;
        if (localLinkedList == null)
        {
          localObject = "null";
          ab.i("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]", new Object[] { paramString1, paramString2, localObject, Long.valueOf(l1), Long.valueOf(l2) });
          boolean bool = ((e)com.tencent.mm.plugin.appbrand.app.g.w(e.class)).a(arrayOfByte, paramString2, localLinkedList, l1, l2);
          localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          int j = paramdbn.yhA.yhy;
          if (!bool) {
            break label456;
          }
          i = 107;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(j, i);
          AppMethodBeat.o(129474);
          return Boolean.valueOf(bool);
        }
        if (bo.es(localLinkedList))
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
      catch (Exception paramdbn)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", paramdbn, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(129474);
        return paramString1;
      }
      localObject = ((StringBuilder)localObject).toString();
      continue;
      label456:
      int i = 108;
    }
  }
  
  final String awm()
  {
    return "CmdIssueLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.g
 * JD-Core Version:    0.7.0.1
 */