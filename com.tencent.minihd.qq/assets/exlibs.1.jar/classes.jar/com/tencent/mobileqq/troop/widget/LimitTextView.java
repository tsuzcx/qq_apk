package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class LimitTextView
  extends AnimationTextView
{
  public static final String a = "…";
  private CharSequence a = null;
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public CharSequence a()
  {
    if (this.a != null) {
      return this.a;
    }
    return super.getText();
  }
  
  @TargetApi(16)
  public int getMaxLines()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = super.getMaxLines();
    }
    for (;;)
    {
      return i;
      try
      {
        int j = TextView.class.getDeclaredField("mMaxMode").getInt(this);
        i = TextView.class.getDeclaredField("mMaximum").getInt(this);
        int k = TextView.class.getDeclaredField("LINES").getInt(this);
        if (j == k) {
          continue;
        }
        return -1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return -1;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label60:
        break label60;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMaxLines();
    Object localObject;
    String str;
    if ((paramInt1 > 0) && (super.getLineCount() > paramInt1))
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(paramInt1 - 1);
      this.a = getText();
      localObject = this.a.toString();
      paramInt2 = ((String)localObject).codePointAt(paramInt1 - 2);
      paramInt3 = ((String)localObject).codePointAt(paramInt1 - 1);
      if (((paramInt2 != 20) || (paramInt3 < 0) || (paramInt3 >= EmotcationConstants.b)) && (paramInt2 <= 65535)) {
        break label164;
      }
      str = this.a.subSequence(0, paramInt1 - 2) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取的是系统表情或者emoji表情------------");
        localObject = str;
      }
    }
    for (;;)
    {
      setText((CharSequence)localObject);
      return;
      label164:
      str = this.a.subSequence(0, paramInt1 - 1) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取正常文本------------");
        localObject = str;
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(new QQText(paramCharSequence, 13, 32, 1), TextView.BufferType.SPANNABLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LimitTextView
 * JD-Core Version:    0.7.0.1
 */