package com.tencent.mm.plugin.expt.d;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.matrix.a.a.a.e;
import com.tencent.matrix.a.a.a.e.b;
import com.tencent.matrix.a.a.a.q.b;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a zxL;
  private static final HashMap<String, List<Pair<String, String>>> zxM;
  private static final HashMap<String, List<Pair<String, String>>> zxN;
  private static final HashMap<String, List<Pair<String, String>>> zxO;
  private static final HashMap<String, List<Pair<String, String>>> zxP;
  
  static
  {
    AppMethodBeat.i(299555);
    zxL = new a((byte)0);
    zxM = new HashMap();
    zxN = new HashMap();
    zxO = new HashMap();
    zxP = new HashMap();
    AppMethodBeat.o(299555);
  }
  
  public static final void ayW()
  {
    AppMethodBeat.i(299552);
    Map localMap = (Map)zxM;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("getConnectionInfo", "()Landroid/net/wifi/WifiInfo;"));
    localArrayList.add(Pair.create("getScanResults", "()Ljava/util/List;"));
    localArrayList.add(Pair.create("startScan", "()Z"));
    localMap.put("android/net/wifi/WifiManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)zxM, (com.tencent.mm.hellhoundlib.a.c)new c.a.a());
    localMap = (Map)zxN;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("getAllCellInfo", "()Ljava/util/List;"));
    localArrayList.add(Pair.create("getCellLocation", "()Landroid/telephony/CellLocation;"));
    localArrayList.add(Pair.create("getSubscriberId", "()Ljava/lang/String;"));
    localArrayList.add(Pair.create("getLine1Number", "()Ljava/lang/String;"));
    localArrayList.add(Pair.create("getDeviceId", "()Ljava/lang/String;"));
    localArrayList.add(Pair.create("getImei", "()Ljava/lang/String;"));
    localArrayList.add(Pair.create("getImei", "(I)Ljava/lang/String;"));
    localArrayList.add(Pair.create("getMeid", "()Ljava/lang/String;"));
    localArrayList.add(Pair.create("getMeid", "(I)Ljava/lang/String;"));
    localMap.put("android/telephony/TelephonyManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)zxN, (com.tencent.mm.hellhoundlib.a.c)new c.a.b());
    localMap = (Map)zxO;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startDiscovery", "()Z"));
    localArrayList.add(Pair.create("startLeScan", "([Ljava/util/UUID;Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z"));
    localArrayList.add(Pair.create("startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z"));
    localMap.put("android/bluetooth/BluetoothAdapter", localArrayList);
    localMap = (Map)zxO;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startScan", "(Landroid/bluetooth/le/ScanCallback;)V"));
    localArrayList.add(Pair.create("startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V"));
    localArrayList.add(Pair.create("startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/app/PendingIntent;)I"));
    localMap.put("android/bluetooth/le/BluetoothLeScanner", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)zxO, (com.tencent.mm.hellhoundlib.a.c)new c.a.c());
    localMap = (Map)zxP;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;"));
    localMap.put("android/provider/Settings$Secure", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)zxP, (com.tencent.mm.hellhoundlib.a.c)new c.a.d());
    AppMethodBeat.o(299552);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion;", "", "()V", "TAG", "", "bluetoothManagerMethods", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "otherSensitiveMethods", "telephonyManagerMethods", "wifiManagerMethods", "isLocationPermissionGranted", "", "context", "Landroid/content/Context;", "isPhoneStatePermissionGranted", "monitor", "", "unmonitor", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$2", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.hellhoundlib.a.c
    {
      public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(299541);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString4 + " from " + paramString1 + '#' + paramString2);
        paramString5 = MMApplicationContext.getContext().getApplicationContext();
        if (paramObject == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
          AppMethodBeat.o(299541);
          throw paramString1;
        }
        paramString3 = (WifiManager)paramObject;
        if (paramString4 != null) {
          switch (paramString4.hashCode())
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(299541);
          return null;
          if (paramString4.equals("getConfiguredNetworks"))
          {
            paramObject = c.zxL;
            s.s(paramString5, "gContext");
            if (c.a.gf(paramString5))
            {
              paramString1 = paramString3.getConfiguredNetworks();
              AppMethodBeat.o(299541);
              return paramString1;
              if (paramString4.equals("getConnectionInfo"))
              {
                paramObject = c.zxL;
                s.s(paramString5, "gContext");
                if (c.a.gf(paramString5))
                {
                  paramString1 = paramString3.getConnectionInfo();
                  AppMethodBeat.o(299541);
                  return paramString1;
                  if (!paramString4.equals("startScan")) {
                    continue;
                  }
                  paramObject = c.zxL;
                  s.s(paramString5, "gContext");
                  if (c.a.gf(paramString5))
                  {
                    paramString1 = (com.tencent.matrix.a.a.a.q)com.tencent.matrix.a.a.aj(com.tencent.matrix.a.a.a.q.class);
                    if (paramString1 != null)
                    {
                      paramString1 = paramString1.eTm;
                      if (paramString1 != null) {
                        paramString1.awW();
                      }
                    }
                    boolean bool = paramString3.startScan();
                    AppMethodBeat.o(299541);
                    return Boolean.valueOf(bool);
                    if (!paramString4.equals("getScanResults")) {
                      continue;
                    }
                    paramObject = c.zxL;
                    s.s(paramString5, "gContext");
                    if (!c.a.gf(paramString5)) {
                      break label450;
                    }
                    paramString1 = (com.tencent.matrix.a.a.a.q)com.tencent.matrix.a.a.aj(com.tencent.matrix.a.a.a.q.class);
                    if (paramString1 != null)
                    {
                      paramString1 = paramString1.eTm;
                      if (paramString1 != null) {
                        paramString1.axn();
                      }
                    }
                    paramString1 = paramString3.getScanResults();
                    AppMethodBeat.o(299541);
                    return paramString1;
                  }
                }
                else
                {
                  Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                  continue;
                }
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                continue;
                label450:
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
              }
            }
            else
            {
              Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$4", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "imei", "", "imeiByIdx", "imsi", "meid", "meidByIdx", "onHook", "", "innerClassName", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements com.tencent.mm.hellhoundlib.a.c
    {
      private String imei;
      private String imsi;
      private String zxQ;
      private String zxR;
      private String zxS;
      
      public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(299573);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString4 + " from " + paramString1 + '#' + paramString2);
        paramString5 = MMApplicationContext.getContext().getApplicationContext();
        if (paramObject == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(299573);
          throw paramString1;
        }
        paramString3 = (TelephonyManager)paramObject;
        if (paramString4 != null) {
          switch (paramString4.hashCode())
          {
          default: 
            break;
          }
        }
        for (;;)
        {
          label156:
          AppMethodBeat.o(299573);
          return null;
          if (paramString4.equals("getDeviceId"))
          {
            if (Build.VERSION.SDK_INT < 29)
            {
              paramString3 = c.zxL;
              s.s(paramString5, "gContext");
              if (c.a.gg(paramString5))
              {
                paramString1 = com.tencent.mm.compatible.deviceinfo.q.eD(false);
                AppMethodBeat.o(299573);
                return paramString1;
                if (!paramString4.equals("getSubscriberId")) {
                  continue;
                }
                if (Build.VERSION.SDK_INT < 29)
                {
                  paramObject = c.zxL;
                  s.s(paramString5, "gContext");
                  if (c.a.gg(paramString5))
                  {
                    paramString1 = this.imsi;
                    if (paramString1 == null)
                    {
                      paramString1 = (b)this;
                      paramString1.imsi = paramString3.getSubscriberId();
                      paramString1 = paramString1.imsi;
                      AppMethodBeat.o(299573);
                      return paramString1;
                      if (!paramString4.equals("getAllCellInfo")) {
                        continue;
                      }
                      paramObject = c.zxL;
                      s.s(paramString5, "gContext");
                      if (c.a.gf(paramString5))
                      {
                        paramString1 = paramString3.getAllCellInfo();
                        AppMethodBeat.o(299573);
                        return paramString1;
                        if (!paramString4.equals("getCellLocation")) {
                          continue;
                        }
                        paramObject = c.zxL;
                        s.s(paramString5, "gContext");
                        if (!c.a.gf(paramString5)) {
                          break label663;
                        }
                        paramString1 = paramString3.getCellLocation();
                        AppMethodBeat.o(299573);
                        return paramString1;
                        if (!paramString4.equals("getMeid")) {
                          continue;
                        }
                        if (Build.VERSION.SDK_INT >= 29) {
                          break label1015;
                        }
                        paramObject = c.zxL;
                        s.s(paramString5, "gContext");
                        if (!c.a.gg(paramString5)) {
                          break label1015;
                        }
                        if (paramArrayOfObject != null) {
                          break label950;
                        }
                        paramString1 = null;
                        label413:
                        if (paramString1 != null) {
                          break label960;
                        }
                      }
                    }
                  }
                }
              }
            }
            label663:
            label842:
            label852:
            while (paramString1.intValue() != 0)
            {
              if ((paramString1 == null) || (paramString1.intValue() != 1)) {
                break label156;
              }
              paramString1 = this.zxS;
              if (paramString1 != null) {
                break label1008;
              }
              paramString1 = (b)this;
              paramString1.zxS = paramString3.getMeid(((Integer)paramArrayOfObject[0]).intValue());
              paramString1 = paramString1.zxS;
              AppMethodBeat.o(299573);
              return paramString1;
              if (!paramString4.equals("getLine1Number")) {
                break label156;
              }
              paramObject = c.zxL;
              s.s(paramString5, "gContext");
              if (c.a.gg(paramString5))
              {
                paramString1 = paramString3.getLine1Number();
                AppMethodBeat.o(299573);
                return paramString1;
                if (!paramString4.equals("getImei")) {
                  break label156;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                  break label907;
                }
                paramObject = c.zxL;
                s.s(paramString5, "gContext");
                if (!c.a.gg(paramString5)) {
                  break label907;
                }
                if (paramArrayOfObject != null) {
                  break label842;
                }
              }
              for (paramString1 = null;; paramString1 = Integer.valueOf(paramArrayOfObject.length))
              {
                if (paramString1 != null) {
                  break label852;
                }
                if ((paramString1 == null) || (paramString1.intValue() != 1)) {
                  break;
                }
                paramString1 = this.zxQ;
                if (paramString1 != null) {
                  break label900;
                }
                paramString1 = (b)this;
                paramString1.zxQ = paramString3.getImei(((Integer)paramArrayOfObject[0]).intValue());
                paramString1 = paramString1.zxQ;
                AppMethodBeat.o(299573);
                return paramString1;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                break;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                break;
                AppMethodBeat.o(299573);
                return paramString1;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                break;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                break;
                Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
                break;
              }
              if (paramString1.intValue() != 0) {
                break;
              }
              paramString1 = this.imei;
              if (paramString1 == null)
              {
                paramString1 = (b)this;
                paramString1.imei = paramString3.getImei();
                paramString1 = paramString1.imei;
                AppMethodBeat.o(299573);
                return paramString1;
              }
              AppMethodBeat.o(299573);
              return paramString1;
              AppMethodBeat.o(299573);
              return paramString1;
              Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
              break label156;
              paramString1 = Integer.valueOf(paramArrayOfObject.length);
              break label413;
            }
            label900:
            label907:
            label950:
            label960:
            paramString1 = this.zxR;
            if (paramString1 == null)
            {
              paramString1 = (b)this;
              paramString1.zxR = paramString3.getMeid();
              paramString1 = paramString1.zxR;
              AppMethodBeat.o(299573);
              return paramString1;
            }
            AppMethodBeat.o(299573);
            return paramString1;
            label1008:
            AppMethodBeat.o(299573);
            return paramString1;
            label1015:
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$7", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements com.tencent.mm.hellhoundlib.a.c
    {
      public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
      {
        Object localObject = null;
        paramString5 = null;
        boolean bool = false;
        AppMethodBeat.i(299581);
        Log.d("MicroMsg.SensitiveApiCallPatch", "hook call " + paramString4 + " from " + paramString1 + '#' + paramString2);
        paramString3 = com.tencent.matrix.c.a.axV();
        int i;
        label71:
        Context localContext;
        if (paramString3 == null)
        {
          paramString3 = null;
          if (paramString3 != null) {
            break label153;
          }
          i = 0;
          localContext = MMApplicationContext.getContext().getApplicationContext();
          if (paramString4 != null) {
            switch (paramString4.hashCode())
            {
            }
          }
        }
        label153:
        label209:
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(299581);
              return null;
              paramString3 = paramString3.eOc;
              if (paramString3 == null)
              {
                paramString3 = null;
                break;
              }
              paramString3 = paramString3.ePD;
              break;
              paramString3 = com.tencent.matrix.c.a.axV();
              if (paramString3 != null)
              {
                paramString3 = paramString3.eOc;
                if (paramString3 != null)
                {
                  paramString3 = paramString3.ePD;
                  if ((paramString3 == null) || ((paramString3.ePt & 0x1) != 1)) {}
                }
              }
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label209;
                }
                i = 0;
                break;
              }
              i = 1;
              break label71;
            } while (!paramString4.equals("startDiscovery"));
            if (paramObject != null) {
              break label311;
            }
            paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothAdapter");
            AppMethodBeat.o(299581);
            throw paramString1;
          } while (!paramString4.equals("startLeScan"));
          if (paramObject != null) {
            break label438;
          }
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothAdapter");
          AppMethodBeat.o(299581);
          throw paramString1;
        } while (!paramString4.equals("startScan"));
        if (paramObject == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.le.BluetoothLeScanner");
          AppMethodBeat.o(299581);
          throw paramString1;
          label311:
          paramString3 = (BluetoothAdapter)paramObject;
          paramString5 = c.zxL;
          s.s(localContext, "gContext");
          if (c.a.gf(localContext)) {
            if (i != 0)
            {
              paramString1 = (e)com.tencent.matrix.a.a.aj(e.class);
              if (paramString1 != null)
              {
                paramString1 = paramString1.eQM;
                if (paramString1 != null) {
                  paramString1.awU();
                }
              }
              bool = paramString3.startDiscovery();
            }
          }
          for (;;)
          {
            AppMethodBeat.o(299581);
            return Boolean.valueOf(bool);
            Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
            break;
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
          }
          label438:
          paramString3 = (BluetoothAdapter)paramObject;
          paramObject = c.zxL;
          s.s(localContext, "gContext");
          if (c.a.gf(localContext)) {
            if (i != 0)
            {
              paramString1 = (e)com.tencent.matrix.a.a.aj(e.class);
              if (paramString1 != null)
              {
                paramString1 = paramString1.eQM;
                if (paramString1 != null) {
                  paramString1.awW();
                }
              }
              if (paramArrayOfObject != null) {
                break label532;
              }
              paramString1 = paramString5;
              label503:
              if (paramString1 != null) {
                break label542;
              }
              label507:
              if (paramString1 != null) {
                break label574;
              }
            }
          }
          for (;;)
          {
            paramString1 = Boolean.FALSE;
            AppMethodBeat.o(299581);
            return paramString1;
            Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
            break;
            label532:
            paramString1 = Integer.valueOf(paramArrayOfObject.length);
            break label503;
            label542:
            if (paramString1.intValue() != 1) {
              break label507;
            }
            bool = paramString3.startLeScan((BluetoothAdapter.LeScanCallback)paramArrayOfObject[0]);
            AppMethodBeat.o(299581);
            return Boolean.valueOf(bool);
            label574:
            if (paramString1.intValue() == 2)
            {
              bool = paramString3.startLeScan((UUID[])paramArrayOfObject[0], (BluetoothAdapter.LeScanCallback)paramArrayOfObject[1]);
              AppMethodBeat.o(299581);
              return Boolean.valueOf(bool);
              Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
            }
          }
        }
        paramString3 = (BluetoothLeScanner)paramObject;
        paramString5 = c.zxL;
        s.s(localContext, "gContext");
        if (c.a.gf(localContext)) {
          if (i != 0)
          {
            paramString1 = (e)com.tencent.matrix.a.a.aj(e.class);
            if (paramString1 != null)
            {
              paramString1 = paramString1.eQM;
              if (paramString1 != null) {
                paramString1.awW();
              }
            }
            if (paramArrayOfObject != null) {
              break label749;
            }
            paramString1 = localObject;
            label721:
            if (paramString1 != null) {
              break label759;
            }
            label725:
            if (paramString1 != null) {
              break label812;
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(299581);
          return Integer.valueOf(3);
          Log.i("MicroMsg.SensitiveApiCallPatch", "bluetooth amsHook enabled, just return.");
          break;
          label749:
          paramString1 = Integer.valueOf(paramArrayOfObject.length);
          break label721;
          label759:
          if (paramString1.intValue() != 1) {
            break label725;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.le.ScanCallback");
            AppMethodBeat.o(299581);
            throw paramString1;
          }
          paramString3.startScan((ScanCallback)paramString1);
          paramString1 = ah.aiuX;
          AppMethodBeat.o(299581);
          return paramString1;
          label812:
          if (paramString1.intValue() == 3)
          {
            if ((paramArrayOfObject[2] instanceof PendingIntent))
            {
              paramString1 = (List)paramArrayOfObject[0];
              paramString2 = paramArrayOfObject[1];
              if (paramString2 == null)
              {
                paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.le.ScanSettings");
                AppMethodBeat.o(299581);
                throw paramString1;
              }
              paramString2 = (ScanSettings)paramString2;
              paramString4 = paramArrayOfObject[2];
              if (paramString4 == null)
              {
                paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.PendingIntent");
                AppMethodBeat.o(299581);
                throw paramString1;
              }
              i = paramString3.startScan(paramString1, paramString2, (PendingIntent)paramString4);
              AppMethodBeat.o(299581);
              return Integer.valueOf(i);
            }
            paramString1 = (List)paramArrayOfObject[0];
            paramString2 = paramArrayOfObject[1];
            if (paramString2 == null)
            {
              paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.le.ScanSettings");
              AppMethodBeat.o(299581);
              throw paramString1;
            }
            paramString2 = (ScanSettings)paramString2;
            paramString4 = paramArrayOfObject[2];
            if (paramString4 == null)
            {
              paramString1 = new NullPointerException("null cannot be cast to non-null type android.bluetooth.le.ScanCallback");
              AppMethodBeat.o(299581);
              throw paramString1;
            }
            paramString3.startScan(paramString1, paramString2, (ScanCallback)paramString4);
            paramString1 = ah.aiuX;
            AppMethodBeat.o(299581);
            return paramString1;
            Log.e("MicroMsg.SensitiveApiCallPatch", "no permission granted call " + paramString4 + " from " + paramString1 + '#' + paramString2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c
 * JD-Core Version:    0.7.0.1
 */