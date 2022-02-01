package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.audio.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a oHT = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean gCV;
  public boolean gCW;
  public int gCZ;
  private int oHN = -1;
  private int oHO = -1;
  protected ArrayList<String> oHP = new ArrayList();
  private Stack<Integer> oHQ;
  public kotlin.g.a.b<? super Boolean, x> oHR;
  protected boolean oHS;
  
  public a()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.oHQ = new Stack();
  }
  
  private final void AU(int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.gCW = false;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      com.tencent.mm.plugin.audio.d.b.jw(false);
      com.tencent.mm.plugin.audio.d.b.c(this.audioManager);
      h.RTc.bqo("delayConnectBluetooth");
      return;
    case 3: 
      localObject = d.oIq;
      d.jw(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int AV(int paramInt)
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
      } while (this.gCW);
      h.RTc.bqo("delayConnectBluetooth");
      paramInt = com.tencent.mm.plugin.audio.d.b.b(this.audioManager);
      if (paramInt == 1)
      {
        bool1 = true;
        this.gCW = bool1;
        localObject = com.tencent.mm.plugin.audio.d.b.oIo;
        if (paramInt != 1) {
          break label124;
        }
      }
      label124:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.b.jw(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      if (this.oHQ.contains(Integer.valueOf(4))) {
        AU(4);
      }
      Object localObject = d.oIq;
      d.jw(true);
      return -1;
      this.audioManager.setSpeakerphoneOn(true);
    }
  }
  
  public static boolean AY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      return com.tencent.mm.plugin.audio.d.b.ces();
    }
    Object localObject = d.oIq;
    return d.ces();
  }
  
  public static void cdT()
  {
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
  }
  
  public static boolean cdZ()
  {
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    Object localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (!com.tencent.mm.plugin.audio.d.b.ces()) {
      localObject = d.oIq;
    }
    return d.ces();
  }
  
  private void jq(boolean paramBoolean)
  {
    this.oHS = paramBoolean;
    kotlin.g.a.b localb = this.oHR;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int w(boolean paramBoolean, int paramInt)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.oHQ.isEmpty()) && (this.oHQ.size() > 1))
    {
      localObject = (Integer)this.oHQ.get(this.oHQ.size() - 1);
      localInteger = (Integer)this.oHQ.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          p.g(localObject, "prevDevice");
          AU(((Integer)localObject).intValue());
          label108:
          paramInt = AV(paramInt);
        }
      }
    }
    label234:
    do
    {
      do
      {
        return paramInt;
        if (((Integer)localObject).intValue() == paramInt) {
          break label108;
        }
        break;
        AU(paramInt);
        if (localInteger == null) {
          p.g(localInteger, "nextDevice");
        }
        for (paramInt = AV(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return AV(paramInt);
        }
        AU(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.b.oIo;
        if (!com.tencent.mm.plugin.audio.d.b.cee()) {
          break label234;
        }
        localObject = com.tencent.mm.plugin.audio.d.b.oIo;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.b.ces());
      localObject = d.oIq;
      paramInt = i;
    } while (d.f(this.audioManager));
    cdU();
    return -1;
  }
  
  public final void AW(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void AX(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  public final void agq(String paramString)
  {
    p.h(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.oHP.contains(paramString)) && (this.oHQ.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        js(false);
      }
      this.oHQ.clear();
      this.oHP.remove(paramString);
      return;
    }
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    p.h(paramString, "type");
    Log.printInfoStack("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    if (this.oHP.contains(paramString)) {
      this.oHP.remove(paramString);
    }
    this.oHP.add(paramString);
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
      return js(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      jt(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      cdU();
      return -1;
    }
    label139:
    cV(true);
    return -1;
  }
  
  public final void b(final int paramInt, final kotlin.g.a.a<x> parama)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.oHO == -1) || (this.oHO != paramInt)) {
      h.RTc.b((Runnable)new c(this, paramInt, parama), "reset speaker");
    }
    this.oHO = paramInt;
  }
  
  public void cV(boolean paramBoolean)
  {
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramBoolean = e.f(this.oHQ);
      Log.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + isSpeakerphoneOn() + " and ret is " + paramBoolean);
      w(true, 1);
      return;
    }
    e.g(this.oHQ);
    x localx = x.SXb;
    w(false, 1);
  }
  
  public final void cdU()
  {
    if (c.c(this.oHQ))
    {
      AU(1);
      w(true, 2);
    }
  }
  
  public final void cdV()
  {
    Log.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean cdW()
  {
    d locald = d.oIq;
    return d.f(this.audioManager);
  }
  
  public final int cdX()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.oIo;
    return com.tencent.mm.plugin.audio.d.b.d(this.audioManager);
  }
  
  public final int cdY()
  {
    if (this.oHQ.empty()) {
      return -1;
    }
    Object localObject = this.oHQ.lastElement();
    p.g(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public final void eQ(int paramInt1, int paramInt2)
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
  
  public void iY(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.oHN == paramInt)
    {
      bool = true;
      Log.i("MicroMsg.BaseAudioManager", bool);
      if (this.oHN != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.oHP.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
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
      this.gCV = true;
      h.RTc.a((Runnable)new b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.gCV = false;
      js(false);
      return;
    case 2: 
      jq(true);
      js(true);
      return;
    case 3: 
      h.RTc.bqo("delayConnectBluetooth");
      js(false);
      return;
    case 8: 
      jt(true);
      return;
    }
    jt(false);
  }
  
  public final boolean isBluetoothScoOn()
  {
    com.tencent.mm.plugin.audio.d.b localb = com.tencent.mm.plugin.audio.d.b.oIo;
    return com.tencent.mm.plugin.audio.d.b.e(this.audioManager);
  }
  
  public final boolean isSpeakerphoneOn()
  {
    e locale = e.oIr;
    return e.g(this.audioManager);
  }
  
  public abstract boolean jp(boolean paramBoolean);
  
  public final void jr(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int js(boolean paramBoolean)
  {
    int i = -1;
    Log.printInfoStack("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.b.a(this.oHQ))
      {
        i = w(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          jq(paramBoolean);
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      jq(false);
      continue;
      jq(false);
      com.tencent.mm.plugin.audio.d.b.b(this.oHQ);
      x localx = x.SXb;
      w(false, 4);
    }
  }
  
  public final void jt(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (d.d(this.oHQ)) {
        w(true, 3);
      }
      return;
    }
    d.e(this.oHQ);
    x localx = x.SXb;
    w(false, 3);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(223952);
      Log.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
      com.tencent.mm.plugin.audio.d.b.b(this.oHU.audioManager);
      AppMethodBeat.o(223952);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, kotlin.g.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(223953);
      this.oHU.audioManager.setMode(paramInt);
      kotlin.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(223953);
        return;
      }
      AppMethodBeat.o(223953);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */