package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  public long cRG = 0L;
  private String cSd = "";
  private String cZA = "";
  public long cZB = 0L;
  public a cZY;
  public b cZZ;
  public long daa = 0L;
  public long dab = 0L;
  public long dac = 0L;
  public long dad = 0L;
  public long dae = 0L;
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(128654);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.cZY != null) {}
    for (int i = this.cZY.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cZZ != null) {
        i = this.cZZ.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.daa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dab);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dae);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128654);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128655);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.cZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.daa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.dab);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.dac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.dad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.dae);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128655);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final cb ha(String paramString)
  {
    AppMethodBeat.i(128652);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(128652);
    return this;
  }
  
  public final cb hb(String paramString)
  {
    AppMethodBeat.i(128653);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128653);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(128648);
      daf = new a("release", 0, 1);
      dag = new a("debug", 1, 2);
      dah = new a("test", 2, 3);
      dai = new a[] { daf, dag, dah };
      AppMethodBeat.o(128648);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a gN(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return daf;
      case 2: 
        return dag;
      }
      return dah;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(128651);
      daj = new b("undefined", 0, 0);
      dak = new b("normal", 1, 1000);
      dal = new b("plugin", 2, 1001);
      dam = new b("wxstore", 3, 1002);
      dan = new b("merchant", 4, 1003);
      dao = new b("wagame", 5, 1004);
      dap = new b("gift", 6, 1005);
      daq = new b[] { daj, dak, dal, dam, dan, dao, dap };
      AppMethodBeat.o(128651);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b gO(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return daj;
      case 1000: 
        return dak;
      case 1001: 
        return dal;
      case 1002: 
        return dam;
      case 1003: 
        return dan;
      case 1004: 
        return dao;
      }
      return dap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */