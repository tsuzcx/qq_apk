package com.tencent.mm.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a mtv;
  
  static
  {
    AppMethodBeat.i(43439);
    mtv = new a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(43437);
        paramAnonymousString = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousString.aYi(), "com/tencent/mm/game/lockstep/LockstepLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramAnonymousString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/game/lockstep/LockstepLoadDelegate$1", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(43437);
      }
    };
    AppMethodBeat.o(43439);
  }
  
  public static void a(a parama)
  {
    mtv = parama;
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(43438);
    mtv.loadLibrary("mmlockstep");
    AppMethodBeat.o(43438);
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.b.a
 * JD-Core Version:    0.7.0.1
 */