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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "locationPermissionGrant", "", "getLocationPermissionGrant", "()Z", "setLocationPermissionGrant", "(Z)V", "longitude", "getLongitude", "setLongitude", "onLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "getOnLocationGet", "()Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "setOnLocationGet", "(Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;)V", "overtimeTask", "Ljava/lang/Runnable;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestLocation", "showGpsAlert", "stopLocation", "Companion", "plugin-card_release"})
public abstract class CardNewBaseUI
  extends MMActivity
{
  public static final CardNewBaseUI.a qgv = new CardNewBaseUI.a((byte)0);
  protected float dTj = -1000.0F;
  protected float latitude = -85.0F;
  public boolean qgs;
  private b.a qgt = (b.a)new b(this);
  private final Runnable qgu = (Runnable)new d(this);
  
  private void cxh()
  {
    Log.i("MicroMsg.CardNewBaseUI", "request location: %s", new Object[] { Boolean.valueOf(this.qgs) });
    if (this.qgs)
    {
      d.bca().a(this.qgt, false);
      MMHandlerThread.postToMainThreadDelayed(this.qgu, 4000L);
    }
  }
  
  public abstract void ad(int paramInt, boolean paramBoolean);
  
  public final void cxi()
  {
    Log.i("MicroMsg.CardNewBaseUI", "stop location");
    d.bca().c(this.qgt);
    MMHandlerThread.removeRunnable(this.qgu);
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
      cxh();
      return;
    }
    this.qgs = b.k((Context)getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qgs = b.a((Activity)this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 69, null, null);
    if (this.qgs) {
      cxh();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.qgu);
    cxi();
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
        this.qgs = true;
        cxh();
        return;
        paramInt = 0;
        break;
      }
      label61:
      this.qgs = false;
      h.a((Context)this, getString(2131757063), getString(2131763890), getString(2131762043), getString(2131757785), false, (DialogInterface.OnClickListener)new c(this), null);
      ad(-2, false);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "onGetLocation"})
  static final class b
    implements b.a
  {
    b(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(112510);
      if (paramBoolean)
      {
        this.qgw.latitude = paramFloat2;
        this.qgw.dTj = paramFloat1;
        this.qgw.cxi();
      }
      this.qgw.ad(0, paramBoolean);
      AppMethodBeat.o(112510);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(112511);
      this.qgw.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
      AppMethodBeat.o(112511);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(CardNewBaseUI paramCardNewBaseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(112512);
      Log.i("MicroMsg.CardNewBaseUI", "remove location in task");
      CardNewBaseUI.a(this.qgw);
      AppMethodBeat.o(112512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI
 * JD-Core Version:    0.7.0.1
 */