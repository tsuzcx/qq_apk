package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ab;
import com.tencent.mm.plugin.webview.luggage.jsapi.ao;
import com.tencent.mm.plugin.webview.luggage.jsapi.t;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.a>> oKO;
  
  private static void aM(Class<? extends com.tencent.luggage.d.a> paramClass)
  {
    AppMethodBeat.i(8828);
    oKO.add(paramClass);
    AppMethodBeat.o(8828);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.a>> bYl()
  {
    try
    {
      AppMethodBeat.i(8827);
      oKO = new LinkedList();
      aM(a.class);
      aM(e.class);
      aM(g.class);
      aM(ao.class);
      aM(ab.class);
      aM(t.class);
      aM(c.class);
      aM(b.class);
      aM(f.class);
      LinkedList localLinkedList = oKO;
      AppMethodBeat.o(8827);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.d
 * JD-Core Version:    0.7.0.1
 */