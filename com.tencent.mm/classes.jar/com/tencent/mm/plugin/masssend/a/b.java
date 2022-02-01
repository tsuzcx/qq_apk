package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.i;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )" };
  public h hpA;
  
  public b(h paramh)
  {
    this.hpA = paramh;
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(26350);
    switch (parama.msgType)
    {
    default: 
      parama = ai.getContext().getResources().getString(2131757722);
      AppMethodBeat.o(26350);
      return parama;
    case 1: 
      parama = parama.dbr();
      AppMethodBeat.o(26350);
      return parama;
    case 3: 
      parama = ai.getContext().getResources().getString(2131755853);
      AppMethodBeat.o(26350);
      return parama;
    case 34: 
      parama = ai.getContext().getResources().getString(2131755929);
      AppMethodBeat.o(26350);
      return parama;
    }
    parama = ai.getContext().getResources().getString(2131755926);
    AppMethodBeat.o(26350);
    return parama;
  }
  
  public static Bitmap akx(String paramString)
  {
    AppMethodBeat.i(26348);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(26348);
      return null;
    }
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    az.ayM();
    paramString = c.awL() + paramString;
    int i = BackwardSupportUtil.ExifHelper.ce(paramString);
    localObject = u.FE(paramString);
    paramString = (String)localObject;
    if (i != 0) {
      paramString = f.a((Bitmap)localObject, i);
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
    az.ayM();
    localObject = BackwardSupportUtil.b.n(c.awL() + paramString, paramFloat);
    paramString = (String)localObject;
    if (localObject != null) {
      paramString = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * paramFloat), (int)(((Bitmap)localObject).getHeight() * paramFloat), true);
    }
    AppMethodBeat.o(26347);
    return paramString;
  }
  
  public static a l(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26349);
    if (!i.eA(paramString1))
    {
      AppMethodBeat.o(26349);
      return null;
    }
    az.ayM();
    Object localObject1 = c.awL();
    int i = BackwardSupportUtil.ExifHelper.ce(paramString1);
    String str = g.getMessageDigest((paramString1 + System.currentTimeMillis()).getBytes());
    ac.d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(paramString1)));
    Object localObject2 = f.aKw(paramString1);
    if ((paramInt2 == 0) && ((i.aSp(paramString1) > 204800L) || ((localObject2 != null) && ((((BitmapFactory.Options)localObject2).outHeight > 960) || (((BitmapFactory.Options)localObject2).outWidth > 960)))))
    {
      if (!f.a(paramString1, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject1, str))
      {
        AppMethodBeat.o(26349);
        return null;
      }
      i.aT((String)localObject1, str, str + ".jpg");
    }
    for (;;)
    {
      paramString1 = str + ".jpg";
      ac.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(paramString1)));
      if ((paramInt2 != 0) || (i == 0) || (f.a((String)localObject1 + paramString1, i, Bitmap.CompressFormat.JPEG, (String)localObject1, str + ".jpg"))) {
        break;
      }
      AppMethodBeat.o(26349);
      return null;
      localObject2 = (String)localObject1 + str + ".jpg";
      paramString1 = i.aU(paramString1, 0, -1);
      i.e((String)localObject2, paramString1, paramString1.length);
    }
    str = g.getMessageDigest((paramString1 + System.currentTimeMillis()).getBytes());
    if (!f.a((String)localObject1 + paramString1, 120, 120, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, str))
    {
      AppMethodBeat.o(26349);
      return null;
    }
    ac.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
    localObject1 = new a();
    ((a)localObject1).msgType = 3;
    ((a)localObject1).uEc = paramString2;
    ((a)localObject1).uEd = paramInt1;
    ((a)localObject1).uEb = str;
    ((a)localObject1).filename = paramString1;
    AppMethodBeat.o(26349);
    return localObject1;
  }
  
  public final Cursor Hi(int paramInt)
  {
    AppMethodBeat.i(26345);
    Object localObject = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + paramInt + " offset (SELECT count(*) FROM massendinfo ) -" + paramInt;
    ac.v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(localObject)));
    localObject = this.hpA.a((String)localObject, null, 0);
    AppMethodBeat.o(26345);
    return localObject;
  }
  
  public final a aky(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(26351);
    paramString = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.hpA.a(paramString, null, 2);
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
  
  public final int dbu()
  {
    int i = 0;
    AppMethodBeat.i(26346);
    Cursor localCursor = this.hpA.a("SELECT count(*) FROM massendinfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(26346);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.b
 * JD-Core Version:    0.7.0.1
 */