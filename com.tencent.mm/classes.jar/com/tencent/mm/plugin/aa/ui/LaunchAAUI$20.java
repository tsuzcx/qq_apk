package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.ArrayList;

final class LaunchAAUI$20
  implements d.a
{
  LaunchAAUI$20(LaunchAAUI paramLaunchAAUI, boolean paramBoolean, Context paramContext, String paramString1, int paramInt, String paramString2, double paramDouble, ArrayList paramArrayList) {}
  
  public final void aRA()
  {
    AppMethodBeat.i(189764);
    ae.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onError");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189762);
        if (LaunchAAUI.v(LaunchAAUI.20.this.jab) != null) {
          LaunchAAUI.v(LaunchAAUI.20.this.jab).dismiss();
        }
        Toast.makeText(LaunchAAUI.20.this.val$context, 2131760656, 1).show();
        AppMethodBeat.o(189762);
      }
    });
    AppMethodBeat.o(189764);
  }
  
  public final void bL(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(189763);
    ae.i("MicroMsg.Aa.LaunchAAUI", "IImgUploadCallback onSuccess");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189761);
        if (LaunchAAUI.20.this.jah)
        {
          LaunchAAUI.a(LaunchAAUI.20.this.jab, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fOj, LaunchAAUI.20.this.jai, LaunchAAUI.20.this.jaj, LaunchAAUI.20.this.jak, LaunchAAUI.20.this.jad, paramString1, paramString2);
          AppMethodBeat.o(189761);
          return;
        }
        LaunchAAUI.a(LaunchAAUI.20.this.jab, LaunchAAUI.20.this.val$context, LaunchAAUI.20.this.fOj, LaunchAAUI.20.this.jai, LaunchAAUI.20.this.jaj, LaunchAAUI.20.this.jak, LaunchAAUI.s(LaunchAAUI.20.this.jab), paramString1, paramString2);
        AppMethodBeat.o(189761);
      }
    });
    AppMethodBeat.o(189763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.20
 * JD-Core Version:    0.7.0.1
 */