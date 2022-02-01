package com.tencent.mm.live.core.core.trtc.widget;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.f;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabSettingFragmentDialog
  extends BaseSettingFragmentDialog
{
  private TabLayout hBW;
  private ViewPager hBX;
  private List<Fragment> hBY;
  private List<String> hBZ;
  private q hCa;
  
  protected abstract List<String> aDW();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.hBY = getFragments();
    this.hBZ = aDW();
    if (this.hBY == null) {
      this.hBY = new ArrayList();
    }
    this.hBW.a(this.hBX, false, false);
    this.hCa = new BaseTabSettingFragmentDialog.1(this, getChildFragmentManager());
    this.hBX.setAdapter(this.hCa);
    int i = 0;
    while (i < this.hBZ.size())
    {
      paramView = this.hBW.ab(i);
      if (paramView != null) {
        paramView.d((CharSequence)this.hBZ.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */