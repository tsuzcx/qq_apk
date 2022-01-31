package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> hQe;
  private static LinkedList<d> hQf;
  private static LinkedList<b> hQg;
  
  static
  {
    AppMethodBeat.i(51243);
    hQe = new LinkedList();
    hQf = new LinkedList();
    hQg = new LinkedList();
    AppMethodBeat.o(51243);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(51239);
    synchronized (hQg)
    {
      if (hQg.size() > 0)
      {
        AppMethodBeat.o(51239);
        return false;
      }
      hQg.push(paramb);
      AppMethodBeat.o(51239);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(51241);
    synchronized (hQf)
    {
      if (hQf.size() > 0)
      {
        AppMethodBeat.o(51241);
        return false;
      }
      hQf.push(paramd);
      AppMethodBeat.o(51241);
      return true;
    }
  }
  
  public static b aDI()
  {
    AppMethodBeat.i(51238);
    synchronized (hQg)
    {
      if (hQg.size() <= 0)
      {
        AppMethodBeat.o(51238);
        return null;
      }
      b localb = (b)hQg.removeFirst();
      cq(localb);
      AppMethodBeat.o(51238);
      return localb;
    }
  }
  
  public static d aDJ()
  {
    AppMethodBeat.i(51240);
    synchronized (hQf)
    {
      if (hQf.size() <= 0)
      {
        AppMethodBeat.o(51240);
        return null;
      }
      d locald = (d)hQf.removeFirst();
      cq(locald);
      AppMethodBeat.o(51240);
      return locald;
    }
  }
  
  private static void cq(View paramView)
  {
    AppMethodBeat.i(51242);
    if (paramView == null)
    {
      AppMethodBeat.o(51242);
      return;
    }
    if (!ViewGroup.class.isInstance(paramView.getParent()))
    {
      AppMethodBeat.o(51242);
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
    AppMethodBeat.o(51242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.i
 * JD-Core Version:    0.7.0.1
 */