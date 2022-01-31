package a.j.b.a.c.m;

import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;

public final class d
{
  public final f BYN;
  public final k CDl;
  public final Collection<f> CDm;
  public final a.f.a.b<t, String> CDn;
  public final b[] CDo;
  
  private d(f paramf, k paramk, Collection<f> paramCollection, a.f.a.b<? super t, String> paramb, b... paramVarArgs)
  {
    this.BYN = paramf;
    this.CDl = paramk;
    this.CDm = paramCollection;
    this.CDn = paramb;
    this.CDo = paramVarArgs;
  }
  
  public d(f paramf, b[] paramArrayOfb, a.f.a.b<? super t, String> paramb)
  {
    this(paramf, null, null, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(122858);
    AppMethodBeat.o(122858);
  }
  
  private d(k paramk, b[] paramArrayOfb, a.f.a.b<? super t, String> paramb)
  {
    this(null, paramk, null, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(122860);
    AppMethodBeat.o(122860);
  }
  
  public d(Collection<f> paramCollection, b[] paramArrayOfb, a.f.a.b<? super t, String> paramb)
  {
    this(null, null, paramCollection, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(122862);
    AppMethodBeat.o(122862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.m.d
 * JD-Core Version:    0.7.0.1
 */