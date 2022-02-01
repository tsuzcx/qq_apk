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
import com.tencent.mm.hellhoundlib.b.b;

public final class a
  extends BaseAdapter
{
  private LayoutInflater jiz;
  private String[] jlH;
  private Drawable jlI;
  private View.OnTouchListener jlJ;
  private Context mContext;
  
  public a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127865);
    this.jlI = null;
    this.jlJ = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(127864);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/AliasAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ((TextView)paramAnonymousView.findViewById(2131296639)).setTextColor(a.a(a.this).getResources().getColor(2131100212));
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/AliasAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(127864);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          ((TextView)paramAnonymousView.findViewById(2131296639)).setTextColor(a.a(a.this).getResources().getColor(2131101182));
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/AliasAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(127864);
          return false;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/AliasAdapter$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(127864);
        return false;
      }
    };
    this.jlH = paramArrayOfString;
    this.mContext = paramContext;
    this.jiz = LayoutInflater.from(paramContext);
    this.jlI = paramContext.getResources().getDrawable(2131234063);
    this.jlI.setBounds(0, 0, this.jlI.getIntrinsicWidth(), this.jlI.getIntrinsicHeight());
    AppMethodBeat.o(127865);
  }
  
  private boolean rx(int paramInt)
  {
    return paramInt == this.jlH.length - 1;
  }
  
  public final int getCount()
  {
    return this.jlH.length;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.jlH[paramInt];
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
      paramViewGroup = this.jiz.inflate(2131492956, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131296639);
    paramViewGroup.setOnTouchListener(this.jlJ);
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if ((i == 0) || (!rx(paramInt))) {
        break label110;
      }
      paramView.setPadding(25, 0, 25, 10);
      paramView.setCompoundDrawablePadding(0);
      paramView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      paramView.setText(this.jlH[paramInt]);
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
        paramView.setCompoundDrawables(null, null, this.jlI, null);
        break;
      }
      label160:
      if (rx(paramInt))
      {
        paramView.setPadding(0, 0, 25, 10);
        paramView.setCompoundDrawablePadding(0);
        paramView.setCompoundDrawables(null, null, null, null);
      }
      else
      {
        paramView.setPadding(0, 0, 10, 10);
        paramView.setCompoundDrawablePadding(10);
        paramView.setCompoundDrawables(null, null, this.jlI, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */