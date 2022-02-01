package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;

public final class c
{
  private static int nUs = 1;
  private static int nUt = 1;
  
  public static String WD(String paramString)
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
  
  public static void WE(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.iRH.MR();
    ba.aBQ();
    if (com.tencent.mm.model.c.azs().aqm(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    ba.aBQ();
    bu localbu = com.tencent.mm.model.c.azs().apX(paramString);
    if ((localbu == null) || (!localbu.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = WD(paramString);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.bMW();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bt.aQN(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).hHS.a(str2, null, 0);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.nUp != null) {
          break label383;
        }
      }
    }
    label383:
    for (localObject = "";; localObject = locala.nUp)
    {
      if (((String)localObject).equals(str1)) {
        break label393;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.nUn = ((Cursor)localObject).getString(0);
        locala.nUo = ((Cursor)localObject).getInt(1);
        locala.nUp = ((Cursor)localObject).getString(2);
        locala.nUq = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.nUr = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.hHL = ((Cursor)localObject).getInt(8);
        locala.hYt = ((Cursor)localObject).getInt(9);
        locala.hHN = ((Cursor)localObject).getString(10);
        locala.hHO = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label393:
    if (locala.nUq != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new bu();
    ((bu)localObject).tN(paramString);
    long l;
    int i;
    if (localbu.field_createTime <= locala.createtime)
    {
      l = localbu.field_createTime - 1L;
      ((bu)localObject).qA(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((bu)localObject).setType(i);
      ((bu)localObject).setStatus(2);
      ((bu)localObject).kr(1);
      if (((bu)localObject).getType() != 34) {
        break label674;
      }
      ((bu)localObject).setContent(p.b(u.aAm(), locala.nUr, false));
      paramString = locala.getContent() + bt.flT();
      if (com.tencent.mm.vfs.i.mz(s.getFullPath(locala.getContent()), s.getFullPath(paramString)) >= 0L) {
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
    ((bu)localObject).tO(paramString);
    for (;;)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azs().as((bu)localObject);
      AppMethodBeat.o(22645);
      return;
      label674:
      ((bu)localObject).setContent(locala.getContent());
    }
  }
  
  public static String a(Context paramContext, am paramam)
  {
    AppMethodBeat.i(22647);
    if (paramam == null)
    {
      paramContext = paramContext.getString(2131756727);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.aUp(paramam.getCountryCode()))
    {
      paramContext = paramam.getCity();
      if (!bt.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = v.zh(paramam.getProvince());
      if (!bt.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.fsz();
      paramContext = RegionCodeDecoder.getLocName(paramam.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756727);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static void bMU()
  {
    AppMethodBeat.i(22646);
    b localb = d.bMW();
    long l = bt.flT() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.hHS.a((String)localObject, null, 0);
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
      localb.hHS.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
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
        com.tencent.mm.vfs.i.deleteFile(s.getFullPath(localObject[i]));
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