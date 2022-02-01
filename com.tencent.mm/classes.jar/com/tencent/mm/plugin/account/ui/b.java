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

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater pUI;
  private String[] pYN;
  private Drawable pYO;
  private View.OnTouchListener pYP;
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.pYO = null;
    this.pYP = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(127864);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ((TextView)paramAnonymousView.findViewById(r.f.alias_tv)).setTextColor(b.a(b.this).getResources().getColor(r.c.desc_text_color));
          AppMethodBeat.o(127864);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          ((TextView)paramAnonymousView.findViewById(r.f.alias_tv)).setTextColor(b.a(b.this).getResources().getColor(r.c.white_text_color));
          AppMethodBeat.o(127864);
          return false;
        }
        AppMethodBeat.o(127864);
        return false;
      }
    };
    this.pYN = paramArrayOfString;
    this.mContext = paramContext;
    this.pUI = LayoutInflater.from(paramContext);
    this.pYO = paramContext.getResources().getDrawable(r.e.signup_chose_line);
    this.pYO.setBounds(0, 0, this.pYO.getIntrinsicWidth(), this.pYO.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean yx(int paramInt)
  {
    return paramInt == this.pYN.length - 1;
  }
  
  public final int getCount()
  {
    return this.pYN.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.pYN[paramInt];
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
      paramViewGroup = this.pUI.inflate(r.g.alias_item, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(r.f.alias_tv);
    paramViewGroup.setOnTouchListener(this.pYP);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!yx(paramInt))) {
        break label112;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.pYN[paramInt]);
      AppMethodBeat.o(127866);
      return paramViewGroup;
      i = 0;
      break;
      label112:
      if (paramInt == 0) {}
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label162;
        }
        paramView.setPadding(25, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.pYO, null);
        break;
      }
      label162:
      if (yx(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.pYO, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */