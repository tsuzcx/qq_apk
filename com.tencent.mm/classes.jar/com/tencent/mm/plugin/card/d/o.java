package com.tencent.mm.plugin.card.d;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class o
{
  @TargetApi(11)
  public static void KG(String paramString)
  {
    AppMethodBeat.i(113868);
    ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(113868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.o
 * JD-Core Version:    0.7.0.1
 */