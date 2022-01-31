package a.j.b.a.c.e.b.a;

import a.a.ad;
import a.a.x;
import a.a.y;
import a.i.e;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.b.b.g;
import a.j.b.a.c.e.b.b.g.b;
import a.j.b.a.c.e.b.b.g.b.b;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  implements c
{
  private static final List<String> Cqn;
  private static final Map<String, Integer> Cqo;
  public static final h.a Cqp;
  private final Set<Integer> Cql;
  private final b.g Cqm;
  private final List<b.g.b> kNQ;
  private final String[] strings;
  
  static
  {
    AppMethodBeat.i(121327);
    Cqp = new h.a((byte)0);
    Object localObject1 = a.a.j.listOf(new String[] { "kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator" });
    Cqn = (List)localObject1;
    Object localObject2 = a.a.j.p((Iterable)localObject1);
    localObject1 = (Map)new LinkedHashMap(e.iE(ad.TQ(a.a.j.d((Iterable)localObject2)), 16));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put((String)((y)localObject3).value, Integer.valueOf(((y)localObject3).index));
    }
    Cqo = (Map)localObject1;
    AppMethodBeat.o(121327);
  }
  
  public h(b.g paramg, String[] paramArrayOfString)
  {
    AppMethodBeat.i(121326);
    this.Cqm = paramg;
    this.strings = paramArrayOfString;
    paramg = this.Cqm.CpK;
    if (paramg.isEmpty()) {}
    for (paramg = (Set)x.BMz;; paramg = a.a.j.o((Iterable)paramg))
    {
      this.Cql = paramg;
      paramg = new ArrayList();
      paramArrayOfString = this.Cqm.CpJ;
      paramg.ensureCapacity(paramArrayOfString.size());
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        b.g.b localb = (b.g.b)paramArrayOfString.next();
        a.f.b.j.p(localb, "record");
        int j = localb.CpN;
        int i = 0;
        while (i < j)
        {
          paramg.add(localb);
          i += 1;
        }
      }
    }
    paramg.trimToSize();
    this.kNQ = ((List)paramg);
    AppMethodBeat.o(121326);
  }
  
  public final String Vp(int paramInt)
  {
    AppMethodBeat.i(121324);
    String str = getString(paramInt);
    AppMethodBeat.o(121324);
    return str;
  }
  
  public final boolean Vq(int paramInt)
  {
    AppMethodBeat.i(121325);
    boolean bool = this.Cql.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(121325);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(121323);
    Object localObject3 = (b.g.b)this.kNQ.get(paramInt);
    if (((b.g.b)localObject3).elL()) {
      localObject1 = ((b.g.b)localObject3).getString();
    }
    Object localObject4;
    int i;
    for (;;)
    {
      localObject2 = localObject1;
      if (((b.g.b)localObject3).elO() < 2) {
        break label286;
      }
      localObject2 = ((b.g.b)localObject3).CpR;
      localObject4 = (Integer)((List)localObject2).get(0);
      Integer localInteger = (Integer)((List)localObject2).get(1);
      a.f.b.j.p(localObject4, "begin");
      localObject2 = localObject1;
      if (a.f.b.j.compare(0, ((Integer)localObject4).intValue()) > 0) {
        break label286;
      }
      paramInt = ((Integer)localObject4).intValue();
      a.f.b.j.p(localInteger, "end");
      localObject2 = localObject1;
      if (a.f.b.j.compare(paramInt, localInteger.intValue()) > 0) {
        break label286;
      }
      localObject2 = localObject1;
      if (a.f.b.j.compare(localInteger.intValue(), ((String)localObject1).length()) > 0) {
        break label286;
      }
      a.f.b.j.p(localObject1, "string");
      paramInt = ((Integer)localObject4).intValue();
      i = localInteger.intValue();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(121323);
      throw ((Throwable)localObject1);
      int j;
      if (((b.g.b)localObject3).elK())
      {
        i = ((Collection)Cqn).size();
        j = ((b.g.b)localObject3).CpO;
        if (j >= 0) {
          break label243;
        }
      }
      label243:
      while (i <= j)
      {
        localObject1 = this.strings[paramInt];
        break;
      }
      localObject1 = (String)Cqn.get(((b.g.b)localObject3).CpO);
    }
    Object localObject2 = ((String)localObject1).substring(paramInt, i);
    a.f.b.j.p(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label286:
    Object localObject1 = localObject2;
    if (((b.g.b)localObject3).elP() >= 2)
    {
      localObject4 = ((b.g.b)localObject3).CpT;
      localObject1 = (Integer)((List)localObject4).get(0);
      localObject4 = (Integer)((List)localObject4).get(1);
      a.f.b.j.p(localObject2, "string");
      localObject1 = m.a((String)localObject2, (char)((Integer)localObject1).intValue(), (char)((Integer)localObject4).intValue());
    }
    localObject2 = ((b.g.b)localObject3).CpQ;
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = b.g.b.b.CpV;
    }
    localObject2 = localObject1;
    switch (i.bLo[localObject3.ordinal()])
    {
    default: 
      localObject2 = localObject1;
    }
    for (;;)
    {
      a.f.b.j.p(localObject2, "string");
      AppMethodBeat.o(121323);
      return localObject2;
      a.f.b.j.p(localObject1, "string");
      localObject2 = m.a((String)localObject1, '$', '.');
      continue;
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 2)
      {
        a.f.b.j.p(localObject1, "string");
        paramInt = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(121323);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(1, paramInt - 1);
        a.f.b.j.p(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      a.f.b.j.p(localObject2, "string");
      localObject2 = m.a((String)localObject2, '$', '.');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.h
 * JD-Core Version:    0.7.0.1
 */