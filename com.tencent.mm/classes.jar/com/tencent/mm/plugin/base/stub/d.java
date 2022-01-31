package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class d
{
  protected String appId;
  protected Context context;
  protected d.a jLz;
  protected String openId;
  
  public d(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.jLz = parama;
  }
  
  protected void aVD()
  {
    AppMethodBeat.i(18125);
    h.a(this.context, 2131302030, 2131297087, false, new d.1(this));
    AppMethodBeat.o(18125);
  }
  
  public final void aVE()
  {
    AppMethodBeat.i(18124);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      ab.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.jLz.fH(true);
      AppMethodBeat.o(18124);
      return;
    }
    f localf = g.ca(this.appId, false);
    if (localf == null)
    {
      ab.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.jLz.fH(true);
      AppMethodBeat.o(18124);
      return;
    }
    if (ah.isNullOrNil(localf.field_openId))
    {
      ab.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      ab.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      al.cae().xB(this.appId);
      this.jLz.fH(true);
      AppMethodBeat.o(18124);
      return;
    }
    if (this.openId.equalsIgnoreCase(localf.field_openId))
    {
      ab.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.jLz.fH(true);
      AppMethodBeat.o(18124);
      return;
    }
    ab.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localf.field_openId);
    aVD();
    AppMethodBeat.o(18124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */