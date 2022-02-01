package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import dwm;
import dwn;
import dwo;
import dwp;
import dwq;
import java.io.UnsupportedEncodingException;

public class EditActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback
{
  public static final int a = 210;
  public static final String a = "editType";
  public static final int b = 150;
  public static final String b = "key_hide_clear_btn";
  public static final int c = 96;
  public static final String c = "key_null_bg";
  public static final int d = 210;
  public static final String d = "key_simple_count_style";
  public static final int e = 48;
  public static final String e = "leftBtn_type";
  public static final int f = 24;
  public static final String f = "leftBtn_text";
  public static final int g = 30;
  public static final String g = "rightBtn_show";
  public static final int h = 900;
  public static final String h = "rightBtn_text";
  public static final int i = 150;
  public static final String i = "support_emotion";
  public static final int j = -1;
  public static final String j = "key_title_style";
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 100;
  public static final int r = 101;
  public static final int s = 0;
  public static final int t = 1;
  float jdField_a_of_type_Float = 1.5F;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new dwq(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  public ClearableEditText a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  private String k;
  public int u;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297780));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new dwm(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297782));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(new dwn(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297779));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setEditableFactory(QQTextBuilder.a);
    if (getIntent().getBooleanExtra("key_null_bg", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setBackgroundResource(2130838151);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding((int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 10.0F), (int)DisplayUtils.a(this, 30.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
    if (getIntent().getBooleanExtra("key_hide_clear_btn", false)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonStyle(1);
    }
    setTitle(this.v);
    ViewGroup.LayoutParams localLayoutParams;
    int i1;
    if (getIntent().getIntExtra("key_title_style", 0) == 0)
    {
      setRightHighlightButton(2131367064, new dwo(this));
      enableRightHighlight(true);
      localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getLayoutParams();
      if (this.b) {
        break label309;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.k);
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i1, i1);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(74.0F * this.jdField_a_of_type_Float));
      }
    }
    for (;;)
    {
      if (localLayoutParams != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams(localLayoutParams);
      }
      new Handler().postDelayed(new dwp(this), 500L);
      return;
      if (getIntent().getIntExtra("key_title_style", 0) != 1) {
        break;
      }
      this.leftView.setText(2131365114);
      break;
      label309:
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.k);
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i1, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(150.0F * this.jdField_a_of_type_Float));
      }
    }
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void d() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.x = paramBundle.getIntExtra("support_emotion", 0);
    setContentView(2130903338);
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131297778));
    if (this.x == 1) {
      h();
    }
    this.v = paramBundle.getIntExtra("title", 0);
    this.w = paramBundle.getIntExtra("limit", 0);
    this.b = paramBundle.getBooleanExtra("multiLine", false);
    this.u = paramBundle.getIntExtra("action", 0);
    this.c = paramBundle.getBooleanExtra("canPostNull", true);
    this.k = paramBundle.getStringExtra("current");
    if (this.k == null) {
      this.k = "";
    }
    i();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    super.doOnDestroy();
  }
  
  public void e()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
  }
  
  public void f()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void g()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (!android.text.TextUtils.isEmpty(str))
    {
      Object localObject1 = new byte[0];
      try
      {
        localObject2 = str.getBytes("utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          ColorStateList localColorStateList = getResources().getColorStateList(2131427975);
          continue;
          localObject1 = String.valueOf((this.w - i1) / 3);
          continue;
          if (i1 > this.w) {
            localObject1 = getString(2131367303) + "！ " + i1 + "/" + this.w;
          } else {
            localObject1 = i1 + "/" + this.w;
          }
        }
        if ((i1 > 0) && (i1 <= this.w))
        {
          enableRightHighlight(true);
          return;
        }
        if ((i1 == 0) && (this.c))
        {
          enableRightHighlight(true);
          return;
        }
        enableRightHighlight(false);
        return;
      }
    }
    for (int i1 = localObject1.length;; i1 = 0) {
      if (i1 > this.w)
      {
        localObject2 = getResources().getColorStateList(2131427999);
        if (!getIntent().getBooleanExtra("key_simple_count_style", false)) {
          continue;
        }
        if (i1 <= this.w) {
          continue;
        }
        localObject1 = String.valueOf((this.w - i1 - 2) / 3);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        if ((this.u != 101) || (!android.text.TextUtils.isEmpty(str.trim()))) {
          continue;
        }
        enableRightHighlight(false);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (getIntent().getIntExtra("key_title_style", 0) == 1)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (android.text.TextUtils.isEmpty(str)) {
        break label126;
      }
      Object localObject = new byte[0];
      try
      {
        byte[] arrayOfByte = str.getBytes("utf-8");
        localObject = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        f();
        localObject = getIntent();
        ((Intent)localObject).putExtra("result", str);
        setResult(-1, (Intent)localObject);
        finish();
        return true;
      }
    }
    label126:
    for (int i1 = localObject.length;; i1 = 0)
    {
      if (i1 > this.w)
      {
        QQToast.a(this, 2131366078, 0).b(getTitleBarHeight());
        return true;
      }
      f();
      return super.onBackEvent();
    }
  }
  
  protected void onPause()
  {
    f();
    super.onPause();
  }
  
  protected void onResume()
  {
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */