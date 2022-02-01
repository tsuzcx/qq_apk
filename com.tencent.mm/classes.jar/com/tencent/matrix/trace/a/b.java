package com.tencent.matrix.trace.a;

import com.tencent.c.a.a;
import java.util.Set;

public final class b
{
  public a cET;
  public boolean cFS;
  public boolean cKm;
  public boolean cKn;
  public boolean cKo;
  public boolean cKp;
  public boolean cKq;
  public String cKr;
  public Set<String> cKs;
  public boolean cKt = true;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.cFS).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.cKq).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.cKt).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.cKm).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.cKn).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.cKo).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.cKp).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.cKr).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b cKu = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */