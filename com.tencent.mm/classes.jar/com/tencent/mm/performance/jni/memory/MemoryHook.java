package com.tencent.mm.performance.jni.memory;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.AbsHook;
import com.tencent.mm.performance.jni.HookManager;
import com.tencent.mm.performance.jni.LibWxPerfManager;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends AbsHook
{
  public static final MemoryHook INSTANCE;
  private boolean mEnableMmap;
  private boolean mEnableStacktrace;
  private Set<String> mHookSoSet;
  private Set<String> mIgnoreSoSet;
  private int mMaxTraceSize;
  private int mMinTraceSize;
  private double mSampling;
  
  static
  {
    AppMethodBeat.i(73336);
    LibWxPerfManager.INSTANCE.init();
    INSTANCE = new MemoryHook();
    AppMethodBeat.o(73336);
  }
  
  private MemoryHook()
  {
    AppMethodBeat.i(73331);
    this.mHookSoSet = new HashSet();
    this.mIgnoreSoSet = new HashSet();
    this.mSampling = 1.0D;
    AppMethodBeat.o(73331);
  }
  
  private native void addHookSoNative(String[] paramArrayOfString);
  
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  private native void dumpNative(String paramString);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void setSampleSizeRangeNative(int paramInt1, int paramInt2);
  
  private native void setSamplingNative(double paramDouble);
  
  public MemoryHook addHookSo(String paramString)
  {
    AppMethodBeat.i(195656);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("regex = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195656);
      throw paramString;
    }
    this.mHookSoSet.add(paramString);
    AppMethodBeat.o(195656);
    return this;
  }
  
  public MemoryHook addHookSo(String... paramVarArgs)
  {
    AppMethodBeat.i(73332);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addHookSo(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(73332);
    return this;
  }
  
  public MemoryHook addIgnoreSo(String paramString)
  {
    AppMethodBeat.i(195657);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(195657);
      return this;
    }
    this.mIgnoreSoSet.add(paramString);
    AppMethodBeat.o(195657);
    return this;
  }
  
  public MemoryHook addIgnoreSo(String... paramVarArgs)
  {
    AppMethodBeat.i(73333);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addIgnoreSo(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(73333);
    return this;
  }
  
  public void dump(String paramString)
  {
    AppMethodBeat.i(195660);
    dumpNative(paramString);
    AppMethodBeat.o(195660);
  }
  
  public MemoryHook enableMmapHook(boolean paramBoolean)
  {
    this.mEnableMmap = paramBoolean;
    return this;
  }
  
  public MemoryHook enableStacktrace(boolean paramBoolean)
  {
    this.mEnableStacktrace = paramBoolean;
    return this;
  }
  
  public void hook()
  {
    AppMethodBeat.i(73335);
    HookManager.INSTANCE.clearHooks().addHook(this).commitHooks();
    AppMethodBeat.o(73335);
  }
  
  public MemoryHook maxTraceSize(int paramInt)
  {
    this.mMaxTraceSize = paramInt;
    return this;
  }
  
  public MemoryHook minTraceSize(int paramInt)
  {
    this.mMinTraceSize = paramInt;
    return this;
  }
  
  public void onConfigure()
  {
    AppMethodBeat.i(195658);
    if ((this.mMinTraceSize < 0) || ((this.mMaxTraceSize != 0) && (this.mMaxTraceSize < this.mMinTraceSize)))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.mMinTraceSize + ", max = " + this.mMaxTraceSize);
      AppMethodBeat.o(195658);
      throw localIllegalArgumentException;
    }
    new StringBuilder("enable mmap? ").append(this.mEnableMmap);
    enableMmapHookNative(this.mEnableMmap);
    setSampleSizeRangeNative(this.mMinTraceSize, this.mMaxTraceSize);
    setSamplingNative(this.mSampling);
    enableStacktraceNative(this.mEnableStacktrace);
    AppMethodBeat.o(195658);
  }
  
  public void onHook()
  {
    AppMethodBeat.i(195659);
    addHookSoNative((String[])this.mHookSoSet.toArray(new String[0]));
    addIgnoreSoNative((String[])this.mIgnoreSoSet.toArray(new String[0]));
    AppMethodBeat.o(195659);
  }
  
  public MemoryHook sampling(double paramDouble)
  {
    AppMethodBeat.i(73334);
    if ((this.mSampling < 0.0D) || (this.mSampling > 1.0D))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("sampling should be between 0 and 1: ".concat(String.valueOf(paramDouble)));
      AppMethodBeat.o(73334);
      throw localIllegalArgumentException;
    }
    this.mSampling = paramDouble;
    AppMethodBeat.o(73334);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */