package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import java.util.Locale;

final class k$1
  implements CrashMonitorForJni.a
{
  public final String sX()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = ae.getProcessName();
    if ((localObject != null) && ((((String)localObject).contains(":tools")) || (((String)localObject).contains(":appbrand"))))
    {
      localStringBuilder.append("\n");
      localObject = WebView.getCrashExtraMessage(ae.getContext());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        String str = (String)localObject + String.format(Locale.US, "client_version:%s;", new Object[] { d.CLIENT_VERSION });
        localObject = str;
        if (str.length() > 8192) {
          localObject = str.substring(str.length() - 8192);
        }
        localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject).getBytes(), 2));
        y.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject });
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.k.1
 * JD-Core Version:    0.7.0.1
 */