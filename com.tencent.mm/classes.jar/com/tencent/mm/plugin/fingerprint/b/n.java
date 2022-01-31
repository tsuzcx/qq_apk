package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
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

public final class n
  implements k
{
  private String gGl = "";
  private com.tencent.mm.pluginsdk.wallet.a mFX = null;
  private com.tencent.mm.pluginsdk.wallet.a mFY = null;
  WeakReference<WalletBaseUI> mGq = null;
  
  private void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(41554);
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.mFY.aC(paramInt, paramString);
    this.mFY = null;
    AppMethodBeat.o(41554);
  }
  
  public final void a(Context paramContext, com.tencent.mm.pluginsdk.wallet.a parama, String paramString)
  {
    AppMethodBeat.i(41550);
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.mGq = new WeakReference((WalletBaseUI)paramContext);
    this.mFX = parama;
    this.gGl = paramString;
    ((WalletBaseUI)this.mGq.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.mGq.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.cxZ();
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.soter.a.a.a(new n.1(this), true, 1, new c(this.gGl, 1), new f());
    AppMethodBeat.o(41550);
  }
  
  public final void a(com.tencent.mm.pluginsdk.wallet.a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(41555);
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.mFY = parama;
    parama = x.uli.ulk;
    if (parama != null)
    {
      if ((this.mGq != null) && (this.mGq.get() != null))
      {
        ((WalletBaseUI)this.mGq.get()).doSceneProgress(new b(parama.BmG, parama.signature, this.gGl, 1));
        AppMethodBeat.o(41555);
      }
    }
    else
    {
      ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      aF(-1, ah.getContext().getString(2131299968));
    }
    AppMethodBeat.o(41555);
  }
  
  final void aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(41552);
    if (this.mFX != null) {
      this.mFX.aC(paramInt, paramString);
    }
    AppMethodBeat.o(41552);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(41551);
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.mGq != null) && (this.mGq.get() != null))
    {
      ((WalletBaseUI)this.mGq.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.mGq.get()).removeSceneEndListener(1638);
    }
    this.mFX = null;
    x.uli.reset();
    if ((this.mGq != null) && (this.mGq.get() != null)) {
      this.mGq.clear();
    }
    AppMethodBeat.o(41551);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41553);
    ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = ah.getContext().getString(2131299968);
    }
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        if (bo.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramm).mGC))
        {
          aF(-1, str);
          AppMethodBeat.o(41553);
          return true;
        }
        al.d(new n.2(this));
      }
    }
    else
    {
      if (!(paramm instanceof b)) {
        break label220;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label194;
      }
      ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.cya();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      aG(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(41553);
      return true;
      ab.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      aF(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(41553);
      return true;
      label194:
      ab.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      aG(-1, str);
    }
    label220:
    AppMethodBeat.o(41553);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.n
 * JD-Core Version:    0.7.0.1
 */