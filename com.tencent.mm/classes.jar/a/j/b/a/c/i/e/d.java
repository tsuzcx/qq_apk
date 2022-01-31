package a.j.b.a.c.i.e;

import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final d CxA;
  public static final d CxB;
  public static final d CxC;
  public static final d CxD;
  public static final d CxE;
  public static final d CxF;
  public static final d CxG;
  public static final d CxH;
  public static final d CxI;
  public static final d CxJ;
  private static final List<d.a.a> CxK;
  private static final List<d.a.a> CxL;
  public static final d.a CxM;
  private static int Cxp;
  private static final int Cxq;
  private static final int Cxr;
  private static final int Cxs;
  private static final int Cxt;
  private static final int Cxu;
  private static final int Cxv;
  private static final int Cxw;
  private static final int Cxx;
  private static final int Cxy;
  private static final int Cxz;
  final int Cxn;
  public final List<c> Cxo;
  
  static
  {
    AppMethodBeat.i(122183);
    CxM = new d.a((byte)0);
    Cxp = 1;
    Cxq = d.a.eoj();
    Cxr = d.a.eoj();
    Cxs = d.a.eoj();
    Cxt = d.a.eoj();
    Cxu = d.a.eoj();
    Cxv = d.a.eoj();
    Cxw = d.a.eoj() - 1;
    Cxx = Cxq | Cxr | Cxs;
    Cxy = Cxr | Cxu | Cxv;
    Cxz = Cxu | Cxv;
    CxA = new d(Cxw);
    CxB = new d(Cxz);
    CxC = new d(Cxq);
    CxD = new d(Cxr);
    CxE = new d(Cxs);
    CxF = new d(Cxx);
    CxG = new d(Cxt);
    CxH = new d(Cxu);
    CxI = new d(Cxv);
    CxJ = new d(Cxy);
    Object localObject1 = d.class.getFields();
    a.f.b.j.p(localObject1, "T::class.java.fields");
    Object localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      a.f.b.j.p(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject1 = (Iterable)localObject2;
    Object localObject3 = (Collection)new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    label434:
    while (((Iterator)localObject4).hasNext())
    {
      Field localField = (Field)((Iterator)localObject4).next();
      localObject2 = localField.get(null);
      localObject1 = localObject2;
      if (!(localObject2 instanceof d)) {
        localObject1 = null;
      }
      localObject1 = (d)localObject1;
      if (localObject1 != null)
      {
        i = ((d)localObject1).Cxn;
        a.f.b.j.p(localField, "field");
        localObject1 = localField.getName();
        a.f.b.j.p(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(i, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label434;
        }
        ((Collection)localObject3).add(localObject1);
        break;
      }
    }
    CxK = a.a.j.m((Iterable)localObject3);
    localObject1 = d.class.getFields();
    a.f.b.j.p(localObject1, "T::class.java.fields");
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      a.f.b.j.p(localObject3, "it");
      if (Modifier.isStatic(((Field)localObject3).getModifiers())) {
        ((Collection)localObject2).add(localObject3);
      }
      i += 1;
    }
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (Field)localObject3;
      a.f.b.j.p(localObject4, "it");
      if (a.f.b.j.e(((Field)localObject4).getType(), Integer.TYPE)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject1).iterator();
    label701:
    label752:
    label755:
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Field)((Iterator)localObject3).next();
      localObject4 = ((Field)localObject1).get(null);
      if (localObject4 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(122183);
        throw ((Throwable)localObject1);
      }
      j = ((Integer)localObject4).intValue();
      if (j == (-j & j))
      {
        i = 1;
        if (i == 0) {
          break label752;
        }
        a.f.b.j.p(localObject1, "field");
        localObject1 = ((Field)localObject1).getName();
        a.f.b.j.p(localObject1, "field.name");
      }
      for (localObject1 = new d.a.a(j, (String)localObject1);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label755;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        i = 0;
        break label701;
      }
    }
    CxL = a.a.j.m((Iterable)localObject2);
    AppMethodBeat.o(122183);
  }
  
  public d(int paramInt, List<? extends c> paramList)
  {
    AppMethodBeat.i(122181);
    this.Cxo = paramList;
    paramList = ((Iterable)this.Cxo).iterator();
    while (paramList.hasNext()) {
      paramInt &= (((c)paramList.next()).enZ() ^ 0xFFFFFFFF);
    }
    this.Cxn = paramInt;
    AppMethodBeat.o(122181);
  }
  
  public final boolean VQ(int paramInt)
  {
    return (this.Cxn & paramInt) != 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122180);
    Object localObject2 = ((Iterable)CxK).iterator();
    int i;
    label49:
    label53:
    label67:
    Iterator localIterator;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((d.a.a)localObject1).mask == this.Cxn)
      {
        i = 1;
        if (i == 0) {
          break label154;
        }
        localObject1 = (d.a.a)localObject1;
        if (localObject1 == null) {
          break label161;
        }
        localObject1 = ((d.a.a)localObject1).name;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label195;
        }
        localObject1 = (Iterable)CxL;
        localObject2 = (Collection)new ArrayList();
        localIterator = ((Iterable)localObject1).iterator();
      }
    }
    label154:
    label161:
    label169:
    for (;;)
    {
      label99:
      if (!localIterator.hasNext()) {
        break label171;
      }
      localObject1 = (d.a.a)localIterator.next();
      if (VQ(((d.a.a)localObject1).mask)) {}
      for (localObject1 = ((d.a.a)localObject1).name;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label169;
        }
        ((Collection)localObject2).add(localObject1);
        break label99;
        i = 0;
        break label49;
        break;
        localObject1 = null;
        break label53;
        localObject1 = null;
        break label67;
      }
    }
    label171:
    localObject2 = a.a.j.a((Iterable)localObject2, (CharSequence)" | ", null, null, 0, null, null, 62);
    label195:
    Object localObject1 = "DescriptorKindFilter(" + (String)localObject2 + ", " + this.Cxo + ')';
    AppMethodBeat.o(122180);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.e.d
 * JD-Core Version:    0.7.0.1
 */