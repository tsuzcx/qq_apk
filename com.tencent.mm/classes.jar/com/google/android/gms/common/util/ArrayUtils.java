package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@VisibleForTesting
public final class ArrayUtils
{
  public static int[] appendToArray(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(5043);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {}
    for (paramArrayOfInt = new int[1];; paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length + 1))
    {
      paramArrayOfInt[(paramArrayOfInt.length - 1)] = paramInt;
      AppMethodBeat.o(5043);
      return paramArrayOfInt;
    }
  }
  
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(5042);
    if ((paramArrayOfT == null) && (paramT == null))
    {
      paramArrayOfT = new IllegalArgumentException("Cannot generate array of generic type w/o class info");
      AppMethodBeat.o(5042);
      throw paramArrayOfT;
    }
    if (paramArrayOfT == null) {}
    for (paramArrayOfT = (Object[])Array.newInstance(paramT.getClass(), 1);; paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1))
    {
      paramArrayOfT[(paramArrayOfT.length - 1)] = paramT;
      AppMethodBeat.o(5042);
      return paramArrayOfT;
    }
  }
  
  public static <T> T[] concat(T[]... paramVarArgs)
  {
    AppMethodBeat.i(5040);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = (Object[])Array.newInstance(paramVarArgs.getClass(), 0);
      AppMethodBeat.o(5040);
      return paramVarArgs;
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    Object[] arrayOfObject = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      T[] arrayOfT = paramVarArgs[i];
      System.arraycopy(arrayOfT, 0, arrayOfObject, j, arrayOfT.length);
      j += arrayOfT.length;
      i += 1;
    }
    AppMethodBeat.o(5040);
    return arrayOfObject;
  }
  
  public static byte[] concatByteArrays(byte[]... paramVarArgs)
  {
    AppMethodBeat.i(5041);
    if (paramVarArgs.length == 0)
    {
      AppMethodBeat.o(5041);
      return new byte[0];
    }
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], j);
    j = paramVarArgs[0].length;
    i = 1;
    while (i < paramVarArgs.length)
    {
      byte[] arrayOfByte2 = paramVarArgs[i];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    AppMethodBeat.o(5041);
    return arrayOfByte1;
  }
  
  public static boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfByte[i] == paramByte) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contains(char[] paramArrayOfChar, char paramChar)
  {
    if (paramArrayOfChar == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfChar[i] == paramChar) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contains(double[] paramArrayOfDouble, double paramDouble)
  {
    if (paramArrayOfDouble == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfDouble[i] == paramDouble) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contains(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    if (paramArrayOfFloat == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        float f = paramArrayOfFloat[i];
        if ((paramFloat1 - paramFloat2 <= f) && (f <= paramFloat1 + paramFloat2)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(5022);
    if (indexOf(paramArrayOfT, paramT) >= 0)
    {
      AppMethodBeat.o(5022);
      return true;
    }
    AppMethodBeat.o(5022);
    return false;
  }
  
  public static boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfShort.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfShort[i] == paramShort) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfBoolean.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfBoolean[i] == paramBoolean) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean containsIgnoreCase(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(5023);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(5023);
      return false;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str == paramString)
      {
        AppMethodBeat.o(5023);
        return true;
      }
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        AppMethodBeat.o(5023);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(5023);
    return false;
  }
  
  public static boolean equalsAnyOrder(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(5024);
    if (paramArrayOfObject1 == paramArrayOfObject2)
    {
      AppMethodBeat.o(5024);
      return true;
    }
    if (paramArrayOfObject1 == null)
    {
      i = 0;
      if (paramArrayOfObject2 != null) {
        break label53;
      }
    }
    label53:
    for (int j = 0;; j = paramArrayOfObject2.length)
    {
      if ((i != 0) || (j != 0)) {
        break label59;
      }
      AppMethodBeat.o(5024);
      return true;
      i = paramArrayOfObject1.length;
      break;
    }
    label59:
    if (i != j)
    {
      AppMethodBeat.o(5024);
      return false;
    }
    zza localzza = new zza(i);
    j = paramArrayOfObject1.length;
    int i = 0;
    while (i < j)
    {
      localzza.zzb(paramArrayOfObject1[i]);
      i += 1;
    }
    j = paramArrayOfObject2.length;
    i = 0;
    while (i < j)
    {
      localzza.zzc(paramArrayOfObject2[i]);
      i += 1;
    }
    paramArrayOfObject1 = localzza.zzzb.values().iterator();
    while (paramArrayOfObject1.hasNext()) {
      if (((zza)paramArrayOfObject1.next()).count != 0)
      {
        AppMethodBeat.o(5024);
        return false;
      }
    }
    AppMethodBeat.o(5024);
    return true;
  }
  
  public static <T> int indexOf(T[] paramArrayOfT, T paramT)
  {
    int j = 0;
    AppMethodBeat.i(5021);
    int i;
    if (paramArrayOfT != null) {
      i = paramArrayOfT.length;
    }
    while (j < i) {
      if (Objects.equal(paramArrayOfT[j], paramT))
      {
        AppMethodBeat.o(5021);
        return j;
        i = 0;
      }
      else
      {
        j += 1;
      }
    }
    AppMethodBeat.o(5021);
    return -1;
  }
  
  public static <T> ArrayList<T> newArrayList()
  {
    AppMethodBeat.i(5049);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(5049);
    return localArrayList;
  }
  
  public static <T> int rearrange(T[] paramArrayOfT, Predicate<T> paramPredicate)
  {
    AppMethodBeat.i(5048);
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      AppMethodBeat.o(5048);
      return 0;
    }
    int m = paramArrayOfT.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (paramPredicate.apply(paramArrayOfT[i]))
      {
        if (j != i)
        {
          T ? = paramArrayOfT[j];
          paramArrayOfT[j] = paramArrayOfT[i];
          paramArrayOfT[i] = ?;
        }
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(5048);
    return j;
  }
  
  public static int[] removeAll(int[] paramArrayOfInt1, int... paramVarArgs)
  {
    AppMethodBeat.i(5045);
    if (paramArrayOfInt1 == null)
    {
      AppMethodBeat.o(5045);
      return null;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramArrayOfInt1 = Arrays.copyOf(paramArrayOfInt1, paramArrayOfInt1.length);
      AppMethodBeat.o(5045);
      return paramArrayOfInt1;
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length];
    int m;
    int j;
    int i;
    int k;
    int n;
    if (paramVarArgs.length == 1)
    {
      m = paramArrayOfInt1.length;
      j = 0;
      i = 0;
      k = i;
      if (j >= m) {
        break label157;
      }
      n = paramArrayOfInt1[j];
      if (paramVarArgs[0] == n) {
        break label176;
      }
      k = i + 1;
      arrayOfInt[i] = n;
      i = k;
    }
    label157:
    label173:
    label176:
    for (;;)
    {
      j += 1;
      break;
      m = paramArrayOfInt1.length;
      j = 0;
      i = 0;
      k = i;
      if (j < m)
      {
        n = paramArrayOfInt1[j];
        if (contains(paramVarArgs, n)) {
          break label173;
        }
        k = i + 1;
        arrayOfInt[i] = n;
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfInt1 = resize(arrayOfInt, k);
        AppMethodBeat.o(5045);
        return paramArrayOfInt1;
      }
    }
  }
  
  public static <T> T[] removeAll(T[] paramArrayOfT1, T... paramVarArgs)
  {
    AppMethodBeat.i(5044);
    if (paramArrayOfT1 == null)
    {
      AppMethodBeat.o(5044);
      return null;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramArrayOfT1 = Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length);
      AppMethodBeat.o(5044);
      return paramArrayOfT1;
    }
    Object[] arrayOfObject = (Object[])Array.newInstance(paramVarArgs.getClass().getComponentType(), paramArrayOfT1.length);
    int m;
    int j;
    int i;
    int k;
    T ?;
    if (paramVarArgs.length == 1)
    {
      m = paramArrayOfT1.length;
      j = 0;
      i = 0;
      k = i;
      if (j >= m) {
        break label171;
      }
      ? = paramArrayOfT1[j];
      if (Objects.equal(paramVarArgs[0], ?)) {
        break label190;
      }
      k = i + 1;
      arrayOfObject[i] = ?;
      i = k;
    }
    label171:
    label187:
    label190:
    for (;;)
    {
      j += 1;
      break;
      m = paramArrayOfT1.length;
      j = 0;
      i = 0;
      k = i;
      if (j < m)
      {
        ? = paramArrayOfT1[j];
        if (contains(paramVarArgs, ?)) {
          break label187;
        }
        k = i + 1;
        arrayOfObject[i] = ?;
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfT1 = resize(arrayOfObject, k);
        AppMethodBeat.o(5044);
        return paramArrayOfT1;
      }
    }
  }
  
  public static int[] resize(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(5047);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(5047);
      return null;
    }
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt != paramArrayOfInt.length) {
      arrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    }
    AppMethodBeat.o(5047);
    return arrayOfInt;
  }
  
  public static <T> T[] resize(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(5046);
    if (paramArrayOfT == null)
    {
      AppMethodBeat.o(5046);
      return null;
    }
    Object localObject = paramArrayOfT;
    if (paramInt != paramArrayOfT.length) {
      localObject = Arrays.copyOf(paramArrayOfT, paramInt);
    }
    AppMethodBeat.o(5046);
    return localObject;
  }
  
  public static <T> ArrayList<T> toArrayList(Collection<T> paramCollection)
  {
    AppMethodBeat.i(5051);
    if (paramCollection == null)
    {
      AppMethodBeat.o(5051);
      return null;
    }
    paramCollection = new ArrayList(paramCollection);
    AppMethodBeat.o(5051);
    return paramCollection;
  }
  
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT)
  {
    AppMethodBeat.i(5050);
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfT[i]);
      i += 1;
    }
    AppMethodBeat.o(5050);
    return localArrayList;
  }
  
  public static long[] toLongArray(Collection<Long> paramCollection)
  {
    AppMethodBeat.i(5054);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(5054);
      return new long[0];
    }
    long[] arrayOfLong = new long[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfLong[i] = ((Long)paramCollection.next()).longValue();
      i += 1;
    }
    AppMethodBeat.o(5054);
    return arrayOfLong;
  }
  
  public static long[] toLongArray(Long[] paramArrayOfLong)
  {
    int i = 0;
    AppMethodBeat.i(5055);
    if (paramArrayOfLong == null)
    {
      AppMethodBeat.o(5055);
      return new long[0];
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    while (i < paramArrayOfLong.length)
    {
      arrayOfLong[i] = paramArrayOfLong[i].longValue();
      i += 1;
    }
    AppMethodBeat.o(5055);
    return arrayOfLong;
  }
  
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection)
  {
    AppMethodBeat.i(5052);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(5052);
      return new int[0];
    }
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramCollection.next()).intValue();
      i += 1;
    }
    AppMethodBeat.o(5052);
    return arrayOfInt;
  }
  
  public static int[] toPrimitiveArray(Integer[] paramArrayOfInteger)
  {
    int i = 0;
    AppMethodBeat.i(5053);
    if (paramArrayOfInteger == null)
    {
      AppMethodBeat.o(5053);
      return new int[0];
    }
    int[] arrayOfInt = new int[paramArrayOfInteger.length];
    while (i < paramArrayOfInteger.length)
    {
      arrayOfInt[i] = paramArrayOfInteger[i].intValue();
      i += 1;
    }
    AppMethodBeat.o(5053);
    return arrayOfInt;
  }
  
  public static String[] toStringArray(Collection<String> paramCollection)
  {
    AppMethodBeat.i(5056);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      AppMethodBeat.o(5056);
      return new String[0];
    }
    paramCollection = (String[])paramCollection.toArray(new String[paramCollection.size()]);
    AppMethodBeat.o(5056);
    return paramCollection;
  }
  
  public static Boolean[] toWrapperArray(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(5031);
    if (paramArrayOfBoolean == null)
    {
      AppMethodBeat.o(5031);
      return null;
    }
    int j = paramArrayOfBoolean.length;
    Boolean[] arrayOfBoolean = new Boolean[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBoolean[i] = Boolean.valueOf(paramArrayOfBoolean[i]);
      i += 1;
    }
    AppMethodBeat.o(5031);
    return arrayOfBoolean;
  }
  
  public static Byte[] toWrapperArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5030);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(5030);
      return null;
    }
    int j = paramArrayOfByte.length;
    Byte[] arrayOfByte = new Byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Byte.valueOf(paramArrayOfByte[i]);
      i += 1;
    }
    AppMethodBeat.o(5030);
    return arrayOfByte;
  }
  
  public static Character[] toWrapperArray(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(5026);
    if (paramArrayOfChar == null)
    {
      AppMethodBeat.o(5026);
      return null;
    }
    int j = paramArrayOfChar.length;
    Character[] arrayOfCharacter = new Character[j];
    int i = 0;
    while (i < j)
    {
      arrayOfCharacter[i] = Character.valueOf(paramArrayOfChar[i]);
      i += 1;
    }
    AppMethodBeat.o(5026);
    return arrayOfCharacter;
  }
  
  public static Double[] toWrapperArray(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(5028);
    if (paramArrayOfDouble == null)
    {
      AppMethodBeat.o(5028);
      return null;
    }
    int j = paramArrayOfDouble.length;
    Double[] arrayOfDouble = new Double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
      i += 1;
    }
    AppMethodBeat.o(5028);
    return arrayOfDouble;
  }
  
  public static Float[] toWrapperArray(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(5029);
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(5029);
      return null;
    }
    int j = paramArrayOfFloat.length;
    Float[] arrayOfFloat = new Float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
      i += 1;
    }
    AppMethodBeat.o(5029);
    return arrayOfFloat;
  }
  
  public static Integer[] toWrapperArray(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(5025);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(5025);
      return null;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(5025);
    return arrayOfInteger;
  }
  
  public static Long[] toWrapperArray(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(5027);
    if (paramArrayOfLong == null)
    {
      AppMethodBeat.o(5027);
      return null;
    }
    int j = paramArrayOfLong.length;
    Long[] arrayOfLong = new Long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    AppMethodBeat.o(5027);
    return arrayOfLong;
  }
  
  public static Short[] toWrapperArray(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(5032);
    if (paramArrayOfShort == null)
    {
      AppMethodBeat.o(5032);
      return null;
    }
    int j = paramArrayOfShort.length;
    Short[] arrayOfShort = new Short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = Short.valueOf(paramArrayOfShort[i]);
      i += 1;
    }
    AppMethodBeat.o(5032);
    return arrayOfShort;
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(5037);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
      i += 1;
    }
    AppMethodBeat.o(5037);
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(5036);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
      i += 1;
    }
    AppMethodBeat.o(5036);
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(5034);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
      i += 1;
    }
    AppMethodBeat.o(5034);
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(5035);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
      i += 1;
    }
    AppMethodBeat.o(5035);
  }
  
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    AppMethodBeat.i(5033);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[i].toString());
      i += 1;
    }
    AppMethodBeat.o(5033);
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(5038);
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
      i += 1;
    }
    AppMethodBeat.o(5038);
  }
  
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    AppMethodBeat.i(5039);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"").append(paramArrayOfString[i]).append("\"");
      i += 1;
    }
    AppMethodBeat.o(5039);
  }
  
  static final class zza
  {
    HashMap<Object, zza> zzzb;
    
    zza(int paramInt)
    {
      AppMethodBeat.i(5017);
      this.zzzb = new HashMap(paramInt);
      AppMethodBeat.o(5017);
    }
    
    private final zza zzd(Object paramObject)
    {
      AppMethodBeat.i(5020);
      zza localzza2 = (zza)this.zzzb.get(paramObject);
      zza localzza1 = localzza2;
      if (localzza2 == null)
      {
        localzza1 = new zza();
        this.zzzb.put(paramObject, localzza1);
      }
      AppMethodBeat.o(5020);
      return localzza1;
    }
    
    final void zzb(Object paramObject)
    {
      AppMethodBeat.i(5018);
      paramObject = zzd(paramObject);
      paramObject.count += 1;
      AppMethodBeat.o(5018);
    }
    
    final void zzc(Object paramObject)
    {
      AppMethodBeat.i(5019);
      paramObject = zzd(paramObject);
      paramObject.count -= 1;
      AppMethodBeat.o(5019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */