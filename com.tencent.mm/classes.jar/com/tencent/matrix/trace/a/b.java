package com.tencent.matrix.trace.a;

import com.tencent.c.a.a;
import java.util.Set;

public final class b
{
  public a ctq;
  public boolean cuo;
  public boolean cyI;
  public boolean cyJ;
  public boolean cyK;
  public boolean cyL;
  public boolean cyM;
  public String cyN;
  public Set<String> cyO;
  public boolean cyP = true;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.cuo).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.cyM).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.cyP).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.cyI).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.cyJ).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.cyK).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.cyL).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.cyN).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b cyQ = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */