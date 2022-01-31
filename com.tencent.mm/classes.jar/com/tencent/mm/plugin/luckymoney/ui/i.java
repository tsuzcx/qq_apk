package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<w> oja;
  String ojb;
  boolean ojc;
  int ojd;
  View.OnClickListener owY;
  i.b owZ;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(43030);
    this.oja = new LinkedList();
    this.ojd = 1;
    this.owZ = null;
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    AppMethodBeat.o(43030);
  }
  
  private w yI(int paramInt)
  {
    AppMethodBeat.i(43033);
    w localw = (w)this.oja.get(paramInt);
    AppMethodBeat.o(43033);
    return localw;
  }
  
  public final void ci(List<w> paramList)
  {
    AppMethodBeat.i(43031);
    if (paramList == null) {
      new LinkedList();
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(43031);
      return;
      this.oja = paramList;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43032);
    int i = this.oja.size();
    AppMethodBeat.o(43032);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43034);
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130970044, paramViewGroup, false);
      paramViewGroup = new i.c(this);
      paramViewGroup.ldP = paramView.findViewById(2131821003);
      paramViewGroup.kPy = ((ImageView)paramView.findViewById(2131825822));
      paramViewGroup.nzx = ((TextView)paramView.findViewById(2131825823));
      paramViewGroup.ojf = ((TextView)paramView.findViewById(2131825827));
      paramViewGroup.ojg = ((TextView)paramView.findViewById(2131825824));
      paramViewGroup.ojh = ((TextView)paramView.findViewById(2131825826));
      paramViewGroup.oji = ((TextView)paramView.findViewById(2131825825));
      paramViewGroup.ojj = ((ImageView)paramView.findViewById(2131825828));
      paramViewGroup.ojk = ((TextView)paramView.findViewById(2131825829));
      if (this.owZ != null) {
        this.owZ.a(paramViewGroup, this.mContext);
      }
      paramView.setTag(paramViewGroup);
    }
    w localw;
    for (;;)
    {
      localw = yI(paramInt);
      x.b(paramViewGroup.kPy, localw.ooC, localw.userName);
      if ((!bo.nullAsNil(localw.onz).equals(this.ojb)) || (!this.ojc)) {
        break;
      }
      paramViewGroup.oji.setOnClickListener(this.owY);
      paramViewGroup.oji.setVisibility(0);
      paramViewGroup.ojh.setVisibility(8);
      paramViewGroup.ojf.setVisibility(8);
      x.a(this.mContext, paramViewGroup.nzx, localw.ooB);
      String str = this.mContext.getString(2131301295, new Object[] { e.E(localw.ooo / 100.0D) });
      paramViewGroup.ojg.setText(str);
      if (!bo.isNullOrNil(localw.ooE)) {
        break label453;
      }
      paramViewGroup.ojj.setVisibility(8);
      paramViewGroup.ojk.setVisibility(8);
      AppMethodBeat.o(43034);
      return paramView;
      paramViewGroup = (i.c)paramView.getTag();
    }
    if (bo.isNullOrNil(localw.ooD)) {
      paramViewGroup.ojh.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.ojf.setText(x.j(this.mContext, bo.getLong(localw.oop, 0L) * 1000L));
      paramViewGroup.ojf.setVisibility(0);
      paramViewGroup.oji.setVisibility(8);
      break;
      x.a(this.mContext, paramViewGroup.ojh, localw.ooD);
      paramViewGroup.ojh.setVisibility(0);
    }
    label453:
    paramViewGroup.ojk.setText(localw.ooE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.i
 * JD-Core Version:    0.7.0.1
 */