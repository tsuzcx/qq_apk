package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import java.util.ArrayList;
import java.util.List;

public abstract class bl
  implements TencentMapComponent.Component
{
  private final List<bm> a = new ArrayList();
  private volatile int b;
  
  protected void a(Context paramContext) {}
  
  protected void a(bm parambm)
  {
    if (parambm != null) {}
    try
    {
      this.a.add(parambm);
      return;
    }
    finally
    {
      parambm = finally;
      throw parambm;
    }
  }
  
  /* Error */
  public void a(bm parambm, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   6: invokeinterface 34 1 0
    //   11: istore_3
    //   12: iload_3
    //   13: ifne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 38 2 0
    //   30: putfield 40	com/tencent/mapsdk/internal/bl:b	I
    //   33: goto -17 -> 16
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	bl
    //   0	41	1	parambm	bm
    //   0	41	2	paramBundle	android.os.Bundle
    //   11	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	12	36	finally
    //   19	33	36	finally
  }
  
  public final Context b()
  {
    bm localbm = c_();
    if (localbm != null) {
      return localbm.getContext();
    }
    return null;
  }
  
  /* Error */
  protected void b(bm parambm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_0
    //   7: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface 53 2 0
    //   16: pop
    //   17: aload_0
    //   18: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   21: invokeinterface 34 1 0
    //   26: ifne +10 -> 36
    //   29: aload_0
    //   30: invokevirtual 56	com/tencent/mapsdk/internal/bl:b_	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   41: invokeinterface 34 1 0
    //   46: iconst_1
    //   47: isub
    //   48: putfield 40	com/tencent/mapsdk/internal/bl:b	I
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bl
    //   0	59	1	parambm	bm
    // Exception table:
    //   from	to	target	type
    //   6	17	54	finally
    //   17	33	54	finally
    //   36	51	54	finally
  }
  
  protected void b_()
  {
    try
    {
      this.a.clear();
      this.b = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final bm c_()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/mapsdk/internal/bl:b	I
    //   6: iflt +40 -> 46
    //   9: aload_0
    //   10: getfield 40	com/tencent/mapsdk/internal/bl:b	I
    //   13: aload_0
    //   14: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   17: invokeinterface 34 1 0
    //   22: if_icmpge +24 -> 46
    //   25: aload_0
    //   26: getfield 20	com/tencent/mapsdk/internal/bl:a	Ljava/util/List;
    //   29: aload_0
    //   30: getfield 40	com/tencent/mapsdk/internal/bl:b	I
    //   33: invokeinterface 63 2 0
    //   38: checkcast 47	com/tencent/mapsdk/internal/bm
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aconst_null
    //   47: astore_1
    //   48: goto -6 -> 42
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	bl
    //   41	7	1	localbm	bm
    //   51	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bl
 * JD-Core Version:    0.7.0.1
 */