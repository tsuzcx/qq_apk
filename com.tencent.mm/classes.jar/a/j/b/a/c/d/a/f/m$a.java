package a.j.b.a.c.d.a.f;

import a.f.a.b;
import a.f.b.j;
import a.o;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class m$a
{
  final String className;
  
  public m$a(String paramString)
  {
    AppMethodBeat.i(120185);
    this.className = localObject;
    AppMethodBeat.o(120185);
  }
  
  public final void c(String paramString, b<? super m.a.a, y> paramb)
  {
    AppMethodBeat.i(120184);
    j.q(paramString, "name");
    j.q(paramb, "block");
    Map localMap = this.Ciq.Cip;
    paramString = new m.a.a(this, paramString);
    paramb.S(paramString);
    paramString = paramString.egN();
    localMap.put(paramString.first, paramString.second);
    AppMethodBeat.o(120184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.m.a
 * JD-Core Version:    0.7.0.1
 */