package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class a$14
  implements l
{
  a$14(a parama) {}
  
  public final String FV()
  {
    AppMethodBeat.i(220438);
    ae.i(this.csS.getLogTag(), "getPosterPath, posterPath: " + this.csS.csP);
    String str = this.csS.csP;
    AppMethodBeat.o(220438);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(220437);
    ae.i(this.csS.getLogTag(), "getTitle, title: " + this.csS.mTitle);
    String str = this.csS.mTitle;
    AppMethodBeat.o(220437);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.14
 * JD-Core Version:    0.7.0.1
 */