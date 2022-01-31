package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
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
    AppMethodBeat.i(74833);
    this.breakHandlers = new ArrayList();
    this.runtime = paramV8;
    setupDebugObject(paramV8);
    setupBreakpointHandler();
    AppMethodBeat.o(74833);
  }
  
  /* Error */
  private void setupBreakpointHandler()
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 10	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler
    //   8: dup
    //   9: aload_0
    //   10: aconst_null
    //   11: invokespecial 100	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:<init>	(Lcom/eclipsesource/v8/debug/DebugHandler;Lcom/eclipsesource/v8/debug/DebugHandler$1;)V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 102	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   19: aload_1
    //   20: ldc 22
    //   22: invokevirtual 108	com/eclipsesource/v8/V8Object:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   25: pop
    //   26: aload_0
    //   27: getfield 102	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   30: ldc 22
    //   32: invokevirtual 112	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   35: checkcast 114	com/eclipsesource/v8/V8Function
    //   38: astore_1
    //   39: new 116	com/eclipsesource/v8/V8Array
    //   42: dup
    //   43: aload_0
    //   44: getfield 85	com/eclipsesource/v8/debug/DebugHandler:runtime	Lcom/eclipsesource/v8/V8;
    //   47: invokespecial 118	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   50: aload_1
    //   51: invokevirtual 122	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 102	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   59: ldc 47
    //   61: aload_2
    //   62: invokevirtual 126	com/eclipsesource/v8/V8Object:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   65: pop
    //   66: aload_1
    //   67: ifnull +14 -> 81
    //   70: aload_1
    //   71: invokevirtual 130	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   74: ifne +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 133	com/eclipsesource/v8/V8Function:release	()V
    //   81: aload_2
    //   82: ifnull +62 -> 144
    //   85: aload_2
    //   86: invokevirtual 134	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   89: ifne +55 -> 144
    //   92: aload_2
    //   93: invokevirtual 135	com/eclipsesource/v8/V8Array:release	()V
    //   96: ldc 97
    //   98: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +14 -> 122
    //   111: aload_3
    //   112: invokevirtual 130	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   115: ifne +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 133	com/eclipsesource/v8/V8Function:release	()V
    //   122: aload_2
    //   123: ifnull +14 -> 137
    //   126: aload_2
    //   127: invokevirtual 134	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   130: ifne +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 135	com/eclipsesource/v8/V8Array:release	()V
    //   137: ldc 97
    //   139: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: ldc 97
    //   146: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(74847);
    paramV8 = paramV8.getObject(DEBUG_OBJECT_NAME);
    try
    {
      this.debugObject = paramV8.getObject("Debug");
      return;
    }
    finally
    {
      paramV8.release();
      AppMethodBeat.o(74847);
    }
  }
  
  public void addBreakHandler(BreakHandler paramBreakHandler)
  {
    AppMethodBeat.i(74834);
    this.runtime.getLocker().checkThread();
    this.breakHandlers.add(paramBreakHandler);
    AppMethodBeat.o(74834);
  }
  
  public void changeBreakPointCondition(int paramInt, String paramString)
  {
    AppMethodBeat.i(74845);
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
      AppMethodBeat.o(74845);
    }
  }
  
  public void clearBreakPoint(int paramInt)
  {
    AppMethodBeat.i(74840);
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
      AppMethodBeat.o(74840);
    }
  }
  
  public void disableAllBreakPoints()
  {
    AppMethodBeat.i(74841);
    this.debugObject.executeVoidFunction("disableAllBreakPoints", null);
    AppMethodBeat.o(74841);
  }
  
  public void disableScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(74839);
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
      AppMethodBeat.o(74839);
    }
  }
  
  public void enableScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(74838);
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
      AppMethodBeat.o(74838);
    }
  }
  
  public ScriptBreakPoint getScriptBreakPoint(int paramInt)
  {
    AppMethodBeat.i(74844);
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
      AppMethodBeat.o(74844);
    }
  }
  
  public int getScriptBreakPointCount()
  {
    AppMethodBeat.i(74842);
    V8Array localV8Array = this.debugObject.executeArrayFunction("scriptBreakPoints", null);
    try
    {
      int i = localV8Array.length();
      return i;
    }
    finally
    {
      localV8Array.release();
      AppMethodBeat.o(74842);
    }
  }
  
  public int[] getScriptBreakPointIDs()
  {
    AppMethodBeat.i(74843);
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
        AppMethodBeat.o(74843);
      }
      AppMethodBeat.o(74843);
    }
    if (i < localV8Array.length()) {
      localV8Object = localV8Array.getObject(i);
    }
    localV8Array.release();
    AppMethodBeat.o(74843);
    return arrayOfInt2;
  }
  
  public void release()
  {
    AppMethodBeat.i(74846);
    this.debugObject.release();
    AppMethodBeat.o(74846);
  }
  
  public void removeBreakHandler(BreakHandler paramBreakHandler)
  {
    AppMethodBeat.i(74835);
    this.runtime.getLocker().checkThread();
    this.breakHandlers.remove(paramBreakHandler);
    AppMethodBeat.o(74835);
  }
  
  public int setBreakpoint(V8Function paramV8Function)
  {
    AppMethodBeat.i(74836);
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
      AppMethodBeat.o(74836);
    }
  }
  
  public int setScriptBreakpoint(String paramString, int paramInt)
  {
    AppMethodBeat.i(74837);
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
      AppMethodBeat.o(74837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler
 * JD-Core Version:    0.7.0.1
 */