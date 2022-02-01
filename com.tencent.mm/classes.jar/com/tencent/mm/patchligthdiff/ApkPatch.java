package com.tencent.mm.patchligthdiff;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApkPatch
{
  static
  {
    AppMethodBeat.i(231448);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("apk_patch");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/patchligthdiff/ApkPatch", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/patchligthdiff/ApkPatch", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(231448);
  }
  
  public static native int patch(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.patchligthdiff.ApkPatch
 * JD-Core Version:    0.7.0.1
 */