package com.tencent.mapsdk.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class mb
{
  private static final String b = "%s-%s-%s,%s-%s-%s,%s-%s-%s";
  protected SharedPreferences a = null;
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  private String b()
  {
    return String.format("%s-%s-%s,%s-%s-%s,%s-%s-%s", new Object[] { "mapconfig", Integer.valueOf(b("mapConfigVersion")), b("mapConfigZipMd5", null), "indoormap_style", Integer.valueOf(b("indoormap_style_version")), b("indoormap_style_md5", null), "indoormap_style_night", Integer.valueOf(b("indoormap_style_night_version")), b("indoormap_style_night_md5", null) });
  }
  
  private long d(String paramString)
  {
    if (this.a == null) {
      return -1L;
    }
    return this.a.getLong(paramString, -1L);
  }
  
  public final String a(String paramString)
  {
    return b(paramString, null);
  }
  
  public final boolean a()
  {
    return a(new String[] { "mapConfigVersion", "poiIconVersion", "mapIconVersion", "mapConfigIndoorVersion", "mapConfigIndoorPremiumVersion", "mapPoiIcon3dIndoorVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "mapConfigIndoorMd5", "mapConfigIndoorPremiumMd5", "poiIcon3dIndoorMd5" });
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putInt(paramString, paramInt).commit();
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putLong(paramString, paramLong).commit();
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putString(paramString1, paramString2).commit();
  }
  
  public final boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    if (this.a == null) {
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localEditor.remove(paramArrayOfString[i]);
      i += 1;
    }
    return localEditor.commit();
  }
  
  public final int b(String paramString)
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.getInt(paramString, -1);
  }
  
  public final int b(String paramString, int paramInt)
  {
    if (this.a == null) {
      return paramInt;
    }
    return this.a.getInt(paramString, paramInt);
  }
  
  public final String b(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getString(paramString1, paramString2);
  }
  
  public final boolean c(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mb
 * JD-Core Version:    0.7.0.1
 */