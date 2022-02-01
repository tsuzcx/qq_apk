package com.google.a.b.a;

import com.google.a.b.g;
import com.google.a.d.a;
import com.google.a.i;
import com.google.a.k;
import com.google.a.m;
import com.google.a.n;
import com.google.a.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  private static final Writer bOG;
  private static final p bOH;
  public final List<k> bOI;
  private String bOJ;
  public k bOK;
  
  static
  {
    AppMethodBeat.i(108074);
    bOG = new e.1();
    bOH = new p("closed");
    AppMethodBeat.o(108074);
  }
  
  public e()
  {
    super(bOG);
    AppMethodBeat.i(108059);
    this.bOI = new ArrayList();
    this.bOK = m.bNw;
    AppMethodBeat.o(108059);
  }
  
  private void a(k paramk)
  {
    AppMethodBeat.i(108061);
    Object localObject2;
    if (this.bOJ != null)
    {
      if ((!(paramk instanceof m)) || (this.bNd))
      {
        localObject2 = (n)yN();
        String str = this.bOJ;
        localObject1 = paramk;
        if (paramk == null) {
          localObject1 = m.bNw;
        }
        ((n)localObject2).bNx.put(str, localObject1);
      }
      this.bOJ = null;
      AppMethodBeat.o(108061);
      return;
    }
    if (this.bOI.isEmpty())
    {
      this.bOK = paramk;
      AppMethodBeat.o(108061);
      return;
    }
    Object localObject1 = yN();
    if ((localObject1 instanceof i))
    {
      localObject2 = (i)localObject1;
      localObject1 = paramk;
      if (paramk == null) {
        localObject1 = m.bNw;
      }
      ((i)localObject2).elements.add(localObject1);
      AppMethodBeat.o(108061);
      return;
    }
    paramk = new IllegalStateException();
    AppMethodBeat.o(108061);
    throw paramk;
  }
  
  private k yN()
  {
    AppMethodBeat.i(108060);
    k localk = (k)this.bOI.get(this.bOI.size() - 1);
    AppMethodBeat.o(108060);
    return localk;
  }
  
  public final a a(Number paramNumber)
  {
    AppMethodBeat.i(108072);
    if (paramNumber == null)
    {
      paramNumber = yS();
      AppMethodBeat.o(108072);
      return paramNumber;
    }
    if (!this.bNi)
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        paramNumber = new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(paramNumber)));
        AppMethodBeat.o(108072);
        throw paramNumber;
      }
    }
    a(new p(paramNumber));
    AppMethodBeat.o(108072);
    return this;
  }
  
  public final a av(long paramLong)
  {
    AppMethodBeat.i(108071);
    a(new p(Long.valueOf(paramLong)));
    AppMethodBeat.o(108071);
    return this;
  }
  
  public final a b(Boolean paramBoolean)
  {
    AppMethodBeat.i(108070);
    if (paramBoolean == null)
    {
      paramBoolean = yS();
      AppMethodBeat.o(108070);
      return paramBoolean;
    }
    a(new p(paramBoolean));
    AppMethodBeat.o(108070);
    return this;
  }
  
  public final a bZ(String paramString)
  {
    AppMethodBeat.i(108066);
    if ((this.bOI.isEmpty()) || (this.bOJ != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(108066);
      throw paramString;
    }
    if ((yN() instanceof n))
    {
      this.bOJ = paramString;
      AppMethodBeat.o(108066);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(108066);
    throw paramString;
  }
  
  public final a bg(boolean paramBoolean)
  {
    AppMethodBeat.i(108069);
    a(new p(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(108069);
    return this;
  }
  
  public final a ca(String paramString)
  {
    AppMethodBeat.i(108067);
    if (paramString == null)
    {
      paramString = yS();
      AppMethodBeat.o(108067);
      return paramString;
    }
    a(new p(paramString));
    AppMethodBeat.o(108067);
    return this;
  }
  
  public final void close()
  {
    AppMethodBeat.i(108073);
    if (!this.bOI.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(108073);
      throw localIOException;
    }
    this.bOI.add(bOH);
    AppMethodBeat.o(108073);
  }
  
  public final void flush() {}
  
  public final a yO()
  {
    AppMethodBeat.i(108062);
    i locali = new i();
    a(locali);
    this.bOI.add(locali);
    AppMethodBeat.o(108062);
    return this;
  }
  
  public final a yP()
  {
    AppMethodBeat.i(108063);
    if ((this.bOI.isEmpty()) || (this.bOJ != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108063);
      throw localIllegalStateException;
    }
    if ((yN() instanceof i))
    {
      this.bOI.remove(this.bOI.size() - 1);
      AppMethodBeat.o(108063);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108063);
    throw localIllegalStateException;
  }
  
  public final a yQ()
  {
    AppMethodBeat.i(108064);
    n localn = new n();
    a(localn);
    this.bOI.add(localn);
    AppMethodBeat.o(108064);
    return this;
  }
  
  public final a yR()
  {
    AppMethodBeat.i(108065);
    if ((this.bOI.isEmpty()) || (this.bOJ != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108065);
      throw localIllegalStateException;
    }
    if ((yN() instanceof n))
    {
      this.bOI.remove(this.bOI.size() - 1);
      AppMethodBeat.o(108065);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108065);
    throw localIllegalStateException;
  }
  
  public final a yS()
  {
    AppMethodBeat.i(108068);
    a(m.bNw);
    AppMethodBeat.o(108068);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */