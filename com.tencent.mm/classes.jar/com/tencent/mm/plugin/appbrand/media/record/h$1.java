package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements h.a
{
  public final void ge(String paramString)
  {
    AppMethodBeat.i(175888);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/tencent/mm/plugin/appbrand/media/record/AudioRecordUtil$1", "loadLibrary", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/media/record/AudioRecordUtil$1", "loadLibrary", "(Ljava/lang/String;Ljava/lang/ClassLoader;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(175888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.h.1
 * JD-Core Version:    0.7.0.1
 */