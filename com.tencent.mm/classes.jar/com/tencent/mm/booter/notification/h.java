package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class h
{
  public g luq;
  
  private h()
  {
    AppMethodBeat.i(19997);
    this.luq = new g();
    AppMethodBeat.o(19997);
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(20000);
    paramNotification = this.luq.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(20000);
    return paramNotification;
  }
  
  public final boolean a(String paramString, cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19998);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19998);
      return false;
    }
    paramBoolean = g.a(paramString, paramcc, paramInt, paramBoolean);
    AppMethodBeat.o(19998);
    return paramBoolean;
  }
  
  public final int b(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(19999);
    int i = this.luq.a(paramNotificationItem);
    AppMethodBeat.o(19999);
    return i;
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(238926);
    this.luq.s(paramInt, paramString);
    AppMethodBeat.o(238926);
  }
  
  public static final class a
  {
    private static final h lur;
    
    static
    {
      AppMethodBeat.i(19996);
      lur = new h((byte)0);
      AppMethodBeat.o(19996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.h
 * JD-Core Version:    0.7.0.1
 */