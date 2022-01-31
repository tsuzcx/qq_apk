package a.f.b;

import a.j.d;
import a.j.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends s
{
  private final d BNm;
  private final String name;
  private final String signature;
  
  public t(d paramd, String paramString1, String paramString2)
  {
    this.BNm = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final String dyz()
  {
    return this.signature;
  }
  
  public final d ebe()
  {
    return this.BNm;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(55873);
    paramObject = ebj().X(new Object[] { paramObject });
    AppMethodBeat.o(55873);
    return paramObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.t
 * JD-Core Version:    0.7.0.1
 */