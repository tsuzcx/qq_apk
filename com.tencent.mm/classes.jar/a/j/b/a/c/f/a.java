package a.j.b.a.c.f;

import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final b BUK;
  public final b CqB;
  public final boolean CqC;
  
  static
  {
    AppMethodBeat.i(121362);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(121362);
      return;
    }
  }
  
  public a(b paramb1, b paramb2, boolean paramBoolean)
  {
    AppMethodBeat.i(121349);
    this.BUK = paramb1;
    if ((!$assertionsDisabled) && (paramb2.CqE.CqJ.isEmpty()))
    {
      paramb2 = new StringBuilder("Class name must not be root: ").append(paramb1);
      if (paramBoolean) {}
      for (paramb1 = " (local)";; paramb1 = "")
      {
        paramb1 = new AssertionError(paramb1);
        AppMethodBeat.o(121349);
        throw paramb1;
      }
    }
    this.CqB = paramb2;
    this.CqC = paramBoolean;
    AppMethodBeat.o(121349);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.s(paramf), false);
    AppMethodBeat.i(121350);
    AppMethodBeat.o(121350);
  }
  
  public static a ayS(String paramString)
  {
    AppMethodBeat.i(121356);
    paramString = cD(paramString, false);
    AppMethodBeat.o(121356);
    return paramString;
  }
  
  public static a cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121357);
    String str = m.jB(paramString, "").replace('/', '.');
    paramString = m.a(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(121357);
    return paramString;
  }
  
  public static a n(b paramb)
  {
    AppMethodBeat.i(121348);
    paramb = new a(paramb.emd(), paramb.CqE.emh());
    AppMethodBeat.o(121348);
    return paramb;
  }
  
  public final f elZ()
  {
    AppMethodBeat.i(156776);
    f localf = this.CqB.CqE.emh();
    AppMethodBeat.o(156776);
    return localf;
  }
  
  public final a ema()
  {
    AppMethodBeat.i(121353);
    Object localObject = this.CqB.emd();
    if (((b)localObject).CqE.CqJ.isEmpty())
    {
      AppMethodBeat.o(121353);
      return null;
    }
    localObject = new a(this.BUK, (b)localObject, this.CqC);
    AppMethodBeat.o(121353);
    return localObject;
  }
  
  public final boolean emb()
  {
    AppMethodBeat.i(121354);
    if (!this.CqB.emd().CqE.CqJ.isEmpty())
    {
      AppMethodBeat.o(121354);
      return true;
    }
    AppMethodBeat.o(121354);
    return false;
  }
  
  public final b emc()
  {
    AppMethodBeat.i(121355);
    if (this.BUK.CqE.CqJ.isEmpty())
    {
      localb = this.CqB;
      AppMethodBeat.o(121355);
      return localb;
    }
    b localb = new b(this.BUK.CqE.CqJ + "." + this.CqB.CqE.CqJ);
    AppMethodBeat.o(121355);
    return localb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121359);
    if (this == paramObject)
    {
      AppMethodBeat.o(121359);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(121359);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.BUK.equals(paramObject.BUK)) && (this.CqB.equals(paramObject.CqB)) && (this.CqC == paramObject.CqC))
    {
      AppMethodBeat.o(121359);
      return true;
    }
    AppMethodBeat.o(121359);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121360);
    int i = this.BUK.hashCode();
    int j = this.CqB.hashCode();
    int k = Boolean.valueOf(this.CqC).hashCode();
    AppMethodBeat.o(121360);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String mk()
  {
    AppMethodBeat.i(121358);
    if (this.BUK.CqE.CqJ.isEmpty())
    {
      str = this.CqB.CqE.CqJ;
      AppMethodBeat.o(121358);
      return str;
    }
    String str = this.BUK.CqE.CqJ.replace('.', '/') + "/" + this.CqB.CqE.CqJ;
    AppMethodBeat.o(121358);
    return str;
  }
  
  public final a p(f paramf)
  {
    AppMethodBeat.i(121352);
    paramf = new a(this.BUK, this.CqB.q(paramf), this.CqC);
    AppMethodBeat.o(121352);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121361);
    if (this.BUK.CqE.CqJ.isEmpty())
    {
      str = "/" + mk();
      AppMethodBeat.o(121361);
      return str;
    }
    String str = mk();
    AppMethodBeat.o(121361);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.f.a
 * JD-Core Version:    0.7.0.1
 */