package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.a;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences
  implements SharedPreferences
{
  private static final String TAG = "MicroMsg.SDK.SharedPreferences";
  private final String[] columns;
  private final ContentResolver cr;
  private MMSharedPreferences.REditor editor;
  private final HashMap<String, Object> values;
  
  public MMSharedPreferences(Context paramContext)
  {
    AppMethodBeat.i(128080);
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.editor = null;
    this.cr = paramContext.getContentResolver();
    AppMethodBeat.o(128080);
  }
  
  private Object getValue(String paramString)
  {
    AppMethodBeat.i(128081);
    for (;;)
    {
      try
      {
        Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localCursor == null)
        {
          AppMethodBeat.o(128081);
          return null;
        }
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = c.a.a(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          AppMethodBeat.o(128081);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SDK.SharedPreferences", "getValue exception:" + paramString.getMessage());
        AppMethodBeat.o(128081);
        return null;
      }
      paramString = null;
    }
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(128088);
    if (getValue(paramString) != null)
    {
      AppMethodBeat.o(128088);
      return true;
    }
    AppMethodBeat.o(128088);
    return false;
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(128089);
    if (this.editor == null) {
      this.editor = new MMSharedPreferences.REditor(this.cr);
    }
    MMSharedPreferences.REditor localREditor = this.editor;
    AppMethodBeat.o(128089);
    return localREditor;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(128082);
    try
    {
      Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
      if (localCursor == null)
      {
        AppMethodBeat.o(128082);
        return null;
      }
      int i = localCursor.getColumnIndex("key");
      int j = localCursor.getColumnIndex("type");
      int k = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = c.a.a(localCursor.getInt(j), localCursor.getString(k));
        this.values.put(localCursor.getString(i), localObject);
      }
      localHashMap.close();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.SharedPreferences", "getAll exception:" + localException.getMessage());
      localHashMap = this.values;
      AppMethodBeat.o(128082);
      return localHashMap;
    }
    HashMap localHashMap = this.values;
    AppMethodBeat.o(128082);
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(128087);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Boolean)))
    {
      paramBoolean = ((Boolean)paramString).booleanValue();
      AppMethodBeat.o(128087);
      return paramBoolean;
    }
    AppMethodBeat.o(128087);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(128086);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Float)))
    {
      paramFloat = ((Float)paramString).floatValue();
      AppMethodBeat.o(128086);
      return paramFloat;
    }
    AppMethodBeat.o(128086);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(128084);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Integer)))
    {
      paramInt = ((Integer)paramString).intValue();
      AppMethodBeat.o(128084);
      return paramInt;
    }
    AppMethodBeat.o(128084);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(128085);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Long)))
    {
      paramLong = ((Long)paramString).longValue();
      AppMethodBeat.o(128085);
      return paramLong;
    }
    AppMethodBeat.o(128085);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128083);
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String)))
    {
      paramString1 = (String)paramString1;
      AppMethodBeat.o(128083);
      return paramString1;
    }
    AppMethodBeat.o(128083);
    return paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */