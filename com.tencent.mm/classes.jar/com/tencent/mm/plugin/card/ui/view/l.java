package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View iyc;
  LinearLayout iyd;
  boolean iye = false;
  
  public final void aCU()
  {
    if (this.iyc != null) {
      this.iyc.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    if (this.iyc == null) {
      this.iyc = ((ViewStub)findViewById(a.d.card_detail_table_stub)).inflate();
    }
    Object localObject = this.iya.aBE().azy().sHH;
    ((TextView)this.iyc.findViewById(a.d.detail_table_title)).setText(((tx)localObject).title);
    LinkedList localLinkedList;
    LayoutInflater localLayoutInflater;
    if ((((tx)localObject).sQL != null) && (((tx)localObject).sQL.size() > 0))
    {
      this.iyd = ((LinearLayout)this.iyc.findViewById(a.d.detail_table_rows_view));
      this.iyd.removeAllViews();
      localLinkedList = ((tx)localObject).sQL;
      localLayoutInflater = (LayoutInflater)this.iya.aBH().getSystemService("layout_inflater");
      if ((((tx)localObject).sQK >= localLinkedList.size()) || (this.iye))
      {
        this.iyc.findViewById(a.d.detail_table_expand_tv).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(a.e.card_table_row_item, null, false);
          ((TextView)localObject).setText(((ra)localLinkedList.get(i)).title);
          this.iyd.addView((View)localObject);
          i += 1;
        }
        this.iyd.invalidate();
      }
    }
    else
    {
      return;
    }
    int i = 0;
    while (i < ((tx)localObject).sQK)
    {
      TextView localTextView = (TextView)localLayoutInflater.inflate(a.e.card_table_row_item, null, false);
      localTextView.setText(((ra)localLinkedList.get(i)).title);
      this.iyd.addView(localTextView);
      i += 1;
    }
    this.iyd.invalidate();
    this.iyc.findViewById(a.d.detail_table_expand_tv).setVisibility(0);
    this.iyc.findViewById(a.d.detail_table_expand_tv).setOnClickListener(new l.1(this, (tx)localObject, localLinkedList, localLayoutInflater));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */