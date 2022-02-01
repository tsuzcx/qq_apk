package coil.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/request/CachePolicy;", "", "readEnabled", "", "writeEnabled", "(Ljava/lang/String;IZZ)V", "getReadEnabled", "()Z", "getWriteEnabled", "ENABLED", "READ_ONLY", "WRITE_ONLY", "DISABLED", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  public final boolean cpb;
  public final boolean cpc;
  
  static
  {
    AppMethodBeat.i(187941);
    cpd = new b("ENABLED", 0, true, true);
    cpe = new b("READ_ONLY", 1, true, false);
    cpf = new b("WRITE_ONLY", 2, false, true);
    cpg = new b("DISABLED", 3, false, false);
    cph = new b[] { cpd, cpe, cpf, cpg };
    AppMethodBeat.o(187941);
  }
  
  private b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cpb = paramBoolean1;
    this.cpc = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.j.b
 * JD-Core Version:    0.7.0.1
 */