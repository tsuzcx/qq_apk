package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ln
  extends a
{
  private String eJx = "";
  private long eXc = 0L;
  private a eYV;
  private long eYW = 0L;
  private long eYX = 0L;
  private String eYY = "";
  
  public final ln a(a parama)
  {
    this.eYV = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.eYV != null) {}
    for (int i = this.eYV.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYY);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.eYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.eYY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long aiR()
  {
    return this.eYX;
  }
  
  public final String aiS()
  {
    return this.eYY;
  }
  
  public final String getAppId()
  {
    return this.eJx;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final ln vb(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final ln vc(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final ln vd(long paramLong)
  {
    this.eYX = paramLong;
    return this;
  }
  
  public final ln yT(String paramString)
  {
    AppMethodBeat.i(43469);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final ln yU(String paramString)
  {
    AppMethodBeat.i(180149);
    this.eYY = x("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43468);
      eYZ = new a("release", 0, 1);
      eZa = new a("debug", 1, 2);
      eZb = new a("demo", 2, 3);
      eZc = new a[] { eYZ, eZa, eZb };
      AppMethodBeat.o(43468);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mb(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eYZ;
      case 2: 
        return eZa;
      }
      return eZb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ln
 * JD-Core Version:    0.7.0.1
 */