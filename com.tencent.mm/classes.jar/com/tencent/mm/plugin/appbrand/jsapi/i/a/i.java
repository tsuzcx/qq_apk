package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.b;
import com.tencent.mm.plugin.appbrand.widget.d.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> kWu;
  private static LinkedList<d> kWv;
  private static LinkedList<b> kWw;
  
  static
  {
    AppMethodBeat.i(146564);
    kWu = new LinkedList();
    kWv = new LinkedList();
    kWw = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (kWw)
    {
      if (kWw.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      kWw.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (kWv)
    {
      if (kWv.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      kWv.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b blP()
  {
    AppMethodBeat.i(146559);
    synchronized (kWw)
    {
      if (kWw.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)kWw.removeFirst();
      cE(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d blQ()
  {
    AppMethodBeat.i(146561);
    synchronized (kWv)
    {
      if (kWv.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)kWv.removeFirst();
      cE(locald);
      AppMethodBeat.o(146561);
      return locald;
    }
  }
  
  private static void cE(View paramView)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.i
 * JD-Core Version:    0.7.0.1
 */