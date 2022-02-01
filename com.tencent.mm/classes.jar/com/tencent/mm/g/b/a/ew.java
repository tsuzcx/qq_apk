package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  private long dYT = 0L;
  private String eag;
  private long eai = 0L;
  private a eap;
  private long eaq = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eap != null) {}
    for (int i = this.eap.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaq);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eap);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.eaq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final ew a(a parama)
  {
    this.eap = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public final ew hM(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final ew hN(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final ew hO(long paramLong)
  {
    this.eaq = paramLong;
    return this;
  }
  
  public final ew kT(String paramString)
  {
    AppMethodBeat.i(43475);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43474);
      ear = new a("release", 0, 1);
      eas = new a("debug", 1, 2);
      eat = new a("demo", 2, 3);
      eau = new a[] { ear, eas, eat };
      AppMethodBeat.o(43474);
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
        return ear;
      case 2: 
        return eas;
      }
      return eat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ew
 * JD-Core Version:    0.7.0.1
 */