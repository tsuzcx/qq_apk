package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.ui.base.preference.Preference;

public class BizTimelineSettingLoadingPreference
  extends Preference
{
  private View mView;
  
  public BizTimelineSettingLoadingPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizTimelineSettingLoadingPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(301990);
    this.mView = null;
    setLayoutResource(d.f.biz_time_line_setting_loading_pref);
    AppMethodBeat.o(301990);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(302000);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    super.onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(302000);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(369883);
    super.onBindView(paramView);
    AppMethodBeat.o(369883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimelineSettingLoadingPreference
 * JD-Core Version:    0.7.0.1
 */