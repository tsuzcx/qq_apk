package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8Object;
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
  private List<BreakHandler> breakHandlers = new ArrayList();
  private V8Object debugObject;
  private V8 runtime;
  
  public DebugHandler(V8 paramV8)
  {
    this.runtime = paramV8;
    setupDebugObject(paramV8);
    setupBreakpointHandler();
  }
  
  /* Error */
  private void setupBreakpointHandler()
  {
    // Byte code:
    //   0: new 10	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: invokespecial 89	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:<init>	(Lcom/eclipsesource/v8/debug/DebugHandler;Lcom/eclipsesource/v8/debug/DebugHandler$1;)V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 91	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   14: aload_1
    //   15: ldc 22
    //   17: invokevirtual 97	com/eclipsesource/v8/V8Object:registerJavaMethod	(Lcom/eclipsesource/v8/JavaVoidCallback;Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   20: pop
    //   21: aload_0
    //   22: getfield 91	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   25: ldc 22
    //   27: invokevirtual 101	com/eclipsesource/v8/V8Object:getObject	(Ljava/lang/String;)Lcom/eclipsesource/v8/V8Object;
    //   30: checkcast 103	com/eclipsesource/v8/V8Function
    //   33: astore_1
    //   34: new 105	com/eclipsesource/v8/V8Array
    //   37: dup
    //   38: aload_0
    //   39: getfield 78	com/eclipsesource/v8/debug/DebugHandler:runtime	Lcom/eclipsesource/v8/V8;
    //   42: invokespecial 107	com/eclipsesource/v8/V8Array:<init>	(Lcom/eclipsesource/v8/V8;)V
    //   45: aload_1
    //   46: invokevirtual 111	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 91	com/eclipsesource/v8/debug/DebugHandler:debugObject	Lcom/eclipsesource/v8/V8Object;
    //   54: ldc 47
    //   56: aload_2
    //   57: invokevirtual 115	com/eclipsesource/v8/V8Object:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_1
    //   62: ifnull +14 -> 76
    //   65: aload_1
    //   66: invokevirtual 119	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   69: ifne +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 122	com/eclipsesource/v8/V8Function:release	()V
    //   76: aload_2
    //   77: ifnull +14 -> 91
    //   80: aload_2
    //   81: invokevirtual 123	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   84: ifne +7 -> 91
    //   87: aload_2
    //   88: invokevirtual 124	com/eclipsesource/v8/V8Array:release	()V
    //   91: return
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull +14 -> 112
    //   101: aload_3
    //   102: invokevirtual 119	com/eclipsesource/v8/V8Function:isReleased	()Z
    //   105: ifne +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 122	com/eclipsesource/v8/V8Function:release	()V
    //   112: aload_2
    //   113: ifnull +14 -> 127
    //   116: aload_2
    //   117: invokevirtual 123	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   120: ifne +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 124	com/eclipsesource/v8/V8Array:release	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_1
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: goto -41 -> 97
    //   141: astore 4
    //   143: aload_1
    //   144: astore_3
    //   145: aload 4
    //   147: astore_1
    //   148: goto -51 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DebugHandler
    //   9	64	1	localObject1	Object
    //   92	42	1	localObject2	Object
    //   137	11	1	localObject3	Object
    //   49	84	2	localV8Array	V8Array
    //   96	49	3	localObject4	Object
    //   129	7	4	localObject5	Object
    //   141	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	92	finally
    //   34	50	129	finally
    //   50	61	141	finally
  }
  
  private void setupDebugObject(V8 paramV8)
  {
    paramV8 = paramV8.getObject(DEBUG_OBJECT_NAME);
    try
    {
      this.debugObject = paramV8.getObject("Debug");
      return;
    }
    finally
    {
      paramV8.release();
    }
  }
  
  public void addBreakHandler(BreakHandler paramBreakHandler)
  {
    this.runtime.getLocker().checkThread();
    this.breakHandlers.add(paramBreakHandler);
  }
  
  public void changeBreakPointCondition(int paramInt, String paramString)
  {
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
    }
  }
  
  public void clearBreakPoint(int paramInt)
  {
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
    }
  }
  
  public void disableAllBreakPoints()
  {
    this.debugObject.executeVoidFunction("disableAllBreakPoints", null);
  }
  
  public void disableScriptBreakPoint(int paramInt)
  {
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
    }
  }
  
  public void enableScriptBreakPoint(int paramInt)
  {
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
    }
  }
  
  public ScriptBreakPoint getScriptBreakPoint(int paramInt)
  {
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
    }
  }
  
  public int getScriptBreakPointCount()
  {
    V8Array localV8Array = this.debugObject.executeArrayFunction("scriptBreakPoints", null);
    try
    {
      int i = localV8Array.length();
      return i;
    }
    finally
    {
      localV8Array.release();
    }
  }
  
  public int[] getScriptBreakPointIDs()
  {
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
      }
      localV8Array.release();
    }
    if (i < localV8Array.length()) {
      localV8Object = localV8Array.getObject(i);
    }
    localV8Array.release();
    return arrayOfInt2;
  }
  
  public void release()
  {
    this.debugObject.release();
  }
  
  public void removeBreakHandler(BreakHandler paramBreakHandler)
  {
    this.runtime.getLocker().checkThread();
    this.breakHandlers.remove(paramBreakHandler);
  }
  
  public int setBreakpoint(V8Function paramV8Function)
  {
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
    }
  }
  
  public int setScriptBreakpoint(String paramString, int paramInt)
  {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler
 * JD-Core Version:    0.7.0.1
 */