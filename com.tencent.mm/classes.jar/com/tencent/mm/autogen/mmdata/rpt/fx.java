package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fx
  extends a
{
  public long iJA;
  public long iJB;
  public long iJC;
  public long iJD;
  private long iJE;
  public long iJF;
  public int iJG;
  public long iJv;
  public long iJw;
  public int iJx;
  public long iJy;
  public long iJz;
  
  public final String aIE()
  {
    AppMethodBeat.i(368005);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368005);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368011);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenCameraCost:").append(this.iJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameCost:").append(this.iJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCamera2:").append(this.iJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateRecorderCost:").append(this.iJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StopRecorderCost:").append(this.iJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RenderFps:").append(this.iJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RenderFrameCost:").append(this.iJB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EffectInitCost:").append(this.iJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EffectTrackCost:").append(this.iJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EffectRenderCost:").append(this.iJE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EffectErrCode:").append(this.iJF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextStep:").append(this.iJG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368011);
    return localObject;
  }
  
  public final int getId()
  {
    return 23312;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fx
 * JD-Core Version:    0.7.0.1
 */