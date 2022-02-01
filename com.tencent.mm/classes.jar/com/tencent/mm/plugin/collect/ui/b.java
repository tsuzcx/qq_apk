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
  List<h> pkh;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(64041);
    this.pkh = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64041);
  }
  
  public final h Bv(int paramInt)
  {
    AppMethodBeat.i(64043);
    h localh = (h)this.pkh.get(paramInt);
    AppMethodBeat.o(64043);
    return localh;
  }
  
  public final void cO(List<h> paramList)
  {
    AppMethodBeat.i(64046);
    this.pkh.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64046);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64042);
    int i = this.pkh.size();
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
      localView = z.jV(this.mContext).inflate(2131493555, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (a)localView.getTag();
    paramViewGroup = Bv(paramInt);
    paramView.pah.setText(e.a(this.mContext, paramViewGroup.pgU, paramViewGroup.type));
    paramView.pki.setText(e.Bt(paramViewGroup.dtj));
    paramView.lHT.setText(this.mContext.getString(2131757448, new Object[] { Integer.valueOf(paramViewGroup.pgV) }));
    AppMethodBeat.o(64044);
    return localView;
  }
  
  public final void setData(List<h> paramList)
  {
    AppMethodBeat.i(64045);
    this.pkh.clear();
    this.pkh.addAll(paramList);
    notifyDataSetChanged();
    AppMethodBeat.o(64045);
  }
  
  static final class a
  {
    TextView lHT;
    TextView pah;
    WalletTextView pki;
    TextView pkj;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64040);
      this.pah = ((TextView)paramView.findViewById(2131298436));
      this.pkj = ((TextView)paramView.findViewById(2131298435));
      this.pki = ((WalletTextView)paramView.findViewById(2131298441));
      this.lHT = ((TextView)paramView.findViewById(2131298437));
      AppMethodBeat.o(64040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.b
 * JD-Core Version:    0.7.0.1
 */