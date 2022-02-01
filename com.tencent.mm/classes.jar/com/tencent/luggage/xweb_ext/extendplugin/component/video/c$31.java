package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class c$31
  implements l
{
  c$31(c paramc) {}
  
  public final String FV()
  {
    AppMethodBeat.i(220509);
    ae.i(this.cvH.getLogTag(), "getPosterPath, posterPath: " + this.cvH.csP);
    String str = this.cvH.csP;
    AppMethodBeat.o(220509);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(220508);
    ae.i(this.cvH.getLogTag(), "getTitle, title: " + this.cvH.mTitle);
    String str = this.cvH.mTitle;
    AppMethodBeat.o(220508);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.31
 * JD-Core Version:    0.7.0.1
 */