package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class l
  implements d
{
  private String iTR;
  private com.tencent.mm.plugin.fingerprint.d.b skA;
  private com.tencent.mm.plugin.soter.a skB;
  WeakReference<WalletBaseUI> sky;
  private com.tencent.mm.plugin.fingerprint.d.b skz;
  
  private void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(64374);
    if (this.skA != null) {
      this.skA.aZ(paramInt, paramString);
    }
    AppMethodBeat.o(64374);
  }
  
  private void cHx()
  {
    AppMethodBeat.i(64372);
    this.skB.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64366);
        ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
        if ((l.this.sky != null) && (l.this.sky.get() != null))
        {
          ((WalletBaseUI)l.this.sky.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(2), false);
          AppMethodBeat.o(64366);
          return;
        }
        l.this.ba(-1, "base ui is null");
        AppMethodBeat.o(64366);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64367);
        if (paramAnonymousc.errCode == 1006)
        {
          ac.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          l.this.ba(-1, ai.getContext().getString(2131756561));
          AppMethodBeat.o(64367);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed");
            if ((!bs.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              l.this.ba(-2, ai.getContext().getString(2131756562));
              AppMethodBeat.o(64367);
              return;
            }
            if ((com.tencent.soter.core.a.fDd() == 1) && (!bs.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              l.this.ba(-2, ai.getContext().getString(2131756563));
              AppMethodBeat.o(64367);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ac.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.e(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ac.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.e(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ac.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.e(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ac.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.iTR, 2));
    AppMethodBeat.o(64372);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb) {}
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64368);
    ac.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.skz = paramb;
    this.iTR = paramString;
    this.sky = new WeakReference((WalletBaseUI)paramContext);
    this.skB = new com.tencent.mm.plugin.soter.a();
    ((WalletBaseUI)this.sky.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.sky.get()).addSceneEndListener(1638);
    ((i)g.ab(i.class)).r(null);
    cHx();
    AppMethodBeat.o(64368);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64371);
    ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.skA = paramb;
    paramb = p.skJ.skN;
    if (paramb != null)
    {
      if ((this.sky != null) && (this.sky.get() != null))
      {
        ((WalletBaseUI)this.sky.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(paramb.JWJ, paramb.signature, this.iTR, 2));
        AppMethodBeat.o(64371);
      }
    }
    else
    {
      ac.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
      bb(-1, ai.getContext().getString(2131758809));
    }
    AppMethodBeat.o(64371);
  }
  
  final void ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(64373);
    if (this.skz != null) {
      this.skz.aZ(paramInt, paramString);
    }
    AppMethodBeat.o(64373);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64369);
    ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.sky != null) && (this.sky.get() != null))
    {
      ((WalletBaseUI)this.sky.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.sky.get()).removeSceneEndListener(1638);
    }
    p.skJ.reset();
    if ((this.sky != null) && (this.sky.get() != null)) {
      this.sky.clear();
    }
    AppMethodBeat.o(64369);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64370);
    ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = ai.getContext().getString(2131758809);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (bs.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramn).skD))
        {
          ba(-1, str);
          AppMethodBeat.o(64370);
          return true;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64365);
            l.this.ba(0, "");
            AppMethodBeat.o(64365);
          }
        });
      }
    }
    else
    {
      if (!(paramn instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label225;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label199;
      }
      ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.dTn();
      com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
      bb(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64370);
      return true;
      ac.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      ba(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.e(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64370);
      return true;
      label199:
      ac.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.e(8, paramInt1, paramInt2, "open fp pay failed");
      bb(-1, str);
    }
    label225:
    AppMethodBeat.o(64370);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l
 * JD-Core Version:    0.7.0.1
 */