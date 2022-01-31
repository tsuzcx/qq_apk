package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class i$a$3
  implements BluetoothAdapter.LeScanCallback
{
  i$a$3(i.a parama) {}
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87705);
    if (paramBluetoothDevice == null)
    {
      ab.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
      AppMethodBeat.o(87705);
      return;
    }
    if ((this.klO.klH.klz == null) || (bo.isNullOrNil(this.klO.klH.klz.name)))
    {
      AppMethodBeat.o(87705);
      return;
    }
    String str = bo.nullAsNil(paramBluetoothDevice.getName());
    paramBluetoothDevice = paramBluetoothDevice.getAddress();
    if (str.equals(this.klO.klH.klz.name))
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramBluetoothDevice, str, Integer.valueOf(paramInt) });
      paramArrayOfByte = new i.b(paramBluetoothDevice, paramInt, str, i.a.av(paramArrayOfByte));
      this.klO.klK.put(paramBluetoothDevice, paramArrayOfByte);
      AppMethodBeat.o(87705);
      return;
    }
    ab.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramBluetoothDevice, str, Integer.valueOf(paramInt) });
    AppMethodBeat.o(87705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i.a.3
 * JD-Core Version:    0.7.0.1
 */