package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;

@a(7)
public class IPCallFeedbackDialogUI
  extends MMActivity
{
  private g lws;
  
  public void finish()
  {
    y.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
    if ((this.lws != null) && (this.lws.isShowing()))
    {
      this.lws.dismiss();
      this.lws = null;
    }
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
    this.lws = new g(this, this.mController.uMN, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0L));
    this.lws.setOnDismissListener(new IPCallFeedbackDialogUI.1(this));
    this.lws.getWindow().setSoftInputMode(16);
    this.lws.show();
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    y.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI
 * JD-Core Version:    0.7.0.1
 */