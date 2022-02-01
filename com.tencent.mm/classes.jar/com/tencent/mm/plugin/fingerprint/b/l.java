package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class l
  implements d
{
  private String jpT;
  WeakReference<WalletBaseUI> trT;
  private com.tencent.mm.plugin.fingerprint.d.b trU;
  private com.tencent.mm.plugin.fingerprint.d.b trV;
  private com.tencent.mm.plugin.soter.a trW;
  
  private void bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(64374);
    if (this.trV != null) {
      this.trV.bb(paramInt, paramString);
    }
    AppMethodBeat.o(64374);
  }
  
  private void cSr()
  {
    AppMethodBeat.i(64372);
    this.trW.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64366);
        ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
        if ((l.this.trT != null) && (l.this.trT.get() != null))
        {
          ((WalletBaseUI)l.this.trT.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(2), false);
          AppMethodBeat.o(64366);
          return;
        }
        l.this.bc(-1, "base ui is null");
        AppMethodBeat.o(64366);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64367);
        if (paramAnonymousc.errCode == 1006)
        {
          ae.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          l.this.bc(-1, ak.getContext().getString(2131756561));
          AppMethodBeat.o(64367);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.e(4, -1000223, -1, "gen auth key failed");
            if ((!bu.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              l.this.bc(-2, ak.getContext().getString(2131756562));
              AppMethodBeat.o(64367);
              return;
            }
            if ((com.tencent.soter.core.a.fYU() == 1) && (!bu.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              l.this.bc(-2, ak.getContext().getString(2131756563));
              AppMethodBeat.o(64367);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ae.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.e(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ae.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.e(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ae.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.e(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ae.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.e(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.jpT, 2));
    AppMethodBeat.o(64372);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb) {}
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64368);
    ae.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.trU = paramb;
    this.jpT = paramString;
    this.trT = new WeakReference((WalletBaseUI)paramContext);
    this.trW = new com.tencent.mm.plugin.soter.a();
    ((WalletBaseUI)this.trT.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.trT.get()).addSceneEndListener(1638);
    ((i)g.ab(i.class)).q(null);
    cSr();
    AppMethodBeat.o(64368);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64371);
    ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.trV = paramb;
    paramb = p.tse.tsi;
    if (paramb != null)
    {
      if ((this.trT != null) && (this.trT.get() != null))
      {
        ((WalletBaseUI)this.trT.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(paramb.MnB, paramb.signature, this.jpT, 2));
        AppMethodBeat.o(64371);
      }
    }
    else
    {
      ae.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.e(9, -1000223, -1, "signature is null");
      bd(-1, ak.getContext().getString(2131758809));
    }
    AppMethodBeat.o(64371);
  }
  
  final void bc(int paramInt, String paramString)
  {
    AppMethodBeat.i(64373);
    if (this.trU != null) {
      this.trU.bb(paramInt, paramString);
    }
    AppMethodBeat.o(64373);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64369);
    ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.trT != null) && (this.trT.get() != null))
    {
      ((WalletBaseUI)this.trT.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.trT.get()).removeSceneEndListener(1638);
    }
    p.tse.reset();
    if ((this.trT != null) && (this.trT.get() != null)) {
      this.trT.clear();
    }
    AppMethodBeat.o(64369);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64370);
    ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = ak.getContext().getString(2131758809);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (bu.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramn).trY))
        {
          bc(-1, str);
          AppMethodBeat.o(64370);
          return true;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64365);
            l.this.bc(0, "");
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
      ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.ejj();
      com.tencent.mm.plugin.soter.d.a.e(0, 0, 0, "OK");
      bd(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64370);
      return true;
      ae.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      bc(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.e(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64370);
      return true;
      label199:
      ae.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.e(8, paramInt1, paramInt2, "open fp pay failed");
      bd(-1, str);
    }
    label225:
    AppMethodBeat.o(64370);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l
 * JD-Core Version:    0.7.0.1
 */