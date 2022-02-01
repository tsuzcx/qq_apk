package com.tencent.matrix.trace.a;

import com.tencent.c.a.a;
import java.util.Set;

public final class b
{
  public a cVx;
  public boolean cWq;
  public boolean daK;
  public boolean daL;
  public boolean daM;
  public boolean daN;
  public boolean daO;
  public String daP;
  public Set<String> daQ;
  public boolean daR = true;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.cWq).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.daO).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.daR).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.daK).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.daL).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.daM).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.daN).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.daP).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b daS = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */