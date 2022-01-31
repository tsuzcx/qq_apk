package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  private EmojiBaseActivity.a lle;
  EmojiBaseActivity.b llf;
  private HandlerThread mHandlerThread;
  
  public final void bms()
  {
    if (this.llf != null) {
      this.llf.removeMessages(131074);
    }
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    if (this.llf != null) {
      this.llf.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void m(Message paramMessage);
  
  public abstract void n(Message paramMessage);
  
  public final void o(Message paramMessage)
  {
    if (this.llf != null) {
      this.llf.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandlerThread = d.aqu("EmojiBaseActivity_handlerThread");
    this.mHandlerThread.start();
    this.lle = new EmojiBaseActivity.a(this, this.mHandlerThread.getLooper());
    this.llf = new EmojiBaseActivity.b(this, getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.lle != null) && (this.lle.getLooper() != null)) {
      this.lle.getLooper().quit();
    }
    this.mHandlerThread = null;
    this.lle = null;
    this.llf = null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(Message paramMessage)
  {
    if (this.lle != null) {
      this.lle.sendMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */