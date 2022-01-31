package a.j.b.a.c.e.b.a;

import a.f.a.b;
import a.f.b.z;
import a.j.b.a.c.e.a.d;
import a.j.b.a.c.e.b.a.c;
import a.j.b.a.c.g.o;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class k$a
{
  public static k a(byte[] paramArrayOfByte, String paramString, b<? super g, y> paramb)
  {
    AppMethodBeat.i(121339);
    a.f.b.j.q(paramString, "debugName");
    a.f.b.j.q(paramb, "reportIncompatibleVersionError");
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = k.Cqv;
      AppMethodBeat.o(121339);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new DataInputStream((InputStream)new ByteArrayInputStream(paramArrayOfByte));
    int j;
    int i;
    try
    {
      j = paramArrayOfByte.readInt();
      localObject1 = new int[j];
      i = 0;
      while (i < j)
      {
        localObject1[i] = paramArrayOfByte.readInt();
        i += 1;
      }
      localObject2 = new g(Arrays.copyOf((int[])localObject1, j));
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = k.Cqw;
      AppMethodBeat.o(121339);
      return paramArrayOfByte;
    }
    if (!((g)localObject2).elW())
    {
      paramb.S(localObject2);
      paramArrayOfByte = k.Cqv;
      AppMethodBeat.o(121339);
      return paramArrayOfByte;
    }
    if (a.j.b.a.c.e.a.j.a((a.j.b.a.c.e.a.a)localObject2))
    {
      i = paramArrayOfByte.readInt();
      if ((i & 0x1) == 0) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new g((int[])localObject1, bool);
      if (((g)localObject1).elW()) {
        break label219;
      }
      paramb.S(localObject1);
      paramArrayOfByte = k.Cqv;
      AppMethodBeat.o(121339);
      return paramArrayOfByte;
      i = 0;
      break;
    }
    label219:
    Object localObject2 = a.j.b.a.c.e.b.a.a.N((InputStream)paramArrayOfByte);
    if (localObject2 == null)
    {
      paramArrayOfByte = k.Cqv;
      AppMethodBeat.o(121339);
      return paramArrayOfByte;
    }
    Object localObject1 = new LinkedHashMap();
    Object localObject3 = ((a.j.b.a.c.e.b.a.a)localObject2).CoZ.iterator();
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (a.c)((Iterator)localObject3).next();
      a.f.b.j.p(localObject4, "proto");
      paramb = ((a.c)localObject4).ekZ();
      localObject5 = (Map)localObject1;
      a.f.b.j.p(paramb, "packageFqName");
      paramArrayOfByte = ((Map)localObject5).get(paramb);
      label376:
      String str;
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new m(paramb);
        ((Map)localObject5).put(paramb, paramArrayOfByte);
        localObject5 = (m)paramArrayOfByte;
        paramArrayOfByte = ((a.c)localObject4).Cpg;
        a.f.b.j.p(paramArrayOfByte, "proto.shortClassNameList");
        localIterator = ((Iterable)paramArrayOfByte).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label528;
        }
        str = (String)localIterator.next();
        paramArrayOfByte = ((a.c)localObject4).Cph;
        a.f.b.j.p(paramArrayOfByte, "proto.multifileFacadeShortNameIdList");
        paramArrayOfByte = (Integer)a.a.j.w(paramArrayOfByte, i);
        if (paramArrayOfByte == null) {
          break label513;
        }
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.intValue() - 1);
        label433:
        if (paramArrayOfByte == null) {
          break label518;
        }
        o localo = ((a.c)localObject4).Cpj;
        a.f.b.j.p(localo, "proto.multifileFacadeShortNameList");
        j = ((Number)paramArrayOfByte).intValue();
        paramArrayOfByte = (String)a.a.j.w((List)localo, j);
        label474:
        if (paramArrayOfByte == null) {
          break label523;
        }
      }
      label513:
      label518:
      label523:
      for (paramArrayOfByte = l.js(paramb, paramArrayOfByte);; paramArrayOfByte = null)
      {
        a.f.b.j.p(str, "partShortName");
        ((m)localObject5).jt(l.js(paramb, str), paramArrayOfByte);
        i += 1;
        break label376;
        break;
        paramArrayOfByte = null;
        break label433;
        paramArrayOfByte = null;
        break label474;
      }
      label528:
      paramArrayOfByte = ((a.c)localObject4).Cpk;
      a.f.b.j.p(paramArrayOfByte, "proto.classWithJvmPackageNameShortNameList");
      Iterator localIterator = ((Iterable)paramArrayOfByte).iterator();
      i = 0;
      label553:
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        paramArrayOfByte = ((a.c)localObject4).Cpl;
        a.f.b.j.p(paramArrayOfByte, "proto.classWithJvmPackageNamePackageIdList");
        paramb = (Integer)a.a.j.w(paramArrayOfByte, i);
        paramArrayOfByte = paramb;
        if (paramb == null)
        {
          paramArrayOfByte = ((a.c)localObject4).Cpl;
          a.f.b.j.p(paramArrayOfByte, "proto.classWithJvmPackageNamePackageIdList");
          paramArrayOfByte = (Integer)a.a.j.fT(paramArrayOfByte);
        }
        if (paramArrayOfByte != null)
        {
          j = paramArrayOfByte.intValue();
          paramArrayOfByte = ((a.j.b.a.c.e.b.a.a)localObject2).Cpb;
          a.f.b.j.p(paramArrayOfByte, "moduleProto.jvmPackageNameList");
          paramArrayOfByte = (String)a.a.j.w((List)paramArrayOfByte, j);
          if (paramArrayOfByte != null) {
            break label668;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label553;
        break;
        label668:
        a.f.b.j.p(str, "partShortName");
        ((m)localObject5).jt(l.js(paramArrayOfByte, str), null);
      }
    }
    paramb = ((a.j.b.a.c.e.b.a.a)localObject2).Cpa.iterator();
    label900:
    while (paramb.hasNext())
    {
      localObject3 = (a.c)paramb.next();
      localObject4 = (Map)localObject1;
      a.f.b.j.p(localObject3, "proto");
      localObject5 = ((a.c)localObject3).ekZ();
      a.f.b.j.p(localObject5, "proto.packageFqName");
      paramArrayOfByte = ((Map)localObject4).get(localObject5);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = ((a.c)localObject3).ekZ();
        a.f.b.j.p(paramArrayOfByte, "proto.packageFqName");
        paramArrayOfByte = new m(paramArrayOfByte);
        ((Map)localObject4).put(localObject5, paramArrayOfByte);
        paramArrayOfByte = (m)paramArrayOfByte;
        localObject3 = ((a.c)localObject3).Cpg;
        a.f.b.j.p(localObject3, "proto.shortClassNameList");
        localObject3 = ((Iterable)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label900;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        a.f.b.j.q(localObject4, "shortName");
        localObject5 = paramArrayOfByte.Cqz;
        if (localObject5 == null)
        {
          paramArrayOfByte = new v("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
          AppMethodBeat.o(121339);
          throw paramArrayOfByte;
          break;
        }
        z.dm(localObject5).add(localObject4);
      }
    }
    paramArrayOfByte = ((a.j.b.a.c.e.b.a.a)localObject2).Cpc;
    a.f.b.j.p(paramArrayOfByte, "moduleProto.stringTable");
    paramb = ((a.j.b.a.c.e.b.a.a)localObject2).Cpd;
    a.f.b.j.p(paramb, "moduleProto.qualifiedNameTable");
    paramArrayOfByte = new d(paramArrayOfByte, paramb);
    paramb = ((a.j.b.a.c.e.b.a.a)localObject2).Cno;
    a.f.b.j.p(paramb, "moduleProto.annotationList");
    localObject2 = (Iterable)paramb;
    paramb = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.j.b.a.c.e.a.a)((Iterator)localObject2).next();
      a.f.b.j.p(localObject3, "proto");
      paramb.add(paramArrayOfByte.Vp(((a.j.b.a.c.e.a.a)localObject3).Cks));
    }
    paramArrayOfByte = (List)paramb;
    paramArrayOfByte = new k((Map)localObject1, new a(paramArrayOfByte), paramString, (byte)0);
    AppMethodBeat.o(121339);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.k.a
 * JD-Core Version:    0.7.0.1
 */