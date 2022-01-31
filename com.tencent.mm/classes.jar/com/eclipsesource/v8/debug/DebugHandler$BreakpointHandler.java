package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.util.Iterator;
import java.util.List;

class DebugHandler$BreakpointHandler
  implements JavaVoidCallback
{
  private DebugHandler$BreakpointHandler(DebugHandler paramDebugHandler) {}
  
  private EventData createDebugEvent(DebugHandler.DebugEvent paramDebugEvent, V8Object paramV8Object)
  {
    switch (DebugHandler.1.$SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[paramDebugEvent.ordinal()])
    {
    default: 
      return new EventData(paramV8Object);
    case 1: 
      return new BreakEvent(paramV8Object);
    case 2: 
      return new CompileEvent(paramV8Object);
    case 3: 
      return new CompileEvent(paramV8Object);
    }
    return new ExceptionEvent(paramV8Object);
  }
  
  /* Error */
  private void invokeHandler(V8Array paramV8Array, int paramInt, BreakHandler paramBreakHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: invokevirtual 58	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
    //   5: astore 7
    //   7: aload_1
    //   8: iconst_2
    //   9: invokevirtual 58	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
    //   12: astore 6
    //   14: aload_1
    //   15: iconst_3
    //   16: invokevirtual 58	com/eclipsesource/v8/V8Array:getObject	(I)Lcom/eclipsesource/v8/V8Object;
    //   19: astore 5
    //   21: new 60	com/eclipsesource/v8/debug/ExecutionState
    //   24: dup
    //   25: aload 7
    //   27: invokespecial 61	com/eclipsesource/v8/debug/ExecutionState:<init>	(Lcom/eclipsesource/v8/V8Object;)V
    //   30: astore 8
    //   32: invokestatic 65	com/eclipsesource/v8/debug/DebugHandler$DebugEvent:values	()[Lcom/eclipsesource/v8/debug/DebugHandler$DebugEvent;
    //   35: iload_2
    //   36: aaload
    //   37: astore_1
    //   38: aload_0
    //   39: aload_1
    //   40: aload 6
    //   42: invokespecial 67	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:createDebugEvent	(Lcom/eclipsesource/v8/debug/DebugHandler$DebugEvent;Lcom/eclipsesource/v8/V8Object;)Lcom/eclipsesource/v8/debug/EventData;
    //   45: astore 4
    //   47: aload_3
    //   48: aload_1
    //   49: aload 8
    //   51: aload 4
    //   53: aload 5
    //   55: invokeinterface 73 5 0
    //   60: aload_0
    //   61: aload 7
    //   63: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   66: aload_0
    //   67: aload 6
    //   69: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   72: aload_0
    //   73: aload 5
    //   75: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   78: aload_0
    //   79: aload 8
    //   81: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   84: aload_0
    //   85: aload 4
    //   87: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   90: return
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aconst_null
    //   95: astore 4
    //   97: aconst_null
    //   98: astore 5
    //   100: aconst_null
    //   101: astore 6
    //   103: aconst_null
    //   104: astore 7
    //   106: aload_0
    //   107: aload 7
    //   109: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   112: aload_0
    //   113: aload 6
    //   115: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   118: aload_0
    //   119: aload 5
    //   121: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   124: aload_0
    //   125: aload 4
    //   127: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   130: aload_0
    //   131: aload_3
    //   132: invokespecial 77	com/eclipsesource/v8/debug/DebugHandler$BreakpointHandler:safeRelease	(Lcom/eclipsesource/v8/Releasable;)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_3
    //   140: aconst_null
    //   141: astore 4
    //   143: aconst_null
    //   144: astore 5
    //   146: aconst_null
    //   147: astore 6
    //   149: goto -43 -> 106
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_3
    //   155: aconst_null
    //   156: astore 4
    //   158: aconst_null
    //   159: astore 5
    //   161: goto -55 -> 106
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_3
    //   167: aconst_null
    //   168: astore 4
    //   170: goto -64 -> 106
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_3
    //   176: aload 8
    //   178: astore 4
    //   180: goto -74 -> 106
    //   183: astore_1
    //   184: aload 4
    //   186: astore_3
    //   187: aload 8
    //   189: astore 4
    //   191: goto -85 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	BreakpointHandler
    //   0	194	1	paramV8Array	V8Array
    //   0	194	2	paramInt	int
    //   0	194	3	paramBreakHandler	BreakHandler
    //   45	145	4	localObject	Object
    //   19	141	5	localV8Object1	V8Object
    //   12	136	6	localV8Object2	V8Object
    //   5	103	7	localV8Object3	V8Object
    //   30	158	8	localExecutionState	ExecutionState
    // Exception table:
    //   from	to	target	type
    //   0	7	91	finally
    //   7	14	137	finally
    //   14	21	152	finally
    //   21	32	164	finally
    //   32	47	173	finally
    //   47	60	183	finally
  }
  
  private void safeRelease(Releasable paramReleasable)
  {
    if (paramReleasable != null) {
      paramReleasable.release();
    }
  }
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array == null) || (paramV8Array.isUndefined())) {}
    for (;;)
    {
      return;
      int i = paramV8Array.getInteger(0);
      paramV8Object = DebugHandler.access$100(this.this$0).iterator();
      while (paramV8Object.hasNext()) {
        invokeHandler(paramV8Array, i, (BreakHandler)paramV8Object.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler.BreakpointHandler
 * JD-Core Version:    0.7.0.1
 */