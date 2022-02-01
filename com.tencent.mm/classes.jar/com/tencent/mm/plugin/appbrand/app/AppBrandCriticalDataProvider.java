package com.tencent.mm.plugin.appbrand.app;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "insert", "Landroid/net/Uri;", "uri", "contentValues", "Landroid/content/ContentValues;", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"})
public final class AppBrandCriticalDataProvider
  extends WxaCriticalDataProvider
  implements c
{
  public final ISQLiteDatabase Pp()
  {
    AppMethodBeat.i(50159);
    Object localObject = n.buy();
    if (localObject != null)
    {
      c(x.class, n.buC());
      c(bh.class, n.buL());
      g.aAi().by(localObject);
    }
    for (;;)
    {
      localObject = (ISQLiteDatabase)localObject;
      AppMethodBeat.o(50159);
      return localObject;
      localObject = null;
    }
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(50160);
    kotlin.g.b.p.h(paramUri, "uri");
    Uri localUri = super.insert(paramUri, paramContentValues);
    int i;
    if ((localUri != null) && (p(paramUri) == 5))
    {
      if (paramContentValues == null) {
        break label124;
      }
      paramUri = paramContentValues.getAsString("CONTENT_KEY_ACTION");
      if (kotlin.g.b.p.j(paramUri, "ACTION_FLUSH_WXA_DEBUG_PKG_INFO"))
      {
        paramUri = paramContentValues.getAsString("CONTENT_KEY_APPID");
        paramContentValues = paramContentValues.getAsInteger("CONTENT_KEY_PKG_TYPE");
        if (paramContentValues == null) {
          break label129;
        }
        i = paramContentValues.intValue();
        label75:
        paramContentValues = (CharSequence)paramUri;
        if ((paramContentValues != null) && (paramContentValues.length() != 0)) {
          break label134;
        }
      }
    }
    label129:
    label134:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (i != -1)) {
        h.bWb().cl(paramUri, i);
      }
      AppMethodBeat.o(50160);
      return localUri;
      label124:
      paramUri = null;
      break;
      i = -1;
      break label75;
    }
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(50158);
    super.Pq();
    AppMethodBeat.o(50158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */