package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.f.a;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.af;

public final class h
{
  private static final h htq = new h();
  private final a<af, Integer> htp = new a();
  
  public static h arM()
  {
    return htq;
  }
  
  final void e(af paramaf)
  {
    if (paramaf == null) {
      return;
    }
    this.htp.remove(paramaf);
    paramaf.getContentView().setFocusable(true);
    paramaf.getContentView().setFocusableInTouchMode(true);
  }
  
  public final void f(af paramaf)
  {
    if (paramaf == null) {
      return;
    }
    Integer localInteger2 = (Integer)this.htp.get(paramaf);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = localInteger1.intValue();
    this.htp.put(paramaf, Integer.valueOf(i + 1));
    paramaf.getContentView().setFocusable(false);
    paramaf.getContentView().setFocusableInTouchMode(false);
  }
  
  public final void g(af paramaf)
  {
    if (paramaf == null) {
      return;
    }
    Integer localInteger = (Integer)this.htp.get(paramaf);
    if (localInteger != null)
    {
      localInteger = Integer.valueOf(localInteger.intValue() - 1);
      if (localInteger.intValue() > 0) {}
    }
    else
    {
      e(paramaf);
      return;
    }
    this.htp.put(paramaf, localInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */