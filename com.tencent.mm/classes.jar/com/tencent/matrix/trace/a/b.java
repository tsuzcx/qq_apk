package com.tencent.matrix.trace.a;

import com.tencent.b.a.a;
import java.util.Set;

public final class b
{
  public boolean dal;
  public a dcH;
  public boolean deM;
  public boolean deN;
  public boolean deO;
  public boolean deP = true;
  public boolean deQ;
  public boolean deR;
  public String deS;
  public Set<String> deT;
  public boolean deU = true;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.dal).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.deR).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.deU).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.deM).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.deN).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.deO).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.deQ).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.deS).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b deV = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */