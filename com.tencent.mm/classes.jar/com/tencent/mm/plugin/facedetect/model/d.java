package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static final Object mLock;
  private static volatile d zSE;
  private List<a> zSF = null;
  
  static
  {
    AppMethodBeat.i(103701);
    zSE = null;
    mLock = new Object();
    AppMethodBeat.o(103701);
  }
  
  public static final d dOG()
  {
    AppMethodBeat.i(103697);
    if (zSE == null) {
      synchronized (mLock)
      {
        if (zSE == null) {
          zSE = new d();
        }
        d locald = zSE;
        AppMethodBeat.o(103697);
        return locald;
      }
    }
    ??? = zSE;
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
    //   15: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   33: getfield 39	com/tencent/mm/plugin/facedetect/model/d:zSF	Ljava/util/List;
    //   36: ifnonnull +18 -> 54
    //   39: aload_0
    //   40: new 57	java/util/ArrayList
    //   43: dup
    //   44: iconst_5
    //   45: invokespecial 59	java/util/ArrayList:<init>	(I)V
    //   48: invokestatic 65	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   51: putfield 39	com/tencent/mm/plugin/facedetect/model/d:zSF	Ljava/util/List;
    //   54: aload_0
    //   55: getfield 39	com/tencent/mm/plugin/facedetect/model/d:zSF	Ljava/util/List;
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
    //   89	98	83	finally
    //   32	54	88	finally
    //   54	75	88	finally
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(103700);
    synchronized (mLock)
    {
      if (this.zSF != null) {
        this.zSF.remove(new a(paramb));
      }
      AppMethodBeat.o(103700);
      return;
    }
  }
  
  public final void bP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103699);
    synchronized (mLock)
    {
      Log.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(paramArrayOfByte)));
      if ((this.zSF == null) || (this.zSF.size() == 0))
      {
        Log.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
        AppMethodBeat.o(103699);
        return;
      }
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        Log.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
        AppMethodBeat.o(103699);
        return;
      }
      Iterator localIterator = this.zSF.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        int i = paramArrayOfByte.length;
        locala.data = ((byte[])locala.zSG.dOH().h(Integer.valueOf(i)));
        System.arraycopy(paramArrayOfByte, 0, locala.data, 0, i);
        locala.zSG.bQ(locala.data);
      }
    }
    AppMethodBeat.o(103699);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(271886);
    synchronized (mLock)
    {
      if (this.zSF != null) {
        this.zSF.clear();
      }
      AppMethodBeat.o(271886);
      return;
    }
  }
  
  final class a
  {
    byte[] data;
    d.b zSG;
    
    a(d.b paramb)
    {
      this.zSG = paramb;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(271890);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(271890);
        return false;
      }
      boolean bool = this.zSG.equals(((a)paramObject).zSG);
      AppMethodBeat.o(271890);
      return bool;
    }
  }
  
  public static abstract interface b
  {
    public abstract void bQ(byte[] paramArrayOfByte);
    
    public abstract a<byte[]> dOH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.d
 * JD-Core Version:    0.7.0.1
 */