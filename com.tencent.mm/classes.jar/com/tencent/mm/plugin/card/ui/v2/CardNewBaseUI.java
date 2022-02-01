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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"})
public abstract class CardNewBaseUI
  extends MMActivity
{
  public static final CardNewBaseUI.a oMe = new CardNewBaseUI.a((byte)0);
  protected float dAp = -1000.0F;
  protected float dyz = -85.0F;
  public boolean oMb;
  private b.a oMc = (b.a)new b(this);
  private final Runnable oMd = (Runnable)new d(this);
  
  private void bYc()
  {
    ad.i("MicroMsg.CardNewBaseUI", "request location: %s", new Object[] { Boolean.valueOf(this.oMb) });
    if (this.oMb)
    {
      d.aHQ().a(this.oMc, false);
      aq.o(this.oMd, 4000L);
    }
  }
  
  public abstract void V(int paramInt, boolean paramBoolean);
  
  public final void bYd()
  {
    ad.i("MicroMsg.CardNewBaseUI", "stop location");
    d.aHQ().c(this.oMc);
    aq.aA(this.oMd);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ad.i("MicroMsg.CardNewBaseUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 563: 
      bYc();
      return;
    }
    this.oMb = b.j((Context)getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.oMb = b.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
    if (this.oMb) {
      bYc();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aq.aA(this.oMd);
    bYd();
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
        this.oMb = true;
        bYc();
        return;
        paramInt = 0;
        break;
      }
      label61:
      this.oMb = false;
      h.a((Context)this, getString(2131756893), getString(2131761885), getString(2131760598), getString(2131757558), false, (DialogInterface.OnClickListener)new c(this), null);
      V(-2, false);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements b.a
  {
    b(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(112510);
      if (paramBoolean)
      {
        this.oMf.dyz = paramFloat2;
        this.oMf.dAp = paramFloat1;
        this.oMf.bYd();
      }
      this.oMf.V(0, paramBoolean);
      AppMethodBeat.o(112510);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(112511);
      this.oMf.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
      AppMethodBeat.o(112511);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(112512);
      ad.i("MicroMsg.CardNewBaseUI", "remove location in task");
      CardNewBaseUI.a(this.oMf);
      AppMethodBeat.o(112512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
 * JD-Core Version:    0.7.0.1
 */