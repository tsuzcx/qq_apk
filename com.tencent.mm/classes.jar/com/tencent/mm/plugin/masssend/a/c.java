package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> ESJ;
  
  public static void Op(long paramLong)
  {
    AppMethodBeat.i(26353);
    bh.beI();
    com.tencent.mm.model.c.aHp().i(102409, Long.valueOf(paramLong));
    AppMethodBeat.o(26353);
  }
  
  private static String eRj()
  {
    AppMethodBeat.i(26354);
    if (bh.aHB())
    {
      bh.beI();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.aHl(), LocaleUtil.getApplicationLanguage() });
      Log.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      AppMethodBeat.o(26354);
      return str;
    }
    AppMethodBeat.o(26354);
    return "";
  }
  
  private boolean eRk()
  {
    AppMethodBeat.i(26355);
    byte[] arrayOfByte;
    if (this.ESJ == null)
    {
      localObject = eRj();
      arrayOfByte = u.aY((String)localObject, 0, -1);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(26355);
        return false;
      }
    }
    try
    {
      this.ESJ = ((e)new e().parseFrom(arrayOfByte)).ESK;
      if (this.ESJ == null)
      {
        Log.w("MicroMsg.MassSendService", "info list is empty");
        AppMethodBeat.o(26355);
        return false;
      }
    }
    catch (Exception localException)
    {
      u.deleteFile((String)localObject);
      AppMethodBeat.o(26355);
      return false;
    }
    Log.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.ESJ.toString() });
    long l = Util.nowSecond();
    Object localObject = this.ESJ.iterator();
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
  
  public final void aNW(String paramString)
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
      locale.ESK.add(localObject2);
      i += 1;
      break;
    }
    label203:
    locale.count = locale.ESK.size();
    this.ESJ = locale.ESK;
    for (;;)
    {
      try
      {
        paramString = locale.toByteArray();
        localObject1 = eRj();
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.w("MicroMsg.MassSendService", "mass send config file path is null, return");
          AppMethodBeat.o(26356);
          return;
        }
        localObject2 = new q((String)localObject1);
        if (!((q)localObject2).ifE())
        {
          bh.beI();
          com.tencent.mm.model.c.aHp().i(102408, Boolean.FALSE);
          Log.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
          u.f((String)localObject1, paramString, paramString.length);
          AppMethodBeat.o(26356);
          return;
        }
        if (!u.buc(((q)localObject2).getPath()).equals(g.getMessageDigest(paramString)))
        {
          i = 1;
          if (i != 0)
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(102408, Boolean.FALSE);
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
  
  public final void eRi()
  {
    Object localObject1 = null;
    AppMethodBeat.i(26352);
    boolean bool1 = eRk();
    bh.beI();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.aHp().b(102408, Boolean.FALSE)).booleanValue();
    int i;
    if ((z.bdn() & 0x10000) == 0)
    {
      i = 1;
      Log.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label411;
      }
      Log.d("MicroMsg.MassSendService", "set top conversation");
      bh.beI();
      if (com.tencent.mm.model.c.bbR().bwx("masssendapp") != null) {
        break label252;
      }
      bh.beI();
      if (com.tencent.mm.model.c.bbR().bwx("masssendapp") == null)
      {
        localObject1 = new az();
        ((az)localObject1).setUsername("masssendapp");
        ((az)localObject1).setContent(MMApplicationContext.getContext().getResources().getString(R.l.eyE));
        ((az)localObject1).EB(Util.nowMilliSecond() + 2000L);
        ((az)localObject1).pJ(0);
        ((az)localObject1).pH(0);
        bh.beI();
        com.tencent.mm.model.c.bbR().e((az)localObject1);
      }
    }
    label252:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10425, "");
      bh.beI();
      com.tencent.mm.model.c.aHp().i(102409, Long.valueOf(Util.nowMilliSecond()));
      bh.beI();
      com.tencent.mm.model.c.aHp().i(102408, Boolean.TRUE);
      AppMethodBeat.o(26352);
      return;
      i = 0;
      break;
      localObject2 = h.eRm().lvy.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label361;
      }
      if (localObject1 != null) {
        break label397;
      }
      localObject1 = MMApplicationContext.getContext().getResources().getString(R.l.eyE);
      label292:
      localObject2 = new az();
      ((az)localObject2).setUsername("masssendapp");
      ((az)localObject2).setContent((String)localObject1);
      ((az)localObject2).EB(Util.nowMilliSecond() + 2000L);
      ((az)localObject2).pJ(0);
      ((az)localObject2).pH(0);
      bh.beI();
      com.tencent.mm.model.c.bbR().a((az)localObject2, "masssendapp");
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
      h.eRm();
      localObject1 = b.a((a)localObject1);
      break label292;
      label411:
      if (!bool1)
      {
        bh.beI();
        com.tencent.mm.model.c.aHp().i(102408, Boolean.FALSE);
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