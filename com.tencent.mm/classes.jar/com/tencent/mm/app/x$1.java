package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.ao;
import java.util.Locale;

final class x$1
  implements CrashMonitorForJni.CrashExtraMessageGetter
{
  public final String getExtraMessage()
  {
    AppMethodBeat.i(19446);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = MMApplicationContext.getProcessName();
    if ((localObject != null) && ((((String)localObject).contains(":tools")) || (((String)localObject).contains(":appbrand")) || (((String)localObject).contains(":isolated_process0"))))
    {
      localStringBuilder.append("\n");
      localObject = ao.getCrashExtraMessage(MMApplicationContext.getContext());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        String str = (String)localObject + String.format(Locale.US, "client_version:%s;", new Object[] { BuildInfo.CLIENT_VERSION });
        localObject = str;
        if (str.length() > 8192) {
          localObject = str.substring(str.length() - 8192);
        }
        localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject).getBytes(), 2));
        Log.v("MicroMsg.MMIsolatedCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject });
      }
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(19446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.x.1
 * JD-Core Version:    0.7.0.1
 */