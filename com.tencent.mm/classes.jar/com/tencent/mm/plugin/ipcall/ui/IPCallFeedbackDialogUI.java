package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI
  extends MMActivity
{
  private g uRW;
  
  public void finish()
  {
    AppMethodBeat.i(25795);
    ad.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
    if ((this.uRW != null) && (this.uRW.isShowing()))
    {
      this.uRW.dismiss();
      this.uRW = null;
    }
    super.finish();
    AppMethodBeat.o(25795);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25791);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
    this.uRW = new g(this, getContext(), getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0L));
    this.uRW.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25790);
        IPCallFeedbackDialogUI.this.finish();
        AppMethodBeat.o(25790);
      }
    });
    this.uRW.getWindow().setSoftInputMode(16);
    this.uRW.show();
    AppMethodBeat.o(25791);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25794);
    ad.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(25794);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(25793);
    ad.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(25793);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25792);
    ad.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
    super.onResume();
    AppMethodBeat.o(25792);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI
 * JD-Core Version:    0.7.0.1
 */