package com.tencent.mm.plugin.clean.ui.newui;

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
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;

public final class a
  extends BaseAdapter
{
  HashSet<Integer> jCr;
  CleanChattingUI kJb;
  
  public a(CleanChattingUI paramCleanChattingUI)
  {
    AppMethodBeat.i(18841);
    this.kJb = paramCleanChattingUI;
    this.jCr = new HashSet();
    AppMethodBeat.o(18841);
  }
  
  private static b tE(int paramInt)
  {
    AppMethodBeat.i(18843);
    b localb = (b)d.bgQ().get(paramInt);
    AppMethodBeat.o(18843);
    return localb;
  }
  
  public final void bhf()
  {
    AppMethodBeat.i(18845);
    this.jCr.clear();
    this.kJb.a(this.jCr);
    AppMethodBeat.o(18845);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(18842);
    ArrayList localArrayList = d.bgQ();
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      AppMethodBeat.o(18842);
      return i;
    }
    AppMethodBeat.o(18842);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18844);
    b localb;
    if (paramView == null)
    {
      paramView = this.kJb.getLayoutInflater().inflate(2130969161, paramViewGroup, false);
      paramViewGroup = new a.a(this);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131821212));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131821007));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.jCu = ((RelativeLayout)paramView.findViewById(2131821630));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jCu.setOnClickListener(new a.1(this, paramInt));
      localb = tE(paramInt);
      a.b.c(paramViewGroup.egq, localb.username);
      paramViewGroup.gpL.setText(bo.hk(localb.jyU));
      if (!t.lA(localb.username)) {
        break label239;
      }
      paramViewGroup.gpM.setText(j.b(this.kJb, s.getDisplayName(localb.username, localb.username), paramViewGroup.gpM.getTextSize()));
      label198:
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label271;
      }
      paramViewGroup.gpN.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(18844);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label239:
      paramViewGroup.gpM.setText(j.b(this.kJb, s.nE(localb.username), paramViewGroup.gpM.getTextSize()));
      break label198;
      label271:
      paramViewGroup.gpN.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.a
 * JD-Core Version:    0.7.0.1
 */