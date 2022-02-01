package com.tencent.mm.live.core.core.trtc.widget;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabSettingFragmentDialog
  extends BaseSettingFragmentDialog
{
  private TabLayout kpW;
  private ViewPager kpX;
  private List<Fragment> kpY;
  private List<String> kpZ;
  private a kqa;
  
  protected abstract List<String> aMd();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.kpY = getFragments();
    this.kpZ = aMd();
    if (this.kpY == null) {
      this.kpY = new ArrayList();
    }
    this.kpW.a(this.kpX, false, false);
    this.kqa = new g(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(200281);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(200281);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(200281);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(200280);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(200280);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(200280);
        return localFragment;
      }
    };
    this.kpX.setAdapter(this.kqa);
    int i = 0;
    while (i < this.kpZ.size())
    {
      paramView = this.kpW.gd(i);
      if (paramView != null) {
        paramView.y((CharSequence)this.kpZ.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */