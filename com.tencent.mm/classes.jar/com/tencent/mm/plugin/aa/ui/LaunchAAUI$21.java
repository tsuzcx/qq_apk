package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

final class LaunchAAUI$21
  implements d.a
{
  LaunchAAUI$21(LaunchAAUI paramLaunchAAUI, Context paramContext, String paramString, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public final void aRb()
  {
    AppMethodBeat.i(198934);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198932);
        if (LaunchAAUI.v(LaunchAAUI.21.this.iXi) != null) {
          LaunchAAUI.v(LaunchAAUI.21.this.iXi).dismiss();
        }
        Toast.makeText(LaunchAAUI.21.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(198932);
      }
    });
    AppMethodBeat.o(198934);
  }
  
  public final void bL(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(198933);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198931);
        LaunchAAUI.a(LaunchAAUI.21.this.iXi, LaunchAAUI.21.this.val$context, LaunchAAUI.21.this.fNr, paramString1, paramString2, LaunchAAUI.21.this.iXo, LaunchAAUI.21.this.iXk);
        AppMethodBeat.o(198931);
      }
    });
    AppMethodBeat.o(198933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.21
 * JD-Core Version:    0.7.0.1
 */