package a.j.b.a.c.h;

import a.f.b.j;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p$a
  extends p
{
  p$a()
  {
    super(str, 1);
  }
  
  public final String escape(String paramString)
  {
    AppMethodBeat.i(121912);
    j.q(paramString, "string");
    paramString = m.h(m.h(paramString, "<", "&lt;", false), ">", "&gt;", false);
    AppMethodBeat.o(121912);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.h.p.a
 * JD-Core Version:    0.7.0.1
 */