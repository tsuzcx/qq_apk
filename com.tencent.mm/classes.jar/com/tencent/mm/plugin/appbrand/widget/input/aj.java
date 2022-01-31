package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.platformtools.ae;

final class aj
  extends c
{
  private static final int hwl = ae.getContext().getResources().getDimensionPixelSize(y.e.NormalTextSize);
  private e hwk = null;
  
  protected final e asu()
  {
    if (this.hwk == null) {
      this.hwk = new aj.a();
    }
    return this.hwk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj
 * JD-Core Version:    0.7.0.1
 */