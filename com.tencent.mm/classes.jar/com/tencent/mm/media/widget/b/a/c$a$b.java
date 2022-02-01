package com.tencent.mm.media.widget.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "name", "", "<anonymous parameter 2>", "", "newThread"})
final class c$a$b
  implements HardCoderJNI.HCPerfManagerThread
{
  public static final b haf;
  
  static
  {
    AppMethodBeat.i(94188);
    haf = new b();
    AppMethodBeat.o(94188);
  }
  
  public final Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(94187);
    paramRunnable = new Thread(paramRunnable, paramString);
    AppMethodBeat.o(94187);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */