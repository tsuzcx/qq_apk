package com.tencent.mm.booter.notification.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class d
{
  public Intent mIntent;
  
  public static PendingIntent a(Context paramContext, int paramInt, Intent paramIntent)
  {
    return PendingIntent.getActivity(paramContext, paramInt, paramIntent, 134217728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.d
 * JD-Core Version:    0.7.0.1
 */