package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class AddrBookObserver
  extends ContentObserver
{
  private static boolean fBf;
  private static Intent fBg;
  private static ak handler;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(124503);
    fBf = false;
    handler = new AddrBookObserver.1(Looper.getMainLooper());
    AppMethodBeat.o(124503);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(ak.fetchFreeHandler());
    AppMethodBeat.i(124501);
    this.context = paramContext;
    AppMethodBeat.o(124501);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(124502);
    super.onChange(paramBoolean);
    ab.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (!fBf)
    {
      l.aqu();
      handler.removeMessages(0);
      Message localMessage = handler.obtainMessage();
      localMessage.obj = this.context;
      localMessage.what = 0;
      handler.sendMessageDelayed(localMessage, 20000L);
      AppMethodBeat.o(124502);
      return;
    }
    ab.e("MicroMsg.AddrBookObserver", "isSyncing:" + fBf + ", is time to sync:" + l.aqu() + " , return");
    AppMethodBeat.o(124502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */