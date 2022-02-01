package com.tencent.mm.plugin.location.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class SimpleImageView$a
  implements Runnable
{
  private ap handler;
  private String url;
  
  public SimpleImageView$a(String paramString, ap paramap)
  {
    this.url = paramString;
    this.handler = paramap;
  }
  
  public final void run()
  {
    AppMethodBeat.i(55929);
    byte[] arrayOfByte = bt.aRi(this.url);
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