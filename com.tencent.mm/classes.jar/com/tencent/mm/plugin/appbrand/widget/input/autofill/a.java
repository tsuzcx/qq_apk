package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

final class a
  extends ArrayAdapter<a.b>
  implements g
{
  private b mGD;
  h mGE;
  private boolean mGF;
  private final LayoutInflater mInflater;
  
  a(Context paramContext, List<a.b> paramList)
  {
    super(paramContext, 2131493005, paramList);
    AppMethodBeat.i(136615);
    this.mGF = false;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(136615);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(136617);
    this.mGD = paramb;
    this.mGD.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(136612);
        if ((a.a(a.this) != null) && (!a.b(a.this))) {
          a.a(a.this).a("", h.a.mHp);
        }
        AppMethodBeat.o(136612);
      }
    });
    AppMethodBeat.o(136617);
  }
  
  public final void bAR()
  {
    AppMethodBeat.i(136618);
    this.mGD.setOnDismissListener(null);
    this.mGD = null;
    AppMethodBeat.o(136618);
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(136620);
    Filter localFilter = super.getFilter();
    AppMethodBeat.o(136620);
    return localFilter;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 8;
    AppMethodBeat.i(136619);
    View localView = paramView;
    if (paramView == null) {
      localView = this.mInflater.inflate(2131493005, paramViewGroup, false);
    }
    paramView = (a)localView.getTag();
    if (paramView == null)
    {
      paramView = new a(localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramViewGroup = (a.b)getItem(paramInt);
      paramView.mGK = paramViewGroup;
      paramView.mGH.setText(paramViewGroup.title);
      paramView.mGI.setText(paramViewGroup.content);
      TextView localTextView = paramView.mGI;
      int i;
      if (bs.isNullOrNil(paramViewGroup.content))
      {
        i = 8;
        localTextView.setVisibility(i);
        paramView = paramView.iCJ;
        if (paramInt != getCount() - 1) {
          break label159;
        }
      }
      label159:
      for (paramInt = j;; paramInt = 0)
      {
        paramView.setVisibility(paramInt);
        AppMethodBeat.o(136619);
        return localView;
        i = 0;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(136616);
    super.notifyDataSetChanged();
    AppMethodBeat.o(136616);
  }
  
  final class a
    implements View.OnClickListener
  {
    View asD;
    View iCJ;
    TextView mGH;
    TextView mGI;
    View mGJ;
    a.b mGK;
    
    a(View paramView)
    {
      AppMethodBeat.i(136613);
      this.asD = paramView;
      this.mGH = ((TextView)paramView.findViewById(2131305902));
      this.mGI = ((TextView)paramView.findViewById(2131298739));
      this.mGJ = paramView.findViewById(2131298360);
      this.iCJ = paramView.findViewById(2131299154);
      paramView.setBackgroundResource(2131233634);
      paramView.setOnClickListener(this);
      this.mGJ.setOnClickListener(this);
      AppMethodBeat.o(136613);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(136614);
      if (this.mGK != null) {
        if (paramView.getId() == 2131298360)
        {
          a.this.remove(this.mGK);
          if (a.a(a.this) != null)
          {
            a.a(a.this).a(this.mGK.id, h.a.mHq);
            AppMethodBeat.o(136614);
          }
        }
        else if ((paramView == this.asD) && (a.a(a.this) != null))
        {
          if (this.mGK != null) {
            a.a(a.this).a(this.mGK.id, h.a.mHr);
          }
          a.c(a.this);
          if (a.d(a.this) != null) {
            a.d(a.this).mGL.getView().clearFocus();
          }
        }
      }
      AppMethodBeat.o(136614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a
 * JD-Core Version:    0.7.0.1
 */