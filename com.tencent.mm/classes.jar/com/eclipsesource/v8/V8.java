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
  JavaTaskScheduler _javaTaskScheduler;
  private Map<String, Object> data;
  private V8Map<V8Executor> executors;
  private boolean forceTerminateExecutors;
  private Map<Long, MethodDescriptor> functionRegistry;
  private final V8Locker locker;
  Runnable nativeJavaCallback_;
  private long objectReferences;
  private LinkedList<ReferenceHandler> referenceHandlers;
  private LinkedList<V8Runnable> releaseHandlers;
  private List<Releasable> resources;
  private long v8RuntimePtr;
  protected Map<Long, V8Value> v8WeakReferences;
  
  static
  {
    AppMethodBeat.i(61968);
    lock = new Object();
    runtimeCounter = 0;
    v8Flags = "";
    initialized = false;
    nativeLibraryLoaded = false;
    nativeLoadError = null;
    nativeLoadException = null;
    undefined = new V8Object.Undefined();
    invalid = new Object();
    sLoadLibraryDelegate = new V8.1();
    AppMethodBeat.o(61968);
  }
  
  protected V8()
  {
    this(null, true);
  }
  
  protected V8(String paramString, boolean paramBoolean)
  {
    super(null);
    AppMethodBeat.i(61806);
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
    this._javaTaskScheduler = null;
    this.released = false;
    this.v8RuntimePtr = _createIsolate(paramString, paramBoolean);
    this.locker = new V8Locker(this);
    checkThread();
    if (paramBoolean) {
      this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }
    AppMethodBeat.o(61806);
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
  
  private static native void _enableNativeTrans(long paramLong);
  
  private native boolean _equals(long paramLong1, long paramLong2, long paramLong3);
  
  private native boolean _executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native boolean _executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  private static native String _executeDebugScript(long paramLong, String paramString1, String paramString2);
  
  private native double _executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native double _executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  private native Object _executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3);
  
  private native Object _executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private native int _executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native int _executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  private native Object _executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, ExecuteDetails paramExecuteDetails);
  
  private native String _executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native String _executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  private native void _executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  private native void _executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails);
  
  private native Object _executeWxaScript(long paramLong, ArrayList<ScriptPartObject> paramArrayList, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, ExecuteDetails paramExecuteDetails);
  
  private native Object _get(long paramLong1, int paramInt, long paramLong2, String paramString);
  
  private native int _getArrayType(long paramLong1, long paramLong2);
  
  private native boolean _getBoolean(long paramLong1, long paramLong2, String paramString);
  
  private native long _getBuildID();
  
  private native double _getDouble(long paramLong1, long paramLong2, String paramString);
  
  private native long _getGlobalObject(long paramLong);
  
  private native int _getInteger(long paramLong1, long paramLong2, String paramString);
  
  private native long _getIsolatePtr(long paramLong);
  
  private native String[] _getKeys(long paramLong1, long paramLong2);
  
  private static native long _getNativeTransManager();
  
  private native String _getString(long paramLong1, long paramLong2, String paramString);
  
  private native int _getType(long paramLong1, long paramLong2);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt);
  
  private native int _getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native int _getType(long paramLong1, long paramLong2, String paramString);
  
  private native long _getUVLoopPtr(long paramLong);
  
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
  
  private static native void _nativeDispatch(long paramLong);
  
  private static native void _nativeLoopStop(long paramLong);
  
  private static native void _nativeMessageLoop(long paramLong);
  
  private static native void _nativeTransBroadcastMessage(int paramInt, String paramString);
  
  private static native void _nativeTransHandleMessage(long paramLong);
  
  private static native void _nativeTransPostMessage(int paramInt, String paramString);
  
  private static native void _nativeTransSetJavaSchedule(long paramLong);
  
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
  
  public static void broadcastMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(196758);
    _nativeTransBroadcastMessage(paramInt, paramString);
    AppMethodBeat.o(196758);
  }
  
  private void checkArgs(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(61861);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == invalid)
      {
        paramArrayOfObject = new IllegalArgumentException("argument type mismatch");
        AppMethodBeat.o(61861);
        throw paramArrayOfObject;
      }
      i += 1;
    }
    AppMethodBeat.o(61861);
  }
  
  private static void checkNativeLibraryLoaded()
  {
    AppMethodBeat.i(61805);
    if (!nativeLibraryLoaded)
    {
      if (nativeLoadError != null)
      {
        localIllegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
        AppMethodBeat.o(61805);
        throw localIllegalStateException;
      }
      if (nativeLoadException != null)
      {
        localIllegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
        AppMethodBeat.o(61805);
        throw localIllegalStateException;
      }
      IllegalStateException localIllegalStateException = new IllegalStateException("J2V8 native library not loaded");
      AppMethodBeat.o(61805);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(61805);
  }
  
  private Object checkResult(Object paramObject)
  {
    AppMethodBeat.i(61859);
    if (paramObject == null)
    {
      AppMethodBeat.o(61859);
      return paramObject;
    }
    if ((paramObject instanceof Float))
    {
      double d = ((Float)paramObject).doubleValue();
      AppMethodBeat.o(61859);
      return Double.valueOf(d);
    }
    if (((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof String)))
    {
      AppMethodBeat.o(61859);
      return paramObject;
    }
    if ((paramObject instanceof V8Value))
    {
      if (((V8Value)paramObject).isReleased())
      {
        paramObject = new V8RuntimeException("V8Value already released");
        AppMethodBeat.o(61859);
        throw paramObject;
      }
      AppMethodBeat.o(61859);
      return paramObject;
    }
    paramObject = new V8RuntimeException("Unknown return type: " + paramObject.getClass());
    AppMethodBeat.o(61859);
    throw paramObject;
  }
  
  static void checkScript(String paramString)
  {
    AppMethodBeat.i(61849);
    if (paramString == null)
    {
      paramString = new NullPointerException("Script is null");
      AppMethodBeat.o(61849);
      throw paramString;
    }
    AppMethodBeat.o(61849);
  }
  
  public static V8 createV8Runtime()
  {
    AppMethodBeat.i(61786);
    V8 localV8 = createV8Runtime(null, null);
    AppMethodBeat.o(61786);
    return localV8;
  }
  
  public static V8 createV8Runtime(String paramString)
  {
    AppMethodBeat.i(61787);
    paramString = createV8Runtime(paramString, null);
    AppMethodBeat.o(61787);
    return paramString;
  }
  
  public static V8 createV8Runtime(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61788);
    paramString1 = createV8Runtime(paramString1, paramString2, true, null, null);
    AppMethodBeat.o(61788);
    return paramString1;
  }
  
  protected static V8 createV8Runtime(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(61789);
    paramString1 = createV8Runtime(paramString1, paramString2, paramBoolean, null, null);
    AppMethodBeat.o(61789);
    return paramString1;
  }
  
  /* Error */
  protected static V8 createV8Runtime(String arg0, String paramString2, boolean paramBoolean, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 438
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 90	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   9: ifne +24 -> 33
    //   12: getstatic 80	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   15: astore 5
    //   17: aload 5
    //   19: monitorenter
    //   20: getstatic 90	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   23: ifne +7 -> 30
    //   26: aload_1
    //   27: invokestatic 441	com/eclipsesource/v8/V8:load	(Ljava/lang/String;)V
    //   30: aload 5
    //   32: monitorexit
    //   33: invokestatic 443	com/eclipsesource/v8/V8:checkNativeLibraryLoaded	()V
    //   36: getstatic 88	com/eclipsesource/v8/V8:initialized	Z
    //   39: ifne +33 -> 72
    //   42: getstatic 80	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokestatic 445	com/eclipsesource/v8/V8:_setCodeCacheDir	(Ljava/lang/String;)V
    //   56: aload 4
    //   58: ifnull +8 -> 66
    //   61: aload 4
    //   63: invokestatic 447	com/eclipsesource/v8/V8:_setSnapshotBlob	([B)V
    //   66: aload_1
    //   67: monitorexit
    //   68: iconst_1
    //   69: putstatic 88	com/eclipsesource/v8/V8:initialized	Z
    //   72: new 2	com/eclipsesource/v8/V8
    //   75: dup
    //   76: aload_0
    //   77: iload_2
    //   78: invokespecial 113	com/eclipsesource/v8/V8:<init>	(Ljava/lang/String;Z)V
    //   81: astore_1
    //   82: getstatic 80	com/eclipsesource/v8/V8:lock	Ljava/lang/Object;
    //   85: astore_0
    //   86: aload_0
    //   87: monitorenter
    //   88: getstatic 82	com/eclipsesource/v8/V8:runtimeCounter	I
    //   91: iconst_1
    //   92: iadd
    //   93: putstatic 82	com/eclipsesource/v8/V8:runtimeCounter	I
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 438
    //   101: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: aload 5
    //   109: monitorexit
    //   110: ldc_w 438
    //   113: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: aload_1
    //   120: monitorexit
    //   121: ldc_w 438
    //   124: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: ldc_w 438
    //   135: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	1	paramString2	String
    //   0	140	2	paramBoolean	boolean
    //   0	140	3	paramString3	String
    //   0	140	4	paramArrayOfByte	byte[]
    //   15	93	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	30	106	finally
    //   30	33	106	finally
    //   107	110	106	finally
    //   52	56	118	finally
    //   61	66	118	finally
    //   66	68	118	finally
    //   119	121	118	finally
    //   88	98	129	finally
    //   130	132	129	finally
  }
  
  public static int getActiveRuntimes()
  {
    return runtimeCounter;
  }
  
  private Object[] getArgs(V8Object paramV8Object, MethodDescriptor paramMethodDescriptor, V8Array paramV8Array, boolean paramBoolean)
  {
    AppMethodBeat.i(61863);
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
      AppMethodBeat.o(61863);
      return paramV8Object;
    }
  }
  
  private Object getArrayItem(V8Array paramV8Array, int paramInt)
  {
    AppMethodBeat.i(61867);
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
    AppMethodBeat.o(61867);
    return null;
    paramInt = paramV8Array.getInteger(paramInt);
    AppMethodBeat.o(61867);
    return Integer.valueOf(paramInt);
    d = paramV8Array.getDouble(paramInt);
    AppMethodBeat.o(61867);
    return Double.valueOf(d);
    bool = paramV8Array.getBoolean(paramInt);
    AppMethodBeat.o(61867);
    return Boolean.valueOf(bool);
    paramV8Array = paramV8Array.getString(paramInt);
    AppMethodBeat.o(61867);
    return paramV8Array;
    paramV8Array = paramV8Array.getArray(paramInt);
    AppMethodBeat.o(61867);
    return paramV8Array;
    paramV8Array = paramV8Array.getObject(paramInt);
    AppMethodBeat.o(61867);
    return paramV8Array;
    paramV8Array = paramV8Array.getObject(paramInt);
    AppMethodBeat.o(61867);
    return paramV8Array;
    paramV8Array = paramV8Array.get(paramInt);
    AppMethodBeat.o(61867);
    return paramV8Array;
    paramV8Array = getUndefined();
    AppMethodBeat.o(61867);
    return paramV8Array;
  }
  
  private Object getDefaultValue(Class<?> paramClass)
  {
    AppMethodBeat.i(61855);
    if (paramClass.equals(V8Object.class))
    {
      paramClass = new V8Object.Undefined();
      AppMethodBeat.o(61855);
      return paramClass;
    }
    if (paramClass.equals(V8Array.class))
    {
      paramClass = new V8Array.Undefined();
      AppMethodBeat.o(61855);
      return paramClass;
    }
    paramClass = invalid;
    AppMethodBeat.o(61855);
    return paramClass;
  }
  
  public static String getFlags()
  {
    return v8Flags;
  }
  
  public static long getNativeTransManager()
  {
    AppMethodBeat.i(196756);
    long l = _getNativeTransManager();
    AppMethodBeat.o(196756);
    return l;
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
    AppMethodBeat.i(61808);
    String str = _getVersion();
    AppMethodBeat.o(61808);
    return str;
  }
  
  private Object getVarArgContainer(Class<?>[] paramArrayOfClass, int paramInt)
  {
    AppMethodBeat.i(61864);
    Class<?> localClass = paramArrayOfClass[(paramArrayOfClass.length - 1)];
    paramArrayOfClass = localClass;
    if (localClass.isArray()) {
      paramArrayOfClass = localClass.getComponentType();
    }
    paramArrayOfClass = Array.newInstance(paramArrayOfClass, paramInt);
    AppMethodBeat.o(61864);
    return paramArrayOfClass;
  }
  
  public static boolean isLoaded()
  {
    return nativeLibraryLoaded;
  }
  
  private boolean isVoidMethod(Method paramMethod)
  {
    AppMethodBeat.i(61854);
    if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      AppMethodBeat.o(61854);
      return true;
    }
    AppMethodBeat.o(61854);
    return false;
  }
  
  /* Error */
  private static void load(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 601
    //   6: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 106	com/eclipsesource/v8/V8:sLoadLibraryDelegate	Lcom/eclipsesource/v8/ILoadLibraryDelegate;
    //   12: aload_0
    //   13: invokeinterface 606 2 0
    //   18: iconst_1
    //   19: putstatic 90	com/eclipsesource/v8/V8:nativeLibraryLoaded	Z
    //   22: ldc_w 601
    //   25: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: aload_0
    //   34: putstatic 92	com/eclipsesource/v8/V8:nativeLoadError	Ljava/lang/Error;
    //   37: ldc_w 601
    //   40: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -15 -> 28
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aload_0
    //   54: putstatic 94	com/eclipsesource/v8/V8:nativeLoadException	Ljava/lang/Exception;
    //   57: ldc_w 601
    //   60: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(61803);
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleCreated(paramV8Value);
    }
    AppMethodBeat.o(61803);
  }
  
  private void notifyReferenceDisposed(V8Value paramV8Value)
  {
    AppMethodBeat.i(61804);
    Iterator localIterator = this.referenceHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ReferenceHandler)localIterator.next()).v8HandleDisposed(paramV8Value);
    }
    AppMethodBeat.o(61804);
  }
  
  private void notifyReleaseHandlers(V8 paramV8)
  {
    AppMethodBeat.i(61802);
    Iterator localIterator = this.releaseHandlers.iterator();
    while (localIterator.hasNext()) {
      ((V8Runnable)localIterator.next()).run(paramV8);
    }
    AppMethodBeat.o(61802);
  }
  
  private void populateParamters(V8Array paramV8Array, int paramInt, Object[] paramArrayOfObject, List<Object> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(61865);
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
    AppMethodBeat.o(61865);
  }
  
  public static void postMessage(int paramInt, String paramString)
  {
    AppMethodBeat.i(196757);
    _nativeTransPostMessage(paramInt, paramString);
    AppMethodBeat.o(196757);
  }
  
  private void releaseArguments(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    AppMethodBeat.i(61862);
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
    AppMethodBeat.o(61862);
  }
  
  private void releaseNativeMethodDescriptors()
  {
    AppMethodBeat.i(61812);
    Iterator localIterator = this.functionRegistry.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      releaseMethodDescriptor(this.v8RuntimePtr, localLong.longValue());
    }
    AppMethodBeat.o(61812);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(61813);
    if (this.resources != null)
    {
      Iterator localIterator = this.resources.iterator();
      while (localIterator.hasNext()) {
        ((Releasable)localIterator.next()).release();
      }
      this.resources.clear();
      this.resources = null;
    }
    AppMethodBeat.o(61813);
  }
  
  private Object[] setDefaultValues(Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass, V8Object paramV8Object, boolean paramBoolean)
  {
    AppMethodBeat.i(61866);
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
        AppMethodBeat.o(61866);
        return paramArrayOfObject;
        i = 0;
      }
    }
  }
  
  public static void setFlags(String paramString)
  {
    v8Flags = paramString;
  }
  
  public static void setLoadLibraryDelegate(ILoadLibraryDelegate paramILoadLibraryDelegate)
  {
    AppMethodBeat.i(61964);
    if (paramILoadLibraryDelegate == null)
    {
      paramILoadLibraryDelegate = new IllegalArgumentException("setLoadLibraryDelegate: param delegate null");
      AppMethodBeat.o(61964);
      throw paramILoadLibraryDelegate;
    }
    sLoadLibraryDelegate = paramILoadLibraryDelegate;
    AppMethodBeat.o(61964);
  }
  
  protected void acquireLock(long paramLong)
  {
    AppMethodBeat.i(61873);
    _acquireLock(paramLong);
    AppMethodBeat.o(61873);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, double paramDouble)
  {
    AppMethodBeat.i(61908);
    _add(paramLong1, paramLong2, paramString, paramDouble);
    AppMethodBeat.o(61908);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    AppMethodBeat.i(61905);
    _add(paramLong1, paramLong2, paramString, paramInt);
    AppMethodBeat.o(61905);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(61909);
    _add(paramLong1, paramLong2, paramString1, paramString2);
    AppMethodBeat.o(61909);
  }
  
  protected void add(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(61907);
    _add(paramLong1, paramLong2, paramString, paramBoolean);
    AppMethodBeat.o(61907);
  }
  
  protected void addArrayBooleanItem(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(61936);
    _addArrayBooleanItem(paramLong1, paramLong2, paramBoolean);
    AppMethodBeat.o(61936);
  }
  
  protected void addArrayDoubleItem(long paramLong1, long paramLong2, double paramDouble)
  {
    AppMethodBeat.i(61937);
    _addArrayDoubleItem(paramLong1, paramLong2, paramDouble);
    AppMethodBeat.o(61937);
  }
  
  protected void addArrayIntItem(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61935);
    _addArrayIntItem(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61935);
  }
  
  protected void addArrayNullItem(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61941);
    _addArrayNullItem(paramLong1, paramLong2);
    AppMethodBeat.o(61941);
  }
  
  protected void addArrayObjectItem(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61939);
    _addArrayObjectItem(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61939);
  }
  
  protected void addArrayStringItem(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61938);
    _addArrayStringItem(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61938);
  }
  
  protected void addArrayUndefinedItem(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61940);
    _addArrayUndefinedItem(paramLong1, paramLong2);
    AppMethodBeat.o(61940);
  }
  
  protected void addNull(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61911);
    _addNull(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61911);
  }
  
  void addObjRef(V8Value paramV8Value)
  {
    AppMethodBeat.i(61962);
    this.objectReferences += 1L;
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceCreated(paramV8Value);
    }
    AppMethodBeat.o(61962);
  }
  
  protected void addObject(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61906);
    _addObject(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61906);
  }
  
  public void addReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    AppMethodBeat.i(61796);
    this.referenceHandlers.add(0, paramReferenceHandler);
    AppMethodBeat.o(61796);
  }
  
  public void addReleaseHandler(V8Runnable paramV8Runnable)
  {
    AppMethodBeat.i(61797);
    this.releaseHandlers.add(paramV8Runnable);
    AppMethodBeat.o(61797);
  }
  
  protected void addUndefined(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61910);
    _addUndefined(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61910);
  }
  
  protected Object arrayGet(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(61934);
    Object localObject = _arrayGet(paramLong1, paramInt1, paramLong2, paramInt2);
    AppMethodBeat.o(61934);
    return localObject;
  }
  
  protected boolean arrayGetBoolean(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61930);
    boolean bool = _arrayGetBoolean(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61930);
    return bool;
  }
  
  protected int arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(61955);
    paramInt1 = _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfBoolean);
    AppMethodBeat.o(61955);
    return paramInt1;
  }
  
  protected boolean[] arrayGetBooleans(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61950);
    boolean[] arrayOfBoolean = _arrayGetBooleans(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61950);
    return arrayOfBoolean;
  }
  
  protected byte arrayGetByte(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61931);
    byte b = _arrayGetByte(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61931);
    return b;
  }
  
  protected int arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(61956);
    paramInt1 = _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.o(61956);
    return paramInt1;
  }
  
  protected byte[] arrayGetBytes(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61951);
    byte[] arrayOfByte = _arrayGetBytes(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61951);
    return arrayOfByte;
  }
  
  protected double arrayGetDouble(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61932);
    double d = _arrayGetDouble(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61932);
    return d;
  }
  
  protected int arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(61954);
    paramInt1 = _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfDouble);
    AppMethodBeat.o(61954);
    return paramInt1;
  }
  
  protected double[] arrayGetDoubles(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61949);
    double[] arrayOfDouble = _arrayGetDoubles(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61949);
    return arrayOfDouble;
  }
  
  protected int arrayGetInteger(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61929);
    paramInt = _arrayGetInteger(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61929);
    return paramInt;
  }
  
  protected int arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(61953);
    paramInt1 = _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(61953);
    return paramInt1;
  }
  
  protected int[] arrayGetIntegers(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61948);
    int[] arrayOfInt = _arrayGetIntegers(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61948);
    return arrayOfInt;
  }
  
  protected int arrayGetSize(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61928);
    int i = _arrayGetSize(paramLong1, paramLong2);
    AppMethodBeat.o(61928);
    return i;
  }
  
  protected String arrayGetString(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61933);
    String str = _arrayGetString(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61933);
    return str;
  }
  
  protected int arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(61957);
    paramInt1 = _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2, paramArrayOfString);
    AppMethodBeat.o(61957);
    return paramInt1;
  }
  
  protected String[] arrayGetStrings(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61952);
    String[] arrayOfString = _arrayGetStrings(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61952);
    return arrayOfString;
  }
  
  /* Error */
  protected Object callObjectJavaMethod(long paramLong, V8Object paramV8Object, V8Array paramV8Array)
  {
    // Byte code:
    //   0: ldc_w 842
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 136	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   10: lload_1
    //   11: invokestatic 845	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokeinterface 847 2 0
    //   19: checkcast 11	com/eclipsesource/v8/V8$MethodDescriptor
    //   22: astore 6
    //   24: aload 6
    //   26: getfield 851	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   29: ifnull +29 -> 58
    //   32: aload_0
    //   33: aload 6
    //   35: getfield 851	com/eclipsesource/v8/V8$MethodDescriptor:callback	Lcom/eclipsesource/v8/JavaCallback;
    //   38: aload_3
    //   39: aload 4
    //   41: invokeinterface 857 3 0
    //   46: invokespecial 859	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_3
    //   50: ldc_w 842
    //   53: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_3
    //   57: areturn
    //   58: aload 6
    //   60: getfield 456	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   63: invokevirtual 862	java/lang/reflect/Method:isVarArgs	()Z
    //   66: istore 5
    //   68: aload_0
    //   69: aload_3
    //   70: aload 6
    //   72: aload 4
    //   74: iload 5
    //   76: invokespecial 864	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   79: astore_3
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 866	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   85: aload_0
    //   86: aload 6
    //   88: getfield 456	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   91: aload 6
    //   93: getfield 869	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   96: aload_3
    //   97: invokevirtual 872	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: invokespecial 859	com/eclipsesource/v8/V8:checkResult	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 4
    //   105: aload_0
    //   106: aload_3
    //   107: iload 5
    //   109: invokespecial 874	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   112: ldc_w 842
    //   115: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload 4
    //   120: areturn
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 878	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   128: astore 4
    //   130: ldc_w 842
    //   133: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload 4
    //   138: athrow
    //   139: astore 4
    //   141: aload_0
    //   142: aload_3
    //   143: iload 5
    //   145: invokespecial 874	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   148: ldc_w 842
    //   151: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 4
    //   156: athrow
    //   157: astore 4
    //   159: ldc_w 842
    //   162: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 4
    //   167: athrow
    //   168: astore 4
    //   170: ldc_w 842
    //   173: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload 4
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	V8
    //   0	179	1	paramLong	long
    //   0	179	3	paramV8Object	V8Object
    //   0	179	4	paramV8Array	V8Array
    //   66	78	5	bool	boolean
    //   22	70	6	localMethodDescriptor	MethodDescriptor
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
    //   0: ldc_w 881
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 136	com/eclipsesource/v8/V8:functionRegistry	Ljava/util/Map;
    //   10: lload_1
    //   11: invokestatic 845	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: invokeinterface 847 2 0
    //   19: checkcast 11	com/eclipsesource/v8/V8$MethodDescriptor
    //   22: astore 6
    //   24: aload 6
    //   26: getfield 885	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   29: ifnull +23 -> 52
    //   32: aload 6
    //   34: getfield 885	com/eclipsesource/v8/V8$MethodDescriptor:voidCallback	Lcom/eclipsesource/v8/JavaVoidCallback;
    //   37: aload_3
    //   38: aload 4
    //   40: invokeinterface 890 3 0
    //   45: ldc_w 881
    //   48: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: aload 6
    //   54: getfield 456	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   57: invokevirtual 862	java/lang/reflect/Method:isVarArgs	()Z
    //   60: istore 5
    //   62: aload_0
    //   63: aload_3
    //   64: aload 6
    //   66: aload 4
    //   68: iload 5
    //   70: invokespecial 864	com/eclipsesource/v8/V8:getArgs	(Lcom/eclipsesource/v8/V8Object;Lcom/eclipsesource/v8/V8$MethodDescriptor;Lcom/eclipsesource/v8/V8Array;Z)[Ljava/lang/Object;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_3
    //   76: invokespecial 866	com/eclipsesource/v8/V8:checkArgs	([Ljava/lang/Object;)V
    //   79: aload 6
    //   81: getfield 456	com/eclipsesource/v8/V8$MethodDescriptor:method	Ljava/lang/reflect/Method;
    //   84: aload 6
    //   86: getfield 869	com/eclipsesource/v8/V8$MethodDescriptor:object	Ljava/lang/Object;
    //   89: aload_3
    //   90: invokevirtual 872	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_0
    //   95: aload_3
    //   96: iload 5
    //   98: invokespecial 874	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   101: ldc_w 881
    //   104: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore 4
    //   110: aload 4
    //   112: invokevirtual 878	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   115: astore 4
    //   117: ldc_w 881
    //   120: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload 4
    //   125: athrow
    //   126: astore 4
    //   128: aload_0
    //   129: aload_3
    //   130: iload 5
    //   132: invokespecial 874	com/eclipsesource/v8/V8:releaseArguments	([Ljava/lang/Object;Z)V
    //   135: ldc_w 881
    //   138: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 4
    //   143: athrow
    //   144: astore 4
    //   146: ldc_w 881
    //   149: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: athrow
    //   155: astore 4
    //   157: ldc_w 881
    //   160: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 4
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	V8
    //   0	166	1	paramLong	long
    //   0	166	3	paramV8Object	V8Object
    //   0	166	4	paramV8Array	V8Array
    //   60	71	5	bool	boolean
    //   22	63	6	localMethodDescriptor	MethodDescriptor
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
    AppMethodBeat.i(61847);
    if ((paramV8Value == null) || (paramV8Value.isUndefined()))
    {
      AppMethodBeat.o(61847);
      return;
    }
    paramV8Value = paramV8Value.getRuntime();
    if ((paramV8Value == null) || (paramV8Value.isReleased()) || (paramV8Value != this))
    {
      paramV8Value = new Error("Invalid target runtime");
      AppMethodBeat.o(61847);
      throw paramV8Value;
    }
    AppMethodBeat.o(61847);
  }
  
  void checkThread()
  {
    AppMethodBeat.i(61848);
    this.locker.checkThread();
    if (isReleased())
    {
      Error localError = new Error("Runtime disposed error");
      AppMethodBeat.o(61848);
      throw localError;
    }
    AppMethodBeat.o(61848);
  }
  
  protected void closeUVLoop()
  {
    AppMethodBeat.i(61794);
    _closeUVLoop(this.v8RuntimePtr);
    AppMethodBeat.o(61794);
  }
  
  protected boolean contains(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61886);
    boolean bool = _contains(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61886);
    return bool;
  }
  
  void createAndRegisterMethodDescriptor(JavaCallback paramJavaCallback, long paramLong)
  {
    AppMethodBeat.i(61853);
    MethodDescriptor localMethodDescriptor = new MethodDescriptor(null);
    localMethodDescriptor.callback = paramJavaCallback;
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(61853);
  }
  
  void createNodeRuntime(String paramString)
  {
    AppMethodBeat.i(61868);
    _startNodeJS(this.v8RuntimePtr, paramString);
    AppMethodBeat.o(61868);
  }
  
  protected void createTwin(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61876);
    _createTwin(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61876);
  }
  
  protected void createTwin(V8Value paramV8Value1, V8Value paramV8Value2)
  {
    AppMethodBeat.i(61822);
    checkThread();
    createTwin(this.v8RuntimePtr, paramV8Value1.getHandle(), paramV8Value2.getHandle());
    AppMethodBeat.o(61822);
  }
  
  protected ByteBuffer createV8ArrayBufferBackingStore(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61925);
    ByteBuffer localByteBuffer = _createV8ArrayBufferBackingStore(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61925);
    return localByteBuffer;
  }
  
  protected long createV8Context(int paramInt)
  {
    AppMethodBeat.i(61791);
    long l = _createContext(this.v8RuntimePtr, paramInt);
    AppMethodBeat.o(61791);
    return l;
  }
  
  public void debuggerMessageLoop()
  {
    AppMethodBeat.i(61967);
    checkThread();
    _debugMessageLoop(this.v8RuntimePtr);
    AppMethodBeat.o(61967);
  }
  
  protected void disposeMethodID(long paramLong)
  {
    AppMethodBeat.i(61856);
    this.functionRegistry.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(61856);
  }
  
  public void enableNativeTrans()
  {
    AppMethodBeat.i(196755);
    _enableNativeTrans(this.v8RuntimePtr);
    AppMethodBeat.o(196755);
  }
  
  protected boolean equals(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61900);
    boolean bool = _equals(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61900);
    return bool;
  }
  
  public V8Array executeArrayScript(String paramString)
  {
    AppMethodBeat.i(61832);
    paramString = executeArrayScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61832);
    return paramString;
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61833);
    paramString1 = executeArrayScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61833);
    return paramString1;
  }
  
  public V8Array executeArrayScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61834);
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    if ((paramString1 instanceof V8Array))
    {
      paramString1 = (V8Array)paramString1;
      AppMethodBeat.o(61834);
      return paramString1;
    }
    paramString1 = new V8ResultUndefined();
    AppMethodBeat.o(61834);
    throw paramString1;
  }
  
  protected boolean executeBooleanFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61896);
    boolean bool = _executeBooleanFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61896);
    return bool;
  }
  
  protected boolean executeBooleanScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61880);
    boolean bool = _executeBooleanScript(paramLong, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61880);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString)
  {
    AppMethodBeat.i(61829);
    boolean bool = executeBooleanScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61829);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61830);
    boolean bool = executeBooleanScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61830);
    return bool;
  }
  
  public boolean executeBooleanScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61831);
    checkThread();
    checkScript(paramString1);
    boolean bool = executeBooleanScript(this.v8RuntimePtr, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61831);
    return bool;
  }
  
  public String executeDebugScript(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61965);
    checkThread();
    checkScript(paramString1);
    paramString1 = _executeDebugScript(this.v8RuntimePtr, paramString1, paramString2);
    AppMethodBeat.o(61965);
    return paramString1;
  }
  
  protected double executeDoubleFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61894);
    double d = _executeDoubleFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61894);
    return d;
  }
  
  protected double executeDoubleScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61878);
    double d = _executeDoubleScript(paramLong, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61878);
    return d;
  }
  
  public double executeDoubleScript(String paramString)
  {
    AppMethodBeat.i(61823);
    double d = executeDoubleScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61823);
    return d;
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61824);
    double d = executeDoubleScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61824);
    return d;
  }
  
  public double executeDoubleScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61825);
    checkThread();
    checkScript(paramString1);
    double d = executeDoubleScript(this.v8RuntimePtr, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61825);
    return d;
  }
  
  protected Object executeFunction(long paramLong1, int paramInt, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61897);
    paramString = _executeFunction(paramLong1, paramInt, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61897);
    return paramString;
  }
  
  protected Object executeFunction(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(61898);
    Object localObject = _executeFunction(paramLong1, paramLong2, paramLong3, paramLong4);
    AppMethodBeat.o(61898);
    return localObject;
  }
  
  protected int executeIntegerFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61893);
    int i = _executeIntegerFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61893);
    return i;
  }
  
  protected int executeIntegerScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61877);
    paramInt1 = _executeIntegerScript(paramLong, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61877);
    return paramInt1;
  }
  
  public int executeIntegerScript(String paramString)
  {
    AppMethodBeat.i(61819);
    int i = executeIntegerScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61819);
    return i;
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61820);
    paramInt = executeIntegerScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61820);
    return paramInt;
  }
  
  public int executeIntegerScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61821);
    checkThread();
    checkScript(paramString1);
    paramInt1 = executeIntegerScript(this.v8RuntimePtr, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61821);
    return paramInt1;
  }
  
  public V8Object executeObjectScript(String paramString)
  {
    AppMethodBeat.i(61838);
    paramString = executeObjectScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61838);
    return paramString;
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61839);
    paramString1 = executeObjectScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61839);
    return paramString1;
  }
  
  public V8Object executeObjectScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61840);
    checkThread();
    paramString1 = executeScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    if ((paramString1 instanceof V8Object))
    {
      paramString1 = (V8Object)paramString1;
      AppMethodBeat.o(61840);
      return paramString1;
    }
    paramString1 = new V8ResultUndefined();
    AppMethodBeat.o(61840);
    throw paramString1;
  }
  
  protected Object executeScript(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61881);
    paramString1 = _executeScript(paramLong, paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramExecuteDetails);
    AppMethodBeat.o(61881);
    return paramString1;
  }
  
  public Object executeScript(String paramString)
  {
    AppMethodBeat.i(61835);
    paramString = executeScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61835);
    return paramString;
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61836);
    paramString1 = executeScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61836);
    return paramString1;
  }
  
  public Object executeScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61837);
    checkThread();
    checkScript(paramString1);
    paramString1 = executeScript(getV8RuntimePtr(), 0, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61837);
    return paramString1;
  }
  
  protected String executeStringFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61895);
    paramString = _executeStringFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61895);
    return paramString;
  }
  
  protected String executeStringScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61879);
    paramString1 = _executeStringScript(paramLong, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61879);
    return paramString1;
  }
  
  public String executeStringScript(String paramString)
  {
    AppMethodBeat.i(61826);
    paramString = executeStringScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61826);
    return paramString;
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61827);
    paramString1 = executeStringScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61827);
    return paramString1;
  }
  
  public String executeStringScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61828);
    checkThread();
    checkScript(paramString1);
    paramString1 = executeStringScript(this.v8RuntimePtr, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61828);
    return paramString1;
  }
  
  protected void executeVoidFunction(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(61899);
    _executeVoidFunction(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(61899);
  }
  
  protected void executeVoidScript(long paramLong, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61882);
    _executeVoidScript(paramLong, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61882);
  }
  
  public void executeVoidScript(String paramString)
  {
    AppMethodBeat.i(61841);
    executeVoidScript(paramString, null, 0, null, null, 0, null);
    AppMethodBeat.o(61841);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61842);
    executeVoidScript(paramString1, paramString2, paramInt, null, null, 0, null);
    AppMethodBeat.o(61842);
  }
  
  public void executeVoidScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(61843);
    checkThread();
    checkScript(paramString1);
    executeVoidScript(this.v8RuntimePtr, paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(61843);
  }
  
  protected Object executeWxaScript(long paramLong, ArrayList<ScriptPartObject> paramArrayList, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(175413);
    paramArrayList = _executeWxaScript(paramLong, paramArrayList, paramInt1, paramString1, paramInt2, paramString2, paramString3, paramInt3, paramExecuteDetails);
    AppMethodBeat.o(175413);
    return paramArrayList;
  }
  
  public Object executeWxaScript(ArrayList<ScriptPartObject> paramArrayList, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, ExecuteDetails paramExecuteDetails)
  {
    AppMethodBeat.i(175412);
    checkThread();
    paramArrayList = executeWxaScript(this.v8RuntimePtr, paramArrayList, 0, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramExecuteDetails);
    AppMethodBeat.o(175412);
    return paramArrayList;
  }
  
  protected Object get(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61892);
    paramString = _get(paramLong1, paramInt, paramLong2, paramString);
    AppMethodBeat.o(61892);
    return paramString;
  }
  
  protected int getArrayType(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61945);
    int i = _getArrayType(paramLong1, paramLong2);
    AppMethodBeat.o(61945);
    return i;
  }
  
  protected boolean getBoolean(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61889);
    boolean bool = _getBoolean(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61889);
    return bool;
  }
  
  public long getBuildID()
  {
    AppMethodBeat.i(61844);
    long l = _getBuildID();
    AppMethodBeat.o(61844);
    return l;
  }
  
  public Object getData(String paramString)
  {
    AppMethodBeat.i(61801);
    if (this.data == null)
    {
      AppMethodBeat.o(61801);
      return null;
    }
    paramString = this.data.get(paramString);
    AppMethodBeat.o(61801);
    return paramString;
  }
  
  protected double getDouble(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61890);
    double d = _getDouble(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61890);
    return d;
  }
  
  public V8Executor getExecutor(V8Object paramV8Object)
  {
    AppMethodBeat.i(61816);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(61816);
      return null;
    }
    paramV8Object = (V8Executor)this.executors.get(paramV8Object);
    AppMethodBeat.o(61816);
    return paramV8Object;
  }
  
  protected long getGlobalObject()
  {
    AppMethodBeat.i(61872);
    long l = _getGlobalObject(this.v8RuntimePtr);
    AppMethodBeat.o(61872);
    return l;
  }
  
  protected int getInteger(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61888);
    int i = _getInteger(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61888);
    return i;
  }
  
  protected long getIsolatePtr()
  {
    AppMethodBeat.i(61960);
    long l = _getIsolatePtr(this.v8RuntimePtr);
    AppMethodBeat.o(61960);
    return l;
  }
  
  protected String[] getKeys(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61887);
    String[] arrayOfString = _getKeys(paramLong1, paramLong2);
    AppMethodBeat.o(61887);
    return arrayOfString;
  }
  
  public V8Locker getLocker()
  {
    return this.locker;
  }
  
  public long getObjectReferenceCount()
  {
    AppMethodBeat.i(61807);
    long l1 = this.objectReferences;
    long l2 = this.v8WeakReferences.size();
    AppMethodBeat.o(61807);
    return l1 - l2;
  }
  
  protected String getString(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61891);
    paramString = _getString(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61891);
    return paramString;
  }
  
  protected int getType(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61942);
    int i = _getType(paramLong1, paramLong2);
    AppMethodBeat.o(61942);
    return i;
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(61944);
    paramInt = _getType(paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(61944);
    return paramInt;
  }
  
  protected int getType(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61946);
    paramInt1 = _getType(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61946);
    return paramInt1;
  }
  
  protected int getType(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(61943);
    int i = _getType(paramLong1, paramLong2, paramString);
    AppMethodBeat.o(61943);
    return i;
  }
  
  protected long getUVLoopPtr()
  {
    AppMethodBeat.i(61961);
    long l = _getUVLoopPtr(this.v8RuntimePtr);
    AppMethodBeat.o(61961);
    return l;
  }
  
  protected long getV8RuntimePtr()
  {
    return this.v8RuntimePtr;
  }
  
  protected int identityHash(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61904);
    int i = _identityHash(paramLong1, paramLong2);
    AppMethodBeat.o(61904);
    return i;
  }
  
  protected long initNewSharedV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(61914);
    paramLong = _initNewSharedV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
    AppMethodBeat.o(61914);
    return paramLong;
  }
  
  protected long initNewV8Array(long paramLong)
  {
    AppMethodBeat.i(61926);
    paramLong = _initNewV8Array(paramLong);
    AppMethodBeat.o(61926);
    return paramLong;
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, int paramInt)
  {
    AppMethodBeat.i(61915);
    paramLong = _initNewV8ArrayBuffer(paramLong, paramInt);
    AppMethodBeat.o(61915);
    return paramLong;
  }
  
  protected long initNewV8ArrayBuffer(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(61913);
    paramLong = _initNewV8ArrayBuffer(paramLong, paramByteBuffer, paramInt);
    AppMethodBeat.o(61913);
    return paramLong;
  }
  
  public long initNewV8Float32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61917);
    paramLong1 = _initNewV8Float32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61917);
    return paramLong1;
  }
  
  public long initNewV8Float64Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61918);
    paramLong1 = _initNewV8Float64Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61918);
    return paramLong1;
  }
  
  protected long[] initNewV8Function(long paramLong)
  {
    AppMethodBeat.i(61927);
    checkThread();
    long[] arrayOfLong = _initNewV8Function(paramLong);
    AppMethodBeat.o(61927);
    return arrayOfLong;
  }
  
  public long initNewV8Int16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61921);
    paramLong1 = _initNewV8Int16Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61921);
    return paramLong1;
  }
  
  public long initNewV8Int32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61916);
    paramLong1 = _initNewV8Int32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61916);
    return paramLong1;
  }
  
  public long initNewV8Int8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61923);
    paramLong1 = _initNewV8Int8Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61923);
    return paramLong1;
  }
  
  protected long initNewV8Object(long paramLong)
  {
    AppMethodBeat.i(61871);
    paramLong = _initNewV8Object(paramLong);
    AppMethodBeat.o(61871);
    return paramLong;
  }
  
  public long initNewV8UInt16Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61920);
    paramLong1 = _initNewV8UInt16Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61920);
    return paramLong1;
  }
  
  public long initNewV8UInt32Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61919);
    paramLong1 = _initNewV8UInt32Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61919);
    return paramLong1;
  }
  
  public long initNewV8UInt8Array(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61922);
    paramLong1 = _initNewV8UInt8Array(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61922);
    return paramLong1;
  }
  
  public long initNewV8UInt8ClampedArray(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61924);
    paramLong1 = _initNewV8UInt8ClampedArray(paramLong1, paramLong2, paramInt1, paramInt2);
    AppMethodBeat.o(61924);
    return paramLong1;
  }
  
  boolean isRunning()
  {
    AppMethodBeat.i(61870);
    boolean bool = _isRunning(this.v8RuntimePtr);
    AppMethodBeat.o(61870);
    return bool;
  }
  
  protected boolean isWeak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61884);
    boolean bool = _isWeak(paramLong1, paramLong2);
    AppMethodBeat.o(61884);
    return bool;
  }
  
  public void lowMemoryNotification()
  {
    AppMethodBeat.i(61845);
    checkThread();
    lowMemoryNotification(getV8RuntimePtr());
    AppMethodBeat.o(61845);
  }
  
  protected void lowMemoryNotification(long paramLong)
  {
    AppMethodBeat.i(61875);
    _lowMemoryNotification(paramLong);
    AppMethodBeat.o(61875);
  }
  
  public void memoryPressureNotification(int paramInt)
  {
    AppMethodBeat.i(61846);
    _memoryPressureNotification(this.v8RuntimePtr, paramInt);
    AppMethodBeat.o(61846);
  }
  
  public void nativeDispatch()
  {
    AppMethodBeat.i(196750);
    _nativeDispatch(this.v8RuntimePtr);
    AppMethodBeat.o(196750);
  }
  
  public void nativeLoopStop()
  {
    AppMethodBeat.i(196751);
    _nativeLoopStop(this.v8RuntimePtr);
    AppMethodBeat.o(196751);
  }
  
  public void nativeMessageLoop()
  {
    AppMethodBeat.i(196749);
    _nativeMessageLoop(this.v8RuntimePtr);
    AppMethodBeat.o(196749);
  }
  
  protected void onNativeRunJavaTask()
  {
    AppMethodBeat.i(196752);
    if (this.nativeJavaCallback_ != null) {
      this.nativeJavaCallback_.run();
    }
    AppMethodBeat.o(196752);
  }
  
  protected void onNativeTransMsgDispatchByJava()
  {
    AppMethodBeat.i(196754);
    if (this._javaTaskScheduler != null) {
      this._javaTaskScheduler.Schedule(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(196748);
          V8.access$200(V8.this.v8RuntimePtr);
          AppMethodBeat.o(196748);
        }
      });
    }
    AppMethodBeat.o(196754);
  }
  
  boolean pumpMessageLoop()
  {
    AppMethodBeat.i(61869);
    boolean bool = _pumpMessageLoop(this.v8RuntimePtr);
    AppMethodBeat.o(61869);
    return bool;
  }
  
  void registerCallback(JavaCallback paramJavaCallback, long paramLong, String paramString)
  {
    AppMethodBeat.i(61852);
    createAndRegisterMethodDescriptor(paramJavaCallback, registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, false));
    AppMethodBeat.o(61852);
  }
  
  void registerCallback(Object paramObject, Method paramMethod, long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(61850);
    MethodDescriptor localMethodDescriptor = new MethodDescriptor(null);
    localMethodDescriptor.object = paramObject;
    localMethodDescriptor.method = paramMethod;
    localMethodDescriptor.includeReceiver = paramBoolean;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, isVoidMethod(paramMethod));
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(61850);
  }
  
  protected long registerJavaMethod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(61912);
    paramLong1 = _registerJavaMethod(paramLong1, paramLong2, paramString, paramBoolean);
    AppMethodBeat.o(61912);
    return paramLong1;
  }
  
  public void registerResource(Releasable paramReleasable)
  {
    AppMethodBeat.i(61818);
    checkThread();
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    this.resources.add(paramReleasable);
    AppMethodBeat.o(61818);
  }
  
  public void registerV8Executor(V8Object paramV8Object, V8Executor paramV8Executor)
  {
    AppMethodBeat.i(61814);
    checkThread();
    if (this.executors == null) {
      this.executors = new V8Map();
    }
    this.executors.put(paramV8Object, paramV8Executor);
    AppMethodBeat.o(61814);
  }
  
  void registerVoidCallback(JavaVoidCallback paramJavaVoidCallback, long paramLong, String paramString)
  {
    AppMethodBeat.i(61851);
    MethodDescriptor localMethodDescriptor = new MethodDescriptor(null);
    localMethodDescriptor.voidCallback = paramJavaVoidCallback;
    paramLong = registerJavaMethod(getV8RuntimePtr(), paramLong, paramString, true);
    this.functionRegistry.put(Long.valueOf(paramLong), localMethodDescriptor);
    AppMethodBeat.o(61851);
  }
  
  public void release()
  {
    AppMethodBeat.i(61809);
    release(true);
    AppMethodBeat.o(61809);
  }
  
  protected void release(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61885);
    _release(paramLong1, paramLong2);
    AppMethodBeat.o(61885);
  }
  
  public void release(boolean paramBoolean)
  {
    AppMethodBeat.i(61811);
    if (isReleased())
    {
      AppMethodBeat.o(61811);
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
        this.locker.release();
        _releaseRuntime(this.v8RuntimePtr);
        this.v8RuntimePtr = 0L;
        this.released = true;
        if ((paramBoolean) && (getObjectReferenceCount() > 0L))
        {
          ??? = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
          AppMethodBeat.o(61811);
          throw ((Throwable)???);
        }
      }
      AppMethodBeat.o(61811);
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
        this.locker.release();
        _releaseRuntime(this.v8RuntimePtr);
        this.v8RuntimePtr = 0L;
        this.released = true;
        if ((paramBoolean) && (getObjectReferenceCount() > 0L))
        {
          ??? = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
          AppMethodBeat.o(61811);
          throw ((Throwable)???);
        }
      }
      AppMethodBeat.o(61811);
    }
  }
  
  protected void releaseLock(long paramLong)
  {
    AppMethodBeat.i(61874);
    _releaseLock(paramLong);
    AppMethodBeat.o(61874);
  }
  
  protected void releaseMethodDescriptor(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61959);
    _releaseMethodDescriptor(paramLong1, paramLong2);
    AppMethodBeat.o(61959);
  }
  
  void releaseObjRef(V8Value paramV8Value)
  {
    AppMethodBeat.i(61963);
    if (!this.referenceHandlers.isEmpty()) {
      notifyReferenceDisposed(paramV8Value);
    }
    this.objectReferences -= 1L;
    AppMethodBeat.o(61963);
  }
  
  protected void releaseV8Context(long paramLong)
  {
    AppMethodBeat.i(61795);
    _releaseContext(this.v8RuntimePtr, paramLong);
    AppMethodBeat.o(61795);
  }
  
  public V8Executor removeExecutor(V8Object paramV8Object)
  {
    AppMethodBeat.i(61815);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(61815);
      return null;
    }
    paramV8Object = (V8Executor)this.executors.remove(paramV8Object);
    AppMethodBeat.o(61815);
    return paramV8Object;
  }
  
  public void removeReferenceHandler(ReferenceHandler paramReferenceHandler)
  {
    AppMethodBeat.i(61798);
    this.referenceHandlers.remove(paramReferenceHandler);
    AppMethodBeat.o(61798);
  }
  
  public void removeReleaseHandler(V8Runnable paramV8Runnable)
  {
    AppMethodBeat.i(61799);
    this.releaseHandlers.remove(paramV8Runnable);
    AppMethodBeat.o(61799);
  }
  
  protected boolean sameValue(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61903);
    boolean bool = _sameValue(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61903);
    return bool;
  }
  
  public void setData(String paramString, Object paramObject)
  {
    try
    {
      AppMethodBeat.i(61800);
      if (this.data == null) {
        this.data = new HashMap();
      }
      this.data.put(paramString, paramObject);
      AppMethodBeat.o(61800);
      return;
    }
    finally {}
  }
  
  public void setJavaTaskScheduler(JavaTaskScheduler paramJavaTaskScheduler)
  {
    AppMethodBeat.i(196753);
    this._javaTaskScheduler = paramJavaTaskScheduler;
    _nativeTransSetJavaSchedule(1L);
    AppMethodBeat.o(196753);
  }
  
  public void setNativeJavaCallback(Runnable paramRunnable)
  {
    this.nativeJavaCallback_ = paramRunnable;
  }
  
  protected void setPrototype(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61947);
    _setPrototype(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61947);
  }
  
  protected void setWeak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61883);
    _setWeak(paramLong1, paramLong2);
    AppMethodBeat.o(61883);
  }
  
  public void shutdownExecutors(boolean paramBoolean)
  {
    AppMethodBeat.i(61817);
    checkThread();
    if (this.executors == null)
    {
      AppMethodBeat.o(61817);
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
    AppMethodBeat.o(61817);
  }
  
  protected boolean strictEquals(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(61902);
    boolean bool = _strictEquals(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(61902);
    return bool;
  }
  
  protected void switchV8Context(long paramLong)
  {
    AppMethodBeat.i(61792);
    _switchContext(this.v8RuntimePtr, paramLong);
    AppMethodBeat.o(61792);
  }
  
  public void terminateExecution()
  {
    AppMethodBeat.i(61810);
    this.forceTerminateExecutors = true;
    terminateExecution(this.v8RuntimePtr);
    AppMethodBeat.o(61810);
  }
  
  protected void terminateExecution(long paramLong)
  {
    AppMethodBeat.i(61958);
    _terminateExecution(paramLong);
    AppMethodBeat.o(61958);
  }
  
  protected String toString(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(61901);
    String str = _toString(paramLong1, paramLong2);
    AppMethodBeat.o(61901);
    return str;
  }
  
  public void waitForDebugger(String paramString)
  {
    AppMethodBeat.i(61966);
    checkThread();
    _waitForDebuger(this.v8RuntimePtr, paramString);
    AppMethodBeat.o(61966);
  }
  
  protected void wakeUpUVLoop()
  {
    AppMethodBeat.i(61793);
    _wakeUpUVLoop(this.v8RuntimePtr);
    AppMethodBeat.o(61793);
  }
  
  protected void weakReferenceReleased(long paramLong)
  {
    AppMethodBeat.i(61857);
    V8Value localV8Value = (V8Value)this.v8WeakReferences.get(Long.valueOf(paramLong));
    if (localV8Value != null)
    {
      this.v8WeakReferences.remove(Long.valueOf(paramLong));
      try
      {
        localV8Value.release();
        AppMethodBeat.o(61857);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(61857);
  }
  
  public static abstract interface JavaTaskScheduler
  {
    public abstract void Schedule(Runnable paramRunnable);
  }
  
  class MethodDescriptor
  {
    JavaCallback callback;
    boolean includeReceiver;
    Method method;
    Object object;
    JavaVoidCallback voidCallback;
    
    private MethodDescriptor() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.V8
 * JD-Core Version:    0.7.0.1
 */