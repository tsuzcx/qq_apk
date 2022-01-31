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
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.jq;
import com.tencent.mm.h.a.jq.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class f
{
  private static int duA = 0;
  private static HashMap<Integer, String> duB = new HashMap();
  private static volatile f duh = null;
  private static boolean duk = false;
  public static boolean dul = false;
  private static boolean dum = false;
  private static boolean dun = false;
  private static int dut = 0;
  private static int duu = 0;
  private static HashMap<Integer, String> duv = new HashMap();
  private static int duw = 0;
  private static int dux = 0;
  private static HashMap<Integer, String> duy = new HashMap();
  private static int duz = 0;
  public final AudioManager dui;
  private int duj = -1;
  private int duo = 0;
  private final Set<a> dup = new HashSet();
  private final int duq = 1000;
  private ah dur = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      y.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
      f.this.gp(3);
    }
  };
  private int dus = -1;
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public f(Context paramContext)
  {
    this.dui = ((AudioManager)paramContext.getSystemService("audio"));
    y.i("MicroMsg.MMAudioManager", "init dkbt %s", new Object[] { yr() });
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        y.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
        f.this.gp(7);
      }
    }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = paramAnonymousIntent.getIntExtra("state", -1);
        y.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousIntent.getIntExtra("microphone", -1)) });
        if (i == 0) {
          f.this.gp(6);
        }
        while (i != 1) {
          return;
        }
        f.this.yl();
      }
    }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent == null) {
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        f.bo(paramAnonymousIntent.getBooleanExtra("existing", false));
        y.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] existing:" + f.dum);
      }
    }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        y.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
        if (d.gG(11))
        {
          f.bp(true);
          f.a(f.this).sendEmptyMessageDelayed(0, 1000L);
        }
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        y.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
        f.bp(false);
        if (q.dyn.dwL == 1) {
          com.tencent.mm.compatible.c.a.a(f.b(f.this));
        }
        f.this.gp(4);
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
    if (d.gF(11)) {
      paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent == null) {}
          int i;
          do
          {
            return;
            paramAnonymousContext = paramAnonymousIntent.getAction();
            i = paramAnonymousIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            y.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] state:" + i);
            if (i == 2)
            {
              f.bp(true);
              f.a(f.this).sendEmptyMessageDelayed(0, 1000L);
              return;
            }
          } while (i != 0);
          f.bp(false);
          if (q.dyn.dwL == 1) {
            com.tencent.mm.compatible.c.a.a(f.b(f.this));
          }
          f.this.gp(4);
        }
      }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
    }
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent == null) {}
        int i;
        do
        {
          return;
          i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
          y.i("MicroMsg.MMAudioManager", "onReceive bluetooth state changed: %s, prevState: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10)) });
        } while (i != 10);
        f.bp(false);
        f.yC();
        if (q.dyn.dwL == 1) {
          com.tencent.mm.compatible.c.a.a(f.b(f.this));
        }
        f.this.gp(4);
      }
    }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
  }
  
  public static void gs(int paramInt)
  {
    dut += 1;
    y.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dut), Integer.valueOf(duu) });
    duv.put(Integer.valueOf(paramInt), bk.csb().toString());
    yA();
  }
  
  public static void gt(int paramInt)
  {
    duu += 1;
    y.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dut), Integer.valueOf(duu) });
    duv.remove(Integer.valueOf(paramInt));
  }
  
  public static void gu(int paramInt)
  {
    duw += 1;
    y.l("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(duw), Integer.valueOf(dux) });
    duy.put(Integer.valueOf(paramInt), bk.csb().toString());
    yA();
  }
  
  public static void gv(int paramInt)
  {
    if (duy.containsKey(Integer.valueOf(paramInt)))
    {
      dux += 1;
      y.l("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(duw), Integer.valueOf(dux) });
      duy.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void gw(int paramInt)
  {
    duz += 1;
    y.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(duz), Integer.valueOf(duA) });
    duB.put(Integer.valueOf(paramInt), bk.csb().toString());
    yA();
  }
  
  public static void gx(int paramInt)
  {
    duA += 1;
    y.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(duz), Integer.valueOf(duA) });
    duB.remove(Integer.valueOf(paramInt));
  }
  
  private static void yA()
  {
    jq localjq = new jq();
    if (dut - duu > 1)
    {
      localjq.bRW.bRX = true;
      localjq.bRW.bRY = duv.size();
    }
    if (duz - duA > 1)
    {
      localjq.bRW.bRZ = true;
      localjq.bRW.bSa = duB.size();
    }
    if (duw - dux > 1)
    {
      localjq.bRW.bSb = true;
      localjq.bRW.bSc = duy.size();
    }
    if ((localjq.bRW.bRZ) || (localjq.bRW.bRX) || (localjq.bRW.bSb))
    {
      y.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localjq.bRW.bRX), Integer.valueOf(localjq.bRW.bRY), Boolean.valueOf(localjq.bRW.bRZ), Integer.valueOf(localjq.bRW.bSa), Boolean.valueOf(localjq.bRW.bSb), Integer.valueOf(localjq.bRW.bSc) });
      com.tencent.mm.sdk.b.a.udP.m(localjq);
    }
  }
  
  public static String yB()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(duv.size()).append("init: ").append(dut).append("release: ").append(duu).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!duv.isEmpty())
    {
      localIterator = duv.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(duB.size()).append("init: ").append(duz).append("release: ").append(duA).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!duB.isEmpty())
    {
      localIterator = duB.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(duy.size()).append("init: ").append(duw).append("release: ").append(duw).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!duy.isEmpty())
    {
      localIterator = duy.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    y.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    return localObject;
  }
  
  public static f yi()
  {
    if (duh == null) {}
    try
    {
      if (duh == null) {
        duh = new f(ae.getContext());
      }
      return duh;
    }
    finally {}
  }
  
  public static boolean ym()
  {
    return false;
  }
  
  @TargetApi(14)
  private static boolean yo()
  {
    boolean bool = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
        y.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
        if (i != 2) {
          break label82;
        }
        return true;
      }
      if (!duk) {
        if (q.dyn.dwW == 1)
        {
          bool = BluetoothAdapter.getDefaultAdapter().isEnabled();
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
      bool = false;
    }
    return bool;
    label82:
    return false;
  }
  
  public static int yp()
  {
    ((AudioManager)ae.getContext().getSystemService("audio")).isBluetoothScoOn();
    return 0;
  }
  
  public static boolean yq()
  {
    y.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + dum + " , isUseHTCAccessory = " + dun);
    if ((dum) && (!dun)) {
      return false;
    }
    y.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + duk);
    if (!yo())
    {
      y.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + duk + " , isConnectHeadset() = " + yo());
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      y.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      y.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      y.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
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
        y.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
        return false;
      }
      y.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.valueOf(true) });
      return true;
    }
  }
  
  private void yw()
  {
    if (this.dui != null)
    {
      int i = this.dui.getMode();
      boolean bool = this.dui.isSpeakerphoneOn();
      Object localObject1 = com.tencent.mm.compatible.e.l.yP().gz(98305);
      Object localObject2 = com.tencent.mm.compatible.e.l.yP().gz(94209);
      if (localObject1 == null)
      {
        com.tencent.mm.compatible.e.l.yP().set(98305, Boolean.valueOf(bool));
        y.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + bool);
      }
      if (localObject2 == null)
      {
        com.tencent.mm.compatible.e.l.yP().set(94209, Integer.valueOf(i));
        y.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + i);
      }
    }
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.dup.add(parama);
    }
  }
  
  public final void aX(int paramInt1, int paramInt2)
  {
    if (this.dui != null)
    {
      y.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
      this.dui.setStreamVolume(paramInt1, paramInt2, 0);
    }
  }
  
  public final void b(a parama)
  {
    if (parama != null) {
      this.dup.remove(parama);
    }
  }
  
  public final boolean b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = this.dui.getStreamMaxVolume(paramInt);
    y.d("MicroMsg.MMAudioManager", "maxVolumn:" + i);
    i /= 3;
    int j = this.dui.getStreamVolume(paramInt);
    if (j < i) {
      this.dui.setStreamVolume(paramInt, i, 0);
    }
    y.i("MicroMsg.MMAudioManager", "StreamType:" + paramInt + "  current:" + j);
    return f(paramBoolean1, true, paramBoolean2);
  }
  
  public final int bm(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 3; yn(); i = 0) {
      return 0;
    }
    return i;
  }
  
  @TargetApi(11)
  public final boolean bn(boolean paramBoolean)
  {
    int i = 3;
    int k = 0;
    int j = 0;
    y.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(ys()), Boolean.valueOf(paramBoolean), yr() });
    boolean bool;
    if (at.uc())
    {
      y.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", new Object[] { Integer.valueOf(this.duj) });
      bool = false;
      return bool;
    }
    if (dul)
    {
      setMode(3);
      return false;
    }
    yw();
    if (q.dye.dvM)
    {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        for (i = j;; i = 3)
        {
          if (q.dye.dvN >= 0) {
            i = q.dye.dvN;
          }
          y.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i);
          if (i != this.dui.getMode()) {
            setMode(i);
          }
          bool = paramBoolean;
          if (this.dui.isSpeakerphoneOn()) {
            break;
          }
          setSpeakerphoneOn(true);
          return paramBoolean;
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (q.dyn.dwW != 1) {
          break label705;
        }
        y.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
      }
    }
    label700:
    label705:
    for (i = 0;; i = 2)
    {
      if (q.dye.dvO >= 0) {
        i = q.dye.dvO;
      }
      y.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
      if (i != this.dui.getMode()) {
        setMode(i);
      }
      bool = paramBoolean;
      if (!this.dui.isSpeakerphoneOn()) {
        break;
      }
      setSpeakerphoneOn(false);
      return paramBoolean;
      if (q.dye.duN)
      {
        if (q.dye.yD())
        {
          if (q.dye.duP >= 0) {
            setMode(q.dye.duP);
          }
          for (;;)
          {
            bool = paramBoolean;
            if (q.dye.duR <= 0) {
              break;
            }
            setSpeakerphoneOn(paramBoolean);
            return paramBoolean;
            if (q.dye.duQ >= 0) {
              if (paramBoolean) {
                setMode(0);
              } else {
                setMode(2);
              }
            }
          }
        }
        if (q.dye.yE())
        {
          if (paramBoolean)
          {
            if (q.dye.yH()) {
              setSpeakerphoneOn(true);
            }
            bool = paramBoolean;
            if (q.dye.yG() < 0) {
              break;
            }
            setMode(q.dye.yG());
            return paramBoolean;
          }
          if (q.dye.yJ()) {
            setSpeakerphoneOn(false);
          }
          bool = paramBoolean;
          if (q.dye.yI() < 0) {
            break;
          }
          setMode(q.dye.yI());
          return paramBoolean;
        }
      }
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        for (i = k;; i = 3)
        {
          if (q.dye.dvn >= 0) {
            i = q.dye.dvn;
          }
          y.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i);
          if (i != this.dui.getMode()) {
            setMode(i);
          }
          bool = paramBoolean;
          if (this.dui.isSpeakerphoneOn()) {
            break;
          }
          setSpeakerphoneOn(true);
          return paramBoolean;
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (q.dyn.dwW != 1) {
          break label700;
        }
        y.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
      }
      for (i = 0;; i = 2)
      {
        j = i;
        if (Build.VERSION.SDK_INT >= 11)
        {
          j = i;
          if (com.tencent.mm.compatible.util.l.wx())
          {
            j = i;
            if (2 == q.dyn.dwX) {
              j = 2;
            }
          }
        }
        if (q.dye.dvo >= 0) {
          j = q.dye.dvo;
        }
        y.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + j);
        if (j != this.dui.getMode()) {
          setMode(j);
        }
        bool = paramBoolean;
        if (!this.dui.isSpeakerphoneOn()) {
          break;
        }
        setSpeakerphoneOn(false);
        return paramBoolean;
      }
    }
  }
  
  @TargetApi(11)
  public final boolean f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    int m = this.dui.getMode();
    y.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(ys()), Boolean.valueOf(paramBoolean1), yr() });
    if (at.uc())
    {
      y.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(this.duj) });
      paramBoolean2 = false;
    }
    do
    {
      do
      {
        return paramBoolean2;
        if ((!paramBoolean3) && ((yn()) || (dul)))
        {
          y.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
          if (!paramBoolean2) {
            setMode(0);
          }
          for (;;)
          {
            return false;
            y.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
            setMode(3);
          }
        }
        yw();
        if (!paramBoolean2) {
          break label325;
        }
        if (!q.dye.duN) {
          break label569;
        }
        if (q.dye.yD())
        {
          if (q.dye.duP >= 0) {
            setMode(q.dye.duP);
          }
          for (;;)
          {
            paramBoolean2 = paramBoolean1;
            if (q.dye.duR <= 0) {
              break;
            }
            setSpeakerphoneOn(paramBoolean1);
            return paramBoolean1;
            if (q.dye.duQ >= 0) {
              if (paramBoolean1) {
                setMode(0);
              } else {
                setMode(2);
              }
            }
          }
        }
        if (!q.dye.yE()) {
          break label569;
        }
        if (!paramBoolean1) {
          break;
        }
        if (q.dye.yH()) {
          setSpeakerphoneOn(true);
        }
        paramBoolean2 = paramBoolean1;
      } while (q.dye.yG() < 0);
      setMode(q.dye.yG());
      return paramBoolean1;
      if (q.dye.yJ()) {
        setSpeakerphoneOn(false);
      }
      paramBoolean2 = paramBoolean1;
    } while (q.dye.yI() < 0);
    setMode(q.dye.yI());
    return paramBoolean1;
    label325:
    if ((q.dye.duN) && (q.dye.yF()))
    {
      if (paramBoolean1)
      {
        localObject = q.dye;
        i = j;
        if (((b)localObject).yF())
        {
          k = ((b)localObject).duT & 0x10;
          localObject = new StringBuilder("enableSpeaker ");
          if (k <= 0) {
            break label453;
          }
        }
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          y.d("VoipAudioInfo", paramBoolean2);
          i = j;
          if (k > 0) {
            i = 1;
          }
          if (i != 0) {
            setSpeakerphoneOn(true);
          }
          paramBoolean2 = paramBoolean1;
          if (q.dye.yK() < 0) {
            break;
          }
          setMode(q.dye.yK());
          return paramBoolean1;
        }
      }
      Object localObject = q.dye;
      if (((b)localObject).yF())
      {
        j = ((b)localObject).duT & 0x1;
        localObject = new StringBuilder("disableSpeaker ");
        if (j > 0)
        {
          paramBoolean2 = true;
          label499:
          y.d("VoipAudioInfo", paramBoolean2);
          if (j <= 0) {
            break label557;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          setSpeakerphoneOn(false);
        }
        paramBoolean2 = paramBoolean1;
        if (q.dye.yL() < 0) {
          break;
        }
        setMode(q.dye.yL());
        return paramBoolean1;
        paramBoolean2 = false;
        break label499;
        i = 0;
        continue;
        i = 0;
      }
    }
    label453:
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          i = k;
          label589:
          if (q.dye.dvn >= 0) {
            i = q.dye.dvn;
          }
          y.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
          if (i != this.dui.getMode()) {
            setMode(i);
          }
          if (i != this.dui.getMode())
          {
            if (this.duo != 0) {
              break label696;
            }
            this.duo = 1;
          }
        }
        for (;;)
        {
          paramBoolean2 = paramBoolean1;
          if (this.dui.isSpeakerphoneOn()) {
            break;
          }
          setSpeakerphoneOn(true);
          return paramBoolean1;
          i = 3;
          break label589;
          if (this.duo == 2) {
            this.duo = 3;
          }
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (q.dyn.dwW != 1) {
          break label982;
        }
        y.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
        i = 0;
      }
    }
    for (;;)
    {
      label557:
      label569:
      label741:
      j = i;
      label696:
      if (Build.VERSION.SDK_INT >= 11)
      {
        j = i;
        if (com.tencent.mm.compatible.util.l.wx())
        {
          j = i;
          if (2 == q.dyn.dwX) {
            j = 2;
          }
        }
      }
      if (q.dye.dvo >= 0) {
        j = q.dye.dvo;
      }
      y.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + j);
      if (j != this.dui.getMode()) {
        setMode(j);
      }
      if (j != this.dui.getMode())
      {
        if (this.duo != 0) {
          break label887;
        }
        this.duo = 2;
      }
      for (;;)
      {
        paramBoolean2 = paramBoolean1;
        if (!this.dui.isSpeakerphoneOn()) {
          break;
        }
        setSpeakerphoneOn(false);
        return paramBoolean1;
        i = 3;
        break label741;
        label887:
        if (this.duo == 1) {
          this.duo = 3;
        }
      }
      setSpeakerphoneOn(paramBoolean1);
      paramBoolean2 = paramBoolean1;
      if (ys() == paramBoolean1) {
        break;
      }
      if (paramBoolean1)
      {
        setMode(0);
        return paramBoolean1;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (com.tencent.mm.compatible.util.l.wx()) && (2 != q.dyn.dwX))
      {
        setMode(3);
        return paramBoolean1;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        setMode(3);
        return paramBoolean1;
      }
      setMode(2);
      return paramBoolean1;
      label982:
      i = 2;
    }
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    if (this.dui != null) {
      return this.dui.getStreamMaxVolume(paramInt);
    }
    return 5;
  }
  
  public final int getStreamVolume(int paramInt)
  {
    if (this.dui != null) {
      return this.dui.getStreamVolume(paramInt);
    }
    return -1;
  }
  
  public final void gp(int paramInt)
  {
    y.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.duj) });
    Iterator localIterator = this.dup.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ew(paramInt);
    }
  }
  
  public final void gq(int paramInt)
  {
    if (this.dui != null) {
      this.dui.adjustStreamVolume(paramInt, 1, 5);
    }
  }
  
  public final void gr(int paramInt)
  {
    if (this.dui != null) {
      this.dui.adjustStreamVolume(paramInt, -1, 5);
    }
  }
  
  public final void setMode(int paramInt)
  {
    if (this.dui != null)
    {
      y.i("MicroMsg.MMAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.dui.getMode()), Integer.valueOf(paramInt) });
      this.dui.setMode(paramInt);
    }
  }
  
  public final void setSpeakerphoneOn(boolean paramBoolean)
  {
    y.l("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + paramBoolean, new Object[0]);
    if (this.dui != null)
    {
      y.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + paramBoolean);
      this.dui.setSpeakerphoneOn(paramBoolean);
    }
  }
  
  public final void yj()
  {
    y.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", new Object[] { yr() });
    dul = false;
    gp(2);
  }
  
  public final int yk()
  {
    int i = 1;
    this.duj = -1;
    if (!yq())
    {
      i = -1;
      return i;
    }
    y.l("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", new Object[] { yr() });
    AudioManager localAudioManager = this.dui;
    boolean bool;
    if (!localAudioManager.isBluetoothScoAvailableOffCall()) {
      bool = false;
    }
    for (;;)
    {
      y.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { yr(), Boolean.valueOf(bool) });
      y.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + yr() + " ret:" + bool);
      bool = yn();
      y.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      return 0;
      if (at.uc())
      {
        bool = false;
      }
      else
      {
        y.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", new Object[] { Integer.valueOf(q.dyn.dwN) });
        if (((q.dyn.dwN == 1) || (q.dyn.dwN == -1)) && (!localAudioManager.isBluetoothScoOn()))
        {
          y.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bk.csb() });
          localAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
  }
  
  public final void yl()
  {
    dul = false;
    y.l("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", new Object[] { yr() });
    com.tencent.mm.compatible.c.a.a(this.dui);
    this.dur.removeCallbacksAndMessages(Integer.valueOf(1));
    y.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", new Object[] { yr() });
  }
  
  public final boolean yn()
  {
    boolean bool = false;
    y.i("MicroMsg.MMAudioManager", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isScoConnected: %s, isBluetoothCanUse: %s, isACLConnected: %s", new Object[] { Boolean.valueOf(this.dui.isBluetoothScoOn()), Boolean.valueOf(this.dui.isBluetoothA2dpOn()), Boolean.valueOf(dul), Boolean.valueOf(yq()), Boolean.valueOf(duk) });
    if ((this.dui.isBluetoothScoOn()) || (this.dui.isBluetoothA2dpOn()) || (dul)) {
      bool = true;
    }
    return bool;
  }
  
  public final String yr()
  {
    if (this.dui != null) {}
    for (int i = this.dui.getMode();; i = 0) {
      return "mode:" + i + " isSpeakerphoneOn:" + this.dui.isSpeakerphoneOn() + " isBluetoothOn:" + yn() + " btStatus:" + this.duj;
    }
  }
  
  public final boolean ys()
  {
    return this.dui.getMode() == 0;
  }
  
  public final boolean yt()
  {
    boolean bool;
    if (this.dui != null)
    {
      bool = this.dui.isWiredHeadsetOn();
      if ((!bool) && (d.gF(23)))
      {
        if ((this.dui != null) && (d.gF(23)))
        {
          AudioDeviceInfo[] arrayOfAudioDeviceInfo = this.dui.getDevices(3);
          int j = arrayOfAudioDeviceInfo.length;
          int i = 0;
          while (i < j)
          {
            AudioDeviceInfo localAudioDeviceInfo = arrayOfAudioDeviceInfo[i];
            y.i("MicroMsg.MMAudioManager", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localAudioDeviceInfo.getType()) });
            if ((localAudioDeviceInfo.getType() == 4) || (localAudioDeviceInfo.getType() == 3) || (localAudioDeviceInfo.getType() == 11)) {
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
    }
    else
    {
      return false;
    }
    return bool;
  }
  
  public final void yu()
  {
    if (this.dui != null) {
      this.dui.setStreamMute(3, true);
    }
  }
  
  public final void yv()
  {
    if (this.dui != null) {
      this.dui.setStreamMute(3, false);
    }
  }
  
  @Deprecated
  public final void yx()
  {
    Object localObject2;
    if (this.dui != null)
    {
      Object localObject1 = com.tencent.mm.compatible.e.l.yP().gz(98305);
      localObject2 = com.tencent.mm.compatible.e.l.yP().gz(94209);
      if (localObject1 != null)
      {
        y.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + localObject1);
        setSpeakerphoneOn(((Boolean)localObject1).booleanValue());
        com.tencent.mm.compatible.e.l.yP().set(98305, null);
      }
      if (localObject2 == null) {}
    }
    try
    {
      y.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + localObject2 + ",inmode:0");
      i = bk.getInt(String.valueOf(localObject2), 0);
      if ((i >= -1) && (i < 4))
      {
        setMode(i);
        com.tencent.mm.compatible.e.l.yP().set(94209, null);
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
  
  public final int yy()
  {
    int i = this.duo;
    this.duo = 0;
    return i;
  }
  
  public final int yz()
  {
    if (this.dus == -1) {}
    try
    {
      Field localField = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
      if ((localField != null) && (this.dui != null)) {
        this.dus = localField.getInt(this.dui);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + localException.getMessage());
        this.dus = 6;
      }
    }
    return this.dus;
  }
  
  public static abstract interface a
  {
    public abstract void ew(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.f
 * JD-Core Version:    0.7.0.1
 */