package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
{
  Handler b;
  c dYU;
  
  public g()
  {
    AppMethodBeat.i(76770);
    this.b = new h(this);
    AppMethodBeat.o(76770);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(76771);
    Message localMessage = this.b.obtainMessage(100);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errorCode", paramInt);
    localMessage.setData(localBundle);
    this.b.sendMessage(localMessage);
    AppMethodBeat.o(76771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.g
 * JD-Core Version:    0.7.0.1
 */