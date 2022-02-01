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
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<bmz> vjL;
  private String vjM;
  boolean vjN;
  private int vjO;
  private a vjP;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.vjL = new LinkedList();
    this.vjM = null;
    this.vjN = false;
    this.vjO = 1;
    this.vjP = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private bmz Jb(int paramInt)
  {
    AppMethodBeat.i(64909);
    bmz localbmz = (bmz)this.vjL.get(paramInt);
    AppMethodBeat.o(64909);
    return localbmz;
  }
  
  public final void es(List<bmz> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.vjL = new LinkedList();; this.vjL = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.vjL.size();
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
      paramViewGroup.jCI = paramView.findViewById(2131304239);
      paramViewGroup.pcD = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.upn = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.vjQ = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.vjR = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.vjS = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.vjT = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.vjU = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.vjV = ((TextView)paramView.findViewById(2131301937));
      paramView.setTag(paramViewGroup);
    }
    bmz localbmz;
    for (;;)
    {
      localbmz = Jb(paramInt);
      z.b(paramViewGroup.pcD, localbmz.vjo, localbmz.username);
      paramViewGroup.vjS.setVisibility(8);
      z.a(this.mContext, paramViewGroup.upn, localbmz.nickname);
      String str = this.mContext.getString(2131760940, new Object[] { e.C(localbmz.GGW / 100.0D) });
      paramViewGroup.vjR.setText(str);
      paramViewGroup.vjQ.setText(z.n(this.mContext, localbmz.GGX * 1000L));
      paramViewGroup.vjQ.setVisibility(0);
      paramViewGroup.vjT.setVisibility(8);
      if (!bt.isNullOrNil(localbmz.GGZ)) {
        break;
      }
      paramViewGroup.vjU.setVisibility(8);
      paramViewGroup.vjV.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.vjV.setText(localbmz.GGZ);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */