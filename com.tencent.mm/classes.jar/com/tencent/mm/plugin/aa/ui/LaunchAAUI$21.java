package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.ArrayList;

final class LaunchAAUI$21
  implements d.a
{
  LaunchAAUI$21(LaunchAAUI paramLaunchAAUI, Context paramContext, String paramString, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public final void aRA()
  {
    AppMethodBeat.i(189768);
    ae.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189766);
        if (LaunchAAUI.v(LaunchAAUI.21.this.jab) != null) {
          LaunchAAUI.v(LaunchAAUI.21.this.jab).dismiss();
        }
        Toast.makeText(LaunchAAUI.21.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(189766);
      }
    });
    AppMethodBeat.o(189768);
  }
  
  public final void bL(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(189767);
    ae.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189765);
        LaunchAAUI.a(LaunchAAUI.21.this.jab, LaunchAAUI.21.this.val$context, LaunchAAUI.21.this.fOj, paramString1, paramString2, LaunchAAUI.21.this.jah, LaunchAAUI.21.this.jad);
        AppMethodBeat.o(189765);
      }
    });
    AppMethodBeat.o(189767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.21
 * JD-Core Version:    0.7.0.1
 */