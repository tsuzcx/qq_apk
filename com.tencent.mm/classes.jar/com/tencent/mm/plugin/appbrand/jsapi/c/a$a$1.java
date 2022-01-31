package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class a$a$1
  implements BluetoothAdapter.LeScanCallback
{
  a$a$1(a.a parama) {}
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94352);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.BeaconManager", "valueByte is null or nil");
      AppMethodBeat.o(94352);
      return;
    }
    int k = 0;
    int i = 2;
    for (;;)
    {
      j = k;
      if (i <= 5)
      {
        if (((paramArrayOfByte[(i + 2)] & 0xFF) == 2) && ((paramArrayOfByte[(i + 3)] & 0xFF) == 21)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label624;
        }
        localObject1 = new byte[16];
        System.arraycopy(paramArrayOfByte, i + 4, localObject1, 0, 16);
        localObject2 = new StringBuilder();
        j = 0;
        while (j < 16)
        {
          k = localObject1[j] & 0xFF;
          if (k < 16) {
            ((StringBuilder)localObject2).append("0");
          }
          ((StringBuilder)localObject2).append(Integer.toHexString(k));
          j += 1;
        }
      }
      i += 1;
    }
    Object localObject1 = ((StringBuilder)localObject2).toString().toUpperCase(Locale.US);
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.BeaconManager", "hexString is null, err");
      AppMethodBeat.o(94352);
      return;
    }
    localObject1 = UUID.fromString(((String)localObject1).substring(0, 8) + "-" + ((String)localObject1).substring(8, 12) + "-" + ((String)localObject1).substring(12, 16) + "-" + ((String)localObject1).substring(16, 20) + "-" + ((String)localObject1).substring(20, 32));
    int m = 0;
    Object localObject2 = this.hMt.hMo;
    int n = localObject2.length;
    int j = 0;
    for (;;)
    {
      k = m;
      double d;
      if (j < n)
      {
        if (localObject2[j].equals(localObject1)) {
          k = 1;
        }
      }
      else if (k != 0)
      {
        j = paramArrayOfByte[(i + 20)];
        k = paramArrayOfByte[(i + 21)];
        m = paramArrayOfByte[(i + 22)];
        n = paramArrayOfByte[(i + 23)];
        i = paramArrayOfByte[(i + 24)];
        d = paramInt;
        if (d != 0.0D) {
          break label639;
        }
        d = -1.0D;
        label412:
        paramBluetoothDevice = paramBluetoothDevice.getAddress();
        paramArrayOfByte = new JSONObject();
      }
      try
      {
        paramArrayOfByte.put("uuid", localObject1);
        paramArrayOfByte.put("major", (j & 0xFF) * 256 + (k & 0xFF));
        paramArrayOfByte.put("minor", (m & 0xFF) * 256 + (n & 0xFF));
        paramArrayOfByte.put("proximity", 0);
        paramArrayOfByte.put("accuracy", d);
        paramArrayOfByte.put("rssi", paramInt);
        this.hMt.hMn.put(paramBluetoothDevice, paramArrayOfByte);
        this.hMt.hMr.put(paramBluetoothDevice, paramArrayOfByte);
        ab.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[] { paramArrayOfByte });
        long l = System.currentTimeMillis();
        if (l - this.hMt.hMq > 500L)
        {
          if (this.hMt.hMp != null) {
            this.hMt.hMp.A(this.hMt.hMr);
          }
          this.hMt.hMq = l;
          this.hMt.hMr.clear();
        }
        label624:
        AppMethodBeat.o(94352);
        return;
        j += 1;
        continue;
        label639:
        d = d * 1.0D / i;
        if (d < 1.0D)
        {
          d = Math.pow(d, 10.0D);
          break label412;
        }
        d = Math.pow(d, 9.9476D) * 0.92093D + 0.54992D;
      }
      catch (JSONException paramBluetoothDevice)
      {
        for (;;)
        {
          ab.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[] { paramBluetoothDevice });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.a.1
 * JD-Core Version:    0.7.0.1
 */