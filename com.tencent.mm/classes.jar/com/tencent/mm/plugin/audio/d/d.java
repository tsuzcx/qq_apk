package com.tencent.mm.plugin.audio.d;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Stack;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/audio/util/SpeakerUtil;", "", "()V", "TAG", "", "isSpeakerPhoneOn", "", "audioManager", "Landroid/media/AudioManager;", "releaseSpeakerResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestSpeakerResource", "plugin-audio_release"})
public final class d
{
  public static final d nsb;
  
  static
  {
    AppMethodBeat.i(199814);
    nsb = new d();
    AppMethodBeat.o(199814);
  }
  
  public static final boolean f(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199811);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.SpeakerUtil", " request the speaker resource");
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
        AppMethodBeat.o(199811);
        return true;
      } while (localInteger.intValue() == 1);
      break;
    }
    AppMethodBeat.o(199811);
    return false;
  }
  
  public static final void g(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(199812);
    p.h(paramStack, "mDeviceQueue");
    ad.i("MicroMsg.SpeakerUtil", "release the speaker resource");
    paramStack.removeElement(Integer.valueOf(1));
    AppMethodBeat.o(199812);
  }
  
  public static boolean g(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(199813);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isSpeakerphoneOn();
    AppMethodBeat.o(199813);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.d
 * JD-Core Version:    0.7.0.1
 */