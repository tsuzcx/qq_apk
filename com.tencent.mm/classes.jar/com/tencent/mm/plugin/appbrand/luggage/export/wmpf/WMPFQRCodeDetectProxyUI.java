package com.tencent.mm.plugin.appbrand.luggage.export.wmpf;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.l;

@a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activityStarted", "", "eventListen", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "startActivityForResult", "intent", "Landroid/content/Intent;", "requestCode", "options", "Companion", "plugin-appbrand-integration_release"})
public final class WMPFQRCodeDetectProxyUI
  extends MMActivity
{
  public static final a qcV;
  private HashMap _$_findViewCache;
  private boolean qcT;
  private IListener<rz> qcU;
  
  static
  {
    AppMethodBeat.i(253724);
    qcV = new a((byte)0);
    AppMethodBeat.o(253724);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(253727);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(253727);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(253725);
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
    AppMethodBeat.o(253725);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(253723);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "finish() " + hashCode() + ' ' + android.util.Log.getStackTraceString(new Throwable()));
    super.finish();
    AppMethodBeat.o(253723);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(253710);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onCreate " + hashCode());
    super.onCreate(paramBundle);
    paramBundle = WMPFAccessibleProvider.qcQ;
    if (!WMPFAccessibleProvider.cbf())
    {
      finish();
      AppMethodBeat.o(253710);
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
      if ((i == 0) && (u.agG(paramBundle))) {
        break label121;
      }
      finish();
      AppMethodBeat.o(253710);
      return;
      paramBundle = null;
      break;
    }
    label121:
    h.a((Context)this, "", false, (DialogInterface.OnCancelListener)c.qcY);
    Object localObject = new rx();
    EventCenter localEventCenter = EventCenter.instance;
    b localb = new b(this, paramBundle);
    this.qcU = ((IListener)localb);
    localEventCenter.add((IListener)localb);
    ((rx)localObject).fRg.fwK = System.currentTimeMillis();
    ((rx)localObject).fRg.filePath = paramBundle;
    ((rx)localObject).fRg.fRh = ((Set)new HashSet());
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(253710);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(253721);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onDestroy() " + hashCode());
    IListener localIListener = this.qcU;
    if (localIListener != null) {
      EventCenter.instance.removeListener(localIListener);
    }
    super.onDestroy();
    AppMethodBeat.o(253721);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(253719);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onPause() " + hashCode());
    super.onPause();
    AppMethodBeat.o(253719);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(253714);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onResume() " + hashCode());
    super.onResume();
    if (this.qcT)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(253714);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(253717);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WMPFQRCodeDetectProxyUI", "onStart() " + hashCode());
    super.onStart();
    if (this.qcT)
    {
      moveTaskToBack(true);
      finish();
    }
    AppMethodBeat.o(253717);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(253712);
    super.startActivityForResult(paramIntent, paramInt);
    this.qcT = true;
    AppMethodBeat.o(253712);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(253711);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    this.qcT = true;
    AppMethodBeat.o(253711);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$Companion;", "", "()V", "KEY_QRCODE_PATH", "", "TAG", "waitFor", "", "context", "Landroid/content/Context;", "qrcodePath", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/wmpf/WMPFQRCodeDetectProxyUI$onCreate$2$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class b
    extends IListener<rz>
  {
    b(WMPFQRCodeDetectProxyUI paramWMPFQRCodeDetectProxyUI, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class c
    implements DialogInterface.OnCancelListener
  {
    public static final c qcY;
    
    static
    {
      AppMethodBeat.i(244206);
      qcY = new c();
      AppMethodBeat.o(244206);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.wmpf.WMPFQRCodeDetectProxyUI
 * JD-Core Version:    0.7.0.1
 */