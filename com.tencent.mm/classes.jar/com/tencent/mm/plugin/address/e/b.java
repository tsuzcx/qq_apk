package com.tencent.mm.plugin.address.e;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b
{
  @TargetApi(11)
  public static void xJ(String paramString)
  {
    AppMethodBeat.i(17011);
    ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setText(paramString);
    AppMethodBeat.o(17011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.b
 * JD-Core Version:    0.7.0.1
 */