package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.b;
import com.tencent.mm.plugin.appbrand.widget.d.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> jVT;
  private static LinkedList<d> jVU;
  private static LinkedList<b> jVV;
  
  static
  {
    AppMethodBeat.i(146564);
    jVT = new LinkedList();
    jVU = new LinkedList();
    jVV = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (jVV)
    {
      if (jVV.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      jVV.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (jVU)
    {
      if (jVU.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      jVU.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b baF()
  {
    AppMethodBeat.i(146559);
    synchronized (jVV)
    {
      if (jVV.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)jVV.removeFirst();
      cA(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d baG()
  {
    AppMethodBeat.i(146561);
    synchronized (jVU)
    {
      if (jVU.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)jVU.removeFirst();
      cA(locald);
      AppMethodBeat.o(146561);
      return locald;
    }
  }
  
  private static void cA(View paramView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.i
 * JD-Core Version:    0.7.0.1
 */