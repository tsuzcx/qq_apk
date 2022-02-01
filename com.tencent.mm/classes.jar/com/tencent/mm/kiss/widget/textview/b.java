package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  public ConcurrentHashMap<String, LinkedList<f>> hud;
  
  public b()
  {
    AppMethodBeat.i(141009);
    this.hud = new ConcurrentHashMap();
    AppMethodBeat.o(141009);
  }
  
  /* Error */
  public final void a(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 30
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: getfield 36	com/tencent/mm/kiss/widget/textview/f:huG	Ljava/lang/CharSequence;
    //   15: ifnonnull +11 -> 26
    //   18: ldc 30
    //   20: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 23	com/tencent/mm/kiss/widget/textview/b:hud	Ljava/util/concurrent/ConcurrentHashMap;
    //   30: aload_1
    //   31: getfield 36	com/tencent/mm/kiss/widget/textview/f:huG	Ljava/lang/CharSequence;
    //   34: invokeinterface 42 1 0
    //   39: invokevirtual 46	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 48	java/util/LinkedList
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: ifnonnull +11 -> 60
    //   52: new 48	java/util/LinkedList
    //   55: dup
    //   56: invokespecial 49	java/util/LinkedList:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 53	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 23	com/tencent/mm/kiss/widget/textview/b:hud	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: aload_1
    //   71: getfield 36	com/tencent/mm/kiss/widget/textview/f:huG	Ljava/lang/CharSequence;
    //   74: invokeinterface 42 1 0
    //   79: aload_2
    //   80: invokevirtual 57	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: ldc 30
    //   86: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -66 -> 23
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	b
    //   0	97	1	paramf	f
    //   47	33	2	localLinkedList1	LinkedList
    //   45	4	3	localLinkedList2	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	7	92	finally
    //   11	18	92	finally
    //   18	23	92	finally
    //   26	46	92	finally
    //   52	60	92	finally
    //   60	89	92	finally
  }
  
  /* Error */
  public final f z(java.lang.CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 60
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 23	com/tencent/mm/kiss/widget/textview/b:hud	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: aload_1
    //   12: invokeinterface 42 1 0
    //   17: invokevirtual 46	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 48	java/util/LinkedList
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +10 -> 35
    //   28: aload_1
    //   29: invokevirtual 64	java/util/LinkedList:size	()I
    //   32: ifne +14 -> 46
    //   35: aconst_null
    //   36: astore_1
    //   37: ldc 60
    //   39: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_1
    //   47: invokevirtual 68	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   50: checkcast 32	com/tencent/mm/kiss/widget/textview/f
    //   53: astore_1
    //   54: ldc 60
    //   56: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -17 -> 42
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	b
    //   0	67	1	paramCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   2	24	62	finally
    //   28	35	62	finally
    //   37	42	62	finally
    //   46	59	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b
 * JD-Core Version:    0.7.0.1
 */