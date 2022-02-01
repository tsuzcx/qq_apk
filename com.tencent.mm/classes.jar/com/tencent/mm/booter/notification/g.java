package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class g
{
  public f iSt;
  
  private g()
  {
    AppMethodBeat.i(19997);
    this.iSt = new f();
    AppMethodBeat.o(19997);
  }
  
  public static boolean a(String paramString, ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19998);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19998);
      return false;
    }
    paramBoolean = d.a(paramString, paramca, paramInt, paramBoolean);
    AppMethodBeat.o(19998);
    return paramBoolean;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(20000);
    paramNotification = this.iSt.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(20000);
    return paramNotification;
  }
  
  public final int b(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(19999);
    int i = this.iSt.a(paramNotificationItem);
    AppMethodBeat.o(19999);
    return i;
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(280566);
    this.iSt.s(paramInt, paramString);
    AppMethodBeat.o(280566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.g
 * JD-Core Version:    0.7.0.1
 */