package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ
  extends MMWizardActivity
{
  protected final int getLayoutId()
  {
    return a.f.succ_unbindqq;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.unbind_qq);
    addTextOptionMenu(0, getString(a.i.app_finish), new SuccUnbindQQ.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.SuccUnbindQQ
 * JD-Core Version:    0.7.0.1
 */