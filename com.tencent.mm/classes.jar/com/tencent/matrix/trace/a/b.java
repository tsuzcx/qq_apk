package com.tencent.matrix.trace.a;

import com.tencent.b.a.a;
import java.util.Set;

public final class b
{
  public boolean eLL;
  public boolean eYL;
  public a fbi;
  public boolean fdB;
  public boolean fdC;
  public boolean fdD;
  public boolean fdE = true;
  public boolean fdF;
  public boolean fdG;
  public int fdH = 2000;
  public int fdI = 2000;
  public boolean fdJ;
  public boolean fdK;
  public boolean fdL;
  public int fdM = 0;
  public boolean fdN;
  public String fdO;
  public Set<String> fdP;
  public String fdQ = "";
  public String fdR = "";
  public boolean fdS = true;
  public boolean fdT;
  
  public final boolean azE()
  {
    return (this.fdC) || (this.fdD);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("# TraceConfig\n");
    localStringBuilder.append("* isDebug:\t").append(this.eYL).append("\n");
    localStringBuilder.append("* isDevEnv:\t").append(this.fdK).append("\n");
    localStringBuilder.append("* isHasActivity:\t").append(this.fdS).append("\n");
    localStringBuilder.append("* defaultFpsEnable:\t").append(this.fdB).append("\n");
    localStringBuilder.append("* defaultMethodTraceEnable:\t").append(this.fdC).append("\n");
    localStringBuilder.append("* defaultStartupEnable:\t").append(this.fdD).append("\n");
    localStringBuilder.append("* defaultAnrEnable:\t").append(this.fdF).append("\n");
    localStringBuilder.append("* splashActivities:\t").append(this.fdO).append("\n");
    localStringBuilder.append("* historyMsgRecorder:\t").append(this.fdT).append("\n");
    localStringBuilder.append("* denseMsgTracer:\t").append(this.eLL).append("\n");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public b fdU = new b((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.a.b
 * JD-Core Version:    0.7.0.1
 */