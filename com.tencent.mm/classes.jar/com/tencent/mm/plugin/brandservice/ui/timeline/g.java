package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.al.af;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.b;
import com.tencent.mm.storage.u.c;
import com.tencent.mm.storage.w;
import com.tencent.mm.storagebase.h;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class g
  extends BaseAdapter
{
  private static final int fBL;
  private static final int fBM;
  private static final int fBN;
  private static int fBO;
  private int daq;
  private int fwc;
  List<t> mgF;
  u.c nuw;
  boolean nzB;
  private BizTimeLineNewMsgUI nzN;
  private long nzO;
  boolean nzP;
  
  static
  {
    AppMethodBeat.i(5915);
    fBL = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 28);
    fBM = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20);
    fBN = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 1);
    fBO = -1;
    AppMethodBeat.o(5915);
  }
  
  public g(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<t> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.nzP = false;
    this.nuw = new u.c()
    {
      public final void a(Object paramAnonymousObject, u.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.GCq != u.b.GCs) || (paramAnonymousa.nAa == null)) {
            break label58;
          }
          g.a(g.this).add(0, paramAnonymousa.nAa);
        }
        for (;;)
        {
          g.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.GCq == u.b.GCt)
          {
            paramAnonymousa = g.this;
            paramAnonymousObject = paramAnonymousa.bJQ();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.mgF.clear();
              paramAnonymousa = paramAnonymousa.mgF;
              w localw = af.aDd();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(w.o(localw.hpA.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.nzB = false;
    this.nzN = paramBizTimeLineNewMsgUI;
    af.aDd().a(this.nuw, Looper.getMainLooper());
    this.mgF = paramList;
    this.fwc = paramInt1;
    this.daq = paramInt2;
    this.nzO = paramLong;
    AppMethodBeat.o(5908);
  }
  
  public final t bJQ()
  {
    AppMethodBeat.i(5912);
    if (this.mgF.size() > 0)
    {
      t localt = (t)this.mgF.get(this.mgF.size() - 1);
      AppMethodBeat.o(5912);
      return localt;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.mgF.size();
    AppMethodBeat.o(5909);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5911);
    final t localt = yG(paramInt);
    if (localt == null)
    {
      ac.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.nzN, 2131493214, null);
      locala.asD = localView;
      locala.fxQ = ((ImageView)localView.findViewById(2131297008));
      locala.iIU = ((TextView)localView.findViewById(2131302860));
      locala.timeTv = ((TextView)localView.findViewById(2131305822));
      locala.titleTv = ((TextView)localView.findViewById(2131305948));
      locala.miE = localView.findViewById(2131297453);
      locala.nzR = ((ViewGroup)localView.findViewById(2131297299));
      locala.nzS = ((AppBrandNearbyShowcaseView)localView.findViewById(2131297302));
      localView.setTag(locala);
      locala.nzR.setVisibility(8);
      if (!localt.eZn()) {
        break label381;
      }
      locala.fxQ.setImageResource(2131231274);
      label202:
      if (!localt.eZn()) {
        break label397;
      }
      paramView = this.nzN.getString(2131756584);
      label220:
      locala.iIU.setText(k.b(this.nzN, paramView, locala.iIU.getTextSize()));
      locala.timeTv.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.nzN, localt.field_createTime));
      if (!localt.eZj()) {
        break label409;
      }
      paramViewGroup = m.vE(localt.field_content);
      paramView = paramViewGroup;
      if (bs.isNullOrNil(paramViewGroup)) {
        paramView = this.nzN.getString(2131756613);
      }
      locala.titleTv.setText(paramView);
      label310:
      if (paramInt != getCount() - 1) {
        break label1407;
      }
      locala.miE.setVisibility(4);
    }
    for (;;)
    {
      yH(paramInt);
      paramView = b.nyW;
      b.a(localt, 0, paramInt, this.daq, this.fwc, this.nzO);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label381:
      a.b.d(locala.fxQ, localt.field_talker);
      break label202;
      label397:
      paramView = v.wk(localt.field_talker);
      break label220;
      label409:
      if (!localt.isText()) {
        if (localt.field_type != 10000) {
          break label468;
        }
      }
      label468:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label474;
        }
        locala.titleTv.setText(k.a(this.nzN, localt.field_content, (int)locala.titleTv.getTextSize()));
        break;
      }
      label474:
      if (localt.eZm())
      {
        locala.titleTv.setText(this.nzN.getString(2131755853));
        break label310;
      }
      if (localt.eZl())
      {
        locala.titleTv.setText(this.nzN.getString(2131755929));
        break label310;
      }
      if (localt.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label577;
        }
        locala.titleTv.setText(this.nzN.getString(2131755926));
        break;
      }
      label577:
      if ((localt.field_type == 42) || (localt.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label632;
        }
        locala.titleTv.setText(this.nzN.getString(2131755860));
        break;
      }
      label632:
      Object localObject;
      if (localt.eZn())
      {
        paramView = paramViewGroup.getContext();
        if (paramView == null) {
          break label310;
        }
        localObject = localt.field_content;
        if (localObject == null)
        {
          ac.i("MicroMsg.BizTimeLineAdapter", "sys xml is null");
          break label310;
        }
        paramViewGroup = bv.L((String)localObject, "sysmsg");
        if ((paramViewGroup == null) || (paramViewGroup.isEmpty()))
        {
          locala.titleTv.setText(this.nzN.getString(2131756622));
          ac.i("MicroMsg.BizTimeLineAdapter", "parse xml failed, values is null, xml : %s", new Object[] { localObject });
          break label310;
        }
        localObject = (String)paramViewGroup.get(".sysmsg.BizMsgRejectRecommend.Content");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ac.i("MicroMsg.BizTimeLineAdapter", "get title from map failed, xml : %s");
          locala.titleTv.setText(this.nzN.getString(2131756622));
          break label310;
        }
        b localb = b.nyW;
        paramViewGroup = b.d(paramViewGroup, 4);
        if (paramViewGroup.size() == 0) {
          break label310;
        }
        locala.nzR.setVisibility(0);
        locala.titleTv.setText(k.a(this.nzN, (CharSequence)localObject, (int)locala.titleTv.getTextSize()));
        locala.nzR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5906);
            paramAnonymousView = b.nyW;
            b.a(localt, 1, paramInt, g.b(g.this), g.c(g.this), g.d(g.this));
            Object localObject = new Intent(paramView, BizFastRejectMsgUI.class);
            if (g.c(g.this) == 2) {
              ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            }
            for (;;)
            {
              ((Intent)localObject).putExtra("key_time_line_msg_rank", paramInt);
              ((Intent)localObject).putExtra("biz_time_line_line_session_id", g.b(g.this));
              ((Intent)localObject).putExtra("key_time_line_msg_id", localt.field_msgId);
              ((Intent)localObject).putExtra("key_reject_biz_info_xml", localt.field_content);
              paramAnonymousView = paramView;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(5906);
              return;
              if (g.c(g.this) == 1) {
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 0);
              }
            }
          }
        });
        localObject = locala.nzS;
        if (paramViewGroup.size() > 3) {}
        for (i = 4;; i = 3)
        {
          ((AppBrandNearbyShowcaseView)localObject).setIconLayerCount(i);
          ((AppBrandNearbyShowcaseView)localObject).hJ(false);
          ((AppBrandNearbyShowcaseView)localObject).setIconSize(fBL + fBN * 2);
          ((AppBrandNearbyShowcaseView)localObject).setIconGap(fBM);
          fBO = paramView.getResources().getColor(2131100498);
          paramView = new com.tencent.mm.plugin.appbrand.ui.widget.a(fBL, fBN, fBO);
          int j = 0;
          while (j < i)
          {
            com.tencent.mm.modelappbrand.a.b.aAS().a(((AppBrandNearbyShowcaseView)localObject).vk(j), ((com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramViewGroup.get(j % paramViewGroup.size())).hlG, com.tencent.mm.modelappbrand.a.a.aAR(), paramView);
            j += 1;
          }
          break;
        }
      }
      if ((localt.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1024:
        if (i == 0) {
          break label1386;
        }
        localObject = k.b.vA(localt.field_content);
        if (localObject == null) {
          break label1386;
        }
        paramView = "";
        switch (((k.b)localObject).type)
        {
        }
      }
      for (;;)
      {
        paramViewGroup = paramView;
        if (bs.isNullOrNil(paramView)) {
          paramViewGroup = ((k.b)localObject).getTitle();
        }
        locala.titleTv.setText(k.b(this.nzN, paramViewGroup, locala.titleTv.getTextSize()));
        break;
        i = 0;
        break label1024;
        paramView = ((k.b)localObject).title;
        continue;
        paramView = this.nzN.getString(2131755853);
        continue;
        paramView = this.nzN.getString(2131755820) + ((k.b)localObject).title;
        continue;
        paramView = this.nzN.getString(2131755926) + ((k.b)localObject).title;
        continue;
        paramView = this.nzN.getString(2131755920) + ((k.b)localObject).getTitle();
        continue;
        paramView = this.nzN.getString(2131755860) + ((k.b)localObject).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject).hjl + "]" + ((k.b)localObject).hjh;
      }
      label1386:
      locala.titleTv.setText(this.nzN.getString(2131756622));
      break label310;
      label1407:
      locala.miE.setVisibility(0);
    }
  }
  
  public final t yG(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.mgF.size())
    {
      t localt = (t)this.mgF.get(paramInt);
      AppMethodBeat.o(5910);
      return localt;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void yH(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.fwc == 1) && (!this.nzP))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.nzB)) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5907);
          Object localObject1;
          Object localObject2;
          if ((paramInt == g.this.getCount() - 1) && (!g.this.nzB))
          {
            ac.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(g.this.getCount()) });
            localObject1 = g.this;
            localObject2 = ((g)localObject1).bJQ();
            if (localObject2 == null) {
              break label245;
            }
            w localw = af.aDd();
            long l = ((t)localObject2).field_createTime;
            localObject2 = w.o(localw.hpA.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((g)localObject1).mgF.addAll((Collection)localObject2);
            ((g)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label245;
            }
          }
          label245:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              g.this.nzB = true;
              localObject1 = g.e(g.this);
              if (((BizTimeLineNewMsgUI)localObject1).nzT != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).nzX.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).nzY.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).nzY.findViewById(2131297358);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(2131756632));
                }
              }
            }
            AppMethodBeat.o(5907);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  static final class a
  {
    View asD;
    ImageView fxQ;
    TextView iIU;
    View miE;
    ViewGroup nzR;
    AppBrandNearbyShowcaseView nzS;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */