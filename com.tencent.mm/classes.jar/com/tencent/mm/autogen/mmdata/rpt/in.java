package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  public String iOe = "";
  public String iOf = "";
  public long iQq = 0L;
  public long iQr = 0L;
  public long iQs = 0L;
  public long iQt = 0L;
  public String ijk = "";
  public long iwE = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(369189);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iQq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369189);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369197);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.iQq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.iQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.iQs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.iQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.iwE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.iOe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.iOf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369197);
    return localObject;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final in rQ(String paramString)
  {
    AppMethodBeat.i(369169);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369169);
    return this;
  }
  
  public final in rR(String paramString)
  {
    AppMethodBeat.i(369174);
    this.iOe = F("FileID", paramString, true);
    AppMethodBeat.o(369174);
    return this;
  }
  
  public final in rS(String paramString)
  {
    AppMethodBeat.i(369178);
    this.iOf = F("AesKey", paramString, true);
    AppMethodBeat.o(369178);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.in
 * JD-Core Version:    0.7.0.1
 */