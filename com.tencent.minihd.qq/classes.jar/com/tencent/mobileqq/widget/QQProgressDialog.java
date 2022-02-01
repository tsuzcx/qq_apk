package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.CircleProgressView;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.ProgressWheel;
import kyo;

public class QQProgressDialog
  extends Dialog
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiCircleProgressView;
  private ProgressWheel jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel;
  private QQProgressDialog.Callback jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback;
  
  public QQProgressDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QQProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, 2131558903);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904003, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel = ((ProgressWheel)this.jdField_a_of_type_AndroidViewView.findViewById(2131300432));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297007));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(QQProgressDialog.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback = paramCallback;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void d(boolean paramBoolean)
  {
    setOnKeyListener(new kyo(this, paramBoolean));
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 121	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: getfield 71	com/tencent/mobileqq/widget/QQProgressDialog:jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel	Lcom/tencent/mobileqq/activity/widget/qqmusic/ui/ProgressWheel;
    //   8: invokevirtual 89	com/tencent/mobileqq/activity/widget/qqmusic/ui/ProgressWheel:b	()V
    //   11: aload_0
    //   12: getfield 71	com/tencent/mobileqq/widget/QQProgressDialog:jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel	Lcom/tencent/mobileqq/activity/widget/qqmusic/ui/ProgressWheel;
    //   15: bipush 8
    //   17: invokevirtual 82	com/tencent/mobileqq/activity/widget/qqmusic/ui/ProgressWheel:setVisibility	(I)V
    //   20: aload_0
    //   21: getfield 76	com/tencent/mobileqq/widget/QQProgressDialog:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   24: invokevirtual 102	android/widget/TextView:getVisibility	()I
    //   27: bipush 8
    //   29: if_icmpeq +12 -> 41
    //   32: aload_0
    //   33: getfield 76	com/tencent/mobileqq/widget/QQProgressDialog:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   36: bipush 8
    //   38: invokevirtual 103	android/widget/TextView:setVisibility	(I)V
    //   41: aload_0
    //   42: invokestatic 126	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 126	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: invokestatic 126	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	QQProgressDialog
    //   46	1	1	localException	java.lang.Exception
    //   52	6	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	41	46	java/lang/Exception
    //   0	41	52	finally
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog$Callback.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.gravity = 17;
    localLayoutParams.y += this.jdField_a_of_type_Int;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressDialog
 * JD-Core Version:    0.7.0.1
 */