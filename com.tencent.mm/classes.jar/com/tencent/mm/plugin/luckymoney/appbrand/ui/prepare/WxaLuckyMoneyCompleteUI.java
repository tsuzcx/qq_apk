package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private Button nJm;
  
  public final void Sp(String paramString) {}
  
  public final MMActivity bMN()
  {
    return this;
  }
  
  public final void bMO() {}
  
  public int getLayoutId()
  {
    return 2130971334;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42051);
    this.nJm = ((Button)findViewById(2131829601));
    this.nJm.setOnClickListener(new WxaLuckyMoneyCompleteUI.1(this));
    AppMethodBeat.o(42051);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42052);
    setResult(0, null);
    finish();
    AppMethodBeat.o(42052);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42050);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(42050);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI
 * JD-Core Version:    0.7.0.1
 */