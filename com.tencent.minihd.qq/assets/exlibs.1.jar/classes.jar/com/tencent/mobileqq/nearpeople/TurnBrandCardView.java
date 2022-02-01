package com.tencent.mobileqq.nearpeople;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TurnBrandCardView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public TurnBrandCardView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903972, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300303));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300304);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300305));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300306));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840434);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131369580);
    if (paramInt >= 0) {}
    for (;;)
    {
      paramString1 = String.format(paramString1, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
      return;
      paramInt = 0;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.c;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    i = View.MeasureSpec.makeMeasureSpec(paramInt1 * 6 / 7, 1073741824);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1 / 7, 1073741824);
    this.jdField_a_of_type_AndroidWidgetImageView.measure(paramInt2, i);
    this.jdField_a_of_type_AndroidViewView.measure(paramInt2, paramInt1);
  }
  
  public void setInfoAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor((paramInt & 0xFF) + (paramInt << 8 & 0xFF00) + (paramInt << 16 & 0xFF0000) - 16777216);
  }
  
  public void setInitAlpha(int paramInt)
  {
    this.c = paramInt;
    setInfoAlpha(this.c);
  }
  
  public void setInitLeftAndTop(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandCardView
 * JD-Core Version:    0.7.0.1
 */