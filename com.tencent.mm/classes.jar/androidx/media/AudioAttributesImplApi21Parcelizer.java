package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AudioAttributesImplApi21Parcelizer
{
  public static b read(a parama)
  {
    AppMethodBeat.i(242718);
    b localb = new b();
    localb.abJ = ((AudioAttributes)parama.b(localb.abJ, 1));
    localb.abK = parama.aZ(localb.abK, 2);
    AppMethodBeat.o(242718);
    return localb;
  }
  
  public static void write(b paramb, a parama)
  {
    AppMethodBeat.i(242719);
    parama.a(paramb.abJ, 1);
    parama.aY(paramb.abK, 2);
    AppMethodBeat.o(242719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.AudioAttributesImplApi21Parcelizer
 * JD-Core Version:    0.7.0.1
 */