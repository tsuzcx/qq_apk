package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.util.SizeMeasure;
import gmp;

public class FloatMsgBar
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public FloatAioController.MsgBarInfo a;
  private QQMessageFacade.Message jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  private View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  private View d;
  
  public FloatMsgBar(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    SizeMeasure.b(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo = new FloatAioController.MsgBarInfo();
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903324, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297714);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297715));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297716));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297718));
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131296532);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131297717);
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public FloatAioController.MsgBarInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo;
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidViewView.performClick();
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = paramMessage;
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, Bitmap paramBitmap)
  {
    SizeMeasure.b(this.jdField_a_of_type_AndroidContentContext);
    int i = this.c.getPaddingLeft();
    int j = this.c.getPaddingRight();
    int k = this.c.getPaddingTop();
    int m = this.c.getPaddingBottom();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.hbMsg.a))
    {
      this.c.setBackgroundResource(2130838380);
      this.d.setBackgroundResource(2130838381);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427399));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131427399));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    for (;;)
    {
      this.c.setPadding(i, k, j, m);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence2);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo.c = paramCharSequence1;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo.d = paramCharSequence2;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController$MsgBarInfo.a = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      return;
      this.c.setBackgroundResource(2130838367);
      this.d.setBackgroundResource(2130838371);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(17170444));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(17170444));
      if (paramBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838406);
      }
    }
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131296532);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131297717);
    localView.setVisibility(4);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(1.5F);
    int i = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493515);
    localObject = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { i, 0.0F });
    ((ObjectAnimator)localObject).setDuration(150L);
    ((ObjectAnimator)localObject).setInterpolator(localDecelerateInterpolator);
    ((ObjectAnimator)localObject).addUpdateListener(new gmp(this, i, localView, localDecelerateInterpolator));
    ((ObjectAnimator)localObject).start();
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatMsgBar
 * JD-Core Version:    0.7.0.1
 */