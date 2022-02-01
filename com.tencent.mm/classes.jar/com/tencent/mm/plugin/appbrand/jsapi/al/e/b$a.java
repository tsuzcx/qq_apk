package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$Companion;", "", "()V", "TAG", "", "getFormatTime", "timeMs", "", "getMsTime", "", "formatTime", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static String BH(int paramInt)
  {
    AppMethodBeat.i(139655);
    Object localObject = new StringBuilder();
    Formatter localFormatter = new Formatter((Appendable)localObject, Locale.getDefault());
    paramInt /= 1000;
    int i = paramInt / 60;
    int j = paramInt / 3600;
    ((StringBuilder)localObject).setLength(0);
    localObject = localFormatter.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i % 60), Integer.valueOf(paramInt % 60) }).toString();
    s.s(localObject, "formatter.format(\"%02d:%…utes, seconds).toString()");
    AppMethodBeat.o(139655);
    return localObject;
  }
  
  public static long acI(String paramString)
  {
    AppMethodBeat.i(139656);
    Object localObject = String.valueOf(paramString);
    paramString = (String)localObject;
    if (n.g((CharSequence)localObject, ".") != -1)
    {
      i = n.g((CharSequence)localObject, ".");
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(139656);
        throw paramString;
      }
      paramString = ((String)localObject).substring(0, i);
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    localObject = (CharSequence)paramString;
    localObject = new k(":").o((CharSequence)localObject, 0);
    ListIterator localListIterator;
    if (!((List)localObject).isEmpty())
    {
      localListIterator = ((List)localObject).listIterator(((List)localObject).size());
      if (localListIterator.hasPrevious()) {
        if (((CharSequence)localListIterator.previous()).length() == 0)
        {
          i = 1;
          label157:
          if (i != 0) {
            break label221;
          }
        }
      }
    }
    for (localObject = p.c((Iterable)localObject, localListIterator.nextIndex() + 1);; localObject = (List)ab.aivy)
    {
      localObject = ((Collection)localObject).toArray(new String[0]);
      if (localObject != null) {
        break label234;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(139656);
      throw paramString;
      i = 0;
      break label157;
      label221:
      break;
    }
    label234:
    localObject = (String[])localObject;
    if (localObject.length == 3) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(s.X("Can't parse time string: ", paramString).toString());
      AppMethodBeat.o(139656);
      throw paramString;
    }
    long l1 = Long.parseLong(localObject[0]);
    long l2 = Long.parseLong(localObject[1]);
    long l3 = Long.parseLong(localObject[2]);
    AppMethodBeat.o(139656);
    return (l3 + (l2 * 60L + l1 * 3600L)) * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.b.a
 * JD-Core Version:    0.7.0.1
 */