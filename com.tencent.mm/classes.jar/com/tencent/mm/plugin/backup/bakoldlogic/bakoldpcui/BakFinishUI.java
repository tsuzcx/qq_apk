package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI
  extends MMWizardActivity
  implements e.e
{
  private int hOQ;
  private TextView hOS;
  private ah handler = new ah(Looper.getMainLooper());
  
  public final void avH()
  {
    this.handler.post(new BakFinishUI.2(this));
  }
  
  protected final int getLayoutId()
  {
    return R.i.bak_topc_finish;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.bak_chat_to_pc_title);
    this.hOS = ((TextView)findViewById(R.h.bak_topc_finish_tip));
    if (6 == this.hOQ) {
      this.hOS.setText(getString(R.l.bak_chat_to_pc_restore_finish));
    }
    for (;;)
    {
      setBackBtn(new BakFinishUI.1(this));
      return;
      if (1 == this.hOQ) {
        this.hOS.setText(getString(R.l.bak_chat_to_pc_back_finish));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    this.hOQ = getIntent().getIntExtra("cmd", -1);
    y.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.hOQ) });
    initView();
    a.avr().avs().hOa = this;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.avr().avs().hOa = null;
    y.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.hOQ) });
  }
  
  public final void onError(int paramInt)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
        Intent localIntent = new Intent(BakFinishUI.this, BakConnErrorUI.class);
        MMWizardActivity.C(BakFinishUI.this, localIntent);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a.avr().avs().hOi = -1;
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI
 * JD-Core Version:    0.7.0.1
 */