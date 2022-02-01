package com.tencent.mm.plugin.audio.b;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Stack;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", "index", "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a
{
  public static final a.a nrH = new a.a((byte)0);
  public AudioManager audioManager;
  private boolean fVJ;
  public boolean fVK;
  public int fVN;
  private int nrB = -1;
  private int nrC = -1;
  protected ArrayList<String> nrD = new ArrayList();
  private Stack<Integer> nrE;
  public d.g.a.b<? super Boolean, z> nrF;
  protected boolean nrG;
  
  public a()
  {
    Object localObject = aj.getContext().getSystemService("audio");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.media.AudioManager");
    }
    this.audioManager = ((AudioManager)localObject);
    this.nrE = new Stack();
  }
  
  public static boolean bGA()
  {
    com.tencent.mm.plugin.audio.d.a.bGM();
    c.bGM();
    Object localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (!com.tencent.mm.plugin.audio.d.a.bGL()) {
      localObject = c.nsa;
    }
    return c.bGL();
  }
  
  public static void bGu()
  {
    com.tencent.mm.plugin.audio.d.a.bGM();
    c.bGM();
  }
  
  private void ir(boolean paramBoolean)
  {
    this.nrG = paramBoolean;
    d.g.a.b localb = this.nrF;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(paramBoolean));
    }
  }
  
  private final int v(boolean paramBoolean, int paramInt)
  {
    ad.m("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    int i = -1;
    Object localObject;
    Integer localInteger;
    if ((!this.nrE.isEmpty()) && (this.nrE.size() > 1))
    {
      localObject = (Integer)this.nrE.get(this.nrE.size() - 1);
      localInteger = (Integer)this.nrE.lastElement();
      if (paramBoolean) {
        if (localObject == null)
        {
          p.g(localObject, "prevDevice");
          xj(((Integer)localObject).intValue());
          label107:
          paramInt = xk(paramInt);
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
        xj(paramInt);
        if (localInteger == null) {
          p.g(localInteger, "nextDevice");
        }
        for (paramInt = xk(localInteger.intValue());; paramInt = -1)
        {
          return paramInt;
          if (paramInt != localInteger.intValue()) {
            break;
          }
        }
        if (paramBoolean) {
          return xk(paramInt);
        }
        xj(paramInt);
        switch (paramInt)
        {
        default: 
          return -1;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.nrY;
        if (!com.tencent.mm.plugin.audio.d.a.bGG()) {
          break label230;
        }
        localObject = com.tencent.mm.plugin.audio.d.a.nrY;
        paramInt = i;
      } while (com.tencent.mm.plugin.audio.d.a.bGL());
      localObject = c.nsa;
      paramInt = i;
    } while (c.f(this.audioManager));
    bGv();
    return -1;
  }
  
  private final void xj(int paramInt)
  {
    ad.m("MicroMsg.BaseAudioManager", "close prev audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 4: 
      this.fVK = false;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      com.tencent.mm.plugin.audio.d.a.iy(false);
      com.tencent.mm.plugin.audio.d.a.c(this.audioManager);
      return;
    case 3: 
      localObject = c.nsa;
      c.iy(false);
      return;
    }
    this.audioManager.setSpeakerphoneOn(false);
  }
  
  private final int xk(int paramInt)
  {
    boolean bool2 = true;
    int i = 1;
    ad.m("MicroMsg.BaseAudioManager", "start current audio playing device %s", new Object[] { Integer.valueOf(paramInt) });
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
      } while (this.fVK);
      paramInt = com.tencent.mm.plugin.audio.d.a.b(this.audioManager);
      h.LTJ.aZz("delayConnectBluetooth");
      if (paramInt == 1)
      {
        bool1 = true;
        this.fVK = bool1;
        localObject = com.tencent.mm.plugin.audio.d.a.nrY;
        if (paramInt != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.mm.plugin.audio.d.a.iy(bool1);
        return paramInt;
        bool1 = false;
        break;
      }
      this.audioManager.setSpeakerphoneOn(false);
      return -1;
      if (this.nrE.contains(Integer.valueOf(4))) {
        xj(4);
      }
      Object localObject = c.nsa;
      c.iy(true);
      return -1;
      this.audioManager.setSpeakerphoneOn(true);
    }
  }
  
  public static boolean xn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    case 4: 
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      return com.tencent.mm.plugin.audio.d.a.bGL();
    }
    Object localObject = c.nsa;
    return c.bGL();
  }
  
  public final void VJ(String paramString)
  {
    p.h(paramString, "type");
    ad.m("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(paramString)), new Object[0]);
    if ((this.nrD.contains(paramString)) && (this.nrE.contains(Integer.valueOf(4)))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        it(false);
      }
      this.nrE.clear();
      this.nrD.remove(paramString);
      return;
    }
  }
  
  public final int b(String paramString, Integer paramInteger)
  {
    p.h(paramString, "type");
    ad.m("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + paramString + " adn target device " + paramInteger, new Object[0]);
    com.tencent.mm.plugin.audio.d.a.bGM();
    c.bGM();
    if (this.nrD.contains(paramString)) {
      this.nrD.remove(paramString);
    }
    this.nrD.add(paramString);
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
      return it(true);
      if (paramInteger.intValue() != 3) {
        break label86;
      }
      iu(true);
      return -1;
      if (paramInteger.intValue() != 2) {
        break label90;
      }
      bGv();
      return -1;
    }
    label139:
    cn(true);
    return -1;
  }
  
  public final void b(final int paramInt, final d.g.a.a<z> parama)
  {
    ad.m("MicroMsg.BaseAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(paramInt) });
    if ((this.nrC == -1) || (this.nrC != paramInt)) {
      h.LTJ.f((Runnable)new c(this, paramInt, parama), "reset speaker");
    }
    this.nrC = paramInt;
  }
  
  public final String bGB()
  {
    int i = this.audioManager.getMode();
    StringBuilder localStringBuilder = new StringBuilder("mode:").append(i).append(" isSpeakerphoneOn:").append(isSpeakerphoneOn()).append(" isBluetoothOn:");
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nrY;
    return com.tencent.mm.plugin.audio.d.a.bGD();
  }
  
  public final void bGv()
  {
    if (com.tencent.mm.plugin.audio.d.b.c(this.nrE))
    {
      xj(1);
      v(true, 2);
    }
  }
  
  public final void bGw()
  {
    ad.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
    b(0, null);
  }
  
  public final boolean bGx()
  {
    c localc = c.nsa;
    return c.f(this.audioManager);
  }
  
  public final int bGy()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nrY;
    return com.tencent.mm.plugin.audio.d.a.d(this.audioManager);
  }
  
  public final int bGz()
  {
    if (this.nrE.empty()) {
      return -1;
    }
    Object localObject = this.nrE.lastElement();
    p.g(localObject, "mDeviceQueue.lastElement()");
    return ((Number)localObject).intValue();
  }
  
  public void cn(boolean paramBoolean)
  {
    ad.m("MicroMsg.BaseAudioManager", "request speaker on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramBoolean = d.f(this.nrE);
      ad.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + isSpeakerphoneOn() + " and ret is " + paramBoolean);
      v(true, 1);
      return;
    }
    d.g(this.nrE);
    z localz = z.MKo;
    v(false, 1);
  }
  
  public final void eD(int paramInt1, int paramInt2)
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
  
  public void hC(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onAudioDeviceStateChanged mstatus is ").append(paramInt).append(" and  mCurrentAudioDeviceState = status ");
    boolean bool;
    if (this.nrB == paramInt)
    {
      bool = true;
      ad.i("MicroMsg.BaseAudioManager", bool);
      if (this.nrB != paramInt) {
        break label58;
      }
    }
    label58:
    while ((this.nrD.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
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
      this.fVJ = true;
      h.LTJ.a((Runnable)new b(this), 1000L, "delayConnectBluetooth");
      return;
    case 1: 
    case 6: 
    case 7: 
      this.fVJ = false;
      it(false);
      return;
    case 2: 
      ir(true);
      it(true);
      return;
    case 3: 
      it(false);
      return;
    case 8: 
      iu(true);
      return;
    }
    iu(false);
  }
  
  public abstract boolean iq(boolean paramBoolean);
  
  public final void is(boolean paramBoolean)
  {
    this.audioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  public final boolean isBluetoothScoOn()
  {
    com.tencent.mm.plugin.audio.d.a locala = com.tencent.mm.plugin.audio.d.a.nrY;
    return com.tencent.mm.plugin.audio.d.a.e(this.audioManager);
  }
  
  public final boolean isSpeakerphoneOn()
  {
    d locald = d.nsb;
    return d.g(this.audioManager);
  }
  
  public final int it(boolean paramBoolean)
  {
    int i = -1;
    ad.m("MicroMsg.BaseAudioManager", "request bluetooth on value %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (com.tencent.mm.plugin.audio.d.a.a(this.nrE))
      {
        i = v(true, 4);
        if (i != -1)
        {
          paramBoolean = true;
          ir(paramBoolean);
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", new Object[] { Integer.valueOf(i) });
      return i;
      paramBoolean = false;
      break;
      ir(false);
      continue;
      ir(false);
      com.tencent.mm.plugin.audio.d.a.b(this.nrE);
      z localz = z.MKo;
      v(false, 4);
    }
  }
  
  public final void iu(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (c.d(this.nrE)) {
        v(true, 3);
      }
      return;
    }
    c.e(this.nrE);
    z localz = z.MKo;
    v(false, 3);
  }
  
  public final void xl(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, 1);
  }
  
  public final void xm(int paramInt)
  {
    com.tencent.mm.compatible.b.a.a(this.audioManager, paramInt, -1);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(199743);
      ad.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
      com.tencent.mm.plugin.audio.d.a.b(this.nrI.audioManager);
      AppMethodBeat.o(199743);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, d.g.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(199744);
      this.nrI.audioManager.setMode(paramInt);
      d.g.a.a locala = parama;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(199744);
        return;
      }
      AppMethodBeat.o(199744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a
 * JD-Core Version:    0.7.0.1
 */