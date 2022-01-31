package com.tencent.mm.plugin.location.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class SimpleImageView$a
  implements Runnable
{
  private ah handler;
  private String url;
  
  public SimpleImageView$a(String paramString, ah paramah)
  {
    this.url = paramString;
    this.handler = paramah;
  }
  
  public final void run()
  {
    byte[] arrayOfByte = bk.ZV(this.url);
    Message localMessage = Message.obtain();
    localMessage.obj = arrayOfByte;
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView.a
 * JD-Core Version:    0.7.0.1
 */