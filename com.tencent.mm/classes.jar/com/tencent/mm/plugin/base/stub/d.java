package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public class d
{
  protected String appId;
  protected Context context;
  protected d.a hRU;
  protected String openId;
  
  public d(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.hRU = parama;
  }
  
  protected void UF()
  {
    h.b(this.context, R.l.openid_checker_fail_msg, R.l.app_tip, new d.1(this), new d.2(this));
  }
  
  public final void awa()
  {
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      y.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.hRU.em(true);
      return;
    }
    f localf = g.by(this.appId, false);
    if (localf == null)
    {
      y.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.hRU.em(true);
      return;
    }
    if (ah.bl(localf.field_openId))
    {
      y.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      y.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      ap.brp().qh(this.appId);
      this.hRU.em(true);
      return;
    }
    if (this.openId.equalsIgnoreCase(localf.field_openId))
    {
      y.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.hRU.em(true);
      return;
    }
    y.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localf.field_openId);
    UF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */