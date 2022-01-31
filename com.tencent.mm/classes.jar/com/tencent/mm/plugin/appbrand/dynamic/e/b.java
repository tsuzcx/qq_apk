package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.mm.ui.widget.MMWebView;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static volatile boolean dJj;
  private static final List<b.a> fWs = new LinkedList();
  
  public static boolean a(b.a parama)
  {
    if (fWs.contains(parama)) {
      return false;
    }
    if (dJj)
    {
      parama.aaK();
      return true;
    }
    return fWs.add(parama);
  }
  
  public static void initialize()
  {
    if (dJj) {
      return;
    }
    b.1 local1 = new b.1();
    com.tencent.mm.cl.b.a(MMWebView.wkp, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.b
 * JD-Core Version:    0.7.0.1
 */