package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class b
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )" };
  public h dXo;
  
  public b(h paramh)
  {
    this.dXo = paramh;
  }
  
  public static Bitmap GR(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    paramString = paramString.trim();
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return x.pg(com.tencent.mm.model.c.FG() + paramString);
  }
  
  public static String a(a parama)
  {
    switch (parama.msgType)
    {
    default: 
      return ae.getContext().getResources().getString(R.l.contact_info_masssend_tip);
    case 1: 
      return parama.bgW();
    case 3: 
      return ae.getContext().getResources().getString(R.l.app_pic);
    case 34: 
      return ae.getContext().getResources().getString(R.l.app_voice);
    }
    return ae.getContext().getResources().getString(R.l.app_video);
  }
  
  public static Bitmap d(String paramString, float paramFloat)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = null;
    }
    Object localObject;
    do
    {
      return paramString;
      paramString = paramString.trim();
      localObject = new StringBuilder();
      au.Hx();
      localObject = BackwardSupportUtil.b.e(com.tencent.mm.model.c.FG() + paramString, paramFloat);
      paramString = (String)localObject;
    } while (localObject == null);
    return Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * paramFloat), (int)(((Bitmap)localObject).getHeight() * paramFloat), true);
  }
  
  public static a i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!e.bK(paramString1)) {
      return null;
    }
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.FG();
    int i = BackwardSupportUtil.ExifHelper.YS(paramString1);
    String str = g.o((paramString1 + System.currentTimeMillis()).getBytes());
    y.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + paramString1);
    Object localObject2 = com.tencent.mm.sdk.platformtools.c.YU(paramString1);
    if ((paramInt2 == 0) && ((e.aeQ(paramString1) > 204800L) || ((localObject2 != null) && ((((BitmapFactory.Options)localObject2).outHeight > 960) || (((BitmapFactory.Options)localObject2).outWidth > 960)))))
    {
      if (!com.tencent.mm.sdk.platformtools.c.a(paramString1, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject1, str)) {
        return null;
      }
      e.f((String)localObject1, str, str + ".jpg");
    }
    for (;;)
    {
      paramString1 = str + ".jpg";
      y.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + paramString1);
      if ((paramInt2 != 0) || (i == 0) || (com.tencent.mm.sdk.platformtools.c.a((String)localObject1 + paramString1, i, Bitmap.CompressFormat.JPEG, (String)localObject1, str + ".jpg"))) {
        break;
      }
      return null;
      localObject2 = (String)localObject1 + str + ".jpg";
      paramString1 = e.c(paramString1, 0, -1);
      e.a((String)localObject2, paramString1, paramString1.length);
    }
    str = g.o((paramString1 + System.currentTimeMillis()).getBytes());
    if (!com.tencent.mm.sdk.platformtools.c.a((String)localObject1 + paramString1, 120, 120, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, str)) {
      return null;
    }
    y.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + str);
    localObject1 = new a();
    ((a)localObject1).msgType = 3;
    ((a)localObject1).maF = paramString2;
    ((a)localObject1).maG = paramInt1;
    ((a)localObject1).maE = str;
    ((a)localObject1).filename = paramString1;
    return localObject1;
  }
  
  public final a GS(String paramString)
  {
    Object localObject = null;
    paramString = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.b
 * JD-Core Version:    0.7.0.1
 */