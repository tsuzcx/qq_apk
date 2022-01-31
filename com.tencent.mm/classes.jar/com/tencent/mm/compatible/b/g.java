package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.jz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class g
{
  private static volatile g elV;
  private static boolean elZ;
  public static boolean ema;
  private static boolean emb;
  private static boolean emc;
  private static int emj;
  private static int emk;
  private static HashMap<Integer, String> eml;
  private static int emm;
  private static int emn;
  private static HashMap<Integer, String> emo;
  private static int emp;
  private static int emq;
  private static HashMap<Integer, String> emr;
  private final Set<a> bLQ;
  public final AudioManager elW;
  private int elX;
  private String elY;
  private int emd;
  private final int eme;
  private ak emf;
  private ak emg;
  private ak emh;
  private int emi;
  
  static
  {
    AppMethodBeat.i(92892);
    elV = null;
    elZ = false;
    ema = false;
    emb = false;
    emc = false;
    emj = 0;
    emk = 0;
    eml = new HashMap();
    emm = 0;
    emn = 0;
    emo = new HashMap();
    emp = 0;
    emq = 0;
    emr = new HashMap();
    AppMethodBeat.o(92892);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public g(Context paramContext)
  {
    AppMethodBeat.i(92856);
    this.elX = -1;
    this.emd = 0;
    this.bLQ = new HashSet();
    this.eme = 1000;
    this.emf = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(92851);
        ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
        g.this.iE(3);
        AppMethodBeat.o(92851);
      }
    };
    this.emg = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(92842);
        ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_ACTIVE ");
        g.this.iE(5);
        AppMethodBeat.o(92842);
      }
    };
    this.emh = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(92843);
        ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
        g.this.setMode(0);
        AppMethodBeat.o(92843);
      }
    };
    this.emi = -1;
    this.elW = ((AudioManager)paramContext.getSystemService("audio"));
    ab.i("MicroMsg.MMAudioManager", "init dkbt %s", new Object[] { KL() });
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92841);
        ab.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
        g.this.iE(7);
        AppMethodBeat.o(92841);
      }
    }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92844);
        int i = paramAnonymousIntent.getIntExtra("state", -1);
        ab.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousIntent.getIntExtra("microphone", -1)) });
        if (i == 0)
        {
          g.this.iE(6);
          AppMethodBeat.o(92844);
          return;
        }
        if (i == 1) {
          g.this.KF();
        }
        AppMethodBeat.o(92844);
      }
    }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92845);
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(92845);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        g.access$002(paramAnonymousIntent.getBooleanExtra("existing", false));
        ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] existing:" + g.emb);
        AppMethodBeat.o(92845);
      }
    }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92846);
        paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (paramAnonymousContext == null)
        {
          ab.i("MicroMsg.MMAudioManager", "device is unavailable");
          AppMethodBeat.o(92846);
          return;
        }
        if (g.a(g.this) == null)
        {
          g.a(g.this, paramAnonymousContext.getAddress());
          AppMethodBeat.o(92846);
          return;
        }
        if (g.a(g.this).equals(paramAnonymousContext.getAddress()))
        {
          ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
          if (d.fw(11))
          {
            g.access$202(true);
            g.b(g.this).sendEmptyMessageDelayed(0, 1000L);
          }
        }
        AppMethodBeat.o(92846);
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92847);
        ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
        paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (paramAnonymousContext == null)
        {
          ab.i("MicroMsg.MMAudioManager", "pre address is null");
          AppMethodBeat.o(92847);
          return;
        }
        if (paramAnonymousContext.getAddress().equals(g.a(g.this)))
        {
          ab.i("MicroMsg.MMAudioManager", "pre connect device is " + paramAnonymousContext.getAddress());
          g.access$202(false);
          g.a(g.this, null);
          if (ac.erF.eoJ == 1) {
            com.tencent.mm.compatible.c.a.b(g.c(g.this));
          }
          g.this.iE(4);
        }
        AppMethodBeat.o(92847);
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
    if (d.fv(11)) {
      paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(92848);
          if (paramAnonymousIntent == null)
          {
            AppMethodBeat.o(92848);
            return;
          }
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = paramAnonymousIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
          paramAnonymousIntent = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (paramAnonymousIntent == null)
          {
            ab.i("MicroMsg.MMAudioManager", "pre address is null");
            AppMethodBeat.o(92848);
            return;
          }
          if (g.a(g.this) == null)
          {
            g.a(g.this, paramAnonymousIntent.getAddress());
            AppMethodBeat.o(92848);
            return;
          }
          if (paramAnonymousIntent.getAddress().equals(g.a(g.this)))
          {
            ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] state:" + i);
            if (i == 2)
            {
              g.access$202(true);
              g.b(g.this).sendEmptyMessageDelayed(0, 1000L);
              AppMethodBeat.o(92848);
              return;
            }
            if (i == 0)
            {
              g.access$202(false);
              if (ac.erF.eoJ == 1) {
                com.tencent.mm.compatible.c.a.b(g.c(g.this));
              }
              g.this.iE(4);
              g.a(g.this, null);
            }
          }
          AppMethodBeat.o(92848);
        }
      }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
    }
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(92849);
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(92849);
          return;
        }
        int i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        int j = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (paramAnonymousContext == null)
        {
          ab.i("MicroMsg.MMAudioManager", "pre address is null");
          AppMethodBeat.o(92849);
          return;
        }
        if (paramAnonymousContext.getAddress().equals(g.a(g.this)))
        {
          ab.i("MicroMsg.MMAudioManager", "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i == 10)
          {
            g.access$202(false);
            g.KX();
            if (ac.erF.eoJ == 1) {
              com.tencent.mm.compatible.c.a.b(g.c(g.this));
            }
            g.this.iE(4);
          }
        }
        AppMethodBeat.o(92849);
      }
    }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    if (d.fv(28)) {
      paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(92850);
          if (paramAnonymousIntent == null)
          {
            AppMethodBeat.o(92850);
            return;
          }
          paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (paramAnonymousContext == null)
          {
            ab.i("MicroMsg.MMAudioManager", "device is unavailable");
            AppMethodBeat.o(92850);
            return;
          }
          g.a(g.this, paramAnonymousContext.getAddress());
          g.d(g.this).removeMessages(0);
          g.e(g.this).sendEmptyMessageDelayed(0, 1000L);
          ab.i("MicroMsg.MMAudioManager", "android pie switch bt device");
          AppMethodBeat.o(92850);
        }
      }, new IntentFilter("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED"));
    }
    AppMethodBeat.o(92856);
  }
  
  public static g KC()
  {
    AppMethodBeat.i(92852);
    if (elV == null) {}
    try
    {
      if (elV == null) {
        elV = new g(ah.getContext());
      }
      g localg = elV;
      AppMethodBeat.o(92852);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(92852);
    }
  }
  
  public static boolean KG()
  {
    return false;
  }
  
  @TargetApi(14)
  private static boolean KI()
  {
    AppMethodBeat.i(92861);
    try
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
        ab.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
        if (i == 2)
        {
          AppMethodBeat.o(92861);
          return true;
        }
        AppMethodBeat.o(92861);
        return false;
      }
      boolean bool = elZ;
      if (bool)
      {
        AppMethodBeat.o(92861);
        return true;
      }
      if (ac.erF.eoU == 1)
      {
        bool = BluetoothAdapter.getDefaultAdapter().isEnabled();
        AppMethodBeat.o(92861);
        return bool;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
      AppMethodBeat.o(92861);
    }
    return false;
  }
  
  public static int KJ()
  {
    AppMethodBeat.i(92863);
    ((AudioManager)ah.getContext().getSystemService("audio")).isBluetoothScoOn();
    AppMethodBeat.o(92863);
    return 0;
  }
  
  public static boolean KK()
  {
    AppMethodBeat.i(92864);
    ab.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + emb + " , isUseHTCAccessory = " + emc);
    if ((emb) && (!emc))
    {
      AppMethodBeat.o(92864);
      return false;
    }
    ab.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + elZ);
    boolean bool = KI();
    if (!bool)
    {
      ab.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + elZ + " , isConnectHeadset() = " + bool);
      AppMethodBeat.o(92864);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      ab.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      AppMethodBeat.o(92864);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      ab.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
      AppMethodBeat.o(92864);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      ab.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
      AppMethodBeat.o(92864);
      return false;
    }
    localObject = ((Set)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((BluetoothDevice)((Iterator)localObject).next()).getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ab.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
        AppMethodBeat.o(92864);
        return false;
      }
      ab.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.TRUE });
      AppMethodBeat.o(92864);
      return true;
    }
  }
  
  private boolean KO()
  {
    AppMethodBeat.i(92871);
    if ((this.elW != null) && (d.fv(23)))
    {
      AudioDeviceInfo[] arrayOfAudioDeviceInfo = this.elW.getDevices(3);
      int j = arrayOfAudioDeviceInfo.length;
      int i = 0;
      while (i < j)
      {
        AudioDeviceInfo localAudioDeviceInfo = arrayOfAudioDeviceInfo[i];
        ab.i("MicroMsg.MMAudioManager", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localAudioDeviceInfo.getType()) });
        if ((localAudioDeviceInfo.getType() == 4) || (localAudioDeviceInfo.getType() == 3) || (localAudioDeviceInfo.getType() == 11))
        {
          AppMethodBeat.o(92871);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(92871);
    return false;
  }
  
  private void KR()
  {
    AppMethodBeat.i(92876);
    if (this.elW != null)
    {
      int i = this.elW.getMode();
      boolean bool = this.elW.isSpeakerphoneOn();
      Object localObject1 = com.tencent.mm.compatible.e.l.Lm().iN(98305);
      Object localObject2 = com.tencent.mm.compatible.e.l.Lm().iN(94209);
      if (localObject1 == null)
      {
        com.tencent.mm.compatible.e.l.Lm().set(98305, Boolean.valueOf(bool));
        ab.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron ".concat(String.valueOf(bool)));
      }
      if (localObject2 == null)
      {
        com.tencent.mm.compatible.e.l.Lm().set(94209, Integer.valueOf(i));
        ab.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode ".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(92876);
  }
  
  private static void KV()
  {
    AppMethodBeat.i(92890);
    jz localjz = new jz();
    if (emj - emk > 1)
    {
      localjz.czx.czy = true;
      localjz.czx.czz = eml.size();
    }
    if (emp - emq > 1)
    {
      localjz.czx.czA = true;
      localjz.czx.czB = emr.size();
    }
    if (emm - emn > 1)
    {
      localjz.czx.czC = true;
      localjz.czx.czD = emo.size();
    }
    if ((localjz.czx.czA) || (localjz.czx.czy) || (localjz.czx.czC))
    {
      ab.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localjz.czx.czy), Integer.valueOf(localjz.czx.czz), Boolean.valueOf(localjz.czx.czA), Integer.valueOf(localjz.czx.czB), Boolean.valueOf(localjz.czx.czC), Integer.valueOf(localjz.czx.czD) });
      com.tencent.mm.sdk.b.a.ymk.l(localjz);
    }
    AppMethodBeat.o(92890);
  }
  
  public static String KW()
  {
    AppMethodBeat.i(92891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(eml.size()).append("init: ").append(emj).append("release: ").append(emk).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!eml.isEmpty())
    {
      localIterator = eml.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(emr.size()).append("init: ").append(emp).append("release: ").append(emq).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!emr.isEmpty())
    {
      localIterator = emr.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(emo.size()).append("init: ").append(emm).append("release: ").append(emm).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!emo.isEmpty())
    {
      localIterator = emo.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    ab.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(92891);
    return localObject;
  }
  
  public static void iH(int paramInt)
  {
    AppMethodBeat.i(92884);
    emj += 1;
    ab.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emj), Integer.valueOf(emk) });
    eml.put(Integer.valueOf(paramInt), bo.dtY().toString());
    KV();
    AppMethodBeat.o(92884);
  }
  
  public static void iI(int paramInt)
  {
    AppMethodBeat.i(92885);
    emk += 1;
    ab.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emj), Integer.valueOf(emk) });
    eml.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(92885);
  }
  
  public static void iJ(int paramInt)
  {
    AppMethodBeat.i(92886);
    emm += 1;
    ab.b("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emm), Integer.valueOf(emn) });
    emo.put(Integer.valueOf(paramInt), bo.dtY().toString());
    KV();
    AppMethodBeat.o(92886);
  }
  
  public static void iK(int paramInt)
  {
    AppMethodBeat.i(92887);
    if (emo.containsKey(Integer.valueOf(paramInt)))
    {
      emn += 1;
      ab.b("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emm), Integer.valueOf(emn) });
      emo.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(92887);
  }
  
  public static void iL(int paramInt)
  {
    AppMethodBeat.i(92888);
    emp += 1;
    ab.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emp), Integer.valueOf(emq) });
    emr.put(Integer.valueOf(paramInt), bo.dtY().toString());
    KV();
    AppMethodBeat.o(92888);
  }
  
  public static void iM(int paramInt)
  {
    AppMethodBeat.i(92889);
    emq += 1;
    ab.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(emp), Integer.valueOf(emq) });
    emr.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(92889);
  }
  
  public final void KD()
  {
    AppMethodBeat.i(92857);
    ab.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", new Object[] { KL() });
    ema = false;
    iE(2);
    AppMethodBeat.o(92857);
  }
  
  public final int KE()
  {
    AppMethodBeat.i(92858);
    this.elX = -1;
    if (!KK())
    {
      AppMethodBeat.o(92858);
      return -1;
    }
    ab.b("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", new Object[] { KL() });
    boolean bool = com.tencent.mm.compatible.c.a.a(this.elW);
    ab.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { KL(), Boolean.valueOf(bool) });
    ab.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + KL() + " ret:" + bool);
    bool = KH();
    ab.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(92858);
      return 1;
    }
    AppMethodBeat.o(92858);
    return 0;
  }
  
  public final void KF()
  {
    AppMethodBeat.i(92859);
    ema = false;
    ab.b("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", new Object[] { KL() });
    com.tencent.mm.compatible.c.a.b(this.elW);
    this.emf.removeCallbacksAndMessages(Integer.valueOf(1));
    ab.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", new Object[] { KL() });
    AppMethodBeat.o(92859);
  }
  
  public final boolean KH()
  {
    AppMethodBeat.i(92860);
    boolean bool1 = this.elW.isBluetoothScoOn();
    boolean bool2 = this.elW.isBluetoothA2dpOn();
    ab.i("MicroMsg.MMAudioManager", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isScoConnected: %s, isBluetoothCanUse: %s, isACLConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(ema), Boolean.valueOf(KK()), Boolean.valueOf(elZ) });
    if ((bool1) || (bool2) || (ema))
    {
      AppMethodBeat.o(92860);
      return true;
    }
    AppMethodBeat.o(92860);
    return false;
  }
  
  public final String KL()
  {
    AppMethodBeat.i(92865);
    if (this.elW != null) {}
    for (int i = this.elW.getMode();; i = 0)
    {
      String str = "mode:" + i + " isSpeakerphoneOn:" + this.elW.isSpeakerphoneOn() + " isBluetoothOn:" + KH() + " btStatus:" + this.elX;
      AppMethodBeat.o(92865);
      return str;
    }
  }
  
  public final boolean KM()
  {
    AppMethodBeat.i(92866);
    if (this.elW.getMode() == 0)
    {
      AppMethodBeat.o(92866);
      return true;
    }
    AppMethodBeat.o(92866);
    return false;
  }
  
  public final boolean KN()
  {
    AppMethodBeat.i(92870);
    if (this.elW != null)
    {
      boolean bool2 = this.elW.isWiredHeadsetOn();
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (d.fv(23)) {
          bool1 = KO();
        }
      }
      AppMethodBeat.o(92870);
      return bool1;
    }
    AppMethodBeat.o(92870);
    return false;
  }
  
  public final void KP()
  {
    AppMethodBeat.i(92874);
    if (this.elW != null) {
      this.elW.setStreamMute(3, true);
    }
    AppMethodBeat.o(92874);
  }
  
  public final void KQ()
  {
    AppMethodBeat.i(92875);
    if (this.elW != null) {
      this.elW.setStreamMute(3, false);
    }
    AppMethodBeat.o(92875);
  }
  
  @Deprecated
  public final void KS()
  {
    AppMethodBeat.i(92877);
    Object localObject2;
    if (this.elW != null)
    {
      Object localObject1 = com.tencent.mm.compatible.e.l.Lm().iN(98305);
      localObject2 = com.tencent.mm.compatible.e.l.Lm().iN(94209);
      if (localObject1 != null)
      {
        ab.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: ".concat(String.valueOf(localObject1)));
        setSpeakerphoneOn(((Boolean)localObject1).booleanValue());
        com.tencent.mm.compatible.e.l.Lm().set(98305, null);
      }
      if (localObject2 == null) {}
    }
    try
    {
      ab.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + localObject2 + ",inmode:0");
      i = bo.getInt(String.valueOf(localObject2), 0);
      if ((i >= -1) && (i < 4))
      {
        setMode(i);
        com.tencent.mm.compatible.e.l.Lm().set(94209, null);
        AppMethodBeat.o(92877);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        setMode(0);
      }
    }
  }
  
  public final int KT()
  {
    int i = this.emd;
    this.emd = 0;
    return i;
  }
  
  public final int KU()
  {
    AppMethodBeat.i(92883);
    if (this.emi == -1) {}
    try
    {
      Field localField = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
      if ((localField != null) && (this.elW != null)) {
        this.emi = localField.getInt(this.elW);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ab.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + localException.getMessage());
        this.emi = 6;
      }
    }
    i = this.emi;
    AppMethodBeat.o(92883);
    return i;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(92853);
    if (parama != null) {
      this.bLQ.add(parama);
    }
    AppMethodBeat.o(92853);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(92854);
    if (parama != null) {
      this.bLQ.remove(parama);
    }
    AppMethodBeat.o(92854);
  }
  
  public final boolean b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(92869);
    int i = this.elW.getStreamMaxVolume(paramInt);
    ab.d("MicroMsg.MMAudioManager", "maxVolumn:".concat(String.valueOf(i)));
    i /= 3;
    int j = this.elW.getStreamVolume(paramInt);
    if (j < i) {
      a.b(this.elW, paramInt, i);
    }
    ab.i("MicroMsg.MMAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean1 = d(paramBoolean1, true, paramBoolean2);
    AppMethodBeat.o(92869);
    return paramBoolean1;
  }
  
  public final int bM(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92862);
    int i;
    if (paramBoolean)
    {
      i = 3;
      if (!KH()) {
        break label36;
      }
      i = j;
    }
    label36:
    for (;;)
    {
      AppMethodBeat.o(92862);
      return i;
      i = 0;
      break;
    }
  }
  
  @TargetApi(11)
  public final boolean bN(boolean paramBoolean)
  {
    int i = 3;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(92868);
    ab.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(KM()), Boolean.valueOf(paramBoolean), KL() });
    if (ax.Ep())
    {
      ab.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", new Object[] { Integer.valueOf(this.elX) });
      AppMethodBeat.o(92868);
      return false;
    }
    if (ema)
    {
      setMode(3);
      AppMethodBeat.o(92868);
      return false;
    }
    KR();
    if (ac.erv.enD)
    {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        for (i = j;; i = 3)
        {
          if (ac.erv.enE >= 0) {
            i = ac.erv.enE;
          }
          ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
          if (i != this.elW.getMode()) {
            setMode(i);
          }
          if (!this.elW.isSpeakerphoneOn()) {
            setSpeakerphoneOn(true);
          }
          AppMethodBeat.o(92868);
          return paramBoolean;
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (ac.erF.eoU != 1) {
          break label697;
        }
        ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
      }
    }
    label692:
    label697:
    for (i = 0;; i = 2)
    {
      if (ac.erv.enF >= 0) {
        i = ac.erv.enF;
      }
      ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
      if (i != this.elW.getMode()) {
        setMode(i);
      }
      if (!this.elW.isSpeakerphoneOn()) {
        break;
      }
      setSpeakerphoneOn(false);
      break;
      if (ac.erv.emD)
      {
        if (ac.erv.KY())
        {
          if (ac.erv.emF >= 0) {
            setMode(ac.erv.emF);
          }
          for (;;)
          {
            if (ac.erv.emH > 0) {
              setSpeakerphoneOn(paramBoolean);
            }
            AppMethodBeat.o(92868);
            return paramBoolean;
            if (ac.erv.emG >= 0) {
              if (paramBoolean) {
                setMode(0);
              } else {
                setMode(2);
              }
            }
          }
        }
        if (ac.erv.KZ())
        {
          if (paramBoolean)
          {
            if (ac.erv.Lc()) {
              setSpeakerphoneOn(true);
            }
            if (ac.erv.Lb() >= 0) {
              setMode(ac.erv.Lb());
            }
          }
          for (;;)
          {
            AppMethodBeat.o(92868);
            return paramBoolean;
            if (ac.erv.Le()) {
              setSpeakerphoneOn(false);
            }
            if (ac.erv.Ld() >= 0) {
              setMode(ac.erv.Ld());
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        for (i = k;; i = 3)
        {
          if (ac.erv.ene >= 0) {
            i = ac.erv.ene;
          }
          ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
          if (i != this.elW.getMode()) {
            setMode(i);
          }
          if (!this.elW.isSpeakerphoneOn()) {
            setSpeakerphoneOn(true);
          }
          AppMethodBeat.o(92868);
          return paramBoolean;
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (ac.erF.eoU != 1) {
          break label692;
        }
        ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
      }
      for (i = 0;; i = 2)
      {
        j = i;
        if (Build.VERSION.SDK_INT >= 11)
        {
          j = i;
          if (com.tencent.mm.compatible.util.l.IM())
          {
            j = i;
            if (2 == ac.erF.eoV) {
              j = 2;
            }
          }
        }
        if (ac.erv.enf >= 0) {
          j = ac.erv.enf;
        }
        ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(j)));
        if (j != this.elW.getMode()) {
          setMode(j);
        }
        if (!this.elW.isSpeakerphoneOn()) {
          break;
        }
        setSpeakerphoneOn(false);
        break;
      }
    }
  }
  
  public final void bW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92882);
    if (this.elW != null)
    {
      ab.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
      a.b(this.elW, paramInt1, paramInt2);
    }
    AppMethodBeat.o(92882);
  }
  
  @TargetApi(11)
  public final boolean d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(92867);
    int i = this.elW.getMode();
    ab.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s isvoip:%s", new Object[] { Boolean.valueOf(KM()), Boolean.valueOf(paramBoolean1), KL(), Boolean.valueOf(paramBoolean2) });
    if (ax.Ep())
    {
      ab.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.elX) });
      AppMethodBeat.o(92867);
      return false;
    }
    if ((!paramBoolean3) && ((KH()) || (ema)))
    {
      ab.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      if (!paramBoolean2) {
        setMode(0);
      }
      for (;;)
      {
        AppMethodBeat.o(92867);
        return false;
        ab.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        setMode(3);
      }
    }
    KR();
    if (paramBoolean2)
    {
      if (ac.erv.emD)
      {
        if (ac.erv.KY())
        {
          if (ac.erv.emF >= 0) {
            setMode(ac.erv.emF);
          }
          for (;;)
          {
            if (ac.erv.emH > 0) {
              setSpeakerphoneOn(paramBoolean1);
            }
            AppMethodBeat.o(92867);
            return paramBoolean1;
            if (ac.erv.emG >= 0) {
              if (paramBoolean1) {
                setMode(0);
              } else {
                setMode(2);
              }
            }
          }
        }
        if (ac.erv.KZ())
        {
          if (paramBoolean1)
          {
            if (ac.erv.Lc()) {
              setSpeakerphoneOn(true);
            }
            if (ac.erv.Lb() >= 0) {
              setMode(ac.erv.Lb());
            }
          }
          for (;;)
          {
            AppMethodBeat.o(92867);
            return paramBoolean1;
            if (ac.erv.Le()) {
              setSpeakerphoneOn(false);
            }
            if (ac.erv.Ld() >= 0) {
              setMode(ac.erv.Ld());
            }
          }
        }
      }
    }
    else if ((ac.erv.emD) && (ac.erv.La()))
    {
      if (paramBoolean1)
      {
        if (ac.erv.Lg()) {
          setSpeakerphoneOn(true);
        }
        if (ac.erv.Lf() >= 0) {
          setMode(ac.erv.Lf());
        }
      }
      for (;;)
      {
        AppMethodBeat.o(92867);
        return paramBoolean1;
        if (ac.erv.Li()) {
          setSpeakerphoneOn(false);
        }
        if (ac.erv.Lh() >= 0) {
          setMode(ac.erv.Lh());
        }
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          i = 0;
          if (ac.erv.ene >= 0) {
            i = ac.erv.ene;
          }
          ab.i("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode: %s, getMode: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.elW.getMode()) });
          if (i != this.elW.getMode()) {
            setMode(i);
          }
          if (i != this.elW.getMode())
          {
            if (this.emd != 0) {
              break label610;
            }
            this.emd = 1;
          }
        }
        for (;;)
        {
          ab.i("MicroMsg.MMAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.elW.isSpeakerphoneOn()) });
          if (!this.elW.isSpeakerphoneOn()) {
            setSpeakerphoneOn(true);
          }
          AppMethodBeat.o(92867);
          return paramBoolean1;
          i = 3;
          break;
          label610:
          if (this.emd == 2) {
            this.emd = 3;
          }
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (ac.erF.eoU != 1) {
          break label932;
        }
        ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
        i = 0;
      }
    }
    for (;;)
    {
      label655:
      int j = i;
      if (Build.VERSION.SDK_INT >= 11)
      {
        j = i;
        if (com.tencent.mm.compatible.util.l.IM())
        {
          j = i;
          if (2 == ac.erF.eoV) {
            j = 2;
          }
        }
      }
      if (ac.erv.enf >= 0) {
        j = ac.erv.enf;
      }
      ab.i("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode: %s getMode:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.elW.getMode()) });
      if (j != this.elW.getMode()) {
        setMode(j);
      }
      if (j != this.elW.getMode())
      {
        if (this.emd != 0) {
          break label835;
        }
        this.emd = 2;
      }
      for (;;)
      {
        ab.i("MicroMsg.MMAudioManager", "voip doShiftSpeaker false isSpeakerphoneOn: %s", new Object[] { Boolean.valueOf(this.elW.isSpeakerphoneOn()) });
        if (!this.elW.isSpeakerphoneOn()) {
          break;
        }
        setSpeakerphoneOn(false);
        break;
        i = 3;
        break label655;
        label835:
        if (this.emd == 1) {
          this.emd = 3;
        }
      }
      setSpeakerphoneOn(paramBoolean1);
      if (KM() == paramBoolean1) {
        break;
      }
      if (paramBoolean1)
      {
        setMode(0);
        break;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.l.IM()) && (2 != ac.erF.eoV))
      {
        setMode(3);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        setMode(3);
        break;
      }
      setMode(2);
      break;
      label932:
      i = 2;
    }
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    AppMethodBeat.i(92880);
    if (this.elW != null)
    {
      paramInt = this.elW.getStreamMaxVolume(paramInt);
      AppMethodBeat.o(92880);
      return paramInt;
    }
    AppMethodBeat.o(92880);
    return 5;
  }
  
  public final int getStreamVolume(int paramInt)
  {
    AppMethodBeat.i(92881);
    if (this.elW != null)
    {
      paramInt = this.elW.getStreamVolume(paramInt);
      AppMethodBeat.o(92881);
      return paramInt;
    }
    AppMethodBeat.o(92881);
    return -1;
  }
  
  public final void iE(int paramInt)
  {
    AppMethodBeat.i(92855);
    ab.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.elX) });
    Iterator localIterator = this.bLQ.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).gy(paramInt);
    }
    AppMethodBeat.o(92855);
  }
  
  public final void iF(int paramInt)
  {
    AppMethodBeat.i(92872);
    if (this.elW != null) {
      a.a(this.elW, paramInt, 1);
    }
    AppMethodBeat.o(92872);
  }
  
  public final void iG(int paramInt)
  {
    AppMethodBeat.i(92873);
    if (this.elW != null) {
      a.a(this.elW, paramInt, -1);
    }
    AppMethodBeat.o(92873);
  }
  
  public final void setMode(int paramInt)
  {
    AppMethodBeat.i(92878);
    if (this.elW != null)
    {
      ab.i("MicroMsg.MMAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.elW.getMode()), Integer.valueOf(paramInt) });
      this.elW.setMode(paramInt);
    }
    AppMethodBeat.o(92878);
  }
  
  public final void setSpeakerphoneOn(boolean paramBoolean)
  {
    AppMethodBeat.i(92879);
    ab.b("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: %s, isSpeakerphoneOn:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.elW.isSpeakerphoneOn()) });
    if (this.elW != null)
    {
      ab.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: ".concat(String.valueOf(paramBoolean)));
      try
      {
        this.elW.setSpeakerphoneOn(paramBoolean);
        AppMethodBeat.o(92879);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(92879);
  }
  
  public static abstract interface a
  {
    public abstract void gy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */