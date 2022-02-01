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
  private TabLayout gqd;
  private ViewPager gqe;
  private List<Fragment> gqf;
  private List<String> gqg;
  private q gqh;
  
  protected abstract List<String> ajp();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.gqf = getFragments();
    this.gqg = ajp();
    if (this.gqf == null) {
      this.gqf = new ArrayList();
    }
    this.gqd.a(this.gqe, false, false);
    this.gqh = new i(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(209061);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(209061);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(209061);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(209060);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(209060);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(209060);
        return localFragment;
      }
    };
    this.gqe.setAdapter(this.gqh);
    int i = 0;
    while (i < this.gqg.size())
    {
      paramView = this.gqd.ad(i);
      if (paramView != null) {
        paramView.d((CharSequence)this.gqg.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */