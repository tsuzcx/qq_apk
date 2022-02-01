package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class q
  extends BufferedOutputStream
{
  private boolean closed;
  
  public q(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public q(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, paramInt);
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(93195);
    a.checkState(this.closed);
    this.out = paramOutputStream;
    this.count = 0;
    this.closed = false;
    AppMethodBeat.o(93195);
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 24	com/google/android/exoplayer2/i/q:closed	Z
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_0
    //   13: invokevirtual 47	com/google/android/exoplayer2/i/q:flush	()V
    //   16: aload_0
    //   17: getfield 34	com/google/android/exoplayer2/i/q:out	Ljava/io/OutputStream;
    //   20: invokevirtual 51	java/io/OutputStream:close	()V
    //   23: aload_1
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +7 -> 33
    //   29: aload_2
    //   30: invokestatic 57	com/google/android/exoplayer2/i/x:m	(Ljava/lang/Throwable;)V
    //   33: ldc 44
    //   35: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: astore_2
    //   40: aload_1
    //   41: ifnull -16 -> 25
    //   44: aload_1
    //   45: astore_2
    //   46: goto -21 -> 25
    //   49: astore_1
    //   50: goto -34 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	q
    //   11	34	1	localObject1	java.lang.Object
    //   49	1	1	localObject2	java.lang.Object
    //   24	6	2	localObject3	java.lang.Object
    //   39	1	2	localObject4	java.lang.Object
    //   45	1	2	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   16	23	39	finally
    //   12	16	49	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.q
 * JD-Core Version:    0.7.0.1
 */