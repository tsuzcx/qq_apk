package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  private a peU;
  b peV;
  
  public final void cdp()
  {
    if (this.peV != null) {
      this.peV.removeMessages(131074);
    }
  }
  
  public final void fh(int paramInt1, int paramInt2)
  {
    if (this.peV != null) {
      this.peV.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void l(Message paramMessage);
  
  public abstract void m(Message paramMessage);
  
  public final void n(Message paramMessage)
  {
    if (this.peV != null) {
      this.peV.sendMessage(paramMessage);
    }
  }
  
  public final void o(Message paramMessage)
  {
    if (this.peU != null) {
      this.peU.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.peU = new a(a.aTF("EmojiBaseActivity_handlerThread"));
    this.peV = new b(getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.peU != null) && (this.peU.getLooper() != null)) {
      this.peU.getSerial().KbG.quit();
    }
    this.peU = null;
    this.peV = null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ao
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
    extends ao
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */