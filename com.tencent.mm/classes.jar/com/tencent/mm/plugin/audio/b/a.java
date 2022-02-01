package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Stack;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a mRi = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean fCv;
  public boolean fCw;
  public int fCz;
  private int mRc = -1;
  private int mRd = -1;
  protected ArrayList<String> mRe = new ArrayList();
  private Stack<Integer> mRf;
  public d.g.a.b<? super Boolean, y> mRg;
  protected boolean mRh;
  
  public a()
  {
    Object localObject = ai.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.mRf = new Stack();
  }
  
  public static void bCp()
  {
    com.tencent.mm.plugin.audio.d.a.bCE();
    c.bCE();
  }
  
  public static boolean bCv()
  {
    com.tencent.mm.plugin.audio.d.a.bCE();
    c.bCE();
    Object localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (!com.tencent.mm.plugin.audio.d.a.bCD()) {
      localObject = c.mRB;
    }
    return c.bCD();
  }
  
  private void ii(boolean paramBoolean)
  {
    this.mRh = paramBoolean;
    d.g.a.b localb = this.mRg;
    if (localb != null) {
      localb.ay(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int w(boolean paramBoolean, int paramInt)
  {
    ac.m("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.mRf.isEmpty()) && (this.mRf.size() > 1))
    {
      localObject = (Integer)this.mRf.get(this.mRf.size() - 1);
      localInteger = (Integer)this.mRf.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          k.g(localObject, "prevDevice");
          wD(((Integer)localObject).intValue());
          label107:
          paramInt = wE(paramInt);
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
          break label107;
        }
        break;
        wD(paramInt);
        if (localInteger == null) {
          k.g(localInteger, "nextDevice");
        }
        for (paramInt = wE(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return wE(paramInt);
        }
        wD(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.mRz;
        if (!com.tencent.mm.plugin.audio.d.a.bCA()) {
          break label230;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.mRz;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.a.bCD());
      localObject = c.mRB;
      paramInt = i;
    } while (c.e(this.audioManager));
    bCq();
    return -1;
  }
  
  private final void wD(int paramInt)
  {
    ac.m("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.fCw = false;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      com.tencent.mm.plugin.audio.d.a.ip(false);
      com.tencent.mm.plugin.audio.d.a.b(this.audioManager);
      return;
    case 3: 
      localObject = c.mRB;
      c.ip(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int wE(int paramInt)
  {
    boolean bool2 = true;
    ac.m("MicroMsg.BaseAudioManager", "start current audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 4: 
      do
      {
        return -1;
      } while (this.fCw);
      paramInt = com.tencent.mm.plugin.audio.d.a.a(this.audioManager);
      h.JZN.aTz("delayConnectBluetooth");
      if (paramInt == 1)
      {
        bool1 = true;
        this.fCw = bool1;
        localObject = com.tencent.mm.plugin.audio.d.a.mRz;
        if (paramInt != 1) {
          break label116;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.a.ip(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
    case 2: 
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
    case 3: 
      label116:
      if (this.mRf.contains(Integer.valueOf(4))) {
        wD(4);
      }
      localObject = c.mRB;
      c.ip(true);
      return -1;
    }
    this.audioManager.setSpeakerphoneOn(true);
    return -1;
  }
  
  public static boolean wH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      return com.tencent.mm.plugin.audio.d.a.bCD();
    }
    Object localObject = c.mRB;
    return c.bCD();
  }
  
  public final void Sl(String paramString)
  {
    k.h(paramString, "type");
    ac.m("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.mRe.contains(paramString)) && (this.mRf.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ik(false);
      }
      this.mRf.clear();
      this.mRe.remove(paramString);
      return;
    }
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    k.h(paramString, "type");
    ac.m("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.a.bCE();
    c.bCE();
    if (this.mRe.contains(paramString)) {
      this.mRe.remove(paramString);
    }
    this.mRe.add(paramString);
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
      return ik(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      il(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      bCq();
      return -1;
    }
    label139:
    cm(true);
    return -1;
  }
  
  public final void b(final int paramInt, final d.g.a.a<y> parama)
  {
    ac.m("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.mRd == -1) || (this.mRd != paramInt)) {
      h.JZN.f((Runnable)new c(this, paramInt, parama), "reset speaker");
    }
    this.mRd = paramInt;
  }
  
  public final void bCq()
  {
    if (com.tencent.mm.plugin.audio.d.b.c(this.mRf))
    {
      wD(1);
      w(true, 2);
    }
  }
  
  public final void bCr()
  {
    ac.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean bCs()
  {
    c localc = c.mRB;
    return c.e(this.audioManager);
  }
  
  public final int bCt()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mRz;
    return com.tencent.mm.plugin.audio.d.a.c(this.audioManager);
  }
  
  public final int bCu()
  {
    if (this.mRf.empty()) {
      return -1;
    }
    Object localObject = this.mRf.lastElement();
    k.g(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public final String bCw()
  {
    int i = this.audioManager.getMode();
    StringBuilder localStringBuilder = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(isSpeakerphoneOn()).append(" isBluetoothOn:");
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mRz;
    return com.tencent.mm.plugin.audio.d.a.bCy();
  }
  
  public void cm(boolean paramBoolean)
  {
    ac.m("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if ((d.f(this.mRf)) && (!isSpeakerphoneOn())) {
        w(true, 1);
      }
      return;
    }
    d.g(this.mRf);
    y localy = y.KTp;
    w(false, 1);
  }
  
  public final void eA(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
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
  
  public void hv(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.mRc == paramInt)
    {
      bool = true;
      ac.i("MicroMsg.BaseAudioManager", bool);
      if (this.mRc != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.mRe.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
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
      this.fCv = true;
      h.JZN.a((Runnable)new b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.fCv = false;
      ik(false);
      return;
    case 2: 
      ii(false);
      ik(true);
      return;
    case 3: 
      ik(false);
      return;
    case 8: 
      il(true);
      return;
    }
    il(false);
  }
  
  public abstract boolean ih(boolean paramBoolean);
  
  public final void ij(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int ik(boolean paramBoolean)
  {
    int i = -1;
    ac.m("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.a.a(this.mRf))
      {
        i = w(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          ii(paramBoolean);
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      ii(false);
      continue;
      ii(false);
      com.tencent.mm.plugin.audio.d.a.b(this.mRf);
      y localy = y.KTp;
      w(false, 4);
    }
  }
  
  public final void il(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (c.d(this.mRf)) {
        w(true, 3);
      }
      return;
    }
    c.e(this.mRf);
    y localy = y.KTp;
    w(false, 3);
  }
  
  public final boolean isBluetoothScoOn()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.mRz;
    return com.tencent.mm.plugin.audio.d.a.d(this.audioManager);
  }
  
  public final boolean isSpeakerphoneOn()
  {
    d locald = d.mRC;
    return d.f(this.audioManager);
  }
  
  public final void wF(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void wG(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(198345);
      ac.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
      com.tencent.mm.plugin.audio.d.a.a(this.mRj.audioManager);
      AppMethodBeat.o(198345);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, d.g.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(198346);
      this.mRj.audioManager.setMode(paramInt);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(198346);
        return;
      }
      AppMethodBeat.o(198346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */