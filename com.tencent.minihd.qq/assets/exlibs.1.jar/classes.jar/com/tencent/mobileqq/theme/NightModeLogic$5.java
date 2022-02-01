package com.tencent.mobileqq.theme;

import android.os.Handler.Callback;
import android.os.Message;

class NightModeLogic$5
  implements Handler.Callback
{
  NightModeLogic$5(NightModeLogic paramNightModeLogic) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 4097)
    {
      if (NightModeLogic.access$100(this.this$0) != null) {
        this.this$0.startNightMode(NightModeLogic.access$100(this.this$0));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.5
 * JD-Core Version:    0.7.0.1
 */