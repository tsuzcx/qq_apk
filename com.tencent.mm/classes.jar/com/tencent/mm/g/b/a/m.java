package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  public int dPT;
  private String dSe;
  public int dSf;
  public int dSg;
  private String dSh;
  private String dSi;
  public int dSj;
  private String dSk;
  private String dSl;
  
  public final String RD()
  {
    AppMethodBeat.i(217628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSl);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(217628);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(217629);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.dSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.dSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.dSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.dSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.dSl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217629);
    return localObject;
  }
  
  public final m RJ()
  {
    this.dSg = 67;
    return this;
  }
  
  public final m gI(String paramString)
  {
    AppMethodBeat.i(217623);
    this.dSe = t("RequestId", paramString, true);
    AppMethodBeat.o(217623);
    return this;
  }
  
  public final m gJ(String paramString)
  {
    AppMethodBeat.i(217624);
    this.dSh = t("MsgId", paramString, true);
    AppMethodBeat.o(217624);
    return this;
  }
  
  public final m gK(String paramString)
  {
    AppMethodBeat.i(217625);
    this.dSi = t("MsgFromUsername", paramString, true);
    AppMethodBeat.o(217625);
    return this;
  }
  
  public final m gL(String paramString)
  {
    AppMethodBeat.i(217626);
    this.dSk = t("ChatRoomID", paramString, true);
    AppMethodBeat.o(217626);
    return this;
  }
  
  public final m gM(String paramString)
  {
    AppMethodBeat.i(217627);
    this.dSl = t("PicMD5", paramString, true);
    AppMethodBeat.o(217627);
    return this;
  }
  
  public final int getId()
  {
    return 20511;
  }
  
  public final m ig(int paramInt)
  {
    this.dPT = paramInt;
    return this;
  }
  
  public final m ih(int paramInt)
  {
    this.dSf = paramInt;
    return this;
  }
  
  public final m ii(int paramInt)
  {
    this.dSj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.m
 * JD-Core Version:    0.7.0.1
 */