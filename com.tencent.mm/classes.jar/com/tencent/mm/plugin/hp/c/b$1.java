package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class b$1
  implements c.a
{
  b$1(b paramb) {}
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(90621);
    if ((paramBoolean) && (paramb != null))
    {
      this.nKB.nKA = paramb;
      this.nKB.nKw = this.nKB.nKA.nKR;
      ab.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", new Object[] { this.nKB.nKA.nKR, this.nKB.nKw });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 71L, 1L, false);
      AppMethodBeat.o(90621);
      return;
    }
    paramb = ah.getContext();
    String str = this.nKB.nKv;
    paramb.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", str).apply();
    com.tencent.mm.plugin.hp.tinker.h.aB(ah.getContext(), "");
    AppMethodBeat.o(90621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.c.b.1
 * JD-Core Version:    0.7.0.1
 */