package a.j.b.a.c.d.b;

import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class t
{
  public static final t Cjx;
  
  static
  {
    AppMethodBeat.i(120319);
    Cjx = new t();
    AppMethodBeat.o(120319);
  }
  
  public static String a(e parame, String paramString)
  {
    AppMethodBeat.i(120315);
    a.f.b.j.q(parame, "classDescriptor");
    a.f.b.j.q(paramString, "jvmDescriptor");
    a.f.b.j.q(parame, "receiver$0");
    Object localObject = a.j.b.a.c.a.b.c.BVe;
    localObject = a.j.b.a.c.i.c.a.o((l)parame).CqE;
    a.f.b.j.p(localObject, "fqNameSafe.toUnsafe()");
    localObject = a.j.b.a.c.a.b.c.c((a.j.b.a.c.f.c)localObject);
    if (localObject != null)
    {
      parame = a.j.b.a.c.i.d.b.h((a.j.b.a.c.f.a)localObject);
      a.f.b.j.p(parame, "JvmClassName.byClassId(it)");
      parame = parame.Cjr;
      a.f.b.j.p(parame, "JvmClassName.byClassId(it).internalName");
    }
    for (;;)
    {
      parame = jq(parame, paramString);
      AppMethodBeat.o(120315);
      return parame;
      parame = y.a(parame, (u)v.Cjz, false);
    }
  }
  
  public static String[] ad(String... paramVarArgs)
  {
    AppMethodBeat.i(120311);
    a.f.b.j.q(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localCollection.add("<init>(" + str + ")V");
      i += 1;
    }
    paramVarArgs = ((Collection)localCollection).toArray(new String[0]);
    if (paramVarArgs == null)
    {
      paramVarArgs = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(120311);
      throw paramVarArgs;
    }
    paramVarArgs = (String[])paramVarArgs;
    AppMethodBeat.o(120311);
    return paramVarArgs;
  }
  
  public static String ayM(String paramString)
  {
    AppMethodBeat.i(120308);
    a.f.b.j.q(paramString, "name");
    paramString = "java/lang/".concat(String.valueOf(paramString));
    AppMethodBeat.o(120308);
    return paramString;
  }
  
  public static String ayN(String paramString)
  {
    AppMethodBeat.i(120309);
    a.f.b.j.q(paramString, "name");
    paramString = "java/util/".concat(String.valueOf(paramString));
    AppMethodBeat.o(120309);
    return paramString;
  }
  
  public static String ayO(String paramString)
  {
    AppMethodBeat.i(120310);
    a.f.b.j.q(paramString, "name");
    paramString = "java/util/function/".concat(String.valueOf(paramString));
    AppMethodBeat.o(120310);
    return paramString;
  }
  
  private static String ayP(String paramString)
  {
    AppMethodBeat.i(120318);
    if (paramString.length() > 1)
    {
      paramString = "L" + paramString + ';';
      AppMethodBeat.o(120318);
      return paramString;
    }
    AppMethodBeat.o(120318);
    return paramString;
  }
  
  public static String e(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(120317);
    a.f.b.j.q(paramString1, "name");
    a.f.b.j.q(paramList, "parameters");
    a.f.b.j.q(paramString2, "ret");
    paramString1 = paramString1 + '(' + a.a.j.a((Iterable)paramList, (CharSequence)"", null, null, 0, null, (a.f.a.b)t.a.Cjy, 30) + ')' + ayP(paramString2);
    AppMethodBeat.o(120317);
    return paramString1;
  }
  
  public static String jq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(120316);
    a.f.b.j.q(paramString1, "internalName");
    a.f.b.j.q(paramString2, "jvmDescriptor");
    paramString1 = paramString1 + "." + paramString2;
    AppMethodBeat.o(120316);
    return paramString1;
  }
  
  public static LinkedHashSet<String> o(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(120312);
    a.f.b.j.q(paramString, "name");
    a.f.b.j.q(paramVarArgs, "signatures");
    paramString = q(ayM(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(120312);
    return paramString;
  }
  
  public static LinkedHashSet<String> p(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(120313);
    a.f.b.j.q(paramString, "name");
    a.f.b.j.q(paramVarArgs, "signatures");
    paramString = q(ayN(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(120313);
    return paramString;
  }
  
  private static LinkedHashSet<String> q(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(120314);
    a.f.b.j.q(paramString, "internalName");
    a.f.b.j.q(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localCollection.add(paramString + "." + str);
      i += 1;
    }
    paramString = (LinkedHashSet)localCollection;
    AppMethodBeat.o(120314);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.b.t
 * JD-Core Version:    0.7.0.1
 */