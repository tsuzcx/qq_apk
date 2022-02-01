package com.facebook.jni;

import com.facebook.soloader.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadScopeSupport
{
  static
  {
    AppMethodBeat.i(208060);
    a.loadLibrary("fbjni");
    AppMethodBeat.o(208060);
  }
  
  private static void runStdFunction(long paramLong)
  {
    AppMethodBeat.i(208053);
    runStdFunctionImpl(paramLong);
    AppMethodBeat.o(208053);
  }
  
  private static native void runStdFunctionImpl(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.jni.ThreadScopeSupport
 * JD-Core Version:    0.7.0.1
 */