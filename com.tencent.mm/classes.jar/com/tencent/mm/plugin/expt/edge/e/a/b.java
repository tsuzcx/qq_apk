package com.tencent.mm.plugin.expt.edge.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  public String script;
  public int zAa;
  public int zAb;
  public int zAc;
  public int zAd;
  public String zAe;
  public String zAf;
  public String zAg;
  public String zzS;
  public int zzV;
  public int zzW;
  public int zzX;
  public List<a> zzY;
  public int zzZ;
  
  public final String toString()
  {
    AppMethodBeat.i(299652);
    StringBuilder localStringBuilder = new StringBuilder("EdgeComputingScriptConfigModel{configID='").append(this.zzS).append('\'').append(", dataSourceType=").append(this.zzV).append(", dataSourceID=").append(this.zzW).append(", reportID=").append(this.zzX).append(", fieldConfigModels=").append(this.zzY).append(", isInstantReport=").append(this.zzZ).append(", reportMethod=").append(this.zAd).append(", isRepeat=").append(this.zAa).append(", runPeriod=").append(this.zAb).append(", dbExpireTime=").append(this.zAc).append(", script='");
    if (com.tencent.mm.plugin.expt.edge.b.isDebugMode())
    {
      str = this.script;
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", scriptURL='");
      if (!com.tencent.mm.plugin.expt.edge.b.isDebugMode()) {
        break label264;
      }
      str = this.zAe;
      label178:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", scriptMD5='");
      if (!com.tencent.mm.plugin.expt.edge.b.isDebugMode()) {
        break label270;
      }
      str = this.zAg;
      label205:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", originalJson='");
      if (!com.tencent.mm.plugin.expt.edge.b.isDebugMode()) {
        break label276;
      }
    }
    label264:
    label270:
    label276:
    for (String str = this.zAf;; str = "originalJson")
    {
      str = str + '\'' + '}';
      AppMethodBeat.o(299652);
      return str;
      str = "script";
      break;
      str = "scriptURL";
      break label178;
      str = "scriptMD5";
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.e.a.b
 * JD-Core Version:    0.7.0.1
 */