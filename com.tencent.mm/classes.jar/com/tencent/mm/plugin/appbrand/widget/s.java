package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "", "(Ljava/lang/String;I)V", "NONE", "NOT_FULL_SCREEN", "FULL_SCREEN", "DISMISS", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum s
{
  static
  {
    AppMethodBeat.i(323950);
    uxV = new s("NONE", 0);
    uxW = new s("NOT_FULL_SCREEN", 1);
    uxX = new s("FULL_SCREEN", 2);
    uxY = new s("DISMISS", 3);
    uxZ = new s[] { uxV, uxW, uxX, uxY };
    AppMethodBeat.o(323950);
  }
  
  private s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.s
 * JD-Core Version:    0.7.0.1
 */