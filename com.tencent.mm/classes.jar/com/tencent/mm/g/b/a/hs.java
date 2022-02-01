package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private long etb = 0L;
  private long euA = 0L;
  private long euB = 0L;
  private String euC = "";
  private String euy = "";
  private a euz;
  
  public final String RC()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.euz != null) {}
    for (int i = this.euz.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euC);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.euz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.euB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.euC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long Va()
  {
    return this.euB;
  }
  
  public final String Vb()
  {
    return this.euC;
  }
  
  public final hs a(a parama)
  {
    this.euz = parama;
    return this;
  }
  
  public final String getAppId()
  {
    return this.euy;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final hs nr(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final hs ns(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final hs nt(long paramLong)
  {
    this.euB = paramLong;
    return this;
  }
  
  public final hs qQ(String paramString)
  {
    AppMethodBeat.i(43469);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final hs qR(String paramString)
  {
    AppMethodBeat.i(180149);
    this.euC = t("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43468);
      euD = new a("release", 0, 1);
      euE = new a("debug", 1, 2);
      euF = new a("demo", 2, 3);
      euG = new a[] { euD, euE, euF };
      AppMethodBeat.o(43468);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a iZ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return euD;
      case 2: 
        return euE;
      }
      return euF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hs
 * JD-Core Version:    0.7.0.1
 */