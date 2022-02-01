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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class a
  extends ArrayAdapter<a.b>
  implements g
{
  private final LayoutInflater mInflater;
  private b nhb;
  h nhc;
  private boolean nhd;
  
  a(Context paramContext, List<a.b> paramList)
  {
    super(paramContext, 2131493005, paramList);
    AppMethodBeat.i(136615);
    this.nhd = false;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(136615);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(136617);
    this.nhb = paramb;
    this.nhb.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(136612);
        if ((a.a(a.this) != null) && (!a.b(a.this))) {
          a.a(a.this).a("", h.a.nhN);
        }
        AppMethodBeat.o(136612);
      }
    });
    AppMethodBeat.o(136617);
  }
  
  public final void bET()
  {
    AppMethodBeat.i(136618);
    this.nhb.setOnDismissListener(null);
    this.nhb = null;
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
      paramView.nhi = paramViewGroup;
      paramView.nhf.setText(paramViewGroup.title);
      paramView.nhg.setText(paramViewGroup.content);
      TextView localTextView = paramView.nhg;
      int i;
      if (bt.isNullOrNil(paramViewGroup.content))
      {
        i = 8;
        localTextView.setVisibility(i);
        paramView = paramView.iVT;
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
    View auu;
    View iVT;
    TextView nhf;
    TextView nhg;
    View nhh;
    a.b nhi;
    
    a(View paramView)
    {
      AppMethodBeat.i(136613);
      this.auu = paramView;
      this.nhf = ((TextView)paramView.findViewById(2131305902));
      this.nhg = ((TextView)paramView.findViewById(2131298739));
      this.nhh = paramView.findViewById(2131298360);
      this.iVT = paramView.findViewById(2131299154);
      paramView.setBackgroundResource(2131233634);
      paramView.setOnClickListener(this);
      this.nhh.setOnClickListener(this);
      AppMethodBeat.o(136613);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(136614);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (this.nhi != null)
      {
        if (paramView.getId() != 2131298360) {
          break label111;
        }
        a.this.remove(this.nhi);
        if (a.a(a.this) != null) {
          a.a(a.this).a(this.nhi.id, h.a.nhO);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(136614);
        return;
        label111:
        if ((paramView == this.auu) && (a.a(a.this) != null))
        {
          if (this.nhi != null) {
            a.a(a.this).a(this.nhi.id, h.a.nhP);
          }
          a.c(a.this);
          if (a.d(a.this) != null) {
            a.d(a.this).nhj.getView().clearFocus();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a
 * JD-Core Version:    0.7.0.1
 */