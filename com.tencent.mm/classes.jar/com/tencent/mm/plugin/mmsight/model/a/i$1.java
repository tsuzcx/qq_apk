package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class i$1
  extends ah
{
  i$1(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.mjh.miT != null)
    {
      this.mjh.miT.bjj();
      this.mjh.miT = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.i.1
 * JD-Core Version:    0.7.0.1
 */