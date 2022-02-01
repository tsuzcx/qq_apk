package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> tvP;
  
  private static String cNP()
  {
    AppMethodBeat.i(26354);
    if (az.afw())
    {
      az.arV();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.aff(), ac.eFu() });
      ad.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(26354);
      return str;
    }
    AppMethodBeat.o(26354);
    return "";
  }
  
  private boolean cNQ()
  {
    AppMethodBeat.i(26355);
    byte[] arrayOfByte;
    if (this.tvP == null)
    {
      localObject = cNP();
      arrayOfByte = i.aR((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(26355);
        return false;
      }
    }
    try
    {
      this.tvP = ((e)new e().parseFrom(arrayOfByte)).tvQ;
      if (this.tvP == null)
      {
        ad.w("MicroMsg.MassSendService", "info list is empty");
        AppMethodBeat.o(26355);
        return false;
      }
    }
    catch (Exception localException)
    {
      i.deleteFile((String)localObject);
      AppMethodBeat.o(26355);
      return false;
    }
    ad.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.tvP.toString() });
    long l = bt.aGK();
    Object localObject = this.tvP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((locald.begin <= l) && (l <= locald.end))
      {
        AppMethodBeat.o(26355);
        return true;
      }
    }
    AppMethodBeat.o(26355);
    return false;
  }
  
  public static void rk(long paramLong)
  {
    AppMethodBeat.i(26353);
    az.arV();
    com.tencent.mm.model.c.afk().set(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(26353);
  }
  
  public final void afF(String paramString)
  {
    AppMethodBeat.i(26356);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26356);
      return;
    }
    Object localObject1 = bw.K(paramString, "Festivals");
    if (localObject1 == null)
    {
      AppMethodBeat.o(26356);
      return;
    }
    e locale = new e();
    int i = 0;
    Object localObject2 = new StringBuilder(".Festivals.Festival");
    if (i == 0) {}
    for (paramString = "";; paramString = String.valueOf(i))
    {
      paramString = paramString;
      if (!((Map)localObject1).containsKey(paramString)) {
        break label200;
      }
      localObject2 = new d();
      ((d)localObject2).begin = bt.aGa((String)((Map)localObject1).get(paramString + ".StartTime"));
      ((d)localObject2).end = (bt.aGa((String)((Map)localObject1).get(paramString + ".EndTime")) + 86400000);
      locale.tvQ.add(localObject2);
      i += 1;
      break;
    }
    label200:
    locale.count = locale.tvQ.size();
    this.tvP = locale.tvQ;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = cNP();
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(26356);
          return;
        }
        localObject2 = new com.tencent.mm.vfs.e((String)localObject1);
        if (!((com.tencent.mm.vfs.e)localObject2).exists())
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(102408, Boolean.FALSE);
          ad.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          i.f((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(26356);
          return;
        }
        if (!i.aEN(q.B(((com.tencent.mm.vfs.e)localObject2).mUri)).equals(g.getMessageDigest(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(102408, Boolean.FALSE);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
        AppMethodBeat.o(26356);
        return;
      }
    }
  }
  
  public final void cNO()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26352);
    boolean bool1 = cNQ();
    az.arV();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.afk().get(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((u.aqS() & 0x10000) == 0)
    {
      i = 1;
      ad.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      ad.d("MicroMsg.MassSendService", "set top conversation");
      az.arV();
      if (com.tencent.mm.model.c.apR().aIn("masssendapp") != null) {
        break label252;
      }
      az.arV();
      if (com.tencent.mm.model.c.apR().aIn("masssendapp") == null)
      {
        localObject1 = new am();
        ((am)localObject1).setUsername("masssendapp");
        ((am)localObject1).setContent(aj.getContext().getResources().getString(2131757722));
        ((am)localObject1).kS(bt.eGO() + 2000L);
        ((am)localObject1).jV(0);
        ((am)localObject1).jT(0);
        az.arV();
        com.tencent.mm.model.c.apR().e((am)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10425, "");
      az.arV();
      com.tencent.mm.model.c.afk().set(102409, Long.valueOf(bt.eGO()));
      az.arV();
      com.tencent.mm.model.c.afk().set(102408, Boolean.TRUE);
      AppMethodBeat.o(26352);
      return;
      i = 0;
      break;
      localObject2 = h.cNS().gPa.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = aj.getContext().getResources().getString(2131757722);
      label292:
      localObject2 = new am();
      ((am)localObject2).setUsername("masssendapp");
      ((am)localObject2).setContent((String)localObject1);
      ((am)localObject2).kS(bt.eGO() + 2000L);
      ((am)localObject2).jV(0);
      ((am)localObject2).jT(0);
      az.arV();
      com.tencent.mm.model.c.apR().a((am)localObject2, "masssendapp");
    }
    label361:
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new a();
      ((a)localObject1).convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      break;
      label397:
      h.cNS();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        az.arV();
        com.tencent.mm.model.c.afk().set(102408, Boolean.FALSE);
      }
      AppMethodBeat.o(26352);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.c
 * JD-Core Version:    0.7.0.1
 */