package com.tencent.mm.plugin.downloader.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.plugin.downloader.c.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

@a(7)
public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private c eQV = null;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(c.b.empty);
    if (d.gF(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = new FileDownloadConfirmUI.1(this, getIntent().getLongExtra("extra_download_id", -1L));
    FileDownloadConfirmUI.2 local2 = new FileDownloadConfirmUI.2(this);
    FileDownloadConfirmUI.3 local3 = new FileDownloadConfirmUI.3(this);
    c.a locala = new c.a(this);
    locala.aez("");
    locala.Iq(c.c.file_downloader_confirm_title);
    locala.Is(c.c.app_yes).a(paramBundle);
    locala.It(c.c.app_no).b(local2);
    locala.a(local3);
    this.eQV = locala.aoP();
    this.eQV.show();
    y.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
  }
  
  protected void onStop()
  {
    super.onStop();
    this.eQV.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI
 * JD-Core Version:    0.7.0.1
 */