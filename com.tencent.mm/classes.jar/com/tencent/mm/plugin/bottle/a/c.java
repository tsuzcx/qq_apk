package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;

public final class c
{
  private static int mRg = 1;
  private static int mRh = 1;
  
  public static String OT(String paramString)
  {
    AppMethodBeat.i(22644);
    if (bt.isNullOrNil(paramString))
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
  
  public static void OU(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.hYu.Ll();
    az.arV();
    if (com.tencent.mm.model.c.apO().agE(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    az.arV();
    bl localbl = com.tencent.mm.model.c.apO().agq(paramString);
    if ((localbl == null) || (!localbl.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = OT(paramString);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.bBL();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bt.aFQ(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).gPa.a(str2, null, 0);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.mRd != null) {
          break label383;
        }
      }
    }
    label383:
    for (localObject = "";; localObject = locala.mRd)
    {
      if (((String)localObject).equals(str1)) {
        break label393;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.mRb = ((Cursor)localObject).getString(0);
        locala.mRc = ((Cursor)localObject).getInt(1);
        locala.mRd = ((Cursor)localObject).getString(2);
        locala.mRe = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.mRf = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.gOT = ((Cursor)localObject).getInt(8);
        locala.hfl = ((Cursor)localObject).getInt(9);
        locala.gOV = ((Cursor)localObject).getString(10);
        locala.gOW = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label393:
    if (locala.mRe != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new bl();
    ((bl)localObject).nY(paramString);
    long l;
    int i;
    if (localbl.field_createTime <= locala.createtime)
    {
      l = localbl.field_createTime - 1L;
      ((bl)localObject).kY(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((bl)localObject).setType(i);
      ((bl)localObject).setStatus(2);
      ((bl)localObject).jV(1);
      if (((bl)localObject).getType() != 34) {
        break label674;
      }
      ((bl)localObject).setContent(p.b(u.aqG(), locala.mRf, false));
      paramString = locala.getContent() + bt.eGO();
      if (i.lC(s.getFullPath(locala.getContent()), s.getFullPath(paramString)) >= 0L) {
        break label646;
      }
      ad.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
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
    ((bl)localObject).nZ(paramString);
    for (;;)
    {
      az.arV();
      com.tencent.mm.model.c.apO().an((bl)localObject);
      AppMethodBeat.o(22645);
      return;
      label674:
      ((bl)localObject).setContent(locala.getContent());
    }
  }
  
  public static String a(Context paramContext, af paramaf)
  {
    AppMethodBeat.i(22647);
    if (paramaf == null)
    {
      paramContext = paramContext.getString(2131756727);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.aJc(paramaf.getCountryCode()))
    {
      paramContext = paramaf.getCity();
      if (!bt.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = v.sj(paramaf.getProvince());
      if (!bt.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.eMO();
      paramContext = RegionCodeDecoder.getLocName(paramaf.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756727);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static void bBJ()
  {
    AppMethodBeat.i(22646);
    b localb = d.bBL();
    long l = bt.eGO() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.gPa.a((String)localObject, null, 0);
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
      localb.gPa.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(22646);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      ad.d("MicroMsg.BottleLogic", "delete path:" + s.getFullPath(localObject[i]));
      if (!bt.isNullOrNil(s.getFullPath(localObject[i]))) {
        i.deleteFile(s.getFullPath(localObject[i]));
      }
      i += 1;
    }
    AppMethodBeat.o(22646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */