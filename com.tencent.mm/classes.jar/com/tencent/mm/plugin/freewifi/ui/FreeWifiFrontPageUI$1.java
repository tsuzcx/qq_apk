package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiFrontPageUI$1
  extends ah
{
  FreeWifiFrontPageUI$1(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = (FreeWifiFrontPageUI.c)paramMessage.obj;
    switch (FreeWifiFrontPageUI.8.krQ[paramMessage.krO.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.krP.aUY();
      return;
    case 2: 
      this.krP.aUZ();
      return;
    case 3: 
      this.krP.bk(paramMessage.data);
      return;
    }
    this.krP.bl(paramMessage.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.1
 * JD-Core Version:    0.7.0.1
 */