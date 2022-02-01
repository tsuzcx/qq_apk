package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import ktf;
import ktg;

public class QQCustomSingleChoiceDialog
  extends QQCustomDialog
{
  public int a;
  public DialogInterface.OnClickListener a;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new ktg(this);
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new ktf(this);
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  public CharSequence[] a;
  
  public QQCustomSingleChoiceDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomSingleChoiceDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomSingleChoiceDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public QQCustomSingleChoiceDialog a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.text.setVisibility(8);
    this.bodyLayout.setVisibility(8);
    this.list.setVisibility(0);
    this.list.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.list.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.list.setDivider(new ColorDrawable(-4011827));
    this.list.setDividerHeight(1);
    this.jdField_a_of_type_ArrayOfJavaLangCharSequence = paramArrayOfCharSequence;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleChoiceDialog
 * JD-Core Version:    0.7.0.1
 */