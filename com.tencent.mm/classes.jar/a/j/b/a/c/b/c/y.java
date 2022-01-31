package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.t;
import a.j.b.a.c.b.t.a;
import a.j.b.a.c.b.w;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class y
  extends k
  implements ag
{
  public az BZE;
  public final boolean BZH;
  private final b.a BZT;
  public t BZU = null;
  public final boolean BZi;
  public final w BZj;
  public final ah BZz;
  public boolean isDefault;
  
  static
  {
    if (!y.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public y(w paramw, az paramaz, ah paramah, g paramg, f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, am paramam)
  {
    super(paramah.ecv(), paramg, paramf, paramam);
    this.BZj = paramw;
    this.BZE = paramaz;
    this.BZz = paramah;
    this.isDefault = paramBoolean1;
    this.BZi = paramBoolean2;
    this.BZH = paramBoolean3;
    this.BZT = parama;
  }
  
  public final <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final t c(au paramau)
  {
    throw new UnsupportedOperationException();
  }
  
  public final w ecC()
  {
    return this.BZj;
  }
  
  public final az ecE()
  {
    return this.BZE;
  }
  
  public final boolean ecI()
  {
    return this.BZH;
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final boolean ecL()
  {
    return this.BZi;
  }
  
  public final boolean ecW()
  {
    return false;
  }
  
  public final t edP()
  {
    return this.BZU;
  }
  
  public final boolean edQ()
  {
    return false;
  }
  
  public final boolean edR()
  {
    return false;
  }
  
  public final boolean edS()
  {
    return false;
  }
  
  public final boolean edT()
  {
    return false;
  }
  
  public final boolean edU()
  {
    return false;
  }
  
  public final t.a<? extends t> edV()
  {
    throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
  }
  
  public final ak edp()
  {
    return this.BZz.edp();
  }
  
  public final ak edq()
  {
    return this.BZz.edq();
  }
  
  public final List<ar> edr()
  {
    return Collections.emptyList();
  }
  
  public final boolean edv()
  {
    return false;
  }
  
  public final b.a edy()
  {
    return this.BZT;
  }
  
  public final ah eeg()
  {
    return this.BZz;
  }
  
  public abstract ag eff();
  
  public final void i(Collection<? extends b> paramCollection)
  {
    assert (paramCollection.isEmpty()) : "Overridden accessors should be empty";
  }
  
  public final boolean isDefault()
  {
    return this.isDefault;
  }
  
  protected final Collection<ag> sq(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(0);
    Iterator localIterator = this.BZz.edw().iterator();
    label80:
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (paramBoolean) {}
      for (localObject = ((ah)localObject).eeh();; localObject = ((ah)localObject).eei())
      {
        if (localObject == null) {
          break label80;
        }
        localArrayList.add(localObject);
        break;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.y
 * JD-Core Version:    0.7.0.1
 */