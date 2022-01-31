package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import java.nio.charset.Charset;
import java.util.Arrays;

public class zzayz
  extends zza
  implements Comparable<zzayz>
{
  public static final Parcelable.Creator<zzayz> CREATOR = new zzaza();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final zzayz.zza zzbBK = new zzayz.zza();
  public final String name;
  final String zzaGV;
  final long zzbBG;
  final byte[] zzbBH;
  public final int zzbBI;
  public final int zzbBJ;
  final boolean zzbhm;
  final double zzbho;
  
  public zzayz(String paramString1, long paramLong, boolean paramBoolean, double paramDouble, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.name = paramString1;
    this.zzbBG = paramLong;
    this.zzbhm = paramBoolean;
    this.zzbho = paramDouble;
    this.zzaGV = paramString2;
    this.zzbBH = paramArrayOfByte;
    this.zzbBI = paramInt1;
    this.zzbBJ = paramInt2;
  }
  
  private static int compare(byte paramByte1, byte paramByte2)
  {
    return paramByte1 - paramByte2;
  }
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  private static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  private static int compare(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return 0;
    }
    if (paramString1 == null) {
      return -1;
    }
    if (paramString2 == null) {
      return 1;
    }
    return paramString1.compareTo(paramString2);
  }
  
  private static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return 0;
    }
    if (paramBoolean1) {
      return 1;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject != null) && ((paramObject instanceof zzayz)))
    {
      paramObject = (zzayz)paramObject;
      if ((!zzaa.equal(this.name, paramObject.name)) || (this.zzbBI != paramObject.zzbBI) || (this.zzbBJ != paramObject.zzbBJ)) {
        bool = false;
      }
      do
      {
        do
        {
          do
          {
            return bool;
            switch (this.zzbBI)
            {
            default: 
              int i = this.zzbBI;
              throw new AssertionError(31 + "Invalid enum value: " + i);
            }
          } while (this.zzbBG == paramObject.zzbBG);
          return false;
        } while (this.zzbhm == paramObject.zzbhm);
        return false;
      } while (this.zzbho == paramObject.zzbho);
      return false;
      return zzaa.equal(this.zzaGV, paramObject.zzaGV);
      return Arrays.equals(this.zzbBH, paramObject.zzbBH);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    zza(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaza.zza(this, paramParcel, paramInt);
  }
  
  public int zza(zzayz paramzzayz)
  {
    int j = 0;
    int i = 0;
    int k = this.name.compareTo(paramzzayz.name);
    if (k != 0) {
      i = k;
    }
    do
    {
      return i;
      k = compare(this.zzbBI, paramzzayz.zzbBI);
      if (k != 0) {
        return k;
      }
      switch (this.zzbBI)
      {
      default: 
        i = this.zzbBI;
        throw new AssertionError(31 + "Invalid enum value: " + i);
      case 1: 
        return compare(this.zzbBG, paramzzayz.zzbBG);
      case 2: 
        return compare(this.zzbhm, paramzzayz.zzbhm);
      case 3: 
        return Double.compare(this.zzbho, paramzzayz.zzbho);
      case 4: 
        return compare(this.zzaGV, paramzzayz.zzaGV);
      }
    } while (this.zzbBH == paramzzayz.zzbBH);
    if (this.zzbBH == null) {
      return -1;
    }
    i = j;
    if (paramzzayz.zzbBH == null) {
      return 1;
    }
    do
    {
      i += 1;
      if (i >= Math.min(this.zzbBH.length, paramzzayz.zzbBH.length)) {
        break;
      }
      j = compare(this.zzbBH[i], paramzzayz.zzbBH[i]);
    } while (j == 0);
    return j;
    return compare(this.zzbBH.length, paramzzayz.zzbBH.length);
  }
  
  public String zza(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Flag(");
    paramStringBuilder.append(this.name);
    paramStringBuilder.append(", ");
    switch (this.zzbBI)
    {
    default: 
      paramStringBuilder = this.name;
      int i = this.zzbBI;
      throw new AssertionError(String.valueOf(paramStringBuilder).length() + 27 + "Invalid type: " + paramStringBuilder + ", " + i);
    case 1: 
      paramStringBuilder.append(this.zzbBG);
    }
    for (;;)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(this.zzbBI);
      paramStringBuilder.append(", ");
      paramStringBuilder.append(this.zzbBJ);
      paramStringBuilder.append(")");
      return paramStringBuilder.toString();
      paramStringBuilder.append(this.zzbhm);
      continue;
      paramStringBuilder.append(this.zzbho);
      continue;
      paramStringBuilder.append("'");
      paramStringBuilder.append(this.zzaGV);
      paramStringBuilder.append("'");
      continue;
      if (this.zzbBH == null)
      {
        paramStringBuilder.append("null");
      }
      else
      {
        paramStringBuilder.append("'");
        paramStringBuilder.append(new String(this.zzbBH, UTF_8));
        paramStringBuilder.append("'");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzayz
 * JD-Core Version:    0.7.0.1
 */