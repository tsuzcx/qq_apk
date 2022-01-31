package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bx
{
  public static bx fnO;
  private SharedPreferences fnP;
  private SharedPreferences fny;
  
  static
  {
    AppMethodBeat.i(58129);
    fnO = new bx();
    AppMethodBeat.o(58129);
  }
  
  private bx()
  {
    AppMethodBeat.i(58118);
    this.fny = ah.getContext().getSharedPreferences(ah.dsP() + "_account_history", 0);
    this.fnP = ah.getContext().getSharedPreferences(ah.dsP() + "_account_switch", 0);
    AppMethodBeat.o(58118);
  }
  
  private void pJ(String paramString)
  {
    AppMethodBeat.i(58126);
    if (this.fny.contains(paramString)) {}
    try
    {
      e.deleteFile(getString(paramString, "last_avatar_path"));
      this.fny.edit().remove(paramString).commit();
      AppMethodBeat.o(58126);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final Set<String> abf()
  {
    AppMethodBeat.i(58127);
    HashSet localHashSet = new HashSet();
    Set localSet = this.fnP.getStringSet("first_switch_group", null);
    if ((localSet != null) && (!localSet.isEmpty())) {
      localHashSet.addAll(localSet);
    }
    AppMethodBeat.o(58127);
    return localHashSet;
  }
  
  public final String abg()
  {
    AppMethodBeat.i(58128);
    Object localObject2 = abf();
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
    ab.i("MicroMsg.SwitchAccountInfo", "switch users %s", new Object[] { ((StringBuilder)localObject1).toString() });
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(58128);
    return localObject1;
  }
  
  public final void ar(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58123);
    if ((bo.Q(new String[] { paramString1, paramString2 })) || (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(58123);
      return;
    }
    Object localObject = this.fnP.getStringSet("first_switch_group", null);
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
        paramString1 = this.fnP.edit();
        paramString1.remove("first_switch_group").apply();
        paramString1.putStringSet("first_switch_group", (Set)localObject).commit();
        AppMethodBeat.o(58123);
        return;
        Iterator localIterator = ((Set)localObject).iterator();
        while (localIterator.hasNext()) {
          pJ((String)localIterator.next());
        }
        ((Set)localObject).clear();
        ((Set)localObject).add(paramString1);
        ((Set)localObject).add(paramString2);
      }
    }
  }
  
  public final void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(58120);
    if (paramMap != null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramMap.isEmpty())
        {
          ab.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
          AppMethodBeat.o(58120);
          return;
        }
        if (!this.fny.contains(paramString)) {
          break label177;
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
        ab.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", new Object[] { paramString, paramMap.getMessage() });
        AppMethodBeat.o(58120);
        return;
      }
      continue;
      label177:
      localObject = new JSONObject();
    }
    ab.i("MicroMsg.SwitchAccountInfo", "put json str %s", new Object[] { ((JSONObject)localObject).toString() });
    this.fny.edit().putString(paramString, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
    AppMethodBeat.o(58120);
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58121);
    try
    {
      ab.i("MicroMsg.SwitchAccountInfo", "get %s, %s", new Object[] { paramString1, paramString2 });
      if (this.fny.contains(paramString1))
      {
        Object localObject = new String(Base64.decode(this.fny.getString(paramString1, ""), 0));
        if (!bo.isNullOrNil((String)localObject))
        {
          ab.i("MicroMsg.SwitchAccountInfo", "get json str %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has(paramString2))
          {
            localObject = ((JSONObject)localObject).getString(paramString2);
            AppMethodBeat.o(58121);
            return localObject;
          }
        }
      }
      else
      {
        ab.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", new Object[] { paramString1 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, localException.getMessage() });
      }
    }
    AppMethodBeat.o(58121);
    return "";
  }
  
  public final void n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(58119);
    for (;;)
    {
      try
      {
        if (this.fny.contains(paramString1))
        {
          localObject = this.fny.getString(paramString1, "");
          if (!bo.isNullOrNil((String)localObject))
          {
            localObject = new JSONObject(new String(Base64.decode((String)localObject, 0)));
            if (!bo.Q(new String[] { paramString2, paramString3 }))
            {
              ((JSONObject)localObject).put(paramString2, paramString3);
              ab.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", new Object[] { paramString2, ((JSONObject)localObject).toString() });
              this.fny.edit().putString(paramString1, Base64.encodeToString(((JSONObject)localObject).toString().getBytes(), 0)).commit();
            }
            AppMethodBeat.o(58119);
            return;
          }
          localObject = new JSONObject();
          continue;
        }
        Object localObject = new JSONObject();
      }
      catch (Exception paramString3)
      {
        ab.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", new Object[] { paramString2, paramString1, paramString3.getMessage() });
        AppMethodBeat.o(58119);
        return;
      }
    }
  }
  
  public final void pG(String paramString)
  {
    AppMethodBeat.i(58122);
    if (pH(paramString))
    {
      Set localSet = this.fnP.getStringSet("first_switch_group", null);
      if (localSet != null)
      {
        localSet.remove(paramString);
        SharedPreferences.Editor localEditor = this.fnP.edit();
        localEditor.remove("first_switch_group").apply();
        localEditor.putStringSet("first_switch_group", localSet).commit();
      }
    }
    if (pI(paramString)) {
      pJ(paramString);
    }
    AppMethodBeat.o(58122);
  }
  
  public final boolean pH(String paramString)
  {
    AppMethodBeat.i(58124);
    Set localSet = this.fnP.getStringSet("first_switch_group", null);
    if (localSet == null)
    {
      AppMethodBeat.o(58124);
      return false;
    }
    boolean bool = localSet.contains(paramString);
    AppMethodBeat.o(58124);
    return bool;
  }
  
  public final boolean pI(String paramString)
  {
    AppMethodBeat.i(58125);
    boolean bool = this.fny.contains(paramString);
    AppMethodBeat.o(58125);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.bx
 * JD-Core Version:    0.7.0.1
 */