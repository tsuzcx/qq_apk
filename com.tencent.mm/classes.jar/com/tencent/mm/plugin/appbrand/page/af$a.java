package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class af$a
  implements bd.a
{
  float iyO;
  float iyP;
  View view;
  float x;
  float y;
  
  public final void dn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91095);
    this.iyO = paramInt1;
    this.iyP = paramInt2;
    this.view.setX(this.x + paramInt1);
    this.view.setY(this.y + paramInt2);
    AppMethodBeat.o(91095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af.a
 * JD-Core Version:    0.7.0.1
 */