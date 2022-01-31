package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.c.b;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class m
  implements k
{
  private String gGl;
  WeakReference<WalletBaseUI> mGq;
  private com.tencent.mm.pluginsdk.wallet.a mGr;
  private com.tencent.mm.pluginsdk.wallet.a mGs;
  
  private void aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(41547);
    if (this.mGs != null) {
      this.mGs.aC(paramInt, paramString);
    }
    AppMethodBeat.o(41547);
  }
  
  private void bzA()
  {
    AppMethodBeat.i(41545);
    com.tencent.soter.a.a.a(new m.2(this), true, 1, new c(this.gGl, 2), new f());
    AppMethodBeat.o(41545);
  }
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    AppMethodBeat.i(41541);
    ab.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.mGr = parama;
    this.gGl = paramString;
    this.mGq = new WeakReference((WalletBaseUI)paramContext);
    ((WalletBaseUI)this.mGq.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.mGq.get()).addSceneEndListener(1638);
    bzA();
    AppMethodBeat.o(41541);
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(41544);
    ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.mGs = parama;
    parama = x.uli.ulk;
    if (parama != null)
    {
      if ((this.mGq != null) && (this.mGq.get() != null))
      {
        ((WalletBaseUI)this.mGq.get()).doSceneProgress(new b(parama.BmG, parama.signature, this.gGl, 2));
        AppMethodBeat.o(41544);
      }
    }
    else
    {
      ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
      aE(-1, ah.getContext().getString(2131299650));
    }
    AppMethodBeat.o(41544);
  }
  
  final void aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(41546);
    if (this.mGr != null) {
      this.mGr.aC(paramInt, paramString);
    }
    AppMethodBeat.o(41546);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(41542);
    ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.mGq != null) && (this.mGq.get() != null))
    {
      ((WalletBaseUI)this.mGq.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.mGq.get()).removeSceneEndListener(1638);
    }
    x.uli.reset();
    if ((this.mGq != null) && (this.mGq.get() != null)) {
      this.mGq.clear();
    }
    AppMethodBeat.o(41542);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41543);
    ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = ah.getContext().getString(2131299650);
    }
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (bo.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramm).mGC))
        {
          aD(-1, str);
          AppMethodBeat.o(41543);
          return true;
        }
        al.d(new m.1(this));
      }
    }
    else
    {
      if (!(paramm instanceof b)) {
        break label225;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label199;
      }
      ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.cya();
      com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
      aE(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(41543);
      return true;
      ab.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      aD(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.e(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(41543);
      return true;
      label199:
      ab.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.e(8, paramInt1, paramInt2, "open fp pay failed");
      aE(-1, str);
    }
    label225:
    AppMethodBeat.o(41543);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.m
 * JD-Core Version:    0.7.0.1
 */