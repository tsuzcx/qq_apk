package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzblc
{
  private static int zza(String paramString, zzbld.zza.zza[] paramArrayOfzza)
  {
    int m = paramArrayOfzza.length;
    int j = 0;
    int i = 14;
    if (j < m)
    {
      zzbld.zza.zza localzza = paramArrayOfzza[j];
      int k;
      if (i == 14) {
        if ((localzza.type == 9) || (localzza.type == 2) || (localzza.type == 6)) {
          k = localzza.type;
        }
      }
      do
      {
        do
        {
          j += 1;
          i = k;
          break;
          k = i;
        } while (localzza.type == 14);
        i = localzza.type;
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 48 + "Unexpected TypedValue type: " + i + " for key " + paramString);
        k = i;
      } while (localzza.type == i);
      j = localzza.type;
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 126 + "The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + i + " and " + j);
    }
    return i;
  }
  
  static int zza(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return paramList.size() - 1;
  }
  
  public static zzblc.zza zza(DataMap paramDataMap)
  {
    zzbld localzzbld = new zzbld();
    ArrayList localArrayList = new ArrayList();
    localzzbld.zzbVy = zza(paramDataMap, localArrayList);
    return new zzblc.zza(localzzbld, localArrayList);
  }
  
  private static zzbld.zza.zza zza(List<Asset> paramList, Object paramObject)
  {
    zzbld.zza.zza localzza1 = new zzbld.zza.zza();
    if (paramObject == null)
    {
      localzza1.type = 14;
      return localzza1;
    }
    localzza1.zzbVC = new zzbld.zza.zza.zza();
    if ((paramObject instanceof String))
    {
      localzza1.type = 2;
      localzza1.zzbVC.zzbVE = ((String)paramObject);
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    for (;;)
    {
      return localzza1;
      if ((paramObject instanceof Integer))
      {
        localzza1.type = 6;
        localzza1.zzbVC.zzbVI = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localzza1.type = 5;
        localzza1.zzbVC.zzbVH = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localzza1.type = 3;
        localzza1.zzbVC.zzbVF = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localzza1.type = 4;
        localzza1.zzbVC.zzbVG = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localzza1.type = 8;
        localzza1.zzbVC.zzbVK = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localzza1.type = 7;
        localzza1.zzbVC.zzbVJ = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localzza1.type = 1;
        localzza1.zzbVC.zzbVD = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localzza1.type = 11;
        localzza1.zzbVC.zzbVN = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localzza1.type = 12;
        localzza1.zzbVC.zzbVO = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localzza1.type = 15;
        localzza1.zzbVC.zzbVP = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localzza1.type = 13;
        localzza1.zzbVC.zzbVQ = zza(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        localzza1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = new TreeSet(paramObject.keySet());
        localObject1 = new zzbld.zza[((TreeSet)localObject2).size()];
        localObject2 = ((TreeSet)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new zzbld.zza();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].zzbVA = zza(paramList, paramObject.get((String)localObject3));
          i += 1;
        }
        localzza1.zzbVC.zzbVL = ((zzbld.zza[])localObject1);
      }
    }
    int j;
    label575:
    zzbld.zza.zza localzza2;
    if ((paramObject instanceof ArrayList))
    {
      localzza1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new zzbld.zza.zza[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      i = 0;
      j = 14;
      if (i < k)
      {
        localObject1 = ((ArrayList)localObject2).get(i);
        localzza2 = zza(paramList, localObject1);
        if ((localzza2.type != 14) && (localzza2.type != 2) && (localzza2.type != 6) && (localzza2.type != 9))
        {
          paramList = String.valueOf(localObject1.getClass());
          throw new IllegalArgumentException(String.valueOf(paramList).length() + 130 + "The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + paramList);
        }
        if ((j == 14) && (localzza2.type != 14))
        {
          j = localzza2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[i] = localzza2;
      i += 1;
      break label575;
      if (localzza2.type != j)
      {
        paramList = String.valueOf(paramObject.getClass());
        paramObject = String.valueOf(localObject1.getClass());
        throw new IllegalArgumentException(String.valueOf(paramList).length() + 80 + String.valueOf(paramObject).length() + "ArrayList elements must all be of the sameclass, but this one contains a " + paramList + " and a " + paramObject);
        localzza1.zzbVC.zzbVM = ((zzbld.zza.zza[])localObject3);
        break;
        paramList = String.valueOf(paramObject.getClass().getSimpleName());
        if (paramList.length() != 0) {}
        for (paramList = "newFieldValueFromValue: unexpected value ".concat(paramList);; paramList = new String("newFieldValueFromValue: unexpected value ")) {
          throw new RuntimeException(paramList);
        }
      }
    }
  }
  
  public static DataMap zza(zzblc.zza paramzza)
  {
    DataMap localDataMap = new DataMap();
    zzbld.zza[] arrayOfzza = paramzza.zzbVw.zzbVy;
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      zzbld.zza localzza = arrayOfzza[i];
      zza(paramzza.zzbVx, localDataMap, localzza.name, localzza.zzbVA);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList zza(List<Asset> paramList, zzbld.zza.zza.zza paramzza, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramzza.zzbVM.length);
    paramzza = paramzza.zzbVM;
    int k = paramzza.length;
    int i = 0;
    if (i < k)
    {
      zzbld.zza[] arrayOfzza = paramzza[i];
      if (arrayOfzza.type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfzza = arrayOfzza.zzbVC.zzbVL;
          int m = arrayOfzza.length;
          int j = 0;
          while (j < m)
          {
            zzbld.zza localzza = arrayOfzza[j];
            zza(paramList, localDataMap, localzza.name, localzza.zzbVA);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfzza.zzbVC.zzbVE);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfzza.zzbVC.zzbVI));
        }
      }
      label191:
      throw new IllegalArgumentException(39 + "Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzbld.zza.zza paramzza)
  {
    int i = paramzza.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = paramzza.zzbVC;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVD);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVN);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVO);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVP);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVE);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVF);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVG);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVH);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVI);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((zzbld.zza.zza.zza)localObject1).zzbVJ);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVK);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
      {
        paramList = String.valueOf(paramString);
        if (paramList.length() != 0) {}
        for (paramList = "populateBundle: unexpected type for: ".concat(paramList);; paramList = new String("populateBundle: unexpected type for: ")) {
          throw new RuntimeException(paramList);
        }
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((zzbld.zza.zza.zza)localObject1).zzbVQ));
      return;
    }
    if (i == 9)
    {
      paramzza = new DataMap();
      localObject1 = ((zzbld.zza.zza.zza)localObject1).zzbVL;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        zza(paramList, paramzza, localObject2.name, localObject2.zzbVA);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzza);
      return;
    }
    if (i == 10)
    {
      i = zza(paramString, ((zzbld.zza.zza.zza)localObject1).zzbVM);
      paramList = zza(paramList, (zzbld.zza.zza.zza)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException(39 + "Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException(43 + "populateBundle: unexpected type " + i);
  }
  
  private static zzbld.zza[] zza(DataMap paramDataMap, List<Asset> paramList)
  {
    Object localObject1 = new TreeSet(paramDataMap.keySet());
    zzbld.zza[] arrayOfzza = new zzbld.zza[((TreeSet)localObject1).size()];
    localObject1 = ((TreeSet)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfzza[i] = new zzbld.zza();
      arrayOfzza[i].name = str;
      arrayOfzza[i].zzbVA = zza(paramList, localObject2);
      i += 1;
    }
    return arrayOfzza;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzblc
 * JD-Core Version:    0.7.0.1
 */