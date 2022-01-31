package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI
  extends MMActivity
{
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_no_wifi;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new FreeWifiNoWifiUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI
 * JD-Core Version:    0.7.0.1
 */