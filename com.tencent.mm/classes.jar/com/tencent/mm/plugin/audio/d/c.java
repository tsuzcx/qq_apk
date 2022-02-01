package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Stack;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"})
public final class c
{
  public static final c mRB;
  private static boolean mRx;
  
  static
  {
    AppMethodBeat.i(198407);
    mRB = new c();
    AppMethodBeat.o(198407);
  }
  
  public static boolean bCD()
  {
    return mRx;
  }
  
  public static final void bCE()
  {
    AppMethodBeat.i(198403);
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    mRx = a.a.bCx().bCs();
    AppMethodBeat.o(198403);
  }
  
  public static final boolean d(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198404);
    k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.HeadSetPlugUtil", " request the headset resource");
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
      AppMethodBeat.o(198404);
      return true;
    }
    AppMethodBeat.o(198404);
    return false;
  }
  
  public static final void e(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198405);
    k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
    paramStack.removeElement(Integer.valueOf(3));
    AppMethodBeat.o(198405);
  }
  
  public static boolean e(AudioManager paramAudioManager)
  {
    boolean bool2 = true;
    AppMethodBeat.i(198406);
    k.h(paramAudioManager, "audioManager");
    boolean bool1 = paramAudioManager.isWiredHeadsetOn();
    int i;
    if ((!bool1) && (d.kZ(23))) {
      if (d.kZ(23))
      {
        paramAudioManager = paramAudioManager.getDevices(3);
        int j = paramAudioManager.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramAudioManager[i];
          k.g(localObject, "deviceInfo");
          ac.i("MicroMsg.HeadSetPlugUtil", "isWireHeadsetPluggedNew, deviceInfo type: %s", new Object[] { Integer.valueOf(localObject.getType()) });
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
      AppMethodBeat.o(198406);
      return bool1;
      label133:
      i += 1;
      break;
      bool1 = false;
    }
  }
  
  public static void ip(boolean paramBoolean)
  {
    mRx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.c
 * JD-Core Version:    0.7.0.1
 */