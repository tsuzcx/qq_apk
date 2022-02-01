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
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View nIC;
  private View nID;
  
  public final void bMB()
  {
    AppMethodBeat.i(113710);
    if (this.nIC != null) {
      this.nIC.setVisibility(8);
    }
    if (this.nID != null) {
      this.nID.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.nIg.bKt();
    g localg = this.nIg.bKy();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.bHW().CPv != null) && (localb.bHW().CPv.size() > 1))
    {
      if (this.nIC == null) {
        this.nIC = ((ViewStub)findViewById(2131297890)).inflate();
      }
      if (this.nID != null) {
        this.nID.setVisibility(8);
      }
      localObject1 = this.nIg.bKw();
      localObject2 = this.nIC;
      localObject3 = this.nIg.bKx();
      LinkedList localLinkedList = localb.bHW().CPv;
      int j = l.Rm(localb.bHV().gHT);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label370:
      while (localIterator.hasNext())
      {
        Object localObject4 = (xo)localIterator.next();
        View localView = y.js((Context)localObject1).inflate(2131493335, (ViewGroup)localObject2, false);
        localView.setId(2131297891);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((xo)localObject4).url)) && (bt.isNullOrNil(((xo)localObject4).CRq))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131304465)).setText(((xo)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131304462);
        localTextView.setText(((xo)localObject4).nrs);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label370;
          }
          localObject4 = y.js((Context)localObject1).inflate(2131493336, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.bHC()) && (localb.bHW().CPC != null) && (!TextUtils.isEmpty(localb.bHW().CPC.title))) {
        this.nIC.setBackgroundResource(2131233299);
      }
      if ((!localb.bHC()) && (localg.bLN()))
      {
        this.nIC.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.bHW().CPv != null) && (localb.bHW().CPv.size() == 1))
    {
      if (this.nID == null) {
        this.nID = ((ViewStub)findViewById(2131297889)).inflate();
      }
      if (this.nIC != null) {
        this.nIC.setVisibility(8);
      }
      localObject1 = this.nID;
      localObject2 = this.nIg.bKx();
      localObject3 = localb.bHW().CPv;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131297892).setVisibility(0);
        localObject3 = (xo)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(((xo)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(((xo)localObject3).nrs);
        i = l.Rm(localb.bHV().gHT);
        ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(i);
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((xo)localObject3).url)) {
          ((View)localObject1).findViewById(2131297892).setEnabled(false);
        }
      }
      if ((localb.bHC()) && (localb.bHW().CPC != null) && (!TextUtils.isEmpty(localb.bHW().CPC.title))) {
        this.nID.setBackgroundResource(2131233299);
      }
      if ((!localb.bHC()) && (localg.bLN()))
      {
        this.nID.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.nIC != null) {
        this.nIC.setVisibility(8);
      }
      if (this.nID != null) {
        this.nID.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */