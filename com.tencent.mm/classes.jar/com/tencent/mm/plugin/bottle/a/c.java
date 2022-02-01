package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;

public final class c
{
  private static int pkU = 1;
  private static int pkV = 1;
  
  public static String a(Context paramContext, as paramas)
  {
    AppMethodBeat.i(22647);
    if (paramas == null)
    {
      paramContext = paramContext.getString(2131756885);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.bkO(paramas.getCountryCode()))
    {
      paramContext = paramas.getCity();
      if (!Util.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = aa.It(paramas.getProvince());
      if (!Util.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.gEm();
      paramContext = RegionCodeDecoder.getLocName(paramas.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756885);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static String ahl(String paramString)
  {
    AppMethodBeat.i(22644);
    if (Util.isNullOrNil(paramString))
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
  
  public static void ahm(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.jRu.WZ();
    bg.aVF();
    if (com.tencent.mm.model.c.aSQ().aEM(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    bg.aVF();
    ca localca = com.tencent.mm.model.c.aSQ().aEx(paramString);
    if ((localca == null) || (!localca.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = ahl(paramString);
    if (Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.ckU();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + Util.escapeSqlValue(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).iFy.rawQuery(str2, null);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.pkR != null) {
          break label382;
        }
      }
    }
    label382:
    for (localObject = "";; localObject = locala.pkR)
    {
      if (((String)localObject).equals(str1)) {
        break label392;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.pkQ = ((Cursor)localObject).getString(0);
        locala.bva = ((Cursor)localObject).getInt(1);
        locala.pkR = ((Cursor)localObject).getString(2);
        locala.pkS = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.pkT = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.iFr = ((Cursor)localObject).getInt(8);
        locala.iWj = ((Cursor)localObject).getInt(9);
        locala.iFt = ((Cursor)localObject).getString(10);
        locala.iFu = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label392:
    if (locala.pkS != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new ca();
    ((ca)localObject).Cy(paramString);
    long l;
    int i;
    if (localca.field_createTime <= locala.createtime)
    {
      l = localca.field_createTime - 1L;
      ((ca)localObject).setCreateTime(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((ca)localObject).setType(i);
      ((ca)localObject).setStatus(2);
      ((ca)localObject).nv(1);
      if (((ca)localObject).getType() != 34) {
        break label674;
      }
      ((ca)localObject).setContent(p.b(z.aTY(), locala.pkT, false));
      paramString = locala.getContent() + Util.nowMilliSecond();
      if (com.tencent.mm.vfs.s.nw(com.tencent.mm.modelvoice.s.getFullPath(locala.getContent()), com.tencent.mm.modelvoice.s.getFullPath(paramString)) >= 0L) {
        break label646;
      }
      Log.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
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
    ((ca)localObject).Cz(paramString);
    for (;;)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSQ().aC((ca)localObject);
      AppMethodBeat.o(22645);
      return;
      label674:
      ((ca)localObject).setContent(locala.getContent());
    }
  }
  
  public static void ckS()
  {
    AppMethodBeat.i(22646);
    b localb = d.ckU();
    long l = Util.nowMilliSecond() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.iFy.rawQuery((String)localObject, null);
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
      localb.iFy.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(22646);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      Log.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.s.getFullPath(localObject[i]));
      if (!Util.isNullOrNil(com.tencent.mm.modelvoice.s.getFullPath(localObject[i]))) {
        com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.modelvoice.s.getFullPath(localObject[i]));
      }
      i += 1;
    }
    AppMethodBeat.o(22646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */