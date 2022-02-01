package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public int eki;
  private String eno = "";
  public int enp;
  public int enq;
  private String enr = "";
  private String ens = "";
  public int ent;
  private String enu = "";
  private String enw = "";
  public long enx = 0L;
  private int eny;
  private String enz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(187791);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ens);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ent);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187791);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187792);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.enp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.enr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.ens);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.ent);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.enu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.enw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampsInMs:").append(this.enx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiRet:").append(this.eny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiAction:").append(this.enz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187792);
    return localObject;
  }
  
  public final ab bW(long paramLong)
  {
    this.enx = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20511;
  }
  
  public final ab ie(String paramString)
  {
    AppMethodBeat.i(187785);
    this.eno = x("RequestId", paramString, true);
    AppMethodBeat.o(187785);
    return this;
  }
  
  public final ab jdMethod_if(String paramString)
  {
    AppMethodBeat.i(187786);
    this.enr = x("MsgId", paramString, true);
    AppMethodBeat.o(187786);
    return this;
  }
  
  public final ab ig(String paramString)
  {
    AppMethodBeat.i(187787);
    this.ens = x("MsgFromUsername", paramString, true);
    AppMethodBeat.o(187787);
    return this;
  }
  
  public final ab ih(String paramString)
  {
    AppMethodBeat.i(187788);
    this.enu = x("ChatRoomID", paramString, true);
    AppMethodBeat.o(187788);
    return this;
  }
  
  public final ab ii(String paramString)
  {
    AppMethodBeat.i(187789);
    this.enw = x("PicMD5", paramString, true);
    AppMethodBeat.o(187789);
    return this;
  }
  
  public final ab ij(String paramString)
  {
    AppMethodBeat.i(187790);
    this.enz = x("CgiAction", paramString, true);
    AppMethodBeat.o(187790);
    return this;
  }
  
  public final ab jK(int paramInt)
  {
    this.eki = paramInt;
    return this;
  }
  
  public final ab jL(int paramInt)
  {
    this.enp = paramInt;
    return this;
  }
  
  public final ab jM(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final ab jN(int paramInt)
  {
    this.ent = paramInt;
    return this;
  }
  
  public final ab jO(int paramInt)
  {
    this.eny = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */