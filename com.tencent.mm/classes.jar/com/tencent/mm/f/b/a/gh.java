package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  private String gCs = "";
  private int gCt;
  private String gcU = "";
  private int ggl;
  private int giX;
  
  public final String agH()
  {
    AppMethodBeat.i(214240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214240);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PackageName:").append(this.gCs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KbType:").append(this.gCt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214241);
    return localObject;
  }
  
  public final int getId()
  {
    return 21766;
  }
  
  public final gh mJ(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final gh mK(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final gh mL(int paramInt)
  {
    this.gCt = paramInt;
    return this;
  }
  
  public final gh vv(String paramString)
  {
    AppMethodBeat.i(214235);
    this.gCs = z("PackageName", paramString, true);
    AppMethodBeat.o(214235);
    return this;
  }
  
  public final gh vw(String paramString)
  {
    AppMethodBeat.i(214238);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(214238);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gh
 * JD-Core Version:    0.7.0.1
 */