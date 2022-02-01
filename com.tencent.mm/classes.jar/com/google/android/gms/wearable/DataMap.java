package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@VisibleForTesting
public class DataMap
{
  public static final String TAG = "DataMap";
  private final HashMap<String, Object> zzq;
  
  public DataMap()
  {
    AppMethodBeat.i(100786);
    this.zzq = new HashMap();
    AppMethodBeat.o(100786);
  }
  
  public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> paramArrayList)
  {
    AppMethodBeat.i(100789);
    ArrayList localArrayList = new ArrayList();
    paramArrayList = (ArrayList)paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      i += 1;
      localArrayList.add(fromBundle((Bundle)localObject));
    }
    AppMethodBeat.o(100789);
    return localArrayList;
  }
  
  public static DataMap fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(100787);
    paramBundle.setClassLoader(Asset.class.getClassLoader());
    DataMap localDataMap = new DataMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String)) {
        localDataMap.putString(str, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        localDataMap.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        localDataMap.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Double)) {
        localDataMap.putDouble(str, ((Double)localObject).doubleValue());
      } else if ((localObject instanceof Float)) {
        localDataMap.putFloat(str, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Boolean)) {
        localDataMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if ((localObject instanceof Byte)) {
        localDataMap.putByte(str, ((Byte)localObject).byteValue());
      } else if ((localObject instanceof byte[])) {
        localDataMap.putByteArray(str, (byte[])localObject);
      } else if ((localObject instanceof String[])) {
        localDataMap.putStringArray(str, (String[])localObject);
      } else if ((localObject instanceof long[])) {
        localDataMap.putLongArray(str, (long[])localObject);
      } else if ((localObject instanceof float[])) {
        localDataMap.putFloatArray(str, (float[])localObject);
      } else if ((localObject instanceof Asset)) {
        localDataMap.putAsset(str, (Asset)localObject);
      } else if ((localObject instanceof Bundle)) {
        localDataMap.putDataMap(str, fromBundle((Bundle)localObject));
      } else if ((localObject instanceof ArrayList)) {
        switch (zza((ArrayList)localObject))
        {
        case 4: 
        default: 
          break;
        case 0: 
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 1: 
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 3: 
          localDataMap.putStringArrayList(str, (ArrayList)localObject);
          break;
        case 2: 
          localDataMap.putIntegerArrayList(str, (ArrayList)localObject);
          break;
        case 5: 
          localDataMap.putDataMapArrayList(str, arrayListFromBundleArrayList((ArrayList)localObject));
        }
      }
    }
    AppMethodBeat.o(100787);
    return localDataMap;
  }
  
  public static DataMap fromByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(100788);
    try
    {
      paramArrayOfByte = zze.zza(new zzf(zzg.zza(paramArrayOfByte), new ArrayList()));
      AppMethodBeat.o(100788);
      return paramArrayOfByte;
    }
    catch (zzs paramArrayOfByte)
    {
      paramArrayOfByte = new IllegalArgumentException("Unable to convert data", paramArrayOfByte);
      AppMethodBeat.o(100788);
      throw paramArrayOfByte;
    }
  }
  
  private static int zza(ArrayList<?> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(100844);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(100844);
      return 0;
    }
    paramArrayList = (ArrayList)paramArrayList;
    int k = paramArrayList.size();
    while (i < k)
    {
      Object localObject = paramArrayList.get(i);
      int j = i + 1;
      i = j;
      if (localObject != null)
      {
        if ((localObject instanceof Integer))
        {
          AppMethodBeat.o(100844);
          return 2;
        }
        if ((localObject instanceof String))
        {
          AppMethodBeat.o(100844);
          return 3;
        }
        if ((localObject instanceof DataMap))
        {
          AppMethodBeat.o(100844);
          return 4;
        }
        i = j;
        if ((localObject instanceof Bundle))
        {
          AppMethodBeat.o(100844);
          return 5;
        }
      }
    }
    AppMethodBeat.o(100844);
    return 1;
  }
  
  private static void zza(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(100842);
    zza(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
    AppMethodBeat.o(100842);
  }
  
  private static void zza(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(100843);
    paramClassCastException = new StringBuilder();
    paramClassCastException.append("Key ");
    paramClassCastException.append(paramString1);
    paramClassCastException.append(" expected ");
    paramClassCastException.append(paramString2);
    paramClassCastException.append(" but value was a ");
    paramClassCastException.append(paramObject1.getClass().getName());
    paramClassCastException.append(".  The default value ");
    paramClassCastException.append(paramObject2);
    paramClassCastException.append(" was returned.");
    AppMethodBeat.o(100843);
  }
  
  public void clear()
  {
    AppMethodBeat.i(100794);
    this.zzq.clear();
    AppMethodBeat.o(100794);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(100795);
    boolean bool = this.zzq.containsKey(paramString);
    AppMethodBeat.o(100795);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100839);
    if (!(paramObject instanceof DataMap))
    {
      AppMethodBeat.o(100839);
      return false;
    }
    paramObject = (DataMap)paramObject;
    if (size() != paramObject.size())
    {
      AppMethodBeat.o(100839);
      return false;
    }
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = get((String)localObject2);
      localObject2 = paramObject.get((String)localObject2);
      if ((localObject1 instanceof Asset))
      {
        if (!(localObject2 instanceof Asset))
        {
          AppMethodBeat.o(100839);
          return false;
        }
        localObject1 = (Asset)localObject1;
        localObject2 = (Asset)localObject2;
        boolean bool;
        if ((localObject1 == null) || (localObject2 == null)) {
          if (localObject1 == localObject2) {
            bool = true;
          }
        }
        while (!bool)
        {
          AppMethodBeat.o(100839);
          return false;
          bool = false;
          continue;
          if (!TextUtils.isEmpty(((Asset)localObject1).getDigest())) {
            bool = ((Asset)localObject1).getDigest().equals(((Asset)localObject2).getDigest());
          } else {
            bool = Arrays.equals(((Asset)localObject1).getData(), ((Asset)localObject2).getData());
          }
        }
      }
      else if ((localObject1 instanceof String[]))
      {
        if (!(localObject2 instanceof String[]))
        {
          AppMethodBeat.o(100839);
          return false;
        }
        if (!Arrays.equals((String[])localObject1, (String[])localObject2))
        {
          AppMethodBeat.o(100839);
          return false;
        }
      }
      else if ((localObject1 instanceof long[]))
      {
        if (!(localObject2 instanceof long[]))
        {
          AppMethodBeat.o(100839);
          return false;
        }
        if (!Arrays.equals((long[])localObject1, (long[])localObject2))
        {
          AppMethodBeat.o(100839);
          return false;
        }
      }
      else if ((localObject1 instanceof float[]))
      {
        if (!(localObject2 instanceof float[]))
        {
          AppMethodBeat.o(100839);
          return false;
        }
        if (!Arrays.equals((float[])localObject1, (float[])localObject2))
        {
          AppMethodBeat.o(100839);
          return false;
        }
      }
      else if ((localObject1 instanceof byte[]))
      {
        if (!(localObject2 instanceof byte[]))
        {
          AppMethodBeat.o(100839);
          return false;
        }
        if (!Arrays.equals((byte[])localObject1, (byte[])localObject2))
        {
          AppMethodBeat.o(100839);
          return false;
        }
      }
      else if ((localObject1 == null) || (localObject2 == null))
      {
        if (localObject1 != localObject2)
        {
          AppMethodBeat.o(100839);
          return false;
        }
      }
      else if (!localObject1.equals(localObject2))
      {
        AppMethodBeat.o(100839);
        return false;
      }
    }
    AppMethodBeat.o(100839);
    return true;
  }
  
  public <T> T get(String paramString)
  {
    AppMethodBeat.i(100796);
    paramString = this.zzq.get(paramString);
    AppMethodBeat.o(100796);
    return paramString;
  }
  
  public Asset getAsset(String paramString)
  {
    AppMethodBeat.i(100830);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100830);
      return null;
    }
    try
    {
      Asset localAsset = (Asset)localObject;
      AppMethodBeat.o(100830);
      return localAsset;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Asset", localClassCastException);
      AppMethodBeat.o(100830);
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(100816);
    boolean bool = getBoolean(paramString, false);
    AppMethodBeat.o(100816);
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(100817);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100817);
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(100817);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      AppMethodBeat.o(100817);
    }
    return paramBoolean;
  }
  
  public byte getByte(String paramString)
  {
    AppMethodBeat.i(100818);
    byte b = getByte(paramString, (byte)0);
    AppMethodBeat.o(100818);
    return b;
  }
  
  public byte getByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(100819);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100819);
      return paramByte;
    }
    try
    {
      byte b = ((Byte)localObject).byteValue();
      AppMethodBeat.o(100819);
      return b;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      AppMethodBeat.o(100819);
    }
    return paramByte;
  }
  
  public byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(100835);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100835);
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      AppMethodBeat.o(100835);
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(100835);
    }
    return null;
  }
  
  public DataMap getDataMap(String paramString)
  {
    AppMethodBeat.i(100831);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100831);
      return null;
    }
    try
    {
      DataMap localDataMap = (DataMap)localObject;
      AppMethodBeat.o(100831);
      return localDataMap;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "DataMap", localClassCastException);
      AppMethodBeat.o(100831);
    }
    return null;
  }
  
  public ArrayList<DataMap> getDataMapArrayList(String paramString)
  {
    AppMethodBeat.i(100834);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100834);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(100834);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<DataMap>", localClassCastException);
      AppMethodBeat.o(100834);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(100826);
    double d = getDouble(paramString, 0.0D);
    AppMethodBeat.o(100826);
    return d;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(100827);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100827);
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      AppMethodBeat.o(100827);
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      AppMethodBeat.o(100827);
    }
    return paramDouble;
  }
  
  public float getFloat(String paramString)
  {
    AppMethodBeat.i(100824);
    float f = getFloat(paramString, 0.0F);
    AppMethodBeat.o(100824);
    return f;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100825);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100825);
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      AppMethodBeat.o(100825);
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      AppMethodBeat.o(100825);
    }
    return paramFloat;
  }
  
  public float[] getFloatArray(String paramString)
  {
    AppMethodBeat.i(100837);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100837);
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      AppMethodBeat.o(100837);
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "float[]", localClassCastException);
      AppMethodBeat.o(100837);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(100820);
    int i = getInt(paramString, 0);
    AppMethodBeat.o(100820);
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(100821);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100821);
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(100821);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Integer", localClassCastException);
      AppMethodBeat.o(100821);
    }
    return paramInt;
  }
  
  public ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    AppMethodBeat.i(100832);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100832);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(100832);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<Integer>", localClassCastException);
      AppMethodBeat.o(100832);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(100822);
    long l = getLong(paramString, 0L);
    AppMethodBeat.o(100822);
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(100823);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100823);
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(100823);
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long", localClassCastException);
      AppMethodBeat.o(100823);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    AppMethodBeat.i(100836);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100836);
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      AppMethodBeat.o(100836);
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long[]", localClassCastException);
      AppMethodBeat.o(100836);
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(100829);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100829);
      return null;
    }
    try
    {
      String str = (String)localObject;
      AppMethodBeat.o(100829);
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String", localClassCastException);
      AppMethodBeat.o(100829);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(100828);
    paramString1 = getString(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(100828);
      return paramString2;
    }
    AppMethodBeat.o(100828);
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(100838);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100838);
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      AppMethodBeat.o(100838);
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String[]", localClassCastException);
      AppMethodBeat.o(100838);
    }
    return null;
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    AppMethodBeat.i(100833);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(100833);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(100833);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<String>", localClassCastException);
      AppMethodBeat.o(100833);
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(100840);
    int i = this.zzq.hashCode();
    AppMethodBeat.o(100840);
    return i * 29;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(100793);
    boolean bool = this.zzq.isEmpty();
    AppMethodBeat.o(100793);
    return bool;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(100799);
    Set localSet = this.zzq.keySet();
    AppMethodBeat.o(100799);
    return localSet;
  }
  
  public void putAll(DataMap paramDataMap)
  {
    AppMethodBeat.i(100798);
    Iterator localIterator = paramDataMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzq.put(str, paramDataMap.get(str));
    }
    AppMethodBeat.o(100798);
  }
  
  public void putAsset(String paramString, Asset paramAsset)
  {
    AppMethodBeat.i(100807);
    this.zzq.put(paramString, paramAsset);
    AppMethodBeat.o(100807);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(100800);
    this.zzq.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(100800);
  }
  
  public void putByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(100801);
    this.zzq.put(paramString, Byte.valueOf(paramByte));
    AppMethodBeat.o(100801);
  }
  
  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(100812);
    this.zzq.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(100812);
  }
  
  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    AppMethodBeat.i(100808);
    this.zzq.put(paramString, paramDataMap);
    AppMethodBeat.o(100808);
  }
  
  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    AppMethodBeat.i(100809);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(100809);
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(100805);
    this.zzq.put(paramString, Double.valueOf(paramDouble));
    AppMethodBeat.o(100805);
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100804);
    this.zzq.put(paramString, Float.valueOf(paramFloat));
    AppMethodBeat.o(100804);
  }
  
  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(100814);
    this.zzq.put(paramString, paramArrayOfFloat);
    AppMethodBeat.o(100814);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(100802);
    this.zzq.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(100802);
  }
  
  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(100810);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(100810);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(100803);
    this.zzq.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(100803);
  }
  
  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(100813);
    this.zzq.put(paramString, paramArrayOfLong);
    AppMethodBeat.o(100813);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(100806);
    this.zzq.put(paramString1, paramString2);
    AppMethodBeat.o(100806);
  }
  
  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(100815);
    this.zzq.put(paramString, paramArrayOfString);
    AppMethodBeat.o(100815);
  }
  
  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(100811);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(100811);
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(100797);
    paramString = this.zzq.remove(paramString);
    AppMethodBeat.o(100797);
    return paramString;
  }
  
  public int size()
  {
    AppMethodBeat.i(100792);
    int i = this.zzq.size();
    AppMethodBeat.o(100792);
    return i;
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(100790);
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.zzq.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = this.zzq.get(str);
      if ((localObject1 instanceof String)) {
        localBundle.putString(str, (String)localObject1);
      } else if ((localObject1 instanceof Integer)) {
        localBundle.putInt(str, ((Integer)localObject1).intValue());
      } else if ((localObject1 instanceof Long)) {
        localBundle.putLong(str, ((Long)localObject1).longValue());
      } else if ((localObject1 instanceof Double)) {
        localBundle.putDouble(str, ((Double)localObject1).doubleValue());
      } else if ((localObject1 instanceof Float)) {
        localBundle.putFloat(str, ((Float)localObject1).floatValue());
      } else if ((localObject1 instanceof Boolean)) {
        localBundle.putBoolean(str, ((Boolean)localObject1).booleanValue());
      } else if ((localObject1 instanceof Byte)) {
        localBundle.putByte(str, ((Byte)localObject1).byteValue());
      } else if ((localObject1 instanceof byte[])) {
        localBundle.putByteArray(str, (byte[])localObject1);
      } else if ((localObject1 instanceof String[])) {
        localBundle.putStringArray(str, (String[])localObject1);
      } else if ((localObject1 instanceof long[])) {
        localBundle.putLongArray(str, (long[])localObject1);
      } else if ((localObject1 instanceof float[])) {
        localBundle.putFloatArray(str, (float[])localObject1);
      } else if ((localObject1 instanceof Asset)) {
        localBundle.putParcelable(str, (Asset)localObject1);
      } else if ((localObject1 instanceof DataMap)) {
        localBundle.putParcelable(str, ((DataMap)localObject1).toBundle());
      } else if ((localObject1 instanceof ArrayList)) {
        switch (zza((ArrayList)localObject1))
        {
        default: 
          break;
        case 0: 
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 1: 
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 3: 
          localBundle.putStringArrayList(str, (ArrayList)localObject1);
          break;
        case 2: 
          localBundle.putIntegerArrayList(str, (ArrayList)localObject1);
          break;
        case 4: 
          ArrayList localArrayList = new ArrayList();
          localObject1 = (ArrayList)localObject1;
          int j = ((ArrayList)localObject1).size();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = ((ArrayList)localObject1).get(i);
            i += 1;
            localArrayList.add(((DataMap)localObject2).toBundle());
          }
          localBundle.putParcelableArrayList(str, localArrayList);
        }
      }
    }
    AppMethodBeat.o(100790);
    return localBundle;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(100791);
    byte[] arrayOfByte = zzt.zzb(zze.zza(this).zzfw);
    AppMethodBeat.o(100791);
    return arrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(100841);
    String str = this.zzq.toString();
    AppMethodBeat.o(100841);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMap
 * JD-Core Version:    0.7.0.1
 */