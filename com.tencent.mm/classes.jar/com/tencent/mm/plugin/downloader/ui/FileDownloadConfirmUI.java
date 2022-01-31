package com.tencent.mm.plugin.downloader.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

@com.tencent.mm.ui.base.a(7)
public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private c giQ = null;
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(2518);
    super.onCreate(paramBundle);
    setContentView(2130969422);
    if (com.tencent.mm.compatible.util.d.fv(21)) {
      getWindow().setStatusBarColor(0);
    }
    long l = getIntent().getLongExtra("extra_download_id", -1L);
    paramBundle = new FileDownloadConfirmUI.1(this, l);
    Object localObject = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    };
    FileDownloadConfirmUI.3 local3 = new FileDownloadConfirmUI.3(this);
    c.a locala = new c.a(this);
    locala.avm("");
    locala.Rf(2131299868);
    locala.Ri(2131297115).a(paramBundle);
    locala.Rj(2131297014).b((DialogInterface.OnClickListener)localObject);
    locala.a(local3);
    this.giQ = locala.aLZ();
    this.giQ.show();
    paramBundle = com.tencent.mm.plugin.downloader.model.d.iJ(l);
    if (paramBundle != null)
    {
      localObject = new b();
      ((b)localObject).i(paramBundle);
      com.tencent.mm.plugin.downloader.f.a.a(19, (b)localObject);
    }
    ab.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    AppMethodBeat.o(2518);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(2519);
    ab.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    AppMethodBeat.o(2519);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(2520);
    super.onStop();
    this.giQ.dismiss();
    AppMethodBeat.o(2520);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI
 * JD-Core Version:    0.7.0.1
 */