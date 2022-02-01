package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;

public final class c
{
  private static int ntw = 1;
  private static int ntx = 1;
  
  public static String Td(String paramString)
  {
    AppMethodBeat.i(22644);
    if (bs.isNullOrNil(paramString))
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
  
  public static void Te(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(22645);
    com.tencent.mm.plugin.bottle.a.iyy.Lj();
    az.ayM();
    if (com.tencent.mm.model.c.awD().aly(paramString) != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    az.ayM();
    bo localbo = com.tencent.mm.model.c.awD().alk(paramString);
    if ((localbo == null) || (!localbo.field_talker.equals(paramString)))
    {
      AppMethodBeat.o(22645);
      return;
    }
    String str1 = Td(paramString);
    if (bs.isNullOrNil(str1))
    {
      AppMethodBeat.o(22645);
      return;
    }
    Object localObject = d.bIJ();
    String str2 = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bs.aLh(String.valueOf(str1)) + "\"";
    localObject = ((b)localObject).hpA.a(str2, null, 0);
    if (localObject == null)
    {
      locala = null;
      if (locala != null) {
        if (locala.ntt != null) {
          break label383;
        }
      }
    }
    label383:
    for (localObject = "";; localObject = locala.ntt)
    {
      if (((String)localObject).equals(str1)) {
        break label393;
      }
      AppMethodBeat.o(22645);
      return;
      if (((Cursor)localObject).moveToFirst())
      {
        locala = new a();
        locala.ntr = ((Cursor)localObject).getString(0);
        locala.nts = ((Cursor)localObject).getInt(1);
        locala.ntt = ((Cursor)localObject).getString(2);
        locala.ntu = ((Cursor)localObject).getInt(3);
        locala.msgType = ((Cursor)localObject).getInt(4);
        locala.ntv = ((Cursor)localObject).getInt(5);
        locala.content = ((Cursor)localObject).getString(6);
        locala.createtime = ((Cursor)localObject).getLong(7);
        locala.hpt = ((Cursor)localObject).getInt(8);
        locala.hFO = ((Cursor)localObject).getInt(9);
        locala.hpv = ((Cursor)localObject).getString(10);
        locala.hpw = ((Cursor)localObject).getString(11);
      }
      ((Cursor)localObject).close();
      break;
    }
    label393:
    if (locala.ntu != 1)
    {
      AppMethodBeat.o(22645);
      return;
    }
    localObject = new bo();
    ((bo)localObject).re(paramString);
    long l;
    int i;
    if (localbo.field_createTime <= locala.createtime)
    {
      l = localbo.field_createTime - 1L;
      ((bo)localObject).oA(l);
      switch (locala.msgType)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((bo)localObject).setType(i);
      ((bo)localObject).setStatus(2);
      ((bo)localObject).jT(1);
      if (((bo)localObject).getType() != 34) {
        break label674;
      }
      ((bo)localObject).setContent(p.b(u.axw(), locala.ntv, false));
      paramString = locala.getContent() + bs.eWj();
      if (i.lZ(s.getFullPath(locala.getContent()), s.getFullPath(paramString)) >= 0L) {
        break label646;
      }
      ac.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
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
    ((bo)localObject).rf(paramString);
    for (;;)
    {
      az.ayM();
      com.tencent.mm.model.c.awD().ap((bo)localObject);
      AppMethodBeat.o(22645);
      return;
      label674:
      ((bo)localObject).setContent(locala.getContent());
    }
  }
  
  public static String a(Context paramContext, ai paramai)
  {
    AppMethodBeat.i(22647);
    if (paramai == null)
    {
      paramContext = paramContext.getString(2131756727);
      AppMethodBeat.o(22647);
      return paramContext;
    }
    if (RegionCodeDecoder.aOy(paramai.getCountryCode()))
    {
      paramContext = paramai.getCity();
      if (!bs.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      paramContext = v.wm(paramai.getProvince());
      if (!bs.isNullOrNil(paramContext))
      {
        AppMethodBeat.o(22647);
        return paramContext;
      }
      RegionCodeDecoder.fcs();
      paramContext = RegionCodeDecoder.getLocName(paramai.getCountryCode());
      AppMethodBeat.o(22647);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756727);
    AppMethodBeat.o(22647);
    return paramContext;
  }
  
  public static void bIH()
  {
    AppMethodBeat.i(22646);
    b localb = d.bIJ();
    long l = bs.eWj() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(l));
    Cursor localCursor = localb.hpA.a((String)localObject, null, 0);
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
      localb.hpA.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null)
    {
      AppMethodBeat.o(22646);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      ac.d("MicroMsg.BottleLogic", "delete path:" + s.getFullPath(localObject[i]));
      if (!bs.isNullOrNil(s.getFullPath(localObject[i]))) {
        i.deleteFile(s.getFullPath(localObject[i]));
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