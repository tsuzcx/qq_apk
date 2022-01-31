package com.facebook.share.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareDialog$Mode
{
  static
  {
    AppMethodBeat.i(97688);
    AUTOMATIC = new Mode("AUTOMATIC", 0);
    NATIVE = new Mode("NATIVE", 1);
    WEB = new Mode("WEB", 2);
    FEED = new Mode("FEED", 3);
    $VALUES = new Mode[] { AUTOMATIC, NATIVE, WEB, FEED };
    AppMethodBeat.o(97688);
  }
  
  private ShareDialog$Mode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.Mode
 * JD-Core Version:    0.7.0.1
 */