package com.tencent.mobileqq.nearpeople;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class TurnBrandPopupView
  extends FrameLayout
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 20;
  private static final String jdField_a_of_type_JavaLangString = "TurnBrandPopupView";
  private static final int jdField_b_of_type_Int = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TurnBrandPopupView.PopupCallback jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView$PopupCallback;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public TurnBrandPopupView(Context paramContext, TurnBrandPopupView.PopupCallback paramPopupCallback)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView$PopupCallback = paramPopupCallback;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((TurnBrandActivity)this.jdField_a_of_type_AndroidContentContext).app;
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903974, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300319));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300316));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300318));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300315));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300317));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300321));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300320));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131369579, new Object[] { this.jdField_b_of_type_JavaLangString }));
    paramContext = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (paramContext != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369581);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131369582);
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(20.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    int i = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramContext = Bitmap.createBitmap(i + 40, i + 40, Bitmap.Config.ARGB_8888);
    new Canvas(paramContext).drawCircle(i / 2 + 20, i / 2 + 20, i / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramContext);
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandPopupView", 2, "getUrl: " + this.e);
    }
    return this.e;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandPopupView", 2, "updateHeadImage: " + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if (j < k) {}
    for (int i = j;; i = k)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a(paramBitmap, i, j, k));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.e = paramString4;
    paramString2 = this.jdField_b_of_type_JavaLangString;
    paramString1 = paramString2;
    if (paramString2.length() > 16) {
      paramString1 = paramString2.substring(0, 16) + "...";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131369579, new Object[] { paramString1 }));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300321: 
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandPopupView", 2, "user clicked to next brand!");
      }
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView$PopupCallback.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandPopupView", 2, "user clicked go to talk!");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandPopupView$PopupCallback.b(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandPopupView
 * JD-Core Version:    0.7.0.1
 */