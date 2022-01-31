package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.al;
import com.tencent.mm.plugin.webview.luggage.jsapi.q;
import com.tencent.mm.plugin.webview.luggage.jsapi.y;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<Class<? extends com.tencent.luggage.d.a>> laz;
  
  private static void ai(Class<? extends com.tencent.luggage.d.a> paramClass)
  {
    AppMethodBeat.i(136073);
    laz.add(paramClass);
    AppMethodBeat.o(136073);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.d.a>> bjM()
  {
    try
    {
      AppMethodBeat.i(136072);
      laz = new LinkedList();
      ai(a.class);
      ai(e.class);
      ai(g.class);
      ai(al.class);
      ai(y.class);
      ai(q.class);
      ai(c.class);
      ai(b.class);
      ai(f.class);
      LinkedList localLinkedList = laz;
      AppMethodBeat.o(136072);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.d
 * JD-Core Version:    0.7.0.1
 */