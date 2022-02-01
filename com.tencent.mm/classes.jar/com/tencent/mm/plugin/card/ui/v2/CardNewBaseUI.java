package com.tencent.mm.plugin.card.ui.v2;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"})
public abstract class CardNewBaseUI
  extends MMActivity
{
  public static final CardNewBaseUI.a oSG = new CardNewBaseUI.a((byte)0);
  protected float dBu = -1000.0F;
  protected float dzE = -85.0F;
  public boolean oSD;
  private b.a oSE = (b.a)new b(this);
  private final Runnable oSF = (Runnable)new d(this);
  
  private void bZr()
  {
    ae.i("MicroMsg.CardNewBaseUI", "request location: %s", new Object[] { Boolean.valueOf(this.oSD) });
    if (this.oSD)
    {
      d.aIh().a(this.oSE, false);
      ar.o(this.oSF, 4000L);
    }
  }
  
  public abstract void X(int paramInt, boolean paramBoolean);
  
  public final void bZs()
  {
    ae.i("MicroMsg.CardNewBaseUI", "stop location");
    d.aIh().c(this.oSE);
    ar.ay(this.oSF);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ae.i("MicroMsg.CardNewBaseUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 563: 
      bZr();
      return;
    }
    this.oSD = b.k((Context)getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.oSD = b.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    if (this.oSD) {
      bZr();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ar.ay(this.oSF);
    bZs();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
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
        this.oSD = true;
        bZr();
        return;
        paramInt = 0;
        break;
      }
      label61:
      this.oSD = false;
      h.a((Context)this, getString(2131756893), getString(2131761885), getString(2131760598), getString(2131757558), false, (DialogInterface.OnClickListener)new c(this), null);
      X(-2, false);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements b.a
  {
    b(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(112510);
      if (paramBoolean)
      {
        this.oSH.dzE = paramFloat2;
        this.oSH.dBu = paramFloat1;
        this.oSH.bZs();
      }
      this.oSH.X(0, paramBoolean);
      AppMethodBeat.o(112510);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(112511);
      this.oSH.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
      AppMethodBeat.o(112511);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(112512);
      ae.i("MicroMsg.CardNewBaseUI", "remove location in task");
      CardNewBaseUI.a(this.oSH);
      AppMethodBeat.o(112512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
 * JD-Core Version:    0.7.0.1
 */