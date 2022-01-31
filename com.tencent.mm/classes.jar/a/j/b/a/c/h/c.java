package a.j.b.a.c.h;

import a.aa;
import a.f.b.t;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.w;
import a.j.d;
import a.l.m;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public abstract class c
{
  public static final c CtA = c.a.h((a.f.a.b)j.CtM);
  public static final c CtB = c.a.h((a.f.a.b)f.CtI);
  public static final c CtC = c.a.h((a.f.a.b)h.CtK);
  public static final c.a CtD = new c.a((byte)0);
  public static final c Ctu = c.a.h((a.f.a.b)c.d.CtG);
  public static final c Ctv = c.a.h((a.f.a.b)c.b.CtE);
  public static final c Ctw = c.a.h((a.f.a.b)c.c.CtF);
  public static final c Ctx = c.a.h((a.f.a.b)c.e.CtH);
  public static final c Cty = c.a.h((a.f.a.b)i.CtL);
  public static final c Ctz = c.a.h((a.f.a.b)c.g.CtJ);
  
  public abstract String a(a.j.b.a.c.b.a.c paramc, a.j.b.a.c.b.a.e parame);
  
  public abstract String a(ap paramap);
  
  public abstract String a(String paramString1, String paramString2, g paramg);
  
  public abstract String b(f paramf, boolean paramBoolean);
  
  public abstract String b(w paramw);
  
  public abstract String f(a.j.b.a.c.f.c paramc);
  
  public final c h(a.f.a.b<? super i, y> paramb)
  {
    a.f.b.j.q(paramb, "changeOptions");
    if (this == null) {
      throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
    }
    j localj1 = ((e)this).CtQ;
    j localj2 = new j();
    Field[] arrayOfField = localj1.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      a.f.b.j.p(localField, "field");
      Object localObject2;
      Object localObject1;
      if ((localField.getModifiers() & 0x8) == 0)
      {
        localField.setAccessible(true);
        localObject2 = localField.get(localj1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof a.h.b)) {
          localObject1 = null;
        }
        localObject1 = (a.h.b)localObject1;
        if (localObject1 != null) {
          break label134;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label134:
        localObject2 = localField.getName();
        a.f.b.j.p(localObject2, "field.name");
        if (!m.jw((String)localObject2, "is")) {}
        for (int j = 1; (aa.BMh) && (j == 0); j = 0) {
          throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
        }
        localObject2 = (d)a.f.b.v.aG(j.class);
        String str1 = localField.getName();
        StringBuilder localStringBuilder = new StringBuilder("get");
        String str2 = localField.getName();
        a.f.b.j.p(str2, "field.name");
        localField.set(localj2, localj2.dK(((a.h.b)localObject1).a((a.j.k)new t((d)localObject2, str1, m.capitalize(str2)))));
      }
    }
    paramb.S(localj2);
    localj2.lock();
    return (c)new e(localj2);
  }
  
  public abstract String k(l paraml);
  
  static final class f
    extends a.f.b.k
    implements a.f.a.b<i, y>
  {
    public static final f CtI;
    
    static
    {
      AppMethodBeat.i(121716);
      CtI = new f();
      AppMethodBeat.o(121716);
    }
    
    f()
    {
      super();
    }
  }
  
  static final class h
    extends a.f.b.k
    implements a.f.a.b<i, y>
  {
    public static final h CtK;
    
    static
    {
      AppMethodBeat.i(121720);
      CtK = new h();
      AppMethodBeat.o(121720);
    }
    
    h()
    {
      super();
    }
  }
  
  static final class i
    extends a.f.b.k
    implements a.f.a.b<i, y>
  {
    public static final i CtL;
    
    static
    {
      AppMethodBeat.i(121722);
      CtL = new i();
      AppMethodBeat.o(121722);
    }
    
    i()
    {
      super();
    }
  }
  
  static final class j
    extends a.f.b.k
    implements a.f.a.b<i, y>
  {
    public static final j CtM;
    
    static
    {
      AppMethodBeat.i(121724);
      CtM = new j();
      AppMethodBeat.o(121724);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.h.c
 * JD-Core Version:    0.7.0.1
 */