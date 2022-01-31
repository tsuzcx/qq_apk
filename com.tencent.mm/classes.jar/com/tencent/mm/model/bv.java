package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bv
{
  public static bv dXJ = new bv();
  private SharedPreferences dXK = ae.getContext().getSharedPreferences(ae.cqR() + "_account_switch", 0);
  private SharedPreferences dXr = ae.getContext().getSharedPreferences(ae.cqR() + "_account_history", 0);
  
  private void iV(String paramString)
  {
    if (this.dXr.contains(paramString)) {}
    try
    {
      e.deleteFile(getString(paramString, "last_avatar_path"));
      this.dXr.edit().remove(paramString).commit();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final Set<String> Ii()
  {
    HashSet localHashSet = new HashSet();
    Set localSet = this.dXK.getStringSet("first_switch_group", null);
    if ((localSet != null) && (!localSet.isEmpty())) {
      localHashSet.addAll(localSet);
    }
    return localHashSet;
  }
  
  public final String Ij()
  {
    Object localObject = Ii();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((String)((Iterator)localObject).next());
      localStringBuilder.append(';');
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    y.i("MicroMsg.SwitchAccountInfo", "switch users %s", new Object[] { localStringBuilder.toString() });
    return localStringBuilder.toString();
  }
  
  public final void ab(String paramString1, String paramString2)
  {
    if ((bk.H(new String[] { paramString1, paramString2 })) || (paramString1.equals(paramString2))) {
      return;
    }
    Object localObject = this.dXK.getStringSet("first_switch_group", null);
    if (localObject == null) {
      localObject = new HashSet();
    }
    for (;;)
    {
      if ((((Set)localObject).contains(paramString1)) && (((Set)localObject).size() < 2)) {
        ((Set)localObject).add(paramString2);
      }
      for (;;)
      {
        paramString1 = this.dXK.edit();
        paramString1.remove("first_switch_group").apply();
        paramString1.putStringSet("first_switch_group", (Set)localObject).commit();
        return;
        Iterator localIterator = ((Set)localObject).iterator();
        while (localIterator.hasNext()) {
          iV((String)localIterator.next());
        }
        ((Set)localObject).clear();
        ((Set)localObject).add(paramString1);
        ((Set)localObject).add(paramString2);
      }
    }
  }
  
  public final void f(String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          y.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
          return;
        }
        if (!this.dXr.contains(paramString)) {
          break label162;
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
        y.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        return;
      }
      continue;
      label162:
      localObject = new JSONObject();
    }
    y.i("MicroMsg.SwitchAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.dXr.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    try
    {
      y.i("MicroMsg.SwitchAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.dXr.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.dXr.getString(paramString1, ""), 0));
        if (!bk.bl((String)localObject))
        {
          y.i("MicroMsg.SwitchAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2)) {
            return ((JSONObject)localObject).getString(paramString2);
          }
        }
      }
      else
      {
        y.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    return "";
  }
  
  public final void iS(String paramString)
  {
    if (iT(paramString))
    {
      Set localSet = this.dXK.getStringSet("first_switch_group", null);
      if (localSet != null)
      {
        localSet.remove(paramString);
        SharedPreferences.Editor localEditor = this.dXK.edit();
        localEditor.remove("first_switch_group").apply();
        localEditor.putStringSet("first_switch_group", localSet).commit();
      }
    }
    if (iU(paramString)) {
      iV(paramString);
    }
  }
  
  public final boolean iT(String paramString)
  {
    Set localSet = this.dXK.getStringSet("first_switch_group", null);
    if (localSet == null) {
      return false;
    }
    return localSet.contains(paramString);
  }
  
  public final boolean iU(String paramString)
  {
    return this.dXr.contains(paramString);
  }
  
  public final void l(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (this.dXr.contains(paramString1))
        {
          localObject = this.dXr.getString(paramString1, "");
          if (!bk.bl((String)localObject))
          {
            localObject = new JSONObject(new String(Base64.decode((String)localObject, 0)));
            if (bk.H(new String[] { paramString2, paramString3 })) {
              break;
            }
            ((JSONObject)localObject).put(paramString2, paramString3);
            y.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", new Object[] { paramString2, ((JSONObject)localObject).toString() });
            this.dXr.edit().putString(paramString1, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
            return;
          }
          localObject = new JSONObject();
          continue;
        }
        Object localObject = new JSONObject();
      }
      catch (Exception paramString3)
      {
        y.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, paramString3.getMessage() });
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */