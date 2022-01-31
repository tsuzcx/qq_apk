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
    AppMethodBeat.i(70803);
    this.zzq = new HashMap();
    AppMethodBeat.o(70803);
  }
  
  public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> paramArrayList)
  {
    AppMethodBeat.i(70806);
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
    AppMethodBeat.o(70806);
    return localArrayList;
  }
  
  public static DataMap fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(70804);
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
    AppMethodBeat.o(70804);
    return localDataMap;
  }
  
  public static DataMap fromByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70805);
    try
    {
      paramArrayOfByte = zze.zza(new zzf(zzg.zza(paramArrayOfByte), new ArrayList()));
      AppMethodBeat.o(70805);
      return paramArrayOfByte;
    }
    catch (zzs paramArrayOfByte)
    {
      paramArrayOfByte = new IllegalArgumentException("Unable to convert data", paramArrayOfByte);
      AppMethodBeat.o(70805);
      throw paramArrayOfByte;
    }
  }
  
  private static int zza(ArrayList<?> paramArrayList)
  {
    int i = 0;
    AppMethodBeat.i(70861);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(70861);
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
          AppMethodBeat.o(70861);
          return 2;
        }
        if ((localObject instanceof String))
        {
          AppMethodBeat.o(70861);
          return 3;
        }
        if ((localObject instanceof DataMap))
        {
          AppMethodBeat.o(70861);
          return 4;
        }
        i = j;
        if ((localObject instanceof Bundle))
        {
          AppMethodBeat.o(70861);
          return 5;
        }
      }
    }
    AppMethodBeat.o(70861);
    return 1;
  }
  
  private static void zza(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(70859);
    zza(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
    AppMethodBeat.o(70859);
  }
  
  private static void zza(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    AppMethodBeat.i(70860);
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
    AppMethodBeat.o(70860);
  }
  
  public void clear()
  {
    AppMethodBeat.i(70811);
    this.zzq.clear();
    AppMethodBeat.o(70811);
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(70812);
    boolean bool = this.zzq.containsKey(paramString);
    AppMethodBeat.o(70812);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70856);
    if (!(paramObject instanceof DataMap))
    {
      AppMethodBeat.o(70856);
      return false;
    }
    paramObject = (DataMap)paramObject;
    if (size() != paramObject.size())
    {
      AppMethodBeat.o(70856);
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
          AppMethodBeat.o(70856);
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
          AppMethodBeat.o(70856);
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
          AppMethodBeat.o(70856);
          return false;
        }
        if (!Arrays.equals((String[])localObject1, (String[])localObject2))
        {
          AppMethodBeat.o(70856);
          return false;
        }
      }
      else if ((localObject1 instanceof long[]))
      {
        if (!(localObject2 instanceof long[]))
        {
          AppMethodBeat.o(70856);
          return false;
        }
        if (!Arrays.equals((long[])localObject1, (long[])localObject2))
        {
          AppMethodBeat.o(70856);
          return false;
        }
      }
      else if ((localObject1 instanceof float[]))
      {
        if (!(localObject2 instanceof float[]))
        {
          AppMethodBeat.o(70856);
          return false;
        }
        if (!Arrays.equals((float[])localObject1, (float[])localObject2))
        {
          AppMethodBeat.o(70856);
          return false;
        }
      }
      else if ((localObject1 instanceof byte[]))
      {
        if (!(localObject2 instanceof byte[]))
        {
          AppMethodBeat.o(70856);
          return false;
        }
        if (!Arrays.equals((byte[])localObject1, (byte[])localObject2))
        {
          AppMethodBeat.o(70856);
          return false;
        }
      }
      else if ((localObject1 == null) || (localObject2 == null))
      {
        if (localObject1 != localObject2)
        {
          AppMethodBeat.o(70856);
          return false;
        }
      }
      else if (!localObject1.equals(localObject2))
      {
        AppMethodBeat.o(70856);
        return false;
      }
    }
    AppMethodBeat.o(70856);
    return true;
  }
  
  public <T> T get(String paramString)
  {
    AppMethodBeat.i(70813);
    paramString = this.zzq.get(paramString);
    AppMethodBeat.o(70813);
    return paramString;
  }
  
  public Asset getAsset(String paramString)
  {
    AppMethodBeat.i(70847);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70847);
      return null;
    }
    try
    {
      Asset localAsset = (Asset)localObject;
      AppMethodBeat.o(70847);
      return localAsset;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Asset", localClassCastException);
      AppMethodBeat.o(70847);
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(70833);
    boolean bool = getBoolean(paramString, false);
    AppMethodBeat.o(70833);
    return bool;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70834);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70834);
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(70834);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      AppMethodBeat.o(70834);
    }
    return paramBoolean;
  }
  
  public byte getByte(String paramString)
  {
    AppMethodBeat.i(70835);
    byte b = getByte(paramString, (byte)0);
    AppMethodBeat.o(70835);
    return b;
  }
  
  public byte getByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(70836);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70836);
      return paramByte;
    }
    try
    {
      byte b = ((Byte)localObject).byteValue();
      AppMethodBeat.o(70836);
      return b;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      AppMethodBeat.o(70836);
    }
    return paramByte;
  }
  
  public byte[] getByteArray(String paramString)
  {
    AppMethodBeat.i(70852);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70852);
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      AppMethodBeat.o(70852);
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "byte[]", localClassCastException);
      AppMethodBeat.o(70852);
    }
    return null;
  }
  
  public DataMap getDataMap(String paramString)
  {
    AppMethodBeat.i(70848);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70848);
      return null;
    }
    try
    {
      DataMap localDataMap = (DataMap)localObject;
      AppMethodBeat.o(70848);
      return localDataMap;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "DataMap", localClassCastException);
      AppMethodBeat.o(70848);
    }
    return null;
  }
  
  public ArrayList<DataMap> getDataMapArrayList(String paramString)
  {
    AppMethodBeat.i(70851);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70851);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(70851);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<DataMap>", localClassCastException);
      AppMethodBeat.o(70851);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(70843);
    double d = getDouble(paramString, 0.0D);
    AppMethodBeat.o(70843);
    return d;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(70844);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70844);
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      AppMethodBeat.o(70844);
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      AppMethodBeat.o(70844);
    }
    return paramDouble;
  }
  
  public float getFloat(String paramString)
  {
    AppMethodBeat.i(70841);
    float f = getFloat(paramString, 0.0F);
    AppMethodBeat.o(70841);
    return f;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(70842);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70842);
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      AppMethodBeat.o(70842);
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      AppMethodBeat.o(70842);
    }
    return paramFloat;
  }
  
  public float[] getFloatArray(String paramString)
  {
    AppMethodBeat.i(70854);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70854);
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      AppMethodBeat.o(70854);
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "float[]", localClassCastException);
      AppMethodBeat.o(70854);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    AppMethodBeat.i(70837);
    int i = getInt(paramString, 0);
    AppMethodBeat.o(70837);
    return i;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(70838);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70838);
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(70838);
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Integer", localClassCastException);
      AppMethodBeat.o(70838);
    }
    return paramInt;
  }
  
  public ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    AppMethodBeat.i(70849);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70849);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(70849);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<Integer>", localClassCastException);
      AppMethodBeat.o(70849);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    AppMethodBeat.i(70839);
    long l = getLong(paramString, 0L);
    AppMethodBeat.o(70839);
    return l;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(70840);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70840);
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(70840);
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long", localClassCastException);
      AppMethodBeat.o(70840);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    AppMethodBeat.i(70853);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70853);
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      AppMethodBeat.o(70853);
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long[]", localClassCastException);
      AppMethodBeat.o(70853);
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(70846);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70846);
      return null;
    }
    try
    {
      String str = (String)localObject;
      AppMethodBeat.o(70846);
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String", localClassCastException);
      AppMethodBeat.o(70846);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70845);
    paramString1 = getString(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(70845);
      return paramString2;
    }
    AppMethodBeat.o(70845);
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    AppMethodBeat.i(70855);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70855);
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      AppMethodBeat.o(70855);
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String[]", localClassCastException);
      AppMethodBeat.o(70855);
    }
    return null;
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    AppMethodBeat.i(70850);
    Object localObject = this.zzq.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(70850);
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      AppMethodBeat.o(70850);
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<String>", localClassCastException);
      AppMethodBeat.o(70850);
    }
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(70857);
    int i = this.zzq.hashCode();
    AppMethodBeat.o(70857);
    return i * 29;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(70810);
    boolean bool = this.zzq.isEmpty();
    AppMethodBeat.o(70810);
    return bool;
  }
  
  public Set<String> keySet()
  {
    AppMethodBeat.i(70816);
    Set localSet = this.zzq.keySet();
    AppMethodBeat.o(70816);
    return localSet;
  }
  
  public void putAll(DataMap paramDataMap)
  {
    AppMethodBeat.i(70815);
    Iterator localIterator = paramDataMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzq.put(str, paramDataMap.get(str));
    }
    AppMethodBeat.o(70815);
  }
  
  public void putAsset(String paramString, Asset paramAsset)
  {
    AppMethodBeat.i(70824);
    this.zzq.put(paramString, paramAsset);
    AppMethodBeat.o(70824);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70817);
    this.zzq.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(70817);
  }
  
  public void putByte(String paramString, byte paramByte)
  {
    AppMethodBeat.i(70818);
    this.zzq.put(paramString, Byte.valueOf(paramByte));
    AppMethodBeat.o(70818);
  }
  
  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70829);
    this.zzq.put(paramString, paramArrayOfByte);
    AppMethodBeat.o(70829);
  }
  
  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    AppMethodBeat.i(70825);
    this.zzq.put(paramString, paramDataMap);
    AppMethodBeat.o(70825);
  }
  
  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    AppMethodBeat.i(70826);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(70826);
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(70822);
    this.zzq.put(paramString, Double.valueOf(paramDouble));
    AppMethodBeat.o(70822);
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(70821);
    this.zzq.put(paramString, Float.valueOf(paramFloat));
    AppMethodBeat.o(70821);
  }
  
  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(70831);
    this.zzq.put(paramString, paramArrayOfFloat);
    AppMethodBeat.o(70831);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(70819);
    this.zzq.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(70819);
  }
  
  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(70827);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(70827);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(70820);
    this.zzq.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(70820);
  }
  
  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(70830);
    this.zzq.put(paramString, paramArrayOfLong);
    AppMethodBeat.o(70830);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70823);
    this.zzq.put(paramString1, paramString2);
    AppMethodBeat.o(70823);
  }
  
  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(70832);
    this.zzq.put(paramString, paramArrayOfString);
    AppMethodBeat.o(70832);
  }
  
  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(70828);
    this.zzq.put(paramString, paramArrayList);
    AppMethodBeat.o(70828);
  }
  
  public Object remove(String paramString)
  {
    AppMethodBeat.i(70814);
    paramString = this.zzq.remove(paramString);
    AppMethodBeat.o(70814);
    return paramString;
  }
  
  public int size()
  {
    AppMethodBeat.i(70809);
    int i = this.zzq.size();
    AppMethodBeat.o(70809);
    return i;
  }
  
  public Bundle toBundle()
  {
    AppMethodBeat.i(70807);
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
    AppMethodBeat.o(70807);
    return localBundle;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(70808);
    byte[] arrayOfByte = zzt.zzb(zze.zza(this).zzfw);
    AppMethodBeat.o(70808);
    return arrayOfByte;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70858);
    String str = this.zzq.toString();
    AppMethodBeat.o(70858);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMap
 * JD-Core Version:    0.7.0.1
 */