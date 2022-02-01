package com.tencent.mobileqq.text;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText$LinkSpan
  extends ClickableSpan
{
  protected String a;
  
  public QQText$LinkSpan(QQText paramQQText, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (Patterns.b.matcher(str).find()) {
      if (BubbleContextMenu.a) {
        if (QLog.isColorLevel()) {
          QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTextQQText.a(paramView, str);
      return;
      Matcher localMatcher = QQText.b.matcher(str);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == str.length()))
      {
        QQText.a(paramView.getContext(), str, true);
        return;
      }
    } while (!Patterns.f.matcher(str).find());
    QQText.a(paramView.getContext(), str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.LinkSpan
 * JD-Core Version:    0.7.0.1
 */