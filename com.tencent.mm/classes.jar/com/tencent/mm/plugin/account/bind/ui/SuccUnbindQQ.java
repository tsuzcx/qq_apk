package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ
  extends MMWizardActivity
{
  public int getLayoutId()
  {
    return 2130970977;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13775);
    setMMTitle(2131304406);
    addTextOptionMenu(0, getString(2131296964), new SuccUnbindQQ.1(this));
    AppMethodBeat.o(13775);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13772);
    super.onCreate(paramBundle);
    AppMethodBeat.o(13772);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13773);
    super.onDestroy();
    AppMethodBeat.o(13773);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13774);
    super.onResume();
    initView();
    AppMethodBeat.o(13774);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.SuccUnbindQQ
 * JD-Core Version:    0.7.0.1
 */