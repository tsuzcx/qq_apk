package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class al
  extends ag<Pair<WxaAttributes, Boolean>>
{
  private String appId;
  private final int cxS;
  private final int hcr;
  private final String hiw;
  private final int imL;
  private boolean imM = false;
  private boolean imN = false;
  private z.a imO = z.a.ilR;
  private int imP = -1;
  private String username;
  
  al(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.hcr = paramInt1;
    this.imL = paramInt2;
    this.cxS = paramInt3;
    this.hiw = paramString3;
  }
  
  private WxaAttributes aHj()
  {
    AppMethodBeat.i(131987);
    if (!bo.isNullOrNil(this.username))
    {
      localWxaAttributes = g.auF().d(this.username, new String[0]);
      AppMethodBeat.o(131987);
      return localWxaAttributes;
    }
    WxaAttributes localWxaAttributes = g.auF().e(this.appId, new String[0]);
    AppMethodBeat.o(131987);
    return localWxaAttributes;
  }
  
  private static boolean f(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(131988);
    if (bo.isNullOrNil(paramWxaAttributes.field_appId))
    {
      ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(131988);
      return true;
    }
    if (paramWxaAttributes.ayE() == null)
    {
      ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_versionInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(131988);
      return true;
    }
    if (paramWxaAttributes.ayC() == null)
    {
      ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", new Object[] { paramWxaAttributes.field_appInfo, paramWxaAttributes.field_username });
      AppMethodBeat.o(131988);
      return true;
    }
    if ((paramWxaAttributes.ayE().bDd == 0) && (bo.isNullOrNil(paramWxaAttributes.ayE().hkd)))
    {
      ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      AppMethodBeat.o(131988);
      return true;
    }
    AppMethodBeat.o(131988);
    return false;
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */