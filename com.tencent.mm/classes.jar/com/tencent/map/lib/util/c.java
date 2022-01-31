package com.tencent.map.lib.util;

import java.util.HashMap;

public final class c<T, K>
{
  private HashMap<T, K> a;
  private int b = 0;
  private int c = 1024;
  
  /* Error */
  public final K a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/map/lib/util/c:a	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 23	com/tencent/map/lib/util/c:a	Ljava/util/HashMap;
    //   21: aload_1
    //   22: invokevirtual 28	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore_1
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	c
    //   0	34	1	paramT	T
    //   6	2	2	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   17	26	29	finally
  }
  
  public final void a(T paramT, K paramK)
  {
    try
    {
      if (this.a == null) {
        this.a = new HashMap();
      }
      this.a.put(paramT, paramK);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.util.c
 * JD-Core Version:    0.7.0.1
 */