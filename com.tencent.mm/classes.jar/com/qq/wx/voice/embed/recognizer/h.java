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
    AppMethodBeat.i(123224);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123224);
      return;
      int i = paramMessage.getData().getInt("errorCode");
      this.bmf.bmg.fn(i);
      AppMethodBeat.o(123224);
      return;
      paramMessage = (a)paramMessage.obj;
      this.bmf.bmg.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.h
 * JD-Core Version:    0.7.0.1
 */