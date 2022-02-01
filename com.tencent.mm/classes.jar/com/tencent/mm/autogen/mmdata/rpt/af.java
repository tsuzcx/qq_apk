package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class af
  extends a
{
  public long ila;
  public long inA;
  public long inB;
  public String inC = "";
  public long inD;
  public long inE;
  public long inF;
  public String inG = "";
  public String inH = "";
  public String inI = "";
  public long inJ;
  public long inK;
  public long inL;
  public long inM;
  public long inN;
  public long inw;
  public String inx = "";
  public String iny = "";
  public String inz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368640);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368640);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368650);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.inz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_uin:").append(this.inA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distance:").append(this.inB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("district:").append(this.inC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_sns:").append(this.inD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.inE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filterType:").append(this.inF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_username:").append(this.inG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("city:").append(this.inH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("country:").append(this.inI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_finder:").append(this.inJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_signature:").append(this.inK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_nickname_has_emoji:").append(this.inL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_user_pos:").append(this.inM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_user_gender:").append(this.inN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.inw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368650);
    return localObject;
  }
  
  public final int getId()
  {
    return 21855;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.af
 * JD-Core Version:    0.7.0.1
 */