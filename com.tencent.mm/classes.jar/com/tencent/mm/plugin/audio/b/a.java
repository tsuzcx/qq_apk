package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Stack;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a nxa = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean fXP;
  public boolean fXQ;
  public int fXT;
  private int nwU = -1;
  private int nwV = -1;
  protected ArrayList<String> nwW = new ArrayList();
  private Stack<Integer> nwX;
  public d.g.a.b<? super Boolean, z> nwY;
  protected boolean nwZ;
  
  public a()
  {
    Object localObject = ak.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.nwX = new Stack();
  }
  
  public static void bHq()
  {
    com.tencent.mm.plugin.audio.d.a.bHI();
    c.bHI();
  }
  
  public static boolean bHw()
  {
    com.tencent.mm.plugin.audio.d.a.bHI();
    c.bHI();
    Object localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (!com.tencent.mm.plugin.audio.d.a.bHH()) {
      localObject = c.nxt;
    }
    return c.bHH();
  }
  
  private void ip(boolean paramBoolean)
  {
    this.nwZ = paramBoolean;
    d.g.a.b localb = this.nwY;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int w(boolean paramBoolean, int paramInt)
  {
    ae.m("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.nwX.isEmpty()) && (this.nwX.size() > 1))
    {
      localObject = (Integer)this.nwX.get(this.nwX.size() - 1);
      localInteger = (Integer)this.nwX.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          p.g(localObject, "prevDevice");
          xo(((Integer)localObject).intValue());
          label107:
          paramInt = xp(paramInt);
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
        xo(paramInt);
        if (localInteger == null) {
          p.g(localInteger, "nextDevice");
        }
        for (paramInt = xp(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return xp(paramInt);
        }
        xo(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.nxr;
        if (!com.tencent.mm.plugin.audio.d.a.bHC()) {
          break label230;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.nxr;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.a.bHH());
      localObject = c.nxt;
      paramInt = i;
    } while (c.f(this.audioManager));
    bHr();
    return -1;
  }
  
  private final void xo(int paramInt)
  {
    ae.m("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.fXQ = false;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      com.tencent.mm.plugin.audio.d.a.iw(false);
      com.tencent.mm.plugin.audio.d.a.c(this.audioManager);
      return;
    case 3: 
      localObject = c.nxt;
      c.iw(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int xp(int paramInt)
  {
    boolean bool2 = true;
    int i = 1;
    ae.m("MicroMsg.BaseAudioManager", "start current audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
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
      } while (this.fXQ);
      paramInt = com.tencent.mm.plugin.audio.d.a.b(this.audioManager);
      h.MqF.bbc("delayConnectBluetooth");
      if (paramInt == 1)
      {
        bool1 = true;
        this.fXQ = bool1;
        localObject = com.tencent.mm.plugin.audio.d.a.nxr;
        if (paramInt != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.a.iw(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      if (this.nwX.contains(Integer.valueOf(4))) {
        xo(4);
      }
      Object localObject = c.nxt;
      c.iw(true);
      return -1;
      this.audioManager.setSpeakerphoneOn(true);
    }
  }
  
  public static boolean xs(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      return com.tencent.mm.plugin.audio.d.a.bHH();
    }
    Object localObject = c.nxt;
    return c.bHH();
  }
  
  public final void Wv(String paramString)
  {
    p.h(paramString, "type");
    ae.m("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.nwW.contains(paramString)) && (this.nwX.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ir(false);
      }
      this.nwX.clear();
      this.nwW.remove(paramString);
      return;
    }
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    p.h(paramString, "type");
    ae.m("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.a.bHI();
    c.bHI();
    if (this.nwW.contains(paramString)) {
      this.nwW.remove(paramString);
    }
    this.nwW.add(paramString);
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
      return ir(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      is(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      bHr();
      return -1;
    }
    label139:
    cn(true);
    return -1;
  }
  
  public final void b(final int paramInt, final d.g.a.a<z> parama)
  {
    ae.m("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.nwV == -1) || (this.nwV != paramInt)) {
      h.MqF.f((Runnable)new c(this, paramInt, parama), "reset speaker");
    }
    this.nwV = paramInt;
  }
  
  public final void bHr()
  {
    if (com.tencent.mm.plugin.audio.d.b.c(this.nwX))
    {
      xo(1);
      w(true, 2);
    }
  }
  
  public final void bHs()
  {
    ae.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean bHt()
  {
    c localc = c.nxt;
    return c.f(this.audioManager);
  }
  
  public final int bHu()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nxr;
    return com.tencent.mm.plugin.audio.d.a.d(this.audioManager);
  }
  
  public final int bHv()
  {
    if (this.nwX.empty()) {
      return -1;
    }
    Object localObject = this.nwX.lastElement();
    p.g(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public final String bHx()
  {
    int i = this.audioManager.getMode();
    StringBuilder localStringBuilder = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(isSpeakerphoneOn()).append(" isBluetoothOn:");
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nxr;
    return com.tencent.mm.plugin.audio.d.a.bHz();
  }
  
  public void cn(boolean paramBoolean)
  {
    ae.m("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramBoolean = d.f(this.nwX);
      ae.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + isSpeakerphoneOn() + " and ret is " + paramBoolean);
      w(true, 1);
      return;
    }
    d.g(this.nwX);
    z localz = z.Nhr;
    w(false, 1);
  }
  
  public final void eD(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0) });
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
  
  public void hE(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.nwU == paramInt)
    {
      bool = true;
      ae.i("MicroMsg.BaseAudioManager", bool);
      if (this.nwU != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.nwW.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
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
      this.fXP = true;
      h.MqF.a((Runnable)new b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.fXP = false;
      ir(false);
      return;
    case 2: 
      ip(true);
      ir(true);
      return;
    case 3: 
      ir(false);
      return;
    case 8: 
      is(true);
      return;
    }
    is(false);
  }
  
  public abstract boolean io(boolean paramBoolean);
  
  public final void iq(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final int ir(boolean paramBoolean)
  {
    int i = -1;
    ae.m("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.a.a(this.nwX))
      {
        i = w(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          ip(paramBoolean);
        }
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      ip(false);
      continue;
      ip(false);
      com.tencent.mm.plugin.audio.d.a.b(this.nwX);
      z localz = z.Nhr;
      w(false, 4);
    }
  }
  
  public final void is(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (c.d(this.nwX)) {
        w(true, 3);
      }
      return;
    }
    c.e(this.nwX);
    z localz = z.Nhr;
    w(false, 3);
  }
  
  public final boolean isBluetoothScoOn()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nxr;
    return com.tencent.mm.plugin.audio.d.a.e(this.audioManager);
  }
  
  public final boolean isSpeakerphoneOn()
  {
    d locald = d.nxu;
    return d.g(this.audioManager);
  }
  
  public final void xq(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void xr(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(201055);
      ae.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
      com.tencent.mm.plugin.audio.d.a.b(this.nxb.audioManager);
      AppMethodBeat.o(201055);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, d.g.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(201056);
      this.nxb.audioManager.setMode(paramInt);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(201056);
        return;
      }
      AppMethodBeat.o(201056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */