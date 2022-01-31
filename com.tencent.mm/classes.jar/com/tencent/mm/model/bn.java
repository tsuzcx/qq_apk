package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bn
{
  public static bn fnx;
  private SharedPreferences fny;
  
  static
  {
    AppMethodBeat.i(58117);
    fnx = new bn();
    AppMethodBeat.o(58117);
  }
  
  private bn()
  {
    AppMethodBeat.i(58114);
    this.fny = ah.getContext().getSharedPreferences(ah.dsP() + "_register_history", 0);
    AppMethodBeat.o(58114);
  }
  
  public final void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(58115);
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          ab.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(58115);
          return;
        }
        if (!this.fny.contains(paramString)) {
          break label173;
        }
        localObject = this.fny.getString(paramString, "");
        if (!bo.isNullOrNil((String)localObject))
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
        ab.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(58115);
        return;
      }
      continue;
      label173:
      localObject = new JSONObject();
    }
    ab.i("MicroMsg.RegisterAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.fny.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(58115);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58116);
    try
    {
      ab.i("MicroMsg.RegisterAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.fny.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.fny.getString(paramString1, ""), 0));
        if (!bo.isNullOrNil((String)localObject))
        {
          ab.i("MicroMsg.RegisterAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2))
          {
            localObject = ((JSONObject)localObject).getString(paramString2);
            AppMethodBeat.o(58116);
            return localObject;
          }
        }
      }
      else
      {
        ab.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(58116);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bn
 * JD-Core Version:    0.7.0.1
 */