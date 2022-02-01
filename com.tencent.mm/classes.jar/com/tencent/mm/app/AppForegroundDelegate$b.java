package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppForegroundDelegate$b
{
  String value;
  
  static
  {
    AppMethodBeat.i(239268);
    hfv = new b("ENTER", 0, "com.tencent.mm.sensitive.SENSITIVE_PAGE_ENTER");
    hfw = new b("EXIT", 1, "com.tencent.mm.sensitive.SENSITIVE_PAGE_EXIT");
    hfx = new b[] { hfv, hfw };
    AppMethodBeat.o(239268);
  }
  
  private AppForegroundDelegate$b(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate.b
 * JD-Core Version:    0.7.0.1
 */