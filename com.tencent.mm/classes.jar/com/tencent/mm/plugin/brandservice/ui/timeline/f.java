package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.b;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.storagebase.h;
import java.util.Collection;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private int dlK;
  private int fPp;
  List<w> mHf;
  x.c nVS;
  boolean oaG;
  private BizTimeLineNewMsgUI oaS;
  private long oaT;
  boolean oaU;
  
  public f(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<w> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.oaU = false;
    this.nVS = new x.c()
    {
      public final void a(Object paramAnonymousObject, x.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.IoG != x.b.IoI) || (paramAnonymousa.obf == null)) {
            break label58;
          }
          f.a(f.this).add(0, paramAnonymousa.obf);
        }
        for (;;)
        {
          f.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.IoG == x.b.IoJ)
          {
            paramAnonymousa = f.this;
            paramAnonymousObject = paramAnonymousa.bOk();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.mHf.clear();
              paramAnonymousa = paramAnonymousa.mHf;
              z localz = ag.aGg();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(z.o(localz.hHS.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.oaG = false;
    this.oaS = paramBizTimeLineNewMsgUI;
    ag.aGg().a(this.nVS, Looper.getMainLooper());
    this.mHf = paramList;
    this.fPp = paramInt1;
    this.dlK = paramInt2;
    this.oaT = paramLong;
    AppMethodBeat.o(5908);
  }
  
  public final w bOk()
  {
    AppMethodBeat.i(5912);
    if (this.mHf.size() > 0)
    {
      w localw = (w)this.mHf.get(this.mHf.size() - 1);
      AppMethodBeat.o(5912);
      return localw;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.mHf.size();
    AppMethodBeat.o(5909);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5911);
    Object localObject = zq(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.oaS, 2131493214, null);
      paramViewGroup.auu = localView;
      paramViewGroup.fRd = ((ImageView)localView.findViewById(2131297008));
      paramViewGroup.jcd = ((TextView)localView.findViewById(2131302860));
      paramViewGroup.timeTv = ((TextView)localView.findViewById(2131305822));
      paramViewGroup.titleTv = ((TextView)localView.findViewById(2131305948));
      paramViewGroup.mJf = localView.findViewById(2131297453);
      paramViewGroup.oaW = ((ViewGroup)localView.findViewById(2131297299));
      paramViewGroup.oaX = ((AppBrandNearbyShowcaseView)localView.findViewById(2131297302));
      localView.setTag(paramViewGroup);
      paramViewGroup.oaW.setVisibility(8);
      if (!((w)localObject).fpg()) {
        break label425;
      }
      paramView = ((l)g.ab(l.class)).azp().Bf(((w)localObject).field_talker);
      if ((paramView != null) && (com.tencent.mm.o.b.lM(paramView.field_type))) {
        break label425;
      }
      if (((w)localObject).fpk() != null)
      {
        paramView = new c.a();
        paramView.idD = 2131231875;
        paramView.idq = true;
        paramView.hfi = true;
        q.aIJ().a(((w)localObject).fpk().hDQ, paramViewGroup.fRd, paramView.aJc());
      }
      label273:
      if (!((w)localObject).fpg()) {
        break label440;
      }
      paramView = ((w)localObject).fpk().bVF;
      label290:
      paramViewGroup.jcd.setText(k.b(this.oaS, paramView, paramViewGroup.jcd.getTextSize()));
      paramViewGroup.timeTv.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.oaS, ((w)localObject).field_createTime));
      if (!((w)localObject).fpd()) {
        break label452;
      }
      localObject = m.yv(((w)localObject).field_content);
      paramView = (View)localObject;
      if (bt.isNullOrNil((String)localObject)) {
        paramView = this.oaS.getString(2131756613);
      }
      paramViewGroup.titleTv.setText(paramView);
      label379:
      if (paramInt != getCount() - 1) {
        break label1095;
      }
      paramViewGroup.mJf.setVisibility(4);
    }
    for (;;)
    {
      zr(paramInt);
      AppMethodBeat.o(5911);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label425:
      a.b.d(paramViewGroup.fRd, ((w)localObject).field_talker);
      break label273;
      label440:
      paramView = com.tencent.mm.model.v.zf(((w)localObject).field_talker);
      break label290;
      label452:
      if (!((w)localObject).isText()) {
        if (((w)localObject).field_type != 10000) {
          break label509;
        }
      }
      label509:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label515;
        }
        paramViewGroup.titleTv.setText(k.a(this.oaS, ((w)localObject).field_content, (int)paramViewGroup.titleTv.getTextSize()));
        break;
      }
      label515:
      if (((w)localObject).fpg())
      {
        paramViewGroup.titleTv.setText(((w)localObject).fpk().title);
        break label379;
      }
      if (((w)localObject).fpi())
      {
        paramViewGroup.titleTv.setText(this.oaS.getString(2131755853));
        break label379;
      }
      if (((w)localObject).fph())
      {
        paramViewGroup.titleTv.setText(this.oaS.getString(2131755929));
        break label379;
      }
      if (((w)localObject).field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label641;
        }
        paramViewGroup.titleTv.setText(this.oaS.getString(2131755926));
        break;
      }
      label641:
      if ((((w)localObject).field_type == 42) || (((w)localObject).field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label695;
        }
        paramViewGroup.titleTv.setText(this.oaS.getString(2131755860));
        break;
      }
      label695:
      label712:
      k.b localb;
      if ((((w)localObject).field_type & 0xFFFF) == 49)
      {
        i = 1;
        if (i == 0) {
          break label1075;
        }
        localb = k.b.yr(((w)localObject).field_content);
        if (localb == null) {
          break label1075;
        }
        paramView = "";
        switch (localb.type)
        {
        }
      }
      for (;;)
      {
        localObject = paramView;
        if (bt.isNullOrNil(paramView)) {
          localObject = localb.getTitle();
        }
        paramViewGroup.titleTv.setText(k.b(this.oaS, (CharSequence)localObject, paramViewGroup.titleTv.getTextSize()));
        break;
        i = 0;
        break label712;
        paramView = localb.title;
        continue;
        paramView = this.oaS.getString(2131755853);
        continue;
        paramView = this.oaS.getString(2131755820) + localb.title;
        continue;
        paramView = this.oaS.getString(2131755926) + localb.title;
        continue;
        paramView = this.oaS.getString(2131755920) + localb.getTitle();
        continue;
        paramView = this.oaS.getString(2131755860) + localb.getTitle();
        continue;
        paramView = "[" + localb.hBu + "]" + localb.hBq;
      }
      label1075:
      paramViewGroup.titleTv.setText(this.oaS.getString(2131756622));
      break label379;
      label1095:
      paramViewGroup.mJf.setVisibility(0);
    }
  }
  
  public final w zq(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.mHf.size())
    {
      w localw = (w)this.mHf.get(paramInt);
      AppMethodBeat.o(5910);
      return localw;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void zr(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.fPp == 1) && (!this.oaU))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.oaG)) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209499);
          Object localObject1;
          Object localObject2;
          if ((paramInt == f.this.getCount() - 1) && (!f.this.oaG))
          {
            ad.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(f.this.getCount()) });
            localObject1 = f.this;
            localObject2 = ((f)localObject1).bOk();
            if (localObject2 == null) {
              break label243;
            }
            z localz = ag.aGg();
            long l = ((w)localObject2).field_createTime;
            localObject2 = z.o(localz.hHS.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((f)localObject1).mHf.addAll((Collection)localObject2);
            ((f)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label243;
            }
          }
          label243:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              f.this.oaG = true;
              localObject1 = f.b(f.this);
              if (((BizTimeLineNewMsgUI)localObject1).oaY != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).obc.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).obd.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).obd.findViewById(2131297358);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(2131756632));
                }
              }
            }
            AppMethodBeat.o(209499);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  static final class a
  {
    View auu;
    ImageView fRd;
    TextView jcd;
    View mJf;
    ViewGroup oaW;
    AppBrandNearbyShowcaseView oaX;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */