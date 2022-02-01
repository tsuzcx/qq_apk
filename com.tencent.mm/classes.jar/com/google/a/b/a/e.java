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
  private static final Writer bEs;
  private static final p bEt;
  public final List<k> bEu;
  private String bEv;
  public k bEw;
  
  static
  {
    AppMethodBeat.i(108074);
    bEs = new Writer()
    {
      public final void close()
      {
        AppMethodBeat.i(108081);
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(108081);
        throw localAssertionError;
      }
      
      public final void flush()
      {
        AppMethodBeat.i(108080);
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(108080);
        throw localAssertionError;
      }
      
      public final void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(108079);
        paramAnonymousArrayOfChar = new AssertionError();
        AppMethodBeat.o(108079);
        throw paramAnonymousArrayOfChar;
      }
    };
    bEt = new p("closed");
    AppMethodBeat.o(108074);
  }
  
  public e()
  {
    super(bEs);
    AppMethodBeat.i(108059);
    this.bEu = new ArrayList();
    this.bEw = m.bDi;
    AppMethodBeat.o(108059);
  }
  
  private void a(k paramk)
  {
    AppMethodBeat.i(108061);
    Object localObject2;
    if (this.bEv != null)
    {
      if ((!(paramk instanceof m)) || (this.bCP))
      {
        localObject2 = (n)xq();
        String str = this.bEv;
        localObject1 = paramk;
        if (paramk == null) {
          localObject1 = m.bDi;
        }
        ((n)localObject2).bDj.put(str, localObject1);
      }
      this.bEv = null;
      AppMethodBeat.o(108061);
      return;
    }
    if (this.bEu.isEmpty())
    {
      this.bEw = paramk;
      AppMethodBeat.o(108061);
      return;
    }
    Object localObject1 = xq();
    if ((localObject1 instanceof i))
    {
      localObject2 = (i)localObject1;
      localObject1 = paramk;
      if (paramk == null) {
        localObject1 = m.bDi;
      }
      ((i)localObject2).elements.add(localObject1);
      AppMethodBeat.o(108061);
      return;
    }
    paramk = new IllegalStateException();
    AppMethodBeat.o(108061);
    throw paramk;
  }
  
  private k xq()
  {
    AppMethodBeat.i(108060);
    k localk = (k)this.bEu.get(this.bEu.size() - 1);
    AppMethodBeat.o(108060);
    return localk;
  }
  
  public final a a(Boolean paramBoolean)
  {
    AppMethodBeat.i(108070);
    if (paramBoolean == null)
    {
      paramBoolean = xv();
      AppMethodBeat.o(108070);
      return paramBoolean;
    }
    a(new p(paramBoolean));
    AppMethodBeat.o(108070);
    return this;
  }
  
  public final a a(Number paramNumber)
  {
    AppMethodBeat.i(108072);
    if (paramNumber == null)
    {
      paramNumber = xv();
      AppMethodBeat.o(108072);
      return paramNumber;
    }
    if (!this.bCU)
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
  
  public final a bf(boolean paramBoolean)
  {
    AppMethodBeat.i(108069);
    a(new p(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(108069);
    return this;
  }
  
  public final a bg(String paramString)
  {
    AppMethodBeat.i(108066);
    if ((this.bEu.isEmpty()) || (this.bEv != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(108066);
      throw paramString;
    }
    if ((xq() instanceof n))
    {
      this.bEv = paramString;
      AppMethodBeat.o(108066);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(108066);
    throw paramString;
  }
  
  public final a bh(String paramString)
  {
    AppMethodBeat.i(108067);
    if (paramString == null)
    {
      paramString = xv();
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
    if (!this.bEu.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(108073);
      throw localIOException;
    }
    this.bEu.add(bEt);
    AppMethodBeat.o(108073);
  }
  
  public final void flush() {}
  
  public final a xr()
  {
    AppMethodBeat.i(108062);
    i locali = new i();
    a(locali);
    this.bEu.add(locali);
    AppMethodBeat.o(108062);
    return this;
  }
  
  public final a xs()
  {
    AppMethodBeat.i(108063);
    if ((this.bEu.isEmpty()) || (this.bEv != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108063);
      throw localIllegalStateException;
    }
    if ((xq() instanceof i))
    {
      this.bEu.remove(this.bEu.size() - 1);
      AppMethodBeat.o(108063);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108063);
    throw localIllegalStateException;
  }
  
  public final a xt()
  {
    AppMethodBeat.i(108064);
    n localn = new n();
    a(localn);
    this.bEu.add(localn);
    AppMethodBeat.o(108064);
    return this;
  }
  
  public final a xu()
  {
    AppMethodBeat.i(108065);
    if ((this.bEu.isEmpty()) || (this.bEv != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108065);
      throw localIllegalStateException;
    }
    if ((xq() instanceof n))
    {
      this.bEu.remove(this.bEu.size() - 1);
      AppMethodBeat.o(108065);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108065);
    throw localIllegalStateException;
  }
  
  public final a xv()
  {
    AppMethodBeat.i(108068);
    a(m.bDi);
    AppMethodBeat.o(108068);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */