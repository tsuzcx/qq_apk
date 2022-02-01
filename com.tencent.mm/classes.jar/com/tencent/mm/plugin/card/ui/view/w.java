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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View oVA;
  private View oVz;
  
  public final void bZG()
  {
    AppMethodBeat.i(113710);
    if (this.oVz != null) {
      this.oVz.setVisibility(8);
    }
    if (this.oVA != null) {
      this.oVA.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.oVd.bXA();
    g localg = this.oVd.bXF();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.bVd().GhP != null) && (localb.bVd().GhP.size() > 1))
    {
      if (this.oVz == null) {
        this.oVz = ((ViewStub)findViewById(2131297890)).inflate();
      }
      if (this.oVA != null) {
        this.oVA.setVisibility(8);
      }
      localObject1 = this.oVd.bXD();
      localObject2 = this.oVz;
      localObject3 = this.oVd.bXE();
      LinkedList localLinkedList = localb.bVd().GhP;
      int j = l.ZY(localb.bVc().hDr);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label370:
      while (localIterator.hasNext())
      {
        Object localObject4 = (aai)localIterator.next();
        View localView = z.jV((Context)localObject1).inflate(2131493335, (ViewGroup)localObject2, false);
        localView.setId(2131297891);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((aai)localObject4).url)) && (bu.isNullOrNil(((aai)localObject4).GjJ))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131304465)).setText(((aai)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131304462);
        localTextView.setText(((aai)localObject4).oEp);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label370;
          }
          localObject4 = z.jV((Context)localObject1).inflate(2131493336, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.bUJ()) && (localb.bVd().GhW != null) && (!TextUtils.isEmpty(localb.bVd().GhW.title))) {
        this.oVz.setBackgroundResource(2131233299);
      }
      if ((!localb.bUJ()) && (localg.bYU()))
      {
        this.oVz.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.bVd().GhP != null) && (localb.bVd().GhP.size() == 1))
    {
      if (this.oVA == null) {
        this.oVA = ((ViewStub)findViewById(2131297889)).inflate();
      }
      if (this.oVz != null) {
        this.oVz.setVisibility(8);
      }
      localObject1 = this.oVA;
      localObject2 = this.oVd.bXE();
      localObject3 = localb.bVd().GhP;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131297892).setVisibility(0);
        localObject3 = (aai)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(((aai)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(((aai)localObject3).oEp);
        i = l.ZY(localb.bVc().hDr);
        ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(i);
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((aai)localObject3).url)) {
          ((View)localObject1).findViewById(2131297892).setEnabled(false);
        }
      }
      if ((localb.bUJ()) && (localb.bVd().GhW != null) && (!TextUtils.isEmpty(localb.bVd().GhW.title))) {
        this.oVA.setBackgroundResource(2131233299);
      }
      if ((!localb.bUJ()) && (localg.bYU()))
      {
        this.oVA.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.oVz != null) {
        this.oVz.setVisibility(8);
      }
      if (this.oVA != null) {
        this.oVA.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */