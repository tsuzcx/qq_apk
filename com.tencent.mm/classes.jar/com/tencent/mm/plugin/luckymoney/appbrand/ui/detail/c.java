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
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<bnr> vvQ;
  private String vvR;
  boolean vvS;
  private int vvT;
  private a vvU;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(64906);
    this.vvQ = new LinkedList();
    this.vvR = null;
    this.vvS = false;
    this.vvT = 1;
    this.vvU = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(64906);
  }
  
  private bnr JA(int paramInt)
  {
    AppMethodBeat.i(64909);
    bnr localbnr = (bnr)this.vvQ.get(paramInt);
    AppMethodBeat.o(64909);
    return localbnr;
  }
  
  public final void ew(List<bnr> paramList)
  {
    AppMethodBeat.i(64907);
    if (paramList == null) {}
    for (this.vvQ = new LinkedList();; this.vvQ = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(64907);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64908);
    int i = this.vvQ.size();
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
      paramViewGroup.jFG = paramView.findViewById(2131304239);
      paramViewGroup.pjj = ((ImageView)paramView.findViewById(2131301935));
      paramViewGroup.uAJ = ((TextView)paramView.findViewById(2131301938));
      paramViewGroup.vvV = ((TextView)paramView.findViewById(2131301939));
      paramViewGroup.vvW = ((TextView)paramView.findViewById(2131301933));
      paramViewGroup.vvX = ((TextView)paramView.findViewById(2131301934));
      paramViewGroup.vvY = ((TextView)paramView.findViewById(2131301940));
      paramViewGroup.vvZ = ((ImageView)paramView.findViewById(2131301936));
      paramViewGroup.vwa = ((TextView)paramView.findViewById(2131301937));
      paramView.setTag(paramViewGroup);
    }
    bnr localbnr;
    for (;;)
    {
      localbnr = JA(paramInt);
      z.b(paramViewGroup.pjj, localbnr.vvt, localbnr.username);
      paramViewGroup.vvX.setVisibility(8);
      z.a(this.mContext, paramViewGroup.uAJ, localbnr.nickname);
      String str = this.mContext.getString(2131760940, new Object[] { f.C(localbnr.Hay / 100.0D) });
      paramViewGroup.vvW.setText(str);
      paramViewGroup.vvV.setText(z.o(this.mContext, localbnr.Haz * 1000L));
      paramViewGroup.vvV.setVisibility(0);
      paramViewGroup.vvY.setVisibility(8);
      if (!bu.isNullOrNil(localbnr.HaB)) {
        break;
      }
      paramViewGroup.vvZ.setVisibility(8);
      paramViewGroup.vwa.setVisibility(8);
      AppMethodBeat.o(64910);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
    paramViewGroup.vwa.setText(localbnr.HaB);
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
  
  static abstract interface a {}
  
  final class b
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
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */