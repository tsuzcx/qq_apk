package a.j.b.a.c.d.b;

import a.aa;
import a.j.b.a.c.i.d.c;
import a.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
  implements k<j>
{
  public static final l Cjt;
  
  static
  {
    AppMethodBeat.i(120283);
    Cjt = new l();
    AppMethodBeat.o(120283);
  }
  
  private j ayK(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(120276);
    a.f.b.j.q(paramString, "representation");
    if (paramString.length() > 0) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("empty string as JvmType");
      AppMethodBeat.o(120276);
      throw paramString;
    }
    int m = paramString.charAt(0);
    c[] arrayOfc = c.values();
    int n = arrayOfc.length;
    i = 0;
    Object localObject;
    if (i < n)
    {
      localObject = arrayOfc[i];
      if (((c)localObject).desc.charAt(0) == m)
      {
        j = 1;
        label105:
        if (j == 0) {
          break label139;
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label152;
      }
      paramString = (j)new j.c((c)localObject);
      AppMethodBeat.o(120276);
      return paramString;
      j = 0;
      break label105;
      label139:
      i += 1;
      break;
      localObject = null;
    }
    switch (m)
    {
    default: 
      label152:
      i = k;
      if (m == 76)
      {
        localObject = (CharSequence)paramString;
        a.f.b.j.q(localObject, "receiver$0");
        if ((((CharSequence)localObject).length() <= 0) || (!a.a(((CharSequence)localObject).charAt(a.l.m.ar((CharSequence)localObject)), ';', false))) {
          break label348;
        }
      }
      break;
    }
    label348:
    for (int j = 1;; j = 0)
    {
      i = k;
      if (j != 0) {
        i = 1;
      }
      if ((!aa.BMh) || (i != 0)) {
        break;
      }
      paramString = (Throwable)new AssertionError("Type that is not primitive nor array should be Object, but '" + paramString + "' was found");
      AppMethodBeat.o(120276);
      throw paramString;
      paramString = (j)new j.c(null);
      AppMethodBeat.o(120276);
      return paramString;
      paramString = paramString.substring(1);
      a.f.b.j.p(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = (j)new j.a(ayK(paramString));
      AppMethodBeat.o(120276);
      return paramString;
    }
    paramString = paramString.substring(1, paramString.length() - 1);
    a.f.b.j.p(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = (j)new j.b(paramString);
    AppMethodBeat.o(120276);
    return paramString;
  }
  
  private static j.b ayL(String paramString)
  {
    AppMethodBeat.i(120278);
    a.f.b.j.q(paramString, "internalName");
    paramString = new j.b(paramString);
    AppMethodBeat.o(120278);
    return paramString;
  }
  
  public final String a(j paramj)
  {
    AppMethodBeat.i(120280);
    a.f.b.j.q(paramj, "type");
    if ((paramj instanceof j.a))
    {
      paramj = "[" + a(((j.a)paramj).Cjq);
      AppMethodBeat.o(120280);
      return paramj;
    }
    if ((paramj instanceof j.c))
    {
      paramj = ((j.c)paramj).Cjs;
      if (paramj != null)
      {
        paramj = paramj.desc;
        if (paramj != null) {}
      }
      else
      {
        AppMethodBeat.o(120280);
        return "V";
      }
    }
    else
    {
      if ((paramj instanceof j.b))
      {
        paramj = "L" + ((j.b)paramj).Cjr + ";";
        AppMethodBeat.o(120280);
        return paramj;
      }
      paramj = new a.m();
      AppMethodBeat.o(120280);
      throw paramj;
    }
    AppMethodBeat.o(120280);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.b.l
 * JD-Core Version:    0.7.0.1
 */