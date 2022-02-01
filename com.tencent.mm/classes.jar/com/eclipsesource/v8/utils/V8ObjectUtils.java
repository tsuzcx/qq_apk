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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final TypeAdapter DEFAULT_TYPE_ADAPTER;
  private static final Object IGNORE;
  
  static
  {
    AppMethodBeat.i(61768);
    IGNORE = new Object();
    DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    AppMethodBeat.o(61768);
  }
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt)
  {
    AppMethodBeat.i(61737);
    int i = paramV8Array.length();
    if (paramInt == 1)
    {
      paramV8Array = paramV8Array.getIntegers(0, i);
      AppMethodBeat.o(61737);
      return paramV8Array;
    }
    if (paramInt == 2)
    {
      paramV8Array = paramV8Array.getDoubles(0, i);
      AppMethodBeat.o(61737);
      return paramV8Array;
    }
    if (paramInt == 3)
    {
      paramV8Array = paramV8Array.getBooleans(0, i);
      AppMethodBeat.o(61737);
      return paramV8Array;
    }
    if (paramInt == 4)
    {
      paramV8Array = paramV8Array.getStrings(0, i);
      AppMethodBeat.o(61737);
      return paramV8Array;
    }
    paramV8Array = new RuntimeException("Unsupported bulk load type: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(61737);
    throw paramV8Array;
  }
  
  public static Object getTypedArray(V8Array paramV8Array, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(61736);
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
      AppMethodBeat.o(61736);
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
      AppMethodBeat.o(61736);
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
      AppMethodBeat.o(61736);
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
      AppMethodBeat.o(61736);
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
      AppMethodBeat.o(61736);
      return paramObject;
    }
    paramV8Array = new RuntimeException("Unsupported bulk load type: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(61736);
    throw paramV8Array;
  }
  
  public static Object getV8Result(V8 paramV8, Object paramObject)
  {
    AppMethodBeat.i(61742);
    if (paramObject == null)
    {
      AppMethodBeat.o(61742);
      return null;
    }
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8 = getV8Result(paramV8, paramObject, localHashtable);
      if ((paramV8 instanceof V8Object))
      {
        paramV8 = ((V8Object)paramV8).twin();
        return paramV8;
      }
      return paramV8;
    }
    finally
    {
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
      AppMethodBeat.o(61742);
    }
  }
  
  private static Object getV8Result(V8 paramV8, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61760);
    if (paramMap.containsKey(paramObject))
    {
      paramV8 = paramMap.get(paramObject);
      AppMethodBeat.o(61760);
      return paramV8;
    }
    if ((paramObject instanceof Map))
    {
      paramV8 = toV8Object(paramV8, (Map)paramObject, paramMap);
      AppMethodBeat.o(61760);
      return paramV8;
    }
    if ((paramObject instanceof List))
    {
      paramV8 = toV8Array(paramV8, (List)paramObject, paramMap);
      AppMethodBeat.o(61760);
      return paramV8;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8 = toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap);
      AppMethodBeat.o(61760);
      return paramV8;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8 = toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap);
      AppMethodBeat.o(61760);
      return paramV8;
    }
    AppMethodBeat.o(61760);
    return paramObject;
  }
  
  public static Object getV8Result(V8Context paramV8Context, Object paramObject)
  {
    AppMethodBeat.i(61743);
    if (paramObject == null)
    {
      AppMethodBeat.o(61743);
      return null;
    }
    Hashtable localHashtable = new Hashtable();
    try
    {
      paramV8Context = getV8Result(paramV8Context, paramObject, localHashtable);
      if ((paramV8Context instanceof V8Object))
      {
        paramV8Context = ((V8Object)paramV8Context).twin();
        return paramV8Context;
      }
      return paramV8Context;
    }
    finally
    {
      paramObject = localHashtable.values().iterator();
      while (paramObject.hasNext()) {
        ((V8Value)paramObject.next()).release();
      }
      AppMethodBeat.o(61743);
    }
  }
  
  private static Object getV8Result(V8Context paramV8Context, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61761);
    if (paramMap.containsKey(paramObject))
    {
      paramV8Context = paramMap.get(paramObject);
      AppMethodBeat.o(61761);
      return paramV8Context;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Context = toV8Object(paramV8Context, (Map)paramObject, paramMap);
      AppMethodBeat.o(61761);
      return paramV8Context;
    }
    if ((paramObject instanceof List))
    {
      paramV8Context = toV8Array(paramV8Context, (List)paramObject, paramMap);
      AppMethodBeat.o(61761);
      return paramV8Context;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Context = toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap);
      AppMethodBeat.o(61761);
      return paramV8Context;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Context = toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap);
      AppMethodBeat.o(61761);
      return paramV8Context;
    }
    AppMethodBeat.o(61761);
    return paramObject;
  }
  
  public static Object getValue(V8Array paramV8Array, int paramInt)
  {
    AppMethodBeat.i(61746);
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
      AppMethodBeat.o(61746);
    }
  }
  
  public static Object getValue(V8Array paramV8Array, int paramInt, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61747);
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
      AppMethodBeat.o(61747);
    }
  }
  
  public static Object getValue(V8Object paramV8Object, String paramString)
  {
    AppMethodBeat.i(61748);
    paramV8Object = getValue(paramV8Object, paramString, DEFAULT_TYPE_ADAPTER);
    AppMethodBeat.o(61748);
    return paramV8Object;
  }
  
  public static Object getValue(V8Object paramV8Object, String paramString, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61749);
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
      AppMethodBeat.o(61749);
    }
  }
  
  public static Object getValue(Object paramObject)
  {
    AppMethodBeat.i(61730);
    paramObject = getValue(paramObject, DEFAULT_TYPE_ADAPTER);
    AppMethodBeat.o(61730);
    return paramObject;
  }
  
  private static Object getValue(Object paramObject, int paramInt, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61766);
    Object localObject = paramTypeAdapter.adapt(paramInt, paramObject);
    if (TypeAdapter.DEFAULT != localObject)
    {
      AppMethodBeat.o(61766);
      return localObject;
    }
    switch (paramInt)
    {
    default: 
      paramObject = new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(paramInt));
      AppMethodBeat.o(61766);
      throw paramObject;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      AppMethodBeat.o(61766);
      return paramObject;
    case 7: 
      paramObject = IGNORE;
      AppMethodBeat.o(61766);
      return paramObject;
    case 10: 
      paramObject = new ArrayBuffer(((V8ArrayBuffer)paramObject).getBackingStore());
      AppMethodBeat.o(61766);
      return paramObject;
    case 8: 
      paramObject = toTypedArray((V8Array)paramObject);
      AppMethodBeat.o(61766);
      return paramObject;
    case 5: 
      paramObject = toList((V8Array)paramObject, paramV8Map, paramTypeAdapter);
      AppMethodBeat.o(61766);
      return paramObject;
    case 6: 
      paramObject = toMap((V8Object)paramObject, paramV8Map, paramTypeAdapter);
      AppMethodBeat.o(61766);
      return paramObject;
    case 0: 
      AppMethodBeat.o(61766);
      return null;
    }
    paramObject = V8.getUndefined();
    AppMethodBeat.o(61766);
    return paramObject;
  }
  
  public static Object getValue(Object paramObject, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61731);
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
      AppMethodBeat.o(61731);
    }
  }
  
  public static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject)
  {
    AppMethodBeat.i(61744);
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
      AppMethodBeat.o(61744);
    }
  }
  
  private static void pushValue(V8 paramV8, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61762);
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8, (Map)paramObject, paramMap));
      AppMethodBeat.o(61762);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8, (List)paramObject, paramMap));
      AppMethodBeat.o(61762);
      return;
    }
    paramV8 = new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
    AppMethodBeat.o(61762);
    throw paramV8;
  }
  
  public static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject)
  {
    AppMethodBeat.i(61745);
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
      AppMethodBeat.o(61745);
    }
  }
  
  private static void pushValue(V8Context paramV8Context, V8Array paramV8Array, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61763);
    if (paramObject == null)
    {
      paramV8Array.pushUndefined();
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Array.push(new Double(((Long)paramObject).longValue()));
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Array.push((String)paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Array.push(paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Array.push((V8Object)paramObject);
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Array.push(toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Array.push(toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Array.push(toV8Object(paramV8Context, (Map)paramObject, paramMap));
      AppMethodBeat.o(61763);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Array.push(toV8Array(paramV8Context, (List)paramObject, paramMap));
      AppMethodBeat.o(61763);
      return;
    }
    paramV8Context = new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
    AppMethodBeat.o(61763);
    throw paramV8Context;
  }
  
  private static void setValue(V8 paramV8, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61764);
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8, (TypedArray)paramObject, paramMap));
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8, (ArrayBuffer)paramObject, paramMap));
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8, (Map)paramObject, paramMap));
      AppMethodBeat.o(61764);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8, (List)paramObject, paramMap));
      AppMethodBeat.o(61764);
      return;
    }
    paramV8 = new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
    AppMethodBeat.o(61764);
    throw paramV8;
  }
  
  private static void setValue(V8Context paramV8Context, V8Object paramV8Object, String paramString, Object paramObject, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61765);
    if (paramObject == null)
    {
      paramV8Object.addUndefined(paramString);
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramV8Object.add(paramString, ((Integer)paramObject).intValue());
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramV8Object.add(paramString, ((Long)paramObject).longValue());
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramV8Object.add(paramString, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramV8Object.add(paramString, ((Float)paramObject).floatValue());
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramV8Object.add(paramString, (String)paramObject);
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramV8Object.add(paramString, ((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof V8Object))
    {
      paramV8Object.add(paramString, (V8Object)paramObject);
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof TypedArray))
    {
      paramV8Object.add(paramString, toV8TypedArray(paramV8Context, (TypedArray)paramObject, paramMap));
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof ArrayBuffer))
    {
      paramV8Object.add(paramString, toV8ArrayBuffer(paramV8Context, (ArrayBuffer)paramObject, paramMap));
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramV8Object.add(paramString, toV8Object(paramV8Context, (Map)paramObject, paramMap));
      AppMethodBeat.o(61765);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramV8Object.add(paramString, toV8Array(paramV8Context, (List)paramObject, paramMap));
      AppMethodBeat.o(61765);
      return;
    }
    paramV8Context = new IllegalStateException("Unsupported Object of type: " + paramObject.getClass());
    AppMethodBeat.o(61765);
    throw paramV8Context;
  }
  
  public static List<? super Object> toList(V8Array paramV8Array)
  {
    AppMethodBeat.i(61734);
    paramV8Array = toList(paramV8Array, DEFAULT_TYPE_ADAPTER);
    AppMethodBeat.o(61734);
    return paramV8Array;
  }
  
  public static List<? super Object> toList(V8Array paramV8Array, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61735);
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Array = toList(paramV8Array, localV8Map, paramTypeAdapter);
      return paramV8Array;
    }
    finally
    {
      localV8Map.release();
      AppMethodBeat.o(61735);
    }
  }
  
  private static List<? super Object> toList(V8Array paramV8Array, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61751);
    if (paramV8Array == null)
    {
      paramV8Array = Collections.emptyList();
      AppMethodBeat.o(61751);
      return paramV8Array;
    }
    if (paramV8Map.containsKey(paramV8Array))
    {
      paramV8Array = (List)paramV8Map.get(paramV8Array);
      AppMethodBeat.o(61751);
      return paramV8Array;
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
        AppMethodBeat.o(61751);
      }
    }
    AppMethodBeat.o(61751);
    return localArrayList;
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object)
  {
    AppMethodBeat.i(61732);
    paramV8Object = toMap(paramV8Object, DEFAULT_TYPE_ADAPTER);
    AppMethodBeat.o(61732);
    return paramV8Object;
  }
  
  public static Map<String, ? super Object> toMap(V8Object paramV8Object, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61733);
    V8Map localV8Map = new V8Map();
    try
    {
      paramV8Object = toMap(paramV8Object, localV8Map, paramTypeAdapter);
      return paramV8Object;
    }
    finally
    {
      localV8Map.release();
      AppMethodBeat.o(61733);
    }
  }
  
  private static Map<String, ? super Object> toMap(V8Object paramV8Object, V8Map<Object> paramV8Map, TypeAdapter paramTypeAdapter)
  {
    AppMethodBeat.i(61750);
    if (paramV8Object == null)
    {
      paramV8Object = Collections.emptyMap();
      AppMethodBeat.o(61750);
      return paramV8Object;
    }
    if (paramV8Map.containsKey(paramV8Object))
    {
      paramV8Object = (Map)paramV8Map.get(paramV8Object);
      AppMethodBeat.o(61750);
      return paramV8Object;
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
        AppMethodBeat.o(61750);
      }
    }
    AppMethodBeat.o(61750);
    return localV8PropertyMap;
  }
  
  private static Object toTypedArray(V8Array paramV8Array)
  {
    AppMethodBeat.i(61767);
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
      paramV8Array = new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(i));
      AppMethodBeat.o(61767);
      throw paramV8Array;
    case 9: 
      paramV8Array = new Int8Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 11: 
      paramV8Array = new UInt8Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 12: 
      paramV8Array = new UInt8ClampedArray(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 13: 
      paramV8Array = new Int16Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 14: 
      paramV8Array = new UInt16Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 1: 
      paramV8Array = new Int32Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 15: 
      paramV8Array = new UInt32Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    case 16: 
      paramV8Array = new Float32Array(paramV8Array);
      AppMethodBeat.o(61767);
      return paramV8Array;
    }
    paramV8Array = new Float64Array(paramV8Array);
    AppMethodBeat.o(61767);
    return paramV8Array;
  }
  
  public static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList)
  {
    AppMethodBeat.i(61740);
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
      AppMethodBeat.o(61740);
    }
  }
  
  private static V8Array toV8Array(V8 paramV8, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61754);
    if (paramMap.containsKey(new ListWrapper(paramList)))
    {
      paramV8 = (V8Array)paramMap.get(new ListWrapper(paramList));
      AppMethodBeat.o(61754);
      return paramV8;
    }
    V8Array localV8Array = new V8Array(paramV8);
    paramMap.put(new ListWrapper(paramList), localV8Array);
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        pushValue(paramV8, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      AppMethodBeat.o(61754);
    }
    catch (IllegalStateException paramV8)
    {
      localV8Array.release();
      AppMethodBeat.o(61754);
      throw paramV8;
    }
    return localV8Array;
  }
  
  public static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList)
  {
    AppMethodBeat.i(61741);
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
      AppMethodBeat.o(61741);
    }
  }
  
  private static V8Array toV8Array(V8Context paramV8Context, List<? extends Object> paramList, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61755);
    if (paramMap.containsKey(new ListWrapper(paramList)))
    {
      paramV8Context = (V8Array)paramMap.get(new ListWrapper(paramList));
      AppMethodBeat.o(61755);
      return paramV8Context;
    }
    V8Array localV8Array = paramV8Context.newV8Array();
    paramMap.put(new ListWrapper(paramList), localV8Array);
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        pushValue(paramV8Context, localV8Array, paramList.get(i), paramMap);
        i += 1;
      }
      AppMethodBeat.o(61755);
    }
    catch (IllegalStateException paramV8Context)
    {
      localV8Array.release();
      AppMethodBeat.o(61755);
      throw paramV8Context;
    }
    return localV8Array;
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8 paramV8, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61756);
    if (paramMap.containsKey(paramArrayBuffer))
    {
      paramV8 = (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
      AppMethodBeat.o(61756);
      return paramV8;
    }
    paramV8 = new V8ArrayBuffer(paramV8, paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8);
    AppMethodBeat.o(61756);
    return paramV8;
  }
  
  private static V8ArrayBuffer toV8ArrayBuffer(V8Context paramV8Context, ArrayBuffer paramArrayBuffer, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61757);
    if (paramMap.containsKey(paramArrayBuffer))
    {
      paramV8Context = (V8ArrayBuffer)paramMap.get(paramArrayBuffer);
      AppMethodBeat.o(61757);
      return paramV8Context;
    }
    paramV8Context = paramV8Context.newV8ArrayBuffer(paramArrayBuffer.getByteBuffer());
    paramMap.put(paramArrayBuffer, paramV8Context);
    AppMethodBeat.o(61757);
    return paramV8Context;
  }
  
  public static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(61738);
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
      AppMethodBeat.o(61738);
    }
  }
  
  private static V8Object toV8Object(V8 paramV8, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    AppMethodBeat.i(61752);
    if (paramMap1.containsKey(paramMap))
    {
      paramV8 = (V8Object)paramMap1.get(paramMap);
      AppMethodBeat.o(61752);
      return paramV8;
    }
    V8Object localV8Object = new V8Object(paramV8);
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      AppMethodBeat.o(61752);
    }
    catch (IllegalStateException paramV8)
    {
      localV8Object.release();
      AppMethodBeat.o(61752);
      throw paramV8;
    }
    return localV8Object;
  }
  
  public static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(61739);
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
      AppMethodBeat.o(61739);
    }
  }
  
  private static V8Object toV8Object(V8Context paramV8Context, Map<String, ? extends Object> paramMap, Map<Object, V8Value> paramMap1)
  {
    AppMethodBeat.i(61753);
    if (paramMap1.containsKey(paramMap))
    {
      paramV8Context = (V8Object)paramMap1.get(paramMap);
      AppMethodBeat.o(61753);
      return paramV8Context;
    }
    V8Object localV8Object = paramV8Context.newV8Object();
    paramMap1.put(paramMap, localV8Object);
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        setValue(paramV8Context, localV8Object, (String)localEntry.getKey(), localEntry.getValue(), paramMap1);
      }
      AppMethodBeat.o(61753);
    }
    catch (IllegalStateException paramV8Context)
    {
      localV8Object.release();
      AppMethodBeat.o(61753);
      throw paramV8Context;
    }
    return localV8Object;
  }
  
  private static V8TypedArray toV8TypedArray(V8 paramV8, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61758);
    if (paramMap.containsKey(paramTypedArray))
    {
      paramV8 = (V8TypedArray)paramMap.get(paramTypedArray);
      AppMethodBeat.o(61758);
      return paramV8;
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
      AppMethodBeat.o(61758);
    }
  }
  
  private static V8TypedArray toV8TypedArray(V8Context paramV8Context, TypedArray paramTypedArray, Map<Object, V8Value> paramMap)
  {
    AppMethodBeat.i(61759);
    if (paramMap.containsKey(paramTypedArray))
    {
      paramV8Context = (V8TypedArray)paramMap.get(paramTypedArray);
      AppMethodBeat.o(61759);
      return paramV8Context;
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
      AppMethodBeat.o(61759);
    }
  }
  
  static class DefaultTypeAdapter
    implements TypeAdapter
  {
    public Object adapt(int paramInt, Object paramObject)
    {
      return TypeAdapter.DEFAULT;
    }
  }
  
  static class ListWrapper
  {
    private List<? extends Object> list;
    
    public ListWrapper(List<? extends Object> paramList)
    {
      this.list = paramList;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof ListWrapper))
      {
        bool1 = bool2;
        if (((ListWrapper)paramObject).list == this.list) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(61729);
      int i = System.identityHashCode(this.list);
      AppMethodBeat.o(61729);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.utils.V8ObjectUtils
 * JD-Core Version:    0.7.0.1
 */