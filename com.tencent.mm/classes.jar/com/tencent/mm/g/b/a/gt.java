package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  private String dFe = "";
  public long dHY = 0L;
  public long eaM = 0L;
  private String ecm = "";
  public a edb;
  public b edc;
  public long edd = 0L;
  public long ede = 0L;
  public long edf = 0L;
  public long edg = 0L;
  public long edh = 0L;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.edb != null) {}
    for (int i = this.edb.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.edc != null) {
        i = this.edc.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ede);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edh);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.edc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.ede);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.edf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.edg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.edh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final gt oh(String paramString)
  {
    AppMethodBeat.i(43489);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final gt oi(String paramString)
  {
    AppMethodBeat.i(43490);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43485);
      edi = new a("release", 0, 1);
      edj = new a("debug", 1, 2);
      edk = new a("test", 2, 3);
      edl = new a[] { edi, edj, edk };
      AppMethodBeat.o(43485);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iH(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return edi;
      case 2: 
        return edj;
      }
      return edk;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43488);
      edm = new b("undefined", 0, 0);
      edn = new b("normal", 1, 1000);
      edo = new b("plugin", 2, 1001);
      edp = new b("wxstore", 3, 1002);
      edq = new b("merchant", 4, 1003);
      edr = new b("wagame", 5, 1004);
      eds = new b("gift", 6, 1005);
      edt = new b[] { edm, edn, edo, edp, edq, edr, eds };
      AppMethodBeat.o(43488);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b iI(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return edm;
      case 1000: 
        return edn;
      case 1001: 
        return edo;
      case 1002: 
        return edp;
      case 1003: 
        return edq;
      case 1004: 
        return edr;
      }
      return eds;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gt
 * JD-Core Version:    0.7.0.1
 */