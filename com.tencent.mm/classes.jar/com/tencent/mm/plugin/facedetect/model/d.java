package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final Object mLock;
  private static volatile d mhO;
  public List<a> mhP = null;
  
  static
  {
    AppMethodBeat.i(176);
    mhO = null;
    mLock = new Object();
    AppMethodBeat.o(176);
  }
  
  public static final d bui()
  {
    AppMethodBeat.i(172);
    if (mhO == null) {
      synchronized (mLock)
      {
        if (mhO == null) {
          mhO = new d();
        }
        d locald = mhO;
        AppMethodBeat.o(172);
        return locald;
      }
    }
    ??? = mhO;
    AppMethodBeat.o(172);
    return ???;
  }
  
  /* Error */
  public final void a(d.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 173
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +19 -> 28
    //   12: ldc 43
    //   14: ldc 45
    //   16: invokestatic 51	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: sipush 173
    //   22: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: getstatic 31	com/tencent/mm/plugin/facedetect/model/d:mLock	Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_2
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 37	com/tencent/mm/plugin/facedetect/model/d:mhP	Ljava/util/List;
    //   38: ifnonnull +18 -> 56
    //   41: aload_0
    //   42: new 53	java/util/ArrayList
    //   45: dup
    //   46: iconst_5
    //   47: invokespecial 55	java/util/ArrayList:<init>	(I)V
    //   50: invokestatic 61	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   53: putfield 37	com/tencent/mm/plugin/facedetect/model/d:mhP	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 37	com/tencent/mm/plugin/facedetect/model/d:mhP	Ljava/util/List;
    //   60: new 6	com/tencent/mm/plugin/facedetect/model/d$a
    //   63: dup
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial 64	com/tencent/mm/plugin/facedetect/model/d$a:<init>	(Lcom/tencent/mm/plugin/facedetect/model/d;Lcom/tencent/mm/plugin/facedetect/model/d$b;)V
    //   69: invokeinterface 70 2 0
    //   74: pop
    //   75: aload_2
    //   76: monitorexit
    //   77: sipush 173
    //   80: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -58 -> 25
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_2
    //   93: monitorexit
    //   94: sipush 173
    //   97: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	d
    //   0	102	1	paramb	d.b
    // Exception table:
    //   from	to	target	type
    //   2	8	86	finally
    //   12	25	86	finally
    //   28	34	86	finally
    //   77	83	86	finally
    //   94	102	86	finally
    //   34	56	91	finally
    //   56	77	91	finally
    //   92	94	91	finally
  }
  
  public final void aT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(174);
    synchronized (mLock)
    {
      ab.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish data:".concat(String.valueOf(paramArrayOfByte)));
      if ((this.mhP == null) || (this.mhP.size() == 0))
      {
        ab.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
        AppMethodBeat.o(174);
        return;
      }
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        ab.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
        AppMethodBeat.o(174);
        return;
      }
      Iterator localIterator = this.mhP.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        int i = paramArrayOfByte.length;
        locala.data = ((byte[])locala.mhQ.buj().c(Integer.valueOf(i)));
        System.arraycopy(paramArrayOfByte, 0, locala.data, 0, i);
        locala.mhQ.aU(locala.data);
      }
    }
    AppMethodBeat.o(174);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(175);
    synchronized (mLock)
    {
      if (this.mhP != null) {
        this.mhP.remove(paramb);
      }
      AppMethodBeat.o(175);
      return;
    }
  }
  
  final class a
  {
    byte[] data;
    d.b mhQ;
    
    a(d.b paramb)
    {
      this.mhQ = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.d
 * JD-Core Version:    0.7.0.1
 */