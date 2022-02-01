package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetBackupWxaAttrs;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetWxaAttrs;", "username", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "_executeCostMs", "", "_executeEndMs", "_executeStartMs", "callSync", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "executeCostMs", "executeEndMs", "executeStartMs", "name", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  implements af
{
  private final String appId;
  private long taR;
  private long taS;
  private long taT;
  private final String username;
  
  public ae(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.appId = paramString2;
  }
  
  public final long cAj()
  {
    return this.taR;
  }
  
  public final long cAk()
  {
    return this.taS;
  }
  
  public final long cAl()
  {
    return this.taT;
  }
  
  public final Pair<WxaAttributes, Boolean> cAm()
  {
    AppMethodBeat.i(320686);
    this.taR = Util.nowMilliSecond();
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
    for (localObject = ((aa)n.ag(aa.class)).e(this.appId, new String[0]);; localObject = ((aa)localObject).d(str, new String[0]))
    {
      localObject = Pair.create(localObject, Boolean.FALSE);
      s.s(localObject, "create(attrs, false)");
      this.taS = Util.nowMilliSecond();
      this.taT = (this.taS - this.taR);
      AppMethodBeat.o(320686);
      return localObject;
      i = 0;
      break;
      localObject = (aa)n.ag(aa.class);
      str = this.username;
      s.checkNotNull(str);
    }
  }
  
  public final String name()
  {
    return "LaunchPreconditionTaskGetBackupWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */