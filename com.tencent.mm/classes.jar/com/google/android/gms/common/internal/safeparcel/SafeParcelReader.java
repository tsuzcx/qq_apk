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
    AppMethodBeat.i(4772);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4772);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    paramParcel = new BigDecimal(new BigInteger(arrayOfByte), j);
    AppMethodBeat.o(4772);
    return paramParcel;
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4786);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4786);
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
    AppMethodBeat.o(4786);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4767);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4767);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    paramParcel = new BigInteger(arrayOfByte);
    AppMethodBeat.o(4767);
    return paramParcel;
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4783);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4783);
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
    AppMethodBeat.o(4783);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4779);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4779);
      return null;
    }
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4779);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4789);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4789);
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
    AppMethodBeat.o(4789);
    return localArrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4776);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4776);
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4776);
    return localBundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4777);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4777);
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4777);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4778);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4778);
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
    AppMethodBeat.o(4778);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4800);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4800);
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
    AppMethodBeat.o(4800);
    return localSparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4780);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4780);
      return null;
    }
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4780);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4785);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4785);
      return null;
    }
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4785);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4803);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4803);
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
    AppMethodBeat.o(4803);
    return localArrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4794);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4794);
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
    AppMethodBeat.o(4794);
    return localSparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4784);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4784);
      return null;
    }
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4784);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4802);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4802);
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
    AppMethodBeat.o(4802);
    return localArrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4793);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4793);
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
    AppMethodBeat.o(4793);
    return localSparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4788);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4788);
      return null;
    }
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4788);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4805);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4805);
      return null;
    }
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4805);
    return localArrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4799);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4799);
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
    AppMethodBeat.o(4799);
    return localSparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4781);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4781);
      return null;
    }
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4781);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4790);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4790);
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
    AppMethodBeat.o(4790);
    return localArrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4782);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4782);
      return null;
    }
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4782);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4801);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4801);
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
    AppMethodBeat.o(4801);
    return localArrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4808);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4808);
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4808);
    return localParcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4809);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4809);
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
    AppMethodBeat.o(4809);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4810);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4810);
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
    AppMethodBeat.o(4810);
    return localArrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4797);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4797);
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
    AppMethodBeat.o(4797);
    return localSparseArray;
  }
  
  public static <T extends Parcelable> T createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(4775);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4775);
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4775);
    return paramCreator;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4791);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4791);
      return null;
    }
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4791);
    return localSparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4792);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4792);
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
    AppMethodBeat.o(4792);
    return localSparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4795);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4795);
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
    AppMethodBeat.o(4795);
    return localSparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4773);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4773);
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4773);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4787);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4787);
      return null;
    }
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4787);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4804);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4804);
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4804);
    return localArrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4796);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4796);
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
    AppMethodBeat.o(4796);
    return localSparseArray;
  }
  
  public static <T> T[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(4806);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4806);
      return null;
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4806);
    return paramCreator;
  }
  
  public static <T> ArrayList<T> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(4807);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4807);
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4807);
    return paramCreator;
  }
  
  public static <T> SparseArray<T> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(4798);
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
    {
      AppMethodBeat.o(4798);
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
    AppMethodBeat.o(4798);
    return localSparseArray;
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4812);
    if (paramParcel.dataPosition() != paramInt)
    {
      paramParcel = new ParseException(37 + "Overread allowed size end=" + paramInt, paramParcel);
      AppMethodBeat.o(4812);
      throw paramParcel;
    }
    AppMethodBeat.o(4812);
  }
  
  public static int getFieldId(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4758);
    zza(paramParcel, paramInt, 4);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(4758);
      return true;
    }
    AppMethodBeat.o(4758);
    return false;
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4759);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(4759);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(4759);
      return Boolean.valueOf(bool);
    }
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4760);
    zza(paramParcel, paramInt, 4);
    byte b = (byte)paramParcel.readInt();
    AppMethodBeat.o(4760);
    return b;
  }
  
  public static char readChar(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4761);
    zza(paramParcel, paramInt, 4);
    char c = (char)paramParcel.readInt();
    AppMethodBeat.o(4761);
    return c;
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4770);
    zza(paramParcel, paramInt, 8);
    double d = paramParcel.readDouble();
    AppMethodBeat.o(4770);
    return d;
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4771);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(4771);
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    double d = paramParcel.readDouble();
    AppMethodBeat.o(4771);
    return Double.valueOf(d);
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4768);
    zza(paramParcel, paramInt, 4);
    float f = paramParcel.readFloat();
    AppMethodBeat.o(4768);
    return f;
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4769);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(4769);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    float f = paramParcel.readFloat();
    AppMethodBeat.o(4769);
    return Float.valueOf(f);
  }
  
  public static int readHeader(Parcel paramParcel)
  {
    AppMethodBeat.i(4752);
    int i = paramParcel.readInt();
    AppMethodBeat.o(4752);
    return i;
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4774);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4774);
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4774);
    return localIBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4763);
    zza(paramParcel, paramInt, 4);
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(4763);
    return paramInt;
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4764);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(4764);
      return null;
    }
    zza(paramParcel, paramInt, i, 4);
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(4764);
    return Integer.valueOf(paramInt);
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(4811);
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
    {
      AppMethodBeat.o(4811);
      return;
    }
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(paramInt + i);
    AppMethodBeat.o(4811);
  }
  
  public static long readLong(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4765);
    zza(paramParcel, paramInt, 8);
    long l = paramParcel.readLong();
    AppMethodBeat.o(4765);
    return l;
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4766);
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
    {
      AppMethodBeat.o(4766);
      return null;
    }
    zza(paramParcel, paramInt, i, 8);
    long l = paramParcel.readLong();
    AppMethodBeat.o(4766);
    return Long.valueOf(l);
  }
  
  public static short readShort(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4762);
    zza(paramParcel, paramInt, 4);
    short s = (short)paramParcel.readInt();
    AppMethodBeat.o(4762);
    return s;
  }
  
  public static int readSize(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4753);
    if ((paramInt & 0xFFFF0000) != -65536)
    {
      AppMethodBeat.o(4753);
      return paramInt >> 16 & 0xFFFF;
    }
    paramInt = paramParcel.readInt();
    AppMethodBeat.o(4753);
    return paramInt;
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4754);
    paramParcel.setDataPosition(readSize(paramParcel, paramInt) + paramParcel.dataPosition());
    AppMethodBeat.o(4754);
  }
  
  public static int validateObjectHeader(Parcel paramParcel)
  {
    AppMethodBeat.i(4757);
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
        AppMethodBeat.o(4757);
        throw paramParcel;
      }
    }
    j = i + k;
    if ((j < i) || (j > paramParcel.dataSize()))
    {
      paramParcel = new ParseException(54 + "Size read is invalid start=" + i + " end=" + j, paramParcel);
      AppMethodBeat.o(4757);
      throw paramParcel;
    }
    AppMethodBeat.o(4757);
    return j;
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4755);
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 != paramInt2)
    {
      String str = Integer.toHexString(paramInt1);
      paramParcel = new ParseException(String.valueOf(str).length() + 46 + "Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + str + ")", paramParcel);
      AppMethodBeat.o(4755);
      throw paramParcel;
    }
    AppMethodBeat.o(4755);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4756);
    if (paramInt2 != paramInt3)
    {
      String str = Integer.toHexString(paramInt2);
      paramParcel = new ParseException(String.valueOf(str).length() + 46 + "Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + str + ")", paramParcel);
      AppMethodBeat.o(4756);
      throw paramParcel;
    }
    AppMethodBeat.o(4756);
  }
  
  public static class ParseException
    extends RuntimeException
  {
    public ParseException(String paramString, Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(4751);
      AppMethodBeat.o(4751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelReader
 * JD-Core Version:    0.7.0.1
 */