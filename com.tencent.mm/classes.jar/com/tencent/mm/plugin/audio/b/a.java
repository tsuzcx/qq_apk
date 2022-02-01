package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.audio.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayer", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a uUV = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean lQm;
  private boolean lQn;
  public int lQq;
  private int uUW = -1;
  private int uUX = -1;
  private ArrayList<String> uUY = new ArrayList();
  private Stack<Integer> uUZ;
  private kotlin.g.a.b<? super Boolean, ah> uVa;
  private boolean uVb;
  
  public a()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.uUZ = new Stack();
  }
  
  private final void EW(int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.lQn = false;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      com.tencent.mm.plugin.audio.d.b.lU(false);
      com.tencent.mm.plugin.audio.d.b.c(this.audioManager);
      h.ahAA.bFQ("delayConnectBluetooth");
      return;
    case 3: 
      localObject = d.uVu;
      d.lU(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int EX(int paramInt)
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
      } while (this.lQn);
      h.ahAA.bFQ("delayConnectBluetooth");
      paramInt = com.tencent.mm.plugin.audio.d.b.b(this.audioManager);
      if (paramInt == 1)
      {
        bool1 = true;
        this.lQn = bool1;
        this.audioManager.setSpeakerphoneOn(false);
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        if (paramInt != 1) {
          break label132;
        }
      }
      label132:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.b.lU(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      if (this.uUZ.contains(Integer.valueOf(4))) {
        EW(4);
      }
      Object localObject = d.uVu;
      d.lU(true);
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      this.audioManager.setSpeakerphoneOn(true);
    }
  }
  
  public static boolean Fa(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      return com.tencent.mm.plugin.audio.d.b.cUp();
    }
    Object localObject = d.uVu;
    return d.cUp();
  }
  
  private static final void a(a parama)
  {
    s.u(parama, "this$0");
    Log.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
    com.tencent.mm.plugin.audio.d.b.b(parama.audioManager);
  }
  
  private static final void a(a parama, int paramInt, kotlin.g.a.a parama1)
  {
    s.u(parama, "this$0");
    parama.audioManager.setMode(paramInt);
    if (parama1 != null) {
      parama1.invoke();
    }
  }
  
  public static void cTN()
  {
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
  }
  
  public static boolean cTT()
  {
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    Object localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (!com.tencent.mm.plugin.audio.d.b.cUp()) {
      localObject = d.uVu;
    }
    return d.cUp();
  }
  
  private void lO(boolean paramBoolean)
  {
    this.uVb = paramBoolean;
    kotlin.g.a.b localb = this.uVa;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int z(boolean paramBoolean, int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    Object localObject;
    if ((!this.uUZ.isEmpty()) && (this.uUZ.size() > 1))
    {
      localObject = (Integer)this.uUZ.get(this.uUZ.size() - 1);
      Integer localInteger = (Integer)this.uUZ.lastElement();
      if (paramBoolean)
      {
        if (localObject == null) {}
        for (;;)
        {
          s.s(localObject, "prevDevice");
          EW(((Integer)localObject).intValue());
          do
          {
            return EX(paramInt);
          } while (((Integer)localObject).intValue() == paramInt);
        }
      }
      EW(paramInt);
      if (localInteger == null) {}
      while (paramInt != localInteger.intValue())
      {
        s.s(localInteger, "nextDevice");
        return EX(localInteger.intValue());
      }
    }
    for (;;)
    {
      return -1;
      if (paramBoolean) {
        return EX(paramInt);
      }
      EW(paramInt);
      if (paramInt == 1)
      {
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        if (com.tencent.mm.plugin.audio.d.b.cUa())
        {
          localObject = com.tencent.mm.plugin.audio.d.b.uVo;
          if (com.tencent.mm.plugin.audio.d.b.cUp()) {}
        }
        else
        {
          localObject = d.uVu;
          if (!d.f(this.audioManager)) {
            cTO();
          }
        }
      }
    }
  }
  
  public final void EY(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void EZ(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  public final void ad(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.uVa = paramb;
  }
  
  public final void ahq(String paramString)
  {
    s.u(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", s.X("releaseAudioPlayingOrRecordingResource type ", paramString), new Object[0]);
    if ((this.uUY.contains(paramString)) && (this.uUZ.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        lQ(false);
      }
      this.uUZ.clear();
      this.uUY.remove(paramString);
      return;
    }
  }
  
  public final boolean ahr(String paramString)
  {
    s.u(paramString, "type");
    Iterator localIterator = ((Iterable)this.uUY).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p((String)localObject, paramString));
    for (paramString = localObject; paramString != null; paramString = null) {
      return true;
    }
    return false;
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    s.u(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    if (this.uUY.contains(paramString)) {
      this.uUY.remove(paramString);
    }
    this.uUY.add(paramString);
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
      return lQ(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      lR(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      cTO();
      return -1;
    }
    label139:
    ee(true);
    return -1;
  }
  
  public final void b(int paramInt, kotlin.g.a.a<ah> parama)
  {
    if ((this.uUX == -1) || (this.uUX != paramInt)) {
      h.ahAA.g(new a..ExternalSyntheticLambda1(this, paramInt, parama), "reset speaker");
    }
    this.uUX = paramInt;
  }
  
  public final void bLg()
  {
    this.audioManager.setStreamMute(3, true);
  }
  
  public final void bLh()
  {
    this.audioManager.setStreamMute(3, false);
  }
  
  public final ArrayList<String> cTJ()
  {
    return this.uUY;
  }
  
  protected final boolean cTK()
  {
    return this.lQn;
  }
  
  protected final boolean cTL()
  {
    return this.uVb;
  }
  
  public final void cTM()
  {
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    if (this.uUY.contains("voip")) {
      this.uUY.remove("voip");
    }
    this.uUY.add("voip");
  }
  
  public final void cTO()
  {
    if (c.c(this.uUZ))
    {
      EW(1);
      z(true, 2);
    }
  }
  
  public final void cTP()
  {
    Log.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean cTQ()
  {
    d locald = d.uVu;
    return d.f(this.audioManager);
  }
  
  public final int cTR()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.uVo;
    return com.tencent.mm.plugin.audio.d.b.d(this.audioManager);
  }
  
  public final int cTS()
  {
    if (this.uUZ.empty()) {
      return -1;
    }
    Object localObject = this.uUZ.lastElement();
    s.s(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public final boolean cTU()
  {
    e locale = e.uVv;
    return e.g(this.audioManager);
  }
  
  public final boolean cTV()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.uVo;
    return com.tencent.mm.plugin.audio.d.b.e(this.audioManager);
  }
  
  public void ee(boolean paramBoolean)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramBoolean = e.f(this.uUZ);
      Log.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + cTU() + " and ret is " + paramBoolean);
      z(true, 1);
      return;
    }
    e.g(this.uUZ);
    ah localah = ah.aiuX;
    z(false, 1);
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.audioManager.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.audioManager.getStreamVolume(paramInt);
  }
  
  public final void gi(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt1, paramInt2, 0);
  }
  
  public abstract boolean lN(boolean paramBoolean);
  
  public final void lP(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int lQ(boolean paramBoolean)
  {
    int i = -1;
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.b.a(this.uUZ))
      {
        i = z(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          lO(paramBoolean);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      lO(false);
      continue;
      lO(false);
      com.tencent.mm.plugin.audio.d.b.b(this.uUZ);
      ah localah = ah.aiuX;
      z(false, 4);
    }
  }
  
  public final void lR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (d.d(this.uUZ)) {
        z(true, 3);
      }
      return;
    }
    d.e(this.uUZ);
    ah localah = ah.aiuX;
    z(false, 3);
  }
  
  public final int lS(boolean paramBoolean)
  {
    int i;
    if ((this.audioManager.isBluetoothScoOn()) || (this.lQn))
    {
      i = 1;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int j = 3;; j = 0)
    {
      if (i == 0) {
        return j;
      }
      return 0;
      i = 0;
      break;
    }
    return j;
  }
  
  public void nW(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.uUW == paramInt)
    {
      bool = true;
      Log.i("MicroMsg.BaseAudioManager", bool);
      if (this.uUW != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.uUY.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
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
      this.lQm = true;
      h.ahAA.a(new a..ExternalSyntheticLambda0(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.lQm = false;
      lQ(false);
      return;
    case 2: 
      lO(true);
      lQ(true);
      return;
    case 3: 
      h.ahAA.bFQ("delayConnectBluetooth");
      lQ(false);
      return;
    case 8: 
      lR(true);
      return;
    }
    lR(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */