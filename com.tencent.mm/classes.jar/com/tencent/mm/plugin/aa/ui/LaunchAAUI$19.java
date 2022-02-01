package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

final class LaunchAAUI$19
  implements d.a
{
  LaunchAAUI$19(LaunchAAUI paramLaunchAAUI, Context paramContext, String paramString, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public final void aHb()
  {
    AppMethodBeat.i(63655);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63653);
        if (LaunchAAUI.v(LaunchAAUI.19.this.idP) != null) {
          LaunchAAUI.v(LaunchAAUI.19.this.idP).dismiss();
        }
        Toast.makeText(LaunchAAUI.19.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(63653);
      }
    });
    AppMethodBeat.o(63655);
  }
  
  public final void bB(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(63654);
    ad.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63652);
        LaunchAAUI.a(LaunchAAUI.19.this.idP, LaunchAAUI.19.this.val$context, LaunchAAUI.19.this.fqK, paramString1, paramString2, LaunchAAUI.19.this.idW, LaunchAAUI.19.this.idR);
        AppMethodBeat.o(63652);
      }
    });
    AppMethodBeat.o(63654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.19
 * JD-Core Version:    0.7.0.1
 */