package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends BaseAdapter
{
  private LayoutInflater imq;
  private Drawable ipA;
  private View.OnTouchListener ipB;
  private String[] ipz;
  private Context mContext;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.ipA = null;
    this.ipB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(127864);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ((TextView)paramAnonymousView.findViewById(2131296639)).setTextColor(a.a(a.this).getResources().getColor(2131100212));
          AppMethodBeat.o(127864);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          ((TextView)paramAnonymousView.findViewById(2131296639)).setTextColor(a.a(a.this).getResources().getColor(2131101182));
          AppMethodBeat.o(127864);
          return false;
        }
        AppMethodBeat.o(127864);
        return false;
      }
    };
    this.ipz = paramArrayOfString;
    this.mContext = paramContext;
    this.imq = LayoutInflater.from(paramContext);
    this.ipA = paramContext.getResources().getDrawable(2131234063);
    this.ipA.setBounds(0, 0, this.ipA.getIntrinsicWidth(), this.ipA.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean qh(int paramInt)
  {
    return paramInt == this.ipz.length - 1;
  }
  
  public final int getCount()
  {
    return this.ipz.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.ipz[paramInt];
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    AppMethodBeat.i(127866);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.imq.inflate(2131492956, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131296639);
    paramViewGroup.setOnTouchListener(this.ipB);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!qh(paramInt))) {
        break label110;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.ipz[paramInt]);
      AppMethodBeat.o(127866);
      return paramViewGroup;
      i = 0;
      break;
      label110:
      if (paramInt == 0) {}
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label160;
        }
        paramView.setPadding(25, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.ipA, null);
        break;
      }
      label160:
      if (qh(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.ipA, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */