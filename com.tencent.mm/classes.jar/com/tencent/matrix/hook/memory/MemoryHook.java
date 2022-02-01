package com.tencent.matrix.hook.memory;

import com.tencent.matrix.e.c;
import com.tencent.matrix.hook.a;
import com.tencent.matrix.hook.a.a;
import com.tencent.matrix.memguard.MemGuard;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook
  extends a
{
  public static final MemoryHook eVb = new MemoryHook();
  public final Set<String> eVc = new HashSet();
  public final Set<String> eVd = new HashSet();
  public int eVe;
  public int eVf;
  public int eVg = 10485760;
  public boolean eVh;
  public boolean eVi;
  private boolean eVj = false;
  
  private native void dumpNative(String paramString1, String paramString2);
  
  private native void enableMmapHookNative(boolean paramBoolean);
  
  private native void enableStacktraceNative(boolean paramBoolean);
  
  private native void installHooksNative(String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean);
  
  private native void setStacktraceLogThresholdNative(int paramInt);
  
  private native void setTracingAllocSizeRangeNative(int paramInt1, int paramInt2);
  
  public final String axH()
  {
    return "matrix-memoryhook";
  }
  
  public final boolean axI()
  {
    if (MemGuard.isInstalled())
    {
      c.w("Matrix.MemoryHook", "MemGuard has been installed, skip MemoryHook install logic.", new Object[0]);
      return false;
    }
    if ((this.eVe < 0) || ((this.eVf != 0) && (this.eVf < this.eVe))) {
      throw new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.eVe + ", max = " + this.eVf);
    }
    c.d("Matrix.MemoryHook", "enable mmap? " + this.eVi, new Object[0]);
    enableMmapHookNative(this.eVi);
    setTracingAllocSizeRangeNative(this.eVe, this.eVf);
    setStacktraceLogThresholdNative(this.eVg);
    enableStacktraceNative(this.eVh);
    return true;
  }
  
  public final void dump(String paramString1, String paramString2)
  {
    if (this.eUE == a.a.eUG) {
      dumpNative(paramString1, paramString2);
    }
  }
  
  public final boolean dy(boolean paramBoolean)
  {
    if (!this.eVj)
    {
      installHooksNative((String[])this.eVc.toArray(new String[0]), (String[])this.eVd.toArray(new String[0]), paramBoolean);
      this.eVj = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.hook.memory.MemoryHook
 * JD-Core Version:    0.7.0.1
 */