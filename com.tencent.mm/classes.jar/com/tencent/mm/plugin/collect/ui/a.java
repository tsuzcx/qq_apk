package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends BaseAdapter
{
  List<com.tencent.mm.plugin.collect.model.a> kQw;
  private Context mContext;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(41169);
    this.kQw = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(41169);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41170);
    int i = this.kQw.size();
    AppMethodBeat.o(41170);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(41171);
    Object localObject = this.kQw.get(paramInt);
    AppMethodBeat.o(41171);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41172);
    View localView = paramView;
    if (paramView == null)
    {
      localView = w.hM(this.mContext).inflate(2130969171, paramViewGroup, false);
      localView.setTag(new a.a(localView));
    }
    paramView = (com.tencent.mm.plugin.collect.model.a)this.kQw.get(paramInt);
    paramViewGroup = (a.a)localView.getTag();
    TextView localTextView = paramViewGroup.kGe;
    Context localContext = this.mContext;
    long l = paramView.timestamp;
    localTextView.setText(new SimpleDateFormat(localContext.getString(2131298424)).format(new Date(l * 1000L)));
    paramViewGroup.kQx.setText(e.tN(paramView.cpo));
    if (!bo.isNullOrNil(paramView.desc))
    {
      paramViewGroup.kPB.setText(paramView.desc);
      paramViewGroup.kPB.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(41172);
      return localView;
      paramViewGroup.kPB.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.a
 * JD-Core Version:    0.7.0.1
 */