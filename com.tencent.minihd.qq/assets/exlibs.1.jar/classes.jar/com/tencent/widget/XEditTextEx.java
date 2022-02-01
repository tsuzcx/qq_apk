package com.tencent.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;

public class XEditTextEx
  extends XEditText
{
  private static final String jdField_a_of_type_JavaLangString = XEditTextEx.class.getSimpleName();
  private XEditTextEx.OnPrivateIMECommandListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener;
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener != null) {
      return this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener.a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public void setOnPrivateIMECommandListener(XEditTextEx.OnPrivateIMECommandListener paramOnPrivateIMECommandListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener = paramOnPrivateIMECommandListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */