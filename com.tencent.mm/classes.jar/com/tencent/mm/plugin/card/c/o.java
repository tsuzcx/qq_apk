package com.tencent.mm.plugin.card.c;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class o
{
  public static void TF(String paramString)
  {
    AppMethodBeat.i(113868);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(113868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.o
 * JD-Core Version:    0.7.0.1
 */