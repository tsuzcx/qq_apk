package com.google.android.gms.common.util;

import androidx.b.a;
import androidx.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils
{
  public static <K, V> Map<K, V> inOrderMapOf()
  {
    AppMethodBeat.i(5129);
    Map localMap = mapOf();
    AppMethodBeat.o(5129);
    return localMap;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(5130);
    paramK = mapOf(paramK, paramV);
    AppMethodBeat.o(5130);
    return paramK;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5131);
    Map localMap = zzg(2, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5131);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5132);
    Map localMap = zzg(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5132);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    AppMethodBeat.i(5133);
    Map localMap = zzg(4, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5133);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    AppMethodBeat.i(5134);
    Map localMap = zzg(5, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5134);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    AppMethodBeat.i(5135);
    Map localMap = zzg(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5135);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5136);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    switch (i)
    {
    default: 
      paramArrayOfK = Collections.unmodifiableMap(zzb(i, false, paramArrayOfK, paramArrayOfV));
      AppMethodBeat.o(5136);
      return paramArrayOfK;
    case 0: 
      paramArrayOfK = inOrderMapOf();
      AppMethodBeat.o(5136);
      return paramArrayOfK;
    }
    paramArrayOfK = inOrderMapOf(paramArrayOfK[0], paramArrayOfV[0]);
    AppMethodBeat.o(5136);
    return paramArrayOfK;
  }
  
  public static <T> Set<T> inOrderSetOf()
  {
    AppMethodBeat.i(5093);
    Set localSet = setOf();
    AppMethodBeat.o(5093);
    return localSet;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT)
  {
    AppMethodBeat.i(5094);
    paramT = setOf(paramT);
    AppMethodBeat.o(5094);
    return paramT;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(5095);
    Set localSet = zze(2, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5095);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2, T paramT3)
  {
    AppMethodBeat.i(5096);
    Set localSet = zze(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5096);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    AppMethodBeat.i(5097);
    Set localSet = zze(4, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    localSet.add(paramT4);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5097);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5098);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableSet(zzb(paramVarArgs.length, false, paramVarArgs));
      AppMethodBeat.o(5098);
      return paramVarArgs;
    case 0: 
      paramVarArgs = inOrderSetOf();
      AppMethodBeat.o(5098);
      return paramVarArgs;
    case 1: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0]);
      AppMethodBeat.o(5098);
      return paramVarArgs;
    case 2: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1]);
      AppMethodBeat.o(5098);
      return paramVarArgs;
    case 3: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      AppMethodBeat.o(5098);
      return paramVarArgs;
    }
    paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    AppMethodBeat.o(5098);
    return paramVarArgs;
  }
  
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    AppMethodBeat.i(5069);
    if (paramCollection == null)
    {
      AppMethodBeat.o(5069);
      return true;
    }
    boolean bool = paramCollection.isEmpty();
    AppMethodBeat.o(5069);
    return bool;
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    AppMethodBeat.i(5070);
    if (paramMap == null)
    {
      AppMethodBeat.o(5070);
      return true;
    }
    boolean bool = paramMap.isEmpty();
    AppMethodBeat.o(5070);
    return bool;
  }
  
  @Deprecated
  public static <T> List<T> listOf()
  {
    AppMethodBeat.i(5072);
    List localList = Collections.emptyList();
    AppMethodBeat.o(5072);
    return localList;
  }
  
  @Deprecated
  public static <T> List<T> listOf(T paramT)
  {
    AppMethodBeat.i(5073);
    paramT = Collections.singletonList(paramT);
    AppMethodBeat.o(5073);
    return paramT;
  }
  
  @Deprecated
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5074);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      AppMethodBeat.o(5074);
      return paramVarArgs;
    case 0: 
      paramVarArgs = listOf();
      AppMethodBeat.o(5074);
      return paramVarArgs;
    }
    paramVarArgs = listOf(paramVarArgs[0]);
    AppMethodBeat.o(5074);
    return paramVarArgs;
  }
  
  public static <K, V> Map<K, V> mapOf()
  {
    AppMethodBeat.i(5119);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(5119);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(5120);
    paramK = Collections.singletonMap(paramK, paramV);
    AppMethodBeat.o(5120);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5121);
    Map localMap = zzf(2, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5121);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5122);
    Map localMap = zzf(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5122);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    AppMethodBeat.i(5123);
    Map localMap = zzf(4, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5123);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    AppMethodBeat.i(5124);
    Map localMap = zzf(5, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5124);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    AppMethodBeat.i(5125);
    Map localMap = zzf(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(5125);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5126);
    zza(paramArrayOfK, paramArrayOfV);
    switch (paramArrayOfK.length)
    {
    default: 
      paramArrayOfK = Collections.unmodifiableMap(zza(paramArrayOfK.length, false, paramArrayOfK, paramArrayOfV));
      AppMethodBeat.o(5126);
      return paramArrayOfK;
    case 0: 
      paramArrayOfK = mapOf();
      AppMethodBeat.o(5126);
      return paramArrayOfK;
    }
    paramArrayOfK = mapOf(paramArrayOfK[0], paramArrayOfV[0]);
    AppMethodBeat.o(5126);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf()
  {
    AppMethodBeat.i(5152);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    AppMethodBeat.o(5152);
    return localLinkedHashMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(5153);
    paramK = mutableInOrderMapOfWithSize(1, paramK, paramV);
    AppMethodBeat.o(5153);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5154);
    paramK1 = mutableInOrderMapOfWithSize(2, paramK1, paramV1, paramK2, paramV2);
    AppMethodBeat.o(5154);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5155);
    paramK1 = mutableInOrderMapOfWithSize(3, paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
    AppMethodBeat.o(5155);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5156);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    if (i == 0)
    {
      paramArrayOfK = mutableInOrderMapOf();
      AppMethodBeat.o(5156);
      return paramArrayOfK;
    }
    paramArrayOfK = zzb(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5156);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArraysWithSize(int paramInt, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5151);
    zza(paramArrayOfK, paramArrayOfV);
    int i = Math.max(paramInt, paramArrayOfK.length);
    if (i == 0)
    {
      paramArrayOfK = mutableInOrderMapOf();
      AppMethodBeat.o(5151);
      return paramArrayOfK;
    }
    if (paramArrayOfK.length == 0)
    {
      paramArrayOfK = mutableInOrderMapOfWithSize(i);
      AppMethodBeat.o(5151);
      return paramArrayOfK;
    }
    paramArrayOfK = zzb(paramInt, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5151);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt)
  {
    AppMethodBeat.i(5147);
    if (paramInt == 0)
    {
      localMap = mutableInOrderMapOf();
      AppMethodBeat.o(5147);
      return localMap;
    }
    Map localMap = zzg(paramInt, true);
    AppMethodBeat.o(5147);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(5148);
    Map localMap = zzg(Math.max(paramInt, 1), true);
    localMap.put(paramK, paramV);
    AppMethodBeat.o(5148);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5149);
    Map localMap = zzg(Math.max(paramInt, 2), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    AppMethodBeat.o(5149);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5150);
    Map localMap = zzg(Math.max(paramInt, 3), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    AppMethodBeat.o(5150);
    return localMap;
  }
  
  public static <T> Set<T> mutableInOrderSetOf()
  {
    AppMethodBeat.i(5111);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    AppMethodBeat.o(5111);
    return localLinkedHashSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T paramT)
  {
    AppMethodBeat.i(5112);
    paramT = mutableInOrderSetOfWithSize(1, paramT);
    AppMethodBeat.o(5112);
    return paramT;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(5113);
    paramT1 = mutableInOrderSetOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(5113);
    return paramT1;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5114);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableInOrderSetOf();
      AppMethodBeat.o(5114);
      return paramVarArgs;
    }
    paramVarArgs = zzb(paramVarArgs.length, true, paramVarArgs);
    AppMethodBeat.o(5114);
    return paramVarArgs;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt)
  {
    AppMethodBeat.i(5107);
    if (paramInt == 0)
    {
      localSet = mutableInOrderSetOf();
      AppMethodBeat.o(5107);
      return localSet;
    }
    Set localSet = zze(paramInt, true);
    AppMethodBeat.o(5107);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(5108);
    Set localSet = zze(Math.max(paramInt, 1), true);
    localSet.add(paramT);
    AppMethodBeat.o(5108);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(5109);
    Set localSet = zze(Math.max(paramInt, 2), true);
    localSet.add(paramT1);
    localSet.add(paramT2);
    AppMethodBeat.o(5109);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(5110);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(5110);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableInOrderSetOfWithSize(paramInt);
      AppMethodBeat.o(5110);
      return paramVarArgs;
    }
    paramVarArgs = zzb(i, true, paramVarArgs);
    AppMethodBeat.o(5110);
    return paramVarArgs;
  }
  
  public static <T> List<T> mutableListOf()
  {
    AppMethodBeat.i(5079);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(5079);
    return localArrayList;
  }
  
  public static <T> List<T> mutableListOf(T paramT)
  {
    AppMethodBeat.i(5080);
    paramT = mutableListOfWithSize(1, paramT);
    AppMethodBeat.o(5080);
    return paramT;
  }
  
  public static <T> List<T> mutableListOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(5081);
    paramT1 = mutableListOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(5081);
    return paramT1;
  }
  
  public static <T> List<T> mutableListOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5082);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableListOf();
      AppMethodBeat.o(5082);
      return paramVarArgs;
    }
    paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(5082);
    return paramVarArgs;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt)
  {
    AppMethodBeat.i(5075);
    if (paramInt == 0)
    {
      localList = mutableListOf();
      AppMethodBeat.o(5075);
      return localList;
    }
    List localList = zzc(paramInt, true);
    AppMethodBeat.o(5075);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(5076);
    List localList = zzc(Math.max(paramInt, 1), true);
    localList.add(paramT);
    AppMethodBeat.o(5076);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(5077);
    List localList = zzc(Math.max(paramInt, 2), true);
    localList.add(paramT1);
    localList.add(paramT2);
    AppMethodBeat.o(5077);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(5078);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableListOf();
      AppMethodBeat.o(5078);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableListOfWithSize(paramInt);
      AppMethodBeat.o(5078);
      return paramVarArgs;
    }
    if (paramVarArgs.length == i)
    {
      paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
      AppMethodBeat.o(5078);
      return paramVarArgs;
    }
    List localList = zzc(i, true);
    localList.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(5078);
    return localList;
  }
  
  public static <K, V> Map<K, V> mutableMapOf()
  {
    AppMethodBeat.i(5142);
    a locala = new a();
    AppMethodBeat.o(5142);
    return locala;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(5143);
    paramK = mutableMapOfWithSize(1, paramK, paramV);
    AppMethodBeat.o(5143);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5144);
    paramK1 = mutableMapOfWithSize(2, paramK1, paramV1, paramK2, paramV2);
    AppMethodBeat.o(5144);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5145);
    paramK1 = mutableMapOfWithSize(3, paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
    AppMethodBeat.o(5145);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5146);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    if (i == 0)
    {
      paramArrayOfK = mutableMapOf();
      AppMethodBeat.o(5146);
      return paramArrayOfK;
    }
    paramArrayOfK = zza(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5146);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableMapOfKeyValueArraysWithSize(int paramInt, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5141);
    zza(paramArrayOfK, paramArrayOfV);
    int i = Math.max(paramInt, paramArrayOfK.length);
    if (i == 0)
    {
      paramArrayOfK = mutableMapOf();
      AppMethodBeat.o(5141);
      return paramArrayOfK;
    }
    if (paramArrayOfK.length == 0)
    {
      paramArrayOfK = mutableMapOfWithSize(paramInt);
      AppMethodBeat.o(5141);
      return paramArrayOfK;
    }
    paramArrayOfK = zza(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5141);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt)
  {
    AppMethodBeat.i(5137);
    if (paramInt == 0)
    {
      localMap = mutableMapOf();
      AppMethodBeat.o(5137);
      return localMap;
    }
    Map localMap = zzf(paramInt, true);
    AppMethodBeat.o(5137);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(5138);
    Map localMap = zzf(Math.max(paramInt, 1), true);
    localMap.put(paramK, paramV);
    AppMethodBeat.o(5138);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(5139);
    Map localMap = zzf(Math.max(paramInt, 2), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    AppMethodBeat.o(5139);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(5140);
    Map localMap = zzf(Math.max(paramInt, 3), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    AppMethodBeat.o(5140);
    return localMap;
  }
  
  public static <T> Set<T> mutableSetOf()
  {
    AppMethodBeat.i(5103);
    b localb = new b();
    AppMethodBeat.o(5103);
    return localb;
  }
  
  public static <T> Set<T> mutableSetOf(T paramT)
  {
    AppMethodBeat.i(5104);
    paramT = mutableSetOfWithSize(1, paramT);
    AppMethodBeat.o(5104);
    return paramT;
  }
  
  public static <T> Set<T> mutableSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(5105);
    paramT1 = mutableSetOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(5105);
    return paramT1;
  }
  
  public static <T> Set<T> mutableSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5106);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(5106);
      return paramVarArgs;
    }
    paramVarArgs = zza(paramVarArgs.length, true, paramVarArgs);
    AppMethodBeat.o(5106);
    return paramVarArgs;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt)
  {
    AppMethodBeat.i(5099);
    if (paramInt == 0)
    {
      localSet = mutableSetOf();
      AppMethodBeat.o(5099);
      return localSet;
    }
    Set localSet = zzd(paramInt, true);
    AppMethodBeat.o(5099);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(5100);
    Set localSet = zzd(Math.max(paramInt, 1), true);
    localSet.add(paramT);
    AppMethodBeat.o(5100);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(5101);
    Set localSet = zzd(Math.max(paramInt, 2), true);
    localSet.add(paramT1);
    localSet.add(paramT2);
    AppMethodBeat.o(5101);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(5102);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(5102);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableSetOfWithSize(paramInt);
      AppMethodBeat.o(5102);
      return paramVarArgs;
    }
    paramVarArgs = zza(i, true, paramVarArgs);
    AppMethodBeat.o(5102);
    return paramVarArgs;
  }
  
  @Deprecated
  public static <T> Set<T> setOf()
  {
    AppMethodBeat.i(5085);
    Set localSet = Collections.emptySet();
    AppMethodBeat.o(5085);
    return localSet;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT)
  {
    AppMethodBeat.i(5086);
    paramT = Collections.singleton(paramT);
    AppMethodBeat.o(5086);
    return paramT;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(5087);
    Set localSet = zzd(2, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5087);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3)
  {
    AppMethodBeat.i(5088);
    Set localSet = zzd(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5088);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    AppMethodBeat.i(5089);
    Set localSet = zzd(4, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    localSet.add(paramT4);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(5089);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(5090);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableSet(zza(paramVarArgs.length, false, paramVarArgs));
      AppMethodBeat.o(5090);
      return paramVarArgs;
    case 0: 
      paramVarArgs = setOf();
      AppMethodBeat.o(5090);
      return paramVarArgs;
    case 1: 
      paramVarArgs = setOf(paramVarArgs[0]);
      AppMethodBeat.o(5090);
      return paramVarArgs;
    case 2: 
      paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1]);
      AppMethodBeat.o(5090);
      return paramVarArgs;
    case 3: 
      paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      AppMethodBeat.o(5090);
      return paramVarArgs;
    }
    paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    AppMethodBeat.o(5090);
    return paramVarArgs;
  }
  
  private static <K, V> Map<K, V> zza(int paramInt, boolean paramBoolean, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5118);
    Map localMap = zzf(paramInt, paramBoolean);
    zza(localMap, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5118);
    return localMap;
  }
  
  private static <T> Set<T> zza(int paramInt, boolean paramBoolean, T[] paramArrayOfT)
  {
    AppMethodBeat.i(5084);
    Set localSet = zzd(paramInt, paramBoolean);
    Collections.addAll(localSet, paramArrayOfT);
    AppMethodBeat.o(5084);
    return localSet;
  }
  
  private static <K, V> void zza(Map<K, V> paramMap, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5116);
    int i = 0;
    while (i < paramArrayOfK.length)
    {
      paramMap.put(paramArrayOfK[i], paramArrayOfV[i]);
      i += 1;
    }
    AppMethodBeat.o(5116);
  }
  
  private static <K, V> void zza(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5115);
    if (paramArrayOfK.length != paramArrayOfV.length)
    {
      int i = paramArrayOfK.length;
      int j = paramArrayOfV.length;
      paramArrayOfK = new IllegalArgumentException(66 + "Key and values array lengths not equal: " + i + " != " + j);
      AppMethodBeat.o(5115);
      throw paramArrayOfK;
    }
    AppMethodBeat.o(5115);
  }
  
  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(5128);
    Map localMap = zzg(paramInt, paramBoolean);
    zza(localMap, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(5128);
    return localMap;
  }
  
  private static <T> Set<T> zzb(int paramInt, boolean paramBoolean, T[] paramArrayOfT)
  {
    AppMethodBeat.i(5092);
    Set localSet = zze(paramInt, paramBoolean);
    Collections.addAll(localSet, paramArrayOfT);
    AppMethodBeat.o(5092);
    return localSet;
  }
  
  private static <T> List<T> zzc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5071);
    ArrayList localArrayList = new ArrayList(paramInt);
    AppMethodBeat.o(5071);
    return localArrayList;
  }
  
  private static <T> Set<T> zzd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5083);
    float f;
    if (paramBoolean)
    {
      f = 0.75F;
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 128;; i = 256)
    {
      if (paramInt > i) {
        break label58;
      }
      localObject = new b(paramInt);
      AppMethodBeat.o(5083);
      return localObject;
      f = 1.0F;
      break;
    }
    label58:
    Object localObject = new HashSet(paramInt, f);
    AppMethodBeat.o(5083);
    return localObject;
  }
  
  private static <T> Set<T> zze(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5091);
    if (paramBoolean) {}
    for (float f = 0.75F;; f = 1.0F)
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramInt, f);
      AppMethodBeat.o(5091);
      return localLinkedHashSet;
    }
  }
  
  private static <K, V> Map<K, V> zzf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5117);
    float f;
    if (paramBoolean)
    {
      f = 0.75F;
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 128;; i = 256)
    {
      if (paramInt > i) {
        break label58;
      }
      localObject = new a(paramInt);
      AppMethodBeat.o(5117);
      return localObject;
      f = 1.0F;
      break;
    }
    label58:
    Object localObject = new HashMap(paramInt, f);
    AppMethodBeat.o(5117);
    return localObject;
  }
  
  private static <K, V> Map<K, V> zzg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5127);
    if (paramBoolean) {}
    for (float f = 0.75F;; f = 1.0F)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramInt, f);
      AppMethodBeat.o(5127);
      return localLinkedHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.CollectionUtils
 * JD-Core Version:    0.7.0.1
 */