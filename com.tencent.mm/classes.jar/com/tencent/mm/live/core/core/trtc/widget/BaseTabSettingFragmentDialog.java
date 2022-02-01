package com.tencent.mm.live.core.core.trtc.widget;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.f;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabSettingFragmentDialog
  extends BaseSettingFragmentDialog
{
  private q pTo;
  private TabLayout qLz;
  private ViewPager qMJ;
  private List<Fragment> qNM;
  private List<String> qNR;
  
  protected abstract List<String> crS();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.qNM = getFragments();
    this.qNR = crS();
    if (this.qNM == null) {
      this.qNM = new ArrayList();
    }
    this.qLz.a(this.qMJ, false, false);
    this.pTo = new i(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(205528);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(205528);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(205528);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(205527);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(205527);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(205527);
        return localFragment;
      }
    };
    this.qMJ.setAdapter(this.pTo);
    int i = 0;
    while (i < this.qNR.size())
    {
      paramView = this.qLz.ad(i);
      if (paramView != null) {
        paramView.d((CharSequence)this.qNR.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */