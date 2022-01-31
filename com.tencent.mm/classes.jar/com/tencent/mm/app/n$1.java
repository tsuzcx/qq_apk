package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.xweb.WebView;
import java.util.Locale;

final class n$1
  implements CrashMonitorForJni.a
{
  public final String Bt()
  {
    AppMethodBeat.i(153463);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = ah.getProcessName();
    if ((localObject != null) && ((((String)localObject).contains(":tools")) || (((String)localObject).contains(":appbrand")) || (((String)localObject).contains(":isolated_process0"))))
    {
      localStringBuilder.append("\n");
      localObject = WebView.getCrashExtraMessage(ah.getContext());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        String str = (String)localObject + String.format(Locale.US, "client_version:%s;", new Object[] { f.CLIENT_VERSION });
        localObject = str;
        if (str.length() > 8192) {
          localObject = str.substring(str.length() - 8192);
        }
        localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject).getBytes(), 2));
        ab.v("MicroMsg.MMIsolatedCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject });
      }
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(153463);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.n.1
 * JD-Core Version:    0.7.0.1
 */