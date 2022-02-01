package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d
{
  protected String appId;
  protected Context context;
  protected String openId;
  protected a pdr;
  
  public d(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.pdr = parama;
  }
  
  protected void cjQ()
  {
    AppMethodBeat.i(22179);
    com.tencent.mm.ui.base.h.a(this.context, 2131763790, 2131755998, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22177);
        paramAnonymousDialogInterface = b.a.dSQ();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.k(d.this.openId, z.aUb(), d.this.appId);
        }
        d.this.pdr.jZ(false);
        AppMethodBeat.o(22177);
      }
    });
    AppMethodBeat.o(22179);
  }
  
  public final void cjR()
  {
    AppMethodBeat.i(22178);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      Log.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.pdr.jZ(true);
      AppMethodBeat.o(22178);
      return;
    }
    g localg = com.tencent.mm.pluginsdk.model.app.h.o(this.appId, false, false);
    if (localg == null)
    {
      Log.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.pdr.jZ(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (Util.isNullOrNil(localg.field_openId))
    {
      Log.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      Log.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      ao.eAU().add(this.appId);
      this.pdr.jZ(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (this.openId.equalsIgnoreCase(localg.field_openId))
    {
      Log.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.pdr.jZ(true);
      AppMethodBeat.o(22178);
      return;
    }
    Log.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localg.field_openId);
    cjQ();
    AppMethodBeat.o(22178);
  }
  
  public static abstract interface a
  {
    public abstract void jZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */