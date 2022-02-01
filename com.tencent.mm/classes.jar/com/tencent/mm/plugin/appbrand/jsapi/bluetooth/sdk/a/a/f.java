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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "(Ljava/lang/String;[BJ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  private final String cIZ;
  final String kjY;
  private a kka;
  final byte[] kkb;
  
  public f(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(204997);
    this.cIZ = paramString;
    this.kkb = paramArrayOfByte;
    this.kjY = ("MicroMsg.AppBrand.PairAction#" + hashCode());
    this.kkl = paramLong;
    AppMethodBeat.o(204997);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(204996);
    super.b(paramj);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kjY, "onDone, result: ".concat(String.valueOf(paramj)), new Object[0]);
    paramj = this.kka;
    if (paramj != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramj.kkc.kjY, "pairReceiver.unregisterSelf", new Object[0]);
      paramj.context.unregisterReceiver((BroadcastReceiver)paramj);
    }
    this.kka = null;
    AppMethodBeat.o(204996);
  }
  
  public final void bfM()
  {
    AppMethodBeat.i(204995);
    if (!c.bfV())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kjY, "Bluetooth is not enable.", new Object[0]);
      a(j.kkD);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.cIZ))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kjY, "Invalid deviceId", new Object[0]);
      a(j.kkR);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    Object localObject2 = c.bfT();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kjY, "Bluetooth is not enable.", new Object[0]);
      a(j.kkD);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.cIZ);
    localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
    if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kjY, "already paired", new Object[0]);
      a(j.kkA);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.kjY, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kjY, "startPairing is false", new Object[0]);
      a(j.kkK);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    localObject2 = this.kkh;
    k.g(localObject2, "worker");
    localObject2 = ((d)localObject2).getContext();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.kjY, "context is null", new Object[0]);
      a(j.kkK);
      done();
      AppMethodBeat.o(204995);
      return;
    }
    k.g(localObject1, "device");
    this.kka = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.kka;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).kkc.kjY, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
      AppMethodBeat.o(204995);
      return;
    }
    AppMethodBeat.o(204995);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"})
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice kiV;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(204994);
      this.context = paramBluetoothDevice;
      this.kiV = localObject;
      AppMethodBeat.o(204994);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(204993);
      BluetoothDevice localBluetoothDevice = this.kiV;
      if (paramIntent != null) {}
      for (paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"); (k.g(localBluetoothDevice, paramContext) ^ true); paramContext = null)
      {
        AppMethodBeat.o(204993);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "onReceive, intent: ".concat(String.valueOf(paramIntent)), new Object[0]);
      if (k.g("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kjY, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(204993);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(204993);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "PAIRING_VARIANT_PIN", new Object[0]);
          if (f.this.kkb == null)
          {
            f.this.a(j.kkT);
            f.this.done();
            AppMethodBeat.o(204993);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "setPin", new Object[0]);
          this.kiV.setPin(f.this.kkb);
          AppMethodBeat.o(204993);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        }
      }
      if (k.g("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(f.this.kjY, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(204993);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(204993);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "BOND_NONE, reason: " + paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
        f.this.a(j.kkB);
        f.this.done();
        AppMethodBeat.o(204993);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(204993);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(f.this.kjY, "BOND_BONDED", new Object[0]);
        f.this.a(j.kkA);
        f.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f
 * JD-Core Version:    0.7.0.1
 */