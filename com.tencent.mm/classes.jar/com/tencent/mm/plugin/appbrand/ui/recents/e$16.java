package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;

final class e$16
  implements j.a
{
  e$16(e parame) {}
  
  public final void a(String paramString, l paraml)
  {
    if (("single".equals(paramString)) && ((3 == paraml.gbI) || (2 == paraml.gbI)))
    {
      this.hhH.runOnUiThread(new e.16.1(this));
      y.d("MicroMsg.AppBrandLauncherRecentsList", "onHistoryRecordModified");
      e.a(this.hhH, true, 9223372036854775807L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.16
 * JD-Core Version:    0.7.0.1
 */