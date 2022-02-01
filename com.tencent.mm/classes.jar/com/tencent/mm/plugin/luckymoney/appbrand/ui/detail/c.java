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
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<bez> sYN;
  private String sYO;
  boolean sYP;
  private int sYQ;
  private a sYR;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.sYN = new LinkedList();
    this.sYO = null;
    this.sYP = false;
    this.sYQ = 1;
    this.sYR = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private bez FK(int paramInt)
  {
    AppMethodBeat.i(64909);
    bez localbez = (bez)this.sYN.get(paramInt);
    AppMethodBeat.o(64909);
    return localbez;
  }
  
  public final void eb(List<bez> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.sYN = new LinkedList();; this.sYN = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.sYN.size();
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
      paramViewGroup.iIW = paramView.findViewById(2131304239);
      paramViewGroup.nVN = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.siX = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.sYS = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.sYT = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.sYU = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.sYV = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.sYW = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.sYX = ((TextView)paramView.findViewById(2131301937));
      paramView.setTag(paramViewGroup);
    }
    bez localbez;
    for (;;)
    {
      localbez = FK(paramInt);
      z.b(paramViewGroup.nVN, localbez.sYq, localbez.username);
      paramViewGroup.sYU.setVisibility(8);
      z.a(this.mContext, paramViewGroup.siX, localbez.nickname);
      String str = this.mContext.getString(2131760940, new Object[] { e.D(localbez.DCe / 100.0D) });
      paramViewGroup.sYT.setText(str);
      paramViewGroup.sYS.setText(z.m(this.mContext, localbez.DCf * 1000L));
      paramViewGroup.sYS.setVisibility(0);
      paramViewGroup.sYV.setVisibility(8);
      if (!bt.isNullOrNil(localbez.DCh)) {
        break;
      }
      paramViewGroup.sYW.setVisibility(8);
      paramViewGroup.sYX.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.sYX.setText(localbez.DCh);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */