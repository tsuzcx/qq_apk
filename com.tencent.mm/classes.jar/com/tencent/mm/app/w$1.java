package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

final class w$1
  implements CrashMonitorForJni.CrashExtraMessageGetter
{
  public final String getExtraMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = MMApplicationContext.getProcessName();
    Object localObject2;
    if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
    {
      localStringBuilder.append("\n");
      localObject1 = ao.getCrashExtraMessage(MMApplicationContext.getContext());
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { BuildInfo.CLIENT_VERSION });
        localObject1 = localObject2;
        if (((String)localObject2).length() > 8192) {
          localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
        }
        localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
        Log.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
      }
    }
    localObject1 = w.aCF().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ICrashReporter.ICrashReportExtraMessageGetter)((Iterator)localObject1).next();
      localStringBuilder.append('\n').append(((ICrashReporter.ICrashReportExtraMessageGetter)localObject2).getCrashReportExtraMessage());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.w.1
 * JD-Core Version:    0.7.0.1
 */