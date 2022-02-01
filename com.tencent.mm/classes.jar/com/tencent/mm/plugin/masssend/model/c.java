package com.tencent.mm.plugin.masssend.model;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> KNn;
  
  private static String fZS()
  {
    AppMethodBeat.i(26354);
    if (bh.baz())
    {
      bh.bCz();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.baj(), LocaleUtil.getApplicationLanguage() });
      Log.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(26354);
      return str;
    }
    AppMethodBeat.o(26354);
    return "";
  }
  
  private boolean fZT()
  {
    AppMethodBeat.i(26355);
    byte[] arrayOfByte;
    if (this.KNn == null)
    {
      localObject = fZS();
      arrayOfByte = y.bi((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(26355);
        return false;
      }
    }
    try
    {
      this.KNn = ((e)new e().parseFrom(arrayOfByte)).KNo;
      if (this.KNn == null)
      {
        Log.w("MicroMsg.MassSendService", "info list is empty");
        AppMethodBeat.o(26355);
        return false;
      }
    }
    catch (Exception localException)
    {
      y.deleteFile((String)localObject);
      AppMethodBeat.o(26355);
      return false;
    }
    Log.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.KNn.toString() });
    long l = Util.nowSecond();
    Object localObject = this.KNn.iterator();
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
  
  public static void sk(long paramLong)
  {
    AppMethodBeat.i(26353);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(26353);
  }
  
  public final void aKT(String paramString)
  {
    AppMethodBeat.i(26356);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26356);
      return;
    }
    Object localObject1 = XmlParser.parseXml(paramString, "Festivals", null);
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
        break label203;
      }
      localObject2 = new d();
      ((d)localObject2).begin = Util.getSeconds((String)((Map)localObject1).get(paramString + ".StartTime"), 0);
      ((d)localObject2).end = (Util.getSeconds((String)((Map)localObject1).get(paramString + ".EndTime"), 0) + 86400000);
      locale.KNo.add(localObject2);
      i += 1;
      break;
    }
    label203:
    locale.count = locale.KNo.size();
    this.KNn = locale.KNo;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = fZS();
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(26356);
          return;
        }
        localObject2 = new u((String)localObject1);
        if (!((u)localObject2).jKS())
        {
          bh.bCz();
          com.tencent.mm.model.c.ban().B(102408, Boolean.FALSE);
          Log.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          y.f((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(26356);
          return;
        }
        if (!y.bub(ah.v(((u)localObject2).mUri)).equals(com.tencent.mm.b.g.getMessageDigest(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(102408, Boolean.FALSE);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
        AppMethodBeat.o(26356);
        return;
      }
    }
  }
  
  public final void fZR()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26352);
    boolean bool1 = fZT();
    bh.bCz();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.ban().d(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((z.bBf() & 0x10000) == 0)
    {
      i = 1;
      Log.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      Log.d("MicroMsg.MassSendService", "set top conversation");
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().bxM("masssendapp") != null) {
        break label252;
      }
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().bxM("masssendapp") == null)
      {
        localObject1 = new bb();
        ((bb)localObject1).setUsername("masssendapp");
        ((bb)localObject1).setContent(MMApplicationContext.getContext().getResources().getString(R.l.gBw));
        ((bb)localObject1).gR(Util.nowMilliSecond() + 2000L);
        ((bb)localObject1).pI(0);
        ((bb)localObject1).pG(0);
        bh.bCz();
        com.tencent.mm.model.c.bzG().h((bb)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10425, "");
      bh.bCz();
      com.tencent.mm.model.c.ban().B(102409, Long.valueOf(Util.nowMilliSecond()));
      bh.bCz();
      com.tencent.mm.model.c.ban().B(102408, Boolean.TRUE);
      AppMethodBeat.o(26352);
      return;
      i = 0;
      break;
      localObject2 = g.fZV().omV.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(R.l.gBw);
      label292:
      localObject2 = new bb();
      ((bb)localObject2).setUsername("masssendapp");
      ((bb)localObject2).setContent((String)localObject1);
      ((bb)localObject2).gR(Util.nowMilliSecond() + 2000L);
      ((bb)localObject2).pI(0);
      ((bb)localObject2).pG(0);
      bh.bCz();
      com.tencent.mm.model.c.bzG().c((bb)localObject2, "masssendapp");
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
      g.fZV();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        bh.bCz();
        com.tencent.mm.model.c.ban().B(102408, Boolean.FALSE);
      }
      AppMethodBeat.o(26352);
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.c
 * JD-Core Version:    0.7.0.1
 */