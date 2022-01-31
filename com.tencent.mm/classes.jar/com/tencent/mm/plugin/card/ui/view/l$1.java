package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tx;
import java.util.LinkedList;

final class l$1
  implements View.OnClickListener
{
  l$1(l paraml, tx paramtx, LinkedList paramLinkedList, LayoutInflater paramLayoutInflater) {}
  
  public final void onClick(View paramView)
  {
    this.iyi.iye = true;
    this.iyi.iyc.findViewById(a.d.detail_table_expand_tv).setVisibility(8);
    int i = this.iyf.sQK;
    while (i < this.iyg.size())
    {
      paramView = (TextView)this.iyh.inflate(a.e.card_table_row_item, null, false);
      paramView.setText(((ra)this.iyg.get(i)).title);
      this.iyi.iyd.addView(paramView);
      i += 1;
    }
    this.iyi.iyd.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l.1
 * JD-Core Version:    0.7.0.1
 */