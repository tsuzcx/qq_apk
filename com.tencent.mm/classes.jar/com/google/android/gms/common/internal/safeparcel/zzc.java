package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class zzc
{
  private static int zzH(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void zzI(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void zzJ(Parcel paramParcel, int paramInt)
  {
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, byte paramByte)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, double paramDouble)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, float paramFloat)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, long paramLong)
  {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 == null)
    {
      if (paramBoolean) {
        zzb(paramParcel1, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzI(paramParcel1, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt1, 0);
      }
      return;
    }
    paramInt1 = zzH(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzI(paramParcel, paramInt1);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    int i = 0;
    if (paramBoolean == null)
    {
      if (paramBoolean1) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramInt = i;
    if (paramBoolean.booleanValue()) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean)
  {
    if (paramDouble == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void zza(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void zza(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    int i = zzH(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue());
      paramInt += 1;
    }
    zzI(paramParcel, i);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, short paramShort)
  {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    zzb(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static void zza(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (paramArrayOfFloat == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeFloatArray(paramArrayOfFloat);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfInt);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOfLong);
    zzI(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void zza(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfT == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt1, 0);
      }
      return;
    }
    int i = zzH(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      T ? = paramArrayOfT[paramInt1];
      if (? == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        zza(paramParcel, ?, paramInt2);
      }
    }
    zzI(paramParcel, i);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfBoolean);
    zzI(paramParcel, paramInt);
  }
  
  public static void zza(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    int j = zzH(paramParcel, paramInt);
    int k = paramArrayOfByte.length;
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeByteArray(paramArrayOfByte[paramInt]);
      paramInt += 1;
    }
    zzI(paramParcel, j);
  }
  
  private static <T extends Parcelable> void zza(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static int zzaZ(Parcel paramParcel)
  {
    return zzH(paramParcel, 20293);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void zzb(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzI(paramParcel, paramInt);
  }
  
  public static void zzc(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static <T extends Parcelable> void zzc(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    int i = zzH(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        zza(paramParcel, localParcelable, 0);
      }
    }
    zzI(paramParcel, i);
  }
  
  public static void zzd(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      return;
    }
    paramInt = zzH(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzI(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.zzc
 * JD-Core Version:    0.7.0.1
 */