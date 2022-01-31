package com.tencent.mm.plugin.extqlauncher;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class b$3
  extends ak
{
  b$3(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(20476);
    if ((ah.getContext() == null) || (!aw.RG()))
    {
      ab.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
      AppMethodBeat.o(20476);
      return;
    }
    if (b.a(this.mgf))
    {
      int i = b.btT();
      if ((i > 0) || (i < this.mgf.mgd))
      {
        ab.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
        paramMessage = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
        paramMessage.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
        ah.getContext().sendBroadcast(paramMessage);
        this.mgf.mgd = i;
      }
    }
    AppMethodBeat.o(20476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.3
 * JD-Core Version:    0.7.0.1
 */