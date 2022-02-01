package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.al;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bk.a;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class ax
{
  public Rect HZ;
  public final Set<c> JD = new HashSet();
  public final Object JE = new Object();
  private b JF = b.JO;
  public bk<?> JG;
  public bk<?> JH;
  public bk<?> JI;
  public Size JJ;
  public bk<?> JK;
  public bb JL = bb.kx();
  public t Jn;
  
  protected ax(bk<?> parambk)
  {
    this.JH = parambk;
    this.JI = parambk;
  }
  
  protected final boolean X(String paramString)
  {
    if (jA() == null) {
      return false;
    }
    return Objects.equals(paramString, gV());
  }
  
  protected final int a(t paramt)
  {
    return paramt.gK().aI(ju());
  }
  
  protected bk<?> a(s params, bk.a<?, ?, ?> parama)
  {
    return parama.iT();
  }
  
  public final bk<?> a(s params, bk<?> parambk1, bk<?> parambk2)
  {
    if (parambk2 != null)
    {
      parambk2 = at.k(parambk2);
      parambk2.e(androidx.camera.core.a.f.Qn);
    }
    Iterator localIterator;
    ac.a locala;
    for (;;)
    {
      localIterator = this.JH.ke().iterator();
      while (localIterator.hasNext())
      {
        locala = (ac.a)localIterator.next();
        parambk2.a(locala, this.JH.c(locala), this.JH.b(locala));
      }
      parambk2 = at.ku();
    }
    if (parambk1 != null)
    {
      localIterator = parambk1.ke().iterator();
      while (localIterator.hasNext())
      {
        locala = (ac.a)localIterator.next();
        if (!locala.getId().equals(androidx.camera.core.a.f.Qn.getId())) {
          parambk2.a(locala, parambk1.c(locala), parambk1.b(locala));
        }
      }
    }
    if ((parambk2.a(al.MK)) && (parambk2.a(al.MI))) {
      parambk2.e(al.MI);
    }
    return a(params, d(parambk2));
  }
  
  public abstract bk<?> a(boolean paramBoolean, bl parambl);
  
  public final void a(t paramt, bk<?> parambk1, bk<?> parambk2)
  {
    synchronized (this.JE)
    {
      this.Jn = paramt;
      this.JD.add(paramt);
      this.JG = parambk1;
      this.JK = parambk2;
      this.JI = a(paramt.gK(), this.JG, this.JK);
      if (this.JI.kZ() != null) {
        paramt.gK();
      }
      iR();
      return;
    }
  }
  
  protected abstract Size d(Size paramSize);
  
  public abstract bk.a<?, ?, ?> d(ac paramac);
  
  protected final void d(bb parambb)
  {
    this.JL = parambb;
    parambb = Collections.unmodifiableList(parambb.Fs).iterator();
    while (parambb.hasNext())
    {
      ad localad = (ad)parambb.next();
      if (localad.Mm == null) {
        localad.Mm = getClass();
      }
    }
  }
  
  public final void f(Size paramSize)
  {
    this.JJ = d(paramSize);
  }
  
  protected final String gV()
  {
    return ((t)androidx.core.f.f.checkNotNull(jA(), "No camera attached to use case: ".concat(String.valueOf(this)))).gK().gV();
  }
  
  public final String getName()
  {
    return this.JI.ag("<UnknownUseCase-" + hashCode() + ">");
  }
  
  public void iQ() {}
  
  public void iR() {}
  
  protected void iV() {}
  
  public void iW() {}
  
  public final int iw()
  {
    return this.JI.ki();
  }
  
  public final t jA()
  {
    synchronized (this.JE)
    {
      t localt = this.Jn;
      return localt;
    }
  }
  
  public final void jB()
  {
    iV();
  }
  
  protected final p jC()
  {
    synchronized (this.JE)
    {
      if (this.Jn == null)
      {
        localp = p.Lx;
        return localp;
      }
      p localp = this.Jn.gO();
      return localp;
    }
  }
  
  protected final int ju()
  {
    return ((al)this.JI).ko();
  }
  
  protected final void jv()
  {
    this.JF = b.JN;
    jz();
  }
  
  protected final void jw()
  {
    this.JF = b.JO;
    jz();
  }
  
  protected final void jx()
  {
    Iterator localIterator = this.JD.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).c(this);
    }
  }
  
  protected final void jy()
  {
    Iterator localIterator = this.JD.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).d(this);
    }
  }
  
  public final void jz()
  {
    switch (1.JM[this.JF.ordinal()])
    {
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.JD.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).b(this);
      }
      continue;
      localIterator = this.JD.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(this);
      }
    }
  }
  
  public static abstract interface a {}
  
  static enum b
  {
    static
    {
      AppMethodBeat.i(198567);
      JN = new b("ACTIVE", 0);
      JO = new b("INACTIVE", 1);
      JP = new b[] { JN, JO };
      AppMethodBeat.o(198567);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(ax paramax);
    
    public abstract void b(ax paramax);
    
    public abstract void c(ax paramax);
    
    public abstract void d(ax paramax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ax
 * JD-Core Version:    0.7.0.1
 */