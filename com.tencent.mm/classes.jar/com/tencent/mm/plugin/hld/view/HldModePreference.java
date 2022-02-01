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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/HldModePreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSelected", "", "mView", "Landroid/view/View;", "selectIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSelected", "onBindView", "", "view", "onCreateView", "parent", "Landroid/view/ViewGroup;", "setSelected", "selected", "Companion", "plugin-hld_release"})
public final class HldModePreference
  extends Preference
{
  public static final a DHQ;
  private WeImageView Buo;
  private boolean isSelected;
  private View mView;
  
  static
  {
    AppMethodBeat.i(215542);
    DHQ = new a((byte)0);
    AppMethodBeat.o(215542);
  }
  
  public HldModePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HldModePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215540);
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(215540);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(215537);
    p.k(paramView, "view");
    super.onBindView(paramView);
    auO(8);
    paramView = paramView.findViewById(a.f.state_icon);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(215537);
      throw paramView;
    }
    this.Buo = ((WeImageView)paramView);
    paramView = this.Buo;
    if (paramView == null) {
      p.iCn();
    }
    if (this.isSelected) {}
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(215537);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(215535);
    paramViewGroup = super.onCreateView(paramViewGroup);
    Object localObject = paramViewGroup.findViewById(a.f.content);
    if (localObject == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(215535);
      throw paramViewGroup;
    }
    localObject = (ViewGroup)localObject;
    ((ViewGroup)localObject).removeAllViews();
    View.inflate(getContext(), a.h.mm_preference_summary_below_hld_mode, (ViewGroup)localObject);
    this.mView = paramViewGroup;
    paramViewGroup = this.mView;
    AppMethodBeat.o(215535);
    return paramViewGroup;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/HldModePreference$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.HldModePreference
 * JD-Core Version:    0.7.0.1
 */