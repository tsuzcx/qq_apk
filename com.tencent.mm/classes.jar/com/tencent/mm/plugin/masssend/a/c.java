package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> uEi;
  
  private static String dbw()
  {
    AppMethodBeat.i(26354);
    if (az.agM())
    {
      az.ayM();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.agv(), ab.eUO() });
      ac.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(26354);
      return str;
    }
    AppMethodBeat.o(26354);
    return "";
  }
  
  private boolean dbx()
  {
    AppMethodBeat.i(26355);
    byte[] arrayOfByte;
    if (this.uEi == null)
    {
      localObject = dbw();
      arrayOfByte = i.aU((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(26355);
        return false;
      }
    }
    try
    {
      this.uEi = ((e)new e().parseFrom(arrayOfByte)).uEj;
      if (this.uEi == null)
      {
        ac.w("MicroMsg.MassSendService", "info list is empty");
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
    ac.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.uEi.toString() });
    long l = bs.aNx();
    Object localObject = this.uEi.iterator();
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
  
  public static void vN(long paramLong)
  {
    AppMethodBeat.i(26353);
    az.ayM();
    com.tencent.mm.model.c.agA().set(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(26353);
  }
  
  public final void akz(String paramString)
  {
    AppMethodBeat.i(26356);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26356);
      return;
    }
    Object localObject1 = bv.L(paramString, "Festivals");
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
      ((d)localObject2).begin = bs.aLr((String)((Map)localObject1).get(paramString + ".StartTime"));
      ((d)localObject2).end = (bs.aLr((String)((Map)localObject1).get(paramString + ".EndTime")) + 86400000);
      locale.uEj.add(localObject2);
      i += 1;
      break;
    }
    label200:
    locale.count = locale.uEj.size();
    this.uEi = locale.uEj;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = dbw();
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(26356);
          return;
        }
        localObject2 = new com.tencent.mm.vfs.e((String)localObject1);
        if (!((com.tencent.mm.vfs.e)localObject2).exists())
        {
          az.ayM();
          com.tencent.mm.model.c.agA().set(102408, Boolean.FALSE);
          ac.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          i.f((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(26356);
          return;
        }
        if (!i.aKe(q.B(((com.tencent.mm.vfs.e)localObject2).mUri)).equals(g.getMessageDigest(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(102408, Boolean.FALSE);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
        AppMethodBeat.o(26356);
        return;
      }
    }
  }
  
  public final void dbv()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26352);
    boolean bool1 = dbx();
    az.ayM();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.agA().get(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((u.axI() & 0x10000) == 0)
    {
      i = 1;
      ac.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      ac.d("MicroMsg.MassSendService", "set top conversation");
      az.ayM();
      if (com.tencent.mm.model.c.awG().aNI("masssendapp") != null) {
        break label252;
      }
      az.ayM();
      if (com.tencent.mm.model.c.awG().aNI("masssendapp") == null)
      {
        localObject1 = new ap();
        ((ap)localObject1).setUsername("masssendapp");
        ((ap)localObject1).setContent(ai.getContext().getResources().getString(2131757722));
        ((ap)localObject1).ou(bs.eWj() + 2000L);
        ((ap)localObject1).jT(0);
        ((ap)localObject1).jR(0);
        az.ayM();
        com.tencent.mm.model.c.awG().e((ap)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10425, "");
      az.ayM();
      com.tencent.mm.model.c.agA().set(102409, Long.valueOf(bs.eWj()));
      az.ayM();
      com.tencent.mm.model.c.agA().set(102408, Boolean.TRUE);
      AppMethodBeat.o(26352);
      return;
      i = 0;
      break;
      localObject2 = h.dbz().hpA.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = ai.getContext().getResources().getString(2131757722);
      label292:
      localObject2 = new ap();
      ((ap)localObject2).setUsername("masssendapp");
      ((ap)localObject2).setContent((String)localObject1);
      ((ap)localObject2).ou(bs.eWj() + 2000L);
      ((ap)localObject2).jT(0);
      ((ap)localObject2).jR(0);
      az.ayM();
      com.tencent.mm.model.c.awG().a((ap)localObject2, "masssendapp");
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
      h.dbz();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        az.ayM();
        com.tencent.mm.model.c.agA().set(102408, Boolean.FALSE);
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