package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.ah;

final class a$1
  implements com.tencent.mm.pluginsdk.permission.a
{
  a$1(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, com.tencent.mm.pluginsdk.permission.a parama1) {}
  
  public final void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(2522);
    b localb;
    if (paramBoolean)
    {
      localb = new b();
      localb.i(this.kYh);
      String str = this.kYh.field_packageName;
      SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("install_begin_time", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
      }
      com.tencent.mm.plugin.downloader.f.a.a(this.kYh.field_appId, this.kYh.field_scene, 4, this.kYh.field_md5, this.kYh.field_downloadUrl, null, this.kYh.field_extInfo);
      localb.iHc = ((System.currentTimeMillis() - this.kYh.field_startTime) / 1000L);
      com.tencent.mm.plugin.downloader.f.a.a(4, localb);
      if (!this.kZL) {
        break label172;
      }
      com.tencent.mm.plugin.downloader.f.a.a(15, localb);
    }
    for (;;)
    {
      if (this.kZM != null) {
        this.kZM.eb(paramBoolean);
      }
      AppMethodBeat.o(2522);
      return;
      label172:
      com.tencent.mm.plugin.downloader.f.a.a(16, localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a.1
 * JD-Core Version:    0.7.0.1
 */