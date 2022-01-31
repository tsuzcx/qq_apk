package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.k;

public final class a
{
  public static long dLv;
  public static long dLw;
  public com.tencent.mm.kernel.a.a.b dLt;
  public b dLu;
  public volatile boolean mConfigured = false;
  
  public static String by(long paramLong)
  {
    return System.currentTimeMillis() - paramLong + "ms";
  }
  
  public static final void j(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      k.i("MMSkeleton.Boot", paramString, new Object[0]);
      return;
    }
    k.i("MMSkeleton.Boot", paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.a
 * JD-Core Version:    0.7.0.1
 */