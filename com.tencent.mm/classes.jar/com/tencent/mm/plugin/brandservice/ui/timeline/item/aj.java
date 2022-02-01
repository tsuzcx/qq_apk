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
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends ai
{
  public LinearLayout vLw;
  public LinearLayout vLx;
  public LinearLayout vMH;
  public LinearLayout vMI;
  public TextView vMJ;
  public List<ag> vMK;
  public aq vML;
  public as vMM;
  public ao vMN;
  public ap vMO;
  public at vMP;
  public an vMQ;
  public ar vMR;
  private View.OnClickListener vMS;
  
  public aj()
  {
    AppMethodBeat.i(6030);
    this.vMK = new ArrayList();
    this.vML = new aq();
    this.vMM = new as();
    this.vMN = new ao();
    this.vMO = new ap();
    this.vMP = new at();
    this.vMQ = new an();
    this.vMR = new ar();
    this.vMS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1 = null;
        AppMethodBeat.i(6028);
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
        localObject2 = (ab)paramAnonymousView.getTag();
        ((ab)localObject2).field_isExpand = true;
        ((ab)localObject2).field_status = 4;
        ((ab)localObject2).field_isRead = 1;
        ((ab)localObject2).field_hasShow = 1;
        af.bHl().F((ab)localObject2);
        com.tencent.mm.plugin.brandservice.ui.timeline.b localb = aj.this.vMC;
        StringBuilder localStringBuilder = new StringBuilder("onExpand msgId=");
        if (localObject2 == null)
        {
          paramAnonymousView = null;
          localStringBuilder = localStringBuilder.append(paramAnonymousView).append(" talker=");
          if (localObject2 != null) {
            break label180;
          }
        }
        label180:
        for (paramAnonymousView = localObject1;; paramAnonymousView = ((ab)localObject2).field_talker)
        {
          Log.i("MicroMsg.BizTimeLineAdapter", paramAnonymousView);
          com.tencent.mm.plugin.brandservice.ui.timeline.b.eq(localb.eXW);
          localb.vFK.d((ab)localObject2, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6028);
          return;
          paramAnonymousView = Long.valueOf(((ab)localObject2).field_msgId);
          break;
        }
      }
    };
    AppMethodBeat.o(6030);
  }
  
  private void a(View paramView, ah paramah, boolean paramBoolean)
  {
    AppMethodBeat.i(6031);
    if (paramBoolean)
    {
      if (paramah.vJU == null) {
        paramah.a(paramView, this.vMC);
      }
      if (paramah.vJU != null)
      {
        paramah.vJU.setVisibility(0);
        AppMethodBeat.o(6031);
      }
    }
    else if (paramah.vJU != null)
    {
      paramah.vJU.setVisibility(8);
    }
    AppMethodBeat.o(6031);
  }
  
  private void a(aj paramaj, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6032);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramaj.vMH, paramaj.vMM, bool1);
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
        a(paramaj.vMH, paramaj.vMO, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label220;
        }
        bool1 = true;
        a(paramaj.vMH, paramaj.vMP, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label226;
        }
        bool1 = true;
        a(paramaj.vMH, paramaj.vMQ, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label232;
        }
        bool1 = true;
        a(paramaj.vMH, paramaj.vMR, bool1);
        if (!bool1) {
          break label244;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = paramaj.vMH;
        paramaj = paramaj.vML;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramaj, bool1);
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
  
  private static void ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(6034);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6034);
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
    paramView.setPadding(0, paramInt1 - com.tencent.mm.plugin.brandservice.ui.timeline.b.vGl, 0, paramInt2 - com.tencent.mm.plugin.brandservice.ui.timeline.b.vGl);
    AppMethodBeat.o(6033);
  }
  
  public final View a(final ab paramab, int paramInt, View paramView)
  {
    AppMethodBeat.i(302582);
    Object localObject1 = this.vMK.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ag)((Iterator)localObject1).next();
      com.tencent.mm.ui.chatting.as.bj(((ag)localObject2).vJU, 3);
      this.vMH.removeView(((ag)localObject2).vJU);
    }
    this.vMK.clear();
    Object localObject2 = ((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramab.field_msgId, paramab.field_content);
    LinkedList localLinkedList = ((u)localObject2).nUC;
    int k = localLinkedList.size();
    if (k == 0)
    {
      this.vMH.setVisibility(8);
      a(this, -1, 0);
      AppMethodBeat.o(302582);
      return paramView;
    }
    this.vMH.setVisibility(0);
    v localv = (v)localLinkedList.get(0);
    c(localv);
    boolean bool1 = d.a(paramab, localv);
    if (bool1) {
      if ((Util.isNullOrNil(localv.nUM)) && (localv.type != 7) && (localv.type != 10)) {
        bool1 = false;
      }
    }
    label827:
    label1102:
    for (;;)
    {
      a(this, -1, k);
      paramab.acFv = bool1;
      Object localObject3 = ((Activity)this.mContext).getLayoutInflater();
      final int i = this.vMK.size();
      label248:
      if (i < k)
      {
        localObject1 = com.tencent.mm.ui.chatting.as.aBU(3);
        if (localObject1 != null) {
          break label2272;
        }
        localObject1 = ((LayoutInflater)localObject3).inflate(d.f.biz_time_line_item_comm_slot, null);
      }
      label863:
      label2272:
      for (;;)
      {
        Object localObject5 = this.vMC;
        Object localObject6 = this.mContext;
        Object localObject4 = this.vMH;
        localObject5 = new ag((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject5, (Context)localObject6);
        ((ag)localObject5).vJU = ((View)localObject1);
        ((ag)localObject5).plj = ((View)localObject1).findViewById(d.e.top_line);
        ((ag)localObject5).uoA = ((ViewGroup)((View)localObject1).findViewById(d.e.content_ll));
        ((ag)localObject5).vMn = ((MMNeat7extView)((View)localObject1).findViewById(d.e.title_neat_tv));
        localObject6 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        if (com.tencent.mm.plugin.brandservice.ui.b.e.dhV())
        {
          localObject6 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
          com.tencent.mm.plugin.brandservice.ui.b.e.e(((ag)localObject5).vMn);
        }
        ((ag)localObject5).vMo = ((TextView)((View)localObject1).findViewById(d.e.summary));
        ((ag)localObject5).vMp = ((View)localObject1).findViewById(d.e.cover_area);
        ((ag)localObject5).vIK = ((ImageView)((View)localObject1).findViewById(d.e.cover_iv));
        ((ag)localObject5).vMs = ((ImageView)((View)localObject1).findViewById(d.e.play_icon));
        ((ag)localObject5).vMq = ((View)localObject1).findViewById(d.e.biz_slot_voice_layout);
        ((ag)localObject5).vMr = ((ImageView)((View)localObject1).findViewById(d.e.biz_time_line_voice_play_icon));
        ((ag)localObject5).vJc = ((View)localObject1).findViewById(d.e.stat_layout);
        ((ag)localObject5).vJd = ((TextView)((View)localObject1).findViewById(d.e.friends_read_tv));
        ((ag)localObject5).vMt = ((View)localObject1).findViewById(d.e.pic_cover_mask_layout);
        ((ag)localObject5).vMu = ((View)localObject1).findViewById(d.e.pic_cover_mask);
        ((ag)localObject5).vJJ = ((TextView)((View)localObject1).findViewById(d.e.pic_num));
        ((ViewGroup)localObject4).addView((View)localObject1, ((ViewGroup)localObject4).getChildCount());
        this.vMK.add(localObject5);
        i += 1;
        break label248;
        a(this, ((v)localLinkedList.get(0)).type, k);
        break;
        i = 0;
        while (i < this.vMK.size())
        {
          ((ag)this.vMK.get(i)).vJU.setVisibility(8);
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
            this.vMM.a(k, localv, paramab, paramInt, (u)localObject2, paramab.vMB);
          }
        }
        else
        {
          if ((k <= 2) || (paramab.field_isExpand)) {
            break label1420;
          }
          this.vMI.setVisibility(0);
          this.vMJ.setText(this.mContext.getString(d.i.biz_time_line_show_more_article, new Object[] { Integer.valueOf(k - 2) }));
          this.vMI.setTag(paramab);
          this.vMI.setOnClickListener(this.vMS);
          if (!bool1) {
            break label1432;
          }
          i = 1;
          if ((i >= k) || ((!paramab.field_isExpand) && (i > 1))) {
            break label2239;
          }
          localObject3 = (v)localLinkedList.get(i);
          m = paramab.vMB + i;
          c((v)localObject3);
          localObject1 = this.vMK;
          if (!bool1) {
            break label1438;
          }
          j = i - 1;
          localObject4 = (ag)((List)localObject1).get(j);
          j = localv.type;
          if (i != 0) {
            break label1445;
          }
          ((ag)localObject4).plj.setVisibility(8);
          if (bool1) {
            break label1787;
          }
          if (i != 0) {
            break label1684;
          }
          if (k != 1) {
            break label1660;
          }
          s(((ag)localObject4).uoA, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf);
          ((ag)localObject4).a((v)localObject3, paramab, i, false);
          ((ag)localObject4).a((v)localObject3, false);
          ((ag)localObject4).a(((ag)localObject4).vJc, ((ag)localObject4).vJd, paramab, (v)localObject3);
          if (!Util.isNullOrNil(((v)localObject3).title)) {
            break label1947;
          }
          localObject5 = com.tencent.mm.plugin.brandservice.model.b.vBC;
          switch (((v)localObject3).type)
          {
          case 6: 
          default: 
            localObject1 = this.mContext.getResources().getString(d.i.biz_time_line_item_default_title);
            label999:
            ((com.tencent.mm.plugin.brandservice.model.b)localObject5).a((String)localObject1, ((ag)localObject4).vMn, (v)localObject3, 1);
            label1014:
            ((ag)localObject4).vMn.setTextColor(this.mContext.getResources().getColor(d.b.FG_0));
            if ((((v)localObject3).nUP == 0) || (((v)localObject3).nUP == 1))
            {
              ((ag)localObject4).vMp.setVisibility(0);
              ((ag)localObject4).vMn.setTextColor(this.mContext.getResources().getColor(d.b.FG_0));
              if (((v)localObject3).type == 7)
              {
                ((ag)localObject4).vIK.setVisibility(8);
                if ((Util.isNullOrNil(((v)localObject3).nUO)) || (((v)localObject3).type != 3)) {
                  break label2195;
                }
                ((ag)localObject4).vMo.setText(((v)localObject3).nUO);
                ((ag)localObject4).vMo.setVisibility(0);
                label1144:
                ((ag)localObject4).vJU.setVisibility(0);
                localObject1 = this.vMC;
                localObject5 = ((ag)localObject4).vJU;
                if (k <= 1) {
                  break label2219;
                }
                bool2 = true;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.b)localObject1).a((v)localObject3, paramab, paramInt, (u)localObject2, (View)localObject5, bool2, i);
                if ((i != k - 1) || (this.vMI.getVisibility() == 0)) {
                  break label2225;
                }
                ((ag)localObject4).vJU.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
              }
            }
            break;
          }
        }
        for (;;)
        {
          if (((v)localObject3).type == 5)
          {
            localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(((v)localObject3).url, ((v)localObject3).type, "");
          }
          i += 1;
          break label762;
          if (localv.type == 8)
          {
            this.vMO.a(k, localv, paramab, paramInt, (u)localObject2, paramab.vMB);
            break;
          }
          if (localv.type == 7)
          {
            this.vMP.a(k, localv, paramab, paramInt, (u)localObject2, paramab.vMB);
            break;
          }
          if (localv.type == 6)
          {
            this.vMQ.a(k, (v)localLinkedList.get(0), paramab, paramInt, (u)localObject2, paramab.vMB);
            break;
          }
          if (localv.type == 10)
          {
            this.vMR.a(k, localv, paramab, paramInt, (u)localObject2, paramab.vMB);
            break;
          }
          this.vML.a(k, localv, paramab, paramInt, (u)localObject2, paramab.vMB);
          break;
          this.vMI.setVisibility(8);
          break label754;
          i = 0;
          break label762;
          j = i;
          break label827;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((ag)localObject4).plj.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              localObject1 = (v)localLinkedList.get(i - 1);
              localObject5 = (v)localLinkedList.get(i);
              if (((((v)localObject1).type != 7) && (((v)localObject1).type != 5) && (((v)localObject1).type != 6) && (Util.isNullOrNil(((v)localObject1).nUM))) || ((((v)localObject5).type != 7) && (((v)localObject5).type != 5) && (((v)localObject5).type != 6) && (Util.isNullOrNil(((v)localObject5).nUM))))
              {
                ad(((ag)localObject4).plj, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGk);
                break;
                ((ag)localObject4).plj.setVisibility(0);
                continue;
              }
              ad(((ag)localObject4).plj, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGj);
              break;
            }
          }
          ad(((ag)localObject4).plj, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGk);
          break label863;
          label1660:
          localObject1 = ((ag)localObject4).uoA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi;
          s((View)localObject1, j, j);
          break label893;
          if (i == 1)
          {
            if (k == 2)
            {
              s(((ag)localObject4).uoA, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf);
              break label893;
            }
            localObject1 = ((ag)localObject4).uoA;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi;
            s((View)localObject1, j, j);
            break label893;
          }
          if (i == k - 1)
          {
            s(((ag)localObject4).uoA, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf);
            break label893;
          }
          localObject1 = ((ag)localObject4).uoA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi;
          s((View)localObject1, j, j);
          break label893;
          label1787:
          if (i == 1)
          {
            if (i == k - 1)
            {
              localObject1 = ((ag)localObject4).uoA;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf;
              s((View)localObject1, j, j);
              break label893;
            }
            s(((ag)localObject4).uoA, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi);
            break label893;
          }
          if (i == k - 1)
          {
            s(((ag)localObject4).uoA, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGf);
            break label893;
          }
          localObject1 = ((ag)localObject4).uoA;
          j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi;
          s((View)localObject1, j, j);
          break label893;
          localObject1 = this.mContext.getResources().getString(d.i.biz_time_line_item_video_default_title);
          break label999;
          localObject1 = this.mContext.getResources().getString(d.i.biz_time_line_item_voice_default_title);
          break label999;
          localObject1 = this.mContext.getResources().getString(d.i.biz_time_line_item_image_default_title);
          break label999;
          com.tencent.mm.plugin.brandservice.model.b.vBC.a(((v)localObject3).title, ((ag)localObject4).vMn, (v)localObject3, 1);
          break label1014;
          if (!Util.isNullOrNil(((v)localObject3).nUM))
          {
            ((ag)localObject4).vIK.setVisibility(0);
            if (Util.isNullOrNil(((v)localObject3).nVd)) {}
            for (localObject1 = ((v)localObject3).nUM;; localObject1 = ((v)localObject3).nVd)
            {
              long l = paramab.field_msgId;
              localObject5 = ((ag)localObject4).vIK;
              j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
              d.a(l, i, (v)localObject3, (String)localObject1, (ImageView)localObject5, j, j, false, new m.a()
              {
                public final void onFinish()
                {
                  AppMethodBeat.i(6029);
                  this.vMU.a(this.vsS, paramab, i, true);
                  this.vMU.a(this.vsS, true);
                  aj.this.vMC.vFN.y(paramab.field_msgId, i);
                  AppMethodBeat.o(6029);
                }
                
                public final void onStart() {}
              }, m, 2.0F);
              break;
            }
          }
          if ((((v)localObject3).type == 5) || (((v)localObject3).type == 6))
          {
            ((ag)localObject4).vIK.setVisibility(0);
            localObject1 = d.d.chatting_item_biz_play_icon_bg;
            localObject5 = ((ag)localObject4).vIK;
            j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
            d.a((String)localObject1, (ImageView)localObject5, j, j, m);
            break label1102;
          }
          ((ag)localObject4).vMp.setVisibility(8);
          break label1102;
          ((ag)localObject4).vMp.setVisibility(8);
          ((ag)localObject4).vMn.setTextColor(this.mContext.getResources().getColor(d.b.FG_2));
          break label1102;
          ((ag)localObject4).vMo.setText("");
          ((ag)localObject4).vMo.setVisibility(8);
          break label1144;
          bool2 = false;
          break label1175;
          ((ag)localObject4).vJU.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
        }
        this.vMC.a(paramInt, paramab, this.vLx, this.vLw);
        this.vMC.a(this, paramab);
        AppMethodBeat.o(302582);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
 * JD-Core Version:    0.7.0.1
 */