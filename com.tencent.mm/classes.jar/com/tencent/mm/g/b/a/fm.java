package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class fm
  extends a
{
  public long dKe = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ecH = 0L;
  public long ecI = 0L;
  public String ecJ = "";
  public long ecK = 0L;
  public long ecL = 0L;
  public long ecM = 0L;
  public long ecN = 0L;
  private String ecO = "";
  public String ecP;
  public String ecQ;
  
  public final String PV()
  {
    AppMethodBeat.i(43573);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecH);
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
    ((StringBuffer)localObject).append(this.ecI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecQ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43573);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ecH);
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
    ((StringBuffer)localObject).append("fileSize:").append(this.ecI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filePath:").append(this.ecJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineType:").append(this.ecK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useCodeCache:").append(this.ecL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("useIsolatedContext:").append(this.ecM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("compileTime:").append(this.ecN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("engineVersion:").append(this.ecO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginAppid:").append(this.ecP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginVersion:").append(this.ecQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43574);
    return localObject;
  }
  
  public final fm RZ()
  {
    AppMethodBeat.i(43572);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43572);
    return this;
  }
  
  public final int getId()
  {
    return 16007;
  }
  
  public final fm iu(long paramLong)
  {
    AppMethodBeat.i(43570);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43570);
    return this;
  }
  
  public final fm iv(long paramLong)
  {
    AppMethodBeat.i(43571);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43571);
    return this;
  }
  
  public final fm lm(String paramString)
  {
    AppMethodBeat.i(177749);
    this.ecO = t("engineVersion", paramString, true);
    AppMethodBeat.o(177749);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fm
 * JD-Core Version:    0.7.0.1
 */