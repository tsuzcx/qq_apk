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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  View.OnClickListener vNf;
  b vNg;
  private List<y> vvQ;
  String vvR;
  boolean vvS;
  int vvT;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.vvQ = new LinkedList();
    this.vvT = 1;
    this.vNg = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private y JZ(int paramInt)
  {
    AppMethodBeat.i(65928);
    y localy = (y)this.vvQ.get(paramInt);
    AppMethodBeat.o(65928);
    return localy;
  }
  
  public final void ew(List<y> paramList)
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
      this.vvQ = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.vvQ.size();
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
      paramViewGroup.jFG = paramView.findViewById(2131304239);
      paramViewGroup.pjj = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.uAJ = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.vvV = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.vvW = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.vvX = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.vvY = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.vvZ = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.vwa = ((TextView)paramView.findViewById(2131301937));
      if (this.vNg != null) {
        this.vNg.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    y localy;
    for (;;)
    {
      localy = JZ(paramInt);
      z.b(paramViewGroup.pjj, localy.vBG, localy.userName);
      if ((!bu.nullAsNil(localy.vAq).equals(this.vvR)) || (!this.vvS)) {
        break;
      }
      paramViewGroup.vvY.setOnClickListener(this.vNf);
      paramViewGroup.vvY.setVisibility(0);
      paramViewGroup.vvX.setVisibility(8);
      paramViewGroup.vvV.setVisibility(8);
      z.a(this.mContext, paramViewGroup.uAJ, localy.vBF);
      String str = this.mContext.getString(2131760940, new Object[] { f.C(localy.vBs / 100.0D) });
      paramViewGroup.vvW.setText(str);
      if (!bu.isNullOrNil(localy.vBI)) {
        break label453;
      }
      paramViewGroup.vvZ.setVisibility(8);
      paramViewGroup.vwa.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (bu.isNullOrNil(localy.vBH)) {
      paramViewGroup.vvX.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.vvV.setText(z.o(this.mContext, bu.getLong(localy.vBt, 0L) * 1000L));
      paramViewGroup.vvV.setVisibility(0);
      paramViewGroup.vvY.setVisibility(8);
      break;
      z.a(this.mContext, paramViewGroup.vvX, localy.vBH);
      paramViewGroup.vvX.setVisibility(0);
    }
    label453:
    paramViewGroup.vwa.setText(localy.vBI);
    if (this.vvT == 2) {
      paramViewGroup.vvZ.setImageResource(2131233018);
    }
    for (;;)
    {
      paramViewGroup.vvZ.setVisibility(0);
      paramViewGroup.vwa.setVisibility(0);
      break;
      paramViewGroup.vvZ.setImageResource(2131232964);
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
      paramc.jFG.setBackgroundResource(2131101053);
      paramc.jFG.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131165500), 0, paramContext.getResources().getDimensionPixelOffset(2131165500));
      paramc.uAJ.setTextColor(i);
      paramc.vvV.setTextColor(j);
      paramc.vvW.setTextColor(i);
      paramc.vvX.setTextColor(i);
      paramc.vvY.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(i.c paramc, Context paramContext);
  }
  
  final class c
  {
    View jFG;
    ImageView pjj;
    TextView uAJ;
    TextView vvV;
    TextView vvW;
    TextView vvX;
    TextView vvY;
    ImageView vvZ;
    TextView vwa;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */