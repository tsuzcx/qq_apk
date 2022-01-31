package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.ArrayList;

public final class d$b
  extends OutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final int Crf;
  private final ArrayList<d> Crg;
  private int Crh;
  private int bgR;
  private byte[] buffer;
  
  d$b()
  {
    AppMethodBeat.i(121420);
    this.Crf = 128;
    this.Crg = new ArrayList();
    this.buffer = new byte[''];
    AppMethodBeat.o(121420);
  }
  
  private void VB(int paramInt)
  {
    AppMethodBeat.i(121425);
    this.Crg.add(new p(this.buffer));
    this.Crh += this.buffer.length;
    this.buffer = new byte[Math.max(this.Crf, Math.max(paramInt, this.Crh >>> 1))];
    this.bgR = 0;
    AppMethodBeat.o(121425);
  }
  
  private int size()
  {
    try
    {
      int i = this.Crh;
      int j = this.bgR;
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final d emt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 70
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   11: aload_0
    //   12: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   15: arraylength
    //   16: if_icmpge +88 -> 104
    //   19: aload_0
    //   20: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   23: ifle +46 -> 69
    //   26: aload_0
    //   27: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   35: istore_1
    //   36: iload_1
    //   37: newarray byte
    //   39: astore_3
    //   40: aload_2
    //   41: iconst_0
    //   42: aload_3
    //   43: iconst_0
    //   44: aload_2
    //   45: arraylength
    //   46: iload_1
    //   47: invokestatic 73	java/lang/Math:min	(II)I
    //   50: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   53: aload_0
    //   54: getfield 39	a/j/b/a/c/g/d$b:Crg	Ljava/util/ArrayList;
    //   57: new 48	a/j/b/a/c/g/p
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 51	a/j/b/a/c/g/p:<init>	([B)V
    //   65: invokevirtual 55	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 57	a/j/b/a/c/g/d$b:Crh	I
    //   74: aload_0
    //   75: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   78: iadd
    //   79: putfield 57	a/j/b/a/c/g/d$b:Crh	I
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   87: aload_0
    //   88: getfield 39	a/j/b/a/c/g/d$b:Crg	Ljava/util/ArrayList;
    //   91: invokestatic 83	a/j/b/a/c/g/d:x	(Ljava/lang/Iterable;)La/j/b/a/c/g/d;
    //   94: astore_2
    //   95: ldc 70
    //   97: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: areturn
    //   104: aload_0
    //   105: getfield 39	a/j/b/a/c/g/d$b:Crg	Ljava/util/ArrayList;
    //   108: new 48	a/j/b/a/c/g/p
    //   111: dup
    //   112: aload_0
    //   113: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   116: invokespecial 51	a/j/b/a/c/g/p:<init>	([B)V
    //   119: invokevirtual 55	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_0
    //   124: getstatic 21	a/j/b/a/c/g/d$b:EMPTY_BYTE_ARRAY	[B
    //   127: putfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   130: goto -61 -> 69
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	b
    //   35	12	1	i	int
    //   30	73	2	localObject1	Object
    //   133	4	2	localObject2	Object
    //   39	23	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	69	133	finally
    //   69	100	133	finally
    //   104	130	133	finally
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121424);
    String str = String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
    AppMethodBeat.o(121424);
    return str;
  }
  
  public final void write(int paramInt)
  {
    try
    {
      AppMethodBeat.i(121421);
      if (this.bgR == this.buffer.length) {
        VB(1);
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.bgR;
      this.bgR = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      AppMethodBeat.o(121421);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_3
    //   8: aload_0
    //   9: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   12: arraylength
    //   13: aload_0
    //   14: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   17: isub
    //   18: if_icmpgt +35 -> 53
    //   21: aload_1
    //   22: iload_2
    //   23: aload_0
    //   24: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   27: aload_0
    //   28: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   31: iload_3
    //   32: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   40: iload_3
    //   41: iadd
    //   42: putfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   45: ldc 118
    //   47: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   57: arraylength
    //   58: aload_0
    //   59: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   62: isub
    //   63: istore 4
    //   65: aload_1
    //   66: iload_2
    //   67: aload_0
    //   68: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   71: aload_0
    //   72: getfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   75: iload 4
    //   77: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: iload_3
    //   81: iload 4
    //   83: isub
    //   84: istore_3
    //   85: aload_0
    //   86: iload_3
    //   87: invokespecial 116	a/j/b/a/c/g/d$b:VB	(I)V
    //   90: aload_1
    //   91: iload_2
    //   92: iload 4
    //   94: iadd
    //   95: aload_0
    //   96: getfield 41	a/j/b/a/c/g/d$b:buffer	[B
    //   99: iconst_0
    //   100: iload_3
    //   101: invokestatic 79	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   104: aload_0
    //   105: iload_3
    //   106: putfield 65	a/j/b/a/c/g/d$b:bgR	I
    //   109: ldc 118
    //   111: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -64 -> 50
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	b
    //   0	122	1	paramArrayOfByte	byte[]
    //   0	122	2	paramInt1	int
    //   0	122	3	paramInt2	int
    //   63	32	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	50	117	finally
    //   53	80	117	finally
    //   85	114	117	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.g.d.b
 * JD-Core Version:    0.7.0.1
 */