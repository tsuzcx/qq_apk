package com.tencent.mm.plugin.appbrand.app;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.e.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "insert", "Landroid/net/Uri;", "uri", "contentValues", "Landroid/content/ContentValues;", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
public final class AppBrandCriticalDataProvider
  extends WxaCriticalDataProvider
  implements c
{
  public final e Ey()
  {
    AppMethodBeat.i(50159);
    Object localObject = j.aOy();
    if (localObject != null)
    {
      c(t.class, j.aOC());
      c(bf.class, j.aOK());
      g.afC().bq(localObject);
    }
    for (;;)
    {
      localObject = (e)localObject;
      AppMethodBeat.o(50159);
      return localObject;
      localObject = null;
    }
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(50160);
    k.h(paramUri, "uri");
    Uri localUri = super.insert(paramUri, paramContentValues);
    int i;
    if ((localUri != null) && (p(paramUri) == 5))
    {
      if (paramContentValues == null) {
        break label119;
      }
      paramUri = paramContentValues.getAsString("CONTENT_KEY_ACTION");
      if (k.g(paramUri, "ACTION_FLUSH_WXA_DEBUG_PKG_INFO"))
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
        f.bQ(paramUri, i);
      }
      AppMethodBeat.o(50160);
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
    AppMethodBeat.i(50158);
    super.Ez();
    AppMethodBeat.o(50158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */