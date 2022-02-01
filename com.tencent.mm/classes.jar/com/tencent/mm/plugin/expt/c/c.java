package com.tencent.mm.plugin.expt.c;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.matrix.a.a.a.e;
import com.tencent.matrix.a.a.a.e.b;
import com.tencent.matrix.a.a.a.n;
import com.tencent.matrix.a.a.a.n.b;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch;", "", "()V", "Companion", "plugin-expt_release"})
public final class c
{
  private static final HashMap<String, List<Pair<String, String>>> wcQ;
  private static final HashMap<String, List<Pair<String, String>>> wcR;
  private static final HashMap<String, List<Pair<String, String>>> wcS;
  public static final a wcT;
  
  static
  {
    AppMethodBeat.i(251964);
    wcT = new a((byte)0);
    wcQ = new HashMap();
    wcR = new HashMap();
    wcS = new HashMap();
    AppMethodBeat.o(251964);
  }
  
  public static final void Xr()
  {
    AppMethodBeat.i(251965);
    Map localMap = (Map)wcQ;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("getConnectionInfo", "()Landroid/net/wifi/WifiInfo;"));
    localArrayList.add(Pair.create("getScanResults", "()Ljava/util/List;"));
    localArrayList.add(Pair.create("startScan", "()Z"));
    localMap.put("android/net/wifi/WifiManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)wcQ, (com.tencent.mm.hellhoundlib.a.c)new c.a.a());
    localMap = (Map)wcR;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("getAllCellInfo", "()Ljava/util/List;"));
    localMap.put("android/telephony/TelephonyManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)wcR, (com.tencent.mm.hellhoundlib.a.c)new c.a.b());
    localMap = (Map)wcS;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startDiscovery", "()Z"));
    localArrayList.add(Pair.create("startLeScan", "([Ljava/util/UUID;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z"));
    localArrayList.add(Pair.create("startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z"));
    localMap.put("android/bluetooth/BluetoothAdapter", localArrayList);
    localMap = (Map)wcS;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startScan", "(Landroid/bluetooth/le/ScanCallback;)V"));
    localArrayList.add(Pair.create("startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V"));
    localArrayList.add(Pair.create("startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/app/PendingIntent;)I"));
    localMap.put("android/bluetooth/le/BluetoothLeScanner", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)wcS, (com.tencent.mm.hellhoundlib.a.c)new c.a.c());
    AppMethodBeat.o(251965);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion;", "", "()V", "TAG", "", "bluetoothManagerMethods", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "telephonyManagerMethods", "wifiManagerMethods", "isPermissionGranted", "", "context", "Landroid/content/Context;", "monitor", "", "unmonitor", "plugin-expt_release"})
  public static final class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$2", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"})
    public static final class a
      implements com.tencent.mm.hellhoundlib.a.c
    {
      @SuppressLint({"MissingPermission"})
      public final Object a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(254855);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString3 + " from " + paramString1 + '#' + paramString2);
        paramArrayOfObject = MMApplicationContext.getContext();
        p.j(paramArrayOfObject, "MMApplicationContext.getContext()");
        paramArrayOfObject = paramArrayOfObject.getApplicationContext();
        if (paramObject == null)
        {
          paramString1 = new t("null cannot be cast to non-null type android.net.wifi.WifiManager");
          AppMethodBeat.o(254855);
          throw paramString1;
        }
        paramObject = (WifiManager)paramObject;
        if (paramString3 == null) {}
        for (;;)
        {
          AppMethodBeat.o(254855);
          return null;
          c.a locala;
          switch (paramString3.hashCode())
          {
          default: 
            break;
          case -2129330689: 
            if (paramString3.equals("startScan"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = (n)com.tencent.matrix.a.a.Z(n.class);
                if (paramString1 != null)
                {
                  paramString1 = paramString1.Wx();
                  if (paramString1 != null) {
                    paramString1.Wo();
                  }
                }
                boolean bool = paramObject.startScan();
                AppMethodBeat.o(254855);
                return Boolean.valueOf(bool);
              }
            }
            break;
          case -703033767: 
            if (paramString3.equals("getConfiguredNetworks"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = paramObject.getConfiguredNetworks();
                AppMethodBeat.o(254855);
                return paramString1;
              }
            }
            break;
          case 977831330: 
            if (paramString3.equals("getConnectionInfo"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = paramObject.getConnectionInfo();
                AppMethodBeat.o(254855);
                return paramString1;
              }
            }
            break;
          case -1437827709: 
            if (paramString3.equals("getScanResults"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = (n)com.tencent.matrix.a.a.Z(n.class);
                if (paramString1 != null)
                {
                  paramString1 = paramString1.Wx();
                  if (paramString1 != null) {
                    paramString1.Wy();
                  }
                }
                paramString1 = paramObject.getScanResults();
                AppMethodBeat.o(254855);
                return paramString1;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
                continue;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
              }
              else
              {
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
                continue;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
              }
            }
            break;
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$4", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"})
    public static final class b
      implements com.tencent.mm.hellhoundlib.a.c
    {
      @SuppressLint({"MissingPermission"})
      public final Object a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(252337);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString3 + " from " + paramString1 + '#' + paramString2);
        paramArrayOfObject = MMApplicationContext.getContext();
        p.j(paramArrayOfObject, "MMApplicationContext.getContext()");
        paramArrayOfObject = paramArrayOfObject.getApplicationContext();
        if (paramObject == null)
        {
          paramString1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(252337);
          throw paramString1;
        }
        paramObject = (TelephonyManager)paramObject;
        if (paramString3 == null) {}
        for (;;)
        {
          AppMethodBeat.o(252337);
          return null;
          c.a locala;
          switch (paramString3.hashCode())
          {
          default: 
            break;
          case -1384328005: 
            if (paramString3.equals("getAllCellInfo"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = paramObject.getAllCellInfo();
                AppMethodBeat.o(252337);
                return paramString1;
              }
            }
            break;
          case 702848429: 
            if (paramString3.equals("getCellLocation"))
            {
              locala = c.wcT;
              p.j(paramArrayOfObject, "gContext");
              if (c.a.fi(paramArrayOfObject))
              {
                paramString1 = paramObject.getCellLocation();
                AppMethodBeat.o(252337);
                return paramString1;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
              }
              else
              {
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
              }
            }
            break;
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$7", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"})
    public static final class c
      implements com.tencent.mm.hellhoundlib.a.c
    {
      @SuppressLint({"MissingPermission"})
      public final Object a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
      {
        c.a locala2 = null;
        c.a locala1 = null;
        boolean bool = false;
        AppMethodBeat.i(254167);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString3 + " from " + paramString1 + '#' + paramString2);
        Object localObject = com.tencent.matrix.c.a.WS();
        int i;
        if (localObject != null)
        {
          localObject = ((com.tencent.matrix.a.c)localObject).VL();
          if (localObject != null)
          {
            localObject = ((d)localObject).VX();
            if (localObject != null) {
              break label126;
            }
            i = 0;
            label90:
            localObject = MMApplicationContext.getContext();
            p.j(localObject, "MMApplicationContext.getContext()");
            localObject = ((Context)localObject).getApplicationContext();
            if (paramString3 != null) {
              break label204;
            }
          }
        }
        label126:
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                AppMethodBeat.o(254167);
                return null;
                localObject = null;
                break;
                localObject = com.tencent.matrix.c.a.WS();
                if (localObject != null)
                {
                  localObject = ((com.tencent.matrix.a.c)localObject).VL();
                  if (localObject != null)
                  {
                    localObject = ((d)localObject).VX();
                    if (localObject != null)
                    {
                      localObject = Integer.valueOf(((com.tencent.matrix.a.a.c)localObject).cTR & 0x1);
                      if (localObject != null) {
                        break label189;
                      }
                    }
                  }
                }
                while (((Integer)localObject).intValue() != 1)
                {
                  i = 1;
                  break;
                  localObject = null;
                  break label172;
                }
                i = 0;
                break label90;
                switch (paramString3.hashCode())
                {
                }
              }
            } while (!paramString3.equals("startScan"));
            if (paramObject != null) {
              break label685;
            }
            paramString1 = new t("null cannot be cast to non-null type android.bluetooth.le.BluetoothLeScanner");
            AppMethodBeat.o(254167);
            throw paramString1;
          } while (!paramString3.equals("startDiscovery"));
          if (paramObject != null) {
            break label340;
          }
          paramString1 = new t("null cannot be cast to non-null type android.bluetooth.BluetoothAdapter");
          AppMethodBeat.o(254167);
          throw paramString1;
        } while (!paramString3.equals("startLeScan"));
        label172:
        label189:
        label204:
        if (paramObject == null)
        {
          paramString1 = new t("null cannot be cast to non-null type android.bluetooth.BluetoothAdapter");
          AppMethodBeat.o(254167);
          throw paramString1;
          label340:
          paramObject = (BluetoothAdapter)paramObject;
          paramArrayOfObject = c.wcT;
          p.j(localObject, "gContext");
          if (c.a.fi((Context)localObject)) {
            if (i != 0)
            {
              paramString1 = (e)com.tencent.matrix.a.a.Z(e.class);
              if (paramString1 != null)
              {
                paramString1 = paramString1.Wk();
                if (paramString1 != null) {
                  paramString1.Wm();
                }
              }
              bool = paramObject.startDiscovery();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(254167);
            return Boolean.valueOf(bool);
            Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
            break;
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
          }
        }
        paramObject = (BluetoothAdapter)paramObject;
        locala2 = c.wcT;
        p.j(localObject, "gContext");
        if (c.a.fi((Context)localObject)) {
          if (i != 0)
          {
            paramString1 = (e)com.tencent.matrix.a.a.Z(e.class);
            if (paramString1 != null)
            {
              paramString1 = paramString1.Wk();
              if (paramString1 != null) {
                paramString1.Wo();
              }
            }
            paramString1 = locala1;
            if (paramArrayOfObject != null) {
              paramString1 = Integer.valueOf(paramArrayOfObject.length);
            }
            if (paramString1 != null) {
              break label570;
            }
            label545:
            if (paramString1 != null) {
              break label603;
            }
          }
        }
        for (;;)
        {
          paramString1 = Boolean.FALSE;
          AppMethodBeat.o(254167);
          return paramString1;
          Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
          break;
          label570:
          if (paramString1.intValue() != 1) {
            break label545;
          }
          bool = paramObject.startLeScan((BluetoothAdapter.LeScanCallback)paramArrayOfObject[0]);
          AppMethodBeat.o(254167);
          return Boolean.valueOf(bool);
          label603:
          if (paramString1.intValue() == 2)
          {
            bool = paramObject.startLeScan((UUID[])paramArrayOfObject[0], (BluetoothAdapter.LeScanCallback)paramArrayOfObject[1]);
            AppMethodBeat.o(254167);
            return Boolean.valueOf(bool);
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
          }
        }
        label685:
        paramObject = (BluetoothLeScanner)paramObject;
        locala1 = c.wcT;
        p.j(localObject, "gContext");
        if (c.a.fi((Context)localObject)) {
          if (i != 0)
          {
            paramString1 = (e)com.tencent.matrix.a.a.Z(e.class);
            if (paramString1 != null)
            {
              paramString1 = paramString1.Wk();
              if (paramString1 != null) {
                paramString1.Wo();
              }
            }
            paramString1 = locala2;
            if (paramArrayOfObject != null) {
              paramString1 = Integer.valueOf(paramArrayOfObject.length);
            }
            if (paramString1 != null) {
              break label786;
            }
            label762:
            if (paramString1 != null) {
              break label840;
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(254167);
          return Integer.valueOf(3);
          Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
          break;
          label786:
          if (paramString1.intValue() != 1) {
            break label762;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.bluetooth.le.ScanCallback");
            AppMethodBeat.o(254167);
            throw paramString1;
          }
          paramObject.startScan((ScanCallback)paramString1);
          paramString1 = x.aazN;
          AppMethodBeat.o(254167);
          return paramString1;
          label840:
          if (paramString1.intValue() == 3)
          {
            if ((paramArrayOfObject[2] instanceof PendingIntent))
            {
              paramString1 = (List)paramArrayOfObject[0];
              paramString2 = paramArrayOfObject[1];
              if (paramString2 == null)
              {
                paramString1 = new t("null cannot be cast to non-null type android.bluetooth.le.ScanSettings");
                AppMethodBeat.o(254167);
                throw paramString1;
              }
              paramString2 = (ScanSettings)paramString2;
              paramString3 = paramArrayOfObject[2];
              if (paramString3 == null)
              {
                paramString1 = new t("null cannot be cast to non-null type android.app.PendingIntent");
                AppMethodBeat.o(254167);
                throw paramString1;
              }
              i = paramObject.startScan(paramString1, paramString2, (PendingIntent)paramString3);
              AppMethodBeat.o(254167);
              return Integer.valueOf(i);
            }
            paramString1 = (List)paramArrayOfObject[0];
            paramString2 = paramArrayOfObject[1];
            if (paramString2 == null)
            {
              paramString1 = new t("null cannot be cast to non-null type android.bluetooth.le.ScanSettings");
              AppMethodBeat.o(254167);
              throw paramString1;
            }
            paramString2 = (ScanSettings)paramString2;
            paramString3 = paramArrayOfObject[2];
            if (paramString3 == null)
            {
              paramString1 = new t("null cannot be cast to non-null type android.bluetooth.le.ScanCallback");
              AppMethodBeat.o(254167);
              throw paramString1;
            }
            paramObject.startScan(paramString1, paramString2, (ScanCallback)paramString3);
            paramString1 = x.aazN;
            AppMethodBeat.o(254167);
            return paramString1;
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString3 + " from " + paramString1 + '#' + paramString2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.c
 * JD-Core Version:    0.7.0.1
 */