package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter
{
  public static int beginObjectHeader(Parcel paramParcel)
  {
    AppMethodBeat.i(4816);
    int i = zza(paramParcel, 20293);
    AppMethodBeat.o(4816);
    return i;
  }
  
  public static void finishObjectHeader(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4817);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4817);
  }
  
  public static void writeBigDecimal(Parcel paramParcel, int paramInt, BigDecimal paramBigDecimal, boolean paramBoolean)
  {
    AppMethodBeat.i(4832);
    if (paramBigDecimal == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4832);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
    paramParcel.writeInt(paramBigDecimal.scale());
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4832);
  }
  
  public static void writeBigDecimalArray(Parcel paramParcel, int paramInt, BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(4846);
    if (paramArrayOfBigDecimal == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4846);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfBigDecimal.length;
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeByteArray(paramArrayOfBigDecimal[paramInt].unscaledValue().toByteArray());
      paramParcel.writeInt(paramArrayOfBigDecimal[paramInt].scale());
      paramInt += 1;
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4846);
  }
  
  public static void writeBigInteger(Parcel paramParcel, int paramInt, BigInteger paramBigInteger, boolean paramBoolean)
  {
    AppMethodBeat.i(4827);
    if (paramBigInteger == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4827);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigInteger.toByteArray());
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4827);
  }
  
  public static void writeBigIntegerArray(Parcel paramParcel, int paramInt, BigInteger[] paramArrayOfBigInteger, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(4843);
    if (paramArrayOfBigInteger == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4843);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfBigInteger.length;
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeByteArray(paramArrayOfBigInteger[paramInt].toByteArray());
      paramInt += 1;
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4843);
  }
  
  public static void writeBoolean(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4818);
    zzb(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(4818);
      return;
    }
  }
  
  public static void writeBooleanArray(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    AppMethodBeat.i(4839);
    if (paramArrayOfBoolean == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4839);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfBoolean);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4839);
  }
  
  public static void writeBooleanList(Parcel paramParcel, int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4849);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4849);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramList.size();
    paramParcel.writeInt(k);
    paramInt = 0;
    if (paramInt < k)
    {
      if (((Boolean)paramList.get(paramInt)).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        paramInt += 1;
        break;
      }
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4849);
  }
  
  public static void writeBooleanObject(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    int i = 0;
    AppMethodBeat.i(4819);
    if (paramBoolean == null)
    {
      if (paramBoolean1) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4819);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramInt = i;
    if (paramBoolean.booleanValue()) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
    AppMethodBeat.o(4819);
  }
  
  public static void writeBundle(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(4836);
    if (paramBundle == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4836);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4836);
  }
  
  public static void writeByte(Parcel paramParcel, int paramInt, byte paramByte)
  {
    AppMethodBeat.i(4820);
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
    AppMethodBeat.o(4820);
  }
  
  public static void writeByteArray(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(4837);
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4837);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4837);
  }
  
  public static void writeByteArrayArray(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(4838);
    if (paramArrayOfByte == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4838);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramArrayOfByte.length;
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeByteArray(paramArrayOfByte[paramInt]);
      paramInt += 1;
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4838);
  }
  
  public static void writeByteArraySparseArray(Parcel paramParcel, int paramInt, SparseArray<byte[]> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4872);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4872);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(paramInt));
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4872);
  }
  
  public static void writeChar(Parcel paramParcel, int paramInt, char paramChar)
  {
    AppMethodBeat.i(4821);
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
    AppMethodBeat.o(4821);
  }
  
  public static void writeCharArray(Parcel paramParcel, int paramInt, char[] paramArrayOfChar, boolean paramBoolean)
  {
    AppMethodBeat.i(4840);
    if (paramArrayOfChar == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4840);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeCharArray(paramArrayOfChar);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4840);
  }
  
  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(4830);
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
    AppMethodBeat.o(4830);
  }
  
  public static void writeDoubleArray(Parcel paramParcel, int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(4845);
    if (paramArrayOfDouble == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4845);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeDoubleArray(paramArrayOfDouble);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4845);
  }
  
  public static void writeDoubleList(Parcel paramParcel, int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4853);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4853);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeDouble(((Double)paramList.get(paramInt)).doubleValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4853);
  }
  
  public static void writeDoubleObject(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(4831);
    if (paramDouble == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4831);
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
    AppMethodBeat.o(4831);
  }
  
  public static void writeDoubleSparseArray(Parcel paramParcel, int paramInt, SparseArray<Double> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4864);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4864);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeDouble(((Double)paramSparseArray.valueAt(paramInt)).doubleValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4864);
  }
  
  public static void writeFloat(Parcel paramParcel, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(4828);
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
    AppMethodBeat.o(4828);
  }
  
  public static void writeFloatArray(Parcel paramParcel, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(4844);
    if (paramArrayOfFloat == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4844);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeFloatArray(paramArrayOfFloat);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4844);
  }
  
  public static void writeFloatList(Parcel paramParcel, int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4852);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4852);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeFloat(((Float)paramList.get(paramInt)).floatValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4852);
  }
  
  public static void writeFloatObject(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(4829);
    if (paramFloat == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4829);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
    AppMethodBeat.o(4829);
  }
  
  public static void writeFloatSparseArray(Parcel paramParcel, int paramInt, SparseArray<Float> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4865);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4865);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeFloat(((Float)paramSparseArray.valueAt(paramInt)).floatValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4865);
  }
  
  public static void writeIBinder(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    AppMethodBeat.i(4834);
    if (paramIBinder == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4834);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4834);
  }
  
  public static void writeIBinderArray(Parcel paramParcel, int paramInt, IBinder[] paramArrayOfIBinder, boolean paramBoolean)
  {
    AppMethodBeat.i(4848);
    if (paramArrayOfIBinder == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4848);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderArray(paramArrayOfIBinder);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4848);
  }
  
  public static void writeIBinderList(Parcel paramParcel, int paramInt, List<IBinder> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4855);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4855);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderList(paramList);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4855);
  }
  
  public static void writeIBinderSparseArray(Parcel paramParcel, int paramInt, SparseArray<IBinder> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4871);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4871);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(paramInt));
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4871);
  }
  
  public static void writeInt(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4823);
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
    AppMethodBeat.o(4823);
  }
  
  public static void writeIntArray(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4841);
    if (paramArrayOfInt == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4841);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfInt);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4841);
  }
  
  public static void writeIntegerList(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4850);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4850);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4850);
  }
  
  public static void writeIntegerObject(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    AppMethodBeat.i(4824);
    if (paramInteger == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4824);
      return;
    }
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
    AppMethodBeat.o(4824);
  }
  
  public static void writeList(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4862);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4862);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4862);
  }
  
  public static void writeLong(Parcel paramParcel, int paramInt, long paramLong)
  {
    AppMethodBeat.i(4825);
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
    AppMethodBeat.o(4825);
  }
  
  public static void writeLongArray(Parcel paramParcel, int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    AppMethodBeat.i(4842);
    if (paramArrayOfLong == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4842);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOfLong);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4842);
  }
  
  public static void writeLongList(Parcel paramParcel, int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4851);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4851);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeLong(((Long)paramList.get(paramInt)).longValue());
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4851);
  }
  
  public static void writeLongObject(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(4826);
    if (paramLong == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4826);
      return;
    }
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
    AppMethodBeat.o(4826);
  }
  
  public static void writeParcel(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    AppMethodBeat.i(4859);
    if (paramParcel2 == null)
    {
      if (paramBoolean) {
        zzb(paramParcel1, paramInt, 0);
      }
      AppMethodBeat.o(4859);
      return;
    }
    paramInt = zza(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzb(paramParcel1, paramInt);
    AppMethodBeat.o(4859);
  }
  
  public static void writeParcelArray(Parcel paramParcel, int paramInt, Parcel[] paramArrayOfParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(4860);
    if (paramArrayOfParcel == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4860);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfParcel.length;
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcel localParcel = paramArrayOfParcel[paramInt];
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4860);
  }
  
  public static void writeParcelList(Parcel paramParcel, int paramInt, List<Parcel> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4861);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4861);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcel localParcel = (Parcel)paramList.get(paramInt);
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4861);
  }
  
  public static void writeParcelSparseArray(Parcel paramParcel, int paramInt, SparseArray<Parcel> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4869);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4869);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcel localParcel = (Parcel)paramSparseArray.valueAt(paramInt);
      if (localParcel != null)
      {
        paramParcel.writeInt(localParcel.dataSize());
        paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramParcel.writeInt(0);
      }
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4869);
  }
  
  public static void writeParcelable(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(4835);
    if (paramParcelable == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt1, 0);
      }
      AppMethodBeat.o(4835);
      return;
    }
    paramInt1 = zza(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzb(paramParcel, paramInt1);
    AppMethodBeat.o(4835);
  }
  
  public static void writeShort(Parcel paramParcel, int paramInt, short paramShort)
  {
    AppMethodBeat.i(4822);
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
    AppMethodBeat.o(4822);
  }
  
  public static void writeSparseBooleanArray(Parcel paramParcel, int paramInt, SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4863);
    if (paramSparseBooleanArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4863);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4863);
  }
  
  public static void writeSparseIntArray(Parcel paramParcel, int paramInt, SparseIntArray paramSparseIntArray, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(4866);
    if (paramSparseIntArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4866);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramSparseIntArray.size();
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeInt(paramSparseIntArray.keyAt(paramInt));
      paramParcel.writeInt(paramSparseIntArray.valueAt(paramInt));
      paramInt += 1;
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4866);
  }
  
  public static void writeSparseLongArray(Parcel paramParcel, int paramInt, SparseLongArray paramSparseLongArray, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(4867);
    if (paramSparseLongArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4867);
      return;
    }
    int j = zza(paramParcel, paramInt);
    int k = paramSparseLongArray.size();
    paramParcel.writeInt(k);
    paramInt = i;
    while (paramInt < k)
    {
      paramParcel.writeInt(paramSparseLongArray.keyAt(paramInt));
      paramParcel.writeLong(paramSparseLongArray.valueAt(paramInt));
      paramInt += 1;
    }
    zzb(paramParcel, j);
    AppMethodBeat.o(4867);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(4833);
    if (paramString == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4833);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4833);
  }
  
  public static void writeStringArray(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(4847);
    if (paramArrayOfString == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4847);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4847);
  }
  
  public static void writeStringList(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4854);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4854);
      return;
    }
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzb(paramParcel, paramInt);
    AppMethodBeat.o(4854);
  }
  
  public static void writeStringSparseArray(Parcel paramParcel, int paramInt, SparseArray<String> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4868);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4868);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeString((String)paramSparseArray.valueAt(paramInt));
      paramInt += 1;
    }
    zzb(paramParcel, i);
    AppMethodBeat.o(4868);
  }
  
  public static <T extends Parcelable> void writeTypedArray(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(4856);
    if (paramArrayOfT == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt1, 0);
      }
      AppMethodBeat.o(4856);
      return;
    }
    int i = zza(paramParcel, paramInt1);
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
    zzb(paramParcel, i);
    AppMethodBeat.o(4856);
  }
  
  public static <T extends Parcelable> void writeTypedList(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(4857);
    if (paramList == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4857);
      return;
    }
    int i = zza(paramParcel, paramInt);
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
    zzb(paramParcel, i);
    AppMethodBeat.o(4857);
  }
  
  public static <T extends Parcelable> void writeTypedSparseArray(Parcel paramParcel, int paramInt, SparseArray<T> paramSparseArray, boolean paramBoolean)
  {
    AppMethodBeat.i(4870);
    if (paramSparseArray == null)
    {
      if (paramBoolean) {
        zzb(paramParcel, paramInt, 0);
      }
      AppMethodBeat.o(4870);
      return;
    }
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcelable localParcelable = (Parcelable)paramSparseArray.valueAt(paramInt);
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
    zzb(paramParcel, i);
    AppMethodBeat.o(4870);
  }
  
  private static int zza(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4814);
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    paramInt = paramParcel.dataPosition();
    AppMethodBeat.o(4814);
    return paramInt;
  }
  
  private static <T extends Parcelable> void zza(Parcel paramParcel, T paramT, int paramInt)
  {
    AppMethodBeat.i(4858);
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
    AppMethodBeat.o(4858);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4815);
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
    AppMethodBeat.o(4815);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4813);
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      AppMethodBeat.o(4813);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
    AppMethodBeat.o(4813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 * JD-Core Version:    0.7.0.1
 */