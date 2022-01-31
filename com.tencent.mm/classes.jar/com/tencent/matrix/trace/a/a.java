package com.tencent.matrix.trace.a;

import android.content.Context;
import java.util.HashSet;

public final class a
{
  public final long bqA;
  public final long bqB;
  public final long bqC;
  public final long bqD;
  public final long bqE;
  public final long bqF;
  private final float bqG;
  public final String bqH;
  public final boolean bqx;
  public final boolean bqy;
  public final HashSet<String> bqz;
  private int mDeviceLevel = 0;
  
  private a(boolean paramBoolean1, boolean paramBoolean2, HashSet<String> paramHashSet, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, float paramFloat, long paramLong6, String paramString)
  {
    this.bqx = paramBoolean1;
    this.bqy = paramBoolean2;
    this.bqz = paramHashSet;
    this.bqA = paramLong1;
    this.bqE = (1000000L * paramLong2);
    this.bqC = paramLong4;
    this.bqD = paramLong5;
    this.bqB = paramLong3;
    this.bqF = paramLong6;
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 16.666668F;
    }
    this.bqG = f;
    this.bqH = paramString;
  }
  
  public final int ai(Context paramContext)
  {
    if (this.mDeviceLevel == 0)
    {
      int i = com.tencent.matrix.trace.f.a.aj(paramContext).value;
      this.mDeviceLevel = i;
      return i;
    }
    return this.mDeviceLevel;
  }
  
  public final boolean rm()
  {
    return (this.bqH != null) && (!this.bqH.equals(""));
  }
  
  public final String toString()
  {
    int i = 0;
    boolean bool1 = this.bqx;
    boolean bool2 = this.bqy;
    if (this.bqz == null) {}
    for (;;)
    {
      return String.format("fpsEnable:%s,methodTraceEnable:%s,sceneSet size:%s,fpsTimeSliceMs:%s,EvilThresholdNano:%sns,frameRefreshRate:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(this.bqA), Long.valueOf(this.bqE), Float.valueOf(this.bqG) });
      i = this.bqz.size();
    }
  }
  
  public static final class a
  {
    public boolean bqI = false;
    public boolean bqJ = false;
    public float bqK = 16.666668F;
    public HashSet<String> bqL;
    public long bqM = 6000L;
    public long bqN = 8000L;
    public long bqO = 6000L;
    public long bqP = 1000L;
    public long bqQ = 3000L;
    public String bqR;
    public long bqS = 120000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.a.a
 * JD-Core Version:    0.7.0.1
 */