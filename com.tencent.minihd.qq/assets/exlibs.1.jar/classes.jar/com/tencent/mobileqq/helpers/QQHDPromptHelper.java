package com.tencent.mobileqq.helpers;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;

public class QQHDPromptHelper
{
  public static Dialog a(Context paramContext, String paramString1, Drawable paramDrawable, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = DialogUtil.a(paramContext, 230, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
    paramContext.setPreviewImage(paramDrawable);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return DialogUtil.a(paramContext, 230, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static Dialog a(Context paramContext, String paramString, int[] paramArrayOfInt, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    paramContext = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    paramContext.a(paramString);
    paramContext.a(paramArrayOfInt);
    paramContext.a(paramOnButtonClickListener);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.helpers.QQHDPromptHelper
 * JD-Core Version:    0.7.0.1
 */