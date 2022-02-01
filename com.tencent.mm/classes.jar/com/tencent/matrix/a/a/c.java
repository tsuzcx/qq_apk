package com.tencent.matrix.a.a;

import com.tencent.matrix.a.a.a.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public final class c
{
  public Callable<String> cTA;
  public long cTB = 120000L;
  public int cTC = 30;
  public long cTD = 30000L;
  public long cTE = 1200000L;
  public long cTF = 600000L;
  public int cTG = 200;
  public int cTH = 100;
  public int cTI = 10000;
  public int cTJ = 5000;
  public boolean cTK = true;
  public boolean cTL = false;
  public boolean cTM = true;
  public boolean cTN = false;
  public boolean cTO = false;
  public boolean cTP = false;
  public boolean cTQ = false;
  public int cTR = 0;
  public boolean cTS = false;
  public boolean cTT = false;
  public List<String> cTU = Collections.emptyList();
  public List<String> cTV = Collections.emptyList();
  public List<String> cTW = Collections.emptyList();
  public List<String> cTX = Collections.emptyList();
  public final List<j> cTY = new ArrayList(3);
  public b cTz = new b.a();
  
  public final String toString()
  {
    return "BatteryMonitorConfig{wakelockTimeout=" + this.cTB + ", wakelockWarnCount=" + this.cTC + ", greyTime=" + this.cTD + ", foregroundLoopCheckTime=" + this.cTE + ", backgroundLoopCheckTime=" + this.cTF + ", overHeatCount=" + this.cTG + ", foregroundServiceLeakLimit=" + this.cTH + ", fgThreadWatchingLimit=" + this.cTI + ", bgThreadWatchingLimit=" + this.cTJ + ", isForegroundModeEnabled=" + this.cTK + ", isBackgroundModeEnabled=" + this.cTL + ", isBuiltinForegroundNotifyEnabled=" + this.cTM + ", isStatAsSample=" + this.cTN + ", isStatPidProc=" + this.cTO + ", isInspectiffiesError=" + this.cTP + ", isAmsHookEnabled=" + this.cTQ + ", isAggressiveMode=" + this.cTS + ", isUseThreadClock=" + this.cTT + ", tagWhiteList=" + this.cTU + ", tagBlackList=" + this.cTV + ", looperWatchList=" + this.cTW + ", threadWatchList=" + this.cTX + ", features=" + this.cTY + '}';
  }
  
  public static final class a
  {
    public final c cTZ = new c((byte)0);
    
    public final a aa(Class<? extends j> paramClass)
    {
      try
      {
        this.cTZ.cTY.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
    
    public final a eQ(String paramString)
    {
      if (this.cTZ.cTU == Collections.EMPTY_LIST) {
        this.cTZ.cTU = new ArrayList();
      }
      this.cTZ.cTU.add(paramString);
      return this;
    }
    
    public final a eR(String paramString)
    {
      if (this.cTZ.cTV == Collections.EMPTY_LIST) {
        this.cTZ.cTV = new ArrayList();
      }
      this.cTZ.cTV.add(paramString);
      return this;
    }
    
    public final a eS(String paramString)
    {
      if (this.cTZ.cTX == Collections.EMPTY_LIST) {
        this.cTZ.cTX = new ArrayList();
      }
      this.cTZ.cTX.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.c
 * JD-Core Version:    0.7.0.1
 */