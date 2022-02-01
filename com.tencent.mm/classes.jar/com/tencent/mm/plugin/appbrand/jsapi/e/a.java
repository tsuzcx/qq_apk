package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class a
{
  public static BroadcastReceiver kCT;
  public static boolean kCU;
  public static Map<String, a> map;
  
  static
  {
    AppMethodBeat.i(144673);
    map = new ConcurrentHashMap();
    AppMethodBeat.o(144673);
  }
  
  public static a PD(String paramString)
  {
    AppMethodBeat.i(144671);
    paramString = (a)map.get(paramString);
    AppMethodBeat.o(144671);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(144670);
    map.put(paramString, parama);
    if (kCT == null)
    {
      ad.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
      kCT = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          boolean bool2 = false;
          AppMethodBeat.i(144666);
          if (paramAnonymousIntent == null)
          {
            ad.i("MicroMsg.BeaconManager", "Receive intent failed");
            AppMethodBeat.o(144666);
            return;
          }
          paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
          if (paramAnonymousContext != null)
          {
            int i = paramAnonymousContext.getState();
            ad.i("MicroMsg.BeaconManager", "state:%d", new Object[] { Integer.valueOf(i) });
            boolean bool1;
            if (i == 12) {
              bool1 = true;
            }
            while (((a.kCU) && (!bool1)) || ((!a.kCU) && (bool1)))
            {
              paramAnonymousContext = a.map.values().iterator();
              while (paramAnonymousContext.hasNext())
              {
                paramAnonymousIntent = (a.a)paramAnonymousContext.next();
                if ((paramAnonymousIntent.isStart()) && (!bool1)) {
                  paramAnonymousIntent.Gv();
                }
                if (paramAnonymousIntent.kNI != null) {
                  paramAnonymousIntent.kNI.gs(bool1);
                }
              }
              bool1 = bool2;
              if (i == 10) {
                bool1 = bool2;
              }
            }
            a.kCU = bool1;
          }
          AppMethodBeat.o(144666);
        }
      };
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      aj.getContext().registerReceiver(kCT, paramString);
    }
    AppMethodBeat.o(144670);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(144672);
    map.remove(paramString);
    ad.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((map.size() == 0) && (kCT != null))
    {
      ad.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      aj.getContext().unregisterReceiver(kCT);
      kCT = null;
    }
    AppMethodBeat.o(144672);
  }
  
  public static final class a
  {
    volatile boolean isStart;
    BluetoothAdapter kNF;
    Map<String, JSONObject> kNG;
    UUID[] kNH;
    a kNI;
    long kNJ;
    Map<String, JSONObject> kNK;
    BluetoothAdapter.LeScanCallback kNL;
    
    public a()
    {
      AppMethodBeat.i(144668);
      this.kNG = new ConcurrentHashMap();
      this.kNH = null;
      this.isStart = false;
      this.kNJ = 0L;
      this.kNK = new ConcurrentHashMap();
      this.kNL = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(144667);
          if (bt.cC(paramAnonymousArrayOfByte))
          {
            ad.e("MicroMsg.BeaconManager", "valueByte is null or nil");
            AppMethodBeat.o(144667);
            return;
          }
          ad.i("MicroMsg.BeaconManager", "handleScanData, device: ".concat(String.valueOf(paramAnonymousBluetoothDevice)));
          int k = 0;
          int i = 2;
          for (;;)
          {
            j = k;
            if (i <= 5)
            {
              if (((paramAnonymousArrayOfByte[(i + 2)] & 0xFF) == 2) && ((paramAnonymousArrayOfByte[(i + 3)] & 0xFF) == 21)) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break label680;
              }
              localObject1 = new byte[16];
              System.arraycopy(paramAnonymousArrayOfByte, i + 4, localObject1, 0, 16);
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
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.e("MicroMsg.BeaconManager", "hexString is null, err");
            AppMethodBeat.o(144667);
            return;
          }
          localObject1 = ((String)localObject1).substring(0, 8) + "-" + ((String)localObject1).substring(8, 12) + "-" + ((String)localObject1).substring(12, 16) + "-" + ((String)localObject1).substring(16, 20) + "-" + ((String)localObject1).substring(20, 32);
          ad.i("MicroMsg.BeaconManager", "strUuid %s", new Object[] { localObject1 });
          localObject1 = UUID.fromString((String)localObject1);
          int m = 0;
          Object localObject2 = a.a.this.kNH;
          int n = localObject2.length;
          int j = 0;
          for (;;)
          {
            k = m;
            if (j < n)
            {
              if (localObject2[j].equals(localObject1)) {
                k = 1;
              }
            }
            else
            {
              if (k != 0) {
                break;
              }
              ad.i("MicroMsg.BeaconManager", "not found beacon!");
              AppMethodBeat.o(144667);
              return;
            }
            j += 1;
          }
          j = paramAnonymousArrayOfByte[(i + 20)];
          k = paramAnonymousArrayOfByte[(i + 21)];
          m = paramAnonymousArrayOfByte[(i + 22)];
          n = paramAnonymousArrayOfByte[(i + 23)];
          i = paramAnonymousArrayOfByte[(i + 24)];
          double d = paramAnonymousInt;
          if (d == 0.0D) {
            d = -1.0D;
          }
          for (;;)
          {
            paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
            paramAnonymousArrayOfByte = new JSONObject();
            try
            {
              paramAnonymousArrayOfByte.put("uuid", localObject1);
              paramAnonymousArrayOfByte.put("major", (j & 0xFF) * 256 + (k & 0xFF));
              paramAnonymousArrayOfByte.put("minor", (m & 0xFF) * 256 + (n & 0xFF));
              paramAnonymousArrayOfByte.put("proximity", 0);
              paramAnonymousArrayOfByte.put("accuracy", d);
              paramAnonymousArrayOfByte.put("rssi", paramAnonymousInt);
              a.a.this.kNG.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              a.a.this.kNK.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              ad.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[] { paramAnonymousArrayOfByte });
              long l = System.currentTimeMillis();
              if (l - a.a.this.kNJ > 500L)
              {
                if (a.a.this.kNI != null) {
                  a.a.this.kNI.E(a.a.this.kNK);
                }
                a.a.this.kNJ = l;
                a.a.this.kNK.clear();
              }
              label680:
              AppMethodBeat.o(144667);
              return;
              d = d * 1.0D / i;
              if (d < 1.0D)
              {
                d = Math.pow(d, 10.0D);
                continue;
              }
              d = Math.pow(d, 9.9476D) * 0.92093D + 0.54992D;
            }
            catch (JSONException paramAnonymousBluetoothDevice)
            {
              for (;;)
              {
                ad.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[] { paramAnonymousBluetoothDevice });
              }
            }
          }
        }
      };
      BluetoothManager localBluetoothManager = (BluetoothManager)aj.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
        AppMethodBeat.o(144668);
        return;
      }
      this.kNF = localBluetoothManager.getAdapter();
      if (this.kNF == null)
      {
        ad.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        AppMethodBeat.o(144668);
        return;
      }
      a.kCU = this.kNF.isEnabled();
      AppMethodBeat.o(144668);
    }
    
    public final boolean Gv()
    {
      AppMethodBeat.i(144669);
      ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
      if (!isStart())
      {
        ad.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(144669);
        return false;
      }
      this.kNG.clear();
      this.kNF.stopLeScan(this.kNL);
      this.isStart = false;
      AppMethodBeat.o(144669);
      return true;
    }
    
    final boolean isStart()
    {
      try
      {
        boolean bool = this.isStart;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public static abstract interface a
    {
      public abstract void E(Map<String, JSONObject> paramMap);
      
      public abstract void gs(boolean paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */