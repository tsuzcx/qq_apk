package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import fft;
import ffu;
import java.util.Observable;
import java.util.Observer;

public class TroopAssistSetGuideActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static final String a = "troop_uin";
  public static final String b = "troop_name";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fft(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Button b;
  private String c;
  private String d;
  
  private void b()
  {
    setTitle(this.d);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302376));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    if (!TextUtils.isEmpty(this.c))
    {
      Drawable localDrawable = this.app.a(this.c);
      if (localDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302379));
    this.b = ((Button)findViewById(2131302378));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().addObserver(this);
    }
  }
  
  private void c()
  {
    TroopAssistantManager.a().a(this.app, this.c);
    setResult(0);
    finish();
  }
  
  private void d()
  {
    this.app.a(this.c, Integer.valueOf(2));
    TroopAssistantManager.a().a(this.app, this.c);
    setResult(-1);
    finish();
  }
  
  public void a()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label107;
        }
        if (i <= 99) {
          break label66;
        }
        this.leftView.setText(getString(2131366025) + "(99+)");
      }
    }
    return;
    label66:
    this.leftView.setText(getString(2131366025) + "(" + i + ")");
    return;
    label107:
    this.leftView.setText(getString(2131366025));
  }
  
  protected boolean onBackEvent()
  {
    c();
    return super.onBackEvent();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904505);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getStringExtra("troop_uin");
      this.d = paramBundle.getStringExtra("troop_name");
    }
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new ffu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistSetGuideActivity
 * JD-Core Version:    0.7.0.1
 */