package com.tencent.mm.plugin.appbrand.app;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.luggage.sdk.processes.d;
import com.tencent.luggage.wxa.storage.WxaCriticalDataProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandCriticalDataProvider;", "Lcom/tencent/luggage/wxa/storage/WxaCriticalDataProvider;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "insert", "Landroid/net/Uri;", "uri", "contentValues", "Landroid/content/ContentValues;", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "provideDatabase", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCriticalDataProvider
  extends WxaCriticalDataProvider
  implements c
{
  public final ISQLiteDatabase att()
  {
    AppMethodBeat.i(50159);
    Object localObject = n.ceY();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      localObject = (ISQLiteDatabase)localObject;
      AppMethodBeat.o(50159);
      return localObject;
      c(ac.class, n.cfc());
      c(bm.class, n.cfm());
      c(t.class, n.ag(t.class));
      c(l.class, n.ag(l.class));
      h.baF().cS(localObject);
    }
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(50160);
    s.u(paramUri, "uri");
    Uri localUri = super.insert(paramUri, paramContentValues);
    int i;
    if ((localUri != null) && (i(paramUri) == 5))
    {
      if (paramContentValues != null) {
        break label129;
      }
      paramUri = null;
      if (s.p(paramUri, "ACTION_FLUSH_WXA_DEBUG_PKG_INFO"))
      {
        paramUri = paramContentValues.getAsString("CONTENT_KEY_APPID");
        paramContentValues = paramContentValues.getAsInteger("CONTENT_KEY_PKG_TYPE");
        if (paramContentValues != null) {
          break label139;
        }
        i = -1;
        label67:
        paramContentValues = (CharSequence)paramUri;
        if ((paramContentValues != null) && (paramContentValues.length() != 0)) {
          break label147;
        }
      }
    }
    label129:
    label139:
    label147:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (i != -1))
      {
        paramContentValues = i.tWq;
        paramContentValues = (d)i.a.cJV();
        s.s(paramUri, "appId");
        d.a(paramContentValues, paramUri, i);
      }
      AppMethodBeat.o(50160);
      return localUri;
      paramUri = paramContentValues.getAsString("CONTENT_KEY_ACTION");
      break;
      i = paramContentValues.intValue();
      break label67;
    }
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(50158);
    super.atu();
    AppMethodBeat.o(50158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */