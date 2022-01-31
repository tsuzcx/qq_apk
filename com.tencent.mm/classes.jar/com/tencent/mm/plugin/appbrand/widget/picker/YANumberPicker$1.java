package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.n;
import android.widget.OverScroller;

final class YANumberPicker$1
  extends Handler
{
  YANumberPicker$1(YANumberPicker paramYANumberPicker, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 0;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (!YANumberPicker.a(this.hBM).iY.isFinished())
      {
        if (YANumberPicker.b(this.hBM) == 0) {
          YANumberPicker.b(this.hBM, 1);
        }
        YANumberPicker.c(this.hBM).sendMessageDelayed(YANumberPicker.c(1, 0, 0, paramMessage.obj), 32L);
        return;
      }
      int i;
      if (YANumberPicker.d(this.hBM) != 0)
      {
        if (YANumberPicker.b(this.hBM) == 0) {
          YANumberPicker.b(this.hBM, 1);
        }
        if (YANumberPicker.d(this.hBM) < -YANumberPicker.e(this.hBM) / 2)
        {
          j = (int)((YANumberPicker.e(this.hBM) + YANumberPicker.d(this.hBM)) * 300.0F / YANumberPicker.e(this.hBM));
          n localn = YANumberPicker.a(this.hBM);
          i = YANumberPicker.f(this.hBM);
          int k = YANumberPicker.e(this.hBM);
          localn.startScroll(0, i, 0, YANumberPicker.d(this.hBM) + k, j * 3);
          i = YANumberPicker.c(this.hBM, YANumberPicker.f(this.hBM) + YANumberPicker.e(this.hBM) + YANumberPicker.d(this.hBM));
          this.hBM.postInvalidate();
        }
      }
      for (;;)
      {
        paramMessage = YANumberPicker.c(2, YANumberPicker.g(this.hBM), i, paramMessage.obj);
        if (!YANumberPicker.h(this.hBM)) {
          break label399;
        }
        YANumberPicker.i(this.hBM).sendMessageDelayed(paramMessage, j * 2);
        return;
        j = (int)(-YANumberPicker.d(this.hBM) * 300.0F / YANumberPicker.e(this.hBM));
        YANumberPicker.a(this.hBM).startScroll(0, YANumberPicker.f(this.hBM), 0, YANumberPicker.d(this.hBM), j * 3);
        i = YANumberPicker.c(this.hBM, YANumberPicker.f(this.hBM) + YANumberPicker.d(this.hBM));
        break;
        YANumberPicker.b(this.hBM, 0);
        i = YANumberPicker.c(this.hBM, YANumberPicker.f(this.hBM));
      }
      label399:
      YANumberPicker.c(this.hBM).sendMessageDelayed(paramMessage, j * 2);
      return;
    }
    YANumberPicker.a(this.hBM, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.1
 * JD-Core Version:    0.7.0.1
 */