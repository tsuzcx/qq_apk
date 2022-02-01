package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.f.j.a;
import com.tencent.f.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  b rfA;
  private a rfz;
  
  public final void cHg()
  {
    if (this.rfA != null) {
      this.rfA.removeMessages(131074);
    }
  }
  
  public final void fC(int paramInt1, int paramInt2)
  {
    if (this.rfA != null) {
      this.rfA.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void j(Message paramMessage);
  
  public abstract void k(Message paramMessage);
  
  public final void l(Message paramMessage)
  {
    if (this.rfA != null) {
      this.rfA.sendMessage(paramMessage);
    }
  }
  
  public final void m(Message paramMessage)
  {
    if (this.rfz != null) {
      this.rfz.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.rfz = new a(a.bqt("EmojiBaseActivity_handlerThread"));
    this.rfA = new b(getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.rfz != null) && (this.rfz.getLooper() != null)) {
      this.rfz.getSerial().RUS.quit();
    }
    this.rfz = null;
    this.rfA = null;
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
      EmojiBaseActivity.this.j(paramMessage);
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
      EmojiBaseActivity.this.k(paramMessage);
      AppMethodBeat.o(108858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */