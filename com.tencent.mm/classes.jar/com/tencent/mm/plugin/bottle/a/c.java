package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class c
{
  private static int jRX = 1;
  private static int jRY = 1;
  
  public static String GF(String paramString)
  {
    AppMethodBeat.i(18533);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(18533);
      return null;
    }
    paramString = paramString.split("@bottle:");
    if ((paramString == null) || (paramString.length < 2))
    {
      AppMethodBeat.o(18533);
      return null;
    }
    paramString = paramString[1];
    AppMethodBeat.o(18533);
    return paramString;
  }
  
  public static void GG(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(18534);
    com.tencent.mm.plugin.bottle.a.gmP.BO();
    aw.aaz();
    if (com.tencent.mm.model.c.YC().TA(paramString) != 1)
    {
      AppMethodBeat.o(18534);
      return;
    }
    aw.aaz();
    bi localbi = com.tencent.mm.model.c.YC().Tm(paramString);
    if ((localbi == null) || (!localbi.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(18534);
      return;
    }
    String str1 = GF(paramString);
    if (bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(18534);
      return;
    }
    Object localObject = d.aWj();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bo.wC(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).fnw.a(str2, null, 0);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.jRT != null) {
          break label383;
        }
      }
    }
    label383:
    for (localObject = "";; localObject = locala.jRT)
    {
      if (((String)localObject).equals(str1)) {
        break label393;
      }
      AppMethodBeat.o(18534);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.jRR = ((Cursor)localObject).getString(0);
        locala.jRS = ((Cursor)localObject).getInt(1);
        locala.jRT = ((Cursor)localObject).getString(2);
        locala.jRU = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.jRV = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.jRW = ((Cursor)localObject).getLong(7);
        locala.fns = ((Cursor)localObject).getInt(8);
        locala.fCK = ((Cursor)localObject).getInt(9);
        locala.fnu = ((Cursor)localObject).getString(10);
        locala.fnv = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label393:
    if (locala.jRU != 1)
    {
      AppMethodBeat.o(18534);
      return;
    }
    localObject = new bi();
    ((bi)localObject).kj(paramString);
    long l;
    int i;
    if (localbi.field_createTime <= locala.jRW)
    {
      l = localbi.field_createTime - 1L;
      ((bi)localObject).fQ(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((bi)localObject).setType(i);
      ((bi)localObject).setStatus(2);
      ((bi)localObject).hL(1);
      if (((bi)localObject).getType() != 34) {
        break label674;
      }
      ((bi)localObject).setContent(p.d(r.Zn(), locala.jRV, false));
      paramString = locala.getContent() + bo.aoy();
      if (e.C(com.tencent.mm.modelvoice.s.getFullPath(locala.getContent()), com.tencent.mm.modelvoice.s.getFullPath(paramString)) >= 0L) {
        break label646;
      }
      ab.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
      AppMethodBeat.o(18534);
      return;
      l = locala.jRW;
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
    ((bi)localObject).kk(paramString);
    for (;;)
    {
      aw.aaz();
      com.tencent.mm.model.c.YC().Z((bi)localObject);
      AppMethodBeat.o(18534);
      return;
      label674:
      ((bi)localObject).setContent(locala.getContent());
    }
  }
  
  public static String a(Context paramContext, ad paramad)
  {
    AppMethodBeat.i(18536);
    if (paramad == null)
    {
      paramContext = paramContext.getString(2131297803);
      AppMethodBeat.o(18536);
      return paramContext;
    }
    if (RegionCodeDecoder.asx(paramad.getCountryCode()))
    {
      paramContext = paramad.getCity();
      if (!bo.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(18536);
        return paramContext;
      }
      paramContext = com.tencent.mm.model.s.nG(paramad.getProvince());
      if (!bo.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(18536);
        return paramContext;
      }
      RegionCodeDecoder.dyE();
      paramContext = RegionCodeDecoder.getLocName(paramad.getCountryCode());
      AppMethodBeat.o(18536);
      return paramContext;
    }
    paramContext = paramContext.getString(2131297803);
    AppMethodBeat.o(18536);
    return paramContext;
  }
  
  public static void aWh()
  {
    AppMethodBeat.i(18535);
    b localb = d.aWj();
    long l = bo.aoy() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.fnw.a((String)localObject, null, 0);
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
      localb.fnw.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(18535);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      ab.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.s.getFullPath(localObject[i]));
      if (!bo.isNullOrNil(com.tencent.mm.modelvoice.s.getFullPath(localObject[i]))) {
        e.deleteFile(com.tencent.mm.modelvoice.s.getFullPath(localObject[i]));
      }
      i += 1;
    }
    AppMethodBeat.o(18535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */