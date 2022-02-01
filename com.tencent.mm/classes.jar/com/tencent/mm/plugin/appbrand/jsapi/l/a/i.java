package com.tencent.mm.plugin.appbrand.jsapi.l.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.f.b;
import com.tencent.mm.plugin.appbrand.widget.f.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> oZu;
  private static LinkedList<d> oZv;
  private static LinkedList<b> oZw;
  
  static
  {
    AppMethodBeat.i(146564);
    oZu = new LinkedList();
    oZv = new LinkedList();
    oZw = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (oZw)
    {
      if (oZw.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      oZw.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (oZv)
    {
      if (oZv.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      oZv.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b bSU()
  {
    AppMethodBeat.i(146559);
    synchronized (oZw)
    {
      if (oZw.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)oZw.removeFirst();
      detachView(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d bSV()
  {
    AppMethodBeat.i(146561);
    synchronized (oZv)
    {
      if (oZv.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)oZv.removeFirst();
      detachView(locald);
      AppMethodBeat.o(146561);
      return locald;
    }
  }
  
  private static void detachView(View paramView)
  {
    AppMethodBeat.i(146563);
    if (paramView == null)
    {
      AppMethodBeat.o(146563);
      return;
    }
    if (!ViewGroup.class.isInstance(paramView.getParent()))
    {
      AppMethodBeat.o(146563);
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
    AppMethodBeat.o(146563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.i
 * JD-Core Version:    0.7.0.1
 */