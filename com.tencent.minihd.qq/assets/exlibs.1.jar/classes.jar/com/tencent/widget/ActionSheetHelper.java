package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout.LayoutParams;

public class ActionSheetHelper
{
  public static Dialog a(Context paramContext, View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.a(AnimationUtils.loadAnimation(paramContext, 17432576));
    localActionSheet.b(AnimationUtils.loadAnimation(paramContext, 17432577));
    localActionSheet.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return localActionSheet;
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.b(paramContext);
    localActionSheet.a(AnimationUtils.loadAnimation(paramContext, 17432576));
    localActionSheet.b(AnimationUtils.loadAnimation(paramContext, 17432577));
    localActionSheet.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */