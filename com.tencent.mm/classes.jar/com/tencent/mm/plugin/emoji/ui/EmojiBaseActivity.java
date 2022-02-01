package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  private a oBu;
  b oBv;
  
  public final void bWc()
  {
    if (this.oBv != null) {
      this.oBv.removeMessages(131074);
    }
  }
  
  public final void fe(int paramInt1, int paramInt2)
  {
    if (this.oBv != null) {
      this.oBv.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void l(Message paramMessage);
  
  public abstract void m(Message paramMessage);
  
  public final void n(Message paramMessage)
  {
    if (this.oBv != null) {
      this.oBv.sendMessage(paramMessage);
    }
  }
  
  public final void o(Message paramMessage)
  {
    if (this.oBu != null) {
      this.oBu.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.oBu = new a(a.aOc("EmojiBaseActivity_handlerThread"));
    this.oBv = new b(getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.oBu != null) && (this.oBu.getLooper() != null)) {
      this.oBu.getSerial().IzX.quit();
    }
    this.oBu = null;
    this.oBv = null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ap
  {
    a(a parama)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(108857);
      super.handleMessage(paramMessage);
      EmojiBaseActivity.this.l(paramMessage);
      AppMethodBeat.o(108857);
    }
  }
  
  final class b
    extends ap
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(108858);
      super.handleMessage(paramMessage);
      EmojiBaseActivity.this.m(paramMessage);
      AppMethodBeat.o(108858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */