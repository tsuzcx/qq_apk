package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Message;

final class YANumberPicker$2
  extends Handler
{
  YANumberPicker$2(YANumberPicker paramYANumberPicker) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      this.hBM.requestLayout();
      return;
    }
    YANumberPicker.a(this.hBM, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.2
 * JD-Core Version:    0.7.0.1
 */