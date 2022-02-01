package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class HongbaoProgressLayout
  extends LinearLayout
{
  boolean a = false;
  
  public HongbaoProgressLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HongbaoProgressLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
      if ((paramContext instanceof Activity)) {
        this.a = ((Activity)paramContext).getIntent().getBooleanExtra("from_float_aio", false);
      }
    }
    if (this.a) {
      setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.HongbaoProgressLayout
 * JD-Core Version:    0.7.0.1
 */