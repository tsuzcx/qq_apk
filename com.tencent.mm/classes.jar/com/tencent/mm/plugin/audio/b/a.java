package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.audio.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a rJJ = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean jnb;
  public boolean jnc;
  public int jnf;
  private int rJD = -1;
  private int rJE = -1;
  private ArrayList<String> rJF = new ArrayList();
  private Stack<Integer> rJG;
  private kotlin.g.a.b<? super Boolean, x> rJH;
  private boolean rJI;
  
  public a()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.rJG = new Stack();
  }
  
  private final int B(boolean paramBoolean, int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.rJG.isEmpty()) && (this.rJG.size() > 1))
    {
      localObject = (Integer)this.rJG.get(this.rJG.size() - 1);
      localInteger = (Integer)this.rJG.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          p.j(localObject, "prevDevice");
          Ev(((Integer)localObject).intValue());
          label106:
          paramInt = Ew(paramInt);
        }
      }
    }
    label230:
    do
    {
      do
      {
        return paramInt;
        if (((Integer)localObject).intValue() == paramInt) {
          break label106;
        }
        break;
        Ev(paramInt);
        if (localInteger == null) {
          p.j(localInteger, "nextDevice");
        }
        for (paramInt = Ew(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return Ew(paramInt);
        }
        Ev(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        if (!com.tencent.mm.plugin.audio.d.b.crr()) {
          break label230;
        }
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.b.crF());
      localObject = d.rKg;
      paramInt = i;
    } while (d.f(this.audioManager));
    crf();
    return -1;
  }
  
  private final void Ev(int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.jnc = false;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      com.tencent.mm.plugin.audio.d.b.kH(false);
      com.tencent.mm.plugin.audio.d.b.c(this.audioManager);
      h.ZvG.bDh("delayConnectBluetooth");
      return;
    case 3: 
      localObject = d.rKg;
      d.kH(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int Ew(int paramInt)
  {
    boolean bool2 = true;
    int i = 1;
    Log.printInfoStack("MicroMsg.BaseAudioManager", "start current audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramInt = -1;
      do
      {
        return paramInt;
        paramInt = i;
      } while (this.jnc);
      h.ZvG.bDh("delayConnectBluetooth");
      paramInt = com.tencent.mm.plugin.audio.d.b.b(this.audioManager);
      if (paramInt == 1)
      {
        bool1 = true;
        this.jnc = bool1;
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        if (paramInt != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.b.kH(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      if (this.rJG.contains(Integer.valueOf(4))) {
        Ev(4);
      }
      Object localObject = d.rKg;
      d.kH(true);
      return -1;
      this.audioManager.setSpeakerphoneOn(true);
    }
  }
  
  public static boolean Ez(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      return com.tencent.mm.plugin.audio.d.b.crF();
    }
    Object localObject = d.rKg;
    return d.crF();
  }
  
  public static void cre()
  {
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
  }
  
  public static boolean crk()
  {
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    Object localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (!com.tencent.mm.plugin.audio.d.b.crF()) {
      localObject = d.rKg;
    }
    return d.crF();
  }
  
  private void kB(boolean paramBoolean)
  {
    this.rJI = paramBoolean;
    kotlin.g.a.b localb = this.rJH;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
  }
  
  public final void B(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.rJH = paramb;
  }
  
  public final void Ex(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void Ey(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  public final void anT(String paramString)
  {
    p.k(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.rJF.contains(paramString)) && (this.rJG.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        kD(false);
      }
      this.rJG.clear();
      this.rJF.remove(paramString);
      return;
    }
  }
  
  public final boolean anU(String paramString)
  {
    p.k(paramString, "type");
    Iterator localIterator = ((Iterable)this.rJF).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h((String)localObject, paramString));
    for (paramString = localObject; paramString != null; paramString = null) {
      return true;
    }
    return false;
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    p.k(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    if (this.rJF.contains(paramString)) {
      this.rJF.remove(paramString);
    }
    this.rJF.add(paramString);
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label110;
      }
      label86:
      if (paramInteger != null) {
        break label125;
      }
      label90:
      if (paramInteger != null) {
        break label139;
      }
    }
    label110:
    label125:
    while (paramInteger.intValue() != 1)
    {
      return -1;
      if (paramInteger.intValue() != 4) {
        break;
      }
      return kD(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      kE(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      crf();
      return -1;
    }
    label139:
    ds(true);
    return -1;
  }
  
  public final void b(final int paramInt, final kotlin.g.a.a<x> parama)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.rJE == -1) || (this.rJE != paramInt)) {
      h.ZvG.d((Runnable)new c(this, paramInt, parama), "reset speaker");
    }
    this.rJE = paramInt;
  }
  
  public final ArrayList<String> crc()
  {
    return this.rJF;
  }
  
  protected final boolean crd()
  {
    return this.rJI;
  }
  
  public final void crf()
  {
    if (c.c(this.rJG))
    {
      Ev(1);
      B(true, 2);
    }
  }
  
  public final void crg()
  {
    Log.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean crh()
  {
    d locald = d.rKg;
    return d.f(this.audioManager);
  }
  
  public final int cri()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.rKe;
    return com.tencent.mm.plugin.audio.d.b.d(this.audioManager);
  }
  
  public final int crj()
  {
    if (this.rJG.empty()) {
      return -1;
    }
    Object localObject = this.rJG.lastElement();
    p.j(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public final boolean crl()
  {
    e locale = e.rKh;
    return e.g(this.audioManager);
  }
  
  public final boolean crm()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.rKe;
    return com.tencent.mm.plugin.audio.d.b.e(this.audioManager);
  }
  
  public void ds(boolean paramBoolean)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramBoolean = e.f(this.rJG);
      Log.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + crl() + " and ret is " + paramBoolean);
      B(true, 1);
      return;
    }
    e.g(this.rJG);
    x localx = x.aazN;
    B(false, 1);
  }
  
  public final void fp(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt1, paramInt2, 0);
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.audioManager.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.audioManager.getStreamVolume(paramInt);
  }
  
  public abstract boolean kA(boolean paramBoolean);
  
  public final void kC(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int kD(boolean paramBoolean)
  {
    int i = -1;
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.b.a(this.rJG))
      {
        i = B(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          kB(paramBoolean);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      kB(false);
      continue;
      kB(false);
      com.tencent.mm.plugin.audio.d.b.b(this.rJG);
      x localx = x.aazN;
      B(false, 4);
    }
  }
  
  public final void kE(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (d.d(this.rJG)) {
        B(true, 3);
      }
      return;
    }
    d.e(this.rJG);
    x localx = x.aazN;
    B(false, 3);
  }
  
  public void ko(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.rJD == paramInt)
    {
      bool = true;
      Log.i("MicroMsg.BaseAudioManager", bool);
      if (this.rJD != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.rJF.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      return;
      bool = false;
      break;
    }
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 5: 
      this.jnb = true;
      h.ZvG.a((Runnable)new b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.jnb = false;
      kD(false);
      return;
    case 2: 
      kB(true);
      kD(true);
      return;
    case 3: 
      h.ZvG.bDh("delayConnectBluetooth");
      kD(false);
      return;
    case 8: 
      kE(true);
      return;
    }
    kE(false);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(257648);
      Log.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
      com.tencent.mm.plugin.audio.d.b.b(this.rJK.audioManager);
      AppMethodBeat.o(257648);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, kotlin.g.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(257592);
      this.rJK.audioManager.setMode(paramInt);
      kotlin.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(257592);
        return;
      }
      AppMethodBeat.o(257592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */