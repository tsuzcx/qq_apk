package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class th
  extends a
{
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long iqr = 0L;
  public long jBA = 0L;
  public long jBB = 0L;
  public long jBC = 0L;
  public long jBD = 0L;
  public long jBE = 0L;
  public long jBF = 0L;
  public long jBG = 0L;
  public long jBH = 0L;
  public long jBI = 0L;
  public long jBJ = 0L;
  public long jBK = 0L;
  public long jBL = 0L;
  public long jBM = 0L;
  public long jBN = 0L;
  public long jBO = 0L;
  public long jBP = 0L;
  public long jBQ = 0L;
  public long jBR = 0L;
  public long jBS = 0L;
  private long jBT = 0L;
  private long jBU = 0L;
  private long jBV = 0L;
  public long jBW = 0L;
  public long jBX = 0L;
  public long jBY = 0L;
  public th.a jBy;
  public long jBz = 0L;
  public long jax = 0L;
  private long jyH = 0L;
  private long jyI = 0L;
  private long jyJ = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(43647);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jBy != null) {}
    for (int i = this.jBy.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jBY);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(43647);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43648);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jBy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.jyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.jyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.jyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fps:").append(this.jBz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsVariance:").append(this.jBA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cpu:").append(this.jBB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memory:").append(this.jBC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memoryDiff:").append(this.jBD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("androidNativeMemory:").append(this.jBE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("androidDalvikMemory:").append(this.jBF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeDuration:").append(this.jBG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeCount:").append(this.jBH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mainCanvasType:").append(this.jBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("triangles:").append(this.jBJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawcall:").append(this.jBK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("vertex:").append(this.jBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCommandBuffer:").append(this.jBM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.jBN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsEx:").append(this.jBO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("graphicsMemory:").append(this.jBP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cmdPool:").append(this.jBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsLagCount:").append(this.jBR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsLowCount:").append(this.jBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memoryInFootprint:").append(this.jBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memoryDiffInFootprint:").append(this.jBU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("maxThreadCpu:").append(this.jBV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jank:").append(this.jBW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bigjank:").append(this.jBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stutter:").append(this.jBY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43648);
    return localObject;
  }
  
  public final th aJf()
  {
    AppMethodBeat.i(43644);
    this.jyH = 0L;
    super.bw("CostTimeMs", this.jyH);
    AppMethodBeat.o(43644);
    return this;
  }
  
  public final th aJg()
  {
    AppMethodBeat.i(43645);
    this.jyI = 0L;
    super.by("StartTimeStampMs", this.jyI);
    AppMethodBeat.o(43645);
    return this;
  }
  
  public final th aJh()
  {
    AppMethodBeat.i(43646);
    this.jyJ = 0L;
    super.by("EndTimeStampMs", this.jyJ);
    AppMethodBeat.o(43646);
    return this;
  }
  
  public final int getId()
  {
    return 16023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.th
 * JD-Core Version:    0.7.0.1
 */