package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<bir> uhb;
  private String uhc;
  boolean uhd;
  private int uhe;
  private a uhf;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.uhb = new LinkedList();
    this.uhc = null;
    this.uhd = false;
    this.uhe = 1;
    this.uhf = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private bir HF(int paramInt)
  {
    AppMethodBeat.i(64909);
    bir localbir = (bir)this.uhb.get(paramInt);
    AppMethodBeat.o(64909);
    return localbir;
  }
  
  public final void ef(List<bir> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.uhb = new LinkedList();; this.uhb = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.uhb.size();
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
      paramView = this.mInflater.inflate(2131494658, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.jja = paramView.findViewById(2131304239);
      paramViewGroup.ozi = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.tqQ = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.uhg = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.uhh = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.uhi = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.uhj = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.uhk = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.uhl = ((TextView)paramView.findViewById(2131301937));
      paramView.setTag(paramViewGroup);
    }
    bir localbir;
    for (;;)
    {
      localbir = HF(paramInt);
      z.b(paramViewGroup.ozi, localbir.ugE, localbir.username);
      paramViewGroup.uhi.setVisibility(8);
      z.a(this.mContext, paramViewGroup.tqQ, localbir.nickname);
      String str = this.mContext.getString(2131760940, new Object[] { e.C(localbir.EXA / 100.0D) });
      paramViewGroup.uhh.setText(str);
      paramViewGroup.uhg.setText(z.n(this.mContext, localbir.EXB * 1000L));
      paramViewGroup.uhg.setVisibility(0);
      paramViewGroup.uhj.setVisibility(8);
      if (!bs.isNullOrNil(localbir.EXD)) {
        break;
      }
      paramViewGroup.uhk.setVisibility(8);
      paramViewGroup.uhl.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.uhl.setText(localbir.EXD);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */