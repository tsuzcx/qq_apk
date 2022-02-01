package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplApi21Parcelizer
{
  public static AudioAttributesImplApi21 read(a parama)
  {
    AppMethodBeat.i(193001);
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21();
    localAudioAttributesImplApi21.bJs = ((AudioAttributes)parama.b(localAudioAttributesImplApi21.bJs, 1));
    localAudioAttributesImplApi21.bJt = parama.bT(localAudioAttributesImplApi21.bJt, 2);
    AppMethodBeat.o(193001);
    return localAudioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, a parama)
  {
    AppMethodBeat.i(193057);
    parama.a(paramAudioAttributesImplApi21.bJs, 1);
    parama.bS(paramAudioAttributesImplApi21.bJt, 2);
    AppMethodBeat.o(193057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesImplApi21Parcelizer
 * JD-Core Version:    0.7.0.1
 */