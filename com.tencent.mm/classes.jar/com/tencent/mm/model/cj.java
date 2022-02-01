package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class cj
{
  public static cj ono;
  public static boolean onp;
  private SharedPreferences omZ;
  private SharedPreferences onq;
  
  static
  {
    AppMethodBeat.i(132273);
    ono = new cj();
    onp = false;
    AppMethodBeat.o(132273);
  }
  
  private cj()
  {
    AppMethodBeat.i(132262);
    this.omZ = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_account_history", 0);
    this.onq = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_account_switch", 0);
    AppMethodBeat.o(132262);
  }
  
  private void Kf(String paramString)
  {
    AppMethodBeat.i(132270);
    if (this.omZ.contains(paramString)) {}
    try
    {
      y.deleteFile(getString(paramString, "last_avatar_path"));
      this.omZ.edit().remove(paramString).commit();
      AppMethodBeat.o(132270);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void Kb(String paramString)
  {
    AppMethodBeat.i(132266);
    if (Kd(paramString))
    {
      Set localSet = this.onq.getStringSet("first_switch_group", null);
      if (localSet != null)
      {
        localSet.remove(paramString);
        SharedPreferences.Editor localEditor = this.onq.edit();
        localEditor.remove("first_switch_group").apply();
        localEditor.putStringSet("first_switch_group", localSet).commit();
      }
    }
    if (Ke(paramString)) {
      Kf(paramString);
    }
    AppMethodBeat.o(132266);
  }
  
  public final void Kc(String paramString)
  {
    AppMethodBeat.i(241986);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(241986);
      return;
    }
    Set localSet = this.onq.getStringSet("first_switch_group", null);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    if ((!((Set)localObject).contains(paramString)) && (((Set)localObject).size() < 5)) {
      ((Set)localObject).add(paramString);
    }
    paramString = this.onq.edit();
    paramString.remove("first_switch_group").apply();
    paramString.putStringSet("first_switch_group", (Set)localObject).commit();
    AppMethodBeat.o(241986);
  }
  
  public final boolean Kd(String paramString)
  {
    AppMethodBeat.i(132268);
    Set localSet = this.onq.getStringSet("first_switch_group", null);
    if (localSet == null)
    {
      AppMethodBeat.o(132268);
      return false;
    }
    boolean bool = localSet.contains(paramString);
    AppMethodBeat.o(132268);
    return bool;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(132269);
    boolean bool = this.omZ.contains(paramString);
    AppMethodBeat.o(132269);
    return bool;
  }
  
  public final Set<String> bDj()
  {
    AppMethodBeat.i(132271);
    HashSet localHashSet = new HashSet();
    Set localSet = this.onq.getStringSet("first_switch_group", null);
    if ((localSet != null) && (!localSet.isEmpty())) {
      localHashSet.addAll(localSet);
    }
    AppMethodBeat.o(132271);
    return localHashSet;
  }
  
  public final String bDk()
  {
    AppMethodBeat.i(132272);
    Object localObject2 = bDj();
    Object localObject1 = new StringBuilder();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
      ((StringBuilder)localObject1).append(';');
    }
    if (((StringBuilder)localObject1).length() > 0) {
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    }
    Log.i("MicroMsg.SwitchAccountInfo", "switch users %s", new Object[] { ((StringBuilder)localObject1).toString() });
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(132272);
    return localObject1;
  }
  
  public final String bDl()
  {
    AppMethodBeat.i(242002);
    Object localObject2 = bDj();
    Object localObject1 = new LinkedList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(Util.nullAs(getString((String)((Iterator)localObject2).next(), "last_login_uin"), "0"));
    }
    Log.i("MicroMsg.SwitchAccountInfo", "switch users %s", new Object[] { localObject1 });
    localObject1 = TextUtils.join(";", (Iterable)localObject1);
    AppMethodBeat.o(242002);
    return localObject1;
  }
  
  public final void bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132267);
    if ((Util.isNullOrNil(new String[] { paramString1, paramString2 })) || (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(132267);
      return;
    }
    Object localObject = this.onq.getStringSet("first_switch_group", null);
    if (localObject == null) {
      localObject = new HashSet();
    }
    for (;;)
    {
      if ((((Set)localObject).contains(paramString1)) && (((Set)localObject).size() < 5)) {
        ((Set)localObject).add(paramString2);
      }
      for (;;)
      {
        paramString1 = this.onq.edit();
        paramString1.remove("first_switch_group").apply();
        paramString1.putStringSet("first_switch_group", (Set)localObject).commit();
        AppMethodBeat.o(132267);
        return;
        Iterator localIterator = ((Set)localObject).iterator();
        while (localIterator.hasNext()) {
          Kf((String)localIterator.next());
        }
        ((Set)localObject).clear();
        ((Set)localObject).add(paramString1);
        ((Set)localObject).add(paramString2);
      }
    }
  }
  
  public final void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(132264);
    if (paramMap != null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          Log.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(132264);
          return;
        }
        if (!this.omZ.contains(paramString)) {
          break label179;
        }
        localObject = this.omZ.getString(paramString, "");
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
        Log.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(132264);
        return;
      }
      continue;
      label179:
      localObject = new JSONObject();
    }
    Log.i("MicroMsg.SwitchAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.omZ.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(132264);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132265);
    try
    {
      Log.i("MicroMsg.SwitchAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.omZ.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.omZ.getString(paramString1, ""), 0));
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.i("MicroMsg.SwitchAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2))
          {
            localObject = ((JSONObject)localObject).getString(paramString2);
            AppMethodBeat.o(132265);
            return localObject;
          }
        }
      }
      else
      {
        Log.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(132265);
    return "";
  }
  
  public final void s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(132263);
    for (;;)
    {
      try
      {
        if (this.omZ.contains(paramString1))
        {
          localObject = this.omZ.getString(paramString1, "");
          if (!Util.isNullOrNil((String)localObject))
          {
            localObject = new JSONObject(new String(Base64.decode((String)localObject, 0)));
            if (!Util.isNullOrNil(new String[] { paramString2, paramString3 }))
            {
              ((JSONObject)localObject).put(paramString2, paramString3);
              Log.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", new Object[] { paramString2, ((JSONObject)localObject).toString() });
              this.omZ.edit().putString(paramString1, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
            }
            AppMethodBeat.o(132263);
            return;
          }
          localObject = new JSONObject();
          continue;
        }
        Object localObject = new JSONObject();
      }
      catch (Exception paramString3)
      {
        Log.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, paramString3.getMessage() });
        AppMethodBeat.o(132263);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cj
 * JD-Core Version:    0.7.0.1
 */