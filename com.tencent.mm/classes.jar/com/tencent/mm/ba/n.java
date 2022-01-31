package com.tencent.mm.ba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

public final class n
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
  private h fnw;
  
  public n(h paramh)
  {
    this.fnw = paramh;
  }
  
  public static String L(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78496);
    if (paramBoolean)
    {
      paramString = a.YR() + paramString + "_chatting_bg_vertical.jpg";
      AppMethodBeat.o(78496);
      return paramString;
    }
    paramString = a.YR() + paramString + "_chatting_bg_horizontal.jpg";
    AppMethodBeat.o(78496);
    return paramString;
  }
  
  public static String Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(78497);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(78497);
      return null;
    case 3: 
    case 4: 
      paramString = L(paramString, true);
      AppMethodBeat.o(78497);
      return paramString;
    }
    paramString = L(paramString, false);
    AppMethodBeat.o(78497);
    return paramString;
  }
  
  public static String aiM()
  {
    AppMethodBeat.i(78490);
    String str = a.YR();
    AppMethodBeat.o(78490);
    return str;
  }
  
  public static String cA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78491);
    String str = paramInt1 + "_" + paramInt2 + "_thumb.jpg";
    AppMethodBeat.o(78491);
    return str;
  }
  
  public static int cg(Context paramContext)
  {
    AppMethodBeat.i(78495);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i;
    if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
      i = 1;
    }
    while (localDisplayMetrics.density <= 1.0F) {
      if (i != 0)
      {
        AppMethodBeat.o(78495);
        return 4;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(78495);
        return 2;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(78495);
      return 3;
    }
    AppMethodBeat.o(78495);
    return 1;
  }
  
  public final boolean a(m paramm)
  {
    AppMethodBeat.i(78483);
    if (paramm == null)
    {
      AppMethodBeat.o(78483);
      return false;
    }
    paramm.bsY = -1;
    paramm = paramm.convertTo();
    if ((int)this.fnw.a("packageinfo2", "localId", paramm) != -1)
    {
      doNotify();
      AppMethodBeat.o(78483);
      return true;
    }
    AppMethodBeat.o(78483);
    return false;
  }
  
  public final Cursor aiL()
  {
    AppMethodBeat.i(78486);
    Cursor localCursor = this.fnw.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null, 0);
    AppMethodBeat.o(78486);
    return localCursor;
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(78484);
    if (paramm != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = paramm.convertTo();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.fnw.update("packageinfo2", localContentValues, "id= ? and type =?", new String[] { paramm.id, paramm.cvs }) <= 0) {
        break;
      }
      doNotify();
      AppMethodBeat.o(78484);
      return true;
    }
    doNotify();
    AppMethodBeat.o(78484);
    return false;
  }
  
  public final String cB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78492);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(78492);
      return "";
    case 0: 
      AppMethodBeat.o(78492);
      return "";
    case 1: 
      localObject = paramInt1 + "_session_bg.zip";
      AppMethodBeat.o(78492);
      return localObject;
    case 2: 
      localObject = paramInt1 + "_emoji_art.temp";
      AppMethodBeat.o(78492);
      return localObject;
    case 7: 
      localObject = paramInt1 + "_configlist.cfg";
      AppMethodBeat.o(78492);
      return localObject;
    case 9: 
      AppMethodBeat.o(78492);
      return "_speex_upload.cfg";
    case 12: 
      AppMethodBeat.o(78492);
      return "_rcpt_addr";
    case 18: 
      localObject = cz(paramInt1, paramInt2);
      localObject = ((m)localObject).version + "_feature.zip";
      AppMethodBeat.o(78492);
      return localObject;
    case 5: 
      AppMethodBeat.o(78492);
      return "brand_i18n.apk";
    case 19: 
      AppMethodBeat.o(78492);
      return "_report_reason.temp";
    case 20: 
      AppMethodBeat.o(78492);
      return "_pluginDesc.cfg";
    case 21: 
      AppMethodBeat.o(78492);
      return "_trace_config.cfg";
    case 23: 
      AppMethodBeat.o(78492);
      return "permissioncfg.cfg";
    case 26: 
      AppMethodBeat.o(78492);
      return "ipcallCountryCodeConfig.cfg";
    }
    Object localObject = paramInt1 + "_sensewhere.xml";
    AppMethodBeat.o(78492);
    return localObject;
  }
  
  public final String cC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78493);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(78493);
      return "";
    case 0: 
      AppMethodBeat.o(78493);
      return "";
    case 1: 
      str = a.YR() + paramInt1 + "_session_bg/";
      try
      {
        File localFile = new File(str);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        AppMethodBeat.o(78493);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.PackageInfoStorage", "exception:%s", new Object[] { bo.l(localException) });
          ab.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = ".concat(String.valueOf(str)));
        }
      }
    case 2: 
      AppMethodBeat.o(78493);
      return "";
    }
    String str = cB(paramInt1, paramInt2);
    str = a.YR() + str.replace(".zip", "");
    AppMethodBeat.o(78493);
    return str;
  }
  
  public final void cD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78494);
    e.deleteFile(a.YR() + cB(paramInt1, paramInt2));
    m localm = cz(paramInt1, paramInt2);
    if (localm != null)
    {
      localm.status = 5;
      r.aiP().b(localm);
    }
    AppMethodBeat.o(78494);
  }
  
  public final m cz(int paramInt1, int paramInt2)
  {
    m localm = null;
    AppMethodBeat.i(78487);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + bo.wC(String.valueOf(paramInt1)) + "\" and packageinfo2.type = \"" + bo.wC(String.valueOf(paramInt2)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(78487);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localm = new m();
      localm.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(78487);
    return localm;
  }
  
  public final boolean lQ(int paramInt)
  {
    AppMethodBeat.i(78485);
    String str = "update packageinfo2 set status = 2 where status = 1 and type = " + paramInt + ";";
    boolean bool = this.fnw.execSQL("packageinfo2", str);
    doNotify();
    AppMethodBeat.o(78485);
    return bool;
  }
  
  public final boolean lR(int paramInt)
  {
    AppMethodBeat.i(78488);
    if (this.fnw.delete("packageinfo2", "type =?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      doNotify();
      AppMethodBeat.o(78488);
      return true;
    }
    AppMethodBeat.o(78488);
    return false;
  }
  
  public final m[] lS(int paramInt)
  {
    AppMethodBeat.i(78489);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=".concat(String.valueOf(paramInt));
    localObject = this.fnw.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      m localm = new m();
      localm.convertFrom((Cursor)localObject);
      localArrayList.add(localm);
    }
    ((Cursor)localObject).close();
    localObject = (m[])localArrayList.toArray(new m[localArrayList.size()]);
    AppMethodBeat.o(78489);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.n
 * JD-Core Version:    0.7.0.1
 */