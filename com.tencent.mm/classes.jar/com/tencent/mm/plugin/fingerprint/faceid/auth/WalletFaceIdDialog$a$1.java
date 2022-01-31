package com.tencent.mm.plugin.fingerprint.faceid.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletFaceIdDialog$a$1
  implements d
{
  WalletFaceIdDialog$a$1(WalletFaceIdDialog.a parama) {}
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41396);
    ab.i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(WalletFaceIdDialog.a.b(this.mFH)) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41396);
      return;
      ab.i("MicroMsg.WalletFaceIdDialog", "identify success");
      WalletFaceIdDialog.a.a(this.mFH, paramInt2);
      WalletFaceIdDialog.a.c(this.mFH);
      WalletFaceIdDialog.a.b(this.mFH, paramInt2);
      AppMethodBeat.o(41396);
      return;
      WalletFaceIdDialog.a.c(this.mFH);
      if (WalletFaceIdDialog.a.b(this.mFH) < 2)
      {
        WalletFaceIdDialog.a.d(this.mFH);
        AppMethodBeat.o(41396);
        return;
      }
      WalletFaceIdDialog.a.c(this.mFH, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog.a.1
 * JD-Core Version:    0.7.0.1
 */