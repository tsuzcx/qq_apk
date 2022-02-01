package com.tencent.mm.plugin.findersdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/trace/LiveTracker;", "", "()V", "IS_DEBUG", "", "TAG", "", "TAG2", "debugStack", "enableDebug", "", "getStack", "printLine", "maxLine", "", "logImp", "tag", "msg", "logLevel", "longLog", "log", "trace", "traceWtf", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b HeJ;
  private static boolean cBm;
  
  static
  {
    AppMethodBeat.i(273766);
    HeJ = new b();
    boolean bool = BuildInfo.DEBUG;
    cBm = false;
    AppMethodBeat.o(273766);
  }
  
  public static void ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(273728);
    if (!cBm)
    {
      ae(paramString1, paramString2, paramInt);
      AppMethodBeat.o(273728);
      return;
    }
    int j;
    String str;
    label60:
    int i;
    if (paramString2.length() < 4000)
    {
      ae(paramString1, paramString2, paramInt);
      AppMethodBeat.o(273728);
      return;
      str = paramString2.substring(j);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
      ae(paramString1, "=>id:" + i + ' ' + str, paramInt);
      i += 1;
      j += 4000;
    }
    for (;;)
    {
      if (j < paramString2.length())
      {
        if (paramString2.length() <= j + 4000)
        {
          if (paramString2 != null) {
            break;
          }
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(273728);
          throw paramString1;
        }
        if (paramString2 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(273728);
          throw paramString1;
        }
        str = paramString2.substring(j, j + 4000);
        s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        break label60;
      }
      AppMethodBeat.o(273728);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private static void ae(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(273735);
    switch (paramInt)
    {
    default: 
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(273735);
      return;
    case 2: 
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(273735);
      return;
    case 1: 
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(273735);
      return;
    case 4: 
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(273735);
      return;
    case 3: 
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(273735);
      return;
    }
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(273735);
  }
  
  public static void enableDebug()
  {
    AppMethodBeat.i(273707);
    cBm = true;
    Log.i("Finder.LiveTracker", s.X("enableDebug ", Boolean.valueOf(cBm)));
    AppMethodBeat.o(273707);
  }
  
  private static String ftb()
  {
    AppMethodBeat.i(273745);
    Object localObject = new Throwable().getStackTrace();
    if (localObject.length < 4)
    {
      AppMethodBeat.o(273745);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = localObject.length;
    if (3 < k) {}
    int j;
    for (int i = 3;; i = j)
    {
      j = i + 1;
      String str = localObject[i].getClassName();
      s.s(str, "stes[i].className");
      if (n.i((CharSequence)str, (CharSequence)"com.tencent."))
      {
        str = localObject[i].getClassName();
        s.s(str, "stes[i].className");
        if (!n.i((CharSequence)str, (CharSequence)"sdk.platformtools.Log"))
        {
          localStringBuilder.append("[");
          str = localObject[i].getClassName();
          s.s(str, "stes[i].className");
          localStringBuilder.append(n.bV(str, "com.tencent.mm", ""));
          localStringBuilder.append(":");
          localStringBuilder.append(localObject[i].getMethodName());
          localStringBuilder.append("(" + localObject[i].getLineNumber() + ")]");
          if (i >= 6) {
            break label216;
          }
        }
      }
      if (j >= k)
      {
        label216:
        localObject = localStringBuilder.toString();
        s.s(localObject, "t.toString()");
        AppMethodBeat.o(273745);
        return localObject;
      }
    }
  }
  
  public static String ftc()
  {
    AppMethodBeat.i(273758);
    if (cBm)
    {
      String str = s.X("\nstack=>", ftb());
      AppMethodBeat.o(273758);
      return str;
    }
    AppMethodBeat.o(273758);
    return "";
  }
  
  public static void iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273716);
    s.u(paramString1, "tag");
    s.u(paramString2, "msg");
    ad("Finder.LiveTracker", paramString1 + ':' + paramString2 + ' ' + ftc(), 2);
    AppMethodBeat.o(273716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.f.b
 * JD-Core Version:    0.7.0.1
 */