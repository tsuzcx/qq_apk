package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jg;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.microedition.khronos.opengles.GL10;

public class b
{
  private int a;
  private jg<String> b;
  private Hashtable<String, Integer> c;
  private IntBuffer d;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(98046);
    this.a = paramInt;
    this.b = new jg(paramInt);
    this.c = new Hashtable();
    b();
    AppMethodBeat.o(98046);
  }
  
  private void b()
  {
    AppMethodBeat.i(98047);
    if (this.d == null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.a * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.d = localByteBuffer.asIntBuffer();
    }
    AppMethodBeat.o(98047);
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 69
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   11: aload_1
    //   12: invokevirtual 73	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 75	java/lang/Integer
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +17 -> 37
    //   23: aload_1
    //   24: invokevirtual 79	java/lang/Integer:intValue	()I
    //   27: istore_2
    //   28: ldc 69
    //   30: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_2
    //   39: ldc 69
    //   41: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -11 -> 33
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	b
    //   0	52	1	paramString	String
    //   27	12	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	19	47	finally
    //   23	33	47	finally
    //   39	44	47	finally
  }
  
  public void a()
  {
    try
    {
      AppMethodBeat.i(98051);
      this.c.clear();
      this.b.b();
      if (this.d != null) {
        this.d.clear();
      }
      AppMethodBeat.o(98051);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 91
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   11: invokevirtual 94	java/util/Hashtable:size	()I
    //   14: aload_0
    //   15: getfield 27	com/tencent/map/lib/gl/b:a	I
    //   18: if_icmpne +71 -> 89
    //   21: aload_0
    //   22: invokespecial 40	com/tencent/map/lib/gl/b:b	()V
    //   25: aload_0
    //   26: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   29: ifnonnull +11 -> 40
    //   32: ldc 91
    //   34: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: getfield 33	com/tencent/map/lib/gl/b:b	Lcom/tencent/tencentmap/mapsdk/maps/a/jg;
    //   44: invokevirtual 97	com/tencent/tencentmap/mapsdk/maps/a/jg:a	()Ljava/lang/Object;
    //   47: checkcast 99	java/lang/String
    //   50: astore_3
    //   51: aload_0
    //   52: getfield 38	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   55: aload_3
    //   56: invokevirtual 102	java/util/Hashtable:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 75	java/lang/Integer
    //   62: astore_3
    //   63: aload_0
    //   64: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   67: invokevirtual 105	java/nio/IntBuffer:position	()I
    //   70: aload_0
    //   71: getfield 27	com/tencent/map/lib/gl/b:a	I
    //   74: if_icmpge +15 -> 89
    //   77: aload_0
    //   78: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   81: aload_3
    //   82: invokevirtual 79	java/lang/Integer:intValue	()I
    //   85: invokevirtual 109	java/nio/IntBuffer:put	(I)Ljava/nio/IntBuffer;
    //   88: pop
    //   89: aload_0
    //   90: getfield 33	com/tencent/map/lib/gl/b:b	Lcom/tencent/tencentmap/mapsdk/maps/a/jg;
    //   93: aload_1
    //   94: invokevirtual 112	com/tencent/tencentmap/mapsdk/maps/a/jg:a	(Ljava/lang/Object;)Z
    //   97: pop
    //   98: aload_0
    //   99: getfield 38	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   102: aload_1
    //   103: iload_2
    //   104: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 119	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: ldc 91
    //   113: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -79 -> 37
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	b
    //   0	124	1	paramString	String
    //   0	124	2	paramInt	int
    //   50	32	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	119	finally
    //   40	89	119	finally
    //   89	116	119	finally
  }
  
  /* Error */
  public void a(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 121
    //   16: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   26: invokevirtual 105	java/nio/IntBuffer:position	()I
    //   29: istore_2
    //   30: iload_2
    //   31: ifle +30 -> 61
    //   34: aload_0
    //   35: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   38: invokevirtual 124	java/nio/IntBuffer:rewind	()Ljava/nio/Buffer;
    //   41: pop
    //   42: aload_1
    //   43: iload_2
    //   44: aload_0
    //   45: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   48: invokeinterface 130 3 0
    //   53: aload_0
    //   54: getfield 47	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   57: invokevirtual 89	java/nio/IntBuffer:clear	()Ljava/nio/Buffer;
    //   60: pop
    //   61: ldc 121
    //   63: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -47 -> 19
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	b
    //   0	74	1	paramGL10	GL10
    //   29	15	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	19	69	finally
    //   22	30	69	finally
    //   34	61	69	finally
    //   61	66	69	finally
  }
  
  public void b(GL10 paramGL10)
  {
    try
    {
      AppMethodBeat.i(98052);
      if (this.d != null)
      {
        Iterator localIterator = this.c.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = ((Integer)this.c.get(str)).intValue();
          this.d.put(i);
        }
        a(paramGL10);
      }
    }
    finally {}
    this.c.clear();
    this.b.b();
    AppMethodBeat.o(98052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.b
 * JD-Core Version:    0.7.0.1
 */