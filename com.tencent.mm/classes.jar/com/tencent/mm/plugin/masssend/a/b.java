package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )" };
  public h fnw;
  
  public b(h paramh)
  {
    this.fnw = paramh;
  }
  
  public static Bitmap SB(String paramString)
  {
    AppMethodBeat.i(22726);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(22726);
      return null;
    }
    paramString = paramString.trim();
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    paramString = x.wx(c.YK() + paramString);
    AppMethodBeat.o(22726);
    return paramString;
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(22728);
    switch (parama.msgType)
    {
    default: 
      parama = ah.getContext().getResources().getString(2131298661);
      AppMethodBeat.o(22728);
      return parama;
    case 1: 
      parama = parama.bOU();
      AppMethodBeat.o(22728);
      return parama;
    case 3: 
      parama = ah.getContext().getResources().getString(2131297036);
      AppMethodBeat.o(22728);
      return parama;
    case 34: 
      parama = ah.getContext().getResources().getString(2131297105);
      AppMethodBeat.o(22728);
      return parama;
    }
    parama = ah.getContext().getResources().getString(2131297102);
    AppMethodBeat.o(22728);
    return parama;
  }
  
  public static Bitmap i(String paramString, float paramFloat)
  {
    AppMethodBeat.i(22725);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(22725);
      return null;
    }
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = BackwardSupportUtil.b.k(c.YK() + paramString, paramFloat);
    paramString = (String)localObject;
    if (localObject != null) {
      paramString = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * paramFloat), (int)(((Bitmap)localObject).getHeight() * paramFloat), true);
    }
    AppMethodBeat.o(22725);
    return paramString;
  }
  
  public static a j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22727);
    if (!e.cN(paramString1))
    {
      AppMethodBeat.o(22727);
      return null;
    }
    aw.aaz();
    Object localObject1 = c.YK();
    int i = BackwardSupportUtil.ExifHelper.bY(paramString1);
    String str = g.w((paramString1 + System.currentTimeMillis()).getBytes());
    ab.d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(paramString1)));
    Object localObject2 = d.aoT(paramString1);
    if ((paramInt2 == 0) && ((e.avI(paramString1) > 204800L) || ((localObject2 != null) && ((((BitmapFactory.Options)localObject2).outHeight > 960) || (((BitmapFactory.Options)localObject2).outWidth > 960)))))
    {
      if (!d.a(paramString1, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject1, str))
      {
        AppMethodBeat.o(22727);
        return null;
      }
      e.h((String)localObject1, str, str + ".jpg");
    }
    for (;;)
    {
      paramString1 = str + ".jpg";
      ab.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(paramString1)));
      if ((paramInt2 != 0) || (i == 0) || (d.a((String)localObject1 + paramString1, i, Bitmap.CompressFormat.JPEG, (String)localObject1, str + ".jpg"))) {
        break;
      }
      AppMethodBeat.o(22727);
      return null;
      localObject2 = (String)localObject1 + str + ".jpg";
      paramString1 = e.i(paramString1, 0, -1);
      e.a((String)localObject2, paramString1, paramString1.length);
    }
    str = g.w((paramString1 + System.currentTimeMillis()).getBytes());
    if (!d.a((String)localObject1 + paramString1, 120, 120, Bitmap.CompressFormat.JPEG, 90, (String)localObject1, str))
    {
      AppMethodBeat.o(22727);
      return null;
    }
    ab.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
    localObject1 = new a();
    ((a)localObject1).msgType = 3;
    ((a)localObject1).oBe = paramString2;
    ((a)localObject1).oBf = paramInt1;
    ((a)localObject1).oBd = str;
    ((a)localObject1).filename = paramString1;
    AppMethodBeat.o(22727);
    return localObject1;
  }
  
  public final a SC(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(22729);
    paramString = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    Cursor localCursor = this.fnw.a(paramString, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(22729);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(22729);
    return paramString;
  }
  
  public final int bOX()
  {
    int i = 0;
    AppMethodBeat.i(22724);
    Cursor localCursor = this.fnw.a("SELECT count(*) FROM massendinfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(22724);
    return i;
  }
  
  public final Cursor xL(int paramInt)
  {
    AppMethodBeat.i(22723);
    Object localObject = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + paramInt + " offset (SELECT count(*) FROM massendinfo ) -" + paramInt;
    ab.v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(localObject)));
    localObject = this.fnw.a((String)localObject, null, 0);
    AppMethodBeat.o(22723);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.b
 * JD-Core Version:    0.7.0.1
 */