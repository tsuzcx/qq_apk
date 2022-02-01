package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;

public final class c
{
  private static int nZY = 1;
  private static int nZZ = 1;
  
  public static String Xp(String paramString)
  {
    AppMethodBeat.i(22644);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22644);
      return null;
    }
    paramString = paramString.split("@bottle:");
    if ((paramString == null) || (paramString.length < 2))
    {
      AppMethodBeat.o(22644);
      return null;
    }
    paramString = paramString[1];
    AppMethodBeat.o(22644);
    return paramString;
  }
  
  public static void Xq(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.iUA.MM();
    bc.aCg();
    if (com.tencent.mm.model.c.azI().arr(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    bc.aCg();
    bv localbv = com.tencent.mm.model.c.azI().arc(paramString);
    if ((localbv == null) || (!localbv.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = Xp(paramString);
    if (bu.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.bNU();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bu.aSk(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).hKK.a(str2, null, 0);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.nZV != null) {
          break label383;
        }
      }
    }
    label383:
    for (localObject = "";; localObject = locala.nZV)
    {
      if (((String)localObject).equals(str1)) {
        break label393;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.nZT = ((Cursor)localObject).getString(0);
        locala.nZU = ((Cursor)localObject).getInt(1);
        locala.nZV = ((Cursor)localObject).getString(2);
        locala.nZW = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.nZX = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.hKD = ((Cursor)localObject).getInt(8);
        locala.ibl = ((Cursor)localObject).getInt(9);
        locala.hKF = ((Cursor)localObject).getString(10);
        locala.hKG = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label393:
    if (locala.nZW != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new bv();
    ((bv)localObject).ui(paramString);
    long l;
    int i;
    if (localbv.field_createTime <= locala.createtime)
    {
      l = localbv.field_createTime - 1L;
      ((bv)localObject).qN(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((bv)localObject).setType(i);
      ((bv)localObject).setStatus(2);
      ((bv)localObject).kt(1);
      if (((bv)localObject).getType() != 34) {
        break label674;
      }
      ((bv)localObject).setContent(p.b(v.aAC(), locala.nZX, false));
      paramString = locala.getContent() + bu.fpO();
      if (o.mF(s.getFullPath(locala.getContent()), s.getFullPath(paramString)) >= 0L) {
        break label646;
      }
      ae.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
      AppMethodBeat.o(22645);
      return;
      l = locala.createtime;
      break;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 34;
      continue;
      i = 43;
    }
    label646:
    ((bv)localObject).uj(paramString);
    for (;;)
    {
      bc.aCg();
      com.tencent.mm.model.c.azI().ar((bv)localObject);
      AppMethodBeat.o(22645);
      return;
      label674:
      ((bv)localObject).setContent(locala.getContent());
    }
  }
  
  public static String a(Context paramContext, an paraman)
  {
    AppMethodBeat.i(22647);
    if (paraman == null)
    {
      paramContext = paramContext.getString(2131756727);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.aVQ(paraman.getCountryCode()))
    {
      paramContext = paraman.getCity();
      if (!bu.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = w.zR(paraman.getProvince());
      if (!bu.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.fwA();
      paramContext = RegionCodeDecoder.getLocName(paraman.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756727);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static void bNS()
  {
    AppMethodBeat.i(22646);
    b localb = d.bNU();
    long l = bu.fpO() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.hKK.a((String)localObject, null, 0);
    int j = localCursor.getCount();
    if (j > 0)
    {
      String[] arrayOfString = new String[j];
      i = 0;
      localObject = arrayOfString;
      if (i < j)
      {
        localCursor.moveToPosition(i);
        if (localCursor.getInt(1) == 3) {
          arrayOfString[i] = localCursor.getString(0);
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfString[i] = null;
        }
      }
    }
    else
    {
      localObject = null;
    }
    localCursor.close();
    if (j > 0) {
      localb.hKK.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(22646);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      ae.d("MicroMsg.BottleLogic", "delete path:" + s.getFullPath(localObject[i]));
      if (!bu.isNullOrNil(s.getFullPath(localObject[i]))) {
        o.deleteFile(s.getFullPath(localObject[i]));
      }
      i += 1;
    }
    AppMethodBeat.o(22646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */