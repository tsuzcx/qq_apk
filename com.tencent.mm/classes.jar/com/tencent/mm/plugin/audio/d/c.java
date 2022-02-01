package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Stack;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"})
public final class c
{
  private static boolean nrW;
  public static final c nsa;
  
  static
  {
    AppMethodBeat.i(199810);
    nsa = new c();
    AppMethodBeat.o(199810);
  }
  
  public static boolean bGL()
  {
    return nrW;
  }
  
  public static final void bGM()
  {
    AppMethodBeat.i(199806);
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    nrW = a.a.bGC().bGx();
    AppMethodBeat.o(199806);
  }
  
  public static final boolean d(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199807);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.HeadSetPlugUtil", " request the headset resource");
    Integer localInteger;
    if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {
        break label73;
      }
    }
    label73:
    while (localInteger.intValue() != 3)
    {
      if (paramStack.contains(Integer.valueOf(3))) {
        paramStack.removeElement(Integer.valueOf(3));
      }
      paramStack.push(Integer.valueOf(3));
      AppMethodBeat.o(199807);
      return true;
    }
    AppMethodBeat.o(199807);
    return false;
  }
  
  public static final void e(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199808);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
    paramStack.removeElement(Integer.valueOf(3));
    AppMethodBeat.o(199808);
  }
  
  public static boolean f(AudioManager paramAudioManager)
  {
    boolean bool2 = true;
    AppMethodBeat.i(199809);
    p.h(paramAudioManager, "audioManager");
    boolean bool1 = paramAudioManager.isWiredHeadsetOn();
    int i;
    if ((!bool1) && (d.ly(23))) {
      if (d.ly(23))
      {
        paramAudioManager = paramAudioManager.getDevices(3);
        int j = paramAudioManager.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramAudioManager[i];
          p.g(localObject, "deviceInfo");
          ad.i("MicroMsg.HeadSetPlugUtil", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localObject.getType()) });
          bool1 = bool2;
          if (localObject.getType() != 4)
          {
            bool1 = bool2;
            if (localObject.getType() != 3)
            {
              if (localObject.getType() != 11) {
                break label133;
              }
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199809);
      return bool1;
      label133:
      i += 1;
      break;
      bool1 = false;
    }
  }
  
  public static void iy(boolean paramBoolean)
  {
    nrW = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.c
 * JD-Core Version:    0.7.0.1
 */