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
  private TabLayout gJN;
  private ViewPager gJO;
  private List<Fragment> gJP;
  private List<String> gJQ;
  private q gJR;
  
  protected abstract List<String> amb();
  
  protected abstract List<Fragment> getFragments();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.gJP = getFragments();
    this.gJQ = amb();
    if (this.gJP == null) {
      this.gJP = new ArrayList();
    }
    this.gJN.a(this.gJO, false, false);
    this.gJR = new i(getChildFragmentManager())
    {
      public final int getCount()
      {
        AppMethodBeat.i(216715);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(216715);
          return 0;
        }
        int i = BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).size();
        AppMethodBeat.o(216715);
        return i;
      }
      
      public final Fragment getItem(int paramAnonymousInt)
      {
        AppMethodBeat.i(216714);
        if (BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this) == null)
        {
          AppMethodBeat.o(216714);
          return null;
        }
        Fragment localFragment = (Fragment)BaseTabSettingFragmentDialog.a(BaseTabSettingFragmentDialog.this).get(paramAnonymousInt);
        AppMethodBeat.o(216714);
        return localFragment;
      }
    };
    this.gJO.setAdapter(this.gJR);
    int i = 0;
    while (i < this.gJQ.size())
    {
      paramView = this.gJN.ad(i);
      if (paramView != null) {
        paramView.d((CharSequence)this.gJQ.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.BaseTabSettingFragmentDialog
 * JD-Core Version:    0.7.0.1
 */