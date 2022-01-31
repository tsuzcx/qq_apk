package a.j.b.a.c.b.c;

import a.a.j;
import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.i;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.t;
import a.j.b.a.c.b.t.a;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.ba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class p
  extends k
  implements t
{
  public List<ar> BWy;
  public List<a.j.b.a.c.b.au> BZA;
  public a.j.b.a.c.l.w BZB;
  private ak BZC;
  protected ak BZD;
  public az BZE = ay.BWS;
  public boolean BZF = false;
  public boolean BZG = false;
  public boolean BZH = false;
  public boolean BZI = false;
  public boolean BZJ = false;
  boolean BZK = false;
  boolean BZL = false;
  boolean BZM = false;
  public boolean BZN = false;
  private boolean BZO = true;
  private boolean BZP = false;
  private Collection<? extends t> BZQ = null;
  private volatile a.f.a.a<Collection<t>> BZR = null;
  private final t BZS;
  protected final b.a BZT;
  private t BZU = null;
  protected Map<a.a<?>, Object> BZV = null;
  public boolean BZi = false;
  protected a.j.b.a.c.b.w BZj;
  
  protected p(l paraml, t paramt, g paramg, f paramf, b.a parama, am paramam)
  {
    super(paraml, paramg, paramf, paramam);
    paraml = paramt;
    if (paramt == null) {
      paraml = this;
    }
    this.BZS = paraml;
    this.BZT = parama;
  }
  
  public static List<a.j.b.a.c.b.au> a(t paramt, List<a.j.b.a.c.b.au> paramList, a.j.b.a.c.l.au paramau, boolean paramBoolean1, boolean paramBoolean2, boolean[] paramArrayOfBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (a.j.b.a.c.b.au)localIterator.next();
      a.j.b.a.c.l.w localw = paramau.c(((a.j.b.a.c.b.au)localObject2).eer(), ba.CBY);
      Object localObject1 = ((a.j.b.a.c.b.au)localObject2).eeu();
      if (localObject1 == null) {}
      for (paramList = null; localw == null; paramList = paramau.c((a.j.b.a.c.l.w)localObject1, ba.CBY)) {
        return null;
      }
      if (((localw != ((a.j.b.a.c.b.au)localObject2).eer()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
        paramArrayOfBoolean[0] = true;
      }
      label132:
      int i;
      g localg;
      f localf;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramBoolean1)
      {
        localObject1 = null;
        i = ((a.j.b.a.c.b.au)localObject2).getIndex();
        localg = ((a.j.b.a.c.b.au)localObject2).ecM();
        localf = ((a.j.b.a.c.b.au)localObject2).edF();
        bool1 = ((a.j.b.a.c.b.au)localObject2).eet();
        bool2 = ((a.j.b.a.c.b.au)localObject2).eew();
        bool3 = ((a.j.b.a.c.b.au)localObject2).eex();
        if (!paramBoolean2) {
          break label245;
        }
      }
      label245:
      for (localObject2 = ((a.j.b.a.c.b.au)localObject2).ecN();; localObject2 = am.BWF)
      {
        localArrayList.add(new ai(paramt, (a.j.b.a.c.b.au)localObject1, i, localg, localf, localw, bool1, bool2, bool3, paramList, (am)localObject2));
        break;
        localObject1 = localObject2;
        break label132;
      }
    }
    return localArrayList;
  }
  
  public p a(ak paramak1, ak paramak2, List<? extends ar> paramList, List<a.j.b.a.c.b.au> paramList1, a.j.b.a.c.l.w paramw, a.j.b.a.c.b.w paramw1, az paramaz)
  {
    int k = 0;
    this.BWy = j.m(paramList);
    this.BZA = j.m(paramList1);
    this.BZB = paramw;
    this.BZj = paramw1;
    this.BZE = paramaz;
    this.BZC = paramak1;
    this.BZD = paramak2;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break;
      }
      paramak1 = (ar)paramList.get(i);
      if (paramak1.getIndex() != i) {
        throw new IllegalStateException(paramak1 + " index is " + paramak1.getIndex() + " but position is " + i);
      }
      i += 1;
    }
    do
    {
      j += 1;
      if (j >= paramList1.size()) {
        break;
      }
      paramak1 = (a.j.b.a.c.b.au)paramList1.get(j);
    } while (paramak1.getIndex() == j + 0);
    throw new IllegalStateException(paramak1 + "index is " + paramak1.getIndex() + " but position is " + j);
    return this;
  }
  
  protected abstract p a(l paraml, t paramt, b.a parama, f paramf, g paramg, am paramam);
  
  protected t a(p.a parama)
  {
    Object localObject3 = new boolean[1];
    Object localObject1;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    label69:
    label78:
    label109:
    int j;
    if (parama.Cak != null)
    {
      localObject1 = i.a(ecM(), parama.Cak);
      localObject4 = parama.BZZ;
      localObject5 = parama.BZS;
      localObject6 = parama.BZT;
      localObject7 = parama.BYN;
      boolean bool1 = parama.Cah;
      localObject2 = parama.BZS;
      if (!bool1) {
        break label195;
      }
      if (localObject2 == null) {
        break label186;
      }
      localObject2 = ((t)localObject2).ecN();
      localObject4 = a((l)localObject4, (t)localObject5, (b.a)localObject6, (f)localObject7, (g)localObject1, (am)localObject2);
      if (parama.Caj != null) {
        break label203;
      }
      localObject1 = this.BWy;
      j = localObject3[0];
      if (((List)localObject1).isEmpty()) {
        break label212;
      }
    }
    label186:
    label195:
    label203:
    label212:
    for (int i = 1;; i = 0)
    {
      localObject3[0] = (i | j);
      localObject6 = new ArrayList(((List)localObject1).size());
      localObject5 = a.j.b.a.c.l.k.a((List)localObject1, parama.BZY, (l)localObject4, (List)localObject6, (boolean[])localObject3);
      if (localObject5 != null) {
        break label217;
      }
      localObject3 = null;
      return localObject3;
      localObject1 = ecM();
      break;
      localObject2 = edO();
      break label69;
      localObject2 = am.BWF;
      break label78;
      localObject1 = parama.Caj;
      break label109;
    }
    label217:
    if (parama.Cad != null)
    {
      localObject2 = ((a.j.b.a.c.l.au)localObject5).c(parama.Cad.eer(), ba.CBY);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ac((l)localObject4, new a.j.b.a.c.i.e.a.b((a.j.b.a.c.b.a)localObject4, (a.j.b.a.c.l.w)localObject2, parama.Cad.een()), parama.Cad.ecM());
      j = localObject3[0];
      if (localObject2 != parama.Cad.eer())
      {
        i = 1;
        localObject3[0] = (i | j);
      }
    }
    for (;;)
    {
      label311:
      if (parama.BZD != null)
      {
        localObject2 = parama.BZD.e((a.j.b.a.c.l.au)localObject5);
        if (localObject2 == null)
        {
          return null;
          i = 0;
          break label311;
        }
        j = localObject3[0];
        if (localObject2 != parama.BZD)
        {
          i = 1;
          label366:
          localObject3[0] = (i | j);
        }
      }
      for (;;)
      {
        localObject7 = a((t)localObject4, parama.Cac, (a.j.b.a.c.l.au)localObject5, parama.Cai, parama.Cah, (boolean[])localObject3);
        if (localObject7 == null)
        {
          return null;
          i = 0;
          break label366;
        }
        a.j.b.a.c.l.w localw = ((a.j.b.a.c.l.au)localObject5).c(parama.Cae, ba.CBZ);
        if (localw == null) {
          return null;
        }
        j = localObject3[0];
        if (localw != parama.Cae)
        {
          i = 1;
          localObject3[0] = (i | j);
          if (localObject3[0] == 0)
          {
            localObject3 = this;
            if (parama.Cam) {
              break;
            }
          }
          ((p)localObject4).a((ak)localObject1, (ak)localObject2, (List)localObject6, (List)localObject7, localw, parama.Caa, parama.Cab);
          ((p)localObject4).BZF = this.BZF;
          ((p)localObject4).BZG = this.BZG;
          ((p)localObject4).BZi = this.BZi;
          ((p)localObject4).BZH = this.BZH;
          ((p)localObject4).BZI = this.BZI;
          ((p)localObject4).BZN = this.BZN;
          ((p)localObject4).BZJ = this.BZJ;
          ((p)localObject4).BZK = this.BZK;
          ((p)localObject4).so(this.BZO);
          ((p)localObject4).BZL = parama.BZL;
          ((p)localObject4).BZM = parama.BZM;
          if (parama.Cal == null) {
            break label730;
          }
        }
        label730:
        for (boolean bool2 = parama.Cal.booleanValue();; bool2 = this.BZP)
        {
          ((p)localObject4).sp(bool2);
          if ((parama.BZV.isEmpty()) && (this.BZV == null)) {
            break label791;
          }
          localObject1 = parama.BZV;
          if (this.BZV == null) {
            break label738;
          }
          localObject2 = this.BZV.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (!((Map)localObject1).containsKey(((Map.Entry)localObject3).getKey())) {
              ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
            }
          }
          i = 0;
          break;
        }
        label738:
        if (((Map)localObject1).size() == 1)
        {
          ((p)localObject4).BZV = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
          if ((parama.Cag) || (this.BZU != null))
          {
            if (this.BZU == null) {
              break label894;
            }
            localObject1 = this.BZU;
            ((p)localObject4).BZU = ((t)localObject1).c((a.j.b.a.c.l.au)localObject5);
          }
          if ((parama.Caf) && (!edO().edw().isEmpty()))
          {
            if (!parama.BZY.isEmpty()) {
              break label912;
            }
            parama = this.BZR;
            if (parama == null) {
              break label900;
            }
            ((p)localObject4).BZR = parama;
          }
        }
        for (;;)
        {
          label791:
          label818:
          return localObject4;
          ((p)localObject4).BZV = ((Map)localObject1);
          break;
          label894:
          localObject1 = this;
          break label818;
          label900:
          ((p)localObject4).i(edw());
          continue;
          label912:
          ((p)localObject4).BZR = new p.1(this, (a.j.b.a.c.l.au)localObject5);
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
  
  public <V> V a(a.a<V> parama)
  {
    if (this.BZV == null) {
      return null;
    }
    return this.BZV.get(parama);
  }
  
  public <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final <V> void a(a.a<V> parama, Object paramObject)
  {
    if (this.BZV == null) {
      this.BZV = new LinkedHashMap();
    }
    this.BZV.put(parama, paramObject);
  }
  
  public t b(l paraml, a.j.b.a.c.b.w paramw, az paramaz, b.a parama, boolean paramBoolean)
  {
    return edV().g(paraml).a(paramw).a(paramaz).a(parama).sn(paramBoolean).eeb();
  }
  
  public t c(a.j.b.a.c.l.au paramau)
  {
    if (paramau.BZY.isEmpty()) {
      return this;
    }
    return h(paramau).h(edO()).eeW().eeb();
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    return this.BZj;
  }
  
  public final az ecE()
  {
    return this.BZE;
  }
  
  public boolean ecI()
  {
    return this.BZH;
  }
  
  public final boolean ecJ()
  {
    return this.BZJ;
  }
  
  public final boolean ecK()
  {
    return this.BZK;
  }
  
  public boolean ecL()
  {
    return this.BZi;
  }
  
  public boolean ecW()
  {
    return this.BZI;
  }
  
  public t edO()
  {
    if (this.BZS == this) {
      return this;
    }
    return this.BZS.edO();
  }
  
  public final t edP()
  {
    return this.BZU;
  }
  
  public final boolean edQ()
  {
    return this.BZL;
  }
  
  public final boolean edR()
  {
    if (this.BZF) {
      return true;
    }
    Iterator localIterator = edO().edw().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).edR()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean edS()
  {
    if (this.BZG) {
      return true;
    }
    Iterator localIterator = edO().edw().iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).edS()) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean edT()
  {
    return this.BZM;
  }
  
  public boolean edU()
  {
    return this.BZN;
  }
  
  public t.a<? extends t> edV()
  {
    return h(a.j.b.a.c.l.au.CBL);
  }
  
  public final ak edp()
  {
    return this.BZC;
  }
  
  public final ak edq()
  {
    return this.BZD;
  }
  
  public final List<ar> edr()
  {
    return this.BWy;
  }
  
  public a.j.b.a.c.l.w eds()
  {
    return this.BZB;
  }
  
  public final List<a.j.b.a.c.b.au> edu()
  {
    return this.BZA;
  }
  
  public boolean edv()
  {
    return this.BZP;
  }
  
  public Collection<? extends t> edw()
  {
    a.f.a.a locala = this.BZR;
    if (locala != null)
    {
      this.BZQ = ((Collection)locala.invoke());
      this.BZR = null;
    }
    if (this.BZQ != null) {
      return this.BZQ;
    }
    return Collections.emptyList();
  }
  
  public final b.a edy()
  {
    return this.BZT;
  }
  
  public boolean eeV()
  {
    return this.BZO;
  }
  
  protected final p.a h(a.j.b.a.c.l.au paramau)
  {
    return new p.a(this, paramau.BZY, ecv(), this.BZj, this.BZE, this.BZT, this.BZA, this.BZC, eds());
  }
  
  public void i(Collection<? extends a.j.b.a.c.b.b> paramCollection)
  {
    this.BZQ = paramCollection;
    paramCollection = this.BZQ.iterator();
    while (paramCollection.hasNext()) {
      if (((t)paramCollection.next()).edT()) {
        this.BZM = true;
      }
    }
  }
  
  public void so(boolean paramBoolean)
  {
    this.BZO = paramBoolean;
  }
  
  public void sp(boolean paramBoolean)
  {
    this.BZP = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.p
 * JD-Core Version:    0.7.0.1
 */