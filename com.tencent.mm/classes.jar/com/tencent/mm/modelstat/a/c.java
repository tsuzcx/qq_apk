package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public static Bundle Hi(String paramString)
  {
    AppMethodBeat.i(151154);
    ae.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", new Object[] { paramString });
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