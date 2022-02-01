package com.tencent.mm.modelpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import junit.framework.Assert;

public final class t
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  public h omV;
  
  public t(h paramh)
  {
    this.omV = paramh;
  }
  
  public static String Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150850);
    if (paramBoolean)
    {
      paramString = a.bzS() + paramString + "_chatting_bg_vertical.jpg";
      AppMethodBeat.o(150850);
      return paramString;
    }
    paramString = a.bzS() + paramString + "_chatting_bg_horizontal.jpg";
    AppMethodBeat.o(150850);
    return paramString;
  }
  
  public static String aV(String paramString, int paramInt)
  {
    AppMethodBeat.i(150851);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(150851);
      return null;
    case 3: 
    case 4: 
      paramString = Z(paramString, true);
      AppMethodBeat.o(150851);
      return paramString;
    }
    paramString = Z(paramString, false);
    AppMethodBeat.o(150851);
    return paramString;
  }
  
  public static String bLE()
  {
    AppMethodBeat.i(150844);
    String str = a.bzS();
    AppMethodBeat.o(150844);
    return str;
  }
  
  public static int dT(Context paramContext)
  {
    AppMethodBeat.i(150849);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i;
    if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
      i = 1;
    }
    while (localDisplayMetrics.density <= 1.0F) {
      if (i != 0)
      {
        AppMethodBeat.o(150849);
        return 4;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(150849);
        return 2;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(150849);
      return 3;
    }
    AppMethodBeat.o(150849);
    return 1;
  }
  
  public static String eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150845);
    String str = paramInt1 + "_" + paramInt2 + "_thumb.jpg";
    AppMethodBeat.o(150845);
    return str;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(150837);
    if (params == null)
    {
      AppMethodBeat.o(150837);
      return false;
    }
    params.eQp = -1;
    params = params.convertTo();
    if ((int)this.omV.insert("packageinfo2", "localId", params) != -1)
    {
      doNotify();
      AppMethodBeat.o(150837);
      return true;
    }
    AppMethodBeat.o(150837);
    return false;
  }
  
  public final boolean b(s params)
  {
    AppMethodBeat.i(150838);
    if (params != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = params.convertTo();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.omV.update("packageinfo2", localContentValues, "id= ? and type =?", new String[] { params.id, params.hJK }) <= 0) {
        break;
      }
      doNotify();
      AppMethodBeat.o(150838);
      return true;
    }
    doNotify();
    AppMethodBeat.o(150838);
    return false;
  }
  
  public final Cursor bLD()
  {
    AppMethodBeat.i(150840);
    Cursor localCursor = this.omV.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null);
    AppMethodBeat.o(150840);
    return localCursor;
  }
  
  public final s eI(int paramInt1, int paramInt2)
  {
    s locals = null;
    AppMethodBeat.i(150841);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + Util.escapeSqlValue(String.valueOf(paramInt1)) + "\" and packageinfo2.type = \"" + Util.escapeSqlValue(String.valueOf(paramInt2)) + "\"";
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(150841);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      locals = new s();
      locals.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(150841);
    return locals;
  }
  
  public final String eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150846);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(150846);
      return "";
    case 0: 
      AppMethodBeat.o(150846);
      return "";
    case 1: 
      localObject = paramInt1 + "_session_bg.zip";
      AppMethodBeat.o(150846);
      return localObject;
    case 2: 
      localObject = paramInt1 + "_emoji_art.temp";
      AppMethodBeat.o(150846);
      return localObject;
    case 7: 
      localObject = paramInt1 + "_configlist.cfg";
      AppMethodBeat.o(150846);
      return localObject;
    case 9: 
      AppMethodBeat.o(150846);
      return "_speex_upload.cfg";
    case 12: 
      AppMethodBeat.o(150846);
      return "_rcpt_addr";
    case 18: 
      localObject = eI(paramInt1, paramInt2);
      localObject = ((s)localObject).version + "_feature.zip";
      AppMethodBeat.o(150846);
      return localObject;
    case 5: 
      AppMethodBeat.o(150846);
      return "brand_i18n.apk";
    case 19: 
      AppMethodBeat.o(150846);
      return "_report_reason.temp";
    case 20: 
      AppMethodBeat.o(150846);
      return "_pluginDesc.cfg";
    case 21: 
      AppMethodBeat.o(150846);
      return "_trace_config.cfg";
    case 23: 
      AppMethodBeat.o(150846);
      return "permissioncfg.cfg";
    case 26: 
      AppMethodBeat.o(150846);
      return "ipcallCountryCodeConfig.cfg";
    }
    Object localObject = paramInt1 + "_sensewhere.xml";
    AppMethodBeat.o(150846);
    return localObject;
  }
  
  public final String eL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150847);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(150847);
      return "";
    case 0: 
      AppMethodBeat.o(150847);
      return "";
    case 1: 
      str = a.bzS() + paramInt1 + "_session_bg/";
      try
      {
        com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(str);
        if (!localu.jKS()) {
          localu.jKY();
        }
        AppMethodBeat.o(150847);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.PackageInfoStorage", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
          Log.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = ".concat(String.valueOf(str)));
        }
      }
    case 2: 
      AppMethodBeat.o(150847);
      return "";
    }
    String str = eK(paramInt1, paramInt2);
    str = a.bzS() + str.replace(".zip", "");
    AppMethodBeat.o(150847);
    return str;
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150848);
    y.deleteFile(a.bzS() + eK(paramInt1, paramInt2));
    s locals = eI(paramInt1, paramInt2);
    if (locals != null)
    {
      locals.status = 5;
      u.bLH().b(locals);
    }
    AppMethodBeat.o(150848);
  }
  
  public final boolean wI(int paramInt)
  {
    AppMethodBeat.i(150839);
    String str = "update packageinfo2 set status = 2 where status = 1 and type = " + paramInt + ";";
    boolean bool = this.omV.execSQL("packageinfo2", str);
    doNotify();
    AppMethodBeat.o(150839);
    return bool;
  }
  
  public final boolean wJ(int paramInt)
  {
    AppMethodBeat.i(150842);
    if (this.omV.delete("packageinfo2", "type =?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      doNotify();
      AppMethodBeat.o(150842);
      return true;
    }
    AppMethodBeat.o(150842);
    return false;
  }
  
  public final s[] wK(int paramInt)
  {
    AppMethodBeat.i(150843);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=".concat(String.valueOf(paramInt));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    localObject = (s[])localArrayList.toArray(new s[localArrayList.size()]);
    AppMethodBeat.o(150843);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.t
 * JD-Core Version:    0.7.0.1
 */