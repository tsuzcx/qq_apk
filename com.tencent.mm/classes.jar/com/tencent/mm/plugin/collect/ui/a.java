package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  List<com.tencent.mm.plugin.collect.model.a> pkh;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(64030);
    this.pkh = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(64030);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64031);
    int i = this.pkh.size();
    AppMethodBeat.o(64031);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(64032);
    Object localObject = this.pkh.get(paramInt);
    AppMethodBeat.o(64032);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64033);
    View localView = paramView;
    if (paramView == null)
    {
      localView = z.jV(this.mContext).inflate(2131493553, paramViewGroup, false);
      localView.setTag(new a(localView));
    }
    paramView = (com.tencent.mm.plugin.collect.model.a)this.pkh.get(paramInt);
    paramViewGroup = (a)localView.getTag();
    TextView localTextView = paramViewGroup.pah;
    Context localContext = this.mContext;
    long l = paramView.timestamp;
    localTextView.setText(new SimpleDateFormat(localContext.getString(2131757436)).format(new Date(l * 1000L)));
    paramViewGroup.pki.setText(e.Bt(paramView.dof));
    if (!bu.isNullOrNil(paramView.desc))
    {
      paramViewGroup.lHT.setText(paramView.desc);
      paramViewGroup.lHT.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(64033);
      return localView;
      paramViewGroup.lHT.setVisibility(8);
    }
  }
  
  static final class a
  {
    TextView lHT;
    TextView pah;
    WalletTextView pki;
    
    public a(View paramView)
    {
      AppMethodBeat.i(64029);
      this.pah = ((TextView)paramView.findViewById(2131298427));
      this.pki = ((WalletTextView)paramView.findViewById(2131298444));
      this.lHT = ((TextView)paramView.findViewById(2131298428));
      AppMethodBeat.o(64029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a
 * JD-Core Version:    0.7.0.1
 */