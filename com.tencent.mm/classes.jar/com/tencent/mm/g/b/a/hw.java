package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hw
  extends a
{
  private String dSb = "";
  public long dVd = 0L;
  public long eru = 0L;
  private String esR = "";
  public a etG;
  public hw.b etH;
  public long etI = 0L;
  public long etJ = 0L;
  public long etK = 0L;
  public long etL = 0L;
  public long etM = 0L;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(43491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.etG != null) {}
    for (int i = this.etG.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.etH != null) {
        i = this.etH.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etM);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43491);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.etG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.etH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadKey:").append(this.etJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadValue:").append(this.etK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDownloadCode:").append(this.etL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasSplashScreen:").append(this.etM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43492);
    return localObject;
  }
  
  public final int getId()
  {
    return 16602;
  }
  
  public final hw qG(String paramString)
  {
    AppMethodBeat.i(43489);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(43489);
    return this;
  }
  
  public final hw qH(String paramString)
  {
    AppMethodBeat.i(43490);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43490);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43485);
      etN = new a("release", 0, 1);
      etO = new a("debug", 1, 2);
      etP = new a("test", 2, 3);
      etQ = new a[] { etN, etO, etP };
      AppMethodBeat.o(43485);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ja(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return etN;
      case 2: 
        return etO;
      }
      return etP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw
 * JD-Core Version:    0.7.0.1
 */