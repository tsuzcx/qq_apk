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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class w
  extends i
{
  private View olC;
  private View olD;
  
  public final void bTM()
  {
    AppMethodBeat.i(113710);
    if (this.olC != null) {
      this.olC.setVisibility(8);
    }
    if (this.olD != null) {
      this.olD.setVisibility(8);
    }
    AppMethodBeat.o(113710);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113709);
    b localb = this.olg.bRG();
    g localg = this.olg.bRL();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    if ((localb.bPj().Eig != null) && (localb.bPj().Eig.size() > 1))
    {
      if (this.olC == null) {
        this.olC = ((ViewStub)findViewById(2131297890)).inflate();
      }
      if (this.olD != null) {
        this.olD.setVisibility(8);
      }
      localObject1 = this.olg.bRJ();
      localObject2 = this.olC;
      localObject3 = this.olg.bRK();
      LinkedList localLinkedList = localb.bPj().Eig;
      int j = l.Vy(localb.bPi().hiu);
      ((ViewGroup)localObject2).removeAllViews();
      Iterator localIterator = localLinkedList.iterator();
      label370:
      while (localIterator.hasNext())
      {
        Object localObject4 = (yg)localIterator.next();
        View localView = z.jD((Context)localObject1).inflate(2131493335, (ViewGroup)localObject2, false);
        localView.setId(2131297891);
        localView.setTag(Integer.valueOf(localLinkedList.indexOf(localObject4)));
        localView.setOnClickListener((View.OnClickListener)localObject3);
        if ((TextUtils.isEmpty(((yg)localObject4).url)) && (bs.isNullOrNil(((yg)localObject4).Ekb))) {
          localView.setEnabled(false);
        }
        ((TextView)localView.findViewById(2131304465)).setText(((yg)localObject4).title);
        TextView localTextView = (TextView)localView.findViewById(2131304462);
        localTextView.setText(((yg)localObject4).nUs);
        localTextView.setTextColor(j);
        ((ViewGroup)localObject2).addView(localView);
        if (localLinkedList.indexOf(localObject4) + 1 != localLinkedList.size()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label370;
          }
          localObject4 = z.jD((Context)localObject1).inflate(2131493336, (ViewGroup)localObject2, false);
          ((ViewGroup)localObject2).addView((View)localObject4);
          break;
        }
      }
      if ((localb.bOP()) && (localb.bPj().Ein != null) && (!TextUtils.isEmpty(localb.bPj().Ein.title))) {
        this.olC.setBackgroundResource(2131233299);
      }
      if ((!localb.bOP()) && (localg.bTa()))
      {
        this.olC.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else if ((localb.bPj().Eig != null) && (localb.bPj().Eig.size() == 1))
    {
      if (this.olD == null) {
        this.olD = ((ViewStub)findViewById(2131297889)).inflate();
      }
      if (this.olC != null) {
        this.olC.setVisibility(8);
      }
      localObject1 = this.olD;
      localObject2 = this.olg.bRK();
      localObject3 = localb.bPj().Eig;
      if (((LinkedList)localObject3).size() == 1)
      {
        ((View)localObject1).findViewById(2131297892).setVisibility(0);
        localObject3 = (yg)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(((yg)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(((yg)localObject3).nUs);
        i = l.Vy(localb.bPi().hiu);
        ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(i);
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        if (TextUtils.isEmpty(((yg)localObject3).url)) {
          ((View)localObject1).findViewById(2131297892).setEnabled(false);
        }
      }
      if ((localb.bOP()) && (localb.bPj().Ein != null) && (!TextUtils.isEmpty(localb.bPj().Ein.title))) {
        this.olD.setBackgroundResource(2131233299);
      }
      if ((!localb.bOP()) && (localg.bTa()))
      {
        this.olD.setBackgroundResource(2131233299);
        AppMethodBeat.o(113709);
      }
    }
    else
    {
      if (this.olC != null) {
        this.olC.setVisibility(8);
      }
      if (this.olD != null) {
        this.olD.setVisibility(8);
      }
    }
    AppMethodBeat.o(113709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.w
 * JD-Core Version:    0.7.0.1
 */