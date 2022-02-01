package com.tencent.mm.performance.jni.memory;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.HookManager;
import com.tencent.mm.performance.jni.a;
import com.tencent.mm.performance.jni.b;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook hQk;
  private Set<String> hQl;
  private Set<String> hQm;
  public int hQn;
  public int hQo;
  private double hQp;
  public boolean hQq;
  public boolean hQr;
  
  static
  {
    AppMethodBeat.i(73336);
    b.hQi.init();
    hQk = new MemoryHook();
    AppMethodBeat.o(73336);
  }
  
  private MemoryHook()
  {
    AppMethodBeat.i(73331);
    this.hQl = new HashSet();
    this.hQm = new HashSet();
    this.hQp = 1.0D;
    AppMethodBeat.o(73331);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void setSampleSizeRangeNative(int paramInt1, int paramInt2);
  
  private native void setSamplingNative(double paramDouble);
  
  public final void aFJ()
  {
    AppMethodBeat.i(192601);
    if ((this.hQn < 0) || ((this.hQo != 0) && (this.hQo < this.hQn)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.hQn + ", max = " + this.hQo);
      AppMethodBeat.o(192601);
      throw localIllegalArgumentException;
    }
    new StringBuilder("enable mmap? ").append(this.hQr);
    enableMmapHookNative(this.hQr);
    setSampleSizeRangeNative(this.hQn, this.hQo);
    setSamplingNative(this.hQp);
    enableStacktraceNative(this.hQq);
    AppMethodBeat.o(192601);
  }
  
  public final void aFK()
  {
    AppMethodBeat.i(192602);
    addHookSoNative((String[])this.hQl.toArray(new String[0]));
    addIgnoreSoNative((String[])this.hQm.toArray(new String[0]));
    AppMethodBeat.o(192602);
  }
  
  public native void dumpNative(String paramString);
  
  public final void hook()
  {
    AppMethodBeat.i(73335);
    HookManager localHookManager = HookManager.hQf;
    localHookManager.hQh.clear();
    localHookManager.hQh.add(this);
    localHookManager.aFL();
    AppMethodBeat.o(73335);
  }
  
  public final MemoryHook j(String... paramVarArgs)
  {
    AppMethodBeat.i(73332);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (TextUtils.isEmpty(str))
      {
        paramVarArgs = new IllegalArgumentException("regex = ".concat(String.valueOf(str)));
        AppMethodBeat.o(73332);
        throw paramVarArgs;
      }
      this.hQl.add(str);
      i += 1;
    }
    AppMethodBeat.o(73332);
    return this;
  }
  
  public final MemoryHook k(String... paramVarArgs)
  {
    AppMethodBeat.i(73333);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        this.hQm.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(73333);
    return this;
  }
  
  public final MemoryHook n(double paramDouble)
  {
    AppMethodBeat.i(73334);
    if ((this.hQp < 0.0D) || (this.hQp > 1.0D))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sampling should be between 0 and 1: ".concat(String.valueOf(paramDouble)));
      AppMethodBeat.o(73334);
      throw localIllegalArgumentException;
    }
    this.hQp = paramDouble;
    AppMethodBeat.o(73334);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */