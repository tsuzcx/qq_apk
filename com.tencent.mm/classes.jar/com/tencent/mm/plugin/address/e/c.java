package com.tencent.mm.plugin.address.e;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class c
{
  public static void CP(String paramString)
  {
    AppMethodBeat.i(21055);
    ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(21055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.c
 * JD-Core Version:    0.7.0.1
 */