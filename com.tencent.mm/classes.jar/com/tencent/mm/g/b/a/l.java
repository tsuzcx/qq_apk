package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class l
  extends a
{
  private String ekq = "";
  private int ekr;
  private int eks;
  private int ekt;
  private int eku;
  private String ekv = "";
  
  public final String abV()
  {
    AppMethodBeat.i(199739);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eks);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(199739);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(199740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Content:").append(this.ekq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlay:").append(this.ekr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlaySuccess:").append(this.eks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayFailReason:").append(this.ekt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecentUse:").append(this.eku);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.ekv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199740);
    return localObject;
  }
  
  public final l abZ()
  {
    this.ekt = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22146;
  }
  
  public final l hP(String paramString)
  {
    AppMethodBeat.i(199737);
    this.ekq = x("Content", paramString, true);
    AppMethodBeat.o(199737);
    return this;
  }
  
  public final l hQ(String paramString)
  {
    AppMethodBeat.i(199738);
    this.ekv = x("ChatId", paramString, true);
    AppMethodBeat.o(199738);
    return this;
  }
  
  public final l jC(int paramInt)
  {
    this.ekr = paramInt;
    return this;
  }
  
  public final l jD(int paramInt)
  {
    this.eks = paramInt;
    return this;
  }
  
  public final l jE(int paramInt)
  {
    this.eku = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.l
 * JD-Core Version:    0.7.0.1
 */