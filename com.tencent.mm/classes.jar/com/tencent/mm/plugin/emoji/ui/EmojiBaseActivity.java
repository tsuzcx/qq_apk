package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  EmojiBaseActivity.a jcs;
  EmojiBaseActivity.b jct;
  private HandlerThread mHandlerThread;
  
  public final void aIU()
  {
    if (this.jct != null) {
      this.jct.removeMessages(131074);
    }
  }
  
  public final void cD(int paramInt1, int paramInt2)
  {
    if (this.jct != null) {
      this.jct.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void h(Message paramMessage);
  
  public abstract void i(Message paramMessage);
  
  public final void j(Message paramMessage)
  {
    if (this.jct != null) {
      this.jct.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandlerThread = e.aap("EmojiBaseActivity_handlerThread");
    this.mHandlerThread.start();
    this.jcs = new EmojiBaseActivity.a(this, this.mHandlerThread.getLooper());
    this.jct = new EmojiBaseActivity.b(this, getMainLooper());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jcs != null) && (this.jcs.getLooper() != null)) {
      this.jcs.getLooper().quit();
    }
    this.mHandlerThread = null;
    this.jcs = null;
    this.jct = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */