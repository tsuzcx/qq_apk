package com.tencent.mm.plugin.expt.d.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  public String script;
  public String wdY;
  public int web;
  public int wec;
  public int wed;
  public List<a> wee;
  public int wef;
  public int weg;
  public int weh;
  public int wei;
  public int wej;
  public String wek;
  public String wel;
  public String wem;
  
  public final String toString()
  {
    AppMethodBeat.i(257037);
    StringBuilder localStringBuilder = new StringBuilder("EdgeComputingScriptConfigModel{configID='").append(this.wdY).append('\'').append(", dataSourceType=").append(this.web).append(", dataSourceID=").append(this.wec).append(", reportID=").append(this.wed).append(", fieldConfigModels=").append(this.wee).append(", isInstantReport=").append(this.wef).append(", reportMethod=").append(this.wej).append(", isRepeat=").append(this.weg).append(", runPeriod=").append(this.weh).append(", dbExpireTime=").append(this.wei).append(", script='");
    if (com.tencent.mm.plugin.expt.d.b.No())
    {
      str = this.script;
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", scriptURL='");
      if (!com.tencent.mm.plugin.expt.d.b.No()) {
        break label264;
      }
      str = this.wek;
      label178:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", scriptMD5='");
      if (!com.tencent.mm.plugin.expt.d.b.No()) {
        break label270;
      }
      str = this.wem;
      label205:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", originalJson='");
      if (!com.tencent.mm.plugin.expt.d.b.No()) {
        break label276;
      }
    }
    label264:
    label270:
    label276:
    for (String str = this.wel;; str = "originalJson")
    {
      str = str + '\'' + '}';
      AppMethodBeat.o(257037);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.f.a.b
 * JD-Core Version:    0.7.0.1
 */