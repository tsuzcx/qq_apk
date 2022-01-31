package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.util.zzr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacz
  extends zzact
{
  public static final Parcelable.Creator<zzacz> CREATOR = new zzada();
  private final String mClassName;
  private final zzacw zzaHf;
  private final Parcel zzaHm;
  private final int zzaHn;
  private int zzaHo;
  private int zzaHp;
  private final int zzaiI;
  
  zzacz(int paramInt, Parcel paramParcel, zzacw paramzzacw)
  {
    this.zzaiI = paramInt;
    this.zzaHm = ((Parcel)zzac.zzw(paramParcel));
    this.zzaHn = 2;
    this.zzaHf = paramzzacw;
    if (this.zzaHf == null) {}
    for (this.mClassName = null;; this.mClassName = this.zzaHf.zzyF())
    {
      this.zzaHo = 2;
      return;
    }
  }
  
  private static SparseArray<Map.Entry<String, zzacs.zza<?, ?>>> zzY(Map<String, zzacs.zza<?, ?>> paramMap)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localSparseArray.put(((zzacs.zza)localEntry.getValue()).zzyx(), localEntry);
    }
    return localSparseArray;
  }
  
  private void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(zzq.zzdy(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzq((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzr((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      zzr.zza(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, Parcel paramParcel, int paramInt)
  {
    switch (paramzza.zzyu())
    {
    default: 
      paramInt = paramzza.zzyu();
      throw new IllegalArgumentException(36 + "Unknown field out type = " + paramInt);
    case 0: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt))));
      return;
    case 1: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt)));
      return;
    case 2: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt))));
      return;
    case 3: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt))));
      return;
    case 4: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt))));
      return;
    case 5: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt)));
      return;
    case 6: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt))));
      return;
    case 7: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt)));
      return;
    case 10: 
      zzb(paramStringBuilder, paramzza, zza(paramzza, zzr(com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zzacs.zza<?, ?> paramzza, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (paramzza.zzyA())
    {
      zza(paramStringBuilder, paramzza, paramParcel, paramInt);
      return;
    }
    zzb(paramStringBuilder, paramzza, paramParcel, paramInt);
  }
  
  private void zza(StringBuilder paramStringBuilder, Map<String, zzacs.zza<?, ?>> paramMap, Parcel paramParcel)
  {
    paramMap = zzY(paramMap);
    paramStringBuilder.append('{');
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaY(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzaX(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramMap.get(com.google.android.gms.common.internal.safeparcel.zzb.zzdc(k));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zza(paramStringBuilder, (String)localEntry.getKey(), (zzacs.zza)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, Parcel paramParcel, int paramInt)
  {
    if (paramzza.zzyv())
    {
      paramStringBuilder.append("[");
      switch (paramzza.zzyu())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzw(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzy(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzx(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzz(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzA(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzB(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzv(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzC(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          zza(paramStringBuilder, paramzza.zzyC(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (paramzza.zzyu())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt));
      return;
    case 7: 
      paramzza = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(zzq.zzdy(paramzza)).append("\"");
      return;
    case 8: 
      paramzza = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzq(paramzza)).append("\"");
      return;
    case 9: 
      paramzza = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzr(paramzza));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramzza = com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt);
      paramParcel = paramzza.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        String str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(zzq.zzdy(paramzza.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzF(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    zza(paramStringBuilder, paramzza.zzyC(), paramParcel);
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, Object paramObject)
  {
    if (paramzza.zzyt())
    {
      zzb(paramStringBuilder, paramzza, (ArrayList)paramObject);
      return;
    }
    zza(paramStringBuilder, paramzza.zzys(), paramObject);
  }
  
  private void zzb(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      zza(paramStringBuilder, paramzza.zzys(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> zzr(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  public int getVersionCode()
  {
    return this.zzaiI;
  }
  
  public String toString()
  {
    zzac.zzb(this.zzaHf, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzyH();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, this.zzaHf.zzdw(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzada.zza(this, paramParcel, paramInt);
  }
  
  public Object zzds(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean zzdt(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public Parcel zzyH()
  {
    switch (this.zzaHo)
    {
    }
    for (;;)
    {
      return this.zzaHm;
      this.zzaHp = com.google.android.gms.common.internal.safeparcel.zzc.zzaZ(this.zzaHm);
      com.google.android.gms.common.internal.safeparcel.zzc.zzJ(this.zzaHm, this.zzaHp);
      this.zzaHo = 2;
    }
  }
  
  zzacw zzyI()
  {
    switch (this.zzaHn)
    {
    default: 
      int i = this.zzaHn;
      throw new IllegalStateException(34 + "Invalid creation type: " + i);
    case 0: 
      return null;
    case 1: 
      return this.zzaHf;
    }
    return this.zzaHf;
  }
  
  public Map<String, zzacs.zza<?, ?>> zzyr()
  {
    if (this.zzaHf == null) {
      return null;
    }
    return this.zzaHf.zzdw(this.mClassName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzacz
 * JD-Core Version:    0.7.0.1
 */