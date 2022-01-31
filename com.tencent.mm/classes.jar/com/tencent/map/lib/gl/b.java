package com.tencent.map.lib.gl;

import com.tencent.tencentmap.mapsdk.a.kx;
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
  private kx<String> b;
  private Hashtable<String, Integer> c;
  private IntBuffer d;
  
  public b(int paramInt)
  {
    this.a = paramInt;
    this.b = new kx(paramInt);
    this.c = new Hashtable();
    b();
  }
  
  private void b()
  {
    if (this.d == null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.a * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.d = localByteBuffer.asIntBuffer();
    }
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   6: aload_1
    //   7: invokevirtual 62	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 64	java/lang/Integer
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokevirtual 68	java/lang/Integer:intValue	()I
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	b
    //   0	37	1	paramString	String
    //   22	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	32	finally
    //   18	23	32	finally
  }
  
  public void a()
  {
    try
    {
      this.c.clear();
      this.b.b();
      if (this.d != null) {
        this.d.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   6: invokevirtual 81	java/util/Hashtable:size	()I
    //   9: aload_0
    //   10: getfield 21	com/tencent/map/lib/gl/b:a	I
    //   13: if_icmpne +68 -> 81
    //   16: aload_0
    //   17: invokespecial 34	com/tencent/map/lib/gl/b:b	()V
    //   20: aload_0
    //   21: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +6 -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 27	com/tencent/map/lib/gl/b:b	Lcom/tencent/tencentmap/mapsdk/a/kx;
    //   36: invokevirtual 84	com/tencent/tencentmap/mapsdk/a/kx:a	()Ljava/lang/Object;
    //   39: checkcast 86	java/lang/String
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 32	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   47: aload_3
    //   48: invokevirtual 89	java/util/Hashtable:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 64	java/lang/Integer
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   59: invokevirtual 92	java/nio/IntBuffer:position	()I
    //   62: aload_0
    //   63: getfield 21	com/tencent/map/lib/gl/b:a	I
    //   66: if_icmpge +15 -> 81
    //   69: aload_0
    //   70: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   73: aload_3
    //   74: invokevirtual 68	java/lang/Integer:intValue	()I
    //   77: invokevirtual 96	java/nio/IntBuffer:put	(I)Ljava/nio/IntBuffer;
    //   80: pop
    //   81: aload_0
    //   82: getfield 27	com/tencent/map/lib/gl/b:b	Lcom/tencent/tencentmap/mapsdk/a/kx;
    //   85: aload_1
    //   86: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/kx:a	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: aload_0
    //   91: getfield 32	com/tencent/map/lib/gl/b:c	Ljava/util/Hashtable;
    //   94: aload_1
    //   95: iload_2
    //   96: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: invokevirtual 106	java/util/Hashtable:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: goto -74 -> 29
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	b
    //   0	111	1	paramString	String
    //   0	111	2	paramInt	int
    //   24	50	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	106	finally
    //   32	81	106	finally
    //   81	103	106	finally
  }
  
  /* Error */
  public void a(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   18: invokevirtual 92	java/nio/IntBuffer:position	()I
    //   21: istore_2
    //   22: iload_2
    //   23: ifle -12 -> 11
    //   26: aload_0
    //   27: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   30: invokevirtual 110	java/nio/IntBuffer:rewind	()Ljava/nio/Buffer;
    //   33: pop
    //   34: aload_1
    //   35: iload_2
    //   36: aload_0
    //   37: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   40: invokeinterface 116 3 0
    //   45: aload_0
    //   46: getfield 37	com/tencent/map/lib/gl/b:d	Ljava/nio/IntBuffer;
    //   49: invokevirtual 77	java/nio/IntBuffer:clear	()Ljava/nio/Buffer;
    //   52: pop
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	b
    //   0	61	1	paramGL10	GL10
    //   21	15	2	i	int
    //   6	2	3	localIntBuffer	IntBuffer
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	22	56	finally
    //   26	53	56	finally
  }
  
  public void b(GL10 paramGL10)
  {
    try
    {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.gl.b
 * JD-Core Version:    0.7.0.1
 */