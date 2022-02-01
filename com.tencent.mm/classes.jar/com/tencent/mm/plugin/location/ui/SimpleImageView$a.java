package com.tencent.mm.plugin.location.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class SimpleImageView$a
  implements Runnable
{
  private aq handler;
  private String url;
  
  public SimpleImageView$a(String paramString, aq paramaq)
  {
    this.url = paramString;
    this.handler = paramaq;
  }
  
  public final void run()
  {
    AppMethodBeat.i(55929);
    byte[] arrayOfByte = bu.aSF(this.url);
    Message localMessage = Message.obtain();
    localMessage.obj = arrayOfByte;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(55929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView.a
 * JD-Core Version:    0.7.0.1
 */