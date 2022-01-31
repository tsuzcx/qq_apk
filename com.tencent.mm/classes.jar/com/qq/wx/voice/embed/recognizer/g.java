package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class g
{
  c aVy;
  Handler b = new h(this);
  
  public final void a(int paramInt)
  {
    Message localMessage = this.b.obtainMessage(100);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errorCode", paramInt);
    localMessage.setData(localBundle);
    this.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.g
 * JD-Core Version:    0.7.0.1
 */