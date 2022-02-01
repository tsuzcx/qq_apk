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
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
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

public final class am
  extends al
{
  public LinearLayout sFV;
  public LinearLayout sFW;
  public LinearLayout sHk;
  public LinearLayout sHl;
  public TextView sHm;
  public List<aj> sHn;
  public at sHo;
  public av sHp;
  public ar sHq;
  public as sHr;
  public aw sHs;
  public aq sHt;
  public au sHu;
  private View.OnClickListener sHv;
  
  public am()
  {
    AppMethodBeat.i(6030);
    this.sHn = new ArrayList();
    this.sHo = new at();
    this.sHp = new av();
    this.sHq = new ar();
    this.sHr = new as();
    this.sHs = new aw();
    this.sHt = new aq();
    this.sHu = new au();
    this.sHv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (z)paramAnonymousView.getTag();
        paramAnonymousView.field_isExpand = true;
        paramAnonymousView.field_status = 4;
        paramAnonymousView.field_isRead = 1;
        paramAnonymousView.field_hasShow = 1;
        af.bjB().G(paramAnonymousView);
        com.tencent.mm.plugin.brandservice.ui.timeline.b.cy(am.this.sHf.rbc);
        am.this.sHf.szZ.g(paramAnonymousView, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(6028);
      }
    };
    AppMethodBeat.o(6030);
  }
  
  private static void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(6034);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6034);
  }
  
  private void a(View paramView, ak paramak, boolean paramBoolean)
  {
    AppMethodBeat.i(6031);
    if (paramBoolean)
    {
      if (paramak.sEi == null) {
        paramak.a(paramView, this.sHf);
      }
      if (paramak.sEi != null)
      {
        paramak.sEi.setVisibility(0);
        AppMethodBeat.o(6031);
      }
    }
    else if (paramak.sEi != null)
    {
      paramak.sEi.setVisibility(8);
    }
    AppMethodBeat.o(6031);
  }
  
  private void a(am paramam, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6032);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramam.sHk, paramam.sHp, bool1);
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
        a(paramam.sHk, paramam.sHr, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramam.sHk, paramam.sHs, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramam.sHk, paramam.sHt, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramam.sHk, paramam.sHu, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramam.sHk;
        paramam = paramam.sHo;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramam, bool1);
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
  
  private static void t(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6033);
    paramView.setPadding(0, paramInt1 - com.tencent.mm.plugin.brandservice.ui.timeline.b.sAz, 0, paramInt2 - com.tencent.mm.plugin.brandservice.ui.timeline.b.sAz);
    AppMethodBeat.o(6033);
  }
  
  public final View a(final z paramz, int paramInt, View paramView)
  {
    AppMethodBeat.i(257706);
    Object localObject1 = this.sHn.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aj)((Iterator)localObject1).next();
      com.tencent.mm.ui.chatting.aq.aM(((aj)localObject2).sEi, 3);
      this.sHk.removeView(((aj)localObject2).sEi);
    }
    this.sHn.clear();
    Object localObject2 = ((com.tencent.mm.plugin.biz.a.a)h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramz.field_msgId, paramz.field_content);
    LinkedList localLinkedList = ((u)localObject2).lpz;
    int k = localLinkedList.size();
    if (k == 0)
    {
      this.sHk.setVisibility(8);
      a(this, -1, 0);
      AppMethodBeat.o(257706);
      return paramView;
    }
    this.sHk.setVisibility(0);
    v localv = (v)localLinkedList.get(0);
    c(localv);
    boolean bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(paramz, localv);
    if (bool1) {
      if ((Util.isNullOrNil(localv.lpK)) && (localv.type != 7) && (localv.type != 10)) {
        bool1 = false;
      }
    }
    label827:
    label1102:
    for (;;)
    {
      a(this, -1, k);
      paramz.Veb = bool1;
      Object localObject3 = ((Activity)this.mContext).getLayoutInflater();
      final int i = this.sHn.size();
      label248:
      if (i < k)
      {
        localObject1 = com.tencent.mm.ui.chatting.aq.avs(3);
        if (localObject1 != null) {
          break label2283;
        }
        localObject1 = ((LayoutInflater)localObject3).inflate(d.f.stN, null);
      }
      label863:
      label999:
      label2283:
      for (;;)
      {
        Object localObject5 = this.sHf;
        Object localObject6 = this.mContext;
        Object localObject4 = this.sHk;
        localObject5 = new aj((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject5, (Context)localObject6);
        ((aj)localObject5).sEi = ((View)localObject1);
        ((aj)localObject5).mrE = ((View)localObject1).findViewById(d.e.top_line);
        ((aj)localObject5).rgA = ((ViewGroup)((View)localObject1).findViewById(d.e.content_ll));
        ((aj)localObject5).sGQ = ((MMNeat7extView)((View)localObject1).findViewById(d.e.stf));
        localObject6 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.cEs())
        {
          localObject6 = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
          com.tencent.mm.plugin.brandservice.ui.b.d.e(((aj)localObject5).sGQ);
        }
        ((aj)localObject5).sGR = ((TextView)((View)localObject1).findViewById(d.e.summary));
        ((aj)localObject5).sGS = ((View)localObject1).findViewById(d.e.cover_area);
        ((aj)localObject5).sCR = ((ImageView)((View)localObject1).findViewById(d.e.cover_iv));
        ((aj)localObject5).sGV = ((ImageView)((View)localObject1).findViewById(d.e.play_icon));
        ((aj)localObject5).sGT = ((View)localObject1).findViewById(d.e.dum);
        ((aj)localObject5).sGU = ((ImageView)((View)localObject1).findViewById(d.e.srt));
        ((aj)localObject5).sDk = ((View)localObject1).findViewById(d.e.sta);
        ((aj)localObject5).sDl = ((TextView)((View)localObject1).findViewById(d.e.srT));
        ((aj)localObject5).sGW = ((View)localObject1).findViewById(d.e.ssl);
        ((aj)localObject5).sGX = ((View)localObject1).findViewById(d.e.ssk);
        ((aj)localObject5).sDY = ((TextView)((View)localObject1).findViewById(d.e.dRg));
        ((ViewGroup)localObject4).addView((View)localObject1, ((ViewGroup)localObject4).getChildCount());
        this.sHn.add(localObject5);
        i += 1;
        break label248;
        a(this, ((v)localLinkedList.get(0)).type, k);
        break;
        i = 0;
        while (i < this.sHn.size())
        {
          ((aj)this.sHn.get(i)).sEi.setVisibility(8);
          i += 1;
        }
        label754:
        label762:
        int m;
        int j;
        label893:
        boolean bool2;
        if (bool1)
        {
          if (localv.type == 5) {
            this.sHp.a(k, localv, paramz, paramInt, (u)localObject2, paramz.sHe);
          }
        }
        else
        {
          if ((k <= 2) || (paramz.field_isExpand)) {
            break label1420;
          }
          this.sHl.setVisibility(0);
          this.sHm.setText(this.mContext.getString(d.i.suX, new Object[] { Integer.valueOf(k - 2) }));
          this.sHl.setTag(paramz);
          this.sHl.setOnClickListener(this.sHv);
          if (!bool1) {
            break label1432;
          }
          i = 1;
          if ((i >= k) || ((!paramz.field_isExpand) && (i > 1))) {
            break label2250;
          }
          localObject3 = (v)localLinkedList.get(i);
          m = paramz.sHe + i;
          c((v)localObject3);
          localObject1 = this.sHn;
          if (!bool1) {
            break label1438;
          }
          j = i - 1;
          localObject4 = (aj)((List)localObject1).get(j);
          j = localv.type;
          if (i != 0) {
            break label1445;
          }
          ((aj)localObject4).mrE.setVisibility(8);
          if (bool1) {
            break label1787;
          }
          if (i != 0) {
            break label1684;
          }
          if (k != 1) {
            break label1660;
          }
          t(((aj)localObject4).rgA, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt);
          ((aj)localObject4).a((v)localObject3, paramz, i, false);
          ((aj)localObject4).a((v)localObject3, false);
          ((aj)localObject4).a(((aj)localObject4).sDk, ((aj)localObject4).sDl, paramz, (v)localObject3);
          if (!Util.isNullOrNil(((v)localObject3).title)) {
            break label1947;
          }
          localObject5 = com.tencent.mm.plugin.brandservice.b.b.svR;
          switch (((v)localObject3).type)
          {
          case 6: 
          default: 
            localObject1 = this.mContext.getResources().getString(d.i.suF);
            ((com.tencent.mm.plugin.brandservice.b.b)localObject5).a((String)localObject1, ((aj)localObject4).sGQ, (v)localObject3, 1);
            label1014:
            ((aj)localObject4).sGQ.setTextColor(this.mContext.getResources().getColor(d.b.FG_0));
            if ((((v)localObject3).lpN == 0) || (((v)localObject3).lpN == 1))
            {
              ((aj)localObject4).sGS.setVisibility(0);
              ((aj)localObject4).sGQ.setTextColor(this.mContext.getResources().getColor(d.b.FG_0));
              if (((v)localObject3).type == 7)
              {
                ((aj)localObject4).sCR.setVisibility(8);
                if ((Util.isNullOrNil(((v)localObject3).lpM)) || (((v)localObject3).type != 3)) {
                  break label2217;
                }
                ((aj)localObject4).sGR.setText(((v)localObject3).lpM);
                ((aj)localObject4).sGR.setVisibility(0);
                label1144:
                ((aj)localObject4).sEi.setVisibility(0);
                localObject1 = this.sHf;
                localObject5 = ((aj)localObject4).sEi;
                if (k <= 1) {
                  break label2230;
                }
                bool2 = true;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a((v)localObject3, paramz, paramInt, (u)localObject2, (View)localObject5, bool2, i);
                if ((i != k - 1) || (this.sHl.getVisibility() == 0)) {
                  break label2236;
                }
                ((aj)localObject4).sEi.setBackgroundResource(d.d.spE);
              }
            }
            break;
          }
        }
        for (;;)
        {
          if (((v)localObject3).type == 5)
          {
            localObject1 = e.sKW;
            e.G(((v)localObject3).url, ((v)localObject3).type, "");
          }
          i += 1;
          break label762;
          if (localv.type == 8)
          {
            this.sHr.a(k, localv, paramz, paramInt, (u)localObject2, paramz.sHe);
            break;
          }
          if (localv.type == 7)
          {
            this.sHs.a(k, localv, paramz, paramInt, (u)localObject2, paramz.sHe);
            break;
          }
          if (localv.type == 6)
          {
            this.sHt.a(k, (v)localLinkedList.get(0), paramz, paramInt, (u)localObject2, paramz.sHe);
            break;
          }
          if (localv.type == 10)
          {
            this.sHu.a(k, localv, paramz, paramInt, (u)localObject2, paramz.sHe);
            break;
          }
          this.sHo.a(k, localv, paramz, paramInt, (u)localObject2, paramz.sHe);
          break;
          this.sHl.setVisibility(8);
          break label754;
          i = 0;
          break label762;
          j = i;
          break label827;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((aj)localObject4).mrE.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              localObject1 = (v)localLinkedList.get(i - 1);
              localObject5 = (v)localLinkedList.get(i);
              if (((((v)localObject1).type != 7) && (((v)localObject1).type != 5) && (((v)localObject1).type != 6) && (Util.isNullOrNil(((v)localObject1).lpK))) || ((((v)localObject5).type != 7) && (((v)localObject5).type != 5) && (((v)localObject5).type != 6) && (Util.isNullOrNil(((v)localObject5).lpK))))
              {
                Z(((aj)localObject4).mrE, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAy);
                break;
                ((aj)localObject4).mrE.setVisibility(0);
                continue;
              }
              Z(((aj)localObject4).mrE, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAx);
              break;
            }
          }
          Z(((aj)localObject4).mrE, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAy);
          break label863;
          label1660:
          localObject1 = ((aj)localObject4).rgA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw;
          t((View)localObject1, j, j);
          break label893;
          if (i == 1)
          {
            if (k == 2)
            {
              t(((aj)localObject4).rgA, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt);
              break label893;
            }
            localObject1 = ((aj)localObject4).rgA;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw;
            t((View)localObject1, j, j);
            break label893;
          }
          if (i == k - 1)
          {
            t(((aj)localObject4).rgA, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt);
            break label893;
          }
          localObject1 = ((aj)localObject4).rgA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw;
          t((View)localObject1, j, j);
          break label893;
          label1787:
          if (i == 1)
          {
            if (i == k - 1)
            {
              localObject1 = ((aj)localObject4).rgA;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt;
              t((View)localObject1, j, j);
              break label893;
            }
            t(((aj)localObject4).rgA, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw);
            break label893;
          }
          if (i == k - 1)
          {
            t(((aj)localObject4).rgA, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw, com.tencent.mm.plugin.brandservice.ui.timeline.b.sAt);
            break label893;
          }
          localObject1 = ((aj)localObject4).rgA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAw;
          t((View)localObject1, j, j);
          break label893;
          localObject1 = this.mContext.getResources().getString(d.i.suM);
          break label999;
          localObject1 = this.mContext.getResources().getString(d.i.suN);
          break label999;
          localObject1 = this.mContext.getResources().getString(d.i.suG);
          break label999;
          com.tencent.mm.plugin.brandservice.b.b.svR.a(((v)localObject3).title, ((aj)localObject4).sGQ, (v)localObject3, 1);
          break label1014;
          if (!Util.isNullOrNil(((v)localObject3).lpK))
          {
            ((aj)localObject4).sCR.setVisibility(0);
            if (Util.isNullOrNil(((v)localObject3).lqb)) {}
            for (localObject1 = ((v)localObject3).lpK;; localObject1 = ((v)localObject3).lqb)
            {
              localObject5 = this.sHf.sAc;
              long l = paramz.field_msgId;
              localObject6 = ((aj)localObject4).sCR;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject5).a(l, i, (v)localObject3, (String)localObject1, (ImageView)localObject6, j, j, false, new m.a()
              {
                public final void onFinish()
                {
                  AppMethodBeat.i(6029);
                  this.sHx.a(this.sHy, paramz, i, true);
                  this.sHx.a(this.sHy, true);
                  am.this.sHf.sAc.p(paramz.field_msgId, i);
                  AppMethodBeat.o(6029);
                }
                
                public final void onStart() {}
              }, m, 2.0F);
              break;
            }
          }
          if ((((v)localObject3).type == 5) || (((v)localObject3).type == 6))
          {
            ((aj)localObject4).sCR.setVisibility(0);
            localObject1 = this.sHf.sAc;
            localObject5 = d.d.chatting_item_biz_play_icon_bg;
            localObject6 = ((aj)localObject4).sCR;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
            ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.d)localObject1).a((String)localObject5, (ImageView)localObject6, j, j, m);
            break label1102;
          }
          ((aj)localObject4).sGS.setVisibility(8);
          break label1102;
          ((aj)localObject4).sGS.setVisibility(8);
          ((aj)localObject4).sGQ.setTextColor(this.mContext.getResources().getColor(d.b.FG_2));
          break label1102;
          ((aj)localObject4).sGR.setVisibility(8);
          break label1144;
          bool2 = false;
          break label1175;
          ((aj)localObject4).sEi.setBackgroundResource(d.d.spF);
        }
        this.sHf.a(paramInt, paramz, this.sFW, this.sFV);
        this.sHf.a(this, paramz);
        AppMethodBeat.o(257706);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.am
 * JD-Core Version:    0.7.0.1
 */