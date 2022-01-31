package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a
  implements f
{
  b fBi;
  boolean fQi;
  Set<String> gAB;
  c gAC;
  ak gAD;
  
  public a()
  {
    AppMethodBeat.i(124657);
    this.gAB = Collections.synchronizedSet(new HashSet());
    this.fQi = false;
    this.gAC = new a.1(this);
    this.gAD = new a.2(this);
    this.fBi = new a.3(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.gAC);
    AppMethodBeat.o(124657);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124658);
    if (paramm.getType() == 133)
    {
      g.Rc().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.fQi = false;
    }
    while (paramm.getType() == 32)
    {
      this.fQi = false;
      g.Rc().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(124658);
        return;
        label137:
        g.Rc().a(32, this);
        paramString = (al)paramm;
        paramString = new com.tencent.mm.plugin.account.friend.a.ab(paramString.gyr, paramString.gys);
        g.Rc().a(paramString, 0);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        w.cu(ah.getContext());
      }
    }
    AppMethodBeat.o(124658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */