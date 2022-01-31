package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader
{
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89750);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89750);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    paramParcel = new BigDecimal(new BigInteger(arrayOfByte), j);
    AppMethodBeat.o(89750);
    return paramParcel;
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89764);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89764);
      return null;
    }
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    paramInt = 0;
    while (paramInt < k)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int m = paramParcel.readInt();
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89764);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89745);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89745);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    paramParcel = new BigInteger(arrayOfByte);
    AppMethodBeat.o(89745);
    return paramParcel;
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89761);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89761);
      return null;
    }
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89761);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89757);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89757);
      return null;
    }
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89757);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89767);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89767);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    if (paramInt < k)
    {
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        paramInt += 1;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89767);
    return localArrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89754);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89754);
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89754);
    return localBundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89755);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89755);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89755);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89756);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89756);
      return null;
    }
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfByte[paramInt] = paramParcel.createByteArray();
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89756);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89778);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89778);
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89778);
    return localSparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89758);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89758);
      return null;
    }
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89758);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89763);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89763);
      return null;
    }
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89763);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89781);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89781);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89781);
    return localArrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89772);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89772);
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89772);
    return localSparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89762);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89762);
      return null;
    }
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89762);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89780);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89780);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89780);
    return localArrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89771);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89771);
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89771);
    return localSparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89766);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89766);
      return null;
    }
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89766);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89783);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89783);
      return null;
    }
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89783);
    return localArrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89777);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89777);
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89777);
    return localSparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89759);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89759);
      return null;
    }
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89759);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89768);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89768);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89768);
    return localArrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89760);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89760);
      return null;
    }
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89760);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89779);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89779);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Long.valueOf(paramParcel.readLong()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89779);
    return localArrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89786);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89786);
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89786);
    return localParcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89787);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89787);
      return null;
    }
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m != 0)
      {
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = localParcel;
        paramParcel.setDataPosition(m + n);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        arrayOfParcel[paramInt] = null;
      }
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89787);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89788);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89788);
      return null;
    }
    int k = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m != 0)
      {
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        localArrayList.add(localParcel);
        paramParcel.setDataPosition(m + n);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localArrayList.add(null);
      }
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89788);
    return localArrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89775);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89775);
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n != 0)
      {
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        localSparseArray.append(m, localParcel);
        paramParcel.setDataPosition(i1 + n);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localSparseArray.append(m, null);
      }
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89775);
    return localSparseArray;
  }
  
  public static <T extends Parcelable> T createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89753);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89753);
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89753);
    return paramCreator;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89769);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89769);
      return null;
    }
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89769);
    return localSparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89770);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89770);
      return null;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseIntArray.append(paramParcel.readInt(), paramParcel.readInt());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89770);
    return localSparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89773);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89773);
      return null;
    }
    SparseLongArray localSparseLongArray = new SparseLongArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseLongArray.append(paramParcel.readInt(), paramParcel.readLong());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89773);
    return localSparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89751);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89751);
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89751);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89765);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89765);
      return null;
    }
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89765);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89782);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89782);
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89782);
    return localArrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89774);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89774);
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readString());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89774);
    return localSparseArray;
  }
  
  public static <T> T[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89784);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89784);
      return null;
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89784);
    return paramCreator;
  }
  
  public static <T> ArrayList<T> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89785);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89785);
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89785);
    return paramCreator;
  }
  
  public static <T> SparseArray<T> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(89776);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(89776);
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (Object localObject = paramCreator.createFromParcel(paramParcel);; localObject = null)
      {
        localSparseArray.append(m, localObject);
        paramInt += 1;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    AppMethodBeat.o(89776);
    return localSparseArray;
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89790);
    if (paramParcel.dataPosition() != paramInt)
    {
      paramParcel = new ParseException(37 + "Overread allowed size end=" + paramInt, paramParcel);
      AppMethodBeat.o(89790);
      throw paramParcel;
    }
    AppMethodBeat.o(89790);
  }
  
  public static int getFieldId(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89736);
    zza(paramParcel, paramInt, 4);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(89736);
      return true;
    }
    AppMethodBeat.o(89736);
    return false;
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89737);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(89737);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(89737);
      return Boolean.valueOf(bool);
    }
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89738);
    zza(paramParcel, paramInt, 4);
    byte b = (byte)paramParcel.readInt();
    AppMethodBeat.o(89738);
    return b;
  }
  
  public static char readChar(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89739);
    zza(paramParcel, paramInt, 4);
    char c = (char)paramParcel.readInt();
    AppMethodBeat.o(89739);
    return c;
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89748);
    zza(paramParcel, paramInt, 8);
    double d = paramParcel.readDouble();
    AppMethodBeat.o(89748);
    return d;
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89749);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(89749);
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    double d = paramParcel.readDouble();
    AppMethodBeat.o(89749);
    return Double.valueOf(d);
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89746);
    zza(paramParcel, paramInt, 4);
    float f = paramParcel.readFloat();
    AppMethodBeat.o(89746);
    return f;
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89747);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(89747);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    float f = paramParcel.readFloat();
    AppMethodBeat.o(89747);
    return Float.valueOf(f);
  }
  
  public static int readHeader(Parcel paramParcel)
  {
    AppMethodBeat.i(89730);
    int i = paramParcel.readInt();
    AppMethodBeat.o(89730);
    return i;
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89752);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89752);
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89752);
    return localIBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89741);
    zza(paramParcel, paramInt, 4);
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(89741);
    return paramInt;
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89742);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(89742);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(89742);
    return Integer.valueOf(paramInt);
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(89789);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(89789);
      return;
    }
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(89789);
  }
  
  public static long readLong(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89743);
    zza(paramParcel, paramInt, 8);
    long l = paramParcel.readLong();
    AppMethodBeat.o(89743);
    return l;
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89744);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(89744);
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    long l = paramParcel.readLong();
    AppMethodBeat.o(89744);
    return Long.valueOf(l);
  }
  
  public static short readShort(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89740);
    zza(paramParcel, paramInt, 4);
    short s = (short)paramParcel.readInt();
    AppMethodBeat.o(89740);
    return s;
  }
  
  public static int readSize(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89731);
    if ((paramInt & 0xFFFF0000) != -65536)
    {
      AppMethodBeat.o(89731);
      return paramInt >> 16 & 0xFFFF;
    }
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(89731);
    return paramInt;
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89732);
    paramParcel.setDataPosition(readSize(paramParcel, paramInt) + paramParcel.dataPosition());
    AppMethodBeat.o(89732);
  }
  
  public static int validateObjectHeader(Parcel paramParcel)
  {
    AppMethodBeat.i(89735);
    int j = readHeader(paramParcel);
    int k = readSize(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (getFieldId(j) != 20293)
    {
      String str = String.valueOf(Integer.toHexString(j));
      if (str.length() != 0) {}
      for (str = "Expected object header. Got 0x".concat(str);; str = new String("Expected object header. Got 0x"))
      {
        paramParcel = new ParseException(str, paramParcel);
        AppMethodBeat.o(89735);
        throw paramParcel;
      }
    }
    j = i + k;
    if ((j < i) || (j > paramParcel.dataSize()))
    {
      paramParcel = new ParseException(54 + "Size read is invalid start=" + i + " end=" + j, paramParcel);
      AppMethodBeat.o(89735);
      throw paramParcel;
    }
    AppMethodBeat.o(89735);
    return j;
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89733);
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 != paramInt2)
    {
      String str = Integer.toHexString(paramInt1);
      paramParcel = new ParseException(String.valueOf(str).length() + 46 + "Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + str + ")", paramParcel);
      AppMethodBeat.o(89733);
      throw paramParcel;
    }
    AppMethodBeat.o(89733);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89734);
    if (paramInt2 != paramInt3)
    {
      String str = Integer.toHexString(paramInt2);
      paramParcel = new ParseException(String.valueOf(str).length() + 46 + "Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + str + ")", paramParcel);
      AppMethodBeat.o(89734);
      throw paramParcel;
    }
    AppMethodBeat.o(89734);
  }
  
  public static class ParseException
    extends RuntimeException
  {
    public ParseException(String paramString, Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(89729);
      AppMethodBeat.o(89729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelReader
 * JD-Core Version:    0.7.0.1
 */