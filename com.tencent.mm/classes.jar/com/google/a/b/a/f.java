package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.g;
import com.google.a.i;
import com.google.a.k;
import com.google.a.l;
import com.google.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends c
{
  private static final Writer bMB;
  private static final n bMC;
  public final List<i> bMD;
  private String bME;
  public i bMF;
  
  static
  {
    AppMethodBeat.i(108074);
    bMB = new f.1();
    bMC = new n("closed");
    AppMethodBeat.o(108074);
  }
  
  public f()
  {
    super(bMB);
    AppMethodBeat.i(108059);
    this.bMD = new ArrayList();
    this.bMF = k.bLm;
    AppMethodBeat.o(108059);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(108061);
    if (this.bME != null)
    {
      if ((!(parami instanceof k)) || (zX())) {
        ((l)zF()).a(this.bME, parami);
      }
      this.bME = null;
      AppMethodBeat.o(108061);
      return;
    }
    if (this.bMD.isEmpty())
    {
      this.bMF = parami;
      AppMethodBeat.o(108061);
      return;
    }
    i locali = zF();
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
  
  private i zF()
  {
    AppMethodBeat.i(108060);
    i locali = (i)this.bMD.get(this.bMD.size() - 1);
    AppMethodBeat.o(108060);
    return locali;
  }
  
  public final c a(Number paramNumber)
  {
    AppMethodBeat.i(108072);
    if (paramNumber == null)
    {
      paramNumber = zK();
      AppMethodBeat.o(108072);
      return paramNumber;
    }
    if (!this.bLb)
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
  
  public final c az(long paramLong)
  {
    AppMethodBeat.i(108071);
    b(new n(Long.valueOf(paramLong)));
    AppMethodBeat.o(108071);
    return this;
  }
  
  public final c b(Boolean paramBoolean)
  {
    AppMethodBeat.i(108070);
    if (paramBoolean == null)
    {
      paramBoolean = zK();
      AppMethodBeat.o(108070);
      return paramBoolean;
    }
    b(new n(paramBoolean));
    AppMethodBeat.o(108070);
    return this;
  }
  
  public final c bp(boolean paramBoolean)
  {
    AppMethodBeat.i(108069);
    b(new n(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(108069);
    return this;
  }
  
  public final void close()
  {
    AppMethodBeat.i(108073);
    if (!this.bMD.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(108073);
      throw localIOException;
    }
    this.bMD.add(bMC);
    AppMethodBeat.o(108073);
  }
  
  public final c cm(String paramString)
  {
    AppMethodBeat.i(108066);
    if ((this.bMD.isEmpty()) || (this.bME != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(108066);
      throw paramString;
    }
    if ((zF() instanceof l))
    {
      this.bME = paramString;
      AppMethodBeat.o(108066);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(108066);
    throw paramString;
  }
  
  public final c cn(String paramString)
  {
    AppMethodBeat.i(108067);
    if (paramString == null)
    {
      paramString = zK();
      AppMethodBeat.o(108067);
      return paramString;
    }
    b(new n(paramString));
    AppMethodBeat.o(108067);
    return this;
  }
  
  public final void flush() {}
  
  public final c zG()
  {
    AppMethodBeat.i(108062);
    g localg = new g();
    b(localg);
    this.bMD.add(localg);
    AppMethodBeat.o(108062);
    return this;
  }
  
  public final c zH()
  {
    AppMethodBeat.i(108063);
    if ((this.bMD.isEmpty()) || (this.bME != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108063);
      throw localIllegalStateException;
    }
    if ((zF() instanceof g))
    {
      this.bMD.remove(this.bMD.size() - 1);
      AppMethodBeat.o(108063);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108063);
    throw localIllegalStateException;
  }
  
  public final c zI()
  {
    AppMethodBeat.i(108064);
    l locall = new l();
    b(locall);
    this.bMD.add(locall);
    AppMethodBeat.o(108064);
    return this;
  }
  
  public final c zJ()
  {
    AppMethodBeat.i(108065);
    if ((this.bMD.isEmpty()) || (this.bME != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108065);
      throw localIllegalStateException;
    }
    if ((zF() instanceof l))
    {
      this.bMD.remove(this.bMD.size() - 1);
      AppMethodBeat.o(108065);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108065);
    throw localIllegalStateException;
  }
  
  public final c zK()
  {
    AppMethodBeat.i(108068);
    b(k.bLm);
    AppMethodBeat.o(108068);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */