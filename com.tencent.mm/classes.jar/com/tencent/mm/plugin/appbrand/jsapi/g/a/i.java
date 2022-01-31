package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.plugin.appbrand.widget.d.e;
import java.util.LinkedList;

public final class i
{
  private static LinkedList<View> gvg = new LinkedList();
  private static LinkedList<e> gvh = new LinkedList();
  private static LinkedList<c> gvi = new LinkedList();
  
  public static boolean a(c paramc)
  {
    synchronized (gvi)
    {
      if (gvi.size() > 0) {
        return false;
      }
      gvi.push(paramc);
      return true;
    }
  }
  
  public static boolean a(e parame)
  {
    synchronized (gvh)
    {
      if (gvh.size() > 0) {
        return false;
      }
      gvh.push(parame);
      return true;
    }
  }
  
  public static c ajs()
  {
    synchronized (gvi)
    {
      if (gvi.size() <= 0) {
        return null;
      }
      c localc = (c)gvi.removeFirst();
      bS(localc);
      return localc;
    }
  }
  
  public static e ajt()
  {
    synchronized (gvh)
    {
      if (gvh.size() <= 0) {
        return null;
      }
      e locale = (e)gvh.removeFirst();
      bS(locale);
      return locale;
    }
  }
  
  private static void bS(View paramView)
  {
    if (paramView == null) {}
    while (!ViewGroup.class.isInstance(paramView.getParent())) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.i
 * JD-Core Version:    0.7.0.1
 */