package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public final class al
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View hws;
  private final al.a hwt;
  private int hwu;
  private int hwv;
  private boolean hww;
  
  private al(View paramView, al.a parama)
  {
    this.hws = paramView;
    this.hwt = parama;
  }
  
  public static void a(View paramView, al.a parama)
  {
    paramView = new al(paramView, parama);
    paramView.hws.getViewTreeObserver().addOnGlobalLayoutListener(paramView);
  }
  
  public final void onGlobalLayout()
  {
    if (!this.hww)
    {
      this.hww = true;
      this.hwu = this.hws.getWidth();
      this.hwv = this.hws.getHeight();
    }
    while ((this.hws.getWidth() == this.hwu) && (this.hws.getHeight() == this.hwv)) {
      return;
    }
    this.hwt.arG();
    this.hwu = this.hws.getWidth();
    this.hwv = this.hws.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */