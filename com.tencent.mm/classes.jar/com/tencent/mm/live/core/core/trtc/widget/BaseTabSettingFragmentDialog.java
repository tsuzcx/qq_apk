package com.tencent.mm.live.core.core.trtc.widget;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
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
  private TabLayout mTS;
  private ViewPager mTT;
  private List<Fragment> mTU;
  private List<String> mTV;
  private a mTW;
  
  protected abstract List<String> bfy();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTU = getFragments();
    this.mTV = bfy();
    if (this.mTU == null) {
      this.mTU = new ArrayList();
    }
    this.mTS.a(this.mTT, false, false);
    this.mTW = new m(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(248366);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(248366);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(248366);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(248358);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(248358);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(248358);
        return localFragment;
      }
    };
    this.mTT.setAdapter(this.mTW);
    int i = 0;
    while (i < this.mTV.size())
    {
      paramView = this.mTS.js(i);
      if (paramView != null) {
        paramView.D((CharSequence)this.mTV.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */