package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lo
  extends a
{
  private String eJx = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private a eZd;
  private long eZe = 0L;
  
  public final lo a(a parama)
  {
    this.eZd = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.eZd != null) {}
    for (int i = this.eZd.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eZe);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.eZe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public final lo ve(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final lo vf(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final lo vg(long paramLong)
  {
    this.eZe = paramLong;
    return this;
  }
  
  public final lo yV(String paramString)
  {
    AppMethodBeat.i(43475);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43474);
      eZf = new a("release", 0, 1);
      eZg = new a("debug", 1, 2);
      eZh = new a("demo", 2, 3);
      eZi = new a[] { eZf, eZg, eZh };
      AppMethodBeat.o(43474);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mc(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eZf;
      case 2: 
        return eZg;
      }
      return eZh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lo
 * JD-Core Version:    0.7.0.1
 */