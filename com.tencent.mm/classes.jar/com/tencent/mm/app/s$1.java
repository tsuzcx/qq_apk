package com.tencent.mm.app;

import android.util.Base64;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.xweb.WebView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

final class s$1
  implements CrashMonitorForJni.a
{
  public final String Mj()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = aj.getProcessName();
    Object localObject2;
    if ((localObject1 != null) && ((((String)localObject1).contains(":tools")) || (((String)localObject1).contains(":appbrand"))))
    {
      localStringBuilder.append("\n");
      localObject1 = WebView.getCrashExtraMessage(aj.getContext());
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject2 = (String)localObject1 + String.format(Locale.US, "client_version:%s;", new Object[] { i.hgG });
        localObject1 = localObject2;
        if (((String)localObject2).length() > 8192) {
          localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 8192);
        }
        localStringBuilder.append("#qbrowser.crashmsg=" + Base64.encodeToString(((String)localObject1).getBytes(), 2));
        ad.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", new Object[] { localObject1 });
      }
    }
    localObject1 = s.Mg().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.a)((Iterator)localObject1).next();
      localStringBuilder.append('\n').append(((c.a)localObject2).bev());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.s.1
 * JD-Core Version:    0.7.0.1
 */