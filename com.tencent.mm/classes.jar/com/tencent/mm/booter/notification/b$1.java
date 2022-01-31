package com.tencent.mm.booter.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  extends ah
{
  b$1(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ae.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", true).apply();
    String str1 = paramMessage.getData().getString("notification.show.talker");
    String str2 = paramMessage.getData().getString("notification.show.message.content");
    int i = paramMessage.getData().getInt("notification.show.message.type");
    int j = paramMessage.getData().getInt("notification.show.tipsflag");
    y.i("MicroMsg.MMNotification", "notify need to deal: %s", new Object[] { str1 });
    try
    {
      if (paramMessage.what == 1)
      {
        b.a(this.djk, str1, str2, i, j, true);
        return;
      }
      b.a(this.djk, str1, str2, i, j, false);
      return;
    }
    catch (Exception paramMessage)
    {
      y.printErrStackTrace("MicroMsg.MMNotification", paramMessage, "showNotifiHandler", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b.1
 * JD-Core Version:    0.7.0.1
 */