package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetBackupWxaAttrs;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetWxaAttrs;", "username", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "_executeCostMs", "", "_executeEndMs", "_executeStartMs", "callSync", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "executeCostMs", "executeEndMs", "executeStartMs", "name", "plugin-appbrand-integration_release"})
public final class ad
  implements ae
{
  private final String appId;
  private long pWf;
  private long pWg;
  private long pWh;
  private final String username;
  
  public ad(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.appId = paramString2;
  }
  
  public final long bZX()
  {
    return this.pWf;
  }
  
  public final long bZY()
  {
    return this.pWg;
  }
  
  public final long bZZ()
  {
    return this.pWh;
  }
  
  public final Pair<WxaAttributes, Boolean> caa()
  {
    AppMethodBeat.i(277398);
    this.pWf = Util.nowMilliSecond();
    Object localObject = (CharSequence)this.appId;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label105;
      }
    }
    label105:
    String str;
    for (localObject = ((v)m.W(v.class)).d(this.appId, new String[0]);; localObject = ((v)localObject).c(str, new String[0]))
    {
      localObject = Pair.create(localObject, Boolean.FALSE);
      p.j(localObject, "Pair.create(attrs, false)");
      this.pWg = Util.nowMilliSecond();
      this.pWh = (this.pWg - this.pWf);
      AppMethodBeat.o(277398);
      return localObject;
      i = 0;
      break;
      localObject = (v)m.W(v.class);
      str = this.username;
      if (str == null) {
        p.iCn();
      }
    }
  }
  
  public final String name()
  {
    return "LaunchPreconditionTaskGetBackupWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ad
 * JD-Core Version:    0.7.0.1
 */