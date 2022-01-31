package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"})
public abstract class CardNewBaseUI
  extends MMActivity
{
  public static final CardNewBaseUI.a kAr = new CardNewBaseUI.a((byte)0);
  float cAH = -1000.0F;
  float cyV = -85.0F;
  boolean kAo;
  private b.a kAp = (b.a)new b(this);
  private final Runnable kAq = (Runnable)new CardNewBaseUI.d(this);
  
  private void bfm()
  {
    ab.i("MicroMsg.CardNewBaseUI", "request location: %s", new Object[] { Boolean.valueOf(this.kAo) });
    if (this.kAo)
    {
      d.agQ().a(this.kAp, false);
      al.p(this.kAq, 4000L);
    }
  }
  
  public abstract void R(int paramInt, boolean paramBoolean);
  
  public final void bfn()
  {
    ab.i("MicroMsg.CardNewBaseUI", "stop location");
    d.agQ().c(this.kAp);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ab.i("MicroMsg.CardNewBaseUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 563: 
      bfm();
      return;
    }
    this.kAo = b.i((Context)getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kAo = b.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    if (this.kAo) {
      bfm();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    al.ae(this.kAq);
    bfn();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    j.q(paramArrayOfString, "permissions");
    j.q(paramArrayOfInt, "grantResults");
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
        this.kAo = true;
        bfm();
        return;
        paramInt = 0;
        break;
      }
      label61:
      this.kAo = false;
      h.a((Context)this, getString(2131297951), getString(2131302083), getString(2131300996), getString(2131298499), false, (DialogInterface.OnClickListener)new c(this), null);
      R(-2, false);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements b.a
  {
    b(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(89284);
      if (paramBoolean)
      {
        this.kAs.cyV = paramFloat2;
        this.kAs.cAH = paramFloat1;
        this.kAs.bfn();
      }
      this.kAs.R(0, paramBoolean);
      AppMethodBeat.o(89284);
      return false;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(89285);
      this.kAs.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
      AppMethodBeat.o(89285);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
 * JD-Core Version:    0.7.0.1
 */