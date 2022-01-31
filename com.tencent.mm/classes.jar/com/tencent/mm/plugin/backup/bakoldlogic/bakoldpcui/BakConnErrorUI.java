package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI
  extends MMWizardActivity
{
  private int hOQ;
  
  protected final int getLayoutId()
  {
    return R.i.bak_topc_error;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.bak_chat_to_pc_title);
    setBackBtn(new BakConnErrorUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    this.hOQ = getIntent().getIntExtra("cmd", -1);
    y.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.hOQ) });
    initView();
    a.avr().avs().hOi = -1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.avr().avs().hOa = null;
    y.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.hOQ) });
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
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI
 * JD-Core Version:    0.7.0.1
 */