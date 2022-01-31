package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View iyw;
  private View iyx;
  
  public final void aCU()
  {
    if (this.iyw != null) {
      this.iyw.setVisibility(8);
    }
    if (this.iyx != null) {
      this.iyx.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    b localb = this.iya.aBE();
    g localg = this.iya.aBJ();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.azy().sHy != null) && (localb.azy().sHy.size() > 1))
    {
      if (this.iyw == null) {
        this.iyw = ((ViewStub)findViewById(a.d.card_secondary_field_stub)).inflate();
      }
      if (this.iyx != null) {
        this.iyx.setVisibility(8);
      }
      localObject1 = this.iya.aBH();
      localObject2 = this.iyw;
      localObject3 = this.iya.aBI();
      LinkedList localLinkedList = localb.azy().sHy;
      int j = l.yR(localb.azx().color);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label360:
      while (localIterator.hasNext())
      {
        Object localObject4 = (ra)localIterator.next();
        View localView = y.gt((Context)localObject1).inflate(a.e.card_secondary_field_layout_item, (ViewGroup)localObject2, false);
        localView.setId(a.d.card_secondary_field_view);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if (TextUtils.isEmpty(((ra)localObject4).url)) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(a.d.secondary_field_title)).setText(((ra)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(a.d.secondary_field_subtitle);
        localTextView.setText(((ra)localObject4).ilq);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label360;
          }
          localObject4 = y.gt((Context)localObject1).inflate(a.e.card_secondary_field_layout_item_seperator, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.azf()) && (localb.azy().sHF != null) && (!TextUtils.isEmpty(localb.azy().sHF.title))) {
        this.iyw.setBackgroundResource(a.c.mm_trans);
      }
      if ((!localb.azf()) && (localg.aCH())) {
        this.iyw.setBackgroundResource(a.c.mm_trans);
      }
    }
    do
    {
      do
      {
        return;
        if ((localb.azy().sHy == null) || (localb.azy().sHy.size() != 1)) {
          break;
        }
        if (this.iyx == null) {
          this.iyx = ((ViewStub)findViewById(a.d.card_secondary_field_single_stub)).inflate();
        }
        if (this.iyw != null) {
          this.iyw.setVisibility(8);
        }
        localObject1 = this.iyx;
        localObject2 = this.iya.aBI();
        localObject3 = localb.azy().sHy;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setVisibility(0);
          localObject3 = (ra)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_title_1)).setText(((ra)localObject3).title);
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setText(((ra)localObject3).ilq);
          i = l.yR(localb.azx().color);
          ((TextView)((View)localObject1).findViewById(a.d.secondary_field_subtitle_1)).setTextColor(i);
          ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setOnClickListener((View.OnClickListener)localObject2);
          if (TextUtils.isEmpty(((ra)localObject3).url)) {
            ((View)localObject1).findViewById(a.d.card_secondary_field_view_1).setEnabled(false);
          }
        }
        if ((localb.azf()) && (localb.azy().sHF != null) && (!TextUtils.isEmpty(localb.azy().sHF.title))) {
          this.iyx.setBackgroundResource(a.c.mm_trans);
        }
      } while ((localb.azf()) || (!localg.aCH()));
      this.iyx.setBackgroundResource(a.c.mm_trans);
      return;
      if (this.iyw != null) {
        this.iyw.setVisibility(8);
      }
    } while (this.iyx == null);
    this.iyx.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */