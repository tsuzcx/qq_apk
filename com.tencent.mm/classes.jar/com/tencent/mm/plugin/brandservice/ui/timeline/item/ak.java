package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak
  extends aj
{
  public LinearLayout pwA;
  public LinearLayout pwz;
  public LinearLayout pxI;
  public LinearLayout pxJ;
  public TextView pxK;
  public List<ah> pxL;
  public ar pxM;
  public at pxN;
  public ap pxO;
  public aq pxP;
  public au pxQ;
  public ao pxR;
  public as pxS;
  private View.OnClickListener pxT;
  
  public ak()
  {
    AppMethodBeat.i(6030);
    this.pxL = new ArrayList();
    this.pxM = new ar();
    this.pxN = new at();
    this.pxO = new ap();
    this.pxP = new aq();
    this.pxQ = new au();
    this.pxR = new ao();
    this.pxS = new as();
    this.pxT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (z)paramAnonymousView.getTag();
        paramAnonymousView.field_isExpand = true;
        paramAnonymousView.field_status = 4;
        paramAnonymousView.field_isRead = 1;
        paramAnonymousView.field_hasShow = 1;
        ag.ban().C(paramAnonymousView);
        com.tencent.mm.plugin.brandservice.ui.timeline.b.cB(ak.this.pxE.nZr);
        ak.this.pxE.pqZ.f(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(6028);
      }
    };
    AppMethodBeat.o(6030);
  }
  
  private static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(6034);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6034);
  }
  
  private void a(View paramView, ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(6031);
    if (paramBoolean)
    {
      if (paramai.puO == null) {
        paramai.a(paramView, this.pxE);
      }
      if (paramai.puO != null)
      {
        paramai.puO.setVisibility(0);
        AppMethodBeat.o(6031);
      }
    }
    else if (paramai.puO != null)
    {
      paramai.puO.setVisibility(8);
    }
    AppMethodBeat.o(6031);
  }
  
  private void a(ak paramak, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6032);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramak.pxI, paramak.pxN, bool1);
      if (!bool1) {
        break label247;
      }
    }
    label48:
    label79:
    label110:
    label244:
    label247:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(paramak.pxI, paramak.pxP, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramak.pxI, paramak.pxQ, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramak.pxI, paramak.pxR, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramak.pxI, paramak.pxS, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramak.pxI;
        paramak = paramak.pxM;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramak, bool1);
          AppMethodBeat.o(6032);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label48;
          bool1 = false;
          break label79;
          bool1 = false;
          break label110;
          bool1 = false;
          break label141;
        }
      }
    }
  }
  
  private static void c(v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  private static void s(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6033);
    paramView.setPadding(0, paramInt1 - com.tencent.mm.plugin.brandservice.ui.timeline.b.prB, 0, paramInt2 - com.tencent.mm.plugin.brandservice.ui.timeline.b.prB);
    AppMethodBeat.o(6033);
  }
  
  public final View a(final z paramz, int paramInt, View paramView)
  {
    AppMethodBeat.i(194972);
    Object localObject1 = this.pxL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ah)((Iterator)localObject1).next();
      com.tencent.mm.ui.chatting.aq.aH(((ah)localObject2).puO, 3);
      this.pxI.removeView(((ah)localObject2).puO);
    }
    this.pxL.clear();
    Object localObject2 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramz.field_msgId, paramz.field_content);
    LinkedList localLinkedList = ((u)localObject2).iAd;
    int k = localLinkedList.size();
    if (k == 0)
    {
      this.pxI.setVisibility(8);
      a(this, -1, 0);
      AppMethodBeat.o(194972);
      return paramView;
    }
    this.pxI.setVisibility(0);
    v localv = (v)localLinkedList.get(0);
    c(localv);
    boolean bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramz, localv);
    if (bool1) {
      if ((Util.isNullOrNil(localv.iAo)) && (localv.type != 7) && (localv.type != 10)) {
        bool1 = false;
      }
    }
    label1171:
    label1428:
    label1434:
    label1441:
    label2209:
    label2215:
    label2229:
    for (;;)
    {
      a(this, -1, k);
      paramz.NQj = bool1;
      Object localObject3 = ((Activity)this.mContext).getLayoutInflater();
      final int i = this.pxL.size();
      label248:
      if (i < k)
      {
        localObject1 = com.tencent.mm.ui.chatting.aq.ams(3);
        if (localObject1 != null) {
          break label2262;
        }
        localObject1 = ((LayoutInflater)localObject3).inflate(2131493259, null);
      }
      label824:
      label1098:
      label2262:
      for (;;)
      {
        Object localObject5 = this.pxE;
        Object localObject6 = this.mContext;
        Object localObject4 = this.pxI;
        localObject5 = new ah((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject5, (Context)localObject6);
        ((ah)localObject5).puO = ((View)localObject1);
        ((ah)localObject5).jBI = ((View)localObject1).findViewById(2131309322);
        ((ah)localObject5).pxo = ((View)localObject1).findViewById(2131299208);
        ((ah)localObject5).pxp = ((MMNeat7extView)((View)localObject1).findViewById(2131309237));
        localObject6 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.crj())
        {
          localObject6 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
          com.tencent.mm.plugin.brandservice.ui.b.d.c(((ah)localObject5).pxp);
        }
        ((ah)localObject5).pxq = ((TextView)((View)localObject1).findViewById(2131308767));
        ((ah)localObject5).pxr = ((View)localObject1).findViewById(2131299279);
        ((ah)localObject5).ptE = ((ImageView)((View)localObject1).findViewById(2131299289));
        ((ah)localObject5).pxu = ((ImageView)((View)localObject1).findViewById(2131305957));
        ((ah)localObject5).pxs = ((View)localObject1).findViewById(2131297533);
        ((ah)localObject5).pxt = ((ImageView)((View)localObject1).findViewById(2131297588));
        ((ah)localObject5).ptX = ((View)localObject1).findViewById(2131308374);
        ((ah)localObject5).ptY = ((TextView)((View)localObject1).findViewById(2131301796));
        ((ah)localObject5).pxv = ((View)localObject1).findViewById(2131305926);
        ((ah)localObject5).pxw = ((View)localObject1).findViewById(2131305925);
        ((ah)localObject5).puD = ((TextView)((View)localObject1).findViewById(2131305934));
        ((ViewGroup)localObject4).addView((View)localObject1, ((ViewGroup)localObject4).getChildCount());
        this.pxL.add(localObject5);
        i += 1;
        break label248;
        a(this, ((v)localLinkedList.get(0)).type, k);
        break;
        i = 0;
        while (i < this.pxL.size())
        {
          ((ah)this.pxL.get(i)).puO.setVisibility(8);
          i += 1;
        }
        label751:
        label759:
        int m;
        int j;
        label860:
        label890:
        boolean bool2;
        if (bool1)
        {
          if (localv.type == 5) {
            this.pxN.a(k, localv, paramz, paramInt, (u)localObject2, paramz.pxD);
          }
        }
        else
        {
          if ((k <= 2) || (paramz.field_isExpand)) {
            break label1416;
          }
          this.pxJ.setVisibility(0);
          this.pxK.setText(this.mContext.getString(2131756789, new Object[] { Integer.valueOf(k - 2) }));
          this.pxJ.setTag(paramz);
          this.pxJ.setOnClickListener(this.pxT);
          if (!bool1) {
            break label1428;
          }
          i = 1;
          if ((i >= k) || ((!paramz.field_isExpand) && (i > 1))) {
            break label2229;
          }
          localObject3 = (v)localLinkedList.get(i);
          m = paramz.pxD + i;
          c((v)localObject3);
          localObject1 = this.pxL;
          if (!bool1) {
            break label1434;
          }
          j = i - 1;
          localObject4 = (ah)((List)localObject1).get(j);
          j = localv.type;
          if (i != 0) {
            break label1441;
          }
          ((ah)localObject4).jBI.setVisibility(8);
          if (bool1) {
            break label1783;
          }
          if (i != 0) {
            break label1680;
          }
          if (k != 1) {
            break label1656;
          }
          s(((ah)localObject4).pxo, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, com.tencent.mm.plugin.brandservice.ui.timeline.b.prv);
          ((ah)localObject4).a((v)localObject3, paramz, i, false);
          ((ah)localObject4).a((v)localObject3, false);
          ((ah)localObject4).a(((ah)localObject4).ptX, ((ah)localObject4).ptY, paramz, (v)localObject3);
          if (!Util.isNullOrNil(((v)localObject3).title)) {
            break label1943;
          }
          localObject5 = com.tencent.mm.plugin.brandservice.b.a.pmT;
          switch (((v)localObject3).type)
          {
          case 6: 
          default: 
            localObject1 = this.mContext.getResources().getString(2131756755);
            label995:
            ((com.tencent.mm.plugin.brandservice.b.a)localObject5).a((String)localObject1, ((ah)localObject4).pxp, (v)localObject3, 1);
            label1010:
            ((ah)localObject4).pxp.setTextColor(this.mContext.getResources().getColor(2131099746));
            if ((((v)localObject3).iAr == 0) || (((v)localObject3).iAr == 1))
            {
              ((ah)localObject4).pxr.setVisibility(0);
              ((ah)localObject4).pxp.setTextColor(this.mContext.getResources().getColor(2131099746));
              if (((v)localObject3).type == 7)
              {
                ((ah)localObject4).ptE.setVisibility(8);
                if ((Util.isNullOrNil(((v)localObject3).iAq)) || (((v)localObject3).type != 3)) {
                  break label2196;
                }
                ((ah)localObject4).pxq.setText(((v)localObject3).iAq);
                ((ah)localObject4).pxq.setVisibility(0);
                label1140:
                ((ah)localObject4).puO.setVisibility(0);
                localObject1 = this.pxE;
                localObject5 = ((ah)localObject4).puO;
                if (k <= 1) {
                  break label2209;
                }
                bool2 = true;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a((v)localObject3, paramz, paramInt, (u)localObject2, (View)localObject5, bool2, i);
                if ((i != k - 1) || (this.pxJ.getVisibility() == 0)) {
                  break label2215;
                }
                ((ah)localObject4).puO.setBackgroundResource(2131231316);
              }
            }
            break;
          }
        }
        for (;;)
        {
          if (((v)localObject3).type == 5)
          {
            localObject1 = e.pAN;
            e.F(((v)localObject3).url, ((v)localObject3).type, "");
          }
          i += 1;
          break label759;
          if (localv.type == 8)
          {
            this.pxP.a(k, localv, paramz, paramInt, (u)localObject2, paramz.pxD);
            break;
          }
          if (localv.type == 7)
          {
            this.pxQ.a(k, localv, paramz, paramInt, (u)localObject2, paramz.pxD);
            break;
          }
          if (localv.type == 6)
          {
            this.pxR.a(k, (v)localLinkedList.get(0), paramz, paramInt, (u)localObject2, paramz.pxD);
            break;
          }
          if (localv.type == 10)
          {
            this.pxS.a(k, localv, paramz, paramInt, (u)localObject2, paramz.pxD);
            break;
          }
          this.pxM.a(k, localv, paramz, paramInt, (u)localObject2, paramz.pxD);
          break;
          this.pxJ.setVisibility(8);
          break label751;
          i = 0;
          break label759;
          j = i;
          break label824;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((ah)localObject4).jBI.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              localObject1 = (v)localLinkedList.get(i - 1);
              localObject5 = (v)localLinkedList.get(i);
              if (((((v)localObject1).type != 7) && (((v)localObject1).type != 5) && (((v)localObject1).type != 6) && (Util.isNullOrNil(((v)localObject1).iAo))) || ((((v)localObject5).type != 7) && (((v)localObject5).type != 5) && (((v)localObject5).type != 6) && (Util.isNullOrNil(((v)localObject5).iAo))))
              {
                X(((ah)localObject4).jBI, com.tencent.mm.plugin.brandservice.ui.timeline.b.prA);
                break;
                ((ah)localObject4).jBI.setVisibility(0);
                continue;
              }
              X(((ah)localObject4).jBI, com.tencent.mm.plugin.brandservice.ui.timeline.b.prz);
              break;
            }
          }
          X(((ah)localObject4).jBI, com.tencent.mm.plugin.brandservice.ui.timeline.b.prA);
          break label860;
          label1656:
          localObject1 = ((ah)localObject4).pxo;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pry;
          s((View)localObject1, j, j);
          break label890;
          if (i == 1)
          {
            if (k == 2)
            {
              s(((ah)localObject4).pxo, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, com.tencent.mm.plugin.brandservice.ui.timeline.b.prv);
              break label890;
            }
            localObject1 = ((ah)localObject4).pxo;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pry;
            s((View)localObject1, j, j);
            break label890;
          }
          if (i == k - 1)
          {
            s(((ah)localObject4).pxo, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, com.tencent.mm.plugin.brandservice.ui.timeline.b.prv);
            break label890;
          }
          localObject1 = ((ah)localObject4).pxo;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pry;
          s((View)localObject1, j, j);
          break label890;
          label1783:
          if (i == 1)
          {
            if (i == k - 1)
            {
              localObject1 = ((ah)localObject4).pxo;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.prv;
              s((View)localObject1, j, j);
              break label890;
            }
            s(((ah)localObject4).pxo, com.tencent.mm.plugin.brandservice.ui.timeline.b.prv, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry);
            break label890;
          }
          if (i == k - 1)
          {
            s(((ah)localObject4).pxo, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, com.tencent.mm.plugin.brandservice.ui.timeline.b.prv);
            break label890;
          }
          localObject1 = ((ah)localObject4).pxo;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pry;
          s((View)localObject1, j, j);
          break label890;
          localObject1 = this.mContext.getResources().getString(2131756771);
          break label995;
          localObject1 = this.mContext.getResources().getString(2131756772);
          break label995;
          localObject1 = this.mContext.getResources().getString(2131756756);
          break label995;
          com.tencent.mm.plugin.brandservice.b.a.pmT.a(((v)localObject3).title, ((ah)localObject4).pxp, (v)localObject3, 1);
          break label1010;
          if (!Util.isNullOrNil(((v)localObject3).iAo))
          {
            ((ah)localObject4).ptE.setVisibility(0);
            if (Util.isNullOrNil(((v)localObject3).iAD)) {}
            for (localObject1 = ((v)localObject3).iAo;; localObject1 = ((v)localObject3).iAD)
            {
              localObject5 = this.pxE.prc;
              long l = paramz.field_msgId;
              localObject6 = ((ah)localObject4).ptE;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject5).a(l, i, (v)localObject3, (String)localObject1, (ImageView)localObject6, j, j, false, new m.a()
              {
                public final void onFinish()
                {
                  AppMethodBeat.i(6029);
                  this.pxV.a(this.pxW, paramz, i, true);
                  this.pxV.a(this.pxW, true);
                  ak.this.pxE.prc.m(paramz.field_msgId, i);
                  AppMethodBeat.o(6029);
                }
                
                public final void onStart() {}
              }, m, 2.0F);
              break;
            }
          }
          if ((((v)localObject3).type == 5) || (((v)localObject3).type == 6))
          {
            ((ah)localObject4).ptE.setVisibility(0);
            localObject1 = this.pxE.prc;
            localObject5 = ((ah)localObject4).ptE;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
            ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject1).a("2131231740", (ImageView)localObject5, j, j, m);
            break label1098;
          }
          ((ah)localObject4).pxr.setVisibility(8);
          break label1098;
          ((ah)localObject4).pxr.setVisibility(8);
          ((ah)localObject4).pxp.setTextColor(this.mContext.getResources().getColor(2131099749));
          break label1098;
          ((ah)localObject4).pxq.setVisibility(8);
          break label1140;
          bool2 = false;
          break label1171;
          ((ah)localObject4).puO.setBackgroundResource(2131231322);
        }
        this.pxE.a(paramInt, paramz, this.pwA, this.pwz);
        this.pxE.a(this, paramz);
        AppMethodBeat.o(194972);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ak
 * JD-Core Version:    0.7.0.1
 */