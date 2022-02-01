package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DebugHandler
  implements Releasable
{
  private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
  private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
  private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
  public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
  private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
  private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
  private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
  private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
  private static final String NUMBER = "number";
  private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
  private static final String SET_BREAK_POINT = "setBreakPoint";
  private static final String SET_LISTENER = "setListener";
  private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
  private static final String V8_DEBUG_OBJECT = "Debug";
  private List<BreakHandler> breakHandlers;
  private V8Object debugObject;
  private V8 runtime;
  
  public DebugHandler(V8 paramV8)
  {
    AppMethodBeat.i(61456);
    this.breakHandlers = new ArrayList();
    this.runtime = paramV8;
    setupDebugObject(paramV8);
    setupBreakpointHandler();
    AppMethodBeat.o(61456);
  }
  
  /* Error */
  private void setupBreakpointHandler()
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 10	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler
    //   8: dup
    //   9: aload_0
    //   10: aconst_null
    //   11: invokespecial 102	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:<init>	(Lcom/eclipsesource/v8/debug/DebugHandler;Lcom/eclipsesource/v8/debug/DebugHandler$1;)V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 104	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   19: aload_1
    //   20: ldc 24
    //   22: invokevirtual 110	com/eclipsesource/v8/V8Object:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   25: pop
    //   26: aload_0
    //   27: getfield 104	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   30: ldc 24
    //   32: invokevirtual 114	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   35: checkcast 116	com/eclipsesource/v8/V8Function
    //   38: astore_1
    //   39: new 118	com/eclipsesource/v8/V8Array
    //   42: dup
    //   43: aload_0
    //   44: getfield 87	com/eclipsesource/v8/debug/DebugHandler:runtime	Lcom/eclipsesource/v8/V8;
    //   47: invokespecial 120	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   50: aload_1
    //   51: invokevirtual 124	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 104	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   59: ldc 49
    //   61: aload_2
    //   62: invokevirtual 128	com/eclipsesource/v8/V8Object:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   65: pop
    //   66: aload_1
    //   67: ifnull +14 -> 81
    //   70: aload_1
    //   71: invokevirtual 132	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   74: ifne +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 135	com/eclipsesource/v8/V8Function:release	()V
    //   81: aload_2
    //   82: ifnull +62 -> 144
    //   85: aload_2
    //   86: invokevirtual 136	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   89: ifne +55 -> 144
    //   92: aload_2
    //   93: invokevirtual 137	com/eclipsesource/v8/V8Array:release	()V
    //   96: ldc 99
    //   98: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +14 -> 122
    //   111: aload_3
    //   112: invokevirtual 132	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   115: ifne +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 135	com/eclipsesource/v8/V8Function:release	()V
    //   122: aload_2
    //   123: ifnull +14 -> 137
    //   126: aload_2
    //   127: invokevirtual 136	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   130: ifne +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 137	com/eclipsesource/v8/V8Array:release	()V
    //   137: ldc 99
    //   139: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: ldc 99
    //   146: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_1
    //   155: astore_3
    //   156: aload 4
    //   158: astore_1
    //   159: goto -52 -> 107
    //   162: astore 4
    //   164: aload_1
    //   165: astore_3
    //   166: aload 4
    //   168: astore_1
    //   169: goto -62 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	DebugHandler
    //   14	64	1	localObject1	Object
    //   102	53	1	localObject2	Object
    //   158	11	1	localObject3	Object
    //   54	100	2	localV8Array	V8Array
    //   106	60	3	localObject4	Object
    //   150	7	4	localObject5	Object
    //   162	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   26	39	102	finally
    //   39	55	150	finally
    //   55	66	162	finally
  }
  
  private void setupDebugObject(V8 paramV8)
  {
    AppMethodBeat.i(61470);
    paramV8 = paramV8.getObject(DEBUG_OBJECT_NAME);
    try
    {
      this.debugObject = paramV8.getObject("Debug");
      return;
    }
    finally
    {
      paramV8.release();
      AppMethodBeat.o(61470);
    }
  }
  
  public void addBreakHandler(BreakHandler paramBreakHandler)
  {
    AppMethodBeat.i(61457);
    this.runtime.getLocker().checkThread();
    this.breakHandlers.add(paramBreakHandler);
    AppMethodBeat.o(61457);
  }
  
  public void changeBreakPointCondition(int paramInt, String paramString)
  {
    AppMethodBeat.i(61468);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramInt);
    localV8Array.push(paramString);
    try
    {
      this.debugObject.executeVoidFunction("changeBreakPointCondition", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61468);
    }
  }
  
  public void clearBreakPoint(int paramInt)
  {
    AppMethodBeat.i(61463);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramInt);
    try
    {
      this.debugObject.executeVoidFunction("clearBreakPoint", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61463);
    }
  }
  
  public void disableAllBreakPoints()
  {
    AppMethodBeat.i(61464);
    this.debugObject.executeVoidFunction("disableAllBreakPoints", null);
    AppMethodBeat.o(61464);
  }
  
  public void disableScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(61462);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramInt);
    try
    {
      this.debugObject.executeVoidFunction("disableScriptBreakPoint", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61462);
    }
  }
  
  public void enableScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(61461);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramInt);
    try
    {
      this.debugObject.executeVoidFunction("enableScriptBreakPoint", localV8Array);
      return;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61461);
    }
  }
  
  public ScriptBreakPoint getScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(61467);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramInt);
    localV8Array.push(false);
    Object localObject1 = null;
    try
    {
      V8Object localV8Object = this.debugObject.executeObjectFunction("findScriptBreakPoint", localV8Array);
      localObject1 = localV8Object;
      ScriptBreakPoint localScriptBreakPoint = new ScriptBreakPoint(localV8Object);
      return localScriptBreakPoint;
    }
    finally
    {
      localV8Array.release();
      if (localObject1 != null) {
        localObject1.release();
      }
      AppMethodBeat.o(61467);
    }
  }
  
  public int getScriptBreakPointCount()
  {
    AppMethodBeat.i(61465);
    V8Array localV8Array = this.debugObject.executeArrayFunction("scriptBreakPoints", null);
    try
    {
      int i = localV8Array.length();
      return i;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61465);
    }
  }
  
  public int[] getScriptBreakPointIDs()
  {
    AppMethodBeat.i(61466);
    V8Array localV8Array = this.debugObject.executeArrayFunction("scriptBreakPoints", null);
    try
    {
      arrayOfInt1 = new int[localV8Array.length()];
      i = 0;
    }
    finally
    {
      try
      {
        int[] arrayOfInt1;
        int i;
        arrayOfInt1[i] = localV8Object.executeIntegerFunction("number", null);
        localV8Object.release();
        i += 1;
      }
      finally
      {
        V8Object localV8Object;
        localV8Object.release();
        AppMethodBeat.o(61466);
      }
      AppMethodBeat.o(61466);
    }
    if (i < localV8Array.length()) {
      localV8Object = localV8Array.getObject(i);
    }
    localV8Array.release();
    AppMethodBeat.o(61466);
    return arrayOfInt2;
  }
  
  public void release()
  {
    AppMethodBeat.i(61469);
    this.debugObject.release();
    AppMethodBeat.o(61469);
  }
  
  public void removeBreakHandler(BreakHandler paramBreakHandler)
  {
    AppMethodBeat.i(61458);
    this.runtime.getLocker().checkThread();
    this.breakHandlers.remove(paramBreakHandler);
    AppMethodBeat.o(61458);
  }
  
  public int setBreakpoint(V8Function paramV8Function)
  {
    AppMethodBeat.i(61459);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramV8Function);
    try
    {
      int i = this.debugObject.executeIntegerFunction("setBreakPoint", localV8Array);
      return i;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61459);
    }
  }
  
  public int setScriptBreakpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(61460);
    V8Array localV8Array = new V8Array(this.runtime);
    localV8Array.push(paramString);
    localV8Array.push(paramInt);
    try
    {
      paramInt = this.debugObject.executeIntegerFunction("setScriptBreakPointByName", localV8Array);
      return paramInt;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(61460);
    }
  }
  
  class BreakpointHandler
    implements JavaVoidCallback
  {
    private BreakpointHandler() {}
    
    private EventData createDebugEvent(DebugHandler.DebugEvent paramDebugEvent, V8Object paramV8Object)
    {
      AppMethodBeat.i(61451);
      switch (DebugHandler.1.$SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[paramDebugEvent.ordinal()])
      {
      default: 
        paramDebugEvent = new EventData(paramV8Object);
        AppMethodBeat.o(61451);
        return paramDebugEvent;
      case 1: 
        paramDebugEvent = new BreakEvent(paramV8Object);
        AppMethodBeat.o(61451);
        return paramDebugEvent;
      case 2: 
        paramDebugEvent = new CompileEvent(paramV8Object);
        AppMethodBeat.o(61451);
        return paramDebugEvent;
      case 3: 
        paramDebugEvent = new CompileEvent(paramV8Object);
        AppMethodBeat.o(61451);
        return paramDebugEvent;
      }
      paramDebugEvent = new ExceptionEvent(paramV8Object);
      AppMethodBeat.o(61451);
      return paramDebugEvent;
    }
    
    /* Error */
    private void invokeHandler(V8Array paramV8Array, int paramInt, BreakHandler paramBreakHandler)
    {
      // Byte code:
      //   0: ldc 63
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: iconst_1
      //   7: invokevirtual 69	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   10: astore 7
      //   12: aload_1
      //   13: iconst_2
      //   14: invokevirtual 69	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   17: astore 6
      //   19: aload_1
      //   20: iconst_3
      //   21: invokevirtual 69	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
      //   24: astore 5
      //   26: new 71	com/eclipsesource/v8/debug/ExecutionState
      //   29: dup
      //   30: aload 7
      //   32: invokespecial 72	com/eclipsesource/v8/debug/ExecutionState:<init>	(Lcom/eclipsesource/v8/V8Object;)V
      //   35: astore 8
      //   37: invokestatic 76	com/eclipsesource/v8/debug/DebugHandler$DebugEvent:values	()[Lcom/eclipsesource/v8/debug/DebugHandler$DebugEvent;
      //   40: iload_2
      //   41: aaload
      //   42: astore_1
      //   43: aload_0
      //   44: aload_1
      //   45: aload 6
      //   47: invokespecial 78	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:createDebugEvent	(Lcom/eclipsesource/v8/debug/DebugHandler$DebugEvent;Lcom/eclipsesource/v8/V8Object;)Lcom/eclipsesource/v8/debug/EventData;
      //   50: astore 4
      //   52: aload_3
      //   53: aload_1
      //   54: aload 8
      //   56: aload 4
      //   58: aload 5
      //   60: invokeinterface 84 5 0
      //   65: aload_0
      //   66: aload 7
      //   68: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   71: aload_0
      //   72: aload 6
      //   74: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   77: aload_0
      //   78: aload 5
      //   80: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   83: aload_0
      //   84: aload 8
      //   86: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   89: aload_0
      //   90: aload 4
      //   92: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   95: ldc 63
      //   97: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   100: return
      //   101: astore_1
      //   102: aconst_null
      //   103: astore_3
      //   104: aconst_null
      //   105: astore 4
      //   107: aconst_null
      //   108: astore 5
      //   110: aconst_null
      //   111: astore 6
      //   113: aconst_null
      //   114: astore 7
      //   116: aload_0
      //   117: aload 7
      //   119: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   122: aload_0
      //   123: aload 6
      //   125: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   128: aload_0
      //   129: aload 5
      //   131: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   134: aload_0
      //   135: aload 4
      //   137: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   140: aload_0
      //   141: aload_3
      //   142: invokespecial 88	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
      //   145: ldc 63
      //   147: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   150: aload_1
      //   151: athrow
      //   152: astore_1
      //   153: aconst_null
      //   154: astore_3
      //   155: aconst_null
      //   156: astore 4
      //   158: aconst_null
      //   159: astore 5
      //   161: aconst_null
      //   162: astore 6
      //   164: goto -48 -> 116
      //   167: astore_1
      //   168: aconst_null
      //   169: astore_3
      //   170: aconst_null
      //   171: astore 4
      //   173: aconst_null
      //   174: astore 5
      //   176: goto -60 -> 116
      //   179: astore_1
      //   180: aconst_null
      //   181: astore_3
      //   182: aconst_null
      //   183: astore 4
      //   185: goto -69 -> 116
      //   188: astore_1
      //   189: aconst_null
      //   190: astore_3
      //   191: aload 8
      //   193: astore 4
      //   195: goto -79 -> 116
      //   198: astore_1
      //   199: aload 4
      //   201: astore_3
      //   202: aload 8
      //   204: astore 4
      //   206: goto -90 -> 116
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	209	0	this	BreakpointHandler
      //   0	209	1	paramV8Array	V8Array
      //   0	209	2	paramInt	int
      //   0	209	3	paramBreakHandler	BreakHandler
      //   50	155	4	localObject	Object
      //   24	151	5	localV8Object1	V8Object
      //   17	146	6	localV8Object2	V8Object
      //   10	108	7	localV8Object3	V8Object
      //   35	168	8	localExecutionState	ExecutionState
      // Exception table:
      //   from	to	target	type
      //   5	12	101	finally
      //   12	19	152	finally
      //   19	26	167	finally
      //   26	37	179	finally
      //   37	52	188	finally
      //   52	65	198	finally
    }
    
    private void safeRelease(Releasable paramReleasable)
    {
      AppMethodBeat.i(61452);
      if (paramReleasable != null) {
        paramReleasable.release();
      }
      AppMethodBeat.o(61452);
    }
    
    public void invoke(V8Object paramV8Object, V8Array paramV8Array)
    {
      AppMethodBeat.i(61449);
      if ((paramV8Array == null) || (paramV8Array.isUndefined()))
      {
        AppMethodBeat.o(61449);
        return;
      }
      int i = paramV8Array.getInteger(0);
      paramV8Object = DebugHandler.this.breakHandlers.iterator();
      while (paramV8Object.hasNext()) {
        invokeHandler(paramV8Array, i, (BreakHandler)paramV8Object.next());
      }
      AppMethodBeat.o(61449);
    }
  }
  
  public static enum DebugEvent
  {
    int index;
    
    static
    {
      AppMethodBeat.i(61455);
      Undefined = new DebugEvent("Undefined", 0, 0);
      Break = new DebugEvent("Break", 1, 1);
      Exception = new DebugEvent("Exception", 2, 2);
      NewFunction = new DebugEvent("NewFunction", 3, 3);
      BeforeCompile = new DebugEvent("BeforeCompile", 4, 4);
      AfterCompile = new DebugEvent("AfterCompile", 5, 5);
      CompileError = new DebugEvent("CompileError", 6, 6);
      PromiseError = new DebugEvent("PromiseError", 7, 7);
      AsyncTaskEvent = new DebugEvent("AsyncTaskEvent", 8, 8);
      $VALUES = new DebugEvent[] { Undefined, Break, Exception, NewFunction, BeforeCompile, AfterCompile, CompileError, PromiseError, AsyncTaskEvent };
      AppMethodBeat.o(61455);
    }
    
    private DebugEvent(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler
 * JD-Core Version:    0.7.0.1
 */