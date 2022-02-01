package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import kti;
import ktj;
import ktk;
import ktl;
import ktm;

public class QQCustomSplitDialog
  extends Dialog
{
  public DialogInterface.OnClickListener a;
  public LayoutInflater a;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new kti(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String[] a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  TextView d;
  
  public QQCustomSplitDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomSplitDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomSplitDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomSplitDialog a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    return this;
  }
  
  public QQCustomSplitDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = null;
    try
    {
      String[] arrayOfString = getContext().getResources().getStringArray(paramInt);
      localObject = arrayOfString;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        localNotFoundException.printStackTrace();
      }
    }
    return a(localObject, paramOnClickListener);
  }
  
  public QQCustomSplitDialog a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    return this;
  }
  
  public QQCustomSplitDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return this;
  }
  
  public QQCustomSplitDialog a(String paramString, int paramInt)
  {
    if ((findViewById(paramInt) instanceof TextView))
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    return this;
  }
  
  public QQCustomSplitDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new ktj(this, paramOnClickListener));
    return this;
  }
  
  public QQCustomSplitDialog a(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setDividerHeight(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    return this;
  }
  
  public QQCustomSplitDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new ktl(this, paramOnClickListener));
    return this;
  }
  
  public QQCustomSplitDialog b(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return this;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomSplitDialog b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ktk(this, paramOnClickListener));
    return this;
  }
  
  public QQCustomSplitDialog c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ktm(this, paramOnClickListener));
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297367));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296606));
    this.c = ((TextView)findViewById(2131297370));
    this.d = ((TextView)findViewById(2131297371));
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297368));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297206));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131297372));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297373));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSplitDialog
 * JD-Core Version:    0.7.0.1
 */