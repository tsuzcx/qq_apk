package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<y> uhb;
  String uhc;
  boolean uhd;
  int uhe;
  View.OnClickListener uyy;
  b uyz;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.uhb = new LinkedList();
    this.uhe = 1;
    this.uyz = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private y Ie(int paramInt)
  {
    AppMethodBeat.i(65928);
    y localy = (y)this.uhb.get(paramInt);
    AppMethodBeat.o(65928);
    return localy;
  }
  
  public final void ef(List<y> paramList)
  {
    AppMethodBeat.i(65926);
    if (paramList == null) {
      new LinkedList();
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(65926);
      return;
      this.uhb = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.uhb.size();
    AppMethodBeat.o(65927);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(65929);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131494658, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.jja = paramView.findViewById(2131304239);
      paramViewGroup.ozi = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.tqQ = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.uhg = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.uhh = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.uhi = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.uhj = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.uhk = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.uhl = ((TextView)paramView.findViewById(2131301937));
      if (this.uyz != null) {
        this.uyz.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    y localy;
    for (;;)
    {
      localy = Ie(paramInt);
      z.b(paramViewGroup.ozi, localy.umV, localy.userName);
      if ((!bs.nullAsNil(localy.ulF).equals(this.uhc)) || (!this.uhd)) {
        break;
      }
      paramViewGroup.uhj.setOnClickListener(this.uyy);
      paramViewGroup.uhj.setVisibility(0);
      paramViewGroup.uhi.setVisibility(8);
      paramViewGroup.uhg.setVisibility(8);
      z.a(this.mContext, paramViewGroup.tqQ, localy.umU);
      String str = this.mContext.getString(2131760940, new Object[] { e.C(localy.umH / 100.0D) });
      paramViewGroup.uhh.setText(str);
      if (!bs.isNullOrNil(localy.umX)) {
        break label453;
      }
      paramViewGroup.uhk.setVisibility(8);
      paramViewGroup.uhl.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (bs.isNullOrNil(localy.umW)) {
      paramViewGroup.uhi.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.uhg.setText(z.n(this.mContext, bs.getLong(localy.umI, 0L) * 1000L));
      paramViewGroup.uhg.setVisibility(0);
      paramViewGroup.uhj.setVisibility(8);
      break;
      z.a(this.mContext, paramViewGroup.uhi, localy.umW);
      paramViewGroup.uhi.setVisibility(0);
    }
    label453:
    paramViewGroup.uhl.setText(localy.umX);
    if (this.uhe == 2) {
      paramViewGroup.uhk.setImageResource(2131233018);
    }
    for (;;)
    {
      paramViewGroup.uhk.setVisibility(0);
      paramViewGroup.uhl.setVisibility(0);
      break;
      paramViewGroup.uhk.setImageResource(2131232964);
    }
  }
  
  final class a
    implements i.b
  {
    a() {}
    
    public final void a(i.c paramc, Context paramContext)
    {
      AppMethodBeat.i(65924);
      int i = paramContext.getResources().getColor(2131100571);
      int j = paramContext.getResources().getColor(2131100572);
      int k = paramContext.getResources().getColor(2131100586);
      paramc.jja.setBackgroundResource(2131101053);
      paramc.jja.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131165500), 0, paramContext.getResources().getDimensionPixelOffset(2131165500));
      paramc.tqQ.setTextColor(i);
      paramc.uhg.setTextColor(j);
      paramc.uhh.setTextColor(i);
      paramc.uhi.setTextColor(i);
      paramc.uhj.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(i.c paramc, Context paramContext);
  }
  
  final class c
  {
    View jja;
    ImageView ozi;
    TextView tqQ;
    TextView uhg;
    TextView uhh;
    TextView uhi;
    TextView uhj;
    ImageView uhk;
    TextView uhl;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */