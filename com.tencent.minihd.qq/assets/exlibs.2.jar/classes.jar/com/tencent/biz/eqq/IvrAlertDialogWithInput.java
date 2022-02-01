package com.tencent.biz.eqq;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cfl;
import cfm;
import cfn;
import cfo;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;

public class IvrAlertDialogWithInput
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "result";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new cfo(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String b;
  private String c;
  private int i;
  private int j;
  private int k = 0;
  
  private void a()
  {
    Object localObject = super.getIntent();
    this.k = ((Intent)localObject).getIntExtra("keyboardType", -1);
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((Intent)localObject).getSerializableExtra("inputPattern"));
    this.b = ((Intent)localObject).getStringExtra("ivrAlertTip");
    this.c = ((Intent)localObject).getStringExtra("ivrAlertBtText");
    this.i = ((Intent)localObject).getIntExtra("seq", -1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298398));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298402));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298400));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131298401));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298397));
    this.j = getResources().getColor(2131427329);
    this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-6710887);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    ((ImageButton)findViewById(2131298399)).setOnClickListener(new cfl(this));
    localObject = AnimationUtils.loadAnimation(this, 2130968671);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cfm(this, (Animation)localObject));
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new cfn(this));
    if (TextUtils.isEmpty(this.b)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.c)) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.c);
      }
      switch (this.k)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetEditText.setInputType(1);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(1);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(128);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(2);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(32);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(3);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(16);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(16);
    return;
    this.jdField_a_of_type_AndroidWidgetEditText.setInputType(4);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    super.setContentView(2130903466);
    a();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.IvrAlertDialogWithInput
 * JD-Core Version:    0.7.0.1
 */