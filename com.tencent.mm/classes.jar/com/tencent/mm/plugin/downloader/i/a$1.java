package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$1
  implements com.tencent.mm.pluginsdk.permission.a
{
  a$1(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, com.tencent.mm.pluginsdk.permission.a parama1) {}
  
  public final void hk(boolean paramBoolean)
  {
    AppMethodBeat.i(89130);
    b localb;
    if (paramBoolean)
    {
      localb = new b();
      localb.k(this.qIi);
      String str = this.qIi.field_packageName;
      SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("install_begin_time", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
      }
      com.tencent.mm.plugin.downloader.f.a.a(this.qIi.field_appId, this.qIi.field_scene, 4, this.qIi.field_md5, this.qIi.field_downloadUrl, null, this.qIi.field_extInfo);
      localb.costTime = ((System.currentTimeMillis() - this.qIi.field_startTime) / 1000L);
      com.tencent.mm.plugin.downloader.f.a.a(4, localb);
      if (!this.qJT) {
        break label170;
      }
      com.tencent.mm.plugin.downloader.f.a.a(15, localb);
    }
    for (;;)
    {
      if (this.qJU != null) {
        this.qJU.hk(paramBoolean);
      }
      AppMethodBeat.o(89130);
      return;
      label170:
      com.tencent.mm.plugin.downloader.f.a.a(16, localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a.1
 * JD-Core Version:    0.7.0.1
 */