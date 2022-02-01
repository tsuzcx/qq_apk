package com.tencent.mm.plugin.expt.d.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  public String script;
  public String syg;
  public int syj;
  public int syk;
  public int syl;
  public List<a> sym;
  public int syn;
  public int syo;
  public int syp;
  public int syq;
  public String syr;
  public String sys;
  
  public final String toString()
  {
    AppMethodBeat.i(220345);
    StringBuilder localStringBuilder = new StringBuilder("EdgeComputingScriptConfigModel{configID='").append(this.syg).append('\'').append(", dataSourceType=").append(this.syj).append(", dataSourceID=").append(this.syk).append(", reportID=").append(this.syl).append(", fieldConfigModels=").append(this.sym).append(", isInstantReport=").append(this.syn).append(", isRepeat=").append(this.syo).append(", runPeriod=").append(this.syp).append(", dbExpireTime=").append(this.syq).append(", script='");
    if (com.tencent.mm.plugin.expt.d.b.KB())
    {
      str = this.script;
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", scriptMD5='");
      if (!com.tencent.mm.plugin.expt.d.b.KB()) {
        break label225;
      }
      str = this.sys;
      label166:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", originalJson='");
      if (!com.tencent.mm.plugin.expt.d.b.KB()) {
        break label231;
      }
    }
    label225:
    label231:
    for (String str = this.syr;; str = "originalJson")
    {
      str = str + '\'' + '}';
      AppMethodBeat.o(220345);
      return str;
      str = "script";
      break;
      str = "scriptMD5";
      break label166;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.a.b
 * JD-Core Version:    0.7.0.1
 */