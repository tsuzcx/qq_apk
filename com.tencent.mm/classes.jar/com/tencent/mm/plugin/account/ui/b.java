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
  private LayoutInflater mYa;
  private String[] nbG;
  private Drawable nbH;
  private View.OnTouchListener nbI;
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.nbH = null;
    this.nbI = new View.OnTouchListener()
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
    this.nbG = paramArrayOfString;
    this.mContext = paramContext;
    this.mYa = LayoutInflater.from(paramContext);
    this.nbH = paramContext.getResources().getDrawable(r.e.signup_chose_line);
    this.nbH.setBounds(0, 0, this.nbH.getIntrinsicWidth(), this.nbH.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean yr(int paramInt)
  {
    return paramInt == this.nbG.length - 1;
  }
  
  public final int getCount()
  {
    return this.nbG.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.nbG[paramInt];
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
      paramViewGroup = this.mYa.inflate(r.g.alias_item, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(r.f.alias_tv);
    paramViewGroup.setOnTouchListener(this.nbI);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!yr(paramInt))) {
        break label112;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.nbG[paramInt]);
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
        paramView.setCompoundDrawables(null, null, this.nbH, null);
        break;
      }
      label162:
      if (yr(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.nbH, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */