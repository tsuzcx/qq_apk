package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.v8.utils.typedarrays.Float32Array;
import com.eclipsesource.v8.utils.typedarrays.Float64Array;
import com.eclipsesource.v8.utils.typedarrays.Int16Array;
import com.eclipsesource.v8.utils.typedarrays.Int32Array;
import com.eclipsesource.v8.utils.typedarrays.Int8Array;
import com.eclipsesource.v8.utils.typedarrays.TypedArray;
import com.eclipsesource.v8.utils.typedarrays.UInt16Array;
import com.eclipsesource.v8.utils.typedarrays.UInt32Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8ClampedArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8ObjectUtils
{
  private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new V8ObjectUtils.DefaultTypeAdapter();
  private static final Object IGNORE = new Object();
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt)
  {
    int i = paramV8Array.length();
    if (paramInt == 1) {
      return paramV8Array.getIntegers(0, i);
    }
    if (paramInt == 2) {
      return paramV8Array.getDoubles(0, i);
    }
    if (paramInt == 3) {
      return paramV8Array.getBooleans(0, i);
    }
    if (paramInt == 4) {
      return paramV8Array.getStrings(0, i);
    }
    throw new RuntimeException("Unsupported bulk load type: " + paramInt);
  }
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt, Object paramObject)
  {
    int i = paramV8Array.length();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (int[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new int[i];
      }
      paramV8Array.getIntegers(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 2)
    {
      localObject = (double[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new double[i];
      }
      paramV8Array.getDoubles(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 3)
    {
      localObject = (boolean[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new boolean[i];
      }
      paramV8Array.getBooleans(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 4)
    {
      localObject = (String[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new String[i];
      }
      paramV8Array.getStrings(0, i, paramObject);
      return paramObject;
    }
    if (paramInt == 9)
    {
      localObject = (byte[])paramObject;
      if (localObject != null)
      {
        paramObject = localObject;
        if (localObject.length >= i) {}
      }
      else
      {
        paramObject = new byte[i];
      }
      paramV8Array.getBytes(0, i, paramObject);
      return paramObject;
    }
    throw new RuntimeException("Unsupported bulk load type: " + paramInt);
  }
  
  /* Error */
  public static Object getV8Result(V8 paramV8, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_0
    //   6: aload_0
    //   7: areturn
    //   8: new 98	java/util/Hashtable
    //   11: dup
    //   12: invokespecial 99	java/util/Hashtable:<init>	()V
    //   15: astore_2
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 102	com/eclipsesource/v8/utils/V8ObjectUtils:getV8Result	(Lcom/eclipsesource/v8/V8;Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_1
    //   24: instanceof 104
    //   27: ifeq +49 -> 76
    //   30: aload_1
    //   31: checkcast 104	com/eclipsesource/v8/V8Object
    //   34: invokevirtual 108	com/eclipsesource/v8/V8Object:twin	()Lcom/eclipsesource/v8/V8Object;
    //   37: astore_0
    //   38: aload_2
    //   39: invokeinterface 114 1 0
    //   44: invokeinterface 120 1 0
    //   49: astore_1
    //   50: aload_1
    //   51: invokeinterface 126 1 0
    //   56: ifeq +18 -> 74
    //   59: aload_1
    //   60: invokeinterface 130 1 0
    //   65: checkcast 132	com/eclipsesource/v8/V8Value
    //   68: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   71: goto -21 -> 50
    //   74: aload_0
    //   75: areturn
    //   76: aload_2
    //   77: invokeinterface 114 1 0
    //   82: invokeinterface 120 1 0
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: invokeinterface 126 1 0
    //   96: ifeq -90 -> 6
    //   99: aload_2
    //   100: invokeinterface 130 1 0
    //   105: checkcast 132	com/eclipsesource/v8/V8Value
    //   108: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   111: goto -23 -> 88
    //   114: astore_0
    //   115: aload_2
    //   116: invokeinterface 114 1 0
    //   121: invokeinterface 120 1 0
    //   126: astore_1
    //   127: aload_1
    //   128: invokeinterface 126 1 0
    //   133: ifeq +18 -> 151
    //   136: aload_1
    //   137: invokeinterface 130 1 0
    //   142: checkcast 132	com/eclipsesource/v8/V8Value
    //   145: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   148: goto -21 -> 127
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramV8	V8
    //   0	153	1	paramObject	Object
    //   15	101	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	38	114	finally
  }
  
  private static Object getV8Result(V8 paramV8, Object paramObject, Map<Object, V8Value> paramMap)
  {
    Object localObject;
    if (paramMap.containsKey(paramObject)) {
      localObject = paramMap.get(paramObject);
    }
    do
    {
      return localObject;
      if ((paramObject instanceof Map)) {
        return toV8Object(paramV8, (Map)paramObject, paramMap);
      }
      if ((paramObject instanceof List)) {
        return toV8Array(paramV8, (List)paramObject, paramMap);
      }
      if ((paramObject instanceof TypedArray)) {
        return toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap);
      }
      localObject = paramObject;
    } while (!(paramObject instanceof ArrayBuffer));
    return toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap);
  }
  
  /* Error */
  public static Object getV8Result(V8Context paramV8Context, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_0
    //   6: aload_0
    //   7: areturn
    //   8: new 98	java/util/Hashtable
    //   11: dup
    //   12: invokespecial 99	java/util/Hashtable:<init>	()V
    //   15: astore_2
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 171	com/eclipsesource/v8/utils/V8ObjectUtils:getV8Result	(Lcom/eclipsesource/v8/V8Context;Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_1
    //   24: instanceof 104
    //   27: ifeq +49 -> 76
    //   30: aload_1
    //   31: checkcast 104	com/eclipsesource/v8/V8Object
    //   34: invokevirtual 108	com/eclipsesource/v8/V8Object:twin	()Lcom/eclipsesource/v8/V8Object;
    //   37: astore_0
    //   38: aload_2
    //   39: invokeinterface 114 1 0
    //   44: invokeinterface 120 1 0
    //   49: astore_1
    //   50: aload_1
    //   51: invokeinterface 126 1 0
    //   56: ifeq +18 -> 74
    //   59: aload_1
    //   60: invokeinterface 130 1 0
    //   65: checkcast 132	com/eclipsesource/v8/V8Value
    //   68: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   71: goto -21 -> 50
    //   74: aload_0
    //   75: areturn
    //   76: aload_2
    //   77: invokeinterface 114 1 0
    //   82: invokeinterface 120 1 0
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: invokeinterface 126 1 0
    //   96: ifeq -90 -> 6
    //   99: aload_2
    //   100: invokeinterface 130 1 0
    //   105: checkcast 132	com/eclipsesource/v8/V8Value
    //   108: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   111: goto -23 -> 88
    //   114: astore_0
    //   115: aload_2
    //   116: invokeinterface 114 1 0
    //   121: invokeinterface 120 1 0
    //   126: astore_1
    //   127: aload_1
    //   128: invokeinterface 126 1 0
    //   133: ifeq +18 -> 151
    //   136: aload_1
    //   137: invokeinterface 130 1 0
    //   142: checkcast 132	com/eclipsesource/v8/V8Value
    //   145: invokevirtual 135	com/eclipsesource/v8/V8Value:release	()V
    //   148: goto -21 -> 127
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramV8Context	V8Context
    //   0	153	1	paramObject	Object
    //   15	101	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	38	114	finally
  }
  
  private static Object getV8Result(V8Context paramV8Context, Object paramObject, Map<Object, V8Value> paramMap)
  {
    Object localObject;
    if (paramMap.containsKey(paramObject)) {
      localObject = paramMap.get(paramObject);
    }
    do
    {
      return localObject;
      if ((paramObject instanceof Map)) {
        return toV8Object(paramV8Context, (Map)paramObject, paramMap);
      }
      if ((paramObject instanceof List)) {
        return toV8Array(paramV8Context, (List)paramObject, paramMap);
      }
      if ((paramObject instanceof TypedArray)) {
        return toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap);
      }
      localObject = paramObject;
    } while (!(paramObject instanceof ArrayBuffer));
    return toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap);
  }
  
  public static Object getValue(V8Array paramV8Array, int paramInt)
  {
    V8Map localV8Map = new V8Map();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramV8Array.get(paramInt);
      localObject1 = localObject2;
      paramV8Array = getValue(localObject2, paramV8Array.getType(paramInt), localV8Map, DEFAULT_TYPE_ADAPTER);
      return paramV8Array;
    }
    finally
    {
      if ((localObject1 instanceof Releasable)) {
        ((Releasable)localObject1).release();
      }
      localV8Map.release();
    }
  }
  
  public static Object getValue(V8Array paramV8Array, int paramInt, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramV8Array.get(paramInt);
      localObject1 = localObject2;
      paramV8Array = getValue(localObject2, paramV8Array.getType(paramInt), localV8Map, paramTypeAdapter);
      return paramV8Array;
    }
    finally
    {
      if ((localObject1 instanceof Releasable)) {
        ((Releasable)localObject1).release();
      }
      localV8Map.release();
    }
  }
  
  public static Object getValue(V8Object paramV8Object, String paramString)
  {
    return getValue(paramV8Object, paramString, DEFAULT_TYPE_ADAPTER);
  }
  
  public static Object getValue(V8Object paramV8Object, String paramString, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    Object localObject1 = null;
    try
    {
      Object localObject2 = paramV8Object.get(paramString);
      localObject1 = localObject2;
      paramV8Object = getValue(localObject2, paramV8Object.getType(paramString), localV8Map, paramTypeAdapter);
      return paramV8Object;
    }
    finally
    {
      if ((localObject1 instanceof Releasable)) {
        ((Releasable)localObject1).release();
      }
      localV8Map.release();
    }
  }
  
  public static Object getValue(Object paramObject)
  {
    return getValue(paramObject, DEFAULT_TYPE_ADAPTER);
  }
  
  private static Object getValue(Object paramObject, int paramInt, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    Object localObject = paramTypeAdapter.adapt(paramInt, paramObject);
    if (TypeAdapter.DEFAULT != localObject) {
      return localObject;
    }
    localObject = paramObject;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      throw new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(paramInt));
    case 7: 
      return IGNORE;
    case 10: 
      return new ArrayBuffer(((V8ArrayBuffer)paramObject).getBackingStore());
    case 8: 
      return toTypedArray((V8Array)paramObject);
    case 5: 
      return toList((V8Array)paramObject, paramV8Map, paramTypeAdapter);
    case 6: 
      return toMap((V8Object)paramObject, paramV8Map, paramTypeAdapter);
    case 0: 
      return null;
    }
    return V8.getUndefined();
  }
  
  public static Object getValue(Object paramObject, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      if ((paramObject instanceof V8Value))
      {
        paramObject = getValue(paramObject, ((V8Value)paramObject).getV8Type(), localV8Map, paramTypeAdapter);
        return paramObject;
      }
      return paramObject;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  public static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      pushValue(paramV8, paramV8Array, paramObject, localHashtable);
      return;
    }
    finally
    {
      paramV8Array = localHashtable.values().iterator();
      while (paramV8Array.hasNext()) {
        ((V8Value)paramV8Array.next()).release();
      }
    }
  }
  
  private static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8, (List)paramObject, paramMap));
      return;
    }
    throw new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
  }
  
  public static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      pushValue(paramV8Context, paramV8Array, paramObject, localHashtable);
      return;
    }
    finally
    {
      paramV8Array = localHashtable.values().iterator();
      while (paramV8Array.hasNext()) {
        ((V8Value)paramV8Array.next()).release();
      }
    }
  }
  
  private static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8Context, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8Context, (List)paramObject, paramMap));
      return;
    }
    throw new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
  }
  
  private static void setValue(V8 paramV8, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8, (List)paramObject, paramMap));
      return;
    }
    throw new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
  }
  
  private static void setValue(V8Context paramV8Context, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8Context, (Map)paramObject, paramMap));
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8Context, (List)paramObject, paramMap));
      return;
    }
    throw new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
  }
  
  public static List<? super Object> toList(V8Array paramV8Array)
  {
    return toList(paramV8Array, DEFAULT_TYPE_ADAPTER);
  }
  
  public static List<? super Object> toList(V8Array paramV8Array, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Array = toList(paramV8Array, localV8Map, paramTypeAdapter);
      return paramV8Array;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  private static List<? super Object> toList(V8Array paramV8Array, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    if (paramV8Array == null) {
      return Collections.emptyList();
    }
    if (paramV8Map.containsKey(paramV8Array)) {
      return (List)paramV8Map.get(paramV8Array);
    }
    ArrayList localArrayList = new ArrayList();
    paramV8Map.put(paramV8Array, localArrayList);
    int i = 0;
    while (i < paramV8Array.length())
    {
      Object localObject1 = null;
      try
      {
        Object localObject2 = paramV8Array.get(i);
        localObject1 = localObject2;
        Object localObject3 = getValue(localObject2, paramV8Array.getType(i), paramV8Map, paramTypeAdapter);
        localObject1 = localObject2;
        if (localObject3 != IGNORE)
        {
          localObject1 = localObject2;
          localArrayList.add(localObject3);
        }
        if ((localObject2 instanceof Releasable)) {
          ((Releasable)localObject2).release();
        }
        i += 1;
      }
      finally
      {
        if ((localObject1 instanceof Releasable)) {
          ((Releasable)localObject1).release();
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object)
  {
    return toMap(paramV8Object, DEFAULT_TYPE_ADAPTER);
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object, TypeAdapter paramTypeAdapter)
  {
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Object = toMap(paramV8Object, localV8Map, paramTypeAdapter);
      return paramV8Object;
    }
    finally
    {
      localV8Map.release();
    }
  }
  
  private static Map<String, ? super Object> toMap(V8Object paramV8Object, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    if (paramV8Object == null) {
      return Collections.emptyMap();
    }
    if (paramV8Map.containsKey(paramV8Object)) {
      return (Map)paramV8Map.get(paramV8Object);
    }
    V8PropertyMap localV8PropertyMap = new V8PropertyMap();
    paramV8Map.put(paramV8Object, localV8PropertyMap);
    String[] arrayOfString = paramV8Object.getKeys();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject1 = null;
      try
      {
        Object localObject2 = paramV8Object.get(str);
        localObject1 = localObject2;
        Object localObject3 = getValue(localObject2, paramV8Object.getType(str), paramV8Map, paramTypeAdapter);
        localObject1 = localObject2;
        if (localObject3 != IGNORE)
        {
          localObject1 = localObject2;
          localV8PropertyMap.put(str, localObject3);
        }
        if ((localObject2 instanceof Releasable)) {
          ((Releasable)localObject2).release();
        }
        i += 1;
      }
      finally
      {
        if ((localObject1 instanceof Releasable)) {
          ((Releasable)localObject1).release();
        }
      }
    }
    return localV8PropertyMap;
  }
  
  private static Object toTypedArray(V8Array paramV8Array)
  {
    int i = paramV8Array.getType();
    paramV8Array = ((V8TypedArray)paramV8Array).getByteBuffer();
    switch (i)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      throw new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(i));
    case 9: 
      return new Int8Array(paramV8Array);
    case 11: 
      return new UInt8Array(paramV8Array);
    case 12: 
      return new UInt8ClampedArray(paramV8Array);
    case 13: 
      return new Int16Array(paramV8Array);
    case 14: 
      return new UInt16Array(paramV8Array);
    case 1: 
      return new Int32Array(paramV8Array);
    case 15: 
      return new UInt32Array(paramV8Array);
    case 16: 
      return new Float32Array(paramV8Array);
    }
    return new Float64Array(paramV8Array);
  }
  
  public static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = toV8Array(paramV8, paramList, localHashtable).twin();
      return paramV8;
    }
    finally
    {
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
    }
  }
  
  private static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    Object localObject;
    if (paramMap.containsKey(new V8ObjectUtils.ListWrapper(paramList))) {
      localObject = (V8Array)paramMap.get(new V8ObjectUtils.ListWrapper(paramList));
    }
    for (;;)
    {
      return localObject;
      V8Array localV8Array = new V8Array(paramV8);
      paramMap.put(new V8ObjectUtils.ListWrapper(paramList), localV8Array);
      int i = 0;
      localObject = localV8Array;
      try
      {
        if (i >= paramList.size()) {
          continue;
        }
        pushValue(paramV8, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      catch (IllegalStateException paramV8)
      {
        localV8Array.release();
        throw paramV8;
      }
    }
  }
  
  public static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = toV8Array(paramV8Context, paramList, localHashtable).twin();
      return paramV8Context;
    }
    finally
    {
      paramList = localHashtable.values().iterator();
      while (paramList.hasNext()) {
        ((V8Value)paramList.next()).release();
      }
    }
  }
  
  private static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    Object localObject;
    if (paramMap.containsKey(new V8ObjectUtils.ListWrapper(paramList))) {
      localObject = (V8Array)paramMap.get(new V8ObjectUtils.ListWrapper(paramList));
    }
    for (;;)
    {
      return localObject;
      V8Array localV8Array = paramV8Context.newV8Array();
      paramMap.put(new V8ObjectUtils.ListWrapper(paramList), localV8Array);
      int i = 0;
      localObject = localV8Array;
      try
      {
        if (i >= paramList.size()) {
          continue;
        }
        pushValue(paramV8Context, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      catch (IllegalStateException paramV8Context)
      {
        localV8Array.release();
        throw paramV8Context;
      }
    }
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8 paramV8, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramArrayBuffer)) {
      return (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
    }
    paramV8 = new V8ArrayBuffer(paramV8, paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8);
    return paramV8;
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8Context paramV8Context, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramArrayBuffer)) {
      return (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
    }
    paramV8Context = paramV8Context.newV8ArrayBuffer(paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8Context);
    return paramV8Context;
  }
  
  public static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = toV8Object(paramV8, paramMap, localHashtable).twin();
      return paramV8;
    }
    finally
    {
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
    }
  }
  
  private static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    if (paramMap1.containsKey(paramMap)) {
      return (V8Object)paramMap1.get(paramMap);
    }
    localV8Object = new V8Object(paramV8);
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      return localV8Object;
    }
    catch (IllegalStateException paramV8)
    {
      localV8Object.release();
      throw paramV8;
    }
  }
  
  public static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = toV8Object(paramV8Context, paramMap, localHashtable).twin();
      return paramV8Context;
    }
    finally
    {
      paramMap = localHashtable.values().iterator();
      while (paramMap.hasNext()) {
        ((V8Value)paramMap.next()).release();
      }
    }
  }
  
  private static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    if (paramMap1.containsKey(paramMap)) {
      return (V8Object)paramMap1.get(paramMap);
    }
    localV8Object = paramV8Context.newV8Object();
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8Context, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      return localV8Object;
    }
    catch (IllegalStateException paramV8Context)
    {
      localV8Object.release();
      throw paramV8Context;
    }
  }
  
  private static V8TypedArray toV8TypedArray(V8 paramV8, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramTypedArray)) {
      return (V8TypedArray)paramMap.get(paramTypedArray);
    }
    V8ArrayBuffer localV8ArrayBuffer = new V8ArrayBuffer(paramV8, paramTypedArray.getByteBuffer());
    try
    {
      paramV8 = new V8TypedArray(paramV8, localV8ArrayBuffer, paramTypedArray.getType(), 0, paramTypedArray.length());
      paramMap.put(paramTypedArray, paramV8);
      return paramV8;
    }
    finally
    {
      localV8ArrayBuffer.release();
    }
  }
  
  private static V8TypedArray toV8TypedArray(V8Context paramV8Context, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    if (paramMap.containsKey(paramTypedArray)) {
      return (V8TypedArray)paramMap.get(paramTypedArray);
    }
    V8ArrayBuffer localV8ArrayBuffer = paramV8Context.newV8ArrayBuffer(paramTypedArray.getByteBuffer());
    try
    {
      paramV8Context = paramV8Context.newV8TypedArray(localV8ArrayBuffer, paramTypedArray.getType(), 0, paramTypedArray.length());
      paramMap.put(paramTypedArray, paramV8Context);
      return paramV8Context;
    }
    finally
    {
      localV8ArrayBuffer.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8ObjectUtils
 * JD-Core Version:    0.7.0.1
 */