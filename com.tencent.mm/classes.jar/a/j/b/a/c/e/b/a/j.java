package a.j.b.a.c.e.b.a;

import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.ai;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.e;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.s;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.a.f;
import a.j.b.a.c.e.b.b.c;
import a.j.b.a.c.e.b.b.e;
import a.j.b.a.c.e.b.b.g;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private static final a.j.b.a.c.g.g Cqq;
  public static final j Cqr;
  
  static
  {
    AppMethodBeat.i(121338);
    Cqr = new j();
    a.j.b.a.c.g.g localg = a.j.b.a.c.g.g.emB();
    a.j.b.a.c.e.b.b.a(localg);
    a.f.b.j.p(localg, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
    Cqq = localg;
    AppMethodBeat.o(121338);
  }
  
  public static f.a a(a.u paramu, a.j.b.a.c.e.a.c paramc, a.j.b.a.c.e.a.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(121334);
    a.f.b.j.q(paramu, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    a.f.b.j.q(paramh, "typeTable");
    Object localObject = (i.c)paramu;
    i.f localf = a.j.b.a.c.e.b.b.Cpq;
    a.f.b.j.p(localf, "JvmProtoBuf.propertySignature");
    localObject = (b.e)f.a((i.c)localObject, localf);
    if (localObject == null)
    {
      AppMethodBeat.o(121334);
      return null;
    }
    if (((b.e)localObject).elv()) {}
    for (localObject = ((b.e)localObject).CpE; (localObject == null) && (paramBoolean); localObject = null)
    {
      AppMethodBeat.o(121334);
      return null;
    }
    int i;
    if ((localObject != null) && (((a.j.b.a.c.e.b.b.a)localObject).eiv()))
    {
      i = ((a.j.b.a.c.e.b.b.a)localObject).ClT;
      if ((localObject == null) || (!((a.j.b.a.c.e.b.b.a)localObject).elk())) {
        break label180;
      }
      paramu = paramc.getString(((a.j.b.a.c.e.b.b.a)localObject).CpB);
    }
    label180:
    do
    {
      paramu = new f.a(paramc.getString(i), paramu);
      AppMethodBeat.o(121334);
      return paramu;
      i = paramu.ClT;
      break;
      paramh = b(a.j.b.a.c.e.a.g.a(paramu, paramh), paramc);
      paramu = paramh;
    } while (paramh != null);
    AppMethodBeat.o(121334);
    return null;
  }
  
  public static f.b a(a.e parame, a.j.b.a.c.e.a.c paramc, a.j.b.a.c.e.a.h paramh)
  {
    AppMethodBeat.i(121333);
    a.f.b.j.q(parame, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    a.f.b.j.q(paramh, "typeTable");
    Object localObject1 = (i.c)parame;
    Object localObject2 = a.j.b.a.c.e.b.b.Cpn;
    a.f.b.j.p(localObject2, "JvmProtoBuf.constructorSignature");
    localObject2 = (b.c)f.a((i.c)localObject1, (i.f)localObject2);
    if ((localObject2 != null) && (((b.c)localObject2).eiv()))
    {
      localObject1 = paramc.getString(((b.c)localObject2).ClT);
      if ((localObject2 == null) || (!((b.c)localObject2).elk())) {
        break label124;
      }
    }
    for (parame = paramc.getString(((b.c)localObject2).CpB);; parame = a.a.j.a((Iterable)parame, (CharSequence)"", (CharSequence)"(", (CharSequence)")V", 0, null, null, 56))
    {
      parame = new f.b((String)localObject1, parame);
      AppMethodBeat.o(121333);
      return parame;
      localObject1 = "<init>";
      break;
      label124:
      parame = parame.ClC;
      a.f.b.j.p(parame, "proto.valueParameterList");
      localObject2 = (Iterable)parame;
      parame = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (a.ai)((Iterator)localObject2).next();
        a.f.b.j.p(localObject3, "it");
        localObject3 = b(a.j.b.a.c.e.a.g.a((a.ai)localObject3, paramh), paramc);
        if (localObject3 == null)
        {
          AppMethodBeat.o(121333);
          return null;
        }
        parame.add(localObject3);
      }
    }
  }
  
  public static f.b a(a.o paramo, a.j.b.a.c.e.a.c paramc, a.j.b.a.c.e.a.h paramh)
  {
    AppMethodBeat.i(121332);
    a.f.b.j.q(paramo, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    a.f.b.j.q(paramh, "typeTable");
    Object localObject1 = (i.c)paramo;
    Object localObject2 = a.j.b.a.c.e.b.b.Cpo;
    a.f.b.j.p(localObject2, "JvmProtoBuf.methodSignature");
    localObject1 = (b.c)f.a((i.c)localObject1, (i.f)localObject2);
    int i;
    if ((localObject1 != null) && (((b.c)localObject1).eiv()))
    {
      i = ((b.c)localObject1).ClT;
      if ((localObject1 == null) || (!((b.c)localObject1).elk())) {
        break label128;
      }
    }
    for (paramo = paramc.getString(((b.c)localObject1).CpB);; paramo = a.a.j.a((Iterable)localObject1, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, null, 56) + paramo)
    {
      paramo = new f.b(paramc.getString(i), paramo);
      AppMethodBeat.o(121332);
      return paramo;
      i = paramo.ClT;
      break;
      label128:
      localObject1 = (Collection)a.a.j.df(a.j.b.a.c.e.a.g.b(paramo, paramh));
      localObject2 = paramo.ClC;
      a.f.b.j.p(localObject2, "proto.valueParameterList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        a.ai localai = (a.ai)((Iterator)localObject3).next();
        a.f.b.j.p(localai, "it");
        ((Collection)localObject2).add(a.j.b.a.c.e.a.g.a(localai, paramh));
      }
      localObject2 = (Iterable)a.a.j.b((Collection)localObject1, (Iterable)localObject2);
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = b((a.aa)((Iterator)localObject2).next(), paramc);
        if (localObject3 == null)
        {
          AppMethodBeat.o(121332);
          return null;
        }
        ((Collection)localObject1).add(localObject3);
      }
      localObject1 = (List)localObject1;
      paramo = b(a.j.b.a.c.e.a.g.a(paramo, paramh), paramc);
      if (paramo == null)
      {
        AppMethodBeat.o(121332);
        return null;
      }
    }
  }
  
  private static h a(InputStream paramInputStream, String[] paramArrayOfString)
  {
    AppMethodBeat.i(121331);
    paramInputStream = b.g.e(paramInputStream, Cqq);
    a.f.b.j.p(paramInputStream, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
    paramInputStream = new h(paramInputStream, paramArrayOfString);
    AppMethodBeat.o(121331);
    return paramInputStream;
  }
  
  private static String b(a.aa paramaa, a.j.b.a.c.e.a.c paramc)
  {
    AppMethodBeat.i(121336);
    if (paramaa.ejB())
    {
      paramaa = c.ayR(paramc.Vp(paramaa.CmS));
      AppMethodBeat.o(121336);
      return paramaa;
    }
    AppMethodBeat.o(121336);
    return null;
  }
  
  public static final o<h, a.c> d(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(121328);
    a.f.b.j.q(paramArrayOfString1, "data");
    a.f.b.j.q(paramArrayOfString2, "strings");
    paramArrayOfString1 = b.af(paramArrayOfString1);
    a.f.b.j.p(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    a.f.b.j.q(paramArrayOfString1, "bytes");
    a.f.b.j.q(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.c.a((InputStream)paramArrayOfString1, Cqq));
    AppMethodBeat.o(121328);
    return paramArrayOfString1;
  }
  
  public static final o<h, a.s> e(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(121329);
    a.f.b.j.q(paramArrayOfString1, "data");
    a.f.b.j.q(paramArrayOfString2, "strings");
    paramArrayOfString1 = b.af(paramArrayOfString1);
    a.f.b.j.p(paramArrayOfString1, "BitEncoding.decodeBytes(data)");
    a.f.b.j.q(paramArrayOfString1, "bytes");
    a.f.b.j.q(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(paramArrayOfString1);
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.s.c((InputStream)paramArrayOfString1, Cqq));
    AppMethodBeat.o(121329);
    return paramArrayOfString1;
  }
  
  public static a.j.b.a.c.g.g elX()
  {
    return Cqq;
  }
  
  public static final o<h, a.o> f(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(121330);
    a.f.b.j.q(paramArrayOfString1, "data");
    a.f.b.j.q(paramArrayOfString2, "strings");
    paramArrayOfString1 = new ByteArrayInputStream(b.af(paramArrayOfString1));
    paramArrayOfString1 = new o(a((InputStream)paramArrayOfString1, paramArrayOfString2), a.o.b((InputStream)paramArrayOfString1, Cqq));
    AppMethodBeat.o(121330);
    return paramArrayOfString1;
  }
  
  public static final boolean f(a.u paramu)
  {
    AppMethodBeat.i(121337);
    a.f.b.j.q(paramu, "proto");
    Object localObject = e.Cqg;
    localObject = e.elV();
    paramu = paramu.e(a.j.b.a.c.e.b.b.Cpr);
    a.f.b.j.p(paramu, "proto.getExtension(JvmProtoBuf.flags)");
    paramu = ((a.j.b.a.c.e.a.b.a)localObject).Vo(((Number)paramu).intValue());
    a.f.b.j.p(paramu, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
    boolean bool = paramu.booleanValue();
    AppMethodBeat.o(121337);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.j
 * JD-Core Version:    0.7.0.1
 */