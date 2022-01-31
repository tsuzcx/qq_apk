package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R.l;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.k;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class c
{
  private static int hYj = 1;
  private static int hYk = 1;
  
  public static String a(Context paramContext, ad paramad)
  {
    if (paramad == null) {
      paramContext = paramContext.getString(R.l.bottle_unknowed_city);
    }
    String str;
    do
    {
      do
      {
        return paramContext;
        if (!RegionCodeDecoder.acl(paramad.getCountryCode())) {
          break;
        }
        str = paramad.getCity();
        paramContext = str;
      } while (!bk.bl(str));
      str = r.gX(paramad.getProvince());
      paramContext = str;
    } while (!bk.bl(str));
    RegionCodeDecoder.cvV();
    return RegionCodeDecoder.getLocName(paramad.getCountryCode());
    return paramContext.getString(R.l.bottle_unknowed_city);
  }
  
  public static int awF()
  {
    return hYj;
  }
  
  public static int awG()
  {
    return hYk;
  }
  
  public static int awH()
  {
    return k.Gf();
  }
  
  public static void awI()
  {
    b localb = i.awN();
    long l = bk.UY() - 7776000000L;
    Object localObject = "select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + l;
    Cursor localCursor = localb.dXo.a((String)localObject, null, 0);
    int j = localCursor.getCount();
    int i;
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
      localb.dXo.delete("bottleinfo1", "createtime< ?", new String[] { String.valueOf(l) });
    }
    if (localObject == null) {}
    for (;;)
    {
      return;
      i = 0;
      while (i < localObject.length)
      {
        y.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.q.getFullPath(localObject[i]));
        if (!bk.bl(com.tencent.mm.modelvoice.q.getFullPath(localObject[i]))) {
          e.deleteFile(com.tencent.mm.modelvoice.q.getFullPath(localObject[i]));
        }
        i += 1;
      }
    }
  }
  
  public static String b(Context paramContext, ad paramad)
  {
    if (paramad == null)
    {
      paramad = paramContext.getString(R.l.bottle_unknowed_city);
      return paramad;
    }
    String str = r.gX(paramad.getProvince());
    Object localObject = str;
    if (RegionCodeDecoder.acl(paramad.getCountryCode()))
    {
      if (!bk.bl(paramad.getCity())) {
        break label92;
      }
      localObject = new StringBuilder();
      RegionCodeDecoder.cvV();
    }
    label92:
    for (localObject = RegionCodeDecoder.getLocName(paramad.getCountryCode()) + str;; localObject = str + paramad.getCity())
    {
      paramad = (ad)localObject;
      if (!bk.bl((String)localObject)) {
        break;
      }
      return paramContext.getString(R.l.bottle_unknowed_city);
    }
  }
  
  public static void of(int paramInt)
  {
    hYj = paramInt;
  }
  
  public static void og(int paramInt)
  {
    hYk = paramInt;
  }
  
  public static int oh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 2: 
      return 3;
    case 3: 
      return 34;
    }
    return 43;
  }
  
  public static String xN(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("@bottle:");
    } while ((paramString == null) || (paramString.length < 2));
    return paramString[1];
  }
  
  public static void xO(String paramString)
  {
    a locala = null;
    com.tencent.mm.plugin.bottle.a.eUS.tk();
    au.Hx();
    if (com.tencent.mm.model.c.Fy().HP(paramString) != 1) {}
    bi localbi;
    Object localObject1;
    do
    {
      do
      {
        return;
        au.Hx();
        localbi = com.tencent.mm.model.c.Fy().HA(paramString);
      } while ((localbi == null) || (!localbi.field_talker.equals(paramString)));
      localObject1 = xN(paramString);
    } while (bk.bl((String)localObject1));
    Object localObject2 = i.awN();
    String str = "select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bk.pl((String)localObject1) + "\"";
    localObject2 = ((b)localObject2).dXo.a(str, null, 0);
    if (localObject2 == null)
    {
      locala = null;
      label127:
      if ((locala == null) || (!locala.awE().equals(localObject1)) || (locala.hYg != 1)) {
        break label489;
      }
      localObject1 = new bi();
      ((bi)localObject1).ec(paramString);
      if (localbi.field_createTime > locala.hYi) {
        break label491;
      }
    }
    label489:
    label491:
    for (long l = localbi.field_createTime - 1L;; l = locala.hYi)
    {
      ((bi)localObject1).bg(l);
      ((bi)localObject1).setType(oh(locala.msgType));
      ((bi)localObject1).setStatus(2);
      ((bi)localObject1).fA(1);
      if (((bi)localObject1).getType() != 34) {
        break label521;
      }
      ((bi)localObject1).setContent(n.d(com.tencent.mm.model.q.Gj(), locala.hYh, false));
      paramString = locala.getContent() + bk.UY();
      if (e.r(com.tencent.mm.modelvoice.q.getFullPath(locala.getContent()), com.tencent.mm.modelvoice.q.getFullPath(paramString)) >= 0L) {
        break label499;
      }
      y.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + locala.getContent());
      return;
      if (((Cursor)localObject2).moveToFirst())
      {
        locala = new a();
        locala.hYd = ((Cursor)localObject2).getString(0);
        locala.hYe = ((Cursor)localObject2).getInt(1);
        locala.hYf = ((Cursor)localObject2).getString(2);
        locala.hYg = ((Cursor)localObject2).getInt(3);
        locala.msgType = ((Cursor)localObject2).getInt(4);
        locala.hYh = ((Cursor)localObject2).getInt(5);
        locala.content = ((Cursor)localObject2).getString(6);
        locala.hYi = ((Cursor)localObject2).getLong(7);
        locala.dXk = ((Cursor)localObject2).getInt(8);
        locala.emn = ((Cursor)localObject2).getInt(9);
        locala.dXm = ((Cursor)localObject2).getString(10);
        locala.dXn = ((Cursor)localObject2).getString(11);
      }
      ((Cursor)localObject2).close();
      break label127;
      break;
    }
    label499:
    ((bi)localObject1).ed(paramString);
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.Fy().T((bi)localObject1);
      return;
      label521:
      ((bi)localObject1).setContent(locala.getContent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.c
 * JD-Core Version:    0.7.0.1
 */