package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> mbD;
  private static LinkedList<d> mbE;
  private static LinkedList<b> mbF;
  
  static
  {
    AppMethodBeat.i(146564);
    mbD = new LinkedList();
    mbE = new LinkedList();
    mbF = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (mbF)
    {
      if (mbF.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      mbF.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (mbE)
    {
      if (mbE.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      mbE.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b bHm()
  {
    AppMethodBeat.i(146559);
    synchronized (mbF)
    {
      if (mbF.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)mbF.removeFirst();
      detachView(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d bHn()
  {
    AppMethodBeat.i(146561);
    synchronized (mbE)
    {
      if (mbE.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)mbE.removeFirst();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a.i
 * JD-Core Version:    0.7.0.1
 */