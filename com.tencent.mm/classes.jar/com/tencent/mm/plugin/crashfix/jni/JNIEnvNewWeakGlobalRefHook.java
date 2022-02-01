package com.tencent.mm.plugin.crashfix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class JNIEnvNewWeakGlobalRefHook
{
  private byte _hellAccFlag_;
  
  public static native void calculateOffset();
  
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static void init()
  {
    AppMethodBeat.i(145626);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("systemcrashprotect");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/crashfix/jni/JNIEnvNewWeakGlobalRefHook", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/crashfix/jni/JNIEnvNewWeakGlobalRefHook", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(145626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook
 * JD-Core Version:    0.7.0.1
 */