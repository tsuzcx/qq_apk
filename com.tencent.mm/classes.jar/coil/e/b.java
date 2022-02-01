package coil.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/decode/DataSource;", "", "(Ljava/lang/String;I)V", "MEMORY_CACHE", "MEMORY", "DISK", "NETWORK", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(187840);
    cmU = new b("MEMORY_CACHE", 0);
    cmV = new b("MEMORY", 1);
    cmW = new b("DISK", 2);
    cmX = new b("NETWORK", 3);
    cmY = new b[] { cmU, cmV, cmW, cmX };
    AppMethodBeat.o(187840);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.e.b
 * JD-Core Version:    0.7.0.1
 */