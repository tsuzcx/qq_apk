package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final Object mLock;
  private static volatile d rha;
  public List<a> rhb = null;
  
  static
  {
    AppMethodBeat.i(103701);
    rha = null;
    mLock = new Object();
    AppMethodBeat.o(103701);
  }
  
  public static final d csO()
  {
    AppMethodBeat.i(103697);
    if (rha == null) {
      synchronized (mLock)
      {
        if (rha == null) {
          rha = new d();
        }
        d locald = rha;
        AppMethodBeat.o(103697);
        return locald;
      }
    }
    ??? = rha;
    AppMethodBeat.o(103697);
    return ???;
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 45
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +18 -> 26
    //   11: ldc 47
    //   13: ldc 49
    //   15: invokestatic 55	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc 45
    //   20: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: getstatic 33	com/tencent/mm/plugin/facedetect/model/d:mLock	Ljava/lang/Object;
    //   29: astore_2
    //   30: aload_2
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 39	com/tencent/mm/plugin/facedetect/model/d:rhb	Ljava/util/List;
    //   36: ifnonnull +18 -> 54
    //   39: aload_0
    //   40: new 57	java/util/ArrayList
    //   43: dup
    //   44: iconst_5
    //   45: invokespecial 59	java/util/ArrayList:<init>	(I)V
    //   48: invokestatic 65	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   51: putfield 39	com/tencent/mm/plugin/facedetect/model/d:rhb	Ljava/util/List;
    //   54: aload_0
    //   55: getfield 39	com/tencent/mm/plugin/facedetect/model/d:rhb	Ljava/util/List;
    //   58: new 6	com/tencent/mm/plugin/facedetect/model/d$a
    //   61: dup
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 68	com/tencent/mm/plugin/facedetect/model/d$a:<init>	(Lcom/tencent/mm/plugin/facedetect/model/d;Lcom/tencent/mm/plugin/facedetect/model/d$b;)V
    //   67: invokeinterface 74 2 0
    //   72: pop
    //   73: aload_2
    //   74: monitorexit
    //   75: ldc 45
    //   77: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: goto -57 -> 23
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_2
    //   90: monitorexit
    //   91: ldc 45
    //   93: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	d
    //   0	98	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	83	finally
    //   11	23	83	finally
    //   26	32	83	finally
    //   75	80	83	finally
    //   91	98	83	finally
    //   32	54	88	finally
    //   54	75	88	finally
    //   89	91	88	finally
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(103700);
    synchronized (mLock)
    {
      if (this.rhb != null) {
        this.rhb.remove(paramb);
      }
      AppMethodBeat.o(103700);
      return;
    }
  }
  
  public final void bl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103699);
    synchronized (mLock)
    {
      ad.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(paramArrayOfByte)));
      if ((this.rhb == null) || (this.rhb.size() == 0))
      {
        ad.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
        AppMethodBeat.o(103699);
        return;
      }
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        ad.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
        AppMethodBeat.o(103699);
        return;
      }
      Iterator localIterator = this.rhb.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        int i = paramArrayOfByte.length;
        locala.data = ((byte[])locala.rhc.csP().d(Integer.valueOf(i)));
        System.arraycopy(paramArrayOfByte, 0, locala.data, 0, i);
        locala.rhc.bm(locala.data);
      }
    }
    AppMethodBeat.o(103699);
  }
  
  final class a
  {
    byte[] data;
    d.b rhc;
    
    a(d.b paramb)
    {
      this.rhc = paramb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void bm(byte[] paramArrayOfByte);
    
    public abstract a<byte[]> csP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.d
 * JD-Core Version:    0.7.0.1
 */