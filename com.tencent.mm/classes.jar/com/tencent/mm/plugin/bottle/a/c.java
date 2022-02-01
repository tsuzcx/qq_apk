package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;

public final class c
{
  private static int vzb = 1;
  private static int vzc = 1;
  
  public static String a(Context paramContext, au paramau)
  {
    AppMethodBeat.i(22647);
    if (paramau == null)
    {
      paramContext = paramContext.getString(R.l.gvS);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.byG(paramau.getCountryCode()))
    {
      paramContext = paramau.getCity();
      if (!Util.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = aa.IF(paramau.getProvince());
      if (!Util.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.jcF();
      paramContext = RegionCodeDecoder.getLocName(paramau.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.gvS);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static String ain(String paramString)
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
  
  public static void aio(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.pFo.aDx();
    bh.bCz();
    if (com.tencent.mm.model.c.bzD().aLW(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    bh.bCz();
    cc localcc = com.tencent.mm.model.c.bzD().aLG(paramString);
    if ((localcc == null) || (!localcc.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = ain(paramString);
    if (Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.dbh();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + Util.escapeSqlValue(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).omV.rawQuery(str2, null);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.vyY != null) {
          break label382;
        }
      }
    }
    label382:
    for (localObject = "";; localObject = locala.vyY)
    {
      if (((String)localObject).equals(str1)) {
        break label392;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.vyX = ((Cursor)localObject).getString(0);
        locala.cYv = ((Cursor)localObject).getInt(1);
        locala.vyY = ((Cursor)localObject).getString(2);
        locala.vyZ = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.vza = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.omO = ((Cursor)localObject).getInt(8);
        locala.oFl = ((Cursor)localObject).getInt(9);
        locala.omQ = ((Cursor)localObject).getString(10);
        locala.omR = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label392:
    if (locala.vyZ != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new cc();
    ((cc)localObject).BS(paramString);
    long l;
    int i;
    if (localcc.getCreateTime() <= locala.createtime)
    {
      l = localcc.getCreateTime() - 1L;
      ((cc)localObject).setCreateTime(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((cc)localObject).setType(i);
      ((cc)localObject).setStatus(2);
      ((cc)localObject).pI(1);
      if (((cc)localObject).getType() != 34) {
        break label675;
      }
      ((cc)localObject).setContent(p.a(z.bAM(), locala.vza, false));
      paramString = locala.getContent() + Util.nowMilliSecond();
      if (y.O(s.getFullPath(locala.getContent()), s.getFullPath(paramString), false) >= 0L) {
        break label647;
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
    label647:
    ((cc)localObject).BT(paramString);
    for (;;)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzD().ba((cc)localObject);
      AppMethodBeat.o(22645);
      return;
      label675:
      ((cc)localObject).setContent(locala.getContent());
    }
  }
  
  public static void dbf()
  {
    AppMethodBeat.i(22646);
    b localb = d.dbh();
    long l = Util.nowMilliSecond() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.omV.rawQuery((String)localObject, null);
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
      localb.omV.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(22646);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      Log.d("MicroMsg.BottleLogic", "delete path:" + s.getFullPath(localObject[i]));
      if (!Util.isNullOrNil(s.getFullPath(localObject[i]))) {
        y.deleteFile(s.getFullPath(localObject[i]));
      }
      i += 1;
    }
    AppMethodBeat.o(22646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */