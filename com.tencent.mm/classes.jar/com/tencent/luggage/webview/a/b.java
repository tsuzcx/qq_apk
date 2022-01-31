package com.tencent.luggage.webview.a;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private final LinkedList<Pair<c, Pattern>> bFK;
  
  public b()
  {
    AppMethodBeat.i(90944);
    this.bFK = new LinkedList();
    AppMethodBeat.o(90944);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(90945);
    Object localObject = paramc.xd();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = null;; localObject = Pattern.compile((String)localObject))
    {
      this.bFK.add(new Pair(paramc, localObject));
      AppMethodBeat.o(90945);
      return;
    }
  }
  
  public final WebResourceResponse cj(String paramString)
  {
    AppMethodBeat.i(90946);
    Iterator localIterator = this.bFK.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Pair)localIterator.next();
      Object localObject1 = (c)((Pair)localObject2).first;
      localObject2 = (Pattern)((Pair)localObject2).second;
      if ((localObject2 != null) && (((Pattern)localObject2).matcher(paramString).matches()))
      {
        localObject1 = ((c)localObject1).bG(paramString);
        if (localObject1 != null)
        {
          AppMethodBeat.o(90946);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(90946);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.webview.a.b
 * JD-Core Version:    0.7.0.1
 */