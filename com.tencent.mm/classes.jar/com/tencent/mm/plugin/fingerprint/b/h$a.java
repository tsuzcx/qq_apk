package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$a
  implements q.a
{
  private h$a(h paramh) {}
  
  public final void BS(String paramString)
  {
    AppMethodBeat.i(41484);
    if (TextUtils.isEmpty(paramString))
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41482);
          h.a.this.mGb.mFX.aC(-1, h.a.this.mGb.mFZ.getString(2131299968));
          AppMethodBeat.o(41482);
        }
      });
      ab.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
      AppMethodBeat.o(41484);
      return;
    }
    al.d(new h.a.2(this, paramString));
    AppMethodBeat.o(41484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.h.a
 * JD-Core Version:    0.7.0.1
 */