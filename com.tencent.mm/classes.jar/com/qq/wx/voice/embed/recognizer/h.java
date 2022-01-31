package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class h
  extends Handler
{
  h(g paramg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      int i = paramMessage.getData().getInt("errorCode");
      this.aVx.aVy.dX(i);
      return;
    }
    paramMessage = (a)paramMessage.obj;
    this.aVx.aVy.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.h
 * JD-Core Version:    0.7.0.1
 */