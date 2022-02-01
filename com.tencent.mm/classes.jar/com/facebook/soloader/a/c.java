package com.facebook.soloader.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements b
{
  public final boolean cz(String paramString)
  {
    AppMethodBeat.i(208151);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/facebook/soloader/nativeloader/SystemDelegate", "loadLibrary", "(Ljava/lang/String;I)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/facebook/soloader/nativeloader/SystemDelegate", "loadLibrary", "(Ljava/lang/String;I)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(208151);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.soloader.a.c
 * JD-Core Version:    0.7.0.1
 */