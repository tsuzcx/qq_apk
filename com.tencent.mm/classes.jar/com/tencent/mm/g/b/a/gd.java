package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class gd
  extends a
{
  public long dKe = 0L;
  public long dON = 0L;
  public long dYT = 0L;
  public String dYa = "";
  public long eaX = 0L;
  public String eag = "";
  public long eai = 0L;
  private long ebp = 0L;
  public long ebq = 0L;
  public long ebr = 0L;
  public long ecS;
  public long ect = 0L;
  public a efT;
  public long efU = 0L;
  public gd.c efV;
  public gd.b efW;
  public long efX = 0L;
  private long efY = 0L;
  private long efZ = 0L;
  private long ega = 0L;
  public long egb;
  public long egc;
  public long egd;
  public long ege;
  public gd.d egf;
  public long egg;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.efT != null)
    {
      i = this.efT.value;
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
      ((StringBuffer)localObject).append(this.efU);
      ((StringBuffer)localObject).append(",");
      if (this.efV == null) {
        break label497;
      }
      i = this.efV.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.efW == null) {
        break label502;
      }
    }
    label497:
    label502:
    for (int i = this.efW.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dON);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ega);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ect);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ege);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.egf != null) {
        i = this.egf.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.egg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecS);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efT);
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
    ((StringBuffer)localObject).append("PkgSize:").append(this.efU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.efV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.efW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.efX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.efY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.efZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.eaX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.ega);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.ect);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.egb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.egc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.egd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.ege);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.egf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.egg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.ecS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final gd Si()
  {
    AppMethodBeat.i(43720);
    this.ebr = bt.eGO();
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final gd jN(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final gd jO(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final gd jP(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.ega = paramLong;
    super.ba("NonUICostTimeMs", this.ega);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43711);
      egh = new a("release", 0, 1);
      egi = new a("debug", 1, 2);
      egj = new a("demo", 2, 3);
      egk = new a[] { egh, egi, egj };
      AppMethodBeat.o(43711);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jk(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return egh;
      case 2: 
        return egi;
      }
      return egj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gd
 * JD-Core Version:    0.7.0.1
 */