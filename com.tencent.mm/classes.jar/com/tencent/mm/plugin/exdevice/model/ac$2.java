package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.al;

final class ac$2
  implements g
{
  ac$2(ac paramac, ac.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(19375);
    if (this.lFV.eUJ)
    {
      this.lFV.lFT = false;
      AppMethodBeat.o(19375);
      return;
    }
    al.d(new ac.2.1(this));
    paramString = this.lFV.J(paramb.bitmap);
    this.lFW.Lw(paramString);
    this.lFV.lFT = false;
    AppMethodBeat.o(19375);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac.2
 * JD-Core Version:    0.7.0.1
 */