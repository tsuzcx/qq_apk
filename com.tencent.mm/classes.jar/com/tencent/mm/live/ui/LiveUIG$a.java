package com.tencent.mm.live.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
public final class LiveUIG$a
  extends BaseAdapter
{
  public final int getCount()
  {
    AppMethodBeat.i(203298);
    int i = LiveUIG.b(this.KyR).size();
    AppMethodBeat.o(203298);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(203299);
    Object localObject = LiveUIG.b(this.KyR).get(paramInt);
    k.g(localObject, "selectsList[position]");
    AppMethodBeat.o(203299);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @SuppressLint({"SetTextI18n"})
  public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203300);
    k.h(paramViewGroup, "parent");
    paramView = new TextView((Context)this.KyR);
    paramViewGroup = getItem(paramInt);
    if (paramViewGroup == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
      AppMethodBeat.o(203300);
      throw paramView;
    }
    paramViewGroup = (LiveUIG.d)paramViewGroup;
    paramView.setTag(paramViewGroup);
    paramView.setText((CharSequence)(paramViewGroup.aaO() + "->:" + paramViewGroup.value()));
    paramView.setGravity(17);
    paramView.setTextSize(1, 20.0F);
    paramView.setHeight(a.fromDPToPix(aj.getContext(), 50));
    if (paramInt % 2 == 1) {
      paramView.setBackgroundColor(Color.parseColor("#e2efda"));
    }
    paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
    paramView = (View)paramView;
    AppMethodBeat.o(203300);
    return paramView;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(LiveUIG.d paramd, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203297);
      this.KyS.dT((View)paramView);
      AppMethodBeat.o(203297);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG.a
 * JD-Core Version:    0.7.0.1
 */