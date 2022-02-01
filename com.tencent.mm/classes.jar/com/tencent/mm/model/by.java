package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class by
{
  public static by lvB;
  private SharedPreferences lvC;
  
  static
  {
    AppMethodBeat.i(132261);
    lvB = new by();
    AppMethodBeat.o(132261);
  }
  
  private by()
  {
    AppMethodBeat.i(132258);
    this.lvC = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_register_history", 0);
    AppMethodBeat.o(132258);
  }
  
  public final void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(132259);
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          Log.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(132259);
          return;
        }
        if (!this.lvC.contains(paramString)) {
          break label173;
        }
        localObject = this.lvC.getString(paramString, "");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = new JSONObject(new String(Base64.decode((String)localObject, 0)));
          Iterator localIterator = paramMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          String str = (String)localIterator.next();
          ((JSONObject)localObject).put(str, paramMap.get(str));
          continue;
        }
        localObject = new JSONObject();
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(132259);
        return;
      }
      continue;
      label173:
      localObject = new JSONObject();
    }
    Log.i("MicroMsg.RegisterAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.lvC.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(132259);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132260);
    try
    {
      Log.i("MicroMsg.RegisterAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.lvC.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.lvC.getString(paramString1, ""), 0));
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.i("MicroMsg.RegisterAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2))
          {
            localObject = ((JSONObject)localObject).getString(paramString2);
            AppMethodBeat.o(132260);
            return localObject;
          }
        }
      }
      else
      {
        Log.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(132260);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */