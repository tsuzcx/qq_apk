package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  public long inn;
  public long ino;
  public long inp;
  public String inq = "";
  public long inr;
  public long ins;
  public long jdField_int;
  public String inu = "";
  public String inv = "";
  public long inw;
  public String inx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368624);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ino);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ins);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jdField_int);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368624);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368635);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actioncode:").append(this.inn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectfriendnum:").append(this.ino);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendnum:").append(this.inp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendlist:").append(this.inq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beforsocialblackfriendnum:").append(this.inr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aftersocialblackfriendnum:").append(this.ins);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionnum:").append(this.jdField_int);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagname:").append(this.inu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagid:").append(this.inv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.inw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368635);
    return localObject;
  }
  
  public final int getId()
  {
    return 19824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ae
 * JD-Core Version:    0.7.0.1
 */