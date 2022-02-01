package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

final class LaunchAAUI$18
  implements d.a
{
  LaunchAAUI$18(LaunchAAUI paramLaunchAAUI, boolean paramBoolean, Context paramContext, String paramString1, int paramInt, String paramString2, double paramDouble, ArrayList paramArrayList) {}
  
  public final void aHb()
  {
    AppMethodBeat.i(63651);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63649);
        if (LaunchAAUI.v(LaunchAAUI.18.this.idP) != null) {
          LaunchAAUI.v(LaunchAAUI.18.this.idP).dismiss();
        }
        Toast.makeText(LaunchAAUI.18.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(63649);
      }
    });
    AppMethodBeat.o(63651);
  }
  
  public final void bB(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(63650);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63648);
        if (LaunchAAUI.18.this.idW)
        {
          LaunchAAUI.a(LaunchAAUI.18.this.idP, LaunchAAUI.18.this.val$context, LaunchAAUI.18.this.fqK, LaunchAAUI.18.this.idX, LaunchAAUI.18.this.idY, LaunchAAUI.18.this.idZ, LaunchAAUI.18.this.idR, paramString1, paramString2);
          AppMethodBeat.o(63648);
          return;
        }
        LaunchAAUI.a(LaunchAAUI.18.this.idP, LaunchAAUI.18.this.val$context, LaunchAAUI.18.this.fqK, LaunchAAUI.18.this.idX, LaunchAAUI.18.this.idY, LaunchAAUI.18.this.idZ, LaunchAAUI.s(LaunchAAUI.18.this.idP), paramString1, paramString2);
        AppMethodBeat.o(63648);
      }
    });
    AppMethodBeat.o(63650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.18
 * JD-Core Version:    0.7.0.1
 */