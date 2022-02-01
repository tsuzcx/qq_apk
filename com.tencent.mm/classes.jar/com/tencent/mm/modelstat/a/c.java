package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static Bundle PV(String paramString)
  {
    AppMethodBeat.i(151154);
    Log.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", new Object[] { paramString });
    Bundle localBundle = new Bundle();
    localBundle.putString("mm_event_class", paramString);
    AppMethodBeat.o(151154);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.c
 * JD-Core Version:    0.7.0.1
 */