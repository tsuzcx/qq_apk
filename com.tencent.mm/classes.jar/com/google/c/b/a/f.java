package com.google.c.b.a;

import com.google.c.d.c;
import com.google.c.g;
import com.google.c.i;
import com.google.c.k;
import com.google.c.l;
import com.google.c.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends c
{
  private static final Writer dGh;
  private static final n dGi;
  public final List<i> aln;
  private String dGj;
  public i dGk;
  
  static
  {
    AppMethodBeat.i(108074);
    dGh = new f.1();
    dGi = new n("closed");
    AppMethodBeat.o(108074);
  }
  
  public f()
  {
    super(dGh);
    AppMethodBeat.i(108059);
    this.aln = new ArrayList();
    this.dGk = k.dEU;
    AppMethodBeat.o(108059);
  }
  
  private i Zq()
  {
    AppMethodBeat.i(108060);
    i locali = (i)this.aln.get(this.aln.size() - 1);
    AppMethodBeat.o(108060);
    return locali;
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(108061);
    if (this.dGj != null)
    {
      if ((!(parami instanceof k)) || (ZI())) {
        ((l)Zq()).a(this.dGj, parami);
      }
      this.dGj = null;
      AppMethodBeat.o(108061);
      return;
    }
    if (this.aln.isEmpty())
    {
      this.dGk = parami;
      AppMethodBeat.o(108061);
      return;
    }
    i locali = Zq();
    if ((locali instanceof g))
    {
      ((g)locali).a(parami);
      AppMethodBeat.o(108061);
      return;
    }
    parami = new IllegalStateException();
    AppMethodBeat.o(108061);
    throw parami;
  }
  
  public final c Zr()
  {
    AppMethodBeat.i(108062);
    g localg = new g();
    b(localg);
    this.aln.add(localg);
    AppMethodBeat.o(108062);
    return this;
  }
  
  public final c Zs()
  {
    AppMethodBeat.i(108063);
    if ((this.aln.isEmpty()) || (this.dGj != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108063);
      throw localIllegalStateException;
    }
    if ((Zq() instanceof g))
    {
      this.aln.remove(this.aln.size() - 1);
      AppMethodBeat.o(108063);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108063);
    throw localIllegalStateException;
  }
  
  public final c Zt()
  {
    AppMethodBeat.i(108064);
    l locall = new l();
    b(locall);
    this.aln.add(locall);
    AppMethodBeat.o(108064);
    return this;
  }
  
  public final c Zu()
  {
    AppMethodBeat.i(108065);
    if ((this.aln.isEmpty()) || (this.dGj != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108065);
      throw localIllegalStateException;
    }
    if ((Zq() instanceof l))
    {
      this.aln.remove(this.aln.size() - 1);
      AppMethodBeat.o(108065);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108065);
    throw localIllegalStateException;
  }
  
  public final c Zv()
  {
    AppMethodBeat.i(108068);
    b(k.dEU);
    AppMethodBeat.o(108068);
    return this;
  }
  
  public final c a(Number paramNumber)
  {
    AppMethodBeat.i(108072);
    if (paramNumber == null)
    {
      paramNumber = Zv();
      AppMethodBeat.o(108072);
      return paramNumber;
    }
    if (!this.dEJ)
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        paramNumber = new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(paramNumber)));
        AppMethodBeat.o(108072);
        throw paramNumber;
      }
    }
    b(new n(paramNumber));
    AppMethodBeat.o(108072);
    return this;
  }
  
  public final c bW(boolean paramBoolean)
  {
    AppMethodBeat.i(108069);
    b(new n(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(108069);
    return this;
  }
  
  public final c cN(long paramLong)
  {
    AppMethodBeat.i(108071);
    b(new n(Long.valueOf(paramLong)));
    AppMethodBeat.o(108071);
    return this;
  }
  
  public final void close()
  {
    AppMethodBeat.i(108073);
    if (!this.aln.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(108073);
      throw localIOException;
    }
    this.aln.add(dGi);
    AppMethodBeat.o(108073);
  }
  
  public final c dM(String paramString)
  {
    AppMethodBeat.i(108066);
    if ((this.aln.isEmpty()) || (this.dGj != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(108066);
      throw paramString;
    }
    if ((Zq() instanceof l))
    {
      this.dGj = paramString;
      AppMethodBeat.o(108066);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(108066);
    throw paramString;
  }
  
  public final c dN(String paramString)
  {
    AppMethodBeat.i(108067);
    if (paramString == null)
    {
      paramString = Zv();
      AppMethodBeat.o(108067);
      return paramString;
    }
    b(new n(paramString));
    AppMethodBeat.o(108067);
    return this;
  }
  
  public final c e(Boolean paramBoolean)
  {
    AppMethodBeat.i(108070);
    if (paramBoolean == null)
    {
      paramBoolean = Zv();
      AppMethodBeat.o(108070);
      return paramBoolean;
    }
    b(new n(paramBoolean));
    AppMethodBeat.o(108070);
    return this;
  }
  
  public final void flush() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.f
 * JD-Core Version:    0.7.0.1
 */