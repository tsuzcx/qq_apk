package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements c.a
{
  a$1(a parama, ps paramps) {}
  
  public final void a(boolean paramBoolean, b paramb)
  {
    if ((paramBoolean) && (paramb != null))
    {
      this.lnk.lni = paramb;
      this.lnj.sNz = this.lnk.lni.lny;
      y.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { this.lnk.lni.lny, this.lnk.lne });
      h.nFQ.a(614L, 71L, 1L, false);
      return;
    }
    paramb = ae.getContext();
    String str = this.lnk.lnd;
    paramb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
    g.at(ae.getContext(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.a.1
 * JD-Core Version:    0.7.0.1
 */