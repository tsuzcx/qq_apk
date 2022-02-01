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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View oOX;
  private View oOY;
  
  public final void bYr()
  {
    AppMethodBeat.i(113710);
    if (this.oOX != null) {
      this.oOX.setVisibility(8);
    }
    if (this.oOY != null) {
      this.oOY.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.oOB.bWl();
    g localg = this.oOB.bWq();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.bTO().FPq != null) && (localb.bTO().FPq.size() > 1))
    {
      if (this.oOX == null) {
        this.oOX = ((ViewStub)findViewById(2131297890)).inflate();
      }
      if (this.oOY != null) {
        this.oOY.setVisibility(8);
      }
      localObject1 = this.oOB.bWo();
      localObject2 = this.oOX;
      localObject3 = this.oOB.bWp();
      LinkedList localLinkedList = localb.bTO().FPq;
      int j = l.Zh(localb.bTN().hAD);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label370:
      while (localIterator.hasNext())
      {
        Object localObject4 = (aaf)localIterator.next();
        View localView = z.jO((Context)localObject1).inflate(2131493335, (ViewGroup)localObject2, false);
        localView.setId(2131297891);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((aaf)localObject4).url)) && (bt.isNullOrNil(((aaf)localObject4).FRk))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131304465)).setText(((aaf)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131304462);
        localTextView.setText(((aaf)localObject4).oxN);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label370;
          }
          localObject4 = z.jO((Context)localObject1).inflate(2131493336, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.bTu()) && (localb.bTO().FPx != null) && (!TextUtils.isEmpty(localb.bTO().FPx.title))) {
        this.oOX.setBackgroundResource(2131233299);
      }
      if ((!localb.bTu()) && (localg.bXF()))
      {
        this.oOX.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.bTO().FPq != null) && (localb.bTO().FPq.size() == 1))
    {
      if (this.oOY == null) {
        this.oOY = ((ViewStub)findViewById(2131297889)).inflate();
      }
      if (this.oOX != null) {
        this.oOX.setVisibility(8);
      }
      localObject1 = this.oOY;
      localObject2 = this.oOB.bWp();
      localObject3 = localb.bTO().FPq;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131297892).setVisibility(0);
        localObject3 = (aaf)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(((aaf)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(((aaf)localObject3).oxN);
        i = l.Zh(localb.bTN().hAD);
        ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(i);
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((aaf)localObject3).url)) {
          ((View)localObject1).findViewById(2131297892).setEnabled(false);
        }
      }
      if ((localb.bTu()) && (localb.bTO().FPx != null) && (!TextUtils.isEmpty(localb.bTO().FPx.title))) {
        this.oOY.setBackgroundResource(2131233299);
      }
      if ((!localb.bTu()) && (localg.bXF()))
      {
        this.oOY.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.oOX != null) {
        this.oOX.setVisibility(8);
      }
      if (this.oOY != null) {
        this.oOY.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */