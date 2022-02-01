package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class d
{
  protected String appId;
  protected Context context;
  protected a nSC;
  protected String openId;
  
  public d(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.nSC = parama;
  }
  
  protected void bMX()
  {
    AppMethodBeat.i(22179);
    com.tencent.mm.ui.base.h.a(this.context, 2131761815, 2131755906, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22177);
        paramAnonymousDialogInterface = b.a.cZq();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.k(d.this.openId, v.aAF(), d.this.appId);
        }
        d.this.nSC.jb(false);
        AppMethodBeat.o(22177);
      }
    });
    AppMethodBeat.o(22179);
  }
  
  public final void bMY()
  {
    AppMethodBeat.i(22178);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      ae.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.nSC.jb(true);
      AppMethodBeat.o(22178);
      return;
    }
    g localg = com.tencent.mm.pluginsdk.model.app.h.m(this.appId, false, false);
    if (localg == null)
    {
      ae.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.nSC.jb(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (bu.isNullOrNil(localg.field_openId))
    {
      ae.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      ae.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      ao.dBi().EL(this.appId);
      this.nSC.jb(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (this.openId.equalsIgnoreCase(localg.field_openId))
    {
      ae.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.nSC.jb(true);
      AppMethodBeat.o(22178);
      return;
    }
    ae.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localg.field_openId);
    bMX();
    AppMethodBeat.o(22178);
  }
  
  public static abstract interface a
  {
    public abstract void jb(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */