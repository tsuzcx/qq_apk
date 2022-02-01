package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activityStarted", "", "eventListen", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "startActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "options", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WMPFQRCodeDetectProxyUI
  extends MMActivity
{
  public static final a thI;
  private boolean thJ;
  private IListener<to> thK;
  
  static
  {
    AppMethodBeat.i(319905);
    thI = new a((byte)0);
    AppMethodBeat.o(319905);
  }
  
  private static final void b(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(319944);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "finish() " + hashCode() + ' ' + android.util.Log.getStackTraceString(new Throwable()));
    super.finish();
    AppMethodBeat.o(319944);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(319915);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", s.X("onCreate ", Integer.valueOf(hashCode())));
    super.onCreate(paramBundle);
    paramBundle = WMPFAccessibleProvider.thG;
    if (!WMPFAccessibleProvider.cBz())
    {
      finish();
      AppMethodBeat.o(319915);
      return;
    }
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject = (CharSequence)paramBundle;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (y.ZC(paramBundle))) {
        break label114;
      }
      finish();
      AppMethodBeat.o(319915);
      return;
      paramBundle = paramBundle.getStringExtra("KEY_QRCODE_PATH");
      break;
    }
    label114:
    k.a((Context)this, "", false, WMPFQRCodeDetectProxyUI..ExternalSyntheticLambda0.INSTANCE);
    Object localObject = new tm();
    IListener local1 = new IListener(paramBundle) {};
    this.thK = ((IListener)local1);
    local1.alive();
    ((tm)localObject).hXd.hBk = System.currentTimeMillis();
    ((tm)localObject).hXd.filePath = paramBundle;
    ((tm)localObject).hXd.hXe = ((Set)new HashSet());
    ((tm)localObject).publish();
    AppMethodBeat.o(319915);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(319941);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", s.X("onDestroy() ", Integer.valueOf(hashCode())));
    IListener localIListener = this.thK;
    if (localIListener != null) {
      localIListener.dead();
    }
    super.onDestroy();
    AppMethodBeat.o(319941);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(319938);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", s.X("onPause() ", Integer.valueOf(hashCode())));
    super.onPause();
    AppMethodBeat.o(319938);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(319923);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", s.X("onResume() ", Integer.valueOf(hashCode())));
    super.onResume();
    if (this.thJ)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(319923);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(319931);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", s.X("onStart() ", Integer.valueOf(hashCode())));
    super.onStart();
    if (this.thJ)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(319931);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(319921);
    super.startActivityForResult(paramIntent, paramInt);
    this.thJ = true;
    AppMethodBeat.o(319921);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(319917);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    this.thJ = true;
    AppMethodBeat.o(319917);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion;", "", "()V", "KEY_QRCODE_PATH", "", "TAG", "waitFor", "", "context", "Landroid/content/Context;", "qrcodePath", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFQRCodeDetectProxyUI
 * JD-Core Version:    0.7.0.1
 */