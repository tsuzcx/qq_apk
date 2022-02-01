package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class im
  extends a
{
  public String iQg = "";
  public int iQh = 0;
  public int iQi = 0;
  public int iQj = 0;
  public int iQk = 0;
  public String iQl = "";
  public int iQm = 0;
  public String iQn = "";
  public String iQo = "";
  public int iQp = 0;
  public int inj = 0;
  public int ivL = 0;
  public long iyK;
  
  public final String aIE()
  {
    AppMethodBeat.i(369163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iyK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369163);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369171);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Status:").append(this.iyK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DictName:").append(this.iQg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Version:").append(this.iQh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DictRequiredType:").append(this.iQi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceType:").append(this.ivL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataType:").append(this.iQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressionAlgo:").append(this.iQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedMd5:").append(this.iQl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TypeId:").append(this.iQm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnUrl:").append(this.iQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriMd5:").append(this.iQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatchVersion:").append(this.iQp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369171);
    return localObject;
  }
  
  public final int getId()
  {
    return 22358;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.im
 * JD-Core Version:    0.7.0.1
 */