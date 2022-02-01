package com.tencent.mm.plugin.masssend.model;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;

public final class b
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )" };
  public h omV;
  
  public b(h paramh)
  {
    this.omV = paramh;
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(26350);
    switch (parama.msgType)
    {
    default: 
      parama = MMApplicationContext.getContext().getResources().getString(R.l.gBw);
      AppMethodBeat.o(26350);
      return parama;
    case 1: 
      parama = parama.fZN();
      AppMethodBeat.o(26350);
      return parama;
    case 3: 
      parama = MMApplicationContext.getContext().getResources().getString(R.l.app_pic);
      AppMethodBeat.o(26350);
      return parama;
    case 34: 
      parama = MMApplicationContext.getContext().getResources().getString(R.l.app_voice);
      AppMethodBeat.o(26350);
      return parama;
    }
    parama = MMApplicationContext.getContext().getResources().getString(R.l.app_video);
    AppMethodBeat.o(26350);
    return parama;
  }
  
  public static Bitmap aKR(String paramString)
  {
    AppMethodBeat.i(26348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26348);
      return null;
    }
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    bh.bCz();
    paramString = com.tencent.mm.model.c.bzL() + paramString;
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    localObject = r.Sg(paramString);
    paramString = (String)localObject;
    if (i != 0) {
      paramString = BitmapUtil.rotate((Bitmap)localObject, i);
    }
    AppMethodBeat.o(26348);
    return paramString;
  }
  
  public static Bitmap j(String paramString, float paramFloat)
  {
    AppMethodBeat.i(26347);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26347);
      return null;
    }
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = BackwardSupportUtil.BitmapFactory.decodeFile(com.tencent.mm.model.c.bzL() + paramString, paramFloat);
    paramString = (String)localObject;
    if (localObject != null) {
      paramString = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * paramFloat), (int)(((Bitmap)localObject).getHeight() * paramFloat), true);
    }
    AppMethodBeat.o(26347);
    return paramString;
  }
  
  public static a o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26349);
    if (!y.ZC(paramString1))
    {
      AppMethodBeat.o(26349);
      return null;
    }
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzL();
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString1);
    String str = g.getMessageDigest((paramString1 + System.currentTimeMillis()).getBytes());
    Log.d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(paramString1)));
    Object localObject2 = BitmapUtil.getImageOptions(paramString1);
    if ((paramInt2 == 0) && ((y.bEl(paramString1) > com.tencent.mm.modelimage.c.bJx()) || ((localObject2 != null) && ((((BitmapFactory.Options)localObject2).outHeight > 960) || (((BitmapFactory.Options)localObject2).outWidth > 960)))))
    {
      if (!BitmapUtil.createThumbNail(paramString1, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject1, str))
      {
        AppMethodBeat.o(26349);
        return null;
      }
      y.bF((String)localObject1, str, str + ".jpg");
    }
    for (;;)
    {
      paramString1 = str + ".jpg";
      Log.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(paramString1)));
      if ((paramInt2 != 0) || (i == 0) || (BitmapUtil.rotate((String)localObject1 + paramString1, i, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, str + ".jpg"))) {
        break;
      }
      AppMethodBeat.o(26349);
      return null;
      localObject2 = (String)localObject1 + str + ".jpg";
      paramString1 = y.bi(paramString1, 0, -1);
      y.e((String)localObject2, paramString1, paramString1.length);
    }
    str = g.getMessageDigest((paramString1 + System.currentTimeMillis()).getBytes());
    if (!BitmapUtil.createThumbNail((String)localObject1 + paramString1, 120, 120, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, str))
    {
      AppMethodBeat.o(26349);
      return null;
    }
    Log.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
    localObject1 = new a();
    ((a)localObject1).msgType = 3;
    ((a)localObject1).KNh = paramString2;
    ((a)localObject1).KNi = paramInt1;
    ((a)localObject1).KNg = str;
    ((a)localObject1).filename = paramString1;
    AppMethodBeat.o(26349);
    return localObject1;
  }
  
  public final Cursor Zj(int paramInt)
  {
    AppMethodBeat.i(26345);
    Object localObject = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + paramInt + " offset (SELECT count(*) FROM massendinfo ) -" + paramInt;
    Log.v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null);
    AppMethodBeat.o(26345);
    return localObject;
  }
  
  public final a aKS(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(26351);
    paramString = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + Util.escapeSqlValue(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.omV.rawQuery(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(26351);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(26351);
    return paramString;
  }
  
  public final int fZQ()
  {
    int i = 0;
    AppMethodBeat.i(26346);
    Cursor localCursor = this.omV.rawQuery("SELECT count(*) FROM massendinfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(26346);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.b
 * JD-Core Version:    0.7.0.1
 */