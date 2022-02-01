package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/HldModePreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSelected", "", "mView", "Landroid/view/View;", "selectIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSelected", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "setSelected", "selected", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldModePreference
  extends Preference
{
  public static final HldModePreference.a JyY;
  private WeImageView HaZ;
  private boolean isSelected;
  private View mView;
  
  static
  {
    AppMethodBeat.i(312485);
    JyY = new HldModePreference.a((byte)0);
    AppMethodBeat.o(312485);
  }
  
  public HldModePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HldModePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312471);
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(312471);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(312518);
    s.u(paramView, "view");
    super.onBindView(paramView);
    aBq(8);
    paramView = paramView.findViewById(a.f.state_icon);
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(312518);
      throw paramView;
    }
    this.HaZ = ((WeImageView)paramView);
    paramView = this.HaZ;
    s.checkNotNull(paramView);
    if (this.isSelected) {}
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(312518);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(312502);
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(a.f.content);
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(312502);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_summary_below_hld_mode, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(312502);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.HldModePreference
 * JD-Core Version:    0.7.0.1
 */