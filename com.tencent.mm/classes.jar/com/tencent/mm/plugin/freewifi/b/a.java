package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a
{
  private Map<String, b> aOa;
  private boolean twV;
  
  private a()
  {
    AppMethodBeat.i(24740);
    this.twV = false;
    this.aOa = new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(Map.Entry paramAnonymousEntry)
      {
        AppMethodBeat.i(24738);
        if (size() > 512)
        {
          AppMethodBeat.o(24738);
          return true;
        }
        AppMethodBeat.o(24738);
        return false;
      }
    };
    AppMethodBeat.o(24740);
  }
  
  private static String gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24741);
    paramString1 = paramString1 + "-" + paramString2;
    AppMethodBeat.o(24741);
    return paramString1;
  }
  
  /* Error */
  public final void e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 24742
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 63	com/tencent/mm/plugin/freewifi/m:ef	(Ljava/lang/String;)Z
    //   12: ifne +30 -> 42
    //   15: aload_2
    //   16: invokestatic 63	com/tencent/mm/plugin/freewifi/m:ef	(Ljava/lang/String;)Z
    //   19: ifne +23 -> 42
    //   22: aload_3
    //   23: invokestatic 63	com/tencent/mm/plugin/freewifi/m:ef	(Ljava/lang/String;)Z
    //   26: ifne +16 -> 42
    //   29: iload 4
    //   31: iconst_4
    //   32: if_icmpeq +19 -> 51
    //   35: iload 4
    //   37: bipush 31
    //   39: if_icmpeq +12 -> 51
    //   42: sipush 24742
    //   45: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: new 11	com/tencent/mm/plugin/freewifi/b/a$b
    //   54: dup
    //   55: invokespecial 64	com/tencent/mm/plugin/freewifi/b/a$b:<init>	()V
    //   58: astore 5
    //   60: aload 5
    //   62: aload_3
    //   63: putfield 68	com/tencent/mm/plugin/freewifi/b/a$b:dnO	Ljava/lang/String;
    //   66: aload 5
    //   68: iload 4
    //   70: putfield 72	com/tencent/mm/plugin/freewifi/b/a$b:tvY	I
    //   73: aload_0
    //   74: getfield 34	com/tencent/mm/plugin/freewifi/b/a:aOa	Ljava/util/Map;
    //   77: aload_1
    //   78: aload_2
    //   79: invokestatic 74	com/tencent/mm/plugin/freewifi/b/a:gL	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: aload 5
    //   84: invokeinterface 80 3 0
    //   89: pop
    //   90: sipush 24742
    //   93: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   58	25	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	29	99	finally
    //   42	48	99	finally
    //   51	96	99	finally
  }
  
  /* Error */
  public final b gM(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 24743
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 63	com/tencent/mm/plugin/freewifi/m:ef	(Ljava/lang/String;)Z
    //   12: ifne +10 -> 22
    //   15: aload_2
    //   16: invokestatic 63	com/tencent/mm/plugin/freewifi/m:ef	(Ljava/lang/String;)Z
    //   19: ifeq +15 -> 34
    //   22: aconst_null
    //   23: astore_1
    //   24: sipush 24743
    //   27: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: getfield 34	com/tencent/mm/plugin/freewifi/b/a:aOa	Ljava/util/Map;
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 74	com/tencent/mm/plugin/freewifi/b/a:gL	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokeinterface 86 2 0
    //   48: checkcast 11	com/tencent/mm/plugin/freewifi/b/a$b
    //   51: astore_1
    //   52: sipush 24743
    //   55: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(24744);
      int i = this.aOa.size();
      AppMethodBeat.o(24744);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
  {
    private static a twX;
    
    static
    {
      AppMethodBeat.i(24739);
      twX = new a((byte)0);
      AppMethodBeat.o(24739);
    }
  }
  
  public static final class b
  {
    String dnO;
    int tvY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.a
 * JD-Core Version:    0.7.0.1
 */