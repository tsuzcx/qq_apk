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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View qkt;
  private View qku;
  
  public final void cxw()
  {
    AppMethodBeat.i(113710);
    if (this.qkt != null) {
      this.qkt.setVisibility(8);
    }
    if (this.qku != null) {
      this.qku.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.qjX.cvq();
    g localg = this.qjX.cvv();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.csR().Lcs != null) && (localb.csR().Lcs.size() > 1))
    {
      if (this.qkt == null) {
        this.qkt = ((ViewStub)findViewById(2131298208)).inflate();
      }
      if (this.qku != null) {
        this.qku.setVisibility(8);
      }
      localObject1 = this.qjX.cvt();
      localObject2 = this.qkt;
      localObject3 = this.qjX.cvu();
      LinkedList localLinkedList = localb.csR().Lcs;
      int j = l.ake(localb.csQ().ixw);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label370:
      while (localIterator.hasNext())
      {
        Object localObject4 = (abz)localIterator.next();
        View localView = aa.jQ((Context)localObject1).inflate(2131493426, (ViewGroup)localObject2, false);
        localView.setId(2131298209);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((abz)localObject4).url)) && (Util.isNullOrNil(((abz)localObject4).Leo))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131307443)).setText(((abz)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131307440);
        localTextView.setText(((abz)localObject4).pRY);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label370;
          }
          localObject4 = aa.jQ((Context)localObject1).inflate(2131493427, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.csx()) && (localb.csR().Lcz != null) && (!TextUtils.isEmpty(localb.csR().Lcz.title))) {
        this.qkt.setBackgroundResource(2131233974);
      }
      if ((!localb.csx()) && (localg.cwK()))
      {
        this.qkt.setBackgroundResource(2131233974);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.csR().Lcs != null) && (localb.csR().Lcs.size() == 1))
    {
      if (this.qku == null) {
        this.qku = ((ViewStub)findViewById(2131298207)).inflate();
      }
      if (this.qkt != null) {
        this.qkt.setVisibility(8);
      }
      localObject1 = this.qku;
      localObject2 = this.qjX.cvu();
      localObject3 = localb.csR().Lcs;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131298210).setVisibility(0);
        localObject3 = (abz)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131307444)).setText(((abz)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131307441)).setText(((abz)localObject3).pRY);
        i = l.ake(localb.csQ().ixw);
        ((TextView)((View)localObject1).findViewById(2131307441)).setTextColor(i);
        ((View)localObject1).findViewById(2131298210).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((abz)localObject3).url)) {
          ((View)localObject1).findViewById(2131298210).setEnabled(false);
        }
      }
      if ((localb.csx()) && (localb.csR().Lcz != null) && (!TextUtils.isEmpty(localb.csR().Lcz.title))) {
        this.qku.setBackgroundResource(2131233974);
      }
      if ((!localb.csx()) && (localg.cwK()))
      {
        this.qku.setBackgroundResource(2131233974);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.qkt != null) {
        this.qkt.setVisibility(8);
      }
      if (this.qku != null) {
        this.qku.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */