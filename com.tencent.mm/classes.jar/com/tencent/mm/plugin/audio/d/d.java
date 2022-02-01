package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"})
public final class d
{
  private static boolean rKa;
  public static final d rKg;
  
  static
  {
    AppMethodBeat.i(257618);
    rKg = new d();
    AppMethodBeat.o(257618);
  }
  
  public static boolean crF()
  {
    return rKa;
  }
  
  public static final void crG()
  {
    AppMethodBeat.i(257611);
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    rKa = a.a.crn().crh();
    AppMethodBeat.o(257611);
  }
  
  public static final boolean d(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(257613);
    p.k(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.HeadSetPlugUtil", " request the headset resource");
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
      AppMethodBeat.o(257613);
      return true;
    }
    AppMethodBeat.o(257613);
    return false;
  }
  
  public static final void e(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(257614);
    p.k(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
    paramStack.removeElement(Integer.valueOf(3));
    AppMethodBeat.o(257614);
  }
  
  public static boolean f(AudioManager paramAudioManager)
  {
    boolean bool2 = true;
    AppMethodBeat.i(257616);
    p.k(paramAudioManager, "audioManager");
    boolean bool1 = paramAudioManager.isWiredHeadsetOn();
    int i;
    if ((!bool1) && (com.tencent.mm.compatible.util.d.qV(23))) {
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        paramAudioManager = paramAudioManager.getDevices(3);
        int j = paramAudioManager.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramAudioManager[i];
          p.j(localObject, "deviceInfo");
          Log.i("MicroMsg.HeadSetPlugUtil", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localObject.getType()) });
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
      AppMethodBeat.o(257616);
      return bool1;
      label133:
      i += 1;
      break;
      bool1 = false;
    }
  }
  
  public static void kH(boolean paramBoolean)
  {
    rKa = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.d
 * JD-Core Version:    0.7.0.1
 */