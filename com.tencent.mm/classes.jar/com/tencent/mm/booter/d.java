package com.tencent.mm.booter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.p.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class d
{
  private static d dYQ;
  private final String[] columns;
  private Context ctx;
  public int dYP;
  private final HashMap<String, Object> values;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(57755);
    this.dYP = -1;
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.ctx = paramContext;
    Object localObject1 = paramContext.getContentResolver();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(a.a.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(57755);
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
        AppMethodBeat.o(57755);
        return;
      }
      if (!"18c867f0717aa67b2ab7347505ba07ed".equals(bo.m("com.tencent.mm.coolassist", paramContext)))
      {
        localObject2.close();
        AppMethodBeat.o(57755);
        return;
      }
      b.dse();
      int i = localObject2.getColumnIndex("key");
      int j = localObject2.getColumnIndex("type");
      int k = localObject2.getColumnIndex("value");
      while (localObject2.moveToNext())
      {
        paramContext = a.resolveObj(localObject2.getInt(j), localObject2.getString(k));
        this.values.put(localObject2.getString(i), paramContext);
      }
      localObject2.close();
      AppMethodBeat.o(57755);
    }
  }
  
  public static d bt(Context paramContext)
  {
    AppMethodBeat.i(57754);
    if (dYQ == null) {
      dYQ = new d(paramContext);
    }
    paramContext = dYQ;
    AppMethodBeat.o(57754);
    return paramContext;
  }
  
  public final Integer getInteger(String paramString)
  {
    AppMethodBeat.i(57758);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof Integer))
    {
      ab.d("MicroMsg.Debugger", "getInteger(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Integer)localObject;
      AppMethodBeat.o(57758);
      return paramString;
    }
    AppMethodBeat.o(57758);
    return null;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(57757);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof String))
    {
      ab.d("MicroMsg.Debugger", "getString(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (String)localObject;
      AppMethodBeat.o(57757);
      return paramString;
    }
    AppMethodBeat.o(57757);
    return null;
  }
  
  public final void kt(String paramString)
  {
    boolean bool3 = false;
    AppMethodBeat.i(57756);
    Integer localInteger = getInteger(".com.tencent.mm.debug.log.level");
    boolean bool4 = bo.a(ku(".com.tencent.mm.debug.log.append_mode"), false);
    boolean bool2;
    if ((bo.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog"))) && (bo.a(ku(".com.tencent.mm.debug.test.uploadLog"), false)))
    {
      bool1 = true;
      if (bool1)
      {
        String str = getString(".com.tencent.mm.debug.log.tag.skey");
        if ((str != null) && (str.length() > 0)) {
          com.tencent.mars.xlog.Xlog.logDecryptor = new com.tencent.mm.sdk.platformtools.ac(str);
        }
      }
      bool2 = this.ctx.getSharedPreferences("system_config_prefs", h.Mp()).getBoolean("first_launch_weixin", true);
      if (!"MM".equalsIgnoreCase(paramString)) {
        bool2 = false;
      }
      if (bool2) {
        break label244;
      }
      bool2 = true;
      label130:
      XLogSetup.keep_setupXLog(bool2, com.tencent.mm.storage.ac.yxo, e.esx, localInteger, Boolean.valueOf(bool4), Boolean.valueOf(bool1), paramString);
      ab.Ne(ab.getLogLevel());
      if (bo.getInt(bo.bf(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
        break label249;
      }
      bool1 = true;
      label181:
      bp.pN(bool1);
      bp.dsd();
      if (getInteger(".com.tencent.mm.debug.log.level") == null) {
        break label254;
      }
    }
    label244:
    label249:
    label254:
    for (boolean bool1 = true;; bool1 = false)
    {
      bp.pO(bool1);
      if (!bp.dsd())
      {
        bool1 = bool3;
        if (!bo.a(ku(".com.tencent.mm.debug.blockReleasedPatch"), false)) {}
      }
      else
      {
        bool1 = true;
      }
      b.pH(bool1);
      AppMethodBeat.o(57756);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label130;
      bool1 = false;
      break label181;
    }
  }
  
  public final Boolean ku(String paramString)
  {
    AppMethodBeat.i(57759);
    Object localObject = this.values.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(57759);
      return null;
    }
    if ((localObject instanceof Boolean))
    {
      ab.d("MicroMsg.Debugger", "getBoolean(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Boolean)localObject;
      AppMethodBeat.o(57759);
      return paramString;
    }
    AppMethodBeat.o(57759);
    return null;
  }
  
  public static final class a
  {
    public static Object resolveObj(int paramInt, String paramString)
    {
      AppMethodBeat.i(57753);
      switch (paramInt)
      {
      }
      try
      {
        ab.e("MicroMsg.Debugger.Resolver", "unknown type");
        label51:
        AppMethodBeat.o(57753);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(57753);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(57753);
        return paramString;
        AppMethodBeat.o(57753);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(57753);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(57753);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(57753);
        return paramString;
      }
      catch (Exception paramString)
      {
        break label51;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.d
 * JD-Core Version:    0.7.0.1
 */