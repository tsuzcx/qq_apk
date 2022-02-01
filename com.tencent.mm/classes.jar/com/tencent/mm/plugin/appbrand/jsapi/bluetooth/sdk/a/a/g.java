package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "useOldImpl", "(Ljava/lang/String;[BJZZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  final String djQ;
  private final String hEl;
  final byte[] rMV;
  private final boolean rMW;
  final boolean rMX;
  private a rMY;
  
  public g(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(329720);
    this.hEl = paramString;
    this.rMV = paramArrayOfByte;
    this.rMW = paramBoolean1;
    this.rMX = paramBoolean2;
    this.djQ = s.X("MicroMsg.Ble.Action#", Integer.valueOf(hashCode()));
    this.rNh = paramLong;
    AppMethodBeat.o(329720);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(329730);
    super.a(paramk);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.djQ, s.X("onDone, result: ", paramk), new Object[0]);
    paramk = this.rMY;
    if (paramk != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(paramk.rMZ.djQ, "pairReceiver.unregisterSelf", new Object[0]);
      paramk.context.unregisterReceiver((BroadcastReceiver)paramk);
    }
    this.rMY = null;
    AppMethodBeat.o(329730);
  }
  
  public final void crh()
  {
    int i = 1;
    AppMethodBeat.i(329729);
    if (!c.cru())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "Bluetooth is not enable.", new Object[0]);
      onResult(k.rND);
      done();
      AppMethodBeat.o(329729);
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.hEl))
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "Invalid deviceId", new Object[0]);
      onResult(k.rNP);
      done();
      AppMethodBeat.o(329729);
      return;
    }
    Object localObject2 = c.crs();
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "Bluetooth is not enable.", new Object[0]);
      onResult(k.rND);
      done();
      AppMethodBeat.o(329729);
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.hEl);
    if (!this.rMW)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1))) {}
      while (i != 0)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.djQ, "already paired", new Object[0]);
        onResult(k.rNz);
        done();
        AppMethodBeat.o(329729);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.djQ, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "startPairing is false", new Object[0]);
      onResult(k.rNI);
      done();
      AppMethodBeat.o(329729);
      return;
    }
    localObject2 = this.rNd.context;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.djQ, "context is null", new Object[0]);
      onResult(k.rNI);
      done();
      AppMethodBeat.o(329729);
      return;
    }
    s.s(localObject1, "device");
    this.rMY = new a((Context)localObject2, (BluetoothDevice)localObject1);
    localObject2 = this.rMY;
    if (localObject2 != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(((a)localObject2).rMZ.djQ, "pairReceiver.registerSelf", new Object[0]);
      localObject1 = ((a)localObject2).context;
      localObject2 = (BroadcastReceiver)localObject2;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
      localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
      ah localah = ah.aiuX;
      ((Context)localObject1).registerReceiver((BroadcastReceiver)localObject2, localIntentFilter);
    }
    AppMethodBeat.o(329729);
  }
  
  public final String getName()
  {
    return "PairAction";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends BroadcastReceiver
  {
    final Context context;
    private final BluetoothDevice rLH;
    
    public a(BluetoothDevice paramBluetoothDevice)
    {
      AppMethodBeat.i(329722);
      this.context = paramBluetoothDevice;
      this.rLH = localObject;
      AppMethodBeat.o(329722);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(329726);
      BluetoothDevice localBluetoothDevice = this.rLH;
      if (paramIntent == null) {}
      for (paramContext = null; !s.p(localBluetoothDevice, paramContext); paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"))
      {
        AppMethodBeat.o(329726);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, s.X("onReceive, intent: ", paramIntent), new Object[0]);
      if (s.p("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(g.this.djQ, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
          AppMethodBeat.o(329726);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(329726);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, "PAIRING_VARIANT_PIN", new Object[0]);
          if (g.this.rMV == null)
          {
            g.this.onResult(k.rNR);
            g.this.done();
            AppMethodBeat.o(329726);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, "setPin", new Object[0]);
          if ((!this.rLH.setPin(g.this.rMV)) || (g.this.rMX)) {
            break;
          }
          g.this.onResult(k.rNz);
          g.this.done();
          AppMethodBeat.o(329726);
          return;
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        }
      }
      if (s.p("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
      {
        if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(g.this.djQ, "Cannot find EXTRA_BOND_STATE", new Object[0]);
          AppMethodBeat.o(329726);
          return;
        }
        switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(329726);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, s.X("BOND_NONE, reason: ", Integer.valueOf(paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1))), new Object[0]);
        g.this.onResult(k.rNB);
        g.this.done();
        AppMethodBeat.o(329726);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, "BOND_BONDING", new Object[0]);
        AppMethodBeat.o(329726);
        return;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(g.this.djQ, "BOND_BONDED", new Object[0]);
        g.this.onResult(k.rNz);
        g.this.done();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.g
 * JD-Core Version:    0.7.0.1
 */