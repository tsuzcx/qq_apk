package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  List<h> kQw;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(41179);
    this.kQw = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(41179);
  }
  
  public final void bm(List<h> paramList)
  {
    AppMethodBeat.i(41184);
    this.kQw.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(41184);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41180);
    int i = this.kQw.size();
    AppMethodBeat.o(41180);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41182);
    View localView = paramView;
    if (paramView == null)
    {
      localView = w.hM(this.mContext).inflate(2130969173, paramViewGroup, false);
      localView.setTag(new b.a(localView));
    }
    paramView = (b.a)localView.getTag();
    paramViewGroup = tP(paramInt);
    paramView.kGe.setText(e.a(this.mContext, paramViewGroup.kNm, paramViewGroup.type));
    paramView.kQx.setText(e.tN(paramViewGroup.kNo));
    paramView.kPB.setText(this.mContext.getString(2131298436, new Object[] { Integer.valueOf(paramViewGroup.kNn) }));
    AppMethodBeat.o(41182);
    return localView;
  }
  
  public final void setData(List<h> paramList)
  {
    AppMethodBeat.i(41183);
    this.kQw.clear();
    this.kQw.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(41183);
  }
  
  public final h tP(int paramInt)
  {
    AppMethodBeat.i(41181);
    h localh = (h)this.kQw.get(paramInt);
    AppMethodBeat.o(41181);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */