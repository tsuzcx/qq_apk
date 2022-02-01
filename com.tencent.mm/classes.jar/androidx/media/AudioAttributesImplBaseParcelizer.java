package androidx.media;

import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplBaseParcelizer
{
  public static AudioAttributesImplBase read(a parama)
  {
    AppMethodBeat.i(193068);
    AudioAttributesImplBase localAudioAttributesImplBase = new AudioAttributesImplBase();
    localAudioAttributesImplBase.bJu = parama.bT(localAudioAttributesImplBase.bJu, 1);
    localAudioAttributesImplBase.bJv = parama.bT(localAudioAttributesImplBase.bJv, 2);
    localAudioAttributesImplBase.cN = parama.bT(localAudioAttributesImplBase.cN, 3);
    localAudioAttributesImplBase.bJw = parama.bT(localAudioAttributesImplBase.bJw, 4);
    AppMethodBeat.o(193068);
    return localAudioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, a parama)
  {
    AppMethodBeat.i(193075);
    parama.bS(paramAudioAttributesImplBase.bJu, 1);
    parama.bS(paramAudioAttributesImplBase.bJv, 2);
    parama.bS(paramAudioAttributesImplBase.cN, 3);
    parama.bS(paramAudioAttributesImplBase.bJw, 4);
    AppMethodBeat.o(193075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBaseParcelizer
 * JD-Core Version:    0.7.0.1
 */