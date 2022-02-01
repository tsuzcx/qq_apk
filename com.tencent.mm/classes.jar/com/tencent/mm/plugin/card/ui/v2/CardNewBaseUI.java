package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.ui.v3.VipCardListUI;
import com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class CardNewBaseUI
  extends MMActivity
{
  public static final CardNewBaseUI.a wGr = new CardNewBaseUI.a((byte)0);
  private float latitude = -85.0F;
  private float longitude = -1000.0F;
  private boolean wGs;
  private b.a wGt = new CardNewBaseUI..ExternalSyntheticLambda1(this);
  private final Runnable wGu = new CardNewBaseUI..ExternalSyntheticLambda2(this);
  
  private static final void a(CardNewBaseUI paramCardNewBaseUI)
  {
    s.u(paramCardNewBaseUI, "this$0");
    Log.i("MicroMsg.CardNewBaseUI", "remove location in task");
    paramCardNewBaseUI.at(-3, false);
  }
  
  private static final void a(CardNewBaseUI paramCardNewBaseUI, DialogInterface paramDialogInterface, int paramInt)
  {
    s.u(paramCardNewBaseUI, "this$0");
    b.bG((Activity)paramCardNewBaseUI.getContext());
  }
  
  private static final boolean a(CardNewBaseUI paramCardNewBaseUI, boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    s.u(paramCardNewBaseUI, "this$0");
    if (paramBoolean)
    {
      paramCardNewBaseUI.latitude = paramFloat2;
      paramCardNewBaseUI.longitude = paramFloat1;
      paramCardNewBaseUI.doo();
    }
    paramCardNewBaseUI.at(0, paramBoolean);
    return false;
  }
  
  private void don()
  {
    Log.i("MicroMsg.CardNewBaseUI", "request location: %s", new Object[] { Boolean.valueOf(this.wGs) });
    if (this.wGs)
    {
      d.bJl().a(this.wGt, false, true);
      l.kK(22, 10);
      MMHandlerThread.postToMainThreadDelayed(this.wGu, 4000L);
    }
  }
  
  public abstract void at(int paramInt, boolean paramBoolean);
  
  public final boolean dom()
  {
    return this.wGs;
  }
  
  public final void doo()
  {
    Log.i("MicroMsg.CardNewBaseUI", "stop location");
    d.bJl().a(this.wGt);
    MMHandlerThread.removeRunnable(this.wGu);
  }
  
  protected final float getLatitude()
  {
    return this.latitude;
  }
  
  protected final float getLongitude()
  {
    return this.longitude;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("MicroMsg.CardNewBaseUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 563: 
      don();
      return;
    }
    this.wGs = b.k((Context)getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (((getContext() instanceof CouponAndGiftCardListV4UI)) || ((getContext() instanceof CardTicketListUI)))
    {
      this.wGs = false;
      return;
    }
    if (!b.c((Activity)this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69))
    {
      at(-2, false);
      return;
    }
    Activity localActivity = (Activity)this;
    if ((getContext() instanceof VipCardListUI)) {}
    for (paramBundle = getString(a.g.wqI);; paramBundle = null)
    {
      this.wGs = b.a(localActivity, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, paramBundle);
      if (!this.wGs) {
        break;
      }
      don();
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.wGu);
    doo();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    if (paramInt == 69)
    {
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label56;
        }
      }
      label56:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label61;
        }
        this.wGs = true;
        don();
        return;
        paramInt = 0;
        break;
      }
      label61:
      this.wGs = false;
      k.a((Context)this, getString(a.g.woY), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardNewBaseUI..ExternalSyntheticLambda0(this), null);
      at(-2, false);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
 * JD-Core Version:    0.7.0.1
 */