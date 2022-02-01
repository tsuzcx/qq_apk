package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static boolean uVp;
  public static final d uVu;
  
  static
  {
    AppMethodBeat.i(263756);
    uVu = new d();
    AppMethodBeat.o(263756);
  }
  
  public static boolean cUp()
  {
    return uVp;
  }
  
  public static final void cUq()
  {
    AppMethodBeat.i(263724);
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    uVp = a.a.cTW().cTQ();
    AppMethodBeat.o(263724);
  }
  
  public static final boolean d(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(263732);
    s.u(paramStack, "mDeviceQueue");
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
      AppMethodBeat.o(263732);
      return true;
    }
    AppMethodBeat.o(263732);
    return false;
  }
  
  public static final void e(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(263740);
    s.u(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
    paramStack.removeElement(Integer.valueOf(3));
    AppMethodBeat.o(263740);
  }
  
  public static boolean f(AudioManager paramAudioManager)
  {
    boolean bool2 = true;
    AppMethodBeat.i(263751);
    s.u(paramAudioManager, "audioManager");
    boolean bool1 = paramAudioManager.isWiredHeadsetOn();
    if ((!bool1) && (com.tencent.mm.compatible.util.d.rb(23))) {
      if (com.tencent.mm.compatible.util.d.rb(23))
      {
        paramAudioManager = paramAudioManager.getDevices(3);
        s.s(paramAudioManager, "audioDevices");
        int j = paramAudioManager.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            Object localObject = paramAudioManager[i];
            i += 1;
            Log.i("MicroMsg.HeadSetPlugUtil", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localObject.getType()) });
            bool1 = bool2;
            if (localObject.getType() != 4)
            {
              bool1 = bool2;
              if (localObject.getType() != 3)
              {
                if (localObject.getType() != 11) {
                  continue;
                }
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(263751);
      return bool1;
      bool1 = false;
    }
  }
  
  public static void lU(boolean paramBoolean)
  {
    uVp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.d
 * JD-Core Version:    0.7.0.1
 */