package com.tencent.matrix.trace.a;

import com.tencent.c.a.a;
import java.util.Set;

public final class b
{
  public boolean cBA;
  public boolean cBB;
  public boolean cBC;
  public boolean cBD;
  public String cBE;
  public Set<String> cBF;
  public boolean cBG = true;
  public boolean cBz;
  public a cwi;
  public boolean cxf;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.cxf).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.cBD).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.cBG).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.cBz).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.cBA).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.cBB).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.cBC).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.cBE).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */