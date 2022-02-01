package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  public int ilm;
  public int imM;
  public int imW;
  private String ioY = "";
  public int ioZ;
  private String ipa = "";
  private String ipb = "";
  private String ipc = "";
  private String ipd = "";
  public long ipe = 0L;
  public int ipf;
  public String ipg = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368646);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368646);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368655);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.ioY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.ioZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.ipa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.ipb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.imM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.ipc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.ipd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampsInMs:").append(this.ipe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiRet:").append(this.ipf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiAction:").append(this.ipg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368655);
    return localObject;
  }
  
  public final int getId()
  {
    return 20511;
  }
  
  public final ap kC(String paramString)
  {
    AppMethodBeat.i(368591);
    this.ioY = F("RequestId", paramString, true);
    AppMethodBeat.o(368591);
    return this;
  }
  
  public final ap kD(String paramString)
  {
    AppMethodBeat.i(368601);
    this.ipa = F("MsgId", paramString, true);
    AppMethodBeat.o(368601);
    return this;
  }
  
  public final ap kE(String paramString)
  {
    AppMethodBeat.i(368612);
    this.ipb = F("MsgFromUsername", paramString, true);
    AppMethodBeat.o(368612);
    return this;
  }
  
  public final ap kF(String paramString)
  {
    AppMethodBeat.i(368622);
    this.ipc = F("ChatRoomID", paramString, true);
    AppMethodBeat.o(368622);
    return this;
  }
  
  public final ap kG(String paramString)
  {
    AppMethodBeat.i(368627);
    this.ipd = F("PicMD5", paramString, true);
    AppMethodBeat.o(368627);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ap
 * JD-Core Version:    0.7.0.1
 */