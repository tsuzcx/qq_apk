package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public class d
{
  protected String appId;
  protected Context context;
  protected String openId;
  protected a vrh;
  
  public d(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.vrh = parama;
  }
  
  protected void cZS()
  {
    AppMethodBeat.i(22179);
    k.a(this.context, R.l.gRi, R.l.app_tip, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22177);
        paramAnonymousDialogInterface = b.a.fCn();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.p(d.this.openId, z.bAP(), d.this.appId);
        }
        d.this.vrh.mC(false);
        AppMethodBeat.o(22177);
      }
    });
    AppMethodBeat.o(22179);
  }
  
  public final void cZW()
  {
    AppMethodBeat.i(22178);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      Log.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.vrh.mC(true);
      AppMethodBeat.o(22178);
      return;
    }
    g localg = h.s(this.appId, false, false);
    if (localg == null)
    {
      Log.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.vrh.mC(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (Util.isNullOrNil(localg.field_openId))
    {
      Log.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      Log.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      as.gxp().add(this.appId);
      this.vrh.mC(true);
      AppMethodBeat.o(22178);
      return;
    }
    if (this.openId.equalsIgnoreCase(localg.field_openId))
    {
      Log.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.vrh.mC(true);
      AppMethodBeat.o(22178);
      return;
    }
    Log.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localg.field_openId);
    cZS();
    AppMethodBeat.o(22178);
  }
  
  public static abstract interface a
  {
    public abstract void mC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d
 * JD-Core Version:    0.7.0.1
 */