package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class p
{
  public static void abo(String paramString)
  {
    AppMethodBeat.i(113869);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(113869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.p
 * JD-Core Version:    0.7.0.1
 */