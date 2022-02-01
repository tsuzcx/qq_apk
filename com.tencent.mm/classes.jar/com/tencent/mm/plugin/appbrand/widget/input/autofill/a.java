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
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.luggage.wxa.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class a
  extends ArrayAdapter<a.b>
  implements g
{
  private final LayoutInflater mInflater;
  private b uJN;
  h uJO;
  private boolean uJP;
  
  a(Context paramContext, List<a.b> paramList)
  {
    super(paramContext, a.f.app_brand_input_autofill_item, paramList);
    AppMethodBeat.i(136615);
    this.uJP = false;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(136615);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(136617);
    this.uJN = paramb;
    this.uJN.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(136612);
        if ((a.a(a.this) != null) && (!a.b(a.this))) {
          a.a(a.this).a("", h.a.uKz);
        }
        AppMethodBeat.o(136612);
      }
    });
    AppMethodBeat.o(136617);
  }
  
  public final void cRW()
  {
    AppMethodBeat.i(136618);
    this.uJN.setOnDismissListener(null);
    this.uJN = null;
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
      localView = this.mInflater.inflate(a.f.app_brand_input_autofill_item, paramViewGroup, false);
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
      paramView.uJU = paramViewGroup;
      paramView.uJR.setText(paramViewGroup.title);
      paramView.uJS.setText(paramViewGroup.content);
      TextView localTextView = paramView.uJS;
      int i;
      if (Util.isNullOrNil(paramViewGroup.content))
      {
        i = 8;
        localTextView.setVisibility(i);
        paramView = paramView.pKl;
        if (paramInt != getCount() - 1) {
          break label160;
        }
      }
      label160:
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
    View caK;
    View pKl;
    TextView uJR;
    TextView uJS;
    View uJT;
    a.b uJU;
    
    a(View paramView)
    {
      AppMethodBeat.i(136613);
      this.caK = paramView;
      this.uJR = ((TextView)paramView.findViewById(a.e.title));
      this.uJS = ((TextView)paramView.findViewById(a.e.content));
      this.uJT = paramView.findViewById(a.e.close);
      this.pKl = paramView.findViewById(a.e.divider);
      paramView.setBackgroundResource(a.d.popup_menu_selector);
      paramView.setOnClickListener(this);
      this.uJT.setOnClickListener(this);
      AppMethodBeat.o(136613);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(136614);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (this.uJU != null)
      {
        if (paramView.getId() != a.e.close) {
          break label112;
        }
        a.this.remove(this.uJU);
        if (a.a(a.this) != null) {
          a.a(a.this).a(this.uJU.id, h.a.uKA);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(136614);
        return;
        label112:
        if ((paramView == this.caK) && (a.a(a.this) != null))
        {
          if (this.uJU != null) {
            a.a(a.this).a(this.uJU.id, h.a.uKB);
          }
          a.c(a.this);
          if (a.d(a.this) != null) {
            a.d(a.this).uJV.getView().clearFocus();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a
 * JD-Core Version:    0.7.0.1
 */