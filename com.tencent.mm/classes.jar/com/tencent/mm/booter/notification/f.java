package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class f
{
  public e flq;
  
  private f()
  {
    AppMethodBeat.i(19997);
    this.flq = new e();
    AppMethodBeat.o(19997);
  }
  
  public static boolean a(String paramString, bl parambl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19998);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19998);
      return false;
    }
    paramBoolean = c.a(paramString, parambl, paramInt, paramBoolean);
    AppMethodBeat.o(19998);
    return paramBoolean;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(20000);
    paramNotification = this.flq.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(20000);
    return paramNotification;
  }
  
  public final int b(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(19999);
    int i = this.flq.a(paramNotificationItem);
    AppMethodBeat.o(19999);
    return i;
  }
  
  public static final class a
  {
    private static final f flr;
    
    static
    {
      AppMethodBeat.i(19996);
      flr = new f((byte)0);
      AppMethodBeat.o(19996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.f
 * JD-Core Version:    0.7.0.1
 */