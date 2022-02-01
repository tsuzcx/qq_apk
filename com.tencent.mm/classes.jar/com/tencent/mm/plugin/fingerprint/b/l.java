package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class l
  implements d
{
  private String itM;
  WeakReference<WalletBaseUI> rce;
  private com.tencent.mm.plugin.fingerprint.d.b rcf;
  private com.tencent.mm.plugin.fingerprint.d.b rcg;
  private com.tencent.mm.plugin.soter.a rch;
  
  private void aW(int paramInt, String paramString)
  {
    AppMethodBeat.i(64374);
    if (this.rcg != null) {
      this.rcg.aU(paramInt, paramString);
    }
    AppMethodBeat.o(64374);
  }
  
  private void cul()
  {
    AppMethodBeat.i(64372);
    this.rch.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64366);
        ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
        if ((l.this.rce != null) && (l.this.rce.get() != null))
        {
          ((WalletBaseUI)l.this.rce.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(2), false);
          AppMethodBeat.o(64366);
          return;
        }
        l.this.aV(-1, "base ui is null");
        AppMethodBeat.o(64366);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64367);
        if (paramAnonymousc.errCode == 1006)
        {
          ad.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          l.this.aV(-1, aj.getContext().getString(2131756561));
          AppMethodBeat.o(64367);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed");
            if ((!bt.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              l.this.aV(-2, aj.getContext().getString(2131756562));
              AppMethodBeat.o(64367);
              return;
            }
            if ((com.tencent.soter.core.a.fmN() == 1) && (!bt.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              l.this.aV(-2, aj.getContext().getString(2131756563));
              AppMethodBeat.o(64367);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ad.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.e(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ad.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.e(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ad.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.e(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ad.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.itM, 2));
    AppMethodBeat.o(64372);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb) {}
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64368);
    ad.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.rcf = paramb;
    this.itM = paramString;
    this.rce = new WeakReference((WalletBaseUI)paramContext);
    this.rch = new com.tencent.mm.plugin.soter.a();
    ((WalletBaseUI)this.rce.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.rce.get()).addSceneEndListener(1638);
    cul();
    AppMethodBeat.o(64368);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64371);
    ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.rcg = paramb;
    paramb = p.rcp.rct;
    if (paramb != null)
    {
      if ((this.rce != null) && (this.rce.get() != null))
      {
        ((WalletBaseUI)this.rce.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(paramb.Iva, paramb.signature, this.itM, 2));
        AppMethodBeat.o(64371);
      }
    }
    else
    {
      ad.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
      aW(-1, aj.getContext().getString(2131758809));
    }
    AppMethodBeat.o(64371);
  }
  
  final void aV(int paramInt, String paramString)
  {
    AppMethodBeat.i(64373);
    if (this.rcf != null) {
      this.rcf.aU(paramInt, paramString);
    }
    AppMethodBeat.o(64373);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64369);
    ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.rce != null) && (this.rce.get() != null))
    {
      ((WalletBaseUI)this.rce.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.rce.get()).removeSceneEndListener(1638);
    }
    p.rcp.reset();
    if ((this.rce != null) && (this.rce.get() != null)) {
      this.rce.clear();
    }
    AppMethodBeat.o(64369);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64370);
    ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = aj.getContext().getString(2131758809);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (bt.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramn).rcj))
        {
          aV(-1, str);
          AppMethodBeat.o(64370);
          return true;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64365);
            l.this.aV(0, "");
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
      ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.dEO();
      com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
      aW(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64370);
      return true;
      ad.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      aV(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.e(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64370);
      return true;
      label199:
      ad.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.e(8, paramInt1, paramInt2, "open fp pay failed");
      aW(-1, str);
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