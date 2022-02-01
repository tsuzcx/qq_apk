package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import ibx;
import iby;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatingOthersActivity
  extends DatingBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new iby(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ibx(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private final String jdField_a_of_type_JavaLangString = "DatingOthersActivity";
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  
  private void a()
  {
    setTitle(2131369688);
    setLeftButton(2131365736, null);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131367064);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300036));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300038));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300039);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)this.app.getManager(67));
    this.jdField_a_of_type_Int = getIntent().getExtras().getInt("curTheme");
    this.jdField_b_of_type_Int = getIntent().getExtras().getInt("item_id", 0);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DatingConfigItem localDatingConfigItem = (DatingConfigItem)localIterator.next();
      this.jdField_b_of_type_JavaUtilList.add(localDatingConfigItem.contentStr);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == -1)
      {
        getWindow().setSoftInputMode(4);
        a(true);
      }
      b();
      this.rightViewText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      if (QLog.isColorLevel()) {
        QLog.d("DatingOthersActivity", 2, "othersETCache = " + this.jdField_b_of_type_JavaLangString + ",curSelectItem = " + this.jdField_b_of_type_Int);
      }
      this.rightViewText.setContentDescription("完成");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("编辑说明文本框连按两次编辑");
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("文本框正在编辑");
      return;
      if (this.jdField_a_of_type_Int == 5) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131369939);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        b(false);
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
        if (this.jdField_b_of_type_Int != -1)
        {
          ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_b_of_type_Int).findViewById(2131300034)).setVisibility(8);
          this.jdField_b_of_type_Int = -1;
        }
      }
    }
    while (!this.jdField_a_of_type_AndroidWidgetEditText.isEnabled()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_b_of_type_JavaLangString.length());
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    LayoutInflater localLayoutInflater = getLayoutInflater();
    int i = 0;
    label22:
    View localView;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localView = localLayoutInflater.inflate(2130903906, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      ((TextView)localView.findViewById(2131300035)).setText((CharSequence)this.jdField_b_of_type_JavaUtilList.get(i));
      if (this.jdField_b_of_type_Int == i) {
        ((ImageView)localView.findViewById(2131300034)).setVisibility(0);
      }
      if (i == this.jdField_a_of_type_JavaUtilList.size() - 1) {
        localView.setBackgroundResource(2130838153);
      }
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setTag(Integer.valueOf(i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      if (this.jdField_b_of_type_Int != i) {
        break label193;
      }
      localView.setContentDescription((String)this.jdField_b_of_type_JavaUtilList.get(i) + "已选择");
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label193:
      localView.setContentDescription((String)this.jdField_b_of_type_JavaUtilList.get(i) + "连按两次选中");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903907);
    a();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297360: 
      paramView = new Intent();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (this.jdField_b_of_type_Int != -1)
      {
        paramView.putExtra("others", (String)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
        paramView.putExtra("item_id", this.jdField_b_of_type_Int);
        paramView.putExtra("item_key", String.valueOf(((DatingConfigItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).id));
        setResult(-1, paramView);
      }
      for (;;)
      {
        finish();
        return;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)this.app.getManager(67));
          }
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString);
          paramView.putExtra("others", this.jdField_b_of_type_JavaLangString);
          paramView.putExtra("item_id", this.jdField_b_of_type_Int);
          int[] arrayOfInt = getResources().getIntArray(2131230771);
          if (arrayOfInt != null) {
            paramView.putExtra("item_key", String.valueOf(arrayOfInt[(this.jdField_a_of_type_Int - 1)]));
          }
          setResult(-1, paramView);
        }
      }
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingOthersActivity
 * JD-Core Version:    0.7.0.1
 */