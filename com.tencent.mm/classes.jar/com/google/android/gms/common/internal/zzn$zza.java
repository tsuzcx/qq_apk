package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

public final class zzn$zza
{
  private final String zzaGd;
  private final ComponentName zzaGe;
  private final String zzadb;
  
  public zzn$zza(ComponentName paramComponentName)
  {
    this.zzadb = null;
    this.zzaGd = null;
    this.zzaGe = ((ComponentName)zzac.zzw(paramComponentName));
  }
  
  public zzn$zza(String paramString1, String paramString2)
  {
    this.zzadb = zzac.zzdr(paramString1);
    this.zzaGd = zzac.zzdr(paramString2);
    this.zzaGe = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
    } while ((zzaa.equal(this.zzadb, paramObject.zzadb)) && (zzaa.equal(this.zzaGe, paramObject.zzaGe)));
    return false;
  }
  
  public final ComponentName getComponentName()
  {
    return this.zzaGe;
  }
  
  public final String getPackage()
  {
    return this.zzaGd;
  }
  
  public final int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzadb, this.zzaGe });
  }
  
  public final String toString()
  {
    if (this.zzadb == null) {
      return this.zzaGe.flattenToString();
    }
    return this.zzadb;
  }
  
  public final Intent zzxZ()
  {
    if (this.zzadb != null) {
      return new Intent(this.zzadb).setPackage(this.zzaGd);
    }
    return new Intent().setComponent(this.zzaGe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzn.zza
 * JD-Core Version:    0.7.0.1
 */