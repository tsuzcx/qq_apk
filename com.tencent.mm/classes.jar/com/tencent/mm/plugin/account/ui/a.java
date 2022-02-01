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
  private LayoutInflater jfG;
  private String[] jiO;
  private Drawable jiP;
  private View.OnTouchListener jiQ;
  private Context mContext;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.jiP = null;
    this.jiQ = new a.1(this);
    this.jiO = paramArrayOfString;
    this.mContext = paramContext;
    this.jfG = LayoutInflater.from(paramContext);
    this.jiP = paramContext.getResources().getDrawable(2131234063);
    this.jiP.setBounds(0, 0, this.jiP.getIntrinsicWidth(), this.jiP.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean ru(int paramInt)
  {
    return paramInt == this.jiO.length - 1;
  }
  
  public final int getCount()
  {
    return this.jiO.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.jiO[paramInt];
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
      paramViewGroup = this.jfG.inflate(2131492956, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131296639);
    paramViewGroup.setOnTouchListener(this.jiQ);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!ru(paramInt))) {
        break label110;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.jiO[paramInt]);
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
        paramView.setCompoundDrawables(null, null, this.jiP, null);
        break;
      }
      label160:
      if (ru(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.jiP, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */