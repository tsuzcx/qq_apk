package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class AddrBookObserver
  extends ContentObserver
{
  private static boolean ekO = false;
  private static Intent ekP;
  private static ah handler = new AddrBookObserver.1(Looper.getMainLooper());
  private final Context context;
  
  public AddrBookObserver(Context paramContext)
  {
    super(ah.fetchFreeHandler());
    this.context = paramContext;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    y.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (ekO)
    {
      y.e("MicroMsg.AddrBookObserver", "isSyncing:" + ekO + ", is time to sync:true , return");
      return;
    }
    handler.removeMessages(0);
    Message localMessage = handler.obtainMessage();
    localMessage.obj = this.context;
    localMessage.what = 0;
    handler.sendMessageDelayed(localMessage, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver
 * JD-Core Version:    0.7.0.1
 */