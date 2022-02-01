package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class om
  extends a
{
  private long gYL = 0L;
  private long gYN = 0L;
  private String gmF = "";
  private a hbU;
  private long hbV = 0L;
  
  public final om AZ(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final om Ba(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final om Bb(long paramLong)
  {
    this.hbV = paramLong;
    return this;
  }
  
  public final om FB(String paramString)
  {
    AppMethodBeat.i(43475);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
  
  public final om a(a parama)
  {
    this.hbU = parama;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hbU != null) {}
    for (int i = this.hbU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hbV);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hbU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.hbV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43474);
      hbW = new a("release", 0, 1);
      hbX = new a("debug", 1, 2);
      hbY = new a("demo", 2, 3);
      hbZ = new a[] { hbW, hbX, hbY };
      AppMethodBeat.o(43474);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a on(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return hbW;
      case 2: 
        return hbX;
      }
      return hbY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.om
 * JD-Core Version:    0.7.0.1
 */