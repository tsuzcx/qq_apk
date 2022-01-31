package com.tencent.mm.booter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.p.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ac;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class c
{
  private static c dhD;
  private final String[] columns = { "_id", "key", "type", "value" };
  private Context ctx;
  public int dhC = -1;
  private final HashMap<String, Object> values = new HashMap();
  
  private c(Context paramContext)
  {
    this.ctx = paramContext;
    Object localObject1 = paramContext.getContentResolver();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(a.a.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = null;
      }
      if (localObject2.getCount() <= 0)
      {
        localObject2.close();
        return;
      }
      if (!"18c867f0717aa67b2ab7347505ba07ed".equals(bk.k("com.tencent.mm.coolassist", paramContext)))
      {
        localObject2.close();
        return;
      }
      b.cqj();
      int i = localObject2.getColumnIndex("key");
      int j = localObject2.getColumnIndex("type");
      int k = localObject2.getColumnIndex("value");
      while (localObject2.moveToNext())
      {
        paramContext = a.j(localObject2.getInt(j), localObject2.getString(k));
        this.values.put(localObject2.getString(i), paramContext);
      }
      localObject2.close();
    }
  }
  
  public static c aS(Context paramContext)
  {
    if (dhD == null) {
      dhD = new c(paramContext);
    }
    return dhD;
  }
  
  public final void em(String paramString)
  {
    boolean bool3 = true;
    Integer localInteger = getInteger(".com.tencent.mm.debug.log.level");
    boolean bool4 = bk.a(en(".com.tencent.mm.debug.log.append_mode"), false);
    boolean bool2;
    if ((bk.bl(getString(".com.tencent.mm.debug.log.mmlog"))) && (bk.a(en(".com.tencent.mm.debug.test.uploadLog"), false)))
    {
      bool1 = true;
      if (bool1)
      {
        String str = getString(".com.tencent.mm.debug.log.tag.skey");
        if ((str != null) && (str.length() > 0)) {
          com.tencent.mars.xlog.Xlog.logDecryptor = new z(str);
        }
      }
      bool2 = this.ctx.getSharedPreferences("system_config_prefs", 4).getBoolean("first_launch_weixin", true);
      if (!"MM".equalsIgnoreCase(paramString)) {
        bool2 = false;
      }
      if (bool2) {
        break label183;
      }
      bool2 = true;
      label123:
      XLogSetup.keep_setupXLog(bool2, ac.unx, e.dzJ, localInteger, Boolean.valueOf(bool4), Boolean.valueOf(bool1), paramString);
      y.Fc(y.getLogLevel());
      if (bk.getInt(bk.aM(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      bl.my(bool1);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label123;
    }
  }
  
  public final Boolean en(String paramString)
  {
    Object localObject = this.values.get(paramString);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Boolean))
    {
      y.d("MicroMsg.Debugger", "getBoolean(): key=" + paramString + ", value=" + localObject.toString());
      return (Boolean)localObject;
    }
    return null;
  }
  
  public final Integer getInteger(String paramString)
  {
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof Integer))
    {
      y.d("MicroMsg.Debugger", "getInteger(): key=" + paramString + ", value=" + localObject.toString());
      return (Integer)localObject;
    }
    return null;
  }
  
  public final String getString(String paramString)
  {
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof String))
    {
      y.d("MicroMsg.Debugger", "getString(): key=" + paramString + ", value=" + localObject.toString());
      return (String)localObject;
    }
    return null;
  }
  
  public static final class a
  {
    public static Object j(int paramInt, String paramString)
    {
      String str = paramString;
      switch (paramInt)
      {
      default: 
      case 1: 
      case 2: 
      case 4: 
      case 5: 
      case 6: 
        try
        {
          y.e("MicroMsg.Debugger.Resolver", "unknown type");
        }
        catch (Exception paramString)
        {
          str = null;
        }
        return Integer.valueOf(paramString);
        return Long.valueOf(paramString);
        return Boolean.valueOf(paramString);
        return Float.valueOf(paramString);
        paramString = Double.valueOf(paramString);
        return paramString;
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.c
 * JD-Core Version:    0.7.0.1
 */