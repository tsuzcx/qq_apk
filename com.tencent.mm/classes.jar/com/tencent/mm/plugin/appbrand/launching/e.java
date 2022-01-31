package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.cq.b;
import com.tencent.mm.g.b.a.cq.c;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e
  extends d
{
  private al ijR = null;
  private final String ijS;
  
  public e(LaunchParcel paramLaunchParcel, String paramString, d.a parama)
  {
    super(paramLaunchParcel, parama);
    this.ijS = paramString;
  }
  
  protected final Pair<WxaAttributes, Boolean> aGJ()
  {
    AppMethodBeat.i(131730);
    Object localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        Object localObject2 = this.username;
        String str = this.appId;
        int j = this.hcr;
        int k = this.gXf;
        if (this.ijP != null) {
          continue;
        }
        i = 0;
        localObject2 = new al((String)localObject2, str, j, k, i, this.hiw);
        this.ijR = ((al)localObject2);
        localObject2 = (Pair)((al)localObject2).aHg();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(131730);
      return localObject1;
      i = this.ijP.scene;
    }
  }
  
  protected final boolean e(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(131731);
    String str = paramWxaAttributes.field_appId;
    if (new ae(str).aHd())
    {
      AppMethodBeat.o(131731);
      return true;
    }
    if ((2 == this.hcr) && (!am.ao(str, com.tencent.mm.plugin.appbrand.task.h.EZ(str))))
    {
      AppMethodBeat.o(131731);
      return true;
    }
    if ((this.hcr == 0) && (!am.a(paramWxaAttributes, this.ijQ)))
    {
      AppMethodBeat.o(131731);
      return true;
    }
    AppMethodBeat.o(131731);
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(131729);
    Object localObject2 = aGJ();
    Object localObject1 = (WxaAttributes)((Pair)localObject2).first;
    if (localObject1 == null)
    {
      ab.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      onError();
      AppMethodBeat.o(131729);
      return;
    }
    if (e((WxaAttributes)localObject1))
    {
      onError();
      AppMethodBeat.o(131729);
      return;
    }
    AppBrandInitConfigWC localAppBrandInitConfigWC = com.tencent.mm.plugin.appbrand.config.f.ayv().b((WxaAttributes)localObject1);
    localAppBrandInitConfigWC.gXd = this.hcr;
    this.appId = localAppBrandInitConfigWC.appId;
    localAppBrandInitConfigWC.hiI = new QualitySession(this.ijS, localAppBrandInitConfigWC, this.ijP);
    if (((Boolean)((Pair)localObject2).second).booleanValue())
    {
      localAppBrandInitConfigWC.bDg = true;
      localObject2 = com.tencent.mm.plugin.appbrand.report.quality.f.a(localAppBrandInitConfigWC.hiI);
      ((cq)localObject2).dcs = cq.c.dcB;
      localObject2 = ((cq)localObject2).fi(this.ijR.ims).fj(this.ijR.imt).fg(this.ijR.imu);
      ((cq)localObject2).dct = cq.b.dcy;
      ((cq)localObject2).cTb = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((cq)localObject2).ake();
      if (this.hcr != 0) {
        break label305;
      }
      localAppBrandInitConfigWC.hha = ((WxaAttributes)localObject1).ayE().hke;
      localAppBrandInitConfigWC.bDb = ((WxaAttributes)localObject1).ayE().bDb;
      if (((WxaAttributes)localObject1).ayE().hkf != null)
      {
        localAppBrandInitConfigWC.hiF = ((WxaAttributes)localObject1).ayE().hkf.hiF;
        localAppBrandInitConfigWC.hiG = ((WxaAttributes)localObject1).ayE().hkf.hiG;
      }
    }
    for (;;)
    {
      localAppBrandInitConfigWC.bCX = Dj(localAppBrandInitConfigWC.bDb);
      if (this.ijP == null) {
        this.ijP = new AppBrandStatObject();
      }
      a(localAppBrandInitConfigWC, this.ijP);
      AppMethodBeat.o(131729);
      return;
      localAppBrandInitConfigWC.bDg = false;
      break;
      label305:
      localAppBrandInitConfigWC.extInfo = ((m)g.w(m.class)).bm(this.appId, this.hcr);
      try
      {
        localObject1 = com.tencent.mm.aa.h.mo(localAppBrandInitConfigWC.extInfo);
        localAppBrandInitConfigWC.hha = ((JSONObject)localObject1).optString("device_orientation");
        localAppBrandInitConfigWC.bDb = ((JSONObject)localObject1).optString("client_js_ext_info");
        localAppBrandInitConfigWC.bCW = ((JSONObject)localObject1).optBoolean("open_remote", false);
        localObject1 = ((JSONObject)localObject1).optJSONObject("loading_image_info");
        if (localObject1 != null)
        {
          localAppBrandInitConfigWC.hiF = ((JSONObject)localObject1).optString("url");
          localAppBrandInitConfigWC.hiG = ((JSONObject)localObject1).optString("progressbar_color");
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */