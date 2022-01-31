package com.tencent.matrix.trace.a;

import java.util.Set;

public final class a
{
  public com.tencent.mrs.b.a bNO;
  public boolean bQT;
  public boolean bQU;
  public boolean bQV;
  public boolean bQW;
  public boolean bQX;
  public String bQY;
  public Set<String> bQZ;
  public boolean isDebug;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.isDebug).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.bQX).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.bQT).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.bQU).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.bQV).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.bQW).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.bQY).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public a bRa = new a((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.a.a
 * JD-Core Version:    0.7.0.1
 */