package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.l;

@a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activityStarted", "", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "startActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "options", "Companion", "plugin-appbrand-integration_release"})
public final class WMPFQRCodeDetectProxyUI
  extends MMActivity
{
  public static final a ncG;
  private HashMap _$_findViewCache;
  private boolean ncF;
  
  static
  {
    AppMethodBeat.i(229048);
    ncG = new a((byte)0);
    AppMethodBeat.o(229048);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229050);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229050);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229049);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(229049);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(229047);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "finish() " + hashCode() + ' ' + android.util.Log.getStackTraceString(new Throwable()));
    super.finish();
    AppMethodBeat.o(229047);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229040);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onCreate " + hashCode());
    super.onCreate(paramBundle);
    paramBundle = WMPFAccessibleProvider.ncC;
    if (!WMPFAccessibleProvider.bOP())
    {
      finish();
      AppMethodBeat.o(229040);
      return;
    }
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringExtra("KEY_QRCODE_PATH");
      localObject = (CharSequence)paramBundle;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label116;
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (s.YS(paramBundle))) {
        break label121;
      }
      finish();
      AppMethodBeat.o(229040);
      return;
      paramBundle = null;
      break;
    }
    label121:
    h.a((Context)this, "", false, (DialogInterface.OnCancelListener)c.ncJ);
    Object localObject = new qx();
    EventCenter.instance.add((IListener)new WMPFQRCodeDetectProxyUI.b(this, paramBundle));
    ((qx)localObject).dXu.dDZ = System.currentTimeMillis();
    ((qx)localObject).dXu.filePath = paramBundle;
    ((qx)localObject).dXu.dXv = ((Set)new HashSet());
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(229040);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229046);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onDestroy() " + hashCode());
    super.onDestroy();
    AppMethodBeat.o(229046);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(229045);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onPause() " + hashCode());
    super.onPause();
    AppMethodBeat.o(229045);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(229043);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onResume() " + hashCode());
    super.onResume();
    if (this.ncF)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(229043);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(229044);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onStart() " + hashCode());
    super.onStart();
    if (this.ncF)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(229044);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(229042);
    super.startActivityForResult(paramIntent, paramInt);
    this.ncF = true;
    AppMethodBeat.o(229042);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(229041);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    this.ncF = true;
    AppMethodBeat.o(229041);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion;", "", "()V", "KEY_QRCODE_PATH", "", "TAG", "waitFor", "", "context", "Landroid/content/Context;", "qrcodePath", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class c
    implements DialogInterface.OnCancelListener
  {
    public static final c ncJ;
    
    static
    {
      AppMethodBeat.i(229039);
      ncJ = new c();
      AppMethodBeat.o(229039);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFQRCodeDetectProxyUI
 * JD-Core Version:    0.7.0.1
 */