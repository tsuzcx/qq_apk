package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.m;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.b;
import com.tencent.mm.storage.aa.c;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

public final class e
  extends BaseAdapter
{
  private int fwM;
  private int jaR;
  List<z> rbc;
  boolean sAk;
  private BizTimeLineNewMsgUI sBf;
  private long sBg;
  boolean sBh;
  aa.c soO;
  
  public e(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<z> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.sBh = false;
    this.soO = new aa.c()
    {
      public final void a(Object paramAnonymousObject, aa.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.VeB != aa.b.VeD) || (paramAnonymousa.sBt == null)) {
            break label58;
          }
          e.a(e.this).add(0, paramAnonymousa.sBt);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.VeB == aa.b.VeE)
          {
            paramAnonymousa = e.this;
            paramAnonymousObject = paramAnonymousa.czT();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.rbc.clear();
              paramAnonymousa = paramAnonymousa.rbc;
              ae localae = af.bjD();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(ae.r(localae.lvy.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.sAk = false;
    this.sBf = paramBizTimeLineNewMsgUI;
    af.bjD().a(this.soO, Looper.getMainLooper());
    this.rbc = paramList;
    this.jaR = paramInt1;
    this.fwM = paramInt2;
    this.sBg = paramLong;
    AppMethodBeat.o(5908);
  }
  
  private static void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(265870);
    if (ab.Qm(paramString))
    {
      localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      localLayoutParams.height = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      paramImageView.setLayoutParams(localLayoutParams);
      a.b.d(paramImageView, paramString);
      AppMethodBeat.o(265870);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    localLayoutParams.height = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    paramImageView.setLayoutParams(localLayoutParams);
    a.b.c(paramImageView, paramString);
    AppMethodBeat.o(265870);
  }
  
  public final z GK(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.rbc.size())
    {
      z localz = (z)this.rbc.get(paramInt);
      AppMethodBeat.o(5910);
      return localz;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void GL(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.jaR == 1) && (!this.sBh))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.sAk)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(262209);
          Object localObject1;
          Object localObject2;
          if ((paramInt == e.this.getCount() - 1) && (!e.this.sAk))
          {
            Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(e.this.getCount()) });
            localObject1 = e.this;
            localObject2 = ((e)localObject1).czT();
            if (localObject2 == null) {
              break label245;
            }
            ae localae = af.bjD();
            long l = ((z)localObject2).field_createTime;
            localObject2 = ae.r(localae.lvy.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((e)localObject1).rbc.addAll((Collection)localObject2);
            ((e)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label245;
            }
          }
          label245:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              e.this.sAk = true;
              localObject1 = e.b(e.this);
              if (((BizTimeLineNewMsgUI)localObject1).sBm != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).sBq.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).sBr.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).sBr.findViewById(d.e.sqZ);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(d.i.suS));
                }
              }
            }
            AppMethodBeat.o(262209);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  public final z czT()
  {
    AppMethodBeat.i(5912);
    if (this.rbc.size() > 0)
    {
      z localz = (z)this.rbc.get(this.rbc.size() - 1);
      AppMethodBeat.o(5912);
      return localz;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.rbc.size();
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
    z localz = GK(paramInt);
    if (localz == null)
    {
      Log.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    paramViewGroup = localz.field_talker;
    int j = 0;
    a locala;
    View localView;
    label332:
    label349:
    Object localObject1;
    int i;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.sBf, d.f.stP, null);
      locala.amk = localView;
      locala.jiu = ((ImageView)localView.findViewById(d.e.avatar_iv));
      locala.mUy = ((TextView)localView.findViewById(d.e.nick_name_tv));
      paramView = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
      com.tencent.mm.plugin.brandservice.ui.b.d.l(locala.mUy);
      locala.timeTv = ((TextView)localView.findViewById(d.e.time_tv));
      locala.titleTv = ((TextView)localView.findViewById(d.e.title_tv));
      locala.sBj = ((TextView)localView.findViewById(d.e.sth));
      locala.rcN = localView.findViewById(d.e.bottom_line);
      locala.sBk = ((ViewGroup)localView.findViewById(d.e.sqm));
      locala.sBl = ((AppBrandNearbyShowcaseView)localView.findViewById(d.e.sqn));
      localView.setTag(locala);
      locala.sBk.setVisibility(8);
      if (!localz.hwD()) {
        break label545;
      }
      paramView = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localz.field_talker);
      if ((paramView != null) && (com.tencent.mm.contact.d.rk(paramView.field_type))) {
        break label640;
      }
      if (localz.hwJ() != null)
      {
        paramView = new c.a();
        paramView.lRP = d.d.default_avatar;
        paramView.lRC = true;
        paramView.kPz = true;
        q.bml().a(localz.hwJ().lqp, locala.jiu, paramView.bmL());
      }
      if (!localz.hwD()) {
        break label656;
      }
      paramView = localz.hwJ().nickName;
      locala.titleTv.setMaxLines(2147483647);
      locala.sBj.setVisibility(8);
      locala.mUy.setText(l.b(this.sBf, paramView, locala.mUy.getTextSize()));
      locala.timeTv.setText(b.f(this.sBf, localz.field_createTime));
      if (!localz.hwA()) {
        break label668;
      }
      localObject1 = m.OU(localz.field_content);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramView = this.sBf.getString(d.i.suF);
      }
      locala.titleTv.setText(paramView);
      paramView = paramViewGroup;
      i = j;
      label469:
      if (paramInt != getCount() - 1) {
        break label1806;
      }
      locala.rcN.setVisibility(4);
    }
    for (;;)
    {
      GL(paramInt);
      ag.a(paramView, 0, i, localz.field_msgId, paramInt, this.fwM, this.jaR - 1, (int)this.sBg);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label545:
      if (localz.hwE())
      {
        paramView = ag.O(localz);
        if (!TextUtils.isEmpty(paramView))
        {
          localObject1 = new c.a();
          ((c.a)localObject1).lRP = d.d.default_avatar;
          ((c.a)localObject1).lRC = true;
          ((c.a)localObject1).kPz = true;
          q.bml().a(paramView, locala.jiu, ((c.a)localObject1).bmL());
          break label332;
        }
        paramView = ag.N(localz);
        if (!Util.isNullOrNil(paramView))
        {
          a(locala.jiu, paramView);
          break label332;
        }
      }
      label640:
      a(locala.jiu, localz.field_talker);
      break label332;
      label656:
      paramView = aa.PJ(localz.field_talker);
      break label349;
      label668:
      if (!localz.hwH())
      {
        if (localz.field_type != 10000) {
          break label803;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = ag.k(localz, 0);
          if (!Util.isNullOrNil(paramView))
          {
            locala.titleTv.setText(paramView);
            ag.b(localz, 0, locala.titleTv);
            paramView = ag.k(localz, 1);
            if (!Util.isNullOrNil(paramView))
            {
              locala.sBj.setText(paramView);
              locala.sBj.setVisibility(0);
              ag.b(localz, 1, locala.sBj);
              paramView = ag.R(localz);
              if (!Util.isNullOrNil(paramView)) {
                locala.mUy.setText(paramView);
              }
            }
            paramView = paramViewGroup;
            i = j;
            break;
            label803:
            i = 0;
            continue;
          }
          locala.titleTv.setText(l.c(this.sBf, localz.field_content, (int)locala.titleTv.getTextSize()));
          paramView = paramViewGroup;
          i = j;
          break;
        }
      }
      if (localz.hwD())
      {
        locala.titleTv.setText(localz.hwJ().title);
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localz.hwG())
      {
        paramView = ag.k(localz, 0);
        if (!Util.isNullOrNil(paramView))
        {
          locala.titleTv.setText(paramView);
          ag.b(localz, 0, locala.titleTv);
          paramView = ag.k(localz, 1);
          if (!Util.isNullOrNil(paramView))
          {
            locala.sBj.setText(paramView);
            locala.sBj.setVisibility(0);
            ag.b(localz, 1, locala.sBj);
          }
          paramView = ag.R(localz);
          if (!Util.isNullOrNil(paramView)) {
            locala.mUy.setText(paramView);
          }
          paramView = paramViewGroup;
          i = j;
          break label469;
        }
        locala.titleTv.setText(this.sBf.getString(d.i.app_pic));
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localz.hwF())
      {
        locala.titleTv.setText(this.sBf.getString(d.i.app_voice));
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localz.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1109;
        }
        locala.titleTv.setText(this.sBf.getString(d.i.app_video));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1109:
      if ((localz.field_type == 42) || (localz.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1170;
        }
        locala.titleTv.setText(this.sBf.getString(d.i.app_product_card_ticket));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1170:
      Object localObject2;
      if (ag.P(localz))
      {
        locala.titleTv.setText(ag.j(localz, 0));
        ag.a(localz, 0, locala.titleTv);
        paramView = ag.j(localz, 1);
        if (!Util.isNullOrNil(paramView))
        {
          locala.sBj.setText(paramView);
          locala.sBj.setVisibility(0);
          ag.a(localz, 1, locala.sBj);
        }
        p.k(localz, "info");
        paramView = "";
        localObject1 = ag.Q(localz);
        if (localObject1 == null) {}
        for (;;)
        {
          if (!Util.isNullOrNil(paramView)) {
            locala.mUy.setText(paramView);
          }
          paramView = ag.N(localz);
          i = ag.f(localz);
          break;
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.title2");
            paramView = paramViewGroup;
            if (paramViewGroup == null) {
              paramView = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramView).append(' ');
            paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.action");
            paramView = paramViewGroup;
            if (paramViewGroup == null) {
              paramView = "";
            }
            paramView = paramView;
          }
        }
      }
      if ((localz.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1407:
        if (i == 0) {
          break label1779;
        }
        localObject2 = k.b.OQ(localz.field_content);
        if (localObject2 == null) {
          break label1779;
        }
        paramView = "";
        switch (((k.b)localObject2).type)
        {
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        if (Util.isNullOrNil(paramView)) {
          localObject1 = ((k.b)localObject2).getTitle();
        }
        locala.titleTv.setText(l.b(this.sBf, (CharSequence)localObject1, locala.titleTv.getTextSize()));
        paramView = paramViewGroup;
        i = j;
        break;
        i = 0;
        break label1407;
        paramView = ((k.b)localObject2).title;
        continue;
        paramView = this.sBf.getString(d.i.app_pic);
        continue;
        paramView = this.sBf.getString(d.i.app_music) + ((k.b)localObject2).title;
        continue;
        paramView = this.sBf.getString(d.i.app_video) + ((k.b)localObject2).title;
        continue;
        paramView = this.sBf.getString(d.i.app_url) + ((k.b)localObject2).getTitle();
        continue;
        paramView = this.sBf.getString(d.i.app_product_card_ticket) + ((k.b)localObject2).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject2).lnE + "]" + ((k.b)localObject2).lnA;
      }
      label1779:
      locala.titleTv.setText(this.sBf.getString(d.i.suL));
      paramView = paramViewGroup;
      i = j;
      break label469;
      label1806:
      locala.rcN.setVisibility(0);
    }
  }
  
  static final class a
  {
    View amk;
    ImageView jiu;
    TextView mUy;
    View rcN;
    TextView sBj;
    ViewGroup sBk;
    AppBrandNearbyShowcaseView sBl;
    TextView timeTv;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e
 * JD-Core Version:    0.7.0.1
 */