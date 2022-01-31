package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.p;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(126757);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(126757);
      return;
      if (!YANumberPicker.a(this.jub).jR.isFinished())
      {
        if (YANumberPicker.b(this.jub) == 0) {
          YANumberPicker.b(this.jub, 1);
        }
        YANumberPicker.c(this.jub).sendMessageDelayed(YANumberPicker.d(1, 0, 0, paramMessage.obj), 32L);
        AppMethodBeat.o(126757);
        return;
      }
      int i;
      if (YANumberPicker.d(this.jub) != 0)
      {
        if (YANumberPicker.b(this.jub) == 0) {
          YANumberPicker.b(this.jub, 1);
        }
        if (YANumberPicker.d(this.jub) < -YANumberPicker.e(this.jub) / 2)
        {
          j = (int)((YANumberPicker.e(this.jub) + YANumberPicker.d(this.jub)) * 300.0F / YANumberPicker.e(this.jub));
          p localp = YANumberPicker.a(this.jub);
          i = YANumberPicker.f(this.jub);
          int k = YANumberPicker.e(this.jub);
          localp.startScroll(0, i, 0, YANumberPicker.d(this.jub) + k, j * 3);
          i = YANumberPicker.c(this.jub, YANumberPicker.f(this.jub) + YANumberPicker.e(this.jub) + YANumberPicker.d(this.jub));
          this.jub.postInvalidate();
        }
      }
      for (;;)
      {
        paramMessage = YANumberPicker.d(2, YANumberPicker.g(this.jub), i, paramMessage.obj);
        if (!YANumberPicker.h(this.jub)) {
          break label418;
        }
        YANumberPicker.i(this.jub).sendMessageDelayed(paramMessage, j * 2);
        AppMethodBeat.o(126757);
        return;
        j = (int)(-YANumberPicker.d(this.jub) * 300.0F / YANumberPicker.e(this.jub));
        YANumberPicker.a(this.jub).startScroll(0, YANumberPicker.f(this.jub), 0, YANumberPicker.d(this.jub), j * 3);
        i = YANumberPicker.c(this.jub, YANumberPicker.f(this.jub) + YANumberPicker.d(this.jub));
        break;
        YANumberPicker.b(this.jub, 0);
        i = YANumberPicker.c(this.jub, YANumberPicker.f(this.jub));
      }
      label418:
      YANumberPicker.c(this.jub).sendMessageDelayed(paramMessage, j * 2);
      AppMethodBeat.o(126757);
      return;
      YANumberPicker.a(this.jub, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.1
 * JD-Core Version:    0.7.0.1
 */