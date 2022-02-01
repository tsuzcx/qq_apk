package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.e.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity
  extends MMActivity
{
  private a uII;
  b uIJ;
  
  public final void cVS()
  {
    if (this.uIJ != null) {
      this.uIJ.removeMessages(131074);
    }
  }
  
  public final void fZ(int paramInt1, int paramInt2)
  {
    if (this.uIJ != null) {
      this.uIJ.sendEmptyMessageDelayed(paramInt1, paramInt2);
    }
  }
  
  public abstract void j(Message paramMessage);
  
  public abstract void k(Message paramMessage);
  
  public final void l(Message paramMessage)
  {
    if (this.uIJ != null) {
      this.uIJ.sendMessage(paramMessage);
    }
  }
  
  public final void m(Message paramMessage)
  {
    if (this.uII != null) {
      this.uII.sendMessage(paramMessage);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.uII = new a(a.bDn("EmojiBaseActivity_handlerThread"));
    this.uIJ = new b(getMainLooper());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.uII != null) && (this.uII.getLooper() != null)) {
      this.uII.getSerial().Zxu.quit();
    }
    this.uII = null;
    this.uIJ = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
 * JD-Core Version:    0.7.0.1
 */