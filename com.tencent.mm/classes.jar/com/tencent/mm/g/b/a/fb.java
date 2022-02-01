package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fb
  extends a
{
  private String dHr = "";
  public long dKe = 0L;
  public long dYT = 0L;
  public a eaV;
  public b eaW;
  public long eaX = 0L;
  public long eaY = 0L;
  public long eaZ = 0L;
  private String eag = "";
  public long eba = 0L;
  public long ebb = 0L;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eaV != null) {}
    for (int i = this.eaV.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eaW != null) {
        i = this.eaW.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eba);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebb);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eaV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eaW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.eaY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.eaZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.ebb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final fb lc(String paramString)
  {
    AppMethodBeat.i(43489);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final fb ld(String paramString)
  {
    AppMethodBeat.i(43490);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43485);
      ebc = new a("release", 0, 1);
      ebd = new a("debug", 1, 2);
      ebe = new a("test", 2, 3);
      ebf = new a[] { ebc, ebd, ebe };
      AppMethodBeat.o(43485);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iJ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ebc;
      case 2: 
        return ebd;
      }
      return ebe;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43488);
      ebg = new b("undefined", 0, 0);
      ebh = new b("normal", 1, 1000);
      ebi = new b("plugin", 2, 1001);
      ebj = new b("wxstore", 3, 1002);
      ebk = new b("merchant", 4, 1003);
      ebl = new b("wagame", 5, 1004);
      ebm = new b("gift", 6, 1005);
      ebn = new b[] { ebg, ebh, ebi, ebj, ebk, ebl, ebm };
      AppMethodBeat.o(43488);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b iK(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return ebg;
      case 1000: 
        return ebh;
      case 1001: 
        return ebi;
      case 1002: 
        return ebj;
      case 1003: 
        return ebk;
      case 1004: 
        return ebl;
      }
      return ebm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fb
 * JD-Core Version:    0.7.0.1
 */