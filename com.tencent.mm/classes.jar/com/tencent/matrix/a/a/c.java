package com.tencent.matrix.a.a;

import com.tencent.matrix.a.a.a.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public final class c
{
  public final List<m> ePA = new ArrayList(3);
  public b ePb = new b.a();
  public Callable<String> ePc;
  public long ePd = 120000L;
  public int ePe = 30;
  public long ePf = 30000L;
  public long ePg = 1200000L;
  public long ePh = 600000L;
  public int ePi = 200;
  public int ePj = 100;
  public int ePk = 10000;
  public int ePl = 5000;
  public boolean ePm = true;
  public boolean ePn = false;
  public boolean ePo = true;
  public boolean ePp = false;
  public boolean ePq = false;
  public boolean ePr = false;
  public boolean ePs = false;
  public int ePt = 0;
  public boolean ePu = false;
  public boolean ePv = false;
  public List<String> ePw = Collections.emptyList();
  public List<String> ePx = Collections.emptyList();
  public List<String> ePy = Collections.emptyList();
  public List<String> ePz = Collections.emptyList();
  
  public final String toString()
  {
    return "BatteryMonitorConfig{wakelockTimeout=" + this.ePd + ", wakelockWarnCount=" + this.ePe + ", greyTime=" + this.ePf + ", foregroundLoopCheckTime=" + this.ePg + ", backgroundLoopCheckTime=" + this.ePh + ", overHeatCount=" + this.ePi + ", foregroundServiceLeakLimit=" + this.ePj + ", fgThreadWatchingLimit=" + this.ePk + ", bgThreadWatchingLimit=" + this.ePl + ", isForegroundModeEnabled=" + this.ePm + ", isBackgroundModeEnabled=" + this.ePn + ", isBuiltinForegroundNotifyEnabled=" + this.ePo + ", isStatAsSample=" + this.ePp + ", isStatPidProc=" + this.ePq + ", isInspectiffiesError=" + this.ePr + ", isAmsHookEnabled=" + this.ePs + ", isAggressiveMode=" + this.ePu + ", isUseThreadClock=" + this.ePv + ", tagWhiteList=" + this.ePw + ", tagBlackList=" + this.ePx + ", looperWatchList=" + this.ePy + ", threadWatchList=" + this.ePz + ", features=" + this.ePA + '}';
  }
  
  public static final class a
  {
    public final c ePB = new c((byte)0);
    
    public final a ak(Class<? extends m> paramClass)
    {
      try
      {
        this.ePB.ePA.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
    
    public final a gp(String paramString)
    {
      if (this.ePB.ePw == Collections.EMPTY_LIST) {
        this.ePB.ePw = new ArrayList();
      }
      this.ePB.ePw.add(paramString);
      return this;
    }
    
    public final a gq(String paramString)
    {
      if (this.ePB.ePx == Collections.EMPTY_LIST) {
        this.ePB.ePx = new ArrayList();
      }
      this.ePB.ePx.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.c
 * JD-Core Version:    0.7.0.1
 */