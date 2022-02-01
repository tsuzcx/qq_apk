package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.b;
import com.tencent.mm.plugin.appbrand.widget.d.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> kwF;
  private static LinkedList<d> kwG;
  private static LinkedList<b> kwH;
  
  static
  {
    AppMethodBeat.i(146564);
    kwF = new LinkedList();
    kwG = new LinkedList();
    kwH = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (kwH)
    {
      if (kwH.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      kwH.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (kwG)
    {
      if (kwG.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      kwG.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b bhy()
  {
    AppMethodBeat.i(146559);
    synchronized (kwH)
    {
      if (kwH.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)kwH.removeFirst();
      cC(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d bhz()
  {
    AppMethodBeat.i(146561);
    synchronized (kwG)
    {
      if (kwG.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)kwG.removeFirst();
      cC(locald);
      AppMethodBeat.o(146561);
      return locald;
    }
  }
  
  private static void cC(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.i
 * JD-Core Version:    0.7.0.1
 */