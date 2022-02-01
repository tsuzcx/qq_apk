package com.tencent.mm.plugin.appbrand.jsapi.b;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static BroadcastReceiver kia;
  public static boolean kib;
  public static Map<String, a> map;
  
  static
  {
    AppMethodBeat.i(144673);
    map = new ConcurrentHashMap();
    AppMethodBeat.o(144673);
  }
  
  public static a Mh(String paramString)
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
    if (kia == null)
    {
      ac.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
      kia = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          boolean bool2 = false;
          AppMethodBeat.i(144666);
          if (paramAnonymousIntent == null)
          {
            ac.i("MicroMsg.BeaconManager", "Receive intent failed");
            AppMethodBeat.o(144666);
            return;
          }
          paramAnonymousContext = BluetoothAdapter.getDefaultAdapter();
          if (paramAnonymousContext != null)
          {
            int i = paramAnonymousContext.getState();
            ac.d("MicroMsg.BeaconManager", "state:%d", new Object[] { Integer.valueOf(i) });
            boolean bool1;
            if (i == 12) {
              bool1 = true;
            }
            while (((a.kib) && (!bool1)) || ((!a.kib) && (bool1)))
            {
              paramAnonymousContext = a.map.values().iterator();
              while (paramAnonymousContext.hasNext())
              {
                paramAnonymousIntent = (a.a)paramAnonymousContext.next();
                if ((paramAnonymousIntent.isStart()) && (!bool1)) {
                  paramAnonymousIntent.Fb();
                }
                if (paramAnonymousIntent.ksm != null) {
                  paramAnonymousIntent.ksm.gm(bool1);
                }
              }
              bool1 = bool2;
              if (i == 10) {
                bool1 = bool2;
              }
            }
            a.kib = bool1;
          }
          AppMethodBeat.o(144666);
        }
      };
      paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      ai.getContext().registerReceiver(kia, paramString);
    }
    AppMethodBeat.o(144670);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(144672);
    map.remove(paramString);
    ac.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[] { paramString });
    if ((map.size() == 0) && (kia != null))
    {
      ac.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
      ai.getContext().unregisterReceiver(kia);
      kia = null;
    }
    AppMethodBeat.o(144672);
  }
  
  public static final class a
  {
    volatile boolean isStart;
    BluetoothAdapter ksj;
    Map<String, JSONObject> ksk;
    UUID[] ksl;
    a ksm;
    long ksn;
    Map<String, JSONObject> kso;
    BluetoothAdapter.LeScanCallback ksp;
    
    public a()
    {
      AppMethodBeat.i(144668);
      this.ksk = new ConcurrentHashMap();
      this.ksl = null;
      this.isStart = false;
      this.ksn = 0L;
      this.kso = new ConcurrentHashMap();
      this.ksp = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(144667);
          if (bs.cv(paramAnonymousArrayOfByte))
          {
            ac.e("MicroMsg.BeaconManager", "valueByte is null or nil");
            AppMethodBeat.o(144667);
            return;
          }
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
                break label624;
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
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.e("MicroMsg.BeaconManager", "hexString is null, err");
            AppMethodBeat.o(144667);
            return;
          }
          localObject1 = UUID.fromString(((String)localObject1).substring(0, 8) + "-" + ((String)localObject1).substring(8, 12) + "-" + ((String)localObject1).substring(12, 16) + "-" + ((String)localObject1).substring(16, 20) + "-" + ((String)localObject1).substring(20, 32));
          int m = 0;
          Object localObject2 = a.a.this.ksl;
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
              j = paramAnonymousArrayOfByte[(i + 20)];
              k = paramAnonymousArrayOfByte[(i + 21)];
              m = paramAnonymousArrayOfByte[(i + 22)];
              n = paramAnonymousArrayOfByte[(i + 23)];
              i = paramAnonymousArrayOfByte[(i + 24)];
              d = paramAnonymousInt;
              if (d != 0.0D) {
                break label639;
              }
              d = -1.0D;
              label412:
              paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
              paramAnonymousArrayOfByte = new JSONObject();
            }
            try
            {
              paramAnonymousArrayOfByte.put("uuid", localObject1);
              paramAnonymousArrayOfByte.put("major", (j & 0xFF) * 256 + (k & 0xFF));
              paramAnonymousArrayOfByte.put("minor", (m & 0xFF) * 256 + (n & 0xFF));
              paramAnonymousArrayOfByte.put("proximity", 0);
              paramAnonymousArrayOfByte.put("accuracy", d);
              paramAnonymousArrayOfByte.put("rssi", paramAnonymousInt);
              a.a.this.ksk.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              a.a.this.kso.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
              ac.d("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[] { paramAnonymousArrayOfByte });
              long l = System.currentTimeMillis();
              if (l - a.a.this.ksn > 500L)
              {
                if (a.a.this.ksm != null) {
                  a.a.this.ksm.E(a.a.this.kso);
                }
                a.a.this.ksn = l;
                a.a.this.kso.clear();
              }
              label624:
              AppMethodBeat.o(144667);
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
            catch (JSONException paramAnonymousBluetoothDevice)
            {
              for (;;)
              {
                ac.e("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[] { paramAnonymousBluetoothDevice });
              }
            }
          }
        }
      };
      BluetoothManager localBluetoothManager = (BluetoothManager)ai.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        ac.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
        AppMethodBeat.o(144668);
        return;
      }
      this.ksj = localBluetoothManager.getAdapter();
      if (this.ksj == null)
      {
        ac.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        AppMethodBeat.o(144668);
        return;
      }
      a.kib = this.ksj.isEnabled();
      AppMethodBeat.o(144668);
    }
    
    public final boolean Fb()
    {
      AppMethodBeat.i(144669);
      ac.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
      if (!isStart())
      {
        ac.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
        AppMethodBeat.o(144669);
        return false;
      }
      this.ksk.clear();
      this.ksj.stopLeScan(this.ksp);
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
      
      public abstract void gm(boolean paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */