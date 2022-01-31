package a.j.b.a.c.f;

import a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c
{
  private static final f CqG;
  private static final Pattern CqH;
  private static final a.f.a.b<String, f> CqI;
  public final String CqJ;
  private transient b CqK;
  private transient c CqL;
  private transient f CqM;
  
  static
  {
    AppMethodBeat.i(121387);
    CqG = f.ayV("<root>");
    CqH = Pattern.compile("\\.");
    CqI = new c.1();
    AppMethodBeat.o(121387);
  }
  
  private c(String paramString)
  {
    this.CqJ = paramString;
  }
  
  c(String paramString, b paramb)
  {
    this.CqJ = paramString;
    this.CqK = paramb;
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    this.CqJ = paramString;
    this.CqL = paramc;
    this.CqM = paramf;
  }
  
  private void compute()
  {
    AppMethodBeat.i(121374);
    int i = this.CqJ.lastIndexOf('.');
    if (i >= 0)
    {
      this.CqM = f.ayW(this.CqJ.substring(i + 1));
      this.CqL = new c(this.CqJ.substring(0, i));
      AppMethodBeat.o(121374);
      return;
    }
    this.CqM = f.ayW(this.CqJ);
    this.CqL = b.CqD.CqE;
    AppMethodBeat.o(121374);
  }
  
  public static c u(f paramf)
  {
    AppMethodBeat.i(121383);
    paramf = new c(paramf.name, b.CqD.CqE, paramf);
    AppMethodBeat.o(121383);
    return paramf;
  }
  
  public final boolean eme()
  {
    AppMethodBeat.i(121375);
    if ((this.CqK != null) || (this.CqJ.indexOf('<') < 0))
    {
      AppMethodBeat.o(121375);
      return true;
    }
    AppMethodBeat.o(121375);
    return false;
  }
  
  public final b emf()
  {
    AppMethodBeat.i(121376);
    if (this.CqK != null)
    {
      localb = this.CqK;
      AppMethodBeat.o(121376);
      return localb;
    }
    this.CqK = new b(this);
    b localb = this.CqK;
    AppMethodBeat.o(121376);
    return localb;
  }
  
  public final c emg()
  {
    AppMethodBeat.i(121377);
    if (this.CqL != null)
    {
      localObject = this.CqL;
      AppMethodBeat.o(121377);
      return localObject;
    }
    if (this.CqJ.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(121377);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.CqL;
    AppMethodBeat.o(121377);
    return localObject;
  }
  
  public final f emh()
  {
    AppMethodBeat.i(121379);
    if (this.CqM != null)
    {
      localObject = this.CqM;
      AppMethodBeat.o(121379);
      return localObject;
    }
    if (this.CqJ.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(121379);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.CqM;
    AppMethodBeat.o(121379);
    return localObject;
  }
  
  public final f emi()
  {
    AppMethodBeat.i(121380);
    if (this.CqJ.isEmpty())
    {
      localf = CqG;
      AppMethodBeat.o(121380);
      return localf;
    }
    f localf = emh();
    AppMethodBeat.o(121380);
    return localf;
  }
  
  public final List<f> emj()
  {
    AppMethodBeat.i(121381);
    if (this.CqJ.isEmpty())
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(121381);
      return localList;
    }
    List localList = e.a(CqH.split(this.CqJ), CqI);
    AppMethodBeat.o(121381);
    return localList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121385);
    if (this == paramObject)
    {
      AppMethodBeat.o(121385);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(121385);
      return false;
    }
    paramObject = (c)paramObject;
    if (!this.CqJ.equals(paramObject.CqJ))
    {
      AppMethodBeat.o(121385);
      return false;
    }
    AppMethodBeat.o(121385);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121386);
    int i = this.CqJ.hashCode();
    AppMethodBeat.o(121386);
    return i;
  }
  
  public final boolean r(f paramf)
  {
    AppMethodBeat.i(121382);
    int j = this.CqJ.indexOf('.');
    if (!this.CqJ.isEmpty())
    {
      String str = this.CqJ;
      paramf = paramf.name;
      int i = j;
      if (j == -1) {
        i = this.CqJ.length();
      }
      if (str.regionMatches(0, paramf, 0, i))
      {
        AppMethodBeat.o(121382);
        return true;
      }
    }
    AppMethodBeat.o(121382);
    return false;
  }
  
  public final c t(f paramf)
  {
    AppMethodBeat.i(121378);
    if (this.CqJ.isEmpty()) {}
    for (String str = paramf.name;; str = this.CqJ + "." + paramf.name)
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(121378);
      return paramf;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121384);
    if (this.CqJ.isEmpty())
    {
      str = CqG.name;
      AppMethodBeat.o(121384);
      return str;
    }
    String str = this.CqJ;
    AppMethodBeat.o(121384);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.f.c
 * JD-Core Version:    0.7.0.1
 */