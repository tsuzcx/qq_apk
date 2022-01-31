package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public final class a
  extends BaseAdapter
{
  private LayoutInflater fhz;
  private String[] fkO;
  private Drawable fkP = null;
  private View.OnTouchListener fkQ = new a.1(this);
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    this.fkO = paramArrayOfString;
    this.fhz = LayoutInflater.from(paramContext);
    this.fkP = paramContext.getResources().getDrawable(q.e.signup_chose_line);
    this.fkP.setBounds(0, 0, this.fkP.getIntrinsicWidth(), this.fkP.getIntrinsicHeight());
  }
  
  private boolean kd(int paramInt)
  {
    return paramInt == this.fkO.length - 1;
  }
  
  public final int getCount()
  {
    return this.fkO.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.fkO[paramInt];
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.fhz.inflate(q.g.alias_item, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(q.f.alias_tv);
    paramViewGroup.setOnTouchListener(this.fkQ);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!kd(paramInt))) {
        break label102;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.fkO[paramInt]);
      return paramViewGroup;
      i = 0;
      break;
      label102:
      if (paramInt == 0) {}
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label152;
        }
        paramView.setPadding(25, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.fkP, null);
        break;
      }
      label152:
      if (kd(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.fkP, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */