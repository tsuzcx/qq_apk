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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends BaseAdapter
{
  private LayoutInflater exe;
  private String[] gCf;
  private Drawable gCg;
  private View.OnTouchListener gCh;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(124713);
    this.gCg = null;
    this.gCh = new a.1(this);
    this.gCf = paramArrayOfString;
    this.exe = LayoutInflater.from(paramContext);
    this.gCg = paramContext.getResources().getDrawable(2130840350);
    this.gCg.setBounds(0, 0, this.gCg.getIntrinsicWidth(), this.gCg.getIntrinsicHeight());
    AppMethodBeat.o(124713);
  }
  
  private boolean mY(int paramInt)
  {
    return paramInt == this.gCf.length - 1;
  }
  
  public final int getCount()
  {
    return this.gCf.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.gCf[paramInt];
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    AppMethodBeat.i(124714);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.exe.inflate(2130968647, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131821117);
    paramViewGroup.setOnTouchListener(this.gCh);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!mY(paramInt))) {
        break label110;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.gCf[paramInt]);
      AppMethodBeat.o(124714);
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
        paramView.setCompoundDrawables(null, null, this.gCg, null);
        break;
      }
      label160:
      if (mY(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.gCg, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */