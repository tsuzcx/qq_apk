package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Looper;
import android.os.MessageQueue;
import android.widget.EditText;
import android.widget.TextView;
import ggp;
import ggq;

public class SearchContactsActivity
  extends SearchBaseActivity
{
  protected SearchBaseFragment a()
  {
    return new SearchContactsFragment();
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ggp(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群、生活服务、正在编辑");
      Looper.myQueue().addIdleHandler(new ggq(this));
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */