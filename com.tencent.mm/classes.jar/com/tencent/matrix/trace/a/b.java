package com.tencent.matrix.trace.a;

import com.tencent.c.a.a;
import java.util.Set;

public final class b
{
  public a cEm;
  public boolean cFj;
  public boolean cJD;
  public boolean cJE;
  public boolean cJF;
  public boolean cJG;
  public boolean cJH;
  public String cJI;
  public Set<String> cJJ;
  public boolean cJK = true;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.cFj).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.cJH).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.cJK).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.cJD).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.cJE).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.cJF).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.cJG).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.cJI).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b cJL = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */