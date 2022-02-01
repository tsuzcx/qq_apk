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
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  List<h> pdB;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(64041);
    this.pdB = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64041);
  }
  
  public final h Bj(int paramInt)
  {
    AppMethodBeat.i(64043);
    h localh = (h)this.pdB.get(paramInt);
    AppMethodBeat.o(64043);
    return localh;
  }
  
  public final void cL(List<h> paramList)
  {
    AppMethodBeat.i(64046);
    this.pdB.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64046);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64042);
    int i = this.pdB.size();
    AppMethodBeat.o(64042);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64044);
    View localView = paramView;
    if (paramView == null)
    {
      localView = z.jO(this.mContext).inflate(2131493555, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (a)localView.getTag();
    paramViewGroup = Bj(paramInt);
    paramView.oTF.setText(e.a(this.mContext, paramViewGroup.paq, paramViewGroup.type));
    paramView.pdC.setText(e.Bh(paramViewGroup.dsd));
    paramView.lDu.setText(this.mContext.getString(2131757448, new Object[] { Integer.valueOf(paramViewGroup.par) }));
    AppMethodBeat.o(64044);
    return localView;
  }
  
  public final void setData(List<h> paramList)
  {
    AppMethodBeat.i(64045);
    this.pdB.clear();
    this.pdB.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64045);
  }
  
  static final class a
  {
    TextView lDu;
    TextView oTF;
    WalletTextView pdC;
    TextView pdD;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64040);
      this.oTF = ((TextView)paramView.findViewById(2131298436));
      this.pdD = ((TextView)paramView.findViewById(2131298435));
      this.pdC = ((WalletTextView)paramView.findViewById(2131298441));
      this.lDu = ((TextView)paramView.findViewById(2131298437));
      AppMethodBeat.o(64040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */