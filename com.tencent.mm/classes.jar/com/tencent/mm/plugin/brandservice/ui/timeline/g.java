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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.am.af;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.b;
import com.tencent.mm.storage.t.c;
import com.tencent.mm.storagebase.h;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class g
  extends BaseAdapter
{
  private static final int fye;
  private static final int fyf;
  private static final int fyg;
  private static int fyh;
  private int dcS;
  private int fsv;
  List<s> lEL;
  t.c mSg;
  boolean mXc;
  private BizTimeLineNewMsgUI mXo;
  private long mXp;
  boolean mXq;
  
  static
  {
    AppMethodBeat.i(5915);
    fye = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 28);
    fyf = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20);
    fyg = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1);
    fyh = -1;
    AppMethodBeat.o(5915);
  }
  
  public g(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<s> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.mXq = false;
    this.mSg = new t.c()
    {
      public final void a(Object paramAnonymousObject, t.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.FeG != t.b.FeI) || (paramAnonymousa.mXB == null)) {
            break label58;
          }
          g.a(g.this).add(0, paramAnonymousa.mXB);
        }
        for (;;)
        {
          g.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.FeG == t.b.FeJ)
          {
            paramAnonymousa = g.this;
            paramAnonymousObject = paramAnonymousa.bCI();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.lEL.clear();
              paramAnonymousa = paramAnonymousa.lEL;
              com.tencent.mm.storage.v localv = af.awl();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(com.tencent.mm.storage.v.p(localv.gPa.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.mXc = false;
    this.mXo = paramBizTimeLineNewMsgUI;
    af.awl().a(this.mSg, Looper.getMainLooper());
    this.lEL = paramList;
    this.fsv = paramInt1;
    this.dcS = paramInt2;
    this.mXp = paramLong;
    AppMethodBeat.o(5908);
  }
  
  public final s bCI()
  {
    AppMethodBeat.i(5912);
    if (this.lEL.size() > 0)
    {
      s locals = (s)this.lEL.get(this.lEL.size() - 1);
      AppMethodBeat.o(5912);
      return locals;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.lEL.size();
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
    final s locals = xP(paramInt);
    if (locals == null)
    {
      ad.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.mXo, 2131493214, null);
      locala.arI = localView;
      locala.fuj = ((ImageView)localView.findViewById(2131297008));
      locala.iiN = ((TextView)localView.findViewById(2131302860));
      locala.timeTv = ((TextView)localView.findViewById(2131305822));
      locala.titleTv = ((TextView)localView.findViewById(2131305948));
      locala.lGJ = localView.findViewById(2131297453);
      locala.mXs = ((ViewGroup)localView.findViewById(2131297299));
      locala.mXt = ((AppBrandNearbyShowcaseView)localView.findViewById(2131297302));
      localView.setTag(locala);
      locala.mXs.setVisibility(8);
      if (!locals.eJP()) {
        break label381;
      }
      locala.fuj.setImageResource(2131231274);
      label202:
      if (!locals.eJP()) {
        break label397;
      }
      paramView = this.mXo.getString(2131756584);
      label220:
      locala.iiN.setText(k.b(this.mXo, paramView, locala.iiN.getTextSize()));
      locala.timeTv.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.mXo, locals.field_createTime));
      if (!locals.eJL()) {
        break label409;
      }
      paramViewGroup = m.rB(locals.field_content);
      paramView = paramViewGroup;
      if (bt.isNullOrNil(paramViewGroup)) {
        paramView = this.mXo.getString(2131756613);
      }
      locala.titleTv.setText(paramView);
      label310:
      if (paramInt != getCount() - 1) {
        break label1407;
      }
      locala.lGJ.setVisibility(4);
    }
    for (;;)
    {
      xQ(paramInt);
      paramView = b.mWx;
      b.a(locals, 0, paramInt, this.dcS, this.fsv, this.mXp);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label381:
      a.b.d(locala.fuj, locals.field_talker);
      break label202;
      label397:
      paramView = com.tencent.mm.model.v.sh(locals.field_talker);
      break label220;
      label409:
      if (!locals.isText()) {
        if (locals.field_type != 10000) {
          break label468;
        }
      }
      label468:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label474;
        }
        locala.titleTv.setText(k.a(this.mXo, locals.field_content, (int)locala.titleTv.getTextSize()));
        break;
      }
      label474:
      if (locals.eJO())
      {
        locala.titleTv.setText(this.mXo.getString(2131755853));
        break label310;
      }
      if (locals.eJN())
      {
        locala.titleTv.setText(this.mXo.getString(2131755929));
        break label310;
      }
      if (locals.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label577;
        }
        locala.titleTv.setText(this.mXo.getString(2131755926));
        break;
      }
      label577:
      if ((locals.field_type == 42) || (locals.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label632;
        }
        locala.titleTv.setText(this.mXo.getString(2131755860));
        break;
      }
      label632:
      Object localObject;
      if (locals.eJP())
      {
        paramView = paramViewGroup.getContext();
        if (paramView == null) {
          break label310;
        }
        localObject = locals.field_content;
        if (localObject == null)
        {
          ad.i("MicroMsg.BizTimeLineAdapter", "sys xml is null");
          break label310;
        }
        paramViewGroup = bw.K((String)localObject, "sysmsg");
        if ((paramViewGroup == null) || (paramViewGroup.isEmpty()))
        {
          locala.titleTv.setText(this.mXo.getString(2131756622));
          ad.i("MicroMsg.BizTimeLineAdapter", "parse xml failed, values is null, xml : %s", new Object[] { localObject });
          break label310;
        }
        localObject = (String)paramViewGroup.get(".sysmsg.BizMsgRejectRecommend.Content");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ad.i("MicroMsg.BizTimeLineAdapter", "get title from map failed, xml : %s");
          locala.titleTv.setText(this.mXo.getString(2131756622));
          break label310;
        }
        b localb = b.mWx;
        paramViewGroup = b.d(paramViewGroup, 4);
        if (paramViewGroup.size() == 0) {
          break label310;
        }
        locala.mXs.setVisibility(0);
        locala.titleTv.setText(k.a(this.mXo, (CharSequence)localObject, (int)locala.titleTv.getTextSize()));
        locala.mXs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(5906);
            paramAnonymousView = b.mWx;
            b.a(locals, 1, paramInt, g.b(g.this), g.c(g.this), g.d(g.this));
            Object localObject = new Intent(paramView, BizFastRejectMsgUI.class);
            if (g.c(g.this) == 2) {
              ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 1);
            }
            for (;;)
            {
              ((Intent)localObject).putExtra("key_time_line_msg_rank", paramInt);
              ((Intent)localObject).putExtra("biz_time_line_line_session_id", g.b(g.this));
              ((Intent)localObject).putExtra("key_time_line_msg_id", locals.field_msgId);
              ((Intent)localObject).putExtra("key_reject_biz_info_xml", locals.field_content);
              paramAnonymousView = paramView;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineNewMsgAdapter$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(5906);
              return;
              if (g.c(g.this) == 1) {
                ((Intent)localObject).putExtra("biz_time_line_line_enter_scene", 0);
              }
            }
          }
        });
        localObject = locala.mXt;
        if (paramViewGroup.size() > 3) {}
        for (i = 4;; i = 3)
        {
          ((AppBrandNearbyShowcaseView)localObject).setIconLayerCount(i);
          ((AppBrandNearbyShowcaseView)localObject).hm(false);
          ((AppBrandNearbyShowcaseView)localObject).setIconSize(fye + fyg * 2);
          ((AppBrandNearbyShowcaseView)localObject).setIconGap(fyf);
          fyh = paramView.getResources().getColor(2131100498);
          paramView = new com.tencent.mm.plugin.appbrand.ui.widget.a(fye, fyg, fyh);
          int j = 0;
          while (j < i)
          {
            com.tencent.mm.modelappbrand.a.b.aub().a(((AppBrandNearbyShowcaseView)localObject).us(j), ((com.tencent.mm.plugin.brandservice.ui.timeline.b.a)paramViewGroup.get(j % paramViewGroup.size())).gLg, com.tencent.mm.modelappbrand.a.a.aua(), paramView);
            j += 1;
          }
          break;
        }
      }
      if ((locals.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1024:
        if (i == 0) {
          break label1386;
        }
        localObject = k.b.rx(locals.field_content);
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
        if (bt.isNullOrNil(paramView)) {
          paramViewGroup = ((k.b)localObject).getTitle();
        }
        locala.titleTv.setText(k.b(this.mXo, paramViewGroup, locala.titleTv.getTextSize()));
        break;
        i = 0;
        break label1024;
        paramView = ((k.b)localObject).title;
        continue;
        paramView = this.mXo.getString(2131755853);
        continue;
        paramView = this.mXo.getString(2131755820) + ((k.b)localObject).title;
        continue;
        paramView = this.mXo.getString(2131755926) + ((k.b)localObject).title;
        continue;
        paramView = this.mXo.getString(2131755920) + ((k.b)localObject).getTitle();
        continue;
        paramView = this.mXo.getString(2131755860) + ((k.b)localObject).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject).gIL + "]" + ((k.b)localObject).gIH;
      }
      label1386:
      locala.titleTv.setText(this.mXo.getString(2131756622));
      break label310;
      label1407:
      locala.lGJ.setVisibility(0);
    }
  }
  
  public final s xP(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.lEL.size())
    {
      s locals = (s)this.lEL.get(paramInt);
      AppMethodBeat.o(5910);
      return locals;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void xQ(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.fsv == 1) && (!this.mXq))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.mXc)) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5907);
          Object localObject1;
          Object localObject2;
          if ((paramInt == g.this.getCount() - 1) && (!g.this.mXc))
          {
            ad.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(g.this.getCount()) });
            localObject1 = g.this;
            localObject2 = ((g)localObject1).bCI();
            if (localObject2 == null) {
              break label245;
            }
            com.tencent.mm.storage.v localv = af.awl();
            long l = ((s)localObject2).field_createTime;
            localObject2 = com.tencent.mm.storage.v.p(localv.gPa.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((g)localObject1).lEL.addAll((Collection)localObject2);
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
              g.this.mXc = true;
              localObject1 = g.e(g.this);
              if (((BizTimeLineNewMsgUI)localObject1).mXu != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).mXy.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).mXz.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).mXz.findViewById(2131297358);
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
    View arI;
    ImageView fuj;
    TextView iiN;
    View lGJ;
    ViewGroup mXs;
    AppBrandNearbyShowcaseView mXt;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */