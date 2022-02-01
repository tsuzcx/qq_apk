package com.tencent.luggage.k;

import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"removeUiRunnable", "", "task", "Ljava/lang/Runnable;", "uiThread", "block", "Lkotlin/Function0;", "delay", "", "isNotNull", "", "", "isNull", "optStringStrictly", "", "Lorg/json/JSONObject;", "name", "fallback", "startsWithIgnoreCase", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "luggage-commons_release"})
public final class c
{
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(207976);
    p.k(paramJSONObject, "$this$optStringStrictly");
    p.k(paramString, "name");
    paramJSONObject = a(paramJSONObject, paramString, "");
    AppMethodBeat.o(207976);
    return paramJSONObject;
  }
  
  public static final String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207977);
    p.k(paramJSONObject, "$this$optStringStrictly");
    p.k(paramString1, "name");
    p.k(paramString2, "fallback");
    paramJSONObject = paramJSONObject.opt(paramString1);
    if ((paramJSONObject instanceof String))
    {
      paramJSONObject = (String)paramJSONObject;
      AppMethodBeat.o(207977);
      return paramJSONObject;
    }
    AppMethodBeat.o(207977);
    return paramString2;
  }
  
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(207970);
    p.k(paramString1, "$this$startsWithIgnoreCase");
    p.k(paramString2, "prefix");
    if (n.ba((CharSequence)paramString2))
    {
      AppMethodBeat.o(207970);
      return false;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      if (!URLUtil.isHttpUrl(paramString1)) {
        break label73;
      }
      str = paramString1.substring(7);
      p.j(str, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      paramBoolean = l.J(str, paramString2);
      AppMethodBeat.o(207970);
      return paramBoolean;
      label73:
      str = paramString1;
      if (URLUtil.isHttpsUrl(paramString1))
      {
        str = paramString1.substring(8);
        p.j(str, "(this as java.lang.String).substring(startIndex)");
      }
    }
  }
  
  public static final void uiThread(a<x> parama)
  {
    AppMethodBeat.i(207979);
    p.k(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (p.h(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(207979);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new d(parama));
    AppMethodBeat.o(207979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.k.c
 * JD-Core Version:    0.7.0.1
 */