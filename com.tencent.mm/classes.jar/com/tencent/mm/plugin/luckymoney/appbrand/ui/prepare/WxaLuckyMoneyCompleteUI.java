package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI
  extends WxaLuckyMoneyBaseUI
  implements b
{
  private Button mkr;
  
  public final MMActivity dhO()
  {
    return this;
  }
  
  public final void dhP() {}
  
  public final void error(String paramString) {}
  
  public int getLayoutId()
  {
    return 2131496117;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64942);
    this.mkr = ((Button)findViewById(2131307107));
    this.mkr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64940);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyCompleteUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WxaLuckyMoneyCompleteUI.this.setResult(0, null);
        WxaLuckyMoneyCompleteUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyCompleteUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64940);
      }
    });
    AppMethodBeat.o(64942);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(64943);
    setResult(0, null);
    finish();
    AppMethodBeat.o(64943);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64941);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(64941);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI
 * JD-Core Version:    0.7.0.1
 */