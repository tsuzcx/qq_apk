package com.tencent.mm.plugin.downloader.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d.a;

@com.tencent.mm.ui.base.a(7)
public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private com.tencent.mm.ui.widget.a.d hRe = null;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89126);
    super.onCreate(paramBundle);
    setContentView(2131493834);
    if (com.tencent.mm.compatible.util.d.lf(21)) {
      getWindow().setStatusBarColor(0);
    }
    final long l = getIntent().getLongExtra("extra_download_id", -1L);
    paramBundle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89124);
        f.bQt().og(l);
        ad.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(89124);
      }
    };
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    };
    DialogInterface.OnDismissListener local3 = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(89125);
        FileDownloadConfirmUI.this.finish();
        AppMethodBeat.o(89125);
      }
    };
    d.a locala = new d.a(this);
    locala.aMf("");
    locala.aay(2131759048);
    locala.aaB(2131755939).b(paramBundle);
    locala.aaC(2131755831).c((DialogInterface.OnClickListener)localObject);
    locala.a(local3);
    this.hRe = locala.fft();
    this.hRe.show();
    paramBundle = com.tencent.mm.plugin.downloader.model.d.oq(l);
    if (paramBundle != null)
    {
      localObject = new b();
      ((b)localObject).k(paramBundle);
      com.tencent.mm.plugin.downloader.f.a.a(19, (b)localObject);
    }
    ad.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    AppMethodBeat.o(89126);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(89127);
    ad.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    AppMethodBeat.o(89127);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(89128);
    super.onStop();
    this.hRe.dismiss();
    AppMethodBeat.o(89128);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI
 * JD-Core Version:    0.7.0.1
 */