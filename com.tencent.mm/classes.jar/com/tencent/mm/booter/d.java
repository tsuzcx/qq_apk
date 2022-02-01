package com.tencent.mm.booter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.al;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class d
{
  private static d fEe;
  private final String[] columns;
  private Context ctx;
  public int fEd;
  private final HashMap<String, Object> values;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(131871);
    this.fEd = -1;
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.ctx = paramContext;
    Object localObject1 = paramContext.getContentResolver();
    try
    {
      localObject1 = ((ContentResolver)localObject1).query(a.a.CONTENT_URI, this.columns, null, null, null);
      if (localObject1 == null)
      {
        AppMethodBeat.o(131871);
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
        AppMethodBeat.o(131871);
        return;
      }
      if (!"18c867f0717aa67b2ab7347505ba07ed".equals(bt.n("com.tencent.mm.coolassist", paramContext)))
      {
        localObject2.close();
        AppMethodBeat.o(131871);
        return;
      }
      com.tencent.mm.sdk.a.b.fjM();
      int i = localObject2.getColumnIndex("key");
      int j = localObject2.getColumnIndex("type");
      int k = localObject2.getColumnIndex("value");
      while (localObject2.moveToNext())
      {
        paramContext = a.resolveObj(localObject2.getInt(j), localObject2.getString(k));
        this.values.put(localObject2.getString(i), paramContext);
      }
      localObject2.close();
      AppMethodBeat.o(131871);
    }
  }
  
  public static d bJ(Context paramContext)
  {
    AppMethodBeat.i(131870);
    if (fEe == null) {
      fEe = new d(paramContext);
    }
    paramContext = fEe;
    AppMethodBeat.o(131870);
    return paramContext;
  }
  
  public final Integer getInteger(String paramString)
  {
    AppMethodBeat.i(131874);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof Integer))
    {
      ad.d("MicroMsg.Debugger", "getInteger(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Integer)localObject;
      AppMethodBeat.o(131874);
      return paramString;
    }
    AppMethodBeat.o(131874);
    return null;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(131873);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof String))
    {
      ad.d("MicroMsg.Debugger", "getString(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (String)localObject;
      AppMethodBeat.o(131873);
      return paramString;
    }
    AppMethodBeat.o(131873);
    return null;
  }
  
  public final void uc(String paramString)
  {
    boolean bool3 = false;
    AppMethodBeat.i(131872);
    Integer localInteger = getInteger(".com.tencent.mm.debug.log.level");
    boolean bool4 = bt.a(ud(".com.tencent.mm.debug.log.append_mode"), true);
    boolean bool2;
    if ((bt.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog"))) && (bt.a(ud(".com.tencent.mm.debug.test.uploadLog"), false)))
    {
      bool1 = true;
      if (bool1)
      {
        String str = getString(".com.tencent.mm.debug.log.tag.skey");
        if ((str != null) && (str.length() > 0)) {
          com.tencent.mars.xlog.Xlog.logDecryptor = new ae(str);
        }
      }
      bool2 = this.ctx.getSharedPreferences("system_config_prefs", g.abm()).getBoolean("first_launch_weixin", true);
      if (!"MM".equalsIgnoreCase(paramString)) {
        bool2 = false;
      }
      if (bool2) {
        break label244;
      }
      bool2 = true;
      label130:
      XLogSetup.keep_setupXLog(bool2, al.IpO, com.tencent.mm.loader.j.b.asb(), localInteger, Boolean.valueOf(bool4), Boolean.valueOf(bool1), paramString);
      ad.aax(ad.getLogLevel());
      if (bt.getInt(bt.bI(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
        break label249;
      }
      bool1 = true;
      label181:
      bu.wK(bool1);
      bu.fjL();
      if (getInteger(".com.tencent.mm.debug.log.level") == null) {
        break label254;
      }
    }
    label244:
    label249:
    label254:
    for (boolean bool1 = true;; bool1 = false)
    {
      bu.wL(bool1);
      if (!bu.fjL())
      {
        bool1 = bool3;
        if (!bt.a(ud(".com.tencent.mm.debug.blockReleasedPatch"), false)) {}
      }
      else
      {
        bool1 = true;
      }
      com.tencent.mm.sdk.a.b.wB(bool1);
      AppMethodBeat.o(131872);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label130;
      bool1 = false;
      break label181;
    }
  }
  
  public final Boolean ud(String paramString)
  {
    AppMethodBeat.i(131875);
    Object localObject = this.values.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(131875);
      return null;
    }
    if ((localObject instanceof Boolean))
    {
      ad.d("MicroMsg.Debugger", "getBoolean(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Boolean)localObject;
      AppMethodBeat.o(131875);
      return paramString;
    }
    AppMethodBeat.o(131875);
    return null;
  }
  
  public static final class a
  {
    public static Object resolveObj(int paramInt, String paramString)
    {
      AppMethodBeat.i(131869);
      switch (paramInt)
      {
      }
      try
      {
        ad.e("MicroMsg.Debugger.Resolver", "unknown type");
        label51:
        AppMethodBeat.o(131869);
        return null;
        paramString = Integer.valueOf(paramString);
        AppMethodBeat.o(131869);
        return paramString;
        paramString = Long.valueOf(paramString);
        AppMethodBeat.o(131869);
        return paramString;
        AppMethodBeat.o(131869);
        return paramString;
        paramString = Boolean.valueOf(paramString);
        AppMethodBeat.o(131869);
        return paramString;
        paramString = Float.valueOf(paramString);
        AppMethodBeat.o(131869);
        return paramString;
        paramString = Double.valueOf(paramString);
        AppMethodBeat.o(131869);
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