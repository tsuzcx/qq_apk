package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "useOldImpl", "(Ljava/lang/String;[BJZZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  final String bqj;
  private final String fzB;
  private a oJi;
  final byte[] oJj;
  private final boolean oJk;
  final boolean oJl;
  
  public g(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199972);
    this.fzB = paramString;
    this.oJj = paramArrayOfByte;
    this.oJk = paramBoolean1;
    this.oJl = paramBoolean2;
    this.bqj = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.oJt = paramLong;
    AppMethodBeat.o(199972);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(199971);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.bqj, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.oJi;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.oJm.bqj, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.oJi = null;
    AppMethodBeat.o(199971);
  }
  
  public final void bQZ()
  {
    AppMethodBeat.i(199969);
    if (!c.bRm())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "Bluetooth is not enable.", new Object[0]);
      a(j.oJL);
      done();
      AppMethodBeat.o(199969);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.fzB))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "Invalid deviceId", new Object[0]);
      a(j.oJZ);
      done();
      AppMethodBeat.o(199969);
      return;
    }
    Object localObject2 = c.bRk();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "Bluetooth is not enable.", new Object[0]);
      a(j.oJL);
      done();
      AppMethodBeat.o(199969);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.fzB);
    if (!this.oJk)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.bqj, "already paired", new Object[0]);
        a(j.oJI);
        done();
        AppMethodBeat.o(199969);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.bqj, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "startPairing is false", new Object[0]);
      a(j.oJS);
      done();
      AppMethodBeat.o(199969);
      return;
    }
    localObject2 = this.oJp;
    p.j(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.bqj, "context is null", new Object[0]);
      a(j.oJS);
      done();
      AppMethodBeat.o(199969);
      return;
    }
    p.j(localObject1, "device");
    this.oJi = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.oJi;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).oJm.bqj, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(199969);
      return;
    }
    AppMethodBeat.o(199969);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice oHS;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(198970);
      this.context = paramBluetoothDevice;
      this.oHS = localObject;
      AppMethodBeat.o(198970);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(198969);
      BluetoothDevice localBluetoothDevice = this.oHS;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (p.h(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(198969);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (p.h("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(g.this.bqj, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(198969);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        case 1: 
        default: 
          AppMethodBeat.o(198969);
          return;
        case 0: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "PAIRING_VARIANT_PIN", new Object[0]);
          if (g.this.oJj == null)
          {
            g.this.a(j.oKb);
            g.this.done();
            AppMethodBeat.o(198969);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "setPin", new Object[0]);
          if ((!this.oHS.setPin(g.this.oJj)) || (g.this.oJl)) {
            break;
          }
          g.this.a(j.oJI);
          g.this.done();
          AppMethodBeat.o(198969);
          return;
        case 2: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
          AppMethodBeat.o(198969);
          return;
        }
      }
      else if (p.h("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(g.this.bqj, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(198969);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198969);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        g.this.a(j.oJJ);
        g.this.done();
        AppMethodBeat.o(198969);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(198969);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.bqj, "BOND_BONDED", new Object[0]);
        g.this.a(j.oJI);
        g.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g
 * JD-Core Version:    0.7.0.1
 */