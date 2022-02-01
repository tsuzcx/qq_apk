package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.plugin.appbrand.widget.g.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> seW;
  private static LinkedList<d> seX;
  private static LinkedList<b> seY;
  
  static
  {
    AppMethodBeat.i(146564);
    seW = new LinkedList();
    seX = new LinkedList();
    seY = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (seY)
    {
      if (seY.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      seY.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (seX)
    {
      if (seX.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      seX.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b ctc()
  {
    AppMethodBeat.i(146559);
    synchronized (seY)
    {
      if (seY.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)seY.removeFirst();
      detachView(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d ctd()
  {
    AppMethodBeat.i(146561);
    synchronized (seX)
    {
      if (seX.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)seX.removeFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.i
 * JD-Core Version:    0.7.0.1
 */