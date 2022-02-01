package androidx.media;

import android.media.AudioAttributes;
import android.support.v4.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplApi21Parcelizer
{
  public static AudioAttributesImplApi21 read(a parama)
  {
    AppMethodBeat.i(107786);
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21();
    localAudioAttributesImplApi21.mAudioAttributes = ((AudioAttributes)parama.a(localAudioAttributesImplApi21.mAudioAttributes, 1));
    localAudioAttributesImplApi21.mLegacyStreamType = parama.aS(localAudioAttributesImplApi21.mLegacyStreamType, 2);
    AppMethodBeat.o(107786);
    return localAudioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, a parama)
  {
    AppMethodBeat.i(107787);
    parama.writeParcelable(paramAudioAttributesImplApi21.mAudioAttributes, 1);
    parama.aR(paramAudioAttributesImplApi21.mLegacyStreamType, 2);
    AppMethodBeat.o(107787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.media.AudioAttributesImplApi21Parcelizer
 * JD-Core Version:    0.7.0.1
 */