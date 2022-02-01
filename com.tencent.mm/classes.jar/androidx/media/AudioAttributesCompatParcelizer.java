package androidx.media;

import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(a parama)
  {
    AppMethodBeat.i(193018);
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.bJr = ((AudioAttributesImpl)parama.d(localAudioAttributesCompat.bJr));
    AppMethodBeat.o(193018);
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, a parama)
  {
    AppMethodBeat.i(193024);
    parama.a(paramAudioAttributesCompat.bJr);
    AppMethodBeat.o(193024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */