package com.tencent.mm.plugin.freewifi.b;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a
{
  private Map<String, a.b> cache = new LinkedHashMap()
  {
    protected final boolean removeEldestEntry(Map.Entry paramAnonymousEntry)
    {
      return size() > 512;
    }
  };
  private boolean knP = false;
  
  private static String de(String paramString1, String paramString2)
  {
    return paramString1 + "-" + paramString2;
  }
  
  /* Error */
  public final a.b dg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   6: ifne +12 -> 18
    //   9: aload_2
    //   10: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 26	com/tencent/mm/plugin/freewifi/b/a:cache	Ljava/util/Map;
    //   28: aload_1
    //   29: aload_2
    //   30: invokestatic 54	com/tencent/mm/plugin/freewifi/b/a:de	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokeinterface 60 2 0
    //   38: checkcast 10	com/tencent/mm/plugin/freewifi/b/a$b
    //   41: astore_1
    //   42: goto -22 -> 20
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	a
    //   0	50	1	paramString1	String
    //   0	50	2	paramString2	String
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	45	finally
    //   24	42	45	finally
  }
  
  /* Error */
  public final void e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   6: ifne +34 -> 40
    //   9: aload_2
    //   10: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   13: ifne +27 -> 40
    //   16: aload_3
    //   17: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   20: istore 5
    //   22: iload 5
    //   24: ifne +16 -> 40
    //   27: iload 4
    //   29: iconst_4
    //   30: if_icmpeq +13 -> 43
    //   33: iload 4
    //   35: bipush 31
    //   37: if_icmpeq +6 -> 43
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: new 10	com/tencent/mm/plugin/freewifi/b/a$b
    //   46: dup
    //   47: invokespecial 63	com/tencent/mm/plugin/freewifi/b/a$b:<init>	()V
    //   50: astore 6
    //   52: aload 6
    //   54: aload_3
    //   55: putfield 67	com/tencent/mm/plugin/freewifi/b/a$b:bHI	Ljava/lang/String;
    //   58: aload 6
    //   60: iload 4
    //   62: putfield 71	com/tencent/mm/plugin/freewifi/b/a$b:kmR	I
    //   65: aload_0
    //   66: getfield 26	com/tencent/mm/plugin/freewifi/b/a:cache	Ljava/util/Map;
    //   69: aload_1
    //   70: aload_2
    //   71: invokestatic 54	com/tencent/mm/plugin/freewifi/b/a:de	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: aload 6
    //   76: invokeinterface 75 3 0
    //   81: pop
    //   82: goto -42 -> 40
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramString1	String
    //   0	90	2	paramString2	String
    //   0	90	3	paramString3	String
    //   0	90	4	paramInt	int
    //   20	3	5	bool	boolean
    //   50	25	6	localb	a.b
    // Exception table:
    //   from	to	target	type
    //   2	22	85	finally
    //   43	82	85	finally
  }
  
  public final int size()
  {
    try
    {
      int i = this.cache.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.a
 * JD-Core Version:    0.7.0.1
 */