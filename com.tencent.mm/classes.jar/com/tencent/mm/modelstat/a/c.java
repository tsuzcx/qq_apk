package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static Bundle uJ(String paramString)
  {
    AppMethodBeat.i(78811);
    ab.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", new Object[] { paramString });
    Bundle localBundle = new Bundle();
    localBundle.putString("mm_event_class", paramString);
    AppMethodBeat.o(78811);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.c
 * JD-Core Version:    0.7.0.1
 */