package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI
  extends MMWizardActivity
  implements e.c
{
  private boolean hPi;
  private ah handler = new ah(Looper.getMainLooper());
  private int uC;
  
  final void avN()
  {
    if ((6 == this.uC) || (1 == this.uC))
    {
      Intent localIntent = new Intent(this, BakOperatingUI.class);
      localIntent.putExtra("cmd", this.uC);
      MMWizardActivity.C(this, localIntent);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.bak_topc_wait;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.bak_chat_to_pc_title);
    if (this.hPi) {
      findViewById(R.h.bak_topc_tip).setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new BakWaitingUI.1(this));
      return;
      findViewById(R.h.bak_topc_tip).setVisibility(0);
    }
  }
  
  public final void nQ(int paramInt)
  {
    this.uC = paramInt;
    this.handler.post(new BakWaitingUI.2(this));
  }
  
  public final void nR(final int paramInt)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          y.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(R.l.backup_pc_not_support_title));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[] { x.cqJ() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
        }
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    a.avr().avs().hNY = this;
    this.uC = a.avr().avs().hOf;
    this.hPi = getIntent().getBooleanExtra("from_back_finish", false);
    y.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.uC), Boolean.valueOf(this.hPi) });
    initView();
    avN();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.avr().avs().hNY = null;
    y.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.uC), Boolean.valueOf(this.hPi) });
  }
  
  public final void onError(final int paramInt)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          y.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(R.l.backup_pc_not_support_title));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[] { x.cqJ() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          return;
        }
        Intent localIntent = new Intent(BakWaitingUI.this, BakConnErrorUI.class);
        MMWizardActivity.C(BakWaitingUI.this, localIntent);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI
 * JD-Core Version:    0.7.0.1
 */