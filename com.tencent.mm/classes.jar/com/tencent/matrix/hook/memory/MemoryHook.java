package com.tencent.matrix.hook.memory;

import androidx.annotation.Keep;
import com.tencent.matrix.e.c;
import com.tencent.matrix.hook.a;
import com.tencent.matrix.hook.a.a;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook cYl = new MemoryHook();
  public final Set<String> cYm = new HashSet();
  public final Set<String> cYn = new HashSet();
  public int cYo;
  public int cYp;
  public int cYq = 10485760;
  public boolean cYr;
  public boolean cYs;
  private boolean cYt = false;
  
  @Keep
  private native void addHookSoNative(String[] paramArrayOfString);
  
  @Keep
  private native void addIgnoreSoNative(String[] paramArrayOfString);
  
  @Keep
  private native void dumpNative(String paramString1, String paramString2);
  
  @Keep
  private native void enableMmapHookNative(boolean paramBoolean);
  
  @Keep
  private native void enableStacktraceNative(boolean paramBoolean);
  
  @Keep
  private native void installHooksNative(boolean paramBoolean);
  
  @Keep
  private native void setStacktraceLogThresholdNative(int paramInt);
  
  @Keep
  private native void setTracingAllocSizeRangeNative(int paramInt1, int paramInt2);
  
  public final String WJ()
  {
    return "matrix-memoryhook";
  }
  
  public final boolean WK()
  {
    if ((this.cYo < 0) || ((this.cYp != 0) && (this.cYp < this.cYo))) {
      throw new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.cYo + ", max = " + this.cYp);
    }
    c.d("Matrix.MemoryHook", "enable mmap? " + this.cYs, new Object[0]);
    enableMmapHookNative(this.cYs);
    setTracingAllocSizeRangeNative(this.cYo, this.cYp);
    setStacktraceLogThresholdNative(this.cYq);
    enableStacktraceNative(this.cYr);
    return true;
  }
  
  public final boolean cR(boolean paramBoolean)
  {
    addHookSoNative((String[])this.cYm.toArray(new String[0]));
    addIgnoreSoNative((String[])this.cYn.toArray(new String[0]));
    if (!this.cYt)
    {
      installHooksNative(paramBoolean);
      this.cYt = true;
    }
    return true;
  }
  
  public final void dump(String paramString1, String paramString2)
  {
    if (this.cXZ == a.a.cYb) {
      dumpNative(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.hook.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */