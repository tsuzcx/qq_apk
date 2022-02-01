package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> vTm;
  
  private static String dnQ()
  {
    AppMethodBeat.i(26354);
    if (bc.ajM())
    {
      bc.aCg();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.ajw(), ad.fom() });
      ae.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(26354);
      return str;
    }
    AppMethodBeat.o(26354);
    return "";
  }
  
  private boolean dnR()
  {
    AppMethodBeat.i(26355);
    byte[] arrayOfByte;
    if (this.vTm == null)
    {
      localObject = dnQ();
      arrayOfByte = o.bb((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(26355);
        return false;
      }
    }
    try
    {
      this.vTm = ((e)new e().parseFrom(arrayOfByte)).vTn;
      if (this.vTm == null)
      {
        ae.w("MicroMsg.MassSendService", "info list is empty");
        AppMethodBeat.o(26355);
        return false;
      }
    }
    catch (Exception localException)
    {
      o.deleteFile((String)localObject);
      AppMethodBeat.o(26355);
      return false;
    }
    ae.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.vTm.toString() });
    long l = bu.aRi();
    Object localObject = this.vTm.iterator();
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
  
  public static void yr(long paramLong)
  {
    AppMethodBeat.i(26353);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(26353);
  }
  
  public final void aqr(String paramString)
  {
    AppMethodBeat.i(26356);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26356);
      return;
    }
    Object localObject1 = bx.M(paramString, "Festivals");
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
      ((d)localObject2).begin = bu.aSu((String)((Map)localObject1).get(paramString + ".StartTime"));
      ((d)localObject2).end = (bu.aSu((String)((Map)localObject1).get(paramString + ".EndTime")) + 86400000);
      locale.vTn.add(localObject2);
      i += 1;
      break;
    }
    label200:
    locale.count = locale.vTn.size();
    this.vTm = locale.vTn;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = dnQ();
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(26356);
          return;
        }
        localObject2 = new k((String)localObject1);
        if (!((k)localObject2).exists())
        {
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(102408, Boolean.FALSE);
          ae.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          o.f((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(26356);
          return;
        }
        if (!o.aRh(w.B(((k)localObject2).mUri)).equals(com.tencent.mm.b.g.getMessageDigest(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(102408, Boolean.FALSE);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
        AppMethodBeat.o(26356);
        return;
      }
    }
  }
  
  public final void dnP()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26352);
    boolean bool1 = dnR();
    bc.aCg();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.ajA().get(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((v.aAO() & 0x10000) == 0)
    {
      i = 1;
      ae.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      ae.d("MicroMsg.MassSendService", "set top conversation");
      bc.aCg();
      if (com.tencent.mm.model.c.azL().aVa("masssendapp") != null) {
        break label252;
      }
      bc.aCg();
      if (com.tencent.mm.model.c.azL().aVa("masssendapp") == null)
      {
        localObject1 = new au();
        ((au)localObject1).setUsername("masssendapp");
        ((au)localObject1).setContent(ak.getContext().getResources().getString(2131757722));
        ((au)localObject1).qH(bu.fpO() + 2000L);
        ((au)localObject1).kt(0);
        ((au)localObject1).kr(0);
        bc.aCg();
        com.tencent.mm.model.c.azL().e((au)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10425, "");
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(102409, Long.valueOf(bu.fpO()));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(102408, Boolean.TRUE);
      AppMethodBeat.o(26352);
      return;
      i = 0;
      break;
      localObject2 = h.dnT().hKK.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = ak.getContext().getResources().getString(2131757722);
      label292:
      localObject2 = new au();
      ((au)localObject2).setUsername("masssendapp");
      ((au)localObject2).setContent((String)localObject1);
      ((au)localObject2).qH(bu.fpO() + 2000L);
      ((au)localObject2).kt(0);
      ((au)localObject2).kr(0);
      bc.aCg();
      com.tencent.mm.model.c.azL().a((au)localObject2, "masssendapp");
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
      h.dnT();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(102408, Boolean.FALSE);
      }
      AppMethodBeat.o(26352);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.c
 * JD-Core Version:    0.7.0.1
 */