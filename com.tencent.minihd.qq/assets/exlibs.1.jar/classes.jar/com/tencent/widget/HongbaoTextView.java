package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import lsc;
import lsd;

public class HongbaoTextView
  extends TextView
{
  public HongbaoTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongbaoTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HongbaoTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramCharSequence.equals("0"))) {}
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = getId();
          Log.i("app2", "name=" + paramContext.getClass().getSimpleName() + " viewId=" + i + "|" + 2131297707);
          if (i == 2131299182) {}
          for (boolean bool = true; (i == 2131297707) || (i == 2131299146) || (bool); bool = false)
          {
            Log.i("app2", "setText text=" + paramCharSequence + " context=" + getContext());
            post(new lsc(this, paramCharSequence, i, paramContext, bool));
            return;
          }
        } while ((i != 2131296606) || (!(paramContext instanceof ContextWrapper)));
        localObject = ((ContextWrapper)paramContext).getBaseContext();
      } while (!(localObject instanceof Activity));
      localObject = (Activity)localObject;
    } while ((!(localObject instanceof BasePluginActivity)) || (!((BasePluginActivity)localObject).getOutActivity().getIntent().getBooleanExtra("from_float_aio", false)));
    Object localObject = (View)getParent().getParent();
    ((View)localObject).setVisibility(8);
    post(new lsd(this, (View)localObject, paramCharSequence, paramContext));
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    a(getContext(), paramCharSequence);
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.HongbaoTextView
 * JD-Core Version:    0.7.0.1
 */