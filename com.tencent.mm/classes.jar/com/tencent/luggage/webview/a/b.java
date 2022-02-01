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
  private final LinkedList<Pair<c, Pattern>> cqH;
  
  public b()
  {
    AppMethodBeat.i(140557);
    this.cqH = new LinkedList();
    AppMethodBeat.o(140557);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(140558);
    Object localObject = paramc.Fw();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = null;; localObject = Pattern.compile((String)localObject))
    {
      this.cqH.add(new Pair(paramc, localObject));
      AppMethodBeat.o(140558);
      return;
    }
  }
  
  public final WebResourceResponse dt(String paramString)
  {
    AppMethodBeat.i(140559);
    Iterator localIterator = this.cqH.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Pair)localIterator.next();
      Object localObject1 = (c)((Pair)localObject2).first;
      localObject2 = (Pattern)((Pair)localObject2).second;
      if ((localObject2 != null) && (((Pattern)localObject2).matcher(paramString).matches()))
      {
        localObject1 = ((c)localObject1).cF(paramString);
        if (localObject1 != null)
        {
          AppMethodBeat.o(140559);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(140559);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.webview.a.b
 * JD-Core Version:    0.7.0.1
 */