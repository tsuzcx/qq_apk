package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetBackupWxaAttrs;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchPreconditionTaskGetWxaAttrs;", "username", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "_executeCostMs", "", "_executeEndMs", "_executeStartMs", "callSync", "Landroid/util/Pair;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "executeCostMs", "executeEndMs", "executeStartMs", "name", "plugin-appbrand-integration_release"})
public final class aj
  implements ak
{
  private final String appId;
  private long mVC;
  private long mVD;
  private long mVE;
  private final String username;
  
  public aj(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.appId = paramString2;
  }
  
  public final long bNF()
  {
    return this.mVC;
  }
  
  public final long bNG()
  {
    return this.mVD;
  }
  
  public final long bNH()
  {
    return this.mVE;
  }
  
  public final Pair<WxaAttributes, Boolean> bNI()
  {
    AppMethodBeat.i(228694);
    this.mVC = Util.nowMilliSecond();
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
    for (localObject = ((v)n.W(v.class)).e(this.appId, new String[0]);; localObject = ((v)localObject).d(str, new String[0]))
    {
      localObject = Pair.create(localObject, Boolean.FALSE);
      p.g(localObject, "Pair.create(attrs, false)");
      this.mVD = Util.nowMilliSecond();
      this.mVE = (this.mVD - this.mVC);
      AppMethodBeat.o(228694);
      return localObject;
      i = 0;
      break;
      localObject = (v)n.W(v.class);
      str = this.username;
      if (str == null) {
        p.hyc();
      }
    }
  }
  
  public final String name()
  {
    return "LaunchPreconditionTaskGetBackupWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj
 * JD-Core Version:    0.7.0.1
 */