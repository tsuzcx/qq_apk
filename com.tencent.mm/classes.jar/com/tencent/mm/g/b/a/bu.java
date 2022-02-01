package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  private String eoz = "";
  private String erH = "";
  private long ery;
  private String etS = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208916);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedID:").append(this.etS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208917);
    return localObject;
  }
  
  public final bu eH(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21726;
  }
  
  public final bu kh(String paramString)
  {
    AppMethodBeat.i(208913);
    this.etS = x("feedID", paramString, true);
    AppMethodBeat.o(208913);
    return this;
  }
  
  public final bu ki(String paramString)
  {
    AppMethodBeat.i(208914);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208914);
    return this;
  }
  
  public final bu kj(String paramString)
  {
    AppMethodBeat.i(208915);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(208915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bu
 * JD-Core Version:    0.7.0.1
 */