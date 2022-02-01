package com.tencent.matrix.a.b;

import com.tencent.matrix.a.b.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public final class b
{
  public a cRJ = new a.a();
  public Callable<String> cRK;
  public long cRL = 120000L;
  public int cRM = 30;
  public long cRN = 30000L;
  public long cRO = 1200000L;
  public long cRP = 600000L;
  public int cRQ = 1024;
  public int cRR = 100;
  public boolean cRS = true;
  public boolean cRT = false;
  public boolean cRU = true;
  public boolean cRV = false;
  public boolean cRW = false;
  public List<String> cRX = Collections.emptyList();
  public List<String> cRY = Collections.emptyList();
  public final List<g> cRZ = new ArrayList(3);
  
  public final String toString()
  {
    return "BatteryMonitorConfig{, wakelockTimeout=" + this.cRL + ", wakelockWarnCount=" + this.cRM + ", greyTime=" + this.cRN + ", foregroundLoopCheckTime=" + this.cRO + ", overHeatCount=" + this.cRQ + ", isForegroundModeEnabled=" + this.cRS + ", isBackgroundModeEnabled=" + this.cRT + ", isBuiltinForegroundNotifyEnabled=" + this.cRU + ", isStatAsSample=" + this.cRV + ", tagWhiteList=" + this.cRX + ", features=" + this.cRZ + '}';
  }
  
  public static final class a
  {
    public final b cSa = new b((byte)0);
    
    public final a Z(Class<? extends g> paramClass)
    {
      try
      {
        this.cSa.cRZ.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
    
    public final a eo(String paramString)
    {
      if (this.cSa.cRX == Collections.EMPTY_LIST) {
        this.cSa.cRX = new ArrayList();
      }
      this.cSa.cRX.add(paramString);
      return this;
    }
    
    public final a ep(String paramString)
    {
      if (this.cSa.cRY == Collections.EMPTY_LIST) {
        this.cSa.cRY = new ArrayList();
      }
      this.cSa.cRY.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.b
 * JD-Core Version:    0.7.0.1
 */