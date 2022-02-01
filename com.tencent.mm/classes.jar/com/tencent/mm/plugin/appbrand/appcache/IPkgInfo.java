package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcelable;

public abstract interface IPkgInfo
  extends Parcelable
{
  public abstract long lastModified();
  
  public abstract String pkgPath();
  
  public abstract int pkgVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.IPkgInfo
 * JD-Core Version:    0.7.0.1
 */