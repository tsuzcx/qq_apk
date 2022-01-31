package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Map;

public class zzacs$zza<I, O>
  extends zza
{
  public static final zzacu CREATOR = new zzacu();
  protected final int zzaGX;
  protected final boolean zzaGY;
  protected final int zzaGZ;
  protected final boolean zzaHa;
  protected final String zzaHb;
  protected final int zzaHc;
  protected final Class<? extends zzacs> zzaHd;
  protected final String zzaHe;
  private zzacw zzaHf;
  private zzacs.zzb<I, O> zzaHg;
  private final int zzaiI;
  
  zzacs$zza(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, zzacn paramzzacn)
  {
    this.zzaiI = paramInt1;
    this.zzaGX = paramInt2;
    this.zzaGY = paramBoolean1;
    this.zzaGZ = paramInt3;
    this.zzaHa = paramBoolean2;
    this.zzaHb = paramString1;
    this.zzaHc = paramInt4;
    if (paramString2 == null) {
      this.zzaHd = null;
    }
    for (this.zzaHe = null; paramzzacn == null; this.zzaHe = paramString2)
    {
      this.zzaHg = null;
      return;
      this.zzaHd = zzacz.class;
    }
    this.zzaHg = paramzzacn.zzyp();
  }
  
  protected zzacs$zza(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends zzacs> paramClass, zzacs.zzb<I, O> paramzzb)
  {
    this.zzaiI = 1;
    this.zzaGX = paramInt1;
    this.zzaGY = paramBoolean1;
    this.zzaGZ = paramInt2;
    this.zzaHa = paramBoolean2;
    this.zzaHb = paramString;
    this.zzaHc = paramInt3;
    this.zzaHd = paramClass;
    if (paramClass == null) {}
    for (this.zzaHe = null;; this.zzaHe = paramClass.getCanonicalName())
    {
      this.zzaHg = paramzzb;
      return;
    }
  }
  
  public static zza zza(String paramString, int paramInt, zzacs.zzb<?, ?> paramzzb, boolean paramBoolean)
  {
    return new zza(7, paramBoolean, 0, false, paramString, paramInt, null, paramzzb);
  }
  
  public static <T extends zzacs> zza<T, T> zza(String paramString, int paramInt, Class<T> paramClass)
  {
    return new zza(11, false, 11, false, paramString, paramInt, paramClass, null);
  }
  
  public static <T extends zzacs> zza<ArrayList<T>, ArrayList<T>> zzb(String paramString, int paramInt, Class<T> paramClass)
  {
    return new zza(11, true, 11, true, paramString, paramInt, paramClass, null);
  }
  
  public static zza<Integer, Integer> zzk(String paramString, int paramInt)
  {
    return new zza(0, false, 0, false, paramString, paramInt, null, null);
  }
  
  public static zza<Boolean, Boolean> zzl(String paramString, int paramInt)
  {
    return new zza(6, false, 6, false, paramString, paramInt, null, null);
  }
  
  public static zza<String, String> zzm(String paramString, int paramInt)
  {
    return new zza(7, false, 7, false, paramString, paramInt, null, null);
  }
  
  public I convertBack(O paramO)
  {
    return this.zzaHg.convertBack(paramO);
  }
  
  public int getVersionCode()
  {
    return this.zzaiI;
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzv(this).zzg("versionCode", Integer.valueOf(this.zzaiI)).zzg("typeIn", Integer.valueOf(this.zzaGX)).zzg("typeInArray", Boolean.valueOf(this.zzaGY)).zzg("typeOut", Integer.valueOf(this.zzaGZ)).zzg("typeOutArray", Boolean.valueOf(this.zzaHa)).zzg("outputFieldName", this.zzaHb).zzg("safeParcelFieldId", Integer.valueOf(this.zzaHc)).zzg("concreteTypeName", zzyz());
    Class localClass = zzyy();
    if (localClass != null) {
      localzza.zzg("concreteType.class", localClass.getCanonicalName());
    }
    if (this.zzaHg != null) {
      localzza.zzg("converterName", this.zzaHg.getClass().getCanonicalName());
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzacu.zza(this, paramParcel, paramInt);
  }
  
  public void zza(zzacw paramzzacw)
  {
    this.zzaHf = paramzzacw;
  }
  
  public boolean zzyA()
  {
    return this.zzaHg != null;
  }
  
  zzacn zzyB()
  {
    if (this.zzaHg == null) {
      return null;
    }
    return zzacn.zza(this.zzaHg);
  }
  
  public Map<String, zza<?, ?>> zzyC()
  {
    zzac.zzw(this.zzaHe);
    zzac.zzw(this.zzaHf);
    return this.zzaHf.zzdw(this.zzaHe);
  }
  
  public int zzys()
  {
    return this.zzaGX;
  }
  
  public boolean zzyt()
  {
    return this.zzaGY;
  }
  
  public int zzyu()
  {
    return this.zzaGZ;
  }
  
  public boolean zzyv()
  {
    return this.zzaHa;
  }
  
  public String zzyw()
  {
    return this.zzaHb;
  }
  
  public int zzyx()
  {
    return this.zzaHc;
  }
  
  public Class<? extends zzacs> zzyy()
  {
    return this.zzaHd;
  }
  
  String zzyz()
  {
    if (this.zzaHe == null) {
      return null;
    }
    return this.zzaHe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzacs.zza
 * JD-Core Version:    0.7.0.1
 */