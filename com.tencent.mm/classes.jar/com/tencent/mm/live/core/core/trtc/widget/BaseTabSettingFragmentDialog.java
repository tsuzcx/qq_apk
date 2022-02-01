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
  private q gMA;
  private TabLayout gMw;
  private ViewPager gMx;
  private List<Fragment> gMy;
  private List<String> gMz;
  
  protected abstract List<String> amq();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.gMy = getFragments();
    this.gMz = amq();
    if (this.gMy == null) {
      this.gMy = new ArrayList();
    }
    this.gMw.a(this.gMx, false, false);
    this.gMA = new i(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(197114);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(197114);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(197114);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(197113);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(197113);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(197113);
        return localFragment;
      }
    };
    this.gMx.setAdapter(this.gMA);
    int i = 0;
    while (i < this.gMz.size())
    {
      paramView = this.gMw.ad(i);
      if (paramView != null) {
        paramView.d((CharSequence)this.gMz.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */