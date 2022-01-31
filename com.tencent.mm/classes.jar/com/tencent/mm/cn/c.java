package com.tencent.mm.cn;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c
  implements SharedPreferences, SharedPreferences.Editor
{
  as AZL;
  
  public c(as paramas)
  {
    this.AZL = paramas;
  }
  
  public void apply()
  {
    AppMethodBeat.i(80406);
    this.AZL.apply();
    AppMethodBeat.o(80406);
  }
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(80404);
    SharedPreferences.Editor localEditor = this.AZL.clear();
    AppMethodBeat.o(80404);
    return localEditor;
  }
  
  public boolean commit()
  {
    AppMethodBeat.i(80405);
    boolean bool = this.AZL.commit();
    AppMethodBeat.o(80405);
    return bool;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(80393);
    boolean bool = this.AZL.contains(paramString);
    AppMethodBeat.o(80393);
    return bool;
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(80394);
    SharedPreferences.Editor localEditor = this.AZL.edit();
    AppMethodBeat.o(80394);
    return localEditor;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(80386);
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = this.AZL.allKeys();
    if (arrayOfString == null)
    {
      AppMethodBeat.o(80386);
      return localHashMap;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(arrayOfString[i], "");
      i += 1;
    }
    AppMethodBeat.o(80386);
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(80392);
    paramBoolean = this.AZL.getBoolean(paramString, paramBoolean);
    AppMethodBeat.o(80392);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(80391);
    paramFloat = this.AZL.getFloat(paramString, paramFloat);
    AppMethodBeat.o(80391);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(80389);
    paramInt = this.AZL.getInt(paramString, paramInt);
    AppMethodBeat.o(80389);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(80390);
    paramLong = this.AZL.getLong(paramString, paramLong);
    AppMethodBeat.o(80390);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80387);
    paramString1 = this.AZL.getString(paramString1, paramString2);
    AppMethodBeat.o(80387);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(80388);
    paramString = this.AZL.getStringSet(paramString, paramSet);
    AppMethodBeat.o(80388);
    return paramString;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(80402);
    paramString = this.AZL.putBoolean(paramString, paramBoolean);
    AppMethodBeat.o(80402);
    return paramString;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(80401);
    paramString = this.AZL.putFloat(paramString, paramFloat);
    AppMethodBeat.o(80401);
    return paramString;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(80399);
    paramString = this.AZL.putInt(paramString, paramInt);
    AppMethodBeat.o(80399);
    return paramString;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(80400);
    paramString = this.AZL.putLong(paramString, paramLong);
    AppMethodBeat.o(80400);
    return paramString;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(80397);
    paramString1 = this.AZL.putString(paramString1, paramString2);
    AppMethodBeat.o(80397);
    return paramString1;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(80398);
    paramString = this.AZL.putStringSet(paramString, paramSet);
    AppMethodBeat.o(80398);
    return paramString;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(80395);
    this.AZL.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    AppMethodBeat.o(80395);
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(80403);
    paramString = this.AZL.remove(paramString);
    AppMethodBeat.o(80403);
    return paramString;
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(80396);
    this.AZL.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    AppMethodBeat.o(80396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cn.c
 * JD-Core Version:    0.7.0.1
 */