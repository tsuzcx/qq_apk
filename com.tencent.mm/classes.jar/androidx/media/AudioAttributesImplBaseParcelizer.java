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
    localAudioAttributesImplBase.mUsage = parama.aT(localAudioAttributesImplBase.mUsage, 1);
    localAudioAttributesImplBase.mContentType = parama.aT(localAudioAttributesImplBase.mContentType, 2);
    localAudioAttributesImplBase.mFlags = parama.aT(localAudioAttributesImplBase.mFlags, 3);
    localAudioAttributesImplBase.mLegacyStream = parama.aT(localAudioAttributesImplBase.mLegacyStream, 4);
    AppMethodBeat.o(107788);
    return localAudioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, a parama)
  {
    AppMethodBeat.i(107789);
    parama.aS(paramAudioAttributesImplBase.mUsage, 1);
    parama.aS(paramAudioAttributesImplBase.mContentType, 2);
    parama.aS(paramAudioAttributesImplBase.mFlags, 3);
    parama.aS(paramAudioAttributesImplBase.mLegacyStream, 4);
    AppMethodBeat.o(107789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBaseParcelizer
 * JD-Core Version:    0.7.0.1
 */