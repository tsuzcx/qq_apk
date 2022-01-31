package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ab
  extends w<Pair<WxaAttributes, Boolean>>
{
  private String appId;
  private final int fJy;
  private final String fPq;
  private final int gJU;
  private final int gLs;
  private boolean gLt = false;
  private boolean gLu = false;
  private r.a gLv = r.a.gKN;
  private String username;
  
  ab(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.fJy = paramInt1;
    this.gLs = paramInt2;
    this.gJU = paramInt3;
    this.fPq = paramString3;
  }
  
  private WxaAttributes alP()
  {
    if (!bk.bl(this.username)) {
      return e.aaT().d(this.username, new String[0]);
    }
    return e.aaT().e(this.appId, new String[0]);
  }
  
  private static boolean c(WxaAttributes paramWxaAttributes)
  {
    if (bk.bl(paramWxaAttributes.field_appId))
    {
      y.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      return true;
    }
    if ((paramWxaAttributes.aep().fPB == 0) && (bk.bl(paramWxaAttributes.aep().fRr)))
    {
      y.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[] { paramWxaAttributes.field_username });
      return true;
    }
    return false;
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ab
 * JD-Core Version:    0.7.0.1
 */