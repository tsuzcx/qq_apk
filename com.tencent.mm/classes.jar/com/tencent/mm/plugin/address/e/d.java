package com.tencent.mm.plugin.address.e;

import android.content.Context;
import android.os.Build.VERSION;

public final class d
{
  public static void P(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      new b();
      ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
      return;
    }
    new c();
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.d
 * JD-Core Version:    0.7.0.1
 */