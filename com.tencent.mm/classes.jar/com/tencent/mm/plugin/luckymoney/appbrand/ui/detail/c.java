package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<cai> yQe;
  private String yQf;
  boolean yQg;
  private int yQh;
  private a yQi;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.yQe = new LinkedList();
    this.yQf = null;
    this.yQg = false;
    this.yQh = 1;
    this.yQi = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private cai PC(int paramInt)
  {
    AppMethodBeat.i(64909);
    cai localcai = (cai)this.yQe.get(paramInt);
    AppMethodBeat.o(64909);
    return localcai;
  }
  
  public final void fq(List<cai> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.yQe = new LinkedList();; this.yQe = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.yQe.size();
    AppMethodBeat.o(64908);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64910);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131495383, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.kHq = paramView.findViewById(2131307157);
      paramViewGroup.qyu = ((ImageView)paramView.findViewById(2131304259));
      paramViewGroup.rMV = ((TextView)paramView.findViewById(2131304263));
      paramViewGroup.yQj = ((TextView)paramView.findViewById(2131304264));
      paramViewGroup.yQk = ((TextView)paramView.findViewById(2131304257));
      paramViewGroup.yQl = ((TextView)paramView.findViewById(2131304258));
      paramViewGroup.yQm = ((TextView)paramView.findViewById(2131304265));
      paramViewGroup.yQn = ((ImageView)paramView.findViewById(2131304260));
      paramViewGroup.yQo = ((TextView)paramView.findViewById(2131304261));
      paramView.setTag(paramViewGroup);
    }
    cai localcai;
    for (;;)
    {
      localcai = PC(paramInt);
      af.a(paramViewGroup.qyu, localcai.yPH, localcai.username);
      paramViewGroup.yQl.setVisibility(8);
      af.a(this.mContext, paramViewGroup.rMV, localcai.nickname);
      String str = this.mContext.getString(2131762714, new Object[] { f.formatMoney2f(localcai.Mfy / 100.0D) });
      paramViewGroup.yQk.setText(str);
      paramViewGroup.yQj.setText(af.o(this.mContext, localcai.Mfz * 1000L));
      paramViewGroup.yQj.setVisibility(0);
      paramViewGroup.yQm.setVisibility(8);
      if (!Util.isNullOrNil(localcai.MfB)) {
        break;
      }
      paramViewGroup.yQn.setVisibility(8);
      paramViewGroup.yQo.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.yQo.setText(localcai.MfB);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */