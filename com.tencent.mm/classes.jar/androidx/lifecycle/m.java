package androidx.lifecycle;

import androidx.a.a.b.a;
import androidx.a.a.b.b;
import androidx.a.a.b.b.b;
import androidx.a.a.b.b.c;
import androidx.a.a.b.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class m
  extends h
{
  private a<k, a> ZV;
  private h.b ZW;
  private final WeakReference<l> ZX;
  private int ZY;
  private boolean ZZ;
  private boolean aaa;
  private ArrayList<h.b> aab;
  
  public m(l paraml)
  {
    AppMethodBeat.i(263211);
    this.ZV = new a();
    this.ZY = 0;
    this.ZZ = false;
    this.aaa = false;
    this.aab = new ArrayList();
    this.ZX = new WeakReference(paraml);
    this.ZW = h.b.ZP;
    AppMethodBeat.o(263211);
  }
  
  static h.b a(h.b paramb1, h.b paramb2)
  {
    AppMethodBeat.i(263236);
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0))
    {
      AppMethodBeat.o(263236);
      return paramb2;
    }
    AppMethodBeat.o(263236);
    return paramb1;
  }
  
  private void a(l paraml)
  {
    AppMethodBeat.i(263230);
    b.d locald = this.ZV.eM();
    while ((locald.hasNext()) && (!this.aaa))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.ZW.compareTo(this.ZW) < 0) && (!this.aaa) && (this.ZV.contains(localEntry.getKey())))
      {
        d(locala.ZW);
        locala.b(paraml, e(locala.ZW));
        je();
      }
    }
    AppMethodBeat.o(263230);
  }
  
  static h.b b(h.a parama)
  {
    AppMethodBeat.i(263228);
    switch (1.ZM[parama.ordinal()])
    {
    default: 
      parama = new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(parama)));
      AppMethodBeat.o(263228);
      throw parama;
    case 1: 
    case 2: 
      parama = h.b.ZQ;
      AppMethodBeat.o(263228);
      return parama;
    case 3: 
    case 4: 
      parama = h.b.ZR;
      AppMethodBeat.o(263228);
      return parama;
    case 5: 
      parama = h.b.ZS;
      AppMethodBeat.o(263228);
      return parama;
    }
    parama = h.b.ZO;
    AppMethodBeat.o(263228);
    return parama;
  }
  
  private void b(l paraml)
  {
    AppMethodBeat.i(263232);
    Object localObject = this.ZV;
    b.b localb = new b.b(((b)localObject).yf, ((b)localObject).ye);
    ((b)localObject).yg.put(localb, Boolean.FALSE);
    while ((localb.hasNext()) && (!this.aaa))
    {
      Map.Entry localEntry = (Map.Entry)localb.next();
      a locala = (a)localEntry.getValue();
      if ((locala.ZW.compareTo(this.ZW) > 0) && (!this.aaa) && (this.ZV.contains(localEntry.getKey())))
      {
        localObject = locala.ZW;
        switch (1.aac[localObject.ordinal()])
        {
        default: 
          paraml = new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(localObject)));
          AppMethodBeat.o(263232);
          throw paraml;
        case 1: 
          paraml = new IllegalArgumentException();
          AppMethodBeat.o(263232);
          throw paraml;
        case 2: 
          localObject = h.a.ON_DESTROY;
        case 3: 
        case 4: 
          for (;;)
          {
            d(b((h.a)localObject));
            locala.b(paraml, (h.a)localObject);
            je();
            break;
            localObject = h.a.ON_STOP;
            continue;
            localObject = h.a.ON_PAUSE;
          }
        }
        paraml = new IllegalArgumentException();
        AppMethodBeat.o(263232);
        throw paraml;
      }
    }
    AppMethodBeat.o(263232);
  }
  
  private h.b c(k paramk)
  {
    AppMethodBeat.i(263216);
    Object localObject = this.ZV;
    if (((a)localObject).contains(paramk))
    {
      paramk = ((b.c)((a)localObject).yd.get(paramk)).yj;
      if (paramk == null) {
        break label105;
      }
      paramk = ((a)paramk.getValue()).ZW;
      label50:
      if (this.aab.isEmpty()) {
        break label110;
      }
    }
    label105:
    label110:
    for (localObject = (h.b)this.aab.get(this.aab.size() - 1);; localObject = null)
    {
      paramk = a(a(this.ZW, paramk), (h.b)localObject);
      AppMethodBeat.o(263216);
      return paramk;
      paramk = null;
      break;
      paramk = null;
      break label50;
    }
  }
  
  private void d(h.b paramb)
  {
    AppMethodBeat.i(263222);
    this.aab.add(paramb);
    AppMethodBeat.o(263222);
  }
  
  private static h.a e(h.b paramb)
  {
    AppMethodBeat.i(263229);
    switch (1.aac[paramb.ordinal()])
    {
    default: 
      paramb = new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(263229);
      throw paramb;
    case 1: 
    case 5: 
      paramb = h.a.ON_CREATE;
      AppMethodBeat.o(263229);
      return paramb;
    case 2: 
      paramb = h.a.ON_START;
      AppMethodBeat.o(263229);
      return paramb;
    case 3: 
      paramb = h.a.ON_RESUME;
      AppMethodBeat.o(263229);
      return paramb;
    }
    paramb = new IllegalArgumentException();
    AppMethodBeat.o(263229);
    throw paramb;
  }
  
  private boolean jd()
  {
    AppMethodBeat.i(263215);
    if (this.ZV.mSize == 0)
    {
      AppMethodBeat.o(263215);
      return true;
    }
    h.b localb1 = ((a)this.ZV.ye.getValue()).ZW;
    h.b localb2 = ((a)this.ZV.yf.getValue()).ZW;
    if ((localb1 == localb2) && (this.ZW == localb2))
    {
      AppMethodBeat.o(263215);
      return true;
    }
    AppMethodBeat.o(263215);
    return false;
  }
  
  private void je()
  {
    AppMethodBeat.i(263220);
    this.aab.remove(this.aab.size() - 1);
    AppMethodBeat.o(263220);
  }
  
  private void sync()
  {
    AppMethodBeat.i(263234);
    l locall = (l)this.ZX.get();
    if (locall == null)
    {
      AppMethodBeat.o(263234);
      return;
    }
    while (!jd())
    {
      this.aaa = false;
      if (this.ZW.compareTo(((a)this.ZV.ye.getValue()).ZW) < 0) {
        b(locall);
      }
      b.c localc = this.ZV.yf;
      if ((!this.aaa) && (localc != null) && (this.ZW.compareTo(((a)localc.getValue()).ZW) > 0)) {
        a(locall);
      }
    }
    this.aaa = false;
    AppMethodBeat.o(263234);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(263213);
    c(b(parama));
    AppMethodBeat.o(263213);
  }
  
  public void a(k paramk)
  {
    AppMethodBeat.i(263218);
    if (this.ZW == h.b.ZO) {}
    a locala;
    for (h.b localb = h.b.ZO;; localb = h.b.ZP)
    {
      locala = new a(paramk, localb);
      if ((a)this.ZV.putIfAbsent(paramk, locala) == null) {
        break;
      }
      AppMethodBeat.o(263218);
      return;
    }
    l locall = (l)this.ZX.get();
    if (locall == null)
    {
      AppMethodBeat.o(263218);
      return;
    }
    if ((this.ZY != 0) || (this.ZZ)) {}
    for (int i = 1;; i = 0)
    {
      localb = c(paramk);
      this.ZY += 1;
      while ((locala.ZW.compareTo(localb) < 0) && (this.ZV.contains(paramk)))
      {
        d(locala.ZW);
        locala.b(locall, e(locala.ZW));
        je();
        localb = c(paramk);
      }
    }
    if (i == 0) {
      sync();
    }
    this.ZY -= 1;
    AppMethodBeat.o(263218);
  }
  
  public final void b(h.b paramb)
  {
    AppMethodBeat.i(293138);
    c(paramb);
    AppMethodBeat.o(293138);
  }
  
  public void b(k paramk)
  {
    AppMethodBeat.i(263224);
    this.ZV.remove(paramk);
    AppMethodBeat.o(263224);
  }
  
  public final void c(h.b paramb)
  {
    AppMethodBeat.i(263214);
    if (this.ZW == paramb)
    {
      AppMethodBeat.o(263214);
      return;
    }
    this.ZW = paramb;
    if ((this.ZZ) || (this.ZY != 0))
    {
      this.aaa = true;
      AppMethodBeat.o(263214);
      return;
    }
    this.ZZ = true;
    sync();
    this.ZZ = false;
    AppMethodBeat.o(263214);
  }
  
  public final h.b jc()
  {
    return this.ZW;
  }
  
  public final int jf()
  {
    return this.ZV.mSize;
  }
  
  static final class a
  {
    h.b ZW;
    g aad;
    
    a(k paramk, h.b paramb)
    {
      AppMethodBeat.i(263206);
      this.aad = o.K(paramk);
      this.ZW = paramb;
      AppMethodBeat.o(263206);
    }
    
    final void b(l paraml, h.a parama)
    {
      AppMethodBeat.i(263207);
      h.b localb = m.b(parama);
      this.ZW = m.a(this.ZW, localb);
      this.aad.a(paraml, parama);
      this.ZW = localb;
      AppMethodBeat.o(263207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.m
 * JD-Core Version:    0.7.0.1
 */