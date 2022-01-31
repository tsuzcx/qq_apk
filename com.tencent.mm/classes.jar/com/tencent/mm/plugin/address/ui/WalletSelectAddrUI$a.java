package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import java.util.ArrayList;
import java.util.List;

public final class WalletSelectAddrUI$a
  extends BaseAdapter
{
  private final Context context;
  List<b> items;
  
  public WalletSelectAddrUI$a(WalletSelectAddrUI paramWalletSelectAddrUI, Context paramContext)
  {
    AppMethodBeat.i(16989);
    this.items = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(16989);
  }
  
  private b ne(int paramInt)
  {
    AppMethodBeat.i(16992);
    b localb = (b)this.items.get(paramInt);
    AppMethodBeat.o(16992);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(16991);
    int i = this.items.size();
    AppMethodBeat.o(16991);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(16990);
    paramViewGroup = new a();
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130971121, null);
      paramViewGroup.gMq = ((ImageView)paramView.findViewById(2131828918));
      paramViewGroup.gMp = ((TextView)paramView.findViewById(2131828917));
      paramViewGroup.gve = ((TextView)paramView.findViewById(2131828916));
      paramView.setTag(paramViewGroup);
      b localb = ne(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(localb.gLe)) {
        localStringBuilder.append(localb.gLe);
      }
      if (!TextUtils.isEmpty(localb.gLf))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.gLf);
      }
      if (!TextUtils.isEmpty(localb.gLg))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.gLg);
      }
      if (!TextUtils.isEmpty(localb.gLi))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.gLi);
      }
      paramViewGroup.gMp.setText(localStringBuilder.toString());
      paramViewGroup.gve.setText(localb.gLj + "，" + localb.gLk);
      if ((!WalletSelectAddrUI.e(this.gNo)) || (WalletSelectAddrUI.g(this.gNo) == null) || (WalletSelectAddrUI.g(this.gNo).id != localb.id)) {
        break label318;
      }
      paramViewGroup.gMq.setImageResource(2131231906);
    }
    for (;;)
    {
      AppMethodBeat.o(16990);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label318:
      paramViewGroup.gMq.setImageBitmap(null);
    }
  }
  
  final class a
  {
    TextView gMp;
    ImageView gMq;
    TextView gve;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.a
 * JD-Core Version:    0.7.0.1
 */