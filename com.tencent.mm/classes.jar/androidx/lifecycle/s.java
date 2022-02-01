package androidx.lifecycle;

import androidx.a.a.a.c;
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

public class s
  extends j
{
  private androidx.a.a.b.a<p, a> bHp;
  private j.b bHq;
  private final WeakReference<q> bHr;
  private int bHs;
  private boolean bHt;
  private boolean bHu;
  private ArrayList<j.b> bHv;
  private final boolean bHw;
  
  public s(q paramq)
  {
    this(paramq, (byte)0);
  }
  
  private s(q paramq, byte paramByte)
  {
    AppMethodBeat.i(194386);
    this.bHp = new androidx.a.a.b.a();
    this.bHs = 0;
    this.bHt = false;
    this.bHu = false;
    this.bHv = new ArrayList();
    this.bHr = new WeakReference(paramq);
    this.bHq = j.b.bHh;
    this.bHw = true;
    AppMethodBeat.o(194386);
  }
  
  private boolean Hh()
  {
    AppMethodBeat.i(194401);
    if (this.bHp.mSize == 0)
    {
      AppMethodBeat.o(194401);
      return true;
    }
    j.b localb1 = ((a)this.bHp.yZ.getValue()).bHq;
    j.b localb2 = ((a)this.bHp.za.getValue()).bHq;
    if ((localb1 == localb2) && (this.bHq == localb2))
    {
      AppMethodBeat.o(194401);
      return true;
    }
    AppMethodBeat.o(194401);
    return false;
  }
  
  private void Hi()
  {
    AppMethodBeat.i(194420);
    this.bHv.remove(this.bHv.size() - 1);
    AppMethodBeat.o(194420);
  }
  
  static j.b a(j.b paramb1, j.b paramb2)
  {
    AppMethodBeat.i(194473);
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0))
    {
      AppMethodBeat.o(194473);
      return paramb2;
    }
    AppMethodBeat.o(194473);
    return paramb1;
  }
  
  private j.b a(p paramp)
  {
    AppMethodBeat.i(194413);
    Object localObject = this.bHp;
    if (((androidx.a.a.b.a)localObject).contains(paramp))
    {
      paramp = ((b.c)((androidx.a.a.b.a)localObject).yY.get(paramp)).zd;
      if (paramp == null) {
        break label105;
      }
      paramp = ((a)paramp.getValue()).bHq;
      label50:
      if (this.bHv.isEmpty()) {
        break label110;
      }
    }
    label105:
    label110:
    for (localObject = (j.b)this.bHv.get(this.bHv.size() - 1);; localObject = null)
    {
      paramp = a(a(this.bHq, paramp), (j.b)localObject);
      AppMethodBeat.o(194413);
      return paramp;
      paramp = null;
      break;
      paramp = null;
      break label50;
    }
  }
  
  private void aL(String paramString)
  {
    AppMethodBeat.i(194466);
    if ((this.bHw) && (!androidx.a.a.a.a.fG().yR.isMainThread()))
    {
      paramString = new IllegalStateException("Method " + paramString + " must be called on the main thread");
      AppMethodBeat.o(194466);
      throw paramString;
    }
    AppMethodBeat.o(194466);
  }
  
  private void g(j.b paramb)
  {
    AppMethodBeat.i(194397);
    if (this.bHq == paramb)
    {
      AppMethodBeat.o(194397);
      return;
    }
    this.bHq = paramb;
    if ((this.bHt) || (this.bHs != 0))
    {
      this.bHu = true;
      AppMethodBeat.o(194397);
      return;
    }
    this.bHt = true;
    sync();
    this.bHt = false;
    AppMethodBeat.o(194397);
  }
  
  private void h(j.b paramb)
  {
    AppMethodBeat.i(194430);
    this.bHv.add(paramb);
    AppMethodBeat.o(194430);
  }
  
  private void h(q paramq)
  {
    AppMethodBeat.i(194438);
    b.d locald = this.bHp.fJ();
    while ((locald.hasNext()) && (!this.bHu))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.bHq.compareTo(this.bHq) < 0) && (!this.bHu) && (this.bHp.contains(localEntry.getKey())))
      {
        h(locala.bHq);
        j.a locala1 = j.a.b(locala.bHq);
        if (locala1 == null)
        {
          paramq = new IllegalStateException("no event up from " + locala.bHq);
          AppMethodBeat.o(194438);
          throw paramq;
        }
        locala.a(paramq, locala1);
        Hi();
      }
    }
    AppMethodBeat.o(194438);
  }
  
  private void i(q paramq)
  {
    AppMethodBeat.i(194449);
    Object localObject = this.bHp;
    b.b localb = new b.b(((b)localObject).za, ((b)localObject).yZ);
    ((b)localObject).zb.put(localb, Boolean.FALSE);
    while ((localb.hasNext()) && (!this.bHu))
    {
      localObject = (Map.Entry)localb.next();
      a locala = (a)((Map.Entry)localObject).getValue();
      while ((locala.bHq.compareTo(this.bHq) > 0) && (!this.bHu) && (this.bHp.contains(((Map.Entry)localObject).getKey())))
      {
        j.a locala1 = j.a.a(locala.bHq);
        if (locala1 == null)
        {
          paramq = new IllegalStateException("no event down from " + locala.bHq);
          AppMethodBeat.o(194449);
          throw paramq;
        }
        h(locala1.Hg());
        locala.a(paramq, locala1);
        Hi();
      }
    }
    AppMethodBeat.o(194449);
  }
  
  private void sync()
  {
    AppMethodBeat.i(194459);
    Object localObject = (q)this.bHr.get();
    if (localObject == null)
    {
      localObject = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
      AppMethodBeat.o(194459);
      throw ((Throwable)localObject);
    }
    while (!Hh())
    {
      this.bHu = false;
      if (this.bHq.compareTo(((a)this.bHp.yZ.getValue()).bHq) < 0) {
        i((q)localObject);
      }
      b.c localc = this.bHp.za;
      if ((!this.bHu) && (localc != null) && (this.bHq.compareTo(((a)localc.getValue()).bHq) > 0)) {
        h((q)localObject);
      }
    }
    this.bHu = false;
    AppMethodBeat.o(194459);
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(194496);
    aL("handleLifecycleEvent");
    g(parama.Hg());
    AppMethodBeat.o(194496);
  }
  
  public void addObserver(p paramp)
  {
    AppMethodBeat.i(194502);
    aL("addObserver");
    if (this.bHq == j.b.bHg) {}
    a locala;
    for (Object localObject = j.b.bHg;; localObject = j.b.bHh)
    {
      locala = new a(paramp, (j.b)localObject);
      if ((a)this.bHp.putIfAbsent(paramp, locala) == null) {
        break;
      }
      AppMethodBeat.o(194502);
      return;
    }
    q localq = (q)this.bHr.get();
    if (localq == null)
    {
      AppMethodBeat.o(194502);
      return;
    }
    int i;
    if ((this.bHs != 0) || (this.bHt))
    {
      i = 1;
      localObject = a(paramp);
      this.bHs += 1;
    }
    for (;;)
    {
      if ((locala.bHq.compareTo((Enum)localObject) >= 0) || (!this.bHp.contains(paramp))) {
        break label231;
      }
      h(locala.bHq);
      localObject = j.a.b(locala.bHq);
      if (localObject == null)
      {
        paramp = new IllegalStateException("no event up from " + locala.bHq);
        AppMethodBeat.o(194502);
        throw paramp;
        i = 0;
        break;
      }
      locala.a(localq, (j.a)localObject);
      Hi();
      localObject = a(paramp);
    }
    label231:
    if (i == 0) {
      sync();
    }
    this.bHs -= 1;
    AppMethodBeat.o(194502);
  }
  
  @Deprecated
  public final void e(j.b paramb)
  {
    AppMethodBeat.i(194481);
    aL("markState");
    f(paramb);
    AppMethodBeat.o(194481);
  }
  
  public final void f(j.b paramb)
  {
    AppMethodBeat.i(194490);
    aL("setCurrentState");
    g(paramb);
    AppMethodBeat.o(194490);
  }
  
  public j.b getCurrentState()
  {
    return this.bHq;
  }
  
  public void removeObserver(p paramp)
  {
    AppMethodBeat.i(194509);
    aL("removeObserver");
    this.bHp.remove(paramp);
    AppMethodBeat.o(194509);
  }
  
  static final class a
  {
    j.b bHq;
    o bHx;
    
    a(p paramp, j.b paramb)
    {
      AppMethodBeat.i(194333);
      this.bHx = u.aK(paramp);
      this.bHq = paramb;
      AppMethodBeat.o(194333);
    }
    
    final void a(q paramq, j.a parama)
    {
      AppMethodBeat.i(194341);
      j.b localb = parama.Hg();
      this.bHq = s.a(this.bHq, localb);
      this.bHx.onStateChanged(paramq, parama);
      this.bHq = localb;
      AppMethodBeat.o(194341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.s
 * JD-Core Version:    0.7.0.1
 */