package a.j.b.a.c.h;

import a.f.b.j;
import a.j.b.a.c.f.c;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  public static final String g(c paramc)
  {
    AppMethodBeat.i(121916);
    j.q(paramc, "receiver$0");
    paramc = paramc.emj();
    j.p(paramc, "pathSegments()");
    paramc = gg(paramc);
    AppMethodBeat.o(121916);
    return paramc;
  }
  
  public static final String gg(List<f> paramList)
  {
    AppMethodBeat.i(121917);
    j.q(paramList, "pathSegments");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(y(localf));
    }
    paramList = localStringBuilder.toString();
    j.p(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(121917);
    return paramList;
  }
  
  public static final String y(f paramf)
  {
    AppMethodBeat.i(121914);
    j.q(paramf, "receiver$0");
    if (z(paramf))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramf = paramf.name;
      j.p(paramf, "asString()");
      paramf = "`".concat(String.valueOf(paramf)) + '`';
      AppMethodBeat.o(121914);
      return paramf;
    }
    paramf = paramf.name;
    j.p(paramf, "asString()");
    AppMethodBeat.o(121914);
    return paramf;
  }
  
  private static final boolean z(f paramf)
  {
    AppMethodBeat.i(121915);
    if (paramf.CqN)
    {
      AppMethodBeat.o(121915);
      return false;
    }
    paramf = paramf.name;
    j.p(paramf, "asString()");
    int j;
    if (!l.Cvi.contains(paramf))
    {
      paramf = (CharSequence)paramf;
      i = 0;
      if (i >= paramf.length()) {
        break label111;
      }
      char c = paramf.charAt(i);
      if ((Character.isLetterOrDigit(c)) || (c == '_')) {
        break label99;
      }
      j = 1;
      label82:
      if (j == 0) {
        break label104;
      }
    }
    label99:
    label104:
    label111:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label116;
      }
      AppMethodBeat.o(121915);
      return true;
      j = 0;
      break label82;
      i += 1;
      break;
    }
    label116:
    AppMethodBeat.o(121915);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.h.q
 * JD-Core Version:    0.7.0.1
 */