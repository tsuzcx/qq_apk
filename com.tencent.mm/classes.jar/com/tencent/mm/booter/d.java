package com.tencent.mm.booter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LogDecryptor;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.at;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class d
{
  private static d lru;
  private final String[] columns;
  private Context ctx;
  public int lrt;
  private final HashMap<String, Object> values;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(131871);
    this.lrt = -1;
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.ctx = paramContext;
    if (!"18c867f0717aa67b2ab7347505ba07ed".equals(Util.getSignaturesMd5("com.tencent.mm.coolassist", paramContext)))
    {
      AppMethodBeat.o(131871);
      return;
    }
    Object localObject = paramContext.getContentResolver();
    try
    {
      paramContext = ((ContentResolver)localObject).query(Uri.parse("content://" + paramContext.getPackageName() + ".coolassist.debugprovider/config"), this.columns, null, null, null);
      if (paramContext == null)
      {
        AppMethodBeat.o(131871);
        return;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      if (paramContext.getCount() <= 0)
      {
        paramContext.close();
        AppMethodBeat.o(131871);
        return;
      }
      CrashReportFactory.setHasDebuger(true);
      int i = paramContext.getColumnIndex("key");
      int j = paramContext.getColumnIndex("type");
      int k = paramContext.getColumnIndex("value");
      while (paramContext.moveToNext())
      {
        localObject = d.a.resolveObj(paramContext.getInt(j), paramContext.getString(k));
        this.values.put(paramContext.getString(i), localObject);
      }
      paramContext.close();
      AppMethodBeat.o(131871);
    }
  }
  
  public static d cO(Context paramContext)
  {
    AppMethodBeat.i(131870);
    if (lru == null) {
      lru = new d(paramContext);
    }
    paramContext = lru;
    AppMethodBeat.o(131870);
    return paramContext;
  }
  
  public final void Ci(String paramString)
  {
    boolean bool3 = false;
    AppMethodBeat.i(131872);
    Integer localInteger = Cj(".com.tencent.mm.debug.log.level");
    boolean bool4 = Util.nullAs(Ck(".com.tencent.mm.debug.log.append_mode"), true);
    boolean bool2;
    if ((Util.isNullOrNil(getString(".com.tencent.mm.debug.log.mmlog"))) && (Util.nullAs(Ck(".com.tencent.mm.debug.test.uploadLog"), false)))
    {
      bool1 = true;
      if (bool1)
      {
        String str = getString(".com.tencent.mm.debug.log.tag.skey");
        if ((str != null) && (str.length() > 0)) {
          com.tencent.mars.xlog.Xlog.logDecryptor = new LogDecryptor(str);
        }
      }
      bool2 = this.ctx.getSharedPreferences("system_config_prefs", g.aQe()).getBoolean("first_launch_weixin", true);
      if (!"MM".equalsIgnoreCase(paramString)) {
        bool2 = false;
      }
      if (bool2) {
        break label244;
      }
      bool2 = true;
      label130:
      XLogSetup.keep_setupXLog(bool2, at.acHr, b.bmG(), localInteger, Boolean.valueOf(bool4), Boolean.valueOf(bool1), paramString);
      Log.setLevel(Log.getLogLevel(), true);
      if (Util.getInt(Util.nullAs(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
        break label249;
      }
      bool1 = true;
      label181:
      WeChatEnvironment.setMonkeyEnv(bool1);
      WeChatEnvironment.isMonkeyEnv();
      if (Cj(".com.tencent.mm.debug.log.level") == null) {
        break label254;
      }
    }
    label244:
    label249:
    label254:
    for (boolean bool1 = true;; bool1 = false)
    {
      WeChatEnvironment.setCoolassistEnv(bool1);
      if (!WeChatEnvironment.isMonkeyEnv())
      {
        bool1 = bool3;
        if (!Util.nullAs(Ck(".com.tencent.mm.debug.blockReleasedPatch"), false)) {}
      }
      else
      {
        bool1 = true;
      }
      CrashReportFactory.setOnlinePatchBlocked(bool1);
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
  
  public final Integer Cj(String paramString)
  {
    AppMethodBeat.i(131874);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof Integer))
    {
      Log.d("MicroMsg.Debugger", "getInteger(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Integer)localObject;
      AppMethodBeat.o(131874);
      return paramString;
    }
    AppMethodBeat.o(131874);
    return null;
  }
  
  public final Boolean Ck(String paramString)
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
      Log.d("MicroMsg.Debugger", "getBoolean(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (Boolean)localObject;
      AppMethodBeat.o(131875);
      return paramString;
    }
    AppMethodBeat.o(131875);
    return null;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(131873);
    Object localObject = this.values.get(paramString);
    if ((localObject instanceof String))
    {
      Log.d("MicroMsg.Debugger", "getString(): key=" + paramString + ", value=" + localObject.toString());
      paramString = (String)localObject;
      AppMethodBeat.o(131873);
      return paramString;
    }
    AppMethodBeat.o(131873);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.d
 * JD-Core Version:    0.7.0.1
 */