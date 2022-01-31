package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MMSharedPreferences$REditor
  implements SharedPreferences.Editor
{
  private boolean clear = false;
  private ContentResolver cr;
  private Set<String> remove = new HashSet();
  private Map<String, Object> values = new HashMap();
  
  public MMSharedPreferences$REditor(ContentResolver paramContentResolver)
  {
    this.cr = paramContentResolver;
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    this.clear = true;
    return this;
  }
  
  public boolean commit()
  {
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
    label146:
    label302:
    label326:
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = ((Map.Entry)localObject1).getValue();
      if (localObject2 == null)
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
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
        this.cr.update(c.b.CONTENT_URI, localContentValues, "key = ?", new String[] { (String)((Map.Entry)localObject1).getKey() });
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
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + localObject2.getClass().toString());
        i = 0;
        break label146;
        localContentValues.put("type", Integer.valueOf(i));
        localContentValues.put("value", localObject2.toString());
      }
    }
    return true;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.values.put(paramString, Boolean.valueOf(paramBoolean));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.values.put(paramString, Float.valueOf(paramFloat));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.values.put(paramString, Integer.valueOf(paramInt));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.values.put(paramString, Long.valueOf(paramLong));
    this.remove.remove(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.values.put(paramString1, paramString2);
    this.remove.remove(paramString1);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    return null;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.remove.add(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor
 * JD-Core Version:    0.7.0.1
 */