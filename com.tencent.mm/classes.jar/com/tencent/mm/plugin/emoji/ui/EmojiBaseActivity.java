package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.j.a;
import com.tencent.threadpool.j.d;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  private a xRy;
  b xRz;
  
  public final void dBx()
  {
    if (this.xRz != null) {
      this.xRz.removeMessages(131074);
    }
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    if (this.xRz != null) {
      this.xRz.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void k(Message paramMessage);
  
  public abstract void l(Message paramMessage);
  
  public final void m(Message paramMessage)
  {
    if (this.xRz != null) {
      this.xRz.sendMessage(paramMessage);
    }
  }
  
  public final void n(Message paramMessage)
  {
    if (this.xRy != null) {
      this.xRy.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.xRy = new a(a.bFV("EmojiBaseActivity_handlerThread"));
    this.xRz = new b(getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.xRy != null) && (this.xRy.getLooper() != null)) {
      this.xRy.getSerial().ahCy.quit();
    }
    this.xRy = null;
    this.xRz = null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends MMHandler
  {
    a(a parama)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(108857);
      super.handleMessage(paramMessage);
      EmojiBaseActivity.this.k(paramMessage);
      AppMethodBeat.o(108857);
    }
  }
  
  final class b
    extends MMHandler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(108858);
      super.handleMessage(paramMessage);
      EmojiBaseActivity.this.l(paramMessage);
      AppMethodBeat.o(108858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */