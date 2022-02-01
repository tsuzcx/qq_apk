package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class d
{
  protected String appId;
  protected Context context;
  protected a mKh;
  protected String openId;
  
  public d(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.mKh = parama;
  }
  
  protected void bAS()
  {
    AppMethodBeat.i(22179);
    com.tencent.mm.ui.base.h.a(this.context, 2131761815, 2131755906, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22177);
        paramAnonymousDialogInterface = b.a.cBi();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.k(d.this.openId, u.aqJ(), d.this.appId);
        }
        d.this.mKh.it(false);
        AppMethodBeat.o(22177);
      }
    });
    AppMethodBeat.o(22179);
  }
  
  public final void bAT()
  {
    AppMethodBeat.i(22178);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      ad.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.mKh.it(true);
      AppMethodBeat.o(22178);
      return;
    }
    g localg = com.tencent.mm.pluginsdk.model.app.h.j(this.appId, false, false);
    if (localg == null)
    {
      ad.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.mKh.it(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (bt.isNullOrNil(localg.field_openId))
    {
      ad.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      ad.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      ap.cZS().xe(this.appId);
      this.mKh.it(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (this.openId.equalsIgnoreCase(localg.field_openId))
    {
      ad.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.mKh.it(true);
      AppMethodBeat.o(22178);
      return;
    }
    ad.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localg.field_openId);
    bAS();
    AppMethodBeat.o(22178);
  }
  
  public static abstract interface a
  {
    public abstract void it(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */