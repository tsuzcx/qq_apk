package com.tencent.mm.plugin.extqlauncher;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  extends ah
{
  b$3(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void handleMessage(Message paramMessage)
  {
    if ((ae.getContext() == null) || (!au.DK())) {
      y.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
    }
    int i;
    do
    {
      do
      {
        return;
      } while (!b.a(this.jMb));
      i = b.aNQ();
    } while ((i <= 0) && (i >= this.jMb.jLZ));
    y.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
    paramMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
    paramMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
    ae.getContext().sendBroadcast(paramMessage);
    this.jMb.jLZ = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.3
 * JD-Core Version:    0.7.0.1
 */