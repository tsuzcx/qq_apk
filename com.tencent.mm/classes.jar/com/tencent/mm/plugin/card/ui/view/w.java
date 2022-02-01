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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View wJO;
  private View wJP;
  
  public final void doE()
  {
    AppMethodBeat.i(113710);
    if (this.wJO != null) {
      this.wJO.setVisibility(8);
    }
    if (this.wJP != null) {
      this.wJP.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.wJs.dmk();
    g localg = this.wJs.dmp();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.djL().Zbz != null) && (localb.djL().Zbz.size() > 1))
    {
      if (this.wJO == null) {
        this.wJO = ((ViewStub)findViewById(a.d.whD)).inflate();
      }
      if (this.wJP != null) {
        this.wJP.setVisibility(8);
      }
      localObject1 = this.wJs.dmn();
      localObject2 = this.wJO;
      localObject3 = this.wJs.dmo();
      LinkedList localLinkedList = localb.djL().Zbz;
      int j = l.alv(localb.djK().nRQ);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label376:
      while (localIterator.hasNext())
      {
        Object localObject4 = (aek)localIterator.next();
        View localView = af.mU((Context)localObject1).inflate(a.e.wnx, (ViewGroup)localObject2, false);
        localView.setId(a.d.whE);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((aek)localObject4).url)) && (Util.isNullOrNil(((aek)localObject4).Zdw))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(a.d.wkY)).setText(((aek)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(a.d.wkV);
        localTextView.setText(((aek)localObject4).wsz);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label376;
          }
          localObject4 = af.mU((Context)localObject1).inflate(a.e.wny, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.djq()) && (localb.djL().ZbG != null) && (!TextUtils.isEmpty(localb.djL().ZbG.title))) {
        this.wJO.setBackgroundResource(a.c.mm_trans);
      }
      if ((!localb.djq()) && (localg.dnD()))
      {
        this.wJO.setBackgroundResource(a.c.mm_trans);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.djL().Zbz != null) && (localb.djL().Zbz.size() == 1))
    {
      if (this.wJP == null) {
        this.wJP = ((ViewStub)findViewById(a.d.whC)).inflate();
      }
      if (this.wJO != null) {
        this.wJO.setVisibility(8);
      }
      localObject1 = this.wJP;
      localObject2 = this.wJs.dmo();
      localObject3 = localb.djL().Zbz;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(a.d.whF).setVisibility(0);
        localObject3 = (aek)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(a.d.wkZ)).setText(((aek)localObject3).title);
        ((TextView)((View)localObject1).findViewById(a.d.wkW)).setText(((aek)localObject3).wsz);
        i = l.alv(localb.djK().nRQ);
        ((TextView)((View)localObject1).findViewById(a.d.wkW)).setTextColor(i);
        ((View)localObject1).findViewById(a.d.whF).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((aek)localObject3).url)) {
          ((View)localObject1).findViewById(a.d.whF).setEnabled(false);
        }
      }
      if ((localb.djq()) && (localb.djL().ZbG != null) && (!TextUtils.isEmpty(localb.djL().ZbG.title))) {
        this.wJP.setBackgroundResource(a.c.mm_trans);
      }
      if ((!localb.djq()) && (localg.dnD()))
      {
        this.wJP.setBackgroundResource(a.c.mm_trans);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.wJO != null) {
        this.wJO.setVisibility(8);
      }
      if (this.wJP != null) {
        this.wJP.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */