package com.tencent.mm.plugin.address.e;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b
{
  @TargetApi(11)
  public static void abo(String paramString)
  {
    AppMethodBeat.i(21054);
    ((ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(21054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.b
 * JD-Core Version:    0.7.0.1
 */