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
  private List<y> sYN;
  String sYO;
  boolean sYP;
  int sYQ;
  View.OnClickListener tqg;
  b tqh;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.sYN = new LinkedList();
    this.sYQ = 1;
    this.tqh = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private y Gj(int paramInt)
  {
    AppMethodBeat.i(65928);
    y localy = (y)this.sYN.get(paramInt);
    AppMethodBeat.o(65928);
    return localy;
  }
  
  public final void eb(List<y> paramList)
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
      this.sYN = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.sYN.size();
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
      paramViewGroup.iIW = paramView.findViewById(2131304239);
      paramViewGroup.nVN = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.siX = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.sYS = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.sYT = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.sYU = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.sYV = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.sYW = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.sYX = ((TextView)paramView.findViewById(2131301937));
      if (this.tqh != null) {
        this.tqh.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    y localy;
    for (;;)
    {
      localy = Gj(paramInt);
      z.b(paramViewGroup.nVN, localy.teG, localy.userName);
      if ((!bt.nullAsNil(localy.tdq).equals(this.sYO)) || (!this.sYP)) {
        break;
      }
      paramViewGroup.sYV.setOnClickListener(this.tqg);
      paramViewGroup.sYV.setVisibility(0);
      paramViewGroup.sYU.setVisibility(8);
      paramViewGroup.sYS.setVisibility(8);
      z.a(this.mContext, paramViewGroup.siX, localy.teF);
      String str = this.mContext.getString(2131760940, new Object[] { e.D(localy.tes / 100.0D) });
      paramViewGroup.sYT.setText(str);
      if (!bt.isNullOrNil(localy.teI)) {
        break label453;
      }
      paramViewGroup.sYW.setVisibility(8);
      paramViewGroup.sYX.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (bt.isNullOrNil(localy.teH)) {
      paramViewGroup.sYU.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.sYS.setText(z.m(this.mContext, bt.getLong(localy.tet, 0L) * 1000L));
      paramViewGroup.sYS.setVisibility(0);
      paramViewGroup.sYV.setVisibility(8);
      break;
      z.a(this.mContext, paramViewGroup.sYU, localy.teH);
      paramViewGroup.sYU.setVisibility(0);
    }
    label453:
    paramViewGroup.sYX.setText(localy.teI);
    if (this.sYQ == 2) {
      paramViewGroup.sYW.setImageResource(2131233018);
    }
    for (;;)
    {
      paramViewGroup.sYW.setVisibility(0);
      paramViewGroup.sYX.setVisibility(0);
      break;
      paramViewGroup.sYW.setImageResource(2131232964);
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
      paramc.iIW.setBackgroundResource(2131101053);
      paramc.iIW.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131165500), 0, paramContext.getResources().getDimensionPixelOffset(2131165500));
      paramc.siX.setTextColor(i);
      paramc.sYS.setTextColor(j);
      paramc.sYT.setTextColor(i);
      paramc.sYU.setTextColor(i);
      paramc.sYV.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(i.c paramc, Context paramContext);
  }
  
  final class c
  {
    View iIW;
    ImageView nVN;
    TextView sYS;
    TextView sYT;
    TextView sYU;
    TextView sYV;
    ImageView sYW;
    TextView sYX;
    TextView siX;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */