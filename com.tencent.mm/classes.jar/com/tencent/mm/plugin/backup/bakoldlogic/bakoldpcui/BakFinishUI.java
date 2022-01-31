package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI
  extends MMWizardActivity
  implements e.e
{
  private ak handler;
  private int jIs;
  private TextView jIu;
  
  public BakFinishUI()
  {
    AppMethodBeat.i(17924);
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(17924);
  }
  
  public final void aVk()
  {
    AppMethodBeat.i(17929);
    this.handler.post(new BakFinishUI.2(this));
    AppMethodBeat.o(17929);
  }
  
  public int getLayoutId()
  {
    return 2130968813;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17926);
    setMMTitle(2131297432);
    this.jIu = ((TextView)findViewById(2131821661));
    if (6 == this.jIs) {
      this.jIu.setText(getString(2131297428));
    }
    for (;;)
    {
      setBackBtn(new BakFinishUI.1(this));
      AppMethodBeat.o(17926);
      return;
      if (1 == this.jIs) {
        this.jIu.setText(getString(2131297419));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17925);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17925);
      return;
    }
    this.jIs = getIntent().getIntExtra("cmd", -1);
    ab.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.jIs) });
    initView();
    a.aUU().aUV().jHC = this;
    AppMethodBeat.o(17925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17927);
    super.onDestroy();
    a.aUU().aUV().jHC = null;
    ab.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.jIs) });
    AppMethodBeat.o(17927);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(17930);
    this.handler.post(new BakFinishUI.3(this));
    AppMethodBeat.o(17930);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17928);
    if (paramInt == 4)
    {
      a.aUU().aUV().jHK = -1;
      Oi(1);
      AppMethodBeat.o(17928);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17928);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI
 * JD-Core Version:    0.7.0.1
 */