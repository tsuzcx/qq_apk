package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetBackupWxaAttrs;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetWxaAttrs;", "username", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "_executeCostMs", "", "_executeEndMs", "_executeStartMs", "callSync", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "executeCostMs", "executeEndMs", "executeStartMs", "name", "plugin-appbrand-integration_release"})
public final class ar
  implements as
{
  private final String appId;
  private long lOu;
  private long lOv;
  private long lOw;
  private final String username;
  
  public ar(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.appId = paramString2;
  }
  
  public final long bsf()
  {
    return this.lOu;
  }
  
  public final long bsg()
  {
    return this.lOv;
  }
  
  public final long bsh()
  {
    return this.lOw;
  }
  
  public final Pair<WxaAttributes, Boolean> bsi()
  {
    AppMethodBeat.i(223553);
    this.lOu = bu.fpO();
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
    for (localObject = ((s)j.T(s.class)).e(this.appId, new String[0]);; localObject = ((s)localObject).d(str, new String[0]))
    {
      localObject = Pair.create(localObject, Boolean.FALSE);
      p.g(localObject, "Pair.create(attrs, false)");
      this.lOv = bu.fpO();
      this.lOw = (this.lOv - this.lOu);
      AppMethodBeat.o(223553);
      return localObject;
      i = 0;
      break;
      localObject = (s)j.T(s.class);
      str = this.username;
      if (str == null) {
        p.gkB();
      }
    }
  }
  
  public final String name()
  {
    return "LaunchPreconditionTaskGetBackupWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ar
 * JD-Core Version:    0.7.0.1
 */