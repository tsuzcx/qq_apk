package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> oBk;
  
  private static String bOZ()
  {
    AppMethodBeat.i(22732);
    if (aw.RG())
    {
      aw.aaz();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.Rp(), aa.dsG() });
      ab.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(22732);
      return str;
    }
    AppMethodBeat.o(22732);
    return "";
  }
  
  private boolean bPa()
  {
    AppMethodBeat.i(22733);
    byte[] arrayOfByte;
    if (this.oBk == null)
    {
      localObject = bOZ();
      arrayOfByte = com.tencent.mm.vfs.e.i((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(22733);
        return false;
      }
    }
    try
    {
      this.oBk = ((e)new e().parseFrom(arrayOfByte)).oBl;
      if (this.oBk == null)
      {
        ab.w("MicroMsg.MassSendService", "info list is empty");
        AppMethodBeat.o(22733);
        return false;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.vfs.e.deleteFile((String)localObject);
      AppMethodBeat.o(22733);
      return false;
    }
    ab.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.oBk.toString() });
    long l = bo.aox();
    Object localObject = this.oBk.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((locald.bVp <= l) && (l <= locald.end))
      {
        AppMethodBeat.o(22733);
        return true;
      }
    }
    AppMethodBeat.o(22733);
    return false;
  }
  
  public static void kA(long paramLong)
  {
    AppMethodBeat.i(22731);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(22731);
  }
  
  public final void SD(String paramString)
  {
    AppMethodBeat.i(22734);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22734);
      return;
    }
    Object localObject1 = br.F(paramString, "Festivals");
    if (localObject1 == null)
    {
      AppMethodBeat.o(22734);
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
      ((d)localObject2).bVp = bo.apM((String)((Map)localObject1).get(paramString + ".StartTime"));
      ((d)localObject2).end = (bo.apM((String)((Map)localObject1).get(paramString + ".EndTime")) + 86400000);
      locale.oBl.add(localObject2);
      i += 1;
      break;
    }
    label200:
    locale.count = locale.oBl.size();
    this.oBk = locale.oBl;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = bOZ();
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(22734);
          return;
        }
        localObject2 = new com.tencent.mm.vfs.b((String)localObject1);
        if (!((com.tencent.mm.vfs.b)localObject2).exists())
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(102408, Boolean.FALSE);
          ab.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          com.tencent.mm.vfs.e.b((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(22734);
          return;
        }
        if (!com.tencent.mm.vfs.e.avP(j.p(((com.tencent.mm.vfs.b)localObject2).mUri)).equals(g.w(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(102408, Boolean.FALSE);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
        AppMethodBeat.o(22734);
        return;
      }
    }
  }
  
  public final void bOY()
  {
    Object localObject1 = null;
    AppMethodBeat.i(22730);
    boolean bool1 = bPa();
    aw.aaz();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.Ru().get(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((r.Zy() & 0x10000) == 0)
    {
      i = 1;
      ab.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      ab.d("MicroMsg.MassSendService", "set top conversation");
      aw.aaz();
      if (com.tencent.mm.model.c.YF().arH("masssendapp") != null) {
        break label252;
      }
      aw.aaz();
      if (com.tencent.mm.model.c.YF().arH("masssendapp") == null)
      {
        localObject1 = new ak();
        ((ak)localObject1).setUsername("masssendapp");
        ((ak)localObject1).setContent(ah.getContext().getResources().getString(2131298661));
        ((ak)localObject1).fK(bo.aoy() + 2000L);
        ((ak)localObject1).hL(0);
        ((ak)localObject1).hJ(0);
        aw.aaz();
        com.tencent.mm.model.c.YF().d((ak)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10425, "");
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(102409, Long.valueOf(bo.aoy()));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(102408, Boolean.TRUE);
      AppMethodBeat.o(22730);
      return;
      i = 0;
      break;
      localObject2 = h.bPc().fnw.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = ah.getContext().getResources().getString(2131298661);
      label292:
      localObject2 = new ak();
      ((ak)localObject2).setUsername("masssendapp");
      ((ak)localObject2).setContent((String)localObject1);
      ((ak)localObject2).fK(bo.aoy() + 2000L);
      ((ak)localObject2).hL(0);
      ((ak)localObject2).hJ(0);
      aw.aaz();
      com.tencent.mm.model.c.YF().a((ak)localObject2, "masssendapp");
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
      h.bPc();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(102408, Boolean.FALSE);
      }
      AppMethodBeat.o(22730);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.c
 * JD-Core Version:    0.7.0.1
 */