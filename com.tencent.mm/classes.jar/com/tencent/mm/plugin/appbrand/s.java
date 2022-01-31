package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private Map<Integer, List<s.b>> gRJ;
  private Map<Integer, Integer> gRK;
  
  private s()
  {
    AppMethodBeat.i(86774);
    this.gRJ = new HashMap();
    this.gRK = new HashMap();
    AppMethodBeat.o(86774);
  }
  
  private void d(int paramInt, List<s.b> paramList)
  {
    AppMethodBeat.i(86778);
    if (this.gRK.isEmpty())
    {
      AppMethodBeat.o(86778);
      return;
    }
    ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!this.gRK.containsKey(Integer.valueOf(paramInt)))
    {
      ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "not in pending notify");
      AppMethodBeat.o(86778);
      return;
    }
    this.gRK.remove(Integer.valueOf(paramInt));
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((s.b)paramList.get(paramInt)).aui();
      paramInt += 1;
    }
    AppMethodBeat.o(86778);
  }
  
  public final void a(r paramr, s.b paramb)
  {
    try
    {
      AppMethodBeat.i(86775);
      int i = paramr.hashCode();
      ab.i("MicroMsg.AppBrandServiceOnInitDoneListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
      List localList = (List)this.gRJ.get(Integer.valueOf(i));
      paramr = localList;
      if (localList == null)
      {
        paramr = new ArrayList();
        this.gRJ.put(Integer.valueOf(i), paramr);
      }
      paramr.add(paramb);
      d(i, paramr);
      AppMethodBeat.o(86775);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void b(r paramr, s.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 113
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokevirtual 95	java/lang/Object:hashCode	()I
    //   11: istore_3
    //   12: ldc 48
    //   14: ldc 115
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: iload_3
    //   23: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 29	com/tencent/mm/plugin/appbrand/s:gRJ	Ljava/util/Map;
    //   34: iload_3
    //   35: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: invokeinterface 99 2 0
    //   43: checkcast 76	java/util/List
    //   46: astore_1
    //   47: aload_1
    //   48: ifnonnull +11 -> 59
    //   51: ldc 113
    //   53: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_1
    //   60: aload_2
    //   61: invokeinterface 117 2 0
    //   66: pop
    //   67: aload_1
    //   68: invokeinterface 118 1 0
    //   73: ifeq +17 -> 90
    //   76: aload_0
    //   77: getfield 29	com/tencent/mm/plugin/appbrand/s:gRJ	Ljava/util/Map;
    //   80: iload_3
    //   81: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokeinterface 74 2 0
    //   89: pop
    //   90: ldc 113
    //   92: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: goto -39 -> 56
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	s
    //   0	103	1	paramr	r
    //   0	103	2	paramb	s.b
    //   11	70	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	47	98	finally
    //   51	56	98	finally
    //   59	90	98	finally
    //   90	95	98	finally
  }
  
  /* Error */
  public final void c(r paramr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokevirtual 95	java/lang/Object:hashCode	()I
    //   11: istore_2
    //   12: ldc 48
    //   14: ldc 123
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: iload_2
    //   23: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 29	com/tencent/mm/plugin/appbrand/s:gRJ	Ljava/util/Map;
    //   34: iload_2
    //   35: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: invokeinterface 99 2 0
    //   43: checkcast 76	java/util/List
    //   46: astore_1
    //   47: aload_1
    //   48: ifnonnull +36 -> 84
    //   51: ldc 48
    //   53: ldc 125
    //   55: invokestatic 70	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 31	com/tencent/mm/plugin/appbrand/s:gRK	Ljava/util/Map;
    //   62: iload_2
    //   63: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: iconst_1
    //   67: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokeinterface 106 3 0
    //   75: pop
    //   76: ldc 121
    //   78: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_2
    //   87: aload_1
    //   88: invokeinterface 80 1 0
    //   93: if_icmpge +25 -> 118
    //   96: aload_1
    //   97: iload_2
    //   98: invokeinterface 84 2 0
    //   103: checkcast 8	com/tencent/mm/plugin/appbrand/s$b
    //   106: invokeinterface 87 1 0
    //   111: iload_2
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: goto -29 -> 86
    //   118: ldc 121
    //   120: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -42 -> 81
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	s
    //   0	131	1	paramr	r
    //   11	104	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	47	126	finally
    //   51	81	126	finally
    //   86	111	126	finally
    //   118	123	126	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */