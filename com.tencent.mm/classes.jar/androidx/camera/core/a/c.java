package androidx.camera.core.a;

import android.util.Size;
import androidx.camera.core.ad;
import androidx.camera.core.ad.a;
import androidx.camera.core.al;
import androidx.camera.core.ap;
import androidx.camera.core.ap.a;
import androidx.camera.core.ax;
import androidx.camera.core.az;
import androidx.camera.core.i;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.m;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.k;
import androidx.camera.core.n;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements i
{
  public m AR;
  private boolean NE;
  public t Qc;
  private final LinkedHashSet<t> Qd;
  private final q Qe;
  private final bl Qf;
  public final b Qg;
  public final List<ax> Qh;
  public az Qi;
  private ac Qj;
  private List<ax> Qk;
  public final Object mLock;
  
  public c(LinkedHashSet<t> paramLinkedHashSet, q paramq, bl parambl)
  {
    AppMethodBeat.i(199180);
    this.Qh = new ArrayList();
    this.AR = o.jV();
    this.mLock = new Object();
    this.NE = true;
    this.Qj = null;
    this.Qk = new ArrayList();
    this.Qc = ((t)paramLinkedHashSet.iterator().next());
    this.Qd = new LinkedHashSet(paramLinkedHashSet);
    this.Qg = new b(this.Qd);
    this.Qe = paramq;
    this.Qf = parambl;
    AppMethodBeat.o(199180);
  }
  
  private void K(List<ax> paramList)
  {
    AppMethodBeat.i(199219);
    for (;;)
    {
      ax localax;
      t localt;
      synchronized (this.mLock)
      {
        if (paramList.isEmpty()) {
          break label243;
        }
        this.Qc.g(paramList);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localax = (ax)localIterator.next();
        if (!this.Qh.contains(localax)) {
          break label213;
        }
        localt = this.Qc;
        localax.iQ();
        localax.JI.kZ();
      }
      synchronized (localax.JE)
      {
        if (localt == localax.Jn)
        {
          bool = true;
          f.checkArgument(bool);
          localt = localax.Jn;
          localax.JD.remove(localt);
          localax.Jn = null;
          localax.JJ = null;
          localax.HZ = null;
          localax.JI = localax.JH;
          localax.JG = null;
          localax.JK = null;
          continue;
          paramList = finally;
          AppMethodBeat.o(199219);
          throw paramList;
        }
        boolean bool = false;
      }
      label213:
      "Attempting to detach non-attached UseCase: ".concat(String.valueOf(localax));
      al.T("CameraUseCaseAdapter");
    }
    this.Qh.removeAll(paramList);
    label243:
    AppMethodBeat.o(199219);
  }
  
  private static boolean L(List<ax> paramList)
  {
    AppMethodBeat.i(199238);
    paramList = paramList.iterator();
    int i = 0;
    int j = 0;
    while (paramList.hasNext())
    {
      ax localax = (ax)paramList.next();
      if ((localax instanceof ap))
      {
        j = 1;
      }
      else
      {
        if (!(localax instanceof ad)) {
          break label81;
        }
        i = 1;
      }
    }
    label81:
    for (;;)
    {
      break;
      if ((i != 0) && (j == 0))
      {
        AppMethodBeat.o(199238);
        return true;
      }
      AppMethodBeat.o(199238);
      return false;
    }
  }
  
  private static boolean M(List<ax> paramList)
  {
    AppMethodBeat.i(199243);
    paramList = paramList.iterator();
    int i = 0;
    int j = 0;
    while (paramList.hasNext())
    {
      ax localax = (ax)paramList.next();
      if ((localax instanceof ap))
      {
        j = 1;
      }
      else
      {
        if (!(localax instanceof ad)) {
          break label81;
        }
        i = 1;
      }
    }
    label81:
    for (;;)
    {
      break;
      if ((j != 0) && (i == 0))
      {
        AppMethodBeat.o(199243);
        return true;
      }
      AppMethodBeat.o(199243);
      return false;
    }
  }
  
  private Map<ax, Size> a(s params, List<ax> paramList1, List<ax> paramList2, Map<ax, c> paramMap)
  {
    AppMethodBeat.i(199191);
    ArrayList localArrayList = new ArrayList();
    String str = params.gV();
    HashMap localHashMap = new HashMap();
    paramList2 = paramList2.iterator();
    ax localax;
    while (paramList2.hasNext())
    {
      localax = (ax)paramList2.next();
      localArrayList.add(this.Qe.a(str, localax.iw(), localax.JJ));
      localHashMap.put(localax, localax.JJ);
    }
    if (!paramList1.isEmpty())
    {
      paramList2 = new HashMap();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localax = (ax)paramList1.next();
        c localc = (c)paramMap.get(localax);
        paramList2.put(localax.a(params, localc.JG, localc.JK), localax);
      }
      params = this.Qe.a(str, localArrayList, new ArrayList(paramList2.keySet()));
      paramList1 = paramList2.entrySet().iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (Map.Entry)paramList1.next();
        localHashMap.put((ax)paramList2.getValue(), (Size)params.get(paramList2.getKey()));
      }
    }
    AppMethodBeat.o(199191);
    return localHashMap;
  }
  
  private static Map<ax, c> a(List<ax> paramList, bl parambl1, bl parambl2)
  {
    AppMethodBeat.i(199199);
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ax localax = (ax)paramList.next();
      localHashMap.put(localax, new c(localax.a(false, parambl1), localax.a(true, parambl2)));
    }
    AppMethodBeat.o(199199);
    return localHashMap;
  }
  
  private static List<ax> d(List<ax> paramList1, List<ax> paramList2)
  {
    AppMethodBeat.i(199211);
    ArrayList localArrayList = new ArrayList(paramList2);
    boolean bool1 = L(paramList1);
    boolean bool2 = M(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList1 = null;
    paramList2 = null;
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      if ((localax instanceof ap))
      {
        paramList2 = localax;
      }
      else
      {
        if (!(localax instanceof ad)) {
          break label210;
        }
        paramList1 = localax;
      }
    }
    label190:
    label210:
    for (;;)
    {
      break;
      if ((bool1) && (paramList2 == null))
      {
        paramList2 = new ap.a().W("Preview-Extra").jl();
        paramList2.a(c..ExternalSyntheticLambda0.INSTANCE);
        localArrayList.add(paramList2);
        if ((!bool2) || (paramList1 != null)) {
          break label190;
        }
        localArrayList.add(new ad.a().M("ImageCapture-Extra").jc());
      }
      for (;;)
      {
        AppMethodBeat.o(199211);
        return localArrayList;
        if ((bool1) || (paramList2 == null)) {
          break;
        }
        localArrayList.remove(paramList2);
        break;
        if ((!bool2) && (paramList1 != null)) {
          localArrayList.remove(paramList1);
        }
      }
    }
  }
  
  private boolean kY()
  {
    boolean bool = true;
    AppMethodBeat.i(199227);
    synchronized (this.mLock)
    {
      if (this.AR.jT() == 1)
      {
        AppMethodBeat.o(199227);
        return bool;
      }
      bool = false;
    }
  }
  
  public final k iF()
  {
    AppMethodBeat.i(199345);
    p localp = this.Qc.gO();
    AppMethodBeat.o(199345);
    return localp;
  }
  
  public final n iG()
  {
    AppMethodBeat.i(199356);
    s locals = this.Qc.gK();
    AppMethodBeat.o(199356);
    return locals;
  }
  
  public final void k(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(199291);
    ArrayList localArrayList;
    for (;;)
    {
      synchronized (this.mLock)
      {
        localArrayList = new ArrayList();
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject1 = (ax)paramCollection.next();
        if (this.Qh.contains(localObject1)) {
          al.O("CameraUseCaseAdapter");
        }
      }
      localArrayList.add(localObject1);
    }
    Object localObject3 = new ArrayList(this.Qh);
    paramCollection = Collections.emptyList();
    Object localObject1 = Collections.emptyList();
    if (kY())
    {
      ((List)localObject3).removeAll(this.Qk);
      ((List)localObject3).addAll(localArrayList);
      paramCollection = d((List)localObject3, new ArrayList(this.Qk));
      localObject1 = new ArrayList(paramCollection);
      ((List)localObject1).removeAll(this.Qk);
      localArrayList.addAll((Collection)localObject1);
      localObject1 = new ArrayList(this.Qk);
      ((List)localObject1).removeAll(paramCollection);
    }
    localObject3 = a(localArrayList, this.AR.jR(), this.Qf);
    Object localObject4;
    try
    {
      localObject4 = new ArrayList(this.Qh);
      ((List)localObject4).removeAll((Collection)localObject1);
      localObject4 = a(this.Qc.gK(), localArrayList, (List)localObject4, (Map)localObject3);
      synchronized (this.mLock)
      {
        if (this.Qi != null)
        {
          this.Qc.gK().gW().intValue();
          this.Qc.gO().gx();
          AppMethodBeat.o(199291);
          throw null;
        }
      }
    }
    catch (IllegalArgumentException paramCollection)
    {
      paramCollection = new a(paramCollection.getMessage());
      AppMethodBeat.o(199291);
      throw paramCollection;
    }
    this.Qk = paramCollection;
    K((List)localObject1);
    paramCollection = localArrayList.iterator();
    while (paramCollection.hasNext())
    {
      localObject1 = (ax)paramCollection.next();
      ??? = (c)((Map)localObject3).get(localObject1);
      ((ax)localObject1).a(this.Qc, ((c)???).JG, ((c)???).JK);
      ((ax)localObject1).f((Size)f.checkNotNull((Size)((Map)localObject4).get(localObject1)));
    }
    this.Qh.addAll(localArrayList);
    if (this.NE) {
      this.Qc.e(localArrayList);
    }
    paramCollection = localArrayList.iterator();
    while (paramCollection.hasNext()) {
      ((ax)paramCollection.next()).jz();
    }
    AppMethodBeat.o(199291);
  }
  
  public final List<ax> kV()
  {
    AppMethodBeat.i(199317);
    synchronized (this.mLock)
    {
      ArrayList localArrayList = new ArrayList(this.Qh);
      AppMethodBeat.o(199317);
      return localArrayList;
    }
  }
  
  public final void kW()
  {
    AppMethodBeat.i(199328);
    synchronized (this.mLock)
    {
      if (this.NE) {
        break label124;
      }
      this.Qc.e(this.Qh);
    }
    synchronized (this.mLock)
    {
      if (this.Qj != null) {
        this.Qc.gO().b(this.Qj);
      }
      ??? = this.Qh.iterator();
      while (((Iterator)???).hasNext())
      {
        ((ax)((Iterator)???).next()).jz();
        continue;
        localObject3 = finally;
        AppMethodBeat.o(199328);
        throw localObject3;
      }
    }
    this.NE = true;
    label124:
    AppMethodBeat.o(199328);
  }
  
  public final void kX()
  {
    AppMethodBeat.i(199337);
    synchronized (this.mLock)
    {
      if (this.NE) {
        this.Qc.g(new ArrayList(this.Qh));
      }
      synchronized (this.mLock)
      {
        p localp = this.Qc.gO();
        this.Qj = localp.gt();
        localp.gs();
        this.NE = false;
        AppMethodBeat.o(199337);
        return;
      }
    }
  }
  
  public final void l(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(199300);
    synchronized (this.mLock)
    {
      K(new ArrayList(paramCollection));
      if (kY()) {
        this.Qk.removeAll(paramCollection);
      }
      try
      {
        k(Collections.emptyList());
        AppMethodBeat.o(199300);
        return;
      }
      catch (a paramCollection)
      {
        paramCollection = new IllegalArgumentException("Failed to add extra fake Preview or ImageCapture use case!");
        AppMethodBeat.o(199300);
        throw paramCollection;
      }
    }
  }
  
  public static final class a
    extends Exception
  {
    public a() {}
    
    public a(String paramString)
    {
      super();
    }
  }
  
  public static final class b
  {
    private final List<String> Ql;
    
    public b(LinkedHashSet<t> paramLinkedHashSet)
    {
      AppMethodBeat.i(199117);
      this.Ql = new ArrayList();
      paramLinkedHashSet = paramLinkedHashSet.iterator();
      while (paramLinkedHashSet.hasNext())
      {
        t localt = (t)paramLinkedHashSet.next();
        this.Ql.add(localt.gK().gV());
      }
      AppMethodBeat.o(199117);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199123);
      if ((paramObject instanceof b))
      {
        boolean bool = this.Ql.equals(((b)paramObject).Ql);
        AppMethodBeat.o(199123);
        return bool;
      }
      AppMethodBeat.o(199123);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(199130);
      int i = this.Ql.hashCode();
      AppMethodBeat.o(199130);
      return i * 53;
    }
  }
  
  static final class c
  {
    bk<?> JG;
    bk<?> JK;
    
    c(bk<?> parambk1, bk<?> parambk2)
    {
      this.JG = parambk1;
      this.JK = parambk2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.c
 * JD-Core Version:    0.7.0.1
 */