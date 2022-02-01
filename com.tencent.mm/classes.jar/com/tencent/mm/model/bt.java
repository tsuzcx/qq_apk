package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bt
{
  public static bt hKL;
  private SharedPreferences hKM;
  
  static
  {
    AppMethodBeat.i(132261);
    hKL = new bt();
    AppMethodBeat.o(132261);
  }
  
  private bt()
  {
    AppMethodBeat.i(132258);
    this.hKM = ak.getContext().getSharedPreferences(ak.fow() + "_register_history", 0);
    AppMethodBeat.o(132258);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132260);
    try
    {
      ae.i("MicroMsg.RegisterAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.hKM.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.hKM.getString(paramString1, ""), 0));
        if (!bu.isNullOrNil((String)localObject))
        {
          ae.i("MicroMsg.RegisterAccountInfo", "get json str %s", new Object[] { localObject });
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
        ae.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(132260);
    return "";
  }
  
  public final void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(132259);
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          ae.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(132259);
          return;
        }
        if (!this.hKM.contains(paramString)) {
          break label173;
        }
        localObject = this.hKM.getString(paramString, "");
        if (!bu.isNullOrNil((String)localObject))
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
        ae.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(132259);
        return;
      }
      continue;
      label173:
      localObject = new JSONObject();
    }
    ae.i("MicroMsg.RegisterAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.hKM.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(132259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */