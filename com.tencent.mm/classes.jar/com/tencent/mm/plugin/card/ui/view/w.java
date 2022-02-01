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
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View tGp;
  private View tGq;
  
  public final void cKY()
  {
    AppMethodBeat.i(113710);
    if (this.tGp != null) {
      this.tGp.setVisibility(8);
    }
    if (this.tGq != null) {
      this.tGq.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.tFT.cIS();
    g localg = this.tFT.cIX();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.cGt().SdF != null) && (localb.cGt().SdF.size() > 1))
    {
      if (this.tGp == null) {
        this.tGp = ((ViewStub)findViewById(a.d.tdp)).inflate();
      }
      if (this.tGq != null) {
        this.tGq.setVisibility(8);
      }
      localObject1 = this.tFT.cIV();
      localObject2 = this.tGp;
      localObject3 = this.tFT.cIW();
      LinkedList localLinkedList = localb.cGt().SdF;
      int j = l.arR(localb.cGs().lmL);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label376:
      while (localIterator.hasNext())
      {
        Object localObject4 = (acg)localIterator.next();
        View localView = ad.kS((Context)localObject1).inflate(a.e.tja, (ViewGroup)localObject2, false);
        localView.setId(a.d.tdq);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((acg)localObject4).url)) && (Util.isNullOrNil(((acg)localObject4).SfB))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(a.d.tgz)).setText(((acg)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(a.d.tgw);
        localTextView.setText(((acg)localObject4).tnY);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label376;
          }
          localObject4 = ad.kS((Context)localObject1).inflate(a.e.tjb, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.cFY()) && (localb.cGt().SdM != null) && (!TextUtils.isEmpty(localb.cGt().SdM.title))) {
        this.tGp.setBackgroundResource(a.c.mm_trans);
      }
      if ((!localb.cFY()) && (localg.cKn()))
      {
        this.tGp.setBackgroundResource(a.c.mm_trans);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.cGt().SdF != null) && (localb.cGt().SdF.size() == 1))
    {
      if (this.tGq == null) {
        this.tGq = ((ViewStub)findViewById(a.d.tdo)).inflate();
      }
      if (this.tGp != null) {
        this.tGp.setVisibility(8);
      }
      localObject1 = this.tGq;
      localObject2 = this.tFT.cIW();
      localObject3 = localb.cGt().SdF;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(a.d.tdr).setVisibility(0);
        localObject3 = (acg)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(a.d.tgA)).setText(((acg)localObject3).title);
        ((TextView)((View)localObject1).findViewById(a.d.tgx)).setText(((acg)localObject3).tnY);
        i = l.arR(localb.cGs().lmL);
        ((TextView)((View)localObject1).findViewById(a.d.tgx)).setTextColor(i);
        ((View)localObject1).findViewById(a.d.tdr).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((acg)localObject3).url)) {
          ((View)localObject1).findViewById(a.d.tdr).setEnabled(false);
        }
      }
      if ((localb.cFY()) && (localb.cGt().SdM != null) && (!TextUtils.isEmpty(localb.cGt().SdM.title))) {
        this.tGq.setBackgroundResource(a.c.mm_trans);
      }
      if ((!localb.cFY()) && (localg.cKn()))
      {
        this.tGq.setBackgroundResource(a.c.mm_trans);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.tGp != null) {
        this.tGp.setVisibility(8);
      }
      if (this.tGq != null) {
        this.tGq.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */