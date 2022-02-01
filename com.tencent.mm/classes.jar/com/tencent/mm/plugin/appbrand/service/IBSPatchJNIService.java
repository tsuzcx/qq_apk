package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;

public abstract interface IBSPatchJNIService
  extends a
{
  public abstract int bspatch(String paramString1, String paramString2, String paramString3);
  
  public static abstract interface ConstantsIncrementalMergeResult
  {
    public static final int FAIL_ALLOC = -3;
    public static final int FAIL_DECOMPRESS = -4;
    public static final int FAIL_OVERFLOW = -5;
    public static final int FAIL_READ_DIFF_FILE = -7;
    public static final int FAIL_READ_OLD_FILE = -6;
    public static final int FATAL = 1;
    public static final int OK = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService
 * JD-Core Version:    0.7.0.1
 */