package com.tencent.mm.plugin.finder.accessibility.base;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getBooleanTag", "", "Landroid/view/View;", "tag", "", "fallback", "getIntTag", "getStringTag", "", "optBooleanTag", "(Landroid/view/View;I)Ljava/lang/Boolean;", "optIntTag", "(Landroid/view/View;I)Ljava/lang/Integer;", "optStringTag", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public static CharSequence an(View paramView, int paramInt)
  {
    s.u(paramView, "<this>");
    CharSequence localCharSequence = (CharSequence)"";
    s.u(paramView, "<this>");
    s.u(localCharSequence, "fallback");
    paramView = paramView.getTag(paramInt);
    if ((paramView instanceof CharSequence)) {}
    for (paramView = (CharSequence)paramView; paramView == null; paramView = null) {
      return localCharSequence;
    }
    return paramView;
  }
  
  public static int ao(View paramView, int paramInt)
  {
    s.u(paramView, "<this>");
    s.u(paramView, "<this>");
    paramView = paramView.getTag(paramInt);
    if ((paramView instanceof Integer)) {}
    for (paramView = (Integer)paramView; paramView == null; paramView = null) {
      return 0;
    }
    return paramView.intValue();
  }
  
  public static boolean ap(View paramView, int paramInt)
  {
    s.u(paramView, "<this>");
    return aq(paramView, paramInt);
  }
  
  public static boolean aq(View paramView, int paramInt)
  {
    s.u(paramView, "<this>");
    paramView = paramView.getTag(paramInt);
    if ((paramView instanceof Boolean)) {}
    for (paramView = (Boolean)paramView; paramView == null; paramView = null) {
      return false;
    }
    return paramView.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.base.a
 * JD-Core Version:    0.7.0.1
 */