package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "", "(Ljava/lang/String;I)V", "NONE", "NOT_FULL_SCREEN", "FULL_SCREEN", "DISMISS", "luggage-wxa-app_release"})
public enum p
{
  static
  {
    AppMethodBeat.i(245359);
    p localp1 = new p("NONE", 0);
    roa = localp1;
    p localp2 = new p("NOT_FULL_SCREEN", 1);
    rob = localp2;
    p localp3 = new p("FULL_SCREEN", 2);
    roc = localp3;
    p localp4 = new p("DISMISS", 3);
    rod = localp4;
    roe = new p[] { localp1, localp2, localp3, localp4 };
    AppMethodBeat.o(245359);
  }
  
  private p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.p
 * JD-Core Version:    0.7.0.1
 */