package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class zzayx
  extends zza
  implements Comparable<zzayx>
{
  public static final Parcelable.Creator<zzayx> CREATOR = new zzayy();
  public final int zzbBC;
  public final zzayz[] zzbBD;
  public final String[] zzbBE;
  public final Map<String, zzayz> zzbBF;
  
  public zzayx(int paramInt, zzayz[] paramArrayOfzzayz, String[] paramArrayOfString)
  {
    this.zzbBC = paramInt;
    this.zzbBD = paramArrayOfzzayz;
    this.zzbBF = new TreeMap();
    int i = paramArrayOfzzayz.length;
    paramInt = 0;
    while (paramInt < i)
    {
      zzayz localzzayz = paramArrayOfzzayz[paramInt];
      this.zzbBF.put(localzzayz.name, localzzayz);
      paramInt += 1;
    }
    this.zzbBE = paramArrayOfString;
    if (this.zzbBE != null) {
      Arrays.sort(this.zzbBE);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof zzayx))
      {
        paramObject = (zzayx)paramObject;
        bool1 = bool2;
        if (this.zzbBC == paramObject.zzbBC)
        {
          bool1 = bool2;
          if (zzaa.equal(this.zzbBF, paramObject.zzbBF))
          {
            bool1 = bool2;
            if (Arrays.equals(this.zzbBE, paramObject.zzbBE)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configuration(");
    localStringBuilder.append(this.zzbBC);
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    Object localObject = this.zzbBF.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((zzayz)((Iterator)localObject).next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    if (this.zzbBE != null)
    {
      localObject = this.zzbBE;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(", ");
        i += 1;
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzayy.zza(this, paramParcel, paramInt);
  }
  
  public int zza(zzayx paramzzayx)
  {
    return this.zzbBC - paramzzayx.zzbBC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzayx
 * JD-Core Version:    0.7.0.1
 */