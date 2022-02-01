package com.tencent.mm.plugin.card.c;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class p
{
  public static void TF(String paramString)
  {
    AppMethodBeat.i(113869);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(113869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.p
 * JD-Core Version:    0.7.0.1
 */