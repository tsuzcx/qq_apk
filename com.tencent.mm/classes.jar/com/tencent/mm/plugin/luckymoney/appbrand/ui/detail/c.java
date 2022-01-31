package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<aty> oja;
  private String ojb;
  boolean ojc;
  private int ojd;
  private c.a oje;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(42017);
    this.oja = new LinkedList();
    this.ojb = null;
    this.ojc = false;
    this.ojd = 1;
    this.oje = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(42017);
  }
  
  private aty yh(int paramInt)
  {
    AppMethodBeat.i(42020);
    aty localaty = (aty)this.oja.get(paramInt);
    AppMethodBeat.o(42020);
    return localaty;
  }
  
  public final void ci(List<aty> paramList)
  {
    AppMethodBeat.i(42018);
    if (paramList == null) {}
    for (this.oja = new LinkedList();; this.oja = paramList)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(42018);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42019);
    int i = this.oja.size();
    AppMethodBeat.o(42019);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42021);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130970044, paramViewGroup, false);
      paramViewGroup = new c.b(this);
      paramViewGroup.ldP = paramView.findViewById(2131821003);
      paramViewGroup.kPy = ((ImageView)paramView.findViewById(2131825822));
      paramViewGroup.nzx = ((TextView)paramView.findViewById(2131825823));
      paramViewGroup.ojf = ((TextView)paramView.findViewById(2131825827));
      paramViewGroup.ojg = ((TextView)paramView.findViewById(2131825824));
      paramViewGroup.ojh = ((TextView)paramView.findViewById(2131825826));
      paramViewGroup.oji = ((TextView)paramView.findViewById(2131825825));
      paramViewGroup.ojj = ((ImageView)paramView.findViewById(2131825828));
      paramViewGroup.ojk = ((TextView)paramView.findViewById(2131825829));
      paramView.setTag(paramViewGroup);
    }
    aty localaty;
    for (;;)
    {
      localaty = yh(paramInt);
      x.b(paramViewGroup.kPy, localaty.oiD, localaty.username);
      paramViewGroup.ojh.setVisibility(8);
      x.a(this.mContext, paramViewGroup.nzx, localaty.nickname);
      String str = this.mContext.getString(2131301295, new Object[] { e.E(localaty.xiM / 100.0D) });
      paramViewGroup.ojg.setText(str);
      paramViewGroup.ojf.setText(x.j(this.mContext, localaty.xiN * 1000L));
      paramViewGroup.ojf.setVisibility(0);
      paramViewGroup.oji.setVisibility(8);
      if (!bo.isNullOrNil(localaty.xiP)) {
        break;
      }
      paramViewGroup.ojj.setVisibility(8);
      paramViewGroup.ojk.setVisibility(8);
      AppMethodBeat.o(42021);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag();
    }
    paramViewGroup.ojk.setText(localaty.xiP);
    if (this.ojd == 2) {
      paramViewGroup.ojj.setImageResource(2130839405);
    }
    for (;;)
    {
      paramViewGroup.ojj.setVisibility(0);
      paramViewGroup.ojk.setVisibility(0);
      break;
      paramViewGroup.ojj.setImageResource(2130839354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.c
 * JD-Core Version:    0.7.0.1
 */