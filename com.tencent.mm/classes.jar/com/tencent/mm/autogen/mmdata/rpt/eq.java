package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
  extends a
{
  public long iDB;
  public String iEH = "";
  public long iEI;
  public long iEJ;
  public String iEK = "";
  public long iEL;
  public long iEM;
  public long iEN;
  public long iEO;
  public long iEP;
  public String iEQ = "";
  public String iER = "";
  public String iES = "";
  public long iET;
  public long iEU;
  public long iEV;
  public long iEW;
  public String iEX = "";
  public String iEY = "";
  public String iEZ = "";
  public String iFa = "";
  public long iFb;
  public long iFc;
  
  public final String aIE()
  {
    AppMethodBeat.i(367855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iER);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iES);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iET);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367855);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("liveId:").append(this.iDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderNickname:").append(this.iEH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("p2pBytes:").append(this.iEI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cdnBytes:").append(this.iEJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("natType:").append(this.iEK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("p2p_upload_switch:").append(this.iEL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("p2p_download_switch:").append(this.iEM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("candidates:").append(this.iEN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("standbys:").append(this.iEO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("load:").append(this.iEP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isp:").append(this.iEQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("url:").append(this.iER);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("full_url:").append(this.iES);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("xs_status:").append(this.iET);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("verify_pieces:").append(this.iEU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("invalid_pieces:").append(this.iEV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tag_missed_invalid_pieces:").append(this.iEW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("uuid:").append(this.iEX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pieceid:").append(this.iEY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("send:").append(this.iEZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recv:").append(this.iFa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("abnormal_ts_count:").append(this.iFb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("total_pieces:").append(this.iFc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367867);
    return localObject;
  }
  
  public final int getId()
  {
    return 23888;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.eq
 * JD-Core Version:    0.7.0.1
 */