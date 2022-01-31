package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.sdk.platformtools.ah;

final class ak
  extends c
{
  private static final int jox;
  private e jow = null;
  
  static
  {
    AppMethodBeat.i(134298);
    jox = ah.getContext().getResources().getDimensionPixelSize(2131427809);
    AppMethodBeat.o(134298);
  }
  
  public final e aRy()
  {
    AppMethodBeat.i(134297);
    if (this.jow == null) {
      this.jow = new ak.a();
    }
    e locale = this.jow;
    AppMethodBeat.o(134297);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */