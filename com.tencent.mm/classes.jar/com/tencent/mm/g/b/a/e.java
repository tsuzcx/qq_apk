package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class e
  extends a
{
  public long dDm;
  public long dDn;
  public long dDo;
  public String dDp;
  public long dDq;
  public long dDr;
  public long dDs;
  public String dDt;
  public String dDu;
  public long dDv;
  public String dDw;
  
  public final String PR()
  {
    AppMethodBeat.i(195924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dDw);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195924);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actioncode:").append(this.dDm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectfriendnum:").append(this.dDn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendnum:").append(this.dDo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendlist:").append(this.dDp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beforsocialblackfriendnum:").append(this.dDq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aftersocialblackfriendnum:").append(this.dDr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionnum:").append(this.dDs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagname:").append(this.dDt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagid:").append(this.dDu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.dDv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195925);
    return localObject;
  }
  
  public final int getId()
  {
    return 19824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */