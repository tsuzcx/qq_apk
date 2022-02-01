package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"})
public final class d
{
  private static boolean oIk;
  public static final d oIq;
  
  static
  {
    AppMethodBeat.i(224030);
    oIq = new d();
    AppMethodBeat.o(224030);
  }
  
  public static boolean ces()
  {
    return oIk;
  }
  
  public static final void cet()
  {
    AppMethodBeat.i(224026);
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    oIk = a.a.cea().cdW();
    AppMethodBeat.o(224026);
  }
  
  public static final boolean d(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224027);
    p.h(paramStack, "mDeviceQueue");
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
      AppMethodBeat.o(224027);
      return true;
    }
    AppMethodBeat.o(224027);
    return false;
  }
  
  public static final void e(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224028);
    p.h(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
    paramStack.removeElement(Integer.valueOf(3));
    AppMethodBeat.o(224028);
  }
  
  public static boolean f(AudioManager paramAudioManager)
  {
    boolean bool2 = true;
    AppMethodBeat.i(224029);
    p.h(paramAudioManager, "audioManager");
    boolean bool1 = paramAudioManager.isWiredHeadsetOn();
    int i;
    if ((!bool1) && (com.tencent.mm.compatible.util.d.oD(23))) {
      if (com.tencent.mm.compatible.util.d.oD(23))
      {
        paramAudioManager = paramAudioManager.getDevices(3);
        int j = paramAudioManager.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramAudioManager[i];
          p.g(localObject, "deviceInfo");
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
      AppMethodBeat.o(224029);
      return bool1;
      label133:
      i += 1;
      break;
      bool1 = false;
    }
  }
  
  public static void jw(boolean paramBoolean)
  {
    oIk = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.d
 * JD-Core Version:    0.7.0.1
 */