package a.j.b.a.e;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader;", "", "()V", "cache", "Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "getCache", "()Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "setCache", "(Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;)V", "buildCache", "member", "Ljava/lang/reflect/Member;", "loadParameterNames", "", "", "Cache", "descriptors.runtime"})
final class a
{
  private static a.a CFy;
  public static final a CFz;
  
  static
  {
    AppMethodBeat.i(123009);
    CFz = new a();
    AppMethodBeat.o(123009);
  }
  
  private static a.a a(Member paramMember)
  {
    AppMethodBeat.i(123007);
    j.q(paramMember, "member");
    paramMember = paramMember.getClass();
    try
    {
      Method localMethod = paramMember.getMethod("getParameters", new Class[0]);
      paramMember = new a.a(localMethod, b.aQ(paramMember).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
      AppMethodBeat.o(123007);
      return paramMember;
    }
    catch (NoSuchMethodException paramMember)
    {
      paramMember = new a.a(null, null);
      AppMethodBeat.o(123007);
    }
    return paramMember;
  }
  
  public static List<String> b(Member paramMember)
  {
    AppMethodBeat.i(123008);
    j.q(paramMember, "member");
    Object localObject2 = CFy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramMember);
      CFy = (a.a)localObject1;
    }
    localObject2 = ((a.a)localObject1).CFA;
    if (localObject2 == null)
    {
      AppMethodBeat.o(123008);
      return null;
    }
    localObject1 = ((a.a)localObject1).CFB;
    if (localObject1 == null)
    {
      AppMethodBeat.o(123008);
      return null;
    }
    paramMember = ((Method)localObject2).invoke(paramMember, new Object[0]);
    if (paramMember == null)
    {
      paramMember = new v("null cannot be cast to non-null type kotlin.Array<*>");
      AppMethodBeat.o(123008);
      throw paramMember;
    }
    paramMember = (Object[])paramMember;
    localObject2 = (Collection)new ArrayList(paramMember.length);
    int j = paramMember.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = ((Method)localObject1).invoke(paramMember[i], new Object[0]);
      if (localObject3 == null)
      {
        paramMember = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(123008);
        throw paramMember;
      }
      ((Collection)localObject2).add((String)localObject3);
      i += 1;
    }
    paramMember = (List)localObject2;
    AppMethodBeat.o(123008);
    return paramMember;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */