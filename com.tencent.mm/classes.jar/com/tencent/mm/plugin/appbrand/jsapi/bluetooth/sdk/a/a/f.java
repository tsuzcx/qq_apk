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
import d.g.b.k;
import d.l;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "(Ljava/lang/String;[BJ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cLR;
  private a jJA;
  final byte[] jJB;
  final String jJy;
  
  public f(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(193689);
    this.cLR = paramString;
    this.jJB = paramArrayOfByte;
    this.jJy = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.jJL = paramLong;
    AppMethodBeat.o(193689);
  }
  
  public final void aYR()
  {
    AppMethodBeat.i(193687);
    if (!c.aZd())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.jJy, "Bluetooth is not enable.", new Object[0]);
      a(j.jKc);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.cLR))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.jJy, "Invalid deviceId", new Object[0]);
      a(j.jKq);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    Object localObject2 = c.aZb();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.jJy, "Bluetooth is not enable.", new Object[0]);
      a(j.jKc);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.cLR);
    localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
    if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.jJy, "already paired", new Object[0]);
      a(j.jJZ);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.jJy, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.jJy, "startPairing is false", new Object[0]);
      a(j.jKj);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    localObject2 = this.jJH;
    k.g(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.jJy, "context is null", new Object[0]);
      a(j.jKj);
      done();
      AppMethodBeat.o(193687);
      return;
    }
    k.g(localObject1, "device");
    this.jJA = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.jJA;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).jJC.jJy, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(193687);
      return;
    }
    AppMethodBeat.o(193687);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(193688);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.jJy, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.jJA;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.jJC.jJy, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.jJA = null;
    AppMethodBeat.o(193688);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice jIw;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(193686);
      this.context = paramBluetoothDevice;
      this.jIw = localObject;
      AppMethodBeat.o(193686);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(193685);
      BluetoothDevice localBluetoothDevice = this.jIw;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (k.g(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(193685);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (k.g("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.jJy, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(193685);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193685);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "PAIRING_VARIANT_PIN", new Object[0]);
          if (f.this.jJB == null)
          {
            f.this.a(j.jKs);
            f.this.done();
            AppMethodBeat.o(193685);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "setPin", new Object[0]);
          this.jIw.setPin(f.this.jJB);
          AppMethodBeat.o(193685);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        }
      }
      if (k.g("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.jJy, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(193685);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(193685);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        f.this.a(j.jKa);
        f.this.done();
        AppMethodBeat.o(193685);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(193685);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.jJy, "BOND_BONDED", new Object[0]);
        f.this.a(j.jJZ);
        f.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */