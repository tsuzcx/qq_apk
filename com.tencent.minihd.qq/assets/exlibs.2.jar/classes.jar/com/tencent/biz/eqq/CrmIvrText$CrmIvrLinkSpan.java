package com.tencent.biz.eqq;

import android.view.View;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrmIvrText$CrmIvrLinkSpan
  extends QQText.LinkSpan
{
  public CrmIvrText$CrmIvrLinkSpan(CrmIvrText paramCrmIvrText, String paramString)
  {
    super(paramCrmIvrText, paramString);
  }
  
  public void onClick(View paramView)
  {
    if (CrmUtils.a.matcher(this.jdField_a_of_type_JavaLangString).find())
    {
      CrmIvrText.a(paramView, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.b, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText.CrmIvrLinkSpan
 * JD-Core Version:    0.7.0.1
 */