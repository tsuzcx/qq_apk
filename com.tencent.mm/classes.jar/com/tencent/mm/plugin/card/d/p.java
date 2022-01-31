package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.os.Build.VERSION;

public final class p
{
  public static void P(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      new n();
      ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
      return;
    }
    new o();
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.p
 * JD-Core Version:    0.7.0.1
 */