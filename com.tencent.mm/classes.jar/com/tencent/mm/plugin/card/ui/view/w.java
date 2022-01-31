package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View kBD;
  private View kBE;
  
  public final void bfq()
  {
    AppMethodBeat.i(88783);
    if (this.kBD != null) {
      this.kBD.setVisibility(8);
    }
    if (this.kBE != null) {
      this.kBE.setVisibility(8);
    }
    AppMethodBeat.o(88783);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88782);
    b localb = this.kBh.bdv();
    g localg = this.kBh.bdA();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.bbe().wDU != null) && (localb.bbe().wDU.size() > 1))
    {
      if (this.kBD == null) {
        this.kBD = ((ViewStub)findViewById(2131822082)).inflate();
      }
      if (this.kBE != null) {
        this.kBE.setVisibility(8);
      }
      localObject1 = this.kBh.bdy();
      localObject2 = this.kBD;
      localObject3 = this.kBh.bdz();
      LinkedList localLinkedList = localb.bbe().wDU;
      int j = l.IB(localb.bbd().color);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label359:
      while (localIterator.hasNext())
      {
        Object localObject4 = (uo)localIterator.next();
        View localView = com.tencent.mm.ui.w.hM((Context)localObject1).inflate(2130968984, (ViewGroup)localObject2, false);
        localView.setId(2131822340);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if (TextUtils.isEmpty(((uo)localObject4).url)) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131822341)).setText(((uo)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131822342);
        localTextView.setText(((uo)localObject4).kmn);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label359;
          }
          localObject4 = com.tencent.mm.ui.w.hM((Context)localObject1).inflate(2130968985, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.baL()) && (localb.bbe().wEb != null) && (!TextUtils.isEmpty(localb.bbe().wEb.title))) {
        this.kBD.setBackgroundResource(2130839676);
      }
      if ((!localb.baL()) && (localg.beR()))
      {
        this.kBD.setBackgroundResource(2130839676);
        AppMethodBeat.o(88782);
      }
    }
    else if ((localb.bbe().wDU != null) && (localb.bbe().wDU.size() == 1))
    {
      if (this.kBE == null) {
        this.kBE = ((ViewStub)findViewById(2131822083)).inflate();
      }
      if (this.kBD != null) {
        this.kBD.setVisibility(8);
      }
      localObject1 = this.kBE;
      localObject2 = this.kBh.bdz();
      localObject3 = localb.bbe().wDU;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131822343).setVisibility(0);
        localObject3 = (uo)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131822344)).setText(((uo)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131822345)).setText(((uo)localObject3).kmn);
        i = l.IB(localb.bbd().color);
        ((TextView)((View)localObject1).findViewById(2131822345)).setTextColor(i);
        ((View)localObject1).findViewById(2131822343).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((uo)localObject3).url)) {
          ((View)localObject1).findViewById(2131822343).setEnabled(false);
        }
      }
      if ((localb.baL()) && (localb.bbe().wEb != null) && (!TextUtils.isEmpty(localb.bbe().wEb.title))) {
        this.kBE.setBackgroundResource(2130839676);
      }
      if ((!localb.baL()) && (localg.beR()))
      {
        this.kBE.setBackgroundResource(2130839676);
        AppMethodBeat.o(88782);
      }
    }
    else
    {
      if (this.kBD != null) {
        this.kBD.setVisibility(8);
      }
      if (this.kBE != null) {
        this.kBE.setVisibility(8);
      }
    }
    AppMethodBeat.o(88782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */