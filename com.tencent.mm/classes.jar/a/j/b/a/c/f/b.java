package a.j.b.a.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b CqD;
  public final c CqE;
  private transient b CqF;
  
  static
  {
    AppMethodBeat.i(121372);
    CqD = new b("");
    AppMethodBeat.o(121372);
  }
  
  public b(c paramc)
  {
    this.CqE = paramc;
  }
  
  private b(c paramc, b paramb)
  {
    this.CqE = paramc;
    this.CqF = paramb;
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(121363);
    this.CqE = new c(paramString, this);
    AppMethodBeat.o(121363);
  }
  
  public static b s(f paramf)
  {
    AppMethodBeat.i(121368);
    paramf = new b(c.u(paramf));
    AppMethodBeat.o(121368);
    return paramf;
  }
  
  public final b emd()
  {
    AppMethodBeat.i(121365);
    if (this.CqF != null)
    {
      localObject = this.CqF;
      AppMethodBeat.o(121365);
      return localObject;
    }
    if (isRoot())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(121365);
      throw ((Throwable)localObject);
    }
    this.CqF = new b(this.CqE.emg());
    Object localObject = this.CqF;
    AppMethodBeat.o(121365);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121370);
    if (this == paramObject)
    {
      AppMethodBeat.o(121370);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(121370);
      return false;
    }
    paramObject = (b)paramObject;
    if (!this.CqE.equals(paramObject.CqE))
    {
      AppMethodBeat.o(121370);
      return false;
    }
    AppMethodBeat.o(121370);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121371);
    int i = this.CqE.hashCode();
    AppMethodBeat.o(121371);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(156777);
    boolean bool = this.CqE.CqJ.isEmpty();
    AppMethodBeat.o(156777);
    return bool;
  }
  
  public final b q(f paramf)
  {
    AppMethodBeat.i(121366);
    paramf = new b(this.CqE.t(paramf), this);
    AppMethodBeat.o(121366);
    return paramf;
  }
  
  public final boolean r(f paramf)
  {
    AppMethodBeat.i(121367);
    boolean bool = this.CqE.r(paramf);
    AppMethodBeat.o(121367);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121369);
    String str = this.CqE.toString();
    AppMethodBeat.o(121369);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.f.b
 * JD-Core Version:    0.7.0.1
 */