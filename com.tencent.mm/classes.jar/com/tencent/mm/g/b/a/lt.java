package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lt
  extends a
{
  private String eJx = "";
  public long eXc = 0L;
  public a eZI;
  public b eZJ;
  public long eZK = 0L;
  public long eZL = 0L;
  public long eZM = 0L;
  public long eZN = 0L;
  public long eZO = 0L;
  private String eiB = "";
  public long erW = 0L;
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.eZI != null) {}
    for (int i = this.eZI.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eZJ != null) {
        i = this.eZJ.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZO);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eZI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eZJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.eZL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.eZM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.eZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.eZO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final lt ze(String paramString)
  {
    AppMethodBeat.i(43489);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final lt zf(String paramString)
  {
    AppMethodBeat.i(43490);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43485);
      eZP = new a("release", 0, 1);
      eZQ = new a("debug", 1, 2);
      eZR = new a("test", 2, 3);
      eZS = new a[] { eZP, eZQ, eZR };
      AppMethodBeat.o(43485);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a me(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eZP;
      case 2: 
        return eZQ;
      }
      return eZR;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43488);
      eZT = new b("undefined", 0, 0);
      eZU = new b("normal", 1, 1000);
      eZV = new b("plugin", 2, 1001);
      eZW = new b("wxstore", 3, 1002);
      eZX = new b("merchant", 4, 1003);
      eZY = new b("wagame", 5, 1004);
      eZZ = new b("gift", 6, 1005);
      faa = new b[] { eZT, eZU, eZV, eZW, eZX, eZY, eZZ };
      AppMethodBeat.o(43488);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b mf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return eZT;
      case 1000: 
        return eZU;
      case 1001: 
        return eZV;
      case 1002: 
        return eZW;
      case 1003: 
        return eZX;
      case 1004: 
        return eZY;
      }
      return eZZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lt
 * JD-Core Version:    0.7.0.1
 */