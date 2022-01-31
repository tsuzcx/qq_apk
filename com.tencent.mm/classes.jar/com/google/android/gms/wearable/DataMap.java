package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.zzblc;
import com.google.android.gms.internal.zzblc.zza;
import com.google.android.gms.internal.zzbld;
import com.google.android.gms.internal.zzbxs;
import com.google.android.gms.internal.zzbxt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap
{
  public static final String TAG = "DataMap";
  private final HashMap<String, Object> zzru = new HashMap();
  
  public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(fromBundle((Bundle)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  public static DataMap fromBundle(Bundle paramBundle)
  {
    paramBundle.setClassLoader(Asset.class.getClassLoader());
    DataMap localDataMap = new DataMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zza(localDataMap, str, paramBundle.get(str));
    }
    return localDataMap;
  }
  
  public static DataMap fromByteArray(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = zzblc.zza(new zzblc.zza(zzbld.zzS(paramArrayOfByte), new ArrayList()));
      return paramArrayOfByte;
    }
    catch (zzbxs paramArrayOfByte)
    {
      throw new IllegalArgumentException("Unable to convert data", paramArrayOfByte);
    }
  }
  
  private static void zza(DataMap paramDataMap, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      paramDataMap.putString(paramString, (String)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof Integer))
      {
        paramDataMap.putInt(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramDataMap.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramDataMap.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        paramDataMap.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        paramDataMap.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof Byte))
      {
        paramDataMap.putByte(paramString, ((Byte)paramObject).byteValue());
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramDataMap.putByteArray(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof String[]))
      {
        paramDataMap.putStringArray(paramString, (String[])paramObject);
        return;
      }
      if ((paramObject instanceof long[]))
      {
        paramDataMap.putLongArray(paramString, (long[])paramObject);
        return;
      }
      if ((paramObject instanceof float[]))
      {
        paramDataMap.putFloatArray(paramString, (float[])paramObject);
        return;
      }
      if ((paramObject instanceof Asset))
      {
        paramDataMap.putAsset(paramString, (Asset)paramObject);
        return;
      }
      if ((paramObject instanceof Bundle))
      {
        paramDataMap.putDataMap(paramString, fromBundle((Bundle)paramObject));
        return;
      }
    } while (!(paramObject instanceof ArrayList));
    switch (zzj((ArrayList)paramObject))
    {
    case 4: 
    default: 
      return;
    case 0: 
      paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 1: 
      paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 3: 
      paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 2: 
      paramDataMap.putIntegerArrayList(paramString, (ArrayList)paramObject);
      return;
    }
    paramDataMap.putDataMapArrayList(paramString, arrayListFromBundleArrayList((ArrayList)paramObject));
  }
  
  private void zza(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    zza(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
  }
  
  private void zza(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
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
  }
  
  private static boolean zza(Asset paramAsset1, Asset paramAsset2)
  {
    if ((paramAsset1 == null) || (paramAsset2 == null)) {
      return paramAsset1 == paramAsset2;
    }
    if (!TextUtils.isEmpty(paramAsset1.getDigest())) {
      return paramAsset1.getDigest().equals(paramAsset2.getDigest());
    }
    return Arrays.equals(paramAsset1.getData(), paramAsset2.getData());
  }
  
  private static boolean zza(DataMap paramDataMap1, DataMap paramDataMap2)
  {
    if (paramDataMap1.size() != paramDataMap2.size()) {
      return false;
    }
    Iterator localIterator = paramDataMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = paramDataMap1.get((String)localObject2);
      localObject2 = paramDataMap2.get((String)localObject2);
      if ((localObject1 instanceof Asset))
      {
        if (!(localObject2 instanceof Asset)) {
          return false;
        }
        if (!zza((Asset)localObject1, (Asset)localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof String[]))
      {
        if (!(localObject2 instanceof String[])) {
          return false;
        }
        if (!Arrays.equals((String[])localObject1, (String[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof long[]))
      {
        if (!(localObject2 instanceof long[])) {
          return false;
        }
        if (!Arrays.equals((long[])localObject1, (long[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof float[]))
      {
        if (!(localObject2 instanceof float[])) {
          return false;
        }
        if (!Arrays.equals((float[])localObject1, (float[])localObject2)) {
          return false;
        }
      }
      else if ((localObject1 instanceof byte[]))
      {
        if (!(localObject2 instanceof byte[])) {
          return false;
        }
        if (!Arrays.equals((byte[])localObject1, (byte[])localObject2)) {
          return false;
        }
      }
      else
      {
        if ((localObject1 == null) || (localObject2 == null)) {
          return localObject1 == localObject2;
        }
        if (!localObject1.equals(localObject2)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private static void zzb(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      paramBundle.putString(paramString, (String)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof Integer))
      {
        paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof Byte))
      {
        paramBundle.putByte(paramString, ((Byte)paramObject).byteValue());
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramBundle.putByteArray(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof String[]))
      {
        paramBundle.putStringArray(paramString, (String[])paramObject);
        return;
      }
      if ((paramObject instanceof long[]))
      {
        paramBundle.putLongArray(paramString, (long[])paramObject);
        return;
      }
      if ((paramObject instanceof float[]))
      {
        paramBundle.putFloatArray(paramString, (float[])paramObject);
        return;
      }
      if ((paramObject instanceof Asset))
      {
        paramBundle.putParcelable(paramString, (Asset)paramObject);
        return;
      }
      if ((paramObject instanceof DataMap))
      {
        paramBundle.putParcelable(paramString, ((DataMap)paramObject).toBundle());
        return;
      }
    } while (!(paramObject instanceof ArrayList));
    switch (zzj((ArrayList)paramObject))
    {
    default: 
      return;
    case 0: 
      paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 1: 
      paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 3: 
      paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
      return;
    case 2: 
      paramBundle.putIntegerArrayList(paramString, (ArrayList)paramObject);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramObject = ((ArrayList)paramObject).iterator();
    while (paramObject.hasNext()) {
      localArrayList.add(((DataMap)paramObject.next()).toBundle());
    }
    paramBundle.putParcelableArrayList(paramString, localArrayList);
  }
  
  private static int zzj(ArrayList<?> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return 0;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = paramArrayList.next();
      if (localObject != null)
      {
        if ((localObject instanceof Integer)) {
          return 2;
        }
        if ((localObject instanceof String)) {
          return 3;
        }
        if ((localObject instanceof DataMap)) {
          return 4;
        }
        if ((localObject instanceof Bundle)) {
          return 5;
        }
      }
    }
    return 1;
  }
  
  public void clear()
  {
    this.zzru.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.zzru.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DataMap)) {
      return false;
    }
    return zza(this, (DataMap)paramObject);
  }
  
  public <T> T get(String paramString)
  {
    return this.zzru.get(paramString);
  }
  
  public Asset getAsset(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      Asset localAsset = (Asset)localObject;
      return localAsset;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Asset", localClassCastException);
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
    }
    return paramBoolean;
  }
  
  public byte getByte(String paramString)
  {
    return getByte(paramString, (byte)0);
  }
  
  public byte getByte(String paramString, byte paramByte)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramByte;
    }
    try
    {
      byte b = ((Byte)localObject).byteValue();
      return b;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
    }
    return paramByte;
  }
  
  public byte[] getByteArray(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = (byte[])localObject;
      return arrayOfByte;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "byte[]", localClassCastException);
    }
    return null;
  }
  
  public DataMap getDataMap(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      DataMap localDataMap = (DataMap)localObject;
      return localDataMap;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "DataMap", localClassCastException);
    }
    return null;
  }
  
  public ArrayList<DataMap> getDataMapArrayList(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<DataMap>", localClassCastException);
    }
    return null;
  }
  
  public double getDouble(String paramString)
  {
    return getDouble(paramString, 0.0D);
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramDouble;
    }
    try
    {
      double d = ((Double)localObject).doubleValue();
      return d;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
    }
    return paramDouble;
  }
  
  public float getFloat(String paramString)
  {
    return getFloat(paramString, 0.0F);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramFloat;
    }
    try
    {
      float f = ((Float)localObject).floatValue();
      return f;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
    }
    return paramFloat;
  }
  
  public float[] getFloatArray(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      float[] arrayOfFloat = (float[])localObject;
      return arrayOfFloat;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "float[]", localClassCastException);
    }
    return null;
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramInt;
    }
    try
    {
      int i = ((Integer)localObject).intValue();
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "Integer", localClassCastException);
    }
    return paramInt;
  }
  
  public ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<Integer>", localClassCastException);
    }
    return null;
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return paramLong;
    }
    try
    {
      long l = ((Long)localObject).longValue();
      return l;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long", localClassCastException);
    }
    return paramLong;
  }
  
  public long[] getLongArray(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      long[] arrayOfLong = (long[])localObject;
      return arrayOfLong;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "long[]", localClassCastException);
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      String str = (String)localObject;
      return str;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String", localClassCastException);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getString(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public String[] getStringArray(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      String[] arrayOfString = (String[])localObject;
      return arrayOfString;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "String[]", localClassCastException);
    }
    return null;
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    Object localObject = this.zzru.get(paramString);
    if (localObject == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = (ArrayList)localObject;
      return localArrayList;
    }
    catch (ClassCastException localClassCastException)
    {
      zza(paramString, localObject, "ArrayList<String>", localClassCastException);
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.zzru.hashCode() * 29;
  }
  
  public boolean isEmpty()
  {
    return this.zzru.isEmpty();
  }
  
  public Set<String> keySet()
  {
    return this.zzru.keySet();
  }
  
  public void putAll(DataMap paramDataMap)
  {
    Iterator localIterator = paramDataMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzru.put(str, paramDataMap.get(str));
    }
  }
  
  public void putAsset(String paramString, Asset paramAsset)
  {
    this.zzru.put(paramString, paramAsset);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.zzru.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void putByte(String paramString, byte paramByte)
  {
    this.zzru.put(paramString, Byte.valueOf(paramByte));
  }
  
  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.zzru.put(paramString, paramArrayOfByte);
  }
  
  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    this.zzru.put(paramString, paramDataMap);
  }
  
  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    this.zzru.put(paramString, paramArrayList);
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    this.zzru.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    this.zzru.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    this.zzru.put(paramString, paramArrayOfFloat);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.zzru.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.zzru.put(paramString, paramArrayList);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    this.zzru.put(paramString, Long.valueOf(paramLong));
  }
  
  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    this.zzru.put(paramString, paramArrayOfLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.zzru.put(paramString1, paramString2);
  }
  
  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    this.zzru.put(paramString, paramArrayOfString);
  }
  
  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    this.zzru.put(paramString, paramArrayList);
  }
  
  public Object remove(String paramString)
  {
    return this.zzru.remove(paramString);
  }
  
  public int size()
  {
    return this.zzru.size();
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.zzru.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zzb(localBundle, str, this.zzru.get(str));
    }
    return localBundle;
  }
  
  public byte[] toByteArray()
  {
    return zzbxt.zzf(zzblc.zza(this).zzbVw);
  }
  
  public String toString()
  {
    return this.zzru.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMap
 * JD-Core Version:    0.7.0.1
 */