package coil.size;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/size/Precision;", "", "(Ljava/lang/String;I)V", "EXACT", "INEXACT", "AUTOMATIC", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(188232);
    cpT = new b("EXACT", 0);
    cpU = new b("INEXACT", 1);
    cpV = new b("AUTOMATIC", 2);
    cpW = new b[] { cpT, cpU, cpV };
    AppMethodBeat.o(188232);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.size.b
 * JD-Core Version:    0.7.0.1
 */