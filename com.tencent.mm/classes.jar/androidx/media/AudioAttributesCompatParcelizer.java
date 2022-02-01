package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(a parama)
  {
    AppMethodBeat.i(107784);
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.mImpl = ((AudioAttributesImpl)parama.d(localAudioAttributesCompat.mImpl));
    AppMethodBeat.o(107784);
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, a parama)
  {
    AppMethodBeat.i(107785);
    parama.a(paramAudioAttributesCompat.mImpl);
    AppMethodBeat.o(107785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.AudioAttributesCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */