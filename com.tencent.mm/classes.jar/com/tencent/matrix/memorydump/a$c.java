package com.tencent.matrix.memorydump;

import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/Thread;", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"}, k=3, mv={1, 1, 16})
final class a$c
  implements ThreadFactory
{
  public static final c eWM = new c();
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "matrix_memory_dump_executor");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.memorydump.a.c
 * JD-Core Version:    0.7.0.1
 */