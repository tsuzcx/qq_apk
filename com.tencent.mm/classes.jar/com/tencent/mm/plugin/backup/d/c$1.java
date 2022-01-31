package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class c$1
  implements f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(595, c.a(this.hIn));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -2011)) {
        y.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
      }
      b.atS().atn().hFu = -5;
      this.hIn.nt(-5);
      return;
    }
    paramm = ((e)paramm).avb();
    au.Hx();
    if (!bk.pm((String)com.tencent.mm.model.c.Dz().get(2, null)).equals(paramm.szb))
    {
      y.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
      b.atS().atn().hFu = -5;
      this.hIn.nt(-5);
      return;
    }
    b.atS().hFm = paramm.ID;
    b.atS().hFn = paramm.szi;
    b.atS().hFo = paramm.szj;
    com.tencent.mm.plugin.backup.g.b.a(this.hIn.hIl);
    b.atS().ato();
    com.tencent.mm.plugin.backup.g.b.a(b.atS().atV());
    com.tencent.mm.plugin.backup.g.b.a(b.atS().atT());
    com.tencent.mm.plugin.backup.g.b.nu(2);
    com.tencent.mm.plugin.backup.g.b.a(c.b(this.hIn));
    paramInt1 = 0;
    Object localObject;
    if (paramm.syY > 0)
    {
      localObject = (ri)paramm.syZ.getFirst();
      paramString = ((ri)localObject).sMR;
      paramInt1 = ((Integer)((ri)localObject).sPm.getFirst()).intValue();
    }
    for (;;)
    {
      localObject = this.hIn;
      ((c)localObject).hIb = paramm.szc;
      ((c)localObject).hIc = paramString;
      ((c)localObject).hId = paramInt1;
      y.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[] { Integer.valueOf(paramm.hQR), Integer.valueOf(paramm.pyo), paramm.szc, paramString, Integer.valueOf(paramInt1) });
      d.nu(22);
      b.atS().atn().hFu = 1;
      localObject = new Intent().setClassName(ae.getContext(), "com.tencent.mm.ui.LauncherUI");
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("nofification_type", "backup_move_notification");
      ae.getContext().startActivity((Intent)localObject);
      h.nFQ.a(485L, 41L, 1L, false);
      c.bb(false);
      y.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[] { paramString, paramm.szc, g.cM(ae.getContext()) });
      c.aud();
      c.a(this.hIn, paramString, paramInt1);
      return;
      y.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.1
 * JD-Core Version:    0.7.0.1
 */