package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.ViewTreeObserver;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.j.a;

public final class c
{
  final aa hwK;
  final e hwL;
  public final j.a hwX = new j.a()
  {
    public final void arP()
    {
      c.this.hwZ = -2147483648;
      c.this.mZ(3);
    }
    
    public final void arQ()
    {
      c.this.hwZ = -2147483648;
      c.this.mZ(3);
    }
  };
  public q hwY;
  int hwZ = -2147483648;
  boolean hxa = false;
  
  c(aa paramaa, e parame)
  {
    this.hwK = paramaa;
    this.hwL = parame;
  }
  
  final void mZ(int paramInt)
  {
    AutoFillListPopupWindowBase.a locala = this.hwL.hxe;
    if (locala == null) {}
    while (!this.hwL.afe.isShowing()) {
      return;
    }
    if ((1 == paramInt) && (this.hxa))
    {
      this.hwZ = -2147483648;
      this.hxa = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new c.3(this, locala, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */