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
import d.g.b.p;
import d.l;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "(Ljava/lang/String;[BJZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cUi;
  final String kEX;
  private a kEZ;
  final byte[] kFa;
  private final boolean kFb;
  
  public f(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(195128);
    this.cUi = paramString;
    this.kFa = paramArrayOfByte;
    this.kFb = paramBoolean;
    this.kEX = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.kFl = paramLong;
    AppMethodBeat.o(195128);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(195127);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kEX, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.kEZ;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.kFc.kEX, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.kEZ = null;
    AppMethodBeat.o(195127);
  }
  
  public final void bjq()
  {
    AppMethodBeat.i(195126);
    if (!c.bjz())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "Bluetooth is not enable.", new Object[0]);
      a(j.kFD);
      done();
      AppMethodBeat.o(195126);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.cUi))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "Invalid deviceId", new Object[0]);
      a(j.kFR);
      done();
      AppMethodBeat.o(195126);
      return;
    }
    Object localObject2 = c.bjx();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "Bluetooth is not enable.", new Object[0]);
      a(j.kFD);
      done();
      AppMethodBeat.o(195126);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.cUi);
    if (!this.kFb)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kEX, "already paired", new Object[0]);
        a(j.kFA);
        done();
        AppMethodBeat.o(195126);
        return;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kEX, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "startPairing is false", new Object[0]);
      a(j.kFK);
      done();
      AppMethodBeat.o(195126);
      return;
    }
    localObject2 = this.kFh;
    p.g(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kEX, "context is null", new Object[0]);
      a(j.kFK);
      done();
      AppMethodBeat.o(195126);
      return;
    }
    p.g(localObject1, "device");
    this.kEZ = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.kEZ;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).kFc.kEX, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(195126);
      return;
    }
    AppMethodBeat.o(195126);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice kDN;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(195125);
      this.context = paramBluetoothDevice;
      this.kDN = localObject;
      AppMethodBeat.o(195125);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(195124);
      BluetoothDevice localBluetoothDevice = this.kDN;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (p.i(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(195124);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (p.i("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kEX, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(195124);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        case 1: 
        default: 
          AppMethodBeat.o(195124);
          return;
        case 0: 
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "PAIRING_VARIANT_PIN", new Object[0]);
          if (f.this.kFa == null)
          {
            f.this.a(j.kFT);
            f.this.done();
            AppMethodBeat.o(195124);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "setPin", new Object[0]);
          this.kDN.setPin(f.this.kFa);
          AppMethodBeat.o(195124);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        AppMethodBeat.o(195124);
        return;
      }
      if (p.i("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kEX, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(195124);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(195124);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        f.this.a(j.kFB);
        f.this.done();
        AppMethodBeat.o(195124);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(195124);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kEX, "BOND_BONDED", new Object[0]);
        f.this.a(j.kFA);
        f.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */