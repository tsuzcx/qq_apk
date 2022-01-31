package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements e
{
  private final String a;
  private int b;
  private Context c;
  private boolean d;
  private BroadcastReceiver e;
  private BluetoothProfile.ServiceListener f;
  private BluetoothHeadset g;
  private List<d> h;
  private Handler i;
  private boolean j;
  private int k;
  private boolean l;
  private com.tencent.liteav.basic.module.a m;
  private boolean n;
  private String o;
  private int p;
  private boolean q;
  private List<String> r;
  private List<String> s;
  private AudioManager t;
  
  static
  {
    AppMethodBeat.i(66583);
    com.tencent.liteav.basic.util.b.f();
    AppMethodBeat.o(66583);
  }
  
  private a()
  {
    AppMethodBeat.i(66570);
    this.a = ("AudioCenter:" + a.class.getSimpleName());
    this.b = 1;
    this.k = 0;
    this.m = null;
    this.n = false;
    this.p = 0;
    this.o = "18446744073709551615";
    this.m = new com.tencent.liteav.basic.module.a();
    this.m.setID(this.o);
    this.h = new ArrayList();
    b();
    AppMethodBeat.o(66570);
  }
  
  public static a a()
  {
    AppMethodBeat.i(66569);
    a locala = a.a.a();
    AppMethodBeat.o(66569);
    return locala;
  }
  
  private void a(Intent paramIntent)
  {
    AppMethodBeat.i(66572);
    int i1 = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
    TXCLog.i(this.a, "processAudioState state " + i1 + " (ps: 10--DISCONNECTED; 11--CONNECTING; 12--CONNECTED), thread id = " + Thread.currentThread().getId());
    if (i1 == 12)
    {
      TXCLog.i(this.a, "SCO connected, yeah!");
      this.b = 3;
      a(true, true);
      this.i.removeCallbacksAndMessages(null);
      this.t.setBluetoothScoOn(true);
      b(this.k);
      AppMethodBeat.o(66572);
      return;
    }
    if ((i1 != 11) && (i1 == 10))
    {
      this.b = 1;
      b(this.k);
      a(false, false);
      if (this.q)
      {
        TXCLog.i(this.a, "processAudioState, mNeedRestartScoWithHangUp");
        this.q = false;
        d();
      }
    }
    AppMethodBeat.o(66572);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(66568);
    TXCTraeJNI.nativeSetTraeConfig(paramString);
    AppMethodBeat.o(66568);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(146231);
        if (paramBoolean1 != true) {
          break label106;
        }
        if (!paramBoolean2)
        {
          this.m.setStatusValue(11005, Integer.valueOf(i1));
          TXCEventRecorderProxy.a("18446744073709551615", 1001, i1, -1, "", 0);
          Iterator localIterator = this.h.iterator();
          if (!localIterator.hasNext()) {
            break label98;
          }
          ((d)localIterator.next()).OnHeadsetState(paramBoolean1);
          continue;
        }
        i1 = 2;
      }
      finally {}
      continue;
      label98:
      AppMethodBeat.o(146231);
      return;
      label106:
      i1 = 0;
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(146227);
    this.r = new ArrayList();
    this.s = new ArrayList();
    this.r.add("HUAWEI");
    this.s.add("EVA-AL00");
    AppMethodBeat.o(146227);
  }
  
  private void b(Intent paramIntent)
  {
    AppMethodBeat.i(66573);
    if (paramIntent.hasExtra("state"))
    {
      int i1 = paramIntent.getIntExtra("state", 0);
      if (i1 == 0)
      {
        this.j = false;
        a(false, false);
        b(this.k);
        TXCLog.i(this.a, "pull out wired headset");
        AppMethodBeat.o(66573);
        return;
      }
      if (1 == i1)
      {
        this.j = true;
        a(true, false);
        b(this.k);
        TXCLog.i(this.a, "insert wired headset");
      }
    }
    AppMethodBeat.o(66573);
  }
  
  private boolean c()
  {
    AppMethodBeat.i(146228);
    String str1;
    if (Build.MANUFACTURER == null)
    {
      str1 = "";
      if (Build.MODEL != null) {
        break label105;
      }
    }
    label105:
    for (String str2 = "";; str2 = Build.MODEL)
    {
      if ((!this.r.contains(str1)) || (!this.s.contains(str2))) {
        break label112;
      }
      TXCLog.i(this.a, "manufacturer = " + str1 + ", model = " + str2 + " need MODE_NORMAL for BT Mic");
      AppMethodBeat.o(146228);
      return true;
      str1 = Build.MANUFACTURER;
      break;
    }
    label112:
    AppMethodBeat.o(146228);
    return false;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 290
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 115	com/tencent/liteav/audio/impl/a:g	Landroid/bluetooth/BluetoothHeadset;
    //   12: ifnonnull +12 -> 24
    //   15: ldc_w 290
    //   18: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 115	com/tencent/liteav/audio/impl/a:g	Landroid/bluetooth/BluetoothHeadset;
    //   28: invokevirtual 296	android/bluetooth/BluetoothHeadset:getConnectedDevices	()Ljava/util/List;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +12 -> 45
    //   36: aload_2
    //   37: invokeinterface 300 1 0
    //   42: ifne +55 -> 97
    //   45: aload_0
    //   46: getfield 83	com/tencent/liteav/audio/impl/a:a	Ljava/lang/String;
    //   49: ldc_w 302
    //   52: invokestatic 304	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc_w 290
    //   58: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: goto -40 -> 21
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    //   69: astore_2
    //   70: aload_0
    //   71: getfield 83	com/tencent/liteav/audio/impl/a:a	Ljava/lang/String;
    //   74: ldc_w 306
    //   77: aload_2
    //   78: invokestatic 311	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 304	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 115	com/tencent/liteav/audio/impl/a:g	Landroid/bluetooth/BluetoothHeadset;
    //   92: aconst_null
    //   93: astore_2
    //   94: goto -62 -> 32
    //   97: aload_2
    //   98: iconst_0
    //   99: invokeinterface 319 2 0
    //   104: checkcast 321	android/bluetooth/BluetoothDevice
    //   107: astore_2
    //   108: aload_0
    //   109: getfield 115	com/tencent/liteav/audio/impl/a:g	Landroid/bluetooth/BluetoothHeadset;
    //   112: aload_2
    //   113: invokevirtual 325	android/bluetooth/BluetoothHeadset:getConnectionState	(Landroid/bluetooth/BluetoothDevice;)I
    //   116: istore_1
    //   117: iload_1
    //   118: iconst_m1
    //   119: if_icmpne +35 -> 154
    //   122: ldc_w 290
    //   125: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: goto -107 -> 21
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 83	com/tencent/liteav/audio/impl/a:a	Ljava/lang/String;
    //   136: ldc_w 327
    //   139: aload_2
    //   140: invokestatic 311	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   143: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokestatic 304	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iconst_m1
    //   150: istore_1
    //   151: goto -34 -> 117
    //   154: aload_0
    //   155: iload_1
    //   156: invokespecial 188	com/tencent/liteav/audio/impl/a:d	(I)V
    //   159: ldc_w 290
    //   162: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: goto -144 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	a
    //   116	40	1	i1	int
    //   31	6	2	localList	List
    //   64	4	2	localObject	Object
    //   69	9	2	localException1	Exception
    //   93	20	2	localBluetoothDevice	android.bluetooth.BluetoothDevice
    //   131	9	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	21	64	finally
    //   24	32	64	finally
    //   36	45	64	finally
    //   45	61	64	finally
    //   70	92	64	finally
    //   97	108	64	finally
    //   108	117	64	finally
    //   122	128	64	finally
    //   132	149	64	finally
    //   154	165	64	finally
    //   24	32	69	java/lang/Exception
    //   108	117	131	java/lang/Exception
  }
  
  private void d(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(146230);
        switch (paramInt)
        {
        case 1: 
          AppMethodBeat.o(146230);
          return;
        }
      }
      finally {}
      if (!this.l)
      {
        TXCLog.w(this.a, "processBTHeadsetState connected, record is not running");
        AppMethodBeat.o(146230);
      }
      else if (this.b == 2)
      {
        TXCLog.w(this.a, "processBTHeadsetState connected, sco is connecting, ignore");
        AppMethodBeat.o(146230);
      }
      else
      {
        this.t.stopBluetoothSco();
        this.t.setBluetoothScoOn(false);
        if (!this.t.isBluetoothScoAvailableOffCall())
        {
          TXCLog.e(this.a, "checkBTHeadsetState connected, not support BTHeadset sco");
          AppMethodBeat.o(146230);
        }
        else
        {
          TXCLog.i(this.a, "processBTHeadsetState connected, delay to startBluetoothSco");
          this.b = 2;
          this.i.postDelayed(new a.3(this), 1000L);
          AppMethodBeat.o(146230);
          continue;
          this.t.stopBluetoothSco();
          this.t.setBluetoothScoOn(false);
          TXCLog.i(this.a, "processBTHeadsetState, disconnected");
          b(this.k);
          this.i.removeCallbacksAndMessages(null);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66575);
        if (this.t == null)
        {
          AppMethodBeat.o(66575);
          return;
        }
        if (this.b == 2)
        {
          AppMethodBeat.o(66575);
          continue;
        }
        if (!com.tencent.liteav.basic.e.b.a().g()) {
          break label101;
        }
      }
      finally {}
      TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 sys Aec Enable~");
      try
      {
        if (this.j)
        {
          if (this.t.getMode() == 0)
          {
            TXCLog.w(this.a, "setMode, mIsWiredHeadsetOn, audioMode is MODE_NORMAL, ignore");
            AppMethodBeat.o(66575);
            continue;
            label101:
            TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 TRAE don't setMode here~");
            AppMethodBeat.o(66575);
          }
          else
          {
            this.t.setMode(0);
            TXCLog.i(this.a, "setMode, is wiredHeadsetOn, set MODE_NORMA");
            AppMethodBeat.o(66575);
          }
        }
        else if ((this.g != null) && (this.b == 3) && (!c()))
        {
          if (this.t.getMode() == 3)
          {
            TXCLog.w(this.a, "setMode, bluetoothHeadset on, audioMode is MODE_IN_COMMUNICATION, ignore");
            AppMethodBeat.o(66575);
          }
          else
          {
            this.t.setMode(3);
            TXCLog.i(this.a, "setMode, bluetoothHeadset on, set mode MODE_IN_COMMUNICATION");
            AppMethodBeat.o(66575);
          }
        }
        else if (this.t.getMode() == 0)
        {
          TXCLog.w(this.a, "setMode, audioMode is MODE_NORMAL, ignore");
          AppMethodBeat.o(66575);
        }
        else
        {
          TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 michael setMode = ".concat(String.valueOf(paramInt)));
          TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 michael info don't change trae mode");
          this.t.setMode(paramInt);
          AppMethodBeat.o(66575);
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(66575);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(66571);
    if (this.d)
    {
      TXCLog.e(this.a, "init, but has inited, ignore!");
      AppMethodBeat.o(66571);
      return;
    }
    TXCLog.i(this.a, "init");
    if (this.c == null) {
      this.c = paramContext.getApplicationContext();
    }
    if (this.t == null) {
      this.t = ((AudioManager)paramContext.getSystemService("audio"));
    }
    if (this.i == null) {
      this.i = new Handler(Looper.getMainLooper());
    }
    this.t = ((AudioManager)paramContext.getSystemService("audio"));
    this.i = new Handler(Looper.getMainLooper());
    c.a().a(this.c);
    c.a().a(this);
    if (this.e == null) {
      this.e = new a.1(this);
    }
    if (this.f == null) {
      this.f = new a.2(this);
    }
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.HEADSET_PLUG");
    paramContext.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    paramContext.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    this.c.registerReceiver(this.e, paramContext);
    try
    {
      paramContext = BluetoothAdapter.getDefaultAdapter();
      if (paramContext != null) {
        paramContext.getProfileProxy(this.c, this.f, 1);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TXCLog.e(this.a, "BluetoothAdapter getProfileProxy: ".concat(String.valueOf(paramContext)));
      }
    }
    this.d = true;
    AppMethodBeat.o(66571);
  }
  
  public void a(d paramd)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66576);
        if (paramd == null)
        {
          AppMethodBeat.o(66576);
          return;
        }
        this.h.add(paramd);
        if (this.j)
        {
          paramd.OnHeadsetState(true);
          AppMethodBeat.o(66576);
          continue;
        }
        if (this.g == null) {
          break label98;
        }
      }
      finally {}
      if ((this.t != null) && (this.b == 3))
      {
        paramd.OnHeadsetState(true);
        AppMethodBeat.o(66576);
      }
      else
      {
        label98:
        AppMethodBeat.o(66576);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(66578);
    TXCLog.i(this.a, "setRecordRunning = ".concat(String.valueOf(paramBoolean)));
    this.l = paramBoolean;
    if (!this.l)
    {
      TXCLog.w(this.a, "processBTHeadsetState, record is not running");
      if ((this.b == 3) || (this.b == 2)) {
        this.i.postDelayed(new a.4(this), 1000L);
      }
      AppMethodBeat.o(66578);
      return;
    }
    d();
    AppMethodBeat.o(66578);
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66579);
        if (com.tencent.liteav.basic.e.b.a().g())
        {
          TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 sys AecEnable~");
          this.k = paramInt;
          a(0);
          if (this.j)
          {
            this.t.setSpeakerphoneOn(false);
            TXCLog.i(this.a, "setAudioRoute, is wiredHeadsetOn, set speakerphoneOn false");
            AppMethodBeat.o(66579);
          }
        }
        else
        {
          TXCLog.i(this.a, "【TXSDK-TRAE-LOG】 TRAE don't set Route here~");
          AppMethodBeat.o(66579);
          continue;
        }
        if (this.g == null) {
          break;
        }
      }
      finally {}
      if (this.b != 3) {
        break;
      }
      this.t.setSpeakerphoneOn(false);
      TXCLog.i(this.a, "setAudioRoute, is bluetoothHeadset connect and isBluetoothScoOn true, set speakerphoneOn false");
      AppMethodBeat.o(66579);
    }
    String str2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder("setAudioRoute, only phone, mSpeakerOn = ");
    if (this.k == 0) {}
    for (String str1 = "true";; str1 = "false")
    {
      TXCLog.i(str2, str1);
      if (this.k == 0)
      {
        this.t.setSpeakerphoneOn(true);
        AppMethodBeat.o(66579);
        break;
      }
      this.t.setSpeakerphoneOn(false);
      AppMethodBeat.o(66579);
      break;
    }
  }
  
  /* Error */
  public void b(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 509
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: ldc_w 509
    //   15: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 108	com/tencent/liteav/audio/impl/a:h	Ljava/util/List;
    //   25: aload_1
    //   26: invokeinterface 512 2 0
    //   31: pop
    //   32: ldc_w 509
    //   35: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: goto -20 -> 18
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	a
    //   0	46	1	paramd	d
    // Exception table:
    //   from	to	target	type
    //   2	8	41	finally
    //   12	18	41	finally
    //   21	38	41	finally
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(146232);
    TXCLog.i(this.a, "onCallStateChanged, state = ".concat(String.valueOf(paramInt)));
    if (!this.t.isBluetoothScoAvailableOffCall())
    {
      TXCLog.e(this.a, "not support BTHeadset sco");
      AppMethodBeat.o(146232);
      return;
    }
    if (paramInt == 0)
    {
      if ((this.b == 1) && (this.g != null))
      {
        this.p = 0;
        TXCLog.i(this.a, "to restartBluetoothSco");
        d();
        AppMethodBeat.o(146232);
        return;
      }
      if (this.p == 2) {
        this.q = true;
      }
      this.p = 0;
      AppMethodBeat.o(146232);
      return;
    }
    if (paramInt == 1)
    {
      this.p = 1;
      AppMethodBeat.o(146232);
      return;
    }
    if (paramInt == 2) {
      this.p = paramInt;
    }
    AppMethodBeat.o(146232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a
 * JD-Core Version:    0.7.0.1
 */