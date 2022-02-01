package com.google.android.gms.internal.wearable;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zze
{
  public static zzf zza(DataMap paramDataMap)
  {
    AppMethodBeat.i(100657);
    zzg localzzg = new zzg();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new TreeSet(paramDataMap.keySet());
    zzh[] arrayOfzzh = new zzh[((TreeSet)localObject1).size()];
    localObject1 = ((TreeSet)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfzzh[i] = new zzh();
      arrayOfzzh[i].name = str;
      arrayOfzzh[i].zzga = zza(localArrayList, localObject2);
      i += 1;
    }
    localzzg.zzfy = arrayOfzzh;
    paramDataMap = new zzf(localzzg, localArrayList);
    AppMethodBeat.o(100657);
    return paramDataMap;
  }
  
  private static zzi zza(List<Asset> paramList, Object paramObject)
  {
    AppMethodBeat.i(100659);
    zzi localzzi1 = new zzi();
    if (paramObject == null)
    {
      localzzi1.type = 14;
      AppMethodBeat.o(100659);
      return localzzi1;
    }
    localzzi1.zzgc = new zzj();
    if ((paramObject instanceof String))
    {
      localzzi1.type = 2;
      localzzi1.zzgc.zzge = ((String)paramObject);
    }
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    for (;;)
    {
      AppMethodBeat.o(100659);
      return localzzi1;
      if ((paramObject instanceof Integer))
      {
        localzzi1.type = 6;
        localzzi1.zzgc.zzgi = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localzzi1.type = 5;
        localzzi1.zzgc.zzgh = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localzzi1.type = 3;
        localzzi1.zzgc.zzgf = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localzzi1.type = 4;
        localzzi1.zzgc.zzgg = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localzzi1.type = 8;
        localzzi1.zzgc.zzgk = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localzzi1.type = 7;
        localzzi1.zzgc.zzgj = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localzzi1.type = 1;
        localzzi1.zzgc.zzgd = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localzzi1.type = 11;
        localzzi1.zzgc.zzgn = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localzzi1.type = 12;
        localzzi1.zzgc.zzgo = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localzzi1.type = 15;
        localzzi1.zzgc.zzgp = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localzzi1.type = 13;
        localObject1 = localzzi1.zzgc;
        paramList.add((Asset)paramObject);
        ((zzj)localObject1).zzgq = (paramList.size() - 1);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        localzzi1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = new TreeSet(paramObject.keySet());
        localObject1 = new zzh[((TreeSet)localObject2).size()];
        localObject2 = ((TreeSet)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new zzh();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].zzga = zza(paramList, paramObject.get((String)localObject3));
          i += 1;
        }
        localzzi1.zzgc.zzgl = ((zzh[])localObject1);
      }
    }
    int j;
    label605:
    zzi localzzi2;
    if ((paramObject instanceof ArrayList))
    {
      localzzi1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new zzi[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      i = 0;
      j = 14;
      if (i < k)
      {
        localObject1 = ((ArrayList)localObject2).get(i);
        localzzi2 = zza(paramList, localObject1);
        if ((localzzi2.type != 14) && (localzzi2.type != 2) && (localzzi2.type != 6) && (localzzi2.type != 9))
        {
          paramList = String.valueOf(localObject1.getClass());
          paramList = new IllegalArgumentException(String.valueOf(paramList).length() + 130 + "The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + paramList);
          AppMethodBeat.o(100659);
          throw paramList;
        }
        if ((j == 14) && (localzzi2.type != 14))
        {
          j = localzzi2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[i] = localzzi2;
      i += 1;
      break label605;
      if (localzzi2.type != j)
      {
        paramList = String.valueOf(paramObject.getClass());
        paramObject = String.valueOf(localObject1.getClass());
        paramList = new IllegalArgumentException(String.valueOf(paramList).length() + 80 + String.valueOf(paramObject).length() + "ArrayList elements must all be of the sameclass, but this one contains a " + paramList + " and a " + paramObject);
        AppMethodBeat.o(100659);
        throw paramList;
        localzzi1.zzgc.zzgm = ((zzi[])localObject3);
        break;
        paramList = String.valueOf(paramObject.getClass().getSimpleName());
        if (paramList.length() != 0) {}
        for (paramList = "newFieldValueFromValue: unexpected value ".concat(paramList);; paramList = new String("newFieldValueFromValue: unexpected value "))
        {
          paramList = new RuntimeException(paramList);
          AppMethodBeat.o(100659);
          throw paramList;
        }
      }
    }
  }
  
  public static DataMap zza(zzf paramzzf)
  {
    AppMethodBeat.i(100658);
    DataMap localDataMap = new DataMap();
    zzh[] arrayOfzzh = paramzzf.zzfw.zzfy;
    int j = arrayOfzzh.length;
    int i = 0;
    while (i < j)
    {
      zzh localzzh = arrayOfzzh[i];
      zza(paramzzf.zzfx, localDataMap, localzzh.name, localzzh.zzga);
      i += 1;
    }
    AppMethodBeat.o(100658);
    return localDataMap;
  }
  
  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzi paramzzi)
  {
    AppMethodBeat.i(100660);
    int i = paramzzi.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      AppMethodBeat.o(100660);
      return;
    }
    Object localObject = paramzzi.zzgc;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((zzj)localObject).zzgd);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((zzj)localObject).zzgn);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((zzj)localObject).zzgo);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((zzj)localObject).zzgp);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((zzj)localObject).zzge);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((zzj)localObject).zzgf);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((zzj)localObject).zzgg);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((zzj)localObject).zzgh);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((zzj)localObject).zzgi);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((zzj)localObject).zzgj);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((zzj)localObject).zzgk);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
      {
        paramList = String.valueOf(paramString);
        if (paramList.length() != 0) {}
        for (paramList = "populateBundle: unexpected type for: ".concat(paramList);; paramList = new String("populateBundle: unexpected type for: "))
        {
          paramList = new RuntimeException(paramList);
          AppMethodBeat.o(100660);
          throw paramList;
        }
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((zzj)localObject).zzgq));
      AppMethodBeat.o(100660);
      return;
    }
    int j;
    DataMap localDataMap;
    if (i == 9)
    {
      paramzzi = new DataMap();
      localObject = ((zzj)localObject).zzgl;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localDataMap = localObject[i];
        zza(paramList, paramzzi, localDataMap.name, localDataMap.zzga);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzzi);
      AppMethodBeat.o(100660);
      return;
    }
    if (i == 10)
    {
      paramzzi = ((zzj)localObject).zzgm;
      i = 14;
      int m = paramzzi.length;
      j = 0;
      int k;
      if (j < m)
      {
        localDataMap = paramzzi[j];
        if (i == 14) {
          if ((localDataMap.type == 9) || (localDataMap.type == 2) || (localDataMap.type == 6)) {
            k = localDataMap.type;
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
          } while (localDataMap.type == 14);
          i = localDataMap.type;
          paramList = new IllegalArgumentException(String.valueOf(paramString).length() + 48 + "Unexpected TypedValue type: " + i + " for key " + paramString);
          AppMethodBeat.o(100660);
          throw paramList;
          k = i;
        } while (localDataMap.type == i);
        j = localDataMap.type;
        paramList = new IllegalArgumentException(String.valueOf(paramString).length() + 126 + "The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + i + " and " + j);
        AppMethodBeat.o(100660);
        throw paramList;
      }
      paramzzi = new ArrayList(((zzj)localObject).zzgm.length);
      localObject = ((zzj)localObject).zzgm;
      m = localObject.length;
      j = 0;
      if (j < m)
      {
        zzh[] arrayOfzzh = localObject[j];
        if (arrayOfzzh.type == 14) {
          paramzzi.add(null);
        }
        for (;;)
        {
          j += 1;
          break;
          if (i == 9)
          {
            localDataMap = new DataMap();
            arrayOfzzh = arrayOfzzh.zzgc.zzgl;
            int n = arrayOfzzh.length;
            k = 0;
            while (k < n)
            {
              zzh localzzh = arrayOfzzh[k];
              zza(paramList, localDataMap, localzzh.name, localzzh.zzga);
              k += 1;
            }
            paramzzi.add(localDataMap);
          }
          else if (i == 2)
          {
            paramzzi.add(arrayOfzzh.zzgc.zzge);
          }
          else
          {
            if (i != 6) {
              break label927;
            }
            paramzzi.add(Integer.valueOf(arrayOfzzh.zzgc.zzgi));
          }
        }
        label927:
        paramList = new IllegalArgumentException(39 + "Unexpected typeOfArrayList: " + i);
        AppMethodBeat.o(100660);
        throw paramList;
      }
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramzzi);
        AppMethodBeat.o(100660);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramzzi);
        AppMethodBeat.o(100660);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramzzi);
        AppMethodBeat.o(100660);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramzzi);
        AppMethodBeat.o(100660);
        return;
      }
      paramList = new IllegalStateException(39 + "Unexpected typeOfArrayList: " + i);
      AppMethodBeat.o(100660);
      throw paramList;
    }
    paramList = new RuntimeException(43 + "populateBundle: unexpected type " + i);
    AppMethodBeat.o(100660);
    throw paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zze
 * JD-Core Version:    0.7.0.1
 */