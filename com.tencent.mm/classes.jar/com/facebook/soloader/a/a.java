package com.facebook.soloader.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static b cDD;
  
  public static void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(208165);
      if (cDD != null)
      {
        paramb = new IllegalStateException("Cannot re-initialize NativeLoader.");
        AppMethodBeat.o(208165);
        throw paramb;
      }
    }
    finally {}
    cDD = paramb;
    AppMethodBeat.o(208165);
  }
  
  public static void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(208173);
      if (!isInitialized()) {
        a(paramb);
      }
      AppMethodBeat.o(208173);
      return;
    }
    finally {}
  }
  
  private static boolean cz(String paramString)
  {
    AppMethodBeat.i(208156);
    try
    {
      if (cDD == null)
      {
        paramString = new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
        AppMethodBeat.o(208156);
        throw paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(208156);
    }
    boolean bool = cDD.cz(paramString);
    AppMethodBeat.o(208156);
    return bool;
  }
  
  /* Error */
  public static boolean isInitialized()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 22	com/facebook/soloader/a/a:cDD	Lcom/facebook/soloader/a/b;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localb	b
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static boolean loadLibrary(String paramString)
  {
    AppMethodBeat.i(208147);
    boolean bool = cz(paramString);
    AppMethodBeat.o(208147);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.soloader.a.a
 * JD-Core Version:    0.7.0.1
 */