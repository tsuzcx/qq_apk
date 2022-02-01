package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.microedition.khronos.opengles.GL10;

public final class lv
{
  public static final int a = 0;
  private int b;
  private a<String> c;
  private Hashtable<String, Integer> d;
  private IntBuffer e;
  
  public lv()
  {
    AppMethodBeat.i(222795);
    this.b = 100;
    this.c = new a();
    this.d = new Hashtable();
    b();
    AppMethodBeat.o(222795);
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 47
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 39	com/tencent/mapsdk/internal/lv:d	Ljava/util/Hashtable;
    //   11: aload_1
    //   12: invokevirtual 51	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 53	java/lang/Integer
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +17 -> 37
    //   23: aload_1
    //   24: invokevirtual 57	java/lang/Integer:intValue	()I
    //   27: istore_2
    //   28: ldc 47
    //   30: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_2
    //   39: ldc 47
    //   41: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -11 -> 33
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	lv
    //   0	52	1	paramString	String
    //   27	12	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	19	47	finally
    //   23	33	47	finally
    //   39	44	47	finally
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    label144:
    label282:
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        AppMethodBeat.i(222822);
        if (this.d.size() == this.b)
        {
          b();
          if (this.e == null)
          {
            AppMethodBeat.o(222822);
            return;
          }
          localObject2 = this.c;
          if (((a)localObject2).d != ((a)localObject2).c) {
            break label216;
          }
          i = 1;
          break label282;
          localObject1 = (String)localObject1;
          localObject1 = (Integer)this.d.remove(localObject1);
          if (this.e.position() < this.b) {
            this.e.put(((Integer)localObject1).intValue());
          }
        }
        localObject1 = this.c;
        if ((((a)localObject1).d + 1) % ((a)localObject1).a == ((a)localObject1).c)
        {
          i = 1;
          if (i == 0)
          {
            ((a)localObject1).d %= ((a)localObject1).a;
            localObject2 = ((a)localObject1).b;
            i = ((a)localObject1).d;
            ((a)localObject1).d = (i + 1);
            localObject2[i] = paramString;
          }
          this.d.put(paramString, Integer.valueOf(paramInt));
          AppMethodBeat.o(222822);
          continue;
          i = 0;
        }
      }
      finally {}
      label216:
      while (i == 0)
      {
        ((a)localObject2).c %= ((a)localObject2).a;
        localObject1 = localObject2.b[localObject2.c];
        ((a)localObject2).b[localObject2.c] = null;
        ((a)localObject2).c += 1;
        break;
        i = 0;
        break label144;
      }
    }
  }
  
  private void b()
  {
    try
    {
      AppMethodBeat.i(222802);
      if (this.e == null)
      {
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.b * 4);
        localByteBuffer.order(ByteOrder.nativeOrder());
        this.e = localByteBuffer.asIntBuffer();
      }
      AppMethodBeat.o(222802);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void b(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 64	com/tencent/mapsdk/internal/lv:e	Ljava/nio/IntBuffer;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 117
    //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 64	com/tencent/mapsdk/internal/lv:e	Ljava/nio/IntBuffer;
    //   26: invokevirtual 78	java/nio/IntBuffer:position	()I
    //   29: istore_2
    //   30: iload_2
    //   31: ifle +30 -> 61
    //   34: aload_0
    //   35: getfield 64	com/tencent/mapsdk/internal/lv:e	Ljava/nio/IntBuffer;
    //   38: invokevirtual 121	java/nio/IntBuffer:rewind	()Ljava/nio/Buffer;
    //   41: pop
    //   42: aload_1
    //   43: iload_2
    //   44: aload_0
    //   45: getfield 64	com/tencent/mapsdk/internal/lv:e	Ljava/nio/IntBuffer;
    //   48: invokeinterface 127 3 0
    //   53: aload_0
    //   54: getfield 64	com/tencent/mapsdk/internal/lv:e	Ljava/nio/IntBuffer;
    //   57: invokevirtual 130	java/nio/IntBuffer:clear	()Ljava/nio/Buffer;
    //   60: pop
    //   61: ldc 117
    //   63: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -47 -> 19
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	lv
    //   0	74	1	paramGL10	GL10
    //   29	15	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	19	69	finally
    //   22	30	69	finally
    //   34	61	69	finally
    //   61	66	69	finally
  }
  
  public final void a()
  {
    try
    {
      AppMethodBeat.i(222849);
      this.d.clear();
      this.c.a();
      if (this.e != null) {
        this.e.clear();
      }
      AppMethodBeat.o(222849);
      return;
    }
    finally {}
  }
  
  public final void a(GL10 paramGL10)
  {
    try
    {
      AppMethodBeat.i(222858);
      if (this.e != null)
      {
        Iterator localIterator = this.d.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = ((Integer)this.d.get(str)).intValue();
          this.e.put(i);
        }
        b(paramGL10);
      }
    }
    finally {}
    this.d.clear();
    this.c.a();
    AppMethodBeat.o(222858);
  }
  
  public static final class a<E>
  {
    int a;
    Object[] b;
    int c;
    int d;
    
    public a()
    {
      AppMethodBeat.i(224159);
      this.a = 100;
      this.b = new Object[100];
      this.d = 0;
      this.c = 0;
      AppMethodBeat.o(224159);
    }
    
    private boolean a(E paramE)
    {
      if ((this.d + 1) % this.a == this.c) {}
      for (int i = 1; i != 0; i = 0) {
        return false;
      }
      this.d %= this.a;
      Object[] arrayOfObject = this.b;
      i = this.d;
      this.d = (i + 1);
      arrayOfObject[i] = paramE;
      return true;
    }
    
    private void b()
    {
      this.d = 0;
      this.c = 0;
    }
    
    private E c()
    {
      if (this.d == this.c) {}
      for (int i = 1; i != 0; i = 0) {
        return null;
      }
      this.c %= this.a;
      Object localObject = this.b[this.c];
      this.b[this.c] = null;
      this.c += 1;
      return localObject;
    }
    
    private boolean d()
    {
      return (this.d + 1) % this.a == this.c;
    }
    
    private boolean e()
    {
      return this.d == this.c;
    }
    
    public final void a()
    {
      AppMethodBeat.i(224217);
      b();
      int i = 0;
      while (i < this.b.length)
      {
        this.b[i] = null;
        i += 1;
      }
      AppMethodBeat.o(224217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lv
 * JD-Core Version:    0.7.0.1
 */