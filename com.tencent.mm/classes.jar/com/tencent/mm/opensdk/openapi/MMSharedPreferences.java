package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences
  implements SharedPreferences
{
  private static final String TAG = "MicroMsg.SDK.SharedPreferences";
  private final String[] columns;
  private final ContentResolver cr;
  private REditor editor;
  private final HashMap<String, Object> values;
  
  public MMSharedPreferences(Context paramContext)
  {
    AppMethodBeat.i(3768);
    this.columns = new String[] { "_id", "key", "type", "value" };
    this.values = new HashMap();
    this.editor = null;
    this.cr = paramContext.getContentResolver();
    AppMethodBeat.o(3768);
  }
  
  private Object getValue(String paramString)
  {
    AppMethodBeat.i(3769);
    for (;;)
    {
      try
      {
        Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
        if (localCursor == null)
        {
          AppMethodBeat.o(3769);
          return null;
        }
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = c.a.a(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          AppMethodBeat.o(3769);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SDK.SharedPreferences", "getValue exception:" + paramString.getMessage());
        AppMethodBeat.o(3769);
        return null;
      }
      paramString = null;
    }
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(3776);
    if (getValue(paramString) != null)
    {
      AppMethodBeat.o(3776);
      return true;
    }
    AppMethodBeat.o(3776);
    return false;
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(3777);
    if (this.editor == null) {
      this.editor = new REditor(this.cr);
    }
    REditor localREditor = this.editor;
    AppMethodBeat.o(3777);
    return localREditor;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(3770);
    try
    {
      Cursor localCursor = this.cr.query(c.b.CONTENT_URI, this.columns, null, null, null);
      if (localCursor == null)
      {
        AppMethodBeat.o(3770);
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
      AppMethodBeat.o(3770);
      return localHashMap;
    }
    HashMap localHashMap = this.values;
    AppMethodBeat.o(3770);
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(3775);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Boolean)))
    {
      paramBoolean = ((Boolean)paramString).booleanValue();
      AppMethodBeat.o(3775);
      return paramBoolean;
    }
    AppMethodBeat.o(3775);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(3774);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Float)))
    {
      paramFloat = ((Float)paramString).floatValue();
      AppMethodBeat.o(3774);
      return paramFloat;
    }
    AppMethodBeat.o(3774);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(3772);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Integer)))
    {
      paramInt = ((Integer)paramString).intValue();
      AppMethodBeat.o(3772);
      return paramInt;
    }
    AppMethodBeat.o(3772);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(3773);
    paramString = getValue(paramString);
    if ((paramString != null) && ((paramString instanceof Long)))
    {
      paramLong = ((Long)paramString).longValue();
      AppMethodBeat.o(3773);
      return paramLong;
    }
    AppMethodBeat.o(3773);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3771);
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String)))
    {
      paramString1 = (String)paramString1;
      AppMethodBeat.o(3771);
      return paramString1;
    }
    AppMethodBeat.o(3771);
    return paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  static class REditor
    implements SharedPreferences.Editor
  {
    private boolean clear;
    private ContentResolver cr;
    private Set<String> remove;
    private Map<String, Object> values;
    
    public REditor(ContentResolver paramContentResolver)
    {
      AppMethodBeat.i(3782);
      this.values = new HashMap();
      this.remove = new HashSet();
      this.clear = false;
      this.cr = paramContentResolver;
      AppMethodBeat.o(3782);
    }
    
    public void apply() {}
    
    public SharedPreferences.Editor clear()
    {
      this.clear = true;
      return this;
    }
    
    public boolean commit()
    {
      AppMethodBeat.i(3789);
      ContentValues localContentValues = new ContentValues();
      if (this.clear)
      {
        this.cr.delete(c.b.CONTENT_URI, null, null);
        this.clear = false;
      }
      Iterator localIterator = this.remove.iterator();
      Object localObject1;
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        this.cr.delete(c.b.CONTENT_URI, "key = ?", new String[] { localObject1 });
      }
      localIterator = this.values.entrySet().iterator();
      label152:
      label308:
      label332:
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject1).getValue();
        if (localObject2 == null)
        {
          Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
          i = 0;
          if (i != 0) {
            break label308;
          }
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label332;
          }
          this.cr.update(c.b.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
          break;
          if ((localObject2 instanceof Integer))
          {
            i = 1;
            break label152;
          }
          if ((localObject2 instanceof Long))
          {
            i = 2;
            break label152;
          }
          if ((localObject2 instanceof String))
          {
            i = 3;
            break label152;
          }
          if ((localObject2 instanceof Boolean))
          {
            i = 4;
            break label152;
          }
          if ((localObject2 instanceof Float))
          {
            i = 5;
            break label152;
          }
          if ((localObject2 instanceof Double))
          {
            i = 6;
            break label152;
          }
          Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject2.getClass().toString());
          i = 0;
          break label152;
          localContentValues.put("type", Integer.valueOf(i));
          localContentValues.put("value", localObject2.toString());
        }
      }
      AppMethodBeat.o(3789);
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(3787);
      this.values.put(paramString, Boolean.valueOf(paramBoolean));
      this.remove.remove(paramString);
      AppMethodBeat.o(3787);
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(3786);
      this.values.put(paramString, Float.valueOf(paramFloat));
      this.remove.remove(paramString);
      AppMethodBeat.o(3786);
      return this;
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(3784);
      this.values.put(paramString, Integer.valueOf(paramInt));
      this.remove.remove(paramString);
      AppMethodBeat.o(3784);
      return this;
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(3785);
      this.values.put(paramString, Long.valueOf(paramLong));
      this.remove.remove(paramString);
      AppMethodBeat.o(3785);
      return this;
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(3783);
      this.values.put(paramString1, paramString2);
      this.remove.remove(paramString1);
      AppMethodBeat.o(3783);
      return this;
    }
    
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(3788);
      this.remove.add(paramString);
      AppMethodBeat.o(3788);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences
 * JD-Core Version:    0.7.0.1
 */