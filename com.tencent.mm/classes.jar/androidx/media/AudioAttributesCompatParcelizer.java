package androidx.media;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(androidx.versionedparcelable.a parama)
  {
    AppMethodBeat.i(242707);
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.abI = ((a)parama.d(localAudioAttributesCompat.abI));
    AppMethodBeat.o(242707);
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, androidx.versionedparcelable.a parama)
  {
    AppMethodBeat.i(242708);
    parama.a(paramAudioAttributesCompat.abI);
    AppMethodBeat.o(242708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.media.AudioAttributesCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */