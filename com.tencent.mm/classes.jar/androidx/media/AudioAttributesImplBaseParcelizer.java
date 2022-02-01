package androidx.media;

import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplBaseParcelizer
{
  public static c read(a parama)
  {
    AppMethodBeat.i(242731);
    c localc = new c();
    localc.abL = parama.aZ(localc.abL, 1);
    localc.abM = parama.aZ(localc.abM, 2);
    localc.cN = parama.aZ(localc.cN, 3);
    localc.abN = parama.aZ(localc.abN, 4);
    AppMethodBeat.o(242731);
    return localc;
  }
  
  public static void write(c paramc, a parama)
  {
    AppMethodBeat.i(242733);
    parama.aY(paramc.abL, 1);
    parama.aY(paramc.abM, 2);
    parama.aY(paramc.cN, 3);
    parama.aY(paramc.abN, 4);
    AppMethodBeat.o(242733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBaseParcelizer
 * JD-Core Version:    0.7.0.1
 */