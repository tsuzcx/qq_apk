package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.c;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

@com.tencent.mm.ui.base.a(7)
public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private e pjp = null;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89126);
    super.onCreate(paramBundle);
    setContentView(c.c.empty);
    if (com.tencent.mm.compatible.util.d.rb(21)) {
      getWindow().setStatusBarColor(0);
    }
    final long l = getIntent().getLongExtra("extra_download_id", -1L);
    paramBundle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89124);
        f.duv().kR(l);
        Log.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[] { Long.valueOf(l) });
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
    e.a locala = new e.a(this);
    locala.bDv("");
    locala.aEO(c.d.file_downloader_confirm_title);
    locala.aER(c.d.app_yes).c(paramBundle);
    locala.aES(c.d.app_no).d((DialogInterface.OnClickListener)localObject);
    locala.c(local3);
    this.pjp = locala.jHH();
    this.pjp.show();
    paramBundle = com.tencent.mm.plugin.downloader.model.d.la(l);
    if (paramBundle != null)
    {
      localObject = new b();
      ((b)localObject).k(paramBundle);
      com.tencent.mm.plugin.downloader.e.a.a(19, (b)localObject);
    }
    Log.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    AppMethodBeat.o(89126);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(89127);
    Log.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    AppMethodBeat.o(89127);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(89128);
    super.onStop();
    this.pjp.dismiss();
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