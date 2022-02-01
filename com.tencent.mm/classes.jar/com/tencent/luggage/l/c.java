package com.tencent.luggage.l;

import android.os.Looper;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"removeUiRunnable", "", "task", "Ljava/lang/Runnable;", "uiThread", "block", "Lkotlin/Function0;", "delay", "", "isNotNull", "", "", "isNull", "optStringStrictly", "", "Lorg/json/JSONObject;", "name", "fallback", "startsWithIgnoreCase", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "luggage-commons_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(219975);
    s.u(paramJSONObject, "<this>");
    s.u(paramString, "name");
    paramJSONObject = a(paramJSONObject, paramString, "");
    AppMethodBeat.o(219975);
    return paramJSONObject;
  }
  
  public static final String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219983);
    s.u(paramJSONObject, "<this>");
    s.u(paramString1, "name");
    s.u(paramString2, "fallback");
    paramJSONObject = paramJSONObject.opt(paramString1);
    if ((paramJSONObject instanceof String))
    {
      paramJSONObject = (String)paramJSONObject;
      AppMethodBeat.o(219983);
      return paramJSONObject;
    }
    AppMethodBeat.o(219983);
    return paramString2;
  }
  
  public static final void a(long paramLong, a<ah> parama)
  {
    AppMethodBeat.i(220014);
    s.u(parama, "block");
    MMHandlerThread.postToMainThreadDelayed(new c..ExternalSyntheticLambda0(parama), paramLong);
    AppMethodBeat.o(220014);
  }
  
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(219956);
    s.u(paramString1, "<this>");
    s.u(paramString2, "prefix");
    if (n.bp((CharSequence)paramString2))
    {
      AppMethodBeat.o(219956);
      return false;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      if (!URLUtil.isHttpUrl(paramString1)) {
        break label73;
      }
      str = paramString1.substring(7);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      paramBoolean = m.M(str, paramString2);
      AppMethodBeat.o(219956);
      return paramBoolean;
      label73:
      str = paramString1;
      if (URLUtil.isHttpsUrl(paramString1))
      {
        str = paramString1.substring(8);
        s.s(str, "(this as java.lang.String).substring(startIndex)");
      }
    }
  }
  
  private static final void t(a parama)
  {
    AppMethodBeat.i(220023);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(220023);
  }
  
  public static final <T> ArrayList<T> toArrayList(T[] paramArrayOfT)
  {
    AppMethodBeat.i(219989);
    s.u(paramArrayOfT, "<this>");
    paramArrayOfT = k.af(paramArrayOfT);
    if ((paramArrayOfT instanceof ArrayList))
    {
      paramArrayOfT = (ArrayList)paramArrayOfT;
      AppMethodBeat.o(219989);
      return paramArrayOfT;
    }
    paramArrayOfT = new ArrayList((Collection)paramArrayOfT);
    AppMethodBeat.o(219989);
    return paramArrayOfT;
  }
  
  private static final void u(a parama)
  {
    AppMethodBeat.i(220029);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(220029);
  }
  
  public static final void uiThread(a<ah> parama)
  {
    AppMethodBeat.i(220002);
    s.u(parama, "block");
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(220002);
      return;
    }
    MMHandlerThread.postToMainThread(new c..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(220002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.l.c
 * JD-Core Version:    0.7.0.1
 */