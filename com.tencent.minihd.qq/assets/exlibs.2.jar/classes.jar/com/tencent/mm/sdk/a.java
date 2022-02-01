package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.sdk.c.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements SharedPreferences
{
  private final ContentResolver a;
  private final String[] b = { "_id", "key", "type", "value" };
  private final HashMap<String, Object> c = new HashMap();
  private a d = null;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  private Object getValue(String paramString)
  {
    for (;;)
    {
      try
      {
        Cursor localCursor = this.a.query(a.b.CONTENT_URI, this.b, "key = ?", new String[] { paramString }, null);
        if (localCursor == null) {
          return null;
        }
        int i = localCursor.getColumnIndex("type");
        int j = localCursor.getColumnIndex("value");
        if (localCursor.moveToFirst())
        {
          paramString = com.tencent.mm.sdk.c.a.a.a(localCursor.getInt(i), localCursor.getString(j));
          localCursor.close();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = null;
    }
  }
  
  public final boolean contains(String paramString)
  {
    return getValue(paramString) != null;
  }
  
  public final SharedPreferences.Editor edit()
  {
    if (this.d == null) {
      this.d = new a(this.a);
    }
    return this.d;
  }
  
  public final Map<String, ?> getAll()
  {
    try
    {
      Cursor localCursor = this.a.query(a.b.CONTENT_URI, this.b, null, null, null);
      if (localCursor == null) {
        return null;
      }
      int i = localCursor.getColumnIndex("key");
      int j = localCursor.getColumnIndex("type");
      int k = localCursor.getColumnIndex("value");
      while (localCursor.moveToNext())
      {
        Object localObject = com.tencent.mm.sdk.c.a.a.a(localCursor.getInt(j), localCursor.getString(k));
        this.c.put(localCursor.getString(i), localObject);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return this.c;
    }
    HashMap localHashMap = this.c;
    return localHashMap;
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = getValue(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    paramString = getValue(paramString);
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if ((paramString instanceof Float)) {
        f = ((Float)paramString).floatValue();
      }
    }
    return f;
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    paramString = getValue(paramString);
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if ((paramString instanceof Integer)) {
        i = ((Integer)paramString).intValue();
      }
    }
    return i;
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    paramString = getValue(paramString);
    long l = paramLong;
    if (paramString != null)
    {
      l = paramLong;
      if ((paramString instanceof Long)) {
        l = ((Long)paramString).longValue();
      }
    }
    return l;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    paramString1 = getValue(paramString1);
    if ((paramString1 != null) && ((paramString1 instanceof String))) {
      return (String)paramString1;
    }
    return paramString2;
  }
  
  public final Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  private static final class a
    implements SharedPreferences.Editor
  {
    private ContentResolver a;
    private Map<String, Object> e = new HashMap();
    private Set<String> f = new HashSet();
    private boolean g = false;
    
    public a(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public final void apply() {}
    
    public final SharedPreferences.Editor clear()
    {
      this.g = true;
      return this;
    }
    
    public final boolean commit()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.g)
      {
        this.a.delete(a.b.CONTENT_URI, null, null);
        this.g = false;
      }
      Iterator localIterator = this.f.iterator();
      Object localObject1;
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        this.a.delete(a.b.CONTENT_URI, "key = ?", new String[] { localObject1 });
      }
      localIterator = this.e.entrySet().iterator();
      label146:
      label302:
      label326:
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject1).getValue();
        if (localObject2 == null)
        {
          com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
          i = 0;
          if (i != 0) {
            break label302;
          }
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label326;
          }
          this.a.update(a.b.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
          break;
          if ((localObject2 instanceof Integer))
          {
            i = 1;
            break label146;
          }
          if ((localObject2 instanceof Long))
          {
            i = 2;
            break label146;
          }
          if ((localObject2 instanceof String))
          {
            i = 3;
            break label146;
          }
          if ((localObject2 instanceof Boolean))
          {
            i = 4;
            break label146;
          }
          if ((localObject2 instanceof Float))
          {
            i = 5;
            break label146;
          }
          if ((localObject2 instanceof Double))
          {
            i = 6;
            break label146;
          }
          com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject2.getClass().toString());
          i = 0;
          break label146;
          localContentValues.put("type", Integer.valueOf(i));
          localContentValues.put("value", localObject2.toString());
        }
      }
      return true;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      this.e.put(paramString, Boolean.valueOf(paramBoolean));
      this.f.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      this.e.put(paramString, Float.valueOf(paramFloat));
      this.f.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      this.e.put(paramString, Integer.valueOf(paramInt));
      this.f.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      this.e.put(paramString, Long.valueOf(paramLong));
      this.f.remove(paramString);
      return this;
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      this.e.put(paramString1, paramString2);
      this.f.remove(paramString1);
      return this;
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      return null;
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      this.f.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a
 * JD-Core Version:    0.7.0.1
 */