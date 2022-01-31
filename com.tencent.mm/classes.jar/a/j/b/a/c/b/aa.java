package a.j.b.a.c.b;

import a.f.b.j;
import a.j.b.a.c.f.a;
import a.j.b.a.c.k.c;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class aa
{
  final i BRT;
  final y BUv;
  final c<a.j.b.a.c.f.b, ab> BWv;
  private final c<aa.a, e> BWw;
  
  public aa(i parami, y paramy)
  {
    AppMethodBeat.i(119291);
    this.BRT = parami;
    this.BUv = paramy;
    this.BWv = this.BRT.i((a.f.a.b)new aa.d(this));
    this.BWw = this.BRT.i((a.f.a.b)new aa.c(this));
    AppMethodBeat.o(119291);
  }
  
  public final e a(a parama, List<Integer> paramList)
  {
    AppMethodBeat.i(119290);
    j.q(parama, "classId");
    j.q(paramList, "typeParametersCount");
    parama = (e)this.BWw.S(new aa.a(parama, paramList));
    AppMethodBeat.o(119290);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.b.aa
 * JD-Core Version:    0.7.0.1
 */