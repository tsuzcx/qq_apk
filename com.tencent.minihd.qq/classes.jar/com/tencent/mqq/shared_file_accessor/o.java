package com.tencent.mqq.shared_file_accessor;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Iterator;
import java.util.Set;

final class o
  implements SharedPreferences.Editor
{
  private o(n paramn) {}
  
  private void a(String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator;
      if (n.b(this.a) != null)
      {
        localIterator = n.b(this.a).iterator();
        if (localIterator.hasNext()) {}
      }
      else
      {
        return;
      }
      ((SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next()).onSharedPreferenceChanged(this.a, paramString);
    }
  }
  
  public final void apply() {}
  
  public final SharedPreferences.Editor clear()
  {
    n.a(this.a).b(null);
    return this;
  }
  
  public final boolean commit()
  {
    return true;
  }
  
  public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    n.a(this.a).a(paramString, Boolean.valueOf(paramBoolean), d.h);
    a(paramString);
    return this;
  }
  
  public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    n.a(this.a).a(paramString, Float.valueOf(paramFloat), d.f);
    a(paramString);
    return this;
  }
  
  public final SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    n.a(this.a).a(paramString, Integer.valueOf(paramInt), d.d);
    a(paramString);
    return this;
  }
  
  public final SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    n.a(this.a).a(paramString, Long.valueOf(paramLong), d.e);
    a(paramString);
    return this;
  }
  
  public final SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    n.a(this.a).a(paramString1, paramString2, d.g);
    a(paramString1);
    return this;
  }
  
  public final SharedPreferences.Editor putStringSet(String paramString, Set paramSet)
  {
    n.a(this.a).a(paramString, paramSet, d.i);
    a(paramString);
    return this;
  }
  
  public final SharedPreferences.Editor remove(String paramString)
  {
    n.a(this.a).a(paramString);
    a(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.o
 * JD-Core Version:    0.7.0.1
 */