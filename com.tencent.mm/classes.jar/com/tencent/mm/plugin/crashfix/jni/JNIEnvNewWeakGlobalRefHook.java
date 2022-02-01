package com.tencent.mm.plugin.crashfix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class JNIEnvNewWeakGlobalRefHook
{
  public static native void calculateOffset();
  
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(145626);
    System.loadLibrary("systemcrashprotect");
    AppMethodBeat.o(145626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook
 * JD-Core Version:    0.7.0.1
 */