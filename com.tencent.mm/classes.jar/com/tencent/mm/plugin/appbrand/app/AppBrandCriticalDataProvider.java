package com.tencent.mm.plugin.appbrand.app;

import a.f.b.j;
import a.l;
import android.content.ContentValues;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "insert", "Landroid/net/Uri;", "uri", "contentValues", "Landroid/content/ContentValues;", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
public final class AppBrandCriticalDataProvider
  extends WxaCriticalDataProvider
  implements c
{
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(143732);
    j.q(paramUri, "uri");
    Uri localUri = super.insert(paramUri, paramContentValues);
    int i;
    if ((localUri != null) && (h(paramUri) == 5))
    {
      if (paramContentValues == null) {
        break label119;
      }
      paramUri = paramContentValues.getAsString("CONTENT_KEY_ACTION");
      if (j.e(paramUri, "ACTION_FLUSH_WXA_DEBUG_PKG_INFO"))
      {
        paramUri = paramContentValues.getAsString("CONTENT_KEY_APPID");
        paramContentValues = paramContentValues.getAsInteger("CONTENT_KEY_PKG_TYPE");
        if (paramContentValues == null) {
          break label124;
        }
        i = paramContentValues.intValue();
        label75:
        paramContentValues = (CharSequence)paramUri;
        if ((paramContentValues != null) && (paramContentValues.length() != 0)) {
          break label129;
        }
      }
    }
    label129:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (i != -1)) {
        h.bt(paramUri, i);
      }
      AppMethodBeat.o(143732);
      return localUri;
      label119:
      paramUri = null;
      break;
      label124:
      i = -1;
      break label75;
    }
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(143731);
    super.xi();
    AppMethodBeat.o(143731);
  }
  
  public final e xh()
  {
    AppMethodBeat.i(134454);
    Object localObject = g.auB();
    if (localObject != null)
    {
      c(p.class, g.auF());
      c(ay.class, g.auM());
      com.tencent.mm.kernel.g.RM().ao(localObject);
    }
    for (;;)
    {
      localObject = (e)localObject;
      AppMethodBeat.o(134454);
      return localObject;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */