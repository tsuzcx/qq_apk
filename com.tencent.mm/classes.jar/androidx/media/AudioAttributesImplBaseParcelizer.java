package androidx.media;

import android.support.v4.media.AudioAttributesImplBase;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplBaseParcelizer
{
  public static AudioAttributesImplBase read(a parama)
  {
    AppMethodBeat.i(107788);
    AudioAttributesImplBase localAudioAttributesImplBase = new AudioAttributesImplBase();
    localAudioAttributesImplBase.mUsage = parama.aN(localAudioAttributesImplBase.mUsage, 1);
    localAudioAttributesImplBase.mContentType = parama.aN(localAudioAttributesImplBase.mContentType, 2);
    localAudioAttributesImplBase.mFlags = parama.aN(localAudioAttributesImplBase.mFlags, 3);
    localAudioAttributesImplBase.mLegacyStream = parama.aN(localAudioAttributesImplBase.mLegacyStream, 4);
    AppMethodBeat.o(107788);
    return localAudioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, a parama)
  {
    AppMethodBeat.i(107789);
    parama.aM(paramAudioAttributesImplBase.mUsage, 1);
    parama.aM(paramAudioAttributesImplBase.mContentType, 2);
    parama.aM(paramAudioAttributesImplBase.mFlags, 3);
    parama.aM(paramAudioAttributesImplBase.mLegacyStream, 4);
    AppMethodBeat.o(107789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBaseParcelizer
 * JD-Core Version:    0.7.0.1
 */