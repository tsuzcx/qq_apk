package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<c> dataList;
  HashSet<Integer> jCr;
  CleanChattingUI kHF;
  
  public a(CleanChattingUI paramCleanChattingUI, List<c> paramList)
  {
    AppMethodBeat.i(18740);
    this.kHF = paramCleanChattingUI;
    this.jCr = new HashSet();
    this.dataList = paramList;
    AppMethodBeat.o(18740);
  }
  
  public final void bhf()
  {
    AppMethodBeat.i(18744);
    this.jCr.clear();
    this.kHF.a(this.jCr);
    AppMethodBeat.o(18744);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(18741);
    int i = this.dataList.size();
    AppMethodBeat.o(18741);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18743);
    c localc1;
    if (paramView == null)
    {
      paramView = this.kHF.getLayoutInflater().inflate(2130969161, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131821007));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.jCu = ((RelativeLayout)paramView.findViewById(2131821630));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jCu.setOnClickListener(new a.1(this, paramInt));
      c localc2 = tA(paramInt);
      localc1 = localc2;
      if (localc2 == null)
      {
        ab.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", new Object[] { Integer.valueOf(paramInt) });
        localc1 = new c();
        localc1.size = 0L;
        localc1.username = "";
      }
      a.b.c(paramViewGroup.egq, localc1.username);
      paramViewGroup.gpL.setText(bo.hk(localc1.size));
      if (!t.lA(localc1.username)) {
        break label289;
      }
      paramViewGroup.gpM.setText(j.b(this.kHF, s.getDisplayName(localc1.username, localc1.username), paramViewGroup.gpM.getTextSize()));
      label248:
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label321;
      }
      paramViewGroup.gpN.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(18743);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label289:
      paramViewGroup.gpM.setText(j.b(this.kHF, s.nE(localc1.username), paramViewGroup.gpM.getTextSize()));
      break label248;
      label321:
      paramViewGroup.gpN.setChecked(false);
    }
  }
  
  public final c tA(int paramInt)
  {
    AppMethodBeat.i(18742);
    if ((paramInt < 0) || (paramInt >= this.dataList.size()))
    {
      AppMethodBeat.o(18742);
      return null;
    }
    c localc = (c)this.dataList.get(paramInt);
    AppMethodBeat.o(18742);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a
 * JD-Core Version:    0.7.0.1
 */