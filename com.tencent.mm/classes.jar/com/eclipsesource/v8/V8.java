package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static final int MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
  public static final int MEMORY_PRESSURE_LEVEL_MODERATE = 1;
  public static final int MEMORY_PRESSURE_LEVEL_NONE = 0;
  private static boolean initialized;
  private static Object invalid;
  private static Object lock;
  private static boolean nativeLibraryLoaded;
  private static Error nativeLoadError;
  private static Exception nativeLoadException;
  private static volatile int runtimeCounter;
  private static ILoadLibraryDelegate sLoadLibraryDelegate;
  private static V8Value undefined;
  private static String v8Flags;
  private Map<String, Object> data;
  private V8Map<V8Executor> executors;
  private boolean forceTerminateExecutors;
  private Map<Long, V8.MethodDescriptor> functionRegistry;
  private final V8Locker locker;
  private long objectReferences;
  private LinkedList<ReferenceHandler> referenceHandlers;
  private LinkedList<V8Runnable> releaseHandlers;
  private List<Releasable> resources;
  private long v8RuntimePtr;
  protected Map<Long, V8Value> v8WeakReferences;
  
  static
  {
    AppMethodBeat.i(75343);
    lock = new Object();
    runtimeCounter = 0;
    v8Flags = null;
    initialized = false;
    nativeLibraryLoaded = false;
    nativeLoadError = null;
    nativeLoadException = null;
    undefined = new V8Object.Undefined();
    invalid = new Object();
    sLoadLibraryDelegate = new V8.1();
    AppMethodBeat.o(75343);
  }
  
  protected V8()
  {
    this(null, true);
  }
  
  protected V8(String paramString, boolean paramBoolean)
  {
    super(null);
    AppMethodBeat.i(75182);
    this.v8WeakReferences = new HashMap();
    this.data = null;
    this.objectReferences = 0L;
    this.v8RuntimePtr = 0L;
    this.resources = null;
    this.executors = null;
    this.forceTerminateExecutors = false;
    this.functionRegistry = new HashMap();
    this.referenceHandlers = new LinkedList();
    this.releaseHandlers = new LinkedList();
    this.released = false;
    this.v8RuntimePtr = _createIsolate(paramString, paramBoolean);
    this.locker = new V8Locker(this);
    checkThread();
    if (paramBoolean) {
      this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }
    AppMethodBeat.o(75182);
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
  
  private native void _closeUVLoop(long paramLong);
  
  private native boolean _contains(long paramLong1, long paramLong2, String paramString);
  
  private native long _createContext(long paramLong, int paramInt);
  
  private native long _createIsolate(String paramString, boolean paramBoolean);
  
  private native void _createTwin(long paramLong1, long paramLong2, long paramLong3);
  
  private native ByteBuffer _createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt);
  
  private static native void _debugMessageLoop(long paramLong);
  
  private native boolean _equals(long paramLong1, long paramLong2, long paramLong3);
  
  private native boolean _executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native boolean _executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  private static native String _executeDebugScript(long paramLong, String paramString1, String paramString2);
  
  private native double _executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native double _executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  private native Object _executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3);
  
  private native Object _executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private native int _executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native int _executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  private native Object _executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4);
  
  private native String _executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native String _executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  private native void _executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
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
  
  private native long _initNewSharedV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
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
  
  private native void _memoryPressureNotification(long paramLong, int paramInt);
  
  private static native boolean _pumpMessageLoop(long paramLong);
  
  private native long _registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean);
  
  private native void _release(long paramLong1, long paramLong2);
  
  private native void _releaseContext(long paramLong1, long paramLong2);
  
  private native void _releaseLock(long paramLong);
  
  private native void _releaseMethodDescriptor(long paramLong1, long paramLong2);
  
  private native void _releaseRuntime(long paramLong);
  
  private native boolean _sameValue(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void _setCodeCacheDir(String paramString);
  
  private static native void _setFlags(String paramString);
  
  private native void _setPrototype(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void _setSnapshotBlob(byte[] paramArrayOfByte);
  
  private native void _setWeak(long paramLong1, long paramLong2);
  
  private static native void _startNodeJS(long paramLong, String paramString);
  
  private native boolean _strictEquals(long paramLong1, long paramLong2, long paramLong3);
  
  private native void _switchContext(long paramLong1, long paramLong2);
  
  private native void _terminateExecution(long paramLong);
  
  private native String _toString(long paramLong1, long paramLong2);
  
  private static native void _waitForDebuger(long paramLong, String paramString);
  
  private native void _wakeUpUVLoop(long paramLong);
  
  private void checkArgs(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(75237);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == invalid)
      {
        paramArrayOfObject = new IllegalArgumentException("argument type mismatch");
        AppMethodBeat.o(75237);
        throw paramArrayOfObject;
      }
      i += 1;
    }
    AppMethodBeat.o(75237);
  }
  
  private static void checkNativeLibraryLoaded()
  {
    AppMethodBeat.i(75181);
    if (!nativeLibraryLoaded)
    {
      if (nativeLoadError != null)
      {
        localIllegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
        AppMethodBeat.o(75181);
        throw localIllegalStateException;
      }
      if (nativeLoadException != null)
      {
        localIllegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
        AppMethodBeat.o(75181);
        throw localIllegalStateException;
      }
      IllegalStateException localIllegalStateException = new IllegalStateException("J2V8 native library not loaded");
      AppMethodBeat.o(75181);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(75181);
  }
  
  private Object checkResult(Object paramObject)
  {
    AppMethodBeat.i(75235);
    if (paramObject == null)
    {
      AppMethodBeat.o(75235);
      return paramObject;
    }
    if ((paramObject instanceof Float))
    {
      double d = ((Float)paramObject).doubleValue();
      AppMethodBeat.o(75235);
      return Double.valueOf(d);
    }
    if (((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof String)))
    {
      AppMethodBeat.o(75235);
      return paramObject;
    }
    if ((paramObject instanceof V8Value))
    {
      if (((V8Value)paramObject).isReleased())
      {
        paramObject = new V8RuntimeException("V8Value already released");
        AppMethodBeat.o(75235);
        throw paramObject;
      }
      AppMethodBeat.o(75235);
      return paramObject;
    }
    paramObject = new V8RuntimeException("Unknown return type: " + paramObject.getClass());
    AppMethodBeat.o(75235);
    throw paramObject;
  }
  
  static void checkScript(String paramString)
  {
    AppMethodBeat.i(75225);
    if (paramString == null)
    {
      paramString = new NullPointerException("Script is null");
      AppMethodBeat.o(75225);
      throw paramString;
    }
    AppMethodBeat.o(75225);
  }
  
  public static V8 createV8Runtime()
  {
    AppMethodBeat.i(75162);
    V8 localV8 = createV8Runtime(null, null);
    AppMethodBeat.o(75162);
    return localV8;
  }
  
  public static V8 createV8Runtime(String paramString)
  {
    AppMethodBeat.i(75163);
    paramString = createV8Runtime(paramString, null);
    AppMethodBeat.o(75163);
    return paramString;
  }
  
  public static V8 createV8Runtime(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75164);
    paramString1 = createV8Runtime(paramString1, paramString2, true, null, null);
    AppMethodBeat.o(75164);
    return paramString1;
  }
  
  protected static V8 createV8Runtime(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(75165);
    paramString1 = createV8Runtime(paramString1, paramString2, paramBoolean, null, null);
    AppMethodBeat.o(75165);
    return paramString1;
  }
  
  /* Error */
  protected static V8 createV8Runtime(String arg0, String paramString2, boolean paramBoolean, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 401
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 78	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   9: ifne +24 -> 33
    //   12: getstatic 70	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   15: astore 5
    //   17: aload 5
    //   19: monitorenter
    //   20: getstatic 78	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   23: ifne +7 -> 30
    //   26: aload_1
    //   27: invokestatic 404	com/eclipsesource/v8/V8:load	(Ljava/lang/String;)V
    //   30: aload 5
    //   32: monitorexit
    //   33: invokestatic 406	com/eclipsesource/v8/V8:checkNativeLibraryLoaded	()V
    //   36: getstatic 76	com/eclipsesource/v8/V8:initialized	Z
    //   39: ifne +39 -> 78
    //   42: getstatic 74	com/eclipsesource/v8/V8:v8Flags	Ljava/lang/String;
    //   45: invokestatic 408	com/eclipsesource/v8/V8:_setFlags	(Ljava/lang/String;)V
    //   48: getstatic 70	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   51: astore_1
    //   52: aload_1
    //   53: monitorenter
    //   54: aload_3
    //   55: ifnull +7 -> 62
    //   58: aload_3
    //   59: invokestatic 410	com/eclipsesource/v8/V8:_setCodeCacheDir	(Ljava/lang/String;)V
    //   62: aload 4
    //   64: ifnull +8 -> 72
    //   67: aload 4
    //   69: invokestatic 412	com/eclipsesource/v8/V8:_setSnapshotBlob	([B)V
    //   72: aload_1
    //   73: monitorexit
    //   74: iconst_1
    //   75: putstatic 76	com/eclipsesource/v8/V8:initialized	Z
    //   78: new 2	com/eclipsesource/v8/V8
    //   81: dup
    //   82: aload_0
    //   83: iload_2
    //   84: invokespecial 101	com/eclipsesource/v8/V8:<init>	(Ljava/lang/String;Z)V
    //   87: astore_1
    //   88: getstatic 70	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   91: astore_0
    //   92: aload_0
    //   93: monitorenter
    //   94: getstatic 72	com/eclipsesource/v8/V8:runtimeCounter	I
    //   97: iconst_1
    //   98: iadd
    //   99: putstatic 72	com/eclipsesource/v8/V8:runtimeCounter	I
    //   102: aload_0
    //   103: monitorexit
    //   104: ldc_w 401
    //   107: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: areturn
    //   112: astore_0
    //   113: aload 5
    //   115: monitorexit
    //   116: ldc_w 401
    //   119: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: aload_1
    //   126: monitorexit
    //   127: ldc_w 401
    //   130: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: ldc_w 401
    //   141: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	1	paramString2	String
    //   0	146	2	paramBoolean	boolean
    //   0	146	3	paramString3	String
    //   0	146	4	paramArrayOfByte	byte[]
    //   15	99	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	30	112	finally
    //   30	33	112	finally
    //   113	116	112	finally
    //   58	62	124	finally
    //   67	72	124	finally
    //   72	74	124	finally
    //   125	127	124	finally
    //   94	104	135	finally
    //   136	138	135	finally
  }
  
  public static int getActiveRuntimes()
  {
    return runtimeCounter;
  }
  
  private Object[] getArgs(V8Object paramV8Object, V8.MethodDescriptor paramMethodDescriptor, V8Array paramV8Array, boolean paramBoolean)
  {
    AppMethodBeat.i(75239);
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
      AppMethodBeat.o(75239);
      return paramV8Object;
    }
  }
  
  private Object getArrayItem(V8Array paramV8Array, int paramInt)
  {
    AppMethodBeat.i(75243);
    try
    {
      int i = paramV8Array.getType(paramInt);
      switch (i)
      {
      }
    }
    catch (V8ResultUndefined paramV8Array)
    {
      label104:
      double d;
      boolean bool;
      break label104;
    }
    AppMethodBeat.o(75243);
    return null;
    paramInt = paramV8Array.getInteger(paramInt);
    AppMethodBeat.o(75243);
    return Integer.valueOf(paramInt);
    d = paramV8Array.getDouble(paramInt);
    AppMethodBeat.o(75243);
    return Double.valueOf(d);
    bool = paramV8Array.getBoolean(paramInt);
    AppMethodBeat.o(75243);
    return Boolean.valueOf(bool);
    paramV8Array = paramV8Array.getString(paramInt);
    AppMethodBeat.o(75243);
    return paramV8Array;
    paramV8Array = paramV8Array.getArray(paramInt);
    AppMethodBeat.o(75243);
    return paramV8Array;
    paramV8Array = paramV8Array.getObject(paramInt);
    AppMethodBeat.o(75243);
    return paramV8Array;
    paramV8Array = paramV8Array.getObject(paramInt);
    AppMethodBeat.o(75243);
    return paramV8Array;
    paramV8Array = paramV8Array.get(paramInt);
    AppMethodBeat.o(75243);
    return paramV8Array;
    paramV8Array = getUndefined();
    AppMethodBeat.o(75243);
    return paramV8Array;
  }
  
  private Object getDefaultValue(Class<?> paramClass)
  {
    AppMethodBeat.i(75231);
    if (paramClass.equals(V8Object.class))
    {
      paramClass = new V8Object.Undefined();
      AppMethodBeat.o(75231);
      return paramClass;
    }
    if (paramClass.equals(V8Array.class))
    {
      paramClass = new V8Array.Undefined();
      AppMethodBeat.o(75231);
      return paramClass;
    }
    paramClass = invalid;
    AppMethodBeat.o(75231);
    return paramClass;
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
    AppMethodBeat.i(75184);
    String str = _getVersion();
    AppMethodBeat.o(75184);
    return str;
  }
  
  private Object getVarArgContainer(Class<?>[] paramArrayOfClass, int paramInt)
  {
    AppMethodBeat.i(75240);
    Class<?> localClass = paramArrayOfClass[(paramArrayOfClass.length - 1)];
    paramArrayOfClass = localClass;
    if (localClass.isArray()) {
      paramArrayOfClass = localClass.getComponentType();
    }
    paramArrayOfClass = Array.newInstance(paramArrayOfClass, paramInt);
    AppMethodBeat.o(75240);
    return paramArrayOfClass;
  }
  
  public static boolean isLoaded()
  {
    return nativeLibraryLoaded;
  }
  
  private boolean isVoidMethod(Method paramMethod)
  {
    AppMethodBeat.i(75230);
    if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      AppMethodBeat.o(75230);
      return true;
    }
    AppMethodBeat.o(75230);
    return false;
  }
  
  /* Error */
  private static void load(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 561
    //   6: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 94	com/eclipsesource/v8/V8:sLoadLibraryDelegate	Lcom/eclipsesource/v8/ILoadLibraryDelegate;
    //   12: aload_0
    //   13: invokeinterface 566 2 0
    //   18: iconst_1
    //   19: putstatic 78	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   22: ldc_w 561
    //   25: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: aload_0
    //   34: putstatic 80	com/eclipsesource/v8/V8:nativeLoadError	Ljava/lang/Error;
    //   37: ldc_w 561
    //   40: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -15 -> 28
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aload_0
    //   54: putstatic 82	com/eclipsesource/v8/V8:nativeLoadException	Ljava/lang/Exception;
    //   57: ldc_w 561
    //   60: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -35 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	22	32	java/lang/Error
    //   3	9	46	finally
    //   9	22	46	finally
    //   22	28	46	finally
    //   33	43	46	finally
    //   53	63	46	finally
    //   9	22	52	java/lang/Exception
  }
  
  private void notifyReferenceCreated(V8Value paramV8Value)
  {
    AppMethodBeat.i(75179);
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleCreated(paramV8Value);
    }
    AppMethodBeat.o(75179);
  }
  
  private void notifyReferenceDisposed(V8Value paramV8Value)
  {
    AppMethodBeat.i(75180);
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleDisposed(paramV8Value);
    }
    AppMethodBeat.o(75180);
  }
  
  private void notifyReleaseHandlers(V8 paramV8)
  {
    AppMethodBeat.i(75178);
    Iterator localIterator = this.releaseHandlers.iterator();
    while (localIterator.hasNext()) {
      ((V8Runnable)localIterator.next()).run(paramV8);
    }
    AppMethodBeat.o(75178);
  }
  
  private void populateParamters(V8Array paramV8Array, int paramInt, Object[] paramArrayOfObject, List<Object> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(75241);
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
    AppMethodBeat.o(75241);
  }
  
  private void releaseArguments(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    AppMethodBeat.i(75238);
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
    AppMethodBeat.o(75238);
  }
  
  private void releaseNativeMethodDescriptors()
  {
    AppMethodBeat.i(75188);
    Iterator localIterator = this.functionRegistry.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      releaseMethodDescriptor(this.v8RuntimePtr, localLong.longValue());
    }
    AppMethodBeat.o(75188);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(75189);
    if (this.resources != null)
    {
      Iterator localIterator = this.resources.iterator();
      while (localIterator.hasNext()) {
        ((Releasable)localIterator.next()).release();
      }
      this.resources.clear();
      this.resources = null;
    }
    AppMethodBeat.o(75189);
  }
  
  private Object[] setDefaultValues(Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, V8Object paramV8Object, boolean paramBoolean)
  {
    AppMethodBeat.i(75242);
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
        AppMethodBeat.o(75242);
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
  
  public static void setLoadLibraryDelegate(ILoadLibraryDelegate paramILoadLibraryDelegate)
  {
    AppMethodBeat.i(75339);
    if (paramILoadLibraryDelegate == null)
    {
      paramILoadLibraryDelegate = new IllegalArgumentException("setLoadLibraryDelegate: param delegate null");
      AppMethodBeat.o(75339);
      throw paramILoadLibraryDelegate;
    }
    sLoadLibraryDelegate = paramILoadLibraryDelegate;
    AppMethodBeat.o(75339);
  }
  
  protected void acquireLock(long paramLong)
  {
    AppMethodBeat.i(75249);
    _acquireLock(paramLong);
    AppMethodBeat.o(75249);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, double paramDouble)
  {
    AppMethodBeat.i(75284);
    _add(paramLong1, paramLong2, paramString, paramDouble);
    AppMethodBeat.o(75284);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    AppMethodBeat.i(75281);
    _add(paramLong1, paramLong2, paramString, paramInt);
    AppMethodBeat.o(75281);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(75285);
    _add(paramLong1, paramLong2, paramString1, paramString2);
    AppMethodBeat.o(75285);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(75283);
    _add(paramLong1, paramLong2, paramString, paramBoolean);
    AppMethodBeat.o(75283);
  }
  
  protected void addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(75312);
    _addArrayBooleanItem(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(75312);
  }
  
  protected void addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble)
  {
    AppMethodBeat.i(75313);
    _addArrayDoubleItem(paramLong1, paramLong2, paramDouble);
    AppMethodBeat.o(75313);
  }
  
  protected void addArrayIntItem(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75311);
    _addArrayIntItem(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75311);
  }
  
  protected void addArrayNullItem(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75317);
    _addArrayNullItem(paramLong1, paramLong2);
    AppMethodBeat.o(75317);
  }
  
  protected void addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75315);
    _addArrayObjectItem(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75315);
  }
  
  protected void addArrayStringItem(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75314);
    _addArrayStringItem(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75314);
  }
  
  protected void addArrayUndefinedItem(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75316);
    _addArrayUndefinedItem(paramLong1, paramLong2);
    AppMethodBeat.o(75316);
  }
  
  protected void addNull(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75287);
    _addNull(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75287);
  }
  
  void addObjRef(V8Value paramV8Value)
  {
    AppMethodBeat.i(75337);
    this.objectReferences += 1L;
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceCreated(paramV8Value);
    }
    AppMethodBeat.o(75337);
  }
  
  protected void addObject(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75282);
    _addObject(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75282);
  }
  
  public void addReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    AppMethodBeat.i(75172);
    this.referenceHandlers.add(0, paramReferenceHandler);
    AppMethodBeat.o(75172);
  }
  
  public void addReleaseHandler(V8Runnable paramV8Runnable)
  {
    AppMethodBeat.i(75173);
    this.releaseHandlers.add(paramV8Runnable);
    AppMethodBeat.o(75173);
  }
  
  protected void addUndefined(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75286);
    _addUndefined(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75286);
  }
  
  protected Object arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(75310);
    Object localObject = _arrayGet(paramLong1, paramInt1, paramLong2, paramInt2);
    AppMethodBeat.o(75310);
    return localObject;
  }
  
  protected boolean arrayGetBoolean(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75306);
    boolean bool = _arrayGetBoolean(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75306);
    return bool;
  }
  
  protected int arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(75331);
    paramInt1 = _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfBoolean);
    AppMethodBeat.o(75331);
    return paramInt1;
  }
  
  protected boolean[] arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75326);
    boolean[] arrayOfBoolean = _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75326);
    return arrayOfBoolean;
  }
  
  protected byte arrayGetByte(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75307);
    byte b = _arrayGetByte(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75307);
    return b;
  }
  
  protected int arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75332);
    paramInt1 = _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.o(75332);
    return paramInt1;
  }
  
  protected byte[] arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75327);
    byte[] arrayOfByte = _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75327);
    return arrayOfByte;
  }
  
  protected double arrayGetDouble(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75308);
    double d = _arrayGetDouble(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75308);
    return d;
  }
  
  protected int arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(75330);
    paramInt1 = _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfDouble);
    AppMethodBeat.o(75330);
    return paramInt1;
  }
  
  protected double[] arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75325);
    double[] arrayOfDouble = _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75325);
    return arrayOfDouble;
  }
  
  protected int arrayGetInteger(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75305);
    paramInt = _arrayGetInteger(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75305);
    return paramInt;
  }
  
  protected int arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(75329);
    paramInt1 = _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(75329);
    return paramInt1;
  }
  
  protected int[] arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75324);
    int[] arrayOfInt = _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75324);
    return arrayOfInt;
  }
  
  protected int arrayGetSize(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75304);
    int i = _arrayGetSize(paramLong1, paramLong2);
    AppMethodBeat.o(75304);
    return i;
  }
  
  protected String arrayGetString(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75309);
    String str = _arrayGetString(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75309);
    return str;
  }
  
  protected int arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75333);
    paramInt1 = _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfString);
    AppMethodBeat.o(75333);
    return paramInt1;
  }
  
  protected String[] arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75328);
    String[] arrayOfString = _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75328);
    return arrayOfString;
  }
  
  /* Error */
  protected Object callObjectJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: ldc_w 798
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 124	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   10: lload_1
    //   11: invokestatic 801	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokeinterface 803 2 0
    //   19: checkcast 6	com/eclipsesource/v8/V8$MethodDescriptor
    //   22: astore 6
    //   24: aload 6
    //   26: getfield 807	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   29: ifnull +29 -> 58
    //   32: aload_0
    //   33: aload 6
    //   35: getfield 807	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   38: aload_3
    //   39: aload 4
    //   41: invokeinterface 813 3 0
    //   46: invokespecial 815	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_3
    //   50: ldc_w 798
    //   53: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_3
    //   57: areturn
    //   58: aload 6
    //   60: getfield 421	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   63: invokevirtual 818	java/lang/reflect/Method:isVarArgs	()Z
    //   66: istore 5
    //   68: aload_0
    //   69: aload_3
    //   70: aload 6
    //   72: aload 4
    //   74: iload 5
    //   76: invokespecial 820	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   79: astore_3
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 822	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   85: aload_0
    //   86: aload 6
    //   88: getfield 421	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   91: aload 6
    //   93: getfield 825	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   96: aload_3
    //   97: invokevirtual 828	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: invokespecial 815	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 4
    //   105: aload_0
    //   106: aload_3
    //   107: iload 5
    //   109: invokespecial 830	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   112: ldc_w 798
    //   115: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload 4
    //   120: areturn
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 834	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   128: astore 4
    //   130: ldc_w 798
    //   133: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload 4
    //   138: athrow
    //   139: astore 4
    //   141: aload_0
    //   142: aload_3
    //   143: iload 5
    //   145: invokespecial 830	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   148: ldc_w 798
    //   151: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 4
    //   156: athrow
    //   157: astore 4
    //   159: ldc_w 798
    //   162: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 4
    //   167: athrow
    //   168: astore 4
    //   170: ldc_w 798
    //   173: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload 4
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	V8
    //   0	179	1	paramLong	long
    //   0	179	3	paramV8Object	V8Object
    //   0	179	4	paramV8Array	V8Array
    //   66	78	5	bool	boolean
    //   22	70	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   85	105	121	java/lang/reflect/InvocationTargetException
    //   85	105	139	finally
    //   123	139	139	finally
    //   159	168	139	finally
    //   170	179	139	finally
    //   85	105	157	java/lang/IllegalAccessException
    //   85	105	168	java/lang/IllegalArgumentException
  }
  
  /* Error */
  protected void callVoidJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: ldc_w 837
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 124	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   10: lload_1
    //   11: invokestatic 801	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokeinterface 803 2 0
    //   19: checkcast 6	com/eclipsesource/v8/V8$MethodDescriptor
    //   22: astore 6
    //   24: aload 6
    //   26: getfield 841	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   29: ifnull +23 -> 52
    //   32: aload 6
    //   34: getfield 841	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   37: aload_3
    //   38: aload 4
    //   40: invokeinterface 846 3 0
    //   45: ldc_w 837
    //   48: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: aload 6
    //   54: getfield 421	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   57: invokevirtual 818	java/lang/reflect/Method:isVarArgs	()Z
    //   60: istore 5
    //   62: aload_0
    //   63: aload_3
    //   64: aload 6
    //   66: aload 4
    //   68: iload 5
    //   70: invokespecial 820	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_3
    //   76: invokespecial 822	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   79: aload 6
    //   81: getfield 421	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   84: aload 6
    //   86: getfield 825	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   89: aload_3
    //   90: invokevirtual 828	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_0
    //   95: aload_3
    //   96: iload 5
    //   98: invokespecial 830	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   101: ldc_w 837
    //   104: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore 4
    //   110: aload 4
    //   112: invokevirtual 834	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   115: astore 4
    //   117: ldc_w 837
    //   120: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload 4
    //   125: athrow
    //   126: astore 4
    //   128: aload_0
    //   129: aload_3
    //   130: iload 5
    //   132: invokespecial 830	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   135: ldc_w 837
    //   138: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 4
    //   143: athrow
    //   144: astore 4
    //   146: ldc_w 837
    //   149: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: athrow
    //   155: astore 4
    //   157: ldc_w 837
    //   160: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 4
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	V8
    //   0	166	1	paramLong	long
    //   0	166	3	paramV8Object	V8Object
    //   0	166	4	paramV8Array	V8Array
    //   60	71	5	bool	boolean
    //   22	63	6	localMethodDescriptor	V8.MethodDescriptor
    // Exception table:
    //   from	to	target	type
    //   79	94	108	java/lang/reflect/InvocationTargetException
    //   79	94	126	finally
    //   110	126	126	finally
    //   146	155	126	finally
    //   157	166	126	finally
    //   79	94	144	java/lang/IllegalAccessException
    //   79	94	155	java/lang/IllegalArgumentException
  }
  
  void checkRuntime(V8Value paramV8Value)
  {
    AppMethodBeat.i(75223);
    if ((paramV8Value == null) || (paramV8Value.isUndefined()))
    {
      AppMethodBeat.o(75223);
      return;
    }
    paramV8Value = paramV8Value.getRuntime();
    if ((paramV8Value == null) || (paramV8Value.isReleased()) || (paramV8Value != this))
    {
      paramV8Value = new Error("Invalid target runtime");
      AppMethodBeat.o(75223);
      throw paramV8Value;
    }
    AppMethodBeat.o(75223);
  }
  
  void checkThread()
  {
    AppMethodBeat.i(75224);
    this.locker.checkThread();
    if (isReleased())
    {
      Error localError = new Error("Runtime disposed error");
      AppMethodBeat.o(75224);
      throw localError;
    }
    AppMethodBeat.o(75224);
  }
  
  protected void closeUVLoop()
  {
    AppMethodBeat.i(75170);
    _closeUVLoop(this.v8RuntimePtr);
    AppMethodBeat.o(75170);
  }
  
  protected boolean contains(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75262);
    boolean bool = _contains(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75262);
    return bool;
  }
  
  void createAndRegisterMethodDescriptor(JavaCallback paramJavaCallback, long paramLong)
  {
    AppMethodBeat.i(75229);
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.callback = paramJavaCallback;
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(75229);
  }
  
  void createNodeRuntime(String paramString)
  {
    AppMethodBeat.i(75244);
    _startNodeJS(this.v8RuntimePtr, paramString);
    AppMethodBeat.o(75244);
  }
  
  protected void createTwin(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75252);
    _createTwin(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75252);
  }
  
  protected void createTwin(V8Value paramV8Value1, V8Value paramV8Value2)
  {
    AppMethodBeat.i(75198);
    checkThread();
    createTwin(this.v8RuntimePtr, paramV8Value1.getHandle(), paramV8Value2.getHandle());
    AppMethodBeat.o(75198);
  }
  
  protected ByteBuffer createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75301);
    ByteBuffer localByteBuffer = _createV8ArrayBufferBackingStore(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75301);
    return localByteBuffer;
  }
  
  protected long createV8Context(int paramInt)
  {
    AppMethodBeat.i(75167);
    long l = _createContext(this.v8RuntimePtr, paramInt);
    AppMethodBeat.o(75167);
    return l;
  }
  
  public void debuggerMessageLoop()
  {
    AppMethodBeat.i(75342);
    checkThread();
    _debugMessageLoop(this.v8RuntimePtr);
    AppMethodBeat.o(75342);
  }
  
  protected void disposeMethodID(long paramLong)
  {
    AppMethodBeat.i(75232);
    this.functionRegistry.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(75232);
  }
  
  protected boolean equals(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75276);
    boolean bool = _equals(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75276);
    return bool;
  }
  
  public V8Array executeArrayScript(String paramString)
  {
    AppMethodBeat.i(75208);
    paramString = executeArrayScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75208);
    return paramString;
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75209);
    paramString1 = executeArrayScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75209);
    return paramString1;
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75210);
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    if ((paramString1 instanceof V8Array))
    {
      paramString1 = (V8Array)paramString1;
      AppMethodBeat.o(75210);
      return paramString1;
    }
    paramString1 = new V8ResultUndefined();
    AppMethodBeat.o(75210);
    throw paramString1;
  }
  
  protected boolean executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75272);
    boolean bool = _executeBooleanFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75272);
    return bool;
  }
  
  protected boolean executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75256);
    boolean bool = _executeBooleanScript(paramLong, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75256);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString)
  {
    AppMethodBeat.i(75205);
    boolean bool = executeBooleanScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75205);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75206);
    boolean bool = executeBooleanScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75206);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75207);
    checkThread();
    checkScript(paramString1);
    boolean bool = executeBooleanScript(this.v8RuntimePtr, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75207);
    return bool;
  }
  
  public String executeDebugScript(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75340);
    checkThread();
    checkScript(paramString1);
    paramString1 = _executeDebugScript(this.v8RuntimePtr, paramString1, paramString2);
    AppMethodBeat.o(75340);
    return paramString1;
  }
  
  protected double executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75270);
    double d = _executeDoubleFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75270);
    return d;
  }
  
  protected double executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75254);
    double d = _executeDoubleScript(paramLong, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75254);
    return d;
  }
  
  public double executeDoubleScript(String paramString)
  {
    AppMethodBeat.i(75199);
    double d = executeDoubleScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75199);
    return d;
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75200);
    double d = executeDoubleScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75200);
    return d;
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75201);
    checkThread();
    checkScript(paramString1);
    double d = executeDoubleScript(this.v8RuntimePtr, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75201);
    return d;
  }
  
  protected Object executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75273);
    paramString = _executeFunction(paramLong1, paramInt, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75273);
    return paramString;
  }
  
  protected Object executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(75274);
    Object localObject = _executeFunction(paramLong1, paramLong2, paramLong3, paramLong4);
    AppMethodBeat.o(75274);
    return localObject;
  }
  
  protected int executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75269);
    int i = _executeIntegerFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75269);
    return i;
  }
  
  protected int executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75253);
    paramInt = _executeIntegerScript(paramLong, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75253);
    return paramInt;
  }
  
  public int executeIntegerScript(String paramString)
  {
    AppMethodBeat.i(75195);
    int i = executeIntegerScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75195);
    return i;
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75196);
    paramInt = executeIntegerScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75196);
    return paramInt;
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75197);
    checkThread();
    checkScript(paramString1);
    paramInt = executeIntegerScript(this.v8RuntimePtr, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75197);
    return paramInt;
  }
  
  public V8Object executeObjectScript(String paramString)
  {
    AppMethodBeat.i(75214);
    paramString = executeObjectScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75214);
    return paramString;
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75215);
    paramString1 = executeObjectScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75215);
    return paramString1;
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75216);
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    if ((paramString1 instanceof V8Object))
    {
      paramString1 = (V8Object)paramString1;
      AppMethodBeat.o(75216);
      return paramString1;
    }
    paramString1 = new V8ResultUndefined();
    AppMethodBeat.o(75216);
    throw paramString1;
  }
  
  protected Object executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75257);
    paramString1 = _executeScript(paramLong, paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4);
    AppMethodBeat.o(75257);
    return paramString1;
  }
  
  public Object executeScript(String paramString)
  {
    AppMethodBeat.i(75211);
    paramString = executeScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75211);
    return paramString;
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75212);
    paramString1 = executeScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75212);
    return paramString1;
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75213);
    checkThread();
    checkScript(paramString1);
    paramString1 = executeScript(getV8RuntimePtr(), 0, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75213);
    return paramString1;
  }
  
  protected String executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75271);
    paramString = _executeStringFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75271);
    return paramString;
  }
  
  protected String executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75255);
    paramString1 = _executeStringScript(paramLong, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75255);
    return paramString1;
  }
  
  public String executeStringScript(String paramString)
  {
    AppMethodBeat.i(75202);
    paramString = executeStringScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75202);
    return paramString;
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75203);
    paramString1 = executeStringScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75203);
    return paramString1;
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75204);
    checkThread();
    checkScript(paramString1);
    paramString1 = executeStringScript(this.v8RuntimePtr, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75204);
    return paramString1;
  }
  
  protected void executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(75275);
    _executeVoidFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(75275);
  }
  
  protected void executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75258);
    _executeVoidScript(paramLong, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75258);
  }
  
  public void executeVoidScript(String paramString)
  {
    AppMethodBeat.i(75217);
    executeVoidScript(paramString, null, 0, null, null);
    AppMethodBeat.o(75217);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75218);
    executeVoidScript(paramString1, paramString2, paramInt, null, null);
    AppMethodBeat.o(75218);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75219);
    checkThread();
    checkScript(paramString1);
    executeVoidScript(this.v8RuntimePtr, paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75219);
  }
  
  protected Object get(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75268);
    paramString = _get(paramLong1, paramInt, paramLong2, paramString);
    AppMethodBeat.o(75268);
    return paramString;
  }
  
  protected int getArrayType(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75321);
    int i = _getArrayType(paramLong1, paramLong2);
    AppMethodBeat.o(75321);
    return i;
  }
  
  protected boolean getBoolean(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75265);
    boolean bool = _getBoolean(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75265);
    return bool;
  }
  
  public long getBuildID()
  {
    AppMethodBeat.i(75220);
    long l = _getBuildID();
    AppMethodBeat.o(75220);
    return l;
  }
  
  public Object getData(String paramString)
  {
    AppMethodBeat.i(75177);
    if (this.data == null)
    {
      AppMethodBeat.o(75177);
      return null;
    }
    paramString = this.data.get(paramString);
    AppMethodBeat.o(75177);
    return paramString;
  }
  
  protected double getDouble(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75266);
    double d = _getDouble(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75266);
    return d;
  }
  
  public V8Executor getExecutor(V8Object paramV8Object)
  {
    AppMethodBeat.i(75192);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(75192);
      return null;
    }
    paramV8Object = (V8Executor)this.executors.get(paramV8Object);
    AppMethodBeat.o(75192);
    return paramV8Object;
  }
  
  protected long getGlobalObject()
  {
    AppMethodBeat.i(75248);
    long l = _getGlobalObject(this.v8RuntimePtr);
    AppMethodBeat.o(75248);
    return l;
  }
  
  protected int getInteger(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75264);
    int i = _getInteger(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75264);
    return i;
  }
  
  protected long getIsolatePtr()
  {
    AppMethodBeat.i(75336);
    long l = _getIsolatePtr(this.v8RuntimePtr);
    AppMethodBeat.o(75336);
    return l;
  }
  
  protected String[] getKeys(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75263);
    String[] arrayOfString = _getKeys(paramLong1, paramLong2);
    AppMethodBeat.o(75263);
    return arrayOfString;
  }
  
  public V8Locker getLocker()
  {
    return this.locker;
  }
  
  public long getObjectReferenceCount()
  {
    AppMethodBeat.i(75183);
    long l1 = this.objectReferences;
    long l2 = this.v8WeakReferences.size();
    AppMethodBeat.o(75183);
    return l1 - l2;
  }
  
  protected String getString(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75267);
    paramString = _getString(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75267);
    return paramString;
  }
  
  protected int getType(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75318);
    int i = _getType(paramLong1, paramLong2);
    AppMethodBeat.o(75318);
    return i;
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75320);
    paramInt = _getType(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(75320);
    return paramInt;
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75322);
    paramInt1 = _getType(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75322);
    return paramInt1;
  }
  
  protected int getType(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(75319);
    int i = _getType(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(75319);
    return i;
  }
  
  protected long getV8RuntimePtr()
  {
    return this.v8RuntimePtr;
  }
  
  protected int identityHash(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75280);
    int i = _identityHash(paramLong1, paramLong2);
    AppMethodBeat.o(75280);
    return i;
  }
  
  protected long initNewSharedV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(75290);
    paramLong = _initNewSharedV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
    AppMethodBeat.o(75290);
    return paramLong;
  }
  
  protected long initNewV8Array(long paramLong)
  {
    AppMethodBeat.i(75302);
    paramLong = _initNewV8Array(paramLong);
    AppMethodBeat.o(75302);
    return paramLong;
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, int paramInt)
  {
    AppMethodBeat.i(75291);
    paramLong = _initNewV8ArrayBuffer(paramLong, paramInt);
    AppMethodBeat.o(75291);
    return paramLong;
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(75289);
    paramLong = _initNewV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
    AppMethodBeat.o(75289);
    return paramLong;
  }
  
  public long initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75293);
    paramLong1 = _initNewV8Float32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75293);
    return paramLong1;
  }
  
  public long initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75294);
    paramLong1 = _initNewV8Float64Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75294);
    return paramLong1;
  }
  
  protected long[] initNewV8Function(long paramLong)
  {
    AppMethodBeat.i(75303);
    checkThread();
    long[] arrayOfLong = _initNewV8Function(paramLong);
    AppMethodBeat.o(75303);
    return arrayOfLong;
  }
  
  public long initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75297);
    paramLong1 = _initNewV8Int16Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75297);
    return paramLong1;
  }
  
  public long initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75292);
    paramLong1 = _initNewV8Int32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75292);
    return paramLong1;
  }
  
  public long initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75299);
    paramLong1 = _initNewV8Int8Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75299);
    return paramLong1;
  }
  
  protected long initNewV8Object(long paramLong)
  {
    AppMethodBeat.i(75247);
    paramLong = _initNewV8Object(paramLong);
    AppMethodBeat.o(75247);
    return paramLong;
  }
  
  public long initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75296);
    paramLong1 = _initNewV8UInt16Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75296);
    return paramLong1;
  }
  
  public long initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75295);
    paramLong1 = _initNewV8UInt32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75295);
    return paramLong1;
  }
  
  public long initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75298);
    paramLong1 = _initNewV8UInt8Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75298);
    return paramLong1;
  }
  
  public long initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75300);
    paramLong1 = _initNewV8UInt8ClampedArray(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(75300);
    return paramLong1;
  }
  
  boolean isRunning()
  {
    AppMethodBeat.i(75246);
    boolean bool = _isRunning(this.v8RuntimePtr);
    AppMethodBeat.o(75246);
    return bool;
  }
  
  protected boolean isWeak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75260);
    boolean bool = _isWeak(paramLong1, paramLong2);
    AppMethodBeat.o(75260);
    return bool;
  }
  
  public void lowMemoryNotification()
  {
    AppMethodBeat.i(75221);
    checkThread();
    lowMemoryNotification(getV8RuntimePtr());
    AppMethodBeat.o(75221);
  }
  
  protected void lowMemoryNotification(long paramLong)
  {
    AppMethodBeat.i(75251);
    _lowMemoryNotification(paramLong);
    AppMethodBeat.o(75251);
  }
  
  public void memoryPressureNotification(int paramInt)
  {
    AppMethodBeat.i(75222);
    _memoryPressureNotification(this.v8RuntimePtr, paramInt);
    AppMethodBeat.o(75222);
  }
  
  boolean pumpMessageLoop()
  {
    AppMethodBeat.i(75245);
    boolean bool = _pumpMessageLoop(this.v8RuntimePtr);
    AppMethodBeat.o(75245);
    return bool;
  }
  
  void registerCallback(JavaCallback paramJavaCallback, long paramLong, String paramString)
  {
    AppMethodBeat.i(75228);
    createAndRegisterMethodDescriptor(paramJavaCallback, registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, false));
    AppMethodBeat.o(75228);
  }
  
  void registerCallback(Object paramObject, Method paramMethod, long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(75226);
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.object = paramObject;
    localMethodDescriptor.method = paramMethod;
    localMethodDescriptor.includeReceiver = paramBoolean;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, isVoidMethod(paramMethod));
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(75226);
  }
  
  protected long registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(75288);
    paramLong1 = _registerJavaMethod(paramLong1, paramLong2, paramString, paramBoolean);
    AppMethodBeat.o(75288);
    return paramLong1;
  }
  
  public void registerResource(Releasable paramReleasable)
  {
    AppMethodBeat.i(75194);
    checkThread();
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(paramReleasable);
    AppMethodBeat.o(75194);
  }
  
  public void registerV8Executor(V8Object paramV8Object, V8Executor paramV8Executor)
  {
    AppMethodBeat.i(75190);
    checkThread();
    if (this.executors == null) {
      this.executors = new V8Map();
    }
    this.executors.put(paramV8Object, paramV8Executor);
    AppMethodBeat.o(75190);
  }
  
  void registerVoidCallback(JavaVoidCallback paramJavaVoidCallback, long paramLong, String paramString)
  {
    AppMethodBeat.i(75227);
    V8.MethodDescriptor localMethodDescriptor = new V8.MethodDescriptor(this, null);
    localMethodDescriptor.voidCallback = paramJavaVoidCallback;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, true);
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(75227);
  }
  
  public void release()
  {
    AppMethodBeat.i(75185);
    release(true);
    AppMethodBeat.o(75185);
  }
  
  protected void release(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75261);
    _release(paramLong1, paramLong2);
    AppMethodBeat.o(75261);
  }
  
  public void release(boolean paramBoolean)
  {
    AppMethodBeat.i(75187);
    if (isReleased())
    {
      AppMethodBeat.o(75187);
      return;
    }
    checkThread();
    try
    {
      notifyReleaseHandlers(this);
      releaseResources();
      shutdownExecutors(this.forceTerminateExecutors);
      if (this.executors != null) {
        this.executors.clear();
      }
      releaseNativeMethodDescriptors();
      synchronized (lock)
      {
        runtimeCounter -= 1;
        _releaseRuntime(this.v8RuntimePtr);
        this.v8RuntimePtr = 0L;
        this.released = true;
        if ((paramBoolean) && (getObjectReferenceCount() > 0L))
        {
          ??? = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
          AppMethodBeat.o(75187);
          throw ((Throwable)???);
        }
      }
      AppMethodBeat.o(75187);
    }
    finally
    {
      releaseResources();
      shutdownExecutors(this.forceTerminateExecutors);
      if (this.executors != null) {
        this.executors.clear();
      }
      releaseNativeMethodDescriptors();
      synchronized (lock)
      {
        runtimeCounter -= 1;
        _releaseRuntime(this.v8RuntimePtr);
        this.v8RuntimePtr = 0L;
        this.released = true;
        if ((paramBoolean) && (getObjectReferenceCount() > 0L))
        {
          ??? = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
          AppMethodBeat.o(75187);
          throw ((Throwable)???);
        }
      }
      AppMethodBeat.o(75187);
    }
  }
  
  protected void releaseLock(long paramLong)
  {
    AppMethodBeat.i(75250);
    _releaseLock(paramLong);
    AppMethodBeat.o(75250);
  }
  
  protected void releaseMethodDescriptor(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75335);
    _releaseMethodDescriptor(paramLong1, paramLong2);
    AppMethodBeat.o(75335);
  }
  
  void releaseObjRef(V8Value paramV8Value)
  {
    AppMethodBeat.i(75338);
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceDisposed(paramV8Value);
    }
    this.objectReferences -= 1L;
    AppMethodBeat.o(75338);
  }
  
  protected void releaseV8Context(long paramLong)
  {
    AppMethodBeat.i(75171);
    _releaseContext(this.v8RuntimePtr, paramLong);
    AppMethodBeat.o(75171);
  }
  
  public V8Executor removeExecutor(V8Object paramV8Object)
  {
    AppMethodBeat.i(75191);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(75191);
      return null;
    }
    paramV8Object = (V8Executor)this.executors.remove(paramV8Object);
    AppMethodBeat.o(75191);
    return paramV8Object;
  }
  
  public void removeReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    AppMethodBeat.i(75174);
    this.referenceHandlers.remove(paramReferenceHandler);
    AppMethodBeat.o(75174);
  }
  
  public void removeReleaseHandler(V8Runnable paramV8Runnable)
  {
    AppMethodBeat.i(75175);
    this.releaseHandlers.remove(paramV8Runnable);
    AppMethodBeat.o(75175);
  }
  
  protected boolean sameValue(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75279);
    boolean bool = _sameValue(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75279);
    return bool;
  }
  
  public void setData(String paramString, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(75176);
      if (this.data == null) {
        this.data = new HashMap();
      }
      this.data.put(paramString, paramObject);
      AppMethodBeat.o(75176);
      return;
    }
    finally {}
  }
  
  protected void setPrototype(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75323);
    _setPrototype(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75323);
  }
  
  protected void setWeak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75259);
    _setWeak(paramLong1, paramLong2);
    AppMethodBeat.o(75259);
  }
  
  public void shutdownExecutors(boolean paramBoolean)
  {
    AppMethodBeat.i(75193);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(75193);
      return;
    }
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
    AppMethodBeat.o(75193);
  }
  
  protected boolean strictEquals(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(75278);
    boolean bool = _strictEquals(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(75278);
    return bool;
  }
  
  protected void switchV8Context(long paramLong)
  {
    AppMethodBeat.i(75168);
    _switchContext(this.v8RuntimePtr, paramLong);
    AppMethodBeat.o(75168);
  }
  
  public void terminateExecution()
  {
    AppMethodBeat.i(75186);
    this.forceTerminateExecutors = true;
    terminateExecution(this.v8RuntimePtr);
    AppMethodBeat.o(75186);
  }
  
  protected void terminateExecution(long paramLong)
  {
    AppMethodBeat.i(75334);
    _terminateExecution(paramLong);
    AppMethodBeat.o(75334);
  }
  
  protected String toString(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75277);
    String str = _toString(paramLong1, paramLong2);
    AppMethodBeat.o(75277);
    return str;
  }
  
  public void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(75341);
    checkThread();
    _waitForDebuger(this.v8RuntimePtr, paramString);
    AppMethodBeat.o(75341);
  }
  
  protected void wakeUpUVLoop()
  {
    AppMethodBeat.i(75169);
    _wakeUpUVLoop(this.v8RuntimePtr);
    AppMethodBeat.o(75169);
  }
  
  protected void weakReferenceReleased(long paramLong)
  {
    AppMethodBeat.i(75233);
    V8Value localV8Value = (V8Value)this.v8WeakReferences.get(Long.valueOf(paramLong));
    if (localV8Value != null)
    {
      this.v8WeakReferences.remove(Long.valueOf(paramLong));
      try
      {
        localV8Value.release();
        AppMethodBeat.o(75233);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(75233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.V8
 * JD-Core Version:    0.7.0.1
 */