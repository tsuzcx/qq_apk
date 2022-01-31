package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static Bundle nv(String paramString)
  {
    y.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", new Object[] { paramString });
    Bundle localBundle = new Bundle();
    localBundle.putString("mm_event_class", paramString);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.b
 * JD-Core Version:    0.7.0.1
 */