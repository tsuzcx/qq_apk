package com.tencent.mm.plugin.appbrand.debugger;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(129942);
    Object localObject1 = this.val$appId;
    String str1 = this.hlc;
    int i = this.hld;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {}
    int j;
    Object localObject3;
    String str2;
    Object localObject4;
    for (;;)
    {
      Object localObject2 = this.val$appId;
      str1 = this.hle;
      j = this.hld;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str1)))
      {
        AppMethodBeat.o(129942);
        return;
        try
        {
          localObject2 = h.mo(str1);
          localObject3 = ((JSONObject)localObject2).keys();
          while (((Iterator)localObject3).hasNext())
          {
            str2 = (String)((Iterator)localObject3).next();
            localObject4 = new y((String)localObject1, str2);
            localObject4 = g.auM().a(((y)localObject4).toString(), 0, i, new String[0]);
            if (localObject4 != null)
            {
              ((at)localObject4).field_downloadURL = ((JSONObject)localObject2).optString(str2);
              g.auM().c((at)localObject4);
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", localThrowable2, "processSubUrlsAndSave appId[%s], json[%s]", new Object[] { localObject1, str1 });
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONArray(str1);
        i = 0;
        if (i < ((JSONArray)localObject3).length())
        {
          localObject4 = ((JSONArray)localObject3).getJSONObject(i);
          int k = ((JSONObject)localObject4).optInt("pkgType");
          str2 = ((JSONObject)localObject4).optString("url");
          localObject1 = null;
          if (k == 12)
          {
            localObject1 = new y(localThrowable2, "__WITHOUT_CODELIB__", k);
            localObject1 = g.auM().a(((y)localObject1).toString(), 0, j, new String[0]);
            if (localObject1 == null) {
              break label375;
            }
            ((at)localObject1).field_downloadURL = str2;
            g.auM().c((at)localObject1);
            break label375;
          }
          if (k != 13) {
            continue;
          }
          localObject1 = new y(localThrowable2, ((JSONObject)localObject4).getString("moduleName"), k);
          continue;
        }
        AppMethodBeat.o(129942);
      }
      catch (Throwable localThrowable1)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", localThrowable1, "processWithoutCodeLibUrlsAndSave withoutCodeLibUrls[%s]", new Object[] { str1 });
        AppMethodBeat.o(129942);
        return;
      }
      return;
      label375:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d.1
 * JD-Core Version:    0.7.0.1
 */