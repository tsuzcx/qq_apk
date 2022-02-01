package com.tencent.mm.plugin.address.e;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class c
{
  public static void KG(String paramString)
  {
    AppMethodBeat.i(21055);
    ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(21055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.c
 * JD-Core Version:    0.7.0.1
 */