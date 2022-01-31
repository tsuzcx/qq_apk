package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class c$1
  implements f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17246);
    aw.Rc().b(595, c.a(this.jBL));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -2011)) {
        ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
      }
      b.aTr().aSL().jyN = -5;
      this.jBL.rf(-5);
      AppMethodBeat.o(17246);
      return;
    }
    paramm = ((e)paramm).aUD();
    aw.aaz();
    if (!bo.nullAsNil((String)com.tencent.mm.model.c.Ru().get(2, null)).equals(paramm.wtd))
    {
      ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
      b.aTr().aSL().jyN = -5;
      this.jBL.rf(-5);
      AppMethodBeat.o(17246);
      return;
    }
    b.aTr().jyF = paramm.ID;
    b.aTr().jyG = paramm.wtj;
    b.aTr().jyH = paramm.wtk;
    com.tencent.mm.plugin.backup.g.b.a(this.jBL.jBJ);
    b.aTr().aSM();
    com.tencent.mm.plugin.backup.g.b.a(b.aTr().aTu());
    com.tencent.mm.plugin.backup.g.b.a(b.aTr().aTs());
    com.tencent.mm.plugin.backup.g.b.rg(2);
    com.tencent.mm.plugin.backup.g.b.a(c.b(this.jBL));
    paramInt1 = 0;
    Object localObject;
    if (paramm.wta > 0)
    {
      localObject = (vd)paramm.wtb.getFirst();
      paramString = ((vd)localObject).wKH;
      paramInt1 = ((Integer)((vd)localObject).wNF.getFirst()).intValue();
    }
    for (;;)
    {
      localObject = this.jBL;
      ((c)localObject).jBz = paramm.wte;
      ((c)localObject).jBA = paramString;
      ((c)localObject).jBB = paramInt1;
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramm.jKs), Integer.valueOf(paramm.Scene), paramm.wte, paramString, Integer.valueOf(paramInt1) });
      d.rg(22);
      b.aTr().aSL().jyN = 1;
      localObject = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
      ah.getContext().startActivity((Intent)localObject);
      h.qsU.idkeyStat(485L, 41L, 1L, false);
      c.access$202(false);
      ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramString, paramm.wte, g.dx(ah.getContext()) });
      c.aTC();
      c.a(this.jBL, paramString, paramInt1);
      AppMethodBeat.o(17246);
      return;
      ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.1
 * JD-Core Version:    0.7.0.1
 */