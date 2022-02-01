package com.tencent.mm.performance.jni.pthread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.a;
import com.tencent.mm.performance.jni.b;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook
  extends a
{
  public static final PthreadHook hQs;
  private Set<String> hQl;
  private Set<String> hQm;
  private Set<String> hQt;
  
  static
  {
    AppMethodBeat.i(192606);
    b.hQi.init();
    hQs = new PthreadHook();
    AppMethodBeat.o(192606);
  }
  
  private PthreadHook()
  {
    AppMethodBeat.i(192603);
    this.hQl = new HashSet();
    this.hQm = new HashSet();
    this.hQt = new HashSet();
    AppMethodBeat.o(192603);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addHookThreadNameNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void dumpNative(String paramString);
  
  public final void aFJ()
  {
    AppMethodBeat.i(192604);
    addHookThreadNameNative((String[])this.hQt.toArray(new String[0]));
    AppMethodBeat.o(192604);
  }
  
  public final void aFK()
  {
    AppMethodBeat.i(192605);
    addHookSoNative((String[])this.hQl.toArray(new String[0]));
    addIgnoreSoNative((String[])this.hQm.toArray(new String[0]));
    AppMethodBeat.o(192605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.pthread.PthreadHook
 * JD-Core Version:    0.7.0.1
 */