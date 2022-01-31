package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;

@a(7)
public class UIEntryStub
  extends Activity
{
  private String Bo;
  private Intent bRh;
  private int hRW;
  private boolean hRX;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    NotifyReceiver.vY();
    this.hRX = false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.bRh = paramIntent;
    y.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[] { Boolean.valueOf(this.hRX) });
    this.hRX = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.bRh == null) {
      this.bRh = getIntent();
    }
    au.Dk().a(new bi(new UIEntryStub.1(this)), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub
 * JD-Core Version:    0.7.0.1
 */