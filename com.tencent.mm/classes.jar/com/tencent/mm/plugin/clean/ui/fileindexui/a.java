package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> mtN;
  CleanChattingUI nOi;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(22850);
    this.nOi = paramCleanChattingUI;
    this.mtN = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(22850);
  }
  
  public final void bNY()
  {
    AppMethodBeat.i(22854);
    this.mtN.clear();
    this.nOi.b(this.mtN);
    AppMethodBeat.o(22854);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22851);
    int i = this.dataList.size();
    AppMethodBeat.o(22851);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22853);
    c localc1;
    if (paramView == null)
    {
      paramView = this.nOi.getLayoutInflater().inflate(2131493544, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramView.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131299008));
      paramViewGroup.icb = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.mtP = ((RelativeLayout)paramView.findViewById(2131304503));
      paramView.setTag(paramViewGroup);
      paramViewGroup.mtP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22849);
          if (a.a(a.this).contains(Integer.valueOf(paramInt))) {
            a.a(a.this).remove(Integer.valueOf(paramInt));
          }
          for (;;)
          {
            a.this.notifyDataSetChanged();
            a.b(a.this).b(a.a(a.this));
            AppMethodBeat.o(22849);
            return;
            a.a(a.this).add(Integer.valueOf(paramInt));
          }
        }
      });
      c localc2 = zu(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        ad.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.frr, localc1.username);
      paramViewGroup.ica.setText(bt.mK(localc1.size));
      if (!w.pF(localc1.username)) {
        break label289;
      }
      paramViewGroup.hJe.setText(k.b(this.nOi, v.getDisplayName(localc1.username, localc1.username), paramViewGroup.hJe.getTextSize()));
      label248:
      if (!this.mtN.contains(Integer.valueOf(paramInt))) {
        break label321;
      }
      paramViewGroup.icb.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(22853);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label289:
      paramViewGroup.hJe.setText(k.b(this.nOi, v.sh(localc1.username), paramViewGroup.hJe.getTextSize()));
      break label248;
      label321:
      paramViewGroup.icb.setChecked(false);
    }
  }
  
  public final c zu(int paramInt)
  {
    AppMethodBeat.i(22852);
    if ((paramInt < 0) || (paramInt >= this.dataList.size()))
    {
      AppMethodBeat.o(22852);
      return null;
    }
    c localc = (c)this.dataList.get(paramInt);
    AppMethodBeat.o(22852);
    return localc;
  }
  
  final class a
  {
    ImageView frr;
    TextView hJe;
    TextView ica;
    CheckBox icb;
    RelativeLayout mtP;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */