package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V8
  extends V8Object
{
  private static boolean initialized;
  private static Object invalid = new Object();
  private static Object lock = new Object();
  private static boolean nativeLibraryLoaded;
  private static Error nativeLoadError;
  private static Exception nativeLoadException;
  private static volatile int runtimeCounter = 0;
  private static V8Value undefined;
  private static String v8Flags = null;
  private Map<String, Object> data = null;
  private V8Map<V8Executor> executors = null;
  private boolean forceTerminateExecutors = false;
  private Map<Long, V8.MethodDescriptor> functionRegistry = new HashMap();
  private final V8Locker locker;
  private long objectReferences = 0L;
  private LinkedList<ReferenceHandler> referenceHandlers = new LinkedList();
  private LinkedList<V8Runnable> releaseHandlers = new LinkedList();
  private List<Releasable> resources = null;
  private long v8RuntimePtr = 0L;
  protected Map<Long, V8Value> v8WeakReferences = new HashMap();
  
  static
  {
    initialized = false;
    nativeLibraryLoaded = false;
    nativeLoadError = null;
    nativeLoadException = null;
    undefined = new V8Object.Undefined();
  }
  
  protected V8()
  {
    this(null, true);
  }
  
  protected V8(String paramString, boolean paramBoolean)
  {
    super(null);
    this.released = false;
    this.v8RuntimePtr = _createIsolate(paramString, paramBoolean);
    this.locker = new V8Locker(this);
    checkThread();
    if (paramBoolean) {
      this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }
  }
  
  private native void _acquireLock(long paramLong);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, double paramDouble);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, int paramInt);
  
  private native void _add(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  private native void _add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean);
  
  private native void _addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void _addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble);
  
  private native void _addArrayIntItem(long paramLong1, long paramLong2, int paramInt);
  
  private native void _addArrayNullItem(long paramLong1, long paramLong2);
  
  private native void _addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _addArrayStringItem(long paramLong1, long paramLong2, String paramString);
  
  private native void _addArrayUndefinedItem(long paramLong1, long paramLong2);
  
  private native void _addNull(long paramLong1, long paramLong2, String paramString);
  
  private native void _addObject(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _addUndefined(long paramLong1, long paramLong2, String paramString);
  
  private native Object _arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  private native boolean _arrayGetBoolean(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean);
  
  private native boolean[] _arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native byte _arrayGetByte(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private native byte[] _arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native double _arrayGetDouble(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble);
  
  private native double[] _arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _arrayGetInteger(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  private native int[] _arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _arrayGetSize(long paramLong1, long paramLong2);
  
  private native String _arrayGetString(long paramLong1, long paramLong2, int paramInt);
  
  private native int _arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString);
  
  private native String[] _arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native boolean _contains(long paramLong1, long paramLong2, String paramString);
  
  private native long _createContext(long paramLong, int paramInt);
  
  private native long _createIsolate(String paramString, boolean paramBoolean);
  
  private native void _createTwin(long paramLong1, long paramLong2, long paramLong3);
  
  private native ByteBuffer _createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt);
  
  private native boolean _equals(long paramLong1, long paramLong2, long paramLong3);
  
  private native boolean _executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native boolean _executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native double _executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native double _executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3);
  
  private native Object _executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private native int _executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native int _executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  private native String _executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native String _executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native void _executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt);
  
  private native Object _get(long paramLong1, int paramInt, long paramLong2, String paramString);
  
  private native int _getArrayType(long paramLong1, long paramLong2);
  
  private native boolean _getBoolean(long paramLong1, long paramLong2, String paramString);
  
  private native long _getBuildID();
  
  private native double _getDouble(long paramLong1, long paramLong2, String paramString);
  
  private native long _getGlobalObject(long paramLong);
  
  private native int _getInteger(long paramLong1, long paramLong2, String paramString);
  
  private native long _getIsolatePtr(long paramLong);
  
  private native String[] _getKeys(long paramLong1, long paramLong2);
  
  private native String _getString(long paramLong1, long paramLong2, String paramString);
  
  private native int _getType(long paramLong1, long paramLong2);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _getType(long paramLong1, long paramLong2, String paramString);
  
  private static native String _getVersion();
  
  private native int _identityHash(long paramLong1, long paramLong2);
  
  private native long _initNewV8Array(long paramLong);
  
  private native long _initNewV8ArrayBuffer(long paramLong, int paramInt);
  
  private native long _initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native long _initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long[] _initNewV8Function(long paramLong);
  
  private native long _initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8Object(long paramLong);
  
  private native long _initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native long _initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private static native boolean _isRunning(long paramLong);
  
  private native boolean _isWeak(long paramLong1, long paramLong2);
  
  private native void _lowMemoryNotification(long paramLong);
  
  private static native boolean _pumpMessageLoop(long paramLong);
  
  private native long _registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean);
  
  private native void _release(long paramLong1, long paramLong2);
  
  private native void _releaseContext(long paramLong1, long paramLong2);
  
  private native void _releaseLock(long paramLong);
  
  private native void _releaseMethodDescriptor(long paramLong1, long paramLong2);
  
  private native void _releaseRuntime(long paramLong);
  
  private native boolean _sameValue(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void _setFlags(String paramString);
  
  private native void _setPrototype(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _setWeak(long paramLong1, long paramLong2);
  
  private static native void _startNodeJS(long paramLong, String paramString);
  
  private native boolean _strictEquals(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _switchContext(long paramLong1, long paramLong2);
  
  private native void _terminateExecution(long paramLong);
  
  private native String _toString(long paramLong1, long paramLong2);
  
  private void checkArgs(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == invalid) {
        throw new IllegalArgumentException("argument type mismatch");
      }
      i += 1;
    }
  }
  
  private static void checkNativeLibraryLoaded()
  {
    if (!nativeLibraryLoaded)
    {
      if (nativeLoadError != null) {
        throw new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
      }
      if (nativeLoadException != null) {
        throw new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
      }
      throw new IllegalStateException("J2V8 native library not loaded");
    }
  }
  
  private Object checkResult(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return paramObject;
        if ((paramObject instanceof Float)) {
          return Double.valueOf(((Float)paramObject).doubleValue());
        }
      } while (((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof String)));
      if (!(paramObject instanceof V8Value)) {
        break;
      }
    } while (!((V8Value)paramObject).isReleased());
    throw new V8RuntimeException("V8Value already released");
    throw new V8RuntimeException("Unknown return type: " + paramObject.getClass());
  }
  
  static void checkScript(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Script is null");
    }
  }
  
  public static V8 createV8Runtime()
  {
    return createV8Runtime(null, null);
  }
  
  public static V8 createV8Runtime(String paramString)
  {
    return createV8Runtime(paramString, null);
  }
  
  public static V8 createV8Runtime(String paramString1, String paramString2)
  {
    return createV8Runtime(paramString1, paramString2, true);
  }
  
  protected static V8 createV8Runtime(String arg0, String paramString2, boolean paramBoolean)
  {
    if (!nativeLibraryLoaded) {}
    synchronized (lock)
    {
      if (!nativeLibraryLoaded) {
        load(paramString2);
      }
      checkNativeLibraryLoaded();
      if (!initialized)
      {
        _setFlags(v8Flags);
        initialized = true;
      }
      paramString2 = new V8(???, paramBoolean);
    }
    synchronized (lock)
    {
      runtimeCounter += 1;
      return paramString2;
      ??? = finally;
      throw ???;
    }
  }
  
  public static int getActiveRuntimes()
  {
    return runtimeCounter;
  }
  
  private Object[] getArgs(V8Object paramV8Object, V8.MethodDescriptor paramMethodDescriptor, V8Array paramV8Array, boolean paramBoolean)
  {
    int j = paramMethodDescriptor.method.getParameterTypes().length;
    if (paramBoolean) {}
    for (int i = j - 1;; i = j)
    {
      paramV8Object = setDefaultValues(new Object[j], paramMethodDescriptor.method.getParameterTypes(), paramV8Object, paramMethodDescriptor.includeReceiver);
      ArrayList localArrayList = new ArrayList();
      populateParamters(paramV8Array, i, paramV8Object, localArrayList, paramMethodDescriptor.includeReceiver);
      if (paramBoolean)
      {
        paramMethodDescriptor = getVarArgContainer(paramMethodDescriptor.method.getParameterTypes(), localArrayList.size());
        System.arraycopy(localArrayList.toArray(), 0, paramMethodDescriptor, 0, localArrayList.size());
        paramV8Object[i] = paramMethodDescriptor;
      }
      return paramV8Object;
    }
  }
  
  private Object getArrayItem(V8Array paramV8Array, int paramInt)
  {
    try
    {
      switch (paramV8Array.getType(paramInt))
      {
      case 1: 
        return Integer.valueOf(paramV8Array.getInteger(paramInt));
      }
    }
    catch (V8ResultUndefined paramV8Array) {}
    return Double.valueOf(paramV8Array.getDouble(paramInt));
    return Boolean.valueOf(paramV8Array.getBoolean(paramInt));
    return paramV8Array.getString(paramInt);
    return paramV8Array.getArray(paramInt);
    return paramV8Array.getObject(paramInt);
    return paramV8Array.getObject(paramInt);
    return paramV8Array.get(paramInt);
    paramV8Array = getUndefined();
    return paramV8Array;
    return null;
  }
  
  private Object getDefaultValue(Class<?> paramClass)
  {
    if (paramClass.equals(V8Object.class)) {
      return new V8Object.Undefined();
    }
    if (paramClass.equals(V8Array.class)) {
      return new V8Array.Undefined();
    }
    return invalid;
  }
  
  public static String getSCMRevision()
  {
    return "Unknown revision ID";
  }
  
  public static V8Value getUndefined()
  {
    return undefined;
  }
  
  public static String getV8Version()
  {
    return _getVersion();
  }
  
  private Object getVarArgContainer(Class<?>[] paramArrayOfClass, int paramInt)
  {
    Class<?> localClass = paramArrayOfClass[(paramArrayOfClass.length - 1)];
    paramArrayOfClass = localClass;
    if (localClass.isArray()) {
      paramArrayOfClass = localClass.getComponentType();
    }
    return Array.newInstance(paramArrayOfClass, paramInt);
  }
  
  public static boolean isLoaded()
  {
    return nativeLibraryLoaded;
  }
  
  private boolean isVoidMethod(Method paramMethod)
  {
    return paramMethod.getReturnType().equals(Void.TYPE);
  }
  
  /* Error */
  private static void load(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 509	com/eclipsesource/v8/LibraryLoader:loadLibrary	(Ljava/lang/String;)V
    //   7: iconst_1
    //   8: putstatic 63	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: aload_0
    //   17: putstatic 65	com/eclipsesource/v8/V8:nativeLoadError	Ljava/lang/Error;
    //   20: goto -9 -> 11
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    //   29: astore_0
    //   30: aload_0
    //   31: putstatic 67	com/eclipsesource/v8/V8:nativeLoadException	Ljava/lang/Exception;
    //   34: goto -23 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	11	15	java/lang/Error
    //   3	11	23	finally
    //   16	20	23	finally
    //   30	34	23	finally
    //   3	11	29	java/lang/Exception
  }
  
  private void notifyReferenceCreated(V8Value paramV8Value)
  {
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleCreated(paramV8Value);
    }
  }
  
  private void notifyReferenceDisposed(V8Value paramV8Value)
  {
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleDisposed(paramV8Value);
    }
  }
  
  private void notifyReleaseHandlers(V8 paramV8)
  {
    Iterator localIterator = this.releaseHandlers.iterator();
    while (localIterator.hasNext()) {
      ((V8Runnable)localIterator.next()).run(paramV8);
    }
  }
  
  private void populateParamters(V8Array paramV8Array, int paramInt, Object[] paramArrayOfObject, List<Object> paramList, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      i = 1;
    }
    int j = i;
    if (j < paramV8Array.length() + i)
    {
      if (j >= paramInt) {
        paramList.add(getArrayItem(paramV8Array, j - i));
      }
      for (;;)
      {
        j += 1;
        break;
        paramArrayOfObject[j] = getArrayItem(paramV8Array, j - i);
      }
    }
  }
  
  private void releaseArguments(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[(paramArrayOfObject.length - 1)] instanceof Object[])))
    {
      localObject1 = (Object[])paramArrayOfObject[(paramArrayOfObject.length - 1)];
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof V8Value)) {
          ((V8Value)localObject2).release();
        }
        i += 1;
      }
    }
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = paramArrayOfObject[i];
      if ((localObject1 instanceof V8Value)) {
        ((V8Value)localObject1).release();
      }
      i += 1;
    }
  }
  
  private void releaseNativeMethodDescriptors()
  {
    Iterator localIterator = this.functionRegistry.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      releaseMethodDescriptor(this.v8RuntimePtr, localLong.longValue());
    }
  }
  
  private void releaseResources()
  {
    if (this.resources != null)
    {
      Iterator localIterator = this.resources.iterator();
      while (localIterator.hasNext()) {
        ((Releasable)localIterator.next()).release();
      }
      this.resources.clear();
      this.resources = null;
    }
  }
  
  private Object[] setDefaultValues(Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, V8Object paramV8Object, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1;
      paramArrayOfObject[0] = paramV8Object;
    }
    for (;;)
    {
      if (i < paramArrayOfObject.length)
      {
        paramArrayOfObject[i] = getDefaultValue(paramArrayOfClass[i]);
        i += 1;
      }
      else
      {
        return paramArrayOfObject;
        i = 0;
      }
    }
  }
  
  public static void setFlags(String paramString)
  {
    v8Flags = paramString;
    initialized = false;
  }
  
  protected void acquireLock(long paramLong)
  {
    _acquireLock(paramLong);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, double paramDouble)
  {
    _add(paramLong1, paramLong2, paramString, paramDouble);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    _add(paramLong1, paramLong2, paramString, paramInt);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    _add(paramLong1, paramLong2, paramString1, paramString2);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    _add(paramLong1, paramLong2, paramString, paramBoolean);
  }
  
  protected void addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    _addArrayBooleanItem(paramLong1, paramLong2, paramBoolean);
  }
  
  protected void addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble)
  {
    _addArrayDoubleItem(paramLong1, paramLong2, paramDouble);
  }
  
  protected void addArrayIntItem(long paramLong1, long paramLong2, int paramInt)
  {
    _addArrayIntItem(paramLong1, paramLong2, paramInt);
  }
  
  protected void addArrayNullItem(long paramLong1, long paramLong2)
  {
    _addArrayNullItem(paramLong1, paramLong2);
  }
  
  protected void addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3)
  {
    _addArrayObjectItem(paramLong1, paramLong2, paramLong3);
  }
  
  protected void addArrayStringItem(long paramLong1, long paramLong2, String paramString)
  {
    _addArrayStringItem(paramLong1, paramLong2, paramString);
  }
  
  protected void addArrayUndefinedItem(long paramLong1, long paramLong2)
  {
    _addArrayUndefinedItem(paramLong1, paramLong2);
  }
  
  protected void addNull(long paramLong1, long paramLong2, String paramString)
  {
    _addNull(paramLong1, paramLong2, paramString);
  }
  
  void addObjRef(V8Value paramV8Value)
  {
    this.objectReferences += 1L;
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceCreated(paramV8Value);
    }
  }
  
  protected void addObject(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    _addObject(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  public void addReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    this.referenceHandlers.add(0, paramReferenceHandler);
  }
  
  public void addReleaseHandler(V8Runnable paramV8Runnable)
  {
    this.releaseHandlers.add(paramV8Runnable);
  }
  
  protected void addUndefined(long paramLong1, long paramLong2, String paramString)
  {
    _addUndefined(paramLong1, paramLong2, paramString);
  }
  
  protected Object arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    return _arrayGet(paramLong1, paramInt1, paramLong2, paramInt2);
  }
  
  protected boolean arrayGetBoolean(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetBoolean(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    return _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfBoolean);
  }
  
  protected boolean[] arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected byte arrayGetByte(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetByte(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  protected byte[] arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected double arrayGetDouble(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetDouble(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    return _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfDouble);
  }
  
  protected double[] arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int arrayGetInteger(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetInteger(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    return _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  protected int[] arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int arrayGetSize(long paramLong1, long paramLong2)
  {
    return _arrayGetSize(paramLong1, paramLong2);
  }
  
  protected String arrayGetString(long paramLong1, long paramLong2, int paramInt)
  {
    return _arrayGetString(paramLong1, paramLong2, paramInt);
  }
  
  protected int arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    return _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfString);
  }
  
  protected String[] arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  /* Error */
  protected Object callObjectJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   4: lload_1
    //   5: invokestatic 695	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: invokeinterface 697 2 0
    //   13: checkcast 6	com/eclipsesource/v8/V8$MethodDescriptor
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 701	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   23: ifnull +21 -> 44
    //   26: aload_0
    //   27: aload 6
    //   29: getfield 701	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   32: aload_3
    //   33: aload 4
    //   35: invokeinterface 707 3 0
    //   40: invokespecial 709	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload 6
    //   46: getfield 370	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   49: invokevirtual 712	java/lang/reflect/Method:isVarArgs	()Z
    //   52: istore 5
    //   54: aload_0
    //   55: aload_3
    //   56: aload 6
    //   58: aload 4
    //   60: iload 5
    //   62: invokespecial 714	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   65: astore_3
    //   66: aload_0
    //   67: aload_3
    //   68: invokespecial 716	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   71: aload_0
    //   72: aload 6
    //   74: getfield 370	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   77: aload 6
    //   79: getfield 719	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   82: aload_3
    //   83: invokevirtual 722	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   86: invokespecial 709	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: astore 4
    //   91: aload_0
    //   92: aload_3
    //   93: iload 5
    //   95: invokespecial 724	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   98: aload 4
    //   100: areturn
    //   101: astore 4
    //   103: aload 4
    //   105: invokevirtual 728	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   108: athrow
    //   109: astore 4
    //   111: aload_0
    //   112: aload_3
    //   113: iload 5
    //   115: invokespecial 724	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   118: aload 4
    //   120: athrow
    //   121: astore 4
    //   123: aload 4
    //   125: athrow
    //   126: astore 4
    //   128: aload 4
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	V8
    //   0	131	1	paramLong	long
    //   0	131	3	paramV8Object	V8Object
    //   0	131	4	paramV8Array	V8Array
    //   52	62	5	bool	boolean
    //   16	62	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   71	91	101	java/lang/reflect/InvocationTargetException
    //   71	91	109	finally
    //   103	109	109	finally
    //   123	126	109	finally
    //   128	131	109	finally
    //   71	91	121	java/lang/IllegalAccessException
    //   71	91	126	java/lang/IllegalArgumentException
  }
  
  /* Error */
  protected void callVoidJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   4: lload_1
    //   5: invokestatic 695	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: invokeinterface 697 2 0
    //   13: checkcast 6	com/eclipsesource/v8/V8$MethodDescriptor
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 734	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   23: ifnull +17 -> 40
    //   26: aload 6
    //   28: getfield 734	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   31: aload_3
    //   32: aload 4
    //   34: invokeinterface 739 3 0
    //   39: return
    //   40: aload 6
    //   42: getfield 370	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   45: invokevirtual 712	java/lang/reflect/Method:isVarArgs	()Z
    //   48: istore 5
    //   50: aload_0
    //   51: aload_3
    //   52: aload 6
    //   54: aload 4
    //   56: iload 5
    //   58: invokespecial 714	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   61: astore_3
    //   62: aload_0
    //   63: aload_3
    //   64: invokespecial 716	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   67: aload 6
    //   69: getfield 370	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   72: aload 6
    //   74: getfield 719	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   77: aload_3
    //   78: invokevirtual 722	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: iload 5
    //   86: invokespecial 724	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   89: return
    //   90: astore 4
    //   92: aload 4
    //   94: invokevirtual 728	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   97: athrow
    //   98: astore 4
    //   100: aload_0
    //   101: aload_3
    //   102: iload 5
    //   104: invokespecial 724	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   107: aload 4
    //   109: athrow
    //   110: astore 4
    //   112: aload 4
    //   114: athrow
    //   115: astore 4
    //   117: aload 4
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	V8
    //   0	120	1	paramLong	long
    //   0	120	3	paramV8Object	V8Object
    //   0	120	4	paramV8Array	V8Array
    //   48	55	5	bool	boolean
    //   16	57	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   67	82	90	java/lang/reflect/InvocationTargetException
    //   67	82	98	finally
    //   92	98	98	finally
    //   112	115	98	finally
    //   117	120	98	finally
    //   67	82	110	java/lang/IllegalAccessException
    //   67	82	115	java/lang/IllegalArgumentException
  }
  
  void checkRuntime(V8Value paramV8Value)
  {
    if ((paramV8Value == null) || (paramV8Value.isUndefined())) {}
    do
    {
      return;
      paramV8Value = paramV8Value.getRuntime();
    } while ((paramV8Value != null) && (!paramV8Value.isReleased()) && (paramV8Value == this));
    throw new Error("Invalid target runtime");
  }
  
  void checkThread()
  {
    this.locker.checkThread();
    if (isReleased()) {
      throw new Error("Runtime disposed error");
    }
  }
  
  protected boolean contains(long paramLong1, long paramLong2, String paramString)
  {
    return _contains(paramLong1, paramLong2, paramString);
  }
  
  void createAndRegisterMethodDescriptor(JavaCallback paramJavaCallback, long paramLong)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.callback = paramJavaCallback;
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  void createNodeRuntime(String paramString)
  {
    _startNodeJS(this.v8RuntimePtr, paramString);
  }
  
  protected void createTwin(long paramLong1, long paramLong2, long paramLong3)
  {
    _createTwin(paramLong1, paramLong2, paramLong3);
  }
  
  protected void createTwin(V8Value paramV8Value1, V8Value paramV8Value2)
  {
    checkThread();
    createTwin(this.v8RuntimePtr, paramV8Value1.getHandle(), paramV8Value2.getHandle());
  }
  
  protected ByteBuffer createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt)
  {
    return _createV8ArrayBufferBackingStore(paramLong1, paramLong2, paramInt);
  }
  
  protected long createV8Context(int paramInt)
  {
    return _createContext(this.v8RuntimePtr, paramInt);
  }
  
  protected void disposeMethodID(long paramLong)
  {
    this.functionRegistry.remove(Long.valueOf(paramLong));
  }
  
  protected boolean equals(long paramLong1, long paramLong2, long paramLong3)
  {
    return _equals(paramLong1, paramLong2, paramLong3);
  }
  
  public V8Array executeArrayScript(String paramString)
  {
    return executeArrayScript(paramString, null, 0);
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt);
    if ((paramString1 instanceof V8Array)) {
      return (V8Array)paramString1;
    }
    throw new V8ResultUndefined();
  }
  
  protected boolean executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeBooleanFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected boolean executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeBooleanScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public boolean executeBooleanScript(String paramString)
  {
    return executeBooleanScript(paramString, null, 0);
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeBooleanScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected double executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeDoubleFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected double executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeDoubleScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public double executeDoubleScript(String paramString)
  {
    return executeDoubleScript(paramString, null, 0);
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeDoubleScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected Object executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3)
  {
    return _executeFunction(paramLong1, paramInt, paramLong2, paramString, paramLong3);
  }
  
  protected Object executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return _executeFunction(paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  protected int executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeIntegerFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected int executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeIntegerScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public int executeIntegerScript(String paramString)
  {
    return executeIntegerScript(paramString, null, 0);
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeIntegerScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  public V8Object executeObjectScript(String paramString)
  {
    return executeObjectScript(paramString, null, 0);
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt);
    if ((paramString1 instanceof V8Object)) {
      return (V8Object)paramString1;
    }
    throw new V8ResultUndefined();
  }
  
  protected Object executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    return _executeScript(paramLong, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public Object executeScript(String paramString)
  {
    return executeScript(paramString, null, 0);
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeScript(getV8RuntimePtr(), 0, paramString1, paramString2, paramInt);
  }
  
  protected String executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return _executeStringFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected String executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    return _executeStringScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public String executeStringScript(String paramString)
  {
    return executeStringScript(paramString, null, 0);
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    return executeStringScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected void executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    _executeVoidFunction(paramLong1, paramLong2, paramString, paramLong3);
  }
  
  protected void executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    _executeVoidScript(paramLong, paramString1, paramString2, paramInt);
  }
  
  public void executeVoidScript(String paramString)
  {
    executeVoidScript(paramString, null, 0);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    checkThread();
    checkScript(paramString1);
    executeVoidScript(this.v8RuntimePtr, paramString1, paramString2, paramInt);
  }
  
  protected Object get(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    return _get(paramLong1, paramInt, paramLong2, paramString);
  }
  
  protected int getArrayType(long paramLong1, long paramLong2)
  {
    return _getArrayType(paramLong1, paramLong2);
  }
  
  protected boolean getBoolean(long paramLong1, long paramLong2, String paramString)
  {
    return _getBoolean(paramLong1, paramLong2, paramString);
  }
  
  public long getBuildID()
  {
    return _getBuildID();
  }
  
  public Object getData(String paramString)
  {
    if (this.data == null) {
      return null;
    }
    return this.data.get(paramString);
  }
  
  protected double getDouble(long paramLong1, long paramLong2, String paramString)
  {
    return _getDouble(paramLong1, paramLong2, paramString);
  }
  
  public V8Executor getExecutor(V8Object paramV8Object)
  {
    checkThread();
    if (this.executors == null) {
      return null;
    }
    return (V8Executor)this.executors.get(paramV8Object);
  }
  
  protected long getGlobalObject()
  {
    return _getGlobalObject(this.v8RuntimePtr);
  }
  
  protected int getInteger(long paramLong1, long paramLong2, String paramString)
  {
    return _getInteger(paramLong1, paramLong2, paramString);
  }
  
  protected long getIsolatePtr()
  {
    return _getIsolatePtr(this.v8RuntimePtr);
  }
  
  protected String[] getKeys(long paramLong1, long paramLong2)
  {
    return _getKeys(paramLong1, paramLong2);
  }
  
  public V8Locker getLocker()
  {
    return this.locker;
  }
  
  public long getObjectReferenceCount()
  {
    return this.objectReferences - this.v8WeakReferences.size();
  }
  
  protected String getString(long paramLong1, long paramLong2, String paramString)
  {
    return _getString(paramLong1, paramLong2, paramString);
  }
  
  protected int getType(long paramLong1, long paramLong2)
  {
    return _getType(paramLong1, paramLong2);
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt)
  {
    return _getType(paramLong1, paramLong2, paramInt);
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _getType(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected int getType(long paramLong1, long paramLong2, String paramString)
  {
    return _getType(paramLong1, paramLong2, paramString);
  }
  
  protected long getV8RuntimePtr()
  {
    return this.v8RuntimePtr;
  }
  
  protected int identityHash(long paramLong1, long paramLong2)
  {
    return _identityHash(paramLong1, paramLong2);
  }
  
  protected long initNewV8Array(long paramLong)
  {
    return _initNewV8Array(paramLong);
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, int paramInt)
  {
    return _initNewV8ArrayBuffer(paramLong, paramInt);
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    return _initNewV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
  }
  
  public long initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Float32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Float64Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected long[] initNewV8Function(long paramLong)
  {
    checkThread();
    return _initNewV8Function(paramLong);
  }
  
  public long initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int16Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8Int8Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  protected long initNewV8Object(long paramLong)
  {
    return _initNewV8Object(paramLong);
  }
  
  public long initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt16Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt32Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt8Array(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public long initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return _initNewV8UInt8ClampedArray(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  boolean isRunning()
  {
    return _isRunning(this.v8RuntimePtr);
  }
  
  protected boolean isWeak(long paramLong1, long paramLong2)
  {
    return _isWeak(paramLong1, paramLong2);
  }
  
  public void lowMemoryNotification()
  {
    checkThread();
    lowMemoryNotification(getV8RuntimePtr());
  }
  
  protected void lowMemoryNotification(long paramLong)
  {
    _lowMemoryNotification(paramLong);
  }
  
  boolean pumpMessageLoop()
  {
    return _pumpMessageLoop(this.v8RuntimePtr);
  }
  
  void registerCallback(JavaCallback paramJavaCallback, long paramLong, String paramString)
  {
    createAndRegisterMethodDescriptor(paramJavaCallback, registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, false));
  }
  
  void registerCallback(Object paramObject, Method paramMethod, long paramLong, String paramString, boolean paramBoolean)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.object = paramObject;
    localMethodDescriptor.method = paramMethod;
    localMethodDescriptor.includeReceiver = paramBoolean;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, isVoidMethod(paramMethod));
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  protected long registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    return _registerJavaMethod(paramLong1, paramLong2, paramString, paramBoolean);
  }
  
  public void registerResource(Releasable paramReleasable)
  {
    checkThread();
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(paramReleasable);
  }
  
  public void registerV8Executor(V8Object paramV8Object, V8Executor paramV8Executor)
  {
    checkThread();
    if (this.executors == null) {
      this.executors = new V8Map();
    }
    this.executors.put(paramV8Object, paramV8Executor);
  }
  
  void registerVoidCallback(JavaVoidCallback paramJavaVoidCallback, long paramLong, String paramString)
  {
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.voidCallback = paramJavaVoidCallback;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, true);
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
  }
  
  public void release()
  {
    release(true);
  }
  
  protected void release(long paramLong1, long paramLong2)
  {
    _release(paramLong1, paramLong2);
  }
  
  /* Error */
  public void release(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 747	com/eclipsesource/v8/V8:isReleased	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 122	com/eclipsesource/v8/V8:checkThread	()V
    //   12: aload_0
    //   13: aload_0
    //   14: invokespecial 1009	com/eclipsesource/v8/V8:notifyReleaseHandlers	(Lcom/eclipsesource/v8/V8;)V
    //   17: aload_0
    //   18: invokespecial 1011	com/eclipsesource/v8/V8:releaseResources	()V
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 98	com/eclipsesource/v8/V8:forceTerminateExecutors	Z
    //   26: invokevirtual 1014	com/eclipsesource/v8/V8:shutdownExecutors	(Z)V
    //   29: aload_0
    //   30: getfield 96	com/eclipsesource/v8/V8:executors	Lcom/eclipsesource/v8/utils/V8Map;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 96	com/eclipsesource/v8/V8:executors	Lcom/eclipsesource/v8/utils/V8Map;
    //   40: invokevirtual 1015	com/eclipsesource/v8/utils/V8Map:clear	()V
    //   43: aload_0
    //   44: invokespecial 1017	com/eclipsesource/v8/V8:releaseNativeMethodDescriptors	()V
    //   47: getstatic 55	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   50: astore_2
    //   51: aload_2
    //   52: monitorenter
    //   53: getstatic 57	com/eclipsesource/v8/V8:runtimeCounter	I
    //   56: iconst_1
    //   57: isub
    //   58: putstatic 57	com/eclipsesource/v8/V8:runtimeCounter	I
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 92	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   68: invokespecial 1019	com/eclipsesource/v8/V8:_releaseRuntime	(J)V
    //   71: aload_0
    //   72: lconst_0
    //   73: putfield 92	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield 110	com/eclipsesource/v8/V8:released	Z
    //   81: iload_1
    //   82: ifeq -75 -> 7
    //   85: aload_0
    //   86: invokevirtual 1021	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifle -84 -> 7
    //   94: new 287	java/lang/IllegalStateException
    //   97: dup
    //   98: new 326	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 1022	java/lang/StringBuilder:<init>	()V
    //   105: aload_0
    //   106: getfield 90	com/eclipsesource/v8/V8:objectReferences	J
    //   109: invokevirtual 1025	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc_w 1027
    //   115: invokevirtual 1030	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 293	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: astore_3
    //   126: aload_2
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore_3
    //   131: aload_0
    //   132: invokespecial 1011	com/eclipsesource/v8/V8:releaseResources	()V
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 98	com/eclipsesource/v8/V8:forceTerminateExecutors	Z
    //   140: invokevirtual 1014	com/eclipsesource/v8/V8:shutdownExecutors	(Z)V
    //   143: aload_0
    //   144: getfield 96	com/eclipsesource/v8/V8:executors	Lcom/eclipsesource/v8/utils/V8Map;
    //   147: ifnull +10 -> 157
    //   150: aload_0
    //   151: getfield 96	com/eclipsesource/v8/V8:executors	Lcom/eclipsesource/v8/utils/V8Map;
    //   154: invokevirtual 1015	com/eclipsesource/v8/utils/V8Map:clear	()V
    //   157: aload_0
    //   158: invokespecial 1017	com/eclipsesource/v8/V8:releaseNativeMethodDescriptors	()V
    //   161: getstatic 55	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   164: astore_2
    //   165: aload_2
    //   166: monitorenter
    //   167: getstatic 57	com/eclipsesource/v8/V8:runtimeCounter	I
    //   170: iconst_1
    //   171: isub
    //   172: putstatic 57	com/eclipsesource/v8/V8:runtimeCounter	I
    //   175: aload_2
    //   176: monitorexit
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 92	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   182: invokespecial 1019	com/eclipsesource/v8/V8:_releaseRuntime	(J)V
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 92	com/eclipsesource/v8/V8:v8RuntimePtr	J
    //   190: aload_0
    //   191: iconst_1
    //   192: putfield 110	com/eclipsesource/v8/V8:released	Z
    //   195: iload_1
    //   196: ifeq +48 -> 244
    //   199: aload_0
    //   200: invokevirtual 1021	com/eclipsesource/v8/V8:getObjectReferenceCount	()J
    //   203: lconst_0
    //   204: lcmp
    //   205: ifle +39 -> 244
    //   208: new 287	java/lang/IllegalStateException
    //   211: dup
    //   212: new 326	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 1022	java/lang/StringBuilder:<init>	()V
    //   219: aload_0
    //   220: getfield 90	com/eclipsesource/v8/V8:objectReferences	J
    //   223: invokevirtual 1025	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: ldc_w 1027
    //   229: invokevirtual 1030	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 293	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   238: athrow
    //   239: astore_3
    //   240: aload_2
    //   241: monitorexit
    //   242: aload_3
    //   243: athrow
    //   244: aload_3
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	V8
    //   0	246	1	paramBoolean	boolean
    //   125	4	3	localObject2	Object
    //   130	1	3	localObject3	Object
    //   239	6	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	125	finally
    //   126	128	125	finally
    //   12	17	130	finally
    //   167	177	239	finally
    //   240	242	239	finally
  }
  
  protected void releaseLock(long paramLong)
  {
    _releaseLock(paramLong);
  }
  
  protected void releaseMethodDescriptor(long paramLong1, long paramLong2)
  {
    _releaseMethodDescriptor(paramLong1, paramLong2);
  }
  
  void releaseObjRef(V8Value paramV8Value)
  {
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceDisposed(paramV8Value);
    }
    this.objectReferences -= 1L;
  }
  
  protected void releaseV8Context(long paramLong)
  {
    _releaseContext(this.v8RuntimePtr, paramLong);
  }
  
  public V8Executor removeExecutor(V8Object paramV8Object)
  {
    checkThread();
    if (this.executors == null) {
      return null;
    }
    return (V8Executor)this.executors.remove(paramV8Object);
  }
  
  public void removeReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    this.referenceHandlers.remove(paramReferenceHandler);
  }
  
  public void removeReleaseHandler(V8Runnable paramV8Runnable)
  {
    this.releaseHandlers.remove(paramV8Runnable);
  }
  
  protected boolean sameValue(long paramLong1, long paramLong2, long paramLong3)
  {
    return _sameValue(paramLong1, paramLong2, paramLong3);
  }
  
  public void setData(String paramString, Object paramObject)
  {
    try
    {
      if (this.data == null) {
        this.data = new HashMap();
      }
      this.data.put(paramString, paramObject);
      return;
    }
    finally {}
  }
  
  protected void setPrototype(long paramLong1, long paramLong2, long paramLong3)
  {
    _setPrototype(paramLong1, paramLong2, paramLong3);
  }
  
  protected void setWeak(long paramLong1, long paramLong2)
  {
    _setWeak(paramLong1, paramLong2);
  }
  
  public void shutdownExecutors(boolean paramBoolean)
  {
    checkThread();
    if (this.executors == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.executors.values().iterator();
      while (localIterator.hasNext())
      {
        V8Executor localV8Executor = (V8Executor)localIterator.next();
        if (paramBoolean) {
          localV8Executor.forceTermination();
        } else {
          localV8Executor.shutdown();
        }
      }
    }
  }
  
  protected boolean strictEquals(long paramLong1, long paramLong2, long paramLong3)
  {
    return _strictEquals(paramLong1, paramLong2, paramLong3);
  }
  
  protected void switchV8Context(long paramLong)
  {
    _switchContext(this.v8RuntimePtr, paramLong);
  }
  
  public void terminateExecution()
  {
    this.forceTerminateExecutors = true;
    terminateExecution(this.v8RuntimePtr);
  }
  
  protected void terminateExecution(long paramLong)
  {
    _terminateExecution(paramLong);
  }
  
  protected String toString(long paramLong1, long paramLong2)
  {
    return _toString(paramLong1, paramLong2);
  }
  
  protected void weakReferenceReleased(long paramLong)
  {
    V8Value localV8Value = (V8Value)this.v8WeakReferences.get(Long.valueOf(paramLong));
    if (localV8Value != null) {
      this.v8WeakReferences.remove(Long.valueOf(paramLong));
    }
    try
    {
      localV8Value.release();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.v8.V8
 * JD-Core Version:    0.7.0.1
 */