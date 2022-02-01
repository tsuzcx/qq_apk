package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hy
  extends a
{
  private String dTr = "";
  public long dWt = 0L;
  public long etb = 0L;
  private String euy = "";
  public a evn;
  public b evo;
  public long evp = 0L;
  public long evq = 0L;
  public long evr = 0L;
  public long evs = 0L;
  public long evt = 0L;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.evn != null) {}
    for (int i = this.evn.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.evo != null) {
        i = this.evo.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evs);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evt);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.evn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.evq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.evr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.evs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.evt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final hy rb(String paramString)
  {
    AppMethodBeat.i(43489);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final hy rc(String paramString)
  {
    AppMethodBeat.i(43490);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43485);
      evu = new a("release", 0, 1);
      evv = new a("debug", 1, 2);
      evw = new a("test", 2, 3);
      evx = new a[] { evu, evv, evw };
      AppMethodBeat.o(43485);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jc(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return evu;
      case 2: 
        return evv;
      }
      return evw;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43488);
      evy = new b("undefined", 0, 0);
      evz = new b("normal", 1, 1000);
      evA = new b("plugin", 2, 1001);
      evB = new b("wxstore", 3, 1002);
      evC = new b("merchant", 4, 1003);
      evD = new b("wagame", 5, 1004);
      evE = new b("gift", 6, 1005);
      evF = new b[] { evy, evz, evA, evB, evC, evD, evE };
      AppMethodBeat.o(43488);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b jd(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return evy;
      case 1000: 
        return evz;
      case 1001: 
        return evA;
      case 1002: 
        return evB;
      case 1003: 
        return evC;
      case 1004: 
        return evD;
      }
      return evE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hy
 * JD-Core Version:    0.7.0.1
 */