package com.tencent.matrix.memorydump;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "dumpHprof", "", "fd", "exit", "", "code", "fdFromForkPair", "pointer", "", "fork", "timeout", "forkPipe", "free", "initialize", "", "initializeNative", "pidFromForkPair", "wait", "pid", "matrix-memory-dump_release"}, k=2, mv={1, 1, 16})
public final class MemoryDumpKt
{
  private static final native int dumpHprof(int paramInt);
  
  private static final native void exit(int paramInt);
  
  private static final native int fdFromForkPair(long paramLong);
  
  private static final native int fork(long paramLong);
  
  private static final native long forkPipe(long paramLong);
  
  private static final native void free(long paramLong);
  
  private static final native boolean initializeNative();
  
  private static final native int pidFromForkPair(long paramLong);
  
  private static final native int wait(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.memorydump.MemoryDumpKt
 * JD-Core Version:    0.7.0.1
 */