package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static Map<String, a> map;
  public static BroadcastReceiver rJV;
  public static boolean rJW;
  
  static
  {
    AppMethodBeat.i(144673);
    map = new ConcurrentHashMap();
    AppMethodBeat.o(144673);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(144670);
    map.put(paramString, parama);
    if (rJV == null)
    {
      Log.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
      rJV = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          boolean bool2 = false;
          AppMethodBeat.i(144666);
          if (paramAnonymousIntent == null)
          {
            Log.i("MicroMsg.BeaconManager", "Receive intent failed");
            AppMethodBeat.o(144666);
            return;
          }
          paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
          if (paramAnonymousContext != null)
          {
            int i = paramAnonymousContext.getState();
            Log.i("MicroMsg.BeaconManager", "state:%d", new Object[] { Integer.valueOf(i) });
            boolean bool1;
            if (i == 12) {
              bool1 = true;
            }
            while (((a.rJW) && (!bool1)) || ((!a.rJW) && (bool1)))
            {
              paramAnonymousContext = a.map.values().iterator();
              while (paramAnonymousContext.hasNext())
              {
                paramAnonymousIntent = (a.a)paramAnonymousContext.next();
                if ((paramAnonymousIntent.isStart()) && (!bool1)) {
                  paramAnonymousIntent.stop();
                }
                if (paramAnonymousIntent.rZl != null) {
                  paramAnonymousIntent.rZl.onBluetoothStateChange(bool1);
                }
              }
              bool1 = bool2;
              if (i == 10) {
                bool1 = bool2;
              }
            }
            a.rJW = bool1;
          }
          AppMethodBeat.o(144666);
        }
      };
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      MMApplicationContext.getContext().registerReceiver(rJV, paramString);
    }
    AppMethodBeat.o(144670);
  }
  
  public static a aaz(String paramString)
  {
    AppMethodBeat.i(144671);
    paramString = (a)map.get(paramString);
    AppMethodBeat.o(144671);
    return paramString;
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(144672);
    map.remove(paramString);
    Log.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((map.size() == 0) && (rJV != null))
    {
      Log.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      MMApplicationContext.getContext().unregisterReceiver(rJV);
      rJV = null;
    }
    AppMethodBeat.o(144672);
  }
  
  public static final class a
  {
    volatile boolean isStart;
    BluetoothAdapter rZi;
    Map<String, JSONObject> rZj;
    UUID[] rZk;
    a rZl;
    long rZm;
    Map<String, JSONObject> rZn;
    BluetoothAdapter.LeScanCallback rZo;
    
    public a()
    {
      AppMethodBeat.i(144668);
      this.rZj = new ConcurrentHashMap();
      this.rZk = null;
      this.isStart = false;
      this.rZm = 0L;
      this.rZn = new ConcurrentHashMap();
      this.rZo = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(144667);
          if (Util.isNullOrNil(paramAnonymousArrayOfByte))
          {
            Log.e("MicroMsg.BeaconManager", "valueByte is null or nil");
            AppMethodBeat.o(144667);
            return;
          }
          Log.i("MicroMsg.BeaconManager", "handleScanData, device: ".concat(String.valueOf(paramAnonymousBluetoothDevice)));
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
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.e("MicroMsg.BeaconManager", "hexString is null, err");
            AppMethodBeat.o(144667);
            return;
          }
          localObject1 = ((String)localObject1).substring(0, 8) + "-" + ((String)localObject1).substring(8, 12) + "-" + ((String)localObject1).substring(12, 16) + "-" + ((String)localObject1).substring(16, 20) + "-" + ((String)localObject1).substring(20, 32);
          Log.i("MicroMsg.BeaconManager", "strUuid %s", new Object[] { localObject1 });
          localObject1 = UUID.fromString((String)localObject1);
          int m = 0;
          Object localObject2 = a.a.this.rZk;
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
              Log.i("MicroMsg.BeaconManager", "not found beacon!");
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
              a.a.this.rZj.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              a.a.this.rZn.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              Log.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[] { paramAnonymousArrayOfByte });
              long l = System.currentTimeMillis();
              if (l - a.a.this.rZm > 500L)
              {
                if (a.a.this.rZl != null) {
                  a.a.this.rZl.O(a.a.this.rZn);
                }
                a.a.this.rZm = l;
                a.a.this.rZn.clear();
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
                Log.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[] { paramAnonymousBluetoothDevice });
              }
            }
          }
        }
      };
      BluetoothManager localBluetoothManager = (BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        Log.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
        AppMethodBeat.o(144668);
        return;
      }
      this.rZi = localBluetoothManager.getAdapter();
      if (this.rZi == null)
      {
        Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        AppMethodBeat.o(144668);
        return;
      }
      a.rJW = this.rZi.isEnabled();
      AppMethodBeat.o(144668);
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
    
    public final boolean stop()
    {
      AppMethodBeat.i(144669);
      Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
      if (!isStart())
      {
        Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(144669);
        return false;
      }
      this.rZj.clear();
      this.rZi.stopLeScan(this.rZo);
      this.isStart = false;
      AppMethodBeat.o(144669);
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void O(Map<String, JSONObject> paramMap);
      
      public abstract void onBluetoothStateChange(boolean paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a
 * JD-Core Version:    0.7.0.1
 */