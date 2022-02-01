package com.tencent.h.a.a;

import android.os.Message;
import com.tencent.g.a.a;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class e
{
  public MMHandler ahWW;
  
  public e(String paramString)
  {
    this.ahWW = new MMHandler(paramString)
    {
      public final void handleMessage(Message paramAnonymousMessage) {}
    };
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.ahWW.removeCallbacks(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.a.e
 * JD-Core Version:    0.7.0.1
 */