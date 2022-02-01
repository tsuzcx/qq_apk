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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  View.OnClickListener vBb;
  b vBc;
  private List<y> vjL;
  String vjM;
  boolean vjN;
  int vjO;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.vjL = new LinkedList();
    this.vjO = 1;
    this.vBc = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private y JA(int paramInt)
  {
    AppMethodBeat.i(65928);
    y localy = (y)this.vjL.get(paramInt);
    AppMethodBeat.o(65928);
    return localy;
  }
  
  public final void es(List<y> paramList)
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
      this.vjL = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.vjL.size();
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
      paramViewGroup.jCI = paramView.findViewById(2131304239);
      paramViewGroup.pcD = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.upn = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.vjQ = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.vjR = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.vjS = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.vjT = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.vjU = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.vjV = ((TextView)paramView.findViewById(2131301937));
      if (this.vBc != null) {
        this.vBc.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    y localy;
    for (;;)
    {
      localy = JA(paramInt);
      z.b(paramViewGroup.pcD, localy.vpB, localy.userName);
      if ((!bt.nullAsNil(localy.vol).equals(this.vjM)) || (!this.vjN)) {
        break;
      }
      paramViewGroup.vjT.setOnClickListener(this.vBb);
      paramViewGroup.vjT.setVisibility(0);
      paramViewGroup.vjS.setVisibility(8);
      paramViewGroup.vjQ.setVisibility(8);
      z.a(this.mContext, paramViewGroup.upn, localy.vpA);
      String str = this.mContext.getString(2131760940, new Object[] { e.C(localy.vpn / 100.0D) });
      paramViewGroup.vjR.setText(str);
      if (!bt.isNullOrNil(localy.vpD)) {
        break label453;
      }
      paramViewGroup.vjU.setVisibility(8);
      paramViewGroup.vjV.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (bt.isNullOrNil(localy.vpC)) {
      paramViewGroup.vjS.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.vjQ.setText(z.n(this.mContext, bt.getLong(localy.vpo, 0L) * 1000L));
      paramViewGroup.vjQ.setVisibility(0);
      paramViewGroup.vjT.setVisibility(8);
      break;
      z.a(this.mContext, paramViewGroup.vjS, localy.vpC);
      paramViewGroup.vjS.setVisibility(0);
    }
    label453:
    paramViewGroup.vjV.setText(localy.vpD);
    if (this.vjO == 2) {
      paramViewGroup.vjU.setImageResource(2131233018);
    }
    for (;;)
    {
      paramViewGroup.vjU.setVisibility(0);
      paramViewGroup.vjV.setVisibility(0);
      break;
      paramViewGroup.vjU.setImageResource(2131232964);
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
      paramc.jCI.setBackgroundResource(2131101053);
      paramc.jCI.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131165500), 0, paramContext.getResources().getDimensionPixelOffset(2131165500));
      paramc.upn.setTextColor(i);
      paramc.vjQ.setTextColor(j);
      paramc.vjR.setTextColor(i);
      paramc.vjS.setTextColor(i);
      paramc.vjT.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(i.c paramc, Context paramContext);
  }
  
  final class c
  {
    View jCI;
    ImageView pcD;
    TextView upn;
    TextView vjQ;
    TextView vjR;
    TextView vjS;
    TextView vjT;
    ImageView vjU;
    TextView vjV;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */