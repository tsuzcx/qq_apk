package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a
{
  private Map<String, a.b> cache;
  private boolean mJC;
  
  private a()
  {
    AppMethodBeat.i(20663);
    this.mJC = false;
    this.cache = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(20661);
        if (size() > 512)
        {
          AppMethodBeat.o(20661);
          return true;
        }
        AppMethodBeat.o(20661);
        return false;
      }
    };
    AppMethodBeat.o(20663);
  }
  
  private static String et(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20664);
    paramString1 = paramString1 + "-" + paramString2;
    AppMethodBeat.o(20664);
    return paramString1;
  }
  
  /* Error */
  public final void e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20665
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   12: ifne +30 -> 42
    //   15: aload_2
    //   16: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   19: ifne +23 -> 42
    //   22: aload_3
    //   23: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   26: ifne +16 -> 42
    //   29: iload 4
    //   31: iconst_4
    //   32: if_icmpeq +19 -> 51
    //   35: iload 4
    //   37: bipush 31
    //   39: if_icmpeq +12 -> 51
    //   42: sipush 20665
    //   45: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: new 10	com/tencent/mm/plugin/freewifi/b/a$b
    //   54: dup
    //   55: invokespecial 62	com/tencent/mm/plugin/freewifi/b/a$b:<init>	()V
    //   58: astore 5
    //   60: aload 5
    //   62: aload_3
    //   63: putfield 66	com/tencent/mm/plugin/freewifi/b/a$b:coX	Ljava/lang/String;
    //   66: aload 5
    //   68: iload 4
    //   70: putfield 70	com/tencent/mm/plugin/freewifi/b/a$b:mIE	I
    //   73: aload_0
    //   74: getfield 32	com/tencent/mm/plugin/freewifi/b/a:cache	Ljava/util/Map;
    //   77: aload_1
    //   78: aload_2
    //   79: invokestatic 72	com/tencent/mm/plugin/freewifi/b/a:et	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: aload 5
    //   84: invokeinterface 78 3 0
    //   89: pop
    //   90: sipush 20665
    //   93: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -48 -> 48
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramString1	String
    //   0	104	2	paramString2	String
    //   0	104	3	paramString3	String
    //   0	104	4	paramInt	int
    //   58	25	5	localb	a.b
    // Exception table:
    //   from	to	target	type
    //   2	29	99	finally
    //   42	48	99	finally
    //   51	96	99	finally
  }
  
  /* Error */
  public final a.b eu(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20666
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   12: ifne +10 -> 22
    //   15: aload_2
    //   16: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   19: ifeq +15 -> 34
    //   22: aconst_null
    //   23: astore_1
    //   24: sipush 20666
    //   27: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: getfield 32	com/tencent/mm/plugin/freewifi/b/a:cache	Ljava/util/Map;
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 72	com/tencent/mm/plugin/freewifi/b/a:et	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokeinterface 84 2 0
    //   48: checkcast 10	com/tencent/mm/plugin/freewifi/b/a$b
    //   51: astore_1
    //   52: sipush 20666
    //   55: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -28 -> 30
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   0	66	1	paramString1	String
    //   0	66	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	22	61	finally
    //   24	30	61	finally
    //   34	58	61	finally
  }
  
  public final int size()
  {
    try
    {
      AppMethodBeat.i(20667);
      int i = this.cache.size();
      AppMethodBeat.o(20667);
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