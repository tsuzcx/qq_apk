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
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<ad> yQe;
  String yQf;
  boolean yQg;
  int yQh;
  View.OnClickListener ziC;
  b ziD;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(65925);
    this.yQe = new LinkedList();
    this.yQh = 1;
    this.ziD = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(65925);
  }
  
  private ad Qc(int paramInt)
  {
    AppMethodBeat.i(65928);
    ad localad = (ad)this.yQe.get(paramInt);
    AppMethodBeat.o(65928);
    return localad;
  }
  
  public final void fq(List<ad> paramList)
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
      this.yQe = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(65927);
    int i = this.yQe.size();
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
      paramView = this.mInflater.inflate(2131495383, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.kHq = paramView.findViewById(2131307157);
      paramViewGroup.qyu = ((ImageView)paramView.findViewById(2131304259));
      paramViewGroup.rMV = ((TextView)paramView.findViewById(2131304263));
      paramViewGroup.yQj = ((TextView)paramView.findViewById(2131304264));
      paramViewGroup.yQk = ((TextView)paramView.findViewById(2131304257));
      paramViewGroup.yQl = ((TextView)paramView.findViewById(2131304258));
      paramViewGroup.yQm = ((TextView)paramView.findViewById(2131304265));
      paramViewGroup.yQn = ((ImageView)paramView.findViewById(2131304260));
      paramViewGroup.yQo = ((TextView)paramView.findViewById(2131304261));
      if (this.ziD != null) {
        this.ziD.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    ad localad;
    for (;;)
    {
      localad = Qc(paramInt);
      af.a(paramViewGroup.qyu, localad.yWE, localad.userName);
      if ((!Util.nullAsNil(localad.yVk).equals(this.yQf)) || (!this.yQg)) {
        break;
      }
      paramViewGroup.yQm.setOnClickListener(this.ziC);
      paramViewGroup.yQm.setVisibility(0);
      paramViewGroup.yQl.setVisibility(8);
      paramViewGroup.yQj.setVisibility(8);
      af.a(this.mContext, paramViewGroup.rMV, localad.yWD);
      String str = this.mContext.getString(2131762714, new Object[] { f.formatMoney2f(localad.yWo / 100.0D) });
      paramViewGroup.yQk.setText(str);
      if (!Util.isNullOrNil(localad.yWG)) {
        break label453;
      }
      paramViewGroup.yQn.setVisibility(8);
      paramViewGroup.yQo.setVisibility(8);
      AppMethodBeat.o(65929);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
    }
    if (Util.isNullOrNil(localad.yWF)) {
      paramViewGroup.yQl.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.yQj.setText(af.o(this.mContext, Util.getLong(localad.yWp, 0L) * 1000L));
      paramViewGroup.yQj.setVisibility(0);
      paramViewGroup.yQm.setVisibility(8);
      break;
      af.a(this.mContext, paramViewGroup.yQl, localad.yWF);
      paramViewGroup.yQl.setVisibility(0);
    }
    label453:
    paramViewGroup.yQo.setText(localad.yWG);
    if (this.yQh == 2) {
      paramViewGroup.yQn.setImageResource(2131233671);
    }
    for (;;)
    {
      paramViewGroup.yQn.setVisibility(0);
      paramViewGroup.yQo.setVisibility(0);
      break;
      paramViewGroup.yQn.setImageResource(2131233614);
    }
  }
  
  final class a
    implements j.b
  {
    a() {}
    
    public final void a(j.c paramc, Context paramContext)
    {
      AppMethodBeat.i(65924);
      int i = paramContext.getResources().getColor(2131100739);
      int j = paramContext.getResources().getColor(2131100740);
      int k = paramContext.getResources().getColor(2131100754);
      paramc.kHq.setBackgroundResource(2131101287);
      paramc.kHq.setPadding(0, paramContext.getResources().getDimensionPixelOffset(2131165518), 0, paramContext.getResources().getDimensionPixelOffset(2131165518));
      paramc.rMV.setTextColor(i);
      paramc.yQj.setTextColor(j);
      paramc.yQk.setTextColor(i);
      paramc.yQl.setTextColor(i);
      paramc.yQm.setTextColor(k);
      AppMethodBeat.o(65924);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(j.c paramc, Context paramContext);
  }
  
  final class c
  {
    View kHq;
    ImageView qyu;
    TextView rMV;
    TextView yQj;
    TextView yQk;
    TextView yQl;
    TextView yQm;
    ImageView yQn;
    TextView yQo;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.j
 * JD-Core Version:    0.7.0.1
 */