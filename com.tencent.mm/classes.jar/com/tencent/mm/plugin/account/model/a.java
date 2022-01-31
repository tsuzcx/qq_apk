package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a
  implements f
{
  boolean eAp = false;
  b ekR = new a.3(this);
  Set<String> fjj = Collections.synchronizedSet(new HashSet());
  c fjk = new a.1(this);
  ah fjl = new a.2(this);
  
  public a()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.fjk);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 133)
    {
      g.Dk().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label127;
      }
      y.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.eAp = false;
    }
    for (;;)
    {
      if (paramm.getType() == 32)
      {
        this.eAp = false;
        g.Dk().b(32, this);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break;
        }
        y.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      }
      return;
      label127:
      g.Dk().a(32, this);
      paramString = (al)paramm;
      paramString = new ab(paramString.fgJ, paramString.fgK);
      g.Dk().a(paramString, 0);
    }
    y.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
    w.bN(ae.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */