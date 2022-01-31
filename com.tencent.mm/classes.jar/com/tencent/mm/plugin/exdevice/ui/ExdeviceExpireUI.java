package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return R.i.exdevice_expire_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.exdevice_rank_tile);
    setBackBtn(new ExdeviceExpireUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI
 * JD-Core Version:    0.7.0.1
 */