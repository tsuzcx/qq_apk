package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

final class LaunchAAUI$20
  implements d.a
{
  LaunchAAUI$20(LaunchAAUI paramLaunchAAUI, boolean paramBoolean, Context paramContext, String paramString1, int paramInt, String paramString2, double paramDouble, ArrayList paramArrayList) {}
  
  public final void aRb()
  {
    AppMethodBeat.i(198930);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198928);
        if (LaunchAAUI.v(LaunchAAUI.20.this.iXi) != null) {
          LaunchAAUI.v(LaunchAAUI.20.this.iXi).dismiss();
        }
        Toast.makeText(LaunchAAUI.20.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(198928);
      }
    });
    AppMethodBeat.o(198930);
  }
  
  public final void bL(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(198929);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198927);
        if (LaunchAAUI.20.this.iXo)
        {
          LaunchAAUI.a(LaunchAAUI.20.this.iXi, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fNr, LaunchAAUI.20.this.iXp, LaunchAAUI.20.this.iXq, LaunchAAUI.20.this.iXr, LaunchAAUI.20.this.iXk, paramString1, paramString2);
          AppMethodBeat.o(198927);
          return;
        }
        LaunchAAUI.a(LaunchAAUI.20.this.iXi, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fNr, LaunchAAUI.20.this.iXp, LaunchAAUI.20.this.iXq, LaunchAAUI.20.this.iXr, LaunchAAUI.s(LaunchAAUI.20.this.iXi), paramString1, paramString2);
        AppMethodBeat.o(198927);
      }
    });
    AppMethodBeat.o(198929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.20
 * JD-Core Version:    0.7.0.1
 */