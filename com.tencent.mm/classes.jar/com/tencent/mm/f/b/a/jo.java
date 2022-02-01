package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jo
  extends a
{
  private String gLn = "";
  public long gLo;
  public long gLp;
  public long gLq;
  public long gLr;
  public long gLs;
  public long gLt;
  public long gLu;
  public long gLv;
  public long gLw;
  public long gLx;
  public long gLy;
  public long gmT;
  public long guX;
  
  public final jo AC(String paramString)
  {
    AppMethodBeat.i(283822);
    this.gLn = z("friendUsername", paramString, true);
    AppMethodBeat.o(283822);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(283824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gLn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLy);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(283824);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(283825);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("friendUsername:").append(this.gLn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isClickAll:").append(this.gLo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("buttonAddNewLabelCnt:").append(this.gLp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchAddNewLabelCnt:").append(this.gLq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectAddLabelCnt:").append(this.gLr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchAddLabelCnt:").append(this.gLs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oriLabelCnt:").append(this.gLt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("removedLabelCnt:").append(this.gLu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addedLabelCnt:").append(this.gLv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTime:").append(this.guX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLabelCnt:").append(this.gLw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("opResult:").append(this.gLx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addremark:").append(this.gLy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(283825);
    return localObject;
  }
  
  public final int getId()
  {
    return 22865;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jo
 * JD-Core Version:    0.7.0.1
 */