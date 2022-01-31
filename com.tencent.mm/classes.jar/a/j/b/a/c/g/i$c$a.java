package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class i$c$a
{
  private final boolean CrA;
  private final Iterator<Map.Entry<i.e, Object>> Cry;
  private Map.Entry<i.e, Object> Crz;
  
  private i$c$a(i.c paramc)
  {
    AppMethodBeat.i(121522);
    paramc = i.c.b(this.CrB);
    if (paramc.Crs) {}
    for (paramc = new l.b(paramc.Crq.entrySet().iterator());; paramc = paramc.Crq.entrySet().iterator())
    {
      this.Cry = paramc;
      if (this.Cry.hasNext()) {
        this.Crz = ((Map.Entry)this.Cry.next());
      }
      this.CrA = false;
      AppMethodBeat.o(121522);
      return;
    }
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(121523);
    while ((this.Crz != null) && (((i.e)this.Crz.getKey()).number < paramInt))
    {
      i.e locale = (i.e)this.Crz.getKey();
      if ((this.CrA) && (locale.CrD.CsX == z.b.Cti) && (!locale.CrE)) {
        paramf.b(locale.number, (q)this.Crz.getValue());
      }
      for (;;)
      {
        if (!this.Cry.hasNext()) {
          break label139;
        }
        this.Crz = ((Map.Entry)this.Cry.next());
        break;
        h.a(locale, this.Crz.getValue(), paramf);
      }
      label139:
      this.Crz = null;
    }
    AppMethodBeat.o(121523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.g.i.c.a
 * JD-Core Version:    0.7.0.1
 */