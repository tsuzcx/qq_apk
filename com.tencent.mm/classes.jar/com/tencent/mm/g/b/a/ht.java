package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  private long etb = 0L;
  private long euA = 0L;
  private a euH;
  private long euI = 0L;
  private String euy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.euH != null) {}
    for (int i = this.euH.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euI);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.euH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.euI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final ht a(a parama)
  {
    this.euH = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public final ht nu(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final ht nv(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final ht nw(long paramLong)
  {
    this.euI = paramLong;
    return this;
  }
  
  public final ht qS(String paramString)
  {
    AppMethodBeat.i(43475);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43474);
      euJ = new a("release", 0, 1);
      euK = new a("debug", 1, 2);
      euL = new a("demo", 2, 3);
      euM = new a[] { euJ, euK, euL };
      AppMethodBeat.o(43474);
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
        return euJ;
      case 2: 
        return euK;
      }
      return euL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ht
 * JD-Core Version:    0.7.0.1
 */