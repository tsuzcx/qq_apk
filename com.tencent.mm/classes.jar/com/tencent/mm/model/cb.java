package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class cb
{
  public static cb hIi;
  private SharedPreferences hHU;
  private SharedPreferences hIj;
  
  static
  {
    AppMethodBeat.i(132273);
    hIi = new cb();
    AppMethodBeat.o(132273);
  }
  
  private cb()
  {
    AppMethodBeat.i(132262);
    this.hHU = aj.getContext().getSharedPreferences(aj.fkC() + "_account_history", 0);
    this.hIj = aj.getContext().getSharedPreferences(aj.fkC() + "_account_switch", 0);
    AppMethodBeat.o(132262);
  }
  
  private void BC(String paramString)
  {
    AppMethodBeat.i(132270);
    if (this.hHU.contains(paramString)) {}
    try
    {
      i.deleteFile(getString(paramString, "last_avatar_path"));
      this.hHU.edit().remove(paramString).commit();
      AppMethodBeat.o(132270);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final boolean BA(String paramString)
  {
    AppMethodBeat.i(132268);
    Set localSet = this.hIj.getStringSet("first_switch_group", null);
    if (localSet == null)
    {
      AppMethodBeat.o(132268);
      return false;
    }
    boolean bool = localSet.contains(paramString);
    AppMethodBeat.o(132268);
    return bool;
  }
  
  public final boolean BB(String paramString)
  {
    AppMethodBeat.i(132269);
    boolean bool = this.hHU.contains(paramString);
    AppMethodBeat.o(132269);
    return bool;
  }
  
  public final void Bz(String paramString)
  {
    AppMethodBeat.i(132266);
    if (BA(paramString))
    {
      Set localSet = this.hIj.getStringSet("first_switch_group", null);
      if (localSet != null)
      {
        localSet.remove(paramString);
        SharedPreferences.Editor localEditor = this.hIj.edit();
        localEditor.remove("first_switch_group").apply();
        localEditor.putStringSet("first_switch_group", localSet).commit();
      }
    }
    if (BB(paramString)) {
      BC(paramString);
    }
    AppMethodBeat.o(132266);
  }
  
  public final Set<String> aCA()
  {
    AppMethodBeat.i(132271);
    HashSet localHashSet = new HashSet();
    Set localSet = this.hIj.getStringSet("first_switch_group", null);
    if ((localSet != null) && (!localSet.isEmpty())) {
      localHashSet.addAll(localSet);
    }
    AppMethodBeat.o(132271);
    return localHashSet;
  }
  
  public final String aCB()
  {
    AppMethodBeat.i(132272);
    Object localObject2 = aCA();
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
    ad.i("MicroMsg.SwitchAccountInfo", "switch users %s", new Object[] { ((StringBuilder)localObject1).toString() });
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(132272);
    return localObject1;
  }
  
  public final void aP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132267);
    if ((bt.V(new String[] { paramString1, paramString2 })) || (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(132267);
      return;
    }
    Object localObject = this.hIj.getStringSet("first_switch_group", null);
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
        paramString1 = this.hIj.edit();
        paramString1.remove("first_switch_group").apply();
        paramString1.putStringSet("first_switch_group", (Set)localObject).commit();
        AppMethodBeat.o(132267);
        return;
        Iterator localIterator = ((Set)localObject).iterator();
        while (localIterator.hasNext()) {
          BC((String)localIterator.next());
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
          ad.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(132264);
          return;
        }
        if (!this.hHU.contains(paramString)) {
          break label178;
        }
        localObject = this.hHU.getString(paramString, "");
        if (!bt.isNullOrNil((String)localObject))
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
        ad.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(132264);
        return;
      }
      continue;
      label178:
      localObject = new JSONObject();
    }
    ad.i("MicroMsg.SwitchAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.hHU.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(132264);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132265);
    try
    {
      ad.i("MicroMsg.SwitchAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.hHU.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.hHU.getString(paramString1, ""), 0));
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.i("MicroMsg.SwitchAccountInfo", "get json str %s", new Object[] { localObject });
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
        ad.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(132265);
    return "";
  }
  
  public final void l(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(132263);
    for (;;)
    {
      try
      {
        if (this.hHU.contains(paramString1))
        {
          localObject = this.hHU.getString(paramString1, "");
          if (!bt.isNullOrNil((String)localObject))
          {
            localObject = new JSONObject(new String(Base64.decode((String)localObject, 0)));
            if (!bt.V(new String[] { paramString2, paramString3 }))
            {
              ((JSONObject)localObject).put(paramString2, paramString3);
              ad.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", new Object[] { paramString2, ((JSONObject)localObject).toString() });
              this.hHU.edit().putString(paramString1, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
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
        ad.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, paramString3.getMessage() });
        AppMethodBeat.o(132263);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.cb
 * JD-Core Version:    0.7.0.1
 */