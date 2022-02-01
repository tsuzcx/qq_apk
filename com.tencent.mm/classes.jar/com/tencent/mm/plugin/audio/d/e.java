package com.tencent.mm.plugin.audio.d;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/util/SpeakerUtil;", "", "()V", "TAG", "", "isSpeakerPhoneOn", "", "audioManager", "Landroid/media/AudioManager;", "releaseSpeakerResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestSpeakerResource", "plugin-audio_release"})
public final class e
{
  public static final e oIr;
  
  static
  {
    AppMethodBeat.i(224034);
    oIr = new e();
    AppMethodBeat.o(224034);
  }
  
  public static final boolean f(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224031);
    p.h(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.SpeakerUtil", " request the speaker resource");
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
        AppMethodBeat.o(224031);
        return true;
      } while (localInteger.intValue() == 1);
      break;
    }
    AppMethodBeat.o(224031);
    return false;
  }
  
  public static final void g(Stack<Integer> paramStack)
  {
    AppMethodBeat.i(224032);
    p.h(paramStack, "mDeviceQueue");
    Log.i("MicroMsg.SpeakerUtil", "release the speaker resource");
    paramStack.removeElement(Integer.valueOf(1));
    AppMethodBeat.o(224032);
  }
  
  public static boolean g(AudioManager paramAudioManager)
  {
    AppMethodBeat.i(224033);
    p.h(paramAudioManager, "audioManager");
    boolean bool = paramAudioManager.isSpeakerphoneOn();
    AppMethodBeat.o(224033);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.e
 * JD-Core Version:    0.7.0.1
 */