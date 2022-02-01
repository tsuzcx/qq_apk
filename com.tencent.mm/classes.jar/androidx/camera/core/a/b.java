package androidx.camera.core.a;

import androidx.camera.core.af;
import androidx.camera.core.impl.a.g.a;
import androidx.camera.core.impl.bi;
import androidx.camera.core.impl.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements af
{
  private final l Qb;
  
  public b(l paraml)
  {
    this.Qb = paraml;
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(199192);
    this.Qb.a(parama);
    AppMethodBeat.o(199192);
  }
  
  public final long getTimestamp()
  {
    AppMethodBeat.i(199184);
    long l = this.Qb.getTimestamp();
    AppMethodBeat.o(199184);
    return l;
  }
  
  public final bi go()
  {
    AppMethodBeat.i(199179);
    bi localbi = this.Qb.go();
    AppMethodBeat.o(199179);
    return localbi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.b
 * JD-Core Version:    0.7.0.1
 */