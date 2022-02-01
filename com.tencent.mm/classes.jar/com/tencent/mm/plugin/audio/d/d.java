package com.tencent.mm.plugin.audio.d;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Stack;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/util/SpeakerUtil;", "", "()V", "TAG", "", "isSpeakerPhoneOn", "", "audioManager", "Landroid/media/AudioManager;", "releaseSpeakerResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestSpeakerResource", "plugin-audio_release"})
public final class d
{
  public static final d mRC;
  
  static
  {
    AppMethodBeat.i(198411);
    mRC = new d();
    AppMethodBeat.o(198411);
  }
  
  public static boolean f(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(198410);
    k.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isSpeakerphoneOn();
    AppMethodBeat.o(198410);
    return bool;
  }
  
  public static final boolean f(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198408);
    k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.SpeakerUtil", " request the speaker resource");
    Integer localInteger;
    if (paramStack.size() == 1)
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {}
    }
    else if (!paramStack.isEmpty())
    {
      localInteger = (Integer)paramStack.lastElement();
      if (localInteger != null) {
        break label104;
      }
    }
    label104:
    while (localInteger.intValue() != 1)
    {
      do
      {
        if (paramStack.contains(Integer.valueOf(1))) {
          paramStack.removeElement(Integer.valueOf(1));
        }
        paramStack.push(Integer.valueOf(1));
        AppMethodBeat.o(198408);
        return true;
      } while (localInteger.intValue() == 1);
      break;
    }
    AppMethodBeat.o(198408);
    return false;
  }
  
  public static final void g(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(198409);
    k.h(paramStack, "mDeviceQueue");
    ac.i("MicroMsg.SpeakerUtil", "release the speaker resource");
    paramStack.removeElement(Integer.valueOf(1));
    AppMethodBeat.o(198409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.d
 * JD-Core Version:    0.7.0.1
 */