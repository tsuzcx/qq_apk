package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import cqz;
import cra;
import crb;

public class ShareAioResultDialog
  extends Dialog
{
  public static final int a = 0;
  public static final int b = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131558902);
    super.setContentView(2130903628);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297370));
    this.b = ((TextView)super.findViewById(2131297371));
    this.c = ((TextView)super.findViewById(2131297613));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131299003));
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    Resources localResources = getContext().getResources();
    this.b.setContentDescription(localResources.getString(2131365557, new Object[] { localResources.getString(2131363682) }));
    this.b.setOnClickListener(new cra(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    Resources localResources = getContext().getResources();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setContentDescription(localResources.getString(2131365557, new Object[] { str }));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new cqz(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b.setText(paramString);
    Resources localResources = getContext().getResources();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setContentDescription(localResources.getString(2131365557, new Object[] { str }));
    this.b.setOnClickListener(new crb(this, paramOnClickListener));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog
 * JD-Core Version:    0.7.0.1
 */