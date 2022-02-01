package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
  extends Handler
{
  h(g paramg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76769);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(76769);
      return;
      int i = paramMessage.getData().getInt("errorCode");
      this.bVL.bVM.onGetError(i);
      AppMethodBeat.o(76769);
      return;
      paramMessage = (a)paramMessage.obj;
      this.bVL.bVM.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.h
 * JD-Core Version:    0.7.0.1
 */