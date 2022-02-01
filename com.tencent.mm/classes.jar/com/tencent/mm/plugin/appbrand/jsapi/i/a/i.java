package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.b;
import com.tencent.mm.plugin.appbrand.widget.d.d;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> kSL;
  private static LinkedList<d> kSM;
  private static LinkedList<b> kSN;
  
  static
  {
    AppMethodBeat.i(146564);
    kSL = new LinkedList();
    kSM = new LinkedList();
    kSN = new LinkedList();
    AppMethodBeat.o(146564);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(146560);
    synchronized (kSN)
    {
      if (kSN.size() > 0)
      {
        AppMethodBeat.o(146560);
        return false;
      }
      kSN.push(paramb);
      AppMethodBeat.o(146560);
      return true;
    }
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(146562);
    synchronized (kSM)
    {
      if (kSM.size() > 0)
      {
        AppMethodBeat.o(146562);
        return false;
      }
      kSM.push(paramd);
      AppMethodBeat.o(146562);
      return true;
    }
  }
  
  public static b blf()
  {
    AppMethodBeat.i(146559);
    synchronized (kSN)
    {
      if (kSN.size() <= 0)
      {
        AppMethodBeat.o(146559);
        return null;
      }
      b localb = (b)kSN.removeFirst();
      cD(localb);
      AppMethodBeat.o(146559);
      return localb;
    }
  }
  
  public static d blg()
  {
    AppMethodBeat.i(146561);
    synchronized (kSM)
    {
      if (kSM.size() <= 0)
      {
        AppMethodBeat.o(146561);
        return null;
      }
      d locald = (d)kSM.removeFirst();
      cD(locald);
      AppMethodBeat.o(146561);
      return locald;
    }
  }
  
  private static void cD(View paramView)
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