package com.tencent.mobileqq.business.sougou;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import hvp;

public class HightlightHotWordText
  extends ClickableSpan
{
  public String a;
  public String b = "https://m.sogou.com/web/searchList.jsp?pid=sogou-appi-4fc28b7093b135c2&keyword=";
  
  HightlightHotWordText(String paramString)
  {
    this.a = paramString;
  }
  
  public static SpannableStringBuilder a(String paramString, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfHotWordItem == null)) {
      return null;
    }
    localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    try
    {
      paramString = paramString.getBytes("GB2312");
      int j = -1;
      int i = 0;
      while (i < paramArrayOfHotWordItem.length)
      {
        String str = new String(paramString, 0, paramArrayOfHotWordItem[i].offset, "GB2312");
        int k = j;
        if (j != str.length())
        {
          k = str.length() + paramArrayOfHotWordItem[i].hotWord.length();
          localSpannableStringBuilder.setSpan(new HightlightHotWordText(paramArrayOfHotWordItem[i].hotWord), str.length(), k, 33);
        }
        i += 1;
        j = k;
      }
      return localSpannableStringBuilder;
    }
    catch (Exception paramString) {}
  }
  
  private void a(Context paramContext)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.a(2131363518, 5);
    localActionSheet.e(2131365736);
    localActionSheet.a(new hvp(this, paramContext, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.getContext();
    } while (paramView == null);
    a(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.HightlightHotWordText
 * JD-Core Version:    0.7.0.1
 */