package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class m
  implements d
{
  int dwi;
  private String jpT = "";
  private com.tencent.mm.plugin.fingerprint.d.b trF = null;
  private com.tencent.mm.plugin.fingerprint.d.b trG = null;
  WeakReference<WalletBaseUI> trT = null;
  private com.tencent.mm.plugin.soter.a trW;
  private String trY;
  String trZ;
  String tsa;
  
  private void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.trG.bb(paramInt, paramString);
    this.trG = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64381);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (bu.isNullOrNil(this.trY))
    {
      ae.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 41);
    ((i)com.tencent.mm.kernel.g.ab(i.class)).a(paramContext, new f(this.trY), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        ae.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
        for (;;)
        {
          paramb.bb(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          ae.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          m.this.dwi = paramAnonymousc.dwi;
          m.this.trZ = paramAnonymousc.trZ;
          m.this.tsa = paramAnonymousc.tsa;
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 40);
          paramb.bb(0, "");
          AppMethodBeat.o(64375);
          return;
          ae.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bb(-1, "");
          AppMethodBeat.o(64375);
          return;
          ae.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = ak.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = ak.getContext().getString(2131764095);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = ak.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          else
          {
            localObject = str;
            if (Build.VERSION.SDK_INT == 27)
            {
              localObject = str;
              if ("Xiaomi".equals(Build.MANUFACTURER)) {
                localObject = ak.getContext().getString(2131756561);
              }
            }
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 39);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
            continue;
            ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            localObject = ak.getContext().getString(2131764095);
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.soter.d.a.SA(2);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          }
        }
      }
    });
    AppMethodBeat.o(64381);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64379);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.trW = new com.tencent.mm.plugin.soter.a();
    this.trT = new WeakReference((WalletBaseUI)paramContext);
    this.trF = paramb;
    this.jpT = paramString;
    ((WalletBaseUI)this.trT.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.trT.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.eji();
    ((i)com.tencent.mm.kernel.g.ab(i.class)).q(null);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 35);
    this.trW.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((m.this.trT != null) && (m.this.trT.get() != null))
        {
          ((WalletBaseUI)m.this.trT.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        m.this.be(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          ae.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 34);
          m.this.be(-1, ak.getContext().getString(2131756561));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
            if ((!bu.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              m.this.be(-2, ak.getContext().getString(2131756562));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.fYU() == 1) && (!bu.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              m.this.be(-2, ak.getContext().getString(2131756563));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ae.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.d(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ae.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ae.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.d(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ae.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.jpT, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.trG = paramb;
    if (!bu.isNullOrNil(this.trZ))
    {
      if ((this.trT != null) && (this.trT.get() != null))
      {
        ((WalletBaseUI)this.trT.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.trZ, this.tsa, this.jpT, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      ae.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      be(-1, ak.getContext().getString(2131759409));
    }
    AppMethodBeat.o(64385);
  }
  
  final void be(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.trF != null) {
      this.trF.bb(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.trT != null) && (this.trT.get() != null))
    {
      ((WalletBaseUI)this.trT.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.trT.get()).removeSceneEndListener(1638);
    }
    this.trF = null;
    p.tse.reset();
    if ((this.trT != null) && (this.trT.get() != null)) {
      this.trT.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64383);
    ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = ak.getContext().getString(2131759409);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.a)paramn;
        if (bu.isNullOrNil(paramString.trY))
        {
          be(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.trY = paramString.trY;
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            m.this.be(0, "");
            AppMethodBeat.o(64378);
          }
        });
      }
    }
    else
    {
      if (!(paramn instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label235;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label207;
      }
      ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.ejj();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      bf(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      ae.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      be(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label207:
      ae.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      bf(-1, str);
    }
    label235:
    AppMethodBeat.o(64383);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.m
 * JD-Core Version:    0.7.0.1
 */