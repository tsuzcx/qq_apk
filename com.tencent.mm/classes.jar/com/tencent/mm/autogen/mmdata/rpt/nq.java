package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nq
  extends a
{
  public int imW = -1;
  public long iow = -1L;
  public long ioy = -1L;
  public long ioz = -1L;
  private String irj = "";
  public String jfA = "";
  public String jfB = "";
  public String jfC = "";
  public int jfD = -1;
  public int jfE = -1;
  public int jfF = -1;
  public int jfG = -1;
  public int jfH = -1;
  public int jfI = -1;
  private long jfJ = -1L;
  public long jfK = -1L;
  private String jfL = "";
  public int jfw = -1;
  public int jfx = -1;
  public int jfy = -1;
  public long jfz = -1L;
  
  public final String aIE()
  {
    AppMethodBeat.i(367843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jfw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.irj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfL);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367843);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367850);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OperateType:").append(this.jfw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.irj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.jfx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CoverType:").append(this.jfy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsObjId:").append(this.jfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageInfo:").append(this.jfA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoInfo:").append(this.jfB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderInfo:").append(this.jfC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.jfD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetSceneCode:").append(this.jfE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetSceneCost:").append(this.jfF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FoldClickCount:").append(this.jfG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLike:").append(this.jfH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeStateChange:").append(this.jfI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.iow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeStamp:").append(this.ioz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTimeStamp:").append(this.ioy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeTimeStamp:").append(this.jfJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstPlayTimeStamp:").append(this.jfK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsCoverInfo:").append(this.jfL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367850);
    return localObject;
  }
  
  public final int getId()
  {
    return 23697;
  }
  
  public final nq vK(String paramString)
  {
    AppMethodBeat.i(367827);
    this.irj = F("UserName", paramString, true);
    AppMethodBeat.o(367827);
    return this;
  }
  
  public final nq vL(String paramString)
  {
    AppMethodBeat.i(367835);
    this.jfL = F("SnsCoverInfo", paramString, true);
    AppMethodBeat.o(367835);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nq
 * JD-Core Version:    0.7.0.1
 */