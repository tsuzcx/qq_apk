package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bl
{
  public static bl dXq = new bl();
  private SharedPreferences dXr = ae.getContext().getSharedPreferences(ae.cqR() + "_register_history", 0);
  
  public final void f(String paramString, Map<String, String> paramMap)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          y.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
          return;
        }
        if (!this.dXr.contains(paramString)) {
          break label158;
        }
        localObject = this.dXr.getString(paramString, "");
        if (!bk.bl((String)localObject))
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
        y.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        return;
      }
      continue;
      label158:
      localObject = new JSONObject();
    }
    y.i("MicroMsg.RegisterAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.dXr.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    try
    {
      y.i("MicroMsg.RegisterAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.dXr.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.dXr.getString(paramString1, ""), 0));
        if (!bk.bl((String)localObject))
        {
          y.i("MicroMsg.RegisterAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2)) {
            return ((JSONObject)localObject).getString(paramString2);
          }
        }
      }
      else
      {
        y.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.bl
 * JD-Core Version:    0.7.0.1
 */