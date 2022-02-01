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
  private static final Writer bGK;
  private static final p bGL;
  public final List<k> bGM;
  private String bGN;
  public k bGO;
  
  static
  {
    AppMethodBeat.i(108074);
    bGK = new e.1();
    bGL = new p("closed");
    AppMethodBeat.o(108074);
  }
  
  public e()
  {
    super(bGK);
    AppMethodBeat.i(108059);
    this.bGM = new ArrayList();
    this.bGO = m.bFA;
    AppMethodBeat.o(108059);
  }
  
  private void a(k paramk)
  {
    AppMethodBeat.i(108061);
    Object localObject2;
    if (this.bGN != null)
    {
      if ((!(paramk instanceof m)) || (this.bFh))
      {
        localObject2 = (n)xD();
        String str = this.bGN;
        localObject1 = paramk;
        if (paramk == null) {
          localObject1 = m.bFA;
        }
        ((n)localObject2).bFB.put(str, localObject1);
      }
      this.bGN = null;
      AppMethodBeat.o(108061);
      return;
    }
    if (this.bGM.isEmpty())
    {
      this.bGO = paramk;
      AppMethodBeat.o(108061);
      return;
    }
    Object localObject1 = xD();
    if ((localObject1 instanceof i))
    {
      localObject2 = (i)localObject1;
      localObject1 = paramk;
      if (paramk == null) {
        localObject1 = m.bFA;
      }
      ((i)localObject2).elements.add(localObject1);
      AppMethodBeat.o(108061);
      return;
    }
    paramk = new IllegalStateException();
    AppMethodBeat.o(108061);
    throw paramk;
  }
  
  private k xD()
  {
    AppMethodBeat.i(108060);
    k localk = (k)this.bGM.get(this.bGM.size() - 1);
    AppMethodBeat.o(108060);
    return localk;
  }
  
  public final a a(Boolean paramBoolean)
  {
    AppMethodBeat.i(108070);
    if (paramBoolean == null)
    {
      paramBoolean = xI();
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
      paramNumber = xI();
      AppMethodBeat.o(108072);
      return paramNumber;
    }
    if (!this.bFm)
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
  
  public final a az(long paramLong)
  {
    AppMethodBeat.i(108071);
    a(new p(Long.valueOf(paramLong)));
    AppMethodBeat.o(108071);
    return this;
  }
  
  public final a bg(boolean paramBoolean)
  {
    AppMethodBeat.i(108069);
    a(new p(Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(108069);
    return this;
  }
  
  public final a bp(String paramString)
  {
    AppMethodBeat.i(108066);
    if ((this.bGM.isEmpty()) || (this.bGN != null))
    {
      paramString = new IllegalStateException();
      AppMethodBeat.o(108066);
      throw paramString;
    }
    if ((xD() instanceof n))
    {
      this.bGN = paramString;
      AppMethodBeat.o(108066);
      return this;
    }
    paramString = new IllegalStateException();
    AppMethodBeat.o(108066);
    throw paramString;
  }
  
  public final a bq(String paramString)
  {
    AppMethodBeat.i(108067);
    if (paramString == null)
    {
      paramString = xI();
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
    if (!this.bGM.isEmpty())
    {
      IOException localIOException = new IOException("Incomplete document");
      AppMethodBeat.o(108073);
      throw localIOException;
    }
    this.bGM.add(bGL);
    AppMethodBeat.o(108073);
  }
  
  public final void flush() {}
  
  public final a xE()
  {
    AppMethodBeat.i(108062);
    i locali = new i();
    a(locali);
    this.bGM.add(locali);
    AppMethodBeat.o(108062);
    return this;
  }
  
  public final a xF()
  {
    AppMethodBeat.i(108063);
    if ((this.bGM.isEmpty()) || (this.bGN != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108063);
      throw localIllegalStateException;
    }
    if ((xD() instanceof i))
    {
      this.bGM.remove(this.bGM.size() - 1);
      AppMethodBeat.o(108063);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108063);
    throw localIllegalStateException;
  }
  
  public final a xG()
  {
    AppMethodBeat.i(108064);
    n localn = new n();
    a(localn);
    this.bGM.add(localn);
    AppMethodBeat.o(108064);
    return this;
  }
  
  public final a xH()
  {
    AppMethodBeat.i(108065);
    if ((this.bGM.isEmpty()) || (this.bGN != null))
    {
      localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(108065);
      throw localIllegalStateException;
    }
    if ((xD() instanceof n))
    {
      this.bGM.remove(this.bGM.size() - 1);
      AppMethodBeat.o(108065);
      return this;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108065);
    throw localIllegalStateException;
  }
  
  public final a xI()
  {
    AppMethodBeat.i(108068);
    a(m.bFA);
    AppMethodBeat.o(108068);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */