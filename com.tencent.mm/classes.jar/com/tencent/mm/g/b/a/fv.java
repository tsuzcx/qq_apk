package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fv
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  private long ebq = 0L;
  private long ebr = 0L;
  public a edN;
  public long edO = 0L;
  public long edP = 0L;
  public long edQ = 0L;
  public long edR = 0L;
  public long edS = 0L;
  public long edT = 0L;
  public long edU = 0L;
  public long edV = 0L;
  public long edW = 0L;
  public long edX = 0L;
  public long edY = 0L;
  public long edZ = 0L;
  public long eea = 0L;
  public long eeb = 0L;
  public long eec = 0L;
  public long eed = 0L;
  public long eee = 0L;
  public long eef = 0L;
  public long eeg = 0L;
  public long eeh = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(43647);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.edN != null) {}
    for (int i = this.edN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eea);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eec);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eed);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eee);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eef);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeh);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43647);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43648);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.edN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fps:").append(this.edO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsVariance:").append(this.edP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cpu:").append(this.edQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memory:").append(this.edR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("memoryDiff:").append(this.edS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("androidNativeMemory:").append(this.edT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("androidDalvikMemory:").append(this.edU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeDuration:").append(this.edV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runtimeCount:").append(this.edW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mainCanvasType:").append(this.edX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("triangles:").append(this.edY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawcall:").append(this.edZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("vertex:").append(this.eea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCommandBuffer:").append(this.eeb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.eec);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsEx:").append(this.eed);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("graphicsMemory:").append(this.eee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cmdPool:").append(this.eef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsLagCount:").append(this.eeg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fpsLowCount:").append(this.eeh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43648);
    return localObject;
  }
  
  public final fv Sd()
  {
    AppMethodBeat.i(43644);
    this.ebp = 0L;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43644);
    return this;
  }
  
  public final fv Se()
  {
    AppMethodBeat.i(43645);
    this.ebq = 0L;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43645);
    return this;
  }
  
  public final fv Sf()
  {
    AppMethodBeat.i(43646);
    this.ebr = 0L;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43646);
    return this;
  }
  
  public final int getId()
  {
    return 16023;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43643);
      eei = new a("release", 0, 1);
      eej = new a("debug", 1, 2);
      eek = new a("demo", 2, 3);
      eel = new a[] { eei, eej, eek };
      AppMethodBeat.o(43643);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jb(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eei;
      case 2: 
        return eej;
      }
      return eek;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fv
 * JD-Core Version:    0.7.0.1
 */