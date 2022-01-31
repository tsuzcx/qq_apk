package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI
  extends MMWizardActivity
{
  public int getLayoutId()
  {
    return 2130970636;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69861);
    setMMTitle(2131302832);
    setBackBtn(new BindSafeDeviceUI.1(this));
    ((ImageView)findViewById(2131827508)).setImageResource(2131230722);
    ((TextView)findViewById(2131827509)).setText(2131302838);
    ((TextView)findViewById(2131827512)).setText(2131302839);
    findViewById(2131827512).setOnClickListener(new BindSafeDeviceUI.2(this));
    AppMethodBeat.o(69861);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69860);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(69860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI
 * JD-Core Version:    0.7.0.1
 */