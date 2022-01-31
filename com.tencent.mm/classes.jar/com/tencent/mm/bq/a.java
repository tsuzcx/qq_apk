package com.tencent.mm.bq;

import android.os.Build.VERSION;
import com.tencent.mm.bn.a.a.a;

public final class a
{
  public static int bSL()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return a.a.notification_icon;
    }
    return a.a.notification_icon_gray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */