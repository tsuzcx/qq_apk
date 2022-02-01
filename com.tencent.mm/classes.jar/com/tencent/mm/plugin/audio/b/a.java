package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Stack;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a mph = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean fyO;
  public boolean fyP;
  public int fyS;
  private int mpb = -1;
  private int mpc = -1;
  protected ArrayList<String> mpd = new ArrayList();
  private Stack<Integer> mpe;
  public d.g.a.b<? super Boolean, y> mpf;
  protected boolean mpg;
  
  public a()
  {
    Object localObject = aj.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.mpe = new Stack();
  }
  
  public static void bvt()
  {
    com.tencent.mm.plugin.audio.d.a.bvI();
    c.bvI();
  }
  
  public static boolean bvz()
  {
    com.tencent.mm.plugin.audio.d.a.bvI();
    c.bvI();
    Object localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (!com.tencent.mm.plugin.audio.d.a.bvH()) {
      localObject = c.mpA;
    }
    return c.bvH();
  }
  
  private void hK(boolean paramBoolean)
  {
    this.mpg = paramBoolean;
    d.g.a.b localb = this.mpf;
    if (localb != null) {
      localb.aA(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int v(boolean paramBoolean, int paramInt)
  {
    ad.m("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.mpe.isEmpty()) && (this.mpe.size() > 1))
    {
      localObject = (Integer)this.mpe.get(this.mpe.size() - 1);
      localInteger = (Integer)this.mpe.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          k.g(localObject, "prevDevice");
          vM(((Integer)localObject).intValue());
          label106:
          paramInt = vN(paramInt);
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
        vM(paramInt);
        if (localInteger == null) {
          k.g(localInteger, "nextDevice");
        }
        for (paramInt = vN(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return vN(paramInt);
        }
        vM(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.mpy;
        if (!com.tencent.mm.plugin.audio.d.a.bvE()) {
          break label230;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.mpy;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.a.bvH());
      localObject = c.mpA;
      paramInt = i;
    } while (c.e(this.audioManager));
    bvu();
    return -1;
  }
  
  private final void vM(int paramInt)
  {
    ad.m("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.fyP = false;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      com.tencent.mm.plugin.audio.d.a.hP(false);
      com.tencent.mm.plugin.audio.d.a.b(this.audioManager);
      return;
    case 3: 
      localObject = c.mpA;
      c.hP(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int vN(int paramInt)
  {
    boolean bool2 = true;
    ad.m("MicroMsg.BaseAudioManager", "start current audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 4: 
      do
      {
        return -1;
      } while (this.fyP);
      paramInt = com.tencent.mm.plugin.audio.d.a.a(this.audioManager);
      h.Iye.aNW("delayConnectBluetooth");
      if (paramInt == 1)
      {
        bool1 = true;
        this.fyP = bool1;
        localObject = com.tencent.mm.plugin.audio.d.a.mpy;
        if (paramInt != 1) {
          break label116;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.a.hP(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
    case 2: 
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
    case 3: 
      label116:
      if (this.mpe.contains(Integer.valueOf(4))) {
        vM(4);
      }
      localObject = c.mpA;
      c.hP(true);
      return -1;
    }
    this.audioManager.setSpeakerphoneOn(true);
    return -1;
  }
  
  public static boolean vQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      return com.tencent.mm.plugin.audio.d.a.bvH();
    }
    Object localObject = c.mpA;
    return c.bvH();
  }
  
  public final void Oc(String paramString)
  {
    k.h(paramString, "type");
    ad.m("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.mpd.contains(paramString)) && (this.mpe.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        hM(false);
      }
      this.mpe.clear();
      this.mpd.remove(paramString);
      return;
    }
  }
  
  public final void a(int paramInt, d.g.a.a<y> parama)
  {
    ad.m("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.mpc == -1) || (this.mpc != paramInt)) {
      h.Iye.f((Runnable)new a.c(this, paramInt, parama), "reset speaker");
    }
    this.mpc = paramInt;
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    k.h(paramString, "type");
    ad.m("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.a.bvI();
    c.bvI();
    if (this.mpd.contains(paramString)) {
      this.mpd.remove(paramString);
    }
    this.mpd.add(paramString);
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
      return hM(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      hN(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      bvu();
      return -1;
    }
    label139:
    ck(true);
    return -1;
  }
  
  public final String bvA()
  {
    int i = this.audioManager.getMode();
    StringBuilder localStringBuilder = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(isSpeakerphoneOn()).append(" isBluetoothOn:");
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    return com.tencent.mm.plugin.audio.d.a.bvC();
  }
  
  public final void bvu()
  {
    if (com.tencent.mm.plugin.audio.d.b.c(this.mpe))
    {
      vM(1);
      v(true, 2);
    }
  }
  
  public final void bvv()
  {
    ad.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    a(0, null);
  }
  
  public final boolean bvw()
  {
    c localc = c.mpA;
    return c.e(this.audioManager);
  }
  
  public final int bvx()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    return com.tencent.mm.plugin.audio.d.a.c(this.audioManager);
  }
  
  public final int bvy()
  {
    if (this.mpe.empty()) {
      return -1;
    }
    Object localObject = this.mpe.lastElement();
    k.g(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public void ck(boolean paramBoolean)
  {
    ad.m("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if ((d.f(this.mpe)) && (!isSpeakerphoneOn())) {
        v(true, 1);
      }
      return;
    }
    d.g(this.mpe);
    y localy = y.JfV;
    v(false, 1);
  }
  
  public final void ex(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    com.tencent.mm.compatible.b.a.b(this.audioManager, paramInt1, paramInt2);
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    return this.audioManager.getStreamMaxVolume(paramInt);
  }
  
  public final int getStreamVolume(int paramInt)
  {
    return this.audioManager.getStreamVolume(paramInt);
  }
  
  public abstract boolean hJ(boolean paramBoolean);
  
  public void hL(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.mpb == paramInt)
    {
      bool = true;
      ad.i("MicroMsg.BaseAudioManager", bool);
      if (this.mpb != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.mpd.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      return;
      bool = false;
      break;
    }
    localStringBuilder = new StringBuilder("isBluetoothOn ");
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    ad.i("MicroMsg.BaseAudioManager", com.tencent.mm.plugin.audio.d.a.bvC() + " and isBluetoothScoOn " + isBluetoothScoOn() + 65289);
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 5: 
      this.fyO = true;
      h.Iye.a((Runnable)new a.b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.fyO = false;
      hM(false);
      return;
    case 2: 
      hK(false);
      hM(true);
      return;
    case 3: 
      hM(false);
      return;
    case 8: 
      hN(true);
      return;
    }
    hN(false);
  }
  
  public final void hL(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int hM(boolean paramBoolean)
  {
    ad.m("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    int i = -1;
    if (paramBoolean)
    {
      hK(true);
      if (com.tencent.mm.plugin.audio.d.a.a(this.mpe)) {
        i = v(true, 4);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      hK(false);
      com.tencent.mm.plugin.audio.d.a.b(this.mpe);
      y localy = y.JfV;
      v(false, 4);
    }
  }
  
  public final void hN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (c.d(this.mpe)) {
        v(true, 3);
      }
      return;
    }
    c.e(this.mpe);
    y localy = y.JfV;
    v(false, 3);
  }
  
  public final boolean isBluetoothScoOn()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mpy;
    return com.tencent.mm.plugin.audio.d.a.d(this.audioManager);
  }
  
  public final boolean isSpeakerphoneOn()
  {
    d locald = d.mpB;
    return d.f(this.audioManager);
  }
  
  public final void vO(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void vP(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */