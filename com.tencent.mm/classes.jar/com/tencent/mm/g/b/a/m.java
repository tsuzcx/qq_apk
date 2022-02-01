package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  public int dRj;
  private String dTA = "";
  private String dTB = "";
  private String dTu = "";
  public int dTv;
  public int dTw;
  private String dTx = "";
  private String dTy = "";
  public int dTz;
  
  public final String RC()
  {
    AppMethodBeat.i(188458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188458);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.dTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.dTB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188459);
    return localObject;
  }
  
  public final m RI()
  {
    this.dTw = 67;
    return this;
  }
  
  public final m gO(String paramString)
  {
    AppMethodBeat.i(188453);
    this.dTu = t("RequestId", paramString, true);
    AppMethodBeat.o(188453);
    return this;
  }
  
  public final m gP(String paramString)
  {
    AppMethodBeat.i(188454);
    this.dTx = t("MsgId", paramString, true);
    AppMethodBeat.o(188454);
    return this;
  }
  
  public final m gQ(String paramString)
  {
    AppMethodBeat.i(188455);
    this.dTy = t("MsgFromUsername", paramString, true);
    AppMethodBeat.o(188455);
    return this;
  }
  
  public final m gR(String paramString)
  {
    AppMethodBeat.i(188456);
    this.dTA = t("ChatRoomID", paramString, true);
    AppMethodBeat.o(188456);
    return this;
  }
  
  public final m gS(String paramString)
  {
    AppMethodBeat.i(188457);
    this.dTB = t("PicMD5", paramString, true);
    AppMethodBeat.o(188457);
    return this;
  }
  
  public final int getId()
  {
    return 20511;
  }
  
  public final m ii(int paramInt)
  {
    this.dRj = paramInt;
    return this;
  }
  
  public final m ij(int paramInt)
  {
    this.dTv = paramInt;
    return this;
  }
  
  public final m ik(int paramInt)
  {
    this.dTz = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.m
 * JD-Core Version:    0.7.0.1
 */