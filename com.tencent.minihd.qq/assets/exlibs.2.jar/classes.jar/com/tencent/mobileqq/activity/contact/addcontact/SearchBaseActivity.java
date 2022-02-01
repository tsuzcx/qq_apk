package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import ggg;
import ggh;
import ggi;
import ggj;
import ggk;
import java.util.regex.Pattern;

public class SearchBaseActivity
  extends FragmentActivity
{
  public static final String a = "from_key";
  public static final Pattern a;
  public static final int b = 0;
  public static final String b = "last_key_words";
  public static final Pattern b;
  public static final int c = 1;
  public static final Pattern c;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public final int a;
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  public EditText a;
  public ImageButton a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SearchBaseFragment a;
  protected boolean a;
  View b;
  protected String c;
  protected int g;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
    jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("^1[0-9]{2}\\d{8}$");
  }
  
  public SearchBaseActivity()
  {
    this.jdField_a_of_type_Int = 64;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected SearchBaseFragment a()
  {
    return new SearchBaseFragment();
  }
  
  protected void a()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("from_key"))
    {
      this.g = localIntent.getIntExtra("from_key", 0);
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("last_key_words");
    }
    if (localIntent.hasExtra("from_activity")) {
      this.jdField_a_of_type_Boolean = localIntent.getStringExtra("from_activity").equals(AddContactsActivity.class.getName());
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298255);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297347);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299461));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131427938));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ggh(this));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getText());
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299473));
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(getResources().getString(2131366950));
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, getResources().getDimension(2131492933));
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new ggi(this));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131299465));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ggj(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ggk(this));
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904005);
    super.getWindow().setBackgroundDrawable(null);
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment = a();
    paramBundle = new Bundle();
    paramBundle.putInt("from_key", this.g);
    paramBundle.putString("last_key_words", this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.setArguments(paramBundle);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(new ggg(this));
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131297408, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment);
    paramBundle.commit();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ViewFactory.a().a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    setContentBackgroundResource(2130837687);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */