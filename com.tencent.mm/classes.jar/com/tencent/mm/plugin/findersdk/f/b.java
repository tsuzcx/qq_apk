package com.tencent.mm.plugin.findersdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/trace/LiveTracker;", "", "()V", "IS_DEBUG", "", "TAG", "", "TAG2", "debugStack", "enableDebug", "", "getStack", "printLine", "maxLine", "", "logImp", "tag", "msg", "logLevel", "longLog", "log", "trace", "traceWtf", "finder-sdk_release"})
public final class b
{
  public static final b Bxg;
  private static boolean aFB;
  
  static
  {
    AppMethodBeat.i(207601);
    Bxg = new b();
    boolean bool = BuildInfo.DEBUG;
    aFB = false;
    AppMethodBeat.o(207601);
  }
  
  public static void W(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(207586);
    if (!aFB)
    {
      X(paramString1, paramString2, paramInt);
      AppMethodBeat.o(207586);
      return;
    }
    int j;
    String str;
    label60:
    int i;
    if (paramString2.length() < 4000)
    {
      X(paramString1, paramString2, paramInt);
      AppMethodBeat.o(207586);
      return;
      str = paramString2.substring(j);
      p.j(str, "(this as java.lang.String).substring(startIndex)");
      X(paramString1, "=>id:" + i + ' ' + str, paramInt);
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
          paramString1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(207586);
          throw paramString1;
        }
        if (paramString2 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(207586);
          throw paramString1;
        }
        str = paramString2.substring(j, j + 4000);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        break label60;
      }
      AppMethodBeat.o(207586);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private static void X(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(207588);
    switch (paramInt)
    {
    default: 
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(207588);
      return;
    case 2: 
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(207588);
      return;
    case 1: 
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(207588);
      return;
    case 4: 
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(207588);
      return;
    case 3: 
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(207588);
      return;
    }
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(207588);
  }
  
  public static void enX()
  {
    AppMethodBeat.i(207581);
    aFB = true;
    Log.i("Finder.LiveTracker", "enableDebug " + aFB);
    AppMethodBeat.o(207581);
  }
  
  private static String enY()
  {
    AppMethodBeat.i(207592);
    Object localObject1 = new Throwable().getStackTrace();
    if (localObject1.length < 4)
    {
      AppMethodBeat.o(207592);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = localObject1.length;
    int i = 3;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      p.j(localObject2, "stes[i]");
      localObject2 = ((StackTraceElement)localObject2).getClassName();
      p.j(localObject2, "stes[i].className");
      if (n.g((CharSequence)localObject2, (CharSequence)"com.tencent."))
      {
        localObject2 = localObject1[i];
        p.j(localObject2, "stes[i]");
        localObject2 = ((StackTraceElement)localObject2).getClassName();
        p.j(localObject2, "stes[i].className");
        if (!n.g((CharSequence)localObject2, (CharSequence)"sdk.platformtools.Log"))
        {
          localStringBuilder.append("[");
          localObject2 = localObject1[i];
          p.j(localObject2, "stes[i]");
          localObject2 = ((StackTraceElement)localObject2).getClassName();
          p.j(localObject2, "stes[i].className");
          localStringBuilder.append(n.l((String)localObject2, "com.tencent.mm", "", false));
          localStringBuilder.append(":");
          localObject2 = localObject1[i];
          p.j(localObject2, "stes[i]");
          localStringBuilder.append(((StackTraceElement)localObject2).getMethodName());
          localObject2 = new StringBuilder("(");
          Object localObject3 = localObject1[i];
          p.j(localObject3, "stes[i]");
          localStringBuilder.append(localObject3.getLineNumber() + ")]");
          if (i >= 6) {
            break;
          }
        }
      }
      i += 1;
    }
    localObject1 = localStringBuilder.toString();
    p.j(localObject1, "t.toString()");
    AppMethodBeat.o(207592);
    return localObject1;
  }
  
  public static String enZ()
  {
    AppMethodBeat.i(207595);
    if (aFB)
    {
      String str = "\nstack=>" + enY();
      AppMethodBeat.o(207595);
      return str;
    }
    AppMethodBeat.o(207595);
    return "";
  }
  
  public static void hA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207583);
    p.k(paramString1, "tag");
    p.k(paramString2, "msg");
    W("Finder.LiveTracker", paramString1 + ':' + paramString2 + ' ' + enZ(), 2);
    AppMethodBeat.o(207583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.f.b
 * JD-Core Version:    0.7.0.1
 */