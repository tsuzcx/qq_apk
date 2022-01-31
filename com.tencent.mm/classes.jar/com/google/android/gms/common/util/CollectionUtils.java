package com.google.android.gms.common.util;

import android.support.v4.e.a;
import android.support.v4.e.b;
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
    AppMethodBeat.i(90107);
    Map localMap = mapOf();
    AppMethodBeat.o(90107);
    return localMap;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(90108);
    paramK = mapOf(paramK, paramV);
    AppMethodBeat.o(90108);
    return paramK;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90109);
    Map localMap = zzg(2, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90109);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90110);
    Map localMap = zzg(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90110);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    AppMethodBeat.i(90111);
    Map localMap = zzg(4, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90111);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    AppMethodBeat.i(90112);
    Map localMap = zzg(5, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90112);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    AppMethodBeat.i(90113);
    Map localMap = zzg(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90113);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> inOrderMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90114);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    switch (i)
    {
    default: 
      paramArrayOfK = Collections.unmodifiableMap(zzb(i, false, paramArrayOfK, paramArrayOfV));
      AppMethodBeat.o(90114);
      return paramArrayOfK;
    case 0: 
      paramArrayOfK = inOrderMapOf();
      AppMethodBeat.o(90114);
      return paramArrayOfK;
    }
    paramArrayOfK = inOrderMapOf(paramArrayOfK[0], paramArrayOfV[0]);
    AppMethodBeat.o(90114);
    return paramArrayOfK;
  }
  
  public static <T> Set<T> inOrderSetOf()
  {
    AppMethodBeat.i(90071);
    Set localSet = setOf();
    AppMethodBeat.o(90071);
    return localSet;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT)
  {
    AppMethodBeat.i(90072);
    paramT = setOf(paramT);
    AppMethodBeat.o(90072);
    return paramT;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(90073);
    Set localSet = zze(2, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90073);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2, T paramT3)
  {
    AppMethodBeat.i(90074);
    Set localSet = zze(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90074);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    AppMethodBeat.i(90075);
    Set localSet = zze(4, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    localSet.add(paramT4);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90075);
    return paramT1;
  }
  
  public static <T> Set<T> inOrderSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90076);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableSet(zzb(paramVarArgs.length, false, paramVarArgs));
      AppMethodBeat.o(90076);
      return paramVarArgs;
    case 0: 
      paramVarArgs = inOrderSetOf();
      AppMethodBeat.o(90076);
      return paramVarArgs;
    case 1: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0]);
      AppMethodBeat.o(90076);
      return paramVarArgs;
    case 2: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1]);
      AppMethodBeat.o(90076);
      return paramVarArgs;
    case 3: 
      paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      AppMethodBeat.o(90076);
      return paramVarArgs;
    }
    paramVarArgs = inOrderSetOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    AppMethodBeat.o(90076);
    return paramVarArgs;
  }
  
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    AppMethodBeat.i(90047);
    if (paramCollection == null)
    {
      AppMethodBeat.o(90047);
      return true;
    }
    boolean bool = paramCollection.isEmpty();
    AppMethodBeat.o(90047);
    return bool;
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    AppMethodBeat.i(90048);
    if (paramMap == null)
    {
      AppMethodBeat.o(90048);
      return true;
    }
    boolean bool = paramMap.isEmpty();
    AppMethodBeat.o(90048);
    return bool;
  }
  
  @Deprecated
  public static <T> List<T> listOf()
  {
    AppMethodBeat.i(90050);
    List localList = Collections.emptyList();
    AppMethodBeat.o(90050);
    return localList;
  }
  
  @Deprecated
  public static <T> List<T> listOf(T paramT)
  {
    AppMethodBeat.i(90051);
    paramT = Collections.singletonList(paramT);
    AppMethodBeat.o(90051);
    return paramT;
  }
  
  @Deprecated
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90052);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      AppMethodBeat.o(90052);
      return paramVarArgs;
    case 0: 
      paramVarArgs = listOf();
      AppMethodBeat.o(90052);
      return paramVarArgs;
    }
    paramVarArgs = listOf(paramVarArgs[0]);
    AppMethodBeat.o(90052);
    return paramVarArgs;
  }
  
  public static <K, V> Map<K, V> mapOf()
  {
    AppMethodBeat.i(90097);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(90097);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(90098);
    paramK = Collections.singletonMap(paramK, paramV);
    AppMethodBeat.o(90098);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90099);
    Map localMap = zzf(2, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90099);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90100);
    Map localMap = zzf(3, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90100);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    AppMethodBeat.i(90101);
    Map localMap = zzf(4, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90101);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    AppMethodBeat.i(90102);
    Map localMap = zzf(5, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90102);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    AppMethodBeat.i(90103);
    Map localMap = zzf(6, false);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    paramK1 = Collections.unmodifiableMap(localMap);
    AppMethodBeat.o(90103);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90104);
    zza(paramArrayOfK, paramArrayOfV);
    switch (paramArrayOfK.length)
    {
    default: 
      paramArrayOfK = Collections.unmodifiableMap(zza(paramArrayOfK.length, false, paramArrayOfK, paramArrayOfV));
      AppMethodBeat.o(90104);
      return paramArrayOfK;
    case 0: 
      paramArrayOfK = mapOf();
      AppMethodBeat.o(90104);
      return paramArrayOfK;
    }
    paramArrayOfK = mapOf(paramArrayOfK[0], paramArrayOfV[0]);
    AppMethodBeat.o(90104);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf()
  {
    AppMethodBeat.i(90130);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    AppMethodBeat.o(90130);
    return localLinkedHashMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(90131);
    paramK = mutableInOrderMapOfWithSize(1, paramK, paramV);
    AppMethodBeat.o(90131);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90132);
    paramK1 = mutableInOrderMapOfWithSize(2, paramK1, paramV1, paramK2, paramV2);
    AppMethodBeat.o(90132);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90133);
    paramK1 = mutableInOrderMapOfWithSize(3, paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
    AppMethodBeat.o(90133);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90134);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    if (i == 0)
    {
      paramArrayOfK = mutableInOrderMapOf();
      AppMethodBeat.o(90134);
      return paramArrayOfK;
    }
    paramArrayOfK = zzb(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90134);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArraysWithSize(int paramInt, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90129);
    zza(paramArrayOfK, paramArrayOfV);
    int i = Math.max(paramInt, paramArrayOfK.length);
    if (i == 0)
    {
      paramArrayOfK = mutableInOrderMapOf();
      AppMethodBeat.o(90129);
      return paramArrayOfK;
    }
    if (paramArrayOfK.length == 0)
    {
      paramArrayOfK = mutableInOrderMapOfWithSize(i);
      AppMethodBeat.o(90129);
      return paramArrayOfK;
    }
    paramArrayOfK = zzb(paramInt, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90129);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt)
  {
    AppMethodBeat.i(90125);
    if (paramInt == 0)
    {
      localMap = mutableInOrderMapOf();
      AppMethodBeat.o(90125);
      return localMap;
    }
    Map localMap = zzg(paramInt, true);
    AppMethodBeat.o(90125);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(90126);
    Map localMap = zzg(Math.max(paramInt, 1), true);
    localMap.put(paramK, paramV);
    AppMethodBeat.o(90126);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90127);
    Map localMap = zzg(Math.max(paramInt, 2), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    AppMethodBeat.o(90127);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90128);
    Map localMap = zzg(Math.max(paramInt, 3), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    AppMethodBeat.o(90128);
    return localMap;
  }
  
  public static <T> Set<T> mutableInOrderSetOf()
  {
    AppMethodBeat.i(90089);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    AppMethodBeat.o(90089);
    return localLinkedHashSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T paramT)
  {
    AppMethodBeat.i(90090);
    paramT = mutableInOrderSetOfWithSize(1, paramT);
    AppMethodBeat.o(90090);
    return paramT;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(90091);
    paramT1 = mutableInOrderSetOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(90091);
    return paramT1;
  }
  
  public static <T> Set<T> mutableInOrderSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90092);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableInOrderSetOf();
      AppMethodBeat.o(90092);
      return paramVarArgs;
    }
    paramVarArgs = zzb(paramVarArgs.length, true, paramVarArgs);
    AppMethodBeat.o(90092);
    return paramVarArgs;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt)
  {
    AppMethodBeat.i(90085);
    if (paramInt == 0)
    {
      localSet = mutableInOrderSetOf();
      AppMethodBeat.o(90085);
      return localSet;
    }
    Set localSet = zze(paramInt, true);
    AppMethodBeat.o(90085);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(90086);
    Set localSet = zze(Math.max(paramInt, 1), true);
    localSet.add(paramT);
    AppMethodBeat.o(90086);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(90087);
    Set localSet = zze(Math.max(paramInt, 2), true);
    localSet.add(paramT1);
    localSet.add(paramT2);
    AppMethodBeat.o(90087);
    return localSet;
  }
  
  public static <T> Set<T> mutableInOrderSetOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(90088);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(90088);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableInOrderSetOfWithSize(paramInt);
      AppMethodBeat.o(90088);
      return paramVarArgs;
    }
    paramVarArgs = zzb(i, true, paramVarArgs);
    AppMethodBeat.o(90088);
    return paramVarArgs;
  }
  
  public static <T> List<T> mutableListOf()
  {
    AppMethodBeat.i(90057);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(90057);
    return localArrayList;
  }
  
  public static <T> List<T> mutableListOf(T paramT)
  {
    AppMethodBeat.i(90058);
    paramT = mutableListOfWithSize(1, paramT);
    AppMethodBeat.o(90058);
    return paramT;
  }
  
  public static <T> List<T> mutableListOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(90059);
    paramT1 = mutableListOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(90059);
    return paramT1;
  }
  
  public static <T> List<T> mutableListOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90060);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableListOf();
      AppMethodBeat.o(90060);
      return paramVarArgs;
    }
    paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90060);
    return paramVarArgs;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt)
  {
    AppMethodBeat.i(90053);
    if (paramInt == 0)
    {
      localList = mutableListOf();
      AppMethodBeat.o(90053);
      return localList;
    }
    List localList = zzc(paramInt, true);
    AppMethodBeat.o(90053);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(90054);
    List localList = zzc(Math.max(paramInt, 1), true);
    localList.add(paramT);
    AppMethodBeat.o(90054);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(90055);
    List localList = zzc(Math.max(paramInt, 2), true);
    localList.add(paramT1);
    localList.add(paramT2);
    AppMethodBeat.o(90055);
    return localList;
  }
  
  public static <T> List<T> mutableListOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(90056);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableListOf();
      AppMethodBeat.o(90056);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableListOfWithSize(paramInt);
      AppMethodBeat.o(90056);
      return paramVarArgs;
    }
    if (paramVarArgs.length == i)
    {
      paramVarArgs = new ArrayList(Arrays.asList(paramVarArgs));
      AppMethodBeat.o(90056);
      return paramVarArgs;
    }
    List localList = zzc(i, true);
    localList.addAll(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90056);
    return localList;
  }
  
  public static <K, V> Map<K, V> mutableMapOf()
  {
    AppMethodBeat.i(90120);
    a locala = new a();
    AppMethodBeat.o(90120);
    return locala;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK, V paramV)
  {
    AppMethodBeat.i(90121);
    paramK = mutableMapOfWithSize(1, paramK, paramV);
    AppMethodBeat.o(90121);
    return paramK;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90122);
    paramK1 = mutableMapOfWithSize(2, paramK1, paramV1, paramK2, paramV2);
    AppMethodBeat.o(90122);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableMapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90123);
    paramK1 = mutableMapOfWithSize(3, paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
    AppMethodBeat.o(90123);
    return paramK1;
  }
  
  public static <K, V> Map<K, V> mutableMapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90124);
    zza(paramArrayOfK, paramArrayOfV);
    int i = paramArrayOfK.length;
    if (i == 0)
    {
      paramArrayOfK = mutableMapOf();
      AppMethodBeat.o(90124);
      return paramArrayOfK;
    }
    paramArrayOfK = zza(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90124);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableMapOfKeyValueArraysWithSize(int paramInt, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90119);
    zza(paramArrayOfK, paramArrayOfV);
    int i = Math.max(paramInt, paramArrayOfK.length);
    if (i == 0)
    {
      paramArrayOfK = mutableMapOf();
      AppMethodBeat.o(90119);
      return paramArrayOfK;
    }
    if (paramArrayOfK.length == 0)
    {
      paramArrayOfK = mutableMapOfWithSize(paramInt);
      AppMethodBeat.o(90119);
      return paramArrayOfK;
    }
    paramArrayOfK = zza(i, true, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90119);
    return paramArrayOfK;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt)
  {
    AppMethodBeat.i(90115);
    if (paramInt == 0)
    {
      localMap = mutableMapOf();
      AppMethodBeat.o(90115);
      return localMap;
    }
    Map localMap = zzf(paramInt, true);
    AppMethodBeat.o(90115);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK, V paramV)
  {
    AppMethodBeat.i(90116);
    Map localMap = zzf(Math.max(paramInt, 1), true);
    localMap.put(paramK, paramV);
    AppMethodBeat.o(90116);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2)
  {
    AppMethodBeat.i(90117);
    Map localMap = zzf(Math.max(paramInt, 2), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    AppMethodBeat.o(90117);
    return localMap;
  }
  
  public static <K, V> Map<K, V> mutableMapOfWithSize(int paramInt, K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    AppMethodBeat.i(90118);
    Map localMap = zzf(Math.max(paramInt, 3), true);
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    AppMethodBeat.o(90118);
    return localMap;
  }
  
  public static <T> Set<T> mutableSetOf()
  {
    AppMethodBeat.i(90081);
    b localb = new b();
    AppMethodBeat.o(90081);
    return localb;
  }
  
  public static <T> Set<T> mutableSetOf(T paramT)
  {
    AppMethodBeat.i(90082);
    paramT = mutableSetOfWithSize(1, paramT);
    AppMethodBeat.o(90082);
    return paramT;
  }
  
  public static <T> Set<T> mutableSetOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(90083);
    paramT1 = mutableSetOfWithSize(2, paramT1, paramT2);
    AppMethodBeat.o(90083);
    return paramT1;
  }
  
  public static <T> Set<T> mutableSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90084);
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(90084);
      return paramVarArgs;
    }
    paramVarArgs = zza(paramVarArgs.length, true, paramVarArgs);
    AppMethodBeat.o(90084);
    return paramVarArgs;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt)
  {
    AppMethodBeat.i(90077);
    if (paramInt == 0)
    {
      localSet = mutableSetOf();
      AppMethodBeat.o(90077);
      return localSet;
    }
    Set localSet = zzd(paramInt, true);
    AppMethodBeat.o(90077);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T paramT)
  {
    AppMethodBeat.i(90078);
    Set localSet = zzd(Math.max(paramInt, 1), true);
    localSet.add(paramT);
    AppMethodBeat.o(90078);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T paramT1, T paramT2)
  {
    AppMethodBeat.i(90079);
    Set localSet = zzd(Math.max(paramInt, 2), true);
    localSet.add(paramT1);
    localSet.add(paramT2);
    AppMethodBeat.o(90079);
    return localSet;
  }
  
  public static <T> Set<T> mutableSetOfWithSize(int paramInt, T... paramVarArgs)
  {
    AppMethodBeat.i(90080);
    int i = Math.max(paramInt, paramVarArgs.length);
    if (i == 0)
    {
      paramVarArgs = mutableSetOf();
      AppMethodBeat.o(90080);
      return paramVarArgs;
    }
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = mutableSetOfWithSize(paramInt);
      AppMethodBeat.o(90080);
      return paramVarArgs;
    }
    paramVarArgs = zza(i, true, paramVarArgs);
    AppMethodBeat.o(90080);
    return paramVarArgs;
  }
  
  @Deprecated
  public static <T> Set<T> setOf()
  {
    AppMethodBeat.i(90063);
    Set localSet = Collections.emptySet();
    AppMethodBeat.o(90063);
    return localSet;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT)
  {
    AppMethodBeat.i(90064);
    paramT = Collections.singleton(paramT);
    AppMethodBeat.o(90064);
    return paramT;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2)
  {
    AppMethodBeat.i(90065);
    Set localSet = zzd(2, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90065);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3)
  {
    AppMethodBeat.i(90066);
    Set localSet = zzd(3, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90066);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3, T paramT4)
  {
    AppMethodBeat.i(90067);
    Set localSet = zzd(4, false);
    localSet.add(paramT1);
    localSet.add(paramT2);
    localSet.add(paramT3);
    localSet.add(paramT4);
    paramT1 = Collections.unmodifiableSet(localSet);
    AppMethodBeat.o(90067);
    return paramT1;
  }
  
  @Deprecated
  public static <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(90068);
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = Collections.unmodifiableSet(zza(paramVarArgs.length, false, paramVarArgs));
      AppMethodBeat.o(90068);
      return paramVarArgs;
    case 0: 
      paramVarArgs = setOf();
      AppMethodBeat.o(90068);
      return paramVarArgs;
    case 1: 
      paramVarArgs = setOf(paramVarArgs[0]);
      AppMethodBeat.o(90068);
      return paramVarArgs;
    case 2: 
      paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1]);
      AppMethodBeat.o(90068);
      return paramVarArgs;
    case 3: 
      paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      AppMethodBeat.o(90068);
      return paramVarArgs;
    }
    paramVarArgs = setOf(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    AppMethodBeat.o(90068);
    return paramVarArgs;
  }
  
  private static <K, V> Map<K, V> zza(int paramInt, boolean paramBoolean, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90096);
    Map localMap = zzf(paramInt, paramBoolean);
    zza(localMap, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90096);
    return localMap;
  }
  
  private static <T> Set<T> zza(int paramInt, boolean paramBoolean, T[] paramArrayOfT)
  {
    AppMethodBeat.i(90062);
    Set localSet = zzd(paramInt, paramBoolean);
    Collections.addAll(localSet, paramArrayOfT);
    AppMethodBeat.o(90062);
    return localSet;
  }
  
  private static <K, V> void zza(Map<K, V> paramMap, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90094);
    int i = 0;
    while (i < paramArrayOfK.length)
    {
      paramMap.put(paramArrayOfK[i], paramArrayOfV[i]);
      i += 1;
    }
    AppMethodBeat.o(90094);
  }
  
  private static <K, V> void zza(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90093);
    if (paramArrayOfK.length != paramArrayOfV.length)
    {
      int i = paramArrayOfK.length;
      int j = paramArrayOfV.length;
      paramArrayOfK = new IllegalArgumentException(66 + "Key and values array lengths not equal: " + i + " != " + j);
      AppMethodBeat.o(90093);
      throw paramArrayOfK;
    }
    AppMethodBeat.o(90093);
  }
  
  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean, K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(90106);
    Map localMap = zzg(paramInt, paramBoolean);
    zza(localMap, paramArrayOfK, paramArrayOfV);
    AppMethodBeat.o(90106);
    return localMap;
  }
  
  private static <T> Set<T> zzb(int paramInt, boolean paramBoolean, T[] paramArrayOfT)
  {
    AppMethodBeat.i(90070);
    Set localSet = zze(paramInt, paramBoolean);
    Collections.addAll(localSet, paramArrayOfT);
    AppMethodBeat.o(90070);
    return localSet;
  }
  
  private static <T> List<T> zzc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90049);
    ArrayList localArrayList = new ArrayList(paramInt);
    AppMethodBeat.o(90049);
    return localArrayList;
  }
  
  private static <T> Set<T> zzd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90061);
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
      AppMethodBeat.o(90061);
      return localObject;
      f = 1.0F;
      break;
    }
    label58:
    Object localObject = new HashSet(paramInt, f);
    AppMethodBeat.o(90061);
    return localObject;
  }
  
  private static <T> Set<T> zze(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90069);
    if (paramBoolean) {}
    for (float f = 0.75F;; f = 1.0F)
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramInt, f);
      AppMethodBeat.o(90069);
      return localLinkedHashSet;
    }
  }
  
  private static <K, V> Map<K, V> zzf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90095);
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
      AppMethodBeat.o(90095);
      return localObject;
      f = 1.0F;
      break;
    }
    label58:
    Object localObject = new HashMap(paramInt, f);
    AppMethodBeat.o(90095);
    return localObject;
  }
  
  private static <K, V> Map<K, V> zzg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90105);
    if (paramBoolean) {}
    for (float f = 0.75F;; f = 1.0F)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramInt, f);
      AppMethodBeat.o(90105);
      return localLinkedHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.util.CollectionUtils
 * JD-Core Version:    0.7.0.1
 */