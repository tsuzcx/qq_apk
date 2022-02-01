package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.luggage.xweb_ext.extendplugin.component.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class c$41
  implements l
{
  c$41(c paramc) {}
  
  public final String PE()
  {
    AppMethodBeat.i(215714);
    Log.i(this.cJF.getLogTag(), "getPosterPath, posterPath: " + this.cJF.cFf);
    String str = this.cJF.cFf;
    AppMethodBeat.o(215714);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(215713);
    Log.i(this.cJF.getLogTag(), "getTitle, title: " + this.cJF.mTitle);
    String str = this.cJF.mTitle;
    AppMethodBeat.o(215713);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.c.41
 * JD-Core Version:    0.7.0.1
 */