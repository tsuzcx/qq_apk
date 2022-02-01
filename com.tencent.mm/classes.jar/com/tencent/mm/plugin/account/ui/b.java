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

public final class b
  extends BaseAdapter
{
  private LayoutInflater kgB;
  private String[] kjQ;
  private Drawable kjR;
  private View.OnTouchListener kjS;
  private Context mContext;
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.kjR = null;
    this.kjS = new b.1(this);
    this.kjQ = paramArrayOfString;
    this.mContext = paramContext;
    this.kgB = LayoutInflater.from(paramContext);
    this.kjR = paramContext.getResources().getDrawable(2131234905);
    this.kjR.setBounds(0, 0, this.kjR.getIntrinsicWidth(), this.kjR.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean vn(int paramInt)
  {
    return paramInt == this.kjQ.length - 1;
  }
  
  public final int getCount()
  {
    return this.kjQ.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.kjQ[paramInt];
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
      paramViewGroup = this.kgB.inflate(2131492989, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131296716);
    paramViewGroup.setOnTouchListener(this.kjS);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!vn(paramInt))) {
        break label110;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.kjQ[paramInt]);
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
        paramView.setCompoundDrawables(null, null, this.kjR, null);
        break;
      }
      label160:
      if (vn(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.kjR, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */