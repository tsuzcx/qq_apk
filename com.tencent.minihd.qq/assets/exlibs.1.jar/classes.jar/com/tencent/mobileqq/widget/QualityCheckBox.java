package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class QualityCheckBox
  extends CheckBox
{
  public QualityCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public QualityCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QualityCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3000) || (paramInt == 1);
  }
  
  public void setText(ArrayList paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    int j = 0;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      long l = new File(str).length();
      int k = j;
      if (l > 19922944L) {
        k = j + 1;
      }
      int m = (int)(i + l);
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "addExtraBtn path:" + str + ",len:" + l);
        i = m;
        j = k;
      }
    }
    boolean bool2 = a(paramInt);
    if ((bool2) && (j <= 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "addExtraBtn showSendRaw:" + bool1);
      }
      if (!bool1) {
        break;
      }
      paramArrayList = PhotoUtils.a(getContext(), i);
      setText(getContext().getString(2131368350) + "(" + paramArrayList + ")");
      setEnabled(true);
      return;
    }
    if (bool2) {
      setText(2131368365);
    }
    for (;;)
    {
      setEnabled(false);
      return;
      setText(2131368350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QualityCheckBox
 * JD-Core Version:    0.7.0.1
 */