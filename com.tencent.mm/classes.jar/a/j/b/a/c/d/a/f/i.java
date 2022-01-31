package a.j.b.a.c.d.a.f;

import a.f.a.b;
import a.f.b.k;
import a.j.b.a.c.d.b.t;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i
{
  private static final d ChF;
  private static final d ChG;
  private static final d ChH;
  private static final Map<String, j> ChI;
  
  static
  {
    AppMethodBeat.i(120143);
    ChF = new d(g.Chz, null, false);
    ChG = new d(g.ChA, null, false);
    ChH = new d(g.ChA, null, true);
    t localt = t.Cjx;
    final String str1 = t.ayM("Object");
    final String str2 = t.ayO("Predicate");
    final String str3 = t.ayO("Function");
    final String str4 = t.ayO("Consumer");
    final String str5 = t.ayO("BiFunction");
    final String str6 = t.ayO("BiConsumer");
    final String str7 = t.ayO("UnaryOperator");
    final String str8 = t.ayN("stream/Stream");
    final String str9 = t.ayN("Optional");
    m localm = new m();
    new m.a(localm, t.ayN("Iterator")).c("forEachRemaining", (b)new i.a(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, t.ayM("Iterable")).c("spliterator", (b)new i.l(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    m.a locala = new m.a(localm, t.ayN("Collection"));
    locala.c("removeIf", (b)new i.v(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("stream", (b)new w(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("parallelStream", (b)new i.x(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, t.ayN("List")).c("replaceAll", (b)new i.y(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, t.ayN("Map"));
    locala.c("forEach", (b)new i.z(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("putIfAbsent", (b)new i.aa(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("replace", (b)new i.ab(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("replace", (b)new i.b(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("replaceAll", (b)new i.c(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("compute", (b)new i.d(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("computeIfAbsent", (b)new i.e(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("computeIfPresent", (b)new i.f(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("merge", (b)new i.g(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala = new m.a(localm, str9);
    locala.c("empty", (b)new i.h(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("of", (b)new i.i(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("ofNullable", (b)new i.j(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("get", (b)new i.k(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    locala.c("ifPresent", (b)new i.m(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, t.ayM("ref/Reference")).c("get", (b)new i.n(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str2).c("test", (b)new i.o(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, t.ayO("BiPredicate")).c("test", (b)new i.p(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str4).c("accept", (b)new i.q(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str6).c("accept", (b)new i.r(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str3).c("apply", (b)new i.s(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, str5).c("apply", (b)new i.t(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    new m.a(localm, t.ayO("Supplier")).c("get", (b)new i.u(localt, str4, str2, str8, str7, str6, str1, str5, str3, str9));
    ChI = localm.Cip;
    AppMethodBeat.o(120143);
  }
  
  public static final Map<String, j> egI()
  {
    return ChI;
  }
  
  static final class w
    extends k
    implements b<m.a.a, y>
  {
    w(t paramt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.i
 * JD-Core Version:    0.7.0.1
 */