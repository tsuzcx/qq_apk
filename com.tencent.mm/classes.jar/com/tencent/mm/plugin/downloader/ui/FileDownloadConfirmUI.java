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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d.a;

@com.tencent.mm.ui.base.a(7)
public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private com.tencent.mm.ui.widget.a.d jzT = null;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89126);
    super.onCreate(paramBundle);
    setContentView(2131493988);
    if (com.tencent.mm.compatible.util.d.oD(21)) {
      getWindow().setStatusBarColor(0);
    }
    final long l = getIntent().getLongExtra("extra_download_id", -1L);
    paramBundle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(89124);
        f.cBv().Cn(l);
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
    d.a locala = new d.a(this);
    locala.bon("");
    locala.aoS(2131759376);
    locala.aoV(2131756033).c(paramBundle);
    locala.aoW(2131755917).d((DialogInterface.OnClickListener)localObject);
    locala.a(local3);
    this.jzT = locala.hbn();
    this.jzT.show();
    paramBundle = com.tencent.mm.plugin.downloader.model.d.Cw(l);
    if (paramBundle != null)
    {
      localObject = new b();
      ((b)localObject).k(paramBundle);
      com.tencent.mm.plugin.downloader.f.a.a(19, (b)localObject);
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
    this.jzT.dismiss();
    AppMethodBeat.o(89128);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI
 * JD-Core Version:    0.7.0.1
 */