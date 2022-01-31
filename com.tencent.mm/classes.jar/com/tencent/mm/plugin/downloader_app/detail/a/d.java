package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.mm.plugin.webview.luggage.jsapi.ae;
import com.tencent.mm.plugin.webview.luggage.jsapi.o;
import com.tencent.mm.plugin.webview.luggage.jsapi.w;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<Class<? extends com.tencent.luggage.e.a>> iRP;
  
  private static void O(Class<? extends com.tencent.luggage.e.a> paramClass)
  {
    iRP.add(paramClass);
  }
  
  public static LinkedList<Class<? extends com.tencent.luggage.e.a>> aGk()
  {
    try
    {
      iRP = new LinkedList();
      O(a.class);
      O(e.class);
      O(f.class);
      O(ae.class);
      O(w.class);
      O(o.class);
      O(c.class);
      O(b.class);
      LinkedList localLinkedList = iRP;
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