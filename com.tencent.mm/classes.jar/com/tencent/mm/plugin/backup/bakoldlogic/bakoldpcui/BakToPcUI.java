package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private Button fbO;
  private Button hPe;
  private TextView hPf;
  private TextView hPg;
  private ah handler = new ah(Looper.getMainLooper());
  private int uC = -1;
  
  private void avM()
  {
    if (this.uC == 0)
    {
      this.fbO.setEnabled(true);
      this.hPe.setEnabled(true);
      return;
    }
    this.fbO.setEnabled(false);
    this.hPe.setEnabled(false);
  }
  
  public final void avE()
  {
    this.uC = 0;
    this.fbO.setVisibility(0);
    this.hPe.setVisibility(0);
    new ah(Looper.getMainLooper()).post(new BakToPcUI.4(this));
  }
  
  protected final int getLayoutId()
  {
    return R.i.bak_topc_chat;
  }
  
  public final void initView()
  {
    setMMTitle(R.l.bak_chat_to_pc_title);
    setBackBtn(new BakToPcUI.1(this));
    this.fbO = ((Button)findViewById(R.h.bak_topc_ok_button));
    this.fbO.setOnClickListener(new BakToPcUI.2(this));
    this.hPe = ((Button)findViewById(R.h.bak_topc_cancel_button));
    this.hPe.setOnClickListener(new BakToPcUI.3(this));
    this.hPf = ((TextView)findViewById(R.h.bak_topc_tip_pcname));
    this.hPf.setText(a.avr().avs().hOg);
    this.hPg = ((TextView)findViewById(R.h.bak_topc_tip_username));
    this.hPg.setText(a.avr().avs().hOh);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    initView();
    this.uC = a.avr().avs().hOf;
    y.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.uC) });
    a.avr().avs().hNZ = this;
    avM();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.uC) });
    a.avr().avs().hNZ = null;
  }
  
  public final void onError(int paramInt)
  {
    this.handler.post(new BakToPcUI.5(this, paramInt));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a.avr().avt().dVU = 3;
      a.avr().avt().Ig();
      a.avr().avs().nN(1);
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */