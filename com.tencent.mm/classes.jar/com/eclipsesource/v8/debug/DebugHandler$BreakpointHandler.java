package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

class DebugHandler$BreakpointHandler
  implements JavaVoidCallback
{
  private DebugHandler$BreakpointHandler(DebugHandler paramDebugHandler) {}
  
  private EventData createDebugEvent(DebugHandler.DebugEvent paramDebugEvent, V8Object paramV8Object)
  {
    AppMethodBeat.i(74828);
    switch (DebugHandler.1.$SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[paramDebugEvent.ordinal()])
    {
    default: 
      paramDebugEvent = new EventData(paramV8Object);
      AppMethodBeat.o(74828);
      return paramDebugEvent;
    case 1: 
      paramDebugEvent = new BreakEvent(paramV8Object);
      AppMethodBeat.o(74828);
      return paramDebugEvent;
    case 2: 
      paramDebugEvent = new CompileEvent(paramV8Object);
      AppMethodBeat.o(74828);
      return paramDebugEvent;
    case 3: 
      paramDebugEvent = new CompileEvent(paramV8Object);
      AppMethodBeat.o(74828);
      return paramDebugEvent;
    }
    paramDebugEvent = new ExceptionEvent(paramV8Object);
    AppMethodBeat.o(74828);
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
    AppMethodBeat.i(74829);
    if (paramReleasable != null) {
      paramReleasable.release();
    }
    AppMethodBeat.o(74829);
  }
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(74826);
    if ((paramV8Array == null) || (paramV8Array.isUndefined()))
    {
      AppMethodBeat.o(74826);
      return;
    }
    int i = paramV8Array.getInteger(0);
    paramV8Object = DebugHandler.access$100(this.this$0).iterator();
    while (paramV8Object.hasNext()) {
      invokeHandler(paramV8Array, i, (BreakHandler)paramV8Object.next());
    }
    AppMethodBeat.o(74826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.debug.DebugHandler.BreakpointHandler
 * JD-Core Version:    0.7.0.1
 */