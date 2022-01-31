package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MobileVerifyUI$a
{
  static
  {
    AppMethodBeat.i(125281);
    gHv = new a("GoBack", 0);
    gHw = new a("GoNext", 1);
    gHx = new a("DoSend", 2);
    gHy = new a("DoProcessSMS", 3);
    gHz = new a[] { gHv, gHw, gHx, gHy };
    AppMethodBeat.o(125281);
  }
  
  private MobileVerifyUI$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.a
 * JD-Core Version:    0.7.0.1
 */