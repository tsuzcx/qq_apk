package com.tencent.mm.plugin.address.e;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b
{
  public static void TF(String paramString)
  {
    AppMethodBeat.i(21054);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(21054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.b
 * JD-Core Version:    0.7.0.1
 */